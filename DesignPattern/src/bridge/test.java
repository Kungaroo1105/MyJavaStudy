package bridge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test {
	public static void main(String[] args) {
        //白色
        Color white = new White();
        //正方形
        Shape square = new Square();
        //白色的正方形
        square.setColor(white);
        square.draw();
        
        //长方形
        Shape rectange = new Rectangle();
        rectange.setColor(white);
        rectange.draw();
        
        try {
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
      //建立连接
      try {
		Connection conn= DriverManager.getConnection("");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
}
