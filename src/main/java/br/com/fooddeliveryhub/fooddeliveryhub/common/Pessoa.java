package br.com.fooddeliveryhub.fooddeliveryhub.common;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class Pessoa {
    protected String nome;
    protected String email;
}
