package com.pyashop.domain.services;

import com.pyashop.domain.Producto;
import com.pyashop.domain.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario crearUsuario(Usuario usuario);
    Usuario modificarUsuario(Usuario usuario);
    void eliminarUsuario(Integer idUsuario);
    List<Usuario> listarUsuario();
    Usuario obtenerUsuarioPorIdUsuario(Integer idUsuario);

    void agregarProductoListaCompra(Usuario usuario,Producto producto);
    void agregarProductoAlCarrito(Usuario usuario, Producto producto);
    void eliminarProductoAlCarrito(Usuario usuario, Producto producto);
    void eliminarProductoListaCompra(Usuario usuario, Producto producto);
    Usuario fetchUserByCorreoyContra(String correoUsuario, String contrasenaUsuario);

}
