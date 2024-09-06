package com.opencoders.products.infrastructure.api.errors;

import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class RestErrors implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        String message = "An unexpected error ocurred";
        if ( ex instanceof MalformedJwtException){
            status = HttpStatus.FORBIDDEN;
            message = "Forbidden request";
        }
        response.setStatus(status.value());
        return new ModelAndView("errorWiew", "errorMessage", message);
    }
}