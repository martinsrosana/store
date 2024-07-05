-- Inserindo tipos de product
INSERT INTO product_type (description, active) VALUES ('Tipo A', true);
INSERT INTO product_type (description, active) VALUES ('Tipo B', true);
INSERT INTO product_type (description, active) VALUES ('Tipo C', true);
INSERT INTO product_type (description, active) VALUES ('Tipo D', true);
INSERT INTO product_type (description, active) VALUES ('Tipo E', true);
INSERT INTO product_type (description, active) VALUES ('Tipo F', true);



-- Inserindo products
INSERT INTO product (name, description, price, product_type_id) VALUES ('Produto 1', 'Descrição Produto 1', 100.0, 1);
INSERT INTO product (name, description, price, product_type_id) VALUES ('Produto 2', 'Descrição Produto 2', 200.0, 2);
INSERT INTO product (name, description, price, product_type_id) VALUES ('Produto 3', 'Descrição Produto 3', 300.0, 3);
INSERT INTO product (name, description, price, product_type_id) VALUES ('Produto 4', 'Descrição Produto 4', 400.0, 4);
INSERT INTO product (name, description, price, product_type_id) VALUES ('Produto 5', 'Descrição Produto 5', 500.0, 5);
INSERT INTO product (name, description, price, product_type_id) VALUES ('Produto 6', 'Descrição Produto 6', 600.0, 6);