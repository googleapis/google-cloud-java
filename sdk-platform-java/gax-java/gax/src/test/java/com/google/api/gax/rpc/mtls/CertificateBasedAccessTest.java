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

import org.junit.jupiter.api.Test;

class CertificateBasedAccessTest {

  @Test
  void testUseMtlsEndpointAlways() {
    CertificateBasedAccess cba =
        new CertificateBasedAccess(
            name -> name.equals("GOOGLE_API_USE_MTLS_ENDPOINT") ? "always" : "false");
    assertEquals(
        CertificateBasedAccess.MtlsEndpointUsagePolicy.ALWAYS, cba.getMtlsEndpointUsagePolicy());
  }

  @Test
  void testUseMtlsEndpointAuto() {
    CertificateBasedAccess cba =
        new CertificateBasedAccess(
            name -> name.equals("GOOGLE_API_USE_MTLS_ENDPOINT") ? "auto" : "false");
    assertEquals(
        CertificateBasedAccess.MtlsEndpointUsagePolicy.AUTO, cba.getMtlsEndpointUsagePolicy());
  }

  @Test
  void testUseMtlsEndpointNever() {
    CertificateBasedAccess cba =
        new CertificateBasedAccess(
            name -> name.equals("GOOGLE_API_USE_MTLS_ENDPOINT") ? "never" : "false");
    assertEquals(
        CertificateBasedAccess.MtlsEndpointUsagePolicy.NEVER, cba.getMtlsEndpointUsagePolicy());
  }

  @Test
  void testUseMtlsClientCertificateTrue() {
    CertificateBasedAccess cba =
        new CertificateBasedAccess(
            name -> name.equals("GOOGLE_API_USE_CLIENT_CERTIFICATE") ? "true" : "auto");
    assertTrue(cba.useMtlsClientCertificate());
  }

  @Test
  void testUseMtlsClientCertificateFalse() {
    CertificateBasedAccess cba =
        new CertificateBasedAccess(
            name -> name.equals("GOOGLE_API_USE_CLIENT_CERTIFICATE") ? "false" : "auto");
    assertFalse(cba.useMtlsClientCertificate());
  }
}
