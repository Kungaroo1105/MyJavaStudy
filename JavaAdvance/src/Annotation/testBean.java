package Annotation;

public class testBean {
	@NewAnnotation
	private String studentName;
	@NewAnnotation
	private String schoolName;
	
	
	public testBean() {
		super();
		this.setSchoolName("testName");
		this.setStudentName("testName");
	}
	public testBean(String studentName, String schoolName) {
		super();
		this.studentName = studentName;
		this.schoolName = schoolName;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
}
