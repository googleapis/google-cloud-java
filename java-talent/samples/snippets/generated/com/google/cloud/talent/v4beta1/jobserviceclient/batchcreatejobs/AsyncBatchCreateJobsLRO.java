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

package com.google.cloud.talent.v4beta1.samples;

// [START jobs_v4beta1_generated_jobserviceclient_batchcreatejobs_lro_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.talent.v4beta1.BatchCreateJobsRequest;
import com.google.cloud.talent.v4beta1.BatchOperationMetadata;
import com.google.cloud.talent.v4beta1.Job;
import com.google.cloud.talent.v4beta1.JobOperationResult;
import com.google.cloud.talent.v4beta1.JobServiceClient;
import com.google.cloud.talent.v4beta1.TenantName;
import java.util.ArrayList;

public class AsyncBatchCreateJobsLRO {

  public static void main(String[] args) throws Exception {
    asyncBatchCreateJobsLRO();
  }

  public static void asyncBatchCreateJobsLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
      BatchCreateJobsRequest request =
          BatchCreateJobsRequest.newBuilder()
              .setParent(TenantName.of("[PROJECT]", "[TENANT]").toString())
              .addAllJobs(new ArrayList<Job>())
              .build();
      OperationFuture<JobOperationResult, BatchOperationMetadata> future =
          jobServiceClient.batchCreateJobsOperationCallable().futureCall(request);
      // Do something.
      JobOperationResult response = future.get();
    }
  }
}
// [END jobs_v4beta1_generated_jobserviceclient_batchcreatejobs_lro_async]
