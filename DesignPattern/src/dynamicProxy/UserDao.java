package dynamicProxy;

/**
 * 接口实现
 * 目标对象
 */
public class UserDao implements IUserDao {
    public void save() {
        System.out.println("----已经保存数据!----");
    }

	public void load() {
		System.out.println("ztxsb");
		
	}
	public void load2(){
		System.out.println("yhksb");
	}
}