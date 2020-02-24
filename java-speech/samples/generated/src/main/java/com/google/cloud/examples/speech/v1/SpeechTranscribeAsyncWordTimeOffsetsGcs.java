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
// DO NOT EDIT! This is a generated sample ("LongRunningRequestAsync",  "speech_transcribe_async_word_time_offsets_gcs")
// sample-metadata:
//   title: Getting word timestamps (Cloud Storage) (LRO)
//   description: Print start and end time of each word spoken in audio file from Cloud Storage
//   usage: gradle run -PmainClass=com.google.cloud.examples.speech.v1.SpeechTranscribeAsyncWordTimeOffsetsGcs [--args='[--storage_uri "gs://cloud-samples-data/speech/brooklyn_bridge.flac"]']

package com.google.cloud.examples.speech.v1;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.speech.v1.LongRunningRecognizeMetadata;
import com.google.cloud.speech.v1.LongRunningRecognizeRequest;
import com.google.cloud.speech.v1.LongRunningRecognizeResponse;
import com.google.cloud.speech.v1.RecognitionAudio;
import com.google.cloud.speech.v1.RecognitionConfig;
import com.google.cloud.speech.v1.SpeechClient;
import com.google.cloud.speech.v1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1.SpeechRecognitionResult;
import com.google.cloud.speech.v1.WordInfo;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class SpeechTranscribeAsyncWordTimeOffsetsGcs {
  // [START speech_transcribe_async_word_time_offsets_gcs]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.api.gax.longrunning.OperationFuture;
   * import com.google.cloud.speech.v1.LongRunningRecognizeMetadata;
   * import com.google.cloud.speech.v1.LongRunningRecognizeRequest;
   * import com.google.cloud.speech.v1.LongRunningRecognizeResponse;
   * import com.google.cloud.speech.v1.RecognitionAudio;
   * import com.google.cloud.speech.v1.RecognitionConfig;
   * import com.google.cloud.speech.v1.SpeechClient;
   * import com.google.cloud.speech.v1.SpeechRecognitionAlternative;
   * import com.google.cloud.speech.v1.SpeechRecognitionResult;
   * import com.google.cloud.speech.v1.WordInfo;
   */

  public static void sampleLongRunningRecognize() {
    // TODO(developer): Replace these variables before running the sample.
    String storageUri = "gs://cloud-samples-data/speech/brooklyn_bridge.flac";
    sampleLongRunningRecognize(storageUri);
  }

  /**
   * Print start and end time of each word spoken in audio file from Cloud Storage
   *
   * @param storageUri URI for audio file in Cloud Storage, e.g. gs://[BUCKET]/[FILE]
   */
  public static void sampleLongRunningRecognize(String storageUri) {
    try (SpeechClient speechClient = SpeechClient.create()) {

      // When enabled, the first result returned by the API will include a list
      // of words and the start and end time offsets (timestamps) for those words.
      boolean enableWordTimeOffsets = true;

      // The language of the supplied audio
      String languageCode = "en-US";
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEnableWordTimeOffsets(enableWordTimeOffsets)
              .setLanguageCode(languageCode)
              .build();
      RecognitionAudio audio = RecognitionAudio.newBuilder().setUri(storageUri).build();
      LongRunningRecognizeRequest request =
          LongRunningRecognizeRequest.newBuilder().setConfig(config).setAudio(audio).build();
      OperationFuture<LongRunningRecognizeResponse, LongRunningRecognizeMetadata> future =
          speechClient.longRunningRecognizeAsync(request);

      System.out.println("Waiting for operation to complete...");
      LongRunningRecognizeResponse response = future.get();
      // The first result includes start and end time word offsets
      SpeechRecognitionResult result = response.getResultsList().get(0);
      // First alternative is the most probable result
      SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
      System.out.printf("Transcript: %s\n", alternative.getTranscript());
      // Print the start and end time of each word
      for (WordInfo word : alternative.getWordsList()) {
        System.out.printf("Word: %s\n", word.getWord());
        System.out.printf(
            "Start time: %s seconds %s nanos\n",
            word.getStartTime().getSeconds(), word.getStartTime().getNanos());
        System.out.printf(
            "End time: %s seconds %s nanos\n",
            word.getEndTime().getSeconds(), word.getEndTime().getNanos());
      }
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END speech_transcribe_async_word_time_offsets_gcs]

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("storage_uri").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String storageUri =
        cl.getOptionValue("storage_uri", "gs://cloud-samples-data/speech/brooklyn_bridge.flac");

    sampleLongRunningRecognize(storageUri);
  }
}
