package com.ecommerce.sprintboot.service.impl;

import com.ecommerce.sprintboot.entity.Employee;
import com.ecommerce.sprintboot.repository.EmployeeRepository;
import com.ecommerce.sprintboot.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements IService<Employee> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee save(Employee employee){
        return  employeeRepository.save( employee);
    }

    @Override
    public Optional<Employee> findById(long id) {
        return employeeRepository.findById(id);
    }

    public void delete(long id )
    {
        employeeRepository.deleteById( id );
    }
}
