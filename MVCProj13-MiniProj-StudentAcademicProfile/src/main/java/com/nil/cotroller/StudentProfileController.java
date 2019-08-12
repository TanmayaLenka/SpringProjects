package com.nil.cotroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nil.command.StudentCommand;
import com.nil.dto.StudentDTO;
import com.nil.service.StudentMgmtService;

public class StudentProfileController extends AbstractController {
	
	private StudentMgmtService service;

	public StudentProfileController(StudentMgmtService service) {
		this.service = service;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<StudentDTO> listDTO=null;
		//use service
		listDTO=service.fetchDetails();
		return new ModelAndView("report", "studentList", listDTO);
	}

}
