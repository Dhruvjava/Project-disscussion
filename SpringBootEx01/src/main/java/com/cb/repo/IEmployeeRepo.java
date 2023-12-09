package com.cb.repo;

import com.cb.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepo extends JpaRepository<Employee, Integer> {

    boolean existsByEmail(String email);

}
