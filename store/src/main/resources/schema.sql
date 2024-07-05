CREATE TABLE product_type (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              description VARCHAR(255) NOT NULL,
                              active BOOLEAN NOT NULL
);

CREATE TABLE product (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         description VARCHAR(255) NOT NULL,
                         price DOUBLE NOT NULL,
                         product_type_id BIGINT,
                         FOREIGN KEY (product_type_id) REFERENCES product_type(id)
);
