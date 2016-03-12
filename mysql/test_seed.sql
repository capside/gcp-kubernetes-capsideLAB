create database test;
create user testuser identified by '1234';
grant all on test.* to testuser;

use test;

create table movies (
	id int(6) auto_increment ,
	name varchar(50) CHARACTER SET utf8 COLLATE utf8_bin,
	publish_date date,
	description text CHARACTER SET utf8 COLLATE utf8_bin,

	primary key (id)
);

insert into movies (name,publish_date,description) values ('Lolo','20150301','A french movie, what else is there to say?');
insert into movies (name,publish_date,description) values ('Eye in the Sky','20160301','Col. Katherine Powell, a military officer in command of an operation to capture terrorists in Kenya, sees her mission escalate when a girl enters the kill zone triggering an international dispute over the implications of modern warfare');
insert into movies (name,publish_date,description) values ('River of Grass','19951013','Cozy, a dissatisfied housewife, meets Lee at a bar. A drink turns into a home break-in, and a gun shot sends them on the run together, thinking theyve committed murder. ');
insert into movies (name,publish_date,description) values ('A separation','20111007','A married couple are faced with a difficult decision - to improve the life of their child by moving to another country or to stay in Iran and look after a deteriorating parent who has Alzheimers disease');
