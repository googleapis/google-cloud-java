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

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.cloudkms.v1.CloudKMS;
import com.google.api.services.cloudkms.v1.CloudKMSScopes;
import com.google.api.services.cloudkms.v1.model.AsymmetricDecryptRequest;
import com.google.api.services.cloudkms.v1.model.AsymmetricDecryptResponse;
import com.google.api.services.cloudkms.v1.model.AsymmetricSignRequest;
import com.google.api.services.cloudkms.v1.model.AsymmetricSignResponse;
import com.google.api.services.cloudkms.v1.model.Digest;
import com.google.api.services.cloudkms.v1.model.KeyRing;
import com.google.api.services.cloudkms.v1.model.ListKeyRingsResponse;
import java.io.IOException;
import java.io.StringReader;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.io.pem.PemReader;

@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class Asymmetric {

  // [START kms_get_asymmetric_public]
  /**
   * Retrieves the public key from a saved asymmetric key pair on Cloud KMS 
   *
   * Requires:
   *   java.io.StringReader
   *   java.security.KeyFactory
   *   java.security.PublicKey
   *   java.security.Security
   *   java.security.spec.X509EncodedKeySpec
   *   org.bouncycastle.jce.provider.BouncyCastleProvider
   *   org.bouncycastle.util.io.pem.PemReader
   */
  public static PublicKey getAsymmetricPublicKey(CloudKMS client, String keyPath) 
      throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, 
      NoSuchProviderException {
    Security.addProvider(new BouncyCastleProvider());
    com.google.api.services.cloudkms.v1.model.PublicKey response;
    response = client.projects()
                     .locations()
                     .keyRings()
                     .cryptoKeys()
                     .cryptoKeyVersions()
                     .getPublicKey(keyPath)
                     .execute();
    PemReader reader = new PemReader(new StringReader(response.getPem()));
    byte[] pem = reader.readPemObject().getContent();
    X509EncodedKeySpec abstractKey = new X509EncodedKeySpec(pem);
    try {
      return KeyFactory.getInstance("RSA", "BC").generatePublic(abstractKey);
    } catch (InvalidKeySpecException e) {
      return KeyFactory.getInstance("ECDSA", "BC").generatePublic(abstractKey);
    }
  }
  // [END kms_get_asymmetric_public]

  // [START kms_decrypt_rsa]
  /**
   * Decrypt a given ciphertext using an 'RSA_DECRYPT_OAEP_2048_SHA256' private key 
   * stored on Cloud KMS
   */
  public static byte[] decryptRSA(byte[] ciphertext, CloudKMS client, String keyPath) 
      throws IOException {
    AsymmetricDecryptRequest request = new AsymmetricDecryptRequest().encodeCiphertext(ciphertext);
    AsymmetricDecryptResponse response = client.projects()
                                               .locations()
                                               .keyRings()
                                               .cryptoKeys()
                                               .cryptoKeyVersions()
                                               .asymmetricDecrypt(keyPath, request)
                                               .execute();
    return response.decodePlaintext();
  }
  // [END kms_decrypt_rsa]

  // [START kms_encrypt_rsa]
  /**
   * Encrypt data locally using an 'RSA_DECRYPT_OAEP_2048_SHA256' public key 
   * retrieved from Cloud KMS
   *
   * Requires:
   *   java.security.PublicKey
   *   java.security.Security
   *   javax.crypto.Cipher
   *   org.bouncycastle.jce.provider.BouncyCastleProvider
   */
  public static byte[] encryptRSA(byte[] plaintext, CloudKMS client, String keyPath)
      throws IOException, IllegalBlockSizeException, NoSuchPaddingException,
             InvalidKeySpecException, NoSuchProviderException, BadPaddingException,
             NoSuchAlgorithmException, InvalidKeyException {
    Security.addProvider(new BouncyCastleProvider());
    PublicKey rsaKey = getAsymmetricPublicKey(client, keyPath);

    Cipher cipher = Cipher.getInstance("RSA/NONE/OAEPWITHSHA256ANDMGF1PADDING", "BC");
    cipher.init(Cipher.ENCRYPT_MODE, rsaKey);
    return cipher.doFinal(plaintext);
  }
  // [END kms_encrypt_rsa]

  // [START kms_sign_asymmetric]
  /** Create a signature for a message using a private key stored on Cloud KMS 
    *
    * Requires:
    *   java.security.MessageDigest
    *   java.util.Base64
    */
  public static byte[] signAsymmetric(byte[] message, CloudKMS client, String keyPath)
      throws IOException, NoSuchAlgorithmException {
    Digest digest = new Digest();
    // Note: some key algorithms will require a different hash function
    // For example, EC_SIGN_P384_SHA384 requires SHA-384
    digest.encodeSha256(MessageDigest.getInstance("SHA-256").digest(message));

    AsymmetricSignRequest signRequest = new AsymmetricSignRequest();
    signRequest.setDigest(digest);

    AsymmetricSignResponse response = client.projects()
                                            .locations()
                                            .keyRings()
                                            .cryptoKeys()
                                            .cryptoKeyVersions()
                                            .asymmetricSign(keyPath, signRequest)
                                            .execute();
    return Base64.getMimeDecoder().decode(response.getSignature());
  }
  // [END kms_sign_asymmetric]

  // [START kms_verify_signature_rsa]
  /**
   * Verify the validity of an 'RSA_SIGN_PSS_2048_SHA256' signature for the 
   * specified message
   *
   * Requires:
   *   java.security.PublicKey
   *   java.security.Security
   *   java.security.Signature
   *   org.bouncycastle.jce.provider.BouncyCastleProvider
   */
  public static boolean verifySignatureRSA(byte[] signature, byte[] message, CloudKMS client, 
      String keyPath) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, 
      SignatureException, NoSuchProviderException, InvalidKeyException {
    Security.addProvider(new BouncyCastleProvider());
    PublicKey rsaKey = getAsymmetricPublicKey(client, keyPath);

    Signature rsaVerify = Signature.getInstance("SHA256withRSA/PSS");

    rsaVerify.initVerify(rsaKey);
    rsaVerify.update(message);
    return rsaVerify.verify(signature);
  }
  // [END kms_verify_signature_rsa]

  // [START kms_verify_signature_ec]
  /** 
   * Verify the validity of an 'EC_SIGN_P256_SHA256' signature for the 
   * specified message
   * 
   * Requires:
   *   java.security.PublicKey
   *   java.security.Security
   *   java.security.Signature
   *   org.bouncycastle.jce.provider.BouncyCastleProvider
   */
  public static boolean verifySignatureEC(byte[] signature, byte[] message, CloudKMS client, 
      String keyPath) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, 
      SignatureException, NoSuchProviderException, InvalidKeyException {
    Security.addProvider(new BouncyCastleProvider());
    PublicKey ecKey = getAsymmetricPublicKey(client, keyPath);

    Signature ecVerify = Signature.getInstance("SHA256withECDSA", "BC");

    ecVerify.initVerify(ecKey);
    ecVerify.update(message);
    return ecVerify.verify(signature);
  }
  // [END kms_verify_signature_ec]

  public static CloudKMS createAuthorizedClient() throws IOException {
    HttpTransport transport = new NetHttpTransport();
    JsonFactory jsonFactory = new JacksonFactory();
    GoogleCredential credential = GoogleCredential.getApplicationDefault(transport, jsonFactory);
    if (credential.createScopedRequired()) {
      credential = credential.createScoped(CloudKMSScopes.all());
    }
    return new CloudKMS.Builder(transport, jsonFactory, credential)
      .setApplicationName("CloudKMS snippets")
      .build();
  }

}

