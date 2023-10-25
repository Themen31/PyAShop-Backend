package com.pyashop.application;

import com.pyashop.domain.Producto;
import com.pyashop.domain.services.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.pyashop.WrapperResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public ResponseEntity<WrapperResponse<Producto>>crearProducto(@Valid @RequestBody Producto producto){
        Producto productoNew = productoService.crearProducto(producto);
        return new WrapperResponse<>(true, "message", productoNew).createResponse();
    }

    @GetMapping("/{ProductId}")
    public ResponseEntity<WrapperResponse<Producto>>SeleccionarProducto(@PathVariable("ProductId") Integer idProducto){
        Producto producto=productoService.seleccionarProducto(idProducto);
        return new WrapperResponse<>(true, "success", producto).createResponse();
    }

    @GetMapping
    public ResponseEntity<WrapperResponse<List<Producto>>>listarProducto(){
        List<Producto> productos=productoService.listarProducto();
        return new WrapperResponse<>(true, "success", productos).createResponse();
    }

    @PutMapping
    public ResponseEntity<WrapperResponse<Producto>>modificarProducto(@RequestBody Producto producto){
        Producto productoUpdate= productoService.modificarProducto(producto);
        return new WrapperResponse<Producto>(true, "success", producto).createResponse(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable ("id")Integer idproducto) {
        productoService.eliminarProducto(idproducto);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/contar")
    public ResponseEntity<WrapperResponse<Long>> contarProductos(){
        Long producto = productoService.countProductos();
        return new WrapperResponse<>(true, "success", producto).createResponse();
    }

}
