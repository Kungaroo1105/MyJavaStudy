package MethodAnnotation;

public class test {
	public static void main(String[] args) {
		testBean bean= new testBean();
		System.out.println("student: "+bean.getStudentName());
		System.out.println("school: "+bean.getSchoolName());
		System.out.println("/////////////////////");
		NewProxy np= new NewProxy();
		bean= np.testProxy(bean,"setStudentName","yang");
		bean= np.testProxy(bean,"setSchoolName","WHU");
		System.out.println("/////////////////////");
		System.out.println("student: "+bean.getStudentName());
		System.out.println("school: "+bean.getSchoolName());
	}
}
