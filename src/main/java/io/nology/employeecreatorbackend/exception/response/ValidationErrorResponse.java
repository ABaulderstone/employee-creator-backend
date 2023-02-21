package io.nology.employeecreatorbackend.exception.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidationErrorResponse {

  private Map<String, List<String>> errors;

  public ValidationErrorResponse() {
    this.errors = new HashMap<>();
  }

  public Map<String, List<String>> getErrors() {
    return errors;
  }

  public void addError(String fieldName, String errorMessage) {
    List<String> fieldErrors = errors.getOrDefault(
      fieldName,
      new ArrayList<>()
    );
    fieldErrors.add(errorMessage);
    errors.put(fieldName, fieldErrors);
  }
}
