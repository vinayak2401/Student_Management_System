package com.sms.dao;

import com.sms.entity.Students;

public interface StudentsDao {
	boolean addStudents(Students stu);
	void getStudentsList();
	void updateStudentsByName(String name);
	void updateStudentsByAge(int age);
	void deleteStudentsById(int id);

}
