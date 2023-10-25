package com.pyashop.domain.services.impl;
import com.pyashop.domain.*;
import com.pyashop.infrastracture.*;
import com.pyashop.domain.services.CompraService;
import com.pyashop.infrastracture.validators.CompraValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CompraServiceImpl implements CompraService{
    private final CompraRepository compraRepository;

    private DonacionRepository donacionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private EstadoCompraRepository estadoCompraRepository;

    public CompraServiceImpl(CompraRepository compraRepository, DonacionRepository donacionRepository){
        this.compraRepository=compraRepository;
        this.donacionRepository = donacionRepository;
    }

    @Override
    public Compra pagarCompra(Compra compra) {
        compra.setMontoPago(compra.getCostoEnvio());//Le asigna el costo de envío a la compra
        Integer idsazo=compra.getUsuario().getIdUsuario(); //Obtiene idUsuario de la compra
        Usuario usuarioFinal=usuarioRepository.getById(idsazo);//Instancia al usuario
        compra.setMontoPago(obtenerMontoTotal(usuarioFinal, compra)); //Le asigna el monto total de pago a la compra
        //Obtiene el subTotal
        compra.setSubtotal(obtenerSubtotal(compra)); //Obtiene el monto de pago sin envío
        CompraValidator.validate(compra);
        Set<Producto> nuevaLista = null; //Vacia la lista (CARRITO)
        usuarioFinal.setLista_compra(nuevaLista); //Le asigna la lista vacía al usuario
        usuarioRepository.save(usuarioFinal); //guarda la nueva información del usuario
        // guarda la compra
        return compraRepository.save(compra);
    }

    @Override
    public float obtenerMontoTotal(Usuario usuario, Compra compra) {
        Integer IddonacionDeCompra = compra.getDonacion().getIdDonacion();
        Donacion donacionDeCompra = donacionRepository.getById(IddonacionDeCompra);
        float limosna = donacionDeCompra.getMontoDonar();
        Set<Producto> productos = usuario.getLista_compra(); //Instancia la lista de Productos
        float total=compra.getMontoPago(); //Obtiene el costo de envío (Monto de pago actual)
        for (Producto producto : productos){
            //Suma de precios
            total+=producto.getCosto_producto(); //va agregando los precios de los productos de la lista al monto total de pago
            productoRepository.save(producto);
        }

        donacionRepository.save(donacionDeCompra);

        if (limosna > 0.0){
            return total + limosna;
        }
        else{ return total; }

    }

    @Override
    public float obtenerSubtotal(Compra compra) { //Obtiene el monto de pago sin envío
        float subtotal=0f;
        //
        float montoLimosna = compra.getDonacion().getMontoDonar();
        float montoCompleto=compra.getMontoPago();
        float montoEnvio= compra.getCostoEnvio();
        subtotal=montoCompleto-montoEnvio-montoLimosna;
        return subtotal;
    }

    @Override
    public Compra modificarCompra(Compra compra) {
        CompraValidator.validate(compra);
        return compraRepository.save(compra);
    }

    @Override
    public void eliminarCompra(Integer idCompra) {
        compraRepository.deleteById(idCompra);
    }

    @Override
    public Compra obtenerCompraPorIdCompra(Integer idCompra) {
        return compraRepository.findById(idCompra).orElse(new Compra());
    }

    @Override
    public List<Compra> listarCompra() {
        return compraRepository.findAll();
    }

    @Override
    public Compra modificarEstadoCompra(Integer idCompra) {
        return null;
    }

    @Override
    public void cancelarCompra(Integer idCompra) {
        Compra compra=compraRepository.findById(idCompra).orElse(new Compra());
        EstadoCompra enviado=estadoCompraRepository.compraEnviado();
        compra.setEstadoCompra(enviado);
    }
    @Override
    public List<Compra> listarComprasPorIdUsuario(Usuario usuario) {
        List<Compra> usuarioId = compraRepository.listarComprasPorIdUsuario(usuario);
        return usuarioId;
    }

}
