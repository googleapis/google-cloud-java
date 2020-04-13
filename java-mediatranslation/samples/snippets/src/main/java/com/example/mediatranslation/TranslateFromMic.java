/*
 * Copyright 2020 Google LLC
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

package com.example.mediatranslation;

// [START media_translation_translate_from_mic]

import com.google.api.gax.rpc.ClientStream;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.StreamController;
import com.google.cloud.mediatranslation.v1beta1.SpeechTranslationServiceClient;
import com.google.cloud.mediatranslation.v1beta1.StreamingTranslateSpeechConfig;
import com.google.cloud.mediatranslation.v1beta1.StreamingTranslateSpeechRequest;
import com.google.cloud.mediatranslation.v1beta1.StreamingTranslateSpeechResponse;
import com.google.cloud.mediatranslation.v1beta1.StreamingTranslateSpeechResult;
import com.google.cloud.mediatranslation.v1beta1.TranslateSpeechConfig;
import com.google.protobuf.ByteString;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

public class TranslateFromMic {

  public static void main(String[] args) throws IOException, LineUnavailableException {
    translateFromMic();
  }

  public static void translateFromMic() throws IOException, LineUnavailableException {

    ResponseObserver<StreamingTranslateSpeechResponse> responseObserver = null;

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (SpeechTranslationServiceClient client = SpeechTranslationServiceClient.create()) {
      responseObserver =
          new ResponseObserver<StreamingTranslateSpeechResponse>() {

            @Override
            public void onStart(StreamController controller) {}

            @Override
            public void onResponse(StreamingTranslateSpeechResponse response) {
              StreamingTranslateSpeechResult res = response.getResult();
              String translation = res.getTextTranslationResult().getTranslation();
              String source = res.getRecognitionResult();

              if (res.getTextTranslationResult().getIsFinal()) {
                System.out.println(String.format("\nFinal translation: %s", translation));
                System.out.println(String.format("Final recognition result: %s", source));
              } else {
                System.out.println(String.format("\nPartial translation: %s", translation));
                System.out.println(String.format("Partial recognition result: %s", source));
              }
            }

            @Override
            public void onComplete() {}

            public void onError(Throwable t) {
              System.out.println(t);
            }
          };

      ClientStream<StreamingTranslateSpeechRequest> clientStream =
          client.streamingTranslateSpeechCallable().splitCall(responseObserver);

      TranslateSpeechConfig audioConfig =
          TranslateSpeechConfig.newBuilder()
              .setAudioEncoding("linear16")
              .setSourceLanguageCode("en-US")
              .setTargetLanguageCode("es-ES")
              .setSampleRateHertz(16000)
              .build();

      StreamingTranslateSpeechConfig streamingRecognitionConfig =
          StreamingTranslateSpeechConfig.newBuilder().setAudioConfig(audioConfig).build();

      StreamingTranslateSpeechRequest request =
          StreamingTranslateSpeechRequest.newBuilder()
              .setStreamingConfig(streamingRecognitionConfig)
              .build(); // The first request in a streaming call has to be a config

      clientStream.send(request);
      // SampleRate:16000Hz, SampleSizeInBits: 16, Number of channels: 1, Signed: true,
      // bigEndian: false
      AudioFormat audioFormat = new AudioFormat(16000, 16, 1, true, false);
      DataLine.Info targetInfo =
          new DataLine.Info(
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
      System.out.println("Start speaking... Press Ctrl-C to stop");
      long startTime = System.currentTimeMillis();
      // Audio Input Stream
      AudioInputStream audio = new AudioInputStream(targetDataLine);

      while (true) {
        byte[] data = new byte[6400];
        audio.read(data);
        request =
            StreamingTranslateSpeechRequest.newBuilder()
                .setAudioContent(ByteString.copyFrom(data))
                .build();
        clientStream.send(request);
      }
    }
  }
}
// [END media_translation_translate_from_mic]
