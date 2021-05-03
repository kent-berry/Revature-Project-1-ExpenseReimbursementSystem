package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Manager;
import util.ConnectionFactory;

public class ManagerDAOimpl implements ManagerDAO {



	@Override
	public Manager getManagerByCredentials(String uid, String pw) {
		Manager manager = null;
		try(Connection conn = ConnectionFactory.getConnection()) {
			String sql = "select id, username, password, firstname, lastname from users where username = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,  uid);
			ps.setString(2,  pw);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				manager = new Manager();
				manager.setEID(rs.getInt(1));
				manager.setUsername(rs.getString(2));
				manager.setPassword(rs.getString(3));
				manager.setFirstname(rs.getString(4));
				manager.setLastname(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return manager;
	}

	@Override
	public List<Manager> getAllManagers() {
		Manager m1 = null;
		try(Connection conn = ConnectionFactory.getConnection()) {
			String sql = "select id, username, password, firstname, lastname from users where is_manager = true";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Manager> managers = new ArrayList<Manager>();
			while(rs.next()) {
				m1 = new Manager();
				m1.setEID(rs.getInt(1));
				m1.setUsername(rs.getString(2));
				m1.setPassword(rs.getString(3));
				m1.setFirstname(rs.getString(4));
				m1.setLastname(rs.getString(5));
				managers.add(m1);
			}
		return managers;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Manager getManagerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
