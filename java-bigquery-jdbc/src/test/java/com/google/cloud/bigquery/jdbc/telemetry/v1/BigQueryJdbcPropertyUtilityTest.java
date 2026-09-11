/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc.telemetry.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BigQueryJdbcPropertyUtilityTest {

  @Test
  public void testConvertStringToBoolean_validValues() {
    assertTrue(BigQueryJdbcPropertyUtility.convertStringToBoolean("1", false));
    assertTrue(BigQueryJdbcPropertyUtility.convertStringToBoolean("true", false));
    assertTrue(BigQueryJdbcPropertyUtility.convertStringToBoolean("True", false));
    assertTrue(BigQueryJdbcPropertyUtility.convertStringToBoolean("TRUE", false));

    assertFalse(BigQueryJdbcPropertyUtility.convertStringToBoolean("0", true));
    assertFalse(BigQueryJdbcPropertyUtility.convertStringToBoolean("false", true));
    assertFalse(BigQueryJdbcPropertyUtility.convertStringToBoolean("False", true));
    assertFalse(BigQueryJdbcPropertyUtility.convertStringToBoolean("FALSE", true));
  }

  @Test
  public void testConvertStringToBoolean_invalidAndNullValues() {
    assertTrue(BigQueryJdbcPropertyUtility.convertStringToBoolean("2", true));
    assertFalse(BigQueryJdbcPropertyUtility.convertStringToBoolean("2", false));
    assertTrue(BigQueryJdbcPropertyUtility.convertStringToBoolean("-1", true));
    assertFalse(BigQueryJdbcPropertyUtility.convertStringToBoolean("-1", false));
    assertTrue(BigQueryJdbcPropertyUtility.convertStringToBoolean("invalid", true));
    assertFalse(BigQueryJdbcPropertyUtility.convertStringToBoolean("invalid", false));
    assertTrue(BigQueryJdbcPropertyUtility.convertStringToBoolean(null, true));
    assertFalse(BigQueryJdbcPropertyUtility.convertStringToBoolean(null, false));
  }

  @Test
  public void testConvertStringToLong_validAndInvalidValues() {
    assertEquals(12345L, BigQueryJdbcPropertyUtility.convertStringToLong("12345", 100L));
    assertEquals(100L, BigQueryJdbcPropertyUtility.convertStringToLong(null, 100L));
    assertEquals(100L, BigQueryJdbcPropertyUtility.convertStringToLong("not-a-number", 100L));
  }

  @Test
  public void testConvertStringToInt_validAndInvalidValues() {
    assertEquals(500, BigQueryJdbcPropertyUtility.convertStringToInt("500", 10));
    assertEquals(10, BigQueryJdbcPropertyUtility.convertStringToInt(null, 10));
    assertEquals(10, BigQueryJdbcPropertyUtility.convertStringToInt("not-a-number", 10));
  }
}
