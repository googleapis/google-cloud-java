/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.compute.v1.samples;

// [START compute_v1_generated_RegionNetworkEndpointGroups_AttachNetworkEndpoints_StringStringStringRegionnetworkendpointgroupsattachendpointsrequest_sync]
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.RegionNetworkEndpointGroupsAttachEndpointsRequest;
import com.google.cloud.compute.v1.RegionNetworkEndpointGroupsClient;

public
class SyncAttachNetworkEndpointsStringStringStringRegionnetworkendpointgroupsattachendpointsrequest {

  public static void main(String[] args) throws Exception {
    syncAttachNetworkEndpointsStringStringStringRegionnetworkendpointgroupsattachendpointsrequest();
  }

  public static void
      syncAttachNetworkEndpointsStringStringStringRegionnetworkendpointgroupsattachendpointsrequest()
          throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
        RegionNetworkEndpointGroupsClient.create()) {
      String project = "project-309310695";
      String region = "region-934795532";
      String networkEndpointGroup = "networkEndpointGroup-2120389028";
      RegionNetworkEndpointGroupsAttachEndpointsRequest
          regionNetworkEndpointGroupsAttachEndpointsRequestResource =
              RegionNetworkEndpointGroupsAttachEndpointsRequest.newBuilder().build();
      Operation response =
          regionNetworkEndpointGroupsClient
              .attachNetworkEndpointsAsync(
                  project,
                  region,
                  networkEndpointGroup,
                  regionNetworkEndpointGroupsAttachEndpointsRequestResource)
              .get();
    }
  }
}
// [END compute_v1_generated_RegionNetworkEndpointGroups_AttachNetworkEndpoints_StringStringStringRegionnetworkendpointgroupsattachendpointsrequest_sync]
