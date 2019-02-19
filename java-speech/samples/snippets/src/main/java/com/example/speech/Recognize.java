/*
 * Copyright 2018 Google Inc.
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

import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientStream;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.StreamController;
import com.google.cloud.speech.v1.LongRunningRecognizeMetadata;
import com.google.cloud.speech.v1.LongRunningRecognizeResponse;
import com.google.cloud.speech.v1.RecognitionAudio;
import com.google.cloud.speech.v1.RecognitionConfig;
import com.google.cloud.speech.v1.RecognitionConfig.AudioEncoding;
import com.google.cloud.speech.v1.RecognizeResponse;
import com.google.cloud.speech.v1.SpeechClient;
import com.google.cloud.speech.v1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1.SpeechRecognitionResult;
import com.google.cloud.speech.v1.StreamingRecognitionConfig;
import com.google.cloud.speech.v1.StreamingRecognitionResult;
import com.google.cloud.speech.v1.StreamingRecognizeRequest;
import com.google.cloud.speech.v1.StreamingRecognizeResponse;
import com.google.cloud.speech.v1.WordInfo;
import com.google.common.util.concurrent.SettableFuture;
import com.google.protobuf.ByteString;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.TargetDataLine;

public class Recognize {

  /** Run speech recognition tasks. */
  public static void main(String... args) throws Exception {
    if (args.length < 1) {
      System.out.println("Usage:");
      System.out.printf(
          "\tjava %s \"<command>\" \"<path-to-image>\"\n"
              + "Commands:\n"
              + "\tsyncrecognize | asyncrecognize | streamrecognize | micstreamrecognize \n"
              + "\t| wordoffsets | auto-punctuation | stream-punctuation \n"
              + "\t| enhanced-model | model-selection | multi-channel\n"
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
    } else if (command.equals("wordoffsets")) {
      if (path.startsWith("gs://")) {
        asyncRecognizeWords(path);
      } else {
        syncRecognizeWords(path);
      }
    } else if (command.equals("asyncrecognize")) {
      if (path.startsWith("gs://")) {
        asyncRecognizeGcs(path);
      } else {
        asyncRecognizeFile(path);
      }
    } else if (command.equals("streamrecognize")) {
      streamingRecognizeFile(path);
    } else if (command.equals("micstreamrecognize")) {
      streamingMicRecognize();
    } else if (command.equals("auto-punctuation")) {
      if (path.startsWith("gs://")) {
        transcribeGcsWithAutomaticPunctuation(path);
      } else {
        transcribeFileWithAutomaticPunctuation(path);
      }
    } else if (command.equals("stream-punctuation")) {
      streamingTranscribeWithAutomaticPunctuation(path);
    } else if (command.equals("enhanced-model")) {
      transcribeFileWithEnhancedModel(path);
    } else if (command.equals("model-selection")) {
      if (path.startsWith("gs://")) {
        transcribeModelSelectionGcs(path);
      } else {
        transcribeModelSelection(path);
      }
    } else if (command.equals("multi-channel")) {
      if (path.startsWith("gs://")) {
        transcribeMultiChannelGcs(path);
      } else {
        transcribeMultiChannel(path);
      }
    }
  }

  // [START speech_transcribe_sync]
  /**
   * Performs speech recognition on raw PCM audio and prints the transcription.
   *
   * @param fileName the path to a PCM audio file to transcribe.
   */
  public static void syncRecognizeFile(String fileName) throws Exception {
    try (SpeechClient speech = SpeechClient.create()) {
      Path path = Paths.get(fileName);
      byte[] data = Files.readAllBytes(path);
      ByteString audioBytes = ByteString.copyFrom(data);

      // Configure request with local raw PCM audio
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEncoding(AudioEncoding.LINEAR16)
              .setLanguageCode("en-US")
              .setSampleRateHertz(16000)
              .build();
      RecognitionAudio audio = RecognitionAudio.newBuilder().setContent(audioBytes).build();

      // Use blocking call to get audio transcript
      RecognizeResponse response = speech.recognize(config, audio);
      List<SpeechRecognitionResult> results = response.getResultsList();

      for (SpeechRecognitionResult result : results) {
        // There can be several alternative transcripts for a given chunk of speech. Just use the
        // first (most likely) one here.
        SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
        System.out.printf("Transcription: %s%n", alternative.getTranscript());
      }
    }
  }
  // [END speech_transcribe_sync]

  /**
   * Performs sync recognize and prints word time offsets.
   *
   * @param fileName the path to a PCM audio file to transcribe get offsets on.
   */
  public static void syncRecognizeWords(String fileName) throws Exception {
    try (SpeechClient speech = SpeechClient.create()) {
      Path path = Paths.get(fileName);
      byte[] data = Files.readAllBytes(path);
      ByteString audioBytes = ByteString.copyFrom(data);

      // Configure request with local raw PCM audio
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEncoding(AudioEncoding.LINEAR16)
              .setLanguageCode("en-US")
              .setSampleRateHertz(16000)
              .setEnableWordTimeOffsets(true)
              .build();
      RecognitionAudio audio = RecognitionAudio.newBuilder().setContent(audioBytes).build();

      // Use blocking call to get audio transcript
      RecognizeResponse response = speech.recognize(config, audio);
      List<SpeechRecognitionResult> results = response.getResultsList();

      for (SpeechRecognitionResult result : results) {
        // There can be several alternative transcripts for a given chunk of speech. Just use the
        // first (most likely) one here.
        SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
        System.out.printf("Transcription: %s%n", alternative.getTranscript());
        for (WordInfo wordInfo : alternative.getWordsList()) {
          System.out.println(wordInfo.getWord());
          System.out.printf(
              "\t%s.%s sec - %s.%s sec\n",
              wordInfo.getStartTime().getSeconds(),
              wordInfo.getStartTime().getNanos() / 100000000,
              wordInfo.getEndTime().getSeconds(),
              wordInfo.getEndTime().getNanos() / 100000000);
        }
      }
    }
  }

  // [START speech_transcribe_sync_gcs]
  /**
   * Performs speech recognition on remote FLAC file and prints the transcription.
   *
   * @param gcsUri the path to the remote FLAC audio file to transcribe.
   */
  public static void syncRecognizeGcs(String gcsUri) throws Exception {
    // Instantiates a client with GOOGLE_APPLICATION_CREDENTIALS
    try (SpeechClient speech = SpeechClient.create()) {
      // Builds the request for remote FLAC file
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEncoding(AudioEncoding.FLAC)
              .setLanguageCode("en-US")
              .setSampleRateHertz(16000)
              .build();
      RecognitionAudio audio = RecognitionAudio.newBuilder().setUri(gcsUri).build();

      // Use blocking call for getting audio transcript
      RecognizeResponse response = speech.recognize(config, audio);
      List<SpeechRecognitionResult> results = response.getResultsList();

      for (SpeechRecognitionResult result : results) {
        // There can be several alternative transcripts for a given chunk of speech. Just use the
        // first (most likely) one here.
        SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
        System.out.printf("Transcription: %s%n", alternative.getTranscript());
      }
    }
  }
  // [END speech_transcribe_sync_gcs]

  // [START speech_transcribe_async]
  /**
   * Performs non-blocking speech recognition on raw PCM audio and prints the transcription. Note
   * that transcription is limited to 60 seconds audio.
   *
   * @param fileName the path to a PCM audio file to transcribe.
   */
  public static void asyncRecognizeFile(String fileName) throws Exception {
    // Instantiates a client with GOOGLE_APPLICATION_CREDENTIALS
    try (SpeechClient speech = SpeechClient.create()) {

      Path path = Paths.get(fileName);
      byte[] data = Files.readAllBytes(path);
      ByteString audioBytes = ByteString.copyFrom(data);

      // Configure request with local raw PCM audio
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEncoding(AudioEncoding.LINEAR16)
              .setLanguageCode("en-US")
              .setSampleRateHertz(16000)
              .build();
      RecognitionAudio audio = RecognitionAudio.newBuilder().setContent(audioBytes).build();

      // Use non-blocking call for getting file transcription
      OperationFuture<LongRunningRecognizeResponse, LongRunningRecognizeMetadata> response =
          speech.longRunningRecognizeAsync(config, audio);

      while (!response.isDone()) {
        System.out.println("Waiting for response...");
        Thread.sleep(10000);
      }

      List<SpeechRecognitionResult> results = response.get().getResultsList();

      for (SpeechRecognitionResult result : results) {
        // There can be several alternative transcripts for a given chunk of speech. Just use the
        // first (most likely) one here.
        SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
        System.out.printf("Transcription: %s%n", alternative.getTranscript());
      }
    }
  }
  // [END speech_transcribe_async]

  // [START speech_transcribe_async_word_time_offsets_gcs]
  /**
   * Performs non-blocking speech recognition on remote FLAC file and prints the transcription as
   * well as word time offsets.
   *
   * @param gcsUri the path to the remote LINEAR16 audio file to transcribe.
   */
  public static void asyncRecognizeWords(String gcsUri) throws Exception {
    // Instantiates a client with GOOGLE_APPLICATION_CREDENTIALS
    try (SpeechClient speech = SpeechClient.create()) {

      // Configure remote file request for Linear16
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEncoding(AudioEncoding.FLAC)
              .setLanguageCode("en-US")
              .setSampleRateHertz(16000)
              .setEnableWordTimeOffsets(true)
              .build();
      RecognitionAudio audio = RecognitionAudio.newBuilder().setUri(gcsUri).build();

      // Use non-blocking call for getting file transcription
      OperationFuture<LongRunningRecognizeResponse, LongRunningRecognizeMetadata> response =
          speech.longRunningRecognizeAsync(config, audio);
      while (!response.isDone()) {
        System.out.println("Waiting for response...");
        Thread.sleep(10000);
      }

      List<SpeechRecognitionResult> results = response.get().getResultsList();

      for (SpeechRecognitionResult result : results) {
        // There can be several alternative transcripts for a given chunk of speech. Just use the
        // first (most likely) one here.
        SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
        System.out.printf("Transcription: %s\n", alternative.getTranscript());
        for (WordInfo wordInfo : alternative.getWordsList()) {
          System.out.println(wordInfo.getWord());
          System.out.printf(
              "\t%s.%s sec - %s.%s sec\n",
              wordInfo.getStartTime().getSeconds(),
              wordInfo.getStartTime().getNanos() / 100000000,
              wordInfo.getEndTime().getSeconds(),
              wordInfo.getEndTime().getNanos() / 100000000);
        }
      }
    }
  }
  // [END speech_transcribe_async_word_time_offsets_gcs]

  // [START speech_transcribe_async_gcs]
  /**
   * Performs non-blocking speech recognition on remote FLAC file and prints the transcription.
   *
   * @param gcsUri the path to the remote LINEAR16 audio file to transcribe.
   */
  public static void asyncRecognizeGcs(String gcsUri) throws Exception {
    // Instantiates a client with GOOGLE_APPLICATION_CREDENTIALS
    try (SpeechClient speech = SpeechClient.create()) {

      // Configure remote file request for Linear16
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEncoding(AudioEncoding.FLAC)
              .setLanguageCode("en-US")
              .setSampleRateHertz(16000)
              .build();
      RecognitionAudio audio = RecognitionAudio.newBuilder().setUri(gcsUri).build();

      // Use non-blocking call for getting file transcription
      OperationFuture<LongRunningRecognizeResponse, LongRunningRecognizeMetadata> response =
          speech.longRunningRecognizeAsync(config, audio);
      while (!response.isDone()) {
        System.out.println("Waiting for response...");
        Thread.sleep(10000);
      }

      List<SpeechRecognitionResult> results = response.get().getResultsList();

      for (SpeechRecognitionResult result : results) {
        // There can be several alternative transcripts for a given chunk of speech. Just use the
        // first (most likely) one here.
        SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
        System.out.printf("Transcription: %s\n", alternative.getTranscript());
      }
    }
  }
  // [END speech_transcribe_async_gcs]

  // [START speech_transcribe_streaming]
  /**
   * Performs streaming speech recognition on raw PCM audio data.
   *
   * @param fileName the path to a PCM audio file to transcribe.
   */
  public static void streamingRecognizeFile(String fileName) throws Exception, IOException {
    Path path = Paths.get(fileName);
    byte[] data = Files.readAllBytes(path);

    // Instantiates a client with GOOGLE_APPLICATION_CREDENTIALS
    try (SpeechClient speech = SpeechClient.create()) {

      // Configure request with local raw PCM audio
      RecognitionConfig recConfig =
          RecognitionConfig.newBuilder()
              .setEncoding(AudioEncoding.LINEAR16)
              .setLanguageCode("en-US")
              .setSampleRateHertz(16000)
              .setModel("default")
              .build();
      StreamingRecognitionConfig config =
          StreamingRecognitionConfig.newBuilder().setConfig(recConfig).build();

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
          new ResponseApiStreamingObserver<>();

      BidiStreamingCallable<StreamingRecognizeRequest, StreamingRecognizeResponse> callable =
          speech.streamingRecognizeCallable();

      ApiStreamObserver<StreamingRecognizeRequest> requestObserver =
          callable.bidiStreamingCall(responseObserver);

      // The first request must **only** contain the audio configuration:
      requestObserver.onNext(
          StreamingRecognizeRequest.newBuilder().setStreamingConfig(config).build());

      // Subsequent requests must **only** contain the audio data.
      requestObserver.onNext(
          StreamingRecognizeRequest.newBuilder()
              .setAudioContent(ByteString.copyFrom(data))
              .build());

      // Mark transmission as completed after sending the data.
      requestObserver.onCompleted();

      List<StreamingRecognizeResponse> responses = responseObserver.future().get();

      for (StreamingRecognizeResponse response : responses) {
        // For streaming recognize, the results list has one is_final result (if available) followed
        // by a number of in-progress results (if iterim_results is true) for subsequent utterances.
        // Just print the first result here.
        StreamingRecognitionResult result = response.getResultsList().get(0);
        // There can be several alternative transcripts for a given chunk of speech. Just use the
        // first (most likely) one here.
        SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
        System.out.printf("Transcript : %s\n", alternative.getTranscript());
      }
    }
  }
  // [END speech_transcribe_streaming]

  // [START speech_sync_recognize_punctuation]
  /**
   * Performs transcription with automatic punctuation on raw PCM audio data.
   *
   * @param fileName the path to a PCM audio file to transcribe.
   */
  public static void transcribeFileWithAutomaticPunctuation(String fileName) throws Exception {
    Path path = Paths.get(fileName);
    byte[] content = Files.readAllBytes(path);

    try (SpeechClient speechClient = SpeechClient.create()) {
      // Configure request with local raw PCM audio
      RecognitionConfig recConfig =
          RecognitionConfig.newBuilder()
              .setEncoding(AudioEncoding.LINEAR16)
              .setLanguageCode("en-US")
              .setSampleRateHertz(16000)
              .setEnableAutomaticPunctuation(true)
              .build();

      // Get the contents of the local audio file
      RecognitionAudio recognitionAudio =
          RecognitionAudio.newBuilder().setContent(ByteString.copyFrom(content)).build();

      // Perform the transcription request
      RecognizeResponse recognizeResponse = speechClient.recognize(recConfig, recognitionAudio);

      // Just print the first result here.
      SpeechRecognitionResult result = recognizeResponse.getResultsList().get(0);

      // There can be several alternative transcripts for a given chunk of speech. Just use the
      // first (most likely) one here.
      SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);

      // Print out the result
      System.out.printf("Transcript : %s\n", alternative.getTranscript());
    }
  }
  // [END speech_sync_recognize_punctuation]

  // [START speech_transcribe_auto_punctuation]
  /**
   * Performs transcription on remote FLAC file and prints the transcription.
   *
   * @param gcsUri the path to the remote FLAC audio file to transcribe.
   */
  public static void transcribeGcsWithAutomaticPunctuation(String gcsUri) throws Exception {
    try (SpeechClient speechClient = SpeechClient.create()) {
      // Configure request with raw PCM audio
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEncoding(AudioEncoding.FLAC)
              .setLanguageCode("en-US")
              .setSampleRateHertz(16000)
              .setEnableAutomaticPunctuation(true)
              .build();

      // Set the remote path for the audio file
      RecognitionAudio audio = RecognitionAudio.newBuilder().setUri(gcsUri).build();

      // Use non-blocking call for getting file transcription
      OperationFuture<LongRunningRecognizeResponse, LongRunningRecognizeMetadata> response =
          speechClient.longRunningRecognizeAsync(config, audio);

      while (!response.isDone()) {
        System.out.println("Waiting for response...");
        Thread.sleep(10000);
      }

      // Just print the first result here.
      SpeechRecognitionResult result = response.get().getResultsList().get(0);

      // There can be several alternative transcripts for a given chunk of speech. Just use the
      // first (most likely) one here.
      SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);

      // Print out the result
      System.out.printf("Transcript : %s\n", alternative.getTranscript());
    }
  }
  // [END speech_transcribe_auto_punctuation]

  // [START speech_stream_recognize_punctuation]
  /**
   * Performs streaming speech recognition on raw PCM audio data.
   *
   * @param fileName the path to a PCM audio file to transcribe.
   */
  public static void streamingTranscribeWithAutomaticPunctuation(String fileName) throws Exception {
    Path path = Paths.get(fileName);
    byte[] data = Files.readAllBytes(path);

    // Instantiates a client with GOOGLE_APPLICATION_CREDENTIALS
    try (SpeechClient speech = SpeechClient.create()) {

      // Configure request with local raw PCM audio
      RecognitionConfig recConfig =
          RecognitionConfig.newBuilder()
              .setEncoding(AudioEncoding.LINEAR16)
              .setLanguageCode("en-US")
              .setSampleRateHertz(16000)
              .setEnableAutomaticPunctuation(true)
              .build();

      // Build the streaming config with the audio config
      StreamingRecognitionConfig config =
          StreamingRecognitionConfig.newBuilder().setConfig(recConfig).build();

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
          new ResponseApiStreamingObserver<>();

      BidiStreamingCallable<StreamingRecognizeRequest, StreamingRecognizeResponse> callable =
          speech.streamingRecognizeCallable();

      ApiStreamObserver<StreamingRecognizeRequest> requestObserver =
          callable.bidiStreamingCall(responseObserver);

      // The first request must **only** contain the audio configuration:
      requestObserver.onNext(
          StreamingRecognizeRequest.newBuilder().setStreamingConfig(config).build());

      // Subsequent requests must **only** contain the audio data.
      requestObserver.onNext(
          StreamingRecognizeRequest.newBuilder()
              .setAudioContent(ByteString.copyFrom(data))
              .build());

      // Mark transmission as completed after sending the data.
      requestObserver.onCompleted();

      List<StreamingRecognizeResponse> responses = responseObserver.future().get();

      for (StreamingRecognizeResponse response : responses) {
        // For streaming recognize, the results list has one is_final result (if available) followed
        // by a number of in-progress results (if iterim_results is true) for subsequent utterances.
        // Just print the first result here.
        StreamingRecognitionResult result = response.getResultsList().get(0);
        // There can be several alternative transcripts for a given chunk of speech. Just use the
        // first (most likely) one here.
        SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
        System.out.printf("Transcript : %s\n", alternative.getTranscript());
      }
    }
  }
  // [END speech_stream_recognize_punctuation]

  // [START speech_transcribe_streaming_mic]
  /** Performs microphone streaming speech recognition with a duration of 1 minute. */
  public static void streamingMicRecognize() throws Exception {

    ResponseObserver<StreamingRecognizeResponse> responseObserver = null;
    try (SpeechClient client = SpeechClient.create()) {

      responseObserver =
          new ResponseObserver<StreamingRecognizeResponse>() {
            ArrayList<StreamingRecognizeResponse> responses = new ArrayList<>();

            public void onStart(StreamController controller) {}

            public void onResponse(StreamingRecognizeResponse response) {
              responses.add(response);
            }

            public void onComplete() {
              for (StreamingRecognizeResponse response : responses) {
                StreamingRecognitionResult result = response.getResultsList().get(0);
                SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
                System.out.printf("Transcript : %s\n", alternative.getTranscript());
              }
            }

            public void onError(Throwable t) {
              System.out.println(t);
            }
          };

      ClientStream<StreamingRecognizeRequest> clientStream =
          client.streamingRecognizeCallable().splitCall(responseObserver);

      RecognitionConfig recognitionConfig =
          RecognitionConfig.newBuilder()
              .setEncoding(RecognitionConfig.AudioEncoding.LINEAR16)
              .setLanguageCode("en-US")
              .setSampleRateHertz(16000)
              .build();
      StreamingRecognitionConfig streamingRecognitionConfig =
          StreamingRecognitionConfig.newBuilder().setConfig(recognitionConfig).build();

      StreamingRecognizeRequest request =
          StreamingRecognizeRequest.newBuilder()
              .setStreamingConfig(streamingRecognitionConfig)
              .build(); // The first request in a streaming call has to be a config

      clientStream.send(request);
      // SampleRate:16000Hz, SampleSizeInBits: 16, Number of channels: 1, Signed: true,
      // bigEndian: false
      AudioFormat audioFormat = new AudioFormat(16000, 16, 1, true, false);
      DataLine.Info targetInfo =
          new Info(
              TargetDataLine.class,
              audioFormat); // Set the system information to read from the microphone audio stream

      if (!AudioSystem.isLineSupported(targetInfo)) {
        System.out.println("Microphone not supported");
        System.exit(0);
      }
      // Target data line captures the audio stream the microphone produces.
      TargetDataLine targetDataLine = (TargetDataLine) AudioSystem.getLine(targetInfo);
      targetDataLine.open(audioFormat);
      targetDataLine.start();
      System.out.println("Start speaking");
      long startTime = System.currentTimeMillis();
      // Audio Input Stream
      AudioInputStream audio = new AudioInputStream(targetDataLine);
      while (true) {
        long estimatedTime = System.currentTimeMillis() - startTime;
        byte[] data = new byte[6400];
        audio.read(data);
        if (estimatedTime > 60000) { // 60 seconds
          System.out.println("Stop speaking.");
          targetDataLine.stop();
          targetDataLine.close();
          break;
        }
        request =
            StreamingRecognizeRequest.newBuilder()
                .setAudioContent(ByteString.copyFrom(data))
                .build();
        clientStream.send(request);
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    responseObserver.onComplete();
  }
  // [END speech_transcribe_streaming_mic]

  // [START speech_transcribe_enhanced_model]
  /**
   * Transcribe the given audio file using an enhanced model.
   *
   * @param fileName the path to an audio file.
   */
  public static void transcribeFileWithEnhancedModel(String fileName) throws Exception {
    Path path = Paths.get(fileName);
    byte[] content = Files.readAllBytes(path);

    try (SpeechClient speechClient = SpeechClient.create()) {
      // Get the contents of the local audio file
      RecognitionAudio recognitionAudio =
          RecognitionAudio.newBuilder().setContent(ByteString.copyFrom(content)).build();

      // Configure request to enable enhanced models
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEncoding(AudioEncoding.LINEAR16)
              .setLanguageCode("en-US")
              .setSampleRateHertz(8000)
              // Enhanced models are only available to projects that
              // opt in for audio data collection.
              .setUseEnhanced(true)
              // A model must be specified to use enhanced model.
              .setModel("phone_call")
              .build();

      // Perform the transcription request
      RecognizeResponse recognizeResponse = speechClient.recognize(config, recognitionAudio);

      // Print out the results
      for (SpeechRecognitionResult result : recognizeResponse.getResultsList()) {
        // There can be several alternative transcripts for a given chunk of speech. Just use the
        // first (most likely) one here.
        SpeechRecognitionAlternative alternative = result.getAlternatives(0);
        System.out.format("Transcript: %s\n\n", alternative.getTranscript());
      }
    }
  }
  // [END speech_transcribe_enhanced_model]

  // [START speech_transcribe_model_selection]
  /**
   * Performs transcription of the given audio file synchronously with the selected model.
   *
   * @param fileName the path to a audio file to transcribe
   */
  public static void transcribeModelSelection(String fileName) throws Exception {
    Path path = Paths.get(fileName);
    byte[] content = Files.readAllBytes(path);

    try (SpeechClient speech = SpeechClient.create()) {
      // Configure request with video media type
      RecognitionConfig recConfig =
          RecognitionConfig.newBuilder()
              // encoding may either be omitted or must match the value in the file header
              .setEncoding(AudioEncoding.LINEAR16)
              .setLanguageCode("en-US")
              // sample rate hertz may be either be omitted or must match the value in the file
              // header
              .setSampleRateHertz(16000)
              .setModel("video")
              .build();

      RecognitionAudio recognitionAudio =
          RecognitionAudio.newBuilder().setContent(ByteString.copyFrom(content)).build();

      RecognizeResponse recognizeResponse = speech.recognize(recConfig, recognitionAudio);
      // Just print the first result here.
      SpeechRecognitionResult result = recognizeResponse.getResultsList().get(0);
      // There can be several alternative transcripts for a given chunk of speech. Just use the
      // first (most likely) one here.
      SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
      System.out.printf("Transcript : %s\n", alternative.getTranscript());
    }
  }
  // [END speech_transcribe_model_selection]

  // [START speech_transcribe_model_selection_gcs]
  /**
   * Performs transcription of the remote audio file asynchronously with the selected model.
   *
   * @param gcsUri the path to the remote audio file to transcribe.
   */
  public static void transcribeModelSelectionGcs(String gcsUri) throws Exception {
    try (SpeechClient speech = SpeechClient.create()) {

      // Configure request with video media type
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              // encoding may either be omitted or must match the value in the file header
              .setEncoding(AudioEncoding.LINEAR16)
              .setLanguageCode("en-US")
              // sample rate hertz may be either be omitted or must match the value in the file
              // header
              .setSampleRateHertz(16000)
              .setModel("video")
              .build();

      RecognitionAudio audio = RecognitionAudio.newBuilder().setUri(gcsUri).build();

      // Use non-blocking call for getting file transcription
      OperationFuture<LongRunningRecognizeResponse, LongRunningRecognizeMetadata> response =
          speech.longRunningRecognizeAsync(config, audio);

      while (!response.isDone()) {
        System.out.println("Waiting for response...");
        Thread.sleep(10000);
      }

      List<SpeechRecognitionResult> results = response.get().getResultsList();

      // Just print the first result here.
      SpeechRecognitionResult result = results.get(0);
      // There can be several alternative transcripts for a given chunk of speech. Just use the
      // first (most likely) one here.
      SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
      System.out.printf("Transcript : %s\n", alternative.getTranscript());
    }
  }
  // [END speech_transcribe_model_selection_gcs]

  // [START speech_transcribe_multichannel]
  /**
   * Transcribe a local audio file with multi-channel recognition
   *
   * @param fileName the path to local audio file
   */
  public static void transcribeMultiChannel(String fileName) throws Exception {
    Path path = Paths.get(fileName);
    byte[] content = Files.readAllBytes(path);

    try (SpeechClient speechClient = SpeechClient.create()) {
      // Get the contents of the local audio file
      RecognitionAudio recognitionAudio =
          RecognitionAudio.newBuilder().setContent(ByteString.copyFrom(content)).build();

      // Configure request to enable multiple channels
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEncoding(AudioEncoding.LINEAR16)
              .setLanguageCode("en-US")
              .setSampleRateHertz(44100)
              .setAudioChannelCount(2)
              .setEnableSeparateRecognitionPerChannel(true)
              .build();

      // Perform the transcription request
      RecognizeResponse recognizeResponse = speechClient.recognize(config, recognitionAudio);

      // Print out the results
      for (SpeechRecognitionResult result : recognizeResponse.getResultsList()) {
        // There can be several alternative transcripts for a given chunk of speech. Just use the
        // first (most likely) one here.
        SpeechRecognitionAlternative alternative = result.getAlternatives(0);
        System.out.format("Transcript : %s\n", alternative.getTranscript());
        System.out.printf("Channel Tag : %s\n", result.getChannelTag());
      }
    }
  }
  // [END speech_transcribe_multichannel]

  // [START speech_transcribe_multichannel_gcs]
  /**
   * Transcribe a remote audio file with multi-channel recognition
   *
   * @param gcsUri the path to the audio file
   */
  public static void transcribeMultiChannelGcs(String gcsUri) throws Exception {

    try (SpeechClient speechClient = SpeechClient.create()) {

      // Configure request to enable multiple channels
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEncoding(AudioEncoding.LINEAR16)
              .setLanguageCode("en-US")
              .setSampleRateHertz(44100)
              .setAudioChannelCount(2)
              .setEnableSeparateRecognitionPerChannel(true)
              .build();

      // Set the remote path for the audio file
      RecognitionAudio audio = RecognitionAudio.newBuilder().setUri(gcsUri).build();

      // Use non-blocking call for getting file transcription
      OperationFuture<LongRunningRecognizeResponse, LongRunningRecognizeMetadata> response =
          speechClient.longRunningRecognizeAsync(config, audio);

      while (!response.isDone()) {
        System.out.println("Waiting for response...");
        Thread.sleep(10000);
      }
      // Just print the first result here.
      for (SpeechRecognitionResult result : response.get().getResultsList()) {

        // There can be several alternative transcripts for a given chunk of speech. Just use the
        // first (most likely) one here.
        SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);

        // Print out the result
        System.out.printf("Transcript : %s\n", alternative.getTranscript());
        System.out.printf("Channel Tag : %s\n", result.getChannelTag());
      }
    }
  }
  // [END speech_transcribe_multichannel_gcs]
}
