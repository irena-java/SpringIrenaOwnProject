DROP TABLE IF EXISTS countries CASCADE;
CREATE TABLE countries (id SERIAL PRIMARY KEY,
 country varchar UNIQUE);
INSERT INTO countries (country)
VALUES ('Украина'),('Россия'),('Белоруссия');

DROP TABLE IF EXISTS user_roles CASCADE;
CREATE TABLE user_roles
 (id SERIAL PRIMARY KEY,
  user_role varchar UNIQUE);
INSERT INTO user_roles (user_role)
VALUES ('CLIENT'),('MANAGER'),('ADMIN');

DROP TABLE IF EXISTS contact_info CASCADE;
CREATE TABLE contact_info
 (id SERIAL PRIMARY KEY,
 contact_person_name varchar NOT NULL,
 phone varchar NOT NULL,
 email varchar,
 date_closed date);

DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users
 (id SERIAL PRIMARY KEY,
  "name" varchar,
  user_role_id integer REFERENCES user_roles(id),
  client_inn varchar,
  country varchar,
  contact_info_id integer REFERENCES contact_info (id),
  password varchar);

DROP TABLE IF EXISTS statuses_basket CASCADE;
CREATE TABLE statuses_basket
 (id SERIAL PRIMARY KEY,
  status_basket varchar  UNIQUE);
INSERT INTO statuses_basket (status_basket)
VALUES ('ON_AGREEMENT'),('CONFIRMED'),('DELETED');

DROP TABLE IF EXISTS statuses_contract CASCADE;
CREATE TABLE statuses_contract
 (id SERIAL PRIMARY KEY,
  status_contract varchar UNIQUE);
INSERT INTO statuses_contract (status_contract)
VALUES ('EXECUTING'),('COMPLETED'),('DELETED');

DROP TABLE IF EXISTS data_science_sections CASCADE;
CREATE TABLE data_science_sections
 (id SERIAL PRIMARY KEY,
  data_science_section varchar UNIQUE);
INSERT INTO data_science_sections (data_science_section)
VALUES ('MASHINE_LEARNING'),('COMPUTER_VISION'),('NATURAL_LANGUAGE_PROCESSING'),('BIG_DATA');

DROP TABLE IF EXISTS data_science_directions CASCADE;
CREATE TABLE data_science_directions
 (id SERIAL PRIMARY KEY,
  data_science_direction varchar UNIQUE);
INSERT INTO data_science_directions (data_science_direction)
VALUES ('DATA_WAREHOUSE'),('MATHEMATICAL_MODEL'),('AUTOMATION');

DROP TABLE IF EXISTS job_types CASCADE;
CREATE TABLE job_types
 (id SERIAL PRIMARY KEY,
  job_type varchar UNIQUE);
INSERT INTO job_types (job_type)
VALUES ('DEVELOPMENT'),('AUDIT'),('CORPORATE_TRAINING');

DROP TABLE IF EXISTS types_payments CASCADE;
CREATE TABLE types_payments
 (id SERIAL PRIMARY KEY,
  type_payment varchar UNIQUE);
INSERT INTO types_payments(type_payment)
VALUES ('PLAN'),('FACT');

DROP TABLE IF EXISTS items CASCADE;
CREATE TABLE items
 (id SERIAL PRIMARY KEY,
  data_science_section_id integer REFERENCES data_science_sections(id),
  data_science_direction_id integer REFERENCES data_science_directions(id),
  job_type_id integer REFERENCES job_types(id),
  start_date date,
  deadline date,
  price money);

DROP TABLE IF EXISTS baskets CASCADE;
CREATE TABLE baskets
 (id SERIAL PRIMARY KEY,
    date_create_basket date NOT NULL,
    user_id integer REFERENCES users(id),
    status_basket_id integer  REFERENCES statuses_basket (id));

DROP TABLE IF EXISTS items_in_basket CASCADE;
CREATE TABLE items_in_basket
 (id SERIAL PRIMARY KEY,
 basket_id integer REFERENCES baskets(id),
 item_id integer REFERENCES items(id));

DROP TABLE IF EXISTS contracts CASCADE;
CREATE TABLE contracts
 (id SERIAL PRIMARY KEY,
  basket_id integer REFERENCES baskets(id),
  date_begin_contract date NOT NULL,
  deadline_contract date NOT NULL,
  status_contract_id  integer REFERENCES statuses_contract(id));


DROP TABLE IF EXISTS payments_calendar CASCADE;
CREATE TABLE payments_calendar
 (id SERIAL PRIMARY KEY,
 contract_id  integer REFERENCES contracts(id),
  "date" date NOT NULL,
  "sum" money NOT NULL,
  type_payments_id integer REFERENCES types_payments(id));

=======================
create table if not exists countries
(
    id serial
    constraint countries_pkey
    primary key,
    country varchar
    constraint countries_country_key
    unique
);

alter table countries owner to postgres;

create table if not exists user_roles
(
    id serial
    constraint user_roles_pkey
    primary key,
    user_role varchar
    constraint user_roles_user_role_key
    unique
);

alter table user_roles owner to postgres;

create table if not exists data_science_sections
(
    id serial
    constraint data_science_sections_pkey
    primary key,
    data_science_section varchar
    constraint data_science_sections_data_science_section_key
    unique
);

alter table data_science_sections owner to postgres;

create table if not exists data_science_directions
(
    id serial
    constraint data_science_directions_pkey
    primary key,
    data_science_direction varchar
    constraint data_science_directions_data_science_direction_key
    unique
);

alter table data_science_directions owner to postgres;

create table if not exists job_types
(
    id serial
    constraint job_types_pkey
    primary key,
    job_type varchar
    constraint job_types_job_type_key
    unique
);

alter table job_types owner to postgres;

create table if not exists items
(
    id serial
    constraint items_pkey
    primary key,
    data_science_section_id integer
    constraint items_data_science_section_id_fkey
    references data_science_sections,
    data_science_direction_id integer
    constraint items_data_science_direction_id_fkey
    references data_science_directions,
    job_type_id integer
    constraint items_job_type_id_fkey
    references job_types,
    start_date date,
    deadline date,
    price numeric
);

alter table items owner to postgres;

create table if not exists users
(
    id serial
    constraint users_pkey
    primary key,
    name varchar,
    user_role_id integer
    constraint users_user_role_id_fkey
    references user_roles,
    client_inn varchar,
    country_id integer
    constraint my_foreign_key_country_id
    references countries,
    contact_info varchar(30),
    password varchar
    );

alter table users owner to postgres;

create table if not exists baskets
(
    id serial
    constraint baskets_pkey
    primary key,
    user_id integer
    constraint my_foreign_key_user_id
    references users,
    item_id integer
    constraint my_foreign_key_item_id
    references items
);

alter table baskets owner to postgres;

create index if not exists fki_my_foreign_key_user_id
    on baskets (user_id);

create index if not exists fki_my_foreign_key_item_id
    on baskets (item_id);

create index if not exists fki_my_foreign_key_country_id
    on users (country_id);

