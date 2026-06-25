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
import java.util.concurrent.atomic.AtomicReference;

/** Utility class to load and parse the JDBC driver version from dependencies.properties. */
public final class BigQueryJdbcVersionUtility {

  private static final BigQueryJdbcCustomLogger LOG =
      new BigQueryJdbcCustomLogger(BigQueryJdbcVersionUtility.class.getName());

  private static final AtomicReference<String> parsedDriverVersion = new AtomicReference<>(null);
  private static final AtomicReference<Integer> parsedDriverMajorVersion =
      new AtomicReference<>(null);
  private static final AtomicReference<Integer> parsedDriverMinorVersion =
      new AtomicReference<>(null);

  private BigQueryJdbcVersionUtility() {
    // Utility class, static methods only.
  }

  /**
   * Gets the full driver version string.
   *
   * @return the driver version string, e.g., "1.0.0-SNAPSHOT"
   */
  public static String getDriverVersion() {
    ensureLoaded();
    return parsedDriverVersion.get();
  }

  /**
   * Gets the driver major version.
   *
   * @return the major version number
   */
  public static int getDriverMajorVersion() {
    ensureLoaded();
    return parsedDriverMajorVersion.get() != null ? parsedDriverMajorVersion.get() : 0;
  }

  /**
   * Gets the driver minor version.
   *
   * @return the minor version number
   */
  public static int getDriverMinorVersion() {
    ensureLoaded();
    return parsedDriverMinorVersion.get() != null ? parsedDriverMinorVersion.get() : 0;
  }

  private static synchronized void ensureLoaded() {
    if (parsedDriverVersion.get() != null) {
      return;
    }
    Properties props = new Properties();
    try (InputStream input =
        BigQueryJdbcVersionUtility.class.getResourceAsStream(
            "/com/google/cloud/bigquery/jdbc/dependencies.properties")) {
      if (input == null) {
        throw new IllegalStateException(
            "Could not find dependencies.properties. Driver version information is unavailable.");
      }
      props.load(input);
      String versionString = props.getProperty("version.jdbc");
      if (versionString == null || versionString.trim().isEmpty()) {
        throw new IllegalStateException(
            "The property version.jdbc not found or empty in dependencies.properties.");
      }
      parsedDriverVersion.compareAndSet(null, versionString.trim());
      String[] parts = versionString.split("\\.");
      if (parts.length < 2) {
        return;
      }
      parsedDriverMajorVersion.compareAndSet(null, Integer.parseInt(parts[0]));
      String minorPart = parts[1];
      String numericMinor = minorPart.replaceAll("[^0-9].*", "");
      if (!numericMinor.isEmpty()) {
        parsedDriverMinorVersion.compareAndSet(null, Integer.parseInt(numericMinor));
      }
    } catch (Exception e) {
      String errorMessage =
          "Error reading dependencies.properties. Driver version information is"
              + " unavailable. Error: "
              + e.getMessage();
      LOG.severe(errorMessage, e);
    }
  }
}
