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

package com.google.cloud.alloydb.v1alpha.samples;

// [START alloydb_v1alpha_generated_AlloyDBCSQLAdmin_RestoreFromCloudSQL_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.alloydb.v1alpha.AlloyDBCSQLAdminClient;
import com.google.cloud.alloydb.v1alpha.Cluster;
import com.google.cloud.alloydb.v1alpha.LocationName;
import com.google.cloud.alloydb.v1alpha.OperationMetadata;
import com.google.cloud.alloydb.v1alpha.RestoreFromCloudSQLRequest;

public class AsyncRestoreFromCloudSQLLRO {

  public static void main(String[] args) throws Exception {
    asyncRestoreFromCloudSQLLRO();
  }

  public static void asyncRestoreFromCloudSQLLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AlloyDBCSQLAdminClient alloyDBCSQLAdminClient = AlloyDBCSQLAdminClient.create()) {
      RestoreFromCloudSQLRequest request =
          RestoreFromCloudSQLRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setClusterId("clusterId561939637")
              .setCluster(Cluster.newBuilder().build())
              .build();
      OperationFuture<Cluster, OperationMetadata> future =
          alloyDBCSQLAdminClient.restoreFromCloudSQLOperationCallable().futureCall(request);
      // Do something.
      Cluster response = future.get();
    }
  }
}
// [END alloydb_v1alpha_generated_AlloyDBCSQLAdmin_RestoreFromCloudSQL_LRO_async]
