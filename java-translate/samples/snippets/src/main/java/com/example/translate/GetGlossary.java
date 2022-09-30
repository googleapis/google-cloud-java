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

// [START translate_v3_get_glossary]
import com.google.cloud.translate.v3.GetGlossaryRequest;
import com.google.cloud.translate.v3.Glossary;
import com.google.cloud.translate.v3.GlossaryName;
import com.google.cloud.translate.v3.TranslationServiceClient;
import java.io.IOException;

public class GetGlossary {

  public static void getGlossary() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "YOUR-PROJECT-ID";
    String glossaryId = "your-glossary-display-name";
    getGlossary(projectId, glossaryId);
  }

  // Get a particular glossary based on the glossary ID
  public static void getGlossary(String projectId, String glossaryId) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (TranslationServiceClient client = TranslationServiceClient.create()) {
      // Supported Locations: `global`, [glossary location], or [model location]
      // Glossaries must be hosted in `us-central1`
      // Custom Models must use the same location as your model. (us-central1)
      GlossaryName glossaryName = GlossaryName.of(projectId, "us-central1", glossaryId);
      GetGlossaryRequest request =
          GetGlossaryRequest.newBuilder().setName(glossaryName.toString()).build();

      Glossary response = client.getGlossary(request);

      System.out.printf("Glossary name: %s\n", response.getName());
      System.out.printf("Entry count: %s\n", response.getEntryCount());
      System.out.printf("Input URI: %s\n", response.getInputConfig().getGcsSource().getInputUri());
    }
  }
}
// [END translate_v3_get_glossary]
