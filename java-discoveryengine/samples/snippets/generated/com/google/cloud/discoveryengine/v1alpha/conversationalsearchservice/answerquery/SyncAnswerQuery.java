/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.discoveryengine.v1alpha.samples;

// [START discoveryengine_v1alpha_generated_ConversationalSearchService_AnswerQuery_sync]
import com.google.cloud.discoveryengine.v1alpha.AnswerQueryRequest;
import com.google.cloud.discoveryengine.v1alpha.AnswerQueryResponse;
import com.google.cloud.discoveryengine.v1alpha.ConversationalSearchServiceClient;
import com.google.cloud.discoveryengine.v1alpha.Query;
import com.google.cloud.discoveryengine.v1alpha.ServingConfigName;
import com.google.cloud.discoveryengine.v1alpha.SessionName;

public class SyncAnswerQuery {

  public static void main(String[] args) throws Exception {
    syncAnswerQuery();
  }

  public static void syncAnswerQuery() throws Exception {
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
              .setAnswerGenerationSpec(AnswerQueryRequest.AnswerGenerationSpec.newBuilder().build())
              .setSearchSpec(AnswerQueryRequest.SearchSpec.newBuilder().build())
              .setQueryUnderstandingSpec(
                  AnswerQueryRequest.QueryUnderstandingSpec.newBuilder().build())
              .setAsynchronousMode(true)
              .setUserPseudoId("userPseudoId-1155274652")
              .build();
      AnswerQueryResponse response = conversationalSearchServiceClient.answerQuery(request);
    }
  }
}
// [END discoveryengine_v1alpha_generated_ConversationalSearchService_AnswerQuery_sync]
