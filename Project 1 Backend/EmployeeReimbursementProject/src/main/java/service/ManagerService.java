package service;

import model.Manager;
import exception.InvalidPasswordException;
import exception.ManagerNotFoundException;

public interface ManagerService {
	Manager getManagerByCredentials(String uid, String pw);
	Manager managerLogin(Manager manager) throws ManagerNotFoundException, InvalidPasswordException;
}
