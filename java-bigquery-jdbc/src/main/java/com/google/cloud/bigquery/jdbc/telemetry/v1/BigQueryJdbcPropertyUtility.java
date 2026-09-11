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

import com.google.api.core.InternalApi;
import com.google.cloud.bigquery.jdbc.BigQueryJdbcCustomLogger;

/**
 * Utility methods for parsing and validating JDBC connection properties in Telemetry package.
 *
 * <p>This is a subset of parse methods used in the telemetry package. Separated out to keep only
 * the essential methods.
 */
@InternalApi
public final class BigQueryJdbcPropertyUtility {
  public static final boolean DEFAULT_ENABLE_DIAGNOSTIC_TELEMETRY_VALUE = true;
  public static final long DEFAULT_TELEMETRY_UPLOAD_INTERVAL_VALUE = 300_000L;
  public static final int DEFAULT_TELEMETRY_BATCH_SIZE_VALUE = 5000;

  private static final BigQueryJdbcCustomLogger LOG =
      new BigQueryJdbcCustomLogger(BigQueryJdbcPropertyUtility.class.getName());

  private BigQueryJdbcPropertyUtility() {
    // Utility class, static methods only.
  }

  /**
   * Converts a String representation of an integer or boolean to a boolean value.
   *
   * @param value the string value to parse ("0", "1", "true", or "false")
   * @param propertyName the name of the property (for error messages)
   * @return true if 1/true, false if 0/false
   */
  static boolean convertStringToBoolean(String value, boolean defaultValue) {
    if (value == null) {
      return defaultValue;
    }

    int integerValue;

    try {
      if (value.equalsIgnoreCase("true")) {
        integerValue = 1;
      } else if (value.equalsIgnoreCase("false")) {
        integerValue = 0;
      } else {
        integerValue = Integer.parseInt(value);
      }
    } catch (NumberFormatException ex) {
      // Fail-safe: ignore invalid telemetry values to avoid disrupting JDBC operations.
      return defaultValue;
    }

    if (integerValue == 1) {
      return true;
    } else if (integerValue == 0) {
      return false;
    } else {
      return defaultValue;
    }
  }

  static long convertStringToLong(String value, long defaultValue) {
    if (value == null) {
      return defaultValue;
    }
    try {
      return Long.parseLong(value);
    } catch (NumberFormatException ignored) {
      // Fail-safe: ignore invalid telemetry values to avoid disrupting JDBC operations.
      return defaultValue;
    }
  }

  static int convertStringToInt(String value, int defaultValue) {
    if (value == null) {
      return defaultValue;
    }
    try {
      return Integer.parseInt(value);
    } catch (NumberFormatException ignored) {
      // Fail-safe: ignore invalid telemetry values to avoid disrupting JDBC operations.
      return defaultValue;
    }
  }
}
