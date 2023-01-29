CREATE TABLE IF NOT EXISTS cliente (

    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11),
    cnpj VARCHAR(14),
    nomeFantasia VARCHAR(50),
    telefone_fixo VARCHAR(11),
    telefone_celular VARCHAR(11),
    telefone_comercial VARCHAR(11),
    tipo_cliente CHAR(1) NOT NULL,
    endereco_residencial_id BIGINT,
    endereco_comercial_id BIGINT,

    PRIMARY KEY(id),
    CONSTRAINT fk_cliente_endereco_residencial FOREIGN KEY(endereco_residencial_id) REFERENCES endereco(id),
    CONSTRAINT fk_cliente_endereco_comercial FOREIGN KEY(endereco_comercial_id) REFERENCES endereco(id)

);

CREATE TABLE IF NOT EXISTS veiculo (

    id BIGINT NOT NULL AUTO_INCREMENT,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    cor VARCHAR(20),
    placa VARCHAR(7),
    vaga_ocupada VARCHAR(10),
    cliente_id BIGINT NOT NULL,

    PRIMARY KEY(id),
    CONSTRAINT fk_veiculo_cliente FOREIGN KEY(cliente_id) REFERENCES cliente(id)
);