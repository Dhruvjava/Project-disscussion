package com.cb.hanler;

import com.cb.exception.InvalidEmployeeData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler(InvalidEmployeeData.class)
    public ResponseEntity<ProblemDetail> handleInvalidEmployeeData(InvalidEmployeeData ed){

        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problemDetail.setTitle(ed.getCode());
        problemDetail.setDetail(ed.getMessage());
        if (ed.getErrors() != null && !ed.getErrors().isEmpty()){
            problemDetail.setProperty("errors", ed.getErrors());
        }

        return ResponseEntity.badRequest().body(problemDetail);
    }

}
