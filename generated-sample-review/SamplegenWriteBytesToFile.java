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
// DO NOT EDIT! This is a generated sample ("Request",  "samplegen_write_bytes_to_file")
// sample-metadata:
//   title: Synthesize an .mp3 file with audio saying the provided phrase
//   description: Synthesize an .mp3 file with audio saying the provided phrase
//   usage: gradle run -PmainClass=com.google.cloud.examples.texttospeech.v1.SamplegenWriteBytesToFile

package com.google.cloud.examples.texttospeech.v1;

import com.google.cloud.texttospeech.v1.AudioConfig;
import com.google.cloud.texttospeech.v1.AudioEncoding;
import com.google.cloud.texttospeech.v1.SynthesisInput;
import com.google.cloud.texttospeech.v1.SynthesizeSpeechRequest;
import com.google.cloud.texttospeech.v1.SynthesizeSpeechResponse;
import com.google.cloud.texttospeech.v1.TextToSpeechClient;
import com.google.cloud.texttospeech.v1.VoiceSelectionParams;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class SamplegenWriteBytesToFile {
  // [START samplegen_write_bytes_to_file]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.cloud.texttospeech.v1.AudioConfig;
   * import com.google.cloud.texttospeech.v1.AudioEncoding;
   * import com.google.cloud.texttospeech.v1.SynthesisInput;
   * import com.google.cloud.texttospeech.v1.SynthesizeSpeechRequest;
   * import com.google.cloud.texttospeech.v1.SynthesizeSpeechResponse;
   * import com.google.cloud.texttospeech.v1.TextToSpeechClient;
   * import com.google.cloud.texttospeech.v1.VoiceSelectionParams;
   * import java.io.FileOutputStream;
   * import java.io.OutputStream;
   */

  /** Synthesize an .mp3 file with audio saying the provided phrase */
  public static void sampleSynthesizeSpeech() {
    try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
      String text = "Hello, world!";
      SynthesisInput input = SynthesisInput.newBuilder().setText(text).build();
      String languageCode = "en";
      VoiceSelectionParams voice =
          VoiceSelectionParams.newBuilder().setLanguageCode(languageCode).build();
      AudioEncoding audioEncoding = AudioEncoding.MP3;
      AudioConfig audioConfig = AudioConfig.newBuilder().setAudioEncoding(audioEncoding).build();
      SynthesizeSpeechRequest request =
          SynthesizeSpeechRequest.newBuilder()
              .setInput(input)
              .setVoice(voice)
              .setAudioConfig(audioConfig)
              .build();
      SynthesizeSpeechResponse response = textToSpeechClient.synthesizeSpeech(request);
      System.out.println("Writing the synthsized results to output.mp3");
      try (OutputStream out = new FileOutputStream("output.mp3")) {
        out.write(response.getAudioContent().toByteArray());
      }
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END samplegen_write_bytes_to_file]

  public static void main(String[] args) {
    sampleSynthesizeSpeech();
  }
}
