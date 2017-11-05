package decorator;

public class Decorator_first extends Decorator {  
	  
    public Decorator_first(Human human) {  
        super(human);  
    }  
  
    public void goClothespress() {  
        System.out.println("ȥ�¹����ҿ�����");  
    }  
  
    public void findPlaceOnMap() {  
        System.out.println("��Map�����ҡ���");  
    }  
  
    @Override  
    public void wearClothes() {  
        // TODO Auto-generated method stub  
        super.wearClothes();  
        goClothespress();  
    }  
  
    @Override  
    public void walkToWhere() {  
        // TODO Auto-generated method stub  
        super.walkToWhere();  
        findPlaceOnMap();  
    }  
}  
