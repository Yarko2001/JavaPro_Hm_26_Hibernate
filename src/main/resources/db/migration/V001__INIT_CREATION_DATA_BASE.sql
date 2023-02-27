
Create SCHEMA IF NOT EXISTS my_university;

CREATE TABLE IF NOT EXISTS my_university.student
(
    id         serial,
    name       text NOT NULL,
    email      text NOT NULL,
    primary    key(id)
);

CREATE TABLE IF NOT EXISTS my_university.mark
(
    id         serial,
    discipline text NOT NULL,
    status      integer NOT NULL,
    primary    key(id)
);