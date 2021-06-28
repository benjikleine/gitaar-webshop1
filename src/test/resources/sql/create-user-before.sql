delete from user_role;
delete from users;

-- password: admin123
insert into users(id, email, first_name, last_name, city, address, phone_number, post_index, activation_code, active, password, password_reset_code, provider)
    values(1, 'admin@gmail.com', 'Admin', 'Admin', null, null, null, null, null, true, '$2a$08$kS2f5m8eYoNpc.ZECzndGuXiqaWmCaFfOGMQquodP48qrD7.cQG4y', null, 'LOCAL');

-- password: admin123
insert into users(id, email, first_name, last_name, city, address, phone_number, post_index, activation_code, active, password, password_reset_code, provider)
    values(122, 'test123@test.com', 'Benjamin', 'Kanon', 'Apeldoorn', 'Koperweg', '1234567890', '1234567890', null, true, null , null, 'LOCAL');

insert into users(id, email, first_name, last_name, city, address, phone_number, post_index, activation_code, active, password, password_reset_code, provider)
    values (126, 'helloworld@test.com', 'Melanie', 'Kanon', 'Apeldoorn', 'Koperweg', '1234567890', '1234567890',null , 'LOCAL');

insert into user_role (user_id, roles) values (1, 'ADMIN');
insert into user_role (user_id, roles) values (122, 'USER');
insert into user_role (user_id, roles) values (126, 'USER');
