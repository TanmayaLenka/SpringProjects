package com.nil.dao;

import java.util.List;

import com.nil.bo.StudentBO;

public interface StudentDAO {
	public List<StudentBO> getDetails();
	public List<StudentBO> getDetailsById(int id);
	public int updateById(StudentBO bo);
	public int insertDetails(StudentBO bo);
	public int removeById(int id);
}
