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

import com.google.cloud.kms.v1.AsymmetricDecryptResponse;
import com.google.cloud.kms.v1.AsymmetricSignRequest;
import com.google.cloud.kms.v1.AsymmetricSignResponse;
import com.google.cloud.kms.v1.CryptoKey;
import com.google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose;
import com.google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionAlgorithm;
import com.google.cloud.kms.v1.CryptoKeyVersionTemplate;
import com.google.cloud.kms.v1.Digest;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.cloud.kms.v1.KeyRingName;
import com.google.common.io.BaseEncoding;
import com.google.protobuf.ByteString;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class Asymmetric {

  // [START kms_create_asymmetric_key]
  /**
   * Creates an RSA encrypt/decrypt key pair with the given id.
   */
  public static CryptoKey createAsymmetricKey(String projectId, String locationId, String keyRingId,
      String cryptoKeyId)
      throws IOException {

    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      String parent = KeyRingName.format(projectId, locationId, keyRingId);

      CryptoKeyPurpose purpose = CryptoKeyPurpose.ASYMMETRIC_DECRYPT;
      CryptoKeyVersionAlgorithm algorithm = CryptoKeyVersionAlgorithm.RSA_DECRYPT_OAEP_2048_SHA256;

      CryptoKeyVersionTemplate version = CryptoKeyVersionTemplate.newBuilder()
          .setAlgorithm(algorithm)
          .build();
      CryptoKey cryptoKey = CryptoKey.newBuilder()
          .setPurpose(purpose)
          .setVersionTemplate(version)
          .build();

      CryptoKey createdKey = client.createCryptoKey(parent, cryptoKeyId, cryptoKey);

      return createdKey;
    }
  }
  // [END kms_create_asymmetric_key]

  // [START kms_get_asymmetric_public]
  /**
   * Retrieves the public key from a saved asymmetric key pair on Cloud KMS
   *
   * Example keyName:
   *   "projects/PROJECT_ID/locations/global/keyRings/RING_ID/cryptoKeys/KEY_ID/cryptoKeyVersions/1"
   */
  public static PublicKey getAsymmetricPublicKey(String keyName) 
      throws IOException, GeneralSecurityException {

    // Create the Cloud KMS client.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      com.google.cloud.kms.v1.PublicKey pub = client.getPublicKey(keyName);

      // Convert a PEM key to DER without taking a dependency on a third party library
      String pemKey = pub.getPem();
      pemKey = pemKey.replaceFirst("-----BEGIN PUBLIC KEY-----", "");
      pemKey = pemKey.replaceFirst("-----END PUBLIC KEY-----", "");
      pemKey = pemKey.replaceAll("\\s", "");
      byte[] derKey = BaseEncoding.base64().decode(pemKey);

      X509EncodedKeySpec keySpec = new X509EncodedKeySpec(derKey);

      if (pub.getAlgorithm().name().contains("RSA")) {
        return KeyFactory.getInstance("RSA").generatePublic(keySpec);
      } else if (pub.getAlgorithm().name().contains("EC")) {
        return KeyFactory.getInstance("EC").generatePublic(keySpec);
      } else {
        throw new UnsupportedOperationException(String.format(
            "key at path '%s' is of unsupported type '%s'.", keyName, pub.getAlgorithm()));
      }
    }
  }
  // [END kms_get_asymmetric_public]

  // [START kms_decrypt_rsa]
  /**
   * Decrypt a given ciphertext using an 'RSA_DECRYPT_OAEP_2048_SHA256' private key
   * stored on Cloud KMS
   *
   * Example keyName:
   *   "projects/PROJECT_ID/locations/global/keyRings/RING_ID/cryptoKeys/KEY_ID/cryptoKeyVersions/1"
   */
  public static byte[] decryptRSA(String keyName, byte[] ciphertext) throws IOException {
    // Create the Cloud KMS client.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      AsymmetricDecryptResponse response = client.asymmetricDecrypt(
          keyName, ByteString.copyFrom(ciphertext));
      return response.getPlaintext().toByteArray();
    }
  }
  // [END kms_decrypt_rsa]

  // [START kms_encrypt_rsa]
  /**
   * Encrypt data locally using an 'RSA_DECRYPT_OAEP_2048_SHA256' public key 
   * retrieved from Cloud KMS
   *
   * Example keyName:
   *   "projects/PROJECT_ID/locations/global/keyRings/RING_ID/cryptoKeys/KEY_ID/cryptoKeyVersions/1"
   */
  public static byte[] encryptRSA(String keyName, byte[] plaintext) 
      throws IOException, GeneralSecurityException {
    // Create the Cloud KMS client.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      // Get the public key
      com.google.cloud.kms.v1.PublicKey pub = client.getPublicKey(keyName);
      String pemKey = pub.getPem();
      pemKey = pemKey.replaceFirst("-----BEGIN PUBLIC KEY-----", "");
      pemKey = pemKey.replaceFirst("-----END PUBLIC KEY-----", "");
      pemKey = pemKey.replaceAll("\\s", "");
      byte[] derKey = BaseEncoding.base64().decode(pemKey);
      X509EncodedKeySpec keySpec = new X509EncodedKeySpec(derKey);
      PublicKey rsaKey = KeyFactory.getInstance("RSA").generatePublic(keySpec);

      // Encrypt plaintext for the 'RSA_DECRYPT_OAEP_2048_SHA256' key.
      // For other key algorithms:
      // https://docs.oracle.com/javase/7/docs/api/javax/crypto/Cipher.html
      Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
      OAEPParameterSpec oaepParams = new OAEPParameterSpec(
          "SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT);
      cipher.init(Cipher.ENCRYPT_MODE, rsaKey, oaepParams);

      return cipher.doFinal(plaintext);
    }
  }
  // [END kms_encrypt_rsa]

  // [START kms_sign_asymmetric]
  /**
   *  Create a signature for a message using a private key stored on Cloud KMS
   *
   * Example keyName:
   *   "projects/PROJECT_ID/locations/global/keyRings/RING_ID/cryptoKeys/KEY_ID/cryptoKeyVersions/1"
   */
  public static byte[] signAsymmetric(String keyName, byte[] message)
      throws IOException, NoSuchAlgorithmException {
    // Create the Cloud KMS client.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {

      // Note: some key algorithms will require a different hash function
      // For example, EC_SIGN_P384_SHA384 requires SHA-384
      byte[] messageHash = MessageDigest.getInstance("SHA-256").digest(message);

      AsymmetricSignRequest request = AsymmetricSignRequest.newBuilder()
          .setName(keyName)
          .setDigest(Digest.newBuilder().setSha256(ByteString.copyFrom(messageHash)))
          .build();

      AsymmetricSignResponse response = client.asymmetricSign(request);
      return response.getSignature().toByteArray();
    }
  }
  // [END kms_sign_asymmetric]

  // [START kms_verify_signature_rsa]
  /**
   * Verify the validity of an 'RSA_SIGN_PKCS1_2048_SHA256' signature for the 
   * specified message
   *
   * Example keyName:
   *   "projects/PROJECT_ID/locations/global/keyRings/RING_ID/cryptoKeys/KEY_ID/cryptoKeyVersions/1"
   */
  public static boolean verifySignatureRSA(String keyName, byte[] message, byte[] signature)
      throws IOException, GeneralSecurityException {

    // Create the Cloud KMS client.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      // Get the public key
      com.google.cloud.kms.v1.PublicKey pub = client.getPublicKey(keyName);
      String pemKey = pub.getPem();
      pemKey = pemKey.replaceFirst("-----BEGIN PUBLIC KEY-----", "");
      pemKey = pemKey.replaceFirst("-----END PUBLIC KEY-----", "");
      pemKey = pemKey.replaceAll("\\s", "");
      byte[] derKey = BaseEncoding.base64().decode(pemKey);
      X509EncodedKeySpec keySpec = new X509EncodedKeySpec(derKey);
      PublicKey rsaKey = KeyFactory.getInstance("RSA").generatePublic(keySpec);

      // Verify the 'RSA_SIGN_PKCS1_2048_SHA256' signature.
      // For other key algorithms:
      // http://docs.oracle.com/javase/7/docs/technotes/guides/security/StandardNames.html#Signature
      Signature rsaVerify = Signature.getInstance("SHA256withRSA");
      rsaVerify.initVerify(rsaKey);
      rsaVerify.update(message);
      return rsaVerify.verify(signature);
    }
  }
  // [END kms_verify_signature_rsa]

  // [START kms_verify_signature_ec]
  /** 
   * Verify the validity of an 'EC_SIGN_P256_SHA256' signature for the 
   * specified message
   *
   * Example keyName:
   *   "projects/PROJECT_ID/locations/global/keyRings/RING_ID/cryptoKeys/KEY_ID/cryptoKeyVersions/1"
   */
  public static boolean verifySignatureEC(String keyName, byte[] message, byte[] signature)
      throws IOException, GeneralSecurityException {

    // Create the Cloud KMS client.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      // Get the public key
      com.google.cloud.kms.v1.PublicKey pub = client.getPublicKey(keyName);
      String pemKey = pub.getPem();
      pemKey = pemKey.replaceFirst("-----BEGIN PUBLIC KEY-----", "");
      pemKey = pemKey.replaceFirst("-----END PUBLIC KEY-----", "");
      pemKey = pemKey.replaceAll("\\s", "");
      byte[] derKey = BaseEncoding.base64().decode(pemKey);
      X509EncodedKeySpec keySpec = new X509EncodedKeySpec(derKey);
      PublicKey ecKey = KeyFactory.getInstance("EC").generatePublic(keySpec);

      // Verify the 'EC_SIGN_P256_SHA256' signature
      // For other key algorithms:
      // http://docs.oracle.com/javase/7/docs/technotes/guides/security/StandardNames.html#Signature
      Signature ecVerify = Signature.getInstance("SHA256withECDSA");
      ecVerify.initVerify(ecKey);
      ecVerify.update(message);
      return ecVerify.verify(signature);
    }
  }
  // [END kms_verify_signature_ec]
}

