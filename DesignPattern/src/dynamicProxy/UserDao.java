package dynamicProxy;

/**
 * �ӿ�ʵ��
 * Ŀ�����
 */
public class UserDao implements IUserDao {
    public void save() {
        System.out.println("----�Ѿ���������!----");
    }

	public void load() {
		System.out.println("ztxsb");
		
	}
	public void load2(){
		System.out.println("yhksb");
	}
}