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

// [START translate_v3_create_glossary]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.translate.v3.CreateGlossaryMetadata;
import com.google.cloud.translate.v3.CreateGlossaryRequest;
import com.google.cloud.translate.v3.GcsSource;
import com.google.cloud.translate.v3.Glossary;
import com.google.cloud.translate.v3.GlossaryInputConfig;
import com.google.cloud.translate.v3.GlossaryName;
import com.google.cloud.translate.v3.LocationName;
import com.google.cloud.translate.v3.TranslationServiceClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class CreateGlossary {

  public static void createGlossary() throws InterruptedException, ExecutionException, IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "YOUR-PROJECT-ID";
    String glossaryId = "your-glossary-display-name";
    List<String> languageCodes = new ArrayList<>();
    languageCodes.add("your-language-code");
    String inputUri = "gs://your-gcs-bucket/path/to/input/file.txt";
    createGlossary(projectId, glossaryId, languageCodes, inputUri);
  }

  // Create a equivalent term sets glossary
  // https://cloud.google.com/translate/docs/advanced/glossary#format-glossary
  public static void createGlossary(
      String projectId, String glossaryId, List<String> languageCodes, String inputUri)
      throws IOException, ExecutionException, InterruptedException {

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (TranslationServiceClient client = TranslationServiceClient.create()) {
      // Supported Locations: `global`, [glossary location], or [model location]
      // Glossaries must be hosted in `us-central1`
      // Custom Models must use the same location as your model. (us-central1)
      String location = "us-central1";
      LocationName parent = LocationName.of(projectId, location);
      GlossaryName glossaryName = GlossaryName.of(projectId, location, glossaryId);

      // Supported Languages: https://cloud.google.com/translate/docs/languages
      Glossary.LanguageCodesSet languageCodesSet =
          Glossary.LanguageCodesSet.newBuilder().addAllLanguageCodes(languageCodes).build();

      // Configure the source of the file from a GCS bucket
      GcsSource gcsSource = GcsSource.newBuilder().setInputUri(inputUri).build();
      GlossaryInputConfig inputConfig =
          GlossaryInputConfig.newBuilder().setGcsSource(gcsSource).build();

      Glossary glossary =
          Glossary.newBuilder()
              .setName(glossaryName.toString())
              .setLanguageCodesSet(languageCodesSet)
              .setInputConfig(inputConfig)
              .build();

      CreateGlossaryRequest request =
          CreateGlossaryRequest.newBuilder()
              .setParent(parent.toString())
              .setGlossary(glossary)
              .build();

      // Start an asynchronous request
      OperationFuture<Glossary, CreateGlossaryMetadata> future =
          client.createGlossaryAsync(request);

      System.out.println("Waiting for operation to complete...");
      Glossary response = future.get();
      System.out.println("Created Glossary.");
      System.out.printf("Glossary name: %s\n", response.getName());
      System.out.printf("Entry count: %s\n", response.getEntryCount());
      System.out.printf("Input URI: %s\n", response.getInputConfig().getGcsSource().getInputUri());
    }
  }
}
// [END translate_v3_create_glossary]
