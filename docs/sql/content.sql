create table tb_category(
    id int unsigned auto_increment,
    name varchar(60) unique,
    describe varchar(255),
    primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf-8;
