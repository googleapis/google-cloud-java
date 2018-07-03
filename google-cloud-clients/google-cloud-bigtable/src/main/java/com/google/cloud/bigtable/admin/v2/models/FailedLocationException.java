package com.google.cloud.bigtable.admin.v2.models;

import java.util.List;
import com.google.api.core.BetaApi;

@BetaApi
public class FailedLocationException extends RuntimeException {
  private static final long serialVersionUID = 1L;
  private final List<String> succeededLocations;
  private final List<String> failedLocations;

  public FailedLocationException(
      String message, List<String> succeededLocations, List<String> failedLocations) {
    super(message);
    this.succeededLocations = succeededLocations;
    this.failedLocations = failedLocations;
  }

  public List<String> getSucceededLocations() {
    return succeededLocations;
  }

  public List<String> getFailedLocations() {
    return failedLocations;
  }
}
