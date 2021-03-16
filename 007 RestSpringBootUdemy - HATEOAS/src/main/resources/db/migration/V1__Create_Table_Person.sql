CREATE TABLE IF NOT EXISTS `person_eq3` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `adress` varchar(250) NOT NULL,
  `first_name` varchar(150) NOT NULL,
  `gender` varchar(1) NOT NULL,
  `last_name` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
)