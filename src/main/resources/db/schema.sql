DROP TABLE usuario;
CREATE TABLE usuario (id [bigint] IDENTITY(1,1) NOT NULL PRIMARY KEY, name VARCHAR(255), surname VARCHAR(255), nif VARCHAR(10), age INTEGER);
