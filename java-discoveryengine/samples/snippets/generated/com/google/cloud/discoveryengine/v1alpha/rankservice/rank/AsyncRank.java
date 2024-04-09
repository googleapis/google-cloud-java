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

// [START discoveryengine_v1alpha_generated_RankService_Rank_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.discoveryengine.v1alpha.RankRequest;
import com.google.cloud.discoveryengine.v1alpha.RankResponse;
import com.google.cloud.discoveryengine.v1alpha.RankServiceClient;
import com.google.cloud.discoveryengine.v1alpha.RankingConfigName;
import com.google.cloud.discoveryengine.v1alpha.RankingRecord;
import java.util.ArrayList;

public class AsyncRank {

  public static void main(String[] args) throws Exception {
    asyncRank();
  }

  public static void asyncRank() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (RankServiceClient rankServiceClient = RankServiceClient.create()) {
      RankRequest request =
          RankRequest.newBuilder()
              .setRankingConfig(
                  RankingConfigName.of("[PROJECT]", "[LOCATION]", "[RANKING_CONFIG]").toString())
              .setModel("model104069929")
              .setTopN(110545924)
              .setQuery("query107944136")
              .addAllRecords(new ArrayList<RankingRecord>())
              .setIgnoreRecordDetailsInResponse(true)
              .build();
      ApiFuture<RankResponse> future = rankServiceClient.rankCallable().futureCall(request);
      // Do something.
      RankResponse response = future.get();
    }
  }
}
// [END discoveryengine_v1alpha_generated_RankService_Rank_async]
