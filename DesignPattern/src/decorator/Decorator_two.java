package decorator;

public class Decorator_two extends Decorator {  
	  
    public Decorator_two(Human human) {  
        super(human);  
    }  
  
    public void findClothes() {  
        System.out.println("�ҵ�һ��D&G����");  
    }  
  
    public void findTheTarget() {  
        System.out.println("��Map���ҵ����ػ�԰�ͳǱ�����");  
    }  
  
    @Override  
    public void wearClothes() {  
        // TODO Auto-generated method stub  
        super.wearClothes();  
        findClothes();  
    }  
  
    @Override  
    public void walkToWhere() {  
        // TODO Auto-generated method stub  
        super.walkToWhere();  
        findTheTarget();  
    }  
}  