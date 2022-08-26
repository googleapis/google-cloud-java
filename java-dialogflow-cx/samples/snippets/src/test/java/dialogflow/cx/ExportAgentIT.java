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

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.dialogflow.cx.v3.Agent;
import com.google.cloud.dialogflow.cx.v3.Agent.Builder;
import com.google.cloud.dialogflow.cx.v3.AgentsClient;
import com.google.cloud.dialogflow.cx.v3.AgentsSettings;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExportAgentIT {

  private static String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static String parent = "";
  private static String agentPath = "";
  private static String agentID = "";

  private ByteArrayOutputStream stdOut;

  @BeforeClass
  public static void beforeAll() {
    assertThat(PROJECT_ID).isNotNull();
  }

  @Before
  public void setUp() throws IOException {
    stdOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(stdOut));

    Builder build = Agent.newBuilder();
    build.setDefaultLanguageCode("en");
    build.setDisplayName("temp_agent_" + UUID.randomUUID().toString());
    build.setTimeZone("America/Los_Angeles");

    Agent agent = build.build();

    String apiEndpoint = "global-dialogflow.googleapis.com:443";
    String parentPath = "projects/" + PROJECT_ID + "/locations/global";

    AgentsSettings agentsSettings = AgentsSettings.newBuilder().setEndpoint(apiEndpoint).build();
    AgentsClient client = AgentsClient.create(agentsSettings);

    parent = client.createAgent(parentPath, agent).getName();
    ExportAgentIT.agentPath = parent;
    ExportAgentIT.agentID = parent.split("/")[5];
    client.close();
  }

  @After
  public void tearDown() throws IOException, InterruptedException {
    stdOut = null;
    System.setOut(null);
    String apiEndpoint = "global-dialogflow.googleapis.com:443";

    AgentsSettings agentsSettings = AgentsSettings.newBuilder().setEndpoint(apiEndpoint).build();
    AgentsClient client = AgentsClient.create(agentsSettings);

    client.deleteAgent(ExportAgentIT.agentPath);
    client.close();

    // Small delay to prevent reaching quota limit of requests per minute
    Thread.sleep(250);
  }

  @Test
  public void testUpdateExportAgent() throws IOException, InterruptedException, ExecutionException {

    ExportAgent.exportAgent(PROJECT_ID, ExportAgentIT.agentID, "global");

    assertThat(stdOut.toString()).contains(ExportAgentIT.agentID);
  }
}
