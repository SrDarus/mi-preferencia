
insert into pais (pai_nombre) values ("chile");
insert into pais (pai_nombre) values ("argentina");
insert into pais (pai_nombre) values ("peru");

insert into region (reg_nombre, pai_id) value ("metropolitana", 1);
insert into region (reg_nombre, pai_id) value ("valparaiso", 1);

insert into comuna (com_nombre, reg_id) value ("santiago", 1 );
insert into comuna (com_nombre, reg_id) value ("quintero", 2);

insert into rol (rol_nombre) values ("admin");
insert into rol (rol_nombre) values ("cliente");

insert into usuario (usu_nombres, usu_apellidos, usu_correo, usu_pass, usu_resto_direccion, com_id) value ("claudio", "vargas", "claudiovargaslillo@gmail.com", "admin", "parcela 112", 1);
insert into usuario_rol (usu_id, rol_id) values (1, 1);