create table tb_account(
    id int unsigned auto_increment, 
    nickname varchar(60) not null,
    password varchar(60) not null,
    gender int unsigned default 1,
    fullname varchar(60),
    primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;
