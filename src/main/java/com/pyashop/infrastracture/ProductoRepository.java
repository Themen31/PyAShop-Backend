package com.pyashop.infrastracture;

import com.pyashop.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @Query(value= "SELECT COUNT(*) FROM Producto", nativeQuery = true)
    Long contarProductos();
}

