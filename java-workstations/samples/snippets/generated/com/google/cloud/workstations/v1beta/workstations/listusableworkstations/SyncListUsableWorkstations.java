/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.workstations.v1beta.samples;

// [START workstations_v1beta_generated_Workstations_ListUsableWorkstations_sync]
import com.google.cloud.workstations.v1beta.ListUsableWorkstationsRequest;
import com.google.cloud.workstations.v1beta.Workstation;
import com.google.cloud.workstations.v1beta.WorkstationConfigName;
import com.google.cloud.workstations.v1beta.WorkstationsClient;

public class SyncListUsableWorkstations {

  public static void main(String[] args) throws Exception {
    syncListUsableWorkstations();
  }

  public static void syncListUsableWorkstations() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
      ListUsableWorkstationsRequest request =
          ListUsableWorkstationsRequest.newBuilder()
              .setParent(
                  WorkstationConfigName.of(
                          "[PROJECT]",
                          "[LOCATION]",
                          "[WORKSTATION_CLUSTER]",
                          "[WORKSTATION_CONFIG]")
                      .toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      for (Workstation element : workstationsClient.listUsableWorkstations(request).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END workstations_v1beta_generated_Workstations_ListUsableWorkstations_sync]
