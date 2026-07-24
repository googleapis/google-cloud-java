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
package com.google.auth.oauth2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AgentIdentityUtilsTest {

  private static final String VALID_SPIFFE_ORG =
      "spiffe://agents.global.org-12345.system.id.goog/path/to/resource";
  private static final String VALID_SPIFFE_PROJ =
      "spiffe://agents.global.proj-98765.system.id.goog/another/path";
  private static final String INVALID_SPIFFE_DOMAIN = "spiffe://example.com/workload";
  private static final String INVALID_SPIFFE_FORMAT =
      "spiffe://agents.global.org-INVALID.system.id.goog/path";

  private TestEnvironmentProvider envProvider;
  private Path tempDir;

  @BeforeEach
  void setUp() throws IOException {
    envProvider = new TestEnvironmentProvider();
    AgentIdentityUtils.setEnvReader(envProvider::getEnv);
    tempDir = Files.createTempDirectory("agent_identity_test");
  }

  @AfterEach
  void tearDown() throws IOException {
    AgentIdentityUtils.resetTimeService();
    AgentIdentityUtils.setWellKnownDir("/var/run/secrets/workload-spiffe-credentials/");
    AgentIdentityUtils.setEnvReader(System::getenv);
    if (tempDir != null) {
      Files.walk(tempDir)
          .sorted(java.util.Comparator.reverseOrder())
          .map(Path::toFile)
          .forEach(File::delete);
    }
  }

  @Test
  public void shouldRequestBoundToken_validOrgSpiffe_returnsTrue() throws CertificateException {
    assertTrue(AgentIdentityUtils.shouldRequestBoundToken(mockCertWithSanUri(VALID_SPIFFE_ORG)));
  }

  @Test
  public void shouldRequestBoundToken_validProjSpiffe_returnsTrue() throws CertificateException {
    assertTrue(AgentIdentityUtils.shouldRequestBoundToken(mockCertWithSanUri(VALID_SPIFFE_PROJ)));
  }

  @Test
  public void shouldRequestBoundToken_invalidDomain_returnsFalse() throws CertificateException {
    assertFalse(
        AgentIdentityUtils.shouldRequestBoundToken(mockCertWithSanUri(INVALID_SPIFFE_DOMAIN)));
  }

  @Test
  public void shouldRequestBoundToken_invalidFormat_returnsFalse() throws CertificateException {
    assertFalse(
        AgentIdentityUtils.shouldRequestBoundToken(mockCertWithSanUri(INVALID_SPIFFE_FORMAT)));
  }

  @Test
  public void shouldRequestBoundToken_certificateParsingException_returnsFalse() throws java.security.cert.CertificateParsingException {
    X509Certificate mockCert = mock(X509Certificate.class);
    when(mockCert.getSubjectAlternativeNames()).thenThrow(new java.security.cert.CertificateParsingException());
    assertFalse(AgentIdentityUtils.shouldRequestBoundToken(mockCert));
  }

  @Test
  public void shouldRequestBoundToken_nonUriSan_returnsFalse() throws java.security.cert.CertificateParsingException {
    X509Certificate mockCert = mock(X509Certificate.class);
    List<?> dnsSan = Arrays.asList(2, "www.example.com");
    when(mockCert.getSubjectAlternativeNames()).thenReturn(Collections.<List<?>>singleton(dnsSan));
    assertFalse(AgentIdentityUtils.shouldRequestBoundToken(mockCert));
  }

  @Test
  public void shouldRequestBoundToken_noSan_returnsFalse() throws CertificateException {
    X509Certificate mockCert = mock(X509Certificate.class);
    when(mockCert.getSubjectAlternativeNames()).thenReturn(null);
    assertFalse(AgentIdentityUtils.shouldRequestBoundToken(mockCert));
  }

  private X509Certificate mockCertWithSanUri(String uri) throws CertificateException {
    X509Certificate mockCert = mock(X509Certificate.class);
    List<?> spiffeEntry = Arrays.asList(6, uri);
    Collection<List<?>> sans = Collections.singletonList(spiffeEntry);
    when(mockCert.getSubjectAlternativeNames()).thenReturn(sans);
    return mockCert;
  }

  @Test
  public void getAgentIdentityCertificate_optedOut_returnsNullImmediately() throws IOException {
    envProvider.setEnv("GOOGLE_API_PREVENT_TOKEN_SHARING_FOR_GCP_SERVICES", "true");
    envProvider.setEnv("GOOGLE_API_CERTIFICATE_CONFIG", "/non/existent/path");
    assertNull(AgentIdentityUtils.getAgentIdentityCertInfo());
  }

  @Test
  public void getAgentIdentityCertificate_noConfigEnvVar_returnsNull() throws IOException {
    AgentIdentityUtils.setTimeService(new FakeTimeService());
    assertNull(AgentIdentityUtils.getAgentIdentityCertInfo());
  }

  @Test
  public void getAgentIdentityCertificate_happyPath_loadsCertificate() throws IOException {
    URL certUrl = getClass().getClassLoader().getResource("x509_leaf_certificate.pem");
    assertNotNull(certUrl, "Test resource x509_leaf_certificate.pem not found");
    String certPath = new File(certUrl.getFile()).getAbsolutePath();
    File configFile = tempDir.resolve("config.json").toFile();
    String configJson =
        "{"
            + " \"cert_configs\": {"
            + " \"workload\": {"
            + " \"cert_path\": \""
            + certPath.replace("\\", "\\\\")
            + "\""
            + " }"
            + " }"
            + "}";
    try (FileOutputStream fos = new FileOutputStream(configFile)) {
      fos.write(configJson.getBytes(StandardCharsets.UTF_8));
    }
    envProvider.setEnv("GOOGLE_API_CERTIFICATE_CONFIG", configFile.getAbsolutePath());
    AgentIdentityUtils.CertInfo info = AgentIdentityUtils.getAgentIdentityCertInfo();
    assertNotNull(info);
    assertTrue(info.certificate.getIssuerDN().getName().contains("unit-tests"));
  }

  @Test
  public void getAgentIdentityCertificate_timeout_throwsIOException() {
    envProvider.setEnv(
        "GOOGLE_API_CERTIFICATE_CONFIG",
        tempDir.resolve("missing.json").toAbsolutePath().toString());
    AgentIdentityUtils.setWellKnownDir(tempDir.toAbsolutePath().toString() + "/");
    AgentIdentityUtils.setTimeService(new FakeTimeService());
    IOException e = assertThrows(IOException.class, AgentIdentityUtils::getAgentIdentityCertInfo);
    assertTrue(
        e.getMessage()
            .contains(
                "Unable to find Agent Identity certificate config or file for bound token request"
                    + " after multiple retries."));
  }

  @Test
  public void getAgentIdentityCertInfo_malformedJson_throwsIOException() throws IOException {
    File configFile = tempDir.resolve("config.json").toFile();
    try (FileOutputStream fos = new FileOutputStream(configFile)) {
      fos.write("{ \"cert_configs\": invalid json} ".getBytes(StandardCharsets.UTF_8));
    }
    envProvider.setEnv("GOOGLE_API_CERTIFICATE_CONFIG", configFile.getAbsolutePath());
    AgentIdentityUtils.setWellKnownDir(tempDir.toAbsolutePath().toString() + "/");
    AgentIdentityUtils.setTimeService(new FakeTimeService());

    IOException e = assertThrows(IOException.class, AgentIdentityUtils::getAgentIdentityCertInfo);
    assertTrue(
        e.getMessage()
            .contains(
                "Unable to find Agent Identity certificate config or file for bound token request"
                    + " after multiple retries."));
  }

  @Test
  public void shouldEnableMtls_true_certsPresent_returnsTrue() throws IOException {
    envProvider.setEnv("GOOGLE_API_USE_CLIENT_CERTIFICATE", "true");
    assertTrue(AgentIdentityUtils.shouldEnableMtls(true, true));
  }

  @Test
  public void shouldEnableMtls_true_certsMissing_throwsIOException() {
    envProvider.setEnv("GOOGLE_API_USE_CLIENT_CERTIFICATE", "true");
    assertThrows(IOException.class, () -> AgentIdentityUtils.shouldEnableMtls(false, true));
  }

  @Test
  public void shouldEnableMtls_false_certsPresent_returnsFalse() throws IOException {
    envProvider.setEnv("GOOGLE_API_USE_CLIENT_CERTIFICATE", "false");
    assertFalse(AgentIdentityUtils.shouldEnableMtls(true, true));
  }

  @Test
  public void shouldEnableMtls_unset_certsPresent_returnsTrue() throws IOException {
    envProvider.setEnv("GOOGLE_API_USE_CLIENT_CERTIFICATE", null);
    assertTrue(AgentIdentityUtils.shouldEnableMtls(true, true));
  }

  @Test
  public void getAgentIdentityCertInfo_fallbackPath_loadsCertificate() throws IOException {
    AgentIdentityUtils.setWellKnownDir(tempDir.toAbsolutePath().toString() + "/");

    URL certUrl = getClass().getClassLoader().getResource("x509_leaf_certificate.pem");
    assertNotNull(certUrl, "Test resource x509_leaf_certificate.pem not found");
    String certPath = new File(certUrl.getFile()).getAbsolutePath();

    Files.copy(Paths.get(certPath), tempDir.resolve("certificates.pem"));

    envProvider.setEnv("GOOGLE_API_CERTIFICATE_CONFIG", null);

    AgentIdentityUtils.CertInfo info = AgentIdentityUtils.getAgentIdentityCertInfo();
    assertNotNull(info);
    assertEquals(
        new String(Files.readAllBytes(tempDir.resolve("certificates.pem")), StandardCharsets.UTF_8),
        info.certContent);
  }

  @Test
  public void verifyKeyPair_match_returnsTrue() throws Exception {
    KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
    kpg.initialize(2048);
    KeyPair kp = kpg.generateKeyPair();

    X509Certificate mockCert = mock(X509Certificate.class);
    when(mockCert.getPublicKey()).thenReturn(kp.getPublic());

    assertTrue(AgentIdentityUtils.verifyKeyPair(mockCert, kp.getPrivate()));
  }

  @Test
  public void verifyKeyPair_mismatch_returnsFalse() throws Exception {
    KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
    kpg.initialize(2048);
    KeyPair kp1 = kpg.generateKeyPair();
    KeyPair kp2 = kpg.generateKeyPair();

    X509Certificate mockCert = mock(X509Certificate.class);
    when(mockCert.getPublicKey()).thenReturn(kp1.getPublic());

    assertFalse(AgentIdentityUtils.verifyKeyPair(mockCert, kp2.getPrivate()));
  }

  @Test
  public void getAgentIdentityCertInfo_mismatch_throwsIOExceptionAfterRetries() throws Exception {
    URL certUrl = getClass().getClassLoader().getResource("x509_leaf_certificate.pem");
    assertNotNull(certUrl, "Test resource x509_leaf_certificate.pem not found");
    String certPath = new File(certUrl.getFile()).getAbsolutePath();

    // Generate a random key that won't match the cert
    KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
    kpg.initialize(2048);
    KeyPair kp = kpg.generateKeyPair();

    File keyFile = tempDir.resolve("private_key.pem").toFile();
    String keyPem =
        "-----BEGIN PRIVATE KEY-----\n"
            + java.util.Base64.getMimeEncoder().encodeToString(kp.getPrivate().getEncoded())
            + "\n-----END PRIVATE KEY-----";
    try (FileOutputStream fos = new FileOutputStream(keyFile)) {
      fos.write(keyPem.getBytes(StandardCharsets.UTF_8));
    }

    File configFile = tempDir.resolve("config.json").toFile();
    String configJson =
        "{"
            + " \"cert_configs\": {"
            + " \"workload\": {"
            + " \"cert_path\": \""
            + certPath.replace("\\", "\\\\")
            + "\","
            + " \"key_path\": \""
            + keyFile.getAbsolutePath().replace("\\", "\\\\")
            + "\""
            + " }"
            + " }"
            + "}";
    try (FileOutputStream fos = new FileOutputStream(configFile)) {
      fos.write(configJson.getBytes(StandardCharsets.UTF_8));
    }

    envProvider.setEnv("GOOGLE_API_CERTIFICATE_CONFIG", configFile.getAbsolutePath());

    FakeTimeService fakeTime = new FakeTimeService();
    AgentIdentityUtils.setTimeService(fakeTime);

    IOException e = assertThrows(IOException.class, AgentIdentityUtils::getAgentIdentityCertInfo);
    assertTrue(
        e.getMessage()
            .contains(
                "Agent Identity certificate and private key mismatch or read failure after 3"
                    + " retries."));
    assertEquals(200, fakeTime.currentTimeMillis()); // 2 retries * 100ms
  }

  private static class FakeTimeService implements AgentIdentityUtils.TimeService {
    private final AtomicLong currentTime = new AtomicLong(0);

    @Override
    public long currentTimeMillis() {
      return currentTime.get();
    }

    @Override
    public void sleep(long millis) throws InterruptedException {
      currentTime.addAndGet(millis);
    }
  }

  private static class TestEnvironmentProvider {
    private final java.util.Map<String, String> env = new java.util.HashMap<>();

    void setEnv(String key, String value) {
      env.put(key, value);
    }

    String getEnv(String key) {
      return env.get(key);
    }
  }
}
