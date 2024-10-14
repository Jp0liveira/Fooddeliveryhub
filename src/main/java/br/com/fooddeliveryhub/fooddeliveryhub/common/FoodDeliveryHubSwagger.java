package br.com.fooddeliveryhub.fooddeliveryhub.common;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FoodDeliveryHubSwagger <T, ID> {
    ResponseEntity<List<T>> listar();

    ResponseEntity<T> buscarPorId(ID id);

    ResponseEntity<T> salvar(T objeto);

//    ResponseEntity<T> atualizar(ID id, T objeto);

    ResponseEntity<Void> deletar(ID id);
}
