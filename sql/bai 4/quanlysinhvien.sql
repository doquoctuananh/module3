-- Hiển thị số lượng sinh viên ở từng nơi
select s.address, count(*) from student as s
group by s.address;

-- Tính điểm trung bình các môn học của mỗi học viên

SELECT S.StudentId,S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName;

-- Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 15
SELECT S.StudentId,S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName
having AVG(Mark) > 15;

-- Hiển thị thông tin các học viên có điểm trung bình lớn nhất.
select s.*  from student s 
where s.studentid in (
select s2.studentid from
(SELECT S.StudentId,S.StudentName, AVG(Mark) as max
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName) as s2
where s2.max in (
select max(s1.max_mark) from 
(SELECT S.StudentId,S.StudentName, AVG(Mark) as max_mark
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName) as s1 ) )