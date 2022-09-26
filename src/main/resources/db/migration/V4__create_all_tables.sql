
create table bills(
billno int not null auto_increment,
guestname varchar(50) not null,

primary key(billno)
);

create table fooditems(
id int not null auto_increment,
name varchar(150) not null,

primary key(id)
);

create table housekeepings(
id int not null auto_increment,
name varchar(150) not null,

primary key(id)
);

create table inventory(
type varchar(50)not null,
status varchar(50)not null
);

create table managers(
id int not null auto_increment,
name varchar(150) not null,
phoneno varchar(50)not null,
location varchar(255)not null,

primary key(id)
);

create table receptionists(
id int not null auto_increment,
name varchar(150) not null,
phoneno varchar(50)not null,
location varchar(255)not null,

primary key(id)
);

create table rooms(
roomno int not null auto_increment,
location varchar(100),

primary key(roomno)
);