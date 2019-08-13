package com.nil.dto;

import java.io.Serializable;

import lombok.Data;
@Data
public class StudentDTO implements Serializable {
	private int slno;
	private int sid;
	private String sname;
	private String branch;
	private int semester;
	private int backlogs;
}
