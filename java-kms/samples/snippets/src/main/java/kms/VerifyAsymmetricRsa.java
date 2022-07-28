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

// [START kms_verify_asymmetric_signature_rsa]
import com.google.cloud.kms.v1.CryptoKeyVersionName;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.cloud.kms.v1.PublicKey;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.stream.Collectors;

public class VerifyAsymmetricRsa {

  public void verifyAsymmetricRsa() throws IOException, GeneralSecurityException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String locationId = "us-east1";
    String keyRingId = "my-key-ring";
    String keyId = "my-key";
    String keyVersionId = "123";
    String message = "my message";
    byte[] signature = null;
    verifyAsymmetricRsa(projectId, locationId, keyRingId, keyId, keyVersionId, message, signature);
  }

  // Verify the signature of a message signed with an RSA key.
  public void verifyAsymmetricRsa(
      String projectId,
      String locationId,
      String keyRingId,
      String keyId,
      String keyVersionId,
      String message,
      byte[] signature)
      throws IOException, GeneralSecurityException {
    // Initialize client that will be used to send requests. This client only
    // needs to be created once, and can be reused for multiple requests. After
    // completing all of your requests, call the "close" method on the client to
    // safely clean up any remaining background resources.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      // Build the name from the project, location, and key ring, key, and key version.
      CryptoKeyVersionName keyVersionName =
          CryptoKeyVersionName.of(projectId, locationId, keyRingId, keyId, keyVersionId);

      // Convert the message into bytes. Cryptographic plaintexts and
      // ciphertexts are always byte arrays.
      byte[] plaintext = message.getBytes(StandardCharsets.UTF_8);

      // Get the public key.
      PublicKey publicKey = client.getPublicKey(keyVersionName);

      // Convert the public PEM key to a DER key (see helper below).
      byte[] derKey = convertPemToDer(publicKey.getPem());
      X509EncodedKeySpec keySpec = new X509EncodedKeySpec(derKey);
      java.security.PublicKey rsaKey = KeyFactory.getInstance("RSA").generatePublic(keySpec);

      // Verify the 'RSA_SIGN_PKCS1_2048_SHA256' signature.
      // For other key algorithms:
      // http://docs.oracle.com/javase/7/docs/technotes/guides/security/StandardNames.html#Signature
      Signature rsaVerify = Signature.getInstance("SHA256withRSA");
      rsaVerify.initVerify(rsaKey);
      rsaVerify.update(plaintext);

      // Verify the signature.
      boolean verified = rsaVerify.verify(signature);
      System.out.printf("Signature verified: %s", verified);
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
// [END kms_verify_asymmetric_signature_rsa]
