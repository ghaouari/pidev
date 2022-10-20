-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 21 sep. 2022 à 08:39
-- Version du serveur :  5.7.26
-- Version de PHP :  7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `rapidservice1`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `mail` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`mail`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `avis`
--

DROP TABLE IF EXISTS `avis`;
CREATE TABLE IF NOT EXISTS `avis` (
  `idAvis` int(30) NOT NULL AUTO_INCREMENT,
  `id_client` int(30) NOT NULL,
  `typeAvis` varchar(50) DEFAULT NULL,
  `nomService` varchar(50) NOT NULL,
  `nomSousService` varchar(50) DEFAULT NULL,
  `id_Prestataire` int(30) NOT NULL,
  PRIMARY KEY (`idAvis`),
  KEY `foreign key fk1` (`id_client`),
  KEY `foreign key fk2` (`nomService`),
  KEY `foreign key 3` (`id_Prestataire`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `avis`
--

INSERT INTO `avis` (`idAvis`, `id_client`, `typeAvis`, `nomService`, `nomSousService`, `id_Prestataire`) VALUES
(1, 1, 'Excelent', 'Aménagement', 'Montage de meuble', 1);

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id_client` int(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) DEFAULT NULL,
  `prenom` varchar(20) DEFAULT NULL,
  `ville` varchar(20) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `mail` varchar(30) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_client`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id_client`, `nom`, `prenom`, `ville`, `tel`, `mail`, `password`) VALUES
(1, 'Hermi', 'Marwa', 'Jendouba Nord', '92354347', 'marwa.hermi@esprit.tn', 'rrr'),
(2, 'mohamed', 'mohamed', 'Tunis', '12365845', 'med@yahoo.com', '124595'),
(3, 'sahar', 'sahar', 'Tunis', '152495', 'sahar@gmail.com', '1236589'),
(4, 'mohamed', 'salah', 'Béja', '212315448751', 'med@hotmail.com', '0125484141');

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

DROP TABLE IF EXISTS `commentaire`;
CREATE TABLE IF NOT EXISTS `commentaire` (
  `idCommentaire` int(30) NOT NULL AUTO_INCREMENT,
  `contenu` varchar(50) DEFAULT NULL,
  `dateCommentaire` varchar(50) DEFAULT NULL,
  `idFichier` int(30) NOT NULL,
  `id_client` int(30) NOT NULL,
  PRIMARY KEY (`idCommentaire`),
  KEY `foreign key_FK1` (`idFichier`),
  KEY `foreign key _FK2` (`id_client`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `demande`
--

DROP TABLE IF EXISTS `demande`;
CREATE TABLE IF NOT EXISTS `demande` (
  `numDemande` int(30) NOT NULL AUTO_INCREMENT,
  `id_client` int(30) NOT NULL,
  `nomService` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`numDemande`),
  KEY `foreign key 2` (`nomService`) USING BTREE,
  KEY `FOREIGN KEY1` (`id_client`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `fichier`
--

DROP TABLE IF EXISTS `fichier`;
CREATE TABLE IF NOT EXISTS `fichier` (
  `idFichier` int(30) NOT NULL AUTO_INCREMENT,
  `id_Prestataire` int(30) NOT NULL,
  `id_client` int(30) NOT NULL,
  `typeFichier` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idFichier`),
  KEY `id_Prestataire` (`id_Prestataire`),
  KEY `id_client` (`id_client`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `prestataire`
--

DROP TABLE IF EXISTS `prestataire`;
CREATE TABLE IF NOT EXISTS `prestataire` (
  `id_Prestataire` int(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) DEFAULT NULL,
  `prenom` varchar(20) DEFAULT NULL,
  `ville` varchar(20) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `mail` varchar(30) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `experience` varchar(20) DEFAULT NULL,
  `nomService` varchar(30) NOT NULL,
  `typeService` varchar(30) NOT NULL,
  PRIMARY KEY (`id_Prestataire`),
  KEY `nomService` (`nomService`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `prestataire`
--

INSERT INTO `prestataire` (`id_Prestataire`, `nom`, `prenom`, `ville`, `tel`, `mail`, `password`, `experience`, `nomService`, `typeService`) VALUES
(1, 'gharbi', 'samir', 'Béja', '21345934', 'gharbisamir@gmail.com', '123ddd', '7 ans en électricité', 'Electricité', 'Bricolage'),
(2, 'Bouhleli', 'Ichrak', 'tunis', '25487678', 'ichrak@gmail.com', '112233', 'experience de 2 ans', 'Plomberie', 'Bricolage'),
(3, 'ben salah', 'amir', 'nabeul', '92345411', 'bensalahamir@yahoo.fr', '123', 'experience de 5 ans', 'Entretien du gazon', 'Jardinage'),
(4, 'Hdhili ', 'Khaled', 'Nabeul', '22345876', 'hdhilikhaled89@gmail.com', '123', 'experiences de 3 ans', 'Nettoyage de terasse', 'Jardinage'),
(5, 'Brinsi', 'Mourad', 'Tunis', '98345887', 'mouradbrinsi@yahoo.fr', 'rrr', 'experience de 2 ans', 'Aménagement', 'Bricolage');

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

DROP TABLE IF EXISTS `reclamation`;
CREATE TABLE IF NOT EXISTS `reclamation` (
  `nRec` int(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `tel` int(15) DEFAULT NULL,
  `mission` varchar(50) DEFAULT NULL,
  `datemission` varchar(30) DEFAULT NULL,
  `nomPrestataire` varchar(50) DEFAULT NULL,
  `missionDesc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`nRec`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `reclamation`
--

INSERT INTO `reclamation` (`nRec`, `nom`, `prenom`, `email`, `tel`, `mission`, `datemission`, `nomPrestataire`, `missionDesc`) VALUES
(1, 'mejri', 'haifa', 'mejri.haifa@esprit.tn', 20314578, 'jardinage', '20-12-2022', 'khaled', 'mal fait'),
(2, 'gharbi', 'olfa', 'gharbi.olfa@esprit.tn', 20314578, 'plomberie', '20-12-2022', 'mourad', 'mal fait'),
(3, 'mezni', 'kais', 'mezni.kais@esprit.tn', 20314578, 'amenagement', '20-12-2022', 'mourad', 'mal fait');

-- --------------------------------------------------------

--
-- Structure de la table `service`
--

DROP TABLE IF EXISTS `service`;
CREATE TABLE IF NOT EXISTS `service` (
  `nomService` varchar(50) NOT NULL,
  `typeService` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`nomService`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `service`
--

INSERT INTO `service` (`nomService`, `typeService`) VALUES
('Accompagnement aux rendez vous médicaux', 'Aide à domicile'),
('Aide au démenagement', 'Démenagement'),
('Aménagement', 'Bricolage'),
('Débrasser des encombrants', 'Démenagement'),
('Débrouissaillage', 'Jardinage'),
('Déneiger', 'Jardinage'),
('Déplacer l electroménager', 'Démenagement'),
('Déplacer un meuble', 'Démenagement'),
('Désherbage', 'Jardinage'),
('Electricité', 'Bricolage'),
('Enlevement de déchets verts', 'Jardinage'),
('Entretien des espaces verts', 'Jardinage'),
('Entretien du gazon', 'Jardinage'),
('Lavage automobile', 'Ménage'),
('Livraison à domicile', 'Aide à domicile'),
('Maintien à domicile', 'Aide à domicile'),
('Ménage à domicile', 'Ménage'),
('Ménage d état des lieux', 'Ménage'),
('Nettoyage de terasse', 'Jardinage'),
('Nettoyage de vitres', 'Ménage'),
('Plomberie', 'Bricolage'),
('Préparer des repas', 'Aide à domicile'),
('Ramassage de feuilles', 'Jardinage'),
('Ranger du bois', 'Jardinage'),
('Rénovation', 'Bricolage'),
('Repassage', 'Ménage'),
('Saler autour de ma maison', 'Jardinage'),
('Taille de haie', 'Jardinage'),
('Tondre la pelouse', 'Jardinage');

-- --------------------------------------------------------

--
-- Structure de la table `sousservice`
--

DROP TABLE IF EXISTS `sousservice`;
CREATE TABLE IF NOT EXISTS `sousservice` (
  `idSousService` int(30) NOT NULL AUTO_INCREMENT,
  `nomService` varchar(50) NOT NULL,
  `nomSousService` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idSousService`),
  KEY `foreign key` (`nomService`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `sousservice`
--

INSERT INTO `sousservice` (`idSousService`, `nomService`, `nomSousService`) VALUES
(1, 'Aménagement', 'Montage meuble'),
(2, 'Amènagement', 'assemblage de meubles'),
(3, 'Aménagement', 'montage canapé'),
(4, 'Aménagement', 'montage lit'),
(5, 'Aménagement', 'démontage de meubles'),
(6, 'Aménagement', 'pose de tringle à rideaux'),
(7, 'Aménagement', 'fixation d étagères'),
(8, 'Aménagement', 'installation un pare baignoire'),
(9, 'Aménagement', 'accrocher un TV au mur'),
(10, 'Electricité', 'installation de prises electriques'),
(11, 'Electricité', 'pose de lampes et luminaires'),
(12, 'Electricité', 'changer une ampoule'),
(13, 'Electricité', 'pose d objets connectés Nest'),
(14, 'Electricité', 'installation d un radiateur electrique'),
(15, 'Plomberie', 'réparation de fuites d eau'),
(16, 'Plomberie', 'changer une chasse d eau'),
(17, 'Plomberie', 'changer un robinet'),
(18, 'Plomberie', 'déboucher un evier'),
(19, 'Plomberie', 'déboucher un WC'),
(20, 'Plomberie', 'déboucher des canalisations'),
(21, 'Plomberie', 'branchement d une machine à laver'),
(22, 'Plomberie', 'branchement d une lave vaiselle'),
(23, 'Plomberie', 'faire les joints de la salle de bain'),
(24, 'Plomberie', 'réparer une chasse d eau'),
(25, 'Plomberie', 'changer une bonde'),
(26, 'Rénovation', 'peinture intérieure'),
(27, 'Rénovation', 'pose de papier peint'),
(28, 'Rénovation', 'pose de parquet'),
(29, 'Rénovation', 'pose de dalles PVC'),
(30, 'Rénovation', 'pose de dalles de moquettes'),
(31, 'Rénovation', 'décoller un papier peint'),
(32, 'Rénovation', 'enduire un mur'),
(33, 'Rénovation', 'isolation de porte'),
(34, 'Rénovation', 'isolation de fenêtre'),
(35, 'Rénovation', 'remplacer une porte');

-- --------------------------------------------------------

--
-- Structure de la table `statistique`
--

DROP TABLE IF EXISTS `statistique`;
CREATE TABLE IF NOT EXISTS `statistique` (
  `numStatistique` int(30) NOT NULL AUTO_INCREMENT,
  `typeStatistique` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`numStatistique`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `avis`
--
ALTER TABLE `avis`
  ADD CONSTRAINT `foreign key 3` FOREIGN KEY (`id_Prestataire`) REFERENCES `prestataire` (`id_Prestataire`),
  ADD CONSTRAINT `foreign key fk1` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`),
  ADD CONSTRAINT `foreign key fk2` FOREIGN KEY (`nomService`) REFERENCES `service` (`nomService`);

--
-- Contraintes pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD CONSTRAINT `foreign key _FK2` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`),
  ADD CONSTRAINT `foreign key_FK1` FOREIGN KEY (`idFichier`) REFERENCES `fichier` (`idFichier`);

--
-- Contraintes pour la table `demande`
--
ALTER TABLE `demande`
  ADD CONSTRAINT `FOREIGN KEY1` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`),
  ADD CONSTRAINT `FOREIGN KEY2` FOREIGN KEY (`nomService`) REFERENCES `service` (`nomService`);

--
-- Contraintes pour la table `fichier`
--
ALTER TABLE `fichier`
  ADD CONSTRAINT `cle étrangere2` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`),
  ADD CONSTRAINT `clé etrangere1` FOREIGN KEY (`id_Prestataire`) REFERENCES `prestataire` (`id_Prestataire`);

--
-- Contraintes pour la table `prestataire`
--
ALTER TABLE `prestataire`
  ADD CONSTRAINT `foreign key k1` FOREIGN KEY (`nomService`) REFERENCES `service` (`nomService`);

--
-- Contraintes pour la table `sousservice`
--
ALTER TABLE `sousservice`
  ADD CONSTRAINT `foreign key` FOREIGN KEY (`nomService`) REFERENCES `service` (`nomService`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
