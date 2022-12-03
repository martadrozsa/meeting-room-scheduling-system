-- show tables;

INSERT INTO room (id, name, numbers_of_places)
SELECT * FROM (SELECT 1, 'Joaquina', 12) AS tmp
WHERE NOT EXISTS(SELECT * FROM room WHERE id=1) LIMIT 1;

INSERT INTO room (id, name, numbers_of_places)
SELECT * FROM (SELECT 2, 'Daniela', 15) AS tmp
WHERE NOT EXISTS(SELECT * FROM room WHERE id=2) LIMIT 1;

INSERT INTO room (id, name, numbers_of_places)
SELECT * FROM (SELECT 3, 'Solidão', 10) AS tmp
WHERE NOT EXISTS(SELECT * FROM room WHERE id=3) LIMIT 1;

INSERT INTO room (id, name, numbers_of_places)
SELECT * FROM (SELECT 4, 'Açores', 08) AS tmp
WHERE NOT EXISTS(SELECT * FROM room WHERE id=4) LIMIT 1;

INSERT INTO room (id, name, numbers_of_places)
SELECT * FROM (SELECT 5, 'Forte', 11) AS tmp
WHERE NOT EXISTS(SELECT * FROM room WHERE id=5) LIMIT 1;

INSERT INTO room (id, name, numbers_of_places)
SELECT * FROM (SELECT 6, 'Saudade', 20) AS tmp
WHERE NOT EXISTS(SELECT * FROM room WHERE id=6) LIMIT 1;

INSERT INTO room (id, name, numbers_of_places)
SELECT * FROM (SELECT 7, 'Matadeiro', 05) AS tmp
WHERE NOT EXISTS(SELECT * FROM room WHERE id=7) LIMIT 1;
