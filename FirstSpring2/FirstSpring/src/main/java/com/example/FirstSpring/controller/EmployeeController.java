package com.example.FirstSpring.controller;


import com.example.FirstSpring.entity.Employee;
import com.example.FirstSpring.service.EmploeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
//@RestController
public class EmployeeController {

    @Autowired
    EmploeeService emploeeService;
    //@RequestMapping("/employees")
    //@RequestMapping(value = "/employees",method = RequestMethod.GET)
    @GetMapping("/employees")
    public List<Employee>findAllEmployees(){

        return emploeeService.getAllEmployees();

    }

//    @RequestMapping("/employees/{id}")
    @GetMapping("/employees/{id}")
    public Employee findAnEmployee(@PathVariable int id){

        return emploeeService.getAnEmployee(id);

    }

//    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    @PostMapping("/employees")
    public void createEmployee(@RequestBody Employee employee){

        emploeeService.createEmployee(employee);

    }

//    @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    @PutMapping("/employees/{id}")
    public void updateEmployee(@PathVariable int id,@RequestBody Employee employee){
        emploeeService.updateEmployee(employee);
    }

//    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/employees/{id}")
    public List<Employee> deleteEmployee(@PathVariable int id){
        emploeeService.deleteEmployee(id);
        return emploeeService.getAllEmployees();
    }

}
