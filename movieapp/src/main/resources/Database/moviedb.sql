-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 10, 2020 at 05:28 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `moviedb`
--

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `movies`
--

CREATE TABLE `movies` (
  `id` int(11) NOT NULL,
  `average_rating` double DEFAULT NULL,
  `overview` longtext DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `movies`
--

INSERT INTO `movies` (`id`, `average_rating`, `overview`, `title`) VALUES
(65683, 6.7, 'Raja lives a poor lifestyle along with his dad, Hazariprasad and mom. He attends college where he has several run-ins with wealthy fellow-collegian, Madhu Mehra. Matters escalate to such an extent that she accuses him of sexually molesting her. When his dad comes to know, he decides to seize this chance to get rich quickly, masquerades as a wealthy businessman, approaches Mr. Mehra, and arranges for their children to get married. Murphy\'s law prevails at the time of the engagement - changing everyone\'s lives forever.', 'Dil'),
(299534, 8.3, 'After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos\' actions and restore order to the universe once and for all, no matter what consequences may be in store.', 'Avengers: Endgame'),
(420818, 7.2, 'Simba idolizes his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub\'s arrival. Scar, Mufasa\'s brother—and former heir to the throne—has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba\'s exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his.', 'The Lion King'),
(30931, 6.4, 'Bubba, an intellectually disabled man, is falsely accused of attacking a young girl. Disguised as a scarecrow, he hides in a cornfield, only to be hunted down and shot by four vigilante men. After they are acquitted due to lack of evidence, the men find themselves being stalked by a mysterious scarecrow.', 'Dark Night of the Scarecrow'),
(645484, 8.2, 'Kizie and Manny, two ordinary people brought together by a tragic twist, embark on a bittersweet and extraordinary journey into the heart of that crazy little thing called \'life\'.', 'Dil Bechara'),
(19404, 8.7, 'Raj is a rich, carefree, happy-go-lucky second generation NRI. Simran is the daughter of Chaudhary Baldev Singh, who in spite of being an NRI is very strict about adherence to Indian values. Simran has left for India to be married to her childhood fiancé. Raj leaves for India with a mission at his hands, to claim his lady love under the noses of her whole family. Thus begins a saga.', 'Dilwale Dulhania Le Jayenge'),
(353898, 7.1, 'After his wife passes away trying to cross a mountain, Manjhi, out of sheer rage, sets on a quest to carve a road through the treacherous mountain.', 'Manjhi: The Mountain Man'),
(353894, 0, 'A prelude to Tongues (1982) which languishes over love and its effect on people.', 'Savage/Love'),
(353892, 3, 'Auditors uncover Accounting fraud at a Fortune 500 Company. The CEO and CFO behind the fraud attempt to coerce the auditors into keeping the fraud quite. Mean-while a worker who recently returns to work after being on a Reality Television show begins infecting others with a highly contagious disease that sends the infected into a violent rage against the non-infected. For the safety of the outside world the FBI declares an emergency and locks the building down, no one is allowed in or out. The people on the inside must survive the onslaught of the Infected people until a vaccine is developed. A contagious disease breaks out in an office building which sends the infected into a violent rage against the non-infected. The FBI quarantines the building forcing the inhabitants to survive the onslaught of the infected until a vaccine is developed.', 'Office Outbreak'),
(12259, 7, 'A Police Officer, whose family was killed by a bandit named Gabbar Singh, decides to fight fire with fire and recruits two convicts, Jai & Veeru, to bring Gabbar Singh to jail alive, but will they succeed in their mission and get their reward? Come and watch the action-packed super-hit Sholay to find out!!', 'Sholay'),
(14609, 6.6, 'When a nuclear missile was fired at Washington in 1945, Captain America managed to detonate it in the upper atmosphere. But then he fell miles into the icy depths of the North Atlantic, where he remained lost for over sixty years. But now, with the world facing the very same evil, Captain America must rise again as our last hope for survival.', 'Ultimate Avengers'),
(1726, 7.6, 'After being held captive in an Afghan cave, billionaire engineer Tony Stark creates a unique weaponized suit of armor to fight evil.', 'Iron Man'),
(256040, 7.5, 'The young Shivudu is left as a foundling in a small village by his mother. By the time he’s grown up, it has become apparent that he possesses exceptional gifts. He meets the beautiful warrior/princess Avanthika and learns that her queen has been held captive for the last 25 years. Shividu sets off to rescue her, discovering his own origins in the process.', 'Bahubali: The Beginning'),
(350312, 7.2, 'When Mahendra, the son of Bahubali, learns about his heritage, he begins to look for answers. His story is juxtaposed with past events that unfolded in the Mahishmati Kingdom.', 'Baahubali 2: The Conclusion'),
(393445, 6.4, 'Ayan falls in love with his soulmate, Alizeh, but she doesn’t reciprocate the feeling. Later, a relationship with Saba helps him realize Alizeh’s value in his life, irrespective of their relationship status.', 'Ae Dil Hai Mushkil'),
(99861, 7.3, 'When Tony Stark tries to jumpstart a dormant peacekeeping program, things go awry and Earth’s Mightiest Heroes are put to the ultimate test as the fate of the planet hangs in the balance. As the villainous Ultron emerges, it is up to The Avengers to stop him from enacting his terrible plans, and soon uneasy alliances and unexpected action pave the way for an epic and unique global adventure.', 'Avengers: Age of Ultron'),
(105025, 6.1, 'Wealthy Jai Mehta is a young man with a heart that has gold. He supports many charitable organizations in India and one day when he visits a deaf and dumb school, he falls in love with the teacher there, Tia Sharma, expresses his love to her and is openly humiliated when she introduces her fiancé, Raj. Soon after Raj and Tia gets married and are proud parents of a baby boy, Anshu. A heart broken Jai takes to alcohol and one night under the influence of alcohol, Jai\'s car collide with Raj and Tia\'s car mysteriously killing Raj and seriously injuring Tia about the head. Tia is treated by doctor, recovers but is unable to remember anything from her troubled past. Jai makes it his responsibility to take care of her, slowly she falls in love with him and proposes marriage. But will this marriage takes place or will Tia remembers her past and takes revenge from Jai for the death of her husband and for her current condition', 'Dil Ka Rishta'),
(277751, 4.3, 'Ayesha (Sameera Reddy) is the elder daughter of rich business tycoon Mr. Verma (Kabir Bedi), an overprotective father who\'s kept his two daughters away from modern influences. Ayesha goes to college and comes in contact with Ajay (Sohail Khan), the leader of a group called Aryans, responsible for handling the security at the college. Ajay\'s soft-spoken nature and humble, down-to-earth attitude soon make Ayesha his most ardent admirer.', 'Maine Dil Tujhko Diya'),
(559082, 6, 'A couple’s caustic, increasingly jarring interactions over a Mumbai evening strain their relationship until it threatens to break at its fraying seams.', 'Lovefucked'),
(166226, 7, 'Three friends, who have known each other for a long time, decide to enter a singing and musical competition.', 'Dil Vil Pyaar Vyaar'),
(526211, 0, 'The Movie Directed by Mohan Baggad.', 'Zinda Dil'),
(155141, 6.3, 'Chided by his family for being the absolute miser, wealthy industrialist Dhaniram (Kader Khan) loves his money as a mother loves a child. This does not auger well with his two sons, Ajay and Vijay (Shashi Kiran and Raj Kiran respectively). The two sons despise their father and find various ways to entrap him, but in vain. Dhaniram gets in the bad books of Income Tax Officer, D.O. Gogi (Shakti Kapoor), and as a result Gogi is arrested and imprisoned. His sister, Dolly (Roshini) and brother, Gulu (Gulshan Grover) both scheme a devious plot that will ensure the death of Dhaniram, and the control of his wealth will rest with them and Gogi.', 'Dariya Dil'),
(429860, 8, 'Ever since Badal was an eight year old, he\'s been in love with violence. As a role model, he chooses the local mafia leader Bachcha Babu. As he grows up, Badal\'s passion for becoming like Bachcha Babu increases. One day, by chance, he gets the opportunity to join Baccha Babu\'s gang. He meets a girl called Megha and falls head over heels for her at first sight. However, she wants nothing to do with him. Megha\'s father, Sharmaji, who is a government school teacher, finds out that Badal is bothering Megha. With the help of his journalist friend, he goes to Bachcha Babu and tells him that Badal is creating trouble in his daughter\'s life. Bachcha Babu assures the journalist that from now on Badal will not disturb Megha and her family. In the course of events Bachcha Babu bumps into Megha and finds that he wants her for himself - at any cost. Bachcha Babu goes to the extent of killing his own wife to marry Megha.', 'Dil Sala Sanki'),
(37574, 7.1, 'One year in the life of a Turkish teacher, teaching the Turkish language to Kurdish children in a remote village in Turkey. The children can\'t speak Turkish, the teacher can\'t speak Kurdish and is forced to become an exile in his own country. On the Way to School is a film about a Turkish teacher who is alone in a village as an authority of the state, and about his interaction with the Kurdish children who have to learn Turkish. The film witnesses the communication problem emphasizing the loneliness of a teacher in a different community and culture; and the changes brought up by his presence into this different community during one year. The film chronicles one school year, starting from September 2007 until the departure of the teacher for summer holiday in June 2008. During this period, they begin to know and understand each other mutually and slowly.', 'On the Way to School'),
(117329, 3.5, 'While traveling by train Shekhar attempts to woo Sanjana Sharma, but finds out she had given her heart to a former boyfriend, Rohit, who is no more. Both share some misadventures en-route to Simla, and upon arrival Shekhar openly declares his love for her knowing fully that this decision will bring nothing but heartbreak for him.', 'Haal-e-Dil'),
(303372, 0, 'Kusam Desai moves from Pune to Bombay with her new husband and family friend Vimal, who does not live up to her expectations.  After discovering Vimal\'s love with Sapna, they must use the Hindu Marriage Act of 1955 in order to obtain a divorce, which is culturally stigmatized.', 'Dil... Akhir Dil Hai'),
(510404, 7.3, 'Koroli Nair, the sole child of a London based business tycoon, settles in Delhi to fulfil her ‘pursuit of happiness’. Much to her dad’s disappointment,she has no interest in upgrading herself as an entrepreneur & wants to settle down with a man and be a mother to her future kids. She teaches English at the British Council in New Delhi which makes her feel content & satisfied in her own way.', 'Dil Juunglee'),
(23766, 3.7, 'Billa, a ruthless international crime lord wanted in at least eleven countries, operates from Kuala Lumpur. The only person he answers to is his unseen boss: \"Devil.\" ACP Krishna Murthy is one of several officers working with Interpol to catch Billa. But when one of his informants is killed, Murthy begins to suspect a mole within the police. Eventually, Billa is killed, and Murthy is the only witness. When he learns of Ranga --a pickpocket and Billa-lookalike, Murthy sets up a secret operation. Ranga takes Billa\'s place to learn the gang\'s secrets. Chased by the uninformed law, suspected by the gang, and hunted by a vengeful femme-fatale; Ranga finds himself in extreme danger from all sides.', 'Billa'),
(694072, 0, 'Billa No 786 is the story of Shankar who had promised his dying mother that he would marry her friends daughter Pinky and thus fulfill her dream. After his mother\'s death along with sister (Kavita) and his dear monkey he went to look for his mother\'s sister to Rampur. there he meets Siddhu (Sidharth Dhavan). Siddhu takes Shankar to Flora Aunty\'s (Zubeida) locality to live there, with the help of the local people he gets a job of a coolie and with his good fortune he gets the Billa No. 786.One day he meets the rich girl Pinky (Rutika) who hates the poor. Dhankeshwar (Mohan Joshi), the owner of the basti , hates Shankar and tries different tricks to trap Shankar and to empty the locality. One day Dhankeshwar succeeds and Shankar is trapped. Does Dhankeshwar succeeds in vacating the locality and building a 5-star hotel? Does Shankar succeed in breaking Rutik\'s pride and fulfill his mother\'s dream?', 'Billa No. 786'),
(17478, 6.1, 'A gang of bikers headed by the cool-headed and arrogant Kabir is on a robbing spree in Mumbai. They rob establishments and then zip away on their superbikes. ACP Jai Dixit is the case in-charge and he recruits a bumbling bike mechanic and racer named Ali to chase the gang on a bike and help Jai nab them. Kabir accepts the challenge, and pulls off another robbery amidst a function. This causes Jai and Ali to call it off. Jai resigns from the police force and Ali goes back to his daily job. Meanwhile Kabir has lost one of his team members and recruits Ali for their final job in Goa. The action shifts from the congested Mumbai traffic to the sunny Goa for the final showdown between cops and robbers.', 'Dhoom'),
(14194, 6.2, 'Jai and Ali return, this time on the trail of an international thief who steals priceless artifacts and has chosen Mumbai as his next target.', 'Dhoom 2'),
(69568, 4.7, 'A brilliant medical practitioner finds himself at the centre of a murder plot after taking the daughter of a Russian Police Commissioner back to his hotel room.', 'Dhaam Dhoom'),
(1024, NULL, 'A brilliant medical practitioner finds himself at the centre of a murder plot after taking the daughter of a Russian Police Commissioner back to his hotel room.', 'Dhaam Dhoom'),
(540, NULL, 'A brilliant medical practitioner finds himself at the centre of a murder plot after taking the daughter of a Russian Police Commissioner back to his hotel room.', 'Dhaam Dhoom'),
(102455, NULL, 'A brilliant medical practitioner finds himself at the centre of a murder plot after taking the daughter of a Russian Police Commissioner back to his hotel room.', 'Dhaam Dhoom'),
(1555, NULL, 'A brilliant medical practitioner finds himself at the centre of a murder plot after taking the daughter of a Russian Police Commissioner back to his hotel room.', 'Dhaam Dhoom'),
(280882, 4.1, 'Prithvi, a young man, is haunted by his past and despite his mother\'s attempts, refuses to come out of his shell. He begins to move on after he falls in love with Samyuktha, a chirpy girl, he meets accidentally. But she is kidnapped by some bikers when out on a joyride and Prithvi is forced to confront his past.', 'Irumbu Kuthirai'),
(172799, 7, 'Doctor Octavius was a brilliant scientist working on a revolutionary new invention until a laboratory accident fused a set of mechanical arms to his body and turned him into the dreaded supervillain Doctor Octopus. Now Doc Ock seeks his revenge on those who did him wrong, and there are only two men who can put an end to his plan of destruction - Spider-Man or his secret alter-ego, Peter Parker.', 'Spider-Man vs. Doc Ock');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `password`) VALUES
(1, 'ashish', '1234'),
(2, 'nilesh', '123');

