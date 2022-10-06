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

// [START gkemulticloud_v1_generated_awsclustersclient_createawscluster_lro_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.gkemulticloud.v1.AwsCluster;
import com.google.cloud.gkemulticloud.v1.AwsClustersClient;
import com.google.cloud.gkemulticloud.v1.CreateAwsClusterRequest;
import com.google.cloud.gkemulticloud.v1.LocationName;
import com.google.cloud.gkemulticloud.v1.OperationMetadata;

public class AsyncCreateAwsClusterLRO {

  public static void main(String[] args) throws Exception {
    asyncCreateAwsClusterLRO();
  }

  public static void asyncCreateAwsClusterLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
      CreateAwsClusterRequest request =
          CreateAwsClusterRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setAwsCluster(AwsCluster.newBuilder().build())
              .setAwsClusterId("awsClusterId1988965944")
              .setValidateOnly(true)
              .build();
      OperationFuture<AwsCluster, OperationMetadata> future =
          awsClustersClient.createAwsClusterOperationCallable().futureCall(request);
      // Do something.
      AwsCluster response = future.get();
    }
  }
}
// [END gkemulticloud_v1_generated_awsclustersclient_createawscluster_lro_async]
