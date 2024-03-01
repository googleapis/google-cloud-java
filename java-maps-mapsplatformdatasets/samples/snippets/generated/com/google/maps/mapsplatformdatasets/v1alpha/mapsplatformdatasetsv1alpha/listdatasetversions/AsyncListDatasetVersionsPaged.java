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

package com.google.maps.mapsplatformdatasets.v1alpha.samples;

// [START mapsplatformdatasets_v1alpha_generated_MapsPlatformDatasetsV1Alpha_ListDatasetVersions_Paged_async]
import com.google.common.base.Strings;
import com.google.maps.mapsplatformdatasets.v1alpha.Dataset;
import com.google.maps.mapsplatformdatasets.v1alpha.DatasetName;
import com.google.maps.mapsplatformdatasets.v1alpha.ListDatasetVersionsRequest;
import com.google.maps.mapsplatformdatasets.v1alpha.ListDatasetVersionsResponse;
import com.google.maps.mapsplatformdatasets.v1alpha.MapsPlatformDatasetsV1AlphaClient;

public class AsyncListDatasetVersionsPaged {

  public static void main(String[] args) throws Exception {
    asyncListDatasetVersionsPaged();
  }

  public static void asyncListDatasetVersionsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (MapsPlatformDatasetsV1AlphaClient mapsPlatformDatasetsV1AlphaClient =
        MapsPlatformDatasetsV1AlphaClient.create()) {
      ListDatasetVersionsRequest request =
          ListDatasetVersionsRequest.newBuilder()
              .setName(DatasetName.of("[PROJECT]", "[DATASET]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListDatasetVersionsResponse response =
            mapsPlatformDatasetsV1AlphaClient.listDatasetVersionsCallable().call(request);
        for (Dataset element : response.getDatasetsList()) {
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
// [END mapsplatformdatasets_v1alpha_generated_MapsPlatformDatasetsV1Alpha_ListDatasetVersions_Paged_async]
