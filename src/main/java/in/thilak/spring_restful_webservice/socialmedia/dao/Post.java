package in.thilak.spring_restful_webservice.socialmedia.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    @JsonIgnore
    @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY) // many Posts to one user
    //@JoinColumn(name = "user_id")
    private User user;

    public Post() {
        super();
    }  
    public Post(Integer id, String description) {
        super();
        this.id = id;
        this.description = description;
    }

    //getters and setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post [id=" + id + ", description=" + description + "]";
    }

}
