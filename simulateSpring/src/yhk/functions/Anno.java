package yhk.functions;

import yhk.annotation.Component;
import yhk.annotation.afterAnno;
import yhk.annotation.beforeAnno;
@Component
public class Anno{
	@beforeAnno
	public void start(){
		System.out.println("start");
	}
	@afterAnno
	public void end(){
		System.out.println("end");
	}
}
