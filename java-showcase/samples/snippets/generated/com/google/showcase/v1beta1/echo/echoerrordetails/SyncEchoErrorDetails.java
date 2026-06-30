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

package com.google.showcase.v1beta1.samples;

// [START localhost7469_v1beta1_generated_Echo_EchoErrorDetails_sync]
import com.google.showcase.v1beta1.EchoClient;
import com.google.showcase.v1beta1.EchoErrorDetailsRequest;
import com.google.showcase.v1beta1.EchoErrorDetailsResponse;
import java.util.ArrayList;

public class SyncEchoErrorDetails {

  public static void main(String[] args) throws Exception {
    syncEchoErrorDetails();
  }

  public static void syncEchoErrorDetails() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (EchoClient echoClient = EchoClient.create()) {
      EchoErrorDetailsRequest request =
          EchoErrorDetailsRequest.newBuilder()
              .setSingleDetailText("singleDetailText1774380934")
              .addAllMultiDetailText(new ArrayList<String>())
              .build();
      EchoErrorDetailsResponse response = echoClient.echoErrorDetails(request);
    }
  }
}
// [END localhost7469_v1beta1_generated_Echo_EchoErrorDetails_sync]
