
CREATE TABLE livros (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    autor VARCHAR(255),
    data VARCHAR(20),
    codigo VARCHAR(17) NOT NULL
);