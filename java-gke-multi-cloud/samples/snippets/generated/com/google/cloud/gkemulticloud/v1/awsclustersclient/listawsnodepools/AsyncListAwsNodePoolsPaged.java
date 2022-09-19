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

// [START gkemulticloud_v1_generated_awsclustersclient_listawsnodepools_paged_async]
import com.google.cloud.gkemulticloud.v1.AwsClusterName;
import com.google.cloud.gkemulticloud.v1.AwsClustersClient;
import com.google.cloud.gkemulticloud.v1.AwsNodePool;
import com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsRequest;
import com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsResponse;
import com.google.common.base.Strings;

public class AsyncListAwsNodePoolsPaged {

  public static void main(String[] args) throws Exception {
    asyncListAwsNodePoolsPaged();
  }

  public static void asyncListAwsNodePoolsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
      ListAwsNodePoolsRequest request =
          ListAwsNodePoolsRequest.newBuilder()
              .setParent(AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListAwsNodePoolsResponse response =
            awsClustersClient.listAwsNodePoolsCallable().call(request);
        for (AwsNodePool element : response.getAwsNodePoolsList()) {
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
// [END gkemulticloud_v1_generated_awsclustersclient_listawsnodepools_paged_async]
