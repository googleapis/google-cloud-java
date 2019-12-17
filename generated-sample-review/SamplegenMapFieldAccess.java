/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// DO NOT EDIT! This is a generated sample ("Request",  "samplegen_map_field_access")
// sample-metadata:
//   title: This sample reads and loops over a map field in the response
//   description: This sample reads and loops over a map field in the response
//   usage: gradle run -PmainClass=com.google.cloud.examples.language.v1.SamplegenMapFieldAccess

package com.google.cloud.examples.language.v1;

import com.google.cloud.language.v1.AnalyzeEntitiesRequest;
import com.google.cloud.language.v1.AnalyzeEntitiesResponse;
import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.Entity;
import com.google.cloud.language.v1.LanguageServiceClient;
import java.util.Map;

public class SamplegenMapFieldAccess {
  // [START samplegen_map_field_access]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.cloud.language.v1.AnalyzeEntitiesRequest;
   * import com.google.cloud.language.v1.AnalyzeEntitiesResponse;
   * import com.google.cloud.language.v1.Document;
   * import com.google.cloud.language.v1.Entity;
   * import com.google.cloud.language.v1.LanguageServiceClient;
   * import java.util.Map;
   */

  /** This sample reads and loops over a map field in the response */
  public static void sampleAnalyzeEntities() {
    try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
      Document.Type type = Document.Type.PLAIN_TEXT;
      String language = "en";

      // The text content to analyze
      String content = "Googleplex is at 1600 Amphitheatre Parkway, Mountain View, CA.";
      Document document =
          Document.newBuilder().setType(type).setLanguage(language).setContent(content).build();
      AnalyzeEntitiesRequest request =
          AnalyzeEntitiesRequest.newBuilder().setDocument(document).build();
      AnalyzeEntitiesResponse response = languageServiceClient.analyzeEntities(request);
      for (Entity entity : response.getEntitiesList()) {
        // Access value by key:
        System.out.printf("URL: %s\n", entity.getMetadataMap().get("wikipedia_url"));
        // Loop over keys and values:
        for (Map.Entry<String, String> entry : entity.getMetadataMap().entrySet()) {
          String key = entry.getKey();
          String value = entry.getValue();
          System.out.printf("%s: %s\n", key, value);
        }

        // Loop over just keys:
        for (String theKey : entity.getMetadataMap().keySet()) {
          System.out.printf("Key: %s\n", theKey);
        }

        // Loop over just values:
        for (String theValue : entity.getMetadataMap().values()) {
          System.out.printf("Value: %s\n", theValue);
        }
      }
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END samplegen_map_field_access]

  public static void main(String[] args) {
    sampleAnalyzeEntities();
  }
}
