/*
 * Copyright 2025 Google LLC
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
 *    * Neither the name of Google LLC nor the names of its
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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Provider for retrieving the subject tokens for {@link IdentityPoolCredentials} by reading an
 * X.509 certificate from the filesystem. The certificate file (e.g., PEM or DER encoded) is read,
 * the leaf certificate is base64-encoded (DER format), wrapped in a JSON array, and used as the
 * subject token for STS exchange.
 */
public class CertificateIdentityPoolSubjectTokenSupplier
    implements IdentityPoolSubjectTokenSupplier {

  private final IdentityPoolCredentialSource credentialSource;

  private static final Pattern PEM_CERT_PATTERN =
      Pattern.compile("-----BEGIN CERTIFICATE-----.*?-----END CERTIFICATE-----", Pattern.DOTALL);

  CertificateIdentityPoolSubjectTokenSupplier(IdentityPoolCredentialSource credentialSource) {
    this.credentialSource = checkNotNull(credentialSource, "credentialSource cannot be null");
    // This check ensures that the credential source was intended for certificate usage.
    // IdentityPoolCredentials logic should guarantee credentialLocation is set in this case.
    checkNotNull(
        credentialSource.getCertificateConfig(),
        "credentialSource.certificateConfig cannot be null when creating"
            + " CertificateIdentityPoolSubjectTokenSupplier");
  }

  private static String loadAndEncodeLeafCertificate(String path) throws IOException {
    try {
      byte[] leafCertBytes = Files.readAllBytes(Paths.get(path));
      X509Certificate leafCert = parseCertificate(leafCertBytes);
      return encodeCert(leafCert);
    } catch (NoSuchFileException e) {
      throw new IOException(String.format("Leaf certificate file not found: %s", path), e);
    } catch (CertificateException e) {
      throw new IOException(
          String.format("Failed to parse leaf certificate from file: %s", path), e);
    } catch (IOException e) {
      // This catches any other general I/O errors during leaf certificate file reading (e.g.,
      // permissions).
      throw new IOException(String.format("Failed to read leaf certificate file: %s", path), e);
    }
  }

  @VisibleForTesting
  static X509Certificate parseCertificate(byte[] certData) throws CertificateException {
    if (certData == null || certData.length == 0) {
      throw new IllegalArgumentException(
          "Invalid certificate data: Certificate file is empty or null.");
    }

    try {
      CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
      InputStream certificateStream = new ByteArrayInputStream(certData);
      return (X509Certificate) certificateFactory.generateCertificate(certificateStream);
    } catch (CertificateException e) {
      // Catch the original exception to add context about the operation being performed.
      // This helps pinpoint the failure point during debugging.
      throw new CertificateException("Failed to parse X.509 certificate data.", e);
    }
  }

  private static String encodeCert(X509Certificate certificate)
      throws CertificateEncodingException {
    return Base64.getEncoder().encodeToString(certificate.getEncoded());
  }

  /**
   * Retrieves the X509 subject token. This method loads the leaf certificate specified by the
   * {@code credentialSource.credentialLocation}. If a trust chain path is configured in the {@code
   * credentialSource.certificateConfig}, it also loads and includes the trust chain certificates.
   * The subject token is constructed as a JSON array containing the base64-encoded (DER format)
   * leaf certificate, followed by the base64-encoded (DER format) certificates in the trust chain.
   * This JSON array serves as the subject token for mTLS authentication.
   *
   * @param context The external account supplier context. This parameter is currently not used in
   *     this implementation.
   * @return The JSON string representation of the base64-encoded certificate chain (leaf
   *     certificate followed by the trust chain, if present).
   * @throws IOException If an I/O error occurs while reading the certificate file(s).
   */
  @Override
  public String getSubjectToken(ExternalAccountSupplierContext context) throws IOException {
    String leafCertPath = credentialSource.getCredentialLocation();
    String trustChainPath = null;
    if (credentialSource.getCertificateConfig() != null) {
      trustChainPath = credentialSource.getCertificateConfig().getTrustChainPath();
    }

    // Load and encode the leaf certificate.
    String encodedLeafCert = loadAndEncodeLeafCertificate(leafCertPath);

    // Initialize the certificate chain for the subject token. The Security Token Service (STS)
    // requires that the leaf certificate (the one used for authenticating this workload) must be
    // the first certificate in this chain.
    List<String> certChain = new ArrayList<>();
    certChain.add(encodedLeafCert);

    // Handle trust chain loading and processing.
    try {
      // Read the trust chain.
      List<X509Certificate> trustChainCerts = readTrustChain(trustChainPath);

      // Process the trust chain certificates read from the file.
      if (!trustChainCerts.isEmpty()) {
        populateCertChainFromTrustChain(certChain, trustChainCerts, encodedLeafCert);
      }
    } catch (IllegalArgumentException e) {
      // This catches the specific error for misconfigured trust chain (e.g., leaf in wrong place).
      throw new IOException("Trust chain misconfiguration: " + e.getMessage(), e);
    } catch (NoSuchFileException e) {
      throw new IOException(String.format("Trust chain file not found: %s", trustChainPath), e);
    } catch (CertificateException e) {
      throw new IOException(
          String.format("Failed to parse certificate(s) from trust chain file: %s", trustChainPath),
          e);
    } catch (IOException e) {
      // This catches any other general I/O errors during trust chain file reading (e.g.,
      // permissions).
      throw new IOException(
          String.format("Failed to read trust chain file: %s", trustChainPath), e);
    }

    return OAuth2Utils.JSON_FACTORY.toString(certChain);
  }

  /**
   * Extends {@code certChainToPopulate} with encoded certificates from {@code trustChainCerts},
   * applying validation rules for the leaf certificate's presence and order within the trust chain.
   *
   * @param certChainToPopulate The list of encoded certificate strings to populate.
   * @param trustChainCerts The list of X509Certificates from the trust chain file (non-empty).
   * @param encodedLeafCert The Base64-encoded leaf certificate.
   * @throws CertificateEncodingException If an error occurs during certificate encoding.
   * @throws IllegalArgumentException If the leaf certificate is found in an invalid position in the
   *     trust chain.
   */
  private void populateCertChainFromTrustChain(
      List<String> certChainToPopulate,
      List<X509Certificate> trustChainCerts,
      String encodedLeafCert)
      throws CertificateEncodingException, IllegalArgumentException {

    // Get the first certificate from the user-provided trust chain file.
    X509Certificate firstTrustCert = trustChainCerts.get(0);
    String encodedFirstTrustCert = encodeCert(firstTrustCert);

    // If the first certificate in the user-provided trust chain file is *not* the leaf
    // certificate (which has already been added as the first element to `certChainToPopulate`),
    // then add this certificate. This handles cases where the user's trust chain file
    // starts with an intermediate certificate. If the first certificate in the trust chain file
    // *is* the leaf certificate, this means the user has explicitly included the leaf in their
    // trust chain file. In this case, we skip adding it again to prevent duplication, as the
    // leaf is already at the beginning of `certChainToPopulate`.
    if (!encodedFirstTrustCert.equals(encodedLeafCert)) {
      certChainToPopulate.add(encodedFirstTrustCert);
    }

    // Iterate over the remaining certificates in the trust chain.
    for (int i = 1; i < trustChainCerts.size(); i++) {
      X509Certificate currentCert = trustChainCerts.get(i);
      String encodedCurrentCert = encodeCert(currentCert);

      // Throw an error if the current certificate (from the user-provided trust chain file,
      // at an index beyond the first) is the same as the leaf certificate.
      // This enforces that if the leaf certificate is included in the trust chain file by the
      // user, it must be the very first certificate in that file. It should not appear
      // elsewhere in the chain.
      if (encodedCurrentCert.equals(encodedLeafCert)) {
        throw new IllegalArgumentException(
            "The leaf certificate should only appear at the beginning of the trust chain file, or be omitted entirely.");
      }

      // Add the current certificate to the chain.
      certChainToPopulate.add(encodedCurrentCert);
    }
  }

  /**
   * Reads a file containing PEM-encoded X509 certificates and returns a list of parsed
   * certificates. It splits the file content based on PEM headers and parses each certificate.
   * Returns an empty list if the trust chain path is empty.
   *
   * @param trustChainPath The path to the trust chain file.
   * @return A list of parsed X509 certificates.
   * @throws IOException If an error occurs while reading the file.
   * @throws CertificateException If an error occurs while parsing a certificate.
   */
  @VisibleForTesting
  static List<X509Certificate> readTrustChain(String trustChainPath)
      throws IOException, CertificateException {
    List<X509Certificate> certificateTrustChain = new ArrayList<>();

    // If no trust chain path is provided, return an empty list.
    if (Strings.isNullOrEmpty(trustChainPath)) {
      return certificateTrustChain;
    }

    // initialize certificate factory to retrieve x509 certificates.
    CertificateFactory cf = CertificateFactory.getInstance("X.509");

    // Read the trust chain file.
    byte[] trustChainData;
    trustChainData = Files.readAllBytes(Paths.get(trustChainPath));

    // Split the file content into PEM certificate blocks.
    String content = new String(trustChainData, StandardCharsets.UTF_8);

    Matcher matcher = PEM_CERT_PATTERN.matcher(content);

    while (matcher.find()) {
      String pemCertBlock = matcher.group(0);
      try (InputStream certStream =
          new ByteArrayInputStream(pemCertBlock.getBytes(StandardCharsets.UTF_8))) {
        // Parse the certificate data.
        Certificate cert = cf.generateCertificate(certStream);

        // Append the certificate to the trust chain.
        if (cert instanceof X509Certificate) {
          certificateTrustChain.add((X509Certificate) cert);
        } else {
          throw new CertificateException(
              "Found non-X.509 certificate in trust chain file: " + trustChainPath);
        }
      } catch (CertificateException e) {
        // If parsing an individual PEM block fails, re-throw with more context.
        throw new CertificateException(
            "Error loading PEM certificates from the trust chain file: "
                + trustChainPath
                + " - "
                + e.getMessage(),
            e);
      }
    }

    if (trustChainData.length > 0 && certificateTrustChain.isEmpty()) {
      throw new CertificateException(
          "Trust chain file was not empty but no PEM certificates were found: " + trustChainPath);
    }

    return certificateTrustChain;
  }
}
