package com.pyashop.application;
import com.pyashop.domain.Compra;
import com.pyashop.domain.Usuario;
import com.pyashop.infrastracture.UsuarioRepository;
import com.pyashop.domain.services.CompraService;
import com.pyashop.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {
    private final CompraService compraService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping
    public ResponseEntity<WrapperResponse<Compra>> pagarCompra(@Valid @RequestBody Compra compra) throws Exception{
        Compra compraNull=null;
        Integer idUsuario=compra.getUsuario().getIdUsuario();
        Usuario usuario=usuarioRepository.getById(idUsuario);
        if(usuario.getLista_compra().isEmpty()){
            return new WrapperResponse<>(false, "El carro de compras está vacío", compraNull).createResponse();
        }
        else {
            Compra compraNew = compraService.pagarCompra(compra);
            return new WrapperResponse<>(true, "success", compraNew).createResponse();
        }
    }

    @PutMapping
    public ResponseEntity<WrapperResponse<Compra>> modificarCompra(@Valid @RequestBody Compra compra){
        Compra compraUpdate=compraService.modificarCompra(compra);
        return new WrapperResponse<>(true, "success",compra).createResponse();
    }

    @DeleteMapping("/{idCompra}")
    public ResponseEntity<WrapperResponse<Void>> eliminarCompra(@PathVariable("idCompra") Integer idCompra){
        compraService.eliminarCompra(idCompra);
        return new WrapperResponse<Void>(true, "success", null).createResponse(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<WrapperResponse<List<Compra>>> listarCompra() {
        List<Compra> compras = compraService.listarCompra();
        return new WrapperResponse<>(true, "success", compras).createResponse();
    }

    @GetMapping("/{idCompra}")
    public ResponseEntity<WrapperResponse<Compra>> obtenerCompraPorIdCompra(@PathVariable("idCompra") Integer idCompra) {
        Compra compra = compraService.obtenerCompraPorIdCompra(idCompra);
        return new WrapperResponse<>(true, "success", compra).createResponse();
    }
    @GetMapping("/listarPorIdUsuario")
    public ResponseEntity<WrapperResponse<List<Compra>>> listarComprasPorIdUsuario(@RequestParam Usuario usuario){
        List<Compra> usuarioid=compraService.listarComprasPorIdUsuario(usuario);
        return new WrapperResponse<>(true, "success", usuarioid).createResponse();
    }
}
