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

// [START translate_v3beta1_translate_document]

import com.google.cloud.translate.v3beta1.DocumentInputConfig;
import com.google.cloud.translate.v3beta1.LocationName;
import com.google.cloud.translate.v3beta1.TranslateDocumentRequest;
import com.google.cloud.translate.v3beta1.TranslateDocumentResponse;
import com.google.cloud.translate.v3beta1.TranslationServiceClient;
import com.google.protobuf.ByteString;
import java.io.FileInputStream;
import java.io.IOException;

public class TranslateDocument {

  public static void translateDocument() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "YOUR-PROJECT-ID";
    String filePath = "your-text";
    translateDocument(projectId, filePath);
  }

  // Translating Document
  public static void translateDocument(String projectId, String filePath) throws IOException {
    // Initialize client that sends requests. This client can be reused for multiple requests. After
    // completing all of your requests, call the "close" method on the client to clean
    // up any remaining background resources.
    try (TranslationServiceClient client = TranslationServiceClient.create()) {
      // The ``global`` location is not supported for batch translation
      LocationName parent = LocationName.of(projectId, "us-central1");

      // Supported file types: https://cloud.google.com/translate/docs/supported-formats
      ByteString content = ByteString.readFrom(new FileInputStream(filePath));

      DocumentInputConfig documentInputConfig =
          DocumentInputConfig.newBuilder()
              .setContent(content)
              .setMimeType("application/pdf")
              .build();

      TranslateDocumentRequest request =
          TranslateDocumentRequest.newBuilder()
              .setParent(parent.toString())
              .setTargetLanguageCode("fr-FR")
              .setDocumentInputConfig(documentInputConfig)
              .build();

      TranslateDocumentResponse response = client.translateDocument(request);

      // To view translated document, write `response.document_translation.byte_stream_outputs`
      // to file. If not provided in the TranslationRequest, the translated file will only be
      // returned through a byte-stream and its output mime type will be the same as the input
      // file's mime type
      System.out.println(
          "Response: Detected Language Code - "
              + response.getDocumentTranslation().getDetectedLanguageCode());
    }
  }
}
// [END translate_v3beta1_translate_document]
