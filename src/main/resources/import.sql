insert into professor_title(id, version, name) values (1, 0, 'Magister');
insert into professor_title(id, version, name) values (2, 0, 'Doctor');
insert into professor_title(id, version, name) values (3, 0, 'Docent');
insert into professor_title(id, version, name) values (4, 0, 'Associate Professor');
insert into professor_title(id, version, name) values (5, 0, 'Professor');
insert into professor_title(id, version, name) values (6, 0, 'Assistant');
insert into professor_title(id, version, name) values (7, 0, 'Academic');


insert into professor(version, name, surname, title_id) values (0, 'Vladimir', 'Antin', 7);
insert into professor(version, name, surname, title_id) values (0, 'Nikola', 'Tesla', 6);
insert into professor(version, name, surname, title_id) values (0, 'Random', 'Profesor', 5);
insert into professor(version, name, surname, title_id) values (0, 'Albert', 'Ajnstajn', 4);
insert into professor(version, name, surname, title_id) values (0, 'Carls', 'Darvin', 3);


insert into course(version, description, name, nmb_of_exercise, nmb_of_lecture) values (0, '', 'Basic of programming',5,5);
insert into course(version, description, name, nmb_of_exercise, nmb_of_lecture) values (0, '', 'Web design',5,5);
insert into course(version, description, name, nmb_of_exercise, nmb_of_lecture) values (0, '', 'Web programming (Java)',5,5);
insert into course(version, description, name, nmb_of_exercise, nmb_of_lecture) values (0, '', 'Web programming (C#)',5,5);
insert into course(version, description, name, nmb_of_exercise, nmb_of_lecture) values (0, '', 'Web programming (PHP)',5,5);
insert into course(version, description, name, nmb_of_exercise, nmb_of_lecture) values (0, '', 'Frontend programming (Angular)',5,5);
insert into course(version, description, name, nmb_of_exercise, nmb_of_lecture) values (0, '', 'Frontend programming (Vue)',5,5);
insert into course(version, description, name, nmb_of_exercise, nmb_of_lecture) values (0, '', 'Frontend programming (React)',5,5);
insert into course(version, description, name, nmb_of_exercise, nmb_of_lecture) values (0, '', 'Logic',5,5);
insert into course(version, description, name, nmb_of_exercise, nmb_of_lecture) values (0, '', 'Basic of Android',5,5);
insert into course(version, description, name, nmb_of_exercise, nmb_of_lecture) values (0, '', 'Basic of iOS',5,5);
insert into course(version, description, name, nmb_of_exercise, nmb_of_lecture) values (0, '', 'Basic of SQL',5,5);
insert into course(version, description, name, nmb_of_exercise, nmb_of_lecture) values (0, '', 'Basic of NoSQL',5,5);
insert into course(version, description, name, nmb_of_exercise, nmb_of_lecture) values (0, '', 'REST web services',5,5);
insert into course(version, description, name, nmb_of_exercise, nmb_of_lecture) values (0, '', 'Graphql web services',5,5);
insert into course(version, description, name, nmb_of_exercise, nmb_of_lecture) values (0, '', 'Machine learning',5,5);


-- insert into user(version, username, password, active) values (0, 'admin', '$2a$10$QM4iKmcuLuMLQOhwcdPRsOrC8Q3.4I9Kv2o2dBfgfDZ6omGLwwlHq', 1);
