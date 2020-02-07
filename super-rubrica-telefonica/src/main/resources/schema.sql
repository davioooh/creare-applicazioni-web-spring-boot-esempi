CREATE TABLE IF NOT EXISTS contacts (
    id serial PRIMARY KEY,
    first_name varchar(100) NOT NULL,
    last_name varchar(100) NOT NULL,
    phone varchar(100) NOT NULL,
    email varchar(100) DEFAULT NULL
);