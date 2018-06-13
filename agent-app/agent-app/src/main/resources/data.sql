insert into accommodation_unit(country, city, address, description, accommodation_type,
                               capacity, category, wifi, parking, tv, breakfast, kitchen, private_bathroom)
values ('Serbia', 'Novi Sad', 'Bul Oslovodjenja 10', 'ok smjestaj', 2, 1, 3, true, false, true, false, true, true);

insert into accommodation_unit(country, city, address, description, accommodation_type,
                               capacity, category, wifi, parking, tv, breakfast, kitchen, private_bathroom)
values ('Serbia', 'Belgrade', 'Seikina 64', 'ok smjestaj', 2, 1, 3, true, false, true, false, true, true);

insert into accommodation_unit(country, city, address, description, accommodation_type,
                               capacity, category, wifi, parking, tv, breakfast, kitchen, private_bathroom)
values ('Montenegro', 'Herceg Novi', 'Partizanski put 20', 'ok smjestaj', 2, 1, 3, true, false, true, false, true, true);

insert into accommodation_unit(country, city, address, description, accommodation_type,
                               capacity, category, wifi, parking, tv, breakfast, kitchen, private_bathroom)
values ('Montenegro', 'Sutorina', 'Sutorina bb', 'ok smjestaj', 2, 1, 3, true, false, true, false, true, true);



insert into accommodation_photo(accommodation_unit_id, path) values (1, 'aja.jpg');
insert into accommodation_photo(accommodation_unit_id, path) values (1, '111.jpg');
insert into accommodation_photo(accommodation_unit_id, path) values (1, '3.jpg');

insert into users(username, password) values ('admin', 'admin');
insert into users(username, password) values ('petarpetrovic', '123');

insert into accommodation_unit_creator(accommodation_unit_id, user_id) values (1, 2);
insert into accommodation_unit_creator(accommodation_unit_id, user_id) values (2, 2);
insert into accommodation_unit_creator(accommodation_unit_id, user_id) values (3, 2);
insert into accommodation_unit_creator(accommodation_unit_id, user_id) values (4, 2);
