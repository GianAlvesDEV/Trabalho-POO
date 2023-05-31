create database construcao_civil;

create table DonoDaCasa(
	cpf             varchar(50)  not null,
    nome            varchar(100) not null,
    telefone        varchar(20)  not null,
    renda_mensal    float        not null,
    primary key (cpf)
);

create table Venda(
	cod_venda          varchar(50)  not null,
    fk_cpf             varchar(50)  not null,
    fk_cod_residencia  int          not null,
    dataDaVenda        date         not null,
    valor              float        not null,
    primary key (cod_venda)
);

create table Residencia(
	cod_residencia    int           not null,
    area              float         not null,
    endereco          varchar(100)  not null,
    primary key (cod_residencia)
);

alter table Venda add foreign key (fk_cpf) references DonoDaCasa(cpf);
alter table Venda add foreign key (fk_cod_residencia) references Residencia(cod_residencia);

select * from DonoDaCasa;
select * from Residencia;


