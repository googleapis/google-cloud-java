/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc.telemetry.v1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Utility builder for constructing {@link DriverEnvironment} telemetry protos. */
final class DriverEnvironmentBuilder {
  private static final Logger logger = Logger.getLogger(DriverEnvironmentBuilder.class.getName());

  static final String DRIVER_NAME = "google-bigquery-jdbc";
  static final String CLIENT_LANGUAGE = "java";
  static final String DEFAULT_TELEMETRY_TAG_DIR = ".bigquery-jdbc";
  static final String DEFAULT_TELEMETRY_TAG_FILE = "telemetry-tag";
  static final String UNKNOWN = "unknown";
  static final String RESTRICTED = "restricted";
  static final String DEFAULT_VERSION = "0.0";

  private DriverEnvironmentBuilder() {}

  static DriverEnvironment build(String driverVersion) {
    return build(driverVersion, null);
  }

  static DriverEnvironment build(String driverVersion, Path customTelemetryTagPath) {
    return DriverEnvironment.newBuilder()
        .setDriverName(DRIVER_NAME)
        .setDriverVersion(sanitizeVersion(driverVersion))
        .setClientLanguage(CLIENT_LANGUAGE)
        .setClientLanguageVersion(getMajorJavaVersion())
        .setOsType(detectOsType())
        .setOsVersion(getMajorOsVersion())
        .setTelemetryTag(getOrCreateTelemetryTag(customTelemetryTagPath))
        .build();
  }

  static String sanitizeVersion(String version) {
    if (version == null || version.trim().isEmpty()) {
      return DEFAULT_VERSION;
    }
    String trimmed = version.trim();
    String[] parts = trimmed.split("\\.");
    if (parts.length >= 2) {
      return parts[0] + "." + parts[1];
    }
    return trimmed;
  }

  static String getMajorJavaVersion() {
    try {
      return getMajorJavaVersion(System.getProperty("java.version"));
    } catch (SecurityException e) {
      return RESTRICTED;
    }
  }

  static String getMajorJavaVersion(String versionProperty) {
    if (versionProperty == null || versionProperty.trim().isEmpty()) {
      return UNKNOWN;
    }
    String version = versionProperty.trim();
    if (version.startsWith("1.")) {
      // Legacy Java version format (e.g. 1.8.0_292 -> 8)
      String[] parts = version.split("\\.");
      if (parts.length >= 2) {
        return parts[1];
      }
    } else {
      // Modern Java version format (e.g. 11.0.12 -> 11 or 17.0.1 -> 17)
      int firstDot = version.indexOf('.');
      if (firstDot > 0) {
        return version.substring(0, firstDot);
      }
    }
    return version;
  }

  static DriverEnvironment.OsType detectOsType() {
    try {
      return detectOsType(System.getProperty("os.name"));
    } catch (SecurityException e) {
      return DriverEnvironment.OsType.OS_TYPE_UNSPECIFIED;
    }
  }

  static DriverEnvironment.OsType detectOsType(String osNameProperty) {
    if (osNameProperty == null || osNameProperty.trim().isEmpty()) {
      return DriverEnvironment.OsType.OS_TYPE_UNKNOWN;
    }
    String osName = osNameProperty.toLowerCase();
    if (osName.contains("win")) {
      return DriverEnvironment.OsType.OS_TYPE_WINDOWS;
    } else if (osName.contains("mac") || osName.contains("darwin")) {
      return DriverEnvironment.OsType.OS_TYPE_MACOS;
    } else if (osName.contains("nux") || osName.contains("nix")) {
      return DriverEnvironment.OsType.OS_TYPE_LINUX;
    } else if (osName.contains("solaris") || osName.contains("sunos")) {
      return DriverEnvironment.OsType.OS_TYPE_SOLARIS;
    } else if (osName.contains("freebsd")) {
      return DriverEnvironment.OsType.OS_TYPE_FREEBSD;
    } else if (osName.contains("openbsd")) {
      return DriverEnvironment.OsType.OS_TYPE_OPENBSD;
    } else if (osName.contains("netbsd")) {
      return DriverEnvironment.OsType.OS_TYPE_NETBSD;
    } else if (osName.contains("aix")) {
      return DriverEnvironment.OsType.OS_TYPE_AIX;
    }
    return DriverEnvironment.OsType.OS_TYPE_UNKNOWN;
  }

  static String getMajorOsVersion() {
    try {
      return getMajorOsVersion(System.getProperty("os.version"));
    } catch (SecurityException e) {
      return RESTRICTED;
    }
  }

  static String getMajorOsVersion(String osVersionProperty) {
    if (osVersionProperty == null || osVersionProperty.trim().isEmpty()) {
      return UNKNOWN;
    }
    String version = osVersionProperty.trim();
    int firstDot = version.indexOf('.');
    if (firstDot > 0) {
      return version.substring(0, firstDot);
    }
    return version;
  }

  static String getOrCreateTelemetryTag(Path customFilePath) {
    try {
      Path idFilePath = customFilePath;
      if (idFilePath == null) {
        String userHome = System.getProperty("user.home");
        if (userHome == null || userHome.trim().isEmpty()) {
          return UUID.randomUUID().toString();
        }
        idFilePath = Paths.get(userHome, DEFAULT_TELEMETRY_TAG_DIR, DEFAULT_TELEMETRY_TAG_FILE);
      }

      if (Files.exists(idFilePath)) {
        try {
          String content =
              new String(Files.readAllBytes(idFilePath), StandardCharsets.UTF_8).trim();
          // Validate existing content is a valid UUID
          UUID.fromString(content);
          return content;
        } catch (Exception e) {
          logger.log(
              Level.WARNING, "Failed to read or parse telemetry tag from file, regenerating", e);
        }
      }

      String newId = UUID.randomUUID().toString();
      try {
        if (idFilePath.getParent() != null) {
          Files.createDirectories(idFilePath.getParent());
        }
        Files.write(idFilePath, newId.getBytes(StandardCharsets.UTF_8));
      } catch (IOException e) {
        logger.log(Level.WARNING, "Failed to persist telemetry tag to file", e);
      }
      return newId;
    } catch (SecurityException e) {
      return UUID.randomUUID().toString();
    }
  }
}
