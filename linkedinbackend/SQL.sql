CREATE TABLE people(

id IDENTITY,
name varchar(255),
experience CLOB,
education CLOB,
json CLOB,
profile CLOB,
url varchar(100),
isactive boolean,
CONSTRAINT pk_people_id PRIMARY KEY (id)
);