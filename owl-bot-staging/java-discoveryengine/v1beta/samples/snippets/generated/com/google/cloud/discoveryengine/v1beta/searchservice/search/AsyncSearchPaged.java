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

package com.google.cloud.discoveryengine.v1beta.samples;

// [START discoveryengine_v1beta_generated_SearchService_Search_Paged_async]
import com.google.cloud.discoveryengine.v1beta.BranchName;
import com.google.cloud.discoveryengine.v1beta.SearchRequest;
import com.google.cloud.discoveryengine.v1beta.SearchResponse;
import com.google.cloud.discoveryengine.v1beta.SearchServiceClient;
import com.google.cloud.discoveryengine.v1beta.ServingConfigName;
import com.google.cloud.discoveryengine.v1beta.UserInfo;
import com.google.common.base.Strings;
import com.google.protobuf.Value;
import java.util.ArrayList;
import java.util.HashMap;

public class AsyncSearchPaged {

  public static void main(String[] args) throws Exception {
    asyncSearchPaged();
  }

  public static void asyncSearchPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SearchServiceClient searchServiceClient = SearchServiceClient.create()) {
      SearchRequest request =
          SearchRequest.newBuilder()
              .setServingConfig(
                  ServingConfigName.ofProjectLocationDataStoreServingConfigName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]")
                      .toString())
              .setBranch(
                  BranchName.ofProjectLocationDataStoreBranchName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]")
                      .toString())
              .setQuery("query107944136")
              .setImageQuery(SearchRequest.ImageQuery.newBuilder().build())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setOffset(-1019779949)
              .setFilter("filter-1274492040")
              .setCanonicalFilter("canonicalFilter-722283124")
              .setOrderBy("orderBy-1207110587")
              .setUserInfo(UserInfo.newBuilder().build())
              .addAllFacetSpecs(new ArrayList<SearchRequest.FacetSpec>())
              .setBoostSpec(SearchRequest.BoostSpec.newBuilder().build())
              .putAllParams(new HashMap<String, Value>())
              .setQueryExpansionSpec(SearchRequest.QueryExpansionSpec.newBuilder().build())
              .setSpellCorrectionSpec(SearchRequest.SpellCorrectionSpec.newBuilder().build())
              .setUserPseudoId("userPseudoId-1155274652")
              .setContentSearchSpec(SearchRequest.ContentSearchSpec.newBuilder().build())
              .setEmbeddingSpec(SearchRequest.EmbeddingSpec.newBuilder().build())
              .setRankingExpression("rankingExpression2110320494")
              .setSafeSearch(true)
              .putAllUserLabels(new HashMap<String, String>())
              .build();
      while (true) {
        SearchResponse response = searchServiceClient.searchCallable().call(request);
        for (SearchResponse.SearchResult element : response.getResultsList()) {
          // doThingsWith(element);
        }
        String nextPageToken = response.getNextPageToken();
        if (!Strings.isNullOrEmpty(nextPageToken)) {
          request = request.toBuilder().setPageToken(nextPageToken).build();
        } else {
          break;
        }
      }
    }
  }
}
// [END discoveryengine_v1beta_generated_SearchService_Search_Paged_async]
