/*
 * Copyright 2021 Google LLC
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

package com.example.translatev3beta1;

// [START translate_v3beta1_batch_translate_document]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.TimedRetryAlgorithm;
import com.google.cloud.translate.v3beta1.BatchDocumentInputConfig;
import com.google.cloud.translate.v3beta1.BatchDocumentOutputConfig;
import com.google.cloud.translate.v3beta1.BatchTranslateDocumentMetadata;
import com.google.cloud.translate.v3beta1.BatchTranslateDocumentRequest;
import com.google.cloud.translate.v3beta1.BatchTranslateDocumentResponse;
import com.google.cloud.translate.v3beta1.GcsDestination;
import com.google.cloud.translate.v3beta1.GcsSource;
import com.google.cloud.translate.v3beta1.LocationName;
import com.google.cloud.translate.v3beta1.TranslationServiceClient;
import com.google.cloud.translate.v3beta1.TranslationServiceSettings;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.threeten.bp.Duration;

public class BatchTranslateDocument {

  public static void batchTranslateDocument()
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "YOUR-PROJECT-ID";
    // Supported Languages: https://cloud.google.com/translate/docs/languages
    String sourceLanguage = "your-source-language";
    String targetLanguage = "your-target-language";
    String inputUri = "gs://your-gcs-bucket/path/to/input/file.txt";
    String outputUri = "gs://your-gcs-bucket/path/to/results/";
    int timeout = 400; // timeout in seconds
    batchTranslateDocument(projectId, sourceLanguage, targetLanguage, inputUri, outputUri, timeout);
  }

  // Batch translate document
  public static void batchTranslateDocument(
      String projectId,
      String sourceLanguage,
      String targetLanguage,
      String inputUri,
      String outputUri,
      int timeout)
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    // refer to https://github.com/googleapis/java-translate/issues/613
    TranslationServiceSettings.Builder translationServiceSettingsBuilder =
        TranslationServiceSettings.newBuilder();
    TimedRetryAlgorithm timedRetryAlgorithm =
        OperationTimedPollAlgorithm.create(
            RetrySettings.newBuilder().setTotalTimeout(Duration.ofSeconds(1000)).build());
    translationServiceSettingsBuilder
        .batchTranslateDocumentOperationSettings()
        .setPollingAlgorithm(timedRetryAlgorithm);
    TranslationServiceSettings translationServiceSettings =
        translationServiceSettingsBuilder.build();

    // Initialize client that sends requests. This client can be reused for multiple requests. After
    // completing all of your requests, call the "close" method on the client to clean
    // up any remaining background resources.
    try (TranslationServiceClient client =
        TranslationServiceClient.create(translationServiceSettings)) {
      // The ``global`` location is not supported for batch translation
      LocationName parent = LocationName.of(projectId, "us-central1");

      // Google Cloud Storage location for the source input. This can be a single file
      // (for example, ``gs://translation-test/input.docx``) or a wildcard
      // (for example, ``gs://translation-test/*``).
      // Supported file types: https://cloud.google.com/translate/docs/supported-formats
      GcsSource gcsSource = GcsSource.newBuilder().setInputUri(inputUri).build();

      BatchDocumentInputConfig batchDocumentInputConfig =
          BatchDocumentInputConfig.newBuilder().setGcsSource(gcsSource).build();

      GcsDestination gcsDestination =
          GcsDestination.newBuilder().setOutputUriPrefix(outputUri).build();

      BatchDocumentOutputConfig batchDocumentOutputConfig =
          BatchDocumentOutputConfig.newBuilder().setGcsDestination(gcsDestination).build();

      BatchTranslateDocumentRequest request =
          BatchTranslateDocumentRequest.newBuilder()
              .setParent(parent.toString())
              .setSourceLanguageCode(sourceLanguage)
              .addTargetLanguageCodes(targetLanguage)
              .addInputConfigs(batchDocumentInputConfig)
              .setOutputConfig(batchDocumentOutputConfig)
              .build();

      OperationFuture<BatchTranslateDocumentResponse, BatchTranslateDocumentMetadata> future =
          client.batchTranslateDocumentAsync(request);

      System.out.println("Waiting for operation to complete...");

      // random number between timeout
      long randomNumber = ThreadLocalRandom.current().nextInt(timeout, timeout + 100);
      BatchTranslateDocumentResponse response = future.get(randomNumber, TimeUnit.SECONDS);

      System.out.println("Total Pages: " + response.getTotalPages());
    }
  }
}
// [END translate_v3beta1_batch_translate_document]
