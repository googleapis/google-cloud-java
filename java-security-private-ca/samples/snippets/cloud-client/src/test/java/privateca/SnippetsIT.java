/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package privateca;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

import com.google.cloud.security.privateca.v1.CaPool.IssuancePolicy;
import com.google.cloud.security.privateca.v1.CaPoolName;
import com.google.cloud.security.privateca.v1.Certificate;
import com.google.cloud.security.privateca.v1.CertificateAuthority;
import com.google.cloud.security.privateca.v1.CertificateAuthorityName;
import com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient;
import com.google.cloud.security.privateca.v1.CertificateName;
import com.google.cloud.security.privateca.v1.CertificateTemplateName;
import com.google.cloud.security.privateca.v1.FetchCertificateAuthorityCsrResponse;
import com.google.protobuf.ByteString;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemWriter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SnippetsIT {

  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static String LOCATION;
  private static String CA_POOL_ID;
  private static String CA_POOL_ID_DELETE;
  private static String CA_NAME;
  private static String CA_NAME_DELETE;
  private static String SUBORDINATE_CA_NAME;
  private static String CERTIFICATE_TEMPLATE_NAME;
  private static String CERTIFICATE_NAME;
  private static String CSR_CERTIFICATE_NAME;
  private static int KEY_SIZE;

  private ByteArrayOutputStream stdOut;

  // Check if the required environment variables are set.
  public static void reqEnvVar(String envVarName) {
    assertWithMessage(String.format("Missing environment variable '%s' ", envVarName))
        .that(System.getenv(envVarName))
        .isNotEmpty();
  }

  @BeforeClass
  public static void setUp()
      throws IOException, ExecutionException, NoSuchProviderException, NoSuchAlgorithmException,
          InterruptedException, TimeoutException {
    reqEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    reqEnvVar("GOOGLE_CLOUD_PROJECT");

    LOCATION = "asia-south1";
    CA_POOL_ID = "ca-pool-" + UUID.randomUUID();
    CA_POOL_ID_DELETE = "ca-pool-" + UUID.randomUUID();
    CA_NAME = "ca-name-" + UUID.randomUUID();
    CA_NAME_DELETE = "ca-name-" + UUID.randomUUID();
    SUBORDINATE_CA_NAME = "sub-ca-name-" + UUID.randomUUID();
    CERTIFICATE_TEMPLATE_NAME = "certificate-template-name-" + UUID.randomUUID();
    CERTIFICATE_NAME = "certificate-name-" + UUID.randomUUID();
    CSR_CERTIFICATE_NAME = "csr-certificate-name-" + UUID.randomUUID();
    KEY_SIZE = 2048; // Default key size

    // <--- START CA POOL --->
    // Create CA Pool.
    privateca.CreateCaPool.createCaPool(PROJECT_ID, LOCATION, CA_POOL_ID);
    privateca.CreateCaPool.createCaPool(PROJECT_ID, LOCATION, CA_POOL_ID_DELETE);
    sleep(5);
    // Set the issuance policy for the created CA Pool.
    privateca.UpdateCaPool_IssuancePolicy.updateCaPoolIssuancePolicy(
        PROJECT_ID, LOCATION, CA_POOL_ID);
    // <--- END CA POOL --->

    // <--- START ROOT CA --->
    // Create and Enable Certificate Authority.
    privateca.CreateCertificateAuthority.createCertificateAuthority(
        PROJECT_ID, LOCATION, CA_POOL_ID, CA_NAME);
    sleep(10);
    privateca.EnableCertificateAuthority.enableCertificateAuthority(
        PROJECT_ID, LOCATION, CA_POOL_ID, CA_NAME);

    // Create and Delete Certificate Authority.
    privateca.CreateCertificateAuthority.createCertificateAuthority(
        PROJECT_ID, LOCATION, CA_POOL_ID, CA_NAME_DELETE);
    sleep(10);
    privateca.DeleteCertificateAuthority.deleteCertificateAuthority(
        PROJECT_ID, LOCATION, CA_POOL_ID, CA_NAME_DELETE);
    // <--- END ROOT CA --->

    // <--- START SUBORDINATE CA --->
    // Follow the below steps to create and enable a Subordinate Certificate Authority.
    // 1. Create a Subordinate Certificate Authority.
    privateca.CreateSubordinateCa.createSubordinateCertificateAuthority(
        PROJECT_ID, LOCATION, CA_POOL_ID, SUBORDINATE_CA_NAME);
    sleep(10);
    // 2. Fetch CSR.
    String pemCSR = fetchPemCSR(CA_POOL_ID, SUBORDINATE_CA_NAME);
    // 3. Sign the CSR, and create a certificate.
    privateca.CreateCertificate_CSR.createCertificateWithCSR(
        PROJECT_ID, LOCATION, CA_POOL_ID, CA_NAME, CSR_CERTIFICATE_NAME, pemCSR);
    // <--- END SUBORDINATE CA --->

    // <--- START CERTIFICATE --->
    // Create Certificate Template.
    privateca.CreateCertificateTemplate.createCertificateTemplate(
        PROJECT_ID, LOCATION, CERTIFICATE_TEMPLATE_NAME);

    // Create an asymmetric key pair using Bouncy Castle crypto framework.
    KeyPair asymmetricKeyPair = createAsymmetricKeyPair();

    // Cast the keys to their respective components.
    RSAPublicKey publicKey = (RSAPublicKey) asymmetricKeyPair.getPublic();
    RSAPrivateKey privateKey = (RSAPrivateKey) asymmetricKeyPair.getPrivate();

    // Construct the PemObject for public and private keys.
    PemObject publicKeyPemObject = new PemObject("PUBLIC KEY", publicKey.getEncoded());
    PemObject privateKeyPemObject = new PemObject("PRIVATE KEY", privateKey.getEncoded());

    // Only the public key will be used to create the certificate.
    ByteString publicKeyByteString = convertToPemEncodedByteString(publicKeyPemObject);

    // TODO (Developers): Save the private key by writing it to a file and
    // TODO (cont): use it to verify the issued certificate.
    ByteString privateKeyByteString = convertToPemEncodedByteString(privateKeyPemObject);

    // Create certificate with the above generated public key.
    privateca.CreateCertificate.createCertificate(
        PROJECT_ID, LOCATION, CA_POOL_ID, CA_NAME, CERTIFICATE_NAME, publicKeyByteString);
    sleep(5);
    // <--- END CERTIFICATE --->
  }

  @AfterClass
  public static void cleanUp()
      throws InterruptedException, ExecutionException, IOException, TimeoutException {

    ByteArrayOutputStream stdOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(stdOut));

    // Revoke Certificate.
    privateca.RevokeCertificate.revokeCertificate(
        PROJECT_ID, LOCATION, CA_POOL_ID, CSR_CERTIFICATE_NAME);

    // Delete Certificate Template.
    privateca.DeleteCertificateTemplate.deleteCertificateTemplate(
        PROJECT_ID, LOCATION, CERTIFICATE_TEMPLATE_NAME);

    // Delete root CA.
    privateca.DeleteCertificateAuthority.deleteCertificateAuthority(
        PROJECT_ID, LOCATION, CA_POOL_ID, CA_NAME);
    sleep(5);
    // Deleting the undeleted CA.
    privateca.DeleteCertificateAuthority.deleteCertificateAuthority(
        PROJECT_ID, LOCATION, CA_POOL_ID, CA_NAME_DELETE);

    // Delete Subordinate CA.
    privateca.DeleteCertificateAuthority.deleteCertificateAuthority(
        PROJECT_ID, LOCATION, CA_POOL_ID, SUBORDINATE_CA_NAME);
    sleep(5);
    // Delete CA Pool.
    privateca.DeleteCaPool.deleteCaPool(PROJECT_ID, LOCATION, CA_POOL_ID);

    stdOut = null;
    System.setOut(null);
  }

  // Wait for the specified amount of time.
  public static void sleep(int seconds) throws InterruptedException {
    TimeUnit.SECONDS.sleep(seconds);
  }

  // Fetch CSR of the given CA.
  public static String fetchPemCSR(String pool_Id, String caName) throws IOException {
    try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
        CertificateAuthorityServiceClient.create()) {
      String caParent =
          CertificateAuthorityName.of(PROJECT_ID, LOCATION, pool_Id, caName).toString();

      FetchCertificateAuthorityCsrResponse response =
          certificateAuthorityServiceClient.fetchCertificateAuthorityCsr(caParent);

      return response.getPemCsr();
    }
  }

  // Create an asymmetric key pair to be used in certificate signing.
  public static KeyPair createAsymmetricKeyPair()
      throws NoSuchAlgorithmException, NoSuchProviderException {
    Security.addProvider(new BouncyCastleProvider());

    // Generate the key pair with RSA algorithm using Bouncy Castle (BC).
    KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA", "BC");
    generator.initialize(KEY_SIZE);
    KeyPair keyPair = generator.generateKeyPair();

    return keyPair;
  }

  // Convert the encoded PemObject to ByteString.
  public static ByteString convertToPemEncodedByteString(PemObject pemEncodedKey)
      throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    PemWriter pemWriter = new PemWriter(new OutputStreamWriter(byteArrayOutputStream));
    pemWriter.writeObject(pemEncodedKey);
    pemWriter.close();
    ByteString keyByteString = ByteString.copyFrom(byteArrayOutputStream.toByteArray());

    return keyByteString;
  }

  @Before
  public void beforeEach() {
    stdOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(stdOut));
  }

  @After
  public void afterEach() {
    stdOut = null;
    System.setOut(null);
  }

  @Test
  public void testCreateCAPool() throws IOException {
    // Check if the CA pool created during setup is successful.
    try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
        CertificateAuthorityServiceClient.create()) {
      String caPoolName =
          certificateAuthorityServiceClient
              .getCaPool(CaPoolName.of(PROJECT_ID, LOCATION, CA_POOL_ID).toString())
              .getName();
      assertThat(caPoolName)
          .contains(
              String.format(
                  "projects/%s/locations/%s/caPools/%s", PROJECT_ID, LOCATION, CA_POOL_ID));
    }
  }

  @Test
  public void testUpdateCAPoolIssuancePolicy() throws IOException {
    try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
        CertificateAuthorityServiceClient.create()) {
      IssuancePolicy issuancePolicy =
          certificateAuthorityServiceClient
              .getCaPool(CaPoolName.of(PROJECT_ID, LOCATION, CA_POOL_ID).toString())
              .getIssuancePolicy();

      String actualExpression =
          issuancePolicy.getIdentityConstraints().getCelExpression().getExpression();
      String expectedExpression =
          "subject_alt_names.all(san, san.type == DNS && (san.value == \"us.google.org\" || san.value.endsWith(\".google.com\")) )";
      assertThat(actualExpression).contains(expectedExpression);
    }
  }

  @Test
  public void testListCAPools() throws IOException {
    privateca.ListCaPools.listCaPools(PROJECT_ID, LOCATION);
    assertThat(stdOut.toString()).contains(CA_POOL_ID);
  }

  @Test
  public void testDeleteCAPool()
      throws InterruptedException, ExecutionException, IOException, TimeoutException {
    privateca.DeleteCaPool.deleteCaPool(PROJECT_ID, LOCATION, CA_POOL_ID_DELETE);
    assertThat(stdOut.toString()).contains("Deleted CA Pool: " + CA_POOL_ID_DELETE);
  }

  @Test
  public void testCreateCertificateAuthority() throws IOException {
    // Check if the CA created during setup is successful.
    try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
        CertificateAuthorityServiceClient.create()) {
      CertificateAuthority response =
          certificateAuthorityServiceClient.getCertificateAuthority(
              CertificateAuthorityName.of(PROJECT_ID, LOCATION, CA_POOL_ID, CA_NAME).toString());
      assertThat(response.getName()).contains(CA_NAME);
    }
  }

  @Test
  public void testListCertificateAuthorities() throws IOException {
    privateca.ListCertificateAuthorities.listCertificateAuthority(PROJECT_ID, LOCATION, CA_POOL_ID);
    assertThat(stdOut.toString()).contains(CA_NAME);
  }

  @Test
  public void testUpdateCertificateAuthority()
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    privateca.UpdateCertificateAuthority.updateCaLabel(PROJECT_ID, LOCATION, CA_POOL_ID, CA_NAME);
    assertThat(stdOut.toString()).contains("Successfully updated the labels ! ");
  }

  @Test
  public void testMonitorCertificateAuthority() throws IOException, InterruptedException {
    privateca.MonitorCertificateAuthority.createCaMonitoringPolicy(PROJECT_ID);
    assertThat(stdOut.toString()).contains("Monitoring policy successfully created !");
  }

  @Test
  public void testEnableDisableCertificateAuthority()
      throws InterruptedException, ExecutionException, IOException {
    privateca.EnableCertificateAuthority.enableCertificateAuthority(
        PROJECT_ID, LOCATION, CA_POOL_ID, CA_NAME);
    assertThat(stdOut.toString()).contains("Enabled Certificate Authority : " + CA_NAME);
    privateca.DisableCertificateAuthority.disableCertificateAuthority(
        PROJECT_ID, LOCATION, CA_POOL_ID, CA_NAME);
    assertThat(stdOut.toString()).contains("Disabled Certificate Authority : " + CA_NAME);
  }

  @Test
  public void testDeleteUndeleteCertificateAuthority()
      throws InterruptedException, ExecutionException, IOException, TimeoutException {
    // CA deleted as part of setup(). Undelete the CA.
    // The undelete operation will be executed only if the CA was successfully deleted.
    privateca.UndeleteCertificateAuthority.undeleteCertificateAuthority(
        PROJECT_ID, LOCATION, CA_POOL_ID, CA_NAME_DELETE);
    assertThat(stdOut.toString())
        .contains("Successfully restored the Certificate Authority ! " + CA_NAME_DELETE);
  }

  @Test
  public void testCreateCertificateTemplate() throws IOException {
    // Check that the Certificate template has been created as part of the setup.
    try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
        CertificateAuthorityServiceClient.create()) {
      String certificateTemplate =
          certificateAuthorityServiceClient
              .getCertificateTemplate(
                  CertificateTemplateName.of(PROJECT_ID, LOCATION, CERTIFICATE_TEMPLATE_NAME)
                      .toString())
              .getName();

      assertThat(certificateTemplate)
          .contains(String.format("projects/%s/locations/%s/", PROJECT_ID, LOCATION));
    }
  }

  @Test
  public void testListCertificateTemplate()
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    privateca.ListCertificateTemplates.listCertificateTemplates(PROJECT_ID, LOCATION);
    assertThat(stdOut.toString()).contains(CERTIFICATE_TEMPLATE_NAME);
  }

  @Test
  public void updateCertificateTemplate()
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    privateca.UpdateCertificateTemplate.updateCertificateTemplate(
        PROJECT_ID, LOCATION, CERTIFICATE_TEMPLATE_NAME);
    assertThat(stdOut.toString()).contains("Successfully updated the certificate template ! ");
  }

  @Test
  public void testCreateCertificate() throws IOException {
    // Check if the certificate created during setup is successful.
    try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
        CertificateAuthorityServiceClient.create()) {
      CertificateName certificateName =
          CertificateName.of(PROJECT_ID, LOCATION, CA_POOL_ID, CERTIFICATE_NAME);
      Certificate certificate = certificateAuthorityServiceClient.getCertificate(certificateName);
      assertThat(certificate.getName()).contains(CERTIFICATE_NAME);
    }
  }

  @Test
  public void testListCertificates() throws IOException {
    privateca.ListCertificates.listCertificates(PROJECT_ID, LOCATION, CA_POOL_ID);
    assertThat(stdOut.toString()).contains(CERTIFICATE_NAME);
  }

  @Test
  public void testFilterCertificates() throws IOException {
    // Filter only certificates created using CSR.
    privateca.FilterCertificates.filterCertificates(PROJECT_ID, LOCATION, CA_POOL_ID);
    assertThat(stdOut.toString()).contains(CSR_CERTIFICATE_NAME);
    assertThat(stdOut.toString()).doesNotContain(CERTIFICATE_NAME);
  }

  @Test
  public void testRevokeCertificate() throws InterruptedException, ExecutionException, IOException {
    try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
        CertificateAuthorityServiceClient.create()) {
      // Revoke the certificate.
      privateca.RevokeCertificate.revokeCertificate(
          PROJECT_ID, LOCATION, CA_POOL_ID, CERTIFICATE_NAME);

      // Check if the certificate has revocation details. If it does, then the certificate is
      // considered as revoked.
      CertificateName certificateName =
          CertificateName.of(PROJECT_ID, LOCATION, CA_POOL_ID, CERTIFICATE_NAME);
      Assert.assertTrue(
          certificateAuthorityServiceClient.getCertificate(certificateName).hasRevocationDetails());
    }
  }

  @Test
  public void testCreateSubordinateCertificateAuthority() throws IOException {
    try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
        CertificateAuthorityServiceClient.create()) {
      CertificateAuthority response =
          certificateAuthorityServiceClient.getCertificateAuthority(
              CertificateAuthorityName.of(PROJECT_ID, LOCATION, CA_POOL_ID, SUBORDINATE_CA_NAME)
                  .toString());
      Assert.assertTrue(response.hasCreateTime());
    }
  }

  @Test
  public void testCreateCertificateWithCSR() throws IOException {
    try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
        CertificateAuthorityServiceClient.create()) {
      Certificate response =
          certificateAuthorityServiceClient.getCertificate(
              CertificateName.of(PROJECT_ID, LOCATION, CA_POOL_ID, CSR_CERTIFICATE_NAME)
                  .toString());
      Assert.assertTrue(response.hasCreateTime());
    }
  }

  @Test
  public void testActivateSubordinateCertificateAuthority()
      throws IOException, ExecutionException, InterruptedException {
    try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
        CertificateAuthorityServiceClient.create()) {
      Certificate response =
          certificateAuthorityServiceClient.getCertificate(
              CertificateName.of(PROJECT_ID, LOCATION, CA_POOL_ID, CSR_CERTIFICATE_NAME)
                  .toString());

      String pemCertificate = response.getPemCertificate();

      privateca.ActivateSubordinateCa.activateSubordinateCA(
          PROJECT_ID, LOCATION, CA_POOL_ID, CA_NAME, SUBORDINATE_CA_NAME, pemCertificate);
      assertThat(stdOut.toString()).contains("Current State: STAGED");
    }
  }
}
