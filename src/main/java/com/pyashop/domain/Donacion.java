package com.pyashop.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "donaciones")
public class Donacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDonacion;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false, foreignKey = @ForeignKey(name = "FK_id_usuario"))
    private Usuario usuario;

    @NotNull
    @Column(name = "monto_donar",nullable = false)
    private float montoDonar;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_pedido",nullable = false)
    private Date fechaDonacion;

    @PrePersist
    public void onCreate() {
        fechaDonacion = new Date();
    }

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "fecha_plantacion")
    private Date fechaPlantacion;

    @NotNull
    @Size(min = 3, max = 50, message = "El método de pago debe ser mínimo 3 caracteres y máximo 50.")
    @Column(name = "metodo_pago", nullable = false)
    private String metodoPago;

    @JsonIgnore
    @OneToOne(mappedBy = "donacion", cascade = CascadeType.ALL)
    private Compra compra;
    public Integer getIdDonacion() {
        return idDonacion;
    }

    public void setIdDonacion(Integer idDonacion) {
        this.idDonacion = idDonacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario donante) {
        this.usuario = donante;
    }

    public float getMontoDonar() {
        return montoDonar;
    }

    public void setMontoDonar(float montoDonar) {
        this.montoDonar = montoDonar;
    }

    public Date getFechaDonacion() {
        return fechaDonacion;
    }

    public void setFechaDonacion(Date fechaDonacion) {
        this.fechaDonacion = fechaDonacion;
    }

    public Date getFechaPlantacion() {
        return fechaPlantacion;
    }

    public void setFechaPlantacion(Date fechaPlantacion) {
        this.fechaPlantacion = fechaPlantacion;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
}
