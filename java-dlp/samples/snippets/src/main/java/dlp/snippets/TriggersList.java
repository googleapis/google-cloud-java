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

// [START dlp_list_triggers]

import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.privacy.dlp.v2.JobTrigger;
import com.google.privacy.dlp.v2.ListJobTriggersRequest;
import com.google.privacy.dlp.v2.LocationName;
import java.io.IOException;

class TriggersList {
  public static void main(String[] args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    listTriggers(projectId);
  }

  public static void listTriggers(String projectId) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
      // Build the request to be sent by the client
      ListJobTriggersRequest listJobTriggersRequest =
          ListJobTriggersRequest.newBuilder()
              .setParent(LocationName.of(projectId, "global").toString())
              .build();

      // Use the client to send the API request.
      DlpServiceClient.ListJobTriggersPagedResponse response =
          dlpServiceClient.listJobTriggers(listJobTriggersRequest);

      // Parse the response and process the results
      System.out.println("DLP triggers found:");
      for (JobTrigger trigger : response.getPage().getValues()) {
        System.out.println("Trigger: " + trigger.getName());
        System.out.println("\tCreated: " + trigger.getCreateTime());
        System.out.println("\tUpdated: " + trigger.getUpdateTime());
        if (trigger.getDisplayName() != null) {
          System.out.println("\tDisplay name: " + trigger.getDisplayName());
        }
        if (trigger.getDescription() != null) {
          System.out.println("\tDescription: " + trigger.getDescription());
        }
        System.out.println("\tStatus: " + trigger.getStatus());
        System.out.println("\tError count: " + trigger.getErrorsCount());
      }
      ;
    }
  }
}
// [END dlp_list_triggers]
