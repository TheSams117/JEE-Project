DROP TABLE estudiantes;
DROP TABLE materias;
DROP TABLE matriculas;
DROP TABLE hibernate_sequence;

DELETE FROM estudiantes;
DELETE FROM materias;
DELETE FROM matriculas

CREATE TABLE estudiantes (
  id SERIAL PRIMARY KEY,
  nombre varchar(255) NOT NULL,
  identificacion varchar(255) NOT NULL
);

CREATE TABLE materias (
  id SERIAL PRIMARY KEY,
  nombre varchar(255) NOT NULL,
  serial varchar(255) NOT NULL
);

CREATE TABLE matriculas (
  id SERIAL PRIMARY KEY,
  estudiante_id int REFERENCES estudiantes (id) ON DELETE CASCADE,
  materia_id int REFERENCES materias (id) ON DELETE CASCADE
);

UPDATE `hibernate_sequence` SET `next_val`=16 WHERE 1;

INSERT INTO `estudiantes`(`id`, `identificacion`, `nombre`) VALUES (1,"1107524154","Sergio");
INSERT INTO `estudiantes`(`id`, `identificacion`, `nombre`) VALUES (2,"123456","Jose");
INSERT INTO `estudiantes`(`id`, `identificacion`, `nombre`) VALUES (3,"3234126","Andrea");
INSERT INTO `estudiantes`(`id`, `identificacion`, `nombre`) VALUES (4,"12342134512" ,"Camila");
INSERT INTO `estudiantes`(`id`, `identificacion`, `nombre`) VALUES (5,"123421345123","Jorge");

INSERT INTO `materias`(`id`, `nombre`, `serial`) VALUES (6,"matemáticas","12445");
INSERT INTO `materias`(`id`, `nombre`, `serial`) VALUES (7,"historia","12342");
INSERT INTO `materias`(`id`, `nombre`, `serial`) VALUES (8,"inglés","42341");
INSERT INTO `materias`(`id`, `nombre`, `serial`) VALUES (9,"química","34323");

INSERT INTO `matriculas`(`id`, `estudiante_id`, `materia_id`) VALUES (10,1,7);
INSERT INTO `matriculas`(`id`, `estudiante_id`, `materia_id`) VALUES (11,4,7);
INSERT INTO `matriculas`(`id`, `estudiante_id`, `materia_id`) VALUES (12,1,6);
INSERT INTO `matriculas`(`id`, `estudiante_id`, `materia_id`) VALUES (13,1,8);
INSERT INTO `matriculas`(`id`, `estudiante_id`, `materia_id`) VALUES (14,4,8);
INSERT INTO `matriculas`(`id`, `estudiante_id`, `materia_id`) VALUES (15,3,9);


SELECT mat.nombre,mat.serial FROM estudiantes.est,matriculas.matr,materias.mat WHERE est.id = 1 AND est.id = mart.id

SELECT estudiantes.nombre,estudiantes.identificacion 
FROM estudiantes, matriculas
WHERE estudiantes.id = 1 AND matriculas.id = estudiantes.id