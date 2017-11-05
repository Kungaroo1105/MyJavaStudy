package objectAdapter;

public class RealTarget implements Target{
	@Override
	public void request() {
		System.out.println("realtarget");
	}
}
