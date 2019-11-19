package com.controller;

import com.domain.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userServiceImpl;

    @GetMapping("/getUsers")
    public String getUsers (ModelMap map){
        List<User> users = this.userServiceImpl.getUsers();
        map.addAttribute( "users",users );
        return "index";
    }

    @PostMapping("/addUser")
    public String addUser (ModelMap map,User user){
        if (this.userServiceImpl.addUser( user )!=null)
            return "redirect:/user/getUsers";
        else
            return "index";
    }

    @PostMapping("/deleteUser")
    public String deleteUser (Integer id){
        try {
            this.userServiceImpl.deleteUser( id );
            return "redirect:/user/getUsers";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }
}
