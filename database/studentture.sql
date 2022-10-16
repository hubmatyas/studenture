CREATE DATABASE IF NOT EXISTS `studentture`;

DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `name` varchar(32) NOT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `subject` WRITE;
ALTER TABLE `subject` DISABLE KEYS;
INSERT INTO `subject` (`id`, `name`) VALUES (1,'Math');
INSERT INTO `subject` (`id`, `name`) VALUES (2, 'English');
INSERT INTO `subject` (`id`, `name`) VALUES (3, 'Programming');
ALTER TABLE `subject` ENABLE KEYS;
UNLOCK TABLES;