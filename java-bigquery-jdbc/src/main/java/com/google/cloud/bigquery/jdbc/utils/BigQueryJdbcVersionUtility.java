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

package com.google.cloud.bigquery.jdbc.utils;

import com.google.cloud.bigquery.jdbc.BigQueryJdbcCustomLogger;
import java.io.InputStream;
import java.util.Properties;

/** Utility class to load and parse the JDBC driver version from dependencies.properties. */
public final class BigQueryJdbcVersionUtility {

  private static final BigQueryJdbcCustomLogger LOG =
      new BigQueryJdbcCustomLogger(BigQueryJdbcVersionUtility.class.getName());

  private static final String DRIVER_VERSION;
  private static final int DRIVER_MAJOR_VERSION;
  private static final int DRIVER_MINOR_VERSION;

  static {
    String version = "0.0.0";
    int major = 0;
    int minor = 0;
    try (InputStream input =
        BigQueryJdbcVersionUtility.class.getResourceAsStream(
            "/com/google/cloud/bigquery/jdbc/dependencies.properties")) {
      if (input == null) {
        throw new IllegalArgumentException(
            "Could not find dependencies.properties. Driver version information is unavailable.");
      }

      Properties props = new Properties();
      props.load(input);
      String versionString = props.getProperty("version.jdbc");
      if (versionString == null || versionString.trim().isEmpty()) {
        throw new IllegalArgumentException(
            "The property version.jdbc not found or empty in dependencies.properties.");
      }

      version = versionString.trim();
      String[] parts = version.split("\\.");
      if (parts.length < 2) {
        throw new IllegalArgumentException("Unexpected version format: " + versionString);
      }
      major = Integer.parseInt(parts[0]);
      String minorPart = parts[1];
      String numericMinor = minorPart.replaceAll("[^0-9].*", "");
      if (!numericMinor.isEmpty()) {
        minor = Integer.parseInt(numericMinor);
      }
    } catch (Exception e) {
      LOG.severe(
          "Error reading dependencies.properties. Driver version information is unavailable. Error: "
              + e.getMessage(),
          e);
    }
    DRIVER_VERSION = version;
    DRIVER_MAJOR_VERSION = major;
    DRIVER_MINOR_VERSION = minor;
  }

  private BigQueryJdbcVersionUtility() {
    // Utility class, static methods only.
  }

  public static String getDriverVersion() {
    return DRIVER_VERSION;
  }

  public static int getDriverMajorVersion() {
    return DRIVER_MAJOR_VERSION;
  }

  public static int getDriverMinorVersion() {
    return DRIVER_MINOR_VERSION;
  }
}
