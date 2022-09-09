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
        -- password must be at least 68 bytes
        password VARCHAR(128) NOT NULL,
        active BOOLEAN NOT NULL,
        roles VARCHAR(128) NOT NULL,
        PRIMARY KEY(id),
        CONSTRAINT Name_UNI UNIQUE (name)
    );

INSERT INTO `user`(name,password,active,roles) VALUES('ttq','$2a$10$Wt.JJTMLZinuriked/lcOepNwIC3Vj7p8g1DT5wq1s84qQAVMzLRC',1,'ROLE_EDITOR');

SELECT * FROM customer;
