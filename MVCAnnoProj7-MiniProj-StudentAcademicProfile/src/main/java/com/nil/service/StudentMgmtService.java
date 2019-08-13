package com.nil.service;

import java.util.List;

import com.nil.dto.StudentDTO;

public interface StudentMgmtService {
	public List<StudentDTO> fetchDetails();
	public List<StudentDTO> fetchDetailsById(int id);
	public String updateDetails(StudentDTO dto);
	public String insertDetails(StudentDTO dto);
	public String removeDetails(int id);
}
