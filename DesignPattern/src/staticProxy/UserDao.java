package staticProxy;

/**
 * �ӿ�ʵ��
 * Ŀ�����
 */
public class UserDao implements IUserDao {
    public void save() {
        System.out.println("----�Ѿ���������!----");
    }
}