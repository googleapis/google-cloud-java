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

package com.google.apps.meet.v2.samples;

// [START meet_v2_generated_ConferenceRecordsService_ListParticipantSessions_async]
import com.google.api.core.ApiFuture;
import com.google.apps.meet.v2.ConferenceRecordsServiceClient;
import com.google.apps.meet.v2.ListParticipantSessionsRequest;
import com.google.apps.meet.v2.ParticipantName;
import com.google.apps.meet.v2.ParticipantSession;

public class AsyncListParticipantSessions {

  public static void main(String[] args) throws Exception {
    asyncListParticipantSessions();
  }

  public static void asyncListParticipantSessions() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
        ConferenceRecordsServiceClient.create()) {
      ListParticipantSessionsRequest request =
          ListParticipantSessionsRequest.newBuilder()
              .setParent(ParticipantName.of("[CONFERENCE_RECORD]", "[PARTICIPANT]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .build();
      ApiFuture<ParticipantSession> future =
          conferenceRecordsServiceClient.listParticipantSessionsPagedCallable().futureCall(request);
      // Do something.
      for (ParticipantSession element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END meet_v2_generated_ConferenceRecordsService_ListParticipantSessions_async]
