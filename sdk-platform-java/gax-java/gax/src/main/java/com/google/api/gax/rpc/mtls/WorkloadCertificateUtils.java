/*
 * Copyright 2026 Google LLC
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
import com.google.auth.mtls.MtlsUtils;
import java.io.File;

/** Internal utility class for managing dynamic workload certificates. */
@InternalApi
public class WorkloadCertificateUtils {

  private static final String EMPTY_FILE_SHA256 =
      "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855";

  private WorkloadCertificateUtils() {}

  /**
   * Computes the SHA-256 fingerprint of the certificate file at {@code certPath}, returning {@code
   * ""} if the path is {@code null}, unreadable, empty (e.g., temporarily truncated to 0 bytes
   * mid-write by an external certificate rotator), or hashes to the empty-byte digest.
   *
   * <p>Returning {@code ""} on unreadable or empty files ensures callers ({@code shouldRefresh()}
   * and {@code refresh()}) safely skip refreshing during transient mid-write states rather than
   * treating an empty digest as a certificate rotation mismatch.
   */
  public static String getCertificateFingerprint(String certPath) {
    if (certPath == null || new File(certPath).length() == 0) {
      return "";
    }
    String fingerprint = MtlsUtils.getCertificateFingerprint(certPath);
    if (fingerprint == null || EMPTY_FILE_SHA256.equalsIgnoreCase(fingerprint)) {
      return "";
    }
    return fingerprint;
  }
}
