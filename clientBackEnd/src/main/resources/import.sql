INSERT INTO users(email,first_name,last_name,password,role) VALUES ('jefimija', 'jefimija','jefimija','jefimija', 'GUEST');
INSERT INTO users(email,first_name,last_name,password,role) VALUES ('dejan.tot@gmail.com', 'dejan','tot','dejan', 'GUEST');


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
INSERT INTO accommodation_pricing(january,february,march,april,may,june,july,august,september,october,november,december,accommodation_unit_id) VALUES ('1000','1000','1000','1000','1000','1000','1000','1000','1000','1000','1000','1000','2');


INSERT INTO accommodation_unit(place,description,capacity,category_id,agent_id,accommodation_type_id) VALUES ('Novi Sad','nema','1000','2','1','1');
INSERT INTO accommodation_unit(place,description,capacity,category_id,agent_id,accommodation_type_id) VALUES ('Beograd','nema','200','2','1','1');

INSERT INTO accommodation_unit_additional_services (accommodation_unit_id, additional_services_id) VALUES ('1', '1');
INSERT INTO accommodation_unit_additional_services (accommodation_unit_id, additional_services_id) VALUES ('1', '2');


INSERT INTO agent(password,username) VALUES ('agent','agent');
