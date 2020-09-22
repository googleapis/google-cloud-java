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

// [START translate_v3_batch_translate_text_with_model]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.translate.v3.BatchTranslateMetadata;
import com.google.cloud.translate.v3.BatchTranslateResponse;
import com.google.cloud.translate.v3.BatchTranslateTextRequest;
import com.google.cloud.translate.v3.GcsDestination;
import com.google.cloud.translate.v3.GcsSource;
import com.google.cloud.translate.v3.InputConfig;
import com.google.cloud.translate.v3.LocationName;
import com.google.cloud.translate.v3.OutputConfig;
import com.google.cloud.translate.v3.TranslationServiceClient;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BatchTranslateTextWithModel {

  public static void batchTranslateTextWithModel()
      throws InterruptedException, ExecutionException, IOException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "YOUR-PROJECT-ID";
    // Supported Languages: https://cloud.google.com/translate/docs/languages
    String sourceLanguage = "your-source-language";
    String targetLanguage = "your-target-language";
    String inputUri = "gs://your-gcs-bucket/path/to/input/file.txt";
    String outputUri = "gs://your-gcs-bucket/path/to/results/";
    String modelId = "YOUR-MODEL-ID";
    batchTranslateTextWithModel(
        projectId, sourceLanguage, targetLanguage, inputUri, outputUri, modelId);
  }

  // Batch translate text using AutoML Translation model
  public static void batchTranslateTextWithModel(
      String projectId,
      String sourceLanguage,
      String targetLanguage,
      String inputUri,
      String outputUri,
      String modelId)
      throws IOException, ExecutionException, InterruptedException, TimeoutException {

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (TranslationServiceClient client = TranslationServiceClient.create()) {
      // Supported Locations: `global`, [glossary location], or [model location]
      // Glossaries must be hosted in `us-central1`
      // Custom Models must use the same location as your model. (us-central1)
      String location = "us-central1";
      LocationName parent = LocationName.of(projectId, location);

      // Configure the source of the file from a GCS bucket
      GcsSource gcsSource = GcsSource.newBuilder().setInputUri(inputUri).build();
      // Supported Mime Types: https://cloud.google.com/translate/docs/supported-formats
      InputConfig inputConfig =
          InputConfig.newBuilder().setGcsSource(gcsSource).setMimeType("text/plain").build();

      // Configure where to store the output in a GCS bucket
      GcsDestination gcsDestination =
          GcsDestination.newBuilder().setOutputUriPrefix(outputUri).build();
      OutputConfig outputConfig =
          OutputConfig.newBuilder().setGcsDestination(gcsDestination).build();

      // Configure the model used in the request
      String modelPath =
          String.format("projects/%s/locations/%s/models/%s", projectId, location, modelId);

      // Build the request that will be sent to the API
      BatchTranslateTextRequest request =
          BatchTranslateTextRequest.newBuilder()
              .setParent(parent.toString())
              .setSourceLanguageCode(sourceLanguage)
              .addTargetLanguageCodes(targetLanguage)
              .addInputConfigs(inputConfig)
              .setOutputConfig(outputConfig)
              .putModels(targetLanguage, modelPath)
              .build();

      // Start an asynchronous request
      OperationFuture<BatchTranslateResponse, BatchTranslateMetadata> future =
          client.batchTranslateTextAsync(request);

      System.out.println("Waiting for operation to complete...");
      BatchTranslateResponse response = future.get(450, TimeUnit.SECONDS);
      // Display the translation for each input text provided
      System.out.printf("Total Characters: %s\n", response.getTotalCharacters());
      System.out.printf("Translated Characters: %s\n", response.getTranslatedCharacters());
    }
  }
}
// [END translate_v3_batch_translate_text_with_model]
