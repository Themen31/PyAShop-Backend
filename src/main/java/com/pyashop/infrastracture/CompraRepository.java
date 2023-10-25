package com.pyashop.infrastracture;
import com.pyashop.domain.Compra;
import com.pyashop.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CompraRepository extends JpaRepository<Compra, Integer> {
    @Query("SELECT p FROM Compra p WHERE p.usuario=:usuario")
    List<Compra> listarComprasPorIdUsuario(@Param("usuario") Usuario usuario);

}
