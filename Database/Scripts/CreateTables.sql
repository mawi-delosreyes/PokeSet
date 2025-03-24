CREATE TABLE Users (
	user_id int(11),
	email varchar(50),
	username varchar(20),
	password varchar(25),
	PRIMARY KEY(user_id)
);

CREATE TABLE Teams (
	team_id int(11),
	user_id int(11),
	team_name varchar(50),
	access bool,
	PRIMARY KEY(team_id)
);

CREATE TABLE PokemonPreset (
	preset_id int(11),
	preset_name varchar(50),
	pokemon_id int(11),
	user_id int(11),
	team_id int(11),
	team_arrange int(2),
	PRIMARY KEY(preset_id)
);

CREATE TABLE MatchDetails (
	match_detail_id int(11),
	team_id int(11),
	user_id int(11),
	match_date date,
	number_of_games int(5),
	pokemon_preset_id_1 int(1),
	pokemon_preset_id_2 int(1),
	pokemon_preset_id_3 int(1),
	pokemon_preset_id_4 int(1),
	pokemon_preset_id_5 int(1),
	pokemon_preset_id_6 int(1),
	result varchar(5),
	PRIMARY KEY(match_detail_id)
);

CREATE TABLE PokemonPresetData (
	preset_data_id int(11),
	preset_id int(11),
	pokemon_id int(11),
	move_1 varchar(50),
	move_2 varchar(50),
	move_3 varchar(50),
	move_4 varchar(50),
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
	ev_id int(11),
	hp int(3),
	attack int(3),
	defense int(3),
	special_attack int(3),
	special_defense int(3),
	speed int(3),
	used bool,
	PRIMARY KEY(ev_id)
);