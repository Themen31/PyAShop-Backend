package com.pyashop.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "estadosolicitud")
public class EstadoSolicitud{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstadoS;

    @NotNull
    @Size(min=3,max=20, message="El estado debe ser mínimo 3 caracteres y máximo 20.")
    @Column(name = "nombreEstadoS", nullable = false)
    private String nombreEstadoS;

    @OneToMany(mappedBy ="estadoSolicitud")
    private List<Solicitud> solicitud;

    public Integer getIdEstadoS() {
        return idEstadoS;
    }

    public void setIdEstadoS(Integer idEstadoS) {
        this.idEstadoS = idEstadoS;
    }

    public String getNombreEstadoS() {
        return nombreEstadoS;
    }

    public void setNombreEstadoS(String nombreEstadoS) {
        this.nombreEstadoS = nombreEstadoS;
    }

}

