-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 14, 2021 at 06:19 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `invest`
--

-- --------------------------------------------------------

--
-- Table structure for table `invest1`
--

CREATE TABLE `invest1` (
  `investorID` int(11) NOT NULL,
  `investorName` varchar(100) NOT NULL,
  `Mail` varchar(100) NOT NULL,
  `ProjectCode` varchar(100) NOT NULL,
  `ProjectName` varchar(100) NOT NULL,
  `InvestAmount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `invest1`
--

INSERT INTO `invest1` (`investorID`, `investorName`, `Mail`, `ProjectCode`, `ProjectName`, `InvestAmount`) VALUES
(1, 'Anne', 'Anne@gmail.com', '2034', 'Management', 300000),
(3, 'Shon', 'Shon@yahoo.com', '2013', 'LeaveManage', 75000),
(4, 'Alwis', 'Alwis@yahoo.com', '2020', 'HotelManage', 1000000),
(5, 'John', 'John@gmail.com', '2040', 'BillManagement', 960000),
(6, 'Raj', 'Raj@gmail.com', '2080', 'BillManagement', 70000),
(7, 'Anne', 'Anne@gmail.com', '2034', 'Management', 900000),
(8, 'Anne', 'Anne@gmail.com', '2034', 'Management', 900000),
(9, 'Anne', 'Anne@gmail.com', '2034', 'Management', 900000),
(10, 'Anne', 'Anne@gmail.com', '2034', 'Management', 900000),
(11, 'Taki', 'Taki@gmail.com', '2020', 'SalesManagement', 12000),
(12, 'Jenifer', 'Jenifer@yahoo.com', '5400', 'TimeTableManagement', 45000),
(13, 'Jenifer', 'Jenifer@yahoo.com', '5400', 'TimeTableManagement', 9000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `invest1`
--
ALTER TABLE `invest1`
  ADD PRIMARY KEY (`investorID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `invest1`
--
ALTER TABLE `invest1`
  MODIFY `investorID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
