package dm.passwordvalidator;

import java.util.List;

public class ValidationResult {
	
	private boolean valid = true;
	
	private List<String> messages;

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	
}
