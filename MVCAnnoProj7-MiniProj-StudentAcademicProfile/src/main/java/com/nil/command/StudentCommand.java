package com.nil.command;

import lombok.Data;

@Data
public class StudentCommand {
	private int sid;
	private String sname;
	private String branch;
	private int semester;
	private int backlogs;
	private String flag;
}
