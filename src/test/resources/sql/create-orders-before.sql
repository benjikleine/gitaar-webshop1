delete from orders_order_items;
delete from order_item;
delete from orders;

INSERT INTO orders (id, address, city, date, email, first_name, last_name, phone_number, post_index, total_price) VALUES (111, 'Koperweg', 'Apeldoorn', '2021-05-28', 'test123@test.com', 'Benjamin', 'Kanon', '12345678', 123456, 56);

INSERT INTO order_item (id, amount, quantity, perfume_id) VALUES (111, 35, 1, 2);
INSERT INTO order_item (id, amount, quantity, perfume_id) VALUES (222, 21, 1, 4);

INSERT INTO orders_order_items (order_id, order_items_id) VALUES (111, 111);
INSERT INTO orders_order_items (order_id, order_items_id) VALUES (111, 222);
