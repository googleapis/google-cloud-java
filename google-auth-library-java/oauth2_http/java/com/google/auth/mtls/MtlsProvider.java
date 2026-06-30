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

package com.google.auth.mtls;

import java.io.IOException;
import java.security.KeyStore;

/**
 * MtlsProvider is used by the Gax library for configuring mutual TLS in the HTTP and GRPC transport
 * layer. The source of the client certificate is up to the implementation.
 *
 * <p>Note: This interface will replace the identically named "MtlsProvider" implementation in the
 * Gax library. The Gax library version of MtlsProvider will be marked as deprecated. See
 * https://github.com/googleapis/google-auth-library-java/issues/1758
 */
public interface MtlsProvider {
  /**
   * Returns a mutual TLS key store.
   *
   * @return KeyStore for configuring mTLS.
   * @throws CertificateSourceUnavailableException if the certificate source is unavailable (ex.
   *     missing configuration file).
   * @throws IOException if a general I/O error occurs while creating the KeyStore
   */
  KeyStore getKeyStore() throws CertificateSourceUnavailableException, IOException;

  /**
   * Returns true if the underlying mTLS provider is available.
   *
   * @throws IOException if a general I/O error occurs while determining availability.
   */
  boolean isAvailable() throws IOException;
}
