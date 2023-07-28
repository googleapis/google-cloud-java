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

package com.google.cloud.aiplatform.v1.samples;

// [START aiplatform_v1_generated_MatchService_FindNeighbors_sync]
import com.google.cloud.aiplatform.v1.FindNeighborsRequest;
import com.google.cloud.aiplatform.v1.FindNeighborsResponse;
import com.google.cloud.aiplatform.v1.IndexEndpointName;
import com.google.cloud.aiplatform.v1.MatchServiceClient;
import java.util.ArrayList;

public class SyncFindNeighbors {

  public static void main(String[] args) throws Exception {
    syncFindNeighbors();
  }

  public static void syncFindNeighbors() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (MatchServiceClient matchServiceClient = MatchServiceClient.create()) {
      FindNeighborsRequest request =
          FindNeighborsRequest.newBuilder()
              .setIndexEndpoint(
                  IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
              .setDeployedIndexId("deployedIndexId-1101212953")
              .addAllQueries(new ArrayList<FindNeighborsRequest.Query>())
              .setReturnFullDatapoint(true)
              .build();
      FindNeighborsResponse response = matchServiceClient.findNeighbors(request);
    }
  }
}
// [END aiplatform_v1_generated_MatchService_FindNeighbors_sync]
