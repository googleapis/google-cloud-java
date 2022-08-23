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

// [START retail_search_product_with_facet_spec]

package search;

import com.google.cloud.ServiceOptions;
import com.google.cloud.retail.v2.SearchRequest;
import com.google.cloud.retail.v2.SearchRequest.FacetSpec;
import com.google.cloud.retail.v2.SearchRequest.FacetSpec.FacetKey;
import com.google.cloud.retail.v2.SearchResponse;
import com.google.cloud.retail.v2.SearchServiceClient;
import java.io.IOException;
import java.util.UUID;

public class SearchWithFacetSpec {

  public static void main(String[] args) throws IOException {
    String projectId = ServiceOptions.getDefaultProjectId();
    String defaultCatalogName =
        String.format("projects/%s/locations/global/catalogs/default_catalog", projectId);
    String defaultSearchPlacementName = defaultCatalogName + "/placements/default_search";

    searchResponse(defaultSearchPlacementName);
  }

  public static void searchResponse(String defaultSearchPlacementName) throws IOException {
    // TRY DIFFERENT CONDITIONS HERE:
    String searchQuery = "Tee";
    String facetKeyParam = "colorFamilies";
    int pageSize = 10;
    String visitorId = UUID.randomUUID().toString();

    FacetKey facetKey = FacetKey.newBuilder().setKey(facetKeyParam).build();
    FacetSpec facetSpec = FacetSpec.newBuilder().setFacetKey(facetKey).build();

    SearchRequest searchRequest =
        SearchRequest.newBuilder()
            .setPlacement(defaultSearchPlacementName)
            .setQuery(searchQuery)
            .setVisitorId(visitorId)
            .addFacetSpecs(facetSpec)
            .setPageSize(pageSize)
            .build();
    System.out.println("Search request: " + searchRequest);

    // Initialize client that will be used to send requests. This client only
    // needs to be created once, and can be reused for multiple requests. After
    // completing all of your requests, call the "close" method on the client to
    // safely clean up any remaining background resources.
    try (SearchServiceClient client = SearchServiceClient.create()) {
      SearchResponse searchResponse = client.search(searchRequest).getPage().getResponse();
      System.out.println("Search response: " + searchResponse);
    }
  }
}

// [END retail_search_product_with_facet_spec]
