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

package com.google.cloud.retail.v2alpha.samples;

// [START retail_v2alpha_generated_ConversationalSearchService_ConversationalSearch_async]
import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.retail.v2alpha.BranchName;
import com.google.cloud.retail.v2alpha.ConversationalSearchRequest;
import com.google.cloud.retail.v2alpha.ConversationalSearchResponse;
import com.google.cloud.retail.v2alpha.ConversationalSearchServiceClient;
import com.google.cloud.retail.v2alpha.SafetySetting;
import com.google.cloud.retail.v2alpha.UserInfo;
import java.util.ArrayList;
import java.util.HashMap;

public class AsyncConversationalSearch {

  public static void main(String[] args) throws Exception {
    asyncConversationalSearch();
  }

  public static void asyncConversationalSearch() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ConversationalSearchServiceClient conversationalSearchServiceClient =
        ConversationalSearchServiceClient.create()) {
      ConversationalSearchRequest request =
          ConversationalSearchRequest.newBuilder()
              .setPlacement("placement1792938725")
              .setBranch(
                  BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString())
              .setQuery("query107944136")
              .addAllPageCategories(new ArrayList<String>())
              .setConversationId("conversationId-1676095234")
              .setSearchParams(ConversationalSearchRequest.SearchParams.newBuilder().build())
              .setVisitorId("visitorId1880545833")
              .setUserInfo(UserInfo.newBuilder().build())
              .setConversationalFilteringSpec(
                  ConversationalSearchRequest.ConversationalFilteringSpec.newBuilder().build())
              .putAllUserLabels(new HashMap<String, String>())
              .addAllSafetySettings(new ArrayList<SafetySetting>())
              .build();
      ServerStream<ConversationalSearchResponse> stream =
          conversationalSearchServiceClient.conversationalSearchCallable().call(request);
      for (ConversationalSearchResponse response : stream) {
        // Do something when a response is received.
      }
    }
  }
}
// [END retail_v2alpha_generated_ConversationalSearchService_ConversationalSearch_async]
