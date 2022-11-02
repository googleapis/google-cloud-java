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

// [START assuredworkloads_v1beta1_generated_AssuredWorkloadsService_DeleteWorkload_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.assuredworkloads.v1beta1.AssuredWorkloadsServiceClient;
import com.google.cloud.assuredworkloads.v1beta1.DeleteWorkloadRequest;
import com.google.cloud.assuredworkloads.v1beta1.WorkloadName;
import com.google.protobuf.Empty;

public class AsyncDeleteWorkload {

  public static void main(String[] args) throws Exception {
    asyncDeleteWorkload();
  }

  public static void asyncDeleteWorkload() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AssuredWorkloadsServiceClient assuredWorkloadsServiceClient =
        AssuredWorkloadsServiceClient.create()) {
      DeleteWorkloadRequest request =
          DeleteWorkloadRequest.newBuilder()
              .setName(WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]").toString())
              .setEtag("etag3123477")
              .build();
      ApiFuture<Empty> future =
          assuredWorkloadsServiceClient.deleteWorkloadCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END assuredworkloads_v1beta1_generated_AssuredWorkloadsService_DeleteWorkload_async]
