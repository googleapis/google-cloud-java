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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

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

  private CertificateBasedAccess createCba(TestEnv env) {
    return new CertificateBasedAccess(env::get);
  }

  @Test
  void testUseMtlsEndpointAlways() {
    TestEnv env = new TestEnv();
    env.set("GOOGLE_API_USE_MTLS_ENDPOINT", "always");
    CertificateBasedAccess cba = createCba(env);
    assertEquals(
        CertificateBasedAccess.MtlsEndpointUsagePolicy.ALWAYS, cba.getMtlsEndpointUsagePolicy());
  }

  @Test
  void testUseMtlsEndpointAuto() {
    TestEnv env = new TestEnv();
    env.set("GOOGLE_API_USE_MTLS_ENDPOINT", "auto");
    CertificateBasedAccess cba = createCba(env);
    assertEquals(
        CertificateBasedAccess.MtlsEndpointUsagePolicy.AUTO, cba.getMtlsEndpointUsagePolicy());
  }

  @Test
  void testUseMtlsEndpointNever() {
    TestEnv env = new TestEnv();
    env.set("GOOGLE_API_USE_MTLS_ENDPOINT", "never");
    CertificateBasedAccess cba = createCba(env);
    assertEquals(
        CertificateBasedAccess.MtlsEndpointUsagePolicy.NEVER, cba.getMtlsEndpointUsagePolicy());
  }

  @Test
  void testUseMtlsEndpointCaseInsensitive() {
    TestEnv env = new TestEnv();
    env.set("GOOGLE_API_USE_MTLS_ENDPOINT", "ALWAYS");
    CertificateBasedAccess cba = createCba(env);
    assertEquals(
        CertificateBasedAccess.MtlsEndpointUsagePolicy.ALWAYS, cba.getMtlsEndpointUsagePolicy());

    env.set("GOOGLE_API_USE_MTLS_ENDPOINT", "NEVER");
    assertEquals(
        CertificateBasedAccess.MtlsEndpointUsagePolicy.NEVER, cba.getMtlsEndpointUsagePolicy());
  }

  @Test
  void testUseMtlsClientCertificateExplicitTrueNoCredentials() {
    TestEnv env = new TestEnv();
    env.set("GOOGLE_API_USE_CLIENT_CERTIFICATE", "true");
    CertificateBasedAccess cba = createCba(env);
    // Explicit 'true' permits mTLS if certs exist, but if no certs are present, returns false/null cleanly (Row 3)
    assertFalse(cba.useMtlsClientCertificate());
    assertNull(cba.getWorkloadCertPath());
  }

  @Test
  void testUseMtlsClientCertificateExplicitFalse() {
    TestEnv env = new TestEnv();
    env.set("GOOGLE_API_USE_CLIENT_CERTIFICATE", "false");

    CertificateBasedAccess cba = createCba(env);
    assertFalse(cba.useMtlsClientCertificate());
    assertNull(cba.getWorkloadCertPath());
  }

  @Test
  void testUseMtlsClientCertificateUnsetNoFiles() {
    TestEnv env = new TestEnv();
    CertificateBasedAccess cba = createCba(env);
    assertFalse(cba.useMtlsClientCertificate());
    assertNull(cba.getWorkloadCertPath());
  }

  @Test
  void testUseMtlsClientCertificateConfigMissingConfigFile_returnsNullSafely() {
    TestEnv env = new TestEnv();
    env.set("GOOGLE_API_CERTIFICATE_CONFIG", "/nonexistent/config.json");

    CertificateBasedAccess cba = createCba(env);

    // Non-existent config file on disk returns false/null safely per Row 3
    assertFalse(cba.useMtlsClientCertificate());
    assertNull(cba.getWorkloadCertPath());
  }
}
