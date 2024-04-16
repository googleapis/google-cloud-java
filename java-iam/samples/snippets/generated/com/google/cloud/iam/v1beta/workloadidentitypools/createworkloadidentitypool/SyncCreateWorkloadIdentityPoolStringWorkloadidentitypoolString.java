/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.iam.v1beta.samples;

// [START iam_v1beta_generated_WorkloadIdentityPools_CreateWorkloadIdentityPool_StringWorkloadidentitypoolString_sync]
import com.google.cloud.iam.v1beta.WorkloadIdentityPoolsClient;
import com.google.iam.v1beta.ProjectName;
import com.google.iam.v1beta.WorkloadIdentityPool;

public class SyncCreateWorkloadIdentityPoolStringWorkloadidentitypoolString {

  public static void main(String[] args) throws Exception {
    syncCreateWorkloadIdentityPoolStringWorkloadidentitypoolString();
  }

  public static void syncCreateWorkloadIdentityPoolStringWorkloadidentitypoolString()
      throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
        WorkloadIdentityPoolsClient.create()) {
      String parent = ProjectName.of("[PROJECT]").toString();
      WorkloadIdentityPool workloadIdentityPool = WorkloadIdentityPool.newBuilder().build();
      String workloadIdentityPoolId = "workloadIdentityPoolId1304488972";
      WorkloadIdentityPool response =
          workloadIdentityPoolsClient
              .createWorkloadIdentityPoolAsync(parent, workloadIdentityPool, workloadIdentityPoolId)
              .get();
    }
  }
}
// [END iam_v1beta_generated_WorkloadIdentityPools_CreateWorkloadIdentityPool_StringWorkloadidentitypoolString_sync]
