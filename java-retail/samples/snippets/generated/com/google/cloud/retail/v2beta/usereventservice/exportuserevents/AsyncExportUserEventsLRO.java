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

package com.google.cloud.retail.v2beta.samples;

// [START retail_v2beta_generated_UserEventService_ExportUserEvents_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.retail.v2beta.CatalogName;
import com.google.cloud.retail.v2beta.ExportMetadata;
import com.google.cloud.retail.v2beta.ExportUserEventsRequest;
import com.google.cloud.retail.v2beta.ExportUserEventsResponse;
import com.google.cloud.retail.v2beta.OutputConfig;
import com.google.cloud.retail.v2beta.UserEventServiceClient;

public class AsyncExportUserEventsLRO {

  public static void main(String[] args) throws Exception {
    asyncExportUserEventsLRO();
  }

  public static void asyncExportUserEventsLRO() throws Exception {
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
      OperationFuture<ExportUserEventsResponse, ExportMetadata> future =
          userEventServiceClient.exportUserEventsOperationCallable().futureCall(request);
      // Do something.
      ExportUserEventsResponse response = future.get();
    }
  }
}
// [END retail_v2beta_generated_UserEventService_ExportUserEvents_LRO_async]
