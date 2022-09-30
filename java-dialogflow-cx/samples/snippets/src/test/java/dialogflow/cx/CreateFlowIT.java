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

import static org.junit.Assert.assertEquals;

import com.google.cloud.dialogflow.cx.v3beta1.Flow;
import com.google.cloud.dialogflow.cx.v3beta1.FlowsClient;
import com.google.cloud.dialogflow.cx.v3beta1.FlowsSettings;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.UUID;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration (system) tests for {@link CreateFlow}. */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class CreateFlowIT {

  private static String DISPLAY_NAME = "flow-" + UUID.randomUUID().toString();
  private static String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static String LOCATION_GLOBAL = "global";
  private static String LOCATION_REGIONAL = "us-central1";
  private static String AGENT_ID_GLOBAL =
      System.getenv()
          .getOrDefault("DIALOGFLOW_CX_AGENT_ID_GLOBAL", "b8d0e85d-0741-4e6d-a66a-3671184b7b93");
  private static String AGENT_ID_REGIONAL =
      System.getenv()
          .getOrDefault("DIALOGFLOW_CX_AGENT_ID_REGIONAL", "1ea2bf10-d5ef-4442-b93f-a917d1991014");
  private static Map<String, String> EVENT_TO_FULFILLMENT_MESSAGES =
      ImmutableMap.of("event-1", "message-1", "event-2", "message-2");

  private static String newFlowNameGlobal;
  private static String newFlowNameRegional;

  @AfterClass
  public static void tearDown() throws Exception {
    // Delete the newly created Flow in the global location.
    if (newFlowNameGlobal != null) {
      try (FlowsClient flowsClient = FlowsClient.create()) {
        flowsClient.deleteFlow(newFlowNameGlobal);
      }
    }

    // Delete the newly created Flow in the regional location.
    if (newFlowNameRegional != null) {
      FlowsSettings flowsSettings =
          FlowsSettings.newBuilder()
              .setEndpoint(LOCATION_REGIONAL + "-dialogflow.googleapis.com:443")
              .build();
      try (FlowsClient flowsClient = FlowsClient.create(flowsSettings)) {
        flowsClient.deleteFlow(newFlowNameRegional);
      }

      // Small delay to prevent reaching quota limit of requests per minute
      Thread.sleep(250);
    }
  }

  @Test
  public void testCreateFlowGlobal() throws Exception {
    Flow result =
        CreateFlow.createFlow(
            DISPLAY_NAME,
            PROJECT_ID,
            LOCATION_GLOBAL,
            AGENT_ID_GLOBAL,
            EVENT_TO_FULFILLMENT_MESSAGES);
    newFlowNameGlobal = result.getName();

    assertEquals(result.getDisplayName(), DISPLAY_NAME);
    // Number of added event handlers + 2 default event handlers.
    assertEquals(result.getEventHandlersCount(), EVENT_TO_FULFILLMENT_MESSAGES.size() + 2);
  }

  @Test
  public void testCreateFlowRegional() throws Exception {
    Flow result =
        CreateFlow.createFlow(
            DISPLAY_NAME,
            PROJECT_ID,
            LOCATION_REGIONAL,
            AGENT_ID_REGIONAL,
            EVENT_TO_FULFILLMENT_MESSAGES);
    newFlowNameRegional = result.getName();

    assertEquals(result.getDisplayName(), DISPLAY_NAME);
    // Number of added event handlers + 2 default event handlers.
    assertEquals(result.getEventHandlersCount(), EVENT_TO_FULFILLMENT_MESSAGES.size() + 2);
  }
}
