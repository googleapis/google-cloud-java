/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.apptopology.v1.samples;

// [START apptopology_v1_generated_AppTopology_ExploreSchema_Paged_async]
import com.google.cloud.apptopology.v1.AppTopologyClient;
import com.google.cloud.apptopology.v1.ExploreSchemaRequest;
import com.google.cloud.apptopology.v1.ExploreSchemaResponse;
import com.google.cloud.apptopology.v1.NodeType;
import com.google.cloud.apptopology.v1.SchemaName;
import com.google.common.base.Strings;
import java.util.ArrayList;

public class AsyncExploreSchemaPaged {

  public static void main(String[] args) throws Exception {
    asyncExploreSchemaPaged();
  }

  public static void asyncExploreSchemaPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AppTopologyClient appTopologyClient = AppTopologyClient.create()) {
      ExploreSchemaRequest request =
          ExploreSchemaRequest.newBuilder()
              .setName(SchemaName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
              .addAllStartLabels(new ArrayList<String>())
              .setDepth(95472323)
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ExploreSchemaResponse response = appTopologyClient.exploreSchemaCallable().call(request);
        for (NodeType element : response.getNodeTypesList()) {
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
// [END apptopology_v1_generated_AppTopology_ExploreSchema_Paged_async]
