/*
 * Copyright 2016 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

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
  void testConstructor() {
    assertEquals(REASON, ERROR.getReason());
    assertEquals(LOCATION, ERROR.getLocation());
    assertEquals(DEBUG_INFO, ERROR.getDebugInfo());
    assertEquals(MESSAGE, ERROR.getMessage());
    assertEquals(REASON, ERROR_INCOMPLETE.getReason());
    assertEquals(LOCATION, ERROR_INCOMPLETE.getLocation());
    assertEquals(null, ERROR_INCOMPLETE.getDebugInfo());
    assertEquals(MESSAGE, ERROR_INCOMPLETE.getMessage());
  }

  @Test
  void testToAndFromPb() {
    compareBigQueryError(ERROR, BigQueryError.fromPb(ERROR.toPb()));
    compareBigQueryError(ERROR_INCOMPLETE, BigQueryError.fromPb(ERROR_INCOMPLETE.toPb()));
  }

  private void compareBigQueryError(BigQueryError expected, BigQueryError value) {
    assertEquals(expected, value);
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
    assertEquals(expected.getReason(), value.getReason());
    assertEquals(expected.getLocation(), value.getLocation());
    assertEquals(expected.getDebugInfo(), value.getDebugInfo());
    assertEquals(expected.getMessage(), value.getMessage());
  }
}
