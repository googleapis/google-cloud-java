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

package com.google.cloud.iam.v1beta.stub.samples;

// [START iam_v1beta_generated_WorkloadIdentityPoolsStubSettings_GetWorkloadIdentityPool_sync]
import com.google.cloud.iam.v1beta.stub.WorkloadIdentityPoolsStubSettings;
import java.time.Duration;

public class SyncGetWorkloadIdentityPool {

  public static void main(String[] args) throws Exception {
    syncGetWorkloadIdentityPool();
  }

  public static void syncGetWorkloadIdentityPool() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    WorkloadIdentityPoolsStubSettings.Builder workloadIdentityPoolsSettingsBuilder =
        WorkloadIdentityPoolsStubSettings.newBuilder();
    workloadIdentityPoolsSettingsBuilder
        .getWorkloadIdentityPoolSettings()
        .setRetrySettings(
            workloadIdentityPoolsSettingsBuilder
                .getWorkloadIdentityPoolSettings()
                .getRetrySettings()
                .toBuilder()
                .setTotalTimeout(Duration.ofSeconds(30))
                .build());
    WorkloadIdentityPoolsStubSettings workloadIdentityPoolsSettings =
        workloadIdentityPoolsSettingsBuilder.build();
  }
}
// [END iam_v1beta_generated_WorkloadIdentityPoolsStubSettings_GetWorkloadIdentityPool_sync]
