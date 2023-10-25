package com.pyashop.application;

import com.pyashop.WrapperResponse;
import com.pyashop.domain.Oferta;
import com.pyashop.domain.services.OfertaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ofertas")
public class OfertaController {
    private final OfertaService ofertaService;

    public OfertaController(OfertaService ofertaService) {
        this.ofertaService = ofertaService;
    }

    @PostMapping
    public ResponseEntity<WrapperResponse<Oferta>>crearOferta(@Valid @RequestBody Oferta oferta){
        Oferta oferta1 = ofertaService.crearOferta(oferta);
        return new WrapperResponse<>(true, "message", oferta1).createResponse();
    }
    @GetMapping("/{OfertaId}")
    public  ResponseEntity<WrapperResponse<Oferta>>verOferta(@PathVariable("OfertaId") Integer idOferta){
        Oferta oferta = ofertaService.verOfertaPorIdOferta(idOferta);
        return new WrapperResponse<>(true, "success", oferta).createResponse();
    }

    @GetMapping
    public ResponseEntity<WrapperResponse<List<Oferta>>>listarOferta(){
        List<Oferta> ofertas = ofertaService.listarOferta();
        return new WrapperResponse<>(true, "success", ofertas).createResponse();
    }

    @PutMapping("/{OfertaId}")
    public ResponseEntity<WrapperResponse<Oferta>> aplicarOferta(@PathVariable("OfertaId") Integer idOferta){
        Oferta oferta = ofertaService.aplicarOferta(idOferta);
        return new WrapperResponse<Oferta>(true, "succes", oferta).createResponse(HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<WrapperResponse<Oferta>>modificarOferta(@RequestBody Oferta oferta){
        Oferta oferta1 = ofertaService.modificarOferta(oferta);
        return new WrapperResponse<Oferta>(true, "success", oferta1).createResponse(HttpStatus.OK);
    }

}
