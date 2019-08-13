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

public class StudentUpdateController extends SimpleFormController {
	private StudentMgmtService service;
	
	public StudentUpdateController(StudentMgmtService service) {
		this.service = service;
	}
	@Override
	public Object formBackingObject(HttpServletRequest request) throws Exception {
		int id=0;
		List<StudentDTO> listDTO=null;
		StudentCommand cmd=null;
		//create command obj
		cmd=new StudentCommand();
		//get request parameter obj
		id=Integer.parseInt(request.getParameter("sid"));
		//use service
		listDTO=service.fetchDetailsById(id);
		for(StudentDTO dto:listDTO) {
			cmd.setSid(dto.getSid());
			cmd.setSname(dto.getSname());
			cmd.setBranch(dto.getBranch());
			cmd.setSemester(dto.getSemester());
			cmd.setBacklogs(dto.getBacklogs());
		}
		return cmd;
	}
	@Override
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		int id=0;
		String msg=null;
		StudentCommand cmd=null;
		StudentDTO dto=null;
		List<StudentDTO> listDTO=null;
		ModelAndView mav=null;
		//cast command obj
		cmd=(StudentCommand)command;
		//convert cmd to dto
		dto=new StudentDTO();
		BeanUtils.copyProperties(cmd, dto);
		//use service
		msg=service.updateDetails(dto);
		listDTO=service.fetchDetails();
		//create and use mav object
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
