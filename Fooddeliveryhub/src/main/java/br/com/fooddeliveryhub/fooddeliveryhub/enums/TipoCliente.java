package br.com.fooddeliveryhub.fooddeliveryhub.enums;

import java.util.List;
import lombok.Getter;

@Getter
public enum TipoCliente {
    BASIC(1, "Cliente Básico", List.of("FAZER_PEDIDO", "CONSULTAR_HISTORICO", "ALTERAR_PERFIL")),
    PREMIUM(2, "Cliente Premium", List.of("FAZER_PEDIDO", "CONSULTAR_HISTORICO", "ALTERAR_PERFIL", "ACESSO_PROMOCOES_EXCLUSIVAS", "SUPORTE_PRIORITARIO")),
    CORPORATE(3, "Cliente Corporativo", List.of("FAZER_PEDIDO", "CONSULTAR_HISTORICO_EMPRESA", "GERENCIAR_ENDERECOS", "ACESSO_RELATORIOS")),
    PARTNER(4,"Parceiro", List.of("GERENCIAR_CARDAPIO", "GERENCIAR_PEDIDOS", "ATUALIZAR_STATUS_PEDIDOS")),
    ADMIN(5,"Administrador", List.of("GERENCIAR_USUARIOS", "GERENCIAR_PLATAFORMA", "GERENCIAR_PROMOCOES", "ACESSO_RELATORIOS_GLOBAIS"));

    private final Integer id;
    private String descricao;
    private List<String> permissoes;

    TipoCliente(Integer id, String descricao, List<String> permissoes) {
        this.id = id;
        this.descricao = descricao;
        this.permissoes = permissoes;
    }
}
