package dm.passwordvalidator;

public interface ValidationRule {
	
	/**
	 * @param inPassword
	 * @return true if valid, false if invalid
	 */
	public boolean validate(String inPassword);
	
	/**
	 * Gets the error message
	 * @return
	 */
	public String getMessage();
	
}
