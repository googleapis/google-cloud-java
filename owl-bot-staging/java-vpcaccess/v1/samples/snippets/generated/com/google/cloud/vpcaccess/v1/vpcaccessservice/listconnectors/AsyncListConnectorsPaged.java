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

package com.google.cloud.vpcaccess.v1.samples;

// [START vpcaccess_v1_generated_VpcAccessService_ListConnectors_Paged_async]
import com.google.cloud.vpcaccess.v1.Connector;
import com.google.cloud.vpcaccess.v1.ListConnectorsRequest;
import com.google.cloud.vpcaccess.v1.ListConnectorsResponse;
import com.google.cloud.vpcaccess.v1.LocationName;
import com.google.cloud.vpcaccess.v1.VpcAccessServiceClient;
import com.google.common.base.Strings;

public class AsyncListConnectorsPaged {

  public static void main(String[] args) throws Exception {
    asyncListConnectorsPaged();
  }

  public static void asyncListConnectorsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (VpcAccessServiceClient vpcAccessServiceClient = VpcAccessServiceClient.create()) {
      ListConnectorsRequest request =
          ListConnectorsRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListConnectorsResponse response =
            vpcAccessServiceClient.listConnectorsCallable().call(request);
        for (Connector element : response.getConnectorsList()) {
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
// [END vpcaccess_v1_generated_VpcAccessService_ListConnectors_Paged_async]
