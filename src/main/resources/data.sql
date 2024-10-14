-- Inserindo Grupos
INSERT INTO grupo (id, nome) VALUES (1, 'Cliente Básico');
INSERT INTO grupo (id, nome) VALUES (2, 'Cliente Premium');
INSERT INTO grupo (id, nome) VALUES (3, 'Cliente Corporativo');
INSERT INTO grupo (id, nome) VALUES (4, 'Parceiro');
INSERT INTO grupo (id, nome) VALUES (5, 'Administrador');

-- Inserindo Permissões
INSERT INTO permissao (id, nome, descricao) VALUES (1, 'FAZER_PEDIDO', 'Permissão para fazer pedidos');
INSERT INTO permissao (id, nome, descricao) VALUES (2, 'CONSULTAR_HISTORICO', 'Permissão para consultar histórico de pedidos');
INSERT INTO permissao (id, nome, descricao) VALUES (3, 'ALTERAR_PERFIL', 'Permissão para alterar perfil de usuário');
INSERT INTO permissao (id, nome, descricao) VALUES (4, 'ACESSO_PROMOCOES_EXCLUSIVAS', 'Permissão para acessar promoções exclusivas');
INSERT INTO permissao (id, nome, descricao) VALUES (5, 'SUPORTE_PRIORITARIO', 'Permissão para suporte prioritário');
INSERT INTO permissao (id, nome, descricao) VALUES (6, 'CONSULTAR_HISTORICO_EMPRESA', 'Permissão para consultar histórico empresarial');
INSERT INTO permissao (id, nome, descricao) VALUES (7, 'GERENCIAR_ENDERECOS', 'Permissão para gerenciar endereços corporativos');
INSERT INTO permissao (id, nome, descricao) VALUES (8, 'ACESSO_RELATORIOS', 'Permissão para acessar relatórios');
INSERT INTO permissao (id, nome, descricao) VALUES (9, 'GERENCIAR_CARDAPIO', 'Permissão para gerenciar o cardápio');
INSERT INTO permissao (id, nome, descricao) VALUES (10, 'GERENCIAR_PEDIDOS', 'Permissão para gerenciar pedidos');
INSERT INTO permissao (id, nome, descricao) VALUES (11, 'ATUALIZAR_STATUS_PEDIDOS', 'Permissão para atualizar status dos pedidos');
INSERT INTO permissao (id, nome, descricao) VALUES (12, 'GERENCIAR_USUARIOS', 'Permissão para gerenciar usuários');
INSERT INTO permissao (id, nome, descricao) VALUES (13, 'GERENCIAR_PLATAFORMA', 'Permissão para gerenciar a plataforma');
INSERT INTO permissao (id, nome, descricao) VALUES (14, 'GERENCIAR_PROMOCOES', 'Permissão para gerenciar promoções');
INSERT INTO permissao (id, nome, descricao) VALUES (15, 'ACESSO_RELATORIOS_GLOBAIS', 'Permissão para acessar relatórios globais');

-- Relacionando Grupos e Permissões
-- Cliente Básico
INSERT INTO grupo_permissao (grupo_id, permissao_id) VALUES (1, 1); -- FAZER_PEDIDO
INSERT INTO grupo_permissao (grupo_id, permissao_id) VALUES (1, 2); -- CONSULTAR_HISTORICO
INSERT INTO grupo_permissao (grupo_id, permissao_id) VALUES (1, 3); -- ALTERAR_PERFIL

-- Cliente Premium
INSERT INTO grupo_permissao (grupo_id, permissao_id) VALUES (2, 1); -- FAZER_PEDIDO
INSERT INTO grupo_permissao (grupo_id, permissao_id) VALUES (2, 2); -- CONSULTAR_HISTORICO
INSERT INTO grupo_permissao (grupo_id, permissao_id) VALUES (2, 3); -- ALTERAR_PERFIL
INSERT INTO grupo_permissao (grupo_id, permissao_id) VALUES (2, 4); -- ACESSO_PROMOCOES_EXCLUSIVAS
INSERT INTO grupo_permissao (grupo_id, permissao_id) VALUES (2, 5); -- SUPORTE_PRIORITARIO

-- Cliente Corporativo
INSERT INTO grupo_permissao (grupo_id, permissao_id) VALUES (3, 1); -- FAZER_PEDIDO
INSERT INTO grupo_permissao (grupo_id, permissao_id) VALUES (3, 6); -- CONSULTAR_HISTORICO_EMPRESA
INSERT INTO grupo_permissao (grupo_id, permissao_id) VALUES (3, 7); -- GERENCIAR_ENDERECOS
INSERT INTO grupo_permissao (grupo_id, permissao_id) VALUES (3, 8); -- ACESSO_RELATORIOS

-- Parceiro
INSERT INTO grupo_permissao (grupo_id, permissao_id) VALUES (4, 9); -- GERENCIAR_CARDAPIO
INSERT INTO grupo_permissao (grupo_id, permissao_id) VALUES (4, 10); -- GERENCIAR_PEDIDOS
INSERT INTO grupo_permissao (grupo_id, permissao_id) VALUES (4, 11); -- ATUALIZAR_STATUS_PEDIDOS

-- Administrador
INSERT INTO grupo_permissao (grupo_id, permissao_id) VALUES (5, 12); -- GERENCIAR_USUARIOS
INSERT INTO grupo_permissao (grupo_id, permissao_id) VALUES (5, 13); -- GERENCIAR_PLATAFORMA
INSERT INTO grupo_permissao (grupo_id, permissao_id) VALUES (5, 14); -- GERENCIAR_PROMOCOES
INSERT INTO grupo_permissao (grupo_id, permissao_id) VALUES (5, 15); -- ACESSO_RELATORIOS_GLOBAIS

-- Inserindo formas de pagamento no banco de dados
INSERT INTO forma_pagamento (id, descricao) VALUES (1, 'Pix');
INSERT INTO forma_pagamento (id, descricao) VALUES (2, 'Cartão');
INSERT INTO forma_pagamento (id, descricao) VALUES (3, 'Boleto');

