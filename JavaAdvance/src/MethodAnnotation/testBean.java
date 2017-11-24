package MethodAnnotation;

public class testBean {
	private String studentName;
	private String schoolName;
	
	
	public testBean() {
		super();
	}
	public testBean(String studentName, String schoolName) {
		super();
		this.studentName = studentName;
		this.schoolName = schoolName;
	}
	public String getStudentName() {
		return studentName;
	}
	@MethodAnno
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getSchoolName() {
		return schoolName;
	}
	@MethodAnno
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
}
