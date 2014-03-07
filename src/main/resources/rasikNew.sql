CREATE DATABASE  IF NOT EXISTS `rasiknew` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `rasiknew`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: rasiknew
-- ------------------------------------------------------
-- Server version	5.6.15-log

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
-- Table structure for table `authors`
--

DROP TABLE IF EXISTS `authors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authors` (
  `authorId` int(11) NOT NULL AUTO_INCREMENT,
  `EnglishName` varchar(120) DEFAULT NULL,
  `MarathiName` varchar(350) DEFAULT NULL,
  `Address1` varchar(135) DEFAULT NULL,
  `Address2` varchar(135) DEFAULT NULL,
  `Address3` varchar(35) DEFAULT NULL,
  `PINCode` varchar(15) DEFAULT NULL,
  `City` varchar(50) DEFAULT NULL,
  `Country` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Phone1` varchar(15) DEFAULT NULL,
  `Phone2` varchar(15) DEFAULT NULL,
  `Fax` varchar(15) DEFAULT NULL,
  `Mobile` varchar(15) DEFAULT NULL,
  `Prefix` varchar(15) DEFAULT NULL,
  `DateOfBirth` date DEFAULT NULL,
  `ExpiredDate` date DEFAULT NULL,
  `Photo` varchar(55) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`authorId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `awarddetail`
--

DROP TABLE IF EXISTS `awarddetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `awarddetail` (
  `AwardDetailId` int(11) NOT NULL AUTO_INCREMENT,
  `AwardDetailsEnglish` varchar(240) DEFAULT NULL,
  `DateOfAward` date DEFAULT NULL,
  `AwardDetailsMarathi` varchar(345) DEFAULT NULL,
  PRIMARY KEY (`AwardDetailId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `bindingtype`
--

DROP TABLE IF EXISTS `bindingtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bindingtype` (
  `BindingTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `BindingTypeName` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`BindingTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `CategoryId` int(11) NOT NULL AUTO_INCREMENT,
  `CategoryHeadEnglish` varchar(50) DEFAULT NULL,
  `CategoryHeadMarathi` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`CategoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `currency`
--

DROP TABLE IF EXISTS `currency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `currency` (
  `CurrencyId` int(2) NOT NULL AUTO_INCREMENT,
  `CurrencyName` varchar(50) DEFAULT NULL,
  `CurrencyRate` double DEFAULT NULL,
  PRIMARY KEY (`CurrencyId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `CustomerId` int(11) NOT NULL AUTO_INCREMENT,
  `EnglishName` varchar(120) DEFAULT NULL,
  `MarathiName` varchar(350) DEFAULT NULL,
  `Address1` varchar(135) DEFAULT NULL,
  `Address2` varchar(135) DEFAULT NULL,
  `Address3` varchar(135) DEFAULT NULL,
  `PINCode` varchar(15) DEFAULT NULL,
  `City` varchar(50) DEFAULT NULL,
  `Country` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Phone1` varchar(15) DEFAULT NULL,
  `Phone2` varchar(15) DEFAULT NULL,
  `Fax` varchar(15) DEFAULT NULL,
  `Mobile` varchar(15) DEFAULT NULL,
  `ContactPerson` varchar(130) DEFAULT NULL,
  `customerTypeId` int(11) DEFAULT '0',
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  `state` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CustomerId`),
  KEY `fk_customercustomerTypeId` (`customerTypeId`),
  CONSTRAINT `fk_customercustomerType` FOREIGN KEY (`customerTypeId`) REFERENCES `customertype` (`customertypeId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `customer_roles`
--

DROP TABLE IF EXISTS `customer_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_roles` (
  `customer_rolesid` int(11) NOT NULL AUTO_INCREMENT,
  `CustomerId` int(11) DEFAULT NULL,
  `Authority` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`customer_rolesid`),
  KEY `fk_customer_roles_idx` (`Authority`),
  KEY `fk_customer_roles_idx1` (`CustomerId`),
  CONSTRAINT `fk_customer_roles` FOREIGN KEY (`CustomerId`) REFERENCES `customer` (`CustomerId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `customertype`
--

DROP TABLE IF EXISTS `customertype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customertype` (
  `customertypeId` int(11) NOT NULL AUTO_INCREMENT,
  `customerType` varchar(45) DEFAULT NULL,
  `customertypeDesc` varchar(245) DEFAULT NULL,
  PRIMARY KEY (`customertypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `discounts`
--

DROP TABLE IF EXISTS `discounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discounts` (
  `DiscountId` int(11) NOT NULL AUTO_INCREMENT,
  `Description` varchar(50) DEFAULT NULL,
  `DiscountPer` double DEFAULT '0',
  `DiscountEndDate` datetime DEFAULT NULL,
  `MaxSaleDiscountPercentage` float DEFAULT NULL,
  `PurchaseDiscount` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`DiscountId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `itemlanguage`
--

DROP TABLE IF EXISTS `itemlanguage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemlanguage` (
  `LanguageId` int(11) NOT NULL AUTO_INCREMENT,
  `LanguageName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`LanguageId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `items` (
  `ItemId` int(11) NOT NULL AUTO_INCREMENT,
  `UserBookCode` varchar(15) DEFAULT NULL,
  `EnglishName` varchar(120) DEFAULT NULL,
  `MarathiName` varchar(350) DEFAULT NULL,
  `PublisherCode` int(11) DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `QtyInHand` int(11) DEFAULT NULL,
  `MinLevel` int(11) DEFAULT NULL,
  `MaxLevel` int(11) DEFAULT NULL,
  `MaxSalePrice` double DEFAULT NULL,
  `PublMonth` tinyint(4) DEFAULT NULL,
  `PublYear` int(4) DEFAULT NULL,
  `ItemTypeId` int(11) DEFAULT NULL,
  `LanguageId` int(11) DEFAULT NULL,
  `ISBNNo` varchar(13) DEFAULT NULL,
  `NoOfPages` int(11) DEFAULT NULL,
  `BindingTypeId` int(11) DEFAULT NULL,
  `DiscountId` int(11) DEFAULT NULL,
  `Description` varchar(1245) DEFAULT NULL,
  `ItemCoverImage` varchar(145) DEFAULT NULL,
  `EbookFile` varchar(145) DEFAULT NULL,
  `AudioBookFile` varchar(145) DEFAULT NULL,
  `printStatus` varchar(45) DEFAULT NULL,
  `MaxSalePriceEndDate` date DEFAULT NULL,
  `MaxSaleDiscountPrecent` double DEFAULT NULL,
  `MaxOwDiscountEndDate` date DEFAULT NULL,
  `PurchaseDiscountPercent` double DEFAULT NULL,
  `MaxInwDiscountEndDate` date DEFAULT NULL,
  `itemseditionId` int(11) DEFAULT NULL,
  `DiscountedPrice` double DEFAULT NULL,
  `DiscountedPriceEndDate` date DEFAULT NULL,
  `PurchasePrice` double DEFAULT NULL,
  `MaxSaleDiscountPrice` double DEFAULT NULL,
  `MaxOwDiscountPrecent` double DEFAULT NULL,
  PRIMARY KEY (`ItemId`),
  KEY `fk_itemItemTypeCode` (`ItemTypeId`),
  KEY `fk_itemBindingTypeId` (`BindingTypeId`),
  KEY `fk_itemLanguageId` (`LanguageId`),
  KEY `fk_itemDiscountId` (`DiscountId`),
  KEY `fk_itemsitemsEditionId_idx` (`itemseditionId`),
  CONSTRAINT `fk_itemBindingTypeId` FOREIGN KEY (`BindingTypeId`) REFERENCES `bindingtype` (`BindingTypeId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_itemDiscountId` FOREIGN KEY (`DiscountId`) REFERENCES `discounts` (`DiscountId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_itemItemTypeCode` FOREIGN KEY (`ItemTypeId`) REFERENCES `itemtype` (`ItemTypeId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_itemLanguageId` FOREIGN KEY (`LanguageId`) REFERENCES `itemlanguage` (`LanguageId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_itemsitemsEditionId` FOREIGN KEY (`itemseditionId`) REFERENCES `itemsedition` (`itemsEditionid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `itemsauthors`
--

DROP TABLE IF EXISTS `itemsauthors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemsauthors` (
  `itemAuthorId` int(11) NOT NULL AUTO_INCREMENT,
  `itemId` int(11) NOT NULL,
  `AuthorId` int(11) NOT NULL,
  PRIMARY KEY (`itemAuthorId`),
  KEY `fk_itemAuthorAuthorId` (`AuthorId`),
  KEY `fk_itemAuthoritemId` (`itemId`),
  CONSTRAINT `fk_itemAuthorAuthorId` FOREIGN KEY (`AuthorId`) REFERENCES `authors` (`authorId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_itemAuthoritemId` FOREIGN KEY (`itemId`) REFERENCES `items` (`ItemId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `itemsawarddetail`
--

DROP TABLE IF EXISTS `itemsawarddetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemsawarddetail` (
  `itemsAwarddetailId` int(11) NOT NULL AUTO_INCREMENT,
  `itemId` int(11) NOT NULL,
  `AwarddetailId` int(11) NOT NULL,
  PRIMARY KEY (`itemsAwarddetailId`),
  KEY `fk_itemAwarddetailAwarddetailId` (`AwarddetailId`),
  KEY `fk_itemAwarddetailitemId` (`itemId`),
  CONSTRAINT `fk_itemAwarddetailAwarddetailId` FOREIGN KEY (`AwarddetailId`) REFERENCES `awarddetail` (`AwardDetailId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_itemAwarddetailitemId` FOREIGN KEY (`itemId`) REFERENCES `items` (`ItemId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `itemscategory`
--

DROP TABLE IF EXISTS `itemscategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemscategory` (
  `itemsCategoryId` int(11) NOT NULL AUTO_INCREMENT,
  `itemId` int(11) NOT NULL,
  `CategoryId` int(11) NOT NULL,
  PRIMARY KEY (`itemsCategoryId`),
  KEY `fk_itemCategoryCategoryId` (`CategoryId`),
  KEY `fk_itemCategoryitemId` (`itemId`),
  CONSTRAINT `fk_itemCategoryCategoryId` FOREIGN KEY (`CategoryId`) REFERENCES `category` (`CategoryId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_itemCategoryitemId` FOREIGN KEY (`itemId`) REFERENCES `items` (`ItemId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `itemscustomerrating`
--

DROP TABLE IF EXISTS `itemscustomerrating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemscustomerrating` (
  `iditemRatingId` int(11) NOT NULL,
  `itemRatingStarValue` int(11) DEFAULT NULL,
  `itemRatingDescription` varchar(1045) DEFAULT NULL,
  `itemId` int(11) NOT NULL,
  `CustomerId` int(11) NOT NULL,
  PRIMARY KEY (`iditemRatingId`),
  KEY `fk_itemRatingitemId` (`itemId`),
  KEY `fk_itemRatingCustomerId` (`CustomerId`),
  CONSTRAINT `fk_itemRatingCustomerId` FOREIGN KEY (`CustomerId`) REFERENCES `customer` (`CustomerId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_itemRatingitemId` FOREIGN KEY (`itemId`) REFERENCES `items` (`ItemId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `itemsedition`
--

DROP TABLE IF EXISTS `itemsedition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemsedition` (
  `itemsEditionid` int(11) NOT NULL AUTO_INCREMENT,
  `itemsedition` varchar(45) DEFAULT NULL,
  `itemseditiondesc` varchar(145) DEFAULT NULL,
  PRIMARY KEY (`itemsEditionid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `itemspublsuppl`
--

DROP TABLE IF EXISTS `itemspublsuppl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemspublsuppl` (
  `itemspublsupplId` int(11) NOT NULL AUTO_INCREMENT,
  `itemId` int(11) NOT NULL,
  `PubSupId` int(11) NOT NULL,
  PRIMARY KEY (`itemspublsupplId`),
  KEY `fk_itemspublsupplitemId` (`itemId`),
  KEY `fk_itemspublsupplpublsupplId` (`PubSupId`),
  CONSTRAINT `fk_itemspublsupplitemId` FOREIGN KEY (`itemId`) REFERENCES `items` (`ItemId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_itemspublsupplpublsupplId` FOREIGN KEY (`PubSupId`) REFERENCES `publsuppl` (`PubSupId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `itemsstockcenter`
--

DROP TABLE IF EXISTS `itemsstockcenter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemsstockcenter` (
  `itemsStockCenterId` int(11) NOT NULL AUTO_INCREMENT,
  `itemId` int(11) NOT NULL,
  `StockCenterId` int(11) NOT NULL,
  `RackLocation` varchar(45) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`itemsStockCenterId`),
  KEY `fk_itemsStockCenteritemId` (`itemId`),
  KEY `fk_itemsStockCenterStockCenterId` (`StockCenterId`),
  CONSTRAINT `fk_itemsStockCenteritemId` FOREIGN KEY (`itemId`) REFERENCES `items` (`ItemId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_itemsStockCenterStockCenterId` FOREIGN KEY (`StockCenterId`) REFERENCES `stockcenter` (`StockCenterId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `itemtype`
--

DROP TABLE IF EXISTS `itemtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemtype` (
  `ItemTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `Description` varchar(50) DEFAULT NULL,
  `VatPerc` double DEFAULT NULL,
  PRIMARY KEY (`ItemTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `publsuppl`
--

DROP TABLE IF EXISTS `publsuppl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `publsuppl` (
  `PubSupId` int(11) NOT NULL AUTO_INCREMENT,
  `EnglishName` varchar(120) DEFAULT NULL,
  `MarathiName` varchar(350) DEFAULT NULL,
  `Address1` varchar(135) DEFAULT NULL,
  `Address2` varchar(135) DEFAULT NULL,
  `Address3` varchar(135) DEFAULT NULL,
  `PINCode` varchar(15) DEFAULT NULL,
  `City` varchar(50) DEFAULT NULL,
  `Country` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Phone1` varchar(15) DEFAULT NULL,
  `Phone2` varchar(15) DEFAULT NULL,
  `Fax` varchar(15) DEFAULT NULL,
  `Mobile` varchar(15) DEFAULT NULL,
  `Website` varchar(115) DEFAULT NULL,
  `ContactPerson` varchar(130) DEFAULT NULL,
  PRIMARY KEY (`PubSupId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `stockcenter`
--

DROP TABLE IF EXISTS `stockcenter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stockcenter` (
  `StockCenterId` int(11) NOT NULL AUTO_INCREMENT,
  `StockCenterHead` varchar(30) DEFAULT NULL,
  `Address1` varchar(130) DEFAULT NULL,
  `Address2` varchar(130) DEFAULT NULL,
  `Address3` varchar(130) DEFAULT NULL,
  `Phone1` varchar(15) DEFAULT NULL,
  `Phone2` varchar(15) DEFAULT NULL,
  `ContactPerson` varchar(130) DEFAULT NULL,
  `CenterCount` int(11) DEFAULT NULL,
  `CanCreateInvoice` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`StockCenterId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `translation`
--

DROP TABLE IF EXISTS `translation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `translation` (
  `translationId` int(11) NOT NULL AUTO_INCREMENT,
  `translatedfrom` varchar(45) DEFAULT NULL,
  `originalname` varchar(45) DEFAULT NULL,
  `originalauthor` varchar(85) DEFAULT NULL,
  `itemsId` int(11) DEFAULT NULL,
  PRIMARY KEY (`translationId`),
  KEY `fk_itemsTranslationId` (`itemsId`),
  CONSTRAINT `fk_itemsTranslationId` FOREIGN KEY (`itemsId`) REFERENCES `items` (`ItemId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `transporter`
--

DROP TABLE IF EXISTS `transporter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transporter` (
  `TransporterId` int(11) NOT NULL AUTO_INCREMENT,
  `EnglishName` varchar(130) DEFAULT NULL,
  `MarathiName` varchar(130) DEFAULT NULL,
  `Address1` varchar(130) DEFAULT NULL,
  `Address2` varchar(130) DEFAULT NULL,
  `Address3` varchar(130) DEFAULT NULL,
  `Phone1` varchar(15) DEFAULT NULL,
  `Phone2` varchar(15) DEFAULT NULL,
  `ContactPerson` varchar(130) DEFAULT NULL,
  `TransportTypeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`TransporterId`),
  KEY `fk_transporterTypeId` (`TransportTypeId`),
  CONSTRAINT `fk_transporterTypeId` FOREIGN KEY (`TransportTypeId`) REFERENCES `transporttypes` (`TransportTypeId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `transporttypes`
--

DROP TABLE IF EXISTS `transporttypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transporttypes` (
  `TransportTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `TransportType` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`TransportTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userinfo` (
  `USER_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ADDRESS` varchar(255) NOT NULL,
  `CREATED_DATE` datetime NOT NULL,
  `NAME` varchar(45) NOT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-03-07 10:16:43
