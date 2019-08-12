package com.nil.cotroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nil.command.StudentCommand;
import com.nil.dto.StudentDTO;
import com.nil.service.StudentMgmtService;

public class StudentInsertController extends SimpleFormController {
	private StudentMgmtService service;
	
	public StudentInsertController(StudentMgmtService service) {
		this.service = service;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		String msg=null;
		StudentCommand cmd=null;
		StudentDTO dto=null;
		ModelAndView mav=null;
		List<StudentDTO> listDTO=null;
		//cast to cmd class
		cmd=(StudentCommand)command;
		//convert cmd to dto
		dto=new StudentDTO();
		BeanUtils.copyProperties(cmd, dto);
		//use service
		msg=service.insertDetails(dto);
		listDTO=service.fetchDetails();
		//create and use mav
		mav=new ModelAndView();
		mav.setViewName(getSuccessView());
		mav.addObject("msg", msg);
		mav.addObject("studentList", listDTO);
		return mav;
	}
	@Override
	protected ModelAndView handleInvalidSubmit(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return new ModelAndView("error");
	}
}
