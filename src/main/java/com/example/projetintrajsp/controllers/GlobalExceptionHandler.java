package com.example.projetintrajsp.controllers;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class GlobalExceptionHandler {
    public static final String error_view = "error";

    /**
     * Rattrape toute les exceptions, erreurs et code http a l'aide de l'annotation @ControllerAdvice
     * et @ExceptionHandler est assigner a la classe Exception pour que sa soit globale. Affiche
     * le code http, la raison de l'erreur ainsi qu'un message expliquant ce qui c'est passer sur
     * la page error
     * @param e exception variable
     * @param status http status
     * @return error.html
     * @throws Exception main class
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView
    defaultErrorHandler(Exception e, HttpStatus status) throws Exception {
        if (AnnotationUtils.findAnnotation
                (e.getClass(), ResponseStatus.class) != null)
            throw e;

        // Sends the user to a custom error view
        ModelAndView mav = new ModelAndView();
        mav.addObject("status", status.value());
        mav.addObject("error", status.getReasonPhrase());
        mav.addObject("exception", e.getMessage());
        mav.setViewName(error_view);
        return mav;
    }
}
