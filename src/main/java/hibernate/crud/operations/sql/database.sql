-- CREATE DATABASE hibernate;

DROP TABLE IF EXISTS student;
CREATE TABLE IF NOT EXISTS student
(
  student_id   SERIAL PRIMARY KEY,
  student_name varchar(50),
  roll_number  varchar(50),
  course       varchar(50)
);

DROP TABLE IF EXISTS book;
CREATE TABLE IF NOT EXISTS book
(
  book_id SERIAL PRIMARY KEY,
  title varchar(50),
  student_id INT
);

DROP TABLE IF EXISTS phone;
CREATE TABLE IF NOT EXISTS phone
(
  phone_id SERIAL PRIMARY KEY,
  phone_number varchar(13),
  student_id INT
);