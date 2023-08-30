/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.discoveryengine.v1.samples;

// [START discoveryengine_v1_generated_CompletionService_CompleteQuery_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.discoveryengine.v1.CompleteQueryRequest;
import com.google.cloud.discoveryengine.v1.CompleteQueryResponse;
import com.google.cloud.discoveryengine.v1.CompletionServiceClient;
import com.google.cloud.discoveryengine.v1.DataStoreName;

public class AsyncCompleteQuery {

  public static void main(String[] args) throws Exception {
    asyncCompleteQuery();
  }

  public static void asyncCompleteQuery() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CompletionServiceClient completionServiceClient = CompletionServiceClient.create()) {
      CompleteQueryRequest request =
          CompleteQueryRequest.newBuilder()
              .setDataStore(
                  DataStoreName.ofProjectLocationDataStoreName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                      .toString())
              .setQuery("query107944136")
              .setQueryModel("queryModel-184930495")
              .setUserPseudoId("userPseudoId-1155274652")
              .setIncludeTailSuggestions(true)
              .build();
      ApiFuture<CompleteQueryResponse> future =
          completionServiceClient.completeQueryCallable().futureCall(request);
      // Do something.
      CompleteQueryResponse response = future.get();
    }
  }
}
// [END discoveryengine_v1_generated_CompletionService_CompleteQuery_async]
