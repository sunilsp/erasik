DROP TABLE IF EXISTS `kriyas`.`user_roles`;
CREATE TABLE `kriyas`.`user_roles` (
  `USER_ROLE_ID` INT(10) UNSIGNED NOT NULL,
  `USER_ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `AUTHORITY` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`USER_ROLE_ID`),
  KEY `FK_user_roles` (`USER_ID`),
  CONSTRAINT `FK_user_roles` FOREIGN KEY (`USER_ID`) REFERENCES `kriyas`.`userinfo` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 
INSERT INTO kriyas.user_roles (USER_ROLE_ID, USER_ID,AUTHORITY)
VALUES (1, 1, 'ROLE_USER');