package in.thilak.spring_restful_webservice.socialmedia.dao;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;


public class User {

    private Integer id;
    @JsonProperty("user_name")
    @Size(min=2, message="Name should have atleast 2 characters")
    private String name;   
    @Past(message="Birth date should be in the past") 
    private LocalDate birthDate;

    //constructors
    public User() {
        super();
     }
    public User(Integer id, String name, LocalDate birthDate) {
        super();
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    //getters and setters
    public Integer getId() {
        return id;
    }   
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }   
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }       

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
    }

}
