-- Se tiene que llamar import.sql
-- La tabla es productos porque en el package models.entity, clase Producto la tenemos mapeada a la tabla productos.
-- El id se omite porque se crea de forma automática incremental.
INSERT INTO productos (nombre, precio, create_at) VALUES('Panasonic', 800, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Sony', 700, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Apple', 1000, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Sony Notebook', 1000, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Hewlett Packard', 500, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Bianchi', 600, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Nike', 100, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Adidas', 200, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Reebok', 300, NOW());