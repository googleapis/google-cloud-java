/*
  Copyright 2017, Google Inc.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/

package com.example.speech;

import com.google.api.gax.grpc.OperationFuture;
import com.google.cloud.speech.spi.v1beta1.SpeechClient;
import com.google.cloud.speech.v1beta1.AsyncRecognizeResponse;
import com.google.cloud.speech.v1beta1.RecognitionAudio;
import com.google.cloud.speech.v1beta1.RecognitionConfig;
import com.google.cloud.speech.v1beta1.RecognitionConfig.AudioEncoding;
import com.google.cloud.speech.v1beta1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1beta1.SpeechRecognitionResult;
import com.google.cloud.speech.v1beta1.SyncRecognizeResponse;
import com.google.protobuf.ByteString;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Recognize {
  public static void main(String... args) throws Exception {
    if (args.length < 1) {
      System.out.println("Usage:");
      System.out.printf(
          "\tjava %s \"<command>\" \"<path-to-image>\"\n"
          + "Commands:\n"
          + "\tsyncrecognize | asyncrecognize\n"
          + "Path:\n\tA file path (ex: ./resources/audio.raw) or a URI "
          + "for a Cloud Storage resource (gs://...)\n",
          Recognize.class.getCanonicalName());
      return;
    }
    String command = args[0];
    String path = args.length > 1 ? args[1] : "";
    
    if (command.equals("syncrecognize")) {
      if (path.startsWith("gs://")) {
        syncRecognizeGcs(path);
      } else {
        syncRecognizeFile(path);
      }
    } else if (command.equals("asyncrecognize")) {
      if (path.startsWith("gs://")) {
        asyncRecognizeGcs(path);
      } else {
        asyncRecognizeFile(path);
      }
    }
    

  }

  public static void syncRecognizeFile(String fileName) throws Exception, IOException {
    SpeechClient speech = SpeechClient.create();

    Path path = Paths.get(fileName);
    byte[] data = Files.readAllBytes(path);
    ByteString audioBytes = ByteString.copyFrom(data);

    RecognitionConfig config = RecognitionConfig.newBuilder()
        .setEncoding(AudioEncoding.LINEAR16)
        .setSampleRate(16000)
        .build();
    RecognitionAudio audio = RecognitionAudio.newBuilder()
        .setContent(audioBytes)
        .build();

    SyncRecognizeResponse response = speech.syncRecognize(config, audio);
    List<SpeechRecognitionResult> results = response.getResultsList();

    for (SpeechRecognitionResult result: results) {
      List<SpeechRecognitionAlternative> alternatives = result.getAlternativesList();
      for (SpeechRecognitionAlternative alternative: alternatives) {
        System.out.printf("Transcription: %s%n", alternative.getTranscript());
      }
    }
    speech.close();
  }

  public static void syncRecognizeGcs(String gcsUri) throws Exception, IOException {
    // Instantiates a client
    SpeechClient speech = SpeechClient.create();

    // Builds the sync recognize request
    RecognitionConfig config = RecognitionConfig.newBuilder()
        .setEncoding(AudioEncoding.FLAC)
        .setSampleRate(16000)
        .build();
    RecognitionAudio audio = RecognitionAudio.newBuilder()
        .setUri(gcsUri)
        .build();

    // Performs speech recognition on the audio file
    SyncRecognizeResponse response = speech.syncRecognize(config, audio);
    List<SpeechRecognitionResult> results = response.getResultsList();

    for (SpeechRecognitionResult result: results) {
      List<SpeechRecognitionAlternative> alternatives = result.getAlternativesList();
      for (SpeechRecognitionAlternative alternative: alternatives) {
        System.out.printf("Transcription: %s%n", alternative.getTranscript());
      }
    }


    speech.close();
  }

  public static void asyncRecognizeFile(String fileName) throws Exception, IOException {
    SpeechClient speech = SpeechClient.create();

    Path path = Paths.get(fileName);
    byte[] data = Files.readAllBytes(path);
    ByteString audioBytes = ByteString.copyFrom(data);

    RecognitionConfig config = RecognitionConfig.newBuilder()
        .setEncoding(AudioEncoding.LINEAR16)
        .setSampleRate(16000)
        .build();
    RecognitionAudio audio = RecognitionAudio.newBuilder()
        .setContent(audioBytes)
        .build();

    OperationFuture<AsyncRecognizeResponse> response = speech.asyncRecognizeAsync(config, audio);

    while(!response.isDone()) {
      System.out.println("Waiting for response...");
      Thread.sleep(200);
    }

    List<SpeechRecognitionResult> results = response.get().getResultsList();

    for (SpeechRecognitionResult result: results) {
      List<SpeechRecognitionAlternative> alternatives = result.getAlternativesList();
      for (SpeechRecognitionAlternative alternative: alternatives) {
        System.out.printf("Transcription: %s%n", alternative.getTranscript());
      }
    }
    speech.close();
  }

  public static void asyncRecognizeGcs(String gcsUri) throws Exception, IOException {
    SpeechClient speech = SpeechClient.create();

    RecognitionConfig config = RecognitionConfig.newBuilder()
        .setEncoding(AudioEncoding.FLAC)
        .setSampleRate(16000)
        .build();
    RecognitionAudio audio = RecognitionAudio.newBuilder()
        .setUri(gcsUri)
        .build();

    OperationFuture<AsyncRecognizeResponse> response = speech.asyncRecognizeAsync(config, audio);

    while(!response.isDone()) {
      System.out.println("Waiting for response...");
      Thread.sleep(200);
    }

    List<SpeechRecognitionResult> results = response.get().getResultsList();

    for (SpeechRecognitionResult result: results) {
      List<SpeechRecognitionAlternative> alternatives = result.getAlternativesList();
      for (SpeechRecognitionAlternative alternative: alternatives) {
        System.out.printf("Transcription: %s%n", alternative.getTranscript());
      }
    }
    speech.close();
  }
}
