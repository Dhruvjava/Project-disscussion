package com.cb.rest;

import com.cb.base.basers.BaseRs;
import com.cb.entity.Employee;
import com.cb.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HomeRest {

    @Autowired
    private IEmployeeService service;

    @PostMapping("/save")
    public ResponseEntity<BaseRs> save(@RequestBody Employee e){
        try{
            return ResponseEntity.ok(service.save(e));
        }catch (Exception ex){
            throw ex;
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> update(@RequestBody Employee e){
        return ResponseEntity.ok(service.update(e));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.ok("Deleted !!!");
    }

}
