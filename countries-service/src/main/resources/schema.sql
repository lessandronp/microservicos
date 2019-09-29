DROP TABLE IF EXISTS country;
 
CREATE TABLE country (
	country VARCHAR(10) NOT NULL,
	name VARCHAR(250) NOT NULL,
	currency VARCHAR(20) NOT NULL,
	currencysimbol VARCHAR(5) NOT NULL,
	language VARCHAR(10) NOT NULL,
	capital VARCHAR(20) NOT NULL,
);