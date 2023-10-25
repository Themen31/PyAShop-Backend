package com.pyashop.domain.services;

import com.pyashop.domain.Categoria;

import java.util.List;

public interface CategoriaService {

    Categoria crearCategoria(Categoria categoria);
    List<Categoria> listarCategorias();
    List<Integer> listarIdCategoria();
}
