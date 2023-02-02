CREATE TABLE IF NOT EXISTS endereco (

    id BIGINT NOT NULL AUTO_INCREMENT,
    logradouro VARCHAR(100) NOT NULL,
    numero VARCHAR(6) NOT NULL,
    bairro VARCHAR(50) NOT NULL,
    municipio_id BIGINT NOT NULL,
    complemento VARCHAR(50),
    cep VARCHAR(8) NOT NULL,

    PRIMARY KEY(id),
    CONSTRAINT fk_endereco_municipio FOREIGN KEY(municipio_id) REFERENCES municipio(id)

);