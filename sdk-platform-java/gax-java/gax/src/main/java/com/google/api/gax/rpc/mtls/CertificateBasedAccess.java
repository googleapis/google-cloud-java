/*
 * Copyright 2025 Google LLC
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

import com.google.api.core.InternalApi;
import com.google.api.gax.rpc.internal.EnvironmentProvider;

/**
 * Utility class for handling certificate-based access configurations.
 *
 * <p>This class handles the processing of GOOGLE_API_USE_CLIENT_CERTIFICATE and
 * GOOGLE_API_USE_MTLS_ENDPOINT environment variables according to https://google.aip.dev/auth/4114
 */
@InternalApi
public class CertificateBasedAccess {

  private final EnvironmentProvider envProvider;

  /** The EnvironmentProvider mechanism supports env var injection for unit tests. */
  public CertificateBasedAccess(EnvironmentProvider envProvider) {
    this.envProvider = envProvider;
  }

  public static CertificateBasedAccess createWithSystemEnv() {
    return new CertificateBasedAccess(System::getenv);
  }

  /**
   * The policy for mutual TLS endpoint usage. NEVER means always use regular endpoint; ALWAYS means
   * always use mTLS endpoint; AUTO means auto switch to mTLS endpoint if client certificate exists
   * and should be used.
   */
  public enum MtlsEndpointUsagePolicy {
    NEVER,
    AUTO,
    ALWAYS;
  }

  /** Returns if mutual TLS client certificate should be used. */
  public boolean useMtlsClientCertificate() {
    String useClientCertificate = envProvider.getenv("GOOGLE_API_USE_CLIENT_CERTIFICATE");
    return "true".equals(useClientCertificate);
  }

  /** Returns the current mutual TLS endpoint usage policy. */
  public MtlsEndpointUsagePolicy getMtlsEndpointUsagePolicy() {
    String mtlsEndpointUsagePolicy = envProvider.getenv("GOOGLE_API_USE_MTLS_ENDPOINT");
    if ("never".equals(mtlsEndpointUsagePolicy)) {
      return MtlsEndpointUsagePolicy.NEVER;
    } else if ("always".equals(mtlsEndpointUsagePolicy)) {
      return MtlsEndpointUsagePolicy.ALWAYS;
    }
    return MtlsEndpointUsagePolicy.AUTO;
  }
}
