-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 22, 2017 at 04:43 PM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `musicdatabase`
--

-- --------------------------------------------------------

--
-- Table structure for table `music`
--

CREATE TABLE `music` (
  `MusicID` int(4) NOT NULL,
  `UploaderID` int(4) NOT NULL,
  `Title` varchar(50) NOT NULL,
  `Genre` varchar(50) NOT NULL,
  `MusicLength` DOUBLE(50) NOT NULL,
  `FilePath` varchar(200) NOT NULL DEFAULT 'Music/Default.mp3	'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `music`
--

INSERT INTO `music` (`MusicID`, `UploaderID`, `Title`, `Genre`, `MusicLength`, `FilePath`) VALUES
(1, 1, 'Deju Vu.mp3', 'Pop', 4.20, 'Music/Deju Vu.mp3	'),
(2, 1, 'Into The Sky by Tara St. Michel.mp3', 'Music/Into The Sky by Tara St. Michel.mp3	'),

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userID` int(4) NOT NULL,
  `username` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(128) NOT NULL,
  `country` varchar(200) DEFAULT 'No Country',
  `admin` smallint(1) NOT NULL,
  `salt` varchar(128) NOT NULL,
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userID`, `username`, `email`, `password`, `country`, `admin`, `salt`) VALUES
(1, 'BenRose', 'ben.rose76@gmail.com', '44c762f1b0c34b1b1a85ee47ed75c838f86eb9c88c775cb5682756850608e6050cb9680254a355219a3e0aa83e1e4669bb62c653d3f19b7fc175be81fcd71e63', 'Ireland', 1, 'mÚ—&\0BË\\ç×¿¼É\Z');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `music`
--
ALTER TABLE `music`
  ADD PRIMARY KEY (`MusicID`),
  ADD KEY `UploaderID` (`UploaderID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `music`
--
ALTER TABLE `music`
  MODIFY `MusicID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `music`
--
ALTER TABLE `music`
  ADD CONSTRAINT `music_ibfk_1` FOREIGN KEY (`MusicID`) REFERENCES `users` (`userID`);


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
