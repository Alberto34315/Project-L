-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 23-05-2020 a las 20:48:39
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `projectl`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `champions`
--

CREATE TABLE IF NOT EXISTS `champions` (
  `codChamp` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) NOT NULL,
  `description` varchar(500) NOT NULL,
  `p` varchar(500) NOT NULL,
  `q` varchar(500) NOT NULL,
  `w` varchar(500) NOT NULL,
  `e` varchar(500) NOT NULL,
  `r` varchar(500) NOT NULL,
  PRIMARY KEY (`codChamp`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `champions`
--

INSERT INTO `champions` (`codChamp`, `nombre`, `description`, `p`, `q`, `w`, `e`, `r`) VALUES
(1, 'Aatrox', 'Aatrox and his brothers, once respected defenders of Shurima against the Void, would end up becoming an even \ngreater threat to Runeterra and knew only defeat from the cunning use of deadly spells. \nHowever, after centuries of seclusion, Aatrox was the first to regain his freedom and dedicated himself to corrupting and \ntransforming any fool who tried to wield the magic weapon that contained its essence.', 'Aatrox''s next basic attack gains 50 bonus range \nand deals 5-12% of the target''s maximum health \nas bonus physical damage (based on level),\n while healing Aatrox for 100% of the bonus physical\n damage dealt (reduced to 25% against minions). \n This damage is capped at 100 against monsters.', 'Aatrox swings his greatsword in the target direction, \nstriking enemies in a line.\n The Darkin Blade can then be \n reactivated twice within 4 seconds,\n with the second cast refreshing the timer.\n The second cast strikes enemies in a cone and \n the third in the target area. \n The first cast deals 10 / 30 / 50 / 70 / 90 \n (+0.6 / 0.65 / 0.7 / 0.75 / 0.8 per attack damage) physical damage,\n increasing by 25% on the second cast and 50% on the third.\n The Darkin Blade deals 55% damage to minions.', 'Aatrox smashes the ground in the target direction, \ncreating a chain that stops on the first enemy hit, \ndealing 30 / 40 / 50 / 60 / 70 (+0.4 per attack damage) \nphysical damage (doubled against minions) \nand slowing them by 25% for 1.5 seconds.\n If Infernal Chains hits a champion or large monster, \n they are chained to the impact area. \n If the chained enemy is still in the impact area after 1.5 seconds,\n they are dragged to the center and take the same damage again.', 'Passive: Aatrox heals for 20 / 22.5 / 25 / 27.5 / 30% \nof the non-periodic damage he deals to champions.\nActive: Aatrox dashes in the target direction.\nUmbral Dash can be cast during his other \nspellcasts without interrupting them.', 'After 0.25 seconds, Aatrox reveals his true demonic form for 10 seconds. \nOn activation, he fears nearby enemy minions for 3 seconds \nand gains 60 / 80 / 100% bonus movement speed,\n decaying over the duration.\nWhile World Ender persists, Aatrox gains 20 / 25 / 30% bonus attack damage \nand receives 50 / 60 / 70% increased self-healing.\nOn enemy champion takedown, \nthe duration of World Ender is extended by 5 seconds \nand the movement speed increase is refreshed.'),
(2, 'Ahri', 'Ahri is a vastaya innately connected to the latent power of Runeterra, \nand is capable of turning magic into orbs of pure energy. It likes to play with its prey, \nmanipulating its emotions before devouring its essence of life. \nDespite her predatory nature, Ahri has a certain sense of empathy, \nas she receives memories from every soul she consumes.', 'If Ahri earns 2 spell hits against an enemy champion within a 1.5 second period,\n she gains 20% movement speed for 3 seconds.', 'Ahri throws out and pulls back her orb, \ndealing 40 / 65 / 90 / 115 / 140 (+35% of ability power) \nmagic damage on the way out and\n40 / 65 / 90 / 115 / 140 (+35% of ability power) true damage on the way back.\nIf Ahri earns 9 spell hits (max 3 per cast), \nshe gains Essence Theft, causing her next Q cast that \nlands to restore 3 / 5 / 9 / 18 (at levels 1 / 6 / 11 / 16)\n health for each enemy hit.', 'attack nearby enemies (prioritizes champions),\n dealing 40 / 65 / 90 / 115 / 140 (+30% of ability power) magic damage.\n Additional fox-fires that hit the same target deal 30% damage,\n up to a maximum total damage of 64 / 104 / 144 / 184 / 224 (+48% of ability power).\nFox-Fire prioritizes any enemy champion affected by Charm''s damage amp \nand the target Ahri most recently basic-attacked within the past 3 seconds.', 'Ahri blows a kiss that deals 60 / 90 / 120 / 150 / 180 (+40% of ability power)\n magic damage to an enemy and charms it,\n interrupting in-progress dashes and\n causing them to walk harmlessly towards her \n for 1.4 / 1.55 / 1.7 / 1.85 / 2 seconds.\nWhen Charm damages a champion, \nAhri''s abilities deal 20% more damage to them for 3 seconds.', 'Ahri dashes forward and fires essence bolts, \ndamaging 3 nearby enemies (prioritizes champions) \nfor 60 / 90 / 120 (+35% of ability power) magic damage per bolt.\n Spirit Rush can be cast up to three times \n within ten seconds before going on cooldown.\n Maximum total magic damage to a single\n target is 210 / 330 / 450 (+75% of ability power).'),
(3, 'Braum', 'Blessed with huge biceps and an even bigger heart,\n Braum is a highly regarded hero in Freljord. \n All the taverns to the north of Frozen Fort toast their legendary strength.\n He is said to have cut down an oak forest in one night and turned an entire mountain into rubble.\n Carrying an enchanted armored door behind him as a shield, \n Braum walks the icy north wearing a mustached \n smile as big as his muscles: a true friend to all in need.', 'Braum''s basic attacks and Winter''s Bite apply stacks of Concussive Blows.\n Once the first stack has been applied, the basic attacks of any allied \n champion will generate Concussive Blow stacks. \n Upon reaching 4 stacks, the target is stunned for 1.25 / 1.5 / 1.75\n seconds and takes 16 + (10 * level) magic damage. After an opponent\n is stunned from Concussive Blows, they no longer gain concussive blow\n stacks and instead take 14-48 bonus magic damage \n from basic attacks for the next 8 seconds.', 'Braum propels ice from his shield that travels forward in a line,\n dealing 60 / 105 / 150 / 195 / 240 (+2.5% of Braum''s max. health) \n magic damage and slowing the first enemy hit by 70% that decays over 2 seconds.', 'Braum leaps to the aid of a nearby ally, \npositioning himself between his target and their nearest enemy champion.\n On arrival, the ally gains 10 / 14 / 18 / 22 / 26 (+12% bonus armor and magic resist)\n bonus resistances and Braum \n gains 10 / 14 / 18 / 22 / 26 (+36% bonus armor and magic resist) \n bonus resistances for 3 seconds.', 'Braum raises his shield, creating a barrier that intercepts all oncoming,\n hostile projectiles for the next 3 / 3.25 / 3.5 / 3.75 / 4 seconds.\nBraum takes no damage from the first projectile he intercepts\n and 30 / 32.5 / 35 / 37.5 / 40% reduced damage from intercepted \n projectiles thereafter, and gains 10% movement speed for the duration.', 'Braum slams his shield into the ground, dealing 150 / 300 / 450 (+60% AP)\nmagic damage to all enemies in a line as well as those in an X-radius area around him.\n The first champion hit is knocked up for 1-1.5 seconds based on distance from \n Braum for the first target hit in the fissure, every other target hit \n or within close vicinity is knocked up for 0.25 seconds.\n For the next 4 seconds a field of ice remains,\n slowing enemies that enter the area by 40 / 50 / 60% for 0.25 seconds.'),
(4, 'Caitlyn', 'Recognized as her best peacemaker, Caitlyn is also Piltover''s\n best weapon to rid the city of its elusive criminal elements.\n She often works with Vi, and acts as a cold and efficient counterpoint to \n her partner''s most brash nature. Despite carrying a unique hextech rifle,\n Caitlyn''s most powerful weapon is her superior intelligence, \n allowing her to set up elaborate traps for any lawbreaker\n foolish enough to operate in the City of Progress.', 'Caitlyn''s next basic attack against enemies rooted by \nYordle Snap Trap or Slow icon slowed by 90 Caliber Net has 1300 range\n and deals 50-100% AD (at levels 1-18) (+ 150% critical strike chance)\n bonus physical damage, increased to 100% AD + (+ 150% critical strike chance) versus non-champions.', 'Caitlyn revs up her rifle for 1 second to unleash a penetrating \nshot which deals 50 / 90 / 130 / 170 / 210 (+1.3 / 1.4 / 1.5 / 1.6 / 1.7 per attack damage)\nto the first target struck, then widens by 30 units,\ndealing 60% damage to any additional enemies.\nPiltover Peacemaker always deals 100% damage to champions revealed by Yordle Snap Trap.', 'Caitlyn sets up to 3 / 3 / 4 / 4 / 5 \ntraps which trigger on champions.\nWhen sprung, the trap immobilizes the champion for 1.5 \nseconds and reveals it for 3 seconds. Traps last 30 / 35 / 40 / 45 / 50 seconds.\nCaitlyn can also fire one 1300 range Headshot at trapped targets, \ndealing 60 / 105 / 150 / 195 / 240 \n(+0.4 / 0.55 / 0.7 / 0.85 / 1.0 per bonus attack damage) physical damage.', 'Caitlyn fires a heavy net that slows down her target by 50% \nfor 1 second and deals 70 / 110 / 150 / 190 / 230 (+80% of ability power) magic damage.\nThe recoil knocks Caitlyn back 400 units.\nCaitlyn can also Headshot netted targets once at 1300 range.', 'Caitlyn takes time to line up the perfect shot,\n dealing 300 / 525 / 750 (+2.0 per bonus attack damage) \n physical damage to a single target at a huge range.\n Enemy champions can intercept the bullet for their ally.\n It provides vision of the target for the duration.'),
(5, 'Lee Sin', 'Lee Sin, Ionia''s master of ancient martial arts, \nis a principled fighter who channels the essence of the dragon\n spirit to meet any challenge. Although he lost his sight many years ago,\n the warrior monk has dedicated his life to protecting his home against anyone\n who dares to upset his sacred balance. Enemies who underestimate his meditative \n attitude will have to deal with his legendary fiery fists and blazing spinning kicks.', 'After Lee Sin uses an ability, his next 2 basic attacks within 3 \nseconds gain 40% Attack Speed and return 20 / 30 / 40 and 10 / 15 / 20 \nenergy respectively (at levels 1 / 7 / 13).', 'Sonic Wave: Lee Sin projects a discordant wave of sound to locate his enemies,\ndealing 55 / 80 / 105 / 130 / 155 (+1.0 per bonus attack damage) physical damage \nto the first enemy it encounters and revealing them for 3 seconds. \nIf Sonic Wave hits, Lee Sin can cast Resonating Strike within the next 3 seconds.', 'Safeguard: Lee Sin rushes towards a target ally, shielding him \n(and his target if it is a champion) for 55 / 110 / 165 / 220 / 275 (+80% of ability power)\nfor the next 2 seconds. After using Safeguard, Lee Sin can cast Iron Will for the next 3 seconds.Iron Will (30 energy):\nLee Sin''s intense training allows him to thrive in battle. For 5 seconds,\nLee Sin gains 10 / 15 / 20 / 25 / 30 % lifesteal and spell vamp.', 'Tempest: Lee Sin smashes the ground sending out a shockwave that deals \n80 / 120 / 160 / 200 / 240 (+1.0 per bonus attack damage)\nmagic damage and reveals enemy units hit for 4 seconds.\nIf Tempest hits an enemy, Lee Sin can cast cripple for the next 3 seconds.\nCripple (30 energy): Lee Sin cripples nearby enemies revealed by Tempest,\nreducing their Movement Speed by 20 / 30 / 40 / 50 / 60 % for 4 seconds.\nMovement Speed recovers gradually over the duration.', 'Lee Sin performs a powerful roundhouse kick launching his\ntarget back 1200 units, dealing 175 / 400 / 625 (+2.0 per bonus attack damage)\n physical damage to the target and any enemies they collide with.\n Enemies the target collides with are knocked into the air for a short\n duration and take 15 / 18 / 21% of the target''s bonus health as physical damage.\n'),
(6, 'Trundle', 'Trundle is a colossal twisted troll with a ruthless personality.\n There is nothing that he is not able to subdue with a blow, not even the Freljord himself.\n His tremendous territorial instinct moves him to chase anyone bold enough to venture into his domain.\n When he brandishes his tremendous club of pure ice, \n it leaves enemies frozen to the bone and pierces them with sharp frozen pillars.\n Later, he mocks as they bleed to death in the cold tundra.', 'Whenever an enemy unit near Trundle dies, he heals for 2 / 3 / 4 / 5 / 6 %\n of their maximum health. The amount is increased at levels 5, 9, 12 and 15.', 'Trundle enhances his next basic attack, dealing 20 / 40 / 60 / 80 / 100 \n(+ 110 / 120 / 130 / 140 / 150 % of total AD) physical damage \nand slowing its target by 75% for 0.1 seconds. This attack increases Trundle''s \nattack damage by 20 / 25 / 30 / 35 / 40 for 5 seconds, \nwith his opponent losing half of this amount for the same duration.', 'Trundle coats a target 1000-radius location with ice for 8 seconds, \ngaining 30 / 35 / 40 / 45 / 50% bonus movement speed,\n 30 / 47.5 / 65 / 82.5 / 100% attack speed, and 25% increased healing \n and regeneration from all sources while he is on it.', 'Trundle creates an icy pillar at a target location for 6 seconds,\ncreating impassable terrain and slowing all enemy units by 20 / 30 / 40 / 50 / 60%\naround the pillar for 0.25 seconds. The slow duration is refreshed\nif enemies stay within the area around the pillar.\nEnemies caught in the center of the eruption are briefly knocked back.', 'Trundle drains 20 / 27.5 / 35 % (+ 2% per 100AP) of an enemy champion''s\n max health as magic damage and 40% of their armor and magic resist,\n half immediately and half over 4 seconds. The armor and magic resist bonus/reduction\n lasts for 4 after it has been fully applied.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `game`
--

CREATE TABLE IF NOT EXISTS `game` (
  `codGame` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`codGame`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `game`
--

INSERT INTO `game` (`codGame`) VALUES
(1),
(2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `participates`
--

CREATE TABLE IF NOT EXISTS `participates` (
  `codGame` int(11) NOT NULL,
  `codRune` int(11) NOT NULL,
  `codChamp` int(11) NOT NULL,
  PRIMARY KEY (`codGame`,`codRune`,`codChamp`),
  KEY `codRune` (`codRune`),
  KEY `codChamp` (`codChamp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `participates`
--

INSERT INTO `participates` (`codGame`, `codRune`, `codChamp`) VALUES
(2, 11, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `runes`
--

CREATE TABLE IF NOT EXISTS `runes` (
  `codRune` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `RuneType` varchar(25) NOT NULL,
  `DescriptionType` varchar(500) NOT NULL,
  `R1` varchar(25) NOT NULL,
  `DescriptionRunesPrimary` varchar(500) NOT NULL,
  `S1` varchar(25) NOT NULL,
  `DescriptionS1` varchar(500) NOT NULL,
  `S2` varchar(25) NOT NULL,
  `DescriptionS2` varchar(500) NOT NULL,
  `S3` varchar(25) NOT NULL,
  `DescriptionS3` varchar(500) NOT NULL,
  `R2` varchar(25) NOT NULL,
  `DescriptionRunesSecondary` varchar(500) NOT NULL,
  `S4` varchar(25) NOT NULL,
  `DescriptionS4` varchar(500) NOT NULL,
  `S5` varchar(25) NOT NULL,
  `DescriptionS5` varchar(500) NOT NULL,
  `B1` varchar(25) NOT NULL,
  `DescriptionB1` varchar(500) NOT NULL,
  `B2` varchar(25) NOT NULL,
  `DescriptionB2` varchar(500) NOT NULL,
  `B3` varchar(25) NOT NULL,
  `DescriptionB3` varchar(500) NOT NULL,
  PRIMARY KEY (`codRune`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=14 ;

--
-- Volcado de datos para la tabla `runes`
--

INSERT INTO `runes` (`codRune`, `name`, `RuneType`, `DescriptionType`, `R1`, `DescriptionRunesPrimary`, `S1`, `DescriptionS1`, `S2`, `DescriptionS2`, `S3`, `DescriptionS3`, `R2`, `DescriptionRunesSecondary`, `S4`, `DescriptionS4`, `S5`, `DescriptionS5`, `B1`, `DescriptionB1`, `B2`, `DescriptionB2`, `B3`, `DescriptionB3`) VALUES
(10, 'Prueba1', 'Precision', 'Improved attacks and sustained damage', 'Conqueror', 'Ranged basic attacks on-hit against enemy champions grant 1 stack of Conqueror, while Melee role melee basic attacks on-hit grant 2 stacks. Abilities that deal damage to an enemy champion always grant 2 stacks.', 'Overheal', 'Converts 20% ? 100% (based on level) of the Heal power healing in excess of your maximum health into a Hybrid resistances icon shield for an amount of up to 10 (+ 10% of maximum health).', 'Promptness', ' Gain 3% (+ 1.5% per Legend stack) Attack speed icon bonus attack speed, up to 18% with 10 stacks.\nLEGEND: Gain Legend stacks for every 100 points earned, up to 10:\n100 points for champion Damage rating takedowns\n100 points for epic monster Damage rating takedowns\n25 points for large monster kills\n4 points for minion kills', 'CoupOfGrace', 'Deal 8% increased damage to champions below 40% maximum health.', 'Resolve', 'Durability and crowd control', 'FontOfLife', 'Slowing or Stun icon immobilizing an enemy Champion icon champion marks them for 4 seconds.\nAllied champions (excluding you) who basic attack marked enemies Heal power heal for 5 (+ 1% of your Health icon maximum health) over 1.75 seconds.', 'Conditioning', 'After 12 minutes, gain Armor icon 9 bonus armor and Magic resistance icon 9 bonus magic resistance and increases your total armor and magic resistance by 5%.', 'AdaptiveForce', '5.4 bonus Attack Damage or 9 Ability Power (Adaptive)', 'Armor', '6 bonus armor', 'Armor', '6 bonus armor'),
(11, 'Prueba2', 'Sorcery', 'Empowered abilities and resource manipulation', 'SummonAery', 'Basic attacks, abilities, item effects, and summoner spells against an enemy Champion icon champion signals Aery to dash to them, dealing 10 ? 40 (based on level) (+ 15% bonus AD) (+ 10% AP) Attack damageAbility power Adaptive damage. Heal power Healing, shielding, or buffing an ally signals Aery to dash to them, Hybrid resistances icon shielding them for 35 ? 80 (based on level) (+ 40% bonus AD) (+ 25% AP) for 2 seconds.', 'NullifyingOrb', 'If you would take Magic damage magic damage that would reduce you below 30% of your Health icon maximum health, you first gain a Hybrid resistances icon shield that absorbs 40 ? 120 (based on level) (+ 15% bonus AD) (+ 10% AP) magic damage for 4 seconds', 'Celerity', 'All Movement speed icon movement speed bonuses are 7% more effective on you.\nAdditionally, you gain 1% bonus movement speed.', 'Scorch', 'Your next damaging ability hit sets enemy Champion icon champions on fire, dealing 15 ? 35 (based on level) Ability power icon bonus magic damage after 1 second.', 'Domination', 'Burst damage and target access', 'CheapShot', 'Basic attacks and damaging abilities deal 10 ? 45 (based on level) Hybrid penetration bonus true damage to Champion icon champions with impaired movement or actions.', 'ZombieWard', ' Scoring a Damage rating takedown on an enemy Ward icon ward summons a friendly Farsight Ward icon Zombie Ward in its place (10 second assist timer).\nGain 1.2 bonus Attack Damage or 2 Ability Power (Adaptive) for every Zombie Ward spawned, up to 10, for a maximum of 12 bonus Attack Damage or 20 Ability Power (Adaptive). After spawning 10 Zombie Wards, gain an additional 6 bonus Attack Damage or 10 Ability Power (Adaptive).', 'AdaptiveForce', '5.4 bonus Attack Damage or 9 Ability Power (Adaptive)', 'AdaptiveForce', '5.4 bonus Attack Damage or 9 Ability Power (Adaptive)', 'Armor', '6 bonus armor'),
(12, 'Prueba3', 'Resolve', 'Durability and crowd control', 'GraspOfTheUndying', 'Entering combat generates one stack every second for the next 3 seconds. Additional stacks may be generated by re-entering combat after 2 seconds. After reaching 4 stacks, your next basic attack within 6 seconds against an enemy Champion icon champion consumes all stacks to deal 4% of your maximum health in Magic damage bonus magic damage, restore 2% of your Health icon maximum health, and permanently grant 5 bonus health. The empowered attack duration refreshes whenever going in combat.', 'Demolish', 'You generate stacks on enemy Turret icon turrets within 600 units, up to 6 after 3 seconds. Your next basic attack against a turret with 6 stacks deals 100 (+ 35% of your maximum health) bonus physical damage. Demolish will only go on Cooldown reduction icon cooldown upon triggering the damage.\nStacks fall off slowly if you move out of range.', 'Conditioning', 'After 12 minutes, gain Armor icon 9 bonus armor and Magic resistance icon 9 bonus magic resistance and increases your total armor and magic resistance by 5%.', 'Overgrowth', 'Every 8 Monster icon monsters or enemy Minion icon minions that die near you permanently grants 3 bonus health.\nAfter gaining 15 stacks (120 monsters or minions), you gain an additional 3.5% Health icon maximum health.', 'Precision', 'Improved attacks and sustained damage', 'Triumph', 'Champion Damage rating takedowns, after a 1-second delay, Heal power restore 12% of your missing health and grant an additional Gold 20.', 'Tenacity', 'Gain 5% (+ 2.5% per Legend stack) Tenacity icon Tenacity, up to 30% with 10 stacks.\nLEGEND: Gain Legend stacks for every 100 points earned, up to 10:\n100 points for champion Damage rating takedowns\n100 points for epic monster Damage rating takedowns\n25 points for large monster kills\n4 points for minion kills', 'AdaptiveForce', '5.4 bonus Attack Damage or 9 Ability Power (Adaptive)', 'AdaptiveForce', '5.4 bonus Attack Damage or 9 Ability Power (Adaptive)', 'Armor', '6 bonus armor'),
(13, 'Prueba4', 'Resolve', 'Durability and crowd control', 'Aftershock', 'Immobilizing an enemy Champion icon champion grants a static 35 (+ 80% bonus armor) bonus armor and 35 (+ 80% bonus magic resistance) bonus magic resistance for 2.5 seconds. The bonus resistances are capped at 80 ? 150 (based on level).', 'Demolish', 'You generate stacks on enemy Turret icon turrets within 600 units, up to 6 after 3 seconds. Your next basic attack against a turret with 6 stacks deals 100 (+ 35% of your maximum health) bonus physical damage. Demolish will only go on Cooldown reduction icon cooldown upon triggering the damage.\nStacks fall off slowly if you move out of range.', 'Conditioning', 'After 12 minutes, gain Armor icon 9 bonus armor and Magic resistance icon 9 bonus magic resistance and increases your total armor and magic resistance by 5%.', 'Overgrowth', 'Every 8 Monster icon monsters or enemy Minion icon minions that die near you permanently grants 3 bonus health.\nAfter gaining 15 stacks (120 monsters or minions), you gain an additional 3.5% Health icon maximum health.', 'Precision', 'Improved attacks and sustained damage', 'Tenacity', 'Gain 5% (+ 2.5% per Legend stack) Tenacity icon Tenacity, up to 30% with 10 stacks.\nLEGEND: Gain Legend stacks for every 100 points earned, up to 10:\n100 points for champion Damage rating takedowns\n100 points for epic monster Damage rating takedowns\n25 points for large monster kills\n4 points for minion kills', 'CutDown', 'Deal 5% to 15% increased damage to champions, based on how much more maximum health they have than you. Bonus damage scales up linearly against enemies with 10% to 100% more maximum health than you.', 'AdaptiveForce', '5.4 bonus Attack Damage or 9 Ability Power (Adaptive)', 'AdaptiveForce', '5.4 bonus Attack Damage or 9 Ability Power (Adaptive)', 'Armor', '6 bonus armor');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `participates`
--
ALTER TABLE `participates`
  ADD CONSTRAINT `participates_ibfk_1` FOREIGN KEY (`codGame`) REFERENCES `game` (`codGame`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `participates_ibfk_2` FOREIGN KEY (`codRune`) REFERENCES `runes` (`codRune`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `participates_ibfk_3` FOREIGN KEY (`codChamp`) REFERENCES `champions` (`codChamp`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
