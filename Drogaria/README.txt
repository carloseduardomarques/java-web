select *
  from dba_users
       
       create user drogaria identified by 12345
       
       grant dba to drogaria;

create table fabricante(codigo integer primary key, descricao varchar2(50))

create table produto(codido integer primary key,
                     descricao varchar2(50),
                     quantidade int,
                     preco decimal(5, 2),
                     codigo_fabricante integer,
                     foreign key (codigo_fabricante) references fabricante(codigo)
                     )
                     

;

select * from  fabricante;
select * from  produto for update ;

select * from fabricante

create sequence s_codigo_fabricante start with 1
;
CREATE OR REPLACE TRIGGER drogaria.TBI_S_fabricante
BEFORE INSERT
ON drogaria.fabricante
REFERENCING NEW AS NEW
FOR EACH ROW
BEGIN
SELECT s_codigo_fabricante.NEXTVAL INTO :NEW.codigo FROM DUAL;
END;