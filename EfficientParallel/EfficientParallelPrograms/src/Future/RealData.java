package Future;

public class RealData implements Data {
	protected final String result;
	public RealData(String param){
		StringBuffer sb=new StringBuffer();
		long s1=System.currentTimeMillis();
		for(int i=0;i<100;i++){
			sb.append(param);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		long s2=System.currentTimeMillis();
		System.out.println("×Ö·û´®append¹ý³ÌºÄÊ±"+(s2-s1)+"ms");
		result=sb.toString();
	}
	@Override
	public String getResult() {
		return result;
	}

}
