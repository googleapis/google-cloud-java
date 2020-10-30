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
package com.google.cloud.mediatranslation.v1beta1.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.api.gax.rpc.BidiStream;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.mediatranslation.v1beta1.SpeechTranslationServiceClient;
import com.google.cloud.mediatranslation.v1beta1.StreamingTranslateSpeechConfig;
import com.google.cloud.mediatranslation.v1beta1.StreamingTranslateSpeechRequest;
import com.google.cloud.mediatranslation.v1beta1.StreamingTranslateSpeechResponse;
import com.google.cloud.mediatranslation.v1beta1.TranslateSpeechConfig;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITSystemTest {

  private static SpeechTranslationServiceClient client;

  @BeforeClass
  public static void setUp() throws IOException {
    client = SpeechTranslationServiceClient.create();
  }

  @AfterClass
  public static void tearDown() {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void streamingTranslateSpeechTest()
      throws ExecutionException, InterruptedException, IOException {
    String filePath = "src/test/resources/audio.raw";

    Path path = Paths.get(filePath);
    byte[] content = Files.readAllBytes(path);
    ByteString audioContent = ByteString.copyFrom(content);

    TranslateSpeechConfig translateSpeechConfig =
        TranslateSpeechConfig.newBuilder()
            .setAudioEncoding("linear16")
            .setSourceLanguageCode("en")
            .setTargetLanguageCode("es")
            .build();
    StreamingTranslateSpeechConfig config =
        StreamingTranslateSpeechConfig.newBuilder()
            .setAudioConfig(translateSpeechConfig)
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
    Iterator<StreamingTranslateSpeechResponse> iterator = bidiStream.iterator();
    assertTrue(iterator.hasNext());
    assertTrue(iterator.next().hasResult());
  }

  @Test
  @SuppressWarnings("all")
  public void streamingTranslateSpeechExceptionTest() {
    BidiStream<StreamingTranslateSpeechRequest, StreamingTranslateSpeechResponse> bidiStream =
        client.streamingTranslateSpeechCallable().call();
    StreamingTranslateSpeechConfig config = StreamingTranslateSpeechConfig.newBuilder().build();
    StreamingTranslateSpeechRequest request =
        StreamingTranslateSpeechRequest.newBuilder().setStreamingConfig(config).build();
    try {
      bidiStream.send(request);
      bidiStream.iterator().hasNext();
      fail();
    } catch (InvalidArgumentException ex) {
      assertTrue(ex.getMessage().contains("Unsupported encoding"));
      assertEquals(StatusCode.Code.INVALID_ARGUMENT, ex.getStatusCode().getCode());
    }
  }
}
