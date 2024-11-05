create database quanlysinhvien;
use quanlysinhvien;

create table class(
	classId int primary key auto_increment,
    className varchar(60) not null,
    startDate datetime,
    status bit
);

create table student(
	studentId int primary key auto_increment,
    studentname varchar(50),
    address varchar(50),
    phone varchar(20),
    status bit,
    classId int not null ,
    foreign key (classId) references class(classId)
);

create table subject(
	subId int primary key auto_increment,
    subName varchar(30) not null,
    credit tinyint default 1 check(credit >=1),
    status bit default 1
);

create table  mark(
	markId int primary key auto_increment,
    subId int not null ,
    studentId int not null ,
    mark float default 0 check (0<= mark <=100),
    examtimes tinyint default 1,
    foreign key (subId) references subject(subId),
    foreign key (studentId) references student(studentId),
    unique(subId,studentId)
);

insert into class (className,startDate, status)
values ('A1','2008-12-20',1),
('A2','2008-12-22',1),
('B3',current_date,0);

insert into student (studentName,address,phone,status,classId)
values ('Hung','Ha Noi','0912113113',1,1);
insert into student (studentName,address,status,classId)
values ('Hoa','Hai phong',1,1);
insert into student (studentName,address,phone,status,classId)
values ('Manh','HCM','0123123123',0,2);

insert into subject(subName,credit)
values('CF',5),
('C',6),
('HDJ',5),
('RDBMS',10);

insert into mark (subId,studentId,mark,examtimes)
values(1,1,8,1),
(1,2,10,2),
(2,1,12,1);

-- Hiển thị danh sách tất cả các học viên
select * from student;

-- Hiển thị danh sách các học viên đang theo học
select * from student where status = true;

-- Hiển thị danh sách các môn học có thời gian học nhỏ hơn 10 giờ.
select * from subject where credit <=10;

-- Hiển thị danh sách học viên lớp A1
select s.StudentId, s.StudentName, c.ClassName from student as s
join class as c on s.classid = c.classid
where c.classname = 'A1';

-- Hiển thị điểm môn CF của các học viên
select s.studentid,s.studentName,m.mark,sub.subname from student as s
join mark as m on m.studentid = s.studentid
join subject as sub on sub.subid = m.subid
where sub.subname = 'CF';

-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
select * from student as s 
where s.studentname like "h%";

-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
select * from class as c
where month(c.startdate)  = 12;

-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
select * from subject as s 
where s.credit between 3 and 5;

-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
update student set classid = 2 where student.studentid =1;

-- Hiển thị các thông tin: StudentName, SubName, Mark.
-- Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
select s.studentname,m.mark,sub.subname from student as s
join mark as m on m.studentid = s.studentid
join subject as sub on sub.subid = m.subid
order by m.mark desc , s.studentname asc


