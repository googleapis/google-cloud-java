/*
 * Copyright 2021 Google LLC
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

package dialogflow.cx;

// [START dialogflow_cx_delete_page]
import com.google.cloud.dialogflow.cx.v3.DeletePageRequest;
import com.google.cloud.dialogflow.cx.v3.DeletePageRequest.Builder;
import com.google.cloud.dialogflow.cx.v3.PagesClient;
import java.io.IOException;

public class DeletePage {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String agentId = "my-agent-id";
    String flowId = "my-flow-id";
    String pageId = "my-page-id";
    String location = "my-location";

    deletePage(projectId, agentId, flowId, pageId, location);
  }

  // DialogFlow API Delete Page Sample.
  // Deletes a page from the provided parameters
  public static void deletePage(
      String projectId, String agentId, String flowId, String pageId, String location)
      throws IOException {
    try (PagesClient client = PagesClient.create()) {
      Builder deleteRequestBuilder = DeletePageRequest.newBuilder();

      deleteRequestBuilder.setName(
          "projects/"
              + projectId
              + "/locations/"
              + location
              + "/agents/"
              + agentId
              + "/flows/"
              + flowId
              + "/pages/"
              + pageId);

      // Make API request to delete page
      client.deletePage(deleteRequestBuilder.build());
      System.out.println("Successfully deleted page!");
    }
  }
  // [END dialogflow_cx_delete_page]
}
