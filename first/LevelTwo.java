package first;
/*
 *  Author : Pulkit Sharma
 */
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LevelTwo {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.jdbc.Driver");			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","3911");  					 		
			Statement stmt = con.createStatement();
			display(stmt,con);			
		}catch(Exception e) {
			System.out.print(e);
		}
	}
	
	public static void display(Statement stmt,Connection Con) {
		while(true) {
			try {				
				menu();		
				System.out.print("Enter a choice => ");
				int choice = sc.nextInt();
				switch(choice) {
				case 1:
					insertRecord(stmt);
					break;
				case 2:
					updateRecord(stmt);
					break;
				case 3:
					deleteRecord(stmt);
					break;
				case 4:
					allRecord(stmt);
					break;
				case 5:
					specificRecord(stmt);
					break;				
				case 6:
					Con.close();
					System.exit(0);
					break;
				default:
					System.exit(0);
					break;
				}
			}catch(Exception e) {
				System.out.print(e);
			}
		}
	}
	
	public static void menu() {
		System.out.println("1). Insert the record");
		System.out.println("2). Update the record");
		System.out.println("3). Delete the record");
		System.out.println("4). Select all record");
		System.out.println("5). Select Specific record");
		System.out.println("6). exit");
	}
	
	public static void insertRecord(Statement stmt) {
		try {
			
			System.out.print("Enter your roll number => ");
			int id = sc.nextInt();
			System.out.print("Enter your First Name => ");
			String name = sc.next();
			System.out.print("Enter your last name => ");
			String lname = sc.next();
			
 
			String sql = "INSERT INTO student_master VALUES (" + id + " , '" + name + "' , '" + lname + "')";
			stmt.executeUpdate(sql);
			
		}catch(Exception e) {
			System.out.print(e);
		}
	}
	
	public static void deleteRecord(Statement stmt) {
		try {
			System.out.print("Enter id number to delete => ");
			int idNumber = sc.nextInt();			
			String sql = "DELETE FROM student_master WHERE id="+(char)idNumber;
			stmt.executeUpdate(sql);				
			System.out.print("Record deleted Successfully");
		}catch(Exception e) {
			System.out.print(e);
		}
	}
	
	public static void updateRecord(Statement stmt) {
		try {
			System.out.println("What you want to update ? ");
			System.out.println("1) First Name");
			System.out.println("2) Last Name");
			System.out.print("Please Enter a choice => ");
			int choice = sc.nextInt();
			System.out.print("Please Provide the lname/fname to change => ");
			String change = sc.next();
			System.out.print("Please provide the student number => ");
			int idNumber = sc.nextInt();
			String sql = new String();
			if(choice == 1) {
				sql = "UPDATE student_master SET fname="+change+" WHERE id="+(char)idNumber;				
			}else if(choice == 2) {
				sql = "UPDATE student_master SET lname="+change+" WHERE id="+(char)idNumber;
			}else {
				System.out.print("You have entered wrong Choice ");
				System.exit(0);
			}
			
			stmt.executeUpdate(sql);
		}catch(Exception e) {
			System.out.print(e);
		}
	}
	
	public static void allRecord(Statement stmt) {
		try {
			String sql = "SELECT * FROM student_master";
			
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next())  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		}catch(Exception e) {
			System.out.print(e);
		}
	}
	
	public static void specificRecord(Statement stmt) {
		try {
			System.out.print("Enter a roll number => ");
			int idNumber = sc.nextInt();
			String sql = "SELECT * FROM student_master WHERE id="+idNumber;
			
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next())  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
			
		}catch(Exception e) {
			System.out.print(e);
		}
	}
	
	
		
}
