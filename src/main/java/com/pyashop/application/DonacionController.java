package com.pyashop.application;

import com.pyashop.WrapperResponse;
import com.pyashop.domain.Donacion;
import com.pyashop.domain.Usuario;
import com.pyashop.infrastracture.UsuarioRepository;
import com.pyashop.domain.services.DonacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/donaciones")
public class DonacionController {
    private final DonacionService donacionService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public DonacionController(DonacionService donacionService) {
        this.donacionService = donacionService;
    }

    @PostMapping
    public ResponseEntity<WrapperResponse<Donacion>> registrarDonacion(@Valid @RequestBody Donacion donacion){
        Donacion historiaNew=  donacionService.registrarDonacion(donacion);
        return new WrapperResponse<>(true, "success", historiaNew).createResponse();
    }

    @PutMapping
    public ResponseEntity<WrapperResponse<Donacion>> modificarDonacion(@Valid @RequestBody Donacion donacion){
        Donacion donacionUpdate=donacionService.modificarDonacion(donacion);
        return new WrapperResponse<>(true, "success",donacion).createResponse();
    }

    @DeleteMapping("/{idDonacion}")
    public ResponseEntity<WrapperResponse<Void>> eliminarDonacion(@PathVariable("idDonacion") Integer idDonacion){
        donacionService.eliminarDonacion(idDonacion);
        return new WrapperResponse<Void>(true, "success", null).createResponse(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<WrapperResponse<List<Donacion>>> listarDonacion() {
        List<Donacion> donaciones = donacionService.listarDonacion();
        List<Donacion> collect = donaciones.stream()
                .filter (donacion -> donacion.getMontoDonar () >0)
                .collect(Collectors.toList());
        return new WrapperResponse<>(true, "success", collect).createResponse();
    }

    @GetMapping("/{idDonacion}")
    public ResponseEntity<WrapperResponse<Donacion>> obtenerDonacionPorIdDonacion(@PathVariable("idDonacion") Integer idDonacion) {
        Donacion donacion = donacionService.obtenerDonacionPorIdDonacion(idDonacion);
        return new WrapperResponse<>(true, "success", donacion).createResponse();
    }
    @GetMapping("/listarDonacionesPorIdUsuario")
    public ResponseEntity<WrapperResponse<List<Donacion>>> listarDonacionesPorIdUsuario(@RequestParam Usuario usuario){
        List<Donacion> usuarioid=donacionService.listarDonacionesPorIdUsuario(usuario);
        List<Donacion> collect1 = usuarioid.stream()
                .filter (donacion -> donacion.getMontoDonar () >0)
                .collect(Collectors.toList());
        return new WrapperResponse<>(true, "success", collect1).createResponse();
    }
}
