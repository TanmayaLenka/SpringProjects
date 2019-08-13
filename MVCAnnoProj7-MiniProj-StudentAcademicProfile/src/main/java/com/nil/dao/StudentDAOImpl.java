package com.nil.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nil.bo.StudentBO;
@Repository("stDAO")
public final class StudentDAOImpl implements StudentDAO {
	@Autowired
	private JdbcTemplate jt;
	
	private static final String STUDENT_DETAILS="SELECT SID,SNAME,BRANCH,SEMESTER,BACKLOGS FROM STUDENT_PROFILE";
	private static final String STUDENT_DETAILS_BY_ID="SELECT SID,SNAME,BRANCH,SEMESTER,BACKLOGS FROM STUDENT_PROFILE WHERE SID=?";
	private static final String UPDATE_BY_ID="UPDATE STUDENT_PROFILE SET SNAME=?, BRANCH=?, SEMESTER=?, BACKLOGS=? WHERE SID=?";
	private static final String INSERT_STUDENT_DETAILS="INSERT INTO STUDENT_PROFILE VALUES(SID.NEXTVAL,?,?,?,?)";
	private static final String REMOVE_BY_ID="DELETE FROM STUDENT_PROFILE WHERE SID=?";

	@Override
	public List<StudentBO> getDetails() {
		List<StudentBO> listBO=null;
		BeanPropertyRowMapper<StudentBO> mapper=null;
		//create row mapper obj
		mapper=new BeanPropertyRowMapper<StudentBO>(StudentBO.class);
		//use jt to retrive student details
		listBO=jt.query(STUDENT_DETAILS, new RowMapperResultSetExtractor<StudentBO>(mapper));
		return listBO;
	}

	@Override
	public List<StudentBO> getDetailsById(int id) {
		List<StudentBO> listBO=null;
		BeanPropertyRowMapper<StudentBO> mapper=null;
		//create row mapper obj
		mapper=new BeanPropertyRowMapper<StudentBO>(StudentBO.class);
		//use jt to retrive student details
		listBO=jt.query(STUDENT_DETAILS_BY_ID, new RowMapperResultSetExtractor<StudentBO>(mapper),id);
		return listBO;
	}
	
	@Override
	public int updateById(StudentBO bo) {
		int count=0;
		//use jt
		count=jt.update(UPDATE_BY_ID, bo.getSname(),bo.getBranch(),bo.getSemester(),bo.getBacklogs(),bo.getSid());
		return count;
	}

	@Override
	public int insertDetails(StudentBO bo) {
		int count=0;
		//use jt
		count=jt.update(INSERT_STUDENT_DETAILS, bo.getSname(),bo.getBranch(),bo.getSemester(),bo.getBacklogs());
		
		return count;
	}

	@Override
	public int removeById(int id) {
		int count=0;
		//use jt
		count=jt.update(REMOVE_BY_ID, id);
		return count;
	}

}
