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
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jspecify.annotations.NullMarked;

/**
 * Builds the mTLS {@link KeyStore} from PEM-encoded certificates and a private key.
 *
 * <p>This replaces {@code com.google.api.client.util.SecurityUtils#createMtlsKeyStore}, which keeps
 * only the first certificate. Here the key entry holds every distinct certificate in the input, so
 * the intermediate certificates are presented too. Some peers (for example, another workload that
 * trusts only a root CA) need them to verify the client certificate. Because every certificate in
 * the input is sent in the TLS handshake, the input should hold only the leaf certificate and its
 * intermediates.
 *
 * <p>Everything else matches the upstream method: key store type (JKS), alias, empty password,
 * accepted key format (PKCS#8 {@code PRIVATE KEY}), which private key is chosen, and error
 * messages. Any input that the upstream method accepted is still accepted, even though more of it
 * is now used: once a certificate and a private key have been found (the point where the upstream
 * method stopped reading), a malformed later PEM section ends the input instead of failing, and an
 * extra certificate that cannot be parsed is left out of the chain. Unlike the upstream method, the
 * input is decoded as UTF-8 rather than the platform default charset, and it is read to the end.
 */
@NullMarked
final class MtlsKeyStoreUtils {

  private static final Logger LOGGER = Logger.getLogger(MtlsKeyStoreUtils.class.getName());

  private static final byte[] VERIFICATION_DATA =
      "verification-data".getBytes(StandardCharsets.UTF_8);

  private MtlsKeyStoreUtils() {}

  /**
   * Creates a key store holding one private key entry.
   *
   * @param certAndKey PEM input containing one or more {@code CERTIFICATE} sections and a PKCS#8
   *     {@code PRIVATE KEY} section, in any order. The first certificate must be the one that
   *     matches the private key (the leaf); the remaining distinct certificates are kept in input
   *     order as the rest of the chain. If there are several private keys, the one used is the same
   *     as upstream: the last one before the first certificate, or else the first one after it. The
   *     stream is read to the end and is not closed.
   * @throws IllegalArgumentException if the input has no certificate or no private key, or if a PEM
   *     section before both a certificate and a private key have been read is malformed
   * @throws GeneralSecurityException if the first certificate or the private key cannot be parsed,
   *     if the private key does not match the leaf certificate's public key, or if the key store
   *     cannot be created
   * @throws IOException if the input cannot be read
   */
  static KeyStore createMtlsKeyStore(InputStream certAndKey)
      throws GeneralSecurityException, IOException {
    List<byte[]> certificates = new ArrayList<>();
    byte[] privateKey = null;
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
        byte[] certBytes = section.getBase64DecodedBytes();
        if (!containsCertificate(certificates, certBytes)) {
          certificates.add(certBytes);
        }
      } else if ("PRIVATE KEY".equals(section.getTitle())
          && (privateKey == null || certificates.isEmpty())) {
        // Same choice as upstream: a later key replaces an earlier one until the first certificate
        // has been seen.
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
      } catch (CertificateException | RuntimeException e) {
        // The upstream method never parsed extra certificates; leave this one out rather than
        // fail.
        LOGGER.log(Level.FINE, "Skipping unparsable extra certificate in mTLS chain", e);
      }
    }
    X509Certificate leaf = chain.get(0);
    PrivateKey key =
        KeyFactory.getInstance(leaf.getPublicKey().getAlgorithm())
            .generatePrivate(new PKCS8EncodedKeySpec(privateKey));
    verifyKeyPair(leaf, key);

    KeyStore keyStore = KeyStore.getInstance("JKS");
    keyStore.load(null);
    keyStore.setKeyEntry("alias", key, new char[] {}, chain.toArray(new X509Certificate[0]));
    return keyStore;
  }

  /**
   * Verifies that {@code privateKey} corresponds to the public key in {@code cert} by performing a
   * test signature and verification.
   */
  private static void verifyKeyPair(X509Certificate cert, PrivateKey privateKey)
      throws GeneralSecurityException {
    PublicKey publicKey = cert.getPublicKey();
    String keyAlgorithm = publicKey.getAlgorithm();
    String sigAlg;
    if ("RSA".equals(keyAlgorithm)) {
      sigAlg = "SHA256withRSA";
    } else if ("EC".equals(keyAlgorithm) || "ECDSA".equals(keyAlgorithm)) {
      sigAlg = "SHA256withECDSA";
    } else {
      return;
    }

    boolean matches = false;
    GeneralSecurityException failureCause = null;
    try {
      if ("ECDSA".equals(keyAlgorithm) && publicKey.getEncoded() != null) {
        // SunEC rejects keys whose algorithm is "ECDSA" rather than "EC"; normalize the key.
        publicKey =
            KeyFactory.getInstance("EC")
                .generatePublic(new X509EncodedKeySpec(publicKey.getEncoded()));
      }

      Signature signer = Signature.getInstance(sigAlg);
      signer.initSign(privateKey);
      signer.update(VERIFICATION_DATA);
      byte[] signature = signer.sign();

      Signature verifier = Signature.getInstance(sigAlg);
      verifier.initVerify(publicKey);
      verifier.update(VERIFICATION_DATA);

      matches = verifier.verify(signature);
    } catch (GeneralSecurityException e) {
      failureCause = e;
    }

    if (!matches) {
      throw new GeneralSecurityException("Certificate and private key do not match", failureCause);
    }
  }

  private static boolean containsCertificate(List<byte[]> certificates, byte[] candidate) {
    for (byte[] existing : certificates) {
      if (Arrays.equals(existing, candidate)) {
        return true;
      }
    }
    return false;
  }

  private static X509Certificate parseCertificate(CertificateFactory certFactory, byte[] der)
      throws CertificateException {
    Certificate cert = certFactory.generateCertificate(new ByteArrayInputStream(der));
    if (cert == null) {
      throw new CertificateException("Empty certificate");
    }
    return (X509Certificate) cert;
  }
}
