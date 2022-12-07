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

package com.google.cloud.datafusion.v1.samples;

// [START datafusion_v1_generated_DataFusion_ListAvailableVersions_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.datafusion.v1.DataFusionClient;
import com.google.cloud.datafusion.v1.ListAvailableVersionsRequest;
import com.google.cloud.datafusion.v1.LocationName;
import com.google.cloud.datafusion.v1.Version;

public class AsyncListAvailableVersions {

  public static void main(String[] args) throws Exception {
    asyncListAvailableVersions();
  }

  public static void asyncListAvailableVersions() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
      ListAvailableVersionsRequest request =
          ListAvailableVersionsRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setLatestPatchOnly(true)
              .build();
      ApiFuture<Version> future =
          dataFusionClient.listAvailableVersionsPagedCallable().futureCall(request);
      // Do something.
      for (Version element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END datafusion_v1_generated_DataFusion_ListAvailableVersions_async]
