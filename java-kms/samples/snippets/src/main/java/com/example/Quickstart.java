/*
  Copyright 2016, Google, Inc.
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
      http://www.apache.org/licenses/LICENSE-2.0
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/

package com.example;

// [START kms_quickstart]
// Imports the Google Cloud client library
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.cloudkms.v1.CloudKMS;
import com.google.api.services.cloudkms.v1.CloudKMSScopes;
import com.google.api.services.cloudkms.v1.model.KeyRing;
import com.google.api.services.cloudkms.v1.model.ListKeyRingsResponse;

import java.io.IOException;

public class Quickstart {
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
        .setApplicationName("CloudKMS snippets")
        .build();
  }

  public static void main(String... args) throws Exception {
    String projectId = args[0];
    // The location of the Key Rings
    String location = "global";

    // Create the Cloud KMS client.
    CloudKMS kms = createAuthorizedClient();

    // The resource name of the cryptoKey
    String keyRingPath = String.format(
        "projects/%s/locations/%s",
        projectId, location);

    // Make the RPC call
    ListKeyRingsResponse response = kms.projects().locations()
        .keyRings()
        .list(keyRingPath)
        .execute();

    // Print the returned key rings
    if (null != response.getKeyRings()) {
      System.out.println("Key Rings: ");
      for (KeyRing keyRing : response.getKeyRings()) {
        System.out.println(keyRing.getName());
      }
    } else {
      System.out.println("No keyrings defined.");
    }
  }
}
// [END kms_quickstart]
