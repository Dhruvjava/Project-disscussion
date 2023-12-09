package com.cb.service;

import com.cb.base.basers.BaseRs;
import com.cb.entity.Employee;

public interface IEmployeeService {

    //save

    public BaseRs save(Employee e);

    //update

    public Employee update(Employee e);

    //delete

    public void delete(Integer id);

    // retrieve

    //etc..

}
