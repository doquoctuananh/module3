-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select s.* from subject as s
where s.credit = (
select max(s.credit) from subject as s);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select sub.* from subject as sub 
where sub.subid in (
select m.subid  from mark as m 
where m.mark = (
select max(m.mark) from mark as m)
);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select s.* from student as s
where s.studentid in (
select stem.studentid from (
select s.studentid ,avg(m.mark) from student as s
join mark as m on m.studentid = s.studentid
group by s.studentid ) as stem
);