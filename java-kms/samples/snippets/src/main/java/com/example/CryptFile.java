/*
 * Copyright (c) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.example;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.cloudkms.v1.CloudKMS;
import com.google.api.services.cloudkms.v1.CloudKMSScopes;
import com.google.api.services.cloudkms.v1.model.DecryptRequest;
import com.google.api.services.cloudkms.v1.model.DecryptResponse;
import com.google.api.services.cloudkms.v1.model.EncryptRequest;
import com.google.api.services.cloudkms.v1.model.EncryptResponse;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import java.io.IOException;

public class CryptFile {

  /**
   * Creates an authorized CloudKMS client service using Application Default Credentials.
   *
   * @return an authorized CloudKMS client
   * @throws IOException if there's an error getting the default credentials.
   */
  public static CloudKMS createAuthorizedClient() throws IOException {
    // Create the credential
    HttpTransport transport = new NetHttpTransport();
    JsonFactory jsonFactory = new JacksonFactory();
    // Authorize the client using Application Default Credentials
    // @see https://g.co/dv/identity/protocols/application-default-credentials
    GoogleCredential credential = GoogleCredential.getApplicationDefault(transport, jsonFactory);

    // Depending on the environment that provides the default credentials (e.g. Compute Engine, App
    // Engine), the credentials may require us to specify the scopes we need explicitly.
    // Check for this case, and inject the scope if required.
    if (credential.createScopedRequired()) {
      credential = credential.createScoped(CloudKMSScopes.all());
    }

    return new CloudKMS.Builder(transport, jsonFactory, credential)
        .setApplicationName("CloudKMS CryptFile")
        .build();
  }

  // [START kms_encrypt]

  /**
   * Encrypts the given plaintext using the specified crypto key.
   */
  public static byte[] encrypt(
      String projectId, String locationId, String keyRingId, String cryptoKeyId, byte[] plaintext)
      throws IOException {
    // The resource name of the cryptoKey
    String resourceName = String.format(
        "projects/%s/locations/%s/keyRings/%s/cryptoKeys/%s",
        projectId, locationId, keyRingId, cryptoKeyId);

    // Create the Cloud KMS client.
    CloudKMS kms = createAuthorizedClient();

    EncryptRequest request = new EncryptRequest().encodePlaintext(plaintext);
    EncryptResponse response = kms.projects().locations().keyRings().cryptoKeys()
        .encrypt(resourceName, request)
        .execute();

    return response.decodeCiphertext();
  }
  // [END kms_encrypt]

  // [START kms_decrypt]

  /**
   * Decrypts the provided ciphertext with the specified crypto key.
   */
  public static byte[] decrypt(String projectId, String locationId, String keyRingId,
      String cryptoKeyId, byte[] ciphertext)
      throws IOException {
    // Create the Cloud KMS client.
    CloudKMS kms = createAuthorizedClient();

    // The resource name of the cryptoKey
    String cryptoKeyName = String.format(
        "projects/%s/locations/%s/keyRings/%s/cryptoKeys/%s",
        projectId, locationId, keyRingId, cryptoKeyId);

    DecryptRequest request = new DecryptRequest().encodeCiphertext(ciphertext);
    DecryptResponse response = kms.projects().locations().keyRings().cryptoKeys()
        .decrypt(cryptoKeyName, request)
        .execute();

    return response.decodePlaintext();
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
