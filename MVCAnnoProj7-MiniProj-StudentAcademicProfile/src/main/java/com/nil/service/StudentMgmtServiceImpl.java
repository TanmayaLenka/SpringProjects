package com.nil.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nil.bo.StudentBO;
import com.nil.dao.StudentDAO;
import com.nil.dto.StudentDTO;

public final class StudentMgmtServiceImpl implements StudentMgmtService {
	private StudentDAO dao;

	public StudentMgmtServiceImpl(StudentDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<StudentDTO> fetchDetails() {
		List<StudentDTO> listDTO=new ArrayList();
		List<StudentBO> listBO=null;
		//use service to get details
		listBO=dao.getDetails();
		listBO.forEach(bo->{
			StudentDTO dto=new StudentDTO();
			//conver bo to dto
			BeanUtils.copyProperties(bo, dto);
			dto.setSlno(listDTO.size()+1);
			listDTO.add(dto);
		});
		return listDTO;
	}
	@Override
	public List<StudentDTO> fetchDetailsById(int id) {
		List<StudentDTO> listDTO=new ArrayList();
		List<StudentBO> listBO=null;
		//use service to get details
		listBO=dao.getDetailsById(id);
		listBO.forEach(bo->{
			StudentDTO dto=new StudentDTO();
			//conver bo to dto
			BeanUtils.copyProperties(bo, dto);
			listDTO.add(dto);
		});
		return listDTO;
	}
	
	@Override
	public String updateDetails(StudentDTO dto) {
		int count=0;
		String msg=null;
		StudentBO bo=null;
		//convert dto to bo
		bo=new StudentBO();
		BeanUtils.copyProperties(dto, bo);
		//use dao
		count=dao.updateById(bo);
		msg=(count==0)?"Record update failed":"Record updated";
		return msg;
	}

	@Override
	public String insertDetails(StudentDTO dto) {
		int count=0;
		String msg=null;
		StudentBO bo=null;
		//create and copy from dto to bo
		bo=new StudentBO();
		BeanUtils.copyProperties(dto, bo);
		//use dao
		count=dao.insertDetails(bo);
		msg=(count==1)?"Record Insertion Succeeded":"Record Insertion Failed";
		return msg;
	}

	@Override
	public String removeDetails(int id) {
		int count=0;
		String msg=null;
		//use dao
		count=dao.removeById(id);
		msg=(count==1)?"Record Deleted":"Record Deletion Failed";
		return msg;
	}

}
