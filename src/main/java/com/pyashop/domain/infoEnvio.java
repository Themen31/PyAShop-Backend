package com.pyashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "infoEnvios")
@Getter
@Setter
public class infoEnvio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdInfoEnvio;

    private String nombreContactoEnvio;

    private String numTelefonoEnvio;

    private String direccionEnvio;

    private String apartamentoEnvio;

    private String codigoPostal;

    public Integer getIdInfoEnvio() {
        return IdInfoEnvio;
    }

    public void setIdInfoEnvio(Integer idInfoEnvio) {
        IdInfoEnvio = idInfoEnvio;
    }

    public String getNombreContactoEnvio() {
        return nombreContactoEnvio;
    }

    public void setNombreContactoEnvio(String nombreContactoEnvio) {
        this.nombreContactoEnvio = nombreContactoEnvio;
    }

    public String getNumTelefonoEnvio() {
        return numTelefonoEnvio;
    }

    public void setNumTelefonoEnvio(String numTelefonoEnvio) {
        this.numTelefonoEnvio = numTelefonoEnvio;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public String getApartamentoEnvio() {
        return apartamentoEnvio;
    }

    public void setApartamentoEnvio(String apartamentoEnvio) {
        this.apartamentoEnvio = apartamentoEnvio;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}

