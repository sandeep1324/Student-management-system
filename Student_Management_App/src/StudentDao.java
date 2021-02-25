import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class StudentDao { //data access object
	// implementation/business logic  hide from client

	public static boolean insertToDB(Student st) {
		boolean f=false;
		try {
		Connection con=Cp.CreateC();
		
		String q="insert into students(sname,sphone,scity) values(?,?,?)";
		
		PreparedStatement pst=con.prepareStatement(q);
		pst.setString(1, st.getStudentName());
		pst.setString(2, st.getStudentPhone());
		pst.setString(3, st.getStudentCity());
		pst.executeUpdate();
		
		f=true;
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public static boolean deleteStudent(int us) {
		// TODO Auto-generated method stub
		boolean f=false;
		try {
		Connection con=Cp.CreateC();
		
		String q="delete from students where sid=?";
		
		PreparedStatement pst=con.prepareStatement(q);
		pst.setInt(1, us);
		pst.executeUpdate();
		
		f=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	
	public static void showAllStudent() {
		boolean f=false;
		try {
		Connection con=Cp.CreateC();
		
		String q="select * from students";
		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(q);
		
		while(rs.next()) {
			int id=rs.getInt(1);
			String name=rs.getString(2);
			String phone=rs.getString(3);
			String city=rs.getString(4);
		
			System.out.println("ID :"+id);
			System.out.println("Name :"+name);
			System.out.println("Phone :"+phone);
			System.out.println("City :"+city);
			System.out.println("---------------------------------------");
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
