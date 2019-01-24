INSERT INTO Role (id, role_name, description) VALUES (1, 'STANDARD_USER', 'Standard User - Has no admin rights');
INSERT INTO Role (id, role_name, description) VALUES (2, 'ADMIN_USER', 'Admin User - Has permission to perform admin tasks');

INSERT INTO Role (id, role_name, description) VALUES (3, 'PROFESOR_USER', 'Profesor User - Has permission to perform admin tasks');
INSERT INTO Role (id, role_name, description) VALUES (4, 'PUBLICADOR_USER', 'Profesor User - Has permission to perform admin tasks');



-- USER
-- non-encrypted password: jwtpass
INSERT INTO User (id, first_name, last_name, password, username) VALUES (1, 'John', 'Doe', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 'john.doe');
INSERT INTO User (id, first_name, last_name, password, username) VALUES (2, 'Admin', 'Admin', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 'admin.admin');


INSERT INTO user_role(user_id, role_id) VALUES(1,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,2);

-- Populate random city table

INSERT INTO RandomCity(id, name) VALUES (1, 'Bamako');
INSERT INTO RandomCity(id, name) VALUES (2, 'Nonkon');
INSERT INTO RandomCity(id, name) VALUES (3, 'Houston');
INSERT INTO RandomCity(id, name) VALUES (4, 'Toronto');
INSERT INTO RandomCity(id, name) VALUES (5, 'New York City');
INSERT INTO RandomCity(id, name) VALUES (6, 'Mopti');
INSERT INTO RandomCity(id, name) VALUES (7, 'Koulikoro');
INSERT INTO RandomCity(id, name) VALUES (8, 'Moscow');
