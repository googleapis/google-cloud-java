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

package com.google.cloud.gaming.v1beta.samples;

// [START gameservices_v1beta_generated_GameServerClustersService_PreviewDeleteGameServerCluster_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.gaming.v1beta.GameServerClusterName;
import com.google.cloud.gaming.v1beta.GameServerClustersServiceClient;
import com.google.cloud.gaming.v1beta.PreviewDeleteGameServerClusterRequest;
import com.google.cloud.gaming.v1beta.PreviewDeleteGameServerClusterResponse;
import com.google.protobuf.Timestamp;

public class AsyncPreviewDeleteGameServerCluster {

  public static void main(String[] args) throws Exception {
    asyncPreviewDeleteGameServerCluster();
  }

  public static void asyncPreviewDeleteGameServerCluster() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (GameServerClustersServiceClient gameServerClustersServiceClient =
        GameServerClustersServiceClient.create()) {
      PreviewDeleteGameServerClusterRequest request =
          PreviewDeleteGameServerClusterRequest.newBuilder()
              .setName(
                  GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]")
                      .toString())
              .setPreviewTime(Timestamp.newBuilder().build())
              .build();
      ApiFuture<PreviewDeleteGameServerClusterResponse> future =
          gameServerClustersServiceClient
              .previewDeleteGameServerClusterCallable()
              .futureCall(request);
      // Do something.
      PreviewDeleteGameServerClusterResponse response = future.get();
    }
  }
}
// [END gameservices_v1beta_generated_GameServerClustersService_PreviewDeleteGameServerCluster_async]
