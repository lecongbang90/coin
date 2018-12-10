
package vn.com.coin.model;


public class ResultError {
	/** The message */
	private String message;
	
	public ResultError(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
