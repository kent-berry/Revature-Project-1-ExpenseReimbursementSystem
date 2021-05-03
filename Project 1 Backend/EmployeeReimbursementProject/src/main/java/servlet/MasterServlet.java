package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Controller controller = new Controller();

    public MasterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		
		switch(uri) {
		case "/EmployeeReimbursementProject/api/getAll":
			controller.getAll(request, response);
			break;
		case "/EmployeeReimbursementProject/api/employeepage/viewAllReimbursementsEmployee":
			controller.viewAllReimbursementsEmployee(request, response);
			break;
		case "/EmployeeReimbursementProject/api/employeepage/viewApprovedReimbursementsEmployee":
			controller.viewApprovedReimbursementsEmployee(request, response);
			break;
		case "/EmployeeReimbursementProject/api/employeepage/ViewDeniedRequestsEmployee":
			controller.ViewDeniedRequestsEmployee(request, response);
			break;
		case "/EmployeeReimbursementProject/api/employeepage/ViewPendingRequestsEmployee":
			controller.ViewPendingRequestsEmployee(request, response);
			break;
		case "/EmployeeReimbursementProject/api/managerpage/viewAllReimbursementsManager":
			controller.viewAllReimbursementsManager(request, response);
			break;
		case "/EmployeeReimbursementProject/api/managerpage/viewAllPendingRequestsManager":
			controller.viewAllPendingReimbursementsManager(request, response);
			break;
		case "/EmployeeReimbursementProject/api/managerpage/viewApprovedRequestsManager":
			controller.viewApprovedRequestsManager(request, response);
			break;
		case "/EmployeeReimbursementProject/api/managerpage/viewDeniedRequestsManager":
			controller.viewDeniedRequestsManager(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		
		switch(uri) {
		case "/EmployeeReimbursementProject/api/employeelogin":
			controller.loginEmployee(request, response);
			break;
		case "/EmployeeReimbursementProject/api/managerlogin":
			controller.loginManager(request, response);
			break;
		case "/EmployeeReimbursementProject/api/employeepage/logout":
			controller.logout(request, response);
			break;
		case "/EmployeeReimbursementProject/api/managerpage/logout":
			controller.logout(request, response);
			break;
		case "/EmployeeReimbursementProject/api/managerpage/updateApproveReimbursement":
			controller.updatereApproveReimbursement(request, response);
			break;
		case "/EmployeeReimbursementProject/api/managerpage/updateDenyReimbursement":
			controller.updateDenyReimbursement(request, response);
			break;
		}
		
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		
		switch(uri) {
		case "/EmployeeReimbursementProject/api/employeepage/submitNewReimbursement":
			controller.submitNewReimbursement(request, response);
			break;
		}
	}
}
