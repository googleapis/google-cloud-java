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

// [START dialogflow_cx_create_agent]

import com.google.cloud.dialogflow.cx.v3.Agent;
import com.google.cloud.dialogflow.cx.v3.Agent.Builder;
import com.google.cloud.dialogflow.cx.v3.AgentsClient;
import com.google.cloud.dialogflow.cx.v3.AgentsSettings;
import java.io.IOException;

public class CreateAgent {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String displayName = "my-display-name";

    createAgent(projectId, displayName);
  }

  public static Agent createAgent(String parent, String displayName) throws IOException {

    String apiEndpoint = "global-dialogflow.googleapis.com:443";

    AgentsSettings agentsSettings = AgentsSettings.newBuilder().setEndpoint(apiEndpoint).build();
    // Note: close() needs to be called on the AgentsClient object to clean up resources
    // such as threads. In the example below, try-with-resources is used,
    // which automatically calls close().
    try (AgentsClient client = AgentsClient.create(agentsSettings)) {
      // Set the details of the Agent to create
      Builder build = Agent.newBuilder();

      build.setDefaultLanguageCode("en");
      build.setDisplayName(displayName);
      // Correct format for timezone is location/city
      // For example America/Los_Angeles, Europe/Madrid, Asia/Tokyo
      build.setTimeZone("America/Los_Angeles");

      Agent agent = build.build();
      String parentPath = String.format("projects/%s/locations/%s", parent, "global");

      // Calls the create agent api and returns the created Agent
      Agent response = client.createAgent(parentPath, agent);
      System.out.println(response);
      return response;
    }
  }
}
// [END dialogflow_cx_create_agent]
