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

package com.google.cloud.speech.v1p1beta1.samples;

// [START speech_v1p1beta1_generated_adaptationclient_createphraseset_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.speech.v1p1beta1.AdaptationClient;
import com.google.cloud.speech.v1p1beta1.CreatePhraseSetRequest;
import com.google.cloud.speech.v1p1beta1.LocationName;
import com.google.cloud.speech.v1p1beta1.PhraseSet;

public class AsyncCreatePhraseSet {

  public static void main(String[] args) throws Exception {
    asyncCreatePhraseSet();
  }

  public static void asyncCreatePhraseSet() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AdaptationClient adaptationClient = AdaptationClient.create()) {
      CreatePhraseSetRequest request =
          CreatePhraseSetRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setPhraseSetId("phraseSetId959902180")
              .setPhraseSet(PhraseSet.newBuilder().build())
              .build();
      ApiFuture<PhraseSet> future = adaptationClient.createPhraseSetCallable().futureCall(request);
      // Do something.
      PhraseSet response = future.get();
    }
  }
}
// [END speech_v1p1beta1_generated_adaptationclient_createphraseset_async]
