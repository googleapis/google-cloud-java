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

// [START translate_v3_detect_language]
import com.google.cloud.translate.v3.DetectLanguageRequest;
import com.google.cloud.translate.v3.DetectLanguageResponse;
import com.google.cloud.translate.v3.DetectedLanguage;
import com.google.cloud.translate.v3.LocationName;
import com.google.cloud.translate.v3.TranslationServiceClient;

import java.io.IOException;

public class DetectLanguage {

  public static void detectLanguage() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "YOUR-PROJECT-ID";
    String text = "your-text";

    detectLanguage(projectId, text);
  }

  // Detecting the language of a text string
  public static void detectLanguage(String projectId, String text) throws IOException {

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (TranslationServiceClient client = TranslationServiceClient.create()) {
      // Supported Locations: `global`, [glossary location], or [model location]
      // Glossaries must be hosted in `us-central1`
      // Custom Models must use the same location as your model. (us-central1)
      LocationName parent = LocationName.of(projectId, "global");

      // Supported Mime Types: https://cloud.google.com/translate/docs/supported-formats
      DetectLanguageRequest request =
          DetectLanguageRequest.newBuilder()
              .setParent(parent.toString())
              .setMimeType("text/plain")
              .setContent(text)
              .build();

      DetectLanguageResponse response = client.detectLanguage(request);

      // Display list of detected languages sorted by detection confidence.
      // The most probable language is first.
      for (DetectedLanguage language : response.getLanguagesList()) {
        // The language detected
        System.out.printf("Language code: %s\n", language.getLanguageCode());
        // Confidence of detection result for this language
        System.out.printf("Confidence: %s\n", language.getConfidence());
      }
    }
  }
}
// [END translate_v3_detect_language]
