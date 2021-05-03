package dao;
import java.util.List;
import model.Employee;

public interface EmployeeDAO {
	List<Employee> getAllEmployees();
	Employee getEmployeeById(int id);
	Employee getEmployeeByCredentials(String uid, String pw);
	List<Employee> getAllEmployees2();
}
