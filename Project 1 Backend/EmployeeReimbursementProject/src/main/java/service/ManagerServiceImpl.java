package service;

import java.util.ArrayList;
import java.util.List;


import dao.ManagerDAO;
import dao.ManagerDAOimpl;
import model.Manager;
import exception.InvalidPasswordException;
import exception.ManagerNotFoundException;

import org.apache.log4j.Logger;

public class ManagerServiceImpl implements ManagerService {
	
	private ManagerDAO managerdao = new ManagerDAOimpl();

	@Override
	public Manager managerLogin(Manager manager) throws ManagerNotFoundException, InvalidPasswordException {
		boolean managerFound = false;
		boolean pwCheck = false;
		
		List<Manager> managers = new ArrayList<Manager>(managerdao.getAllManagers());
		Manager currentManager = new Manager();
		
		for(Manager m : managers) {
			if(m.getUsername().equals(manager.getUsername())) {
				managerFound = true;
				if(m.getPassword().equals(manager.getPassword())) {
					pwCheck = true;
					currentManager.setEID(m.getEID());
					currentManager.setUsername(m.getUsername());
					currentManager.setPassword(m.getPassword());
					currentManager.setFirstname(m.getFirstname());
					currentManager.setLastname(m.getLastname());
					return currentManager;
				}
			}
		}
		if(!managerFound) {
			throw new ManagerNotFoundException("There are no managers with this username: " + manager.getUsername());
		}
			
		if(managerFound && !pwCheck) {
			throw new InvalidPasswordException("This is an incorrect password. Plase try again.");
		}
		return null;
	}
	
	@Override
	public Manager getManagerByCredentials(String uid, String pw) {
		// TODO Auto-generated method stub
		return null;
	}
}
