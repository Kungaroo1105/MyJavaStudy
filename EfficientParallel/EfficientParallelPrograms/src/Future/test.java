package Future;

public class test {

	public static void main(String[] args) {
		Client client= new Client();
		Data data=client.request("helloworld!");
		System.out.println("�������");
		try {
			//�˴������������������ȴ�realdata�ļ���
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("����Ϊ"+data.getResult());
	}

}
