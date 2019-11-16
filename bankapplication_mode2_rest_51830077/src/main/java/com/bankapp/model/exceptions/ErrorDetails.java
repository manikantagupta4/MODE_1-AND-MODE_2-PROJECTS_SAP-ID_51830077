package com.bankapp.model.exceptions;

import java.time.LocalDateTime;

public class ErrorDetails {
	/*"timestamp": "2019-11-26T15:13:54.230+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "Account not found with this accountNumber",
    "trace": "
*/
	private String message;
	private String description;
	private LocalDateTime timestamp;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public ErrorDetails() {
		// TODO Auto-generated constructor stub
	}
	public ErrorDetails(String message, String description, LocalDateTime timestamp) {
		super();
		this.message = message;
		this.description = description;
		this.timestamp = timestamp;
	}
	
}

