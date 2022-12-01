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

// [START speech_v2_generated_Speech_CreateCustomClass_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.speech.v2.CreateCustomClassRequest;
import com.google.cloud.speech.v2.CustomClass;
import com.google.cloud.speech.v2.LocationName;
import com.google.cloud.speech.v2.SpeechClient;
import com.google.longrunning.Operation;

public class AsyncCreateCustomClass {

  public static void main(String[] args) throws Exception {
    asyncCreateCustomClass();
  }

  public static void asyncCreateCustomClass() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SpeechClient speechClient = SpeechClient.create()) {
      CreateCustomClassRequest request =
          CreateCustomClassRequest.newBuilder()
              .setCustomClass(CustomClass.newBuilder().build())
              .setValidateOnly(true)
              .setCustomClassId("customClassId1871032322")
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .build();
      ApiFuture<Operation> future = speechClient.createCustomClassCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END speech_v2_generated_Speech_CreateCustomClass_async]
