
CREATE TABLE usuarios_roles (
    id_usuario BIGINT NOT NULL,
    id_role BIGINT NOT NULL,
    PRIMARY KEY (id_usuario, id_role),
    FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario),
    FOREIGN KEY (id_role) REFERENCES role (id_role)
);