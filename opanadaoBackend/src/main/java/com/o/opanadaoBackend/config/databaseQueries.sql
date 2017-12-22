CREATE TABLE category (
  id          IDENTITY,
  name        VARCHAR(50),
  description VARCHAR(255),
  is_active   BOOLEAN,
  CONSTRAINT pk_category_id PRIMARY KEY (id)
);

INSERT INTO category (name, description, is_active) VALUES ('Kebab', 'Turkish Sandwich', 'true');
INSERT INTO category (name, description, is_active) VALUES ('Panado', 'PANADO Sandwich', 'true');
INSERT INTO category (name, description, is_active) VALUES ('Hamburger', 'American Sandwich', 'true');

CREATE TABLE user (
  id             IDENTITY,
  first_name     VARCHAR(50),
  last_name      VARCHAR(50),
  role           VARCHAR(100),
  enabled        BOOLEAN,
  email          VARCHAR(100),
  password       VARCHAR(60),
  contact_number VARCHAR(15),
  CONSTRAINT pk_user_id PRIMARY KEY (id)
);

INSERT INTO user (first_name, last_name, role, enabled, email, password, contact_number) VALUES
  ('Admin', 'Admin', 'ADMIN', TRUE, 'admin@admin.com', '$2b$10$5YuTD2n7Kp.eLgNIdxc1JOeIDy8bGQEe.83CmkIdc0aM2l7VXLPQi',
   '000000000');
INSERT INTO user (first_name, last_name, role, enabled, email, password, contact_number) VALUES
  ('Customer1', 'Customer1', 'CUSTOMER', TRUE, 'Customer1@Customer1.com',
   '$2b$10$ORYrPo7.Qdjtq.Ppe5jKoOvGPyJ9Aq2a/9eai82rjDWRLC09m66QG', '000000001');
INSERT INTO user (first_name, last_name, role, enabled, email, password, contact_number) VALUES
  ('Customer2', 'Customer2', 'CUSTOMER', TRUE, 'Customer2@Customer2.com',
   '$2b$10$ORYrPo7.Qdjtq.Ppe5jKoOvGPyJ9Aq2a/9eai82rjDWRLC09m66QG', '000000002');


CREATE TABLE cart_line (
  id            IDENTITY,
  cart_id       INT,
  total         DECIMAL(10, 2),
  product_id    INT,
  product_count INT,
  buying_price  DECIMAL(10, 2),
  is_available  BOOLEAN,
  CONSTRAINT fk_cartline_cart_id FOREIGN KEY (cart_id) REFERENCES cart (id),
  CONSTRAINT fk_cartline_product_id FOREIGN KEY (product_id) REFERENCES product (id),
  CONSTRAINT pk_cartline_id PRIMARY KEY (id)
);

