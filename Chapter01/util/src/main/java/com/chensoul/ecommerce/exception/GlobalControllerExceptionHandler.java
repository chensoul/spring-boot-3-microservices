package com.chensoul.ecommerce.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
class GlobalControllerExceptionHandler {
  @ResponseStatus(NOT_FOUND)
  @ExceptionHandler(NotFoundException.class)
  public ProblemDetail handleNotFoundException(NotFoundException ex, HttpServletRequest request) {
    log.warn(ex.getMessage(), ex);

    return this.buildProblemDetail(HttpStatus.NOT_FOUND, ex.getMessage());
  }

  @ResponseStatus(UNPROCESSABLE_ENTITY)
  @ExceptionHandler(InvalidInputException.class)
  public ProblemDetail handleInvalidInputException(InvalidInputException ex, HttpServletRequest request) {
    log.warn(ex.getMessage(), ex);

    return this.buildProblemDetail(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
  }

  @ResponseStatus(INTERNAL_SERVER_ERROR)
  @ExceptionHandler(BusinessException.class)
  public ProblemDetail handleBusinessException(BusinessException ex, HttpServletRequest request) {
    log.warn(ex.getMessage(), ex);

    return this.buildProblemDetail(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(Throwable.class)
  public ProblemDetail handleAllExceptions(final Throwable ex, HttpServletRequest request) {
    log.warn(ex.getMessage(), ex);

    return this.buildProblemDetail(HttpStatus.INTERNAL_SERVER_ERROR);
  }

  private ProblemDetail buildProblemDetail(final HttpStatus status) {
    return buildProblemDetail(status, status.getReasonPhrase());
  }

  private ProblemDetail buildProblemDetail(final HttpStatus status, final String detail) {
    final ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(status, detail.replaceAll("\\s+", " "));

    // Adds errors fields on validation errors, following RFC 9457 best practices.
//    if (!CollectionUtils.isEmpty(errors)) {
//      problemDetail.setProperty("errors", errors);
//    }
    return problemDetail;
  }
}
