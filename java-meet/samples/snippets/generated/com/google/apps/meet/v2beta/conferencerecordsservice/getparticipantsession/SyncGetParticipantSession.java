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

package com.google.apps.meet.v2beta.samples;

// [START meet_v2beta_generated_ConferenceRecordsService_GetParticipantSession_sync]
import com.google.apps.meet.v2beta.ConferenceRecordsServiceClient;
import com.google.apps.meet.v2beta.GetParticipantSessionRequest;
import com.google.apps.meet.v2beta.ParticipantSession;
import com.google.apps.meet.v2beta.ParticipantSessionName;

public class SyncGetParticipantSession {

  public static void main(String[] args) throws Exception {
    syncGetParticipantSession();
  }

  public static void syncGetParticipantSession() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
        ConferenceRecordsServiceClient.create()) {
      GetParticipantSessionRequest request =
          GetParticipantSessionRequest.newBuilder()
              .setName(
                  ParticipantSessionName.of(
                          "[CONFERENCE_RECORD]", "[PARTICIPANT]", "[PARTICIPANT_SESSION]")
                      .toString())
              .build();
      ParticipantSession response = conferenceRecordsServiceClient.getParticipantSession(request);
    }
  }
}
// [END meet_v2beta_generated_ConferenceRecordsService_GetParticipantSession_sync]
