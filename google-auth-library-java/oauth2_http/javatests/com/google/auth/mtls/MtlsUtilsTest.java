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

import com.google.auth.http.HttpTransportFactory;
import com.google.auth.oauth2.EnvironmentProvider;
import com.google.auth.oauth2.OAuth2Utils;
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

  // If client certificate usage is explicitly disabled, canBeEnabled should return false.
  @Test
  void canBeEnabled_allowanceExplicitFalse_returnsFalse() throws IOException {
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

    assertFalse(MtlsUtils.canBeEnabled(envProvider, propProvider, null));
  }

  // If client certificate usage is explicitly enabled and a valid configuration is present,
  // canBeEnabled should return true.
  @Test
  void canBeEnabled_allowanceExplicitTrue_withConfig_returnsTrue() throws IOException {
    EnvironmentProvider envProvider =
        new EnvironmentProvider() {
          @Override
          public String getEnv(String name) {
            if ("GOOGLE_API_USE_CLIENT_CERTIFICATE".equals(name)) {
              return "true";
            }
            if ("GOOGLE_API_CERTIFICATE_CONFIG".equals(name)) {
              return "testresources/mtls/certificate_config.json";
            }
            return null;
          }
        };
    PropertyProvider propProvider = (name, def) -> def;

    assertTrue(MtlsUtils.canBeEnabled(envProvider, propProvider, null));
  }

  // If client certificate usage is unset but a valid configuration is present, mTLS should be
  // enabled by default (returns true).
  @Test
  void canBeEnabled_allowanceUnset_withConfig_returnsTrue() throws IOException {
    EnvironmentProvider envProvider =
        new EnvironmentProvider() {
          @Override
          public String getEnv(String name) {
            if ("GOOGLE_API_CERTIFICATE_CONFIG".equals(name)) {
              return "testresources/mtls/certificate_config.json";
            }
            return null;
          }
        };
    PropertyProvider propProvider = (name, def) -> def;

    assertTrue(MtlsUtils.canBeEnabled(envProvider, propProvider, null));
  }

  // If the GOOGLE_API_CERTIFICATE_CONFIG environment variable points to a non-existent file,
  // canBeEnabled should throw an IOException.
  @Test
  void canBeEnabled_envVarConfigMissingFile_throwsIOException() throws IOException {
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

    assertThrows(IOException.class, () -> MtlsUtils.canBeEnabled(envProvider, propProvider, null));
  }

  // If the well-known gcloud certificate configuration file exists, canBeEnabled should return
  // true.
  @Test
  void canBeEnabled_wellKnownConfigExists_returnsTrue() throws IOException {
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

    assertTrue(MtlsUtils.canBeEnabled(envProvider, propProvider, null));
  }

  @Test
  void canBeEnabled_alwaysPolicy_clientCertDisabled_throwsException() {
    EnvironmentProvider envProvider =
        name -> {
          if ("GOOGLE_API_USE_CLIENT_CERTIFICATE".equals(name)) {
            return "false";
          }
          if ("GOOGLE_API_USE_MTLS_ENDPOINT".equals(name)) {
            return "always";
          }
          return null;
        };
    PropertyProvider propProvider = (name, def) -> def;

    assertThrows(
        CertificateSourceUnavailableException.class,
        () -> MtlsUtils.canBeEnabled(envProvider, propProvider, null));
  }

  @Test
  void getMtlsEndpointUsagePolicy_never() {
    EnvironmentProvider envProvider =
        name -> "GOOGLE_API_USE_MTLS_ENDPOINT".equals(name) ? "never" : null;
    assertEquals(
        MtlsUtils.MtlsEndpointUsagePolicy.NEVER, MtlsUtils.getMtlsEndpointUsagePolicy(envProvider));
  }

  @Test
  void getMtlsEndpointUsagePolicy_always() {
    EnvironmentProvider envProvider =
        name -> "GOOGLE_API_USE_MTLS_ENDPOINT".equals(name) ? "always" : null;
    assertEquals(
        MtlsUtils.MtlsEndpointUsagePolicy.ALWAYS,
        MtlsUtils.getMtlsEndpointUsagePolicy(envProvider));
  }

  @Test
  void getMtlsEndpointUsagePolicy_auto() {
    EnvironmentProvider envProvider = name -> null;
    assertEquals(
        MtlsUtils.MtlsEndpointUsagePolicy.AUTO, MtlsUtils.getMtlsEndpointUsagePolicy(envProvider));
  }

  @Test
  void canBeEnabled_policyNever_returnsFalse() throws IOException {
    EnvironmentProvider envProvider =
        new EnvironmentProvider() {
          @Override
          public String getEnv(String name) {
            if ("GOOGLE_API_CERTIFICATE_CONFIG".equals(name)) {
              return "testresources/mtls/certificate_config.json";
            }
            if ("GOOGLE_API_USE_MTLS_ENDPOINT".equals(name)) {
              return "never";
            }
            return null;
          }
        };
    PropertyProvider propProvider = (name, def) -> def;

    assertFalse(MtlsUtils.canBeEnabled(envProvider, propProvider, null));
  }

  @Test
  void canBeEnabled_autoPolicy_noConfig_returnsFalse() throws IOException {
    EnvironmentProvider envProvider = name -> null;
    PropertyProvider propProvider =
        new PropertyProvider() {
          @Override
          public String getProperty(String name, String def) {
            if ("user.home".equals(name)) return tempDir.toString();
            return def;
          }
        };

    assertFalse(MtlsUtils.canBeEnabled(envProvider, propProvider, null));
  }

  @Test
  void canBeEnabled_alwaysPolicy_returnsTrue() throws IOException {
    EnvironmentProvider envProvider =
        name -> "GOOGLE_API_USE_MTLS_ENDPOINT".equals(name) ? "always" : null;
    PropertyProvider propProvider = (name, def) -> def;

    assertTrue(MtlsUtils.canBeEnabled(envProvider, propProvider, null));
  }

  @Test
  void getWorkloadCertificateConfiguration_malformedJson_throwsException() throws IOException {
    Path configFile = tempDir.resolve("malformed.json");
    Files.write(configFile, "{invalid-json}".getBytes());

    EnvironmentProvider envProvider = name -> null;
    PropertyProvider propProvider = (name, def) -> def;

    assertThrows(
        Exception.class,
        () ->
            MtlsUtils.getWorkloadCertificateConfiguration(
                envProvider, propProvider, configFile.toString()));
  }

  @Test
  void prepareTransportFactoryIfMtlsEnabled_nullInput_returnsNull() throws IOException {
    assertNull(
        MtlsUtils.prepareTransportFactoryIfMtlsEnabled(
            null, name -> null, (name, def) -> def, null));
  }

  @Test
  void prepareTransportFactoryIfMtlsEnabled_mtlsFactory_returnsAsIs()
      throws java.security.GeneralSecurityException, IOException {
    java.security.KeyStore dummyKeyStore =
        java.security.KeyStore.getInstance(java.security.KeyStore.getDefaultType());
    dummyKeyStore.load(null, null);
    MtlsHttpTransportFactory mtlsFactory = new MtlsHttpTransportFactory(dummyKeyStore);

    HttpTransportFactory result =
        MtlsUtils.prepareTransportFactoryIfMtlsEnabled(
            mtlsFactory, name -> null, (name, def) -> def, null);

    assertSame(mtlsFactory, result);
  }

  @Test
  void prepareTransportFactoryIfMtlsEnabled_customFactory_mtlsAlways_returnsAsIs()
      throws IOException {
    HttpTransportFactory customFactory = () -> null;
    EnvironmentProvider envProvider =
        name -> "GOOGLE_API_USE_MTLS_ENDPOINT".equals(name) ? "always" : null;
    PropertyProvider propProvider = (name, def) -> def;

    HttpTransportFactory result =
        MtlsUtils.prepareTransportFactoryIfMtlsEnabled(
            customFactory, envProvider, propProvider, null);

    assertSame(customFactory, result);
  }

  @Test
  void prepareTransportFactoryIfMtlsEnabled_customFactory_mtlsAuto_withConfig_returnsAsIs()
      throws IOException {
    HttpTransportFactory customFactory = () -> null;
    EnvironmentProvider envProvider =
        name ->
            "GOOGLE_API_CERTIFICATE_CONFIG".equals(name)
                ? "testresources/mtls/certificate_config.json"
                : null;
    PropertyProvider propProvider = (name, def) -> def;

    HttpTransportFactory result =
        MtlsUtils.prepareTransportFactoryIfMtlsEnabled(
            customFactory, envProvider, propProvider, null);

    assertSame(customFactory, result);
  }

  @Test
  void prepareTransportFactoryIfMtlsEnabled_defaultFactory_mtlsAlways_upgradesToMtlsFactory()
      throws IOException {
    EnvironmentProvider envProvider =
        new EnvironmentProvider() {
          @Override
          public String getEnv(String name) {
            if ("GOOGLE_API_USE_CLIENT_CERTIFICATE".equals(name)) {
              return "true";
            }
            if ("GOOGLE_API_USE_MTLS_ENDPOINT".equals(name)) {
              return "always";
            }
            if ("GOOGLE_API_CERTIFICATE_CONFIG".equals(name)) {
              return "testresources/mtls/certificate_config.json";
            }
            return null;
          }
        };
    PropertyProvider propProvider = (name, def) -> def;

    HttpTransportFactory result =
        MtlsUtils.prepareTransportFactoryIfMtlsEnabled(
            OAuth2Utils.HTTP_TRANSPORT_FACTORY, envProvider, propProvider, null);

    assertTrue(result instanceof MtlsHttpTransportFactory);
  }

  @Test
  void prepareTransportFactoryIfMtlsEnabled_defaultFactory_mtlsAuto_noConfig_returnsAsIs()
      throws IOException {
    EnvironmentProvider envProvider = name -> null;
    PropertyProvider propProvider = (name, def) -> def;

    HttpTransportFactory result =
        MtlsUtils.prepareTransportFactoryIfMtlsEnabled(
            OAuth2Utils.HTTP_TRANSPORT_FACTORY, envProvider, propProvider, null);

    assertSame(OAuth2Utils.HTTP_TRANSPORT_FACTORY, result);
  }

  private String createJsonConfigString(Path certPath, Path keyPath) {
    return "{\"cert_configs\":{\"workload\":{\"cert_path\":\""
        + certPath.toString().replace("\\", "\\\\")
        + "\",\"key_path\":\""
        + keyPath.toString().replace("\\", "\\\\")
        + "\"}}}";
  }
}
