package service;

import java.util.List;

import model.Employee;
import model.Manager;
import model.Reimbursement;

public interface ReimbursementService {
	List<Reimbursement> getAllEmployeeReimbursements(Employee e1);
	Reimbursement submitNewReimbursement(Reimbursement r);
	List<Reimbursement> viewEmpApprovedReimbursements(Employee e1);
	List<Reimbursement> viewEmpDeniedReimbursements(Employee e1);
	List<Reimbursement> viewEmpPendingReimbursements(Employee e1);
	List<Reimbursement> getAllManagerReimbursements(Manager manager);
	List<Reimbursement> viewManPendingReimbursements(Manager m);
	List<Reimbursement> viewManApprovedReimbursements(Manager m);
	List<Reimbursement> viewManDeniedReimbursement(Manager m);
	Reimbursement approveReimbursements(Reimbursement r);
	Reimbursement denyReimbursements(Reimbursement r);
}
