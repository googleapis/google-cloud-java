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

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.core.InternalApi;
import com.google.auth.http.HttpTransportFactory;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.Objects;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * An HttpTransportFactory that creates {@link NetHttpTransport} instances configured for mTLS
 * (mutual TLS) using a specific {@link KeyStore} containing the client's certificate and private
 * key.
 *
 * <p><b>Warning:</b> This class is considered internal and is not intended for direct use by
 * library consumers. Its API and behavior may change without notice.
 */
@NullMarked
@InternalApi
public class MtlsHttpTransportFactory implements HttpTransportFactory, java.io.Serializable {
  private static final long serialVersionUID = 1L;
  @Nullable private final transient KeyStore mtlsKeyStore;

  /**
   * No-arg constructor required for Java serialization. {@link IdentityPoolCredentials} stores this
   * factory in its serializable {@code transportFactory} field, and {@link
   * java.io.ObjectInputStream} needs a no-arg constructor to reconstruct it during deserialization.
   * Not intended for direct use; callers should use {@link #MtlsHttpTransportFactory(KeyStore)}.
   */
  public MtlsHttpTransportFactory() {
    this.mtlsKeyStore = null;
  }

  /**
   * Constructs a factory for mTLS transports.
   *
   * @param mtlsKeyStore The {@link KeyStore} containing the client's X509 certificate and private
   *     key. This {@link KeyStore} is used for client authentication during the TLS handshake. Must
   *     not be null.
   */
  public MtlsHttpTransportFactory(KeyStore mtlsKeyStore) {
    this.mtlsKeyStore = Objects.requireNonNull(mtlsKeyStore, "mtlsKeyStore cannot be null");
  }

  /**
   * Returns whether this factory was constructed with a non-null {@link KeyStore} containing client
   * certificates for mTLS. A factory created via the no-arg constructor (e.g. during
   * deserialization), with an empty KeyStore, or with a KeyStore containing only trusted CA
   * certificates (without a private key entry and certificate chain) will return {@code false}.
   */
  public boolean hasKeyStore() {
    if (this.mtlsKeyStore == null) {
      return false;
    }
    try {
      Enumeration<String> aliases = this.mtlsKeyStore.aliases();
      if (aliases == null) {
        return false;
      }
      while (aliases.hasMoreElements()) {
        String alias = aliases.nextElement();
        if (this.mtlsKeyStore.isKeyEntry(alias)) {
          Certificate[] chain = this.mtlsKeyStore.getCertificateChain(alias);
          if (chain != null && chain.length > 0) {
            return true;
          }
        }
      }
      return false;
    } catch (KeyStoreException e) {
      return false;
    }
  }

  @Override
  public NetHttpTransport create() {
    try {
      // Build the mTLS transport using the provided KeyStore.
      return new NetHttpTransport.Builder().trustCertificates(null, mtlsKeyStore, "").build();
    } catch (GeneralSecurityException e) {
      // Wrap the checked exception in a RuntimeException because the HttpTransportFactory
      // interface's create() method doesn't allow throwing checked exceptions.
      throw new RuntimeException("Failed to initialize mTLS transport.", e);
    }
  }
}
