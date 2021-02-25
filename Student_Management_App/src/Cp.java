import java.sql.Connection;
import java.sql.DriverManager;

public class Cp {
	static Connection con;
	
public static Connection CreateC()  {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	    
		String user="root";
		String password="admin";
		String url="jdbc:mysql://localhost:3306/student_manage";
		
		con=DriverManager.getConnection(url,user,password);
		
		
	} 
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return con;
}
}
