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

// [START media_translation_translate_from_file]

import com.google.api.gax.rpc.BidiStream;
import com.google.cloud.mediatranslation.v1beta1.SpeechTranslationServiceClient;
import com.google.cloud.mediatranslation.v1beta1.StreamingTranslateSpeechConfig;
import com.google.cloud.mediatranslation.v1beta1.StreamingTranslateSpeechRequest;
import com.google.cloud.mediatranslation.v1beta1.StreamingTranslateSpeechResponse;
import com.google.cloud.mediatranslation.v1beta1.StreamingTranslateSpeechResult;
import com.google.cloud.mediatranslation.v1beta1.TranslateSpeechConfig;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TranslateFromFile {

  public static void translateFromFile() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String filePath = "path/to/audio.raw";
    translateFromFile(filePath);
  }

  public static void translateFromFile(String filePath) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (SpeechTranslationServiceClient client = SpeechTranslationServiceClient.create()) {
      Path path = Paths.get(filePath);
      byte[] content = Files.readAllBytes(path);
      ByteString audioContent = ByteString.copyFrom(content);

      TranslateSpeechConfig audioConfig =
          TranslateSpeechConfig.newBuilder()
              .setAudioEncoding("linear16")
              .setSampleRateHertz(16000)
              .setSourceLanguageCode("en-US")
              .setTargetLanguageCode("fr-FR")
              .build();

      StreamingTranslateSpeechConfig config =
          StreamingTranslateSpeechConfig.newBuilder()
              .setAudioConfig(audioConfig)
              .setSingleUtterance(true)
              .build();

      BidiStream<StreamingTranslateSpeechRequest, StreamingTranslateSpeechResponse> bidiStream =
          client.streamingTranslateSpeechCallable().call();

      // The first request contains the configuration.
      StreamingTranslateSpeechRequest requestConfig =
          StreamingTranslateSpeechRequest.newBuilder().setStreamingConfig(config).build();

      // The second request contains the audio
      StreamingTranslateSpeechRequest request =
          StreamingTranslateSpeechRequest.newBuilder().setAudioContent(audioContent).build();

      bidiStream.send(requestConfig);
      bidiStream.send(request);

      for (StreamingTranslateSpeechResponse response : bidiStream) {
        // Once the transcription settles, the response contains the
        // is_final result. The other results will be for subsequent portions of
        // the audio.
        StreamingTranslateSpeechResult res = response.getResult();
        String translation = res.getTextTranslationResult().getTranslation();
        String source = res.getRecognitionResult();

        if (res.getTextTranslationResult().getIsFinal()) {
          System.out.println(String.format("\nFinal translation: %s", translation));
          System.out.println(String.format("Final recognition result: %s", source));
          break;
        }
        System.out.println(String.format("\nPartial translation: %s", translation));
        System.out.println(String.format("Partial recognition result: %s", source));
      }
    }
  }
}
// [END media_translation_translate_from_file]
