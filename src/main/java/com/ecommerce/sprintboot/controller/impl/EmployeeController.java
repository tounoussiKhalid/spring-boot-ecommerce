package com.ecommerce.sprintboot.controller.impl;

import com.ecommerce.sprintboot.controller.IController;
import com.ecommerce.sprintboot.entity.Employee;
import com.ecommerce.sprintboot.service.IService;
import com.ecommerce.sprintboot.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class EmployeeController extends IController<Employee> {

    @Autowired
    private EmployeeServiceImpl iService;

    @Override
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEntities(){
        List<Employee> employees = iService.findAll();
        if( employees.isEmpty() )
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>( employees, HttpStatus.OK);
    }

    @Override
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEntityById(@PathVariable("id") Long id) {
        Optional<Employee> employeeData = iService.findById(id);

        if (employeeData.isPresent()) {
            return new ResponseEntity<>(employeeData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @PostMapping("/employees")
    public ResponseEntity<Employee> createEntity( @RequestBody Employee employee){
        try{
            Employee _employee  = new Employee( employee.getName(), employee.getRole());
            _employee = iService.save( _employee);
            return new ResponseEntity<>(_employee, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Override
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEntity( @PathVariable("id") Long id, @RequestBody Employee employee){
        Optional<Employee> employeeData = iService.findById(id);
        if( employeeData.isPresent()){
                Employee _employee = employeeData.get();
                _employee.setName( employee.getName());
                _employee.setRole( employee.getRole());
             return new ResponseEntity( iService.save(_employee), HttpStatus.OK);
        } else{
                return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @DeleteMapping("/employees/{id]")
    public ResponseEntity<HttpStatus> deleteEntity(@PathVariable("id") Long id){
        try{
            iService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch( Exception e){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}
