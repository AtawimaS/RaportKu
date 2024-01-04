-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 04 Jan 2024 pada 08.05
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `raportku`
--

DELIMITER $$
--
-- Prosedur
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `tampilnilaiNim` (IN `nim` VARCHAR(15))   BEGIN
    SELECT
        s1.matematika AS matematika_1,
        s1.ipa AS ipa_1,
        s1.ips AS ips_1,
        s1.bin AS bin_1,
        s1.big AS big_1,
        AVG(s1.matematika + s1.ipa + s1.ips + s1.bin + s1.big) / 5 AS rerata_1,
        1 AS semester

    FROM semester_1 s1
    WHERE s1.id_siswa = nim

    UNION

    SELECT
        s2.matematika AS matematika_2,
        s2.ipa AS ipa_2,
        s2.ips AS ips_2,
        s2.bin AS bin_2,
        s2.big AS big_2,
        AVG(s2.matematika + s2.ipa + s2.ips + s2.bin + s2.big) / 5 AS rerata_2,
        2 AS semester

    FROM semester_2 s2
    WHERE s2.id_siswa = nim

    UNION

    SELECT
        s3.matematika AS matematika_3,
        s3.ipa AS ipa_3,
        s3.ips AS ips_3,
        s3.bin AS bin_3,
        s3.big AS big_3,
        AVG(s3.matematika + s3.ipa + s3.ips + s3.bin + s3.big) / 5 AS rerata_3,
        3 AS semester

    FROM semester_3 s3
    WHERE s3.id_siswa = nim

    UNION

    SELECT
        s4.matematika AS matematika_4,
        s4.ipa AS ipa_4,
        s4.ips AS ips_4,
        s4.bin AS bin_4,
        s4.big AS big_4,
        AVG(s4.matematika + s4.ipa + s4.ips + s4.bin + s4.big) / 5 AS rerata_4,
        4 AS semester

    FROM semester_4 s4
    WHERE s4.id_siswa = nim

    UNION

    SELECT
        s5.matematika AS matematika_5,
        s5.ipa AS ipa_5,
        s5.ips AS ips_5,
        s5.bin AS bin_5,
        s5.big AS big_5,
        AVG(s5.matematika + s5.ipa + s5.ips + s5.bin + s5.big) / 5 AS rerata_5,
        5 AS semester

    FROM semester_5 s5
    WHERE s5.id_siswa = nim

    UNION

    SELECT
        s6.matematika AS matematika_6,
        s6.ipa AS ipa_6,
        s6.ips AS ips_6,
        s6.bin AS bin_6,
        s6.big AS big_6,
        AVG(s6.matematika + s6.ipa + s6.ips + s6.bin + s6.big) / 5 AS rerata_6,
        6 AS semester

    FROM semester_6 s6
    WHERE s6.id_siswa = nim

    ORDER BY semester;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `dataguru`
--

