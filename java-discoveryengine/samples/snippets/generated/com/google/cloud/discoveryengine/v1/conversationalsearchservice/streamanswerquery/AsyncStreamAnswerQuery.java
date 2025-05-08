/*
 * Copyright 2025 Google LLC
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

// [START discoveryengine_v1_generated_ConversationalSearchService_StreamAnswerQuery_async]
import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.discoveryengine.v1.AnswerQueryRequest;
import com.google.cloud.discoveryengine.v1.AnswerQueryResponse;
import com.google.cloud.discoveryengine.v1.ConversationalSearchServiceClient;
import com.google.cloud.discoveryengine.v1.Query;
import com.google.cloud.discoveryengine.v1.ServingConfigName;
import com.google.cloud.discoveryengine.v1.SessionName;
import java.util.HashMap;

public class AsyncStreamAnswerQuery {

  public static void main(String[] args) throws Exception {
    asyncStreamAnswerQuery();
  }

  public static void asyncStreamAnswerQuery() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ConversationalSearchServiceClient conversationalSearchServiceClient =
        ConversationalSearchServiceClient.create()) {
      AnswerQueryRequest request =
          AnswerQueryRequest.newBuilder()
              .setServingConfig(
                  ServingConfigName.ofProjectLocationDataStoreServingConfigName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]")
                      .toString())
              .setQuery(Query.newBuilder().build())
              .setSession(
                  SessionName.ofProjectLocationDataStoreSessionName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
                      .toString())
              .setSafetySpec(AnswerQueryRequest.SafetySpec.newBuilder().build())
              .setRelatedQuestionsSpec(AnswerQueryRequest.RelatedQuestionsSpec.newBuilder().build())
              .setGroundingSpec(AnswerQueryRequest.GroundingSpec.newBuilder().build())
              .setAnswerGenerationSpec(AnswerQueryRequest.AnswerGenerationSpec.newBuilder().build())
              .setSearchSpec(AnswerQueryRequest.SearchSpec.newBuilder().build())
              .setQueryUnderstandingSpec(
                  AnswerQueryRequest.QueryUnderstandingSpec.newBuilder().build())
              .setAsynchronousMode(true)
              .setUserPseudoId("userPseudoId-1155274652")
              .putAllUserLabels(new HashMap<String, String>())
              .setEndUserSpec(AnswerQueryRequest.EndUserSpec.newBuilder().build())
              .build();
      ServerStream<AnswerQueryResponse> stream =
          conversationalSearchServiceClient.streamAnswerQueryCallable().call(request);
      for (AnswerQueryResponse response : stream) {
        // Do something when a response is received.
      }
    }
  }
}
// [END discoveryengine_v1_generated_ConversationalSearchService_StreamAnswerQuery_async]
