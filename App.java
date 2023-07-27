package JDBC.SMS;
import java.sql.SQLException;
import java.util.Scanner;

import com.sms.dao.StudentsDao;
import com.sms.dao.StudentsDaoImpl;
import com.sms.entity.Students;
/**
 * Hello world!
 *
 */
public class App 
{
	private static StudentsDao dao;

	
	public static void main( String[] args ) throws SQLException
    {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter 'Admin or Student'");
		String choice=s.next();
		
		boolean isValidUser = false;
		if (choice.equalsIgnoreCase("Admin") || choice.equalsIgnoreCase("Student")) {
			System.out.print("Enter username: ");
			String username = s.next();
			System.out.print("Enter password: ");
			String password = s.next();
			isValidUser = validateUser(choice, username, password);
		}
		
		if (isValidUser) {
		if(choice.equalsIgnoreCase("Admin")){
			System.out.println("1. Add Students");
			System.out.println("2. Update Student by name");
			System.out.println("3. Update Student by age");
			System.out.println("4. Delete Student by id");
			System.out.println("5. Display Students details");
			System.out.println("6. Exit");
			System.out.println("Enter your choice");
			int take=s.nextInt();
			if(take>=1 && take <=6) {
				dao=new StudentsDaoImpl();
			switch(take) {
			case 1:{
				Students stu=new Students(6,"Ashish",13,"ashish@bitlabs.in","Karnataka");
		        try {
		        
		        boolean result=dao.addStudents(stu);
		        if(result==true) {
		        	System.out.println("added");
		        }else {
		        	System.out.println("not added");
		        }
		        }
		        catch(Exception e) {
		        	System.out.println(e);
		        }
		        break;
			}
			case 2:{
				try {
					dao.updateStudentsByName("ram@bitlabs.in");
				}
				catch(Exception e) {
		        	System.out.println(e);
		        }
				break;
			}
			case 3:{
				try {
					dao.updateStudentsByAge(23);
				}
				catch(Exception e) {
		        	System.out.println(e);
		        }
				break;
			}
			case 4:{
				try {
					dao.deleteStudentsById(5);
				}
				catch(Exception e) {
		        	System.out.println(e);
		        }
				break;
			}
			case 5:
			{
				try {
					dao.getStudentsList();
				}
				catch(Exception e) {
		        	System.out.println(e);
		        }
				break;
			}
			case 6:{
				System.out.println("Thank you");
				break;
			}
			default:{
				System.out.println("Invalid choice");
				break;
			}
			}
			
				
			
		}else {
			System.out.println("Invalid choice");
		}
		}
			else {
			System.out.println("Students details are displayed below");
			try {
				dao=new StudentsDaoImpl();
				dao.getStudentsList();
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
       
		}else {
			System.out.println("Invalid username or password. Access denied.");
		}
    }
	private static boolean validateUser(String role, String username, String password) {
		
		return !username.isEmpty() && !password.isEmpty();
	}
        
        
        
        
    }

