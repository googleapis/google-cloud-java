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
// DO NOT EDIT! This is a generated sample ("Request",  "speech_contexts_classes_beta")
// sample-metadata:
//   title: Using Context Classes (Cloud Storage)
//   description: Transcribe a short audio file with static context classes.
//   usage: gradle run -PmainClass=com.google.cloud.examples.speech.v1p1beta1.SpeechContextsClassesBeta [--args='[--storage_uri "gs://cloud-samples-data/speech/time.mp3"] [--phrase "$TIME"]']

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

public class SpeechContextsClassesBeta {
  // [START speech_contexts_classes_beta]
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
    String storageUri = "gs://cloud-samples-data/speech/time.mp3";
    String phrase = "$TIME";
    sampleRecognize(storageUri, phrase);
  }

  /**
   * Transcribe a short audio file with static context classes.
   *
   * @param storageUri URI for audio file in Cloud Storage, e.g. gs://[BUCKET]/[FILE]
   * @param phrase Phrase "hints" help recognize the specified phrases from your audio. In this
   *     sample we are using a static class phrase ($TIME). Classes represent groups of words that
   *     represent common concepts that occur in natural language.
   */
  public static void sampleRecognize(String storageUri, String phrase) {
    try (SpeechClient speechClient = SpeechClient.create()) {
      List<String> phrases = Arrays.asList(phrase);
      SpeechContext speechContextsElement =
          SpeechContext.newBuilder().addAllPhrases(phrases).build();
      List<SpeechContext> speechContexts = Arrays.asList(speechContextsElement);

      // The language of the supplied audio
      String languageCode = "en-US";

      // Sample rate in Hertz of the audio data sent
      int sampleRateHertz = 24000;

      // Encoding of audio data sent. This sample sets this explicitly.
      // This field is optional for FLAC and WAV audio formats.
      RecognitionConfig.AudioEncoding encoding = RecognitionConfig.AudioEncoding.MP3;
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .addAllSpeechContexts(speechContexts)
              .setLanguageCode(languageCode)
              .setSampleRateHertz(sampleRateHertz)
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
  // [END speech_contexts_classes_beta]

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("storage_uri").build());
    options.addOption(Option.builder("").required(false).hasArg(true).longOpt("phrase").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String storageUri = cl.getOptionValue("storage_uri", "gs://cloud-samples-data/speech/time.mp3");
    String phrase = cl.getOptionValue("phrase", "$TIME");

    sampleRecognize(storageUri, phrase);
  }
}
