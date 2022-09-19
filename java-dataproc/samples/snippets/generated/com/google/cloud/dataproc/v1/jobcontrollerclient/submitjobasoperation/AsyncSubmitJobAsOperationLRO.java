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

// [START dataproc_v1_generated_jobcontrollerclient_submitjobasoperation_lro_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.dataproc.v1.Job;
import com.google.cloud.dataproc.v1.JobControllerClient;
import com.google.cloud.dataproc.v1.JobMetadata;
import com.google.cloud.dataproc.v1.SubmitJobRequest;

public class AsyncSubmitJobAsOperationLRO {

  public static void main(String[] args) throws Exception {
    asyncSubmitJobAsOperationLRO();
  }

  public static void asyncSubmitJobAsOperationLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
      SubmitJobRequest request =
          SubmitJobRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setRegion("region-934795532")
              .setJob(Job.newBuilder().build())
              .setRequestId("requestId693933066")
              .build();
      OperationFuture<Job, JobMetadata> future =
          jobControllerClient.submitJobAsOperationOperationCallable().futureCall(request);
      // Do something.
      Job response = future.get();
    }
  }
}
// [END dataproc_v1_generated_jobcontrollerclient_submitjobasoperation_lro_async]
