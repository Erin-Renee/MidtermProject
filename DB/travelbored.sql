-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema travelboreddb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `travelboreddb` ;

-- -----------------------------------------------------
-- Schema travelboreddb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `travelboreddb` DEFAULT CHARACTER SET utf8 ;
USE `travelboreddb` ;

-- -----------------------------------------------------
-- Table `location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `location` ;

CREATE TABLE IF NOT EXISTS `location` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(45) NULL,
  `active` TINYINT NULL DEFAULT 1,
  `zip_code` VARCHAR(5) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `active` TINYINT NULL DEFAULT 1,
  `role` ENUM("admin", "moderator", "user") NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `email` VARCHAR(100) NOT NULL,
  `location_id` INT NOT NULL,
  `create_date` DATETIME NULL,
  `user_img_url` VARCHAR(20000) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  INDEX `fk_user_location1_idx` (`location_id` ASC),
  CONSTRAINT `fk_user_location1`
    FOREIGN KEY (`location_id`)
    REFERENCES `location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `event` ;

CREATE TABLE IF NOT EXISTS `event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(50) NULL,
  `hook` VARCHAR(200) NULL,
  `description` TEXT NULL,
  `event_time` TIME NULL,
  `event_date` DATE NULL,
  `img_url` VARCHAR(10000) NULL,
  `event_url` VARCHAR(10000) NULL,
  `active` TINYINT NOT NULL DEFAULT 1,
  `location_id` INT NOT NULL,
  `create_date` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_event_location1_idx` (`location_id` ASC),
  CONSTRAINT `fk_event_location1`
    FOREIGN KEY (`location_id`)
    REFERENCES `location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `event_detail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `event_detail` ;

CREATE TABLE IF NOT EXISTS `event_detail` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `detail_name` VARCHAR(45) NULL,
  `detail_type` VARCHAR(45) NULL,
  `active` TINYINT NULL DEFAULT 1,
  `event_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_event_details_event1_idx` (`event_id` ASC),
  CONSTRAINT `fk_event_details_event1`
    FOREIGN KEY (`event_id`)
    REFERENCES `event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `event_comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `event_comment` ;

CREATE TABLE IF NOT EXISTS `event_comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `content` TEXT NULL,
  `create_date` DATETIME NULL,
  `user_id` INT NOT NULL,
  `event_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_event_comment_user1_idx` (`user_id` ASC),
  INDEX `fk_event_comment_event1_idx` (`event_id` ASC),
  CONSTRAINT `fk_event_comment_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_event_comment_event1`
    FOREIGN KEY (`event_id`)
    REFERENCES `event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `community`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `community` ;

CREATE TABLE IF NOT EXISTS `community` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NULL,
  `hook` VARCHAR(200) NULL,
  `user_id` INT NOT NULL,
  `create_date` DATETIME NULL,
  `active` TINYINT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  INDEX `fk_group_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_group_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `group_comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `group_comment` ;

CREATE TABLE IF NOT EXISTS `group_comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `content` TEXT NULL,
  `create_date` DATETIME NULL,
  `group_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_group_comment_group1_idx` (`group_id` ASC),
  INDEX `fk_group_comment_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_group_comment_group1`
    FOREIGN KEY (`group_id`)
    REFERENCES `community` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_group_comment_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_event` ;

