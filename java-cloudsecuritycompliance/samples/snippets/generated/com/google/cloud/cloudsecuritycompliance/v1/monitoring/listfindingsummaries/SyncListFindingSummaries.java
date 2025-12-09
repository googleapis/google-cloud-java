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

package com.google.cloud.cloudsecuritycompliance.v1.samples;

// [START cloudsecuritycompliance_v1_generated_Monitoring_ListFindingSummaries_sync]
import com.google.cloud.cloudsecuritycompliance.v1.FindingSummary;
import com.google.cloud.cloudsecuritycompliance.v1.ListFindingSummariesRequest;
import com.google.cloud.cloudsecuritycompliance.v1.LocationName;
import com.google.cloud.cloudsecuritycompliance.v1.MonitoringClient;
import com.google.protobuf.Timestamp;

public class SyncListFindingSummaries {

  public static void main(String[] args) throws Exception {
    syncListFindingSummaries();
  }

  public static void syncListFindingSummaries() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (MonitoringClient monitoringClient = MonitoringClient.create()) {
      ListFindingSummariesRequest request =
          ListFindingSummariesRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setEndTime(Timestamp.newBuilder().build())
              .build();
      for (FindingSummary element : monitoringClient.listFindingSummaries(request).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END cloudsecuritycompliance_v1_generated_Monitoring_ListFindingSummaries_sync]
