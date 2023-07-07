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

package com.google.cloud.dialogflow.cx.v3.samples;

// [START dialogflow_v3_generated_Environments_RunContinuousTest_sync]
import com.google.cloud.dialogflow.cx.v3.EnvironmentName;
import com.google.cloud.dialogflow.cx.v3.EnvironmentsClient;
import com.google.cloud.dialogflow.cx.v3.RunContinuousTestRequest;
import com.google.cloud.dialogflow.cx.v3.RunContinuousTestResponse;

public class SyncRunContinuousTest {

  public static void main(String[] args) throws Exception {
    syncRunContinuousTest();
  }

  public static void syncRunContinuousTest() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
      RunContinuousTestRequest request =
          RunContinuousTestRequest.newBuilder()
              .setEnvironment(
                  EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
                      .toString())
              .build();
      RunContinuousTestResponse response = environmentsClient.runContinuousTestAsync(request).get();
    }
  }
}
// [END dialogflow_v3_generated_Environments_RunContinuousTest_sync]
