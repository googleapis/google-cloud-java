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

package com.google.cloud.osconfig.v1.samples;

// [START osconfig_v1_generated_OsConfigZonalService_ListOSPolicyAssignmentReports_sync]
import com.google.cloud.osconfig.v1.InstanceOSPolicyAssignmentName;
import com.google.cloud.osconfig.v1.ListOSPolicyAssignmentReportsRequest;
import com.google.cloud.osconfig.v1.OSPolicyAssignmentReport;
import com.google.cloud.osconfig.v1.OsConfigZonalServiceClient;

public class SyncListOSPolicyAssignmentReports {

  public static void main(String[] args) throws Exception {
    syncListOSPolicyAssignmentReports();
  }

  public static void syncListOSPolicyAssignmentReports() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (OsConfigZonalServiceClient osConfigZonalServiceClient =
        OsConfigZonalServiceClient.create()) {
      ListOSPolicyAssignmentReportsRequest request =
          ListOSPolicyAssignmentReportsRequest.newBuilder()
              .setParent(
                  InstanceOSPolicyAssignmentName.of(
                          "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[ASSIGNMENT]")
                      .toString())
              .setPageSize(883849137)
              .setFilter("filter-1274492040")
              .setPageToken("pageToken873572522")
              .build();
      for (OSPolicyAssignmentReport element :
          osConfigZonalServiceClient.listOSPolicyAssignmentReports(request).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END osconfig_v1_generated_OsConfigZonalService_ListOSPolicyAssignmentReports_sync]
