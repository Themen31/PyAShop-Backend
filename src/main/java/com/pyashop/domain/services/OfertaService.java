package com.pyashop.domain.services;

import com.pyashop.domain.Oferta;

import java.util.List;

public interface OfertaService {

    Oferta crearOferta(Oferta oferta);
    Oferta verOfertaPorIdOferta(Integer idOferta);

    Oferta aplicarOferta(Integer idOferta);
    Oferta modificarOferta(Oferta oferta);

    List<Oferta> listarOferta();

}
