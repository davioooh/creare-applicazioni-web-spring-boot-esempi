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
 VALUES
    (1, 'testuser', '{noop}pwd'),
    (2, 'testuser2', '{noop}pwd'),
    (3, 'adminuser', '{noop}admin')
 ON CONFLICT DO NOTHING;

CREATE TABLE IF NOT EXISTS user_roles (
    user_id int,
    role varchar(20),
    PRIMARY KEY (user_id, role)
);

INSERT INTO user_roles (user_id, role)
 VALUES
    (1, 'USER'),
    (2, 'USER'),
    (3, 'USER'),
    (3, 'ADMIN')
 ON CONFLICT DO NOTHING;

ALTER TABLE contacts ADD COLUMN IF NOT EXISTS owner_username varchar(100) NOT NULL DEFAULT 'testuser';
ALTER TABLE contacts ALTER COLUMN owner_username DROP DEFAULT;