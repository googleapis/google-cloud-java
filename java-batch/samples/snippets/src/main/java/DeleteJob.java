// Copyright 2022 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

// [START batch_delete_job]

import com.google.cloud.batch.v1.BatchServiceClient;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class DeleteJob {

  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    // Project ID or project number of the Cloud project you want to use.
    String projectId = "YOUR_PROJECT_ID";

    // Name of the region hosts the job.
    String region = "europe-central2";

    // The name of the job that you want to delete.
    String jobName = "JOB_NAME";

    deleteJob(projectId, region, jobName);
  }

  // Triggers the deletion of a Job.
  public static void deleteJob(String projectId, String region, String jobName)
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the `batchServiceClient.close()` method on the client to safely
    // clean up any remaining background resources.
    try (BatchServiceClient batchServiceClient = BatchServiceClient.create()) {

      // Construct the parent path of the job.
      String name = String.format("projects/%s/locations/%s/jobs/%s", projectId, region, jobName);

      batchServiceClient.deleteJobAsync(name).get(3, TimeUnit.MINUTES);
      System.out.printf("Delete the job: %s", jobName);
    }
  }
}
// [END batch_delete_job]
