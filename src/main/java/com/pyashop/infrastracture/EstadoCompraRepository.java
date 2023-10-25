package com.pyashop.infrastracture;
import com.pyashop.domain.EstadoCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EstadoCompraRepository extends JpaRepository<EstadoCompra, Integer> {
    @Query("SELECT e FROM EstadoCompra e WHERE e.nombreEstado = 'Compra Cancelado'")
    EstadoCompra compraCancelado();

    @Query("SELECT e FROM EstadoCompra e WHERE e.nombreEstado = 'Compra de Envío'")
    EstadoCompra compraEnviado();
}
