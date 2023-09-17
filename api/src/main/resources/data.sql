
insert into pais (pai_nombre) values ("chile");
insert into pais (pai_nombre) values ("argentina");
insert into pais (pai_nombre) values ("peru");

insert into region (reg_nombre, pai_id) value ("metropolitana", 1);
insert into region (reg_nombre, pai_id) value ("valparaiso", 1);

insert into comuna (com_nombre, reg_id) value ("santiago", 1 );
insert into comuna (com_nombre, reg_id) value ("quintero", 2);

insert into cliente (cli_nombres, cli_apellidos, cli_correo, cli_pass, cli_resto_direccion, com_id) value ("claudio", "vargas", "claudiovargaslillo@gmail.com", "admin", "parcela 112", 1);

insert into usuario (usu_username, usu_password) values ("darus", "1234");

insert into authority (aut_name) value ("READ");
insert into authority (aut_name) value ("WRITE");
insert into authority (aut_name) value ("ADMIN");

insert into usuario_authority (usu_id, aut_id) values (1, 1);  