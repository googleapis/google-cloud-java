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

// [START texttospeech_v1_generated_texttospeechclient_synthesizespeech_synthesisinputvoiceselectionparamsaudioconfig_sync]
import com.google.cloud.texttospeech.v1.AudioConfig;
import com.google.cloud.texttospeech.v1.SynthesisInput;
import com.google.cloud.texttospeech.v1.SynthesizeSpeechResponse;
import com.google.cloud.texttospeech.v1.TextToSpeechClient;
import com.google.cloud.texttospeech.v1.VoiceSelectionParams;

public class SyncSynthesizeSpeechSynthesisinputVoiceselectionparamsAudioconfig {

  public static void main(String[] args) throws Exception {
    syncSynthesizeSpeechSynthesisinputVoiceselectionparamsAudioconfig();
  }

  public static void syncSynthesizeSpeechSynthesisinputVoiceselectionparamsAudioconfig()
      throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
      SynthesisInput input = SynthesisInput.newBuilder().build();
      VoiceSelectionParams voice = VoiceSelectionParams.newBuilder().build();
      AudioConfig audioConfig = AudioConfig.newBuilder().build();
      SynthesizeSpeechResponse response =
          textToSpeechClient.synthesizeSpeech(input, voice, audioConfig);
    }
  }
}
// [END texttospeech_v1_generated_texttospeechclient_synthesizespeech_synthesisinputvoiceselectionparamsaudioconfig_sync]
