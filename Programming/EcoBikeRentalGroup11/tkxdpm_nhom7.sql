-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 30, 2020 at 11:40 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11
CREATE DATABASE tkxdpm;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tkxdpm_nhom7`
--

-- --------------------------------------------------------

--
-- Table structure for table `bike`
--

CREATE TABLE `bike` (
  `bike_id` int(100) NOT NULL,
  `station_id` int(100) NOT NULL,
  `lock_id` int(100) NOT NULL,
  `plate_license` varchar(100) NOT NULL,
  `brand` varchar(100) NOT NULL,
  `model` varchar(100) NOT NULL,
  `battery` int(30) NOT NULL,
  `operation_date` datetime NOT NULL DEFAULT current_timestamp(),
  `type` varchar(100) NOT NULL DEFAULT 'normal_single',
  `status` int(30) NOT NULL DEFAULT 0,
  `value_of_bike` int(100) DEFAULT 200000,
  `image` varchar(100) NOT NULL DEFAULT 'bike_default.png'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bike`
--

INSERT INTO `bike` (`bike_id`, `station_id`, `lock_id`, `plate_license`, `brand`, `model`, `battery`, `operation_date`, `type`, `status`, `value_of_bike`, `image`) VALUES
(1, 1, 1, 'license_2020', 'thong nhat', 'MX123', 20, '2020-11-11 19:53:31', 'Single Bike', 0, 2000000, 'bike_default.png'),
(2, 1, 2, 'license_2019', 'hon da', 'HD 123', 34, '2020-11-12 09:47:03', 'Electric Bike', 0, 1500000, 'bike_hd.jpg'),
(3, 3, 4, 'ABC_123', 'China', 'Hang Dom', 99, '2020-11-30 16:41:56', 'Electric Bike', 0, 240000, 'bike_default.png'),
(4, 2, 3, 'DEF_01', 'America Bike', 'HANG_XIN', 100, '2020-11-30 16:42:56', '\r\nDouble Bike', 0, 300000, 'bike_default.png');

-- --------------------------------------------------------

--
-- Table structure for table `docking_lock`
--

CREATE TABLE `docking_lock` (
  `lock_id` int(100) NOT NULL,
  `station_id` int(100) NOT NULL,
  `bar_code` varchar(300) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `docking_lock`
--

INSERT INTO `docking_lock` (`lock_id`, `station_id`, `bar_code`, `status`) VALUES
(1, 1, 'nguyenThanhlong', 1),
(2, 1, 'tn_dock_02', 1),
(3, 2, 'bk_station_dock_1', 1),
(4, 3, 'ys_station_dock_1', 1);

-- --------------------------------------------------------

--
-- Table structure for table `payment_method`
--

CREATE TABLE `payment_method` (
  `method_id` int(100) NOT NULL,
  `method_name` varchar(100) NOT NULL,
  `card_code` varchar(100) NOT NULL,
  `owner` varchar(100) NOT NULL,
  `cvv_code` int(50) NOT NULL,
  `date_expire` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `payment_method`
--

INSERT INTO `payment_method` (`method_id`, `method_name`, `card_code`, `owner`, `cvv_code`, `date_expire`) VALUES
(5, 'Interbank', '118609_group11_2020', 'Group 11', 762, '1125'),
(6, 'Momo', '118609_group11_2020', 'Group 11', 921, '1293');

-- --------------------------------------------------------

--
-- Table structure for table `station`
--

CREATE TABLE `station` (
  `station_id` int(100) NOT NULL,
  `station_name` varchar(200) NOT NULL,
  `address` varchar(200) NOT NULL,
  `area` int(50) NOT NULL DEFAULT 100,
  `location_code` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `station`
--

INSERT INTO `station` (`station_id`, `station_name`, `address`, `area`, `location_code`) VALUES
(1, 'thong nhat station', 'So 17 Dai Co Viet, Hai Ba Trung, Ha Noi', 200, 'location_01'),
(2, 'SVD Bach Khoa Station', '202 Le Thanh Nghi, Hai Ba Trung, Ha Noi', 100, 'location_02'),
(3, 'Cong Vien Yen So Station', '1097 Giai Phong, Ha Noi', 300, 'location_03');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `transaction_id` int(100) NOT NULL,
  `bike_id` int(100) NOT NULL,
  `user_id` int(100) NOT NULL,
  `start_time` datetime NOT NULL DEFAULT current_timestamp(),
  `end_time` datetime DEFAULT NULL,
  `status` tinyint(1) NOT NULL DEFAULT 1,
  `deposit` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`transaction_id`, `bike_id`, `user_id`, `start_time`, `end_time`, `status`, `deposit`) VALUES
(3, 1, 1, '2020-11-26 20:12:36', NULL, 1, 50004);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(300) NOT NULL,
  `status` int(30) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table user
add `isAdmin` int(10);
--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `name`, `username`, `password`, `status`, `isAdmin`) VALUES
(1, 'Nguyen Cong Luat', 'luatnc', 'nchust', 0, 0),
(2, 'Nguyen Hai Long', 'longnh', 'nhhust', 0, 0),
(3, 'Hoang Trung Duc', 'ducht', 'hthust', 0, 1);


--
-- Indexes for dumped tables
--

--
-- Indexes for table `bike`
--
ALTER TABLE `bike`
  ADD PRIMARY KEY (`bike_id`),
  ADD KEY `bike_station_id` (`station_id`),
  ADD KEY `bike_lock_id` (`lock_id`);

--
-- Indexes for table `docking_lock`
--
ALTER TABLE `docking_lock`
  ADD PRIMARY KEY (`lock_id`),
  ADD KEY `lock_station_id` (`station_id`);

--
-- Indexes for table `payment_method`
--
ALTER TABLE `payment_method`
  ADD PRIMARY KEY (`method_id`);

--
-- Indexes for table `station`
--
ALTER TABLE `station`
  ADD PRIMARY KEY (`station_id`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`transaction_id`),
  ADD KEY `transaction_bike_id` (`bike_id`),
  ADD KEY `transaction_user_id` (`user_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bike`
--
ALTER TABLE `bike`
  MODIFY `bike_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `docking_lock`
--
ALTER TABLE `docking_lock`
  MODIFY `lock_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `payment_method`
--
ALTER TABLE `payment_method`
  MODIFY `method_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `station`
--
ALTER TABLE `station`
  MODIFY `station_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `transaction_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bike`
--
ALTER TABLE `bike`
  ADD CONSTRAINT `bike_lock_id` FOREIGN KEY (`lock_id`) REFERENCES `docking_lock` (`lock_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `bike_station_id` FOREIGN KEY (`station_id`) REFERENCES `station` (`station_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `docking_lock`
--
ALTER TABLE `docking_lock`
  ADD CONSTRAINT `lock_station_id` FOREIGN KEY (`station_id`) REFERENCES `station` (`station_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `transaction_bike_id` FOREIGN KEY (`bike_id`) REFERENCES `bike` (`bike_id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `transaction_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
