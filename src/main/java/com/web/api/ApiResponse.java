package com.web.api;

/** ApiResponse */
public class ApiResponse {
  private int status;
  private String message;
  private long timestamp;

  public ApiResponse() {}

  public ApiResponse(String message, int status, long timestamp) {
    this.status = status;
    this.message = message;
    this.timestamp = timestamp;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public int getStatus() {
    return this.status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public long getTimestamp() {
    return this.timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }
}
