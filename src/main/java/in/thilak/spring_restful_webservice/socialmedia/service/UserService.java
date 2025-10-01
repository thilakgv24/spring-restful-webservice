package in.thilak.spring_restful_webservice.socialmedia.service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import in.thilak.spring_restful_webservice.socialmedia.dao.Post;
import in.thilak.spring_restful_webservice.socialmedia.dao.User;
import in.thilak.spring_restful_webservice.socialmedia.exception.UserNotFoundException;
import in.thilak.spring_restful_webservice.socialmedia.repository.PostRepository;
import in.thilak.spring_restful_webservice.socialmedia.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;
    private PostRepository postRepository;

    public UserService(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    private static List<User> users = new ArrayList<>();
    static {
        users.add(new User(1, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(2, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(3, "Jack", LocalDate.now().minusYears(10)));
    }

    public List<User> findAll() {
        return userRepository.findAll();
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
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));
        // Predicate<User> predicate = user -> user.getId() == id;
        // User user =  users.stream().filter(predicate).findFirst().orElse(null);
        // if(user == null) {
        //     throw new UserNotFoundException("User with id " + id + " not found");
        // }        
        return user;        
    }

    public User saveUser(User user) {
        // if (user.getId() == null) {
        //     user.setId(users.size() + 1);
        // }
        // users.add(user);
        user = userRepository.save(user);
        return user;
    }

    public User deleteUserById(int id) {
        // Predicate<? super User> predicate = user -> user.getId() == id;
        // User user =  users.stream().filter(predicate).findFirst().orElse(null);
        // if(user == null) {
        //     throw new UserNotFoundException("User with id " + id + " not found");
        // }        
        // users.removeIf(predicate);
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));
        userRepository.deleteById(id);
        
        return user;        
    }

    public List<Post> getPostsByUserId(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));
        return user.getPosts();
    }

    // create post for user
    public Post createPostForUser(int id, Post post) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));
        post.setUser(user);
        System.out.println("**************************"+user.toString());
        return postRepository.save(post);
    }   
}
