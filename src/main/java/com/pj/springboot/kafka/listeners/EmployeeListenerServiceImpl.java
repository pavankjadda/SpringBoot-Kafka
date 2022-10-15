package com.pj.springboot.kafka.listeners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pj.springboot.kafka.domain.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.pj.springboot.kafka.constants.KafkaConstants.EMPLOYEE_TOPIC;

/**
 * Kafka listener service that listens to messages from a Topic
 *
 * @author Pavan Kumar Jadda
 * @since 1.0.0
 */
@Service
@Transactional
@Slf4j
public class EmployeeListenerServiceImpl implements EmployeeListenerService {
    private final ObjectMapper objectMapper;

    public EmployeeListenerServiceImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * Listen and process information received from EMPLOYEE_TOPIC
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @KafkaListener(topics = EMPLOYEE_TOPIC)
    public void processEmployeeInformation(String content) {
        log.info("Raw message received:{} from topic:{} ", content, EMPLOYEE_TOPIC);
        try {
            var employee = objectMapper.readValue(content, Employee.class);
            log.info("Formatted employee information:{} from topic:{} ", employee, EMPLOYEE_TOPIC);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
