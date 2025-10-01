package in.thilak.spring_restful_webservice.socialmedia.error;

import java.time.LocalDate;

public class ErrorDetails {

    private LocalDate timestamp;
    private String message;
    private String details;

    public ErrorDetails(LocalDate timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }
    public String getMessage() {
        return message;
    }
    public String getDetails() {
        return details;
    }
    //setters
    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }       
    public void setMessage(String message) {
        this.message = message;
    }           
    public void setDetails(String details) {
        this.details = details;
    }
    
    @Override
    public String toString() {
        return "ErrorDetails [timestamp=" + timestamp + ", message=" + message + ", details=" + details + "]";
    }
}
