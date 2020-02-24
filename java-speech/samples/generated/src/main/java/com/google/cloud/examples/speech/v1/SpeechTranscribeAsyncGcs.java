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
// DO NOT EDIT! This is a generated sample ("LongRunningRequestAsync",  "speech_transcribe_async_gcs")
// sample-metadata:
//   title: Transcript Audio File using Long Running Operation (Cloud Storage) (LRO)
//   description: Transcribe long audio file from Cloud Storage using asynchronous speech recognition
//   usage: gradle run -PmainClass=com.google.cloud.examples.speech.v1.SpeechTranscribeAsyncGcs [--args='[--storage_uri "gs://cloud-samples-data/speech/brooklyn_bridge.raw"]']

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
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class SpeechTranscribeAsyncGcs {
  // [START speech_transcribe_async_gcs]
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
   */

  public static void sampleLongRunningRecognize() {
    // TODO(developer): Replace these variables before running the sample.
    String storageUri = "gs://cloud-samples-data/speech/brooklyn_bridge.raw";
    sampleLongRunningRecognize(storageUri);
  }

  /**
   * Transcribe long audio file from Cloud Storage using asynchronous speech recognition
   *
   * @param storageUri URI for audio file in Cloud Storage, e.g. gs://[BUCKET]/[FILE]
   */
  public static void sampleLongRunningRecognize(String storageUri) {
    try (SpeechClient speechClient = SpeechClient.create()) {

      // Sample rate in Hertz of the audio data sent
      int sampleRateHertz = 16000;

      // The language of the supplied audio
      String languageCode = "en-US";

      // Encoding of audio data sent. This sample sets this explicitly.
      // This field is optional for FLAC and WAV audio formats.
      RecognitionConfig.AudioEncoding encoding = RecognitionConfig.AudioEncoding.LINEAR16;
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setSampleRateHertz(sampleRateHertz)
              .setLanguageCode(languageCode)
              .setEncoding(encoding)
              .build();
      RecognitionAudio audio = RecognitionAudio.newBuilder().setUri(storageUri).build();
      LongRunningRecognizeRequest request =
          LongRunningRecognizeRequest.newBuilder().setConfig(config).setAudio(audio).build();
      OperationFuture<LongRunningRecognizeResponse, LongRunningRecognizeMetadata> future =
          speechClient.longRunningRecognizeAsync(request);

      System.out.println("Waiting for operation to complete...");
      LongRunningRecognizeResponse response = future.get();
      for (SpeechRecognitionResult result : response.getResultsList()) {
        // First alternative is the most probable result
        SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
        System.out.printf("Transcript: %s\n", alternative.getTranscript());
      }
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END speech_transcribe_async_gcs]

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("storage_uri").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String storageUri =
        cl.getOptionValue("storage_uri", "gs://cloud-samples-data/speech/brooklyn_bridge.raw");

    sampleLongRunningRecognize(storageUri);
  }
}
