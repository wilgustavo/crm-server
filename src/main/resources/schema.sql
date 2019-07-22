 drop table grupo_usuario if exists;
 drop table grupo if exists;
 drop table usuario if exists;
 
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
    
 alter table grupo_usuario
    add constraint fk_grupo 
    foreign key (grupo_nombre) references grupo;
    
 alter table grupo_usuario
    add constraint fk_usuario 
    foreign key (usuario_id) references usuario;
