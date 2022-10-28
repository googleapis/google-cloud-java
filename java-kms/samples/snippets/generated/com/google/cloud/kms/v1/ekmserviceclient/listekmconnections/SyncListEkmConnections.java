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

package com.google.cloud.kms.v1.samples;

// [START cloudkms_v1_generated_ekmserviceclient_listekmconnections_sync]
import com.google.cloud.kms.v1.EkmConnection;
import com.google.cloud.kms.v1.EkmServiceClient;
import com.google.cloud.kms.v1.ListEkmConnectionsRequest;
import com.google.cloud.kms.v1.LocationName;

public class SyncListEkmConnections {

  public static void main(String[] args) throws Exception {
    syncListEkmConnections();
  }

  public static void syncListEkmConnections() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (EkmServiceClient ekmServiceClient = EkmServiceClient.create()) {
      ListEkmConnectionsRequest request =
          ListEkmConnectionsRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setOrderBy("orderBy-1207110587")
              .build();
      for (EkmConnection element : ekmServiceClient.listEkmConnections(request).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END cloudkms_v1_generated_ekmserviceclient_listekmconnections_sync]
