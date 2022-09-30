/*
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.speech.v1.it;

import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.cloud.speech.v1.LongRunningRecognizeResponse;
import com.google.cloud.speech.v1.RecognitionAudio;
import com.google.cloud.speech.v1.RecognitionConfig;
import com.google.cloud.speech.v1.RecognizeResponse;
import com.google.cloud.speech.v1.SpeechClient;
import com.google.cloud.speech.v1.StreamingRecognitionConfig;
import com.google.cloud.speech.v1.StreamingRecognizeRequest;
import com.google.cloud.speech.v1.StreamingRecognizeResponse;
import com.google.common.truth.Truth;
import com.google.common.util.concurrent.SettableFuture;
import com.google.protobuf.ByteString;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class ITSpeechTest {
  private static SpeechClient speechClient;

  @Rule public Timeout globalTimeout = Timeout.seconds(300);

  @BeforeClass
  public static void setupClass() throws Exception {
    speechClient = SpeechClient.create();
  }

  @AfterClass
  public static void tearDownClass() throws Exception {
    speechClient.close();
  }

  @Test
  public void syncRecognize() {
    RecognizeResponse response = speechClient.recognize(config(2), audio());

    Truth.assertThat(response.getResultsCount()).isGreaterThan(0);
    Truth.assertThat(response.getResults(0).getAlternativesCount()).isGreaterThan(0);
    String text = response.getResults(0).getAlternatives(0).getTranscript();
    Truth.assertThat(text).isEqualTo("hello");
  }

  @Test
  public void longrunningRecognize() throws Exception {
    LongRunningRecognizeResponse response =
        speechClient.longRunningRecognizeAsync(config(2), audio()).get();

    Truth.assertThat(response.getResultsCount()).isGreaterThan(0);
    Truth.assertThat(response.getResults(0).getAlternativesCount()).isGreaterThan(0);
    String text = response.getResults(0).getAlternatives(0).getTranscript();
    Truth.assertThat(text).isEqualTo("hello");
  }

  @Test
  public void streamingRecognize() throws Exception {
    byte[] audioBytes =
        ByteString.readFrom(getClass().getClassLoader().getResourceAsStream("hello.flac"))
            .toByteArray();

    StreamingRecognitionConfig streamingConfig =
        StreamingRecognitionConfig.newBuilder().setConfig(config(1)).build();

    ResponseApiStreamingObserver<StreamingRecognizeResponse> responseObserver =
        new ResponseApiStreamingObserver<>();

    ApiStreamObserver<StreamingRecognizeRequest> requestObserver =
        speechClient.streamingRecognizeCallable().bidiStreamingCall(responseObserver);

    // The first request must **only** contain the audio configuration:
    requestObserver.onNext(
        StreamingRecognizeRequest.newBuilder().setStreamingConfig(streamingConfig).build());

    // Subsequent requests must **only** contain the audio data.
    requestObserver.onNext(
        StreamingRecognizeRequest.newBuilder()
            .setAudioContent(ByteString.copyFrom(audioBytes))
            .build());

    // Mark transmission as completed after sending the data.
    requestObserver.onCompleted();

    List<StreamingRecognizeResponse> responses = responseObserver.future().get();

    Truth.assertThat(responses.size()).isGreaterThan(0);
    Truth.assertThat(responses.get(0).getResultsCount()).isGreaterThan(0);
    Truth.assertThat(responses.get(0).getResults(0).getAlternativesCount()).isGreaterThan(0);
    String text = responses.get(0).getResults(0).getAlternatives(0).getTranscript();
    Truth.assertThat(text).isEqualTo("hello");
  }

  private static class ResponseApiStreamingObserver<T> implements ApiStreamObserver<T> {
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

  private RecognitionConfig config(int channels) {
    String languageCode = "en-US";
    int sampleRateHertz = 44100;
    RecognitionConfig.AudioEncoding encoding = RecognitionConfig.AudioEncoding.FLAC;
    RecognitionConfig config =
        RecognitionConfig.newBuilder()
            .setLanguageCode(languageCode)
            .setSampleRateHertz(sampleRateHertz)
            .setEncoding(encoding)
            .setAudioChannelCount(channels)
            .build();
    return config;
  }

  public RecognitionAudio audio() {
    String audio_gcs_uri = System.getenv("AUDIO_GCS_URI");
    if (audio_gcs_uri != null) {
      return RecognitionAudio.newBuilder().setUri(audio_gcs_uri).build();
    }
    return RecognitionAudio.newBuilder()
        .setUri("gs://cloud-samples-data/speech/hello.flac")
        .build();
  }
}
