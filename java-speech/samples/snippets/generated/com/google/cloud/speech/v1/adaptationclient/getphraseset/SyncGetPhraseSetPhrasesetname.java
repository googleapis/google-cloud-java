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

package com.google.cloud.speech.v1.samples;

// [START speech_v1_generated_adaptationclient_getphraseset_phrasesetname_sync]
import com.google.cloud.speech.v1.AdaptationClient;
import com.google.cloud.speech.v1.PhraseSet;
import com.google.cloud.speech.v1.PhraseSetName;

public class SyncGetPhraseSetPhrasesetname {

  public static void main(String[] args) throws Exception {
    syncGetPhraseSetPhrasesetname();
  }

  public static void syncGetPhraseSetPhrasesetname() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (AdaptationClient adaptationClient = AdaptationClient.create()) {
      PhraseSetName name = PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]");
      PhraseSet response = adaptationClient.getPhraseSet(name);
    }
  }
}
// [END speech_v1_generated_adaptationclient_getphraseset_phrasesetname_sync]
