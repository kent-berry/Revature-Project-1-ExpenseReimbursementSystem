package dao;

import java.util.List;

import model.Employee;
import model.Manager;
import model.Reimbursement;

public interface ReimbursementDAO {
	List<Reimbursement> getAllEmployeeReimbursements(Employee e);
	Reimbursement submitNewReimbursement(Reimbursement r);
	List<Reimbursement> viewEmpApprovedReimbursements(Employee e);
	List<Reimbursement> viewEmpDeniedReimbursements(Employee e);
	List<Reimbursement> viewEmpPendingReimbursements(Employee e);
	List<Reimbursement> getAllManagerReimbursements(Manager manager);
	List<Reimbursement> viewManPendingReimbursements(Manager m);
	List<Reimbursement> viewManApprovedReimbursements(Manager m);
	List<Reimbursement> viewManDeniedReimbursements(Manager m);
	Reimbursement approveReimbursements(Reimbursement r);
	Reimbursement denyReimbursements(Reimbursement r);
}
