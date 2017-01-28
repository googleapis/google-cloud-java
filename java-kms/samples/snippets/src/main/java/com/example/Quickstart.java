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
import com.google.api.services.cloudkms.v1beta1.CloudKMS;
import com.google.api.services.cloudkms.v1beta1.CloudKMSScopes;
import com.google.api.services.cloudkms.v1beta1.model.KeyRing;
import com.google.api.services.cloudkms.v1beta1.model.ListKeyRingsResponse;

import java.io.IOException;

// [START kms_quickstart]
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
        .setApplicationName("CloudKMS quickstart")
        .build();
  }

  public static void main(String... args) throws IOException {
    if (args.length != 1) {
      System.err.println("Usage: Quickstart <project-id>");
      System.exit(1);
    }

    // Your Google Cloud Platform project ID
    String projectId = args[0];

    // Lists keys in the "global" location.
    String location = "global";
    // The resource name of the location associated with the KeyRings
    String parent = String.format("projects/%s/locations/%s", projectId, location);
    // Instantiate the client
    CloudKMS kms = createAuthorizedClient();
    // list all key rings for your project
    ListKeyRingsResponse response = kms.projects().locations().keyRings().list(parent).execute();
    // Print the key rings
    System.out.println("Key Rings: ");
    if (null != response.getKeyRings()) {
      for (KeyRing keyRing : response.getKeyRings()) {
        System.out.println(keyRing.getName());
      }
    } else {
      System.out.println("No keyrings defined.");
    }
  }
}
// [END kms_quickstart]
