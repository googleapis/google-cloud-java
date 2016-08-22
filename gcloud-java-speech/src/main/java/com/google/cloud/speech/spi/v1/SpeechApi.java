/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.cloud.speech.spi.v1;

import com.google.api.gax.grpc.ApiCallable;
import com.google.api.gax.protobuf.PathTemplate;
import com.google.cloud.speech.v1.AudioRequest;
import com.google.cloud.speech.v1.InitialRecognizeRequest;
import com.google.cloud.speech.v1.NonStreamingRecognizeResponse;
import com.google.cloud.speech.v1.RecognizeRequest;
import io.grpc.ManagedChannel;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Service that implements Google Cloud Speech API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (SpeechApi speechApi = SpeechApi.create()) {
 *   InitialRecognizeRequest initialRequest = InitialRecognizeRequest.newBuilder().build();
 *   AudioRequest audioRequest = AudioRequest.newBuilder().build();
 *   NonStreamingRecognizeResponse response = speechApi.nonStreamingRecognize(initialRequest, audioRequest);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the speechApi object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's methods:
 *
 * <ol>
 * <li> A "flattened" method. With this type of method, the fields of the request type have been
 * converted into function parameters. It may be the case that not all fields are available
 * as parameters, and not every API method will have a flattened method entry point.
 * <li> A "request object" method. This type of method only takes one parameter, a request
 * object, which must be constructed before the call. Not every API method will have a request
 * object method.
 * <li> A "callable" method. This type of method takes no parameters and returns an immutable
 * ApiCallable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist
 * with these names, this class includes a format method for each type of name, and additionally
 * a parse method to extract the individual identifiers contained within names that are
 * returned.
 *
 * <p>This class can be customized by passing in a custom instance of SpeechSettings to
 * create(). For example:
 *
 * <pre>
 * <code>
 * SpeechSettings speechSettings = SpeechSettings.defaultBuilder()
 *     .provideChannelWith(myCredentials)
 *     .build();
 * SpeechApi speechApi = SpeechApi.create(speechSettings);
 * </code>
 * </pre>
 */
@javax.annotation.Generated("by GAPIC")
public class SpeechApi implements AutoCloseable {
  private final SpeechSettings settings;
  private final ManagedChannel channel;
  private final ScheduledExecutorService executor;
  private final List<AutoCloseable> closeables = new ArrayList<>();

  private final ApiCallable<RecognizeRequest, NonStreamingRecognizeResponse>
      nonStreamingRecognizeCallable;

  public final SpeechSettings getSettings() {
    return settings;
  }

  /**
   * Constructs an instance of SpeechApi with default settings.
   */
  public static final SpeechApi create() throws IOException {
    return create(SpeechSettings.defaultBuilder().build());
  }

  /**
   * Constructs an instance of SpeechApi, using the given settings.
   * The channels are created based on the settings passed in, or defaults for any
   * settings that are not set.
   */
  public static final SpeechApi create(SpeechSettings settings) throws IOException {
    return new SpeechApi(settings);
  }

  /**
   * Constructs an instance of SpeechApi, using the given settings.
   * This is protected so that it easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected SpeechApi(SpeechSettings settings) throws IOException {
    this.settings = settings;
    this.executor = settings.getExecutorProvider().getOrBuildExecutor();
    this.channel = settings.getChannelProvider().getOrBuildChannel(this.executor);

    this.nonStreamingRecognizeCallable =
        ApiCallable.create(settings.nonStreamingRecognizeSettings(), this.channel, this.executor);

    if (settings.getChannelProvider().shouldAutoClose()) {
      closeables.add(
          new Closeable() {
            @Override
            public void close() throws IOException {
              channel.shutdown();
            }
          });
    }
    if (settings.getExecutorProvider().shouldAutoClose()) {
      closeables.add(
          new Closeable() {
            @Override
            public void close() throws IOException {
              executor.shutdown();
            }
          });
    }
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Perform non-streaming speech-recognition: receive results after all audio
   * has been sent and processed.
   *
   * Sample code:
   * <pre><code>
   * try (SpeechApi speechApi = SpeechApi.create()) {
   *   InitialRecognizeRequest initialRequest = InitialRecognizeRequest.newBuilder().build();
   *   AudioRequest audioRequest = AudioRequest.newBuilder().build();
   *   NonStreamingRecognizeResponse response = speechApi.nonStreamingRecognize(initialRequest, audioRequest);
   * }
   * </code></pre>
   *
   * @param initialRequest The `initial_request` message provides information to the recognizer
   * that specifies how to process the request.
   *
   * The first `RecognizeRequest` message must contain an `initial_request`.
   * Any subsequent `RecognizeRequest` messages must not contain an
   * `initial_request`.
   * @param audioRequest The audio data to be recognized. For REST or `NonStreamingRecognize`, all
   * audio data must be contained in the first (and only) `RecognizeRequest`
   * message. For gRPC streaming `Recognize`, sequential chunks of audio data
   * are sent in sequential `RecognizeRequest` messages.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final NonStreamingRecognizeResponse nonStreamingRecognize(
      InitialRecognizeRequest initialRequest, AudioRequest audioRequest) {
    RecognizeRequest request =
        RecognizeRequest.newBuilder()
            .setInitialRequest(initialRequest)
            .setAudioRequest(audioRequest)
            .build();
    return nonStreamingRecognize(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Perform non-streaming speech-recognition: receive results after all audio
   * has been sent and processed.
   *
   * Sample code:
   * <pre><code>
   * try (SpeechApi speechApi = SpeechApi.create()) {
   *   InitialRecognizeRequest initialRequest = InitialRecognizeRequest.newBuilder().build();
   *   AudioRequest audioRequest = AudioRequest.newBuilder().build();
   *   RecognizeRequest request = RecognizeRequest.newBuilder()
   *     .setInitialRequest(initialRequest)
   *     .setAudioRequest(audioRequest)
   *     .build();
   *   NonStreamingRecognizeResponse response = speechApi.nonStreamingRecognize(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final NonStreamingRecognizeResponse nonStreamingRecognize(RecognizeRequest request) {
    return nonStreamingRecognizeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Perform non-streaming speech-recognition: receive results after all audio
   * has been sent and processed.
   *
   * Sample code:
   * <pre><code>
   * try (SpeechApi speechApi = SpeechApi.create()) {
   *   InitialRecognizeRequest initialRequest = InitialRecognizeRequest.newBuilder().build();
   *   AudioRequest audioRequest = AudioRequest.newBuilder().build();
   *   RecognizeRequest request = RecognizeRequest.newBuilder()
   *     .setInitialRequest(initialRequest)
   *     .setAudioRequest(audioRequest)
   *     .build();
   *   ListenableFuture&lt;NonStreamingRecognizeResponse&gt; future = speechApi.nonStreamingRecognizeCallable().futureCall(request);
   *   // Do something
   *   NonStreamingRecognizeResponse response = future.get();
   * }
   * </code></pre>
   */
  public final ApiCallable<RecognizeRequest, NonStreamingRecognizeResponse>
      nonStreamingRecognizeCallable() {
    return nonStreamingRecognizeCallable;
  }

  /**
   * Initiates an orderly shutdown in which preexisting calls continue but new calls are immediately
   * cancelled.
   */
  @Override
  public final void close() throws Exception {
    for (AutoCloseable closeable : closeables) {
      closeable.close();
    }
  }
}
