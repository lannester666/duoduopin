USE DuoDuoPin;

DROP TABLE IF EXISTS `pic`;
DROP TABLE IF EXISTS `credit`;
DROP TABLE IF EXISTS `ShareBillPic`;
CREATE TABLE pic (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) DEFAULT NULL,
    `url` varchar(255) DEFAULT NULL,
    `user_id`     INT UNSIGNED           NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
        ON DELETE CASCADE ON UPDATE CASCADE,
    KEY (`user_id`)
);
CREATE TABLE credit(
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `low_weight_point` int(11) NOT NULL,
    `common_weight_point` int(11) NOT NULL ,
    `high_weight_point` int(11) not null ,
    `average_point` FLOAT NOT NULL,
    `total_number` int(11) NOT NULL ,
    `user_id`     INT UNSIGNED           NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
        ON DELETE CASCADE ON UPDATE CASCADE ,
    KEY (`user_id`)
);
CREATE TABLE ShareBillPic(
    `id` int(11) NOT NULL auto_increment,
    `bill_id` int unsigned not null ,
    `url` varchar(255) default null,
    primary key (`id`),
    foreign key (`bill_id`) references share_bill (`bill_id`)
        on delete cascade on update cascade ,
    key  (`bill_id`)
);