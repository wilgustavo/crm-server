insert into grupo (nombre, descripcion) 
values 
('ROLE_ADMIN', 'Administradores'),
('COMERCIAL', 'Comerciales');

insert into usuario (id, apellido, nombre, email) 
values 
('96ec1106219c4f25a12a07a4f79940b0', 'Acevedo', 'Liliana', 'liliana.acevedo@zilphur.me'),
('551ea9ccc73f4eaaa9397aeace7bc6fb', 'Fulanito', 'Cosme', 'cosmef@email.com');


insert into grupo_usuario (usuario_id, grupo_nombre) 
values
('96ec1106219c4f25a12a07a4f79940b0', 'COMERCIAL'), 
('551ea9ccc73f4eaaa9397aeace7bc6fb', 'ROLE_ADMIN');

insert into contacto
(id, apellido, nombre, email, movil, nacimiento, telefono, 
 domicilio, ciudad, codigo_postal, estado, pais, asignado)
 values
('aaaaaaaaaaa0000009397aeace7bc6fb', 'Fulanito', 'Cosme', 'cosmef@email.com', 
 '232-3223323', '1980-01-01', '232-323232' , 'Av.Siempre Viva 3232', 
 'Sprinfield', '23112', 'Kansas', 'US', '96ec1106219c4f25a12a07a4f79940b0');
