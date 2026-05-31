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

  // If client certificate usage is explicitly disabled, canMtlsBeEnabled should return false.
  @Test
  void canMtlsBeEnabled_allowanceExplicitFalse_returnsFalse() throws IOException {
    EnvironmentProvider envProvider =
        new EnvironmentProvider() {
          @Override
          public String getEnv(String name) {
            if ("GOOGLE_API_USE_CLIENT_CERTIFICATE".equals(name)) {
              return "false";
            }
            return null;
          }
        };
    PropertyProvider propProvider = (name, def) -> def;
    
    assertFalse(MtlsUtils.canMtlsBeEnabled(envProvider, propProvider, null));
  }

  // If client certificate usage is explicitly enabled and a valid configuration is present, canMtlsBeEnabled should return true.
  @Test
  void canMtlsBeEnabled_allowanceExplicitTrue_withConfig_returnsTrue() throws IOException {
    Path configFile = tempDir.resolve("config.json");
    Path certFile = tempDir.resolve("cert.pem");
    Path keyFile = tempDir.resolve("key.pem");
    Files.createFile(certFile);
    Files.createFile(keyFile);
    Files.write(configFile, createJsonConfigString(certFile, keyFile).getBytes());

    EnvironmentProvider envProvider =
        new EnvironmentProvider() {
          @Override
          public String getEnv(String name) {
            if ("GOOGLE_API_USE_CLIENT_CERTIFICATE".equals(name)) {
              return "true";
            }
            if ("GOOGLE_API_CERTIFICATE_CONFIG".equals(name)) {
              return configFile.toString();
            }
            return null;
          }
        };
    PropertyProvider propProvider = (name, def) -> def;

    assertTrue(MtlsUtils.canMtlsBeEnabled(envProvider, propProvider, null));
  }

  // If client certificate usage is unset but a valid configuration is present, mTLS should be enabled by default (returns true).
  @Test
  void canMtlsBeEnabled_allowanceUnset_withConfig_returnsTrue() throws IOException {
    Path configFile = tempDir.resolve("config.json");
    Path certFile = tempDir.resolve("cert.pem");
    Path keyFile = tempDir.resolve("key.pem");
    Files.createFile(certFile);
    Files.createFile(keyFile);
    Files.write(configFile, createJsonConfigString(certFile, keyFile).getBytes());

    EnvironmentProvider envProvider =
        new EnvironmentProvider() {
          @Override
          public String getEnv(String name) {
            if ("GOOGLE_API_CERTIFICATE_CONFIG".equals(name)) {
              return configFile.toString();
            }
            return null;
          }
        };
    PropertyProvider propProvider = (name, def) -> def;

    assertTrue(MtlsUtils.canMtlsBeEnabled(envProvider, propProvider, null));
  }

  // If the GOOGLE_API_CERTIFICATE_CONFIG environment variable points to a non-existent file, canMtlsBeEnabled should throw an IOException.
  @Test
  void canMtlsBeEnabled_envVarConfigMissingFile_throwsIOException() throws IOException {
    Path nonExistentConfig = tempDir.resolve("non_existent.json");
    EnvironmentProvider envProvider =
        new EnvironmentProvider() {
          @Override
          public String getEnv(String name) {
            if ("GOOGLE_API_CERTIFICATE_CONFIG".equals(name)) {
              return nonExistentConfig.toString();
            }
            return null;
          }
        };
    PropertyProvider propProvider = (name, def) -> def;

    assertThrows(
        IOException.class,
        () -> MtlsUtils.canMtlsBeEnabled(envProvider, propProvider, null));
  }

  // If the well-known gcloud certificate configuration file exists, canMtlsBeEnabled should return true.
  @Test
  void canMtlsBeEnabled_wellKnownConfigExists_returnsTrue() throws IOException {
    Path gcloudDir = tempDir.resolve(".config/gcloud");
    Files.createDirectories(gcloudDir);
    Path configFile = gcloudDir.resolve("certificate_config.json");
    Path certFile = tempDir.resolve("cert.pem");
    Path keyFile = tempDir.resolve("key.pem");
    Files.createFile(certFile);
    Files.createFile(keyFile);
    Files.write(configFile, createJsonConfigString(certFile, keyFile).getBytes());

    EnvironmentProvider envProvider = name -> null;
    PropertyProvider propProvider =
        new PropertyProvider() {
          @Override
          public String getProperty(String name, String def) {
            if ("os.name".equals(name)) return "Linux";
            if ("user.home".equals(name)) return tempDir.toString();
            return def;
          }
        };

    assertTrue(MtlsUtils.canMtlsBeEnabled(envProvider, propProvider, null));
  }

  // If the configuration file exists but the certificate path it references does not exist, canMtlsBeEnabled should throw an IOException.
  @Test
  void canMtlsBeEnabled_configMissingCertFile_throwsIOException() throws IOException {
    Path configFile = tempDir.resolve("config.json");
    Path nonExistentCert = tempDir.resolve("non_existent_cert.pem");
    Path keyFile = tempDir.resolve("key.pem");
    Files.createFile(keyFile);
    Files.write(configFile, createJsonConfigString(nonExistentCert, keyFile).getBytes());

    EnvironmentProvider envProvider = name -> "GOOGLE_API_CERTIFICATE_CONFIG".equals(name) ? configFile.toString() : null;
    PropertyProvider propProvider = (name, def) -> def;

    assertThrows(
        IOException.class,
        () -> MtlsUtils.canMtlsBeEnabled(envProvider, propProvider, null));
  }

  // If the configuration file exists but the private key path it references does not exist, canMtlsBeEnabled should throw an IOException.
  @Test
  void canMtlsBeEnabled_configMissingKeyFile_throwsIOException() throws IOException {
    Path configFile = tempDir.resolve("config.json");
    Path certFile = tempDir.resolve("cert.pem");
    Path nonExistentKey = tempDir.resolve("non_existent_key.pem");
    Files.createFile(certFile);
    Files.write(configFile, createJsonConfigString(certFile, nonExistentKey).getBytes());

    EnvironmentProvider envProvider = name -> "GOOGLE_API_CERTIFICATE_CONFIG".equals(name) ? configFile.toString() : null;
    PropertyProvider propProvider = (name, def) -> def;

    assertThrows(
        IOException.class,
        () -> MtlsUtils.canMtlsBeEnabled(envProvider, propProvider, null));
  }

  // If no configuration file exists but a SPIFFE credential bundle file is present, canMtlsBeEnabled should return true.
  @Test
  void canMtlsBeEnabled_unset_spiffeBundlePresent_returnsTrue() throws IOException {
    Path spiffeDir = tempDir.resolve("spiffe_workload_bundle");
    Files.createDirectory(spiffeDir);
    Files.createFile(spiffeDir.resolve("credentialbundle.pem"));

    String originalSpiffeDir = MtlsUtils.spiffeDirectory;
    MtlsUtils.spiffeDirectory = spiffeDir.toString() + "/";
    try {
      EnvironmentProvider envProvider = name -> null;
      PropertyProvider propProvider = (name, def) -> def;

      assertTrue(MtlsUtils.canMtlsBeEnabled(envProvider, propProvider, null));
    } finally {
      MtlsUtils.spiffeDirectory = originalSpiffeDir;
    }
  }

  // If no configuration file exists but separate SPIFFE certificate and key files are present, canMtlsBeEnabled should return true.
  @Test
  void canMtlsBeEnabled_unset_spiffeCertsPresent_returnsTrue() throws IOException {
    Path spiffeDir = tempDir.resolve("spiffe_workload_certs");
    Files.createDirectory(spiffeDir);
    Files.createFile(spiffeDir.resolve("certificates.pem"));
    Files.createFile(spiffeDir.resolve("private_key.pem"));

    String originalSpiffeDir = MtlsUtils.spiffeDirectory;
    MtlsUtils.spiffeDirectory = spiffeDir.toString() + "/";
    try {
      EnvironmentProvider envProvider = name -> null;
      PropertyProvider propProvider = (name, def) -> def;

      assertTrue(MtlsUtils.canMtlsBeEnabled(envProvider, propProvider, null));
    } finally {
      MtlsUtils.spiffeDirectory = originalSpiffeDir;
    }
  }

  private String createJsonConfigString(Path certPath, Path keyPath) {
    return "{\"cert_configs\":{\"workload\":{\"cert_path\":\""
        + certPath.toString().replace("\\", "\\\\")
        + "\",\"key_path\":\""
        + keyPath.toString().replace("\\", "\\\\")
        + "\"}}}";
  }
}
