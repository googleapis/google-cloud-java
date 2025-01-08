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

package com.google.cloud.discoveryengine.v1alpha.samples;

// [START discoveryengine_v1alpha_generated_SampleQueryService_ListSampleQueries_Paged_async]
import com.google.cloud.discoveryengine.v1alpha.ListSampleQueriesRequest;
import com.google.cloud.discoveryengine.v1alpha.ListSampleQueriesResponse;
import com.google.cloud.discoveryengine.v1alpha.SampleQuery;
import com.google.cloud.discoveryengine.v1alpha.SampleQueryServiceClient;
import com.google.cloud.discoveryengine.v1alpha.SampleQuerySetName;
import com.google.common.base.Strings;

public class AsyncListSampleQueriesPaged {

  public static void main(String[] args) throws Exception {
    asyncListSampleQueriesPaged();
  }

  public static void asyncListSampleQueriesPaged() throws Exception {
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
      while (true) {
        ListSampleQueriesResponse response =
            sampleQueryServiceClient.listSampleQueriesCallable().call(request);
        for (SampleQuery element : response.getSampleQueriesList()) {
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
// [END discoveryengine_v1alpha_generated_SampleQueryService_ListSampleQueries_Paged_async]
