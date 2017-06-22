/*
 * Copyright 2017, Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.speech.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.grpc.ChannelAndExecutor;
import com.google.api.gax.grpc.ClientContext;
import com.google.api.gax.grpc.FixedChannelProvider;
import com.google.api.gax.grpc.FixedExecutorProvider;
import com.google.api.gax.grpc.OperationCallable;
import com.google.api.gax.grpc.OperationFuture;
import com.google.api.gax.grpc.StreamingCallable;
import com.google.api.gax.grpc.UnaryCallable;
import com.google.auth.Credentials;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.longrunning.OperationsSettings;
import io.grpc.ManagedChannel;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Service that implements Google Cloud Speech API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (SpeechClient speechClient = SpeechClient.create()) {
 *   RecognitionConfig.AudioEncoding encoding = RecognitionConfig.AudioEncoding.FLAC;
 *   int sampleRateHertz = 44100;
 *   String languageCode = "en-US";
 *   RecognitionConfig config = RecognitionConfig.newBuilder()
 *     .setEncoding(encoding)
 *     .setSampleRateHertz(sampleRateHertz)
 *     .setLanguageCode(languageCode)
 *     .build();
 *   String uri = "gs://bucket_name/file_name.flac";
 *   RecognitionAudio audio = RecognitionAudio.newBuilder()
 *     .setUri(uri)
 *     .build();
 *   RecognizeResponse response = speechClient.recognize(config, audio);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the speechClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li> A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li> A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li> A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of SpeechSettings to create().
 * For example:
 *
 * <pre>
 * <code>
 * SpeechSettings speechSettings =
 *     SpeechSettings.defaultBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SpeechClient speechClient =
 *     SpeechClient.create(speechSettings);
 * </code>
 * </pre>
 */
@Generated("by GAPIC")
@BetaApi
public class SpeechClient implements AutoCloseable {
  private final SpeechSettings settings;
  private final ScheduledExecutorService executor;
  private final ManagedChannel channel;
  private final OperationsClient operationsClient;
  private final List<AutoCloseable> closeables = new ArrayList<>();

  private final UnaryCallable<RecognizeRequest, RecognizeResponse> recognizeCallable;
  private final UnaryCallable<LongRunningRecognizeRequest, Operation> longRunningRecognizeCallable;
  private final OperationCallable<
          LongRunningRecognizeRequest, LongRunningRecognizeResponse, LongRunningRecognizeMetadata>
      longRunningRecognizeOperationCallable;
  private final StreamingCallable<StreamingRecognizeRequest, StreamingRecognizeResponse>
      streamingRecognizeCallable;

  /** Constructs an instance of SpeechClient with default settings. */
  public static final SpeechClient create() throws IOException {
    return create(SpeechSettings.defaultBuilder().build());
  }

