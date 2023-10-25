package com.pyashop.domain.services.impl;

import com.pyashop.domain.Oferta;
import com.pyashop.domain.Producto;
import com.pyashop.infrastracture.OfertaRepository;
import com.pyashop.domain.services.OfertaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfertaServiceImpl implements OfertaService {
    private OfertaRepository ofertaRepository;

    public OfertaServiceImpl(OfertaRepository ofertaRepository) {
        this.ofertaRepository = ofertaRepository;
    }


    @Override
    public Oferta crearOferta(Oferta oferta) {
        //    float a = CalculoPorcentajeDeDescuento(oferta);
        //    float b = CALCULO(a, oferta);
        //    Producto ptm = oferta.getProducto();
        //    float costoPtm = ptm.getCosto_producto();
        //    float precioActualProducto = costoPtm - b;

        //    oferta.setCantidadARestar(b);
        //    oferta.setPrecioActualProducto(precioActualProducto);
        return ofertaRepository.save(oferta);
    }

    @Override
    public Oferta verOfertaPorIdOferta(Integer idOferta) {
        return ofertaRepository.findById(idOferta).orElse(new Oferta());
    }

    @Override
    public Oferta aplicarOferta(Integer idOferta) {
        Oferta x = verOfertaPorIdOferta(idOferta);
        float a = CalculoPorcentajeDeDescuento(x);
        float b = CALCULO(a, x);
        Producto ptm = x.getProducto();
        float costoPtm = ptm.getCosto_producto();
        float precioActualProducto = costoPtm - b;

        x.setCantidadARestar(b);
        x.setPrecioActualProducto(precioActualProducto);
        return ofertaRepository.save(x);
    }

    @Override
    public Oferta modificarOferta(Oferta oferta) {
        return ofertaRepository.save(oferta);
    }

    @Override
    public List<Oferta> listarOferta() {
        return ofertaRepository.findAll();
    }

    private float CalculoPorcentajeDeDescuento(Oferta oferta){
        float x = (float) (oferta.getDsctOfertaDeseado()/100);
        return x;
    }

    private float CALCULO(float a, Oferta o){
        float Dsctoferta = a;
        Producto producto = o.getProducto();
        float costo = producto.getCosto_producto();
        float CALCULO = costo * Dsctoferta;
        return CALCULO;
    }
}
