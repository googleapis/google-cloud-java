package com.google.cloud.model;

public enum ReportResult {
  PASS("Pass, package has no known vulnerabilities and non-compliant licenses."),
  FAIL("Fail, package has known vulnerabilities or non-compliant licenses.");

  private final String message;

  ReportResult(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return String.format("Analyze result: %s", message);
  }
}
