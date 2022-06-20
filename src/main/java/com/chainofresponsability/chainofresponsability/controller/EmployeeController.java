package com.chainofresponsability.chainofresponsability.controller;

import com.chainofresponsability.chainofresponsability.model.Employee;
import com.chainofresponsability.chainofresponsability.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee add(@Valid @RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> remove(@PathVariable Long employeeId){
        if(!employeeRepository.existsById(employeeId)){
            return ResponseEntity.notFound().build();
        }
        employeeRepository.deleteById(employeeId);
        return ResponseEntity.noContent().build();
    }
}
