package com.nil.cotroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nil.dto.StudentDTO;
import com.nil.service.StudentMgmtService;

public class StudentDeleteController extends AbstractController {
	private StudentMgmtService service;

	public StudentDeleteController(StudentMgmtService service) {
		this.service = service;
	}


	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int id=0;
		String msg=null;
		List<StudentDTO> listDTO=null;
		ModelAndView mav=null;
		//read request param value
		id=Integer.parseInt(request.getParameter("sid"));
		//use service
		msg=service.removeDetails(id);
		listDTO=service.fetchDetails();
		//create and fetch mav object
		mav=new ModelAndView();
		mav.setViewName("report");
		mav.addObject("msg", msg);
		mav.addObject("studentList", listDTO);
		return mav;
	}

}
