insert into accommodation_category(category_name) values ('*');
insert into accommodation_category(category_name) values ('**');
insert into accommodation_category(category_name) values ('***');
insert into accommodation_category(category_name) values ('****');
insert into accommodation_category(category_name) values ('*****');


insert into accommodation_type(type_name) values ('APARTMENT');
insert into accommodation_type(type_name) values ('HOTEL');
insert into accommodation_type(type_name) values ('BED & BREAKFAST');

insert into additional_service(name) values ('WiFi');
insert into additional_service(name) values ('Parking');
insert into additional_service(name) values ('Kitchen');
insert into additional_service(name) values ('Private bathroom');
insert into additional_service(name) values ('TV');

insert into agent(username, password) values('user', 'user');
insert into agent(username, password) values('petar', 'petar');

insert into accommodation_unit
(place, description, capacity, accommodation_type_id, category_id, agent_id) values
('Futoska 12,Novi Sad,Serbia', 'super smjestaj', 5, 1, 3, 1);

insert into accommodation_unit
(place, description, capacity, accommodation_type_id, category_id, agent_id) values
('Balzakova 23,Novi Sad,Serbia', 'ok smjestaj', 3, 3, 4, 1);

insert into accommodation_unit
(place, description, capacity, accommodation_type_id, category_id, agent_id) values
('Sejkina 72,Belgrade,Serbia', 'odlican smjestaj', 12, 2, 5, 2);

insert into accommodation_photo(accommodation_unit_id, path) values (1, '12.jpg');
insert into accommodation_photo(accommodation_unit_id, path) values (1, '111.jpg');

insert into accommodation_unit_additional_service(accommodation_unit_id, additional_service_id) values (1, 1);
insert into accommodation_unit_additional_service(accommodation_unit_id, additional_service_id) values (1, 2);
insert into accommodation_unit_additional_service(accommodation_unit_id, additional_service_id) values (1, 4);
insert into accommodation_unit_additional_service(accommodation_unit_id, additional_service_id) values (2, 1);
insert into accommodation_unit_additional_service(accommodation_unit_id, additional_service_id) values (2, 3);
insert into accommodation_unit_additional_service(accommodation_unit_id, additional_service_id) values (2, 4);