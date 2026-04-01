/*
 * Copyright 2025, Google LLC
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import com.google.auth.oauth2.IdentityPoolCredentialSource.CertificateConfig;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/** Tests for {@link CertificateIdentityPoolSubjectTokenSupplier}. */
@ExtendWith(MockitoExtension.class)
class CertificateIdentityPoolSubjectTokenSupplierTest {

  @Mock private IdentityPoolCredentialSource mockCredentialSource;
  @Mock private CertificateConfig mockCertificateConfig;
  @Mock private ExternalAccountSupplierContext mockContext;

  private CertificateIdentityPoolSubjectTokenSupplier supplier;

  private static final byte[] INVALID_CERT_BYTES =
      ("-----BEGIN CERTIFICATE-----\n"
              // This content is intentionally not valid Base64 or a valid DER encoding.
              // The presence of spaces and non-Base64 characters will cause a parsing error.
              + "This is not valid base64 encoded certificate data.\n"
              + "It will cause a CertificateException during parsing.\n"
              + "-----END CERTIFICATE-----\n")
          .getBytes(StandardCharsets.UTF_8);

  private byte[] testCertBytesFromFile;
  private byte[] intermediateCertBytesFromFile;

  @BeforeEach
  void setUp() throws IOException, URISyntaxException {
    ClassLoader classLoader = getClass().getClassLoader();
    URL leafCertUrl = classLoader.getResource("x509_leaf_certificate.pem");
    assertNotNull(leafCertUrl, "Test leaf certificate file not found!");
    File testCertFile = new File(leafCertUrl.getFile());

    URL intermediateCertUrl = classLoader.getResource("x509_intermediate_certificate.pem");
    assertNotNull(intermediateCertUrl, "Test intermediate certificate file not found!");

    lenient().when(mockCertificateConfig.useDefaultCertificateConfig()).thenReturn(false);
    lenient()
        .when(mockCertificateConfig.getCertificateConfigLocation())
        .thenReturn(testCertFile.getAbsolutePath());

    lenient().when(mockCredentialSource.getCertificateConfig()).thenReturn(mockCertificateConfig);
    lenient()
        .when(mockCredentialSource.getCredentialLocation())
        .thenReturn(testCertFile.getAbsolutePath());

    supplier = new CertificateIdentityPoolSubjectTokenSupplier(mockCredentialSource);
    testCertBytesFromFile = Files.readAllBytes(Paths.get(leafCertUrl.toURI()));
    intermediateCertBytesFromFile = Files.readAllBytes(Paths.get(intermediateCertUrl.toURI()));
  }

  @Test
  void parseCertificate_validData_returnsCertificate() throws Exception {
    X509Certificate cert =
        CertificateIdentityPoolSubjectTokenSupplier.parseCertificate(testCertBytesFromFile);
    assertNotNull(cert);
  }

