package in.thilak.spring_restful_webservice.helloworld.dao;

public class HelloWorldBean {

    private String message;
    private int id;

    public HelloWorldBean(String message, int id) {
        this.message = message;
        this.id = id;
    }
     //getter and setters
    public String getMessage() {
        return message;
    }   
    public void setMessage(String message) {
        this.message = message;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }   
    @Override
    public String toString() {
        return "HelloWorldBean [message=" + message + ", id=" + id + "]";
    }

}
