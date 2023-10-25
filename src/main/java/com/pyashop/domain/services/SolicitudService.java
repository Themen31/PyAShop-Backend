package com.pyashop.domain.services;

import com.pyashop.domain.Solicitud;

import java.util.List;

public interface SolicitudService {
    Solicitud crearSolicitud(Solicitud solicitud);
    List<Solicitud> listarSolicitud();
    Solicitud modificarSolicitud(Solicitud solicitud);
    void eliminarSolicitud(Integer idsolicitud);
}
