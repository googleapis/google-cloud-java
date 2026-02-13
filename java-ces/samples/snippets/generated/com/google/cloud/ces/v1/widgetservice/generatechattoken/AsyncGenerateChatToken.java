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

package com.google.cloud.ces.v1.samples;

// [START ces_v1_generated_WidgetService_GenerateChatToken_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.ces.v1.DeploymentName;
import com.google.cloud.ces.v1.GenerateChatTokenRequest;
import com.google.cloud.ces.v1.GenerateChatTokenResponse;
import com.google.cloud.ces.v1.SessionName;
import com.google.cloud.ces.v1.WidgetServiceClient;

public class AsyncGenerateChatToken {

  public static void main(String[] args) throws Exception {
    asyncGenerateChatToken();
  }

  public static void asyncGenerateChatToken() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (WidgetServiceClient widgetServiceClient = WidgetServiceClient.create()) {
      GenerateChatTokenRequest request =
          GenerateChatTokenRequest.newBuilder()
              .setName(SessionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[SESSION]").toString())
              .setDeployment(
                  DeploymentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[DEPLOYMENT]").toString())
              .setRecaptchaToken("recaptchaToken1978277202")
              .build();
      ApiFuture<GenerateChatTokenResponse> future =
          widgetServiceClient.generateChatTokenCallable().futureCall(request);
      // Do something.
      GenerateChatTokenResponse response = future.get();
    }
  }
}
// [END ces_v1_generated_WidgetService_GenerateChatToken_async]
