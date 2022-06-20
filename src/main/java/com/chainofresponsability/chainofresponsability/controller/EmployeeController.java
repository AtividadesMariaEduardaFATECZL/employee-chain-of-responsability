package com.chainofresponsability.chainofresponsability.controller;

import com.chainofresponsability.chainofresponsability.model.Employee;
import com.chainofresponsability.chainofresponsability.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

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

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> search(@PathVariable Long employeeId){
        Optional<Employee> possibleEmployee = employeeRepository.findById(employeeId);

        return possibleEmployee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> remove(@PathVariable Long employeeId){
        if(!employeeRepository.existsById(employeeId)){
            return ResponseEntity.notFound().build();
        }
        employeeRepository.deleteById(employeeId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee> update(@Valid @PathVariable Long employeeId,
                                             @RequestBody Employee employee){
        if(!employeeRepository.existsById(employeeId)){
            return ResponseEntity.notFound().build();
        }
        employee.setId(employeeId);
        employee = employeeRepository.save(employee);
        return ResponseEntity.ok(employee);
    }
}
