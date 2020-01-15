-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 01, 2019 at 04:39 PM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tokosb`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id_barang` varchar(50) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `jenis_barang` varchar(50) NOT NULL,
  `tipe_barang` varchar(50) NOT NULL,
  `harga_barang` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id_barang`, `nama_barang`, `jenis_barang`, `tipe_barang`, `harga_barang`) VALUES
('TSB0001', 'lembut', 'Selimut', 'Kelas 1', 'Rp. 700000'),
('TSB0002', 'sprei nih', 'Sprei', 'kelas 2', 'Rp. 500000'),
('TSB0003', 'hime', 'Spring Bad', 'kelas 2', 'Rp. 400000');

-- --------------------------------------------------------

--
-- Table structure for table `barang_keluar`
--

CREATE TABLE `barang_keluar` (
  `id_barang` varchar(50) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `jenis_barang` varchar(50) NOT NULL,
  `type_barang` varchar(50) NOT NULL,
  `tanggal` date NOT NULL,
  `jumah_barang` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barang_keluar`
--

INSERT INTO `barang_keluar` (`id_barang`, `nama_barang`, `jenis_barang`, `type_barang`, `tanggal`, `jumah_barang`) VALUES
('TSB0002', 'sprei nih', 'Sprei', 'kelas 2', '2019-03-28', 1),
('TSB0003', 'hime', 'Spring Bad', 'kelas 2', '2019-04-27', 3);

-- --------------------------------------------------------

--
-- Table structure for table `barang_masuk`
--

CREATE TABLE `barang_masuk` (
  `id_distributor` varchar(50) NOT NULL,
  `id_barang` varchar(50) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `jenis_barang` varchar(50) NOT NULL,
  `type_barang` varchar(50) NOT NULL,
  `tanggal` date NOT NULL,
  `jumlah_barang` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barang_masuk`
--

INSERT INTO `barang_masuk` (`id_distributor`, `id_barang`, `nama_barang`, `jenis_barang`, `type_barang`, `tanggal`, `jumlah_barang`) VALUES
('DST0001', 'TSB0001', 'lembut', 'Selimut', 'kelas 1', '2019-03-25', 2),
('DST0001', 'TSB0002', 'sprei nih', 'Sprei', 'kelas 2', '2019-03-25', 3),
('DST0001', 'TSB0001', 'lembut', 'Selimut', 'kelas 1', '2019-03-07', 5),
('DST0001', 'TSB0003', 'hime', 'Spring Bad', 'kelas 2', '2019-03-05', 4);

-- --------------------------------------------------------

--
-- Table structure for table `distributor`
--

CREATE TABLE `distributor` (
  `id_distributor` varchar(50) NOT NULL,
  `nama_distributor` varchar(50) NOT NULL,
  `tlp_distributor` varchar(50) NOT NULL,
  `alamat_distributor` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `distributor`
--

INSERT INTO `distributor` (`id_distributor`, `nama_distributor`, `tlp_distributor`, `alamat_distributor`) VALUES
('DST0001', 'tes', 'tes1', 'depok\n');

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `id_peg` varchar(50) NOT NULL,
  `nama_peg` varchar(50) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `tempat_lahir` varchar(50) NOT NULL,
  `tlp` varchar(50) NOT NULL,
  `pendidikan` varchar(50) NOT NULL,
  `alamat_peg` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`id_peg`, `nama_peg`, `tgl_lahir`, `tempat_lahir`, `tlp`, `pendidikan`, `alamat_peg`) VALUES
('NIK0001', 'RIzky', '2019-03-09', 'Jakarta', '085715553987', 'S1', '');

-- --------------------------------------------------------

--
-- Table structure for table `pembeli`
--

CREATE TABLE `pembeli` (
  `id_pembeli` varchar(50) NOT NULL,
  `nama_pembeli` varchar(50) NOT NULL,
  `tlp` varchar(50) NOT NULL,
  `alamat_pembeli` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pembeli`
--

INSERT INTO `pembeli` (`id_pembeli`, `nama_pembeli`, `tlp`, `alamat_pembeli`) VALUES
('CSN0001', 'tes', 'tes3', 'tes2');

-- --------------------------------------------------------

--
-- Table structure for table `stok_barang`
--

CREATE TABLE `stok_barang` (
  `id_barang` varchar(50) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `jenis_barang` varchar(50) NOT NULL,
  `tipe_barang` varchar(50) NOT NULL,
  `harga_barang` varchar(50) NOT NULL,
  `stokbarang` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stok_barang`
--

INSERT INTO `stok_barang` (`id_barang`, `nama_barang`, `jenis_barang`, `tipe_barang`, `harga_barang`, `stokbarang`) VALUES
('TSB0001', 'lembut', 'Selimut', 'Kelas 1', 'Rp. 700000', 14),
('TSB0002', 'sprei nih', 'Sprei', 'kelas 2', 'Rp. 500000', 2),
('TSB0003', 'hime', 'Spring Bad', 'kelas 2', 'Rp. 400000', 1);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_trans` varchar(50) NOT NULL,
  `id_pembeli` varchar(50) NOT NULL,
  `nama_pembeli` varchar(50) NOT NULL,
  `alamat_pembeli` text NOT NULL,
  `tanggal` date NOT NULL,
  `id_barang` varchar(50) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `jenis_barang` varchar(50) NOT NULL,
  `type_barang` varchar(50) NOT NULL,
  `harga_barang` varchar(50) NOT NULL,
  `kuantitas` int(11) NOT NULL,
  `total` varchar(50) NOT NULL,
  `cash` varchar(50) NOT NULL,
  `kembalian` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_trans`, `id_pembeli`, `nama_pembeli`, `alamat_pembeli`, `tanggal`, `id_barang`, `nama_barang`, `jenis_barang`, `type_barang`, `harga_barang`, `kuantitas`, `total`, `cash`, `kembalian`) VALUES
('TRS0001', 'CSN0001', 'tes', 'tes2', '2019-03-28', 'TSB0002', 'sprei nih', 'Sprei', 'kelas 2', 'Rp. 500000', 1, 'Rp. 500000', '1000000', '500000'),
('TRS0002', 'CSN0001', 'tes', 'tes2', '2019-04-27', 'TSB0003', 'hime', 'Spring Bad', 'kelas 2', 'Rp. 400000', 3, 'Rp. 1200000', '1200000', '0');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`) VALUES
('admin', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `stok_barang`
--
ALTER TABLE `stok_barang`
  ADD PRIMARY KEY (`id_barang`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
