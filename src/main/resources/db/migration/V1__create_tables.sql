create table eurder_user
(
    id        bigint unique not null primary key,
    firstName varchar(52)    not null,
    lastName  varchar(52)    not null,
    email     varchar(52)    not null,
    address   varchar(52)    not null,
    phone     varchar(52),
    role_type varchar(52)
);

create sequence user_seq start with 1 increment by 1;

create table item
(
    ID          bigint unique not null primary key,
    NAME        varchar(52)    not null,
    DESCRIPTION varchar(255)   not null,
    PRICE       integer        not null,
    AMOUNT      integer        not null
);

create sequence item_seq start with 1 increment by 1;

create table orders
(
    ID            bigint unique not null primary key,
    FK_ITEM_ID    bigint        not null,
    AMOUNT        integer        not null,
    PRICE         integer        not null,
    SHIPPING_DATE integer        not null
        constraint FK_ITEM_ID REFERENCES item
);

create sequence order_seq start with 1 increment by 1;

create table order_by_client
(
    FK_ORDER_ID    bigint not null,
    FK_CUSTOMER_ID bigint not null
        constraint FK_ORDER_ID references orders
        constraint FK_CUSTOMER_ID references eurder_user
);

