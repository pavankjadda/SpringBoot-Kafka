package com.pj.springboot.kafka.service;

/**
 * Send employee information to EMPLOYEE_TOPIC
 *
 * @author Pavan Kumar Jadda
 * @since 1.0.0
 */
public interface EmployeeService {
    /**
     * Create employee with random information
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    void createEmployee();
}
