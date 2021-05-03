package dao;

import java.util.List;

import model.Manager;

public interface ManagerDAO {

	public List<Manager> getAllManagers();
	public Manager getManagerById(int id);
	public Manager getManagerByCredentials(String uid, String pw);
}
