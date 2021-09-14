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
import com.google.cloud.dialogflow.cx.v3.Page;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/** Integration (system) tests for {@link PageManagment}. */
public class PageManagementIT {

  private static String PROJECT_ID = System.getenv().get("GOOGLE_CLOUD_PROJECT");
  private static String flowID = "00000000-0000-0000-0000-000000000000";
  private static String location = "global";
  private static String displayName = "temp_page_" + UUID.randomUUID().toString();
  private static String parent;
  private static String agentID;
  private static String pageID;
  private static ByteArrayOutputStream stdOut;

  @BeforeClass
  public static void setUp() throws IOException {
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
    agentID = parent.split("/")[5];
  }

  @AfterClass
  public static void tearDown() throws IOException {
    String apiEndpoint = "global-dialogflow.googleapis.com:443";
    String parentPath = "projects/" + PROJECT_ID + "/locations/global";

    AgentsSettings agentsSettings = AgentsSettings.newBuilder().setEndpoint(apiEndpoint).build();
    AgentsClient client = AgentsClient.create(agentsSettings);

    client.deleteAgent(parent);
  }

  @Test
  public void testCreatePage() throws IOException {
    Page p = CreateSimplePage.createPage(PROJECT_ID, agentID, flowID, location, displayName);
    pageID = p.getName().split("/")[9];

    assertThat(p.getDisplayName()).isEqualTo(displayName);
  }

  @Test
  public void testListPages() throws IOException {
    String name = "temp_page_" + UUID.randomUUID().toString();

    Page p = CreateSimplePage.createPage(PROJECT_ID, agentID, flowID, location, name);

    ListPages.listPages(PROJECT_ID, agentID, flowID, location);
    assertThat(stdOut.toString()).contains(name);
  }

  @Test
  public void testDeletePage() throws IOException {
    try {
      DeletePage.deletePage(PROJECT_ID, agentID, flowID, pageID, location);
      assertThat(1).isEqualTo(1);
    } catch (Exception e) {
      assertThat(e).isEqualTo("");
    }
  }
}
