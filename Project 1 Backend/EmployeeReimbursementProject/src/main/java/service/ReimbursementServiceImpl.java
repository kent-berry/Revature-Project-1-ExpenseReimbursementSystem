package service;

import java.util.List;

import org.apache.log4j.Logger;

import dao.ReimbursementDAO;
import dao.ReimbursementDAOimpl;
import model.Employee;
import model.Manager;
import model.Reimbursement;

import org.apache.log4j.Logger;

public class ReimbursementServiceImpl implements ReimbursementService {

	private ReimbursementDAO reimbdao = new ReimbursementDAOimpl();
	
	@Override
	public List<Reimbursement> getAllEmployeeReimbursements(Employee e1) {
		return reimbdao.getAllEmployeeReimbursements(e1);
	}

	@Override
	public List<Reimbursement> viewEmpApprovedReimbursements(Employee e1) {
		return reimbdao.viewEmpApprovedReimbursements(e1);
	}

	@Override
	public List<Reimbursement> viewEmpDeniedReimbursements(Employee e1) {
		return reimbdao.viewEmpDeniedReimbursements(e1);
	}

	@Override
	public List<Reimbursement> viewEmpPendingReimbursements(Employee e1) {
		return reimbdao.viewEmpPendingReimbursements(e1);
	}
	
	@Override
	public Reimbursement submitNewReimbursement(Reimbursement r) {
		return reimbdao.submitNewReimbursement(r);
	}
	
	@Override
	public List<Reimbursement> getAllManagerReimbursements(Manager manager) {
		return reimbdao.getAllManagerReimbursements(manager);
	}

	@Override
	public List<Reimbursement> viewManDeniedReimbursement(Manager m) {
		return reimbdao.viewManDeniedReimbursements(m);
	}
	@Override
	public List<Reimbursement> viewManPendingReimbursements(Manager m) {
		return reimbdao.viewManPendingReimbursements(m);
	}

	@Override
	public List<Reimbursement> viewManApprovedReimbursements(Manager m) {
		return reimbdao.viewManApprovedReimbursements(m);
	}

	@Override
	public Reimbursement approveReimbursements(Reimbursement r) {
		return reimbdao.approveReimbursements(r);
	}

	@Override
	public Reimbursement denyReimbursements(Reimbursement r) {
		return reimbdao.denyReimbursements(r);
	}


}
