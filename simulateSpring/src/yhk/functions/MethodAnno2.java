package yhk.functions;

import yhk.annotation.Component;
import yhk.annotation.afterAnno;
import yhk.annotation.beforeAnno;

@Component
public class MethodAnno2 {
	@beforeAnno
	public void begin() {
		System.out.println("1st step from class MethodAnno2");
	}

	@afterAnno
	public void end() {
		System.out.println("3rd step from class MethodAnno2");
	}
}
