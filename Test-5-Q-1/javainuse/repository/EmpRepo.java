package com.javainuse.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.javainuse.model.Employee;


public interface EmpRepo extends JpaRepository<Employee, Integer> {

}
