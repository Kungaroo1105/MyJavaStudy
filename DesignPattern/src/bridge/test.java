package bridge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test {
	public static void main(String[] args) {
        //��ɫ
        Color white = new White();
        //������
        Shape square = new Square();
        //��ɫ��������
        square.setColor(white);
        square.draw();
        
        //������
        Shape rectange = new Rectangle();
        rectange.setColor(white);
        rectange.draw();
        
        try {
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
      //��������
      try {
		Connection conn= DriverManager.getConnection("");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
}
