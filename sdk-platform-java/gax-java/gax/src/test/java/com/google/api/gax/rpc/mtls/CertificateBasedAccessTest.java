/*
 * Copyright 2021 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
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

package com.google.api.gax.rpc.mtls;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class CertificateBasedAccessTest {

  private static class TestEnv {
    private final Map<String, String> env = new HashMap<>();
    
    void set(String key, String val) {
      env.put(key, val);
    }
    
    String get(String name) {
      return env.get(name);
    }
  }

  private static class TestFileSystem {
    private final Map<String, Boolean> exists = new HashMap<>();
    private final Map<String, String> content = new HashMap<>();

    void setExists(String path, boolean val) {
      exists.put(path, val);
    }

    void setContent(String path, String val) {
      content.put(path, val);
      exists.put(path, true);
    }
  }

  private CertificateBasedAccess createCba(TestEnv env, TestFileSystem fs) {
    return new CertificateBasedAccess(
        env::get,
        path -> fs.exists.getOrDefault(path, false),
        path -> {
          if (!fs.content.containsKey(path)) {
            throw new IOException("File not found: " + path);
          }
          return fs.content.get(path);
        }
    );
  }

  @Test
  void testUseMtlsEndpointAlways() {
    TestEnv env = new TestEnv();
    env.set("GOOGLE_API_USE_MTLS_ENDPOINT", "always");
    CertificateBasedAccess cba = createCba(env, new TestFileSystem());
    assertEquals(
        CertificateBasedAccess.MtlsEndpointUsagePolicy.ALWAYS, cba.getMtlsEndpointUsagePolicy());
  }

  @Test
  void testUseMtlsEndpointAuto() {
    TestEnv env = new TestEnv();
    env.set("GOOGLE_API_USE_MTLS_ENDPOINT", "auto");
    CertificateBasedAccess cba = createCba(env, new TestFileSystem());
    assertEquals(
        CertificateBasedAccess.MtlsEndpointUsagePolicy.AUTO, cba.getMtlsEndpointUsagePolicy());
  }

  @Test
  void testUseMtlsEndpointNever() {
    TestEnv env = new TestEnv();
    env.set("GOOGLE_API_USE_MTLS_ENDPOINT", "never");
    CertificateBasedAccess cba = createCba(env, new TestFileSystem());
    assertEquals(
        CertificateBasedAccess.MtlsEndpointUsagePolicy.NEVER, cba.getMtlsEndpointUsagePolicy());
  }

  @Test
  void testUseMtlsClientCertificateExplicitTrueNoCredentials() {
    TestEnv env = new TestEnv();
    env.set("GOOGLE_API_USE_CLIENT_CERTIFICATE", "true");
    CertificateBasedAccess cba = createCba(env, new TestFileSystem());
    // Explicit 'true' requires credentials to be present on disk, otherwise falls back to false
    assertFalse(cba.useMtlsClientCertificate());
  }

  @Test
  void testUseMtlsClientCertificateExplicitTrueWithSpiffeBundle() {
    TestEnv env = new TestEnv();
    env.set("GOOGLE_API_USE_CLIENT_CERTIFICATE", "true");
    
    TestFileSystem fs = new TestFileSystem();
    fs.setExists("/var/run/secrets/workload-spiffe-credentials/credentialbundle.pem", true);
    
    CertificateBasedAccess cba = createCba(env, fs);
    assertTrue(cba.useMtlsClientCertificate());
  }

  @Test
  void testUseMtlsClientCertificateExplicitFalseWithSpiffeBundle() {
    TestEnv env = new TestEnv();
    env.set("GOOGLE_API_USE_CLIENT_CERTIFICATE", "false");
    
    // Even if spiffe files are present, explicit false must override and disable mtls
    TestFileSystem fs = new TestFileSystem();
    fs.setExists("/var/run/secrets/workload-spiffe-credentials/credentialbundle.pem", true);
    
    CertificateBasedAccess cba = createCba(env, fs);
    assertFalse(cba.useMtlsClientCertificate());
  }

  @Test
  void testUseMtlsClientCertificateUnsetNoFiles() {
    TestEnv env = new TestEnv();
    CertificateBasedAccess cba = createCba(env, new TestFileSystem());
    assertFalse(cba.useMtlsClientCertificate());
  }

  @Test
  void testUseMtlsClientCertificateUnsetSpiffeBundleExists() {
    TestEnv env = new TestEnv();
    TestFileSystem fs = new TestFileSystem();
    fs.setExists("/var/run/secrets/workload-spiffe-credentials/credentialbundle.pem", true);
    CertificateBasedAccess cba = createCba(env, fs);
    assertTrue(cba.useMtlsClientCertificate());
  }

  @Test
  void testUseMtlsClientCertificateUnsetSpiffeSeparateFilesExist() {
    TestEnv env = new TestEnv();
    TestFileSystem fs = new TestFileSystem();
    fs.setExists("/var/run/secrets/workload-spiffe-credentials/certificates.pem", true);
    fs.setExists("/var/run/secrets/workload-spiffe-credentials/private_key.pem", true);
    CertificateBasedAccess cba = createCba(env, fs);
    assertTrue(cba.useMtlsClientCertificate());
  }

  @Test
  void testUseMtlsClientCertificateConfigValid() {
    TestEnv env = new TestEnv();
    env.set("GOOGLE_API_CERTIFICATE_CONFIG", "/path/to/config.json");

    TestFileSystem fs = new TestFileSystem();
    fs.setContent("/path/to/config.json", "{\n  \"cert_path\": \"/my/cert.pem\",\n  \"key_path\": \"/my/key.pem\"\n}");
    fs.setExists("/my/cert.pem", true);
    fs.setExists("/my/key.pem", true);

    CertificateBasedAccess cba = createCba(env, fs);
    assertTrue(cba.useMtlsClientCertificate());
  }

  @Test
  void testUseMtlsClientCertificateConfigMissingFile() {
    TestEnv env = new TestEnv();
    env.set("GOOGLE_API_CERTIFICATE_CONFIG", "/path/to/config.json");

    CertificateBasedAccess cba = createCba(env, new TestFileSystem());
    
    IllegalStateException ex = assertThrows(IllegalStateException.class, cba::useMtlsClientCertificate);
    assertTrue(ex.getMessage().contains("configured but the file does not exist"));
  }

  @Test
  void testUseMtlsClientCertificateConfigMalformedJson() {
    TestEnv env = new TestEnv();
    env.set("GOOGLE_API_CERTIFICATE_CONFIG", "/path/to/config.json");

    TestFileSystem fs = new TestFileSystem();
    fs.setContent("/path/to/config.json", "{\n  \"broken_path\": \"/my/cert.pem\"\n}");

    CertificateBasedAccess cba = createCba(env, fs);
    
    IllegalStateException ex = assertThrows(IllegalStateException.class, cba::useMtlsClientCertificate);
    assertTrue(ex.getMessage().contains("Failed to parse or validate certificate config"));
  }

  @Test
  void testUseMtlsClientCertificateConfigMissingCertFiles() {
    TestEnv env = new TestEnv();
    env.set("GOOGLE_API_CERTIFICATE_CONFIG", "/path/to/config.json");

    TestFileSystem fs = new TestFileSystem();
    fs.setContent("/path/to/config.json", "{\n  \"cert_path\": \"/my/cert.pem\",\n  \"key_path\": \"/my/key.pem\"\n}");
    // my/cert.pem and key.pem DO NOT exist

    CertificateBasedAccess cba = createCba(env, fs);
    
    IllegalStateException ex = assertThrows(IllegalStateException.class, cba::useMtlsClientCertificate);
    assertTrue(ex.getMessage().contains("points to certificate/key files that do not exist on disk"));
  }
}
