package service;

import java.util.List;
import java.util.ArrayList;

import dao.EmployeeDAO;
import dao.EmployeeDAOimpl;
import model.Employee;
import exception.EmployeeNotFoundException;
import exception.InvalidPasswordException;

import org.apache.log4j.Logger;

public class EmployeeServiceImpl implements EmployeeService {
	
	public final static Logger loggy = Logger.getLogger(EmployeeService.class);

	private EmployeeDAO employeedao = new EmployeeDAOimpl();
	
	@Override
	public Employee employeeLogin(Employee employee) throws EmployeeNotFoundException, InvalidPasswordException {
		boolean employeeFound = false;
		boolean pwCheck = false;
		
		List<Employee> employees = new ArrayList<Employee>(employeedao.getAllEmployees());
		Employee currentEmployee = new Employee();
		
		for(Employee e : employees) {
			if(e.getUsername().equals(employee.getUsername())) {
				employeeFound = true;
				if(e.getPassword().equals(employee.getPassword())) {
					pwCheck = true;
					currentEmployee.setEID(e.getEID());
					currentEmployee.setUsername(e.getUsername());
					currentEmployee.setPassword(e.getPassword());
					currentEmployee.setFirstname(e.getFirstname());
					currentEmployee.setLastname(e.getLastname());
					currentEmployee.setManagerID(e.getManagerID());
					return currentEmployee;
				}
			}
		}
		if(!employeeFound) {
			throw new EmployeeNotFoundException("There are no employees with this username: " + employee.getUsername());
		}
			
		if(employeeFound && !pwCheck) {
			throw new InvalidPasswordException("This is incorrect Password. Plase try again.");
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return null;
	}

	@Override
	public Employee getEmployeeByCredentials(String uid, String pw) {
		return null;
	}

	@Override
	public List<Employee> getAll() {
		return employeedao.getAllEmployees2();
	}

}
