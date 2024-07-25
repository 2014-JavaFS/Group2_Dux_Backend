create table users(
	user_id serial primary key,
	username varchar(20) unique not null,
	email varchar(20) unique not null,
	password varchar(20) not null,
	registration_date date not null
);

create type rarity_enum as enum ('COMMON', 'UNCOMMON','RARE', 'EPIC', 'LEGENDARY');
create type condition_enum as enum ('MINT', 'NM', 'LP', 'HP', 'DMG');

create table ducks(
	duck_id serial primary key,
	duck_name varchar(20) not null,
	description varchar(100),
	rarity rarity_enum not null default 'COMMON',
	release_year smallint not null,
	duck_condition condition_enum not null default 'NM',
	price decimal(10, 2) not null
);

create type status_enum as enum ('CART', 'PROCESSING', 'COMPLETE');

create table orders(
	order_id serial primary key,
	buyer int references users(user_id) not null,
	seller int references users(user_id),
	duck int references ducks(duck_id) not null,
	order_date date,
	quantity smallint not null default 1,
	status status_enum default 'CART'
);