package cglibProxy;

public class UserDAO {
	public void save(){
		System.out.println("file saved");
	}
	public void load(String filename){
		System.out.println("file:"+filename+" loaded");
	}
}
