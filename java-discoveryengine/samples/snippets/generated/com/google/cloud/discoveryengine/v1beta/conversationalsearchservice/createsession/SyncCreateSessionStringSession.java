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

package com.google.cloud.discoveryengine.v1beta.samples;

// [START discoveryengine_v1beta_generated_ConversationalSearchService_CreateSession_StringSession_sync]
import com.google.cloud.discoveryengine.v1beta.ConversationalSearchServiceClient;
import com.google.cloud.discoveryengine.v1beta.DataStoreName;
import com.google.cloud.discoveryengine.v1beta.Session;

public class SyncCreateSessionStringSession {

  public static void main(String[] args) throws Exception {
    syncCreateSessionStringSession();
  }

  public static void syncCreateSessionStringSession() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ConversationalSearchServiceClient conversationalSearchServiceClient =
        ConversationalSearchServiceClient.create()) {
      String parent =
          DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]")
              .toString();
      Session session = Session.newBuilder().build();
      Session response = conversationalSearchServiceClient.createSession(parent, session);
    }
  }
}
// [END discoveryengine_v1beta_generated_ConversationalSearchService_CreateSession_StringSession_sync]
