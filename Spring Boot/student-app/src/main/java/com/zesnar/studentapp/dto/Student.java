package com.zesnar.studentapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	private int studentId;
	
	private String studentName;
	
	private int studentAge;
	

}
