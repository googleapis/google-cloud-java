/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dlp.snippets;

// [START dlp_list_jobs]

import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.privacy.dlp.v2.DlpJob;
import com.google.privacy.dlp.v2.DlpJobType;
import com.google.privacy.dlp.v2.ListDlpJobsRequest;
import com.google.privacy.dlp.v2.LocationName;
import java.io.IOException;

public class JobsList {

  public static void main(String[] args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    listJobs(projectId);
  }

  // Lists DLP jobs
  public static void listJobs(String projectId) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {

      // Construct the request to be sent by the client.
      // For more info on filters and job types,
      // see https://cloud.google.com/dlp/docs/reference/rest/v2/projects.dlpJobs/list
      ListDlpJobsRequest listDlpJobsRequest =
          ListDlpJobsRequest.newBuilder()
              .setParent(LocationName.of(projectId, "global").toString())
              .setFilter("state=DONE")
              .setType(DlpJobType.valueOf("INSPECT_JOB"))
              .build();

      // Send the request to list jobs and process the response
      DlpServiceClient.ListDlpJobsPagedResponse response =
          dlpServiceClient.listDlpJobs(listDlpJobsRequest);

      System.out.println("DLP jobs found:");
      for (DlpJob dlpJob : response.getPage().getValues()) {
        System.out.println(dlpJob.getName() + " -- " + dlpJob.getState());
      }
    }
  }
}
// [END dlp_list_jobs]
