CREATE TABLE `person` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(25) NOT NULL,
  `first_name` varchar(15) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `last_name` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
)