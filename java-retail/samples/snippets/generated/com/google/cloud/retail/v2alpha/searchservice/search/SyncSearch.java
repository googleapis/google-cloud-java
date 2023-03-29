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

package com.google.cloud.retail.v2alpha.samples;

// [START retail_v2alpha_generated_SearchService_Search_sync]
import com.google.cloud.retail.v2alpha.BranchName;
import com.google.cloud.retail.v2alpha.SearchRequest;
import com.google.cloud.retail.v2alpha.SearchResponse;
import com.google.cloud.retail.v2alpha.SearchServiceClient;
import com.google.cloud.retail.v2alpha.UserInfo;
import java.util.ArrayList;
import java.util.HashMap;

public class SyncSearch {

  public static void main(String[] args) throws Exception {
    syncSearch();
  }

  public static void syncSearch() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SearchServiceClient searchServiceClient = SearchServiceClient.create()) {
      SearchRequest request =
          SearchRequest.newBuilder()
              .setPlacement("placement1792938725")
              .setBranch(
                  BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString())
              .setQuery("query107944136")
              .setVisitorId("visitorId1880545833")
              .setUserInfo(UserInfo.newBuilder().build())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setOffset(-1019779949)
              .setFilter("filter-1274492040")
              .setCanonicalFilter("canonicalFilter-722283124")
              .setOrderBy("orderBy-1207110587")
              .addAllFacetSpecs(new ArrayList<SearchRequest.FacetSpec>())
              .setDynamicFacetSpec(SearchRequest.DynamicFacetSpec.newBuilder().build())
              .setBoostSpec(SearchRequest.BoostSpec.newBuilder().build())
              .setQueryExpansionSpec(SearchRequest.QueryExpansionSpec.newBuilder().build())
              .addAllVariantRollupKeys(new ArrayList<String>())
              .addAllPageCategories(new ArrayList<String>())
              .setPersonalizationSpec(SearchRequest.PersonalizationSpec.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setSpellCorrectionSpec(SearchRequest.SpellCorrectionSpec.newBuilder().build())
              .build();
      for (SearchResponse.SearchResult element : searchServiceClient.search(request).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END retail_v2alpha_generated_SearchService_Search_sync]
