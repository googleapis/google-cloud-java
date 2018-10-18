/*
 * Copyright 2018 Google Inc.
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

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.Assert.fail;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.services.cloudkms.v1.CloudKMS;
import com.google.api.services.cloudkms.v1.model.CryptoKey;
import com.google.api.services.cloudkms.v1.model.CryptoKeyVersionTemplate;
import com.google.api.services.cloudkms.v1.model.KeyRing;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
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
  private static final String projectId = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String parent = "projects/" + projectId + "/locations/global";
  private static final String keyRing = "kms-asymmetric-sample";
  private static final String message = "test message 123";
  private static final byte[] message_bytes = message.getBytes(StandardCharsets.UTF_8);

  private static final String rsaDecryptId = "rsa-decrypt";
  private static final String rsaSignId = "rsa-sign";
  private static final String ecSignId = "ec-sign";

  private static final String keyParent = parent + "/keyRings/" + keyRing + "/cryptoKeys/";
  private static final String rsaDecrypt = keyParent + rsaDecryptId + "/cryptoKeyVersions/1";
  private static final String rsaSign = keyParent + rsaSignId + "/cryptoKeyVersions/1";
  private static final String ecSign = keyParent + ecSignId + "/cryptoKeyVersions/1";

  private static CloudKMS client;


  private static boolean createKeyHelper(String keyId, String purpose, String algorithm)
      throws NoSuchAlgorithmException, InvalidKeySpecException,
                      NoSuchProviderException, IOException {

    String keyPath = keyParent + keyId + "/cryptoKeyVersions/1";
    try {
      Asymmetric.getAsymmetricPublicKey(client, keyPath);
      // got key; don't need to create one
      return false;
    } catch (GoogleJsonResponseException e) {
      // key doesn't exist. Create it
      CryptoKey cryptoKey = new CryptoKey();
      cryptoKey.setPurpose(purpose);
      CryptoKeyVersionTemplate version = new CryptoKeyVersionTemplate();
      version.setAlgorithm(algorithm);
      cryptoKey.setVersionTemplate(version);

      client.projects().locations().keyRings().cryptoKeys()
            .create(parent + "/keyRings/" + keyRing, cryptoKey)
            .setCryptoKeyId(keyId)
            .execute();
      return true;
    }
  }

  @BeforeClass
  public static void setUpClass() throws Exception {
    client = Asymmetric.createAuthorizedClient();
    try {
      // attempt to create keyRing
      client.projects().locations().keyRings()
            .create(parent, new KeyRing())
            .setKeyRingId(keyRing)
            .execute();
    } catch (IOException e) {
      // keyRing already exists. Skip
    }

    boolean s1 = createKeyHelper(rsaDecryptId, "ASYMMETRIC_DECRYPT","RSA_DECRYPT_OAEP_2048_SHA256");
    boolean s2 = createKeyHelper(rsaSignId, "ASYMMETRIC_SIGN", "RSA_SIGN_PSS_2048_SHA256");
    boolean s3 = createKeyHelper(ecSignId, "ASYMMETRIC_SIGN", "EC_SIGN_P256_SHA256");
    if (s1 || s2 || s3) {
      // leave time for keys to initialize
      Thread.sleep(20000);
    }
  }

  @Test
  public void testGetPublicKey() throws Exception {
    PublicKey rsaDecryptKey = Asymmetric.getAsymmetricPublicKey(client, rsaDecrypt);
    assertEquals("invalid RSA key.", "RSA", rsaDecryptKey.getAlgorithm());
    PublicKey rsaSignKey = Asymmetric.getAsymmetricPublicKey(client, rsaSign);
    assertEquals("invalid RSA key.", "RSA", rsaSignKey.getAlgorithm());
    PublicKey ecSignKey = Asymmetric.getAsymmetricPublicKey(client, ecSign);
    assertEquals("invalid ECDSA key.", "ECDSA", ecSignKey.getAlgorithm());
    String fakeKeyPath = keyParent + "fake-key/cryptoKeyVersions/1";
    try {
      Asymmetric.getAsymmetricPublicKey(client, fakeKeyPath);
      // should throw excpetion above
      fail("GoogleJsonResponseException expected for non-existent key");
    } catch (GoogleJsonResponseException e) {
      // exception expected
    }
  }

  @Test
  public void testRSAEncryptDecrypt() throws Exception {
    byte[] ciphertext = Asymmetric.encryptRSA(message_bytes, client, rsaDecrypt);
    assertEquals("incorrect RSA ciphertext length.", 256, ciphertext.length);

    byte[] plainbytes = Asymmetric.decryptRSA(ciphertext, client, rsaDecrypt);
    assertTrue("decryption failed.", Arrays.equals(message_bytes, plainbytes));
    String plaintext = new String(plainbytes);
    assertEquals("decryption failed.", message, plaintext);
  }

  @Test
  public void testRSASignVerify() throws Exception {
    byte[] sig = Asymmetric.signAsymmetric(message_bytes, client, rsaSign);
    assertEquals("invalid ciphertext length", 256, sig.length);

    boolean success = Asymmetric.verifySignatureRSA(sig, message_bytes, client, rsaSign);
    assertTrue("RSA verification failed. Valid message not accepted", success);
    String changed = message + ".";
    byte[] changedBytes = changed.getBytes(StandardCharsets.UTF_8);
    boolean shouldFail = Asymmetric.verifySignatureRSA(sig, changedBytes, client, rsaSign);
    assertFalse("RSA verification failed. Invalid message accepted", shouldFail);
  }

  @Test
  public void testECSignVerify() throws Exception {
    byte[] sig = Asymmetric.signAsymmetric(message_bytes, client, ecSign);
    assertTrue("invalid ciphertext length", sig.length > 50 && sig.length < 300);

    boolean success = Asymmetric.verifySignatureEC(sig, message_bytes, client, ecSign);
    assertTrue("EC verification failed. Valid message not accepted", success);
    String changed = message + ".";
    byte[] changedBytes = changed.getBytes(StandardCharsets.UTF_8);
    boolean shouldFail = Asymmetric.verifySignatureEC(sig, changedBytes, client, ecSign);
    assertFalse("EC verification failed. Invalid message accepted", shouldFail);
  }

}
