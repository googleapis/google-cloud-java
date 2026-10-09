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

package com.google.auth.mtls;

import com.google.api.client.util.PemReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Builds the mTLS {@link KeyStore} from PEM-encoded certificates and a private key.
 *
 * <p>This is a drop-in replacement for {@code
 * com.google.api.client.util.SecurityUtils#createMtlsKeyStore}: same key store type, alias,
 * password, accepted key format, and error messages. The difference is that the key entry holds
 * every certificate in the input, not just the first one. Some peers (for example, another workload
 * that trusts only a root CA) need the intermediate certificates to verify the client certificate.
 *
 * <p>Because more of the input is now used, any input that the upstream method accepted is still
 * accepted: once a certificate and a private key have been found, a malformed later PEM section
 * ends the input instead of failing, and a later certificate that cannot be parsed is left out of
 * the chain.
 */
@NullMarked
final class MtlsKeyStoreUtils {

  private MtlsKeyStoreUtils() {}

  /**
   * Creates a key store holding one private key entry.
   *
   * @param certAndKey PEM input containing one or more {@code CERTIFICATE} sections and a PKCS#8
   *     {@code PRIVATE KEY} section, in any order. The first certificate must be the one that
   *     matches the private key (the leaf); the remaining certificates are kept in input order as
   *     the rest of the chain. If there are several private keys, the first one is used. The stream
   *     is read to the end and is not closed.
   * @throws IllegalArgumentException if the input has no certificate or no private key
   * @throws GeneralSecurityException if the first certificate or the private key cannot be parsed
   * @throws IOException if the input cannot be read
   */
  static KeyStore createMtlsKeyStore(InputStream certAndKey)
      throws GeneralSecurityException, IOException {
    List<byte[]> certificates = new ArrayList<>();
    byte @Nullable [] privateKey = null;
    PemReader reader = new PemReader(new InputStreamReader(certAndKey, StandardCharsets.UTF_8));
    while (true) {
      PemReader.Section section;
      try {
        section = reader.readNextSection();
      } catch (IllegalArgumentException e) {
        if (!certificates.isEmpty() && privateKey != null) {
          // Malformed trailing content after a usable certificate and key: stop here, as the
          // upstream method (which stopped reading at this point) would have.
          break;
        }
        throw e;
      }
      if (section == null) {
        break;
      }
      if ("CERTIFICATE".equals(section.getTitle())) {
        certificates.add(section.getBase64DecodedBytes());
      } else if (privateKey == null && "PRIVATE KEY".equals(section.getTitle())) {
        privateKey = section.getBase64DecodedBytes();
      }
    }
    if (certificates.isEmpty()) {
      throw new IllegalArgumentException("certificate is missing from certAndKey string");
    }
    if (privateKey == null) {
      throw new IllegalArgumentException("private key is missing from certAndKey string");
    }

    CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
    List<X509Certificate> chain = new ArrayList<>(certificates.size());
    chain.add(parseCertificate(certFactory, certificates.get(0)));
    for (int i = 1; i < certificates.size(); i++) {
      try {
        chain.add(parseCertificate(certFactory, certificates.get(i)));
      } catch (CertificateException e) {
        // The upstream method never parsed extra certificates; leave this one out rather than
        // fail.
      }
    }
    PrivateKey key =
        KeyFactory.getInstance(chain.get(0).getPublicKey().getAlgorithm())
            .generatePrivate(new PKCS8EncodedKeySpec(privateKey));

    KeyStore keyStore = KeyStore.getInstance("JKS");
    keyStore.load(null);
    keyStore.setKeyEntry("alias", key, new char[] {}, chain.toArray(new X509Certificate[0]));
    return keyStore;
  }

  private static X509Certificate parseCertificate(CertificateFactory certFactory, byte[] der)
      throws CertificateException {
    return (X509Certificate) certFactory.generateCertificate(new ByteArrayInputStream(der));
  }
}
