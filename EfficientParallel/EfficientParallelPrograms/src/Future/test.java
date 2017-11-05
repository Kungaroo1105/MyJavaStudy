package Future;

public class test {

	public static void main(String[] args) {
		Client client= new Client();
		Data data=client.request("helloworld!");
		System.out.println("请求完毕");
		try {
			//此处可以做其他操作，等待realdata的加载
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("数据为"+data.getResult());
	}

}
