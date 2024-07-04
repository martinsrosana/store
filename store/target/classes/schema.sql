CREATE TABLE type_product (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              description VARCHAR(255) NOT NULL,
                              active BOOLEAN NOT NULL
);

CREATE TABLE product (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         description VARCHAR(255) NOT NULL,
                         price DOUBLE NOT NULL,
                         type_product_id BIGINT,
                         FOREIGN KEY (type_product_id) REFERENCES type_product(id)
);
