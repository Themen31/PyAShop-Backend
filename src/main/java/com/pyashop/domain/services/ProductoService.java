package com.pyashop.domain.services;

import com.pyashop.domain.Producto;

import java.util.List;

public interface ProductoService {
    Producto crearProducto(Producto producto);
    Producto seleccionarProducto(Integer IdProducto);
    List<Producto> listarProducto();
    Producto modificarProducto(Producto producto);
    void eliminarProducto(Integer idproducto);
    Long countProductos();
    interface RolService {
    }
}
