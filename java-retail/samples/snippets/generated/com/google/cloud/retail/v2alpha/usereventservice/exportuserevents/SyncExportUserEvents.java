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

package com.google.cloud.retail.v2alpha.samples;

// [START retail_v2alpha_generated_UserEventService_ExportUserEvents_sync]
import com.google.cloud.retail.v2alpha.CatalogName;
import com.google.cloud.retail.v2alpha.ExportUserEventsRequest;
import com.google.cloud.retail.v2alpha.ExportUserEventsResponse;
import com.google.cloud.retail.v2alpha.OutputConfig;
import com.google.cloud.retail.v2alpha.UserEventServiceClient;

public class SyncExportUserEvents {

  public static void main(String[] args) throws Exception {
    syncExportUserEvents();
  }

  public static void syncExportUserEvents() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
      ExportUserEventsRequest request =
          ExportUserEventsRequest.newBuilder()
              .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
              .setOutputConfig(OutputConfig.newBuilder().build())
              .setFilter("filter-1274492040")
              .build();
      ExportUserEventsResponse response =
          userEventServiceClient.exportUserEventsAsync(request).get();
    }
  }
}
// [END retail_v2alpha_generated_UserEventService_ExportUserEvents_sync]
