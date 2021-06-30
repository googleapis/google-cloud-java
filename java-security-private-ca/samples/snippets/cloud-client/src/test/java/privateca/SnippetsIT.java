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

import com.google.cloud.kms.v1.CreateKeyRingRequest;
import com.google.cloud.kms.v1.CryptoKey;
import com.google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose;
import com.google.cloud.kms.v1.CryptoKeyVersion;
import com.google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionAlgorithm;
import com.google.cloud.kms.v1.CryptoKeyVersionName;
import com.google.cloud.kms.v1.CryptoKeyVersionTemplate;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.cloud.kms.v1.KeyRing;
import com.google.cloud.kms.v1.KeyRingName;
import com.google.cloud.kms.v1.LocationName;
import com.google.cloud.security.privateca.v1.CaPoolName;
import com.google.cloud.security.privateca.v1.Certificate;
import com.google.cloud.security.privateca.v1.CertificateAuthority;
import com.google.cloud.security.privateca.v1.CertificateAuthorityName;
import com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient;
import com.google.cloud.security.privateca.v1.CertificateName;
import com.google.protobuf.ByteString;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
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
  private static String KMS_LOCATION;
  private static String CA_POOL_NAME;
  private static String CA_POOL_NAME_DELETE;
  private static String CA_NAME;
  private static String CA_NAME_DELETE;
  private static String CERTIFICATE_NAME;
  private static String KEY_RING_ID;
  private static String KEY_ID;
  private static String VERSION_ID;

  private ByteArrayOutputStream stdOut;

  // Check if the required environment variables are set.
  public static void reqEnvVar(String envVarName) {
    assertWithMessage(String.format("Missing environment variable '%s' ", envVarName))
        .that(System.getenv(envVarName))
        .isNotEmpty();
  }

  @BeforeClass
  public static void setUp() throws InterruptedException, ExecutionException, IOException {
    reqEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    reqEnvVar("GOOGLE_CLOUD_PROJECT");

    LOCATION = "asia-south1";
    KMS_LOCATION = "global";
    CA_POOL_NAME = "ca-pool-" + UUID.randomUUID().toString();
    CA_POOL_NAME_DELETE = "ca-pool-" + UUID.randomUUID().toString();
    CA_NAME = "ca-name-" + UUID.randomUUID().toString();
    CA_NAME_DELETE = "ca-name-" + UUID.randomUUID().toString();
    CERTIFICATE_NAME = "certificate-name-" + UUID.randomUUID().toString();
    KEY_RING_ID = "key-ring-id-" + UUID.randomUUID().toString();
    KEY_ID = "key-id-" + UUID.randomUUID().toString();
    VERSION_ID = "1";

    // Create CA Pool.
    privateca.CreateCaPool.createCaPool(PROJECT_ID, LOCATION, CA_POOL_NAME);
    privateca.CreateCaPool.createCaPool(PROJECT_ID, LOCATION, CA_POOL_NAME_DELETE);

    // Create and Enable Certificate Authorities.
    privateca.CreateCertificateAuthority.createCertificateAuthority(
        PROJECT_ID, LOCATION, CA_POOL_NAME, CA_NAME);
    privateca.CreateCertificateAuthority.createCertificateAuthority(
        PROJECT_ID, LOCATION, CA_POOL_NAME, CA_NAME_DELETE);
    sleep(10);
    privateca.EnableCertificateAuthority.enableCertificateAuthority(
        PROJECT_ID, LOCATION, CA_POOL_NAME, CA_NAME);

    // Create Asymmetric Sign Key used to sign certificate, with Cloud KMS.
    createKeyRing();
    sleep(5);
    createAsymmetricSignKey();

    // Retrieve public key from Cloud KMS and Create Certificate.
    ByteString publicKey =
        privateca.CreateCertificate.retrievePublicKey(
            PROJECT_ID, KMS_LOCATION, KEY_RING_ID, KEY_ID, VERSION_ID);
    privateca.CreateCertificate.createCertificate(
        PROJECT_ID, LOCATION, CA_POOL_NAME, CA_NAME, CERTIFICATE_NAME, publicKey);
    sleep(5);
  }

  @AfterClass
  public static void cleanUp() throws InterruptedException, ExecutionException, IOException {

    ByteArrayOutputStream stdOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(stdOut));

    // De-provision public key.
    cleanupCertificateSignKey();

    // Delete CA and CA pool.
    privateca.DeleteCertificateAuthority.deleteCertificateAuthority(
        PROJECT_ID, LOCATION, CA_POOL_NAME, CA_NAME);
    sleep(5);
    privateca.DeleteCaPool.deleteCaPool(PROJECT_ID, LOCATION, CA_POOL_NAME);

    stdOut = null;
    System.setOut(null);
  }

  // Create a new key ring.
  public static void createKeyRing() throws IOException {
    // Initialize client that will be used to send requests. This client only
    // needs to be created once, and can be reused for multiple requests. After
    // completing all of your requests, call the "close" method on the client to
    // safely clean up any remaining background resources.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      // Build the parent name from the project and location.
      LocationName locationName = LocationName.of(PROJECT_ID, KMS_LOCATION);

      // Build the key ring to create.
      KeyRing keyRing = KeyRing.newBuilder().setName(locationName.toString()).build();

      // Create the key ring.
      KeyRing createdKeyRing =
          client.createKeyRing(
              CreateKeyRingRequest.newBuilder()
                  .setParent(locationName.toString())
                  .setKeyRing(keyRing)
                  .setKeyRingId(KEY_RING_ID)
                  .build());
      System.out.printf("Created key ring: %s%n", createdKeyRing.getName());
    }
  }

  // Create a new asymmetric key for the purpose of signing and verifying data.
  public static void createAsymmetricSignKey() throws IOException {
    // Initialize client that will be used to send requests. This client only
    // needs to be created once, and can be reused for multiple requests. After
    // completing all of your requests, call the "close" method on the client to
    // safely clean up any remaining background resources.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      // Build the parent name from the project, location, and key ring.
      KeyRingName keyRingName = KeyRingName.of(PROJECT_ID, KMS_LOCATION, KEY_RING_ID);

      // Build the asymmetric key to create.
      CryptoKey key =
          CryptoKey.newBuilder()
              .setPurpose(CryptoKeyPurpose.ASYMMETRIC_SIGN)
              .setVersionTemplate(
                  CryptoKeyVersionTemplate.newBuilder()
                      .setAlgorithm(CryptoKeyVersionAlgorithm.RSA_SIGN_PKCS1_2048_SHA256))
              .build();

      // Create the key.
      CryptoKey createdKey = client.createCryptoKey(keyRingName, KEY_ID, key);
      System.out.printf("Created asymmetric key: %s%n", createdKey.getName());
    }
  }

  public static void cleanupCertificateSignKey() throws IOException, InterruptedException {
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      CryptoKeyVersionName cryptoKeyVersionName =
          CryptoKeyVersionName.of(PROJECT_ID, KMS_LOCATION, KEY_RING_ID, KEY_ID, VERSION_ID);
      // Destroy the crypto key version.
      CryptoKeyVersion cryptoKeyVersion = client.destroyCryptoKeyVersion(cryptoKeyVersionName);
      sleep(5);
      // If the response has destroy time, then the version is successfully destroyed.
      Assert.assertTrue(cryptoKeyVersion.hasDestroyTime());
    }
  }

  // Wait for the specified amount of time.
  public static void sleep(int seconds) throws InterruptedException {
    TimeUnit.SECONDS.sleep(seconds);
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
              .getCaPool(CaPoolName.of(PROJECT_ID, LOCATION, CA_POOL_NAME).toString())
              .getName();
      assertThat(caPoolName)
          .contains(
              String.format(
                  "projects/%s/locations/%s/caPools/%s", PROJECT_ID, LOCATION, CA_POOL_NAME));
    }
  }

  @Test
  public void testListCAPools() throws IOException {
    privateca.ListCaPools.listCaPools(PROJECT_ID, LOCATION);
    assertThat(stdOut.toString()).contains(CA_POOL_NAME);
  }

  @Test
  public void testDeleteCAPool()
      throws InterruptedException, ExecutionException, IOException, TimeoutException {
    privateca.DeleteCaPool.deleteCaPool(PROJECT_ID, LOCATION, CA_POOL_NAME_DELETE);
    assertThat(stdOut.toString()).contains("Deleted CA Pool: " + CA_POOL_NAME_DELETE);
  }

  @Test
  public void testCreateCertificateAuthority() throws IOException {
    // Check if the CA created during setup is successful.
    try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
        CertificateAuthorityServiceClient.create()) {
      CertificateAuthority response =
          certificateAuthorityServiceClient.getCertificateAuthority(
              CertificateAuthorityName.of(PROJECT_ID, LOCATION, CA_POOL_NAME, CA_NAME).toString());
      assertThat(response.getName()).contains(CA_NAME);
    }
  }

  @Test
  public void testListCertificateAuthorities() throws IOException {
    privateca.ListCertificateAuthorities.listCertificateAuthority(
        PROJECT_ID, LOCATION, CA_POOL_NAME);
    assertThat(stdOut.toString()).contains(CA_NAME);
  }

  @Test
  public void testEnableDisableCertificateAuthority()
      throws InterruptedException, ExecutionException, IOException {
    privateca.EnableCertificateAuthority.enableCertificateAuthority(
        PROJECT_ID, LOCATION, CA_POOL_NAME, CA_NAME);
    assertThat(stdOut.toString()).contains("Enabled Certificate Authority : " + CA_NAME);
    privateca.DisableCertificateAuthority.disableCertificateAuthority(
        PROJECT_ID, LOCATION, CA_POOL_NAME, CA_NAME);
    assertThat(stdOut.toString()).contains("Disabled Certificate Authority : " + CA_NAME);
  }

  @Test
  public void testDeleteCertificateAuthority()
      throws InterruptedException, ExecutionException, IOException {
    privateca.DeleteCertificateAuthority.deleteCertificateAuthority(
        PROJECT_ID, LOCATION, CA_POOL_NAME, CA_NAME_DELETE);
    assertThat(stdOut.toString())
        .contains("Successfully deleted Certificate Authority : " + CA_NAME_DELETE);
  }

  @Test
  public void testCreateCertificate() throws IOException {
    // Check if the certificate created during setup is successful.
    try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
        CertificateAuthorityServiceClient.create()) {
      CertificateName certificateName =
          CertificateName.of(PROJECT_ID, LOCATION, CA_POOL_NAME, CERTIFICATE_NAME);
      Certificate certificate = certificateAuthorityServiceClient.getCertificate(certificateName);
      assertThat(certificate.getName()).contains(CERTIFICATE_NAME);
    }
  }

  @Test
  public void testListCertificates() throws IOException {
    privateca.ListCertificates.listCertificates(PROJECT_ID, LOCATION, CA_POOL_NAME);
    assertThat(stdOut.toString()).contains(CERTIFICATE_NAME);
  }

  @Test
  public void testRevokeCertificate() throws InterruptedException, ExecutionException, IOException {
    try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
        CertificateAuthorityServiceClient.create()) {
      // Revoke the certificate.
      privateca.RevokeCertificate.revokeCertificate(
          PROJECT_ID, LOCATION, CA_POOL_NAME, CERTIFICATE_NAME);

      // Check if the certificate has revocation details. If it does, then the certificate is
      // considered as revoked.
      CertificateName certificateName =
          CertificateName.of(PROJECT_ID, LOCATION, CA_POOL_NAME, CERTIFICATE_NAME);
      Assert.assertTrue(
          certificateAuthorityServiceClient.getCertificate(certificateName).hasRevocationDetails());
    }
  }
}
