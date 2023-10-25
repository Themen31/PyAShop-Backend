package com.pyashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;

    @Column(name="producto_name", nullable = false)
    private String nombre_producto;

    @NotNull
    @Column(name="product_cost")
    private float costo_producto;

    @javax.validation.constraints.NotNull
    @Column(name="stock_producto")
    private int stockP;

    @NotNull
    @Column(name = "category")
    private String categoria_producto;
    @ManyToOne
    @JoinColumn(name = "idCategory", nullable = false, foreignKey = @ForeignKey(name = "FK_category_Id"))
    private Categoria category;

    @JsonIgnore
    @ManyToMany(mappedBy = "carritoCompras")
    private Set<Usuario> carritos = new LinkedHashSet<>();
    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public float getCosto_producto() {
        return costo_producto;
    }

    public void setCosto_producto(float costo_producto) {
        this.costo_producto = costo_producto;
    }

    public String getCategoria_producto() {
        return categoria_producto;
    }

    public void setCategoria_producto(String categoria_producto) {
        this.categoria_producto = categoria_producto;
    }

    public Categoria getCategory() {
        return category;
    }

    public void setCategory(Categoria category) {
        this.category = category;
    }
    public int getStockP() {
        return stockP;
    }

    public void setStockP(int stockP) {
        this.stockP = stockP;
    }
}
