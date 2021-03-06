package springboottutorial.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboottutorial.demo.entity.User;
import springboottutorial.demo.entity.request.AddUserRequest;
import springboottutorial.demo.repository.UserRepository;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @RequestMapping(method = RequestMethod.GET )
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    @RequestMapping( method = RequestMethod.POST)
    public  void addUser(@RequestBody AddUserRequest addUserRequest){
        User user = new User();
        user.setName(addUserRequest.getName());
        user.setSurname(addUserRequest.getSurname());
        userRepository.save(user);

    }


}
