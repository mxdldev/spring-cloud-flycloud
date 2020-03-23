-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: spring_security_oauth2
-- ------------------------------------------------------
-- Server version	5.7.22-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `news_detail`
--

DROP TABLE IF EXISTS `news_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `typeid` int(11) DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `content` text COLLATE utf8_bin,
  `addtime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news_detail`
--

LOCK TABLES `news_detail` WRITE;
/*!40000 ALTER TABLE `news_detail` DISABLE KEYS */;
INSERT INTO `news_detail` VALUES (1,0,'后移动互联网时代我的一些思考','这篇文章本来是写在年前的，题目太大不好下手，加之年后公司上了一个新项目一直很忙，酝酿了好长时间，一直拖到了现在，今天也终于发表了，后移动时代我的一些思考，新时代下，我们不能只顾低头拉车，更要懂得抬头看路。就在半个多月前的2月15号，在滴滴年度员工大会上程维亲自宣布裁员2000人，而2月19号京东也宣布裁员10%的副总裁级别的高管，而就在昨天3月8日下午，熊猫直播在官方微博上宣布将关闭服务器，证实了此前有关熊猫直播倒闭的传言，等等这些消息只表明一个问题，移动互联网寒冬真的来了。其实从从去年开始一直就有各种消息爆出移动互联网行业的不景气，一些小公司由于投资方的撤资，资金链断裂，而导致的裁员、倒闭的情况，出现的就更早了','2019-06-15 21:42:36'),(2,0,'SpringCloud微服务架构在移动后端开发中的应用与研究','年前我写了一篇文章：Android组件化方案最佳实践，主要介绍了Android客户端框架FlyTour的使用，工程的架构为组件化，模块编码架构为MVP,文章地址为：https://blog.csdn.net/geduo_83/article/details/86604852，有的网友说现在自己一个人在做一个Android的项目，自己不会后端开发，问现在有没有好点的后端开源的架子给推荐一下，就自己稍加修改就能上手用的那种，为此我在网上找了一圈儿，还真没发现有什么好的后端架子，也许是我还没有发现，能不能自己搭建一个通用的后台服务端的架子？我想也很有必要，记得《Android第一行代码》作者郭霖有一句很著名的话“当你在感叹，假如有这么一个东西就好了的时候，请注意，这是你的机会”，正式因为这句话，我决定自己搭建一套后端服务的架子，希望对有需要的同学有所帮助','2019-06-15 21:42:36'),(3,0,'浅谈单一结构体项目的组件化改造','浅谈单一结构体项目的组件化改造\",content:\"昨天晚上一年一度的315晚会又来了，今年虽然没有哪家大公司上榜，但是曝光了一些黑心小企业，我们平时用的塑料盆、塑料袋、孩子的塑料玩具有可能都是用医疗废弃物，如输液袋、输液管、一次性注射器、血袋等加工而成的，还有平日孩子们抢着买的辣条这种混合了十几中添加剂的垃圾食品的生产环境着实让人辣眼睛，我们无比惊叹这些企业为了金钱、利益没有一点道德底线，等待他们的将是法律的制裁。好了，我们言归正传，项目功能移植可以说在日常开发中很多时候都会遇到，把A项目中的几个功能移植到B项目当中，最近工作中就有这样一个需求，需要将公司的一个老项目的几个功能模块移植到新项目当中，一开始以为工作量不是很大，但是随着改造工作的深入，不得不改变原有的移植改造方案','2019-06-15 21:42:36'),(4,0,'开发杂谈：Android移动应用架构发展简史','好了，我们言归正传，我们在前面几篇文章谈到了一些项目架构的问题，年前写了一篇“Android组件化最佳实践”，年后写了一篇“浅谈单一结构体项目的组件化改造”，我们提到了单一结构项目里，结构混乱，层次不清，有些模块同一功能解决方案不统一、有了新需求只是在原有项目上不断的砌代码罢了。长此以往，整个项目就是铁板一块，为后期的项目维护和扩展造成了极大的困难。我们在软件开发的时候，在做一个项目之前，架构师做工作就是搭项目框架，这是一个前提工作，给整个项目制定开发标准，开发规范，如果没有规范，项目可以搞起来吗？当然可以，就是个开发人员各行其是，最后的结果就是，项目做完了，整个项目结构混乱，层次不清。反之，一旦形成自己的一套框架体系，就可以长期使用，甚至成为整个公司的一套开发标准，大大提高后期的项目开发效率，来了新项目就直接可以在新项目中使用，而把主要的精力放在业务功能的实现上','2019-06-15 21:42:36'),(5,0,'Android事件分发机制的探索与发现之View篇','关于Android事件传递机制的文章在前面也零零散散的写过两篇，当时也是时间有限，也没有过多的去完善匆匆就发出去了。因为Android事件分发机制是整个Android系统的难点也是重点，说它是难点是因为触摸事件的流转流程错综复杂，前一阵子在有个技术群里面很多人都说，事件分发这块自己也是学习了好多次，但是都是过一阵子，对事件的流转流程又忘了，记不住，学了又忘，忘了又学，出现这种情况就是对事件流转流程理解不深刻，对书上的流程图死记硬背导致的，有些书上甚至出现流程错误的问题，真是误人子弟。','2019-06-15 21:42:36'),(6,0,'fffffff','ffffff fsfdasdfa ','2019-07-06 00:05:00'),(7,1,'6666','66666666','2019-07-06 03:37:25'),(8,1,'111','6666','2019-07-06 03:44:14'),(9,11,'666','77777','2019-07-06 04:37:23'),(10,11,'888','8888','2019-07-06 04:37:57'),(11,12,'8888','00000','2019-07-06 06:30:52'),(12,7,'5555','rtetertewtewtewt','2020-03-14 12:06:39'),(13,8,'7777','ryrtyreyreyreytr','2020-03-15 00:32:12'),(14,4,'yyyy','yyyyyy ','2020-03-19 18:35:31'),(15,4,'0000','00000','2020-03-19 18:35:47'),(16,4,'666','666666','2020-03-19 18:36:35');
/*!40000 ALTER TABLE `news_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news_type`
--

DROP TABLE IF EXISTS `news_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `typename` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news_type`
--

LOCK TABLES `news_type` WRITE;
/*!40000 ALTER TABLE `news_type` DISABLE KEYS */;
INSERT INTO `news_type` VALUES (0,'2019-06-23 02:12:00','移动开发'),(1,'2019-06-23 02:12:00','大数据'),(2,'2019-06-23 02:12:00','人工智能'),(3,'2019-06-23 02:12:00','区块链'),(4,'2020-03-19 10:35:17','6666');
/*!40000 ALTER TABLE `news_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` text COLLATE utf8_bin,
  `password` text COLLATE utf8_bin,
  `age` int(11) DEFAULT NULL,
  `salary` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'mxdl','$2a$10$KUX7ttoSg6ImdwHKc3bu6u4KoHab5hwKn8wWZ6ycvdOv5C4dE/AUy',0,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-19 18:45:21
