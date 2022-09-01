-- Active: 1661897235468@@127.0.0.1@3306

CREATE DATABASE IF NOT EXISTS `web_customer_tracker`;

CREATE TABLE
    customer (
        id INT(11) NOT NULL AUTO_INCREMENT,
        name VARCHAR(45) DEFAULT NULL,
        email VARCHAR(45) DEFAULT NULL,
        PRIMARY KEY (id)
    );

SELECT * FROM customer;
