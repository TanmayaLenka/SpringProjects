package com.nil.cotroller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nil.command.StudentCommand;
import com.nil.dto.StudentDTO;
import com.nil.service.StudentMgmtService;

@Controller("stController")
public class StudentProfileController {
	@Autowired
	private StudentMgmtService service;

	@RequestMapping(value = "/home.htm", method = RequestMethod.GET)
	public String showForm() {
		return "welcome";
	}

	@RequestMapping(value = "student_profile.htm", method = RequestMethod.GET)
	public String showDetails(Map<String, Object> map) {
		List<StudentDTO> listDTO = null;
		// use service
		listDTO = service.fetchDetails();
		map.put("studentList", listDTO);
		return "report";
	}

	@RequestMapping(value = "delete.htm", method = RequestMethod.GET)
	public String deleteStudent(HttpServletRequest request, Map<String, Object> map) {
		int id = 0;
		String msg = null;
		List<StudentDTO> listDTO = null;
		ModelAndView mav = null;
		// read request param value
		id = Integer.parseInt(request.getParameter("sid"));
		// use service
		msg = service.removeDetails(id);
		listDTO = service.fetchDetails();
		// add objects to map
		map.put("msg", msg);
		map.put("studentList", listDTO);
		return "report";
	}
	
	@RequestMapping(value="/update.htm", method = RequestMethod.GET)
	public String updateForm(HttpServletRequest request,@ModelAttribute("stCmd") StudentCommand cmd) {
		int id=0;
		List<StudentDTO> listDTO=null;
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
		return "update";
	}
	@RequestMapping(value="/update.htm", method = RequestMethod.POST)
	public String updateStudent(Map<String,Object> map,@ModelAttribute("stCmd") StudentCommand cmd) {
		int id=0;
		String msg=null;
		StudentDTO dto=null;
		List<StudentDTO> listDTO=null;
		//convert cmd to dto
		dto=new StudentDTO();
		BeanUtils.copyProperties(cmd, dto);
		//use service
		msg=service.updateDetails(dto);
		listDTO=service.fetchDetails();
		map.put("msg", msg);
		map.put("studentList", listDTO);
		return "report";
	}
	
	@RequestMapping(value = "/insert.htm", method = RequestMethod.GET)
	public String insertForm(@ModelAttribute("stCmd") StudentCommand cmd) {
		return "insert";
	}
	@RequestMapping(value="/insert.htm", method = RequestMethod.POST)
	public String insertStudent(Map<String,Object> map,@ModelAttribute("stCmd") StudentCommand cmd) {
		String msg=null;
		StudentDTO dto=null;
		List<StudentDTO> listDTO=null;
		//convert cmd to dto
		dto=new StudentDTO();
		BeanUtils.copyProperties(cmd, dto);
		//use service
		msg=service.insertDetails(dto);
		listDTO=service.fetchDetails();
		//create and use mav
		map.put("msg", msg);
		map.put("studentList", listDTO);
		return "report";
	}

}
