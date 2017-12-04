package cglibProxy;

import org.springframework.cglib.proxy.Enhancer;

public class test {
	public static void main(String[] args) {
		UserDAO user= new UserDAO();
		Enhancer en= new Enhancer();
		en.setCallback(new CglibInterceptor(user));
		//��UserDAO����Ϊ�������ĸ���
		en.setSuperclass(user.getClass());
		Object cglibProxy=en.create();
		((UserDAO) cglibProxy).save();
	}
}
