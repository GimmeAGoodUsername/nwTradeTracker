DROP TABLE IF EXISTS UserModel;

CREATE TABLE UserModel(
    uuid VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);
