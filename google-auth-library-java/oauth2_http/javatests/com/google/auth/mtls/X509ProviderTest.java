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

import static java.nio.charset.StandardCharsets.UTF_8;
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
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class X509ProviderTest {

  private static final String TEST_CERT_PATH = "testresources/mtls/test_cert.pem";
  private static final String TEST_KEY_PATH = "testresources/mtls/test_key.pem";
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
    Path emptyConfig = Files.createTempFile("emptyConfig", ".txt");
    emptyConfig.toFile().deleteOnExit();

    X509Provider testProvider = new X509Provider(emptyConfig.toString());
    String expectedErrorMessage = "no JSON input found";

    IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class, testProvider::getKeyStore);
    assertTrue(exception.getMessage().contains(expectedErrorMessage));
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
    Path windowsTempDir = Files.createTempDirectory("windowsTempDir");
    windowsTempDir.toFile().deleteOnExit();
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
    Path tempConfig = Files.createTempFile("config", ".json");
    tempConfig.toFile().deleteOnExit();
    Path nonExistentCert = tempConfig.getParent().resolve("non_existent_cert.pem");

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
    Path tempConfig = Files.createTempFile("config", ".json");
    tempConfig.toFile().deleteOnExit();
    Path malformedCert = Files.createTempFile("badcert", ".pem");
    malformedCert.toFile().deleteOnExit();

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
  void x509Provider_noConfig_usesGkeCredentialBundle(@TempDir Path tempDir) throws Exception {
    Path bundle = writeGkeBundle(tempDir, /* keyFirst= */ false);
    MtlsUtils.setGkeCredentialBundlePathForTesting(bundle.toString());
    try {
      X509Provider testProvider =
          new X509Provider(new TestEnvironmentProvider(), noGcloudConfig(tempDir), null, true);

      KeyStore store = testProvider.getKeyStore();
      assertEquals(1, store.size());
      assertNotNull(store.getCertificateAlias(loadTestCert()));
      assertTrue(testProvider.isAvailable());
    } finally {
      MtlsUtils.setGkeCredentialBundlePathForTesting(null);
    }
  }

  @Test
  void x509Provider_noConfig_usesGkeCredentialBundleWithKeyFirst(@TempDir Path tempDir)
      throws Exception {
    Path bundle = writeGkeBundle(tempDir, /* keyFirst= */ true);
    MtlsUtils.setGkeCredentialBundlePathForTesting(bundle.toString());
    try {
      X509Provider testProvider =
          new X509Provider(new TestEnvironmentProvider(), noGcloudConfig(tempDir), null, true);

      KeyStore store = testProvider.getKeyStore();
      assertNotNull(store.getCertificateAlias(loadTestCert()));
    } finally {
      MtlsUtils.setGkeCredentialBundlePathForTesting(null);
    }
  }

  @Test
  void x509Provider_gkeCredentialBundleWithIntermediate_keepsFullChain(@TempDir Path tempDir)
      throws Exception {
    Path bundle =
        writeGkeBundle(
            tempDir,
            MtlsKeyStoreUtilsTest.CHAIN_CERT_PATH,
            MtlsKeyStoreUtilsTest.CHAIN_KEY_PATH,
            /* keyFirst= */ false);
    MtlsUtils.setGkeCredentialBundlePathForTesting(bundle.toString());
    try {
      X509Provider testProvider =
          new X509Provider(new TestEnvironmentProvider(), noGcloudConfig(tempDir), null, true);

      KeyStore store = testProvider.getKeyStore();
      // The intermediate is presented too, so peers that only trust the root can verify the leaf.
      MtlsKeyStoreUtilsTest.assertLeafThenIntermediate(store);
    } finally {
      MtlsUtils.setGkeCredentialBundlePathForTesting(null);
    }
  }

  @Test
  void x509Provider_keyFirstGkeCredentialBundleWithIntermediate_keepsFullChain(
      @TempDir Path tempDir) throws Exception {
    // GKE pod certificate bundles put the private key before the certificate chain.
    Path bundle =
        writeGkeBundle(
            tempDir,
            MtlsKeyStoreUtilsTest.CHAIN_CERT_PATH,
            MtlsKeyStoreUtilsTest.CHAIN_KEY_PATH,
            /* keyFirst= */ true);
    MtlsUtils.setGkeCredentialBundlePathForTesting(bundle.toString());
    try {
      X509Provider testProvider =
          new X509Provider(new TestEnvironmentProvider(), noGcloudConfig(tempDir), null, true);

      MtlsKeyStoreUtilsTest.assertLeafThenIntermediate(testProvider.getKeyStore());
    } finally {
      MtlsUtils.setGkeCredentialBundlePathForTesting(null);
    }
  }

  @Test
  void x509Provider_certFileWithIntermediate_keepsFullChain(@TempDir Path tempDir)
      throws Exception {
    Path config = tempDir.resolve("certificate_config.json");
    Files.write(
        config,
        ("{\"cert_configs\":{\"workload\":{\"cert_path\":\""
                + MtlsKeyStoreUtilsTest.CHAIN_CERT_PATH
                + "\",\"key_path\":\""
                + MtlsKeyStoreUtilsTest.CHAIN_KEY_PATH
                + "\"}}}")
            .getBytes(UTF_8));

    X509Provider testProvider = new X509Provider(config.toString());

    KeyStore store = testProvider.getKeyStore();
    MtlsKeyStoreUtilsTest.assertLeafThenIntermediate(store);
  }

  @Test
  void x509Provider_explicitConfigEnv_takesPrecedenceOverGkeCredentialBundle(@TempDir Path tempDir)
      throws Exception {
    MtlsUtils.setGkeCredentialBundlePathForTesting(
        tempDir.resolve("does_not_matter.pem").toString());
    try {
      TestEnvironmentProvider envProvider = new TestEnvironmentProvider();
      envProvider.setEnv("GOOGLE_API_CERTIFICATE_CONFIG", "badfile.txt");
      // Even with a bundle present, an explicit config is used (and fails here).
      writeGkeBundleAt(tempDir.resolve("does_not_matter.pem"), false);
      X509Provider testProvider =
          new X509Provider(envProvider, noGcloudConfig(tempDir), null, true);

      CertificateSourceUnavailableException e =
          assertThrows(CertificateSourceUnavailableException.class, testProvider::getKeyStore);
      assertFalse(String.valueOf(e.getMessage()).contains("GKE"));
    } finally {
      MtlsUtils.setGkeCredentialBundlePathForTesting(null);
    }
  }

  @Test
  void x509Provider_defaultGcloudConfig_takesPrecedenceOverGkeCredentialBundle(
      @TempDir Path tempDir) throws Exception {
    Path bundle = writeGkeBundle(tempDir, false);
    MtlsUtils.setGkeCredentialBundlePathForTesting(bundle.toString());
    try {
      Path gcloudDir = tempDir.resolve("home").resolve(".config").resolve("gcloud");
      Files.createDirectories(gcloudDir);
      Files.write(
          gcloudDir.resolve("certificate_config.json"),
          "{\"cert_configs\":{\"enterprise_certificates\":{}}}".getBytes(UTF_8));

      X509Provider testProvider =
          new X509Provider(new TestEnvironmentProvider(), noGcloudConfig(tempDir), null, true);

      CertificateSourceUnavailableException e =
          assertThrows(CertificateSourceUnavailableException.class, testProvider::getKeyStore);
      assertFalse(String.valueOf(e.getMessage()).contains("GKE"));
    } finally {
      MtlsUtils.setGkeCredentialBundlePathForTesting(null);
    }
  }

  @Test
  void x509Provider_overridePath_ignoresGkeCredentialBundle(@TempDir Path tempDir)
      throws Exception {
    Path bundle = writeGkeBundle(tempDir, false);
    MtlsUtils.setGkeCredentialBundlePathForTesting(bundle.toString());
    try {
      X509Provider testProvider =
          new X509Provider(
              new TestEnvironmentProvider(), noGcloudConfig(tempDir), "badfile.txt", true);

      CertificateSourceUnavailableException e =
          assertThrows(CertificateSourceUnavailableException.class, testProvider::getKeyStore);
      assertFalse(String.valueOf(e.getMessage()).contains("GKE"));
    } finally {
      MtlsUtils.setGkeCredentialBundlePathForTesting(null);
    }
  }

  @Test
  void x509Provider_noConfigAndNoGkeCredentialBundle_isUnavailable(@TempDir Path tempDir)
      throws Exception {
    MtlsUtils.setGkeCredentialBundlePathForTesting(tempDir.resolve("missing.pem").toString());
    try {
      X509Provider testProvider =
          new X509Provider(new TestEnvironmentProvider(), noGcloudConfig(tempDir), null, true);

      assertThrows(CertificateSourceUnavailableException.class, testProvider::getKeyStore);
      assertFalse(testProvider.isAvailable());
    } finally {
      MtlsUtils.setGkeCredentialBundlePathForTesting(null);
    }
  }

  @Test
  void x509Provider_publicConstructor_ignoresGkeCredentialBundle(@TempDir Path tempDir)
      throws Exception {
    Path bundle = writeGkeBundle(tempDir, false);
    MtlsUtils.setGkeCredentialBundlePathForTesting(bundle.toString());
    try {
      // Non-transport callers (e.g. workload identity federation X.509 credentials) keep the
      // existing certificate configuration lookup and never fall back to the GKE bundle.
      X509Provider testProvider =
          new X509Provider(new TestEnvironmentProvider(), noGcloudConfig(tempDir), null);

      assertThrows(CertificateSourceUnavailableException.class, testProvider::getKeyStore);
      assertFalse(testProvider.isAvailable());
    } finally {
      MtlsUtils.setGkeCredentialBundlePathForTesting(null);
    }
  }

  @Test
  void x509Provider_mismatchedKeyPair_retriesAndSucceedsWhenKeyRotates(@TempDir Path tempDir)
      throws Exception {
    Path certFile = tempDir.resolve("cert.pem");
    Path keyFile = tempDir.resolve("key.pem");
    Files.copy(new File(TEST_CERT_PATH).toPath(), certFile);

    KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
    kpg.initialize(1024);
    KeyPair oldRsaKeyPair = kpg.generateKeyPair();
    Files.write(
        keyFile, MtlsKeyStoreUtilsTest.toPkcs8Pem(oldRsaKeyPair.getPrivate()).getBytes(UTF_8));

    Path config = writeWorkloadConfig(tempDir, certFile, keyFile);
    List<Long> sleeps = new ArrayList<>();
    X509Provider.setTimeServiceForTesting(
        millis -> {
          sleeps.add(millis);
          if (sleeps.size() == 2) {
            // Simulate external rotator finishing key_path update before the 3rd attempt.
            try {
              Files.copy(
                  new File(TEST_KEY_PATH).toPath(),
                  keyFile,
                  java.nio.file.StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
              throw new RuntimeException(e);
            }
          }
        });
    try {
      X509Provider testProvider = new X509Provider(config.toString());

      KeyStore store = testProvider.getKeyStore();

      assertEquals(1, store.size());
      assertNotNull(store.getCertificateAlias(loadTestCert()));
      assertEquals(2, sleeps.size());
      assertEquals(X509Provider.CERT_KEY_MATCH_RETRY_INTERVAL_MS, sleeps.get(0));
      assertEquals(X509Provider.CERT_KEY_MATCH_RETRY_INTERVAL_MS, sleeps.get(1));
    } finally {
      X509Provider.setTimeServiceForTesting(null);
    }
  }

  @Test
  void x509Provider_mismatchedKeyPair_throwsAfterExhaustingRetries(@TempDir Path tempDir)
      throws Exception {
    Path certFile = tempDir.resolve("cert.pem");
    Path keyFile = tempDir.resolve("key.pem");
    Files.copy(new File(TEST_CERT_PATH).toPath(), certFile);

    KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
    kpg.initialize(1024);
    KeyPair mismatchedRsaKeyPair = kpg.generateKeyPair();
    Files.write(
        keyFile,
        MtlsKeyStoreUtilsTest.toPkcs8Pem(mismatchedRsaKeyPair.getPrivate()).getBytes(UTF_8));

    Path config = writeWorkloadConfig(tempDir, certFile, keyFile);
    List<Long> sleeps = new ArrayList<>();
    X509Provider.setTimeServiceForTesting(sleeps::add);
    try {
      X509Provider testProvider = new X509Provider(config.toString());

      IOException exception = assertThrows(IOException.class, testProvider::getKeyStore);

      assertEquals("X509Provider: Unexpected IOException:", exception.getMessage());
      assertNotNull(exception.getCause());
      assertTrue(exception.getCause() instanceof GeneralSecurityException);
      assertEquals("Certificate and private key do not match", exception.getCause().getMessage());
      assertEquals(X509Provider.CERT_KEY_MATCH_RETRIES - 1, sleeps.size());
    } finally {
      X509Provider.setTimeServiceForTesting(null);
    }
  }

  @Test
  void x509Provider_transientlyEmptyCertFile_retriesAndSucceeds(@TempDir Path tempDir)
      throws Exception {
    Path certFile = tempDir.resolve("cert.pem");
    Path keyFile = tempDir.resolve("key.pem");
    // Simulate cert_path being truncated mid-write on the first attempt.
    Files.write(certFile, new byte[0]);
    Files.copy(new File(TEST_KEY_PATH).toPath(), keyFile);

    Path config = writeWorkloadConfig(tempDir, certFile, keyFile);
    List<Long> sleeps = new ArrayList<>();
    X509Provider.setTimeServiceForTesting(
        millis -> {
          sleeps.add(millis);
          try {
            Files.copy(
                new File(TEST_CERT_PATH).toPath(),
                certFile,
                java.nio.file.StandardCopyOption.REPLACE_EXISTING);
          } catch (IOException e) {
            throw new RuntimeException(e);
          }
        });
    try {
      X509Provider testProvider = new X509Provider(config.toString());

      KeyStore store = testProvider.getKeyStore();

      assertEquals(1, store.size());
      assertNotNull(store.getCertificateAlias(loadTestCert()));
      assertEquals(1, sleeps.size());
    } finally {
      X509Provider.setTimeServiceForTesting(null);
    }
  }

  @Test
  void x509Provider_interruptedDuringRetrySleep_restoresInterruptAndThrows(@TempDir Path tempDir)
      throws Exception {
    Path certFile = tempDir.resolve("cert.pem");
    Path keyFile = tempDir.resolve("key.pem");
    Files.copy(new File(TEST_CERT_PATH).toPath(), certFile);

    KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
    kpg.initialize(1024);
    KeyPair mismatchedRsaKeyPair = kpg.generateKeyPair();
    Files.write(
        keyFile,
        MtlsKeyStoreUtilsTest.toPkcs8Pem(mismatchedRsaKeyPair.getPrivate()).getBytes(UTF_8));

    Path config = writeWorkloadConfig(tempDir, certFile, keyFile);
    X509Provider.setTimeServiceForTesting(
        millis -> {
          throw new InterruptedException("simulated interrupt");
        });
    try {
      X509Provider testProvider = new X509Provider(config.toString());

      IOException exception = assertThrows(IOException.class, testProvider::getKeyStore);

      assertTrue(Thread.currentThread().isInterrupted());
      assertEquals(
          "X509Provider: Interrupted while waiting for certificate and private key match.",
          exception.getMessage());
      assertTrue(exception.getCause() instanceof InterruptedException);
    } finally {
      Thread.interrupted(); // Clear interrupt flag
      X509Provider.setTimeServiceForTesting(null);
    }
  }

  private static Path writeWorkloadConfig(Path tempDir, Path certFile, Path keyFile)
      throws IOException {
    Path config = tempDir.resolve("certificate_config.json");
    Files.write(
        config,
        ("{\"cert_configs\":{\"workload\":{\"cert_path\":\""
                + certFile.toString()
                + "\",\"key_path\":\""
                + keyFile.toString()
                + "\"}}}")
            .getBytes(UTF_8));
    return config;
  }

  /** Property provider whose user.home has no gcloud certificate_config.json. */
  private static TestPropertyProvider noGcloudConfig(Path tempDir) {
    TestPropertyProvider propProvider = new TestPropertyProvider();
    propProvider.setProperty("os.name", "Linux");
    propProvider.setProperty("user.home", tempDir.resolve("home").toString());
    return propProvider;
  }

  private static Certificate loadTestCert() throws IOException, CertificateException {
    try (FileInputStream fis = new FileInputStream(new File(TEST_CERT_PATH))) {
      return CertificateFactory.getInstance("X.509").generateCertificate(fis);
    }
  }

  private static Path writeGkeBundle(Path dir, boolean keyFirst) throws IOException {
    return writeGkeBundle(dir, TEST_CERT_PATH, TEST_KEY_PATH, keyFirst);
  }

  private static Path writeGkeBundle(Path dir, String certPath, String keyPath, boolean keyFirst)
      throws IOException {
    return writeGkeBundleAt(
        dir.resolve("x509.credential-bundle.private-key.pem"), certPath, keyPath, keyFirst);
  }

  private static Path writeGkeBundleAt(Path bundle, boolean keyFirst) throws IOException {
    return writeGkeBundleAt(bundle, TEST_CERT_PATH, TEST_KEY_PATH, keyFirst);
  }

  private static Path writeGkeBundleAt(
      Path bundle, String certPath, String keyPath, boolean keyFirst) throws IOException {
    String cert = new String(Files.readAllBytes(new File(certPath).toPath()), UTF_8);
    String key = new String(Files.readAllBytes(new File(keyPath).toPath()), UTF_8);
    String content = keyFirst ? key + "\n" + cert : cert + "\n" + key;
    Files.write(bundle, content.getBytes(UTF_8));
    return bundle;
  }
}
