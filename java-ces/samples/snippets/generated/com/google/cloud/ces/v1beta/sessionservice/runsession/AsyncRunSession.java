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

// [START ces_v1beta_generated_SessionService_RunSession_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.ces.v1beta.RunSessionRequest;
import com.google.cloud.ces.v1beta.RunSessionResponse;
import com.google.cloud.ces.v1beta.SessionConfig;
import com.google.cloud.ces.v1beta.SessionInput;
import com.google.cloud.ces.v1beta.SessionServiceClient;
import java.util.ArrayList;

public class AsyncRunSession {

  public static void main(String[] args) throws Exception {
    asyncRunSession();
  }

  public static void asyncRunSession() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
      RunSessionRequest request =
          RunSessionRequest.newBuilder()
              .setConfig(SessionConfig.newBuilder().build())
              .addAllInputs(new ArrayList<SessionInput>())
              .build();
      ApiFuture<RunSessionResponse> future =
          sessionServiceClient.runSessionCallable().futureCall(request);
      // Do something.
      RunSessionResponse response = future.get();
    }
  }
}
// [END ces_v1beta_generated_SessionService_RunSession_async]
