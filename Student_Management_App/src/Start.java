import java.util.Scanner;

public class Start {

	public static void main(String[] args) {
				
		System.out.println("Welcome to Student management app");
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Press 1 to Add Student");
			System.out.println("Press 2 to Delete Student");
			System.out.println("Press 3 to Display Student");
			System.out.println("Press 4 to Exit Student app");
			
			int c=sc.nextInt();
			if(c==1) {//add student
				System.out.println("Enter User name");
				String s=sc.next();
				
				System.out.println("Enter User phone number");
				String q=sc.next();
				
				System.out.println("Enter User city");
				String r=sc.next();
				
				Student st=new Student(s, q, r);
				
				boolean ans=StudentDao.insertToDB(st);
				
				if(ans) {
  					System.out.println("Student added sucessfully with details as below");
				}else {
					System.out.println("Something went wrong try again");
				}
			    	
				System.out.println(st);
			}
			else if(c==2){//delete student
			System.out.println("Enter student id to delete");
			int us=sc.nextInt();
			boolean ans =StudentDao.deleteStudent(us);
			if(ans) {
					System.out.println("Student deleted sucessfully");
			}else {
				System.out.println("Something went wrong try again");
			}
			}
			else if(c==3){//display student
	            StudentDao.showAllStudent();
			}
			else if(c==4){//exit
	          break;
			}
			else {
				
			}
		}
		System.out.println("Application closed sucessfully");
	}
}
