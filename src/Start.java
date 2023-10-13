import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

import java.io.IOException;

public class Start {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Student Management App");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("Press 1 to Add student");
			System.out.println("Press 2 to Delete student");
			System.out.println("Press 3 to Display student");
			System.out.println("Press 4 to exit app");
			
			int c = Integer.parseInt(br.readLine());
			
			switch(c) {
			case 1: 
				// add student
				System.out.println("Enter user name: ");
				String name = br.readLine();
				
				System.out.println("Enter user phone: ");
				String phone = br.readLine();
				
				System.out.println("Enter user city: ");
				String city = br.readLine();
				
				// create student object to store student
				Student st = new Student(name, phone, city);
				boolean answer = StudentDao.insertStudentToDB(st);
				if(answer) {
					System.out.println("Student is added successfully...");
				}else {
					System.out.println("Something went wrong, try again...");
				}
				
				System.out.println(st);
				break;
			case 2: 
				// delete student
				System.out.println("Enter student id to delete: ");
				int userId = Integer.parseInt(br.readLine());
				
				boolean f = StudentDao.deleteStudent(userId);
				if(f) {
					System.out.println("Deleted...");
				}else {
					System.out.println("Something went wrong...");
				}
				
				break;
			case 3:
				// display student
				StudentDao.showAllStuent();
				break;
			case 4: 
				// exit app
				System.out.println("Thank you for using my application");
				System.out.println("See you soon...");
				System.exit(0);
				break;
			default:
				System.out.println("Please give valid argument...");
				break;
			}
		}
		
		

	}

}