CREATE TABLE IF NOT EXISTS `user_event` (
  `user_id` INT NOT NULL,
  `event_id` INT NOT NULL,
  `creator` TINYINT NULL DEFAULT 0,
  `active` TINYINT NULL DEFAULT 1,
  `create_date` DATETIME NULL,
  PRIMARY KEY (`user_id`, `event_id`),
  INDEX `fk_user_has_event_event1_idx` (`event_id` ASC),
  INDEX `fk_user_has_event_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_event_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_event_event1`
    FOREIGN KEY (`event_id`)
    REFERENCES `event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_detail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_detail` ;

CREATE TABLE IF NOT EXISTS `user_detail` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_detail_name` VARCHAR(45) NULL,
  `user_detail_description` VARCHAR(500) NULL,
  `user_detail_url` VARCHAR(20000) NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_details_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_details_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `event_img`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `event_img` ;

CREATE TABLE IF NOT EXISTS `event_img` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `event_img_url` VARCHAR(20000) NULL,
  `event_img_name` VARCHAR(100) NULL,
  `event_id` INT NOT NULL,
  `create_date` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_event_img_event1_idx` (`event_id` ASC),
  CONSTRAINT `fk_event_img_event1`
    FOREIGN KEY (`event_id`)
    REFERENCES `event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS travelboreduser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'travelboreduser'@'localhost' IDENTIFIED BY 'travelboreduser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'travelboreduser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `location`
-- -----------------------------------------------------
START TRANSACTION;
USE `travelboreddb`;
INSERT INTO `location` (`id`, `city`, `active`, `zip_code`) VALUES (1, 'Denver', 1, '80237');
INSERT INTO `location` (`id`, `city`, `active`, `zip_code`) VALUES (2, 'Greenwood Village', 1, '80111');
INSERT INTO `location` (`id`, `city`, `active`, `zip_code`) VALUES (3, 'Denver', 1, '80204');
INSERT INTO `location` (`id`, `city`, `active`, `zip_code`) VALUES (4, 'Denver', 1, '80205');
INSERT INTO `location` (`id`, `city`, `active`, `zip_code`) VALUES (5, 'Colorado Springs', 1, '80910');
INSERT INTO `location` (`id`, `city`, `active`, `zip_code`) VALUES (6, 'Colorado Springs', 1, '80904');
INSERT INTO `location` (`id`, `city`, `active`, `zip_code`) VALUES (7, 'Denver', 1, '80222');
INSERT INTO `location` (`id`, `city`, `active`, `zip_code`) VALUES (8, 'Colorado Springs', 1, '80905');
INSERT INTO `location` (`id`, `city`, `active`, `zip_code`) VALUES (9, 'Englewood', 1, '80112');
INSERT INTO `location` (`id`, `city`, `active`, `zip_code`) VALUES (10, 'Denver', 1, '80203');
INSERT INTO `location` (`id`, `city`, `active`, `zip_code`) VALUES (11, 'Morrison', 1, '80465');
INSERT INTO `location` (`id`, `city`, `active`, `zip_code`) VALUES (12, 'Breckenridge', 1, '80424');

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `travelboreddb`;
INSERT INTO `user` (`id`, `username`, `password`, `active`, `role`, `first_name`, `last_name`, `email`, `location_id`, `create_date`, `user_img_url`) VALUES (2, 'LoneTraveler', 'lonetraveler', 1, 'user', 'Jack', 'Ryan', 'jackryan@gmail.com', 2, '2020-01-24', 'https://skilldistillery.com/wp-content/uploads/2017/01/RobRPicSDWEB-250x250.jpg');
INSERT INTO `user` (`id`, `username`, `password`, `active`, `role`, `first_name`, `last_name`, `email`, `location_id`, `create_date`, `user_img_url`) VALUES (1, 'TravisR', 'admin', 1, 'admin', 'Travis', 'Roberts', 'travis.c.roberts35@gmail.com', 1, '2020-01-30', 'https://scontent.fapa1-1.fna.fbcdn.net/v/t1.0-9/1503400_2558642324082_138437503_n.jpg?_nc_cat=101&_nc_ohc=MnurFJGlohAAX8TVbjx&_nc_ht=scontent.fapa1-1.fna&oh=98565d423eaa629d981abc845567815a&oe=5EC7675F');
INSERT INTO `user` (`id`, `username`, `password`, `active`, `role`, `first_name`, `last_name`, `email`, `location_id`, `create_date`, `user_img_url`) VALUES (3, 'Admin', 'secretpassword', 1, 'admin', 'Admin', '', 'admin@travelbored.com', 2, '2020-01-31', 'https://cdn0.iconfinder.com/data/icons/man-user-human-profile-avatar-person-business/100/10B-1User-512.png');

COMMIT;


-- -----------------------------------------------------
-- Data for table `event`
-- -----------------------------------------------------
START TRANSACTION;
USE `travelboreddb`;
INSERT INTO `event` (`id`, `title`, `hook`, `description`, `event_time`, `event_date`, `img_url`, `event_url`, `active`, `location_id`, `create_date`) VALUES (2, 'Beer & Food Tour of the Rino Arts District', 'On this three-hour food and beer adventure, taste some of the best bites and brews Denver has to offer and explore the RiNo Arts District.', 'We’ll start and end inside the beautiful Denver Central Market, a hub for gourmet vendors and a popular hang-out spot for Denver locals. Along the way, we’ll walk to five restaurants and try delicious local dishes with optional beer pairings. You’ll taste authentic wood-fired pizza, fresh sushi-grade poke with salmon, Mexican tacos from one of Denver’s top chefs, and the best selling ice cream from one of Food and Wine Magazine’s top ice creameries in the country.', '14:00', '2020-01-31', 'https://assets.simpleviewinc.com/simpleview/image/fetch/c_fill,h_465,q_50,w_698/https://assets.simpleviewinc.com/simpleview/image/upload/crm/denver/DeliciousDenver_238148EA-D3FE-4D3D-9149BC895E64007D_62ca1b5f-a934-4198-8da780e781d2eba6.jpg', 'https://www.deliciousdenverfoodtours.com/foodandbeertour/', 1, 4, '2020-01-30');
INSERT INTO `event` (`id`, `title`, `hook`, `description`, `event_time`, `event_date`, `img_url`, `event_url`, `active`, `location_id`, `create_date`) VALUES (3, 'Beer Here! Brewing the New West', 'A river of beer flows through Colorados past.', ' Come explore our brewing past, present, and future. See beer-brewing equipment from then to now, a massive bottle-breaker from Prohibition days, the nations first aluminum beer cans, and a wealth of other artifacts from our states hoppy history.', '10:00', '2020-01-31', 'https://assets.simpleviewinc.com/simpleview/image/fetch/c_fill,h_465,q_50,w_698/https://assets.simpleviewinc.com/simpleview/image/upload/crm/denver/HC_beerHere_sm-010_4bd3234c-a11f-e1f8-475436eef17c3eff.png', 'https://www.historycolorado.org/exhibit/beer-here', 1, 10, '2020-01-30');
INSERT INTO `event` (`id`, `title`, `hook`, `description`, `event_time`, `event_date`, `img_url`, `event_url`, `active`, `location_id`, `create_date`) VALUES (4, 'Icelantics Winter on the Rocks', 'AEG Presents is thrilled to announce ICELANTICS WINTER ON THE ROCKS FT. ZHU live at Red Rocks Amphitheatre on Friday, January 31st, 2020.', 'Tickets to this show are available at the Denver Coliseum box office from 11 a.m. – 3 p.m. every Saturday. All tickets sold at the Coliseum box office require a Flash Seats account along with a valid ID matching the account profile.  Download the Red Rocks App before your visit. From purchasing and managing your tickets, to park and venue maps, tips, weather alerts and special offers, the official Red Rocks app has everything you need for an unforgettable concert experience.', '18:45', '2020-01-31', 'https://assets.simpleviewinc.com/simpleview/image/fetch/q_75/https://assets.simpleviewinc.com/simpleview/image/upload/crm/denver/icelantic-s-winter-on-the-rocks-ft-zhu-tickets_01-31-20_18_5dc9f81acb4730_2dda1573-fb8f-a3db-a02d226ce425f498.jpg', 'https://www.redrocksonline.com/events/detail/icelantics-winter-on-the-rocks-ft-zhu', 1, 11, '2020-01-30');
INSERT INTO `event` (`id`, `title`, `hook`, `description`, `event_time`, `event_date`, `img_url`, `event_url`, `active`, `location_id`, `create_date`) VALUES (5, 'Breckenridge Mardis Gras', 'Each year, New Orleans visitors and Mardi Gras lovers take over Breckenridge with a parade, street party, masks, boas, music, and revelry to commemorate the carnival season. ', 'This year, we are thrilled to be bringing in some of the most seasoned and highly respected musicians from New Orleans to feature a truly authentic New Orleans Mardi Gras Celebration!', '17:30', '2020-02-25', 'https://1ln40d4elc1oqb3b4do821oz-wpengine.netdna-ssl.com/wp-content/uploads/2018/01/dog-in-costume-during-breckenridge-mardi-gras-214x300.jpg', 'https://www.gobreck.com/event/mardi-gras/', 1, 12, '2020-01-30');
INSERT INTO `event` (`id`, `title`, `hook`, `description`, `event_time`, `event_date`, `img_url`, `event_url`, `active`, `location_id`, `create_date`) VALUES (6, 'Bighorn Sheep Day Festival', 'Kids of all ages can see our state mammal in its natural habitat, learn fascinating animal facts and make crafts.', 'Join us for the 15th Annual Bighorn Sheep Day. Look for bighorns in their natural habitat through our high-power telescopes. Bighorn presentations and door prizes. Guided nature walks. Children‘s activities and crafts. Live Zoo animals. No-charge - all activities are FREE! Don‘t forget your binoculars. It‘s a full day of free family fun!', '10:00', '2020-02-15', 'https://cdn.britannica.com/93/6493-004-9A40A729/Bighorn-sheep.jpg', 'https://www.visitcos.com/events-calendar/annual/bighorn-sheep-day/', 1, 6, '2020-01-30');

COMMIT;


-- -----------------------------------------------------
-- Data for table `community`
-- -----------------------------------------------------
START TRANSACTION;
USE `travelboreddb`;
INSERT INTO `community` (`id`, `title`, `hook`, `user_id`, `create_date`, `active`) VALUES (1, 'SD24 Group', 'New slack!!!!', 1, '2020-01-30', 1);
INSERT INTO `community` (`id`, `title`, `hook`, `user_id`, `create_date`, `active`) VALUES (2, 'Beer', 'Talk about your favorite beer(s)!', 1, '2020-01-30', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `group_comment`
-- -----------------------------------------------------
START TRANSACTION;
USE `travelboreddb`;
INSERT INTO `group_comment` (`id`, `content`, `create_date`, `group_id`, `user_id`) VALUES (1, 'First post!!!!!', '2020-01-30', 1, 1);
INSERT INTO `group_comment` (`id`, `content`, `create_date`, `group_id`, `user_id`) VALUES (2, 'My favorite beer is Boulevard...how about you guys?', '2020-01-30', 2, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user_event`
-- -----------------------------------------------------
START TRANSACTION;
USE `travelboreddb`;
INSERT INTO `user_event` (`user_id`, `event_id`, `creator`, `active`, `create_date`) VALUES (1, 2, 1, 1, '2020-01-30');
INSERT INTO `user_event` (`user_id`, `event_id`, `creator`, `active`, `create_date`) VALUES (1, 3, 1, 1, '2020-01-30');

COMMIT;


-- -----------------------------------------------------
-- Data for table `user_detail`
-- -----------------------------------------------------
START TRANSACTION;
USE `travelboreddb`;
INSERT INTO `user_detail` (`id`, `user_detail_name`, `user_detail_description`, `user_detail_url`, `user_id`) VALUES (1, 'middle name', 'sd test middle', NULL, 1);

COMMIT;

