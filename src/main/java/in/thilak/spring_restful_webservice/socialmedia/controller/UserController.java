package in.thilak.spring_restful_webservice.socialmedia.controller;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import in.thilak.spring_restful_webservice.socialmedia.dao.User;
import in.thilak.spring_restful_webservice.socialmedia.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping
    public List<User> retrieveAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable(required = true) int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/{id}/hateoas")
    public EntityModel<User> getUserByIdWithHateoas(@PathVariable(required = true) int id) {

        EntityModel<User> user = EntityModel.of(userService.getUserById(id));
        WebMvcLinkBuilder linkToUsers = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        user.add(linkToUsers.withRel("all-users"));
        return user;
    }

    @PostMapping
    public ResponseEntity<User> creatUser(@Valid @RequestBody User user) {
         User userResponse = userService.saveUser(user);
         URI newresourcelocation = ServletUriComponentsBuilder.fromCurrentRequest()
                 .path("/{id}") // append /{id} to current url
                 .buildAndExpand(userResponse.getId()) // replace {id} with userResponse.getId()
                 .toUri(); // convert to URI
        //return ResponseEntity.created(newresourcelocation).build();
        return ResponseEntity.created(newresourcelocation).body(userResponse);
    }

    @DeleteMapping("/{id}")
    public User deleteUserById(@PathVariable int id) {
       return userService.deleteUserById(id);
        
    }
}
