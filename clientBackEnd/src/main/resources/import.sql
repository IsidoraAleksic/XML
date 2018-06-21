
INSERT INTO users(email,first_name,last_name,password,role,status) VALUES ('jefimija', 'jefimija','jefimija','jefimija', 'GUEST', 'ACTIVATED');
INSERT INTO users(email,first_name,last_name,password,role,status) VALUES ('dejan.tot@gmail.com', 'dejan','tot','dejan', 'GUEST', 'ACTIVATED');


INSERT INTO accommodation_category(category_name) VALUES ('*');
INSERT INTO accommodation_category(category_name) VALUES ('**');
INSERT INTO accommodation_category(category_name) VALUES ('***');
INSERT INTO accommodation_category(category_name) VALUES ('****');
INSERT INTO accommodation_category(category_name) VALUES ('*****');

INSERT INTO accommodation_type(type_name) VALUES ('bed&breakfast');


INSERT INTO additional_services(name) VALUES ('TV');
INSERT INTO additional_services(name) VALUES ('WiFi');
INSERT INTO additional_services(name) VALUES ('Parking');


INSERT INTO accommodation_pricing(january,february,march,april,may,june,july,august,september,october,november,december,accommodation_unit_id) VALUES ('1000','1000','1000','1000','1000','1000','1000','1000','1000','1000','1000','1000','1');
INSERT INTO accommodation_pricing(january,february,march,april,may,june,july,august,september,october,november,december,accommodation_unit_id) VALUES ('900','900','900','900','900','900','900','900','900','900','900','900','2');
INSERT INTO accommodation_pricing(january,february,march,april,may,june,july,august,september,october,november,december,accommodation_unit_id) VALUES ('1000','1000','1000','1000','1000','1000','1000','1000','1000','1000','1000','1000','3');


INSERT INTO accommodation_unit(place,description,capacity,category_id,agent_id,accommodation_type_id) VALUES ('Novi Sad','nema','1000','2','1','1');
INSERT INTO accommodation_unit(place,description,capacity,category_id,agent_id,accommodation_type_id) VALUES ('Novi Sad','nema','1000','3','1','1');
INSERT INTO accommodation_unit(place,description,capacity,category_id,agent_id,accommodation_type_id) VALUES ('Beograd','nema','200','2','1','1');

INSERT INTO accommodation_unit_additional_services (accommodation_unit_id, additional_services_id) VALUES ('1', '1');
INSERT INTO accommodation_unit_additional_services (accommodation_unit_id, additional_services_id) VALUES ('1', '2');
INSERT INTO accommodation_unit_additional_services (accommodation_unit_id, additional_services_id) VALUES ('2', '2');


INSERT INTO review (approved, review, accommodation_unit_id, user_id) VALUES (false, 'shit', '1', '1');

INSERT INTO agent(password,name,surname,email,reg_number) VALUES ('agent','agent','agent','agent@gmail.com','23D');
