package br.com.fooddeliveryhub.fooddeliveryhub.repository;

import br.com.fooddeliveryhub.fooddeliveryhub.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
}
