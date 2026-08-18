/*
 * Copyright 2026, Google Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 *    * Neither the name of Google Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.google.auth.mtls;

import static org.junit.jupiter.api.Assertions.*;

import com.google.auth.oauth2.EnvironmentProvider;
import com.google.auth.oauth2.PropertyProvider;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class MtlsUtilsTest {

  @TempDir Path tempDir;

  @Test
  void getCertificatePath_succeeds() throws IOException {
    Path configFile = tempDir.resolve("config.json");
    Files.write(
        configFile,
        "{\"cert_configs\":{\"workload\":{\"cert_path\":\"cert.pem\",\"key_path\":\"key.pem\"}}}"
            .getBytes());

    EnvironmentProvider envProvider =
        new EnvironmentProvider() {
          @Override
          public String getEnv(String name) {
            return null;
          }
        };
    PropertyProvider propProvider =
        new PropertyProvider() {
          @Override
          public String getProperty(String name, String def) {
            return def;
          }
        };

    String certPath =
        MtlsUtils.getCertificatePath(envProvider, propProvider, configFile.toString());

    assertEquals("cert.pem", certPath);
  }

  @Test
  void getCertificatePath_missingCertPath_throws() throws IOException {
    Path configFile = tempDir.resolve("config.json");
    Files.write(
        configFile, "{\"cert_configs\":{\"workload\":{\"key_path\":\"key.pem\"}}}".getBytes());

    EnvironmentProvider envProvider =
        new EnvironmentProvider() {
          @Override
          public String getEnv(String name) {
            return null;
          }
        };
    PropertyProvider propProvider =
        new PropertyProvider() {
          @Override
          public String getProperty(String name, String def) {
            return def;
          }
        };

    assertThrows(
        IllegalArgumentException.class,
        () -> MtlsUtils.getCertificatePath(envProvider, propProvider, configFile.toString()));
  }

  @Test
  void getWorkloadCertificateConfiguration_overridePath() throws IOException {
    Path configFile = tempDir.resolve("custom_config.json");
    Files.write(
        configFile,
        "{\"cert_configs\":{\"workload\":{\"cert_path\":\"cert.pem\",\"key_path\":\"key.pem\"}}}"
            .getBytes());

    EnvironmentProvider envProvider =
        new EnvironmentProvider() {
          @Override
          public String getEnv(String name) {
            return null;
          }
        };
    PropertyProvider propProvider =
        new PropertyProvider() {
          @Override
          public String getProperty(String name, String def) {
            return def;
          }
        };

    WorkloadCertificateConfiguration config =
        MtlsUtils.getWorkloadCertificateConfiguration(
            envProvider, propProvider, configFile.toString());

    assertNotNull(config);
    assertEquals("cert.pem", config.getCertPath());
    assertEquals("key.pem", config.getPrivateKeyPath());
  }

  @Test
  void getWorkloadCertificateConfiguration_envVar() throws IOException {
    Path configFile = tempDir.resolve("env_config.json");
    Files.write(
        configFile,
        "{\"cert_configs\":{\"workload\":{\"cert_path\":\"cert.pem\",\"key_path\":\"key.pem\"}}}"
            .getBytes());

    EnvironmentProvider envProvider =
        new EnvironmentProvider() {
          @Override
          public String getEnv(String name) {
            return "GOOGLE_API_CERTIFICATE_CONFIG".equals(name) ? configFile.toString() : null;
          }
        };
    PropertyProvider propProvider =
        new PropertyProvider() {
          @Override
          public String getProperty(String name, String def) {
            return def;
          }
        };

    WorkloadCertificateConfiguration config =
        MtlsUtils.getWorkloadCertificateConfiguration(envProvider, propProvider, null);

    assertNotNull(config);
    assertEquals("cert.pem", config.getCertPath());
  }

  @Test
  void getWellKnownCertificateConfigFile_windows() throws IOException {
    EnvironmentProvider envProvider =
        new EnvironmentProvider() {
          @Override
          public String getEnv(String name) {
            return "APPDATA".equals(name) ? tempDir.toString() : null;
          }
        };
    PropertyProvider propProvider =
        new PropertyProvider() {
          @Override
          public String getProperty(String name, String def) {
            return "os.name".equals(name) ? "Windows 10" : def;
          }
        };

    CertificateSourceUnavailableException exception =
        assertThrows(
            CertificateSourceUnavailableException.class,
            () -> MtlsUtils.getWorkloadCertificateConfiguration(envProvider, propProvider, null));

    String expectedPath =
        new File(tempDir.toFile(), "gcloud/certificate_config.json").getAbsolutePath();
    assertTrue(exception.getMessage().contains(expectedPath));
  }

  @Test
  void getWellKnownCertificateConfigFile_linux() throws IOException {
    EnvironmentProvider envProvider =
        new EnvironmentProvider() {
          @Override
          public String getEnv(String name) {
            return null;
          }
        };
    PropertyProvider propProvider =
        new PropertyProvider() {
          @Override
          public String getProperty(String name, String def) {
            if ("os.name".equals(name)) return "Linux";
            if ("user.home".equals(name)) return tempDir.toString();
            return def;
          }
        };

    CertificateSourceUnavailableException exception =
        assertThrows(
            CertificateSourceUnavailableException.class,
            () -> MtlsUtils.getWorkloadCertificateConfiguration(envProvider, propProvider, null));

    String expectedPath =
        new File(tempDir.toFile(), ".config/gcloud/certificate_config.json").getAbsolutePath();
    assertTrue(exception.getMessage().contains(expectedPath));
  }

  @Test
  void getWellKnownCertificateConfigFile_windows_missingAppData_throws() {
    EnvironmentProvider envProvider =
        new EnvironmentProvider() {
          @Override
          public String getEnv(String name) {
            return null;
          }
        };
    PropertyProvider propProvider =
        new PropertyProvider() {
          @Override
          public String getProperty(String name, String def) {
            return "os.name".equals(name) ? "Windows 10" : def;
          }
        };

    CertificateSourceUnavailableException exception =
        assertThrows(
            CertificateSourceUnavailableException.class,
            () -> MtlsUtils.getWorkloadCertificateConfiguration(envProvider, propProvider, null));

    assertEquals("APPDATA environment variable is not set on Windows.", exception.getMessage());
  }

  @Test
  void useMtlsClientCertificate_trueWithNoCertsOnDisk_returnsFalseWithoutThrowing() {
    EnvironmentProvider envProvider =
        name -> "GOOGLE_API_USE_CLIENT_CERTIFICATE".equals(name) ? "true" : null;
    PropertyProvider propProvider = (name, def) -> def;

    assertFalse(MtlsUtils.useMtlsClientCertificate(envProvider, propProvider));
    assertNull(MtlsUtils.getWorkloadCertPath(envProvider, propProvider));
  }

  @Test
  void useMtlsClientCertificate_false_returnsFalse() {
    EnvironmentProvider envProvider =
        name -> "GOOGLE_API_USE_CLIENT_CERTIFICATE".equals(name) ? "false" : null;
    PropertyProvider propProvider = (name, def) -> def;

    assertFalse(MtlsUtils.useMtlsClientCertificate(envProvider, propProvider));
    assertNull(MtlsUtils.getWorkloadCertPath(envProvider, propProvider));
  }

  // --- Explicit GOOGLE_API_CERTIFICATE_CONFIG Tests (Fail Closed) ---

  @Test
  void getWorkloadCertPath_explicitConfigMissing_throwsIllegalStateException() {
    EnvironmentProvider envProvider =
        name -> "GOOGLE_API_CERTIFICATE_CONFIG".equals(name) ? "/nonexistent/config.json" : null;
    PropertyProvider propProvider = (name, def) -> def;

    IllegalStateException exception =
        assertThrows(
            IllegalStateException.class,
            () -> MtlsUtils.getWorkloadCertPath(envProvider, propProvider));
    assertTrue(
        exception
            .getMessage()
            .contains(
                "specified via GOOGLE_API_CERTIFICATE_CONFIG at '/nonexistent/config.json' does not"
                    + " exist"));
  }

  @Test
  void getWorkloadCertPath_explicitConfigIsDirectory_throwsIllegalStateException()
      throws IOException {
    Path configDir = tempDir.resolve("config_dir");
    Files.createDirectory(configDir);

    EnvironmentProvider envProvider =
        name -> "GOOGLE_API_CERTIFICATE_CONFIG".equals(name) ? configDir.toString() : null;
    PropertyProvider propProvider = (name, def) -> def;

    IllegalStateException exception =
        assertThrows(
            IllegalStateException.class,
            () -> MtlsUtils.getWorkloadCertPath(envProvider, propProvider));
    assertTrue(
        exception
            .getMessage()
            .contains(
                "Failed to read certificate configuration file specified via"
                    + " GOOGLE_API_CERTIFICATE_CONFIG"));
  }

  @Test
  void getWorkloadCertPath_explicitConfigUnreadable_throwsIllegalStateException()
      throws IOException {
    Path configFile = tempDir.resolve("unreadable_config.json");
    Files.write(configFile, "{}".getBytes());
    File file = configFile.toFile();
    if (file.setReadable(false)) {
      try {
        EnvironmentProvider envProvider =
            name -> "GOOGLE_API_CERTIFICATE_CONFIG".equals(name) ? configFile.toString() : null;
        PropertyProvider propProvider = (name, def) -> def;

        IllegalStateException exception =
            assertThrows(
                IllegalStateException.class,
                () -> MtlsUtils.getWorkloadCertPath(envProvider, propProvider));
        assertTrue(
            exception
                .getMessage()
                .contains(
                    "Failed to read certificate configuration file specified via"
                        + " GOOGLE_API_CERTIFICATE_CONFIG"));
      } finally {
        file.setReadable(true);
      }
    }
  }

  @Test
  void getWorkloadCertPath_explicitConfigMalformedJson_throwsIllegalStateException()
      throws IOException {
    Path configFile = tempDir.resolve("malformed.json");
    Files.write(configFile, "{ invalid json".getBytes());

    EnvironmentProvider envProvider =
        name -> "GOOGLE_API_CERTIFICATE_CONFIG".equals(name) ? configFile.toString() : null;
    PropertyProvider propProvider = (name, def) -> def;

    IllegalStateException exception =
        assertThrows(
            IllegalStateException.class,
            () -> MtlsUtils.getWorkloadCertPath(envProvider, propProvider));
    assertTrue(
        exception
            .getMessage()
            .contains(
                "specified via GOOGLE_API_CERTIFICATE_CONFIG at '"
                    + configFile.toString()
                    + "' is malformed"));
  }

  @Test
  void getWorkloadCertPath_explicitConfigOnlyEcp_returnsNullSafely() throws IOException {
    Path configFile = tempDir.resolve("ecp_config.json");
    Files.write(configFile, "{\"cert_configs\":{\"enterprise_certificates\":{}}}".getBytes());

    EnvironmentProvider envProvider =
        name -> "GOOGLE_API_CERTIFICATE_CONFIG".equals(name) ? configFile.toString() : null;
    PropertyProvider propProvider = (name, def) -> def;

    assertNull(MtlsUtils.getWorkloadCertPath(envProvider, propProvider));
  }

  @Test
  void getWorkloadCertPath_explicitConfigCertFileMissing_throwsIllegalStateException()
      throws IOException {
    Path keyFile = tempDir.resolve("key.pem");
    Files.write(keyFile, "dummy key".getBytes());

    Path configFile = tempDir.resolve("config.json");
    String configJson =
        String.format(
            "{\"cert_configs\":{\"workload\":{\"cert_path\":\"/nonexistent/cert.pem\",\"key_path\":\"%s\"}}}",
            keyFile.toString().replace("\\", "\\\\"));
    Files.write(configFile, configJson.getBytes());

    EnvironmentProvider envProvider =
        name -> "GOOGLE_API_CERTIFICATE_CONFIG".equals(name) ? configFile.toString() : null;
    PropertyProvider propProvider = (name, def) -> def;

    IllegalStateException exception =
        assertThrows(
            IllegalStateException.class,
            () -> MtlsUtils.getWorkloadCertPath(envProvider, propProvider));
    assertTrue(exception.getMessage().contains("Failed to read certificate/key file"));
    assertTrue(
        exception
            .getMessage()
            .contains("referenced by configuration '" + configFile.toString() + "'"));
  }

  @Test
  void getWorkloadCertPath_explicitConfigCertFileIsDirectory_throwsIllegalStateException()
      throws IOException {
    Path certDir = tempDir.resolve("cert_dir");
    Files.createDirectory(certDir);
    Path keyFile = tempDir.resolve("key.pem");
    Files.write(keyFile, "dummy key".getBytes());

    Path configFile = tempDir.resolve("config.json");
    String configJson =
        String.format(
            "{\"cert_configs\":{\"workload\":{\"cert_path\":\"%s\",\"key_path\":\"%s\"}}}",
            certDir.toString().replace("\\", "\\\\"), keyFile.toString().replace("\\", "\\\\"));
    Files.write(configFile, configJson.getBytes());

    EnvironmentProvider envProvider =
        name -> "GOOGLE_API_CERTIFICATE_CONFIG".equals(name) ? configFile.toString() : null;
    PropertyProvider propProvider = (name, def) -> def;

    IllegalStateException exception =
        assertThrows(
            IllegalStateException.class,
            () -> MtlsUtils.getWorkloadCertPath(envProvider, propProvider));
    assertTrue(exception.getMessage().contains("Failed to read certificate/key file"));
  }

  @Test
  void getWorkloadCertPath_explicitConfigKeyFileMissing_throwsIllegalStateException()
      throws IOException {
    Path certFile = tempDir.resolve("cert.pem");
    Files.write(certFile, "dummy cert".getBytes());

    Path configFile = tempDir.resolve("config.json");
    String configJson =
        String.format(
            "{\"cert_configs\":{\"workload\":{\"cert_path\":\"%s\",\"key_path\":\"/nonexistent/key.pem\"}}}",
            certFile.toString().replace("\\", "\\\\"));
    Files.write(configFile, configJson.getBytes());

    EnvironmentProvider envProvider =
        name -> "GOOGLE_API_CERTIFICATE_CONFIG".equals(name) ? configFile.toString() : null;
    PropertyProvider propProvider = (name, def) -> def;

    IllegalStateException exception =
        assertThrows(
            IllegalStateException.class,
            () -> MtlsUtils.getWorkloadCertPath(envProvider, propProvider));
    assertTrue(exception.getMessage().contains("Failed to read certificate/key file"));
    assertTrue(
        exception
            .getMessage()
            .contains("referenced by configuration '" + configFile.toString() + "'"));
  }

  @Test
  void getWorkloadCertPath_explicitConfigValid_returnsCertPath() throws IOException {
    Path certFile = tempDir.resolve("cert.pem");
    Path keyFile = tempDir.resolve("key.pem");
    Files.write(certFile, "dummy cert".getBytes());
    Files.write(keyFile, "dummy key".getBytes());

    Path configFile = tempDir.resolve("config.json");
    String configJson =
        String.format(
            "{\"cert_configs\":{\"workload\":{\"cert_path\":\"%s\",\"key_path\":\"%s\"}}}",
            certFile.toString().replace("\\", "\\\\"), keyFile.toString().replace("\\", "\\\\"));
    Files.write(configFile, configJson.getBytes());

    EnvironmentProvider envProvider =
        name -> "GOOGLE_API_CERTIFICATE_CONFIG".equals(name) ? configFile.toString() : null;
    PropertyProvider propProvider = (name, def) -> def;

    assertTrue(MtlsUtils.useMtlsClientCertificate(envProvider, propProvider));
    assertEquals(certFile.toString(), MtlsUtils.getWorkloadCertPath(envProvider, propProvider));
  }

  // --- Implicit / Default gcloud Config Tests ---

  @Test
  void getWorkloadCertPath_defaultConfigMissing_returnsNullSafely() {
    EnvironmentProvider envProvider = name -> null;
    PropertyProvider propProvider =
        (name, def) -> {
          if ("user.home".equals(name)) return tempDir.toString();
          if ("os.name".equals(name)) return "Linux";
          return def;
        };

    assertNull(MtlsUtils.getWorkloadCertPath(envProvider, propProvider));
  }

  @Test
  void getWorkloadCertPath_defaultConfigIsDirectory_throwsIllegalStateException()
      throws IOException {
    Path gcloudDir = tempDir.resolve(".config/gcloud");
    Files.createDirectories(gcloudDir);
    Path defaultConfigFile = gcloudDir.resolve("certificate_config.json");
    Files.createDirectory(defaultConfigFile);

    EnvironmentProvider envProvider = name -> null;
    PropertyProvider propProvider =
        (name, def) -> {
          if ("user.home".equals(name)) return tempDir.toString();
          if ("os.name".equals(name)) return "Linux";
          return def;
        };

    IllegalStateException exception =
        assertThrows(
            IllegalStateException.class,
            () -> MtlsUtils.getWorkloadCertPath(envProvider, propProvider));
    assertTrue(
        exception
            .getMessage()
            .contains(
                "Default certificate configuration file at '"
                    + defaultConfigFile.toFile().getAbsolutePath()
                    + "' exists but could not be read"));
  }

  @Test
  void getWorkloadCertPath_defaultConfigMalformedJson_throwsIllegalStateException()
      throws IOException {
    Path gcloudDir = tempDir.resolve(".config/gcloud");
    Files.createDirectories(gcloudDir);
    Path defaultConfigFile = gcloudDir.resolve("certificate_config.json");
    Files.write(defaultConfigFile, "{ malformed json".getBytes());

    EnvironmentProvider envProvider = name -> null;
    PropertyProvider propProvider =
        (name, def) -> {
          if ("user.home".equals(name)) return tempDir.toString();
          if ("os.name".equals(name)) return "Linux";
          return def;
        };

    IllegalStateException exception =
        assertThrows(
            IllegalStateException.class,
            () -> MtlsUtils.getWorkloadCertPath(envProvider, propProvider));
    assertTrue(
        exception
            .getMessage()
            .contains(
                "Default certificate configuration file at '"
                    + defaultConfigFile.toFile().getAbsolutePath()
                    + "' is malformed"));
  }

  @Test
  void getWorkloadCertPath_defaultConfigOnlyEcp_returnsNullSafely() throws IOException {
    Path gcloudDir = tempDir.resolve(".config/gcloud");
    Files.createDirectories(gcloudDir);
    Path defaultConfigFile = gcloudDir.resolve("certificate_config.json");
    Files.write(
        defaultConfigFile,
        "{\"cert_configs\":{\"enterprise_certificates\":{\"libs\":[]}}}".getBytes());

    EnvironmentProvider envProvider = name -> null;
    PropertyProvider propProvider =
        (name, def) -> {
          if ("user.home".equals(name)) return tempDir.toString();
          if ("os.name".equals(name)) return "Linux";
          return def;
        };

    assertNull(MtlsUtils.getWorkloadCertPath(envProvider, propProvider));
  }

  @Test
  void getWorkloadCertPath_defaultConfigCertFileMissing_throwsIllegalStateException()
      throws IOException {
    Path keyFile = tempDir.resolve("key.pem");
    Files.write(keyFile, "dummy key".getBytes());

    Path gcloudDir = tempDir.resolve(".config/gcloud");
    Files.createDirectories(gcloudDir);
    Path defaultConfigFile = gcloudDir.resolve("certificate_config.json");
    String configJson =
        String.format(
            "{\"cert_configs\":{\"workload\":{\"cert_path\":\"/nonexistent/cert.pem\",\"key_path\":\"%s\"}}}",
            keyFile.toString().replace("\\", "\\\\"));
    Files.write(defaultConfigFile, configJson.getBytes());

    EnvironmentProvider envProvider = name -> null;
    PropertyProvider propProvider =
        (name, def) -> {
          if ("user.home".equals(name)) return tempDir.toString();
          if ("os.name".equals(name)) return "Linux";
          return def;
        };

    IllegalStateException exception =
        assertThrows(
            IllegalStateException.class,
            () -> MtlsUtils.getWorkloadCertPath(envProvider, propProvider));
    assertTrue(exception.getMessage().contains("Failed to read certificate/key file"));
    assertTrue(
        exception
            .getMessage()
            .contains(
                "referenced by default configuration '"
                    + defaultConfigFile.toFile().getAbsolutePath()
                    + "'"));
  }

  @Test
  void getWorkloadCertPath_defaultConfigValid_returnsCertPath() throws IOException {
    Path certFile = tempDir.resolve("cert.pem");
    Path keyFile = tempDir.resolve("key.pem");
    Files.write(certFile, "dummy cert".getBytes());
    Files.write(keyFile, "dummy key".getBytes());

    Path gcloudDir = tempDir.resolve(".config/gcloud");
    Files.createDirectories(gcloudDir);
    Path defaultConfigFile = gcloudDir.resolve("certificate_config.json");
    String configJson =
        String.format(
            "{\"cert_configs\":{\"workload\":{\"cert_path\":\"%s\",\"key_path\":\"%s\"}}}",
            certFile.toString().replace("\\", "\\\\"), keyFile.toString().replace("\\", "\\\\"));
    Files.write(defaultConfigFile, configJson.getBytes());

    EnvironmentProvider envProvider = name -> null;
    PropertyProvider propProvider =
        (name, def) -> {
          if ("user.home".equals(name)) return tempDir.toString();
          if ("os.name".equals(name)) return "Linux";
          return def;
        };

    assertTrue(MtlsUtils.useMtlsClientCertificate(envProvider, propProvider));
    assertEquals(certFile.toString(), MtlsUtils.getWorkloadCertPath(envProvider, propProvider));
  }

  // --- General Helpers & Stubs Tests ---

  @Test
  void getCertificateFingerprint_validFile_returnsSha256() throws IOException {
    Path file = tempDir.resolve("test.crt");
    Files.write(file, "hello world".getBytes());

    String fingerprint = MtlsUtils.getCertificateFingerprint(file.toString());
    assertNotNull(fingerprint);
    assertEquals(64, fingerprint.length()); // SHA-256 hex string length
  }

  @Test
  void getCertificateFingerprint_invalidOrNull_returnsNull() {
    assertNull(MtlsUtils.getCertificateFingerprint(null));
    assertNull(MtlsUtils.getCertificateFingerprint("/nonexistent/file.crt"));
    assertNull(MtlsUtils.getCertificateFingerprint(tempDir.toString())); // Directory
  }

  @Test
  void getGkeWorkloadCertPath_returnsNull() {
    assertNull(MtlsUtils.getGkeWorkloadCertPath());
  }

  @Test
  void getGceWorkloadCertPath_returnsNull() {
    assertNull(MtlsUtils.getGceWorkloadCertPath());
  }
}
