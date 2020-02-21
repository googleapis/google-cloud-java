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
// DO NOT EDIT! This is a generated sample ("Request",  "speech_transcribe_multichannel_gcs")
// sample-metadata:
//   title: Multi-Channel Audio Transcription (Cloud Storage)
//   description: Transcribe a short audio file from Cloud Storage with multiple channels
//   usage: gradle run
// -PmainClass=com.google.cloud.examples.speech.v1.SpeechTranscribeMultichannelGcs
// [--args='[--storage_uri "gs://cloud-samples-data/speech/multi.wav"]']

package com.google.cloud.examples.speech.v1;

import com.google.cloud.speech.v1.RecognitionAudio;
import com.google.cloud.speech.v1.RecognitionConfig;
import com.google.cloud.speech.v1.RecognizeRequest;
import com.google.cloud.speech.v1.RecognizeResponse;
import com.google.cloud.speech.v1.SpeechClient;
import com.google.cloud.speech.v1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1.SpeechRecognitionResult;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class SpeechTranscribeMultichannelGcs {
  // [START speech_transcribe_multichannel_gcs]
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
   */

  public static void sampleRecognize() {
    // TODO(developer): Replace these variables before running the sample.
    String storageUri = "gs://cloud-samples-data/speech/multi.wav";
    sampleRecognize(storageUri);
  }

  /**
   * Transcribe a short audio file from Cloud Storage with multiple channels
   *
   * @param storageUri URI for audio file in Cloud Storage, e.g. gs://[BUCKET]/[FILE]
   */
  public static void sampleRecognize(String storageUri) {
    try (SpeechClient speechClient = SpeechClient.create()) {

      // The number of channels in the input audio file (optional)
      int audioChannelCount = 2;

      // When set to true, each audio channel will be recognized separately.
      // The recognition result will contain a channel_tag field to state which
      // channel that result belongs to
      boolean enableSeparateRecognitionPerChannel = true;

      // The language of the supplied audio
      String languageCode = "en-US";
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setAudioChannelCount(audioChannelCount)
              .setEnableSeparateRecognitionPerChannel(enableSeparateRecognitionPerChannel)
              .setLanguageCode(languageCode)
              .build();
      RecognitionAudio audio = RecognitionAudio.newBuilder().setUri(storageUri).build();
      RecognizeRequest request =
          RecognizeRequest.newBuilder().setConfig(config).setAudio(audio).build();
      RecognizeResponse response = speechClient.recognize(request);
      for (SpeechRecognitionResult result : response.getResultsList()) {
        // channelTag to recognize which audio channel this result is for
        System.out.printf("Channel tag: %s\n", result.getChannelTag());
        // First alternative is the most probable result
        SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
        System.out.printf("Transcript: %s\n", alternative.getTranscript());
      }
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END speech_transcribe_multichannel_gcs]

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("storage_uri").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String storageUri =
        cl.getOptionValue("storage_uri", "gs://cloud-samples-data/speech/multi.wav");

    sampleRecognize(storageUri);
  }
}
