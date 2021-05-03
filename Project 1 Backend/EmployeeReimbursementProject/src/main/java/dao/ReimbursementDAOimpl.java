package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
import model.Manager;
import model.Reimbursement;
import util.ConnectionFactory;

public class ReimbursementDAOimpl implements ReimbursementDAO {

	@Override
	public List<Reimbursement> getAllEmployeeReimbursements(Employee e) {
        try(Connection conn = ConnectionFactory.getConnection()){
        	String sql = "select id, amount, type, description, date_created, status, feedback from reimbursements where requested_by = ?";
        	PreparedStatement ps = conn.prepareStatement(sql);
        	ps.setInt(1,  e.getEID());
            List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
            ResultSet rs =  ps.executeQuery();
            while(rs.next()) {
            	Reimbursement r1 = new Reimbursement();
                r1.setRID(rs.getInt(1));
                r1.setAMOUNT(rs.getInt(2));
                r1.setTYPE(rs.getString(3));
				r1.setDESCRIPTION(rs.getString(4));
				r1.setDATE1(rs.getString(5));
				r1.setRSTATUS(rs.getString(6));
				r1.setRFEEDBACK(rs.getString(7));
				reimbursements.add(r1);
            }
            return reimbursements;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
	}

	@Override
	public List<Reimbursement> viewEmpApprovedReimbursements(Employee e) {
        try(Connection conn = ConnectionFactory.getConnection()){
        	String sql = "select id, amount, type, description, date_created, status, feedback from reimbursements where requested_by = ? and status = ?";
        	PreparedStatement ps = conn.prepareStatement(sql);
        	ps.setInt(1,  e.getEID());
        	ps.setString(2,  "approved");
            List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
            ResultSet rs =  ps.executeQuery();
            while(rs.next()) {
            	Reimbursement r1 = new Reimbursement();
            	r1.setRID(rs.getInt(1));
                r1.setAMOUNT(rs.getInt(2));
                r1.setTYPE(rs.getString(3));
				r1.setDESCRIPTION(rs.getString(4));
				r1.setDATE1(rs.getString(5));
				r1.setRSTATUS(rs.getString(6));
				r1.setRFEEDBACK(rs.getString(7));
				reimbursements.add(r1);
            }
            return reimbursements;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
	}

	@Override
	public List<Reimbursement> viewEmpDeniedReimbursements(Employee e) {
        try(Connection conn = ConnectionFactory.getConnection()){
        	String sql = "select id, amount, type, description, date_created, status, feedback from reimbursements where requested_by = ? and status = ?";
        	PreparedStatement ps = conn.prepareStatement(sql);
        	ps.setInt(1,  e.getEID());
        	ps.setString(2,  "denied");
            List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
            ResultSet rs =  ps.executeQuery();
            while(rs.next()) {
            	Reimbursement r1 = new Reimbursement();
            	r1.setRID(rs.getInt(1));
                r1.setAMOUNT(rs.getInt(2));
                r1.setTYPE(rs.getString(3));
				r1.setDESCRIPTION(rs.getString(4));
				r1.setDATE1(rs.getString(5));
				r1.setRSTATUS(rs.getString(6));
				r1.setRFEEDBACK(rs.getString(7));
				reimbursements.add(r1);
            }
            return reimbursements;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
	}

	@Override
	public List<Reimbursement> viewEmpPendingReimbursements(Employee e) {
        try(Connection conn = ConnectionFactory.getConnection()){
        	String sql = "select id, amount, type, description, date_created, status, feedback from reimbursements where requested_by = ? and status = ?";
        	PreparedStatement ps = conn.prepareStatement(sql);
        	ps.setInt(1,  e.getEID());
        	ps.setString(2,  "pending");
            List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
            ResultSet rs =  ps.executeQuery();
            while(rs.next()) {
            	Reimbursement r1 = new Reimbursement();
            	r1.setRID(rs.getInt(1));
                r1.setAMOUNT(rs.getInt(2));
                r1.setTYPE(rs.getString(3));
				r1.setDESCRIPTION(rs.getString(4));
				r1.setDATE1(rs.getString(5));
				r1.setRSTATUS(rs.getString(6));
				r1.setRFEEDBACK(rs.getString(7));
				reimbursements.add(r1);
            }
            return reimbursements;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
	}
	
	@Override
	public Reimbursement submitNewReimbursement(Reimbursement r) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "insert into reimbursements(requested_by, amount, type, description, status, feedback) values (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, r.getEIDRequester());
			ps.setDouble(2, r.getAMOUNT());
			ps.setString(3, r.getTYPE());
			ps.setString(4, r.getDESCRIPTION());
			ps.setString(5, "pending");
			ps.setString(6, null);
			ps.execute();
			System.out.println("Entered Successfully.");
		} catch (SQLException e) {
			System.out.println("Failed");
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Reimbursement> getAllManagerReimbursements(Manager manager) {
        try(Connection conn = ConnectionFactory.getConnection()){
        	String sql = "select id, requested_by, amount, type, description, date_created, status, feedback from reimbursements";
        	PreparedStatement ps = conn.prepareStatement(sql);
            List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
            ResultSet rs =  ps.executeQuery();
            while(rs.next()) {
            	Reimbursement r1 = new Reimbursement();
                r1.setRID(rs.getInt(1));
                r1.setEIDRequester(rs.getInt(2));
                r1.setAMOUNT(rs.getInt(3));
                r1.setTYPE(rs.getString(4));
				r1.setDESCRIPTION(rs.getString(5));
				r1.setDATE1(rs.getString(6));
				r1.setRSTATUS(rs.getString(7));
				r1.setRFEEDBACK(rs.getString(8));
				reimbursements.add(r1);
            }
            return reimbursements;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
	}
	
	@Override
	public List<Reimbursement> viewManPendingReimbursements(Manager m) {
        try(Connection conn = ConnectionFactory.getConnection()){
        	String sql = "select id, requested_by, amount, type, description, date_created, status, feedback from reimbursements where status = ?";
        	PreparedStatement ps = conn.prepareStatement(sql);
        	ps.setString(1,  "pending");
            List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
            ResultSet rs =  ps.executeQuery();
            while(rs.next()) {
            	Reimbursement r1 = new Reimbursement();
            	r1.setRID(rs.getInt(1));
                r1.setEIDRequester(rs.getInt(2));
                r1.setAMOUNT(rs.getInt(3));
                r1.setTYPE(rs.getString(4));
				r1.setDESCRIPTION(rs.getString(5));
				r1.setDATE1(rs.getString(6));
				r1.setRSTATUS(rs.getString(7));
				r1.setRFEEDBACK(rs.getString(8));
				reimbursements.add(r1);
            }
            return reimbursements;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
	}

	@Override
	public List<Reimbursement> viewManApprovedReimbursements(Manager m) {
        try(Connection conn = ConnectionFactory.getConnection()){
        	String sql = "select id, requested_by, amount, type, description, date_created, status, feedback from reimbursements where status = ?";
        	PreparedStatement ps = conn.prepareStatement(sql);
        	ps.setString(1,  "approved");
            List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
            ResultSet rs =  ps.executeQuery();
            while(rs.next()) {
            	Reimbursement r1 = new Reimbursement();
            	r1.setRID(rs.getInt(1));
                r1.setEIDRequester(rs.getInt(2));
                r1.setAMOUNT(rs.getInt(3));
                r1.setTYPE(rs.getString(4));
				r1.setDESCRIPTION(rs.getString(5));
				r1.setDATE1(rs.getString(6));
				r1.setRSTATUS(rs.getString(7));
				r1.setRFEEDBACK(rs.getString(8));
				reimbursements.add(r1);
            }
            return reimbursements;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
	}

	@Override
	public List<Reimbursement> viewManDeniedReimbursements(Manager m) {
        try(Connection conn = ConnectionFactory.getConnection()){
        	String sql = "select id, requested_by, amount, type, description, date_created, status, feedback from reimbursements where status = ?";
        	PreparedStatement ps = conn.prepareStatement(sql);
        	ps.setString(1,  "denied");
            List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
            ResultSet rs =  ps.executeQuery();
            while(rs.next()) {
            	Reimbursement r1 = new Reimbursement();
            	r1.setRID(rs.getInt(1));
                r1.setEIDRequester(rs.getInt(2));
                r1.setAMOUNT(rs.getInt(3));
                r1.setTYPE(rs.getString(4));
				r1.setDESCRIPTION(rs.getString(5));
				r1.setDATE1(rs.getString(6));
				r1.setRSTATUS(rs.getString(7));
				r1.setRFEEDBACK(rs.getString(8));
				reimbursements.add(r1);
            }
            return reimbursements;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
	}

	@Override
	public Reimbursement approveReimbursements(Reimbursement r) {
		try(Connection conn = ConnectionFactory.getConnection()) {
			conn.setAutoCommit(false);
			String sql = "update reimbursements set status = ?,feedback = ? where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);	
			ps.setString(1, "approved");
			ps.setString(2, r.getRFEEDBACK());
			ps.setInt(3, r.getRID());
			ps.executeUpdate();
			conn.commit();
			System.out.println("Reimbursement was approved successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}


	@Override
	public Reimbursement denyReimbursements(Reimbursement r) {
		try(Connection conn = ConnectionFactory.getConnection()) {
			conn.setAutoCommit(false);
			String sql = "update reimbursements set status = ?,feedback = ? where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);	
			ps.setString(1, "denied");
			ps.setString(2, r.getRFEEDBACK());
			ps.setInt(3, r.getRID());
			ps.executeUpdate();
			conn.commit();
			System.out.println("Reimbursement was denied successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
}
