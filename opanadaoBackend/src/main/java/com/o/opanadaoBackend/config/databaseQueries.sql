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
  role VARCHAR(100),
  enabled BOOLEAN,
  email VARCHAR(100),
  password VARCHAR(60),
  contact_number VARCHAR(15),
CONSTRAINT pk_user_id PRIMARY KEY (id)
);

Insert into user (first_name, last_name, role, enabled, email, password, contact_number) VALUES ('Admin', 'Admin', 'ADMIN',true, 'admin@admin.com','$2b$10$5YuTD2n7Kp.eLgNIdxc1JOeIDy8bGQEe.83CmkIdc0aM2l7VXLPQi', '000000000');
Insert into user (first_name, last_name, role, enabled, email, password, contact_number) VALUES ('Customer1', 'Customer1', 'CUSTOMER',true, 'Customer1@Customer1.com','$2b$10$ORYrPo7.Qdjtq.Ppe5jKoOvGPyJ9Aq2a/9eai82rjDWRLC09m66QG', '000000001');
Insert into user (first_name, last_name, role, enabled, email, password, contact_number) VALUES ('Customer2', 'Customer2', 'CUSTOMER',true, 'Customer2@Customer2.com','$2b$10$ORYrPo7.Qdjtq.Ppe5jKoOvGPyJ9Aq2a/9eai82rjDWRLC09m66QG', '000000002');


