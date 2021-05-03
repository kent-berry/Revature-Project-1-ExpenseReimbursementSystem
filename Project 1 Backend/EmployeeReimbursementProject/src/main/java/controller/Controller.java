package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import model.Employee;
import model.Manager;
import model.Reimbursement;
import exception.EmployeeNotFoundException;
import exception.InvalidPasswordException;
import service.EmployeeService;
import service.EmployeeServiceImpl;
import service.ManagerService;
import service.ManagerServiceImpl;
import service.ReimbursementService;
import service.ReimbursementServiceImpl;

import com.google.gson.Gson;

import dao.EmployeeDAOimpl;


public class Controller {
	
	public final static Logger loggy = Logger.getLogger(Controller.class);
	
	EmployeeService empServ = new EmployeeServiceImpl();
	ReimbursementService ReimbServ = new ReimbursementServiceImpl();
	ManagerService managerServ = new ManagerServiceImpl();
	
	
	public void getAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Gson gson = new Gson();
		List<Employee> employees = empServ.getAll();
		String json = gson.toJson(employees);
		PrintWriter pw = response.getWriter();
		pw.append(json);
		
	}
	
	public void loginEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		String body = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
		Gson gson = new Gson();
		String json = null;
		
		System.out.println(body);
		Employee employee = gson.fromJson(body, Employee.class);
		PrintWriter pw = response.getWriter();
		try {
			employee = empServ.employeeLogin(employee);
			loggy.info("Successful login attempt by: " + employee);
			HttpSession session = request.getSession();

			session.setAttribute("employee",employee);
			
			json = gson.toJson(employee);
			pw.append(json);
		}catch(EmployeeNotFoundException e) {
			loggy.warn("Failed login attempt by: " + employee);
			response.sendError(403);
			return;
		}catch(InvalidPasswordException e) {
			loggy.warn("Failed login attempt by: " + employee);
			response.sendError(403);
			return;
		}
		
	}

	public void loginManager(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String body = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
		Gson gson = new Gson();
		String json = null;
		Manager manager = gson.fromJson(body, Manager.class);
		PrintWriter pw = response.getWriter();
		try {
			manager = managerServ.managerLogin(manager);
			loggy.info("Successful login attempt by: " + manager);
			HttpSession session = request.getSession();
			session.setAttribute("manager",manager);
			json = gson.toJson(manager);
			pw.append(json);
		}catch(EmployeeNotFoundException e) {
			response.sendError(403);
			loggy.warn("Failed login attempt by: " + manager);
			return;
		}catch(InvalidPasswordException e) {
			response.sendError(403);
			loggy.warn("Failed login attempt by: " + manager);
			return;
		}
		
	}

	public void viewAllReimbursementsEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		Gson gson = new Gson();
		List<Reimbursement> reimbursements = ReimbServ.getAllEmployeeReimbursements(employee);
		String json = gson.toJson(reimbursements);
		PrintWriter pw = response.getWriter();
		pw.append(json);
		loggy.info("View all reimbursements: " + employee);
	}

	public void viewApprovedReimbursementsEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		Gson gson = new Gson();
		List<Reimbursement> reimbursements = ReimbServ.viewEmpApprovedReimbursements(employee);
		String json = gson.toJson(reimbursements);
		PrintWriter pw = response.getWriter();
		pw.append(json);
		loggy.info("View approved reimbursements: " + employee);
	}

	public void ViewDeniedRequestsEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		Gson gson = new Gson();
		List<Reimbursement> reimbursements = ReimbServ.viewEmpDeniedReimbursements(employee);
		String json = gson.toJson(reimbursements);
		PrintWriter pw = response.getWriter();
		pw.append(json);
		loggy.info("View denied reimbursements: " + employee);
	}

	public void ViewPendingRequestsEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		Gson gson = new Gson();
		List<Reimbursement> reimbursements = ReimbServ.viewEmpPendingReimbursements(employee);
		String json = gson.toJson(reimbursements);
		PrintWriter pw = response.getWriter();
		pw.append(json);
		loggy.info("View pending reimbursements: " + employee);
	}

	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session=request.getSession(); 
		session.invalidate(); 
		response.getWriter().append("Logged Out");
		loggy.info("Successful logout attempt.");
	}

	public void submitNewReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String body = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
		Gson gson = new Gson();
		Reimbursement reimbursement = gson.fromJson(body, Reimbursement.class);
		reimbursement = ReimbServ.submitNewReimbursement(reimbursement);
		response.getWriter().append("Submitted Successfully");
		loggy.info("New reimbursement submitted.");
	}

	public void viewAllReimbursementsManager(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Manager manager = (Manager) request.getSession().getAttribute("manager");
		Gson gson = new Gson();
		List<Reimbursement> reimbursements = ReimbServ.getAllManagerReimbursements(manager);
		String json = gson.toJson(reimbursements);
		PrintWriter pw = response.getWriter();
		pw.append(json);
		loggy.info("View all reimbursements: " + manager);
		
	}

	public void viewAllPendingReimbursementsManager(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Manager manager = (Manager) request.getSession().getAttribute("manager");
		Gson gson = new Gson();
		List<Reimbursement> reimbursements = ReimbServ.viewManPendingReimbursements(manager);
		String json = gson.toJson(reimbursements);
		PrintWriter pw = response.getWriter();
		pw.append(json);
		loggy.info("View pending reimbursements: " + manager);
	}

	public void viewApprovedRequestsManager(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Manager manager = (Manager) request.getSession().getAttribute("manager");
		Gson gson = new Gson();
		List<Reimbursement> reimbursements = ReimbServ.viewManApprovedReimbursements(manager);
		String json = gson.toJson(reimbursements);
		PrintWriter pw = response.getWriter();
		pw.append(json);
		loggy.info("View approved reimbursements: " + manager);
	}

	public void viewDeniedRequestsManager(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Manager manager = (Manager) request.getSession().getAttribute("manager");
		Gson gson = new Gson();
		List<Reimbursement> reimbursements = ReimbServ.viewManDeniedReimbursement(manager);
		String json = gson.toJson(reimbursements);
		PrintWriter pw = response.getWriter();
		pw.append(json);
		loggy.info("View denied reimbursements: " + manager);
	}

	public void updatereApproveReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String body = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
		Gson gson = new Gson();
		Reimbursement reimbursement = gson.fromJson(body, Reimbursement.class);
		reimbursement = ReimbServ.approveReimbursements(reimbursement);
		response.getWriter().append("Updated. Approved Successfully.");
		loggy.info("Reimbursement was approved.");
	}

	public void updateDenyReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String body = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
		Gson gson = new Gson();
		Reimbursement reimbursement = gson.fromJson(body, Reimbursement.class);
		reimbursement = ReimbServ.denyReimbursements(reimbursement);
		response.getWriter().append("Updated. Denied Successfully.");
		loggy.info("Reimbursement was denied.");
	}
}
