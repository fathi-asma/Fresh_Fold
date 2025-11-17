package com.store.fresh_fold.Controller;

import com.store.fresh_fold.Model.User;
import com.store.fresh_fold.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService = new UserService();

    @RequestMapping("/")
    public String index() {
        return "UserLoginForm";
    }

    @GetMapping("/user/login")
    public String showUserLoginPage() {
        return "UserLoginForm";
    }

    @PostMapping("/user/login")
    public String UserLogin(@RequestParam String userName, @RequestParam String password) {
        if (userService.userLogin(userName, password)) {
            return "UserDashboard";
        } else {
            return "UserLoginForm";
        }
    }

    @GetMapping("/user/register")
    public String showUserRegisterPage() {
        return "UserRegisterForm";
    }

    @PostMapping("/user/register")
    public String UserRegister(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String userName, @RequestParam String password, @RequestParam String email, @RequestParam String phoneNumber) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUserName(userName);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);

        if (userService.addUser(user)) {
            return "UserLoginForm";
        } else {
            return "UserRegisterForm";
        }
    }

}




