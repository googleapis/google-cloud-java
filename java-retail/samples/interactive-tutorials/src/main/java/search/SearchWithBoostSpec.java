/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// [START retail_search_product_with_boost_spec]

/*
 * Call Retail API to search for a products in a catalog, rerank the
 * results boosting or burying the products that match defined condition.
 */

package search;

import com.google.cloud.retail.v2.SearchRequest;
import com.google.cloud.retail.v2.SearchRequest.BoostSpec;
import com.google.cloud.retail.v2.SearchRequest.BoostSpec.ConditionBoostSpec;
import com.google.cloud.retail.v2.SearchResponse;
import com.google.cloud.retail.v2.SearchServiceClient;
import java.io.IOException;
import java.util.UUID;

public class SearchWithBoostSpec {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = System.getenv("PROJECT_ID");
    String defaultCatalogName =
        String.format("projects/%s/locations/global/catalogs/default_catalog", projectId);
    String defaultSearchPlacementName = defaultCatalogName + "/placements/default_search";

    getSearchResponse(defaultSearchPlacementName);
  }

  public static SearchResponse getSearchResponse(String defaultSearchPlacementName)
      throws IOException {
    // TRY DIFFERENT CONDITIONS HERE:
    String searchQuery = "Tee";
    String condition = "(colorFamilies: ANY(\"Blue\"))";
    float boost = 0.0f;
    int pageSize = 10;
    String visitorId = UUID.randomUUID().toString();

    BoostSpec boostSpec =
        BoostSpec.newBuilder()
            .addConditionBoostSpecs(
                ConditionBoostSpec.newBuilder().setCondition(condition).setBoost(boost).build())
            .build();

    SearchRequest searchRequest =
        SearchRequest.newBuilder()
            .setPlacement(defaultSearchPlacementName)
            .setQuery(searchQuery)
            .setVisitorId(visitorId)
            .setBoostSpec(boostSpec)
            .setPageSize(pageSize)
            .build();
    System.out.println("Search request: " + searchRequest);

    try (SearchServiceClient client = SearchServiceClient.create()) {
      SearchResponse searchResponse = client.search(searchRequest).getPage().getResponse();
      System.out.println("Search response: " + searchResponse);

      return searchResponse;
    }
  }
}

// [END retail_search_product_with_boost_spec]
