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

package com.example.translate;

// [START translate_v3_list_glossary]
import com.google.cloud.translate.v3.Glossary;
import com.google.cloud.translate.v3.ListGlossariesRequest;
import com.google.cloud.translate.v3.LocationName;
import com.google.cloud.translate.v3.TranslationServiceClient;

import java.io.IOException;

public class ListGlossaries {

  public static void listGlossaries() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "YOUR-PROJECT-ID";
    listGlossaries(projectId);
  }

  // List all the glossaries in a specified location
  public static void listGlossaries(String projectId) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (TranslationServiceClient client = TranslationServiceClient.create()) {
      // Supported Locations: `global`, [glossary location], or [model location]
      // Glossaries must be hosted in `us-central1`
      // Custom Models must use the same location as your model. (us-central1)
      LocationName parent = LocationName.of(projectId, "us-central1");
      ListGlossariesRequest request =
          ListGlossariesRequest.newBuilder().setParent(parent.toString()).build();

      for (Glossary responseItem : client.listGlossaries(request).iterateAll()) {
        System.out.printf("Glossary name: %s\n", responseItem.getName());
        System.out.printf("Entry count: %s\n", responseItem.getEntryCount());
        System.out.printf(
            "Input URI: %s\n", responseItem.getInputConfig().getGcsSource().getInputUri());
      }
    }
  }
}
// [END translate_v3_list_glossary]
