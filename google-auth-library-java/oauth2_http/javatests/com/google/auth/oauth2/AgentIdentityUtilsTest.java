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
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
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
import java.nio.file.attribute.FileTime;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class AgentIdentityUtilsTest {

  private static final String VALID_SPIFFE_ORG =
      "spiffe://agents.global.org-12345.system.id.goog/path/to/resource";
  private static final String VALID_SPIFFE_PROJ =
      "spiffe://agents.global.proj-98765.system.id.goog/another/path";
  private static final String VALID_SPIFFE_NONPROD_ORG =
      "spiffe://agents-nonprod.global.org-12345.system.id.goog/path/to/resource";
  private static final String VALID_SPIFFE_NONPROD_PROJ =
      "spiffe://agents-nonprod.global.proj-98765.system.id.goog/another/path";
  private static final String INVALID_SPIFFE_DOMAIN = "spiffe://example.com/workload";
  private static final String INVALID_SPIFFE_FORMAT =
      "spiffe://agents.global.org-INVALID.system.id.goog/path";

  private TestEnvironmentProvider envProvider;
  @TempDir private Path tempDir;

  @BeforeEach
  void setUp() throws IOException {
    envProvider = new TestEnvironmentProvider();
    AgentIdentityUtils.setEnvironmentProvider(envProvider);
    AgentIdentityUtils.setTimeService(new FakeTimeService());
  }

  @AfterEach
  void tearDown() throws IOException {
    AgentIdentityUtils.resetForTest();
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
  public void shouldRequestBoundToken_validNonprodOrgSpiffe_returnsTrue()
      throws CertificateException {
    assertTrue(
        AgentIdentityUtils.shouldRequestBoundToken(mockCertWithSanUri(VALID_SPIFFE_NONPROD_ORG)));
  }

  @Test
  public void shouldRequestBoundToken_validNonprodProjSpiffe_returnsTrue()
      throws CertificateException {
    assertTrue(
        AgentIdentityUtils.shouldRequestBoundToken(mockCertWithSanUri(VALID_SPIFFE_NONPROD_PROJ)));
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
  public void shouldRequestBoundToken_certificateParsingException_returnsFalse()
      throws java.security.cert.CertificateParsingException {
    X509Certificate mockCert = mock(X509Certificate.class);
    when(mockCert.getSubjectAlternativeNames())
        .thenThrow(new java.security.cert.CertificateParsingException());
    assertFalse(AgentIdentityUtils.shouldRequestBoundToken(mockCert));
  }

  @Test
  public void shouldRequestBoundToken_nonUriSan_returnsFalse()
      throws java.security.cert.CertificateParsingException {
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
  public void getAgentIdentityCertInfo_enableRuntimeBoundTokenFalse_returnsNullImmediately()
      throws IOException {
    envProvider.setEnv(AgentIdentityUtils.GOOGLE_API_ENABLE_RUNTIME_BOUND_TOKEN, "false");
    envProvider.setEnv(AgentIdentityUtils.GOOGLE_API_CERTIFICATE_CONFIG, "/non/existent/path");
    assertNull(AgentIdentityUtils.getAgentIdentityCertInfo());
  }

  @Test
  public void getAgentIdentityCertInfo_legacyPreventSharingFalse_returnsNullImmediately()
      throws IOException {
    envProvider.setEnv(
        AgentIdentityUtils.GOOGLE_API_PREVENT_AGENT_TOKEN_SHARING_FOR_GCP_SERVICES, "false");
    envProvider.setEnv(AgentIdentityUtils.GOOGLE_API_CERTIFICATE_CONFIG, "/non/existent/path");
    assertNull(AgentIdentityUtils.getAgentIdentityCertInfo());
  }

  @Test
  public void getAgentIdentityCertInfo_useClientCertFalse_returnsNullImmediatelyWithoutPolling()
      throws Exception {
    FakeTimeService fakeTime = new FakeTimeService();
    AgentIdentityUtils.setTimeService(fakeTime);
    envProvider.setEnv(AgentIdentityUtils.GOOGLE_API_USE_CLIENT_CERTIFICATE, "false");
    envProvider.setEnv(AgentIdentityUtils.GOOGLE_API_CERTIFICATE_CONFIG, "/non/existent/path");
    AgentIdentityUtils.setWellKnownDir(tempDir.toAbsolutePath().toString() + "/");

    assertNull(AgentIdentityUtils.getAgentIdentityCertInfo());
    assertEquals(0, fakeTime.getSleepCount());
  }

  @Test
  public void getAgentIdentityCertInfo_modernVarOverridesLegacyVar() throws Exception {
    setupValidAgentCredentialsInTempDir();
    // Modern is true, Legacy is false -> should NOT opt out
    envProvider.setEnv(AgentIdentityUtils.GOOGLE_API_ENABLE_RUNTIME_BOUND_TOKEN, "true");
    envProvider.setEnv(
        AgentIdentityUtils.GOOGLE_API_PREVENT_AGENT_TOKEN_SHARING_FOR_GCP_SERVICES, "false");
    assertNotNull(AgentIdentityUtils.getAgentIdentityCertInfo());

    // Modern is false, Legacy is true -> should opt out
    envProvider.setEnv(AgentIdentityUtils.GOOGLE_API_ENABLE_RUNTIME_BOUND_TOKEN, "false");
    envProvider.setEnv(
        AgentIdentityUtils.GOOGLE_API_PREVENT_AGENT_TOKEN_SHARING_FOR_GCP_SERVICES, "true");
    assertNull(AgentIdentityUtils.getAgentIdentityCertInfo());
  }

  @Test
  public void getAgentIdentityCertInfo_enableRuntimeBoundTokenTrue_doesNotOptOut()
      throws Exception {
    setupValidAgentCredentialsInTempDir();
    envProvider.setEnv(AgentIdentityUtils.GOOGLE_API_ENABLE_RUNTIME_BOUND_TOKEN, "true");

    AgentIdentityUtils.CertInfo info = AgentIdentityUtils.getAgentIdentityCertInfo();
    assertNotNull(info);
    assertEquals(
        new String(Files.readAllBytes(tempDir.resolve("certificates.pem")), StandardCharsets.UTF_8),
        info.getCertContent());
  }

  @Test
  public void getAgentIdentityCertInfo_legacyPreventSharingTrue_doesNotOptOut() throws Exception {
    setupValidAgentCredentialsInTempDir();
    envProvider.setEnv(
        AgentIdentityUtils.GOOGLE_API_PREVENT_AGENT_TOKEN_SHARING_FOR_GCP_SERVICES, "true");

    AgentIdentityUtils.CertInfo info = AgentIdentityUtils.getAgentIdentityCertInfo();
    assertNotNull(info);
    assertEquals(
        new String(Files.readAllBytes(tempDir.resolve("certificates.pem")), StandardCharsets.UTF_8),
        info.getCertContent());
  }

  @Test
  public void getAgentIdentityCertInfo_bothUnset_defaultsToEnabled() throws Exception {
    setupValidAgentCredentialsInTempDir();

    AgentIdentityUtils.CertInfo info = AgentIdentityUtils.getAgentIdentityCertInfo();
    assertNotNull(info);
    assertEquals(
        new String(Files.readAllBytes(tempDir.resolve("certificates.pem")), StandardCharsets.UTF_8),
        info.getCertContent());
  }

  private void setupValidAgentCredentialsInTempDir() throws Exception {
    AgentIdentityUtils.setWellKnownDir(tempDir.toAbsolutePath().toString() + "/");

    URL certUrl = getClass().getClassLoader().getResource("agent/agent_spiffe_cert.pem");
    assertNotNull(certUrl, "Test resource agent/agent_spiffe_cert.pem not found");
    String certPath = Paths.get(certUrl.toURI()).toAbsolutePath().toString();
    Files.copy(
        Paths.get(certPath),
        tempDir.resolve("certificates.pem"),
        java.nio.file.StandardCopyOption.REPLACE_EXISTING);

    URL keyUrl = getClass().getClassLoader().getResource("agent/agent_spiffe_key.pem");
    assertNotNull(keyUrl, "Test resource agent/agent_spiffe_key.pem not found");
    String keyPath = Paths.get(keyUrl.toURI()).toAbsolutePath().toString();
    Files.copy(
        Paths.get(keyPath),
        tempDir.resolve("private_key.pem"),
        java.nio.file.StandardCopyOption.REPLACE_EXISTING);

    envProvider.setEnv(AgentIdentityUtils.GOOGLE_API_CERTIFICATE_CONFIG, null);
  }

  @Test
  public void getAgentIdentityCertInfo_noConfigEnvVar_returnsNull() throws IOException {
    AgentIdentityUtils.setWellKnownDir(tempDir.resolve("non_existent").toString());
    AgentIdentityUtils.setTimeService(new FakeTimeService());
    assertNull(AgentIdentityUtils.getAgentIdentityCertInfo());
  }

  @Test
  public void getAgentIdentityCertInfo_happyPath_loadsCertificate() throws Exception {
    URL certUrl = getClass().getClassLoader().getResource("agent/agent_spiffe_cert.pem");
    assertNotNull(certUrl, "Test resource agent/agent_spiffe_cert.pem not found");
    String certPath = Paths.get(certUrl.toURI()).toAbsolutePath().toString();

    URL keyUrl = getClass().getClassLoader().getResource("agent/agent_spiffe_key.pem");
    assertNotNull(keyUrl, "Test resource agent/agent_spiffe_key.pem not found");
    String keyPath = Paths.get(keyUrl.toURI()).toAbsolutePath().toString();

    File configFile = tempDir.resolve("config.json").toFile();
    String configJson =
        "{"
            + " \"cert_configs\": {"
            + " \"workload\": {"
            + " \"cert_path\": \""
            + certPath.replace("\\", "\\\\")
            + "\","
            + " \"key_path\": \""
            + keyPath.replace("\\", "\\\\")
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
    assertTrue(AgentIdentityUtils.shouldRequestBoundToken(info.getCertificate()));
  }

  @Test
  public void getAgentIdentityCertInfo_timeout_throwsIOException() {
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
  public void getAgentIdentityCertInfo_malformedJson_throwsIOException(@TempDir Path outsideDir)
      throws IOException {
    File configFile = outsideDir.resolve("config.json").toFile();
    try (FileOutputStream fos = new FileOutputStream(configFile)) {
      fos.write("{ \"cert_configs\": invalid json} ".getBytes(StandardCharsets.UTF_8));
    }
    envProvider.setEnv("GOOGLE_API_CERTIFICATE_CONFIG", configFile.getAbsolutePath());
    AgentIdentityUtils.setWellKnownDir(tempDir.toAbsolutePath().toString() + "/");
    FakeTimeService fakeTime = new FakeTimeService();
    AgentIdentityUtils.setTimeService(fakeTime);

    IOException e = assertThrows(IOException.class, AgentIdentityUtils::getAgentIdentityCertInfo);
    assertTrue(e.getMessage().contains("Failed to parse Agent Identity config JSON"));
    assertEquals(0, fakeTime.getSleepCount());
  }

  @Test
  public void getAgentIdentityCertInfo_configExists_certMissing_throwsIOExceptionAfterRetries()
      throws IOException {
    File configFile = tempDir.resolve("config.json").toFile();
    try (FileOutputStream fos = new FileOutputStream(configFile)) {
      String json =
          "{ \"cert_configs\": { \"workload\": { \"cert_path\": \"/non/existent/cert.pem\","
              + " \"key_path\": \"/non/existent/key.pem\" } } }";
      fos.write(json.getBytes(StandardCharsets.UTF_8));
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
  public void shouldEnableMtls_true_noCertsNoConfig_returnsFalse() throws IOException {
    envProvider.setEnv("GOOGLE_API_USE_CLIENT_CERTIFICATE", "true");
    assertFalse(AgentIdentityUtils.shouldEnableMtls(false, false));
  }

  @Test
  public void shouldEnableMtls_false_noCertsNoConfig_returnsFalse() throws IOException {
    envProvider.setEnv("GOOGLE_API_USE_CLIENT_CERTIFICATE", "false");
    assertFalse(AgentIdentityUtils.shouldEnableMtls(false, false));
  }

  @Test
  public void shouldEnableMtls_unset_noCertsNoConfig_returnsFalse() throws IOException {
    envProvider.setEnv("GOOGLE_API_USE_CLIENT_CERTIFICATE", null);
    assertFalse(AgentIdentityUtils.shouldEnableMtls(false, false));
  }

  @Test
  public void shouldEnableMtls_unset_certsMissing_configExists_throwsIOException() {
    envProvider.setEnv("GOOGLE_API_USE_CLIENT_CERTIFICATE", null);
    assertThrows(IOException.class, () -> AgentIdentityUtils.shouldEnableMtls(false, true));
  }

  @Test
  public void getAgentIdentityCertInfo_fallbackPath_loadsCertificate() throws Exception {
    AgentIdentityUtils.setWellKnownDir(tempDir.toAbsolutePath().toString() + "/");

    URL certUrl = getClass().getClassLoader().getResource("agent/agent_spiffe_cert.pem");
    assertNotNull(certUrl, "Test resource agent/agent_spiffe_cert.pem not found");
    String certPath = Paths.get(certUrl.toURI()).toAbsolutePath().toString();
    Files.copy(Paths.get(certPath), tempDir.resolve("certificates.pem"));

    URL keyUrl = getClass().getClassLoader().getResource("agent/agent_spiffe_key.pem");
    assertNotNull(keyUrl, "Test resource agent/agent_spiffe_key.pem not found");
    String keyPath = Paths.get(keyUrl.toURI()).toAbsolutePath().toString();
    Files.copy(Paths.get(keyPath), tempDir.resolve("private_key.pem"));

    envProvider.setEnv("GOOGLE_API_CERTIFICATE_CONFIG", null);

    AgentIdentityUtils.CertInfo info = AgentIdentityUtils.getAgentIdentityCertInfo();
    assertNotNull(info);
    assertEquals(
        new String(Files.readAllBytes(tempDir.resolve("certificates.pem")), StandardCharsets.UTF_8),
        info.getCertContent());
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
  public void verifyKeyPair_ecKey_returnsTrue() throws Exception {
    KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC");
    kpg.initialize(256);
    KeyPair kp = kpg.generateKeyPair();

    X509Certificate ecCert = mock(X509Certificate.class);
    when(ecCert.getPublicKey()).thenReturn(kp.getPublic());
    assertTrue(AgentIdentityUtils.verifyKeyPair(ecCert, kp.getPrivate()));
  }

  @Test
  public void shouldRequestBoundToken_uppercaseSpiffeSchemeAndTrustDomain_returnsTrue()
      throws Exception {
    X509Certificate mockCert = mock(X509Certificate.class);
    Collection<List<?>> sans =
        Collections.singletonList(
            Arrays.asList(6, "SPIFFE://AGENTS.GLOBAL.ORG-12345.SYSTEM.ID.GOOG/ns/default/sa/test"));
    when(mockCert.getSubjectAlternativeNames()).thenReturn(sans);

    assertTrue(AgentIdentityUtils.shouldRequestBoundToken(mockCert));
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
    URL certUrl = getClass().getClassLoader().getResource("agent/agent_spiffe_cert.pem");
    assertNotNull(certUrl, "Test resource agent/agent_spiffe_cert.pem not found");
    String certPath = Paths.get(certUrl.toURI()).toAbsolutePath().toString();

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

  @Test
  public void
      getAgentIdentityCertInfo_wellKnownDirExistsNoFiles_notExplicitlyEnabled_returnsNullImmediately()
          throws IOException {
    AgentIdentityUtils.setWellKnownDir(tempDir.toAbsolutePath().toString() + "/");
    FakeTimeService fakeTime = new FakeTimeService();
    AgentIdentityUtils.setTimeService(fakeTime);
    envProvider.setEnv("GOOGLE_API_CERTIFICATE_CONFIG", null);
    envProvider.setEnv("GOOGLE_API_USE_CLIENT_CERTIFICATE", null);

    assertNull(AgentIdentityUtils.getAgentIdentityCertInfo());
    assertEquals(0, fakeTime.getSleepCount());
  }

  @Test
  public void
      getAgentIdentityCertInfo_wellKnownDirExistsNoFiles_explicitlyEnabled_retriesAndThrowsIOException()
          throws IOException {
    AgentIdentityUtils.setWellKnownDir(tempDir.toAbsolutePath().toString() + "/");
    FakeTimeService fakeTime = new FakeTimeService();
    AgentIdentityUtils.setTimeService(fakeTime);
    envProvider.setEnv("GOOGLE_API_CERTIFICATE_CONFIG", null);
    envProvider.setEnv("GOOGLE_API_USE_CLIENT_CERTIFICATE", "true");

    assertThrows(IOException.class, AgentIdentityUtils::getAgentIdentityCertInfo);
    assertTrue(fakeTime.getSleepCount() > 0);
  }

  @Test
  public void readCertificateChain_combinedBundle_stripsPrivateKeyAndRetainsCertificates()
      throws Exception {
    URL cert1Url = getClass().getClassLoader().getResource("agent/agent_spiffe_cert.pem");
    assertNotNull(cert1Url);
    String cert1Pem =
        new String(Files.readAllBytes(Paths.get(cert1Url.toURI())), StandardCharsets.UTF_8);

    URL cert2Url = getClass().getClassLoader().getResource("x509_leaf_certificate.pem");
    assertNotNull(cert2Url);
    String cert2Pem =
        new String(Files.readAllBytes(Paths.get(cert2Url.toURI())), StandardCharsets.UTF_8);

    URL keyUrl = getClass().getClassLoader().getResource("agent/agent_spiffe_key.pem");
    assertNotNull(keyUrl);
    String keyPem =
        new String(Files.readAllBytes(Paths.get(keyUrl.toURI())), StandardCharsets.UTF_8);

    // Create a bundle file with cert1 then private key then cert2
    String bundleContent = cert1Pem + "\n" + keyPem + "\n" + cert2Pem;
    Path bundleFile = tempDir.resolve("bundle.pem");
    Files.write(bundleFile, bundleContent.getBytes(StandardCharsets.UTF_8));

    String extractedChain = AgentIdentityUtils.readCertificateChain(bundleFile.toString());

    // Verify both certificates are retained
    assertTrue(extractedChain.contains(cert1Pem.trim()));
    assertTrue(extractedChain.contains(cert2Pem.trim()));
    // Verify private key is stripped
    assertFalse(extractedChain.contains("PRIVATE KEY"));
    assertFalse(extractedChain.contains("BEGIN PRIVATE KEY"));
    assertFalse(extractedChain.contains("END PRIVATE KEY"));
  }

  @Test
  public void readCertificateChain_noCertificates_throwsIOException() throws Exception {
    URL keyUrl = getClass().getClassLoader().getResource("agent/agent_spiffe_key.pem");
    assertNotNull(keyUrl);
    String keyPem =
        new String(Files.readAllBytes(Paths.get(keyUrl.toURI())), StandardCharsets.UTF_8);

    Path keyOnlyFile = tempDir.resolve("key_only.pem");
    Files.write(keyOnlyFile, keyPem.getBytes(StandardCharsets.UTF_8));

    IOException e =
        assertThrows(
            IOException.class,
            () -> AgentIdentityUtils.readCertificateChain(keyOnlyFile.toString()));
    assertTrue(e.getMessage().contains("No PEM certificates found in certificate file"));
  }

  @Test
  public void loadAndVerifyCredentials_validCombinedBundle_verifiesKeyAndStripsPrivateKey()
      throws Exception {
    URL certUrl = getClass().getClassLoader().getResource("agent/agent_spiffe_cert.pem");
    assertNotNull(certUrl);
    String certPem =
        new String(Files.readAllBytes(Paths.get(certUrl.toURI())), StandardCharsets.UTF_8);

    URL keyUrl = getClass().getClassLoader().getResource("agent/agent_spiffe_key.pem");
    assertNotNull(keyUrl);
    String keyPem =
        new String(Files.readAllBytes(Paths.get(keyUrl.toURI())), StandardCharsets.UTF_8);

    String bundleContent = certPem + "\n" + keyPem;
    Path bundleFile = tempDir.resolve("credentialbundle.pem");
    Files.write(bundleFile, bundleContent.getBytes(StandardCharsets.UTF_8));

    AgentIdentityUtils.CertInfo info =
        AgentIdentityUtils.loadAndVerifyCredentials(bundleFile.toString(), bundleFile.toString());
    assertNotNull(info);
    assertNotNull(info.getCertificate());
    assertTrue(AgentIdentityUtils.shouldRequestBoundToken(info.getCertificate()));
    assertTrue(info.getCertContent().contains("BEGIN CERTIFICATE"));
    assertFalse(info.getCertContent().contains("PRIVATE KEY"));
  }

  @Test
  public void loadAndVerifyCredentials_bundleWithMismatchedKey_failsVerification()
      throws Exception {
    URL certUrl = getClass().getClassLoader().getResource("agent/agent_spiffe_cert.pem");
    assertNotNull(certUrl);
    String certPem =
        new String(Files.readAllBytes(Paths.get(certUrl.toURI())), StandardCharsets.UTF_8);

    // Generate a random key that does not match the cert
    KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
    kpg.initialize(2048);
    KeyPair kp = kpg.generateKeyPair();
    String mismatchedKeyPem =
        "-----BEGIN PRIVATE KEY-----\n"
            + java.util.Base64.getMimeEncoder().encodeToString(kp.getPrivate().getEncoded())
            + "\n-----END PRIVATE KEY-----";

    String bundleContent = certPem + "\n" + mismatchedKeyPem;
    Path bundleFile = tempDir.resolve("credentialbundle.pem");
    Files.write(bundleFile, bundleContent.getBytes(StandardCharsets.UTF_8));

    envProvider.setEnv("GOOGLE_API_USE_CLIENT_CERTIFICATE", "true");
    AgentIdentityUtils.setTimeService(new FakeTimeService());

    IOException e =
        assertThrows(
            IOException.class,
            () ->
                AgentIdentityUtils.loadAndVerifyCredentials(
                    bundleFile.toString(), bundleFile.toString()));
    assertTrue(
        e.getMessage()
            .contains(
                "Agent Identity certificate and private key mismatch or read failure after 3"
                    + " retries."));
  }

  @Test
  public void loadAndVerifyCredentials_implicitDiscovery_bundleWithMismatchedKey_throwsIOException()
      throws Exception {
    AgentIdentityUtils.setWellKnownDir(tempDir.toAbsolutePath().toString() + "/");
    URL certUrl = getClass().getClassLoader().getResource("agent/agent_spiffe_cert.pem");
    assertNotNull(certUrl);
    String certPem =
        new String(Files.readAllBytes(Paths.get(certUrl.toURI())), StandardCharsets.UTF_8);

    KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
    kpg.initialize(2048);
    KeyPair kp = kpg.generateKeyPair();
    String mismatchedKeyPem =
        "-----BEGIN PRIVATE KEY-----\n"
            + java.util.Base64.getMimeEncoder().encodeToString(kp.getPrivate().getEncoded())
            + "\n-----END PRIVATE KEY-----";

    String bundleContent = certPem + "\n" + mismatchedKeyPem;
    Path bundleFile = tempDir.resolve("credentialbundle.pem");
    Files.write(bundleFile, bundleContent.getBytes(StandardCharsets.UTF_8));

    envProvider.setEnv("GOOGLE_API_CERTIFICATE_CONFIG", null);
    envProvider.setEnv("GOOGLE_API_USE_CLIENT_CERTIFICATE", null);
    AgentIdentityUtils.setTimeService(new FakeTimeService());

    IOException e = assertThrows(IOException.class, AgentIdentityUtils::getAgentIdentityCertInfo);
    assertNotNull(e.getCause());
    assertTrue(e.getCause().getMessage().contains("Certificate and private key do not match"));
  }

  @Test
  public void getAgentIdentityCertInfo_wellKnownBundleFile_verifiesAndStripsPrivateKey()
      throws Exception {
    AgentIdentityUtils.setWellKnownDir(tempDir.toAbsolutePath().toString() + "/");

    URL certUrl = getClass().getClassLoader().getResource("agent/agent_spiffe_cert.pem");
    assertNotNull(certUrl);
    String certPem =
        new String(Files.readAllBytes(Paths.get(certUrl.toURI())), StandardCharsets.UTF_8);

    URL keyUrl = getClass().getClassLoader().getResource("agent/agent_spiffe_key.pem");
    assertNotNull(keyUrl);
    String keyPem =
        new String(Files.readAllBytes(Paths.get(keyUrl.toURI())), StandardCharsets.UTF_8);

    String bundleContent = certPem + "\n" + keyPem;
    Path bundleFile = tempDir.resolve("credentialbundle.pem");
    Files.write(bundleFile, bundleContent.getBytes(StandardCharsets.UTF_8));

    envProvider.setEnv(AgentIdentityUtils.GOOGLE_API_CERTIFICATE_CONFIG, null);

    AgentIdentityUtils.CertInfo info = AgentIdentityUtils.getAgentIdentityCertInfo();
    assertNotNull(info);
    assertNotNull(info.getCertificate());
    assertTrue(AgentIdentityUtils.shouldRequestBoundToken(info.getCertificate()));
    assertTrue(info.getCertContent().contains("BEGIN CERTIFICATE"));
    assertFalse(info.getCertContent().contains("PRIVATE KEY"));
  }

  @Test
  public void getAgentIdentityCertInfo_explicitConfigDirectoryAccessDenied_throwsIOException()
      throws Exception {
    Path restrictedDir = tempDir.resolve("restricted_dir");
    Files.createDirectory(restrictedDir);
    Path configFile = restrictedDir.resolve("config.json");
    Files.write(configFile, "{}".getBytes(StandardCharsets.UTF_8));

    restrictedDir.toFile().setReadable(false, false);
    restrictedDir.toFile().setExecutable(false, false);

    try {
      Assumptions.assumeFalse(Files.isReadable(configFile));
      envProvider.setEnv(
          AgentIdentityUtils.GOOGLE_API_CERTIFICATE_CONFIG, configFile.toAbsolutePath().toString());
      assertThrows(IOException.class, AgentIdentityUtils::getAgentIdentityCertInfo);
    } finally {
      restrictedDir.toFile().setReadable(true, false);
      restrictedDir.toFile().setExecutable(true, false);
    }
  }

  @Test
  public void getAgentIdentityCertInfo_explicitConfigFileNotReadable_throwsIOException()
      throws Exception {
    Path configFile = tempDir.resolve("unreadable_config.json");
    Files.write(configFile, "{}".getBytes(StandardCharsets.UTF_8));
    configFile.toFile().setReadable(false, false);

    try {
      Assumptions.assumeFalse(Files.isReadable(configFile));
      envProvider.setEnv(
          AgentIdentityUtils.GOOGLE_API_CERTIFICATE_CONFIG, configFile.toAbsolutePath().toString());
      assertThrows(IOException.class, AgentIdentityUtils::getAgentIdentityCertInfo);
    } finally {
      configFile.toFile().setReadable(true, false);
    }
  }

  @Test
  public void getAgentIdentityCertInfo_implicitWellKnownAccessDenied_returnsNull()
      throws Exception {
    Path restrictedDir = tempDir.resolve("restricted_well_known");
    Files.createDirectory(restrictedDir);
    Path bundleFile = restrictedDir.resolve("credentialbundle.pem");
    Files.write(bundleFile, "test".getBytes(StandardCharsets.UTF_8));

    restrictedDir.toFile().setReadable(false, false);
    restrictedDir.toFile().setExecutable(false, false);

    try {
      Assumptions.assumeFalse(Files.isReadable(bundleFile));
      envProvider.setEnv(AgentIdentityUtils.GOOGLE_API_CERTIFICATE_CONFIG, null);
      AgentIdentityUtils.setWellKnownDir(restrictedDir.toAbsolutePath().toString() + "/");

      assertNull(AgentIdentityUtils.getAgentIdentityCertInfo());
    } finally {
      restrictedDir.toFile().setReadable(true, false);
      restrictedDir.toFile().setExecutable(true, false);
    }
  }

  @Test
  public void getAgentIdentityCertInfo_enterpriseConfig_returnsNullImmediatelyWithoutPolling()
      throws Exception {
    File configFile = tempDir.resolve("enterprise_config.json").toFile();
    try (FileOutputStream fos = new FileOutputStream(configFile)) {
      String json =
          "{\n"
              + "  \"cert_configs\": {\n"
              + "    \"enterprise\": {\n"
              + "      \"cert_provider_command\": [\"/bin/echo\", \"dummy\"]\n"
              + "    }\n"
              + "  }\n"
              + "}";
      fos.write(json.getBytes(StandardCharsets.UTF_8));
    }
    envProvider.setEnv("GOOGLE_API_CERTIFICATE_CONFIG", configFile.getAbsolutePath());
    AgentIdentityUtils.setWellKnownDir(tempDir.toAbsolutePath().toString() + "/");
    FakeTimeService fakeTime = new FakeTimeService();
    AgentIdentityUtils.setTimeService(fakeTime);

    AgentIdentityUtils.CertInfo info = AgentIdentityUtils.getAgentIdentityCertInfo();
    assertNull(info);
    assertEquals(0, fakeTime.getSleepCount());
  }

  @Test
  public void getAgentIdentityCertInfo_configWithoutWorkload_returnsNullImmediatelyWithoutPolling()
      throws Exception {
    File configFile = tempDir.resolve("empty_cert_configs.json").toFile();
    try (FileOutputStream fos = new FileOutputStream(configFile)) {
      String json = "{ \"cert_configs\": {} }";
      fos.write(json.getBytes(StandardCharsets.UTF_8));
    }
    envProvider.setEnv("GOOGLE_API_CERTIFICATE_CONFIG", configFile.getAbsolutePath());
    AgentIdentityUtils.setWellKnownDir(tempDir.toAbsolutePath().toString() + "/");
    FakeTimeService fakeTime = new FakeTimeService();
    AgentIdentityUtils.setTimeService(fakeTime);

    AgentIdentityUtils.CertInfo info = AgentIdentityUtils.getAgentIdentityCertInfo();
    assertNull(info);
    assertEquals(0, fakeTime.getSleepCount());
  }

  @Test
  public void
      getAgentIdentityCertInfo_missingConfigOutsideWellKnownDir_throwsIOExceptionImmediatelyWithoutPolling(
          @TempDir Path outsideDir) throws Exception {
    Path missingConfigFile = outsideDir.resolve("missing_config.json");
    envProvider.setEnv(
        "GOOGLE_API_CERTIFICATE_CONFIG", missingConfigFile.toAbsolutePath().toString());
    AgentIdentityUtils.setWellKnownDir(tempDir.toAbsolutePath().toString() + "/");
    FakeTimeService fakeTime = new FakeTimeService();
    AgentIdentityUtils.setTimeService(fakeTime);

    assertThrows(IOException.class, AgentIdentityUtils::getAgentIdentityCertInfo);
    assertEquals(0, fakeTime.getSleepCount());
  }

  @Test
  public void
      getAgentIdentityCertInfo_configOutsideWellKnownDir_targetCertInWellKnownDir_pollsUntilReady(
          @TempDir Path outsideDir) throws Exception {
    Path targetCertPath = tempDir.resolve("certificates.pem");
    Path targetKeyPath = tempDir.resolve("private_key.pem");

    File configFile = outsideDir.resolve("certificate_config.json").toFile();
    String configJson =
        "{"
            + " \"cert_configs\": {"
            + " \"workload\": {"
            + " \"cert_path\": \""
            + targetCertPath.toAbsolutePath().toString().replace("\\", "\\\\")
            + "\","
            + " \"key_path\": \""
            + targetKeyPath.toAbsolutePath().toString().replace("\\", "\\\\")
            + "\""
            + " }"
            + " }"
            + "}";
    Files.write(configFile.toPath(), configJson.getBytes(StandardCharsets.UTF_8));

    envProvider.setEnv("GOOGLE_API_CERTIFICATE_CONFIG", configFile.getAbsolutePath());
    AgentIdentityUtils.setWellKnownDir(tempDir.toAbsolutePath().toString() + "/");

    FakeTimeService fakeTime = new FakeTimeService();
    fakeTime.setOnSleepCallback(
        () -> {
          if (fakeTime.getSleepCount() == 2) {
            try {
              URL certUrl = getClass().getClassLoader().getResource("agent/agent_spiffe_cert.pem");
              URL keyUrl = getClass().getClassLoader().getResource("agent/agent_spiffe_key.pem");
              Files.copy(Paths.get(certUrl.toURI()), targetCertPath);
              Files.copy(Paths.get(keyUrl.toURI()), targetKeyPath);
            } catch (Exception e) {
              throw new RuntimeException(e);
            }
          }
        });
    AgentIdentityUtils.setTimeService(fakeTime);

    AgentIdentityUtils.CertInfo info = AgentIdentityUtils.getAgentIdentityCertInfo();
    assertNotNull(info);
    assertEquals(2, fakeTime.getSleepCount());
  }

  @Test
  public void getAgentIdentityCertInfo_partialJsonDuringStartupPoll_retriesAndSucceeds()
      throws Exception {
    Path targetCertPath = tempDir.resolve("certificates.pem");
    Path targetKeyPath = tempDir.resolve("private_key.pem");
    URL certUrl = getClass().getClassLoader().getResource("agent/agent_spiffe_cert.pem");
    URL keyUrl = getClass().getClassLoader().getResource("agent/agent_spiffe_key.pem");
    Files.copy(Paths.get(certUrl.toURI()), targetCertPath);
    Files.copy(Paths.get(keyUrl.toURI()), targetKeyPath);

    Path configFile = tempDir.resolve("config.json");
    // Write partial/incomplete JSON simulating non-atomic write at startup
    Files.write(configFile, "{ \"cert_configs\": ".getBytes(StandardCharsets.UTF_8));

    envProvider.setEnv("GOOGLE_API_CERTIFICATE_CONFIG", configFile.toAbsolutePath().toString());
    AgentIdentityUtils.setWellKnownDir(tempDir.toAbsolutePath().toString() + "/");

    String validJson =
        "{"
            + " \"cert_configs\": {"
            + " \"workload\": {"
            + " \"cert_path\": \""
            + targetCertPath.toAbsolutePath().toString().replace("\\", "\\\\")
            + "\","
            + " \"key_path\": \""
            + targetKeyPath.toAbsolutePath().toString().replace("\\", "\\\\")
            + "\""
            + " }"
            + " }"
            + "}";

    FakeTimeService fakeTime = new FakeTimeService();
    fakeTime.setOnSleepCallback(
        () -> {
          if (fakeTime.getSleepCount() == 1) {
            try {
              Files.write(configFile, validJson.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
              throw new RuntimeException(e);
            }
          }
        });
    AgentIdentityUtils.setTimeService(fakeTime);

    AgentIdentityUtils.CertInfo info = AgentIdentityUtils.getAgentIdentityCertInfo();
    assertNotNull(info);
    assertEquals(1, fakeTime.getSleepCount());
  }

  @Test
  public void
      getAgentIdentityCertInfo_startupPollTimeout_subsequentRefreshDoesNotPollAndThrowsIOException()
          throws Exception {
    AgentIdentityUtils.setWellKnownDir(tempDir.toAbsolutePath().toString() + "/");
    FakeTimeService fakeTime = new FakeTimeService();
    AgentIdentityUtils.setTimeService(fakeTime);
    envProvider.setEnv("GOOGLE_API_CERTIFICATE_CONFIG", null);
    envProvider.setEnv("GOOGLE_API_USE_CLIENT_CERTIFICATE", "true");

    // Initial call polls for all 100 cycles (99 sleeps) and fails closed with IOException
    assertThrows(IOException.class, AgentIdentityUtils::getAgentIdentityCertInfo);
    assertEquals(99, fakeTime.getSleepCount());

    // Subsequent token refresh fails closed immediately without sleeping
    assertThrows(IOException.class, AgentIdentityUtils::getAgentIdentityCertInfo);
    assertEquals(99, fakeTime.getSleepCount());
  }

  @Test
  public void
      getAgentIdentityCertInfo_configInWellKnownDirTimeout_subsequentRefreshDoesNotPollAndThrowsIOException()
          throws Exception {
    AgentIdentityUtils.setWellKnownDir(tempDir.toAbsolutePath().toString() + "/");
    FakeTimeService fakeTime = new FakeTimeService();
    AgentIdentityUtils.setTimeService(fakeTime);
    envProvider.setEnv(
        "GOOGLE_API_CERTIFICATE_CONFIG",
        tempDir.resolve("missing_config.json").toAbsolutePath().toString());
    envProvider.setEnv("GOOGLE_API_USE_CLIENT_CERTIFICATE", null);

    // Initial call polls for all 100 cycles (99 sleeps) and fails closed with IOException
    assertThrows(IOException.class, AgentIdentityUtils::getAgentIdentityCertInfo);
    assertEquals(99, fakeTime.getSleepCount());

    // Subsequent token refresh fails closed immediately without sleeping
    assertThrows(IOException.class, AgentIdentityUtils::getAgentIdentityCertInfo);
    assertEquals(99, fakeTime.getSleepCount());
  }

  @Test
  public void
      getAgentIdentityCertInfo_startupSucceeded_subsequentRefreshMissingFileRetriesAndFallsBackToCache()
          throws Exception {
    setupValidAgentCredentialsInTempDir();
    FakeTimeService fakeTime = new FakeTimeService();
    AgentIdentityUtils.setTimeService(fakeTime);
    envProvider.setEnv("GOOGLE_API_CERTIFICATE_CONFIG", null);
    envProvider.setEnv("GOOGLE_API_USE_CLIENT_CERTIFICATE", "true");

    // Initial startup discovery succeeds immediately without polling
    AgentIdentityUtils.CertInfo info1 = AgentIdentityUtils.getAgentIdentityCertInfo();
    assertNotNull(info1);
    assertEquals(0, fakeTime.getSleepCount());

    // Simulate certificate file disappearing on disk after initial startup
    Files.delete(tempDir.resolve("certificates.pem"));

    // Subsequent token refresh retries briefly (2 sleeps of 100ms) and falls back to cached cert
    AgentIdentityUtils.CertInfo info2 = AgentIdentityUtils.getAgentIdentityCertInfo();
    assertSame(info1, info2);
    assertEquals(2, fakeTime.getSleepCount());
  }

  @Test
  public void getAgentIdentityCertInfo_startupSucceeded_rotationMomentaryUnlinkRecoversDuringRetry()
      throws Exception {
    setupValidAgentCredentialsInTempDir();
    FakeTimeService fakeTime = new FakeTimeService();
    AgentIdentityUtils.setTimeService(fakeTime);
    envProvider.setEnv("GOOGLE_API_CERTIFICATE_CONFIG", null);
    envProvider.setEnv("GOOGLE_API_USE_CLIENT_CERTIFICATE", null);

    AgentIdentityUtils.CertInfo info1 = AgentIdentityUtils.getAgentIdentityCertInfo();
    assertNotNull(info1);

    Path certFile = tempDir.resolve("certificates.pem");
    byte[] certBytes = Files.readAllBytes(certFile);
    // Momentarily unlink certificate file simulating non-atomic unlink+create rotation
    Files.delete(certFile);

    fakeTime.setOnSleepCallback(
        () -> {
          if (fakeTime.getSleepCount() == 1) {
            try {
              // Re-create the file with updated content during retry sleep
              Files.write(
                  certFile,
                  (new String(certBytes, StandardCharsets.UTF_8) + "\n")
                      .getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
              throw new RuntimeException(e);
            }
          }
        });

    AgentIdentityUtils.CertInfo info2 = AgentIdentityUtils.getAgentIdentityCertInfo();
    assertNotNull(info2);
    assertNotSame(info1, info2);
    assertEquals(1, fakeTime.getSleepCount());
  }

  @Test
  public void getAgentIdentityCertInfo_implicitDiscovery_missingPrivateKey_throwsIOException()
      throws Exception {
    AgentIdentityUtils.setWellKnownDir(tempDir.toAbsolutePath().toString() + "/");
    URL certUrl = getClass().getClassLoader().getResource("agent/agent_spiffe_cert.pem");
    assertNotNull(certUrl);
    Files.copy(Paths.get(certUrl.toURI()), tempDir.resolve("certificates.pem"));
    // Without private_key.pem, implicit well-known discovery does not consider certOnlyPath ready
    envProvider.setEnv("GOOGLE_API_CERTIFICATE_CONFIG", null);
    envProvider.setEnv("GOOGLE_API_USE_CLIENT_CERTIFICATE", null);
    FakeTimeService fakeTime = new FakeTimeService();
    AgentIdentityUtils.setTimeService(fakeTime);

    assertNull(AgentIdentityUtils.getAgentIdentityCertInfo());
    assertEquals(0, fakeTime.getSleepCount());

    // Once credentialbundle.pem (or private_key.pem) exists without a valid private key, fails
    // closed
    Files.copy(Paths.get(certUrl.toURI()), tempDir.resolve("credentialbundle.pem"));
    assertThrows(IOException.class, AgentIdentityUtils::getAgentIdentityCertInfo);
    assertEquals(2, fakeTime.getSleepCount());
  }

  @Test
  public void getAgentIdentityCertInfo_explicitMtlsEnabled_missingPrivateKey_throwsIOException()
      throws Exception {
    AgentIdentityUtils.setWellKnownDir(tempDir.toAbsolutePath().toString() + "/");
    URL certUrl = getClass().getClassLoader().getResource("agent/agent_spiffe_cert.pem");
    assertNotNull(certUrl);
    Files.copy(Paths.get(certUrl.toURI()), tempDir.resolve("certificates.pem"));
    // Intentionally do NOT copy private_key.pem

    envProvider.setEnv("GOOGLE_API_CERTIFICATE_CONFIG", null);
    envProvider.setEnv("GOOGLE_API_USE_CLIENT_CERTIFICATE", "true");
    FakeTimeService fakeTime = new FakeTimeService();
    AgentIdentityUtils.setTimeService(fakeTime);

    IOException e = assertThrows(IOException.class, AgentIdentityUtils::getAgentIdentityCertInfo);
    assertTrue(
        e.getMessage().contains("Unable to find well-known Agent Identity certificate file"));
    assertEquals(99, fakeTime.getSleepCount());
  }

  @Test
  public void getAgentIdentityCertInfo_certificateOnlyConfig_omittedKeyPath_throwsIOException()
      throws Exception {
    URL certUrl = getClass().getClassLoader().getResource("agent/agent_spiffe_cert.pem");
    assertNotNull(certUrl);
    String certPath = Paths.get(certUrl.toURI()).toAbsolutePath().toString();

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
    Files.write(configFile.toPath(), configJson.getBytes(StandardCharsets.UTF_8));

    envProvider.setEnv("GOOGLE_API_CERTIFICATE_CONFIG", configFile.getAbsolutePath());
    FakeTimeService fakeTime = new FakeTimeService();
    AgentIdentityUtils.setTimeService(fakeTime);

    IOException e = assertThrows(IOException.class, AgentIdentityUtils::getAgentIdentityCertInfo);
    assertTrue(
        e.getMessage()
            .contains(
                "Unable to find Agent Identity certificate config or file for bound token"
                    + " request"));
    assertEquals(0, fakeTime.getSleepCount());
  }

  @Test
  public void getAgentIdentityCertInfo_nonAgentSpiffeCert_returnsNullWithoutReadingKey()
      throws Exception {
    URL certUrl = getClass().getClassLoader().getResource("x509_leaf_certificate.pem");
    assertNotNull(certUrl);
    String certPath = Paths.get(certUrl.toURI()).toAbsolutePath().toString();

    Path invalidKeyFile = tempDir.resolve("invalid_key.pem");
    Files.write(invalidKeyFile, "not-a-valid-private-key".getBytes(StandardCharsets.UTF_8));

    File configFile = tempDir.resolve("config.json").toFile();
    String configJson =
        "{"
            + " \"cert_configs\": {"
            + " \"workload\": {"
            + " \"cert_path\": \""
            + certPath.replace("\\", "\\\\")
            + "\","
            + " \"key_path\": \""
            + invalidKeyFile.toAbsolutePath().toString().replace("\\", "\\\\")
            + "\""
            + " }"
            + " }"
            + "}";
    Files.write(configFile.toPath(), configJson.getBytes(StandardCharsets.UTF_8));

    envProvider.setEnv("GOOGLE_API_CERTIFICATE_CONFIG", configFile.getAbsolutePath());
    FakeTimeService fakeTime = new FakeTimeService();
    AgentIdentityUtils.setTimeService(fakeTime);

    // Should return null without attempting to parse the invalid private key or sleeping
    assertNull(AgentIdentityUtils.getAgentIdentityCertInfo());
    assertEquals(0, fakeTime.getSleepCount());
    assertNull(AgentIdentityUtils.getBoundTokenPayload());
  }

  @Test
  public void getAgentIdentityCertInfo_cachesVerifiedCertInfoAndInvalidatesOnRotation()
      throws Exception {
    setupValidAgentCredentialsInTempDir();
    FakeTimeService fakeTime = new FakeTimeService();
    AgentIdentityUtils.setTimeService(fakeTime);

    AgentIdentityUtils.CertInfo info1 = AgentIdentityUtils.getAgentIdentityCertInfo();
    assertNotNull(info1);

    // Second call with unchanged files on disk must return the exact same cached instance
    AgentIdentityUtils.CertInfo info2 = AgentIdentityUtils.getAgentIdentityCertInfo();
    assertSame(info1, info2);

    // Simulate certificate rotation on disk by modifying the file content/size
    Path certFile = tempDir.resolve("certificates.pem");
    String originalPem = new String(Files.readAllBytes(certFile), StandardCharsets.UTF_8);
    Files.write(certFile, (originalPem + "\n").getBytes(StandardCharsets.UTF_8));

    AgentIdentityUtils.CertInfo info3 = AgentIdentityUtils.getAgentIdentityCertInfo();
    assertNotNull(info3);
    assertNotSame(info1, info3);
  }

  @Test
  public void
      getAgentIdentityCertInfo_rotationWithIdenticalByteLengthAndUpdatedMtime_reloadsCredentials()
          throws Exception {
    setupValidAgentCredentialsInTempDir();
    Path certFile = tempDir.resolve("certificates.pem");
    String basePem = new String(Files.readAllBytes(certFile), StandardCharsets.UTF_8);

    // Write initial version with a fixed-length trailing comment
    String v1Pem = basePem + "\n# version-1";
    Files.write(certFile, v1Pem.getBytes(StandardCharsets.UTF_8));
    FileTime initialMtime = Files.getLastModifiedTime(certFile);
    long initialSize = Files.size(certFile);

    AgentIdentityUtils.CertInfo info1 = AgentIdentityUtils.getAgentIdentityCertInfo();
    assertNotNull(info1);

    // Overwrite with identical byte length but updated mtime
    String v2Pem = basePem + "\n# version-2";
    Files.write(certFile, v2Pem.getBytes(StandardCharsets.UTF_8));
    Files.setLastModifiedTime(certFile, FileTime.fromMillis(initialMtime.toMillis() + 5000));
    assertEquals(initialSize, Files.size(certFile));

    AgentIdentityUtils.CertInfo info2 = AgentIdentityUtils.getAgentIdentityCertInfo();
    assertNotNull(info2);
    assertNotSame(info1, info2);
  }

  @Test
  public void
      getAgentIdentityCertInfo_concurrentCacheInvalidationDuringRotation_fallsBackToInitialSnapshot()
          throws Exception {
    setupValidAgentCredentialsInTempDir();
    FakeTimeService fakeTime = new FakeTimeService();
    AgentIdentityUtils.setTimeService(fakeTime);
    envProvider.setEnv("GOOGLE_API_CERTIFICATE_CONFIG", null);
    envProvider.setEnv("GOOGLE_API_USE_CLIENT_CERTIFICATE", null);

    AgentIdentityUtils.CertInfo info1 = AgentIdentityUtils.getAgentIdentityCertInfo();
    assertNotNull(info1);

    // Simulate transient file disappearance during steady-state rotation
    Files.delete(tempDir.resolve("certificates.pem"));

    // While the thread sleeps in loadAndVerifyCredentials backoff, simulate another thread
    // concurrently clearing/invalidating cachedCredentials
    fakeTime.setOnSleepCallback(() -> AgentIdentityUtils.clearCachedCredentials());

    AgentIdentityUtils.CertInfo info2 = AgentIdentityUtils.getAgentIdentityCertInfo();
    assertSame(info1, info2);
  }

  @Test
  public void
      getAgentIdentityCertInfo_concurrentRotationUpdatedByAnotherThread_returnsFreshestCredential()
          throws Exception {
    setupValidAgentCredentialsInTempDir();
    FakeTimeService fakeTime = new FakeTimeService();
    AgentIdentityUtils.setTimeService(fakeTime);
    envProvider.setEnv("GOOGLE_API_CERTIFICATE_CONFIG", null);
    envProvider.setEnv("GOOGLE_API_USE_CLIENT_CERTIFICATE", null);

    Path certFile = tempDir.resolve("certificates.pem");
    Path keyFile = tempDir.resolve("private_key.pem");
    String basePem = new String(Files.readAllBytes(certFile), StandardCharsets.UTF_8);

    AgentIdentityUtils.CertInfo info1 = AgentIdentityUtils.getAgentIdentityCertInfo();
    assertNotNull(info1);

    // Delete certFile so Thread A enters the retry sleep loop
    Files.delete(certFile);

    AtomicReference<AgentIdentityUtils.CertInfo> concurrentRotatedInfo = new AtomicReference<>();
    fakeTime.setOnSleepCallback(
        () -> {
          if (concurrentRotatedInfo.get() == null) {
            try {
              // Simulate Thread B completing rotation and updating cachedCredentials while Thread A
              // sleeps
              String v2Pem = basePem + "\n# rotated-by-thread-B";
              Files.write(certFile, v2Pem.getBytes(StandardCharsets.UTF_8));
              AgentIdentityUtils.CertInfo rotated =
                  AgentIdentityUtils.loadAndVerifyCredentials(
                      certFile.toString(), keyFile.toString());
              concurrentRotatedInfo.set(rotated);
              // Delete certFile again so Thread A's own disk retries fail and must use cache
              // fallback
              Files.delete(certFile);
            } catch (IOException e) {
              throw new RuntimeException(e);
            }
          }
        });

    AgentIdentityUtils.CertInfo result = AgentIdentityUtils.getAgentIdentityCertInfo();
    assertNotNull(concurrentRotatedInfo.get());
    assertNotSame(info1, concurrentRotatedInfo.get());
    assertSame(concurrentRotatedInfo.get(), result);
  }

  @Test
  public void getAgentIdentityCertInfo_concurrentThreadsReadingAndRotating_noNpeOrRaceConditions()
      throws Exception {
    setupValidAgentCredentialsInTempDir();
    envProvider.setEnv("GOOGLE_API_CERTIFICATE_CONFIG", null);
    envProvider.setEnv("GOOGLE_API_USE_CLIENT_CERTIFICATE", null);

    Path certFile = tempDir.resolve("certificates.pem");
    Path keyFile = tempDir.resolve("private_key.pem");
    byte[] agentCertBytes = Files.readAllBytes(certFile);

    URL nonAgentUrl = getClass().getClassLoader().getResource("mtlsCertAndKey.pem");
    assertNotNull(nonAgentUrl);
    byte[] nonAgentBytes = Files.readAllBytes(Paths.get(nonAgentUrl.toURI()));

    // Prime initial cache
    assertNotNull(AgentIdentityUtils.getAgentIdentityCertInfo());

    int numThreads = 8;
    int iterations = 100;
    ExecutorService executor = Executors.newFixedThreadPool(numThreads + 1);
    try {
      List<Callable<Void>> tasks = new ArrayList<>();
      // Mutator thread rapidly alternates between agent cert, non-agent cert (keyMetadata == null),
      // and cache resets
      tasks.add(
          () -> {
            for (int i = 0; i < iterations; i++) {
              if (i % 3 == 0) {
                Files.write(certFile, nonAgentBytes);
                AgentIdentityUtils.loadAndVerifyCredentials(
                    certFile.toString(), keyFile.toString());
              } else if (i % 3 == 1) {
                Files.write(certFile, agentCertBytes);
                AgentIdentityUtils.loadAndVerifyCredentials(
                    certFile.toString(), keyFile.toString());
              } else {
                AgentIdentityUtils.clearCachedCredentials();
              }
            }
            Files.write(certFile, agentCertBytes);
            return null;
          });

      // Reader threads concurrently call getAgentIdentityCertInfo()
      for (int t = 0; t < numThreads; t++) {
        tasks.add(
            () -> {
              for (int i = 0; i < iterations; i++) {
                try {
                  AgentIdentityUtils.getAgentIdentityCertInfo();
                } catch (IOException ignored) {
                  // Expected if mutator wrote non-matching cert/key mid-read, but NPE must NEVER
                  // occur
                }
              }
              return null;
            });
      }

      List<Future<Void>> futures = executor.invokeAll(tasks);
      for (Future<Void> future : futures) {
        future.get(); // Re-throws any NullPointerException or RuntimeException
      }
    } finally {
      executor.shutdownNow();
    }
  }

  @Test
  public void getAgentIdentityCertInfo_steadyStateKeyMismatch_fallsBackToCache() throws Exception {
    setupValidAgentCredentialsInTempDir();
    FakeTimeService fakeTime = new FakeTimeService();
    AgentIdentityUtils.setTimeService(fakeTime);

    // 1. Initial call succeeds and populates cache
    AgentIdentityUtils.CertInfo initialInfo = AgentIdentityUtils.getAgentIdentityCertInfo();
    assertNotNull(initialInfo);

    // 2. Overwrite private_key.pem on disk with a mismatched key (and advance mtime so cache
    // invalidates)
    KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
    kpg.initialize(2048);
    PrivateKey mismatchedKey = kpg.generateKeyPair().getPrivate();
    String mismatchedKeyPem =
        "-----BEGIN PRIVATE KEY-----\n"
            + java.util.Base64.getEncoder().encodeToString(mismatchedKey.getEncoded())
            + "\n-----END PRIVATE KEY-----\n";
    Path keyPath = tempDir.resolve("private_key.pem");
    Files.write(keyPath, mismatchedKeyPem.getBytes(StandardCharsets.UTF_8));
    Files.setLastModifiedTime(
        keyPath, java.nio.file.attribute.FileTime.fromMillis(System.currentTimeMillis() + 10000));

    // 3. With steady-state cache populated, lastException is set on verifyKeyPair failure so it
    // falls back to cached credentials during rotation mismatch
    AgentIdentityUtils.CertInfo fallbackInfo = AgentIdentityUtils.getAgentIdentityCertInfo();
    assertSame(initialInfo, fallbackInfo);
  }

  @Test
  public void getAgentIdentityCertInfo_mtlsDisabledWithCertsPresent_logsAtMostOnce()
      throws Exception {
    setupValidAgentCredentialsInTempDir();
    envProvider.setEnv(AgentIdentityUtils.GOOGLE_API_USE_CLIENT_CERTIFICATE, "false");

    assertFalse(AgentIdentityUtils.isMtlsDisabledLogged());
    assertNull(AgentIdentityUtils.getAgentIdentityCertInfo());
    assertTrue(AgentIdentityUtils.isMtlsDisabledLogged());

    // Subsequent calls return null without re-triggering log message
    assertNull(AgentIdentityUtils.getAgentIdentityCertInfo());
    assertTrue(AgentIdentityUtils.isMtlsDisabledLogged());
  }

  private static class FakeTimeService implements AgentIdentityUtils.TimeService {
    private final AtomicLong currentTime = new AtomicLong(0);
    private final AtomicInteger sleepCount = new AtomicInteger(0);
    private Runnable onSleepCallback;

    void setOnSleepCallback(Runnable callback) {
      this.onSleepCallback = callback;
    }

    public long currentTimeMillis() {
      return currentTime.get();
    }

    @Override
    public void sleep(long millis) throws InterruptedException {
      sleepCount.incrementAndGet();
      currentTime.addAndGet(millis);
      if (onSleepCallback != null) {
        onSleepCallback.run();
      }
    }

    int getSleepCount() {
      return sleepCount.get();
    }
  }
}
