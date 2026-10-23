/*
 * Copyright 2026, Google Inc. All rights reserved.
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
package com.google.auth.oauth2;

import com.google.common.collect.ImmutableList;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.security.spec.X509EncodedKeySpec;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Utility class for parsing, validating, and verifying X.509 certificates, SPIFFE IDs, and PKCS#8
 * private keys for Agent Identity token binding.
 */
@NullMarked
final class AgentIdentityCertificateValidationUtils {

  private static final LoggerProvider LOGGER_PROVIDER =
      LoggerProvider.forClazz(AgentIdentityCertificateValidationUtils.class);

  // Allowed SPIFFE trust domain patterns for agentic identities.
  private static final List<Pattern> AGENT_IDENTITY_SPIFFE_PATTERNS =
      ImmutableList.of(
          Pattern.compile("^agents\\.global\\.org-\\d+\\.system\\.id\\.goog$"),
          Pattern.compile("^agents\\.global\\.proj-\\d+\\.system\\.id\\.goog$"),
          Pattern.compile("^agents-nonprod\\.global\\.org-\\d+\\.system\\.id\\.goog$"),
          Pattern.compile("^agents-nonprod\\.global\\.proj-\\d+\\.system\\.id\\.goog$"));

  // Subject Alternative Name (SAN) type for URI as defined in RFC 5280 Section 4.2.1.6.
  private static final int SAN_URI_TYPE = 6;

  private static final String SPIFFE_SCHEME_PREFIX = "spiffe://";

  private static final byte[] VERIFICATION_DATA =
      "verification-data".getBytes(StandardCharsets.UTF_8);

  private AgentIdentityCertificateValidationUtils() {}

  /** Thrown for key algorithms that can never be verified, so callers fail without retrying. */
  static final class UnsupportedKeyAlgorithmException extends IOException {
    private static final long serialVersionUID = 1L;

    UnsupportedKeyAlgorithmException(final @Nullable String algorithm) {
      super("Unsupported key algorithm: " + algorithm);
    }
  }

  /**
   * Thrown when a certificate PEM block contains malformed X.509 data, so callers fail fast without
   * retrying.
   */
  static final class InvalidCertificateException extends IOException {
    private static final long serialVersionUID = 1L;

    InvalidCertificateException(final String message, final Throwable cause) {
      super(message, cause);
    }
  }

  /**
   * Reads the full certificate chain from the specified path as a PEM string.
   *
   * <p>Extracts only the {@code -----BEGIN CERTIFICATE-----} blocks using {@link
   * OAuth2Utils#PEM_CERT_PATTERN}, stripping any private keys or non-certificate data that may be
   * present in a combined bundle file.
   */
  static String readCertificateChain(final String certPath) throws IOException {
    byte[] certData = Files.readAllBytes(Paths.get(certPath));
    String content = new String(certData, StandardCharsets.UTF_8);
    Matcher matcher = OAuth2Utils.PEM_CERT_PATTERN.matcher(content);
    StringBuilder certChain = new StringBuilder();
    while (matcher.find()) {
      certChain.append(matcher.group(0)).append("\n");
    }
    if (certChain.length() == 0) {
      throw new IOException("No PEM certificates found in certificate file: " + certPath);
    }
    return certChain.toString();
  }

  /** Parses the X509 certificate from the specified content string. */
  static X509Certificate parseCertificateContent(final String certContent) throws IOException {
    try (InputStream stream =
        new ByteArrayInputStream(certContent.getBytes(StandardCharsets.UTF_8))) {
      CertificateFactory cf = CertificateFactory.getInstance("X.509");
      return (X509Certificate) cf.generateCertificate(stream);
    } catch (GeneralSecurityException e) {
      throw new InvalidCertificateException(
          "Failed to parse Agent Identity certificate for bound token request.", e);
    }
  }

  /** Reads the private key from the specified path using PKCS8 format. */
  static PrivateKey readPrivateKey(final String keyPath, final @Nullable String algorithm)
      throws IOException {
    String keyPem = new String(Files.readAllBytes(Paths.get(keyPath)), StandardCharsets.UTF_8);
    OAuth2Utils.Pkcs8Algorithm pkcs8Alg;
    if ("EC".equals(algorithm) || "ECDSA".equals(algorithm)) {
      pkcs8Alg = OAuth2Utils.Pkcs8Algorithm.EC;
    } else if ("RSA".equals(algorithm)) {
      pkcs8Alg = OAuth2Utils.Pkcs8Algorithm.RSA;
    } else {
      throw new UnsupportedKeyAlgorithmException(algorithm);
    }
    return OAuth2Utils.privateKeyFromPkcs8(keyPem, pkcs8Alg);
  }

  /**
   * Verifies that the private key corresponds to the public key in the certificate by performing a
   * test signature and verification.
   */
  static boolean verifyKeyPair(final X509Certificate cert, final PrivateKey privateKey)
      throws UnsupportedKeyAlgorithmException {
    PublicKey publicKey = cert.getPublicKey();
    String keyAlgorithm = publicKey.getAlgorithm();
    String sigAlg;
    if ("RSA".equals(keyAlgorithm)) {
      sigAlg = "SHA256withRSA";
    } else if ("EC".equals(keyAlgorithm) || "ECDSA".equals(keyAlgorithm)) {
      sigAlg = "SHA256withECDSA";
    } else {
      throw new UnsupportedKeyAlgorithmException(keyAlgorithm);
    }

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

      return verifier.verify(signature);
    } catch (Exception e) {
      LoggingUtils.log(
          LOGGER_PROVIDER,
          Level.FINE,
          Collections.emptyMap(),
          "Key pair verification failed: " + e.getMessage());
      return false;
    }
  }

  /**
   * Determines if a bound token should be requested by checking if any of the certificate's Subject
   * Alternative Names (SANs) match allowed SPIFFE patterns.
   */
  static boolean shouldRequestBoundToken(final X509Certificate cert) {
    Collection<List<?>> sans;
    try {
      sans = cert.getSubjectAlternativeNames();
    } catch (CertificateParsingException e) {
      LoggingUtils.log(
          LOGGER_PROVIDER,
          Level.FINE,
          Collections.emptyMap(),
          "Failed to parse Subject Alternative Names from certificate: " + e.getMessage());
      return false;
    }
    if (sans == null) {
      return false;
    }
    // Iterate through all Subject Alternative Names
    for (List<?> san : sans) {
      // Check if the SAN entry is a URI (type 6) with a String value
      if (san.size() < 2
          || !(san.get(0) instanceof Integer)
          || (Integer) san.get(0) != SAN_URI_TYPE
          || !(san.get(1) instanceof String)) {
        continue;
      }
      String uri = ((String) san.get(1)).toLowerCase(Locale.US);
      // Check if the URI starts with "spiffe://"
      if (!uri.startsWith(SPIFFE_SCHEME_PREFIX)) {
        continue;
      }
      String withoutScheme = uri.substring(SPIFFE_SCHEME_PREFIX.length());
      int slashIndex = withoutScheme.indexOf('/');
      // Extract the trust domain (part before the first slash)
      String trustDomain =
          (slashIndex == -1) ? withoutScheme : withoutScheme.substring(0, slashIndex);
      // Match the trust domain against allowed agent patterns
      for (Pattern pattern : AGENT_IDENTITY_SPIFFE_PATTERNS) {
        if (pattern.matcher(trustDomain).matches()) {
          return true;
        }
      }
    }
    return false;
  }
}
