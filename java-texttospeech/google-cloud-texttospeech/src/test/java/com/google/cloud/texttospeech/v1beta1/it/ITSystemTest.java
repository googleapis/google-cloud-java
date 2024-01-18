/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.texttospeech.v1beta1.it;

import static org.junit.Assert.assertTrue;

import com.google.cloud.texttospeech.v1beta1.AudioConfig;
import com.google.cloud.texttospeech.v1beta1.AudioEncoding;
import com.google.cloud.texttospeech.v1beta1.ListVoicesRequest;
import com.google.cloud.texttospeech.v1beta1.ListVoicesResponse;
import com.google.cloud.texttospeech.v1beta1.SsmlVoiceGender;
import com.google.cloud.texttospeech.v1beta1.SynthesisInput;
import com.google.cloud.texttospeech.v1beta1.SynthesizeSpeechResponse;
import com.google.cloud.texttospeech.v1beta1.TextToSpeechClient;
import com.google.cloud.texttospeech.v1beta1.Voice;
import com.google.cloud.texttospeech.v1beta1.VoiceSelectionParams;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.util.List;
import org.junit.Test;

public class ITSystemTest {

  @Test
  public void synthesizeSpeechTest() throws IOException {
    try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
      SynthesisInput input = SynthesisInput.newBuilder().setText("Hello, World!").build();

      VoiceSelectionParams voice =
          VoiceSelectionParams.newBuilder()
              .setLanguageCode("en-US")
              .setSsmlGender(SsmlVoiceGender.NEUTRAL)
              .build();

      AudioConfig audioConfig =
          AudioConfig.newBuilder().setAudioEncoding(AudioEncoding.MP3).build();

      SynthesizeSpeechResponse response =
          textToSpeechClient.synthesizeSpeech(input, voice, audioConfig);

      ByteString audioContents = response.getAudioContent();

      assertTrue(!audioContents.isEmpty());
    }
  }

  @Test
  public void listVoicesTest() throws IOException {
    try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
      ListVoicesRequest request = ListVoicesRequest.getDefaultInstance();

      ListVoicesResponse response = textToSpeechClient.listVoices(request);
      List<Voice> voices = response.getVoicesList();

      assertTrue(!voices.isEmpty());
    }
  }
}
