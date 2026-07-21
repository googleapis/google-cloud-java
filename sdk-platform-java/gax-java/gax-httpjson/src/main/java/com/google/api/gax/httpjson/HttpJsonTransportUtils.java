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
package com.google.api.gax.httpjson;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.core.InternalApi;
import java.security.Provider;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.conscrypt.Conscrypt;

/**
 * Utility class for creating and configuring {@link NetHttpTransport} instances with Post-Quantum
 * Cryptography (PQC) Conscrypt support.
 */
@InternalApi
public class HttpJsonTransportUtils {

  private static final Logger LOG = Logger.getLogger(HttpJsonTransportUtils.class.getName());

  /**
   * Default TLS 1.3 Post-Quantum Cryptography (PQC) named groups configured when Conscrypt security
   * provider is present:
   *
   * <ul>
   *   <li>{@code X25519MLKEM768}: Primary preferred hybrid key exchange algorithm combining
   *       Curve25519 ECDHE with NIST FIPS 203 (ML-KEM-768 / Kyber768), selected as the primary
   *       group per Google Cloud PQC guidelines.
   *   <li>{@code SecP256r1MLKEM768}: Secondary preferred hybrid key exchange algorithm combining
   *       NIST P-256 (SecP256r1) with NIST FIPS 203 (ML-KEM-768) for environments requiring
   *       FIPS-compliant elliptic curves.
   *   <li>{@code X25519}: Classical non-quantum key exchange fallback to ensure compatibility with
   *       standard TLS 1.3 endpoints if ML-KEM is not negotiated.
   * </ul>
   */
  public static final String[] DEFAULT_PQC_GROUPS =
      new String[] {"X25519MLKEM768", "SecP256r1MLKEM768", "X25519"};

  /**
   * Lazy Initialization-on-Demand Holder Idiom (Singleton pattern).
   *
   * <p>This static nested class defers Conscrypt {@link Provider} creation until first access and
   * caches the resulting instance (or {@code null} if Conscrypt native JNI libraries fail to load).
   *
   * <p>Design rationale:
   *
   * <ul>
   *   <li><b>Thread Safety</b>: Leverages JVM class-loading guarantees to initialize the singleton
   *       thread-safely without requiring synchronized blocks or locks.
   *   <li><b>Performance</b>: Avoids re-instantiating {@code Conscrypt.newProvider()} JNI
   *       allocations on every transport creation.
   *   <li><b>Single Log Output</b>: If Conscrypt JNI is not available on the target architecture,
   *       the failure is logged at WARNING level exactly once during class initialization and
   *       caches {@code null}, preventing repeated JNI error logging on subsequent calls.
   * </ul>
   */
  private static class ConscryptProviderHolder {
    private static final Provider INSTANCE = createProvider();

    private static Provider createProvider() {
      try {
        return Conscrypt.newProvider();
      } catch (Throwable t) {
        LOG.log(
            Level.WARNING, "Conscrypt native libraries not available. Falling back to JDK TLS.", t);
        return null;
      }
    }
  }

  /**
   * Creates a {@link NetHttpTransport.Builder} pre-configured with Conscrypt security provider and
   * PQC named groups if Conscrypt is available.
   *
   * <p>Tradeoff Decision: We intentionally catch errors and gracefully fall back to JDK TLS or
   * Conscrypt defaults rather than failing fast. Because Conscrypt depends on native JNI libraries
   * that may not be available or compatible across all user environments (e.g. non-x86
   * architectures, musl libc, custom runtimes), failing fast would cause breaking outages for
   * existing customers upgrading the SDK. We accept the tradeoff of a potential silent fallback to
   * classical TLS (logged at WARNING level) in exchange for maintaining high availability and
   * backward compatibility across all client environments.
   */
  public static NetHttpTransport.Builder createPqcHttpTransportBuilder() {
    NetHttpTransport.Builder builder = new NetHttpTransport.Builder();
    Provider conscryptProvider = ConscryptProviderHolder.INSTANCE;
    if (conscryptProvider == null) {
      return builder;
    }
    return builder
        .setSecurityProvider(conscryptProvider)
        .setSslSocketConfigurator(
            socket -> {
              if (!Conscrypt.isConscrypt(socket)) {
                return;
              }
              try {
                Conscrypt.setNamedGroups(socket, DEFAULT_PQC_GROUPS);
              } catch (Throwable t) {
                LOG.log(
                    Level.WARNING,
                    "Failed to set PQC named groups on Conscrypt socket. Falling back to"
                        + " Conscrypt default TLS groups.",
                    t);
              }
            });
  }

  private HttpJsonTransportUtils() {}
}
