INSERT INTO orders (id, address, city, date, email, first_name, last_name, phone_number, post_index, total_price)
    VALUES (1, 'Koperweg',  'Apeldoorn', '2021-04-07', 'test123@test.com', 'Benjamin', 'Kanon', '1234567890', 1234567890, 840);
INSERT INTO orders (id, address, city, date, email, first_name, last_name, phone_number, post_index, total_price)
    VALUES (2, 'Koperweg', 'Apeldoorn', '2021-04-07', 'test123@test.com', 'Benjamin', 'Kanon', '1234567890', 1234567890, 240);
INSERT INTO orders (id, address, city, date, email, first_name, last_name, phone_number, post_index, total_price)
    VALUES (3, 'Koperweg', 'Apeldoorn', '2021-04-07', 'benjikleine@live.nl', 'Melanie', 'Kanon', '1234567890', 1234567890, 163);
INSERT INTO orders (id, address, city, date, email, first_name, last_name, phone_number, post_index, total_price)
    VALUES (4, 'Koperweg', 'Apeldoorn', '2021-04-07', 'benjikleine@live.nl', 'Melanie', 'Kanon', '1234567890', 1234567890, 780);
INSERT INTO orders (id, address, city, date, email, first_name, last_name, phone_number, post_index, total_price)
    VALUES (5, 'Koperweg', 'Apeldoorn', '2021-04-07', 'benjikleine@live.nl', 'Melanie', 'Kanon', '1234567890', 1234567890, 196);

INSERT INTO order_item (id, amount, quantity, product_id) VALUES (1, 384, 2, 33);
INSERT INTO order_item (id, amount, quantity, product_id) VALUES (2, 456, 3, 34);
INSERT INTO order_item (id, amount, quantity, product_id) VALUES (3, 178, 2, 39);
INSERT INTO order_item (id, amount, quantity, product_id) VALUES (4, 62, 1, 43);
INSERT INTO order_item (id, amount, quantity, product_id) VALUES (5, 63, 1, 77);
INSERT INTO order_item (id, amount, quantity, product_id) VALUES (6, 41, 1, 85);
INSERT INTO order_item (id, amount, quantity, product_id) VALUES (7, 59, 1, 108);
INSERT INTO order_item (id, amount, quantity, product_id) VALUES (8, 96, 2, 16);
INSERT INTO order_item (id, amount, quantity, product_id) VALUES (9, 684, 4, 17);
INSERT INTO order_item (id, amount, quantity, product_id) VALUES (10, 92, 2, 86);
INSERT INTO order_item (id, amount, quantity, product_id) VALUES (11, 104, 2, 91);

INSERT INTO orders_order_items (order_id, order_items_id) VALUES (1, 1);
INSERT INTO orders_order_items (order_id, order_items_id) VALUES (1, 2);
INSERT INTO orders_order_items (order_id, order_items_id) VALUES (2, 3);
INSERT INTO orders_order_items (order_id, order_items_id) VALUES (2, 4);
INSERT INTO orders_order_items (order_id, order_items_id) VALUES (3, 5);
INSERT INTO orders_order_items (order_id, order_items_id) VALUES (3, 6);
INSERT INTO orders_order_items (order_id, order_items_id) VALUES (3, 7);
INSERT INTO orders_order_items (order_id, order_items_id) VALUES (4, 8);
INSERT INTO orders_order_items (order_id, order_items_id) VALUES (4, 9);
INSERT INTO orders_order_items (order_id, order_items_id) VALUES (5, 10);
INSERT INTO orders_order_items (order_id, order_items_id) VALUES (5, 11);


