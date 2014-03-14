drop table student;
drop table teacher_subject;
drop table pool_subjects;
drop table pool;
drop table teacher;
drop table person;
drop table electivesubject;


create table person
(
  id int not null primary key ,
  fname varchar(20),
  lname varchar(20),
  cpr int,
  email varchar(20),
  password varchar(20)
);

create table student
(
   stuid int not null primary key,
    firstPri1ElectiveSubjID int, 
    firstPri2ElectiveSubjID int,
    secondPri1ElectiveSubjID int ,
    secondPri2ElectiveSubjID int,
    foreign key (stuid) references person(id)
);

create table teacher
(
  teacherid int not null primary key,
  foreign key (teacherid) references person(id)
);

create table electivesubject
(
    subjectid int not null primary key,
    name varchar(20),
    description varchar(100)
);
create table teacher_subject
(
  teacherid int not null,
  subjectid int not null,
  primary key(teacherid,subjectid),
  foreign key (teacherid) references teacher(teacherid),
  foreign key (subjectid) references electivesubject(subjectid)
);
create table pool
(
  poolname varchar(1) not null primary key
);

create table pool_subjects
(
  poolname varchar(1) not null,
  subjectid int not null,
   primary key(poolname,subjectid),
  foreign key (poolname) references pool(poolname),
  foreign key (subjectid) references electivesubject(subjectid)
);


    
