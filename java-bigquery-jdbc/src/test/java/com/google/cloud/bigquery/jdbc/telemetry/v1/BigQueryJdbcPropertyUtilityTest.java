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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BigQueryJdbcPropertyUtilityTest {

  @Test
  public void testConvertStringToBoolean_validValues() {
    assertTrue(TelemetryPropertyUtility.convertStringToBoolean("1", false));
    assertTrue(TelemetryPropertyUtility.convertStringToBoolean("true", false));
    assertTrue(TelemetryPropertyUtility.convertStringToBoolean("True", false));
    assertTrue(TelemetryPropertyUtility.convertStringToBoolean("TRUE", false));

    assertFalse(TelemetryPropertyUtility.convertStringToBoolean("0", true));
    assertFalse(TelemetryPropertyUtility.convertStringToBoolean("false", true));
    assertFalse(TelemetryPropertyUtility.convertStringToBoolean("False", true));
    assertFalse(TelemetryPropertyUtility.convertStringToBoolean("FALSE", true));
  }

  @Test
  public void testConvertStringToBoolean_invalidAndNullValues() {
    assertTrue(TelemetryPropertyUtility.convertStringToBoolean("2", true));
    assertFalse(TelemetryPropertyUtility.convertStringToBoolean("2", false));
    assertTrue(TelemetryPropertyUtility.convertStringToBoolean("-1", true));
    assertFalse(TelemetryPropertyUtility.convertStringToBoolean("-1", false));
    assertTrue(TelemetryPropertyUtility.convertStringToBoolean("invalid", true));
    assertFalse(TelemetryPropertyUtility.convertStringToBoolean("invalid", false));
    assertTrue(TelemetryPropertyUtility.convertStringToBoolean(null, true));
    assertFalse(TelemetryPropertyUtility.convertStringToBoolean(null, false));
  }
}
