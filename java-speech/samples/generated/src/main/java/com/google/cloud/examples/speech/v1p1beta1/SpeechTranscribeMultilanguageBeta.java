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
// DO NOT EDIT! This is a generated sample ("Request",  "speech_transcribe_multilanguage_beta")
// sample-metadata:
//   title: Detecting language spoken automatically (Local File) (Beta)
//   description: Transcribe a short audio file with language detected from a list of possible languages
//   usage: gradle run -PmainClass=com.google.cloud.examples.speech.v1p1beta1.SpeechTranscribeMultilanguageBeta [--args='[--local_file_path "resources/brooklyn_bridge.flac"]']

package com.google.cloud.examples.speech.v1p1beta1;

import com.google.cloud.speech.v1p1beta1.RecognitionAudio;
import com.google.cloud.speech.v1p1beta1.RecognitionConfig;
import com.google.cloud.speech.v1p1beta1.RecognizeRequest;
import com.google.cloud.speech.v1p1beta1.RecognizeResponse;
import com.google.cloud.speech.v1p1beta1.SpeechClient;
import com.google.cloud.speech.v1p1beta1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1p1beta1.SpeechRecognitionResult;
import com.google.protobuf.ByteString;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class SpeechTranscribeMultilanguageBeta {
  // [START speech_transcribe_multilanguage_beta]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.cloud.speech.v1p1beta1.RecognitionAudio;
   * import com.google.cloud.speech.v1p1beta1.RecognitionConfig;
   * import com.google.cloud.speech.v1p1beta1.RecognizeRequest;
   * import com.google.cloud.speech.v1p1beta1.RecognizeResponse;
   * import com.google.cloud.speech.v1p1beta1.SpeechClient;
   * import com.google.cloud.speech.v1p1beta1.SpeechRecognitionAlternative;
   * import com.google.cloud.speech.v1p1beta1.SpeechRecognitionResult;
   * import com.google.protobuf.ByteString;
   * import java.nio.file.Files;
   * import java.nio.file.Path;
   * import java.nio.file.Paths;
   * import java.util.Arrays;
   * import java.util.List;
   */

  public static void sampleRecognize() {
    // TODO(developer): Replace these variables before running the sample.
    String localFilePath = "resources/brooklyn_bridge.flac";
    sampleRecognize(localFilePath);
  }

  /**
   * Transcribe a short audio file with language detected from a list of possible languages
   *
   * @param localFilePath Path to local audio file, e.g. /path/audio.wav
   */
  public static void sampleRecognize(String localFilePath) {
    try (SpeechClient speechClient = SpeechClient.create()) {

      // The language of the supplied audio. Even though additional languages are
      // provided by alternative_language_codes, a primary language is still required.
      String languageCode = "fr";

      // Specify up to 3 additional languages as possible alternative languages
      // of the supplied audio.
      String alternativeLanguageCodesElement = "es";
      String alternativeLanguageCodesElement2 = "en";
      List<String> alternativeLanguageCodes =
          Arrays.asList(alternativeLanguageCodesElement, alternativeLanguageCodesElement2);
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setLanguageCode(languageCode)
              .addAllAlternativeLanguageCodes(alternativeLanguageCodes)
              .build();
      Path path = Paths.get(localFilePath);
      byte[] data = Files.readAllBytes(path);
      ByteString content = ByteString.copyFrom(data);
      RecognitionAudio audio = RecognitionAudio.newBuilder().setContent(content).build();
      RecognizeRequest request =
          RecognizeRequest.newBuilder().setConfig(config).setAudio(audio).build();
      RecognizeResponse response = speechClient.recognize(request);
      for (SpeechRecognitionResult result : response.getResultsList()) {
        // The languageCode which was detected as the most likely being spoken in the audio
        System.out.printf("Detected language: %s\n", result.getLanguageCode());
        // First alternative is the most probable result
        SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
        System.out.printf("Transcript: %s\n", alternative.getTranscript());
      }
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END speech_transcribe_multilanguage_beta]

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("local_file_path").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String localFilePath = cl.getOptionValue("local_file_path", "resources/brooklyn_bridge.flac");

    sampleRecognize(localFilePath);
  }
}
