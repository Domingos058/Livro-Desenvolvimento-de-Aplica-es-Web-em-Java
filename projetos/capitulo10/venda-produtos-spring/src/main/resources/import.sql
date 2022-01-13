delete from cidade;
delete from estado;

insert into estado( id, nome, sigla ) values( 1, "São Paulo", "SP" );
insert into estado( id, nome, sigla ) values( 2, "Goiás", "GO" );
insert into estado( id, nome, sigla ) values( 3, "Paraná", "PR" );
insert into estado( id, nome, sigla ) values( 4, "Rio Grande do Sul", "RS" );
insert into estado( id, nome, sigla ) values( 5, "Minas Gerais", "MG" );

insert into cidade( id, nome, estado_id ) values( 1, "São Paulo", 1 );
insert into cidade( id, nome, estado_id ) values( 2, "Goiânia", 2 );
insert into cidade( id, nome, estado_id ) values( 3, "Curitiba", 3 );
insert into cidade( id, nome, estado_id ) values( 4, "Cascavel", 3 );
insert into cidade( id, nome, estado_id ) values( 5, "Viamão", 4 );
insert into cidade( id, nome, estado_id ) values( 6, "Lima Duarte", 5 );