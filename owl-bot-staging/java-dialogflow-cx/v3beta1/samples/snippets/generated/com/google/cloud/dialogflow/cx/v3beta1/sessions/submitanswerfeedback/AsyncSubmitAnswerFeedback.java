/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.dialogflow.cx.v3beta1.samples;

// [START dialogflow_v3beta1_generated_Sessions_SubmitAnswerFeedback_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.dialogflow.cx.v3beta1.AnswerFeedback;
import com.google.cloud.dialogflow.cx.v3beta1.SessionName;
import com.google.cloud.dialogflow.cx.v3beta1.SessionsClient;
import com.google.cloud.dialogflow.cx.v3beta1.SubmitAnswerFeedbackRequest;
import com.google.protobuf.FieldMask;

public class AsyncSubmitAnswerFeedback {

  public static void main(String[] args) throws Exception {
    asyncSubmitAnswerFeedback();
  }

  public static void asyncSubmitAnswerFeedback() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SessionsClient sessionsClient = SessionsClient.create()) {
      SubmitAnswerFeedbackRequest request =
          SubmitAnswerFeedbackRequest.newBuilder()
              .setSession(
                  SessionName.ofProjectLocationAgentSessionName(
                          "[PROJECT]", "[LOCATION]", "[AGENT]", "[SESSION]")
                      .toString())
              .setResponseId("responseId-633138884")
              .setAnswerFeedback(AnswerFeedback.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      ApiFuture<AnswerFeedback> future =
          sessionsClient.submitAnswerFeedbackCallable().futureCall(request);
      // Do something.
      AnswerFeedback response = future.get();
    }
  }
}
// [END dialogflow_v3beta1_generated_Sessions_SubmitAnswerFeedback_async]
