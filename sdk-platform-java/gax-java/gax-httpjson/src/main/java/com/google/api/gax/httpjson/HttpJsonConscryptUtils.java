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

/** Utility class for creating and configuring {@link NetHttpTransport} instances. */
@InternalApi
public class HttpJsonConscryptUtils {

  private static final Logger LOG = Logger.getLogger(HttpJsonConscryptUtils.class.getName());

  /**
   * Default TLS 1.3 named groups configured when Conscrypt security provider is present, organized
   * in client preference order:
   *
   * <ol>
   *   <li><b>Standard ML-KEM algorithms</b>: Prioritized first for quantum resistance.
   *   <li><b>Draft Kyber algorithms</b>: Retained as a fallback for legacy draft PQC deployments.
   *   <li><b>Classical curves</b>: Fallback for endpoints without PQC support.
   * </ol>
   *
   * <p>In TLS 1.3, the client offers key exchange groups via the {@code supported_groups}
   * ClientHello extension in preference order. The server selects the first group it supports.
   *
   * <p>For details on Conscrypt's supported TLS algorithms, see <a
   * href="https://github.com/google/conscrypt/blob/2.6.0/CAPABILITIES.md">Conscrypt
   * CAPABILITIES.md</a>.
   */
  public static final String[] DEFAULT_CONSCRYPT_NAMED_GROUPS =
      new String[] {
        "X25519MLKEM768",
        "SecP256r1MLKEM768",
        "MLKEM1024",
        "MLKEM768",
        "X25519Kyber768Draft00",
        "X25519",
        "secp256r1",
        "secp384r1"
      };

  /**
   * Lazy initialization holder for Conscrypt {@link Provider}.
   *
   * <p>Caches the Conscrypt {@link Provider} instance (or {@code null} if initialization fails) to
   * avoid repeated expensive JNI initialization operations on every transport creation.
   *
   * <p>Returns {@code null} on failure so that transport creation can fall back to default JDK TLS,
   * ensuring that setting Conscrypt as the default security provider does not cause breaking
   * failures for customers running on environments where Conscrypt is unsupported or unavailable.
   */
  private static class ConscryptProviderHolder {
    private static final Provider INSTANCE = createProvider();

    private static Provider createProvider() {
      try {
        return Conscrypt.newProvider();
      } catch (SecurityException | LinkageError t) {
        LOG.log(
            Level.WARNING, "Conscrypt native libraries not available. Falling back to JDK TLS.", t);
        return null;
      }
    }
  }

  /**
   * Configures the given {@link NetHttpTransport.Builder} with Conscrypt as the security provider
   * by default if Conscrypt is available. Users can customize the {@link NetHttpTransport.Builder}
   * to use a different security provider.
   *
   * @param builder the {@link NetHttpTransport.Builder} to configure
   * @return the configured {@link NetHttpTransport.Builder}
   */
  public static NetHttpTransport.Builder configureConscryptSecurityProvider(
      NetHttpTransport.Builder builder) {
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
                Conscrypt.setNamedGroups(socket, DEFAULT_CONSCRYPT_NAMED_GROUPS);
              } catch (Exception e) {
                // Native JNI linkage errors (e.g. UnsatisfiedLinkError) are caught during
                // ConscryptProviderHolder initialization. Catching Exception here safely
                // intercepts runtime socket configuration errors (e.g. unsupported groups or
                // closed socket) without swallowing JVM errors like OutOfMemoryError.
                LOG.log(
                    Level.WARNING,
                    "Failed to set PQC named groups on Conscrypt socket. Falling back to Conscrypt"
                        + " default TLS groups.",
                    e);
              }
            });
  }

  /**
   * Returns the Conscrypt {@link Provider} instance, or {@code null} if Conscrypt is unavailable.
   *
   * @return the Conscrypt provider or null
   */
  static Provider getConscryptProvider() {
    return ConscryptProviderHolder.INSTANCE;
  }

  private HttpJsonConscryptUtils() {}
}
