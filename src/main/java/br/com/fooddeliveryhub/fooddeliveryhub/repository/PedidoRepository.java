package br.com.fooddeliveryhub.fooddeliveryhub.repository;

import br.com.fooddeliveryhub.fooddeliveryhub.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
