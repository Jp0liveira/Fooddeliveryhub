package br.com.fooddeliveryhub.fooddeliveryhub.repository;

import br.com.fooddeliveryhub.fooddeliveryhub.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {
}
