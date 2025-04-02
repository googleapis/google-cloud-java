/*
 * Copyright 2025 Google LLC
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

package com.google.spanner.adapter.v1.samples;

// [START spanner_v1_generated_Adapter_CreateSession_async]
import com.google.api.core.ApiFuture;
import com.google.spanner.adapter.v1.AdapterClient;
import com.google.spanner.adapter.v1.CreateSessionRequest;
import com.google.spanner.adapter.v1.DatabaseName;
import com.google.spanner.adapter.v1.Session;

public class AsyncCreateSession {

  public static void main(String[] args) throws Exception {
    asyncCreateSession();
  }

  public static void asyncCreateSession() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AdapterClient adapterClient = AdapterClient.create()) {
      CreateSessionRequest request =
          CreateSessionRequest.newBuilder()
              .setParent(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
              .setSession(Session.newBuilder().build())
              .build();
      ApiFuture<Session> future = adapterClient.createSessionCallable().futureCall(request);
      // Do something.
      Session response = future.get();
    }
  }
}
// [END spanner_v1_generated_Adapter_CreateSession_async]
