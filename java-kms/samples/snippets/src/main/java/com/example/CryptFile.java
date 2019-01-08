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

import com.google.cloud.kms.v1.CryptoKeyName;
import com.google.cloud.kms.v1.DecryptResponse;
import com.google.cloud.kms.v1.EncryptResponse;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.protobuf.ByteString;

import java.io.IOException;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

public class CryptFile {

  // [START kms_encrypt]

  /**
   * Encrypts the given plaintext using the specified crypto key.
   */
  public static byte[] encrypt(
      String projectId, String locationId, String keyRingId, String cryptoKeyId, byte[] plaintext)
      throws IOException {

    // Create the KeyManagementServiceClient using try-with-resources to manage client cleanup.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {

      // The resource name of the cryptoKey
      String resourceName = CryptoKeyName.format(projectId, locationId, keyRingId, cryptoKeyId);

      // Encrypt the plaintext with Cloud KMS.
      EncryptResponse response = client.encrypt(resourceName, ByteString.copyFrom(plaintext));

      // Extract the ciphertext from the response.
      return response.getCiphertext().toByteArray();
    }
  }
  // [END kms_encrypt]

  // [START kms_decrypt]

  /**
   * Decrypts the provided ciphertext with the specified crypto key.
   */
  public static byte[] decrypt(
      String projectId, String locationId, String keyRingId, String cryptoKeyId, byte[] ciphertext)
      throws IOException {

    // Create the KeyManagementServiceClient using try-with-resources to manage client cleanup.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {

      // The resource name of the cryptoKey
      String resourceName = CryptoKeyName.format(projectId, locationId, keyRingId, cryptoKeyId);

      // Decrypt the ciphertext with Cloud KMS.
      DecryptResponse response = client.decrypt(resourceName, ByteString.copyFrom(ciphertext));

      // Extract the plaintext from the response.
      return response.getPlaintext().toByteArray();
    }
  }
  // [END kms_decrypt]

  public static void main(String[] args) throws IOException {
    CryptFileCommands commands = new CryptFileCommands();
    CmdLineParser parser = new CmdLineParser(commands);

    try {
      parser.parseArgument(args);
    } catch (CmdLineException e) {
      System.out.println(e);
      System.out.println();
      e.getParser().printUsage(System.out);
      System.exit(1);
    }
    commands.command.run();
  }
}