  /**
   * Constructs an instance of SpeechClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SpeechClient create(SpeechSettings settings) throws IOException {
    return new SpeechClient(settings);
  }

  /**
   * Constructs an instance of SpeechClient, using the given settings. This is protected so that it
   * easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected SpeechClient(SpeechSettings settings) throws IOException {
    this.settings = settings;
    ChannelAndExecutor channelAndExecutor = settings.getChannelAndExecutor();
    this.executor = channelAndExecutor.getExecutor();
    this.channel = channelAndExecutor.getChannel();
    Credentials credentials = settings.getCredentialsProvider().getCredentials();

    ClientContext clientContext =
        ClientContext.newBuilder()
            .setExecutor(this.executor)
            .setChannel(this.channel)
            .setCredentials(credentials)
            .build();

    OperationsSettings operationsSettings =
        OperationsSettings.defaultBuilder()
            .setExecutorProvider(FixedExecutorProvider.create(this.executor))
            .setChannelProvider(FixedChannelProvider.create(this.channel))
            .setCredentialsProvider(FixedCredentialsProvider.create(credentials))
            .build();
    this.operationsClient = OperationsClient.create(operationsSettings);

    this.recognizeCallable = UnaryCallable.create(settings.recognizeSettings(), clientContext);
    this.longRunningRecognizeCallable =
        UnaryCallable.create(
            settings.longRunningRecognizeSettings().getInitialCallSettings(), clientContext);
    this.longRunningRecognizeOperationCallable =
        OperationCallable.create(
            settings.longRunningRecognizeSettings(), clientContext, this.operationsClient);
    this.streamingRecognizeCallable =
        StreamingCallable.create(settings.streamingRecognizeSettings(), clientContext);

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

  public final SpeechSettings getSettings() {
    return settings;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Performs synchronous speech recognition: receive results after all audio has been sent and
   * processed.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   RecognitionConfig.AudioEncoding encoding = RecognitionConfig.AudioEncoding.FLAC;
   *   int sampleRateHertz = 44100;
   *   String languageCode = "en-US";
   *   RecognitionConfig config = RecognitionConfig.newBuilder()
   *     .setEncoding(encoding)
   *     .setSampleRateHertz(sampleRateHertz)
   *     .setLanguageCode(languageCode)
   *     .build();
   *   String uri = "gs://bucket_name/file_name.flac";
   *   RecognitionAudio audio = RecognitionAudio.newBuilder()
   *     .setUri(uri)
   *     .build();
   *   RecognizeResponse response = speechClient.recognize(config, audio);
   * }
   * </code></pre>
   *
   * @param config &#42;Required&#42; Provides information to the recognizer that specifies how to
   *     process the request.
   * @param audio &#42;Required&#42; The audio data to be recognized.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final RecognizeResponse recognize(RecognitionConfig config, RecognitionAudio audio) {

    RecognizeRequest request =
        RecognizeRequest.newBuilder().setConfig(config).setAudio(audio).build();
    return recognize(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Performs synchronous speech recognition: receive results after all audio has been sent and
   * processed.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   RecognitionConfig.AudioEncoding encoding = RecognitionConfig.AudioEncoding.FLAC;
   *   int sampleRateHertz = 44100;
   *   String languageCode = "en-US";
   *   RecognitionConfig config = RecognitionConfig.newBuilder()
   *     .setEncoding(encoding)
   *     .setSampleRateHertz(sampleRateHertz)
   *     .setLanguageCode(languageCode)
   *     .build();
   *   String uri = "gs://bucket_name/file_name.flac";
   *   RecognitionAudio audio = RecognitionAudio.newBuilder()
   *     .setUri(uri)
   *     .build();
   *   RecognizeRequest request = RecognizeRequest.newBuilder()
   *     .setConfig(config)
   *     .setAudio(audio)
   *     .build();
   *   RecognizeResponse response = speechClient.recognize(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final RecognizeResponse recognize(RecognizeRequest request) {
    return recognizeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Performs synchronous speech recognition: receive results after all audio has been sent and
   * processed.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   RecognitionConfig.AudioEncoding encoding = RecognitionConfig.AudioEncoding.FLAC;
   *   int sampleRateHertz = 44100;
   *   String languageCode = "en-US";
   *   RecognitionConfig config = RecognitionConfig.newBuilder()
   *     .setEncoding(encoding)
   *     .setSampleRateHertz(sampleRateHertz)
   *     .setLanguageCode(languageCode)
   *     .build();
   *   String uri = "gs://bucket_name/file_name.flac";
   *   RecognitionAudio audio = RecognitionAudio.newBuilder()
   *     .setUri(uri)
   *     .build();
   *   RecognizeRequest request = RecognizeRequest.newBuilder()
   *     .setConfig(config)
   *     .setAudio(audio)
   *     .build();
   *   ApiFuture&lt;RecognizeResponse&gt; future = speechClient.recognizeCallable().futureCall(request);
   *   // Do something
   *   RecognizeResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<RecognizeRequest, RecognizeResponse> recognizeCallable() {
    return recognizeCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Performs asynchronous speech recognition: receive results via the google.longrunning.Operations
   * interface. Returns either an `Operation.error` or an `Operation.response` which contains a
   * `LongRunningRecognizeResponse` message.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   RecognitionConfig.AudioEncoding encoding = RecognitionConfig.AudioEncoding.FLAC;
   *   int sampleRateHertz = 44100;
   *   String languageCode = "en-US";
   *   RecognitionConfig config = RecognitionConfig.newBuilder()
   *     .setEncoding(encoding)
   *     .setSampleRateHertz(sampleRateHertz)
   *     .setLanguageCode(languageCode)
   *     .build();
   *   String uri = "gs://bucket_name/file_name.flac";
   *   RecognitionAudio audio = RecognitionAudio.newBuilder()
   *     .setUri(uri)
   *     .build();
   *   LongRunningRecognizeResponse response = speechClient.longRunningRecognizeAsync(config, audio).get();
   * }
   * </code></pre>
   *
   * @param config &#42;Required&#42; Provides information to the recognizer that specifies how to
   *     process the request.
   * @param audio &#42;Required&#42; The audio data to be recognized.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final OperationFuture<LongRunningRecognizeResponse, LongRunningRecognizeMetadata>
      longRunningRecognizeAsync(RecognitionConfig config, RecognitionAudio audio) {

    LongRunningRecognizeRequest request =
        LongRunningRecognizeRequest.newBuilder().setConfig(config).setAudio(audio).build();
    return longRunningRecognizeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Performs asynchronous speech recognition: receive results via the google.longrunning.Operations
   * interface. Returns either an `Operation.error` or an `Operation.response` which contains a
   * `LongRunningRecognizeResponse` message.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   RecognitionConfig.AudioEncoding encoding = RecognitionConfig.AudioEncoding.FLAC;
   *   int sampleRateHertz = 44100;
   *   String languageCode = "en-US";
   *   RecognitionConfig config = RecognitionConfig.newBuilder()
   *     .setEncoding(encoding)
   *     .setSampleRateHertz(sampleRateHertz)
   *     .setLanguageCode(languageCode)
   *     .build();
   *   String uri = "gs://bucket_name/file_name.flac";
   *   RecognitionAudio audio = RecognitionAudio.newBuilder()
   *     .setUri(uri)
   *     .build();
   *   LongRunningRecognizeRequest request = LongRunningRecognizeRequest.newBuilder()
   *     .setConfig(config)
   *     .setAudio(audio)
   *     .build();
   *   LongRunningRecognizeResponse response = speechClient.longRunningRecognizeAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final OperationFuture<LongRunningRecognizeResponse, LongRunningRecognizeMetadata>
      longRunningRecognizeAsync(LongRunningRecognizeRequest request) {
    return longRunningRecognizeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Performs asynchronous speech recognition: receive results via the google.longrunning.Operations
   * interface. Returns either an `Operation.error` or an `Operation.response` which contains a
   * `LongRunningRecognizeResponse` message.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   RecognitionConfig.AudioEncoding encoding = RecognitionConfig.AudioEncoding.FLAC;
   *   int sampleRateHertz = 44100;
   *   String languageCode = "en-US";
   *   RecognitionConfig config = RecognitionConfig.newBuilder()
   *     .setEncoding(encoding)
   *     .setSampleRateHertz(sampleRateHertz)
   *     .setLanguageCode(languageCode)
   *     .build();
   *   String uri = "gs://bucket_name/file_name.flac";
   *   RecognitionAudio audio = RecognitionAudio.newBuilder()
   *     .setUri(uri)
   *     .build();
   *   LongRunningRecognizeRequest request = LongRunningRecognizeRequest.newBuilder()
   *     .setConfig(config)
   *     .setAudio(audio)
   *     .build();
   *   OperationFuture&lt;Operation&gt; future = speechClient.longRunningRecognizeOperationCallable().futureCall(request);
   *   // Do something
   *   LongRunningRecognizeResponse response = future.get();
   * }
   * </code></pre>
   */
  public final OperationCallable<
          LongRunningRecognizeRequest, LongRunningRecognizeResponse, LongRunningRecognizeMetadata>
      longRunningRecognizeOperationCallable() {
    return longRunningRecognizeOperationCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Performs asynchronous speech recognition: receive results via the google.longrunning.Operations
   * interface. Returns either an `Operation.error` or an `Operation.response` which contains a
   * `LongRunningRecognizeResponse` message.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   RecognitionConfig.AudioEncoding encoding = RecognitionConfig.AudioEncoding.FLAC;
   *   int sampleRateHertz = 44100;
   *   String languageCode = "en-US";
   *   RecognitionConfig config = RecognitionConfig.newBuilder()
   *     .setEncoding(encoding)
   *     .setSampleRateHertz(sampleRateHertz)
   *     .setLanguageCode(languageCode)
   *     .build();
   *   String uri = "gs://bucket_name/file_name.flac";
   *   RecognitionAudio audio = RecognitionAudio.newBuilder()
   *     .setUri(uri)
   *     .build();
   *   LongRunningRecognizeRequest request = LongRunningRecognizeRequest.newBuilder()
   *     .setConfig(config)
   *     .setAudio(audio)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = speechClient.longRunningRecognizeCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<LongRunningRecognizeRequest, Operation>
      longRunningRecognizeCallable() {
    return longRunningRecognizeCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Performs bidirectional streaming speech recognition: receive results while sending audio. This
   * method is only available via the gRPC API (not REST).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   ApiStreamObserver&lt;StreamingRecognizeResponse&gt; responseObserver =
   *       new ApiStreamObserver&lt;StreamingRecognizeResponse&gt;() {
   *         {@literal @}Override
   *         public void onNext(StreamingRecognizeResponse response) {
   *           // Do something when receive a response
   *         }
   *
   *         {@literal @}Override
   *         public void onError(Throwable t) {
   *           // Add error-handling
   *         }
   *
   *         {@literal @}Override
   *         public void onCompleted() {
   *           // Do something when complete.
   *         }
   *       };
   *   ApiStreamObserver&lt;StreamingRecognizeRequest&gt; requestObserver =
   *       speechClient.streamingRecognizeCallable().bidiStreamingCall(responseObserver));
   *
   *   StreamingRecognizeRequest request = StreamingRecognizeRequest.newBuilder().build();
   *   requestObserver.onNext(request);
   * }
   * </code></pre>
   */
  public final StreamingCallable<StreamingRecognizeRequest, StreamingRecognizeResponse>
      streamingRecognizeCallable() {
    return streamingRecognizeCallable;
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
