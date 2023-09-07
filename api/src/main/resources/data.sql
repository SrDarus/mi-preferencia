
insert into pais (pai_nombre) values ("chile");
insert into pais (pai_nombre) values ("argentina");
insert into pais (pai_nombre) values ("peru");

insert into region (reg_nombre, pai_id) value ("metropolitana", 1);
insert into region (reg_nombre, pai_id) value ("valparaiso", 1);

insert into comuna (com_nombre, reg_id) value ("santiago", 1 );
insert into comuna (com_nombre, reg_id) value ("quintero", 2);

insert into rol (rol_nombre) values ("admin");
insert into rol (rol_nombre) values ("cliente");