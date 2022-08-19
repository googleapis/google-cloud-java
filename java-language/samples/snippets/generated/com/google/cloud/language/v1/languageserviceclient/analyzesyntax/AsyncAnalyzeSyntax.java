/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.language.v1.samples;

// [START language_v1_generated_languageserviceclient_analyzesyntax_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.language.v1.AnalyzeSyntaxRequest;
import com.google.cloud.language.v1.AnalyzeSyntaxResponse;
import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.EncodingType;
import com.google.cloud.language.v1.LanguageServiceClient;

public class AsyncAnalyzeSyntax {

  public static void main(String[] args) throws Exception {
    asyncAnalyzeSyntax();
  }

  public static void asyncAnalyzeSyntax() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
      AnalyzeSyntaxRequest request =
          AnalyzeSyntaxRequest.newBuilder()
              .setDocument(Document.newBuilder().build())
              .setEncodingType(EncodingType.forNumber(0))
              .build();
      ApiFuture<AnalyzeSyntaxResponse> future =
          languageServiceClient.analyzeSyntaxCallable().futureCall(request);
      // Do something.
      AnalyzeSyntaxResponse response = future.get();
    }
  }
}
// [END language_v1_generated_languageserviceclient_analyzesyntax_async]
