package com.pj.springboot.kafka.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    @Override
    public String toString() {
        return "Employee{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", email='" + email + '\'' + ", phone='" + phone + '\'' +
                '}';
    }
}
