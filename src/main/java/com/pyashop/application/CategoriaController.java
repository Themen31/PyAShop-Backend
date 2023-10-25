
package com.pyashop.application;

import com.pyashop.WrapperResponse;
import com.pyashop.domain.Categoria;
import com.pyashop.domain.services.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<WrapperResponse<Categoria>>crearCategoria(@Valid @RequestBody Categoria categoria){
        Categoria categoria1 = categoriaService.crearCategoria(categoria);
        return new WrapperResponse<>(true, "message", categoria1).createResponse();
    }

    @GetMapping
    public ResponseEntity<List<Categoria>>listarCategorias(){
        List<Categoria> categoriaList=categoriaService.listarCategorias();
        return new ResponseEntity<List<Categoria>> (categoriaList, HttpStatus.CREATED);
    }

    @GetMapping("/ides")
    public ResponseEntity<WrapperResponse<List<Integer>>>listarIdCategoria(){
        List<Integer> idesCategoria = categoriaService.listarIdCategoria();
        return new WrapperResponse<>(true, "success", idesCategoria).createResponse();
    }

}
