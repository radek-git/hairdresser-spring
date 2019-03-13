create table if not exists user_type(
  id integer(10) primary key auto_increment,
  name varchar(50) not null
);

insert into user_type values ( 1, 'EMPLOYEE' );
insert into user_type values ( 2, 'CLIENT' );

alter table user
  add foreign key (user_type_id) references user_type(id);

insert into user (name, surname, username, user_type_id) values ( 'empname1', 'empsurname1', 'empusername1' , 1);
insert into user (name, surname, username, user_type_id) values ( 'empname2', 'empsurname2', 'empusername2', 1 );
insert into user (name, surname, username, user_type_id) values ( 'cname1', 'csurname1', 'cusername1', 2 );
insert into user (name, surname, username, user_type_id) values ( 'cname2', 'csurname2', 'cusername2', 2 );

insert into appointment ( client_id, employee_id, start_time, end_time, price ) values ( 1, 2, '2019-03-13T10:00:00', '2019-03-13T11:00:00', 30 );