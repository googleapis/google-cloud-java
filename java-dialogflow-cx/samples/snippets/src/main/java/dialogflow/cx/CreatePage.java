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

// [START dialogflow_cx_create_page]

import com.google.api.gax.rpc.ApiException;
import com.google.cloud.dialogflow.cx.v3beta1.FlowName;
import com.google.cloud.dialogflow.cx.v3beta1.Form;
import com.google.cloud.dialogflow.cx.v3beta1.Form.Parameter;
import com.google.cloud.dialogflow.cx.v3beta1.Form.Parameter.FillBehavior;
import com.google.cloud.dialogflow.cx.v3beta1.Fulfillment;
import com.google.cloud.dialogflow.cx.v3beta1.Page;
import com.google.cloud.dialogflow.cx.v3beta1.PagesClient;
import com.google.cloud.dialogflow.cx.v3beta1.PagesSettings;
import com.google.cloud.dialogflow.cx.v3beta1.ResponseMessage;
import com.google.cloud.dialogflow.cx.v3beta1.ResponseMessage.Text;
import java.io.IOException;
import java.util.List;

public class CreatePage {

  // Create a page in the specified agent.
  public static Page createPage(
      String displayName,
      String projectId,
      String locationId,
      String agentId,
      String flowId,
      List<String> entryTexts)
      throws IOException, ApiException {
    PagesSettings.Builder pagesSettingsBuilder = PagesSettings.newBuilder();
    if (locationId.equals("global")) {
      pagesSettingsBuilder.setEndpoint("dialogflow.googleapis.com:443");
    } else {
      pagesSettingsBuilder.setEndpoint(locationId + "-dialogflow.googleapis.com:443");
    }
    PagesSettings pagesSettings = pagesSettingsBuilder.build();

    // Instantiates a client
    // Note: close() needs to be called on the PagesClient object to clean up resources
    // such as threads. In the example below, try-with-resources is used,
    // which automatically calls close().
    try (PagesClient pagesClient = PagesClient.create(pagesSettings)) {
      // Set the flow name using the projectID (my-project-id), locationID (global), agentID (UUID)
      // and flowID (UUID).
      FlowName parent = FlowName.of(projectId, locationId, agentId, flowId);

      // Build the entry fulfillment based on entry texts.
      Fulfillment.Builder entryFulfillmentBuilder = Fulfillment.newBuilder();
      for (String entryText : entryTexts) {
        entryFulfillmentBuilder.addMessages(
            ResponseMessage.newBuilder()
                // Text ("Hi")
                .setText(Text.newBuilder().addText(entryText).build())
                .build());
      }
      Fulfillment entryFulfillment = entryFulfillmentBuilder.build();

      // Build the form for the new page.
      // Note: hard coding parameters for simplicity.
      FillBehavior fillBehavior =
          FillBehavior.newBuilder()
              .setInitialPromptFulfillment(
                  Fulfillment.newBuilder()
                      .addMessages(
                          ResponseMessage.newBuilder()
                              .setText(Text.newBuilder().addText("What would you like?").build())
                              .build())
                      .build())
              .build();
      Form form =
          Form.newBuilder()
              .addParameters(
                  Parameter.newBuilder()
                      .setDisplayName("param")
                      .setRequired(true)
                      .setEntityType("projects/-/locations/-/agents/-/entityTypes/sys.any")
                      .setFillBehavior(fillBehavior)
                      .build())
              .build();

      // Build the page.
      Page page =
          Page.newBuilder()
              .setDisplayName(displayName)
              .setEntryFulfillment(entryFulfillment)
              .setForm(form)
              .build();

      // Performs the create page request.
      Page response = pagesClient.createPage(parent, page);

      // TODO : Uncomment if you want to print response
      // System.out.format("Page created: %s\n", response.toString());

      pagesClient.shutdown();
      return response;
    }
  }
}
// [END dialogflow_cx_create_page]
