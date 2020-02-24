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
// DO NOT EDIT! This is a generated sample ("Request",  "speech_adaptation_beta")
// sample-metadata:
//   title: Speech Adaptation (Cloud Storage)
//   description: Transcribe a short audio file with speech adaptation.
//   usage: gradle run -PmainClass=com.google.cloud.examples.speech.v1p1beta1.SpeechAdaptationBeta [--args='[--storage_uri "gs://cloud-samples-data/speech/brooklyn_bridge.mp3"] [--phrase "Brooklyn Bridge"]']

package com.google.cloud.examples.speech.v1p1beta1;

import com.google.cloud.speech.v1p1beta1.RecognitionAudio;
import com.google.cloud.speech.v1p1beta1.RecognitionConfig;
import com.google.cloud.speech.v1p1beta1.RecognizeRequest;
import com.google.cloud.speech.v1p1beta1.RecognizeResponse;
import com.google.cloud.speech.v1p1beta1.SpeechClient;
import com.google.cloud.speech.v1p1beta1.SpeechContext;
import com.google.cloud.speech.v1p1beta1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1p1beta1.SpeechRecognitionResult;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class SpeechAdaptationBeta {
  // [START speech_adaptation_beta]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.cloud.speech.v1p1beta1.RecognitionAudio;
   * import com.google.cloud.speech.v1p1beta1.RecognitionConfig;
   * import com.google.cloud.speech.v1p1beta1.RecognizeRequest;
   * import com.google.cloud.speech.v1p1beta1.RecognizeResponse;
   * import com.google.cloud.speech.v1p1beta1.SpeechClient;
   * import com.google.cloud.speech.v1p1beta1.SpeechContext;
   * import com.google.cloud.speech.v1p1beta1.SpeechRecognitionAlternative;
   * import com.google.cloud.speech.v1p1beta1.SpeechRecognitionResult;
   * import java.util.Arrays;
   * import java.util.List;
   */

  public static void sampleRecognize() {
    // TODO(developer): Replace these variables before running the sample.
    String storageUri = "gs://cloud-samples-data/speech/brooklyn_bridge.mp3";
    String phrase = "Brooklyn Bridge";
    sampleRecognize(storageUri, phrase);
  }

  /**
   * Transcribe a short audio file with speech adaptation.
   *
   * @param storageUri URI for audio file in Cloud Storage, e.g. gs://[BUCKET]/[FILE]
   * @param phrase Phrase "hints" help recognize the specified phrases from your audio.
   */
  public static void sampleRecognize(String storageUri, String phrase) {
    try (SpeechClient speechClient = SpeechClient.create()) {
      List<String> phrases = Arrays.asList(phrase);

      // Hint Boost. This value increases the probability that a specific
      // phrase will be recognized over other similar sounding phrases.
      // The higher the boost, the higher the chance of false positive
      // recognition as well. Can accept wide range of positive values.
      // Most use cases are best served with values between 0 and 20.
      // Using a binary search happroach may help you find the optimal value.
      float boost = 20.0F;
      SpeechContext speechContextsElement =
          SpeechContext.newBuilder().addAllPhrases(phrases).setBoost(boost).build();
      List<SpeechContext> speechContexts = Arrays.asList(speechContextsElement);

      // Sample rate in Hertz of the audio data sent
      int sampleRateHertz = 44100;

      // The language of the supplied audio
      String languageCode = "en-US";

      // Encoding of audio data sent. This sample sets this explicitly.
      // This field is optional for FLAC and WAV audio formats.
      RecognitionConfig.AudioEncoding encoding = RecognitionConfig.AudioEncoding.MP3;
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .addAllSpeechContexts(speechContexts)
              .setSampleRateHertz(sampleRateHertz)
              .setLanguageCode(languageCode)
              .setEncoding(encoding)
              .build();
      RecognitionAudio audio = RecognitionAudio.newBuilder().setUri(storageUri).build();
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
  // [END speech_adaptation_beta]

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("storage_uri").build());
    options.addOption(Option.builder("").required(false).hasArg(true).longOpt("phrase").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String storageUri =
        cl.getOptionValue("storage_uri", "gs://cloud-samples-data/speech/brooklyn_bridge.mp3");
    String phrase = cl.getOptionValue("phrase", "Brooklyn Bridge");

    sampleRecognize(storageUri, phrase);
  }
}
