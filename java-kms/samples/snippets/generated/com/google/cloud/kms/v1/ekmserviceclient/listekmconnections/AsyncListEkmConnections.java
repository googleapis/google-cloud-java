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

// [START kms_v1_generated_ekmserviceclient_listekmconnections_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.kms.v1.EkmConnection;
import com.google.cloud.kms.v1.EkmServiceClient;
import com.google.cloud.kms.v1.ListEkmConnectionsRequest;
import com.google.cloud.kms.v1.LocationName;

public class AsyncListEkmConnections {

  public static void main(String[] args) throws Exception {
    asyncListEkmConnections();
  }

  public static void asyncListEkmConnections() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (EkmServiceClient ekmServiceClient = EkmServiceClient.create()) {
      ListEkmConnectionsRequest request =
          ListEkmConnectionsRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setOrderBy("orderBy-1207110587")
              .build();
      ApiFuture<EkmConnection> future =
          ekmServiceClient.listEkmConnectionsPagedCallable().futureCall(request);
      // Do something.
      for (EkmConnection element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END kms_v1_generated_ekmserviceclient_listekmconnections_async]
