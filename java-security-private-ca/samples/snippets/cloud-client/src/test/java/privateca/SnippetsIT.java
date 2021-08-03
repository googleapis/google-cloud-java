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

import com.google.cloud.security.privateca.v1.CaPoolName;
import com.google.cloud.security.privateca.v1.Certificate;
import com.google.cloud.security.privateca.v1.CertificateAuthority;
import com.google.cloud.security.privateca.v1.CertificateAuthorityName;
import com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient;
import com.google.cloud.security.privateca.v1.CertificateName;
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
  private static String CA_POOL_NAME;
  private static String CA_POOL_NAME_DELETE;
  private static String CA_NAME;
  private static String CA_NAME_DELETE;
  private static String CERTIFICATE_NAME;
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
          InterruptedException {
    reqEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    reqEnvVar("GOOGLE_CLOUD_PROJECT");

    LOCATION = "asia-south1";
    CA_POOL_NAME = "ca-pool-" + UUID.randomUUID().toString();
    CA_POOL_NAME_DELETE = "ca-pool-" + UUID.randomUUID().toString();
    CA_NAME = "ca-name-" + UUID.randomUUID().toString();
    CA_NAME_DELETE = "ca-name-" + UUID.randomUUID().toString();
    CERTIFICATE_NAME = "certificate-name-" + UUID.randomUUID().toString();
    KEY_SIZE = 2048; // Default key size

    // Create CA Pool.
    privateca.CreateCaPool.createCaPool(PROJECT_ID, LOCATION, CA_POOL_NAME);
    privateca.CreateCaPool.createCaPool(PROJECT_ID, LOCATION, CA_POOL_NAME_DELETE);
    sleep(5);

    // Create and Enable Certificate Authorities.
    privateca.CreateCertificateAuthority.createCertificateAuthority(
        PROJECT_ID, LOCATION, CA_POOL_NAME, CA_NAME);
    privateca.CreateCertificateAuthority.createCertificateAuthority(
        PROJECT_ID, LOCATION, CA_POOL_NAME, CA_NAME_DELETE);
    sleep(10);
    privateca.EnableCertificateAuthority.enableCertificateAuthority(
        PROJECT_ID, LOCATION, CA_POOL_NAME, CA_NAME);

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
        PROJECT_ID, LOCATION, CA_POOL_NAME, CA_NAME, CERTIFICATE_NAME, publicKeyByteString);
    sleep(5);
  }

  @AfterClass
  public static void cleanUp() throws InterruptedException, ExecutionException, IOException {

    ByteArrayOutputStream stdOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(stdOut));

    // Delete CA and CA pool.
    privateca.DeleteCertificateAuthority.deleteCertificateAuthority(
        PROJECT_ID, LOCATION, CA_POOL_NAME, CA_NAME);
    sleep(5);
    privateca.DeleteCaPool.deleteCaPool(PROJECT_ID, LOCATION, CA_POOL_NAME);

    stdOut = null;
    System.setOut(null);
  }

  // Wait for the specified amount of time.
  public static void sleep(int seconds) throws InterruptedException {
    TimeUnit.SECONDS.sleep(seconds);
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
