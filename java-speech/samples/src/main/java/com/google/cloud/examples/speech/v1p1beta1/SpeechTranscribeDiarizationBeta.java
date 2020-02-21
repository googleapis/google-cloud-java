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
// DO NOT EDIT! This is a generated sample ("LongRunningRequestAsync",
// "speech_transcribe_diarization_beta")
// sample-metadata:
//   title: Separating different speakers (Local File) (LRO) (Beta)
//   description: Print confidence level for individual words in a transcription of a short audio
// file
//     Separating different speakers in an audio file recording
//   usage: gradle run
// -PmainClass=com.google.cloud.examples.speech.v1p1beta1.SpeechTranscribeDiarizationBeta
// [--args='[--local_file_path "resources/commercial_mono.wav"]']

package com.google.cloud.examples.speech.v1p1beta1;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.speech.v1p1beta1.LongRunningRecognizeMetadata;
import com.google.cloud.speech.v1p1beta1.LongRunningRecognizeRequest;
import com.google.cloud.speech.v1p1beta1.LongRunningRecognizeResponse;
import com.google.cloud.speech.v1p1beta1.RecognitionAudio;
import com.google.cloud.speech.v1p1beta1.RecognitionConfig;
import com.google.cloud.speech.v1p1beta1.SpeechClient;
import com.google.cloud.speech.v1p1beta1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1p1beta1.SpeechRecognitionResult;
import com.google.cloud.speech.v1p1beta1.WordInfo;
import com.google.protobuf.ByteString;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class SpeechTranscribeDiarizationBeta {
  // [START speech_transcribe_diarization_beta]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.api.gax.longrunning.OperationFuture;
   * import com.google.cloud.speech.v1p1beta1.LongRunningRecognizeMetadata;
   * import com.google.cloud.speech.v1p1beta1.LongRunningRecognizeRequest;
   * import com.google.cloud.speech.v1p1beta1.LongRunningRecognizeResponse;
   * import com.google.cloud.speech.v1p1beta1.RecognitionAudio;
   * import com.google.cloud.speech.v1p1beta1.RecognitionConfig;
   * import com.google.cloud.speech.v1p1beta1.SpeechClient;
   * import com.google.cloud.speech.v1p1beta1.SpeechRecognitionAlternative;
   * import com.google.cloud.speech.v1p1beta1.SpeechRecognitionResult;
   * import com.google.cloud.speech.v1p1beta1.WordInfo;
   * import com.google.protobuf.ByteString;
   * import java.nio.file.Files;
   * import java.nio.file.Path;
   * import java.nio.file.Paths;
   */

  public static void sampleLongRunningRecognize() {
    // TODO(developer): Replace these variables before running the sample.
    String localFilePath = "resources/commercial_mono.wav";
    sampleLongRunningRecognize(localFilePath);
  }

  /**
   * Print confidence level for individual words in a transcription of a short audio file Separating
   * different speakers in an audio file recording
   *
   * @param localFilePath Path to local audio file, e.g. /path/audio.wav
   */
  public static void sampleLongRunningRecognize(String localFilePath) {
    try (SpeechClient speechClient = SpeechClient.create()) {

      // If enabled, each word in the first alternative of each result will be
      // tagged with a speaker tag to identify the speaker.
      boolean enableSpeakerDiarization = true;

      // Optional. Specifies the estimated number of speakers in the conversation.
      int diarizationSpeakerCount = 2;

      // The language of the supplied audio
      String languageCode = "en-US";
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEnableSpeakerDiarization(enableSpeakerDiarization)
              .setDiarizationSpeakerCount(diarizationSpeakerCount)
              .setLanguageCode(languageCode)
              .build();
      Path path = Paths.get(localFilePath);
      byte[] data = Files.readAllBytes(path);
      ByteString content = ByteString.copyFrom(data);
      RecognitionAudio audio = RecognitionAudio.newBuilder().setContent(content).build();
      LongRunningRecognizeRequest request =
          LongRunningRecognizeRequest.newBuilder().setConfig(config).setAudio(audio).build();
      OperationFuture<LongRunningRecognizeResponse, LongRunningRecognizeMetadata> future =
          speechClient.longRunningRecognizeAsync(request);

      System.out.println("Waiting for operation to complete...");
      LongRunningRecognizeResponse response = future.get();
      for (SpeechRecognitionResult result : response.getResultsList()) {
        // First alternative has words tagged with speakers
        SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
        System.out.printf("Transcript: %s\n", alternative.getTranscript());
        // Print the speakerTag of each word
        for (WordInfo word : alternative.getWordsList()) {
          System.out.printf("Word: %s\n", word.getWord());
          System.out.printf("Speaker tag: %s\n", word.getSpeakerTag());
        }
      }
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END speech_transcribe_diarization_beta]

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("local_file_path").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String localFilePath = cl.getOptionValue("local_file_path", "resources/commercial_mono.wav");

    sampleLongRunningRecognize(localFilePath);
  }
}
