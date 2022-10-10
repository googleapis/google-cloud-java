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

package com.google.cloud.language.v1beta2.samples;

// [START language_v1beta2_generated_languageserviceclient_classifytext_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.language.v1beta2.ClassificationModelOptions;
import com.google.cloud.language.v1beta2.ClassifyTextRequest;
import com.google.cloud.language.v1beta2.ClassifyTextResponse;
import com.google.cloud.language.v1beta2.Document;
import com.google.cloud.language.v1beta2.LanguageServiceClient;

public class AsyncClassifyText {

  public static void main(String[] args) throws Exception {
    asyncClassifyText();
  }

  public static void asyncClassifyText() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
      ClassifyTextRequest request =
          ClassifyTextRequest.newBuilder()
              .setDocument(Document.newBuilder().build())
              .setClassificationModelOptions(ClassificationModelOptions.newBuilder().build())
              .build();
      ApiFuture<ClassifyTextResponse> future =
          languageServiceClient.classifyTextCallable().futureCall(request);
      // Do something.
      ClassifyTextResponse response = future.get();
    }
  }
}
// [END language_v1beta2_generated_languageserviceclient_classifytext_async]
