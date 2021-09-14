package first;

import java.sql.*;
import java.util.Scanner;

public class LevelOne {
	public static void main(String args[]) {
		try {			
			Class.forName("com.mysql.jdbc.Driver");			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","3911");  					 		
			Statement stmt = con.createStatement();
			
			// 1) Insert the statement
			// String sql = "INSERT INTO student_master values (2,'Rohan','Solanki')";
			
			// 2) Update the statement 
			// String sql = "UPDATE student_master SET lname='christian' WHERE id=2";
			
			// 3) Delete The Statement
			// String sql = "DELETE FROM student_master WHERE id=2";
			
			
//	        stmt.executeUpdate(sql);
//	        System.out.println("Data added Successfully");
//	        System.out.println("Showing Data");
			
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter an Id number => ");
			int intake = sc.nextInt();
			
			String sql = "SELECT * FROM student_master WHERE id="+intake;
			
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next())  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));

			con.close();  
		}catch(Exception E) {
			System.out.print(E);
		}
	}
}
