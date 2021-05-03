--drop table users, reimbursements;
--truncate table users, reimbursements;

create table users (
	id serial primary key,
	username varchar(255) not null unique,
	password varchar(255) not null,
	firstname varchar(255) not null,
	lastname varchar(255),
	is_manager boolean not null,
	manager_id int
);

create table reimbursements (
	id serial primary key,
	requested_by integer references users(id),
	amount numeric(50,2) not null,
	type varchar(20) not null,
	description varchar(500),
	date_created date not null default CURRENT_DATE,
	status varchar(30) not null,
	feedback varchar(500)
);

INSERT INTO users(username, password, firstname, lastname, is_manager, manager_id) 
VALUES ('BenTheTrainer', 'pass123', 'Benjamin', 'Trainerman', false, 3);

INSERT INTO users(username, password, firstname, lastname, is_manager, manager_id) 
VALUES ('JonathanG', 'pass123', 'Jonathan', 'G', false, 3);

INSERT INTO users(username, password, firstname, lastname, is_manager) 
VALUES ('FinanceMan', 'pass123', 'Finance', 'Man', true);