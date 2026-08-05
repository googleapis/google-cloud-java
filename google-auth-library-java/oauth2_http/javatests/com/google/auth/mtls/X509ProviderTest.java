/*
 * Copyright 2025, Google Inc. All rights reserved.
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.auth.oauth2.SystemPropertyProvider;
import com.google.auth.oauth2.TestEnvironmentProvider;
import com.google.auth.oauth2.TestPropertyProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class X509ProviderTest {

  @TempDir Path tempDir;

  private static final String TEST_CERT_PATH = "testresources/mtls/test_cert.pem";
  private static final String TEST_CONFIG_PATH = "testresources/mtls/certificate_config.json";

  @Test
  void x509Provider_fileDoesntExist_throws() {
    String certConfigPath = "badfile.txt";
    X509Provider testProvider = new X509Provider(certConfigPath);
    String expectedErrorMessage =
        "Certificate configuration file does not exist or is not a file: "
            + new File(certConfigPath).getAbsolutePath();
    CertificateSourceUnavailableException exception =
        assertThrows(CertificateSourceUnavailableException.class, testProvider::getKeyStore);
    assertEquals(expectedErrorMessage, exception.getMessage());
  }

  @Test
  void x509Provider_emptyFile_throws() throws IOException {
    Path emptyConfig = tempDir.resolve("emptyConfig.txt");
    Files.createFile(emptyConfig);

    X509Provider testProvider = new X509Provider(emptyConfig.toString());
    String expectedErrorMessage = "no JSON input found";

    IOException exception = assertThrows(IOException.class, testProvider::getKeyStore);
    assertNotNull(exception.getCause());
    assertTrue(exception.getCause() instanceof IllegalArgumentException);
    assertTrue(exception.getCause().getMessage().contains(expectedErrorMessage));
  }

  @Test
  void x509Provider_succeeds() throws IOException, KeyStoreException, CertificateException {
    X509Provider testProvider = new X509Provider(TEST_CONFIG_PATH);

    CertificateFactory cf = CertificateFactory.getInstance("X.509");
    Certificate expectedCert;
    try (FileInputStream fis = new FileInputStream(new File(TEST_CERT_PATH))) {
      expectedCert = cf.generateCertificate(fis);
    }

    // Assert that the store has the expected certificate and only the expected certificate.
    KeyStore store = testProvider.getKeyStore();
    assertEquals(1, store.size());
    assertNotNull(store.getCertificateAlias(expectedCert));
  }

  @Test
  void x509Provider_succeeds_withEnvVariable()
      throws IOException, KeyStoreException, CertificateException {
    TestEnvironmentProvider envProvider = new TestEnvironmentProvider();
    envProvider.setEnv("GOOGLE_API_CERTIFICATE_CONFIG", TEST_CONFIG_PATH);

    X509Provider testProvider =
        new X509Provider(envProvider, SystemPropertyProvider.getInstance(), null);

    CertificateFactory cf = CertificateFactory.getInstance("X.509");
    Certificate expectedCert;
    try (FileInputStream fis = new FileInputStream(new File(TEST_CERT_PATH))) {
      expectedCert = cf.generateCertificate(fis);
    }

    // Assert that the store has the expected certificate and only the expected certificate.
    KeyStore store = testProvider.getKeyStore();
    assertEquals(1, store.size());
    assertNotNull(store.getCertificateAlias(expectedCert));
  }

  @Test
  void x509Provider_succeeds_withWellKnownPath()
      throws IOException, KeyStoreException, CertificateException {
    TestEnvironmentProvider envProvider = new TestEnvironmentProvider();
    envProvider.setEnv("CLOUDSDK_CONFIG", "testresources/mtls/");

    X509Provider testProvider =
        new X509Provider(envProvider, SystemPropertyProvider.getInstance(), null);

    CertificateFactory cf = CertificateFactory.getInstance("X.509");
    Certificate expectedCert;
    try (FileInputStream fis = new FileInputStream(new File(TEST_CERT_PATH))) {
      expectedCert = cf.generateCertificate(fis);
    }

    // Assert that the store has the expected certificate and only the expected certificate.
    KeyStore store = testProvider.getKeyStore();
    assertEquals(1, store.size());
    assertNotNull(store.getCertificateAlias(expectedCert));
  }

  @Test
  void x509Provider_succeeds_withWindowsPath()
      throws IOException, KeyStoreException, CertificateException {
    Path windowsTempDir = tempDir.resolve("windowsTempDir");
    Files.createDirectory(windowsTempDir);
    Path gcloudDir = windowsTempDir.resolve("gcloud");
    Files.createDirectory(gcloudDir);
    Path configPath = gcloudDir.resolve("certificate_config.json");

    // Copy the valid config to this new temp location
    Files.copy(new File(TEST_CONFIG_PATH).toPath(), configPath);

    TestEnvironmentProvider envProvider = new TestEnvironmentProvider();
    envProvider.setEnv("APPDATA", windowsTempDir.toString());

    TestPropertyProvider propProvider = new TestPropertyProvider();
    propProvider.setProperty("os.name", "Windows 10");

    X509Provider testProvider = new X509Provider(envProvider, propProvider, null);

    CertificateFactory cf = CertificateFactory.getInstance("X.509");
    Certificate expectedCert;
    try (FileInputStream fis = new FileInputStream(new File(TEST_CERT_PATH))) {
      expectedCert = cf.generateCertificate(fis);
    }

    KeyStore store = testProvider.getKeyStore();
    assertEquals(1, store.size());
    assertNotNull(store.getCertificateAlias(expectedCert));
  }

  @Test
  void x509Provider_certFileDoesntExist_throws() throws IOException {
    Path tempConfig = tempDir.resolve("config_no_cert.json");
    Path nonExistentCert = tempDir.resolve("non_existent_cert.pem");

    Files.write(
        tempConfig,
        ("{\"cert_configs\":{\"workload\":{\"cert_path\":\""
                + nonExistentCert.toString()
                + "\",\"key_path\":\"key.pem\"}}}")
            .getBytes());

    X509Provider testProvider = new X509Provider(tempConfig.toString());

    assertThrows(IOException.class, testProvider::getKeyStore);
  }

  @Test
  void x509Provider_malformedCert_throws() throws IOException {
    Path tempConfig = tempDir.resolve("config_malformed_cert.json");
    Path malformedCert = tempDir.resolve("badcert.pem");

    Files.write(malformedCert, "This is not a valid certificate".getBytes());

    Files.write(
        tempConfig,
        ("{\"cert_configs\":{\"workload\":{\"cert_path\":\""
                + malformedCert.toString()
                + "\",\"key_path\":\"key.pem\"}}}")
            .getBytes());

    X509Provider testProvider = new X509Provider(tempConfig.toString());

    assertThrows(Exception.class, testProvider::getKeyStore);
  }

  @Test
  void x509Provider_missingCertConfigs_throws() throws IOException {
    Path tempConfig = tempDir.resolve("config_missing_configs.json");

    Files.write(tempConfig, "{}".getBytes());

    X509Provider testProvider = new X509Provider(tempConfig.toString());

    IOException exception = assertThrows(IOException.class, testProvider::getKeyStore);
    assertNotNull(exception.getCause());
    assertTrue(exception.getCause() instanceof IllegalArgumentException);
    assertTrue(
        exception.getCause().getMessage().contains("The cert_configs object must be provided"));
  }

  @Test
  void x509Provider_missingCertPath_throws() throws IOException {
    Path tempConfig = tempDir.resolve("config_missing_path.json");

    Files.write(
        tempConfig, "{\"cert_configs\":{\"workload\":{\"key_path\":\"key.pem\"}}}".getBytes());

    X509Provider testProvider = new X509Provider(tempConfig.toString());

    IOException exception = assertThrows(IOException.class, testProvider::getKeyStore);
    assertNotNull(exception.getCause());
    assertTrue(exception.getCause() instanceof IllegalArgumentException);
    assertTrue(exception.getCause().getMessage().contains("The cert_path field must be provided"));
  }

  // Failure Path: mTLS disabled (allowance = false) throws CertificateSourceUnavailableException
  @Test
  void x509Provider_allowanceDisabled_throws() throws Exception {
    X509Provider provider =
        new X509Provider(
            name -> "GOOGLE_API_USE_CLIENT_CERTIFICATE".equals(name) ? "false" : null,
            (name, def) -> def,
            null);
    assertThrows(CertificateSourceUnavailableException.class, provider::getKeyStore);
  }

  @Test
  void x509Provider_isAvailable_succeeds() throws IOException {
    X509Provider testProvider = new X509Provider(TEST_CONFIG_PATH);
    assertTrue(testProvider.isAvailable());
  }

  @Test
  void x509Provider_isAvailable_missingConfig_returnsFalse() throws IOException {
    X509Provider testProvider = new X509Provider("badfile.json");
    assertFalse(testProvider.isAvailable());
  }

  @Test
  void x509Provider_isAvailable_unaffectedByMtlsFlags() throws IOException {
    X509Provider provider =
        new X509Provider(
            name -> {
              if ("GOOGLE_API_USE_CLIENT_CERTIFICATE".equals(name)) {
                return "false";
              }
              if ("GOOGLE_API_USE_MTLS_ENDPOINT".equals(name)) {
                return "never";
              }
              return null;
            },
            (name, def) -> def,
            TEST_CONFIG_PATH);
    assertTrue(provider.isAvailable());
  }
}
