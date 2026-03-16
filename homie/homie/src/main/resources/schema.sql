CREATE TABLE IF NOT EXISTS usuarios (
    id SERIAL PRIMARY KEY,
    email VARCHAR(100),
    password VARCHAR(100)
    );

INSERT INTO usuarios (email, password)
VALUES ('test@test.com', '1234');