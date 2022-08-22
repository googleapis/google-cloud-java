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

// [START dialogflow_v2beta1_generated_contextsclient_createcontext_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.dialogflow.v2beta1.Context;
import com.google.cloud.dialogflow.v2beta1.ContextsClient;
import com.google.cloud.dialogflow.v2beta1.CreateContextRequest;
import com.google.cloud.dialogflow.v2beta1.SessionName;

public class AsyncCreateContext {

  public static void main(String[] args) throws Exception {
    asyncCreateContext();
  }

  public static void asyncCreateContext() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (ContextsClient contextsClient = ContextsClient.create()) {
      CreateContextRequest request =
          CreateContextRequest.newBuilder()
              .setParent(SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]").toString())
              .setContext(Context.newBuilder().build())
              .build();
      ApiFuture<Context> future = contextsClient.createContextCallable().futureCall(request);
      // Do something.
      Context response = future.get();
    }
  }
}
// [END dialogflow_v2beta1_generated_contextsclient_createcontext_async]
