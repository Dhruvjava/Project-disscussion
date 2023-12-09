package com.cb.util;

import com.cb.Messages;
import com.cb.base.rs.ErrorRs;

public class Utils {
    public static ErrorRs populateErrorRSs(String code, Messages messages) {

        ErrorRs rs = new ErrorRs();
        rs.setCode(code);
        rs.setMessage(messages.getError(code));
        return rs;
    }
}
