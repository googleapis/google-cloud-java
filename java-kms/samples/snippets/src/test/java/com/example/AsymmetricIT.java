/*
 * Copyright 2018 Google LLC
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

package com.example;

import static junit.framework.Assert.fail;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.rpc.AlreadyExistsException;
import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.kms.v1.CryptoKey;
import com.google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose;
import com.google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionAlgorithm;
import com.google.cloud.kms.v1.CryptoKeyVersionName;
import com.google.cloud.kms.v1.CryptoKeyVersionTemplate;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.cloud.kms.v1.KeyRingName;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
/**
 * Integration (system) tests for {@link Asymmetric}.
 */

@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class AsymmetricIT {
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String LOCATION = "global";
  private static final String KEY_RING = "kms-asymmetric-sample";

  private static final String RSA_DECRYPT_ID = "rsa-decrypt";
  private static final String RSA_SIGN_ID = "rsa-pkcs-sign";
  private static final String EC_SIGN_ID = "ec-sign";

  private static final String RSA_DECRYPT_PATH =
      CryptoKeyVersionName.format(PROJECT_ID, LOCATION, KEY_RING, RSA_DECRYPT_ID, "1");
  private static final String RSA_SIGN_PATH = 
      CryptoKeyVersionName.format(PROJECT_ID, LOCATION, KEY_RING, RSA_SIGN_ID, "1");
  private static final String EC_SIGN_PATH =
      CryptoKeyVersionName.format(PROJECT_ID, LOCATION, KEY_RING, EC_SIGN_ID, "1");

  private static final byte[] MESSAGE = "test message 123".getBytes(StandardCharsets.UTF_8);

  private static KeyManagementServiceClient client;

  private static boolean createKeyHelper(
      String keyId, CryptoKeyPurpose purpose, CryptoKeyVersionAlgorithm algorithm)
      throws GeneralSecurityException, IOException {

    CryptoKey cryptoKey = CryptoKey.newBuilder()
        .setPurpose(purpose)
        .setVersionTemplate(CryptoKeyVersionTemplate.newBuilder().setAlgorithm(algorithm).build())
        .build();

    try {
      client.createCryptoKey(
          KeyRingName.format(PROJECT_ID, LOCATION, KEY_RING),
          keyId,
          cryptoKey);
      return true;
    } catch (AlreadyExistsException e) {
      return false;
    }
  }

  @BeforeClass
  public static void setUpClass() throws Exception {
    // TODO: set application name. https://github.com/googleapis/gax-java/issues/614
    client = KeyManagementServiceClient.create();

    try {
      Snippets.createKeyRing(PROJECT_ID, LOCATION, KEY_RING);
    } catch (AlreadyExistsException e) {
      // If it already exists, we can just continue.
    }

    boolean s1 = createKeyHelper(RSA_DECRYPT_ID, CryptoKeyPurpose.ASYMMETRIC_DECRYPT,
        CryptoKeyVersionAlgorithm.RSA_DECRYPT_OAEP_2048_SHA256);
    boolean s2 = createKeyHelper(RSA_SIGN_ID, CryptoKeyPurpose.ASYMMETRIC_SIGN,
        CryptoKeyVersionAlgorithm.RSA_SIGN_PKCS1_2048_SHA256);
    boolean s3 = createKeyHelper(EC_SIGN_ID, CryptoKeyPurpose.ASYMMETRIC_SIGN,
        CryptoKeyVersionAlgorithm.EC_SIGN_P256_SHA256);

    if (s1 || s2 || s3) {
      // leave time for keys to initialize
      Thread.sleep(20000);
    }
  }

  @Test
  public void testGetPublicKey() throws Exception {
    PublicKey rsaDecryptKey = Asymmetric.getAsymmetricPublicKey(RSA_DECRYPT_PATH);
    assertEquals("invalid RSA key.", "RSA", rsaDecryptKey.getAlgorithm());
    PublicKey rsaSignKey = Asymmetric.getAsymmetricPublicKey(RSA_SIGN_PATH);
    assertEquals("invalid RSA key.", "RSA", rsaSignKey.getAlgorithm());
    PublicKey ecSignKey = Asymmetric.getAsymmetricPublicKey(EC_SIGN_PATH);
    assertEquals("invalid EC key.", "EC", ecSignKey.getAlgorithm());

    String fakeKeyPath = CryptoKeyVersionName.format(
        PROJECT_ID, LOCATION, KEY_RING, "FAKE", "1");
    try {
      Asymmetric.getAsymmetricPublicKey(fakeKeyPath);
      // should throw exception above
      fail("NotFoundException expected for non-existent key");
    } catch (NotFoundException e) {
      // exception expected
    }
  }

  @Test
  public void testRSAEncryptDecrypt() throws Exception {
    byte[] ciphertext = Asymmetric.encryptRSA(RSA_DECRYPT_PATH, MESSAGE);
    assertEquals("incorrect RSA ciphertext length.", 256, ciphertext.length);

    byte[] plaintext = Asymmetric.decryptRSA(RSA_DECRYPT_PATH, ciphertext);
    assertTrue("decryption failed.", Arrays.equals(plaintext, MESSAGE));
  }

  @Test
  public void testRSASignVerify() throws Exception {
    byte[] sig = Asymmetric.signAsymmetric(RSA_SIGN_PATH, MESSAGE);
    assertEquals("invalid signature length", 256, sig.length);

    boolean success = Asymmetric.verifySignatureRSA(RSA_SIGN_PATH, MESSAGE, sig);
    assertTrue("RSA verification failed. Valid message not accepted", success);
    byte[] alt = new byte[256];
    boolean verifiedInvalid = Asymmetric.verifySignatureRSA(RSA_SIGN_PATH, MESSAGE, alt);
    assertFalse("RSA verification failed. Invalid message accepted", verifiedInvalid);
  }

  @Test
  public void testECSignVerify() throws Exception {
    byte[] sig = Asymmetric.signAsymmetric(EC_SIGN_PATH, MESSAGE);
    boolean success = Asymmetric.verifySignatureEC(EC_SIGN_PATH, MESSAGE, sig);
    assertTrue("EC verification failed. Valid message not accepted", success);

    byte[] alt = Asymmetric.signAsymmetric(EC_SIGN_PATH, new byte[16]);
    boolean verifiedInvalid = Asymmetric.verifySignatureEC(EC_SIGN_PATH, MESSAGE, alt);
    assertFalse("EC verification failed. Invalid message accepted", verifiedInvalid);
  }
}
