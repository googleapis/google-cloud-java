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

package com.example.dialogflow;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.dialogflow.v2.Intent;
import com.google.cloud.dialogflow.v2.IntentsClient;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UpdateIntentIT {

  private static String PROJECT_ID = System.getenv().get("GOOGLE_CLOUD_PROJECT");

  private static String parent = "projects/" + PROJECT_ID + "/locations/global/agent";
  private static String intentID = "";
  private static String intentPath = "";

  private ByteArrayOutputStream stdOut;

  @Before
  public void setUp() throws IOException {

    stdOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(stdOut));

    try (IntentsClient intentsClient = IntentsClient.create()) {
      com.google.cloud.dialogflow.v2.Intent.Builder intent = Intent.newBuilder();
      intent.setDisplayName("temp_intent_" + UUID.randomUUID().toString());

      UpdateIntentIT.intentPath = intentsClient.createIntent(parent, intent.build()).getName();
      UpdateIntentIT.intentID = UpdateIntentIT.intentPath.split("/")[6];
    }
  }

  @After
  public void tearDown() throws IOException {
    stdOut = null;
    System.setOut(null);

    IntentsClient client = IntentsClient.create();

    String intentPath =
        "projects/" + PROJECT_ID + "/locations/global/agent/intents/" + UpdateIntentIT.intentID;

    client.deleteIntent(intentPath);
  }

  @Test
  public void testUpdateIntent() throws IOException {

    String fakeIntent = "fake_intent_" + UUID.randomUUID().toString();

    UpdateIntent.updateIntent(PROJECT_ID, UpdateIntentIT.intentID, "global", fakeIntent);

    assertThat(stdOut.toString()).contains(fakeIntent);
  }
}
