How to Run

#step 1
CREATE SCHEMA `marrymeal_db` DEFAULT CHARACTER SET utf8 ;

#step 2
Developed Entity & update application.prorperties

#step 3
Run Springboot application & will create the tables in your database.

#step 4 - insert data into Role Table
INSERT INTO `marrymeal_db`.`role` (`id`, `description`, `name`) VALUES ('1', 'for admin', 'Administrator');
INSERT INTO `marrymeal_db`.`role` (`id`, `description`, `name`) VALUES ('2', 'for user', 'Member');
INSERT INTO `marrymeal_db`.`role` (`id`, `description`, `name`) VALUES ('3', 'for volunteer as rider', 'Volunteer');
INSERT INTO `marrymeal_db`.`role` (`id`, `description`, `name`) VALUES ('4', 'for partner', 'Partner');

#step 5 - Develop Repository for each entity

#step 6 - insert data into marrymeal_db table and User Role Table
INSERT INTO `marrymeal_db`.`user` (`id`, `name`, `password`, `user_name`) VALUES ('1', 'admin', 'admin', 'admin');
INSERT INTO `marrymeal_db`.`user_role` (`user_id`, `role_id`) VALUES ('1', '1');
INSERT INTO `marrymeal_db`.`user_role` (`user_id`, `role_id`) VALUES ('1', '2'); // dont run (insert) this code
INSERT INTO `marrymeal_db`.`user_role` (`user_id`, `role_id`) VALUES ('1', '3'); // Dont run this code
INSERT INTO `marrymeal_db`.`user_role` (`user_id`, `role_id`) VALUES ('1', '4');


#step 7 - Developed Spring Security. 

#step 8 - Developed the required controller, service classes and JSP pages based on your scenario.

#step 9 - Run as application & check On Browser
http://localhost:8080/
