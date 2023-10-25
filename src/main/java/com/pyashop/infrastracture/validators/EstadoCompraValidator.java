package com.pyashop.infrastracture.validators;
import com.pyashop.infrastracture.exception.IncorrectResourceRequestException;
import com.pyashop.domain.EstadoCompra;
public class EstadoCompraValidator {
    public static void validate(EstadoCompra estadoCompra){
        if (estadoCompra.getNombreEstado() == null || estadoCompra.getNombreEstado().trim().isEmpty()){
            throw new IncorrectResourceRequestException("El estado no puede estar vacío.");
        }

        if (estadoCompra.getNombreEstado().length() < 3){
            throw new IncorrectResourceRequestException("El estado debe ser mayor a 3 caracteres.");
        }

        if (estadoCompra.getNombreEstado().length() > 50){
            throw new IncorrectResourceRequestException("El estado debe ser menor a 50 caracteres.");
        }
    }
}

