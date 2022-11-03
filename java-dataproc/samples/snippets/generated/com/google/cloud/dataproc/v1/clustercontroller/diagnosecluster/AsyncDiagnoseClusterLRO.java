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

package com.google.cloud.dataproc.v1.samples;

// [START dataproc_v1_generated_ClusterController_DiagnoseCluster_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.dataproc.v1.ClusterControllerClient;
import com.google.cloud.dataproc.v1.ClusterOperationMetadata;
import com.google.cloud.dataproc.v1.DiagnoseClusterRequest;
import com.google.cloud.dataproc.v1.DiagnoseClusterResults;

public class AsyncDiagnoseClusterLRO {

  public static void main(String[] args) throws Exception {
    asyncDiagnoseClusterLRO();
  }

  public static void asyncDiagnoseClusterLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
      DiagnoseClusterRequest request =
          DiagnoseClusterRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setRegion("region-934795532")
              .setClusterName("clusterName-1141738587")
              .build();
      OperationFuture<DiagnoseClusterResults, ClusterOperationMetadata> future =
          clusterControllerClient.diagnoseClusterOperationCallable().futureCall(request);
      // Do something.
      DiagnoseClusterResults response = future.get();
    }
  }
}
// [END dataproc_v1_generated_ClusterController_DiagnoseCluster_LRO_async]
