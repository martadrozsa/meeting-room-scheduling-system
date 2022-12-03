-- show tables;

INSERT INTO employee (id, name, admission_date, birth_date)
SELECT * FROM (SELECT 1, 'Pedro Andrade', '2015-03-16', '1990-12-20') AS tmp
WHERE NOT EXISTS(SELECT * FROM employee WHERE id=1) LIMIT 1;

INSERT INTO employee (id, name, admission_date, birth_date)
SELECT * FROM (SELECT 2, 'Camila Lima', '2018-06-25', '1989-11-10') AS tmp
WHERE NOT EXISTS(SELECT * FROM employee WHERE id=2) LIMIT 1;

INSERT INTO employee (id, name, admission_date, birth_date)
SELECT * FROM (SELECT 3, 'Michael Rodriguez', '2017-07-12', '1988-12-20') AS tmp
WHERE NOT EXISTS(SELECT * FROM employee WHERE id=3) LIMIT 1;

INSERT INTO employee (id, name, admission_date, birth_date)
SELECT * FROM (SELECT 4, 'Joseph Martinez', '2019-11-10', '2000-08-23') AS tmp
WHERE NOT EXISTS(SELECT * FROM employee WHERE id=4) LIMIT 1;

INSERT INTO employee (id, name, admission_date, birth_date)
SELECT * FROM (SELECT 5, 'Steven Lewis', '2018-05-10', '1987-03-15') AS tmp
WHERE NOT EXISTS(SELECT * FROM employee WHERE id=5) LIMIT 1;

INSERT INTO employee (id, name, admission_date, birth_date)
SELECT * FROM (SELECT 6, 'Greg Miller', '2020-03-16', '1999-01-18') AS tmp
WHERE NOT EXISTS(SELECT * FROM employee WHERE id=6) LIMIT 1;