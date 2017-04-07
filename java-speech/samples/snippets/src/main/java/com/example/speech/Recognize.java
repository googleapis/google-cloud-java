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

import com.google.api.gax.core.ApiStreamObserver;
import com.google.api.gax.grpc.OperationFuture;
import com.google.api.gax.grpc.StreamingCallable;
import com.google.cloud.speech.spi.v1.SpeechClient;
import com.google.cloud.speech.v1.LongRunningRecognizeResponse;
import com.google.cloud.speech.v1.RecognitionAudio;
import com.google.cloud.speech.v1.RecognitionConfig;
import com.google.cloud.speech.v1.RecognitionConfig.AudioEncoding;
import com.google.cloud.speech.v1.RecognizeResponse;
import com.google.cloud.speech.v1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1.SpeechRecognitionResult;
import com.google.cloud.speech.v1.StreamingRecognitionConfig;
import com.google.cloud.speech.v1.StreamingRecognitionResult;
import com.google.cloud.speech.v1.StreamingRecognizeRequest;
import com.google.cloud.speech.v1.StreamingRecognizeResponse;
import com.google.common.util.concurrent.SettableFuture;
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
          + "\tsyncrecognize | asyncrecognize | streamrecognize\n"
          + "Path:\n\tA file path (ex: ./resources/audio.raw) or a URI "
          + "for a Cloud Storage resource (gs://...)\n",
          Recognize.class.getCanonicalName());
      return;
    }
    String command = args[0];
    String path = args.length > 1 ? args[1] : "";

    // Use command and GCS path pattern to invoke transcription.
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
    } else if (command.equals("streamrecognize")) {
      streamingRecognizeFile(path);
      //streamingRecognizeEasy(path);
    }

  }

  /**
   * Performs speech recognition on raw PCM audio and prints the transcription.
   *
   * @param fileName the path to a PCM audio file to transcribe.
   */
  public static void syncRecognizeFile(String fileName) throws Exception, IOException {
    SpeechClient speech = SpeechClient.create();

    Path path = Paths.get(fileName);
    byte[] data = Files.readAllBytes(path);
    ByteString audioBytes = ByteString.copyFrom(data);

    // Configure request with local raw PCM audio
    RecognitionConfig config = RecognitionConfig.newBuilder()
        .setEncoding(AudioEncoding.LINEAR16)
        .setLanguageCode("en-US")
        .setSampleRateHertz(16000)
        .build();
    RecognitionAudio audio = RecognitionAudio.newBuilder()
        .setContent(audioBytes)
        .build();

    // Use blocking call to get audio transcript
    RecognizeResponse response = speech.recognize(config, audio);
    List<SpeechRecognitionResult> results = response.getResultsList();

    for (SpeechRecognitionResult result: results) {
      List<SpeechRecognitionAlternative> alternatives = result.getAlternativesList();
      for (SpeechRecognitionAlternative alternative: alternatives) {
        System.out.printf("Transcription: %s%n", alternative.getTranscript());
      }
    }
    speech.close();
  }

  /**
   * Performs speech recognition on remote FLAC file and prints the transcription.
   *
   * @param gcsUri the path to the remote FLAC audio file to transcribe.
   */
  public static void syncRecognizeGcs(String gcsUri) throws Exception, IOException {
    // Instantiates a client with GOOGLE_APPLICATION_CREDENTIALS
    SpeechClient speech = SpeechClient.create();

    // Builds the request for remote FLAC file
    RecognitionConfig config = RecognitionConfig.newBuilder()
        .setEncoding(AudioEncoding.FLAC)
        .setLanguageCode("en-US")
        .setSampleRateHertz(16000)
        .build();
    RecognitionAudio audio = RecognitionAudio.newBuilder()
        .setUri(gcsUri)
        .build();

    // Use blocking call for getting audio transcript
    RecognizeResponse response = speech.recognize(config, audio);
    List<SpeechRecognitionResult> results = response.getResultsList();

    for (SpeechRecognitionResult result: results) {
      List<SpeechRecognitionAlternative> alternatives = result.getAlternativesList();
      for (SpeechRecognitionAlternative alternative: alternatives) {
        System.out.printf("Transcription: %s%n", alternative.getTranscript());
      }
    }
    speech.close();
  }

  /*
  /**
   * Performs non-blocking speech recognition on raw PCM audio and prints
   * the transcription.
   *
   * @param fileName the path to a PCM audio file to transcribe.
   */
  public static void asyncRecognizeFile(String fileName) throws Exception, IOException {
    // Instantiates a client with GOOGLE_APPLICATION_CREDENTIALS
    SpeechClient speech = SpeechClient.create();

    Path path = Paths.get(fileName);
    byte[] data = Files.readAllBytes(path);
    ByteString audioBytes = ByteString.copyFrom(data);

    // Configure request with local raw PCM audio
    RecognitionConfig config = RecognitionConfig.newBuilder()
        .setEncoding(AudioEncoding.LINEAR16)
        .setLanguageCode("en-US")
        .setSampleRateHertz(16000)
        .build();
    RecognitionAudio audio = RecognitionAudio.newBuilder()
        .setContent(audioBytes)
        .build();

    // Use non-blocking call for getting file transcription
    OperationFuture<LongRunningRecognizeResponse> response =
        speech.longRunningRecognizeAsync(config, audio);
    while (!response.isDone()) {
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

  /**
   * Performs non-blocking speech recognition on remote FLAC file and prints
   * the transcription.
   *
   * @param gcsUri the path to the remote LINEAR16 audio file to transcribe.
   */
  public static void asyncRecognizeGcs(String gcsUri) throws Exception, IOException {
    // Instantiates a client with GOOGLE_APPLICATION_CREDENTIALS
    SpeechClient speech = SpeechClient.create();

    // Configure remote file request for Linear16
    RecognitionConfig config = RecognitionConfig.newBuilder()
        .setEncoding(AudioEncoding.FLAC)
        .setLanguageCode("en-US")
        .setSampleRateHertz(16000)
        .build();
    RecognitionAudio audio = RecognitionAudio.newBuilder()
        .setUri(gcsUri)
        .build();

    // Use non-blocking call for getting file transcription
    OperationFuture<LongRunningRecognizeResponse> response =
        speech.longRunningRecognizeAsync(config, audio);
    while (!response.isDone()) {
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

  /**
   * Performs streaming speech recognition on raw PCM audio data.
   *
   * @param fileName the path to a PCM audio file to transcribe.
   */
  public static void streamingRecognizeFile(String fileName) throws Exception, IOException {
    Path path = Paths.get(fileName);
    byte[] data = Files.readAllBytes(path);

    // Instantiates a client with GOOGLE_APPLICATION_CREDENTIALS
    SpeechClient speech = SpeechClient.create();

    // Configure request with local raw PCM audio
    RecognitionConfig recConfig = RecognitionConfig.newBuilder()
        .setEncoding(AudioEncoding.LINEAR16)
        .setLanguageCode("en-US")
        .setSampleRateHertz(16000)
        .build();
    StreamingRecognitionConfig config = StreamingRecognitionConfig.newBuilder()
        .setConfig(recConfig)
        .build();

    class ResponseApiStreamingObserver<T> implements ApiStreamObserver<T> {
      private final SettableFuture<List<T>> future = SettableFuture.create();
      private final List<T> messages = new java.util.ArrayList<T>();

      @Override
      public void onNext(T message) {
        messages.add(message);
      }

      @Override
      public void onError(Throwable t) {
        future.setException(t);
      }

      @Override
      public void onCompleted() {
        future.set(messages);
      }

      // Returns the SettableFuture object to get received messages / exceptions.
      public SettableFuture<List<T>> future() {
        return future;
      }
    }

    ResponseApiStreamingObserver<StreamingRecognizeResponse> responseObserver =
        new ResponseApiStreamingObserver<StreamingRecognizeResponse>();

    StreamingCallable<StreamingRecognizeRequest,StreamingRecognizeResponse> callable =
        speech.streamingRecognizeCallable();

    ApiStreamObserver<StreamingRecognizeRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    // The first request must **only** contain the audio configuration:
    requestObserver.onNext(StreamingRecognizeRequest.newBuilder()
        .setStreamingConfig(config)
        .build());

    // Subsequent requests must **only** contain the audio data.
    requestObserver.onNext(StreamingRecognizeRequest.newBuilder()
        .setAudioContent(ByteString.copyFrom(data))
        .build());

    // Mark transmission as completed after sending the data.
    requestObserver.onCompleted();

    List<StreamingRecognizeResponse> responses = responseObserver.future().get();

    for (StreamingRecognizeResponse response: responses) {
      for (StreamingRecognitionResult result: response.getResultsList()) {
        for (SpeechRecognitionAlternative alternative : result.getAlternativesList()) {
          System.out.println(alternative.getTranscript());
        }
      }
    }
    speech.close();
  }

}
