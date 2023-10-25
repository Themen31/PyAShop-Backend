package com.pyashop.application;

import com.pyashop.WrapperResponse;
import com.pyashop.domain.EstadoCompra;
import com.pyashop.domain.services.EstadoCompraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoCompraController {
    private final EstadoCompraService estadoCompraService;

    public EstadoCompraController(EstadoCompraService estadoCompraService){
        this.estadoCompraService=estadoCompraService;
    }

    @PostMapping
    public ResponseEntity<WrapperResponse<EstadoCompra>> crearEstado(@Valid @RequestBody EstadoCompra estadoCompra){
        EstadoCompra estadoCompraNew= estadoCompraService.crearEstado(estadoCompra);
        return new WrapperResponse<>(true, "success",estadoCompraNew).createResponse();
    }

    @PutMapping
    public ResponseEntity<WrapperResponse<EstadoCompra>> modificarEstado(@Valid @RequestBody EstadoCompra estadoCompra){
        EstadoCompra estadoCompraUpdate= estadoCompraService.modificarEstado(estadoCompra);
        return new WrapperResponse<>(true, "success",estadoCompraUpdate).createResponse();
    }

    @DeleteMapping("/{idEstado}")
    public ResponseEntity<WrapperResponse<Void>> eliminarEstado(@PathVariable("idEstado") Integer idEstado){
        estadoCompraService.eliminarEstado(idEstado);
        return new WrapperResponse<Void>(true, "success", null).createResponse(HttpStatus.NO_CONTENT);
    }

    @GetMapping()
    public ResponseEntity<WrapperResponse<List<EstadoCompra>>> listarEstado(){
        List<EstadoCompra> estados = estadoCompraService.listarEstado();
        return new WrapperResponse<>(true, "success", estados).createResponse();
    }

    @GetMapping("/{idEstado}")
    public ResponseEntity<WrapperResponse<EstadoCompra>> obtenerEstadoPorIdEstado(@PathVariable("idEstado") Integer idEstado) {
        EstadoCompra estadoCompra = estadoCompraService.obtenerEstadoPorIdEstado(idEstado);
        return new WrapperResponse<>(true,"success", estadoCompra).createResponse();
    }


}

