create table product(id bigserial primary key, name varchar(250),description varchar(250),
price float,discount float,deleted boolean default false);