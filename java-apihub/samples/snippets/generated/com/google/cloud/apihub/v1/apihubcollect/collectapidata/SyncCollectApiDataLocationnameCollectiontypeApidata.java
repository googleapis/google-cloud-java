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

package com.google.cloud.apihub.v1.samples;

// [START apihub_v1_generated_ApiHubCollect_CollectApiData_LocationnameCollectiontypeApidata_sync]
import com.google.cloud.apihub.v1.ApiData;
import com.google.cloud.apihub.v1.ApiHubCollectClient;
import com.google.cloud.apihub.v1.CollectApiDataResponse;
import com.google.cloud.apihub.v1.CollectionType;
import com.google.cloud.apihub.v1.LocationName;

public class SyncCollectApiDataLocationnameCollectiontypeApidata {

  public static void main(String[] args) throws Exception {
    syncCollectApiDataLocationnameCollectiontypeApidata();
  }

  public static void syncCollectApiDataLocationnameCollectiontypeApidata() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ApiHubCollectClient apiHubCollectClient = ApiHubCollectClient.create()) {
      LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
      CollectionType collectionType = CollectionType.forNumber(0);
      ApiData apiData = ApiData.newBuilder().build();
      CollectApiDataResponse response =
          apiHubCollectClient.collectApiDataAsync(location, collectionType, apiData).get();
    }
  }
}
// [END apihub_v1_generated_ApiHubCollect_CollectApiData_LocationnameCollectiontypeApidata_sync]
