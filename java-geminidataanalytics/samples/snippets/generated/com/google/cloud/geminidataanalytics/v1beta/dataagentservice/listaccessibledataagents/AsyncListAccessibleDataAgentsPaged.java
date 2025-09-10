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

package com.google.cloud.geminidataanalytics.v1beta.samples;

// [START geminidataanalytics_v1beta_generated_DataAgentService_ListAccessibleDataAgents_Paged_async]
import com.google.cloud.geminidataanalytics.v1beta.DataAgent;
import com.google.cloud.geminidataanalytics.v1beta.DataAgentServiceClient;
import com.google.cloud.geminidataanalytics.v1beta.ListAccessibleDataAgentsRequest;
import com.google.cloud.geminidataanalytics.v1beta.ListAccessibleDataAgentsResponse;
import com.google.cloud.geminidataanalytics.v1beta.LocationName;
import com.google.common.base.Strings;

public class AsyncListAccessibleDataAgentsPaged {

  public static void main(String[] args) throws Exception {
    asyncListAccessibleDataAgentsPaged();
  }

  public static void asyncListAccessibleDataAgentsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
      ListAccessibleDataAgentsRequest request =
          ListAccessibleDataAgentsRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setOrderBy("orderBy-1207110587")
              .setShowDeleted(true)
              .build();
      while (true) {
        ListAccessibleDataAgentsResponse response =
            dataAgentServiceClient.listAccessibleDataAgentsCallable().call(request);
        for (DataAgent element : response.getDataAgentsList()) {
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
// [END geminidataanalytics_v1beta_generated_DataAgentService_ListAccessibleDataAgents_Paged_async]
