package com.pyashop.domain.services.impl;

import com.pyashop.domain.Producto;
import com.pyashop.domain.Usuario;
import com.pyashop.infrastracture.UsuarioRepository;
import com.pyashop.domain.services.UsuarioService;
import com.pyashop.infrastracture.validators.UsuarioValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        UsuarioValidator.validate(usuario);
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario modificarUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public void eliminarUsuario(Integer idUsuario) {

    }

    @Override
    public List<Usuario> listarUsuario() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtenerUsuarioPorIdUsuario(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario).orElse(new Usuario());
    }

    @Override
    public Usuario fetchUserByCorreoyContra(String correoUsuario, String contrasenaUsuario){
        return usuarioRepository.findUsuarioByCorreoUsuarioAndContrasenaUsuario(correoUsuario, contrasenaUsuario);
    }

    @Override
    public void agregarProductoListaCompra(Usuario usuario, Producto producto) {
        usuario.getLista_compra().add(producto);
    }
    @Override
    public void agregarProductoAlCarrito(Usuario usuario, Producto producto) {

        if(producto.getStockP()>0){
            usuario.getCarritoCompras().add(producto);
        }

    }
    @Override
    public void eliminarProductoAlCarrito(Usuario usuario, Producto producto) {

        usuario.getCarritoCompras().remove(producto);

    }
    @Override
    public void eliminarProductoListaCompra(Usuario usuario, Producto producto) {

        usuario.getLista_compra().remove(producto);

    }

}
