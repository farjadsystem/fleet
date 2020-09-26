drop table if exists vehicle;
CREATE TABLE `vehicle`
(
    `imei`                 varchar(255) NOT NULL,
    `info_type`            varchar(45)  DEFAULT NULL,
    `region`               varchar(45)  DEFAULT NULL,
    `area`                 varchar(45)  DEFAULT NULL,
    `job_category`         varchar(255) DEFAULT NULL,
    `accountID`            varchar(255) DEFAULT NULL,
    `vehicle_type`         varchar(255) DEFAULT NULL,
    `job`                  varchar(255) DEFAULT NULL,
    `plaque_p1`            char(2)      DEFAULT NULL,
    `plaque_p2`            char(7)      DEFAULT NULL,
    `plaque_p3`            char(3)      DEFAULT NULL ,
    `plaque_p4`            char(2)      NOT NULL ,
    `vehicle_body_no`      varchar(50)  DEFAULT NULL,
    `vehicle_VIN`          varchar(255) DEFAULT NULL,
    `man_year`             int(2)       DEFAULT NULL,
    `driver_name`          varchar(255) DEFAULT NULL,
    `driver_phone`         varchar(255) DEFAULT NULL,
    `driver_national_code` varchar(255) DEFAULT NULL,
    `driver_address`       varchar(255) DEFAULT NULL,
    `driver_birth_date`    varchar(255) DEFAULT NULL,
    `driver_id_no`         int(11)      DEFAULT NULL,
    `comment`              varchar(255) DEFAULT NULL,
    `comment_date`         datetime     DEFAULT NULL,
    `status`               varchar(255) DEFAULT NULL,
    `fuel_type`            varchar(255) DEFAULT NULL,
    `fuel_rate`            varchar(255) DEFAULT NULL,
    `fuel_tank_cap`        varchar(255) DEFAULT NULL,
    `num_wheels`           int(2)       DEFAULT NULL,
    `num_axles`            int(2)       DEFAULT NULL,
    `vehicle_name`         varchar(255) DEFAULT NULL,
    `num_cylinder`         int(2)       DEFAULT NULL,
    `chassis_no`           varchar(255) DEFAULT NULL,
    `vehicle_health_cert`  varchar(255) DEFAULT NULL,
    `owner_name`           varchar(255) DEFAULT NULL,
    `owner_national_code`  varchar(255) DEFAULT NULL,
    `owner_id_no`          varchar(255) DEFAULT NULL,
    `motor_no`             varchar(255) DEFAULT NULL,
    `body_no`              varchar(255) DEFAULT NULL,
    `system_type`          varchar(45)  DEFAULT NULL,
    `owner_address`        varchar(45)  DEFAULT NULL,
    PRIMARY KEY (`imei`) USING BTREE,
    CONSTRAINT `imei` FOREIGN KEY (`imei`) REFERENCES `Device` (`uniqueID`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
