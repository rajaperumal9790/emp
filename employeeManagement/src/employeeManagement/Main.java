package employeeManagement;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		EmployeeDAO dao = new EmployeeDAOImplement();
		System.out.println("------Employee Management------");
		
		Scanner sc = new Scanner(System.in);
		do {
			
			System.out.println("1. Add Employee details\n" +
							   "2. Show all employees details\n" +
					 		   "3. Show employee detail using id number\n" +
							   "4. Update employee details\n" +
					 		   "5. Delate employee detail");
			System.out.println("Enter the choose : ");
			int choose = sc.nextInt();
			
			int id;
			String name;
			
			switch(choose) {
			case 1 :
				Employee emp = new Employee();
				System.out.println("Enter employee id : ");
				id = sc.nextInt();
				System.out.println("Enter employee name : ");
				name = sc.next();
				System.out.println("Enter employee salary : ");
				double salary = sc.nextDouble();
				System.out.println("Enter employee age : ");
				int age = sc.nextInt();
				emp.setId(id);
				emp.setName(name);
				emp.setSalary(salary);
				emp.setAge(age);
				dao.addEmployee(emp);
				break;
				
			case 2 :
					dao.showAllEmployee();
					break;
					
			case 3 :
					System.out.println("Enter employee id : ");
					int empid = sc.nextInt();
					dao.showEmployeeBasedOnId(empid);
					break;
					
			case 4 :
					System.out.println("Enter employee id : ");
					int empid1 = sc.nextInt();
					System.out.println("Enter the new name : ");
					name = sc.next();
					dao.updateEmployee(empid1, name);
					break;
					
			case 5 : 
					System.out.println("Select employee id for delete : ");
					id = sc.nextInt();
					dao.deleteEmployee(id);
					break;
					
			case 6 :
					System.exit(0);
					default :
						System.out.println("Enter valid choosse");
						break;
			}
			
		}while(true);

	}

}
