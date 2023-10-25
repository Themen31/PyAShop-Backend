package com.pyashop.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "oferta")
public class Oferta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOferta;

    @NotNull
    @Column(name="dsctOferta")
    private float dsctOfertaDeseado; //INGRESA A MANO INTEGER

    @Column(name="cantidadRestar")
    private float cantidadARestar; //PORCENTAJE FLOAT

    @Column(name="precioActual")
    private float precioActualProducto; // CALCULADO CON CALCULO FLOAT

    @OneToOne
    @JoinColumn(name = "idProduct", nullable = false)
    private Producto producto; //INGRESA A MANO

    public Integer getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(Integer idOferta) {
        this.idOferta = idOferta;
    }

    public float getDsctOfertaDeseado() {
        return dsctOfertaDeseado;
    }

    public void setDsctOfertaDeseado(float dsctOfertaDeseado) {
        this.dsctOfertaDeseado = dsctOfertaDeseado;
    }

    public float getCantidadARestar() {
        return cantidadARestar;
    }

    public void setCantidadARestar(float cantidadARestar) {
        this.cantidadARestar = cantidadARestar;
    }

    public float getPrecioActualProducto() {
        return precioActualProducto;
    }

    public void setPrecioActualProducto(float precioActualProducto) {
        this.precioActualProducto = precioActualProducto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
