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

package dialogflow.cx;

// [START dialogflow_cx_create_flow]

import com.google.api.gax.rpc.ApiException;
import com.google.cloud.dialogflow.cx.v3beta1.AgentName;
import com.google.cloud.dialogflow.cx.v3beta1.EventHandler;
import com.google.cloud.dialogflow.cx.v3beta1.Flow;
import com.google.cloud.dialogflow.cx.v3beta1.FlowsClient;
import com.google.cloud.dialogflow.cx.v3beta1.FlowsSettings;
import com.google.cloud.dialogflow.cx.v3beta1.Fulfillment;
import com.google.cloud.dialogflow.cx.v3beta1.ResponseMessage;
import com.google.cloud.dialogflow.cx.v3beta1.ResponseMessage.Text;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreateFlow {

  // Create a flow in the specified agent.
  public static Flow createFlow(
      String displayName,
      String projectId,
      String locationId,
      String agentId,
      Map<String, String> eventsToFulfillmentMessages)
      throws IOException, ApiException {
    FlowsSettings.Builder flowsSettingsBuilder = FlowsSettings.newBuilder();
    if (locationId.equals("global")) {
      flowsSettingsBuilder.setEndpoint("dialogflow.googleapis.com:443");
    } else {
      flowsSettingsBuilder.setEndpoint(locationId + "-dialogflow.googleapis.com:443");
    }
    FlowsSettings flowsSettings = flowsSettingsBuilder.build();

    // Instantiates a client
    try (FlowsClient flowsClient = FlowsClient.create(flowsSettings)) {
      // Set the project agent name using the projectID (my-project-id), locationID (global), and
      // agentID (UUID).
      AgentName parent = AgentName.of(projectId, locationId, agentId);

      // Build the EventHandlers for the flow using the mapping from events to fulfillment messages.
      List<EventHandler> eventHandlers = new ArrayList<>();
      for (Map.Entry<String, String> item : eventsToFulfillmentMessages.entrySet()) {
        eventHandlers.add(
            EventHandler.newBuilder()
                .setEvent(item.getKey()) // Event (sys.no-match-default)
                .setTriggerFulfillment(
                    Fulfillment.newBuilder()
                        // Text ("Sorry, could you say that again?")
                        .addMessages(
                            ResponseMessage.newBuilder()
                                .setText(Text.newBuilder().addText(item.getValue()).build())
                                .build())
                        .build())
                .build());
      }

      // Build the flow.
      Flow flow =
          Flow.newBuilder().setDisplayName(displayName).addAllEventHandlers(eventHandlers).build();

      // Performs the create flow request.
      Flow response = flowsClient.createFlow(parent, flow);

      // TODO : Uncomment if you want to print response
      // System.out.format("Flow created: %s\n", response.toString());
      flowsClient.shutdown();
      return response;
    }
  }
}
// [END dialogflow_cx_create_flow]
