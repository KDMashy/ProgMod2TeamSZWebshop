-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2021. Nov 12. 14:49
-- Kiszolgáló verziója: 10.4.21-MariaDB
-- PHP verzió: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `webshop`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `admin`
--

CREATE TABLE `admin` (
  `ADMINID` int(10) UNSIGNED NOT NULL,
  `ADMINNAME` varchar(45) NOT NULL,
  `ADMINPASSWORD` varchar(200) NOT NULL,
  `ADMINCODE` char(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- A tábla adatainak kiíratása `admin`
--

INSERT INTO `admin` (`ADMINID`, `ADMINNAME`, `ADMINPASSWORD`, `ADMINCODE`) VALUES
(1, 'Mashy', 'b35ad0b811f1c7e5b7abe6f9e6f275d769f529aa62f7c03093a222db99628035', '20001210213'),
(2, 'Admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '00000000000');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `egysegarak`
--

CREATE TABLE `egysegarak` (
  `Vasarlas_SorSzam` int(11) NOT NULL,
  `Termek_TermekID` int(11) NOT NULL,
  `Termek_TermekAr` int(10) UNSIGNED NOT NULL,
  `Termek_Mennyiseg` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `gyarto`
--

CREATE TABLE `gyarto` (
  `GyartoID` int(11) NOT NULL,
  `GyartoNev` varchar(200) NOT NULL,
  `GyartoElerhetoseg` varchar(200) NOT NULL,
  `GyartoiGarancia` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `kategoria`
--

CREATE TABLE `kategoria` (
  `KategoriaID` int(11) NOT NULL,
  `KategoriaNev` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `partner`
--

CREATE TABLE `partner` (
  `PartnerID` int(11) NOT NULL,
  `PartnerNev` varchar(100) NOT NULL,
  `PartnerElerhetoseg` varchar(300) NOT NULL,
  `PartnerAdoszam` char(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- A tábla adatainak kiíratása `partner`
--

INSERT INTO `partner` (`PartnerID`, `PartnerNev`, `PartnerElerhetoseg`, `PartnerAdoszam`) VALUES
(1, 'TesztPartner1', 'áéő', NULL);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `szerviz`
--

CREATE TABLE `szerviz` (
  `SzervizID` int(11) NOT NULL,
  `SzervizNev` varchar(200) NOT NULL,
  `SzervizElerhetoseg` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `termek`
--

CREATE TABLE `termek` (
  `TermekID` int(11) NOT NULL,
  `TermekNev` varchar(100) CHARACTER SET utf8 COLLATE utf8_hungarian_ci NOT NULL,
  `TermekDesc` varchar(1000) CHARACTER SET utf8 COLLATE utf8_hungarian_ci NOT NULL,
  `TermekAr` int(10) NOT NULL,
  `TermekKep` varchar(200) CHARACTER SET utf8 COLLATE utf8_hungarian_ci NOT NULL,
  `TermekKeszlet` tinyint(4) NOT NULL,
  `TermekKatID` smallint(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- A tábla adatainak kiíratása `termek`
--

INSERT INTO `termek` (`TermekID`, `TermekNev`, `TermekDesc`, `TermekAr`, `TermekKep`, `TermekKeszlet`, `TermekKatID`) VALUES
(1, 'anonymTermek1', 'teszt', 366, 'RES/asd.png', 0, 1),
(2, 'anonymTermek2', 'tesztelÃ©sre van, van mÃ©g remÃ©ny', 367, 'RES/teszt.png', 0, 1),
(3, 'anonymTermek3', 'TesztelÃ©sre van, van mÃ©g remÃ©ny 2x', 368, 'RES/vanremeny.png', 1, 1),
(4, 'anonymTermek4', 'dsa', 1000, 'RES/asd.png', 1, 1),
(5, 'anonymTermek5', 'asd', 370, 'RES/asd.png', 1, 1),
(6, 'anonymTermek6', 'MÃ©g Ã©l a remÃ©ny', 369, 'RES/sadvagyok.png', 1, 1),
(7, 'anonymTermek7', 'MÃ©g van remÃ©ny', 2000, 'RES/asd.png', 1, 1),
(8, 'anonymTermek8', 'teszt', 122, 'RES/asd.png', 1, 1),
(9, 'anonymTermek9', 'Tesztelek Ã©s sÃ­rok', 124, 'RES/asd.png', 0, 1),
(10, 'anonymTermek10', 'Ã¡Ã©Å', 136, 'RES/asd.png', 0, 1),
(11, 'anonymTermek11', 'áéő', 333, 'RES/asd.png', 0, 1);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `vasarlas`
--

CREATE TABLE `vasarlas` (
  `SorSzam` int(11) NOT NULL,
  `Felhasznalo` varchar(100) NOT NULL,
  `Szamla` tinyint(4) NOT NULL,
  `FizMod` varchar(45) NOT NULL,
  `Osszeg` int(11) NOT NULL,
  `IRSzam` char(4) NOT NULL,
  `Varos` varchar(45) NOT NULL,
  `UtcaHSzam` varchar(70) NOT NULL,
  `Idopont` varchar(100) NOT NULL,
  `Egyeb` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- A tábla adatainak kiíratása `vasarlas`
--

INSERT INTO `vasarlas` (`SorSzam`, `Felhasznalo`, `Szamla`, `FizMod`, `Osszeg`, `IRSzam`, `Varos`, `UtcaHSzam`, `Idopont`, `Egyeb`) VALUES
(1, 'Anonym1', 0, 'asd', 3, '0000', 'Anonym1', 'Anonym1', '211109205208', 'DELETED'),
(2, 'Anonym2', 0, 'asd', 3, '0000', 'Anonym2', 'Anonym2', '211109205208', 'DELETED');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `vevo`
--

CREATE TABLE `vevo` (
  `VevoID` int(11) NOT NULL,
  `VevoNev` varchar(45) NOT NULL,
  `VevoPassword` varchar(200) NOT NULL,
  `VevoEmail` varchar(100) NOT NULL,
  `VevoSzamCim` varchar(45) DEFAULT NULL,
  `VevoAdoszam` char(11) DEFAULT NULL,
  `TorzsVasarlo` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- A tábla adatainak kiíratása `vevo`
--

INSERT INTO `vevo` (`VevoID`, `VevoNev`, `VevoPassword`, `VevoEmail`, `VevoSzamCim`, `VevoAdoszam`, `TorzsVasarlo`) VALUES
(1, 'anonym1', '54d5cb2d332dbdb4850293caae4559ce88b65163f1ea5d4e4b3ac49d772ded14', 'anonym1', 'anonym1', 'anonym1', 0),
(2, 'anonym2', 'daf9358fe344ec2f58f2a501d411091db9e1fa1febd72840e9ad483be0a67b44', 'anonym2', 'anonym2', 'anonym2', 0),
(3, 'anonym3', '54d5cb2d332dbdb4850293caae4559ce88b65163f1ea5d4e4b3ac49d772ded14', 'anonym3', 'anonym3', 'anonym3', 0),
(4, 'anonym4', 'a8849f15d7236514c9d20c567dff9f90d72697bc1506c7e2d7d50b8f825d689c', 'anonym4', 'anonym4', 'anonym4', 0),
(5, 'anonym5', 'd9b5f58f0b38198293971865a14074f59eba3e82595becbe86ae51f1d9f1f65e', 'anonym5', 'anonym5', 'anonym5', 0),
(6, 'anonym6', 'd7c15f947ca64d1fdb1a79109358d91a9fcc3f62d1414ab8a512218777fb950a', 'anonym6', 'anonym6', 'anonym6', 0),
(7, 'anonym7', '16ecab1875791e2b6ed0c9a6dae5a12a79d92120e1c3afbd3a9c8535ce44666d', 'anonym7', 'anonym7', 'anonym7', 0),
(8, 'anonym8', '1e6ed5a6a8954718c4d6d6b3f59497f9823b62ccdc1810133edc252d5d9e370b', 'anonym8', 'anonym8', 'anonym8', 0),
(9, 'anonym9', '88113fc33e2217f55157eb23142e048647ec8675f62d4f662fadbb8b1231c7bd', 'anonym9', 'anonym9', 'anonym9', 0),
(10, 'anonym10', 'a4b4be1a41389805870471a4dad44bcc6c3e4d76197e74a348b4a15c632a880a', 'anonym10', 'anonym10', 'anonym10', 0),
(11, 'anonym11', '0512b9ad82455922876d22184705b0ae2d468ace15e969d53a6a3a67a6846640', 'anonym11', 'anonym11', 'anonym11', 0),
(12, 'anonym12', '6f73c61c105fcb9550a7441a2cb6a966f8525b31d017e93895e1530e461a91d9', 'anonym12', 'anonym12', 'anonym12', 0),
(13, 'anonym13', 'ba8b56fb0deb3c78c141e79627df7440054e6d27b7568306cf099c1ddc170dfb', 'anonym13', 'anonym13', 'anonym13', 0),
(14, 'anonym14', '9fc0cc4fb75ed3d44626ace019a4c15e6710f064cb008a93e29e8510a53076b9', 'anonym14', 'anonym14', 'anonym14', 0),
(15, 'anonym15', '1b9eb80dea8ee8eab1f5983b7f74b98d0ddc50e90964f35aa6016e126eb68845', 'anonym15', 'anonym15', 'anonym15', 0),
(16, 'anonym16', 'a4b4be1a41389805870471a4dad44bcc6c3e4d76197e74a348b4a15c632a880a', 'anonym16', 'anonym16', 'anonym16', 0),
(17, 'anonym17', 'a4b4be1a41389805870471a4dad44bcc6c3e4d76197e74a348b4a15c632a880a', 'anonym17', 'anonym17', 'anonym17', 0),
(18, 'anonym18', 'a4b4be1a41389805870471a4dad44bcc6c3e4d76197e74a348b4a15c632a880a', 'anonym18', 'anonym18', 'anonym18', 0),
(19, 'anonym19', 'a4b4be1a41389805870471a4dad44bcc6c3e4d76197e74a348b4a15c632a880a', 'anonym19', 'anonym19', 'anonym19', 0),
(20, 'anonym20', 'a4b4be1a41389805870471a4dad44bcc6c3e4d76197e74a348b4a15c632a880a', 'anonym20', 'anonym20', 'anonym20', 0),
(21, 'anonym21', '275543d2bbaaa1595f97b60d5f1314728ef7069c5c8d648d5d576bd1f2115398', 'anonym21', 'anonym21', 'anonym21', 0),
(22, 'anonym22', '60eb68565a0c5253b3cae332e58613479fb14ac18f91016f1a95bcabd48e94d4', 'anonym22', 'anonym22', 'anonym22', 0),
(23, 'anonym23', '441e556cf3c8f609e7320c9024a9c39a2d860e93d2a9b2f0d65519af71b0c6d1', 'anonym23', 'anonym23', 'anonym23', 0),
(24, 'anonym24', 'c26a9deae1c0bb4a8de9c6003bc3e8ef0dc446f18c513f82f20b3c6c74cce653', 'anonym24', 'anonym24', 'anonym24', 0),
(25, 'Klepe', 'daf9358fe344ec2f58f2a501d411091db9e1fa1febd72840e9ad483be0a67b44', 'Klepe@gmail.com', NULL, NULL, NULL),
(26, 'KlepeTesztel03', 'a4b4be1a41389805870471a4dad44bcc6c3e4d76197e74a348b4a15c632a880a', 'KlepeT@gmail.com', NULL, NULL, NULL),
(27, 'KlepeTesztel30', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 'KlepeT3@gmail.com', NULL, NULL, NULL);

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`ADMINID`);

--
-- A tábla indexei `egysegarak`
--
ALTER TABLE `egysegarak`
  ADD PRIMARY KEY (`Vasarlas_SorSzam`,`Termek_TermekID`),
  ADD KEY `fk_Termek_has_Vasarlas_Vasarlas1_idx` (`Vasarlas_SorSzam`),
  ADD KEY `fk_Termek_has_Vasarlas_Termek_idx` (`Termek_TermekID`);

--
-- A tábla indexei `gyarto`
--
ALTER TABLE `gyarto`
  ADD PRIMARY KEY (`GyartoID`);

--
-- A tábla indexei `kategoria`
--
ALTER TABLE `kategoria`
  ADD PRIMARY KEY (`KategoriaID`);

--
-- A tábla indexei `partner`
--
ALTER TABLE `partner`
  ADD PRIMARY KEY (`PartnerID`);

--
-- A tábla indexei `szerviz`
--
ALTER TABLE `szerviz`
  ADD PRIMARY KEY (`SzervizID`);

--
-- A tábla indexei `termek`
--
ALTER TABLE `termek`
  ADD PRIMARY KEY (`TermekID`);

--
-- A tábla indexei `vasarlas`
--
ALTER TABLE `vasarlas`
  ADD PRIMARY KEY (`SorSzam`);

--
-- A tábla indexei `vevo`
--
ALTER TABLE `vevo`
  ADD PRIMARY KEY (`VevoID`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `admin`
--
ALTER TABLE `admin`
  MODIFY `ADMINID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT a táblához `gyarto`
--
ALTER TABLE `gyarto`
  MODIFY `GyartoID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `kategoria`
--
ALTER TABLE `kategoria`
  MODIFY `KategoriaID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `partner`
--
ALTER TABLE `partner`
  MODIFY `PartnerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT a táblához `szerviz`
--
ALTER TABLE `szerviz`
  MODIFY `SzervizID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `termek`
--
ALTER TABLE `termek`
  MODIFY `TermekID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT a táblához `vasarlas`
--
ALTER TABLE `vasarlas`
  MODIFY `SorSzam` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT a táblához `vevo`
--
ALTER TABLE `vevo`
  MODIFY `VevoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `egysegarak`
--
ALTER TABLE `egysegarak`
  ADD CONSTRAINT `fk_Termek_has_Vasarlas_Termek` FOREIGN KEY (`Termek_TermekID`) REFERENCES `termek` (`TermekID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Termek_has_Vasarlas_Vasarlas1` FOREIGN KEY (`Vasarlas_SorSzam`) REFERENCES `vasarlas` (`SorSzam`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
