package cglibProxy;

public class test {
	public static void main(String[] args) {
		UserDAO user= new UserDAO();
		Object proxy= (UserDAO)new CglibInterceptor(user).createCglibProcy();
		((UserDAO) proxy).save();
		((UserDAO) proxy).load("file1");
	}
}
