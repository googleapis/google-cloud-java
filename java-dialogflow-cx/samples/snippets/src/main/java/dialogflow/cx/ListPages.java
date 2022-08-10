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

// [START dialogflow_cx_list_pages]
import com.google.cloud.dialogflow.cx.v3.ListPagesRequest;
import com.google.cloud.dialogflow.cx.v3.ListPagesRequest.Builder;
import com.google.cloud.dialogflow.cx.v3.Page;
import com.google.cloud.dialogflow.cx.v3.PagesClient;
import java.io.IOException;

public class ListPages {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String agentId = "my-agent-id";
    String flowId = "my-flow-id";
    String location = "my-location";

    listPages(projectId, agentId, flowId, location);
  }

  // DialogFlow API List Pages Sample.
  // Lists all pages from the provided parameters
  public static void listPages(String projectId, String agentId, String flowId, String location)
      throws IOException {
    // Note: close() needs to be called on the PagesClient object to clean up resources
    // such as threads. In the example below, try-with-resources is used,
    // which automatically calls close().
    try (PagesClient client = PagesClient.create()) {
      Builder listRequestBuilder = ListPagesRequest.newBuilder();

      String parentPath =
          String.format(
              "projects/%s/locations/%s/agents/%s/flows/%s", projectId, location, agentId, flowId);
      listRequestBuilder.setParent(parentPath);
      listRequestBuilder.setLanguageCode("en");

      // Make API request to list all pages in the project
      for (Page element : client.listPages(listRequestBuilder.build()).iterateAll()) {
        System.out.println(element);
      }
    }
  }
  // [END dialogflow_cx_list_pages]
}
