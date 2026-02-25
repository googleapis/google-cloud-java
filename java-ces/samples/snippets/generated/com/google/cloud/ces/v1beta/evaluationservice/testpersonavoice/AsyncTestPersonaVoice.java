/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.ces.v1beta.samples;

// [START ces_v1beta_generated_EvaluationService_TestPersonaVoice_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.ces.v1beta.AppName;
import com.google.cloud.ces.v1beta.EvaluationServiceClient;
import com.google.cloud.ces.v1beta.TestPersonaVoiceRequest;
import com.google.cloud.ces.v1beta.TestPersonaVoiceResponse;

public class AsyncTestPersonaVoice {

  public static void main(String[] args) throws Exception {
    asyncTestPersonaVoice();
  }

  public static void asyncTestPersonaVoice() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
      TestPersonaVoiceRequest request =
          TestPersonaVoiceRequest.newBuilder()
              .setApp(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
              .setPersonaId("personaId853188071")
              .setText("text3556653")
              .build();
      ApiFuture<TestPersonaVoiceResponse> future =
          evaluationServiceClient.testPersonaVoiceCallable().futureCall(request);
      // Do something.
      TestPersonaVoiceResponse response = future.get();
    }
  }
}
// [END ces_v1beta_generated_EvaluationService_TestPersonaVoice_async]
