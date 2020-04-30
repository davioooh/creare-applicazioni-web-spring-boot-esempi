CREATE TABLE IF NOT EXISTS contacts (
    id serial PRIMARY KEY,
    first_name varchar(100) NOT NULL,
    last_name varchar(100) NOT NULL,
    phone varchar(100) NOT NULL,
    email varchar(100) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS users (
    id serial PRIMARY KEY,
    username varchar(100) NOT NULL,
    password varchar(100) NOT NULL
);

INSERT INTO users (id, username, password)
 VALUES (1, 'testuser', '{noop}pwd')
 ON CONFLICT DO NOTHING;