/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.dialogflow.cx.v3.samples;

// [START dialogflow_v3_generated_Sessions_MatchIntent_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.dialogflow.cx.v3.MatchIntentRequest;
import com.google.cloud.dialogflow.cx.v3.MatchIntentResponse;
import com.google.cloud.dialogflow.cx.v3.QueryInput;
import com.google.cloud.dialogflow.cx.v3.QueryParameters;
import com.google.cloud.dialogflow.cx.v3.SessionName;
import com.google.cloud.dialogflow.cx.v3.SessionsClient;

public class AsyncMatchIntent {

  public static void main(String[] args) throws Exception {
    asyncMatchIntent();
  }

  public static void asyncMatchIntent() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SessionsClient sessionsClient = SessionsClient.create()) {
      MatchIntentRequest request =
          MatchIntentRequest.newBuilder()
              .setSession(
                  SessionName.ofProjectLocationAgentSessionName(
                          "[PROJECT]", "[LOCATION]", "[AGENT]", "[SESSION]")
                      .toString())
              .setQueryParams(QueryParameters.newBuilder().build())
              .setQueryInput(QueryInput.newBuilder().build())
              .setPersistParameterChanges(true)
              .build();
      ApiFuture<MatchIntentResponse> future =
          sessionsClient.matchIntentCallable().futureCall(request);
      // Do something.
      MatchIntentResponse response = future.get();
    }
  }
}
// [END dialogflow_v3_generated_Sessions_MatchIntent_async]
