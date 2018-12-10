
package vn.com.coin.model;

public class ResultSuccess {
	/** The message */
	private String message;
	/** The status */
	private boolean status;

	public ResultSuccess(String message, boolean status) {
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
