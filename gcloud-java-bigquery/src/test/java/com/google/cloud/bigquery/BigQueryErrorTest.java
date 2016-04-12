package com.google.cloud.bigquery;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BigQueryErrorTest {

  private static final String REASON = "reason";
  private static final String LOCATION = "location";
  private static final String DEBUG_INFO = "debugInfo";
  private static final String MESSAGE = "message";
  private static final BigQueryError ERROR =
      new BigQueryError(REASON, LOCATION, MESSAGE, DEBUG_INFO);
  private static final BigQueryError ERROR_INCOMPLETE =
      new BigQueryError(REASON, LOCATION, MESSAGE);

  @Test
  public void testConstructor() {
    assertEquals(REASON, ERROR.reason());
    assertEquals(LOCATION, ERROR.location());
    assertEquals(DEBUG_INFO, ERROR.debugInfo());
    assertEquals(MESSAGE, ERROR.message());
    assertEquals(REASON, ERROR_INCOMPLETE.reason());
    assertEquals(LOCATION, ERROR_INCOMPLETE.location());
    assertEquals(null, ERROR_INCOMPLETE.debugInfo());
    assertEquals(MESSAGE, ERROR_INCOMPLETE.message());
  }

  @Test
  public void testToAndFromPb() {
    compareBigQueryError(ERROR, BigQueryError.fromPb(ERROR.toPb()));
    compareBigQueryError(ERROR_INCOMPLETE, BigQueryError.fromPb(ERROR_INCOMPLETE.toPb()));
  }

  private void compareBigQueryError(BigQueryError expected, BigQueryError value) {
    assertEquals(expected, value);
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
    assertEquals(expected.reason(), value.reason());
    assertEquals(expected.location(), value.location());
    assertEquals(expected.debugInfo(), value.debugInfo());
    assertEquals(expected.message(), value.message());
  }
}
