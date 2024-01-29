-- create table person(
--     id integer not null,
--     name varchar(255) not null,
--     location varchar(255),
--     birthday timestamp,
--     primary key (id)
-- );

-- Not needed anymore, table is created by Schema update triggered by spring boot autoconfiguration

INSERT INTO PERSON (ID, name, location, birthday) VALUES ( 1001, 'Maxine', 'Ohio', '2016-01-14 14:30:15' );
INSERT INTO PERSON (ID, name, location, birthday) VALUES ( 1002, 'Lambchop', 'NYC', '2012-11-24 21:31:52' );
INSERT INTO PERSON (ID, name, location, birthday) VALUES ( 1003, 'Scrappy', 'LA', '2015-05-17 18:18:18' );
INSERT INTO PERSON (ID, name, location, birthday) VALUES ( 1004, 'Otter', 'Miami', '2018-02-02 05:20:55' );