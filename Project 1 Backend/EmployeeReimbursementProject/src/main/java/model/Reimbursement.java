package model;

public class Reimbursement {

	private int RID;
	private int EIDRequester;
	private double AMOUNT;
	private String DESCRIPTION;
	private String TYPE;
	private String DATE1;
	private String RSTATUS;
	private String RFEEDBACK;
	
	public Reimbursement() {
		super();
	}
	
	public Reimbursement(int rID, int eIDRequester, double aMOUNT, String dESCRIPTION, String tYPE, String dATE1,
			String rSTATUS, String rCOMMENT) {
		super();
		RID = rID;
		EIDRequester = eIDRequester;
		AMOUNT = aMOUNT;
		DESCRIPTION = dESCRIPTION;
		TYPE = tYPE;
		DATE1 = dATE1;
		RSTATUS = rSTATUS;
		RFEEDBACK = rCOMMENT;
	}
	
	public int getRID() {
		return RID;
	}
	
	public void setRID(int rID) {
		RID = rID;
	}
	
	public int getEIDRequester() {
		return EIDRequester;
	}
	
	public void setEIDRequester(int eIDRequester) {
		EIDRequester = eIDRequester;
	}
	
	public double getAMOUNT() {
		return AMOUNT;
	}
	
	public void setAMOUNT(double aMOUNT) {
		AMOUNT = aMOUNT;
	}
	
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
	
	public String getTYPE() {
		return TYPE;
	}
	
	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}
	
	public String getDATE1() {
		return DATE1;
	}
	
	public void setDATE1(String dATE1) {
		DATE1 = dATE1;
	}
	
	public String getRSTATUS() {
		return RSTATUS;
	}
	
	public void setRSTATUS(String rSTATUS) {
		RSTATUS = rSTATUS;
	}
	
	public String getRFEEDBACK() {
		return RFEEDBACK;
	}
	
	public void setRFEEDBACK(String RFEEDBACK) {
		this.RFEEDBACK = RFEEDBACK;
	}
	
	@Override
	public String toString() {
		return "Reimbursement [RID=" + RID + ", EIDRequester=" + EIDRequester + ", AMOUNT=" + AMOUNT + ", DESCRIPTION="
				+ DESCRIPTION + ", TYPE=" + TYPE + ", DATE1=" + DATE1 + ", RSTATUS=" + RSTATUS + ", RCOMMENT="
				+ RFEEDBACK + "]";
	}
}
