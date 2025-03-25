package com.itlaoqi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.itlaoqi.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class SampleController {

    @GetMapping(path = "/users")
    public ResponseEntity<Map<String,Object>> findUser(Integer rows){
        Map<String,Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("message", "success");
        List<User> users = new ArrayList<>();
        for(int i = 0 ; i < rows ; i++){
            users.add(new User("u" + i, "p" + i));
        }

        result.put("data", users);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(path = "/users")
    public Map<String,Object> createUser(User user){
        Map<String,Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("message", "success");
        result.put("data", user);
        return result;
    }


    @PutMapping(path = "/users/{uid}")
    public Map updateUser(@PathVariable("uid") String uid ,User user){
        Map<String,Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("message", "success");
        result.put("data", user);
        return result;
    }

    @DeleteMapping(path = "/users/{uid}")
    public Map deleteUser(@PathVariable("uid") String uid){
        Map<String,Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("message", "success");
        return result;
    }

    @GetMapping("/header")
    public Map getHeader(@RequestHeader("token") String accessToken){
        Map<String,Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("message", "success");
        result.put("data", accessToken);
        return result;
    }

    @PostMapping("/body")
    public Map getBody(@RequestBody User user){
        Map<String,Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("message", "success");
        result.put("data", user);
        return result;
    }

}