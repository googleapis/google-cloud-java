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

package com.google.api.gax.rpc.testing;

import com.google.api.client.util.SecurityUtils;
import com.google.api.core.InternalApi;
import com.google.auth.mtls.MtlsProvider;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;

@InternalApi("for testing")
public class FakeMtlsProvider implements MtlsProvider {
  private KeyStore keyStore;
  private boolean throwExceptionForGetKeyStore;

  public FakeMtlsProvider(
      KeyStore keystore, String keyStorePassword, boolean throwExceptionForGetKeyStore) {
    super();
    this.keyStore = keystore;
    this.throwExceptionForGetKeyStore = throwExceptionForGetKeyStore;
  }

  @Override
  public KeyStore getKeyStore() throws IOException {
    if (throwExceptionForGetKeyStore) {
      throw new IOException("getKeyStore throws exception");
    }
    return keyStore;
  }

  @Override
  public boolean isAvailable() throws IOException {
    return true;
  }

  public static KeyStore createTestMtlsKeyStore() throws IOException {
    try {
      InputStream certAndKey =
          FakeMtlsProvider.class
              .getClassLoader()
              .getResourceAsStream("com/google/api/gax/rpc/mtls/mtlsCertAndKey.pem");
      return SecurityUtils.createMtlsKeyStore(certAndKey);
    } catch (GeneralSecurityException e) {
      throw new IOException("Failed to create key store", e);
    }
  }
}
