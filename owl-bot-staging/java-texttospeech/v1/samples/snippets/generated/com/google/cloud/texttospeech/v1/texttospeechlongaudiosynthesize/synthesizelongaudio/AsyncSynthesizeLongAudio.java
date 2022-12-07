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

// [START texttospeech_v1_generated_TextToSpeechLongAudioSynthesize_SynthesizeLongAudio_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.texttospeech.v1.AudioConfig;
import com.google.cloud.texttospeech.v1.SynthesisInput;
import com.google.cloud.texttospeech.v1.SynthesizeLongAudioRequest;
import com.google.cloud.texttospeech.v1.TextToSpeechLongAudioSynthesizeClient;
import com.google.cloud.texttospeech.v1.VoiceSelectionParams;
import com.google.longrunning.Operation;

public class AsyncSynthesizeLongAudio {

  public static void main(String[] args) throws Exception {
    asyncSynthesizeLongAudio();
  }

  public static void asyncSynthesizeLongAudio() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (TextToSpeechLongAudioSynthesizeClient textToSpeechLongAudioSynthesizeClient =
        TextToSpeechLongAudioSynthesizeClient.create()) {
      SynthesizeLongAudioRequest request =
          SynthesizeLongAudioRequest.newBuilder()
              .setParent("parent-995424086")
              .setInput(SynthesisInput.newBuilder().build())
              .setAudioConfig(AudioConfig.newBuilder().build())
              .setOutputGcsUri("outputGcsUri-489598154")
              .setVoice(VoiceSelectionParams.newBuilder().build())
              .build();
      ApiFuture<Operation> future =
          textToSpeechLongAudioSynthesizeClient.synthesizeLongAudioCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END texttospeech_v1_generated_TextToSpeechLongAudioSynthesize_SynthesizeLongAudio_async]
