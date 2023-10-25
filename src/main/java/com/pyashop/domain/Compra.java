package com.pyashop.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "compras")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCompra;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false, foreignKey = @ForeignKey(name = "FK_id_usuario"))
    private Usuario usuario;

    @NotNull
    @Column(name = "monto_pago",nullable = false)
    private float montoPago;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_pedido",nullable = false)
    private Date fechaCompra;

    @PrePersist
    public void onCreate() {
        fechaCompra = new Date();
    }

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "fecha_entrega",nullable = true)
    private Date fechaEntrega;

    @NotNull
    @Size(min = 3, max = 50, message = "El método de pago debe ser mínimo 3 caracteres y máximo 50.")
    @Column(name = "metodo_pago", nullable = false)
    private String metodoPago;

    @ManyToOne
    @JoinColumn(name = "id_estado", nullable = false, foreignKey = @ForeignKey(name = "FK_id_estado"))
    private EstadoCompra estadoCompra;

    @NotNull
    @Column(name = "costo_envio",nullable = false)
    private float costoEnvio;

    @NotNull
    @Column(name = "subtotal",nullable = false)
    private float subtotal;

    @OneToOne
    @JoinColumn(name = "idDonacion")
    private Donacion donacion; //input

    //@OneToOne
    //    @JoinColumn(name = "idProduct", nullable = false)
    //    private Producto producto; //INGRESA A MANO


    public Donacion getDonacion() {
        return donacion;
    }

    public void setDonacion(Donacion donacion) {
        this.donacion = donacion;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public float getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(float montoPago) {
        this.montoPago = montoPago;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public EstadoCompra getEstadoCompra() {return estadoCompra;}

    public void setEstadoCompra(EstadoCompra estadoCompra) {this.estadoCompra = estadoCompra;}

    public float getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(float costoEnvio) {
        this.costoEnvio = costoEnvio;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }
}
