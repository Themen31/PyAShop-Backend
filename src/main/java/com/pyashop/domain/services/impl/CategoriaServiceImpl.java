package com.pyashop.domain.services.impl;

import com.pyashop.domain.Categoria;
import com.pyashop.domain.services.CategoriaService;
import com.pyashop.infrastracture.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria crearCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public List<Integer> listarIdCategoria() {
        List<Categoria> categorias = listarCategorias();
        List <Integer> IDESCATEGORIA = new ArrayList<>();
        for (int i = 0; i < categorias.size(); i++){
            Categoria algo = categorias.get(i);
            Integer idCategoria = algo.getIdCategory();
            IDESCATEGORIA.add(idCategoria);
        }
        return IDESCATEGORIA;
    }

}
