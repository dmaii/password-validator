package dm.passwordvalidator;

import java.util.regex.Pattern;

/**
 * Implementation of ValidationRule that validates a password based on the specified regex.
 * If the password matches the regex, then it's valid, otherwise it's invalid.
 * @author dm
 */
public class RegexValidationRule implements ValidationRule {
	
	private String regex;
	
	private String message;
	
	public RegexValidationRule() { }
	
	public RegexValidationRule(String inRegex, String inMessage) {
		this.regex = inRegex;
		this.message = inMessage;
	}

	/* (non-Javadoc)
	 * @see com.test.password_validator.ValidationRule#validate(java.lang.String)
	 */
	public boolean validate(String inPassword) {
		if (Pattern.matches(regex, inPassword)) {
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.test.password_validator.ValidationRule#getMessage()
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @param inRegex
	 */
	public void setRegex(String inRegex) {
		this.regex = inRegex;
	}

}
