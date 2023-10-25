package com.pyashop.domain.services;
import com.pyashop.domain.Donacion;
import com.pyashop.domain.Usuario;

import java.util.List;

public interface DonacionService {
    Donacion registrarDonacion(Donacion donacion);
    Donacion modificarDonacion(Donacion donacion);
    void eliminarDonacion(Integer idDonacion);
    Donacion obtenerDonacionPorIdDonacion(Integer idDonacion);
    List<Donacion> listarDonacion();
    List<Donacion> listarDonacionesPorIdUsuario(Usuario usuario);

}
