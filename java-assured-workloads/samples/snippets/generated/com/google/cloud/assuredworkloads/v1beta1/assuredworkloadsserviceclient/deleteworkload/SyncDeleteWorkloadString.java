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

package com.google.cloud.assuredworkloads.v1beta1.samples;

// [START assuredworkloads_v1beta1_generated_assuredworkloadsserviceclient_deleteworkload_string_sync]
import com.google.cloud.assuredworkloads.v1beta1.AssuredWorkloadsServiceClient;
import com.google.cloud.assuredworkloads.v1beta1.WorkloadName;
import com.google.protobuf.Empty;

public class SyncDeleteWorkloadString {

  public static void main(String[] args) throws Exception {
    syncDeleteWorkloadString();
  }

  public static void syncDeleteWorkloadString() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (AssuredWorkloadsServiceClient assuredWorkloadsServiceClient =
        AssuredWorkloadsServiceClient.create()) {
      String name = WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]").toString();
      assuredWorkloadsServiceClient.deleteWorkload(name);
    }
  }
}
// [END assuredworkloads_v1beta1_generated_assuredworkloadsserviceclient_deleteworkload_string_sync]
