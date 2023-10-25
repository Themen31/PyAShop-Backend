package com.pyashop.infrastracture.validators;

import com.pyashop.infrastracture.exception.IncorrectResourceRequestException;
import com.pyashop.domain.Usuario;

public class UsuarioValidator {

    public static void validate(Usuario usuario) {

        if (usuario.getNombreUsuario() == null || usuario.getNombreUsuario().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("Escriba su nombre correctamente.");
        }

        if(usuario.getNombreUsuario().length() < 5) {
            throw new IncorrectResourceRequestException("Escriba su nombre correctamente.");

        }

        if(usuario.getNombreUsuario().length() > 50) {
            throw new IncorrectResourceRequestException("Escriba su nombre correctamente.");

        }

        if (usuario.getCorreoUsuario() == null || usuario.getCorreoUsuario().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("Escriba el correo correctamente.");
        }

        if (usuario.getContrasenaUsuario() == null || usuario.getContrasenaUsuario().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("Escriba la contraseña correctamente.");
        }

        if(usuario.getContrasenaUsuario().length() < 5) {
            throw new IncorrectResourceRequestException("Escriba la contraseña correctamente.");

        }

        if(usuario.getContrasenaUsuario().length() > 20) {
            throw new IncorrectResourceRequestException("Escriba la contraseña correctamente.");

        }

        if(usuario.getDireccionUsuario().length() > 100) {
            throw new IncorrectResourceRequestException("Especifique bien su direccion");

        }

    }

}
