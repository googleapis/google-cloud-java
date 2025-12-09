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

package com.google.cloud.networkmanagement.v1beta1.samples;

// [START networkmanagement_v1beta1_generated_VpcFlowLogsService_ShowEffectiveFlowLogsConfigs_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.networkmanagement.v1beta1.EffectiveVpcFlowLogsConfig;
import com.google.cloud.networkmanagement.v1beta1.LocationName;
import com.google.cloud.networkmanagement.v1beta1.ShowEffectiveFlowLogsConfigsRequest;
import com.google.cloud.networkmanagement.v1beta1.VpcFlowLogsServiceClient;

public class AsyncShowEffectiveFlowLogsConfigs {

  public static void main(String[] args) throws Exception {
    asyncShowEffectiveFlowLogsConfigs();
  }

  public static void asyncShowEffectiveFlowLogsConfigs() throws Exception {
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
      ApiFuture<EffectiveVpcFlowLogsConfig> future =
          vpcFlowLogsServiceClient.showEffectiveFlowLogsConfigsPagedCallable().futureCall(request);
      // Do something.
      for (EffectiveVpcFlowLogsConfig element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END networkmanagement_v1beta1_generated_VpcFlowLogsService_ShowEffectiveFlowLogsConfigs_async]
