package in.thilak.spring_restful_webservice.socialmedia.service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import in.thilak.spring_restful_webservice.socialmedia.dao.User;
import in.thilak.spring_restful_webservice.socialmedia.exception.UserNotFoundException;

@Service
public class UserService {

    private static List<User> users = new ArrayList<>();
    static {
        users.add(new User(1, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(2, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(3, "Jack", LocalDate.now().minusYears(10)));
    }

    public List<User> findAll() {
        return users;
    }

    public User getUserById(int id) {
        /*
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
        */
        Predicate<User> predicate = user -> user.getId() == id;
        User user =  users.stream().filter(predicate).findFirst().orElse(null);
        if(user == null) {
            throw new UserNotFoundException("User with id " + id + " not found");
        }        
        return user;        
    }

    public User saveUser(User user) {
        if (user.getId() == null) {
            user.setId(users.size() + 1);
        }
        users.add(user);
        return user;
    }

    public User deleteUserById(int id) {
        Predicate<? super User> predicate = user -> user.getId() == id;
        User user =  users.stream().filter(predicate).findFirst().orElse(null);
        if(user == null) {
            throw new UserNotFoundException("User with id " + id + " not found");
        }        
        users.removeIf(predicate);
        return user;        
    }

}
