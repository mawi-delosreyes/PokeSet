CREATE TABLE Users (
	user_id int(11) NOT NULL AUTO_INCREMENT,
	email varchar(50),
	username varchar(20),
	password varchar(25),
	PRIMARY KEY(user_id)
);

CREATE TABLE Teams (
	team_id int(11) NOT NULL AUTO_INCREMENT,
	user_id int(11),
	team_name varchar(50),
	access bool,
	PRIMARY KEY(team_id)
);

CREATE TABLE PokemonPreset (
	preset_id int(11) NOT NULL AUTO_INCREMENT,
	preset_name varchar(50),
	pokemon_id int(11),
	user_id int(11),
	team_id int(11),
	team_arrange int(2),
	PRIMARY KEY(preset_id)
);

CREATE TABLE MatchDetails (
	match_detail_id int(11) NOT NULL AUTO_INCREMENT,
	team_id int(11),
	user_id int(11),
	match_date date,
	number_of_games int(5),
	opponent_1 int(1),
	opponent_2 int(1),
	opponent_3 int(1),
	opponent_4 int(1),
	opponent_5 int(1),
	opponent_6 int(1),
	result varchar(5),
	PRIMARY KEY(match_detail_id)
);

CREATE TABLE PokemonPresetData (
	preset_data_id int(11) NOT NULL AUTO_INCREMENT,
	preset_id int(11),
	pokemon_id int(11),
	move1_id varchar(50),
	move2_id varchar(50),
	move3_id varchar(50),
	move4_id varchar(50),
	item varchar(50),
	ability varchar(50),
	nature varchar(50),
	battle_mechanic varchar(50),
	type varchar(50),
	ev_id int(11),
	used bool,
	PRIMARY KEY(preset_data_id)
);

CREATE TABLE PokemonEV (
	ev_id int(11) NOT NULL AUTO_INCREMENT,
	hp int(3),
	attack int(3),
	defense int(3),
	special_attack int(3),
	special_defense int(3),
	speed int(3),
	used bool,
	PRIMARY KEY(ev_id)
);

CREATE TABLE PokemonMoves (
	move_id int(11) NOT NULL AUTO_INCREMENT,
	move_name varchar(50),
	type_1 varchar(20),
	type_2 varchar(20),
	PRIMARY KEY(move_id)
);

CREATE TABLE PokemonList(
	pokemon_id int(11) NOT NULL,
	pokemon_name varchar(100) NOT NULL,
	type_1 varchar(50) NOT NULL,
	type_2 varchar(50)
);
