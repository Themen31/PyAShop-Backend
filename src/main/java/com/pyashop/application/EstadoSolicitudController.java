package com.pyashop.application;

import com.pyashop.WrapperResponse;
import com.pyashop.domain.EstadoSolicitud;
import com.pyashop.domain.services.EstadoSolicitudService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/estadosolicitud")
public class EstadoSolicitudController {
    private final EstadoSolicitudService estadoSolicitudService;

    public EstadoSolicitudController(EstadoSolicitudService estadoSolicitudService){
        this.estadoSolicitudService=estadoSolicitudService;
    }

    @PostMapping
    public ResponseEntity<WrapperResponse<EstadoSolicitud>> crearEstadoS(@Valid @RequestBody EstadoSolicitud estadoSolicitud){
        EstadoSolicitud estadoSolicitudNew= estadoSolicitudService.crearEstadoS(estadoSolicitud);
        return new WrapperResponse<>(true, "success",estadoSolicitudNew).createResponse();
    }

    @PutMapping
    public ResponseEntity<WrapperResponse<EstadoSolicitud>> modificarEstadoS(@Valid @RequestBody EstadoSolicitud estadoSolicitud){
        EstadoSolicitud estadoSolicitudUpdate= estadoSolicitudService.modificarEstadoS(estadoSolicitud);
        return new WrapperResponse<>(true, "success",estadoSolicitudUpdate).createResponse();
    }

    @DeleteMapping("/{idEstadoS}")
    public ResponseEntity<WrapperResponse<Void>> eliminarEstadoS(@PathVariable("idEstadoS") Integer idEstadoS){
        estadoSolicitudService.eliminarEstadoS(idEstadoS);
        return new WrapperResponse<Void>(true, "success", null).createResponse(HttpStatus.NO_CONTENT);
    }

    @GetMapping()
    public ResponseEntity<WrapperResponse<List<EstadoSolicitud>>> listarEstadoS(){
        List<EstadoSolicitud> estadosolicitud = estadoSolicitudService.listarEstadoS();
        return new WrapperResponse<>(true, "success", estadosolicitud).createResponse();
    }

    @GetMapping("/{idEstado}")
    public ResponseEntity<WrapperResponse<EstadoSolicitud>> obtenerEstadoPorIdEstadoS(@PathVariable("idEstadoS") Integer idEstadoS) {
        EstadoSolicitud estadoSolicitud = estadoSolicitudService.obtenerEstadoPorIdEstadoS(idEstadoS);
        return new WrapperResponse<>(true,"success", estadoSolicitud).createResponse();
    }


}
