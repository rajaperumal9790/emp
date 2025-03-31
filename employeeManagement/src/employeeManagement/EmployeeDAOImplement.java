package employeeManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDAOImplement implements EmployeeDAO {

	@Override
	public void addEmployee(Employee emp) {
		try {
			Connection con = DBConnection.getConnection();
			String qurery = "Insert into employee values(?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(qurery);
			pst.setInt(1, emp.getId());
			pst.setString(2, emp.getName());
			pst.setDouble(3, emp.getSalary());
			pst.setInt(4, emp.getAge());
			int count = pst.executeUpdate();
			
			if (count!=0)
				System.out.println("Successfully inseeted");
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void showAllEmployee() {
		try {
			Connection con = DBConnection.getConnection();
			String qurery = "Select * From employee";
			Statement st = con.createStatement();
			ResultSet rs =st.executeQuery(qurery);
			
			while(rs.next()) {
				System.out.format("%d\t%s\t%f\t%d\n", rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}		
	}

	@Override
	public void showEmployeeBasedOnId(int id) {
		try {
			Connection con = DBConnection.getConnection();
			String qurery = "Select * From employee Where id=" +id;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(qurery);
			
			while(rs.next()) {
				System.out.format("%d\t%s\t%f\t%d\n", rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void updateEmployee(int id, String name) {
		try {
			Connection con = DBConnection.getConnection();
			String qurery = "update employee set emp_name=? Where id=?";
			PreparedStatement pst = con.prepareStatement(qurery);
			pst.setString(1, name);
			pst.setInt(2, id);
			int count = pst.executeUpdate();
			if (count!=0)
				System.out.println("Employee detaile updated succssfully");
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void deleteEmployee(int id) {
		try {
			Connection con = DBConnection.getConnection();
			String qurery = "delete from employee Where id=?";
			PreparedStatement pst = con.prepareStatement(qurery);
			pst.setInt(1, id);
			int count = pst.executeUpdate();
			if (count!=0)
				System.out.println("Employee detaile deleted successfully !! Employee ID is " +id);
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}

}