-- --------------------------------------------------------

--
-- Table structure for table `user_movie_ratings`
--

CREATE TABLE `user_movie_ratings` (
  `movie_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `rating` double DEFAULT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_movie_ratings`
--

INSERT INTO `user_movie_ratings` (`movie_id`, `user_id`, `rating`, `timestamp`) VALUES
(299534, 1, 8.5, '2020-07-28 03:05:25'),
(420818, 1, 9, '2020-07-23 11:56:47'),
(30931, 1, 9, '2020-07-25 10:53:08'),
(645484, 1, 8, '2020-07-28 02:23:16'),
(19404, 1, 9.4, '2020-07-28 02:26:04'),
(353898, 1, 7, '2020-07-28 02:30:20'),
(353894, 1, 7.5, '2020-07-28 02:56:01'),
(353892, 1, 7, '2020-07-28 02:56:40'),
(12259, 1, 8.5, '2020-07-28 03:04:43'),
(14609, 1, 8, '2020-07-28 03:05:46'),
(1726, 1, 8, '2020-07-28 03:06:19'),
(256040, 1, 8, '2020-07-28 03:06:56'),
(350312, 1, 8.3, '2020-07-28 03:07:19'),
(99861, 1, 9.2, '2020-08-04 02:13:12'),
(393445, 1, 9, '2020-08-04 02:16:40'),
(65683, 1, 8, '2020-08-04 02:16:58'),
(105025, 1, 7, '2020-08-04 02:17:11'),
(277751, 1, 6, '2020-08-04 02:17:32'),
(559082, 1, 7.8, '2020-08-04 02:17:48'),
(166226, 1, 6.9, '2020-08-04 02:18:17'),
(526211, 1, 5.8, '2020-08-04 02:18:36'),
(155141, 1, 6, '2020-08-04 02:18:51'),
(429860, 1, 7.6, '2020-08-04 02:19:07'),
(37574, 1, 7.5, '2020-08-04 02:19:22'),
(117329, 1, 4, '2020-08-04 02:19:38'),
(303372, 1, 1, '2020-08-04 02:19:51'),
(510404, 1, 7.3, '2020-08-04 02:20:08'),
(23766, 1, 3, '2020-08-04 04:57:29'),
(694072, 1, 4, '2020-08-04 04:59:34'),
(17478, 1, 6.5, '2020-08-04 05:00:43'),
(14194, 1, 7, '2020-08-04 05:48:49'),
(69568, 1, 7, '2020-08-04 06:21:17'),
(1024, 1, 7, '2020-08-04 06:34:14'),
(540, 1, 7, '2020-08-04 07:02:34'),
(102455, 1, 7, '2020-08-04 07:02:50'),
(1555, 1, 7, '2020-08-04 07:28:46'),
(280882, 1, 3.2, '2020-08-04 07:42:55'),
(172799, 1, 7.5, '2020-08-07 04:30:13');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `movies`
--
ALTER TABLE `movies`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_movie_ratings`
--
ALTER TABLE `user_movie_ratings`
  ADD PRIMARY KEY (`movie_id`,`user_id`),
  ADD KEY `FK83q949o96wbrxmiawy30v2ih` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
