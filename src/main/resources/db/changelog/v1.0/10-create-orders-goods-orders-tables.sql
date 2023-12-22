--liquibase formatted sql

--changeset marzuev_vladimir:1

CREATE TABLE IF NOT EXISTS orders
(
    id           BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY NOT NULL,
    user_address VARCHAR                                             NOT NULL,
    is_payed      BOOLEAN DEFAULT FALSE
);

--rollback drop table orders

--changeset marzuev_vladimir:2
CREATE TABLE IF NOT EXISTS orders_goods
(
    id       BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY NOT NULL,
    good_id  BIGINT                                              NOT NULL,
    quantity BIGINT                                              NOT NULL,
    order_id BIGINT REFERENCES orders ON DELETE CASCADE
);

--rollback drop table orders_goods