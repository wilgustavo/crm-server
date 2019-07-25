 drop table grupo_usuario if exists;
 drop table grupo if exists;
 drop table usuario if exists;
 drop table contacto if exists;
 
 create table grupo (
    descripcion varchar(255),
    nombre varchar(255),
    primary key (nombre));
    
 create table grupo_usuario (
    usuario_id binary not null,
    grupo_nombre varchar(255) not null,
    primary key (usuario_id, grupo_nombre));
    
 create table usuario (
    id binary not null,
    apellido varchar(255),
    email varchar(255),
    nombre varchar(255),
    primary key (id));
    
create table contacto (
    id binary not null,
    apellido varchar(255),
    ciudad varchar(255),
    codigo_postal varchar(255),
    domicilio varchar(255),
    estado varchar(255),
    pais varchar(255),
    email varchar(255),
    movil varchar(255),
    nacimiento date,
    nombre varchar(255),
    telefono varchar(255),
    asignado binary,
    primary key (id));    
    
 alter table grupo_usuario
    add constraint fk_grupo 
    foreign key (grupo_nombre) references grupo;
    
 alter table grupo_usuario
    add constraint fk_usuario 
    foreign key (usuario_id) references usuario;

 alter table contacto 
    add constraint fk_asignado 
    foreign key (asignado) references usuario;
 
 