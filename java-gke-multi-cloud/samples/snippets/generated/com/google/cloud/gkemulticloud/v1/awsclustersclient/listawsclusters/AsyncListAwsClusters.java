/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.gkemulticloud.v1.samples;

// [START gkemulticloud_v1_generated_awsclustersclient_listawsclusters_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.gkemulticloud.v1.AwsCluster;
import com.google.cloud.gkemulticloud.v1.AwsClustersClient;
import com.google.cloud.gkemulticloud.v1.ListAwsClustersRequest;
import com.google.cloud.gkemulticloud.v1.LocationName;

public class AsyncListAwsClusters {

  public static void main(String[] args) throws Exception {
    asyncListAwsClusters();
  }

  public static void asyncListAwsClusters() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
      ListAwsClustersRequest request =
          ListAwsClustersRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      ApiFuture<AwsCluster> future =
          awsClustersClient.listAwsClustersPagedCallable().futureCall(request);
      // Do something.
      for (AwsCluster element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END gkemulticloud_v1_generated_awsclustersclient_listawsclusters_async]
