package model;

public class Employee {

	private int EID;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private int managerID;
	
	public Employee() {
	}
	
	public Employee(int eID, String username, String password, String firstname, String lastname, int managerID) {
		super();
		EID = eID;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.managerID = managerID;
	}
	
	public int getEID() {
		return EID;
	}
	
	public void setEID(int eID) {
		EID = eID;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public int getManagerID() {
		return managerID;
	}
	
	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}
	
	@Override
	public String toString() {
		return "Employee [EID=" + EID + ", username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", managerID=" + managerID + "]";
	}
}
