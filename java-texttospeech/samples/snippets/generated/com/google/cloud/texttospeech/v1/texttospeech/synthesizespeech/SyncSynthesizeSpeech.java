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

package com.google.cloud.texttospeech.v1.samples;

// [START texttospeech_v1_generated_TextToSpeech_SynthesizeSpeech_sync]
import com.google.cloud.texttospeech.v1.AudioConfig;
import com.google.cloud.texttospeech.v1.SynthesisInput;
import com.google.cloud.texttospeech.v1.SynthesizeSpeechRequest;
import com.google.cloud.texttospeech.v1.SynthesizeSpeechResponse;
import com.google.cloud.texttospeech.v1.TextToSpeechClient;
import com.google.cloud.texttospeech.v1.VoiceSelectionParams;

public class SyncSynthesizeSpeech {

  public static void main(String[] args) throws Exception {
    syncSynthesizeSpeech();
  }

  public static void syncSynthesizeSpeech() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
      SynthesizeSpeechRequest request =
          SynthesizeSpeechRequest.newBuilder()
              .setInput(SynthesisInput.newBuilder().build())
              .setVoice(VoiceSelectionParams.newBuilder().build())
              .setAudioConfig(AudioConfig.newBuilder().build())
              .build();
      SynthesizeSpeechResponse response = textToSpeechClient.synthesizeSpeech(request);
    }
  }
}
// [END texttospeech_v1_generated_TextToSpeech_SynthesizeSpeech_sync]
