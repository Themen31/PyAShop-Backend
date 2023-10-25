package com.pyashop.application;

import com.pyashop.WrapperResponse;
import com.pyashop.domain.Solicitud;
import com.pyashop.domain.services.SolicitudService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudController {
    private final SolicitudService solicitudService;

    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    @PostMapping
    public ResponseEntity<WrapperResponse<Solicitud>> crearSolicitud(@Valid @RequestBody Solicitud solicitud){
        Solicitud solicitudNew = solicitudService.crearSolicitud(solicitud);
        return new WrapperResponse<>(true, "message", solicitudNew).createResponse();
    }

    @GetMapping
    public ResponseEntity<WrapperResponse<List<Solicitud>>>listarSolicitud(){
        List<Solicitud> solicitudes=solicitudService.listarSolicitud();
        return new WrapperResponse<>(true, "success", solicitudes).createResponse();
    }

    @PutMapping
    public ResponseEntity<WrapperResponse<Solicitud>>modificarSolicitud(@RequestBody Solicitud solicitud){
        Solicitud solicitudUpdate= solicitudService.modificarSolicitud(solicitud);
        return new WrapperResponse<Solicitud>(true, "success", solicitud).createResponse(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSolicitud(@PathVariable ("id")Integer idsolicitud) {
        solicitudService.eliminarSolicitud(idsolicitud);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
