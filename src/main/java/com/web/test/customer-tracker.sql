-- Active: 1661897235468@@127.0.0.1@3306

CREATE DATABASE IF NOT EXISTS `web_customer_tracker`;

CREATE TABLE
    customer (
        id INT(11) NOT NULL AUTO_INCREMENT,
        name VARCHAR(45) DEFAULT NULL,
        email VARCHAR(45) DEFAULT NULL,
        PRIMARY KEY (id)
    );

DROP TABLE IF EXISTS user;

CREATE TABLE
    user (
        id INT(11) NOT NULL AUTO_INCREMENT,
        name VARCHAR(128) NOT NULL,
        password VARCHAR(128) NOT NULL,
        active BOOLEAN NOT NULL,
        roles VARCHAR(128) NOT NULL,
        PRIMARY KEY(id),
        CONSTRAINT Name_UNI UNIQUE (name)
    );

INSERT INTO
    `user`(name, password, active, roles)
VALUES (
        'locle',
        'thangcho',
        1,
        'ROLE_USER'
    );

INSERT INTO
    `user`(name, password, active, roles)
VALUES (
        'admin',
        'admin',
        1,
        'ROLE_ADMIN'
    );

SELECT * FROM customer;