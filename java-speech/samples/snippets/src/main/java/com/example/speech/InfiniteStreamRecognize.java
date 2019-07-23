/*
 * Copyright 2018 Google LLC
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

// [START speech_transcribe_infinite_streaming]

import com.google.api.gax.rpc.ClientStream;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.StreamController;
import com.google.cloud.speech.v1p1beta1.RecognitionConfig;
import com.google.cloud.speech.v1p1beta1.SpeechClient;
import com.google.cloud.speech.v1p1beta1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1p1beta1.StreamingRecognitionConfig;
import com.google.cloud.speech.v1p1beta1.StreamingRecognitionResult;
import com.google.cloud.speech.v1p1beta1.StreamingRecognizeRequest;
import com.google.cloud.speech.v1p1beta1.StreamingRecognizeResponse;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;

import java.lang.Math;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.TargetDataLine;

public class InfiniteStreamRecognize {

  private static final int STREAMING_LIMIT = 290000; // ~5 minutes

  public static final String RED = "\033[0;31m";
  public static final String GREEN = "\033[0;32m";
  public static final String YELLOW = "\033[0;33m";

  // Creating shared object
  private static volatile BlockingQueue<byte[]> sharedQueue = new LinkedBlockingQueue();
  private static TargetDataLine targetDataLine;
  private static int BYTES_PER_BUFFER = 6400; // buffer size in bytes

  private static int restartCounter = 0;
  private static ArrayList<ByteString> audioInput = new ArrayList<ByteString>();
  private static ArrayList<ByteString> lastAudioInput = new ArrayList<ByteString>();
  private static int resultEndTimeInMS = 0;
  private static int isFinalEndTime = 0;
  private static int finalRequestEndTime = 0;
  private static boolean newStream = true;
  private static double bridgingOffset = 0;
  private static boolean lastTranscriptWasFinal = false;
  private static StreamController referenceToStreamController;
  private static ByteString tempByteString;

  public static void main(String... args) {
    InfiniteStreamRecognizeOptions options = InfiniteStreamRecognizeOptions.fromFlags(args);
    if (options == null) {
      // Could not parse.
      System.out.println("Failed to parse options.");
      System.exit(1);
    }

    try {
      infiniteStreamingRecognize(options.langCode);
    } catch (Exception e) {
      System.out.println("Exception caught: " + e);
    }
  }

  public static String convertMillisToDate(double milliSeconds) {
    long millis = (long) milliSeconds;
    DecimalFormat format = new DecimalFormat();
    format.setMinimumIntegerDigits(2);
    return String.format("%s:%s /",
            format.format(TimeUnit.MILLISECONDS.toMinutes(millis)),
            format.format(TimeUnit.MILLISECONDS.toSeconds(millis)
                    - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)))
    );
  }

  /** Performs infinite streaming speech recognition */
  public static void infiniteStreamingRecognize(String languageCode) throws Exception {

    // Microphone Input buffering
    class MicBuffer implements Runnable {

      @Override
      public void run() {
        System.out.println(YELLOW);
        System.out.println("Start speaking...Press Ctrl-C to stop");
        targetDataLine.start();
        byte[] data = new byte[BYTES_PER_BUFFER];
        while (targetDataLine.isOpen()) {
          try {
            int numBytesRead = targetDataLine.read(data, 0, data.length);
            if ((numBytesRead <= 0) && (targetDataLine.isOpen())) {
              continue;
            }
            sharedQueue.put(data.clone());
          } catch (InterruptedException e) {
            System.out.println("Microphone input buffering interrupted : " + e.getMessage());
          }
        }
      }
    }

    // Creating microphone input buffer thread
    MicBuffer micrunnable = new MicBuffer();
    Thread micThread = new Thread(micrunnable);
    ResponseObserver<StreamingRecognizeResponse> responseObserver = null;
    try (SpeechClient client = SpeechClient.create()) {
      ClientStream<StreamingRecognizeRequest> clientStream;
      responseObserver =
          new ResponseObserver<StreamingRecognizeResponse>() {

            ArrayList<StreamingRecognizeResponse> responses = new ArrayList<>();

            public void onStart(StreamController controller) {
              referenceToStreamController = controller;
            }

            public void onResponse(StreamingRecognizeResponse response) {
              responses.add(response);
              StreamingRecognitionResult result = response.getResultsList().get(0);
              Duration resultEndTime = result.getResultEndTime();
              resultEndTimeInMS = (int) ((resultEndTime.getSeconds() * 1000)
                      + (resultEndTime.getNanos() / 1000000));
              double correctedTime = resultEndTimeInMS - bridgingOffset
                      + (STREAMING_LIMIT * restartCounter);

              SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
              if (result.getIsFinal()) {
                System.out.print(GREEN);
                System.out.print("\033[2K\r");
                System.out.printf("%s: %s [confidence: %.2f]\n",
                        convertMillisToDate(correctedTime),
                        alternative.getTranscript(),
                        alternative.getConfidence()
                );
                isFinalEndTime = resultEndTimeInMS;
                lastTranscriptWasFinal = true;
              } else {
                System.out.print(RED);
                System.out.print("\033[2K\r");
                System.out.printf("%s: %s", convertMillisToDate(correctedTime),
                        alternative.getTranscript()
                );
                lastTranscriptWasFinal = false;
              }
            }

            public void onComplete() {
            }

            public void onError(Throwable t) {
            }
          };
      clientStream = client.streamingRecognizeCallable().splitCall(responseObserver);

      RecognitionConfig recognitionConfig =
          RecognitionConfig.newBuilder()
              .setEncoding(RecognitionConfig.AudioEncoding.LINEAR16)
              .setLanguageCode(languageCode)
              .setSampleRateHertz(16000)
              .build();

      StreamingRecognitionConfig streamingRecognitionConfig =
          StreamingRecognitionConfig.newBuilder()
              .setConfig(recognitionConfig)
              .setInterimResults(true)
              .build();

      StreamingRecognizeRequest request =
          StreamingRecognizeRequest.newBuilder()
              .setStreamingConfig(streamingRecognitionConfig)
              .build(); // The first request in a streaming call has to be a config

      clientStream.send(request);

      try {
        // SampleRate:16000Hz, SampleSizeInBits: 16, Number of channels: 1, Signed: true,
        // bigEndian: false
        AudioFormat audioFormat = new AudioFormat(16000, 16, 1, true, false);
        DataLine.Info targetInfo =
            new Info(
                TargetDataLine.class,
                audioFormat); // Set the system information to read from the microphone audio
        // stream

        if (!AudioSystem.isLineSupported(targetInfo)) {
          System.out.println("Microphone not supported");
          System.exit(0);
        }
        // Target data line captures the audio stream the microphone produces.
        targetDataLine = (TargetDataLine) AudioSystem.getLine(targetInfo);
        targetDataLine.open(audioFormat);
        micThread.start();

        long startTime = System.currentTimeMillis();

        while (true) {

          long estimatedTime = System.currentTimeMillis() - startTime;

          if (estimatedTime >= STREAMING_LIMIT) {

            clientStream.closeSend();
            referenceToStreamController.cancel(); // remove Observer

            if (resultEndTimeInMS > 0) {
              finalRequestEndTime = isFinalEndTime;
            }
            resultEndTimeInMS = 0;

            lastAudioInput = null;
            lastAudioInput = audioInput;
            audioInput = new ArrayList<ByteString>();

            restartCounter++;

            if (!lastTranscriptWasFinal) {
              System.out.print('\n');
            }

            newStream = true;

            clientStream = client.streamingRecognizeCallable().splitCall(responseObserver);

            request =
                StreamingRecognizeRequest.newBuilder()
                      .setStreamingConfig(streamingRecognitionConfig)
                      .build();

            System.out.println(YELLOW);
            System.out.printf("%d: RESTARTING REQUEST\n", restartCounter * STREAMING_LIMIT);

            startTime = System.currentTimeMillis();

          } else {

            if ((newStream) && (lastAudioInput.size() > 0)) {
              // if this is the first audio from a new request
              // calculate amount of unfinalized audio from last request
              // resend the audio to the speech client before incoming audio
              double chunkTime = STREAMING_LIMIT / lastAudioInput.size();
              // ms length of each chunk in previous request audio arrayList
              if (chunkTime != 0) {
                if (bridgingOffset < 0) {
                  // bridging Offset accounts for time of resent audio
                  // calculated from last request
                  bridgingOffset = 0;
                }
                if (bridgingOffset > finalRequestEndTime) {
                  bridgingOffset = finalRequestEndTime;
                }
                int chunksFromMS = (int) Math.floor((finalRequestEndTime
                        - bridgingOffset) / chunkTime);
                // chunks from MS is number of chunks to resend
                bridgingOffset = (int) Math.floor((lastAudioInput.size()
                        - chunksFromMS) * chunkTime);
                // set bridging offset for next request
                for (int i = chunksFromMS; i < lastAudioInput.size(); i++) {
                  request =
                      StreamingRecognizeRequest.newBuilder()
                          .setAudioContent(lastAudioInput.get(i))
                          .build();
                  clientStream.send(request);
                }
              }
              newStream = false;
            }

            tempByteString = ByteString.copyFrom(sharedQueue.take());

            request =
                StreamingRecognizeRequest.newBuilder()
                    .setAudioContent(tempByteString)
                    .build();

            audioInput.add(tempByteString);

          }

          clientStream.send(request);
        }
      } catch (Exception e) {
        System.out.println(e);
      }
    }
  }

}
// [END speech_transcribe_infinite_streaming]
