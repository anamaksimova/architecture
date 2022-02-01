CREATE SCHEMA `lesson4` ;
use `lesson4`;
CREATE TABLE `lesson4`.`films` (
                                   `id` INT NOT NULL AUTO_INCREMENT,
                                   `film_name` VARCHAR(45) NOT NULL,
                                   `film_lasting` INT NOT NULL,
                                   PRIMARY KEY (`id`));
ALTER TABLE `lesson4`.`films`
    ADD INDEX `film_name` (`film_name` ASC);

CREATE TABLE `lesson4`.`schedule` (
                                      `idschedule` INT NOT NULL AUTO_INCREMENT,
                                      `film_name` VARCHAR(45) NOT NULL,
                                      `time` DATETIME NOT NULL,
                                      `price` DECIMAL NOT NULL,
                                      PRIMARY KEY (`idschedule`),
                                      INDEX `film_name_idx` (`film_name` ASC),
                                      CONSTRAINT `film_name`
                                          FOREIGN KEY (`film_name`)
                                              REFERENCES `lesson4`.`films` (`film_name`)
                                              ON DELETE CASCADE
                                              ON UPDATE CASCADE);
INSERT INTO `lesson4`.`films` (`film_name`, `film_lasting`) VALUES ('Dune', '180');
INSERT INTO `lesson4`.`films` (`film_name`, `film_lasting`) VALUES ('Mad Max', '120');
INSERT INTO `lesson4`.`films` (`film_name`, `film_lasting`) VALUES ('Iron Men', '120');
INSERT INTO `lesson4`.`films` (`film_name`, `film_lasting`) VALUES ('Home Alone', '90');

INSERT INTO `lesson4`.`schedule` (`idschedule`, `film_name`, `time`, `price`) VALUES ('1', 'Mad Max', '2022.01.22  9:00:00', '180');
INSERT INTO `lesson4`.`schedule` (`idschedule`, `film_name`, `time`, `price`) VALUES ('5', 'Mad Max', '2022.01.22 12:00:00', '220');
INSERT INTO `lesson4`.`schedule` (`idschedule`, `film_name`, `time`, `price`) VALUES ('4', 'Mad Max', '2022.01.22  15:00:00', '250');
INSERT INTO `lesson4`.`schedule` (`idschedule`, `film_name`, `time`, `price`) VALUES ('3', 'Mad Max', '2022.01.22  18:00:00', '290');
INSERT INTO `lesson4`.`schedule` (`idschedule`, `film_name`, `time`, `price`) VALUES ('2', 'Mad Max', '2022.01.22  21:00:00', '350');

CREATE TABLE `lesson4`.`tickets_sold` (
                                          `idtickets_sold` INT NOT NULL AUTO_INCREMENT,
                                          `ticket_number` INT NOT NULL,
                                          `idschedule` INT NOT NULL,
                                          PRIMARY KEY (`idtickets_sold`),
                                          UNIQUE INDEX `ticket_number_UNIQUE` (`ticket_number` ASC),
                                          INDEX `idschedule_idx` (`idschedule` ASC),
                                          CONSTRAINT `idschedule`
                                              FOREIGN KEY (`idschedule`)
                                                  REFERENCES `lesson4`.`schedule` (`idschedule`)
                                                  ON DELETE NO ACTION
                                                  ON UPDATE CASCADE);

INSERT INTO `lesson4`.`tickets_sold` (`idtickets_sold`, `ticket_number`, `idschedule`) VALUES ('1', '1', '1');
INSERT INTO `lesson4`.`tickets_sold` (`ticket_number`, `idschedule`) VALUES ('2', '1');


UPDATE `lesson4`.`schedule` SET `film_name`='Dune' WHERE `idschedule`='2';
INSERT INTO `lesson4`.`schedule` (`idschedule`, `film_name`, `time`, `price`) VALUES ('6', 'Home Alone', '2022-01-22 19:30:00', '290');

-- задание 1
SELECT N1.idschedule, N2.idschedule,
       N1.name, N1.time, N1.end_time,
       N2.name, N2.time, N2.end_time
from
    (SELECT s.idschedule, s.film_name as name, s.time, s.price, films.film_name,films.film_lasting, date_add(s.time, interval films.film_lasting minute) as end_time
     FROM schedule AS s JOIN films ON s.film_name = films.film_name) as N1
        inner join(SELECT s.idschedule, s.film_name as name, s.time, s.price, films.film_name,films.film_lasting, date_add(s.time, interval films.film_lasting minute) as end_time
                   FROM schedule AS s JOIN films ON s.film_name = films.film_name) as N2 where N1.time<N2.end_time and N1.end_time> N2.time and N1.idschedule<>N2.idschedule
                                                                                           and N1.idschedule<N2.idschedule
order by N1.time;
-- задание 2
SELECT N1.idschedule, N2.idschedule,
       N1.name, N1.time, N1.film_lasting,
       N2.name, N2.time, timediff(N2.time, N1.end_time) as break
from
    (SELECT s.idschedule, s.film_name as name, s.time, s.price, films.film_name,films.film_lasting, date_add(s.time, interval films.film_lasting minute) as end_time
     FROM schedule AS s JOIN films ON s.film_name = films.film_name) as N1
        inner join(SELECT s.idschedule, s.film_name as name, s.time, s.price, films.film_name,films.film_lasting, date_add(s.time, interval films.film_lasting minute) as end_time
                   FROM schedule AS s JOIN films ON s.film_name = films.film_name) as N2 where N1.end_time<N2.time
                                                                                           and N1.idschedule<N2.idschedule
order by break desc;
-- Задание 3
select t.film_name, count(t.s2) as total_visitors
from (SELECT schedule.time, schedule.price, schedule.film_name, schedule.idschedule as s1, tickets_sold.idschedule as s2 FROM schedule JOIN tickets_sold ON schedule.idschedule = tickets_sold.idschedule)
         as t
group by t.film_name;