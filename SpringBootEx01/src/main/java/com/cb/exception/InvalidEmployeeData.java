package com.cb.exception;

import com.cb.base.rs.ErrorRs;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class InvalidEmployeeData extends RuntimeException{

    private String code;

    private String message;

    private List<ErrorRs> errors;

    public InvalidEmployeeData(String code, String message, List<ErrorRs> errors) {
        this.code = code;
        this.message = message;
        this.errors = errors;
    }

    public InvalidEmployeeData(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
