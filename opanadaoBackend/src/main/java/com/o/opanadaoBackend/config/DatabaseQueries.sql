CREATE TABLE category (
  id          IDENTITY,
  name        VARCHAR(50),
  description VARCHAR(255),
  is_active   BOOLEAN,
  CONSTRAINT pk_category_id PRIMARY KEY (id)
);

INSERT INTO category (name, description, is_active) VALUES ('Kebab', 'Turkish Sandwich', 'true');
INSERT INTO category (name, description,  is_active) VALUES ('Panado', 'PANADO Sandwich', 'true');
INSERT INTO category (name, description,  is_active) VALUES ('Hamburger', 'American Sandwich', 'true');

CREATE TABLE user(
  id IDENTITY,
  first_name VARCHAR(50),
  last_name VARCHAR(50),
  role VARCHAR(50),
  enabled BOOLEAN,
  email VARCHAR(100),
  password VARCHAR(50),
  contact_number VARCHAR(15),
CONSTRAINT pk_user_id PRIMARY KEY (id)
);

Insert into user (first_name, last_name, role, enabled, email, password, contact_number) VALUES ('Admin', 'Admin', 'ADMIN',true, 'admin@admin.com','admin', '000000000');
Insert into user (first_name, last_name, role, enabled, email, password, contact_number) VALUES ('Customer1', 'Customer1', 'CUSTOMER',true, 'Customer1@Customer1.com','Customer1', '000000001');
Insert into user (first_name, last_name, role, enabled, email, password, contact_number) VALUES ('Customer2', 'Customer2', 'CUSTOMER',true, 'Customer2@Customer2.com','Customer2', '000000002');

Create TABLE product(
  id Identity,
  code VARCHAR(20),
  name VARCHAR(50),
  description VARCHAR(255),
  unit_price DECIMAL(10,2),
  quantity INT,
  is_active BOOLEAN,
  category_id int,
  purchases int DEFAULT 0,
  views int DEFAULT 0,
  CONSTRAINT pk_product_id PRIMARY KEY (id),
  CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES categoryId (id)
);

INSERT into product (code, name, description, unit_price, quantity, is_active, category_id) VALUES ('KBB001', 'Kebab Normal', 'kebab', 2.5, 30,true, 1);
INSERT into product (code, name, description, unit_price, quantity, is_active, category_id) VALUES ('KBB002', 'Kebab com Ovo', 'kebab', 3, 30,true, 1);
INSERT into product (code, name, description, unit_price, quantity, is_active, category_id) VALUES ('PND001', 'Panado Normal', 'Panado', 1.75, 30,true, 2);
INSERT into product (code, name, description, unit_price, quantity, is_active, category_id) VALUES ('PND002', 'Panado Com Ovo', 'Panado', 2, 30,true, 2);
INSERT into product (code, name, description, unit_price, quantity, is_active, category_id) VALUES ('HBG001', 'Hamburger Normal', 'Hamburger', 3, 30,true, 3);
INSERT into product (code, name, description, unit_price, quantity, is_active, category_id) VALUES ('HBG002', 'Hamburger Com Ovo', 'Hamburger', 3.5, 30,true, 3);