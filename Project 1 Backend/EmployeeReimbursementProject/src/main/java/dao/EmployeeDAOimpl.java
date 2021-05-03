package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import model.Employee;
import util.ConnectionFactory;

public class EmployeeDAOimpl implements EmployeeDAO {

	public final static Logger loggy = Logger.getLogger(EmployeeDAOimpl.class);
	
	@Override
	public List<Employee> getAllEmployees() {
		Employee e1 = null;
		try(Connection conn = ConnectionFactory.getConnection()) {
			String sql = "select id, username, password, firstname, lastname, manager_id from users where is_manager = false";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Employee> employees = new ArrayList<Employee>();
			while(rs.next()) {
				e1 = new Employee();
				e1.setEID(rs.getInt(1));
				e1.setUsername(rs.getString(2));
				e1.setPassword(rs.getString(3));
				e1.setFirstname(rs.getString(4));
				e1.setLastname(rs.getString(5));
				e1.setManagerID(rs.getInt(6));
				employees.add(e1);
			}
		return employees;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeByCredentials(String uid, String pw) {
		Employee employee = null;
		try(Connection conn = ConnectionFactory.getConnection()) {
			String sql = "select id, username, password, firstname, lastname, manager_id from users where username = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,  uid);
			ps.setString(2,  pw);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				employee = new Employee();
				employee.setEID(rs.getInt(1));
				employee.setUsername(rs.getString(2));
				employee.setPassword(rs.getString(3));
				employee.setFirstname(rs.getString(4));
				employee.setLastname(rs.getString(5));
				employee.setManagerID(rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees2() {
        try(Connection conn = ConnectionFactory.getConnection()){
        	String sql = "select id, username, password, firstname, lastname, manager_id from users where is_manager = 0";
            List<Employee> employees = new ArrayList<Employee>();
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs =  ps.executeQuery();
            
            while(rs.next()) {
                Employee e1 = new Employee();
                e1.setEID(rs.getInt(1));
                e1.setUsername(rs.getString(2));
				e1.setPassword(rs.getString(3));
				e1.setFirstname(rs.getString(4));
				e1.setLastname(rs.getString(5));
				e1.setManagerID(rs.getInt(6));
				employees.add(e1);
            }
            return employees;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}

	

}
