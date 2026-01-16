package com.example.employeemanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping
    public String home(){
        return "Home Page";
    }

    @PostMapping ("/add")
    public String addEmployee(){
        return "Add Employee Page";
    }

    @GetMapping ("/search?id={userId}")
    public String searchEmployee(@RequestParam int userID){
        return "search Employee Page by "+userID;
    }

    @GetMapping ("/display")
    public String displayEmployee(){
        return "Display Employee Page";
    }

    @PutMapping ("/update?id={userID}")
    public String updateEmployee(@RequestParam int userID){
        return "update Employee Page by "+userID;
    }

    @DeleteMapping ("/delete?id={userID}")
    public String deleteEmployee(@RequestParam int userID){
        return "delete Employee Page by "+userID;
    }
}
