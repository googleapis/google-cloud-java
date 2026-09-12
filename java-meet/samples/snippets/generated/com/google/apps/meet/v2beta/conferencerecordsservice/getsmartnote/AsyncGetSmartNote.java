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

package com.google.apps.meet.v2beta.samples;

// [START meet_v2beta_generated_ConferenceRecordsService_GetSmartNote_async]
import com.google.api.core.ApiFuture;
import com.google.apps.meet.v2beta.ConferenceRecordsServiceClient;
import com.google.apps.meet.v2beta.GetSmartNoteRequest;
import com.google.apps.meet.v2beta.SmartNote;
import com.google.apps.meet.v2beta.SmartNoteName;

public class AsyncGetSmartNote {

  public static void main(String[] args) throws Exception {
    asyncGetSmartNote();
  }

  public static void asyncGetSmartNote() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
        ConferenceRecordsServiceClient.create()) {
      GetSmartNoteRequest request =
          GetSmartNoteRequest.newBuilder()
              .setName(SmartNoteName.of("[CONFERENCE_RECORD]", "[SMART_NOTE]").toString())
              .build();
      ApiFuture<SmartNote> future =
          conferenceRecordsServiceClient.getSmartNoteCallable().futureCall(request);
      // Do something.
      SmartNote response = future.get();
    }
  }
}
// [END meet_v2beta_generated_ConferenceRecordsService_GetSmartNote_async]
