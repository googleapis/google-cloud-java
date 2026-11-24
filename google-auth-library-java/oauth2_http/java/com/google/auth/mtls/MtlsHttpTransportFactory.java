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
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.Objects;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * An HttpTransportFactory that lazily creates and caches a {@link NetHttpTransport} instance
 * configured for mTLS (mutual TLS) using a specific {@link KeyStore} containing the client's
 * certificate and private key.
 *
 * <p>Repeated {@link #create()} calls on the same factory instance reuse the same {@link
 * NetHttpTransport} so connections share the same {@link javax.net.ssl.SSLContext} and {@link
 * javax.net.ssl.SSLSocketFactory} for TLS session resumption and HTTP keep-alive reuse. Callers
 * rotating client certificates must construct a new {@link MtlsHttpTransportFactory} with the
 * updated {@link KeyStore}. The cached transport is {@code transient} and is lazily recreated after
 * deserialization.
 *
 * <p><b>Warning:</b> This class is considered internal and is not intended for direct use by
 * library consumers. Its API and behavior may change without notice.
 */
@NullMarked
@InternalApi
public class MtlsHttpTransportFactory implements HttpTransportFactory, Serializable {
  private static final long serialVersionUID = 1L;
  private final transient @Nullable KeyStore mtlsKeyStore;
  private final transient boolean hasKeyStore;
  private transient volatile Object transportLock = new Object();
  private transient volatile @Nullable NetHttpTransport cachedTransport;

  /**
   * Default no-arg constructor creating an instance without a KeyStore ({@code hasKeyStore() ==
   * false}). This constructor is invoked reflectively by {@code
   * ExternalAccountCredentials.readObject()} during deserialization (since {@code transportFactory}
   * is transient on {@code ExternalAccountCredentials}), after which {@code
   * IdentityPoolCredentials.readObject()} reconstructs {@code X509Provider} from the serialized
   * certificate configuration and replaces the transport factory with {@link
   * #MtlsHttpTransportFactory(KeyStore)}. Not intended for direct use; callers configuring mTLS
   * should use {@link #MtlsHttpTransportFactory(KeyStore)}.
   */
  public MtlsHttpTransportFactory() {
    this.mtlsKeyStore = null;
    this.hasKeyStore = false;
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
    this.hasKeyStore = checkHasKeyStore(this.mtlsKeyStore);
  }

  /**
   * Returns whether this factory was constructed with a non-null {@link KeyStore} containing client
   * certificates for mTLS. A factory created via the no-arg constructor (e.g. during
   * deserialization), with an empty KeyStore, or with a KeyStore containing only trusted CA
   * certificates (without a private key entry and certificate chain) will return {@code false}.
   */
  public boolean hasKeyStore() {
    return this.hasKeyStore;
  }

  /** Returns the {@link KeyStore} used by this factory, or {@code null} if none was configured. */
  public @Nullable KeyStore getKeyStore() {
    return this.mtlsKeyStore;
  }

  private static boolean checkHasKeyStore(@Nullable KeyStore keyStore) {
    if (keyStore == null) {
      return false;
    }
    try {
      Enumeration<String> aliases = keyStore.aliases();
      if (aliases == null) {
        return false;
      }
      while (aliases.hasMoreElements()) {
        String alias = aliases.nextElement();
        if (keyStore.isKeyEntry(alias)) {
          Certificate[] chain = keyStore.getCertificateChain(alias);
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

  /**
   * Returns the lazily initialized {@link NetHttpTransport} for this factory, creating it once on
   * first call and reusing the same immutable instance on subsequent calls.
   */
  @Override
  public NetHttpTransport create() {
    NetHttpTransport transport = cachedTransport;
    if (transport != null) {
      return transport;
    }
    synchronized (transportLock) {
      transport = cachedTransport;
      if (transport == null) {
        try {
          // Build the mTLS transport once per factory so repeated calls share the same
          // SSLContext and SSLSocketFactory for TLS session resumption and keep-alive reuse.
          transport =
              new NetHttpTransport.Builder().trustCertificates(null, mtlsKeyStore, "").build();
        } catch (GeneralSecurityException e) {
          // Wrap the checked exception in a RuntimeException because the HttpTransportFactory
          // interface's create() method doesn't allow throwing checked exceptions.
          throw new RuntimeException("Failed to initialize mTLS transport.", e);
        }
        cachedTransport = transport;
      }
    }
    return transport;
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    this.transportLock = new Object();
  }
}
