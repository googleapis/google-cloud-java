/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.networkmanagement.v1.samples;

// [START networkmanagement_v1_generated_VpcFlowLogsService_ShowEffectiveFlowLogsConfigs_Paged_async]
import com.google.cloud.networkmanagement.v1.EffectiveVpcFlowLogsConfig;
import com.google.cloud.networkmanagement.v1.LocationName;
import com.google.cloud.networkmanagement.v1.ShowEffectiveFlowLogsConfigsRequest;
import com.google.cloud.networkmanagement.v1.ShowEffectiveFlowLogsConfigsResponse;
import com.google.cloud.networkmanagement.v1.VpcFlowLogsServiceClient;
import com.google.common.base.Strings;

public class AsyncShowEffectiveFlowLogsConfigsPaged {

  public static void main(String[] args) throws Exception {
    asyncShowEffectiveFlowLogsConfigsPaged();
  }

  public static void asyncShowEffectiveFlowLogsConfigsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
      ShowEffectiveFlowLogsConfigsRequest request =
          ShowEffectiveFlowLogsConfigsRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setResource("resource-341064690")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .build();
      while (true) {
        ShowEffectiveFlowLogsConfigsResponse response =
            vpcFlowLogsServiceClient.showEffectiveFlowLogsConfigsCallable().call(request);
        for (EffectiveVpcFlowLogsConfig element : response.getEffectiveFlowLogsConfigsList()) {
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
// [END networkmanagement_v1_generated_VpcFlowLogsService_ShowEffectiveFlowLogsConfigs_Paged_async]
