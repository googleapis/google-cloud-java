/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.speech;

// [START speech_transcribe_with_model_adaptation_gcs_beta]
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.speech.v1p1beta1.AdaptationClient;
import com.google.cloud.speech.v1p1beta1.CreateCustomClassRequest;
import com.google.cloud.speech.v1p1beta1.CreatePhraseSetRequest;
import com.google.cloud.speech.v1p1beta1.CustomClass;
import com.google.cloud.speech.v1p1beta1.CustomClass.ClassItem;
import com.google.cloud.speech.v1p1beta1.LocationName;
import com.google.cloud.speech.v1p1beta1.PhraseSet;
import com.google.cloud.speech.v1p1beta1.PhraseSet.Phrase;
import com.google.cloud.speech.v1p1beta1.RecognitionAudio;
import com.google.cloud.speech.v1p1beta1.RecognitionConfig;
import com.google.cloud.speech.v1p1beta1.RecognitionConfig.AudioEncoding;
import com.google.cloud.speech.v1p1beta1.RecognizeResponse;
import com.google.cloud.speech.v1p1beta1.SpeechAdaptation;
import com.google.cloud.speech.v1p1beta1.SpeechClient;
import com.google.cloud.speech.v1p1beta1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1p1beta1.SpeechRecognitionResult;
import java.util.List;

public class SpeechModelAdaptationBeta {

  public static void main(String[] args) throws Exception {
    String uriPath = "gs://cloud-samples-tests/speech/brooklyn.flac";
    String projectId = "YOUR_PROJECT_ID";
    // Region e.g. us-west1
    String location = "LOCATION_REGION";
    // This value should be 4-63 characters, and valid characters are /[a-z][0-9]-/.
    String customClassId = "YOUR-CUSTOM-CLASS-ID";
    // This value should be 4-63 characters, and valid characters are /[a-z][0-9]-/.
    String phraseSetId = "YOUR-PHRASE-SET-ID";
    transcribeWithModelAdaptation(projectId, location, uriPath, customClassId, phraseSetId);
  }

  /**
   * Transcribe with model adaptation
   *
   * @param projectId your project id
   * @param location the region
   * @param gcsUri the path to the audio file
   */
  public static void transcribeWithModelAdaptation(
      String projectId, String location, String gcsUri, String customClassId, String phraseSetId)
      throws Exception {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (AdaptationClient adaptationClient = AdaptationClient.create()) {

      //  Create `PhraseSet` and `CustomClasses` to create custom lists of similar
      //  items that are likely to occur in your input data.

      // The parent resource where the custom class and phrase set will be created.
      LocationName parent = LocationName.of(projectId, location);

      // Create the custom class
      CreateCustomClassRequest classRequest =
          CreateCustomClassRequest.newBuilder()
              .setParent(parent.toString())
              .setCustomClassId(customClassId)
              .setCustomClass(
                  CustomClass.newBuilder()
                      .addItems(ClassItem.newBuilder().setValue("sushido"))
                      .addItems(ClassItem.newBuilder().setValue("altura"))
                      .addItems(ClassItem.newBuilder().setValue("taneda"))
                      .build())
              .build();
      CustomClass classResponse = adaptationClient.createCustomClass(classRequest);

      // Create the phrase set
      CreatePhraseSetRequest phraseRequest =
          CreatePhraseSetRequest.newBuilder()
              .setParent(parent.toString())
              .setPhraseSetId(phraseSetId)
              .setPhraseSet(
                  PhraseSet.newBuilder()
                      .setBoost(10)
                      .addPhrases(
                          Phrase.newBuilder()
                              .setValue(
                                  String.format("Visit restaurants like %s%n", customClassId)))
                      .build())
              .build();
      PhraseSet phraseResponse = adaptationClient.createPhraseSet(phraseRequest);

      // Next section shows how to use the newly created custom class and phrase set
      // to send a transcription request with speech adaptation

      // Speech adaptation configuration
      SpeechAdaptation speechAdaptation =
          SpeechAdaptation.newBuilder()
              .addCustomClasses(classResponse)
              .addPhraseSets(phraseResponse)
              .build();

      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests. After completing all of your requests, call
      // the "close" method on the client to safely clean up any remaining background resources.
      try (SpeechClient speechClient = SpeechClient.create()) {

        // The path to the audio file to transcribe
        // gcsUri URI for audio file in Cloud Storage, e.g. gs://[BUCKET]/[FILE]

        // Builds the sync recognize request
        RecognitionConfig config =
            RecognitionConfig.newBuilder()
                .setEncoding(AudioEncoding.FLAC)
                .setSampleRateHertz(16000)
                .setLanguageCode("en-US")
                .setAdaptation(speechAdaptation) // Set the adaptation object
                .build();
        RecognitionAudio audio = RecognitionAudio.newBuilder().setUri(gcsUri).build();

        // Performs speech recognition on the audio file.
        RecognizeResponse response = speechClient.recognize(config, audio);
        List<SpeechRecognitionResult> results = response.getResultsList();

        for (SpeechRecognitionResult result : results) {
          // There can be several alternative transcripts for a given chunk of speech. Just use the
          // first (most likely) one here.
          SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
          System.out.printf("Adapted Transcription: %s%n", alternative.getTranscript());
        }
      }
    } catch (ApiException e) {
      System.out.println("Client Interaction Error: \n" + e.toString());
    }
  }
}
// [END speech_transcribe_with_model_adaptation_gcs_beta]
