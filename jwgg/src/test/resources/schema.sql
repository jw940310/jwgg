drop table if exists item CASCADE;
create table item
(
    id        bigint generated by default as identity,
    item_name varchar(10),
    price     integer,
    quantity  integer,
    primary key (id)
);

drop table if exists member CASCADE;
create table member
(
    id        bigint generated by default as identity,
    login_id varchar(10),
    name     varchar(10),
    password  varchar(10),
    primary key (id)
);

drop table if exists champ CASCADE;
create table champ
(
    champ_id        INT generated by default as identity,
    champ_name varchar(10),
    champ_line     varchar(10),
    primary key (champ_id)
);

drop table if exists counter CASCADE;
CREATE TABLE counter (
  login_id        bigint generated by default as identity,
  id INT,
  cid INT,
  FOREIGN KEY ( login_id) REFERENCES member(id),
  FOREIGN KEY (id) REFERENCES champ(champ_id),
  FOREIGN KEY (cid) REFERENCES champ(champ_id)
);

--ALTER TABLE champ ALTER COLUMN champ_id RESTART WITH 1;

--insert into champ (champ_name, champ_line) values ('베인','원딜'); --1
--insert into champ (champ_name, champ_line) values ('시비르','원딜'); --2
--insert into champ (champ_name, champ_line) values ('카이사','원딜'); --3
--insert into champ (champ_name, champ_line) values ('루시안','원딜'); --4
--
--insert into counter (id, cid) values (1,3);
--insert into counter (id, cid) values (2,4);
