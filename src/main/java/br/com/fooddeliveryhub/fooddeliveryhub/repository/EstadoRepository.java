package br.com.fooddeliveryhub.fooddeliveryhub.repository;

import br.com.fooddeliveryhub.fooddeliveryhub.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
}
