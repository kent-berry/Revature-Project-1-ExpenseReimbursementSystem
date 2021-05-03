package service;

import java.util.List;

import model.Employee;
import exception.EmployeeNotFoundException;
import exception.InvalidPasswordException;

public interface EmployeeService {
	Employee getEmployeeByCredentials(String uid, String pw);
	Employee employeeLogin(Employee employee) throws EmployeeNotFoundException, InvalidPasswordException;
	List<Employee> getAllEmployees();
	List<Employee> getAll();

}
