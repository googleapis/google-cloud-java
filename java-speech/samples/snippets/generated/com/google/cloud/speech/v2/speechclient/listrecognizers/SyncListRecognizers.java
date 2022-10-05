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

package com.google.cloud.speech.v2.samples;

// [START speech_v2_generated_speechclient_listrecognizers_sync]
import com.google.cloud.speech.v2.ListRecognizersRequest;
import com.google.cloud.speech.v2.LocationName;
import com.google.cloud.speech.v2.Recognizer;
import com.google.cloud.speech.v2.SpeechClient;

public class SyncListRecognizers {

  public static void main(String[] args) throws Exception {
    syncListRecognizers();
  }

  public static void syncListRecognizers() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SpeechClient speechClient = SpeechClient.create()) {
      ListRecognizersRequest request =
          ListRecognizersRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setShowDeleted(true)
              .build();
      for (Recognizer element : speechClient.listRecognizers(request).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END speech_v2_generated_speechclient_listrecognizers_sync]
