/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package accessapproval;

// [START accessapproval_quickstart]
import com.google.cloud.accessapproval.v1.AccessApprovalAdminClient;
import com.google.cloud.accessapproval.v1.ApprovalRequest;
import java.io.IOException;

public class Quickstart {

  public void quickstart() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    quickstart(projectId);
  }

  public void quickstart(String projectId) throws IOException {
    try (AccessApprovalAdminClient client = AccessApprovalAdminClient.create()) {
      String parent = "projects/" + projectId;
      AccessApprovalAdminClient.ListApprovalRequestsPagedResponse response =
          client.listApprovalRequests(parent);
      int total = 0;
      for (ApprovalRequest request : response.iterateAll()) {
        System.out.println(request.getName());
        total++;
      }
      if (total == 0) {
        System.out.println("No approval requests found");
      }
    }
  }
}
// [END accessapproval_quickstart]