  @Test
  void parseCertificate_emptyData_throwsIllegalArgumentException() {
    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> CertificateIdentityPoolSubjectTokenSupplier.parseCertificate(new byte[0]));
    assertEquals(
        "Invalid certificate data: Certificate file is empty or null.", exception.getMessage());
  }

  @Test
  void parseCertificate_nullData_throwsIllegalArgumentException() {
    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> CertificateIdentityPoolSubjectTokenSupplier.parseCertificate(null));
    assertEquals(
        "Invalid certificate data: Certificate file is empty or null.", exception.getMessage());
  }

  @Test
  void parseCertificate_invalidData_throwsCertificateException() {
    CertificateException exception =
        assertThrows(
            CertificateException.class,
            () -> CertificateIdentityPoolSubjectTokenSupplier.parseCertificate(INVALID_CERT_BYTES));
    assertEquals("Failed to parse X.509 certificate data.", exception.getMessage());
  }

  @Test
  void getSubjectToken_withoutTrustChain_success() throws Exception {
    // Calculate expected result based on the file content.
    CertificateFactory cf = CertificateFactory.getInstance("X.509");
    X509Certificate expectedCert =
        (X509Certificate) cf.generateCertificate(new ByteArrayInputStream(testCertBytesFromFile));
    String expectedEncodedLeaf = Base64.getEncoder().encodeToString(expectedCert.getEncoded());
    String[] expectedCertChainArray = new String[] {expectedEncodedLeaf};
    String expectedSubjectToken = OAuth2Utils.JSON_FACTORY.toString(expectedCertChainArray);

    // Execute
    String actualSubjectToken = supplier.getSubjectToken(mockContext);

    // Verify
    assertEquals(expectedSubjectToken, actualSubjectToken);
  }

  @Test
  void getSubjectToken_trustChainWithLeafFirst_success() throws Exception {
    // Configure mock to return the path to the trust chain file with leaf.
    ClassLoader classLoader = getClass().getClassLoader();
    URL trustChainUrl = classLoader.getResource("trust_chain_with_leaf.pem");
    assertNotNull(trustChainUrl, "Test trust chain file not found!");
    when(mockCertificateConfig.getTrustChainPath())
        .thenReturn(new File(trustChainUrl.getFile()).getAbsolutePath());

    CertificateFactory cf = CertificateFactory.getInstance("X.509");

    // Parse and encode the leaf certificate.
    X509Certificate expectedLeafCert =
        (X509Certificate) cf.generateCertificate(new ByteArrayInputStream(testCertBytesFromFile));
    String expectedEncodedLeaf = Base64.getEncoder().encodeToString(expectedLeafCert.getEncoded());

    // Parse and encode the intermediate certificate.
    X509Certificate expectedIntermediateCert =
        (X509Certificate)
            cf.generateCertificate(new ByteArrayInputStream(intermediateCertBytesFromFile));
    String expectedEncodedIntermediate =
        Base64.getEncoder().encodeToString(expectedIntermediateCert.getEncoded());

    // Expected: JSON array with encoded leaf and then encoded intermediate.
    String[] expectedCertChain = new String[] {expectedEncodedLeaf, expectedEncodedIntermediate};
    String expectedSubjectToken = OAuth2Utils.JSON_FACTORY.toString(expectedCertChain);

    // Execute
    String actualSubjectToken = supplier.getSubjectToken(mockContext);

    // Verify
    assertEquals(expectedSubjectToken, actualSubjectToken);
  }

  @Test
  void getSubjectToken_trustChainWithoutLeaf_success() throws Exception {
    // Configure mock to return the path to the trust chain file WITHOUT leaf.
    ClassLoader classLoader = getClass().getClassLoader();
    URL trustChainUrl = classLoader.getResource("trust_chain_without_leaf.pem");
    assertNotNull(trustChainUrl, "Test trust chain file (without leaf) not found!");
    when(mockCertificateConfig.getTrustChainPath())
        .thenReturn(new File(trustChainUrl.getFile()).getAbsolutePath());

    CertificateFactory cf = CertificateFactory.getInstance("X.509");

    // Parse and encode the leaf certificate.
    X509Certificate expectedLeafCert =
        (X509Certificate) cf.generateCertificate(new ByteArrayInputStream(testCertBytesFromFile));
    String expectedEncodedLeaf = Base64.getEncoder().encodeToString(expectedLeafCert.getEncoded());

    // Parse and encode the intermediate certificate.
    X509Certificate expectedIntermediateCert =
        (X509Certificate)
            cf.generateCertificate(new ByteArrayInputStream(intermediateCertBytesFromFile));
    String expectedEncodedIntermediate =
        Base64.getEncoder().encodeToString(expectedIntermediateCert.getEncoded());

    // Expected: JSON array with encoded leaf and then encoded intermediate.
    String[] expectedCertChainArray =
        new String[] {expectedEncodedLeaf, expectedEncodedIntermediate};
    String expectedSubjectToken = OAuth2Utils.JSON_FACTORY.toString(expectedCertChainArray);

    // Execute
    String actualSubjectToken = supplier.getSubjectToken(mockContext);

    // Verify
    assertEquals(expectedSubjectToken, actualSubjectToken);
  }

  // Tests that an IllegalArgumentException (wrapped in IOException) is thrown
  // when the trust chain file is provided and contains the leaf certificate,
  // but the leaf certificate is not the *first* certificate in that file.
  // For example, an intermediate certificate appears before the leaf certificate.
  @Test
  void getSubjectToken_trustChainWrongOrder_throwsIllegalArgumentException() {
    ClassLoader classLoader = getClass().getClassLoader();
    URL trustChainUrl = classLoader.getResource("trust_chain_wrong_order.pem");
    assertNotNull(trustChainUrl, "Test trust chain file (wrong order) not found!");
    String trustChainPath = new File(trustChainUrl.getFile()).getAbsolutePath();
    when(mockCertificateConfig.getTrustChainPath()).thenReturn(trustChainPath);

    String expectedRootErrorMessage =
        "The leaf certificate should only appear at the beginning of the trust chain file, or be omitted entirely.";
    String expectedOuterExceptionMessage =
        "Trust chain misconfiguration: " + expectedRootErrorMessage;

    // Execute & Verify
    IOException exception =
        assertThrows(IOException.class, () -> supplier.getSubjectToken(mockContext));

    assertEquals(expectedOuterExceptionMessage, exception.getMessage());

    Throwable cause = exception.getCause();
    assertNotNull(cause, "Exception cause should not be null");
    assertTrue(
        cause instanceof IllegalArgumentException,
        "Exception cause should be an IllegalArgumentException");
    assertEquals(expectedRootErrorMessage, cause.getMessage());
  }

  @Test
  void getSubjectToken_trustChainOnlyLeaf_success() throws Exception {
    // Configure mock to use the leaf certificate file itself as the trust chain file,
    // simulating a scenario where the trust chain file contains only the leaf.
    ClassLoader classLoader = getClass().getClassLoader();
    URL trustChainUrl = classLoader.getResource("x509_leaf_certificate.pem");
    assertNotNull(
        trustChainUrl,
        "Test resource 'x509_leaf_certificate.pem' (used as trust chain) not found!");
    when(mockCertificateConfig.getTrustChainPath())
        .thenReturn(new File(trustChainUrl.getFile()).getAbsolutePath());

    CertificateFactory cf = CertificateFactory.getInstance("X.509");

    // Parse and encode the leaf certificate
    X509Certificate expectedLeafCert =
        (X509Certificate) cf.generateCertificate(new ByteArrayInputStream(testCertBytesFromFile));
    String expectedEncodedLeaf = Base64.getEncoder().encodeToString(expectedLeafCert.getEncoded());

    // Expected: JSON array with only the encoded leaf.
    String[] expectedCertChainArray = new String[] {expectedEncodedLeaf};
    String expectedSubjectToken = OAuth2Utils.JSON_FACTORY.toString(expectedCertChainArray);

    // Execute
    String actualSubjectToken = supplier.getSubjectToken(mockContext);

    // Verify
    assertEquals(expectedSubjectToken, actualSubjectToken);
  }

  @Test
  void getSubjectToken_trustChainFileNotFound_throwsIOException() {
    // Configure mock to return a non-existent path for the trust chain.
    String nonExistentPath = "/path/to/non/existent/trust_chain.pem";
    when(mockCertificateConfig.getTrustChainPath()).thenReturn(nonExistentPath);

    // Execute & Verify
    IOException exception =
        assertThrows(IOException.class, () -> supplier.getSubjectToken(mockContext));

    // Check that the cause is NoSuchFileException from readTrustChain.
    assertTrue(exception.getCause() instanceof NoSuchFileException);

    // Check the outer exception message added in getSubjectToken.
    assertEquals("Trust chain file not found: " + nonExistentPath, exception.getMessage());
  }

  @Test
  void getSubjectToken_trustChainInvalidFormat_throwsIOException() throws Exception {
    // Create a temporary file with invalid cert data for the trust chain.
    File invalidTrustChainFile = File.createTempFile("invalid_trust_chain", ".pem");
    invalidTrustChainFile.deleteOnExit();
    Files.write(invalidTrustChainFile.toPath(), INVALID_CERT_BYTES);

    // Configure mock to return the path to the temporary invalid trust chain file.
    String invalidPath = invalidTrustChainFile.getAbsolutePath();
    when(mockCertificateConfig.getTrustChainPath()).thenReturn(invalidPath);

    // Execute & Verify
    IOException exception =
        assertThrows(IOException.class, () -> supplier.getSubjectToken(mockContext));

    // The final exception is an IOException thrown by getSubjectToken.
    assertEquals(
        "Failed to parse certificate(s) from trust chain file: " + invalidPath,
        exception.getMessage());

    // Check that the cause is CertificateException from readTrustChain
    assertTrue(exception.getCause() instanceof CertificateException);

    // Verify the cause's message specifically points to the trust chain parsing failure
    // and includes the path of the invalid trust chain file.
    assertTrue(
        exception
            .getCause()
            .getMessage()
            .startsWith(
                "Error loading PEM certificates from the trust chain file: " + invalidPath));
  }

  @Test
  void getSubjectToken_leafCertFileNotFound_throwsIOException() {
    // Configure mock to return a non-existent path for the leaf certificate.
    String nonExistentPath = "/path/to/non/existent/leaf.pem";
    when(mockCredentialSource.getCredentialLocation()).thenReturn(nonExistentPath);
    // Re-initialize supplier with the bad leaf path
    supplier = new CertificateIdentityPoolSubjectTokenSupplier(mockCredentialSource);

    // Execute & Verify: Expect the wrapper IOException.
    IOException exception =
        assertThrows(IOException.class, () -> supplier.getSubjectToken(mockContext));

    // Check the message of the wrapper IOException.
    assertEquals("Leaf certificate file not found: " + nonExistentPath, exception.getMessage());

    // Check that the cause is the original NoSuchFileException.
    assertNotNull(exception.getCause(), "Exception should have a cause");
    assertTrue(
        exception.getCause() instanceof NoSuchFileException, "Cause should be NoSuchFileException");

    // Check the message of the cause (which is the path) in a platform-agnostic way.
    Path expectedCausePath = Paths.get(nonExistentPath);
    Path actualCausePath = Paths.get(exception.getCause().getMessage());
    assertEquals(expectedCausePath, actualCausePath);
  }

  @Test
  void getSubjectToken_leafCertInvalidFormat_throwsIOException() throws Exception {
    // Create a temporary file with invalid cert data.
    File invalidLeafFile = File.createTempFile("invalid_leaf", ".pem");
    invalidLeafFile.deleteOnExit();
    Files.write(invalidLeafFile.toPath(), INVALID_CERT_BYTES);

    // Configure mock to return the path to the invalid leaf certificate file
    when(mockCredentialSource.getCredentialLocation())
        .thenReturn(invalidLeafFile.getAbsolutePath());
    // Re-initialize supplier with the bad leaf path
    supplier = new CertificateIdentityPoolSubjectTokenSupplier(mockCredentialSource);

    // Execute & Verify
    IOException exception =
        assertThrows(IOException.class, () -> supplier.getSubjectToken(mockContext));

    // Check that the cause is CertificateException from parseCertificate (via
    // loadLeafCertificate)
    assertTrue(exception.getCause() instanceof CertificateException);
    assertEquals("Failed to parse X.509 certificate data.", exception.getCause().getMessage());

    // Check the outer exception message
    assertEquals(
        "Failed to parse leaf certificate from file: " + invalidLeafFile.getAbsolutePath(),
        exception.getMessage());
  }

  @Test
  void readTrustChain_whenFileIsNotEmptyButContainsNoPemBlocks_throwsCertificateException()
      throws IOException {
    // Create a temporary file with content that does not match PEM certificate blocks.
    File trustChainFile = File.createTempFile("non_pem_content_trust_chain", ".txt");
    trustChainFile.deleteOnExit();
    String fileContent = "This is a test file with some data, but no actual PEM certificates.";
    Files.write(trustChainFile.toPath(), fileContent.getBytes(StandardCharsets.UTF_8));
    String trustChainPath = trustChainFile.getAbsolutePath();

    // Execute & Verify
    CertificateException exception =
        assertThrows(
            CertificateException.class,
            () -> CertificateIdentityPoolSubjectTokenSupplier.readTrustChain(trustChainPath));

    // Verify the exception message.
    String expectedMessage =
        "Trust chain file was not empty but no PEM certificates were found: " + trustChainPath;
    assertEquals(expectedMessage, exception.getMessage());
  }

  @Test
  void readTrustChain_nullPath_returnsEmptyList() throws Exception {
    List<X509Certificate> certs = CertificateIdentityPoolSubjectTokenSupplier.readTrustChain(null);
    assertNotNull(certs);
    assertTrue(certs.isEmpty());
  }

  @Test
  void readTrustChain_emptyFile_returnsEmptyList() throws IOException, CertificateException {
    // Create an empty temporary file.
    File emptyFile = File.createTempFile("empty_trust_chain", ".pem");
    emptyFile.deleteOnExit();

    String emptyFilePath = emptyFile.getAbsolutePath();
    List<X509Certificate> certs =
        CertificateIdentityPoolSubjectTokenSupplier.readTrustChain(emptyFilePath);
    assertNotNull(certs);
    assertTrue(certs.isEmpty());
  }
}
