/*
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package kms;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.kms.v1.CryptoKey;
import com.google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose;
import com.google.cloud.kms.v1.CryptoKeyName;
import com.google.cloud.kms.v1.CryptoKeyVersion;
import com.google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionAlgorithm;
import com.google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState;
import com.google.cloud.kms.v1.CryptoKeyVersionName;
import com.google.cloud.kms.v1.CryptoKeyVersionTemplate;
import com.google.cloud.kms.v1.Digest;
import com.google.cloud.kms.v1.EncryptResponse;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.cloud.kms.v1.KeyRing;
import com.google.cloud.kms.v1.KeyRingName;
import com.google.cloud.kms.v1.ListCryptoKeyVersionsRequest;
import com.google.cloud.kms.v1.LocationName;
import com.google.cloud.kms.v1.MacSignResponse;
import com.google.cloud.kms.v1.ProtectionLevel;
import com.google.cloud.kms.v1.PublicKey;
import com.google.common.base.Strings;
import com.google.protobuf.ByteString;
import com.google.protobuf.FieldMask;
import com.google.protobuf.util.FieldMaskUtil;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.UUID;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import javax.crypto.Cipher;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
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
  private static final String LOCATION_ID = "us-east1";

  private static String KEY_RING_ID;
  private static String ASYMMETRIC_DECRYPT_KEY_ID;
  private static String ASYMMETRIC_SIGN_EC_KEY_ID;
  private static String ASYMMETRIC_SIGN_RSA_KEY_ID;
  private static String HSM_KEY_ID;
  private static String MAC_KEY_ID;
  private static String SYMMETRIC_KEY_ID;

  private ByteArrayOutputStream stdOut;

  @BeforeClass
  public static void beforeAll() throws IOException {
    Assert.assertFalse("missing GOOGLE_CLOUD_PROJECT", Strings.isNullOrEmpty(PROJECT_ID));

    KEY_RING_ID = getRandomId();
    createKeyRing(KEY_RING_ID);

    ASYMMETRIC_DECRYPT_KEY_ID = getRandomId();
    createAsymmetricDecryptKey(ASYMMETRIC_DECRYPT_KEY_ID);

    ASYMMETRIC_SIGN_EC_KEY_ID = getRandomId();
    createAsymmetricSignEcKey(ASYMMETRIC_SIGN_EC_KEY_ID);

    ASYMMETRIC_SIGN_RSA_KEY_ID = getRandomId();
    createAsymmetricSignRsaKey(ASYMMETRIC_SIGN_RSA_KEY_ID);

    HSM_KEY_ID = getRandomId();
    createHsmKey(HSM_KEY_ID);

    MAC_KEY_ID = getRandomId();
    createMacKey(MAC_KEY_ID);

    SYMMETRIC_KEY_ID = getRandomId();
    createSymmetricKey(SYMMETRIC_KEY_ID);
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

  @AfterClass
  public static void afterAll() throws IOException {
    Assert.assertFalse("missing GOOGLE_CLOUD_PROJECT", Strings.isNullOrEmpty(PROJECT_ID));

    // Iterate over each key ring's key's crypto key versions and destroy.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      for (CryptoKey key : client.listCryptoKeys(getKeyRingName()).iterateAll()) {
        if (key.hasRotationPeriod() || key.hasNextRotationTime()) {
          CryptoKey keyWithoutRotation = CryptoKey.newBuilder().setName(key.getName()).build();
          FieldMask fieldMask = FieldMaskUtil.fromString("rotation_period,next_rotation_time");
          client.updateCryptoKey(keyWithoutRotation, fieldMask);
        }

        ListCryptoKeyVersionsRequest listVersionsRequest =
            ListCryptoKeyVersionsRequest.newBuilder()
                .setParent(key.getName())
                .setFilter("state != DESTROYED AND state != DESTROY_SCHEDULED")
                .build();
        for (CryptoKeyVersion version :
            client.listCryptoKeyVersions(listVersionsRequest).iterateAll()) {
          client.destroyCryptoKeyVersion(version.getName());
        }
      }
    }
  }

  private static LocationName getLocationName() {
    return LocationName.of(PROJECT_ID, LOCATION_ID);
  }

  private static KeyRingName getKeyRingName() {
    return KeyRingName.of(PROJECT_ID, LOCATION_ID, KEY_RING_ID);
  }

  private static String getRandomId() {
    UUID uuid = UUID.randomUUID();
    return uuid.toString();
  }

  private static KeyRing createKeyRing(String keyRingId) throws IOException {
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      KeyRing keyRing = KeyRing.newBuilder().build();
      KeyRing createdKeyRing = client.createKeyRing(getLocationName(), keyRingId, keyRing);
      return createdKeyRing;
    }
  }

  private static CryptoKey createAsymmetricDecryptKey(String keyId) throws IOException {
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      CryptoKey key =
          CryptoKey.newBuilder()
              .setPurpose(CryptoKeyPurpose.ASYMMETRIC_DECRYPT)
              .setVersionTemplate(
                  CryptoKeyVersionTemplate.newBuilder()
                      .setAlgorithm(CryptoKeyVersionAlgorithm.RSA_DECRYPT_OAEP_2048_SHA256)
                      .build())
              .putLabels("foo", "bar")
              .putLabels("zip", "zap")
              .build();
      CryptoKey createdKey = client.createCryptoKey(getKeyRingName(), keyId, key);
      return createdKey;
    }
  }

  private static CryptoKey createAsymmetricSignEcKey(String keyId) throws IOException {
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      CryptoKey key =
          CryptoKey.newBuilder()
              .setPurpose(CryptoKeyPurpose.ASYMMETRIC_SIGN)
              .setVersionTemplate(
                  CryptoKeyVersionTemplate.newBuilder()
                      .setAlgorithm(CryptoKeyVersionAlgorithm.EC_SIGN_P256_SHA256)
                      .build())
              .putLabels("foo", "bar")
              .putLabels("zip", "zap")
              .build();
      CryptoKey createdKey = client.createCryptoKey(getKeyRingName(), keyId, key);
      return createdKey;
    }
  }

  private static CryptoKey createAsymmetricSignRsaKey(String keyId) throws IOException {
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      CryptoKey key =
          CryptoKey.newBuilder()
              .setPurpose(CryptoKeyPurpose.ASYMMETRIC_SIGN)
              .setVersionTemplate(
                  CryptoKeyVersionTemplate.newBuilder()
                      .setAlgorithm(CryptoKeyVersionAlgorithm.RSA_SIGN_PSS_2048_SHA256)
                      .build())
              .putLabels("foo", "bar")
              .putLabels("zip", "zap")
              .build();
      CryptoKey createdKey = client.createCryptoKey(getKeyRingName(), keyId, key);
      return createdKey;
    }
  }

  private static CryptoKey createHsmKey(String keyId) throws IOException {
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      CryptoKey key =
          CryptoKey.newBuilder()
              .setPurpose(CryptoKeyPurpose.ENCRYPT_DECRYPT)
              .setVersionTemplate(
                  CryptoKeyVersionTemplate.newBuilder()
                      .setAlgorithm(CryptoKeyVersionAlgorithm.GOOGLE_SYMMETRIC_ENCRYPTION)
                      .setProtectionLevel(ProtectionLevel.HSM)
                      .build())
              .putLabels("foo", "bar")
              .putLabels("zip", "zap")
              .build();
      CryptoKey createdKey = client.createCryptoKey(getKeyRingName(), keyId, key);
      return createdKey;
    }
  }

  private static CryptoKey createMacKey(String keyId) throws IOException {
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      CryptoKey key =
          CryptoKey.newBuilder()
              .setPurpose(CryptoKeyPurpose.MAC)
              .setVersionTemplate(
                  CryptoKeyVersionTemplate.newBuilder()
                      .setAlgorithm(CryptoKeyVersionAlgorithm.HMAC_SHA256)
                      .setProtectionLevel(ProtectionLevel.HSM)
                      .build())
              .putLabels("foo", "bar")
              .putLabels("zip", "zap")
              .build();
      CryptoKey createdKey = client.createCryptoKey(getKeyRingName(), keyId, key);
      return createdKey;
    }
  }

  private static CryptoKey createSymmetricKey(String keyId) throws IOException {
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      CryptoKey key =
          CryptoKey.newBuilder()
              .setPurpose(CryptoKeyPurpose.ENCRYPT_DECRYPT)
              .setVersionTemplate(
                  CryptoKeyVersionTemplate.newBuilder()
                      .setAlgorithm(CryptoKeyVersionAlgorithm.GOOGLE_SYMMETRIC_ENCRYPTION)
                      .build())
              .putLabels("foo", "bar")
              .putLabels("zip", "zap")
              .build();
      CryptoKey createdKey = client.createCryptoKey(getKeyRingName(), keyId, key);
      return createdKey;
    }
  }

  private static CryptoKeyVersion createKeyVersion(String keyId)
      throws IOException, InterruptedException, TimeoutException {
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      CryptoKeyName keyName = CryptoKeyName.of(PROJECT_ID, LOCATION_ID, KEY_RING_ID, keyId);
      CryptoKeyVersion keyVersion = CryptoKeyVersion.newBuilder().build();
      CryptoKeyVersion createdVersion = client.createCryptoKeyVersion(keyName, keyVersion);

      for (int i = 1; i <= 5; i++) {
        CryptoKeyVersion gotVersion = client.getCryptoKeyVersion(createdVersion.getName());
        if (gotVersion.getState() == CryptoKeyVersionState.ENABLED) {
          return gotVersion;
        }

        Thread.sleep(500 * i);
      }

      throw new TimeoutException("key version not ready in timeout");
    }
  }

  private static byte[] convertPemToDer(String pem) {
    BufferedReader bufferedReader = new BufferedReader(new StringReader(pem));
    String encoded =
        bufferedReader
            .lines()
            .filter(line -> !line.startsWith("-----BEGIN") && !line.startsWith("-----END"))
            .collect(Collectors.joining());
    return Base64.getDecoder().decode(encoded);
  }

  @Test
  public void testQuickstart() throws IOException {
    new Quickstart().quickstart(PROJECT_ID, LOCATION_ID);
    assertThat(stdOut.toString()).contains("key rings");
  }

  @Test
  public void testCreateKeyAsymmetricDecrypt() throws IOException {
    new CreateKeyAsymmetricDecrypt()
        .createKeyAsymmetricDecrypt(PROJECT_ID, LOCATION_ID, KEY_RING_ID, getRandomId());
    assertThat(stdOut.toString()).contains("Created asymmetric key");
  }

  @Test
  public void testCreateKeyAsymmetricSign() throws IOException {
    new CreateKeyAsymmetricSign()
        .createKeyAsymmetricSign(PROJECT_ID, LOCATION_ID, KEY_RING_ID, getRandomId());
    assertThat(stdOut.toString()).contains("Created asymmetric key");
  }

  @Test
  public void testCreateKeyHsm() throws IOException {
    new CreateKeyHsm().createKeyHsm(PROJECT_ID, LOCATION_ID, KEY_RING_ID, getRandomId());
    assertThat(stdOut.toString()).contains("Created hsm key");
  }

  @Test
  public void testCreateKeyLabels() throws IOException {
    new CreateKeyLabels().createKeyLabels(PROJECT_ID, LOCATION_ID, KEY_RING_ID, getRandomId());
    assertThat(stdOut.toString()).contains("Created key with labels");
  }

  @Test
  public void testCreateKeyMac() throws IOException {
    new CreateKeyMac().createKeyMac(PROJECT_ID, LOCATION_ID, KEY_RING_ID, getRandomId());
    assertThat(stdOut.toString()).contains("Created mac key");
  }

  @Test
  public void testCreateKeyRing() throws IOException {
    new CreateKeyRing().createKeyRing(PROJECT_ID, LOCATION_ID, getRandomId());
    assertThat(stdOut.toString()).contains("Created key ring");
  }

  @Test
  public void testCreateKeyRotationSchedule() throws IOException {
    new CreateKeyRotationSchedule()
        .createKeyRotationSchedule(PROJECT_ID, LOCATION_ID, KEY_RING_ID, getRandomId());
    assertThat(stdOut.toString()).contains("Created key with rotation");
  }

  @Test
  public void testCreateKeySymmetricEncryptDecrypt() throws IOException {
    new CreateKeySymmetricEncryptDecrypt()
        .createKeySymmetricEncryptDecrypt(PROJECT_ID, LOCATION_ID, KEY_RING_ID, getRandomId());
    assertThat(stdOut.toString()).contains("Created symmetric key");
  }

  @Test
  public void testCreateKeyVersion() throws IOException {
    new CreateKeyVersion().createKeyVersion(PROJECT_ID, LOCATION_ID, KEY_RING_ID, SYMMETRIC_KEY_ID);
    assertThat(stdOut.toString()).contains("Created key version");
  }

  @Test
  public void testDecryptAsymmetric() throws IOException, GeneralSecurityException {
    String plaintext = "my message";
    byte[] ciphertext;

    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      CryptoKeyVersionName keyVersionName =
          CryptoKeyVersionName.of(
              PROJECT_ID, LOCATION_ID, KEY_RING_ID, ASYMMETRIC_DECRYPT_KEY_ID, "1");
      PublicKey publicKey = client.getPublicKey(keyVersionName);

      byte[] derKey = convertPemToDer(publicKey.getPem());
      X509EncodedKeySpec keySpec = new X509EncodedKeySpec(derKey);
      java.security.PublicKey rsaKey = KeyFactory.getInstance("RSA").generatePublic(keySpec);

      Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
      OAEPParameterSpec oaepParams =
          new OAEPParameterSpec(
              "SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT);
      cipher.init(Cipher.ENCRYPT_MODE, rsaKey, oaepParams);
      ciphertext = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
    }

    new DecryptAsymmetric()
        .decryptAsymmetric(
            PROJECT_ID, LOCATION_ID, KEY_RING_ID, ASYMMETRIC_DECRYPT_KEY_ID, "1", ciphertext);
    assertThat(stdOut.toString()).contains("my message");
  }

  @Test
  public void testDecryptSymmetric() throws IOException {
    String plaintext = "my plaintext";
    byte[] ciphertext;

    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      CryptoKeyName keyName =
          CryptoKeyName.of(PROJECT_ID, LOCATION_ID, KEY_RING_ID, SYMMETRIC_KEY_ID);
      EncryptResponse result = client.encrypt(keyName, ByteString.copyFromUtf8(plaintext));
      ciphertext = result.getCiphertext().toByteArray();
    }

    new DecryptSymmetric()
        .decryptSymmetric(PROJECT_ID, LOCATION_ID, KEY_RING_ID, SYMMETRIC_KEY_ID, ciphertext);
    assertThat(stdOut.toString()).contains(plaintext);
  }

  @Test
  public void testDestroyRestoreKeyVersion()
      throws IOException, InterruptedException, TimeoutException {
    CryptoKeyVersion keyVersion = createKeyVersion(ASYMMETRIC_DECRYPT_KEY_ID);
    String name = keyVersion.getName();
    String keyVersionId = name.substring(name.lastIndexOf('/') + 1);

    new DestroyKeyVersion()
        .destroyKeyVersion(
            PROJECT_ID, LOCATION_ID, KEY_RING_ID, ASYMMETRIC_DECRYPT_KEY_ID, keyVersionId);
    assertThat(stdOut.toString()).contains("Destroyed key version");

    new RestoreKeyVersion()
        .restoreKeyVersion(
            PROJECT_ID, LOCATION_ID, KEY_RING_ID, ASYMMETRIC_DECRYPT_KEY_ID, keyVersionId);
    assertThat(stdOut.toString()).contains("Restored key version");
  }

  @Test
  public void testDisableEnableKeyVersion() throws Exception {
    CryptoKeyVersion keyVersion = createKeyVersion(ASYMMETRIC_DECRYPT_KEY_ID);
    String name = keyVersion.getName();
    String keyVersionId = name.substring(name.lastIndexOf('/') + 1);

    new DisableKeyVersion()
        .disableKeyVersion(
            PROJECT_ID, LOCATION_ID, KEY_RING_ID, ASYMMETRIC_DECRYPT_KEY_ID, keyVersionId);
    assertThat(stdOut.toString()).contains("Disabled key version");

    new EnableKeyVersion()
        .enableKeyVersion(
            PROJECT_ID, LOCATION_ID, KEY_RING_ID, ASYMMETRIC_DECRYPT_KEY_ID, keyVersionId);
    assertThat(stdOut.toString()).contains("Enabled key version");
  }

  @Test
  public void testEncryptAsymmetric() throws IOException, GeneralSecurityException {
    new EncryptAsymmetric()
        .encryptAsymmetric(
            PROJECT_ID, LOCATION_ID, KEY_RING_ID, ASYMMETRIC_DECRYPT_KEY_ID, "1", "my message");
    assertThat(stdOut.toString()).contains("Ciphertext");
  }

  @Test
  public void testEncryptSymmetric() throws IOException {
    new EncryptSymmetric()
        .encryptSymmetric(PROJECT_ID, LOCATION_ID, KEY_RING_ID, SYMMETRIC_KEY_ID, "my message");
    assertThat(stdOut.toString()).contains("Ciphertext");
  }

  @Test
  public void testGenerateRandomBytes() throws IOException {
    new GenerateRandomBytes().generateRandomBytes(PROJECT_ID, LOCATION_ID, 256);
    assertThat(stdOut.toString()).contains("Random bytes");
  }

  @Test
  public void testGetKeyVersionAttestation() throws IOException {
    new GetKeyVersionAttestation()
        .getKeyVersionAttestation(PROJECT_ID, LOCATION_ID, KEY_RING_ID, HSM_KEY_ID, "1");
    assertThat(stdOut.toString()).contains("CAVIUM");
  }

  @Test
  public void testGetKeyLabels() throws IOException {
    new GetKeyLabels().getKeyLabels(PROJECT_ID, LOCATION_ID, KEY_RING_ID, SYMMETRIC_KEY_ID);
    assertThat(stdOut.toString()).contains("foo=bar");
  }

  @Test
  public void testGetPublicKey() throws IOException, GeneralSecurityException {
    new GetPublicKey()
        .getPublicKey(PROJECT_ID, LOCATION_ID, KEY_RING_ID, ASYMMETRIC_DECRYPT_KEY_ID, "1");
    assertThat(stdOut.toString()).contains("Public key");
  }

  @Test
  public void testIamAddMember() throws IOException {
    new IamAddMember()
        .iamAddMember(
            PROJECT_ID, LOCATION_ID, KEY_RING_ID, SYMMETRIC_KEY_ID, "group:test@google.com");
    assertThat(stdOut.toString()).contains("Updated IAM policy");
  }

  @Test
  public void testIamGetPolicy() throws IOException {
    new IamGetPolicy().iamGetPolicy(PROJECT_ID, LOCATION_ID, KEY_RING_ID, SYMMETRIC_KEY_ID);
    assertThat(stdOut.toString()).contains("IAM policy");
  }

  @Test
  public void testIamRemoveMember() throws IOException {
    new IamRemoveMember()
        .iamRemoveMember(
            PROJECT_ID, LOCATION_ID, KEY_RING_ID, SYMMETRIC_KEY_ID, "group:test@google.com");
    assertThat(stdOut.toString()).contains("Updated IAM policy");
  }

  @Test
  public void testSignAsymmetric() throws IOException, GeneralSecurityException {
    new SignAsymmetric()
        .signAsymmetric(
            PROJECT_ID, LOCATION_ID, KEY_RING_ID, ASYMMETRIC_SIGN_RSA_KEY_ID, "1", "my message");
    assertThat(stdOut.toString()).contains("Signature");
  }

  @Test
  public void testsignMac() throws IOException, GeneralSecurityException {
    new SignMac().signMac(PROJECT_ID, LOCATION_ID, KEY_RING_ID, MAC_KEY_ID, "1", "my message");
    assertThat(stdOut.toString()).contains("Signature");
  }

  @Test
  public void testUpdateKeyAddRotation() throws IOException {
    new UpdateKeyAddRotation()
        .updateKeyAddRotation(PROJECT_ID, LOCATION_ID, KEY_RING_ID, SYMMETRIC_KEY_ID);
    assertThat(stdOut.toString()).contains("Updated key");
  }

  @Test
  public void testUpdateKeyRemoveLabels() throws IOException {
    new UpdateKeyRemoveLabels()
        .updateKeyRemoveLabels(PROJECT_ID, LOCATION_ID, KEY_RING_ID, SYMMETRIC_KEY_ID);
    assertThat(stdOut.toString()).contains("Updated key");
  }

  @Test
  public void testUpdateKeyRemoveRotation() throws IOException {
    new UpdateKeyRemoveRotation()
        .updateKeyRemoveRotation(PROJECT_ID, LOCATION_ID, KEY_RING_ID, SYMMETRIC_KEY_ID);
    assertThat(stdOut.toString()).contains("Updated key");
  }

  @Test
  public void testUpdateKeySetPrimary() throws IOException {
    new UpdateKeySetPrimary()
        .updateKeySetPrimary(PROJECT_ID, LOCATION_ID, KEY_RING_ID, SYMMETRIC_KEY_ID, "1");
    assertThat(stdOut.toString()).contains("Updated key");
  }

  @Test
  public void testUpdateKeyUpdateLabels() throws IOException {
    new UpdateKeyUpdateLabels()
        .updateKeyUpdateLabels(PROJECT_ID, LOCATION_ID, KEY_RING_ID, SYMMETRIC_KEY_ID);
    assertThat(stdOut.toString()).contains("Updated key");
  }

  @Test
  public void testVerifyAsymmetricEc() throws IOException, GeneralSecurityException {
    String message = "my message";
    byte[] signature;

    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      CryptoKeyVersionName versionName =
          CryptoKeyVersionName.of(
              PROJECT_ID, LOCATION_ID, KEY_RING_ID, ASYMMETRIC_SIGN_EC_KEY_ID, "1");

      MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
      byte[] hash = sha256.digest(message.getBytes(StandardCharsets.UTF_8));
      Digest digest = Digest.newBuilder().setSha256(ByteString.copyFrom(hash)).build();

      signature = client.asymmetricSign(versionName, digest).getSignature().toByteArray();
    }

    new VerifyAsymmetricEc()
        .verifyAsymmetricEc(
            PROJECT_ID,
            LOCATION_ID,
            KEY_RING_ID,
            ASYMMETRIC_SIGN_EC_KEY_ID,
            "1",
            message,
            signature);
    assertThat(stdOut.toString()).contains("Signature");
  }

  @Test
  public void testVerifyAsymmetricRsa() throws IOException, GeneralSecurityException {
    String message = "my message";
    byte[] signature;

    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      CryptoKeyVersionName versionName =
          CryptoKeyVersionName.of(
              PROJECT_ID, LOCATION_ID, KEY_RING_ID, ASYMMETRIC_SIGN_RSA_KEY_ID, "1");

      MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
      byte[] hash = sha256.digest(message.getBytes(StandardCharsets.UTF_8));
      Digest digest = Digest.newBuilder().setSha256(ByteString.copyFrom(hash)).build();

      signature = client.asymmetricSign(versionName, digest).getSignature().toByteArray();
    }

    new VerifyAsymmetricRsa()
        .verifyAsymmetricRsa(
            PROJECT_ID,
            LOCATION_ID,
            KEY_RING_ID,
            ASYMMETRIC_SIGN_RSA_KEY_ID,
            "1",
            message,
            signature);
    assertThat(stdOut.toString()).contains("Signature");
  }

  @Test
  public void verifyMac() throws IOException, GeneralSecurityException {
    String data = "my data";

    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      CryptoKeyVersionName versionName =
          CryptoKeyVersionName.of(PROJECT_ID, LOCATION_ID, KEY_RING_ID, MAC_KEY_ID, "1");

      MacSignResponse response = client.macSign(versionName, ByteString.copyFromUtf8(data));

      new VerifyMac()
          .verifyMac(
              PROJECT_ID,
              LOCATION_ID,
              KEY_RING_ID,
              MAC_KEY_ID,
              "1",
              data,
              response.getMac().toByteArray());
      assertThat(stdOut.toString()).contains("Success: true");
    }
  }
}
