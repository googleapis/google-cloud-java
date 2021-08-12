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

// [START dialogflow_cx_update_intent]

import com.google.cloud.dialogflow.cx.v3.Intent;
import com.google.cloud.dialogflow.cx.v3.Intent.Builder;
import com.google.cloud.dialogflow.cx.v3.IntentsClient;
import com.google.cloud.dialogflow.cx.v3.UpdateIntentRequest;
import com.google.protobuf.FieldMask;
import java.io.IOException;

public class UpdateIntent {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String agentId = "my-agent-id";
    String intentId = "my-intent-id";
    String location = "my-location";
    String displayName = "my-display-name";
    updateIntent(projectId, agentId, intentId, location, displayName);
  }

  // DialogFlow API Update Intent sample.
  public static void updateIntent(
      String projectId, String agentId, String intentId, String location, String displayName)
      throws IOException {
    try (IntentsClient client = IntentsClient.create()) {
      String intentPath =
          "projects/"
              + projectId
              + "/locations/"
              + location
              + "/agents/"
              + agentId
              + "/intents/"
              + intentId;

      Builder intentBuilder = client.getIntent(intentPath).toBuilder();

      intentBuilder.setDisplayName(displayName);
      FieldMask fieldMask = FieldMask.newBuilder().addPaths("display_name").build();

      Intent intent = intentBuilder.build();
      UpdateIntentRequest request =
          UpdateIntentRequest.newBuilder()
              .setIntent(intent)
              .setLanguageCode("en")
              .setUpdateMask(fieldMask)
              .build();

      // Make API request to update intent using fieldmask
      Intent response = client.updateIntent(request);
      System.out.println(response);
    }
  }
}
// [END dialogflow_cx_update_intent]
