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

// [START dialogflow_cx_create_page]
import com.google.cloud.dialogflow.cx.v3.CreatePageRequest;
import com.google.cloud.dialogflow.cx.v3.Page;
import com.google.cloud.dialogflow.cx.v3.PagesClient;
import java.io.IOException;

public class CreateSimplePage {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String agentId = "my-agent-id";
    String flowId = "my-flow-id";
    String location = "my-location";
    String displayName = "my-display-name";

    createPage(projectId, agentId, flowId, location, displayName);
  }

  // DialogFlow API Create Page Sample.
  // Creates a page from the provided parameters
  public static Page createPage(
      String projectId, String agentId, String flowId, String location, String displayName)
      throws IOException {
    Page response;
    CreatePageRequest.Builder createRequestBuilder = CreatePageRequest.newBuilder();
    Page.Builder pageBuilder = Page.newBuilder();

    pageBuilder.setDisplayName(displayName);

    createRequestBuilder
        .setParent(
            "projects/"
                + projectId
                + "/locations/"
                + location
                + "/agents/"
                + agentId
                + "/flows/"
                + flowId)
        .setPage(pageBuilder);

    // Make API request to create page
    // Note: close() needs to be called on the PagesClient object to clean up resources
    // such as threads. In the example below, try-with-resources is used,
    // which automatically calls close().
    try (PagesClient client = PagesClient.create()) {
      response = client.createPage(createRequestBuilder.build());
      System.out.println("Successfully created page!");
      return response;
    }
  }
  // [END dialogflow_cx_create_page]
}
