insert into consumers (id, first_name, last_name) values (1, 'Agatha', 'Brinkler');
insert into consumers (id, first_name, last_name) values (2, 'Rowney', 'Grabham');
insert into consumers (id, first_name, last_name) values (3, 'Christophe', 'Dyerson');
insert into consumers (id, first_name, last_name) values (4, 'Maxine', 'Mitkcov');
insert into consumers (id, first_name, last_name) values (5, 'Olive', 'Roft');
insert into consumers (id, first_name, last_name) values (6, 'Cherie', 'Hruska');
insert into consumers (id, first_name, last_name) values (7, 'Carmelina', 'Szach');
insert into consumers (id, first_name, last_name) values (8, 'Doria', 'Chalfain');
insert into consumers (id, first_name, last_name) values (9, 'Ahmad', 'Mallalieu');
insert into consumers (id, first_name, last_name) values (10, 'Rosaline', 'Annell');

insert into restaurants (id, city, state, street1, street2, zip, name) values (1, 'Miaoshi', null, '94391 Mitchell Pass', '51 Bartelt Crossing', null, 'Bubblemix');
insert into restaurants (id, city, state, street1, street2, zip, name) values (2, 'Ergates', null, '10 Monica Lane', '65 Bunker Hill Drive', null, 'Voolith');
insert into restaurants (id, city, state, street1, street2, zip, name) values (3, 'Zangkaxa', null, '1426 Ludington Park', '3 Cambridge Plaza', null, 'Flashpoint');
insert into restaurants (id, city, state, street1, street2, zip, name) values (4, 'Liwu', null, '08 Grim Pass', '04964 Luster Terrace', null, 'Gigabox');
insert into restaurants (id, city, state, street1, street2, zip, name) values (5, 'Mekarsari', null, '89 Westend Park', '07 Iowa Center', null, 'Twiyo');
insert into restaurants (id, city, state, street1, street2, zip, name) values (6, 'Gavarr', null, '279 Packers Alley', '2943 Corscot Trail', null, 'Flashspan');
insert into restaurants (id, city, state, street1, street2, zip, name) values (7, 'Langtad', null, '5668 Division Place', '9949 Springview Parkway', '4022', 'Gabspot');
insert into restaurants (id, city, state, street1, street2, zip, name) values (8, 'Wilmington', 'Delaware', '9123 Surrey Crossing', '621 Waywood Point', '19892', 'Oba');
insert into restaurants (id, city, state, street1, street2, zip, name) values (9, 'Täby', 'Stockholm', '63 Sachtjen Terrace', '15121 Tennessee Alley', '183 55', 'Feedbug');
insert into restaurants (id, city, state, street1, street2, zip, name) values (10, 'Armenia', null, '5 2nd Way', '11147 Sommers Street', '630008', 'Demivee');

insert into courier (id, city, state, street1, street2, zip, available, first_name, last_name) values (1, 'Lubbock', 'Texas', '52 Barnett Pass', '71 Forster Circle', '79410', false, 'Lola', 'Simester');
insert into courier (id, city, state, street1, street2, zip, available, first_name, last_name) values (2, 'San Diego', 'California', '63 Forest Dale Parkway', '413 Oriole Place', '92186', false, 'Celesta', 'Widmoor');
insert into courier (id, city, state, street1, street2, zip, available, first_name, last_name) values (3, 'Miami', 'Florida', '781 American Circle', '4 Grayhawk Lane', '33180', false, 'Warner', 'Spavon');
insert into courier (id, city, state, street1, street2, zip, available, first_name, last_name) values (4, 'Albuquerque', 'New Mexico', '343 Red Cloud Drive', '12 Esch Lane', '87180', false, 'Caterina', 'Wisker');
insert into courier (id, city, state, street1, street2, zip, available, first_name, last_name) values (5, 'Orlando', 'Florida', '7941 Hoffman Road', '0 Upham Trail', '32868', true, 'Dari', 'Concannon');
insert into courier (id, city, state, street1, street2, zip, available, first_name, last_name) values (6, 'Phoenix', 'Arizona', '8 Dunning Terrace', '574 Monument Trail', '85015', false, 'Karolina', 'Zaniolo');
insert into courier (id, city, state, street1, street2, zip, available, first_name, last_name) values (7, 'Denver', 'Colorado', '70625 Grover Junction', '68615 Milwaukee Plaza', '80291', false, 'Regan', 'Benedetti');
insert into courier (id, city, state, street1, street2, zip, available, first_name, last_name) values (8, 'Northridge', 'California', '579 Schmedeman Hill', '8597 Elgar Hill', '91328', true, 'Bank', 'Leafe');
insert into courier (id, city, state, street1, street2, zip, available, first_name, last_name) values (9, 'Saint Louis', 'Missouri', '0789 Banding Lane', '373 Schlimgen Point', '63110', false, 'Jaymee', 'Conti');
insert into courier (id, city, state, street1, street2, zip, available, first_name, last_name) values (10, 'Omaha', 'Nebraska', '7 Rieder Street', '96 Dayton Trail', '68117', false, 'Winslow', 'Guthrum');

insert into restaurant_menu_items (restaurant_id, id, name, price) values (1, 1, 'Cheese - Brick With Pepper', '1.50');
insert into restaurant_menu_items (restaurant_id, id, name, price) values (2, 2, 'Sandwich Wrap', '1.12');
insert into restaurant_menu_items (restaurant_id, id, name, price) values (3, 3, 'Water - Aquafina Vitamin', '6.01');
insert into restaurant_menu_items (restaurant_id, id, name, price) values (4, 4, 'Lobster - Tail 6 Oz', '1.05');
insert into restaurant_menu_items (restaurant_id, id, name, price) values (5, 5, 'Banana', '2.61');
insert into restaurant_menu_items (restaurant_id, id, name, price) values (6, 6, 'Pepper - Black, Whole', '4.63');
insert into restaurant_menu_items (restaurant_id, id, name, price) values (7, 7, 'Soup - Campbells Tomato Ravioli', '3.81');
insert into restaurant_menu_items (restaurant_id, id, name, price) values (8, 8, 'Cheese - Wine', '2.83');
insert into restaurant_menu_items (restaurant_id, id, name, price) values (9, 9, 'Wine - Red, Antinori Santa', '3.43');
insert into restaurant_menu_items (restaurant_id, id, name, price) values (10, 10, 'Alize Red Passion', '3.45');

