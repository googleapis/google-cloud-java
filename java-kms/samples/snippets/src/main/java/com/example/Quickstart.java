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

// [START kms_quickstart]
// Imports the Google Cloud client library

import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.auth.Credentials;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.cloud.kms.v1.KeyManagementServiceClient.ListKeyRingsPagedResponse;
import com.google.cloud.kms.v1.KeyManagementServiceSettings;
import com.google.cloud.kms.v1.KeyRing;
import com.google.cloud.kms.v1.LocationName;

import java.io.IOException;

public class Quickstart {

  public static void main(String... args) throws Exception {
    String projectId = args[0];
    // The location of the Key Rings
    String location = args[1];

    // Create the KeyManagementServiceClient using try-with-resources to manage client cleanup.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {

      // The resource name of the location to search
      String locationPath = LocationName.format(projectId, location);

      // Make the RPC call
      ListKeyRingsPagedResponse response = client.listKeyRings(locationPath);

      // Iterate over all KeyRings (which may cause more result pages to be loaded automatically)
      for (KeyRing keyRing : response.iterateAll()) {
        System.out.println("Found KeyRing: " + keyRing.getName());
      }
    }
  }
}
// [END kms_quickstart]
