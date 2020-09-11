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
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration (system) tests for {@link CreatePage}. */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class CreatePageIT {

  private static String DISPLAY_NAME = "page-" + UUID.randomUUID().toString();
  private static String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static String LOCATION = "global";
  private static String AGENT_ID =
      System.getenv()
          .getOrDefault("DIALOGFLOW_CX_AGENT_ID", "b8d0e85d-0741-4e6d-a66a-3671184b7b93");
  private static String DEFAULT_START_FLOW_ID = "00000000-0000-0000-0000-000000000000";
  private static List<String> ENTRY_TEXTS = Arrays.asList("Hi", "Hello", "How can I help you?");
  private static String newPageName;

  @After
  public void tearDown() throws Exception {
    // Delete the newly created Page.
    if (newPageName != null) {
      try (PagesClient pagesClient = PagesClient.create()) {
        pagesClient.deletePage(newPageName);
      }
    }
  }

  @Test
  public void testCreatePage() throws Exception {
    Page result =
        CreatePage.createPage(
            DISPLAY_NAME, PROJECT_ID, LOCATION, AGENT_ID, DEFAULT_START_FLOW_ID, ENTRY_TEXTS);
    newPageName = result.getName();

    assertEquals(result.getDisplayName(), DISPLAY_NAME);
    assertEquals(result.getEntryFulfillment().getMessagesCount(), ENTRY_TEXTS.size());
  }
}
