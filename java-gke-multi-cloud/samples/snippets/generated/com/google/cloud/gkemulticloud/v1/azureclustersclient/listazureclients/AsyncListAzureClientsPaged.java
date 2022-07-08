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

package com.google.cloud.gkemulticloud.v1.samples;

// [START gkemulticloud_v1_generated_azureclustersclient_listazureclients_paged_async]
import com.google.cloud.gkemulticloud.v1.AzureClient;
import com.google.cloud.gkemulticloud.v1.AzureClustersClient;
import com.google.cloud.gkemulticloud.v1.ListAzureClientsRequest;
import com.google.cloud.gkemulticloud.v1.ListAzureClientsResponse;
import com.google.cloud.gkemulticloud.v1.LocationName;
import com.google.common.base.Strings;

public class AsyncListAzureClientsPaged {

  public static void main(String[] args) throws Exception {
    asyncListAzureClientsPaged();
  }

  public static void asyncListAzureClientsPaged() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
      ListAzureClientsRequest request =
          ListAzureClientsRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListAzureClientsResponse response =
            azureClustersClient.listAzureClientsCallable().call(request);
        for (AzureClient element : response.getAzureClientsList()) {
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
// [END gkemulticloud_v1_generated_azureclustersclient_listazureclients_paged_async]
