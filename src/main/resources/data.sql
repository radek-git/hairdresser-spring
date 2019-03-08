create table if not exists user_type(
  id integer(10) primary key auto_increment,
  name varchar(50) not null
);

insert into user_type values ( 1, 'EMPLOYEE' );
insert into user_type values ( 2, 'CLIENT' );

alter table user
  add foreign key (user_type_id) references user_type(id);