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

import com.google.cloud.dialogflow.cx.v3.AgentsClient;
import com.google.cloud.dialogflow.cx.v3.AgentsSettings;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CreateAgentIT {

  private static String PROJECT_ID = System.getenv().get("GOOGLE_CLOUD_PROJECT");
  private static String agentPath = "";
  private ByteArrayOutputStream stdOut;
  private static PrintStream originalOut;

  @Before
  public void setUp() throws IOException {
    originalOut = System.out;
    stdOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(stdOut));
  }

  @After
  public void tearDown() throws IOException, InterruptedException {
    System.setOut(originalOut);
    String apiEndpoint = "global-dialogflow.googleapis.com:443";

    AgentsSettings agentsSettings = AgentsSettings.newBuilder().setEndpoint(apiEndpoint).build();
    AgentsClient client = AgentsClient.create(agentsSettings);

    client.deleteAgent(CreateAgentIT.agentPath);

    // Small delay to prevent reaching quota limit of requests per minute
    Thread.sleep(250);
  }

  @Test
  public void testCreateAgent() throws IOException {
    String fakeAgent = String.format("fake_agent_%s", UUID.randomUUID().toString());

    CreateAgentIT.agentPath = CreateAgent.createAgent(PROJECT_ID, fakeAgent).getName();

    assertThat(stdOut.toString()).contains(fakeAgent);
  }
}
