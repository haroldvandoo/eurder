insert into eurder_user(id, firstname, lastname, email, address, phone, role_type, password)
values (nextval('user_seq'), 'Bill', 'Clinton', 'billcllinton@whitehouse.com', 'Leuven', '0477123456', 'ADMIN', 'password');

insert into eurder_user(id, firstname, lastname, email, address, phone, role_type, password)
values (nextval('user_seq'), 'Barack', 'Obama', 'bobama@whitehouse.com', 'Brussel', '0477123457', 'CUSTOMER', 'password');

insert into eurder_user(id, firstname, lastname, email, address, phone, role_type, password)
values (nextval('user_seq'), 'Donald', 'Trump', 'dtrump@whitehouse.com', 'Ostende', '0477123458', 'CUSTOMER', 'password');

insert into eurder_user(id, firstname, lastname, email, address, phone, role_type, password)
values (nextval('user_seq'), 'Joe', 'Biden', 'jbiden@whitehouse.com', 'Namur', '0477123459', 'CUSTOMER', 'password');

insert into eurder_user(id, firstname, lastname, email, address, phone, role_type, password)
values (nextval('user_seq'), 'Richard', 'Nixon', 'rnixon@whitehouse.com', 'watergate', '0477123460', 'CUSTOMER', 'password');

insert into item(id, name, description, price, amount)
values (nextval('item_seq'), 'chair', 'ikea chair', 150.00, 50);

insert into item(id, name, description, price, amount)
values (nextval('item_seq'), 'table', 'ugly table', 10.00, 1000);

insert into item(id, name, description, price, amount)
values (nextval('item_seq'), 'sofa', 'nice sofa', 800.00, 3);

insert into item(id, name, description, price, amount)
values (nextval('item_seq'), 'coffee table', 'luxury coffee table', 20000.00, 5);