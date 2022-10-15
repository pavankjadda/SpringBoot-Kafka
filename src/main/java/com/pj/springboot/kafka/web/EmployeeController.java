package com.pj.springboot.kafka.web;

import com.pj.springboot.kafka.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Create employee with random information
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @GetMapping("/create")
    public void createEmployee() {
        employeeService.createEmployee();
    }
}
