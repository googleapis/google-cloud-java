/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.dialogflow.v2beta1.samples;

// [START dialogflow_v2beta1_generated_contextsclient_updatecontext_sync]
import com.google.cloud.dialogflow.v2beta1.Context;
import com.google.cloud.dialogflow.v2beta1.ContextsClient;
import com.google.cloud.dialogflow.v2beta1.UpdateContextRequest;
import com.google.protobuf.FieldMask;

public class SyncUpdateContext {

  public static void main(String[] args) throws Exception {
    syncUpdateContext();
  }

  public static void syncUpdateContext() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ContextsClient contextsClient = ContextsClient.create()) {
      UpdateContextRequest request =
          UpdateContextRequest.newBuilder()
              .setContext(Context.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      Context response = contextsClient.updateContext(request);
    }
  }
}
// [END dialogflow_v2beta1_generated_contextsclient_updatecontext_sync]
