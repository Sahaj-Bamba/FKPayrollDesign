-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 10, 2020 at 11:59 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `PayrollDesign`
--

-- --------------------------------------------------------

--
-- Table structure for table `AccountDetails`
--

CREATE TABLE `AccountDetails` (
  `EmpId` int(11) NOT NULL,
  `AccountNumber` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='A table to store time details';

-- --------------------------------------------------------

--
-- Table structure for table `Employee`
--

CREATE TABLE `Employee` (
  `Id` int(10) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `SalaryType` int(2) NOT NULL,
  `Salary` float NOT NULL,
  `Commission` float NOT NULL,
  `ModeOfPayment` int(2) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `LastPayed` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='A table to store employees data';

--
-- Dumping data for table `Employee`
--

INSERT INTO `Employee` (`Id`, `Name`, `SalaryType`, `Salary`, `Commission`, `ModeOfPayment`, `Address`, `LastPayed`) VALUES
(1, 'sam ka', 1, 12, 12, 1, 'adk ka', '2020-05-11');

-- --------------------------------------------------------

--
-- Table structure for table `EmployeeUnion`
--

CREATE TABLE `EmployeeUnion` (
  `EmpId` int(11) NOT NULL,
  `UnionId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='A table to store time details';

-- --------------------------------------------------------

--
-- Table structure for table `ExtraCharges`
--

CREATE TABLE `ExtraCharges` (
  `id` int(11) NOT NULL,
  `EmpId` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Amount` float NOT NULL,
  `Reason` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='A table to store time details';

-- --------------------------------------------------------

--
-- Table structure for table `Sales`
--

CREATE TABLE `Sales` (
  `id` int(11) NOT NULL,
  `EmpId` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Amount` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='A table to store time details';

-- --------------------------------------------------------

--
-- Table structure for table `TimeCard`
--

CREATE TABLE `TimeCard` (
  `id` int(11) NOT NULL,
  `EmpId` int(11) NOT NULL,
  `Date` date NOT NULL,
  `NumberOfHours` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='A table to store time details';

-- --------------------------------------------------------

--
-- Table structure for table `Union_`
--

CREATE TABLE `Union_` (
  `Id` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Fees` float NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='A table to store time details';

--
-- Indexes for dumped tables
--

--
-- Indexes for table `AccountDetails`
--
ALTER TABLE `AccountDetails`
  ADD PRIMARY KEY (`EmpId`);

--
-- Indexes for table `Employee`
--
ALTER TABLE `Employee`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Id` (`Id`);

--
-- Indexes for table `EmployeeUnion`
--
ALTER TABLE `EmployeeUnion`
  ADD PRIMARY KEY (`EmpId`);

--
-- Indexes for table `ExtraCharges`
--
ALTER TABLE `ExtraCharges`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Sales`
--
ALTER TABLE `Sales`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `TimeCard`
--
ALTER TABLE `TimeCard`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `EmpId` (`EmpId`,`Date`);

--
-- Indexes for table `Union_`
--
ALTER TABLE `Union_`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Id` (`Id`),
  ADD UNIQUE KEY `Name` (`Name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Employee`
--
ALTER TABLE `Employee`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `ExtraCharges`
--
ALTER TABLE `ExtraCharges`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Sales`
--
ALTER TABLE `Sales`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `TimeCard`
--
ALTER TABLE `TimeCard`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Union_`
--
ALTER TABLE `Union_`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
