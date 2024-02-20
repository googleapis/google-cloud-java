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

package com.google.dataflow.v1beta3.samples;

// [START dataflow_v1beta3_generated_JobsV1Beta3_SnapshotJob_async]
import com.google.api.core.ApiFuture;
import com.google.dataflow.v1beta3.JobsV1Beta3Client;
import com.google.dataflow.v1beta3.Snapshot;
import com.google.dataflow.v1beta3.SnapshotJobRequest;
import com.google.protobuf.Duration;

public class AsyncSnapshotJob {

  public static void main(String[] args) throws Exception {
    asyncSnapshotJob();
  }

  public static void asyncSnapshotJob() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (JobsV1Beta3Client jobsV1Beta3Client = JobsV1Beta3Client.create()) {
      SnapshotJobRequest request =
          SnapshotJobRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setJobId("jobId101296568")
              .setTtl(Duration.newBuilder().build())
              .setLocation("location1901043637")
              .setSnapshotSources(true)
              .setDescription("description-1724546052")
              .build();
      ApiFuture<Snapshot> future = jobsV1Beta3Client.snapshotJobCallable().futureCall(request);
      // Do something.
      Snapshot response = future.get();
    }
  }
}
// [END dataflow_v1beta3_generated_JobsV1Beta3_SnapshotJob_async]
