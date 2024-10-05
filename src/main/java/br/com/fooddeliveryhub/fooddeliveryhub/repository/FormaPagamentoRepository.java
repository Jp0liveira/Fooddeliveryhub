package br.com.fooddeliveryhub.fooddeliveryhub.repository;

import br.com.fooddeliveryhub.fooddeliveryhub.model.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {
}
