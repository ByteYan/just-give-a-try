package com.itlaoqi.controller;

import com.itlaoqi.model.Address;
import com.itlaoqi.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;

@RestController
@RequestMapping("/v1/")
public class JacksonController {
    @GetMapping("/employees")
    public Employee showEmployee(){
        Address address = new Address("123 Main St.", "Springfield", "MA", "12345");

        // 创建 Employee 对象
        Employee employee = new Employee(1L, "John", "Doe", LocalDate.of(1990, 1, 1), address, "123-45-6789");
        employee.setDepartments(Arrays.asList("HR", "IT"));
        return employee;
    }
}
