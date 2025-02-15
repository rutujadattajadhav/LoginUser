package org.example.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserException.class)
    public Mono<UserErrorResponse> handleServiceException(UserException ex, ServerWebExchange exchange) {
        CustomErrorResponse response = new CustomErrorResponse();
        response.setTimestamp(LocalDateTime.now());
        response.setPath(exchange.getRequest().getPath().toString());
        response.setStatus(ex.getCode());
        response.setError("Internal Server Error");
        response.setMessage(ex.getMessage());
        return Mono.just(new UserErrorResponse(response));
    }

    @ExceptionHandler(Exception.class)
    public Mono<UserErrorResponse> handleGenericException(Exception ex, ServerWebExchange exchange) {
        CustomErrorResponse response = new CustomErrorResponse();
        response.setTimestamp(LocalDateTime.now());
        response.setPath(exchange.getRequest().getPath().toString());
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setError("Internal Server Error");
        response.setMessage(ex.getMessage());
        return Mono.just(new UserErrorResponse(response));
    }
}

