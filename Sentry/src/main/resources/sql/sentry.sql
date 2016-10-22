DROP TABLE IF EXISTS `programme`;
CREATE TABLE `programme` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `seed` varchar(128) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `vol` int(11) DEFAULT NULL,
  `title` varchar(32) DEFAULT NULL,
  `url` varchar(128) DEFAULT NULL,
  `server` int(11) DEFAULT NULL,
  `sdate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user2pro`;
CREATE TABLE `user2pro` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `proid` int(11) DEFAULT NULL,
  `emtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;