package com.pyashop.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @NotNull
    @Size(min = 5, max = 50, message = "Escriba su nombre correctamente.")
    @Column(name = "nombre_usuario", nullable = false)
    private String nombreUsuario;

    @NotNull
    @Size(min = 5, max = 20, message = "Escriba la contraseña correctamente.")
    @Column(name = "contrasena_usuario", nullable = false, length = 25)
    private String contrasenaUsuario;

    @NotNull
    @Email(message = "Escriba el correo correctamente.")
    @Column(name = "correo_usuario", nullable = false, unique = true)
    private String correoUsuario;

    @Size(max = 100, message = "Especifique bien su direccion")
    @Column(name = "direccion_usuario", length = 100)
    private String direccionUsuario;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany
    @JoinTable(name = "carritos", joinColumns = @JoinColumn(name = "id_carrito"),
            inverseJoinColumns = @JoinColumn(name = "id_product"))
    Set<Producto> carritoCompras = new LinkedHashSet<>();


    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false,
            foreignKey = @ForeignKey(name = "FK_id_rol"))
    private Rol rol;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany
    @JoinTable(name = "lista_de_compras", joinColumns = @JoinColumn(name = "id_lista_compra"),
            inverseJoinColumns = @JoinColumn(name = "id_product"))
    Set<Producto> lista_compra = new LinkedHashSet<>();

    public Set<Producto> getLista_compra() {
        return lista_compra;
    }

    public void setLista_compra(Set<Producto> lista_compra) {
        this.lista_compra = lista_compra;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getDireccionUsuario() {
        return direccionUsuario;
    }

    public void setDireccionUsuario(String direccionUsuario) {
        this.direccionUsuario = direccionUsuario;
    }

    public Set<Producto> getCarritoCompras() {
        return carritoCompras;
    }

    public void setCarritoCompras(Set<Producto> carritoCompras) {
        this.carritoCompras = carritoCompras;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
