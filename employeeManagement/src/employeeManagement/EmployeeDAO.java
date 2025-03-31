package employeeManagement;

import java.sql.SQLException;

public interface EmployeeDAO {
	
	public void addEmployee(Employee emp);
	public void showAllEmployee();
	public void showEmployeeBasedOnId(int id);
	public void updateEmployee(int id, String name);
	public void deleteEmployee(int id);

}
