package com.pj.springboot.kafka.service;

import com.pj.springboot.kafka.domain.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

import static com.pj.springboot.kafka.constants.KafkaConstants.EMPLOYEE_TOPIC;

/**
 * Send employee information to EMPLOYEE_TOPIC
 *
 * @author Pavan Kumar Jadda
 * @since 1.0.0
 */
@Service
@Transactional
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{
    private final KafkaTemplate<String,Employee> kafkaTemplate;

    public EmployeeServiceImpl(KafkaTemplate<String,Employee> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Create employee with random information
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @Override
    public void createEmployee() {
        var employee=new Employee("John"+ new Random().nextInt(),"Doe", "jdoe@example.com","123-456-7890");
        kafkaTemplate.send(EMPLOYEE_TOPIC, employee.getFirstName(),employee);
        log.info("Sent employee: {} to topic:{}", employee, EMPLOYEE_TOPIC);
    }
}
