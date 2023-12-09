package com.cb.service.impl;

import com.cb.Messages;
import com.cb.base.basers.BaseRs;
import com.cb.base.rs.ErrorRs;
import com.cb.constants.ErrorCodes;
import com.cb.constants.MessageCodes;
import com.cb.datars.EmployeeDataRs;
import com.cb.entity.Employee;
import com.cb.exception.InvalidEmployeeData;
import com.cb.helper.EmployeeHelper;
import com.cb.repo.IEmployeeRepo;
import com.cb.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepo repo;

    @Autowired
    private Messages messages;

    @Override
    public BaseRs save(Employee e) {
        try{
            List<ErrorRs> errors = EmployeeHelper.validateSaveEmployee(e, messages);
            if (!errors.isEmpty()) {
                String errorMessage = messages.getError(ErrorCodes.EC_INVALID_INPUT);
                throw new InvalidEmployeeData(ErrorCodes.EC_INVALID_INPUT, errorMessage, errors);
            }
            Optional.of(e.getEmail()).filter(email -> !repo.existsByEmail(email))
                    .ifPresentOrElse(exists -> {
                        repo.save(e);
                    }, () -> {
                        throw new RuntimeException("Employee Already Exists !!!");
                    });
            EmployeeDataRs dataRs = new EmployeeDataRs();
            String message = messages.getMessage(MessageCodes.MC_CREATED_SUCCESSFULLY);
            dataRs.setMessage(message);
            dataRs.setEmployee(e);
            return dataRs;
        }catch (Exception ex){
            throw ex;
        }
    }

    @Override
    public Employee update(Employee e) {
        Optional.ofNullable(e.getId()).filter(emp -> repo.existsById(emp))
                .ifPresentOrElse((emp) -> {
                    repo.save(e);
                }, () -> {
                    throw new RuntimeException("Employee Not Found");
                });
        return e;
    }

    @Override
    public void delete(Integer id) {
        Optional.of(id).filter(ids -> repo.existsById(id))
                .ifPresentOrElse(i -> {
                    repo.deleteById(id);
                }, () -> {
                    throw new RuntimeException("Employee Not Found");
                });
    }
}
