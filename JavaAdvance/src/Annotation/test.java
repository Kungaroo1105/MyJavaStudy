package Annotation;

public class test {
	public static void main(String[] args) {
		testBean bean= new testBean();
		System.out.println(bean.getStudentName());
		System.out.println(bean.getSchoolName());
		System.out.println("/////////////////////");
		NewProxy np= new NewProxy();
		bean= np.testProxy(bean.getClass());
		System.out.println("/////////////////////");
		System.out.println(bean.getStudentName());
		System.out.println(bean.getSchoolName());
	}
}
