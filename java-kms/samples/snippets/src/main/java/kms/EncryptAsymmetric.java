/*
 * Copyright 2020 Google LLC
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

// [START kms_encrypt_asymmetric]
import com.google.cloud.kms.v1.CryptoKeyVersionName;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.cloud.kms.v1.PublicKey;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.stream.Collectors;
import javax.crypto.Cipher;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

public class EncryptAsymmetric {

  public void encryptAsymmetric() throws IOException, GeneralSecurityException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String locationId = "us-east1";
    String keyRingId = "my-key-ring";
    String keyId = "my-key";
    String keyVersionId = "123";
    String plaintext = "Plaintext to encrypt";
    encryptAsymmetric(projectId, locationId, keyRingId, keyId, keyVersionId, plaintext);
  }

  // Encrypt data that was encrypted using the public key component of the given
  // key version.
  public void encryptAsymmetric(
      String projectId,
      String locationId,
      String keyRingId,
      String keyId,
      String keyVersionId,
      String plaintext)
      throws IOException, GeneralSecurityException {
    // Initialize client that will be used to send requests. This client only
    // needs to be created once, and can be reused for multiple requests. After
    // completing all of your requests, call the "close" method on the client to
    // safely clean up any remaining background resources.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      // Build the key version name from the project, location, key ring, key,
      // and key version.
      CryptoKeyVersionName keyVersionName =
          CryptoKeyVersionName.of(projectId, locationId, keyRingId, keyId, keyVersionId);

      // Get the public key.
      PublicKey publicKey = client.getPublicKey(keyVersionName);

      // Convert the public PEM key to a DER key (see helper below).
      byte[] derKey = convertPemToDer(publicKey.getPem());
      X509EncodedKeySpec keySpec = new X509EncodedKeySpec(derKey);
      java.security.PublicKey rsaKey = KeyFactory.getInstance("RSA").generatePublic(keySpec);

      // Encrypt plaintext for the 'RSA_DECRYPT_OAEP_2048_SHA256' key.
      // For other key algorithms:
      // https://docs.oracle.com/javase/7/docs/api/javax/crypto/Cipher.html
      Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
      OAEPParameterSpec oaepParams =
          new OAEPParameterSpec(
              "SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT);
      cipher.init(Cipher.ENCRYPT_MODE, rsaKey, oaepParams);
      byte[] ciphertext = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
      System.out.printf("Ciphertext: %s%n", ciphertext);
    }
  }

  // Converts a base64-encoded PEM certificate like the one returned from Cloud
  // KMS into a DER formatted certificate for use with the Java APIs.
  private byte[] convertPemToDer(String pem) {
    BufferedReader bufferedReader = new BufferedReader(new StringReader(pem));
    String encoded =
        bufferedReader
            .lines()
            .filter(line -> !line.startsWith("-----BEGIN") && !line.startsWith("-----END"))
            .collect(Collectors.joining());
    return Base64.getDecoder().decode(encoded);
  }
}
// [END kms_encrypt_asymmetric]
