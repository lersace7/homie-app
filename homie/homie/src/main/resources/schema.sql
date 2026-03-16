CREATE TABLE IF NOT EXISTS usuario (
    id SERIAL PRIMARY KEY,
    email VARCHAR(100),
    password VARCHAR(100)
    );

INSERT INTO usuario (email, password)
VALUES ('test@test.com', '1234');