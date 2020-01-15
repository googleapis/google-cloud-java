/*
 * Copyright 2020 Google LLC
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
// DO NOT EDIT! This is a generated sample ("Request",  "speech_transcribe_enhanced_model")
// sample-metadata:
//   title: Using Enhanced Models (Local File)
//   description: Transcribe a short audio file using an enhanced model
//   usage: gradle run -PmainClass=com.google.cloud.examples.speech.v1.SpeechTranscribeEnhancedModel [--args='[--local_file_path "resources/hello.wav"]']

package com.google.cloud.examples.speech.v1;

import com.google.cloud.speech.v1.RecognitionAudio;
import com.google.cloud.speech.v1.RecognitionConfig;
import com.google.cloud.speech.v1.RecognizeRequest;
import com.google.cloud.speech.v1.RecognizeResponse;
import com.google.cloud.speech.v1.SpeechClient;
import com.google.cloud.speech.v1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1.SpeechRecognitionResult;
import com.google.protobuf.ByteString;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class SpeechTranscribeEnhancedModel {
  // [START speech_transcribe_enhanced_model]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.cloud.speech.v1.RecognitionAudio;
   * import com.google.cloud.speech.v1.RecognitionConfig;
   * import com.google.cloud.speech.v1.RecognizeRequest;
   * import com.google.cloud.speech.v1.RecognizeResponse;
   * import com.google.cloud.speech.v1.SpeechClient;
   * import com.google.cloud.speech.v1.SpeechRecognitionAlternative;
   * import com.google.cloud.speech.v1.SpeechRecognitionResult;
   * import com.google.protobuf.ByteString;
   * import java.nio.file.Files;
   * import java.nio.file.Path;
   * import java.nio.file.Paths;
   */

  public static void sampleRecognize() {
    // TODO(developer): Replace these variables before running the sample.
    String localFilePath = "resources/hello.wav";
    sampleRecognize(localFilePath);
  }

  /**
   * Transcribe a short audio file using an enhanced model
   *
   * @param localFilePath Path to local audio file, e.g. /path/audio.wav
   */
  public static void sampleRecognize(String localFilePath) {
    try (SpeechClient speechClient = SpeechClient.create()) {

      // The enhanced model to use, e.g. phone_call
      // Currently phone_call is the only model available as an enhanced model.
      String model = "phone_call";

      // Use an enhanced model for speech recognition (when set to true).
      // Project must be eligible for requesting enhanced models.
      // Enhanced speech models require that you opt-in to data logging.
      boolean useEnhanced = true;

      // The language of the supplied audio
      String languageCode = "en-US";
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setModel(model)
              .setUseEnhanced(useEnhanced)
              .setLanguageCode(languageCode)
              .build();
      Path path = Paths.get(localFilePath);
      byte[] data = Files.readAllBytes(path);
      ByteString content = ByteString.copyFrom(data);
      RecognitionAudio audio = RecognitionAudio.newBuilder().setContent(content).build();
      RecognizeRequest request =
          RecognizeRequest.newBuilder().setConfig(config).setAudio(audio).build();
      RecognizeResponse response = speechClient.recognize(request);
      for (SpeechRecognitionResult result : response.getResultsList()) {
        // First alternative is the most probable result
        SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
        System.out.printf("Transcript: %s\n", alternative.getTranscript());
      }
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END speech_transcribe_enhanced_model]

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("local_file_path").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String localFilePath = cl.getOptionValue("local_file_path", "resources/hello.wav");

    sampleRecognize(localFilePath);
  }
}
