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

package com.google.cloud.capacityplanner.v1beta.samples;

// [START capacityplanner_v1beta_generated_UsageService_QueryUsageHistories_sync]
import com.google.cloud.capacityplanner.v1beta.LocationName;
import com.google.cloud.capacityplanner.v1beta.MachineShape;
import com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesRequest;
import com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesResponse;
import com.google.cloud.capacityplanner.v1beta.UsageServiceClient;
import com.google.type.Date;

public class SyncQueryUsageHistories {

  public static void main(String[] args) throws Exception {
    syncQueryUsageHistories();
  }

  public static void syncQueryUsageHistories() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (UsageServiceClient usageServiceClient = UsageServiceClient.create()) {
      QueryUsageHistoriesRequest request =
          QueryUsageHistoriesRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setIsSpot(true)
              .setMachineFamily("machineFamily419822219")
              .setMachineShape(MachineShape.newBuilder().build())
              .setDiskType("diskType279771767")
              .setConfidentialMode(true)
              .setGpuType("gpuType240737798")
              .setTpuType("tpuType-1106616237")
              .setCloudResourceType("cloudResourceType-1446274243")
              .setStartDate(Date.newBuilder().build())
              .setEndDate(Date.newBuilder().build())
              .build();
      QueryUsageHistoriesResponse response = usageServiceClient.queryUsageHistories(request);
    }
  }
}
// [END capacityplanner_v1beta_generated_UsageService_QueryUsageHistories_sync]
