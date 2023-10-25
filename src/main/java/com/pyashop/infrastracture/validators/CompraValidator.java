package com.pyashop.infrastracture.validators;
import com.pyashop.infrastracture.exception.IncorrectResourceRequestException;
import com.pyashop.domain.Compra;

public class CompraValidator {

    public static void validate(Compra compra) {

        if (compra.getEstadoCompra() == null) {
            throw new IncorrectResourceRequestException("El estado no puede estar vacío.");
        }
        if (compra.getMetodoPago() == null || compra.getMetodoPago().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El método de pago no puede estar vacío.");
        }

        if (compra.getMetodoPago().length() < 3) {
            throw new IncorrectResourceRequestException("El método de pago debe ser mayor a 3 caracteres.");
        }

        if (compra.getMetodoPago().length() > 50) {
            throw new IncorrectResourceRequestException("El método de pago debe ser menor a 50 caracteres.");
        }
    }
}


