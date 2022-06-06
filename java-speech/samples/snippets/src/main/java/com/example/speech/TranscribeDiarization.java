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

// [START speech_transcribe_diarization]

import com.google.cloud.speech.v1.RecognitionAudio;
import com.google.cloud.speech.v1.RecognitionConfig;
import com.google.cloud.speech.v1.RecognizeResponse;
import com.google.cloud.speech.v1.SpeakerDiarizationConfig;
import com.google.cloud.speech.v1.SpeechClient;
import com.google.cloud.speech.v1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1.WordInfo;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class TranscribeDiarization {

  static void transcribeDiarization() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String fileName = "resources/commercial_mono.wav";
    transcribeDiarization(fileName);
  }

  // Transcribe the given audio file using speaker diarization.
  static void transcribeDiarization(String fileName) throws IOException {
    Path path = Paths.get(fileName);
    byte[] content = Files.readAllBytes(path);

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (SpeechClient client = SpeechClient.create()) {
      // Get the contents of the local audio file
      RecognitionAudio recognitionAudio =
          RecognitionAudio.newBuilder().setContent(ByteString.copyFrom(content)).build();
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

      // Perform the transcription request
      RecognizeResponse recognizeResponse = client.recognize(config, recognitionAudio);

      // Speaker Tags are only included in the last result object, which has only one alternative.
      SpeechRecognitionAlternative alternative =
          recognizeResponse.getResults(recognizeResponse.getResultsCount() - 1).getAlternatives(0);
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
// [END speech_transcribe_diarization]