CREATE TABLE `dataguru` (
  `id_guru` varchar(15) NOT NULL,
  `nama_guru` varchar(50) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `dataguru`
--

INSERT INTO `dataguru` (`id_guru`, `nama_guru`, `gender`, `email`, `password`) VALUES
('G001', 'Edriko', 'male', 'EdrikoGanteng@gmail.com', 'Edriko123');

-- --------------------------------------------------------

--
-- Struktur dari tabel `datasiswa`
--

CREATE TABLE `datasiswa` (
  `id_siswa` varchar(15) NOT NULL,
  `nama_siswa` varchar(50) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `tanggal_lahir` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `datasiswa`
--

INSERT INTO `datasiswa` (`id_siswa`, `nama_siswa`, `gender`, `tanggal_lahir`) VALUES
('260210', 'Tan, William', 'Male', '2004-06-27');

--
-- Trigger `datasiswa`
--
DELIMITER $$
CREATE TRIGGER `OtomatisInserSmester` AFTER INSERT ON `datasiswa` FOR EACH ROW BEGIN
    DECLARE i INT DEFAULT 1;

    WHILE i <= 6 DO
        CASE i
            WHEN 1 THEN
                INSERT INTO Semester_1 (id_siswa, matematika, ipa, ips, bin, big)
                VALUES (NEW.id_siswa, 0, 0, 0, 0, 0);

            WHEN 2 THEN
                INSERT INTO Semester_2 (id_siswa, matematika, ipa, ips, bin, big)
                VALUES (NEW.id_siswa, 0, 0, 0, 0, 0);

            WHEN 3 THEN
                INSERT INTO Semester_3 (id_siswa, matematika, ipa, ips, bin, big)
                VALUES (NEW.id_siswa, 0, 0, 0, 0, 0);

            WHEN 4 THEN
                INSERT INTO Semester_4 (id_siswa, matematika, ipa, ips, bin, big)
                VALUES (NEW.id_siswa, 0, 0, 0, 0, 0);

            WHEN 5 THEN
                INSERT INTO Semester_5 (id_siswa, matematika, ipa, ips, bin, big)
                VALUES (NEW.id_siswa, 0, 0, 0, 0, 0);

            WHEN 6 THEN
                INSERT INTO Semester_6 (id_siswa, matematika, ipa, ips, bin, big)
                VALUES (NEW.id_siswa, 0, 0, 0, 0, 0);
        END CASE;

        SET i = i + 1;
    END WHILE;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `semester_1`
--

CREATE TABLE `semester_1` (
  `id_siswa` varchar(15) NOT NULL,
  `matematika` int(3) NOT NULL,
  `ipa` int(3) NOT NULL,
  `ips` int(3) NOT NULL,
  `bin` int(3) NOT NULL,
  `big` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `semester_1`
--

INSERT INTO `semester_1` (`id_siswa`, `matematika`, `ipa`, `ips`, `bin`, `big`) VALUES
('260210', 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `semester_2`
--

CREATE TABLE `semester_2` (
  `id_siswa` varchar(15) NOT NULL,
  `matematika` int(3) NOT NULL,
  `ipa` int(3) NOT NULL,
  `ips` int(3) NOT NULL,
  `bin` int(3) NOT NULL,
  `big` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `semester_2`
--

INSERT INTO `semester_2` (`id_siswa`, `matematika`, `ipa`, `ips`, `bin`, `big`) VALUES
('260210', 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `semester_3`
--

CREATE TABLE `semester_3` (
  `id_siswa` varchar(15) NOT NULL,
  `matematika` int(3) NOT NULL,
  `ipa` int(3) NOT NULL,
  `ips` int(3) NOT NULL,
  `bin` int(3) NOT NULL,
  `big` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `semester_3`
--

INSERT INTO `semester_3` (`id_siswa`, `matematika`, `ipa`, `ips`, `bin`, `big`) VALUES
('260210', 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `semester_4`
--

CREATE TABLE `semester_4` (
  `id_siswa` varchar(15) NOT NULL,
  `matematika` int(3) NOT NULL,
  `ipa` int(3) NOT NULL,
  `ips` int(3) NOT NULL,
  `bin` int(3) NOT NULL,
  `big` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `semester_4`
--

INSERT INTO `semester_4` (`id_siswa`, `matematika`, `ipa`, `ips`, `bin`, `big`) VALUES
('260210', 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `semester_5`
--

CREATE TABLE `semester_5` (
  `id_siswa` varchar(15) NOT NULL,
  `matematika` int(3) NOT NULL,
  `ipa` int(3) NOT NULL,
  `ips` int(3) NOT NULL,
  `bin` int(3) NOT NULL,
  `big` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `semester_5`
--

INSERT INTO `semester_5` (`id_siswa`, `matematika`, `ipa`, `ips`, `bin`, `big`) VALUES
('260210', 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `semester_6`
--

CREATE TABLE `semester_6` (
  `id_siswa` varchar(15) NOT NULL,
  `matematika` int(3) NOT NULL,
  `ipa` int(3) NOT NULL,
  `ips` int(3) NOT NULL,
  `bin` int(3) NOT NULL,
  `big` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `semester_6`
--

INSERT INTO `semester_6` (`id_siswa`, `matematika`, `ipa`, `ips`, `bin`, `big`) VALUES
('260210', 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `view_semester_1`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `view_semester_1` (
`id_siswa` varchar(15)
,`nama_siswa` varchar(50)
,`matematika` int(3)
,`ipa` int(3)
,`ips` int(3)
,`bin` int(3)
,`big` int(3)
,`average` decimal(18,4)
,`keterangan` varchar(11)
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `view_semester_2`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `view_semester_2` (
`id_siswa` varchar(15)
,`nama_siswa` varchar(50)
,`matematika` int(3)
,`ipa` int(3)
,`ips` int(3)
,`bin` int(3)
,`big` int(3)
,`average` decimal(18,4)
,`keterangan` varchar(11)
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `view_semester_3`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `view_semester_3` (
`id_siswa` varchar(15)
,`nama_siswa` varchar(50)
,`matematika` int(3)
,`ipa` int(3)
,`ips` int(3)
,`bin` int(3)
,`big` int(3)
,`average` decimal(18,4)
,`keterangan` varchar(11)
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `view_semester_4`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `view_semester_4` (
`id_siswa` varchar(15)
,`nama_siswa` varchar(50)
,`matematika` int(3)
,`ipa` int(3)
,`ips` int(3)
,`bin` int(3)
,`big` int(3)
,`average` decimal(18,4)
,`keterangan` varchar(11)
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `view_semester_5`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `view_semester_5` (
`id_siswa` varchar(15)
,`nama_siswa` varchar(50)
,`matematika` int(3)
,`ipa` int(3)
,`ips` int(3)
,`bin` int(3)
,`big` int(3)
,`average` decimal(18,4)
,`keterangan` varchar(11)
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `view_semester_6`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `view_semester_6` (
`id_siswa` varchar(15)
,`nama_siswa` varchar(50)
,`matematika` int(3)
,`ipa` int(3)
,`ips` int(3)
,`bin` int(3)
,`big` int(3)
,`average` decimal(18,4)
,`keterangan` varchar(11)
);

-- --------------------------------------------------------

--
-- Struktur untuk view `view_semester_1`
--
DROP TABLE IF EXISTS `view_semester_1`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_semester_1`  AS SELECT `ds`.`id_siswa` AS `id_siswa`, `ds`.`nama_siswa` AS `nama_siswa`, `sm`.`matematika` AS `matematika`, `sm`.`ipa` AS `ipa`, `sm`.`ips` AS `ips`, `sm`.`bin` AS `bin`, `sm`.`big` AS `big`, (`sm`.`matematika` + `sm`.`ipa` + `sm`.`ips` + `sm`.`bin` + `sm`.`big`) / 5 AS `average`, CASE WHEN (`sm`.`matematika` + `sm`.`ipa` + `sm`.`ips` + `sm`.`bin` + `sm`.`big`) / 5 > 74 THEN 'Lulus' ELSE 'Tidak Lulus' END AS `keterangan` FROM (`datasiswa` `ds` join `semester_1` `sm` on(`ds`.`id_siswa` = `sm`.`id_siswa`)) ;

-- --------------------------------------------------------

--
-- Struktur untuk view `view_semester_2`
--
DROP TABLE IF EXISTS `view_semester_2`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_semester_2`  AS SELECT `ds`.`id_siswa` AS `id_siswa`, `ds`.`nama_siswa` AS `nama_siswa`, `sm`.`matematika` AS `matematika`, `sm`.`ipa` AS `ipa`, `sm`.`ips` AS `ips`, `sm`.`bin` AS `bin`, `sm`.`big` AS `big`, (`sm`.`matematika` + `sm`.`ipa` + `sm`.`ips` + `sm`.`bin` + `sm`.`big`) / 5 AS `average`, CASE WHEN (`sm`.`matematika` + `sm`.`ipa` + `sm`.`ips` + `sm`.`bin` + `sm`.`big`) / 5 > 74 THEN 'Lulus' ELSE 'Tidak Lulus' END AS `keterangan` FROM (`datasiswa` `ds` join `semester_2` `sm` on(`ds`.`id_siswa` = `sm`.`id_siswa`)) ;

-- --------------------------------------------------------

--
-- Struktur untuk view `view_semester_3`
--
DROP TABLE IF EXISTS `view_semester_3`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_semester_3`  AS SELECT `ds`.`id_siswa` AS `id_siswa`, `ds`.`nama_siswa` AS `nama_siswa`, `sm`.`matematika` AS `matematika`, `sm`.`ipa` AS `ipa`, `sm`.`ips` AS `ips`, `sm`.`bin` AS `bin`, `sm`.`big` AS `big`, (`sm`.`matematika` + `sm`.`ipa` + `sm`.`ips` + `sm`.`bin` + `sm`.`big`) / 5 AS `average`, CASE WHEN (`sm`.`matematika` + `sm`.`ipa` + `sm`.`ips` + `sm`.`bin` + `sm`.`big`) / 5 > 74 THEN 'Lulus' ELSE 'Tidak Lulus' END AS `keterangan` FROM (`datasiswa` `ds` join `semester_3` `sm` on(`ds`.`id_siswa` = `sm`.`id_siswa`)) ;

-- --------------------------------------------------------

--
-- Struktur untuk view `view_semester_4`
--
DROP TABLE IF EXISTS `view_semester_4`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_semester_4`  AS SELECT `ds`.`id_siswa` AS `id_siswa`, `ds`.`nama_siswa` AS `nama_siswa`, `sm`.`matematika` AS `matematika`, `sm`.`ipa` AS `ipa`, `sm`.`ips` AS `ips`, `sm`.`bin` AS `bin`, `sm`.`big` AS `big`, (`sm`.`matematika` + `sm`.`ipa` + `sm`.`ips` + `sm`.`bin` + `sm`.`big`) / 5 AS `average`, CASE WHEN (`sm`.`matematika` + `sm`.`ipa` + `sm`.`ips` + `sm`.`bin` + `sm`.`big`) / 5 > 74 THEN 'Lulus' ELSE 'Tidak Lulus' END AS `keterangan` FROM (`datasiswa` `ds` join `semester_4` `sm` on(`ds`.`id_siswa` = `sm`.`id_siswa`)) ;

-- --------------------------------------------------------

--
-- Struktur untuk view `view_semester_5`
--
DROP TABLE IF EXISTS `view_semester_5`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_semester_5`  AS SELECT `ds`.`id_siswa` AS `id_siswa`, `ds`.`nama_siswa` AS `nama_siswa`, `sm`.`matematika` AS `matematika`, `sm`.`ipa` AS `ipa`, `sm`.`ips` AS `ips`, `sm`.`bin` AS `bin`, `sm`.`big` AS `big`, (`sm`.`matematika` + `sm`.`ipa` + `sm`.`ips` + `sm`.`bin` + `sm`.`big`) / 5 AS `average`, CASE WHEN (`sm`.`matematika` + `sm`.`ipa` + `sm`.`ips` + `sm`.`bin` + `sm`.`big`) / 5 > 74 THEN 'Lulus' ELSE 'Tidak Lulus' END AS `keterangan` FROM (`datasiswa` `ds` join `semester_5` `sm` on(`ds`.`id_siswa` = `sm`.`id_siswa`)) ;

-- --------------------------------------------------------

--
-- Struktur untuk view `view_semester_6`
--
DROP TABLE IF EXISTS `view_semester_6`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_semester_6`  AS SELECT `ds`.`id_siswa` AS `id_siswa`, `ds`.`nama_siswa` AS `nama_siswa`, `sm`.`matematika` AS `matematika`, `sm`.`ipa` AS `ipa`, `sm`.`ips` AS `ips`, `sm`.`bin` AS `bin`, `sm`.`big` AS `big`, (`sm`.`matematika` + `sm`.`ipa` + `sm`.`ips` + `sm`.`bin` + `sm`.`big`) / 5 AS `average`, CASE WHEN (`sm`.`matematika` + `sm`.`ipa` + `sm`.`ips` + `sm`.`bin` + `sm`.`big`) / 5 > 74 THEN 'Lulus' ELSE 'Tidak Lulus' END AS `keterangan` FROM (`datasiswa` `ds` join `semester_6` `sm` on(`ds`.`id_siswa` = `sm`.`id_siswa`)) ;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `dataguru`
--
ALTER TABLE `dataguru`
  ADD PRIMARY KEY (`id_guru`);

--
-- Indeks untuk tabel `datasiswa`
--
ALTER TABLE `datasiswa`
  ADD PRIMARY KEY (`id_siswa`);

--
-- Indeks untuk tabel `semester_1`
--
ALTER TABLE `semester_1`
  ADD KEY `id_siswa` (`id_siswa`);

--
-- Indeks untuk tabel `semester_2`
--
ALTER TABLE `semester_2`
  ADD KEY `id_siswa` (`id_siswa`);

--
-- Indeks untuk tabel `semester_3`
--
ALTER TABLE `semester_3`
  ADD KEY `id_siswa` (`id_siswa`);

--
-- Indeks untuk tabel `semester_4`
--
ALTER TABLE `semester_4`
  ADD KEY `id_siswa` (`id_siswa`);

--
-- Indeks untuk tabel `semester_5`
--
ALTER TABLE `semester_5`
  ADD KEY `id_siswa` (`id_siswa`);

--
-- Indeks untuk tabel `semester_6`
--
ALTER TABLE `semester_6`
  ADD KEY `id_siswa` (`id_siswa`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `semester_1`
--
ALTER TABLE `semester_1`
  ADD CONSTRAINT `semester_1_ibfk_1` FOREIGN KEY (`id_siswa`) REFERENCES `datasiswa` (`id_siswa`);

--
-- Ketidakleluasaan untuk tabel `semester_2`
--
ALTER TABLE `semester_2`
  ADD CONSTRAINT `semester_2_ibfk_1` FOREIGN KEY (`id_siswa`) REFERENCES `datasiswa` (`id_siswa`);

--
-- Ketidakleluasaan untuk tabel `semester_3`
--
ALTER TABLE `semester_3`
  ADD CONSTRAINT `semester_3_ibfk_1` FOREIGN KEY (`id_siswa`) REFERENCES `datasiswa` (`id_siswa`);

--
-- Ketidakleluasaan untuk tabel `semester_4`
--
ALTER TABLE `semester_4`
  ADD CONSTRAINT `semester_4_ibfk_1` FOREIGN KEY (`id_siswa`) REFERENCES `datasiswa` (`id_siswa`);

--
-- Ketidakleluasaan untuk tabel `semester_5`
--
ALTER TABLE `semester_5`
  ADD CONSTRAINT `semester_5_ibfk_1` FOREIGN KEY (`id_siswa`) REFERENCES `datasiswa` (`id_siswa`);

--
-- Ketidakleluasaan untuk tabel `semester_6`
--
ALTER TABLE `semester_6`
  ADD CONSTRAINT `semester_6_ibfk_1` FOREIGN KEY (`id_siswa`) REFERENCES `datasiswa` (`id_siswa`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
