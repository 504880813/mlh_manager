package rms.controller.exception;

public class CustomException extends Exception {
	
	private String meesage;

	public CustomException(String meesage) {
		super(meesage);
		this.meesage = meesage;
	}

	public String getMeesage() {
		return meesage;
	}

	public void setMeesage(String meesage) {
		this.meesage = meesage;
	}
	
	 
}
