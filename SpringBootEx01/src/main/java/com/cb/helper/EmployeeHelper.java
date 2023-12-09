package com.cb.helper;

import com.cb.Messages;
import com.cb.base.rs.ErrorRs;
import com.cb.constants.ErrorCodes;
import com.cb.entity.Employee;
import com.cb.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class EmployeeHelper {
    public static List<ErrorRs> validateSaveEmployee(Employee e, Messages messages) {
        List<ErrorRs> errors = new ArrayList<>();
        if (e.getName() == null) {
            errors.add(Utils.populateErrorRSs(ErrorCodes.EC_REQUIRED_NAME, messages));
        }
        if (e.getEmail() == null) {
            errors.add(Utils.populateErrorRSs(ErrorCodes.EC_REQUIRED_EMAIL, messages));
        }
        if (e.getCity() == null) {
            errors.add(Utils.populateErrorRSs(ErrorCodes.EC_REQUIRED_CITY, messages));
        }
        return errors;
    }
}
