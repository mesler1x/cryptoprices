package ru.cryptoprices.mesler.cryptoprices.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.cryptoprices.mesler.cryptoprices.exception.CoinNotFoundException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CoinNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(CoinNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> exceptionHandler(CoinNotFoundException coinNotFoundException){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", coinNotFoundException.getMessage());
        return errorMap;
    }
}
