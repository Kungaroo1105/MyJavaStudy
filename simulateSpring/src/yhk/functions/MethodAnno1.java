package yhk.functions;

import yhk.annotation.Component;
import yhk.annotation.afterAnno;
import yhk.annotation.beforeAnno;

@Component
public class MethodAnno1{
	@beforeAnno
	public void start(){
		System.out.println("1st step from class MethodAnno1");
	}
	@afterAnno
	public void stop(){
		System.out.println("3rd step from class MethodAnno1");
	}
}
