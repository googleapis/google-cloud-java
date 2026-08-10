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
    EnvironmentProvider envProvider = name -> "GOOGLE_API_USE_CLIENT_CERTIFICATE".equals(name) ? "true" : null;
    PropertyProvider propProvider = (name, def) -> def;

    assertFalse(MtlsUtils.useMtlsClientCertificate(envProvider, propProvider));
    assertNull(MtlsUtils.getWorkloadCertPath(envProvider, propProvider));
  }

  @Test
  void useMtlsClientCertificate_false_returnsFalse() {
    EnvironmentProvider envProvider = name -> "GOOGLE_API_USE_CLIENT_CERTIFICATE".equals(name) ? "false" : null;
    PropertyProvider propProvider = (name, def) -> def;

    assertFalse(MtlsUtils.useMtlsClientCertificate(envProvider, propProvider));
    assertNull(MtlsUtils.getWorkloadCertPath(envProvider, propProvider));
  }

  @Test
  void getWorkloadCertPath_brokenConfigPath_throwsIllegalStateException() {
    EnvironmentProvider envProvider = name -> "GOOGLE_API_CERTIFICATE_CONFIG".equals(name) ? "/nonexistent/config.json" : null;
    PropertyProvider propProvider = (name, def) -> def;

    IllegalStateException exception =
        assertThrows(
            IllegalStateException.class,
            () -> MtlsUtils.getWorkloadCertPath(envProvider, propProvider));
    assertTrue(exception.getMessage().contains("Certificate config is configured but file does not exist"));
  }

  @Test
  void getWorkloadCertPath_configPointsToMissingCertFiles_throwsIllegalStateException() throws IOException {
    Path configFile = tempDir.resolve("config.json");
    Files.write(
        configFile,
        "{\"cert_configs\":{\"workload\":{\"cert_path\":\"/nonexistent/cert.pem\",\"key_path\":\"/nonexistent/key.pem\"}}}"
            .getBytes());

    EnvironmentProvider envProvider = name -> "GOOGLE_API_CERTIFICATE_CONFIG".equals(name) ? configFile.toString() : null;
    PropertyProvider propProvider = (name, def) -> def;

    IllegalStateException exception =
        assertThrows(
            IllegalStateException.class,
            () -> MtlsUtils.getWorkloadCertPath(envProvider, propProvider));
    assertTrue(exception.getMessage().contains("files that do not exist on disk"));
  }

  @Test
  void getWorkloadCertPath_validConfig_returnsCertPath() throws IOException {
    Path certFile = tempDir.resolve("cert.pem");
    Path keyFile = tempDir.resolve("key.pem");
    Files.write(certFile, "dummy cert".getBytes());
    Files.write(keyFile, "dummy key".getBytes());

    Path configFile = tempDir.resolve("config.json");
    String configJson = String.format(
        "{\"cert_configs\":{\"workload\":{\"cert_path\":\"%s\",\"key_path\":\"%s\"}}}",
        certFile.toString().replace("\\", "\\\\"),
        keyFile.toString().replace("\\", "\\\\"));
    Files.write(configFile, configJson.getBytes());

    EnvironmentProvider envProvider = name -> "GOOGLE_API_CERTIFICATE_CONFIG".equals(name) ? configFile.toString() : null;
    PropertyProvider propProvider = (name, def) -> def;

    assertTrue(MtlsUtils.useMtlsClientCertificate(envProvider, propProvider));
    assertEquals(certFile.toString(), MtlsUtils.getWorkloadCertPath(envProvider, propProvider));
  }

  @Test
  void getCertificateFingerprint_validFile_returnsSha256() throws IOException {
    Path file = tempDir.resolve("test.crt");
    Files.write(file, "hello world".getBytes());

    String fingerprint = MtlsUtils.getCertificateFingerprint(file.toString());
    assertNotNull(fingerprint);
    assertEquals(64, fingerprint.length()); // SHA-256 hex string length
  }
}
