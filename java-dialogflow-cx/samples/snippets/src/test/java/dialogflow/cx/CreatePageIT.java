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

import com.google.cloud.dialogflow.cx.v3beta1.Page;
import com.google.cloud.dialogflow.cx.v3beta1.PagesClient;
import com.google.cloud.dialogflow.cx.v3beta1.PagesSettings;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration (system) tests for {@link CreatePage}. */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class CreatePageIT {

  private static String DISPLAY_NAME = "page-" + UUID.randomUUID().toString();
  private static String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static String LOCATION_GLOBAL = "global";
  private static String LOCATION_REGIONAL = "us-central1";
  private static String AGENT_ID_GLOBAL =
      System.getenv()
          .getOrDefault("DIALOGFLOW_CX_AGENT_ID_GLOBAL", "b8d0e85d-0741-4e6d-a66a-3671184b7b93");
  private static String AGENT_ID_REGIONAL =
      System.getenv()
          .getOrDefault("DIALOGFLOW_CX_AGENT_ID_REGIONAL", "1ea2bf10-d5ef-4442-b93f-a917d1991014");
  private static String DEFAULT_START_FLOW_ID = "00000000-0000-0000-0000-000000000000";
  private static List<String> ENTRY_TEXTS = Arrays.asList("Hi", "Hello", "How can I help you?");

  private static String newPageNameGlobal;
  private static String newPageNameRegional;

  @AfterClass
  public static void tearDown() throws Exception {
    // Delete the newly created Page in the global location.
    if (newPageNameGlobal != null) {
      try (PagesClient pagesClient = PagesClient.create()) {
        pagesClient.deletePage(newPageNameGlobal);
      }
    }

    // Delete the newly created Page in the regional location.
    if (newPageNameRegional != null) {
      PagesSettings pagesSettings =
          PagesSettings.newBuilder()
              .setEndpoint(LOCATION_REGIONAL + "-dialogflow.googleapis.com:443")
              .build();
      try (PagesClient pagesClient = PagesClient.create(pagesSettings)) {
        pagesClient.deletePage(newPageNameRegional);
      }
    }
  }

  @Test
  public void testCreatePageGlobal() throws Exception {
    Page result =
        CreatePage.createPage(
            DISPLAY_NAME,
            PROJECT_ID,
            LOCATION_GLOBAL,
            AGENT_ID_GLOBAL,
            DEFAULT_START_FLOW_ID,
            ENTRY_TEXTS);
    newPageNameGlobal = result.getName();

    assertEquals(result.getDisplayName(), DISPLAY_NAME);
    assertEquals(result.getEntryFulfillment().getMessagesCount(), ENTRY_TEXTS.size());
  }

  @Test
  public void testCreatePageRegional() throws Exception {
    Page result =
        CreatePage.createPage(
            DISPLAY_NAME,
            PROJECT_ID,
            LOCATION_REGIONAL,
            AGENT_ID_REGIONAL,
            DEFAULT_START_FLOW_ID,
            ENTRY_TEXTS);
    newPageNameRegional = result.getName();

    assertEquals(result.getDisplayName(), DISPLAY_NAME);
    assertEquals(result.getEntryFulfillment().getMessagesCount(), ENTRY_TEXTS.size());
  }
}
