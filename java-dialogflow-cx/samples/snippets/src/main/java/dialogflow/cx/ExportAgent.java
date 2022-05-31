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

// [START dialogflow_cx_export_agent]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.dialogflow.cx.v3.AgentName;
import com.google.cloud.dialogflow.cx.v3.AgentsClient;
import com.google.cloud.dialogflow.cx.v3.AgentsSettings;
import com.google.cloud.dialogflow.cx.v3.ExportAgentRequest;
import com.google.cloud.dialogflow.cx.v3.ExportAgentResponse;
import com.google.protobuf.Struct;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class ExportAgent {

  public static void main(String[] args)
      throws IOException, InterruptedException, ExecutionException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String agentId = "my-agent-id";
    String location = "my-location";

    exportAgent(projectId, agentId, location);
  }

  public static void exportAgent(String projectId, String agentId, String location)
      throws IOException, InterruptedException, ExecutionException {

    // Sets the api endpoint to specified location
    String apiEndpoint = String.format("%s-dialogflow.googleapis.com:443", location);

    AgentsSettings agentsSettings = AgentsSettings.newBuilder().setEndpoint(apiEndpoint).build();
    try (AgentsClient agentsClient = AgentsClient.create(agentsSettings)) {
      ExportAgentRequest request =
          ExportAgentRequest.newBuilder()
              .setName(AgentName.of(projectId, location, agentId).toString())
              .build();

      // Returns a future of the operation
      OperationFuture<ExportAgentResponse, Struct> future =
          agentsClient.exportAgentOperationCallable().futureCall(request);

      // get the export agent response after the operation is completed
      ExportAgentResponse response = future.get();
      System.out.println(response);
    }
  }
}
// [END dialogflow_cx_export_agent]
