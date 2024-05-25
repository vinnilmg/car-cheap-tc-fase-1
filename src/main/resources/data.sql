insert into carro (id, placa, chassi, renavan, anofab, anomodelo, potencia, cor, nr_portas, equipamentos, tp_carroceria, vr_original, vr_venda, origem, status, classificacao) values
('a472f22e-31c1-41db-b8d4-64a86d8a9394', 'teste', 'teste', 'teste', 2008, 2009, 136, 'branco', 4, 'ar, direção, vidro', 'sedan', 60000, 50000, 'teste', 'teste', 'ECONOMICO');
insert into carro (id, placa, chassi, renavan, anofab, anomodelo, potencia, cor, nr_portas, equipamentos, tp_carroceria, vr_original, vr_venda, origem, status, classificacao) values
('dff0c727-f78f-430e-b3e1-9c184975166c', 'ggxa22', 'xxxxxxxxx', 'teste', 2008, 2009, 136, 'preto', 4, 'ar, direção, vidro', 'sedan', 120000, 150000, 'teste', 'teste', 'PREMIUM');
insert into carro (id, placa, chassi, renavan, anofab, anomodelo, potencia, cor, nr_portas, equipamentos, tp_carroceria, vr_original, vr_venda, origem, status, classificacao) values
('6f73dfb0-55c5-46ce-a104-3b000c35ae38', 'ggxa23', 'xxxxxxxx2', 'teste', 2018, 2009, 250, 'prata', 4, 'ar, direção, trava', 'suv', 75000, 85000, 'teste', 'teste', 'ECONOMICO');
insert into carro (id, placa, chassi, renavan, anofab, anomodelo, potencia, cor, nr_portas, equipamentos, tp_carroceria, vr_original, vr_venda, origem, status, classificacao) values
('bb14a29c-1de9-4431-8014-48878ad86768', 'ggxa24', 'xxxxxxxx3', 'teste', 2021, 2021, 75, 'azul', 2, 'ar, direção, vidro', 'hatch', 250000, 250000, 'teste', 'teste', 'PREMIUM');
insert into carro (id, placa, chassi, renavan, anofab, anomodelo, potencia, cor, nr_portas, equipamentos, tp_carroceria, vr_original, vr_venda, origem, status, classificacao) values
('9b6d13a2-0838-42bb-b943-4e5a7ed0614d', 'ggxa25', 'xxxxxxxx4', 'teste', 2022, 2022, 150, 'branco', 4, 'ar, direção, vidro', 'suv', 160000, 160000, 'teste', 'teste', 'PREMIUM');

INSERT INTO clientes (id, nome, cpf, email, rg) VALUES
('90cfa24e-4be0-44dc-8855-76bbcf4be910', 'João da Silva', '12345678900', 'joao.silva@example.com', 'MG12345678'),
('1f4a7c5e-b2b7-41d5-b89e-99401cb574b5', 'Maria Oliveira', '98765432100', 'maria.oliveira@example.com', 'SP87654321'),
('a1d1b8c4-8b73-4aaf-8349-d2d9a5a03e9d', 'Carlos Pereira', '45678912300', 'carlos.pereira@example.com', 'RJ45678912'),
('ed1b05ec-36b4-4b14-a635-3b526e5e6c3b', 'Ana Costa', '78912345600', 'ana.costa@example.com', 'RS78912345'),
('5a574f7d-f4b7-4a6b-9b0b-8673e4df8e6f', 'Lucas Souza', '32165498700', 'lucas.souza@example.com', 'PR32165498');

INSERT INTO USUARIO (ID,USERNAME,PASSWORD,NOME,SOBRENOME,PERFIL) VALUES ('30e7964f-07cc-4f7c-9a96-b837f92884e4','user1','pass1','JALINDO','SANTOS','MASTER');
INSERT INTO USUARIO (ID,USERNAME,PASSWORD,NOME,SOBRENOME,PERFIL) VALUES ('62800332-989d-4f93-86d9-63a5b0619bc6','user2','pass2','ROMILDO','SILVIO','VENDEDOR');

INSERT INTO PEDIDOS (ID, VENDEDOR_ID, CLIENTE_ID, CARRO_ID, VALOR_COMISSAO, TIPO_PAGAMENTO, STATUS_PEDIDO) VALUES
('1aebd98f-a96f-4c28-b042-d5da03f23950',
'62800332-989d-4f93-86d9-63a5b0619bc6',
'90cfa24e-4be0-44dc-8855-76bbcf4be910',
'a472f22e-31c1-41db-b8d4-64a86d8a9394',
1500.0,
'DINHEIRO',
'PENDENTE');

INSERT INTO PEDIDOS (ID, VENDEDOR_ID, CLIENTE_ID, CARRO_ID, VALOR_COMISSAO, TIPO_PAGAMENTO, STATUS_PEDIDO) VALUES
('cebe598d-f8d0-49db-9b0f-91f14b03e1c4',
'62800332-989d-4f93-86d9-63a5b0619bc6',
'1f4a7c5e-b2b7-41d5-b89e-99401cb574b5',
'dff0c727-f78f-430e-b3e1-9c184975166c',
3000.0,
'CREDITO',
'CONTRATO_EMITIDO');

INSERT INTO PEDIDOS (ID, VENDEDOR_ID, CLIENTE_ID, CARRO_ID, VALOR_COMISSAO, TIPO_PAGAMENTO, STATUS_PEDIDO) VALUES
('a87361fa-6490-4701-b450-91b0da3207d6',
'62800332-989d-4f93-86d9-63a5b0619bc6',
'a1d1b8c4-8b73-4aaf-8349-d2d9a5a03e9d',
'6f73dfb0-55c5-46ce-a104-3b000c35ae38',
1800.0,
'FINANCIAMENTO',
'AGUARDANDO_PAGAMENTO');

INSERT INTO PEDIDOS (ID, VENDEDOR_ID, CLIENTE_ID, CARRO_ID, VALOR_COMISSAO, TIPO_PAGAMENTO, STATUS_PEDIDO) VALUES
('2ce25bd2-3ce3-4f6d-bb23-83140256dcd3',
'62800332-989d-4f93-86d9-63a5b0619bc6',
'ed1b05ec-36b4-4b14-a635-3b526e5e6c3b',
'bb14a29c-1de9-4431-8014-48878ad86768',
4000.0,
'PIX',
'PAGO');