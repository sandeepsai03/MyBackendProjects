package com.excelr;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {

	//collections in spring
	private Integer sno;
	private List<Integer> smarks;
	private Set<String> semails;
	private Map<String,Integer> course;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(Integer sno, List<Integer> smarks, Set<String> semails, Map<String, Integer> course) {
		super();
		this.sno = sno;
		this.smarks = smarks;
		this.semails = semails;
		this.course = course;
	}
	public Integer getSno() {
		return sno;
	}
	public void setSno(Integer sno) {
		this.sno = sno;
	}
	public List<Integer> getSmarks() {
		return smarks;
	}
	public void setSmarks(List<Integer> smarks) {
		this.smarks = smarks;
	}
	public Set<String> getSemails() {
		return semails;
	}
	public void setSemails(Set<String> semails) {
		this.semails = semails;
	}
	public Map<String, Integer> getCourse() {
		return course;
	}
	public void setCourse(Map<String, Integer> course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", smarks=" + smarks + ", semails=" + semails + ", course=" + course
				+ ", getSno()=" + getSno() + ", getSmarks()=" + getSmarks() + ", getSemails()=" + getSemails()
				+ ", getCourse()=" + getCourse() + "]";
	}
	
	
}
