/*
 * Copyright 2019 Google LLC
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

// [START speech_transcribe_diarization_gcs]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.speech.v1.LongRunningRecognizeMetadata;
import com.google.cloud.speech.v1.LongRunningRecognizeResponse;
import com.google.cloud.speech.v1.RecognitionAudio;
import com.google.cloud.speech.v1.RecognitionConfig;
import com.google.cloud.speech.v1.SpeakerDiarizationConfig;
import com.google.cloud.speech.v1.SpeechClient;
import com.google.cloud.speech.v1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1.WordInfo;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class TranscribeDiarizationGcs {

  static void transcribeDiarizationGcs()
      throws IOException, ExecutionException, InterruptedException {
    // TODO(developer): Replace these variables before running the sample.
    String gcsUri = "gs://cloud-samples-data/speech/commercial_mono.wav";
    transcribeDiarizationGcs(gcsUri);
  }

  // Transcribe the give gcs file using speaker diarization
  public static void transcribeDiarizationGcs(String gcsUri)
      throws IOException, ExecutionException, InterruptedException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (SpeechClient speechClient = SpeechClient.create()) {
      SpeakerDiarizationConfig speakerDiarizationConfig =
          SpeakerDiarizationConfig.newBuilder()
              .setEnableSpeakerDiarization(true)
              .setMinSpeakerCount(2)
              .setMaxSpeakerCount(2)
              .build();
      // Configure request to enable Speaker diarization
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEncoding(RecognitionConfig.AudioEncoding.LINEAR16)
              .setLanguageCode("en-US")
              .setSampleRateHertz(8000)
              .setDiarizationConfig(speakerDiarizationConfig)
              .build();
      // Set the remote path for the audio file
      RecognitionAudio audio = RecognitionAudio.newBuilder().setUri(gcsUri).build();

      // Use non-blocking call for getting file transcription
      OperationFuture<LongRunningRecognizeResponse, LongRunningRecognizeMetadata> future =
          speechClient.longRunningRecognizeAsync(config, audio);
      System.out.println("Waiting for response...");

      // Speaker Tags are only included in the last result object, which has only one alternative.
      LongRunningRecognizeResponse response = future.get();
      SpeechRecognitionAlternative alternative =
          response.getResults(response.getResultsCount() - 1).getAlternatives(0);
      // The alternative is made up of WordInfo objects that contain the speaker_tag.
      WordInfo wordInfo = alternative.getWords(0);
      int currentSpeakerTag = wordInfo.getSpeakerTag();
      // For each word, get all the words associated with one speaker, once the speaker changes,
      // add a new line with the new speaker and their spoken words.
      StringBuilder speakerWords =
          new StringBuilder(
              String.format("Speaker %d: %s", wordInfo.getSpeakerTag(), wordInfo.getWord()));
      for (int i = 1; i < alternative.getWordsCount(); i++) {
        wordInfo = alternative.getWords(i);
        if (currentSpeakerTag == wordInfo.getSpeakerTag()) {
          speakerWords.append(" ");
          speakerWords.append(wordInfo.getWord());
        } else {
          speakerWords.append(
              String.format("\nSpeaker %d: %s", wordInfo.getSpeakerTag(), wordInfo.getWord()));
          currentSpeakerTag = wordInfo.getSpeakerTag();
        }
      }
      System.out.println(speakerWords.toString());
    }
  }
}
// [END speech_transcribe_diarization_gcs]
