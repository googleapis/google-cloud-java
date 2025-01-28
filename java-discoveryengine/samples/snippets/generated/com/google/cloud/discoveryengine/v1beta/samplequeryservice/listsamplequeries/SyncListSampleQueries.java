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

package com.google.cloud.discoveryengine.v1beta.samples;

// [START discoveryengine_v1beta_generated_SampleQueryService_ListSampleQueries_sync]
import com.google.cloud.discoveryengine.v1beta.ListSampleQueriesRequest;
import com.google.cloud.discoveryengine.v1beta.SampleQuery;
import com.google.cloud.discoveryengine.v1beta.SampleQueryServiceClient;
import com.google.cloud.discoveryengine.v1beta.SampleQuerySetName;

public class SyncListSampleQueries {

  public static void main(String[] args) throws Exception {
    syncListSampleQueries();
  }

  public static void syncListSampleQueries() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SampleQueryServiceClient sampleQueryServiceClient = SampleQueryServiceClient.create()) {
      ListSampleQueriesRequest request =
          ListSampleQueriesRequest.newBuilder()
              .setParent(
                  SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      for (SampleQuery element : sampleQueryServiceClient.listSampleQueries(request).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END discoveryengine_v1beta_generated_SampleQueryService_ListSampleQueries_sync]
