package com.nil.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nil.command.StudentCommand;

public class StudentDetailsValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println("StudentDetailsValidator.supports()");
		return clazz.isAssignableFrom(StudentCommand.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		StudentCommand cmd=null;
		String name=null,branch=null;
		int semester=0,backlogs=0;
		//cast cmd get data
		cmd=(StudentCommand)target;
		if(cmd.getFlag().equalsIgnoreCase("no")) {
			System.out.println("StudentDetailsValidator.validate()");
		name=cmd.getSname();
		branch=cmd.getBranch();
		semester=cmd.getSemester();
		backlogs=cmd.getBacklogs();
		//valid datas
		if(name==null||name=="") {
			errors.rejectValue("sname", "sname.required");
		}else if(name.length()==0||name.length()>15) {
			errors.rejectValue("sname", "sname.valid");
		}if(branch==null||branch=="") {
			errors.rejectValue("branch", "branch.required");
		}else if(branch.length()==0||branch.length()>15) {
			errors.rejectValue("branch", "branch.valid");
		}if(semester==0) {
			errors.rejectValue("semester", "semester.required");
		}else if(semester<0) {
			errors.rejectValue("semester", "semester.valid");
		}if(backlogs<0) {
			errors.rejectValue("backlogs", "backlogs.valid");
		}
	}
	}

}
