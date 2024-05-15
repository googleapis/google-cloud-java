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

package com.google.cloud.visionai.v1.samples;

// [START visionai_v1_generated_Warehouse_SearchAssets_sync]
import com.google.cloud.visionai.v1.CorpusName;
import com.google.cloud.visionai.v1.Criteria;
import com.google.cloud.visionai.v1.DateTimeRangeArray;
import com.google.cloud.visionai.v1.FacetGroup;
import com.google.cloud.visionai.v1.SearchAssetsRequest;
import com.google.cloud.visionai.v1.SearchResultItem;
import com.google.cloud.visionai.v1.WarehouseClient;
import java.util.ArrayList;

public class SyncSearchAssets {

  public static void main(String[] args) throws Exception {
    syncSearchAssets();
  }

  public static void syncSearchAssets() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (WarehouseClient warehouseClient = WarehouseClient.create()) {
      SearchAssetsRequest request =
          SearchAssetsRequest.newBuilder()
              .setCorpus(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setContentTimeRanges(DateTimeRangeArray.newBuilder().build())
              .addAllCriteria(new ArrayList<Criteria>())
              .addAllFacetSelections(new ArrayList<FacetGroup>())
              .addAllResultAnnotationKeys(new ArrayList<String>())
              .setSearchQuery("searchQuery-552137728")
              .build();
      for (SearchResultItem element : warehouseClient.searchAssets(request).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END visionai_v1_generated_Warehouse_SearchAssets_sync]
