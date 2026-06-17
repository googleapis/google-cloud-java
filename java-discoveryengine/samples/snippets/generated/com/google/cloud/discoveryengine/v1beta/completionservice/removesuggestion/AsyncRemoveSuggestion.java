/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.discoveryengine.v1beta.samples;

// [START discoveryengine_v1beta_generated_CompletionService_RemoveSuggestion_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.discoveryengine.v1beta.CompletionConfigName;
import com.google.cloud.discoveryengine.v1beta.CompletionServiceClient;
import com.google.cloud.discoveryengine.v1beta.RemoveSuggestionRequest;
import com.google.cloud.discoveryengine.v1beta.RemoveSuggestionResponse;
import com.google.cloud.discoveryengine.v1beta.UserInfo;
import com.google.protobuf.Timestamp;

public class AsyncRemoveSuggestion {

  public static void main(String[] args) throws Exception {
    asyncRemoveSuggestion();
  }

  public static void asyncRemoveSuggestion() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CompletionServiceClient completionServiceClient = CompletionServiceClient.create()) {
      RemoveSuggestionRequest request =
          RemoveSuggestionRequest.newBuilder()
              .setCompletionConfig(
                  CompletionConfigName.ofProjectLocationCollectionEngineName(
                          "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]")
                      .toString())
              .setUserPseudoId("userPseudoId-1155274652")
              .setUserInfo(UserInfo.newBuilder().build())
              .setRemoveTime(Timestamp.newBuilder().build())
              .build();
      ApiFuture<RemoveSuggestionResponse> future =
          completionServiceClient.removeSuggestionCallable().futureCall(request);
      // Do something.
      RemoveSuggestionResponse response = future.get();
    }
  }
}
// [END discoveryengine_v1beta_generated_CompletionService_RemoveSuggestion_async]
