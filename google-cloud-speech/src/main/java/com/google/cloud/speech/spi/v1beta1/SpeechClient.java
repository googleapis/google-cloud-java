/*
 * Copyright 2016, Google Inc. All rights reserved.
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
package com.google.cloud.speech.spi.v1beta1;

import com.google.api.gax.grpc.ChannelAndExecutor;
import com.google.api.gax.grpc.FixedChannelProvider;
import com.google.api.gax.grpc.FixedExecutorProvider;
import com.google.api.gax.grpc.OperationCallable;
import com.google.api.gax.grpc.OperationFuture;
import com.google.api.gax.grpc.StreamingCallable;
import com.google.api.gax.grpc.UnaryCallable;
import com.google.cloud.speech.v1beta1.AsyncRecognizeRequest;
import com.google.cloud.speech.v1beta1.AsyncRecognizeResponse;
import com.google.cloud.speech.v1beta1.RecognitionAudio;
import com.google.cloud.speech.v1beta1.RecognitionConfig;
import com.google.cloud.speech.v1beta1.StreamingRecognizeRequest;
import com.google.cloud.speech.v1beta1.StreamingRecognizeResponse;
import com.google.cloud.speech.v1beta1.SyncRecognizeRequest;
import com.google.cloud.speech.v1beta1.SyncRecognizeResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.longrunning.OperationsSettings;
import com.google.protobuf.ExperimentalApi;
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
 *   int sampleRate = 44100;
 *   RecognitionConfig config = RecognitionConfig.newBuilder()
 *     .setEncoding(encoding)
 *     .setSampleRate(sampleRate)
 *     .build();
 *   String uri = "gs://bucket_name/file_name.flac";
 *   RecognitionAudio audio = RecognitionAudio.newBuilder()
 *     .setUri(uri)
 *     .build();
 *   SyncRecognizeResponse response = speechClient.syncRecognize(config, audio);
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
 * InstantiatingChannelProvider channelProvider =
 *     SpeechSettings.defaultChannelProviderBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SpeechSettings speechSettings =
 *     SpeechSettings.defaultBuilder().setChannelProvider(channelProvider).build();
 * SpeechClient speechClient =
 *     SpeechClient.create(speechSettings);
 * </code>
 * </pre>
 */
@Generated("by GAPIC")
@ExperimentalApi
public class SpeechClient implements AutoCloseable {
  private final SpeechSettings settings;
  private final ScheduledExecutorService executor;
  private final ManagedChannel channel;
  private final OperationsClient operationsClient;
  private final List<AutoCloseable> closeables = new ArrayList<>();

  private final UnaryCallable<SyncRecognizeRequest, SyncRecognizeResponse> syncRecognizeCallable;
  private final UnaryCallable<AsyncRecognizeRequest, Operation> asyncRecognizeCallable;
  private final OperationCallable<AsyncRecognizeRequest, AsyncRecognizeResponse>
      asyncRecognizeOperationCallable;
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

    FixedExecutorProvider executorProvider = FixedExecutorProvider.create(this.executor);
    FixedChannelProvider channelProvider = FixedChannelProvider.create(this.channel);
    OperationsSettings operationsSettings =
        OperationsSettings.defaultBuilder()
            .setExecutorProvider(executorProvider)
            .setChannelProvider(channelProvider)
            .build();
    this.operationsClient = OperationsClient.create(operationsSettings);

    this.syncRecognizeCallable =
        UnaryCallable.create(settings.syncRecognizeSettings(), this.channel, this.executor);
    this.asyncRecognizeCallable =
        UnaryCallable.create(
            settings.asyncRecognizeSettings().getInitialCallSettings(),
            this.channel,
            this.executor);
    this.asyncRecognizeOperationCallable =
        OperationCallable.create(
            settings.asyncRecognizeSettings(), this.channel, this.executor, this.operationsClient);
    this.streamingRecognizeCallable =
        StreamingCallable.create(settings.streamingRecognizeSettings(), this.channel);

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
   * Perform synchronous speech-recognition: receive results after all audio has been sent and
   * processed.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   RecognitionConfig.AudioEncoding encoding = RecognitionConfig.AudioEncoding.FLAC;
   *   int sampleRate = 44100;
   *   RecognitionConfig config = RecognitionConfig.newBuilder()
   *     .setEncoding(encoding)
   *     .setSampleRate(sampleRate)
   *     .build();
   *   String uri = "gs://bucket_name/file_name.flac";
   *   RecognitionAudio audio = RecognitionAudio.newBuilder()
   *     .setUri(uri)
   *     .build();
   *   SyncRecognizeResponse response = speechClient.syncRecognize(config, audio);
   * }
   * </code></pre>
   *
   * @param config [Required] The `config` message provides information to the recognizer that
   *     specifies how to process the request.
   * @param audio [Required] The audio data to be recognized.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final SyncRecognizeResponse syncRecognize(
      RecognitionConfig config, RecognitionAudio audio) {

    SyncRecognizeRequest request =
        SyncRecognizeRequest.newBuilder().setConfig(config).setAudio(audio).build();
    return syncRecognize(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Perform synchronous speech-recognition: receive results after all audio has been sent and
   * processed.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   RecognitionConfig.AudioEncoding encoding = RecognitionConfig.AudioEncoding.FLAC;
   *   int sampleRate = 44100;
   *   RecognitionConfig config = RecognitionConfig.newBuilder()
   *     .setEncoding(encoding)
   *     .setSampleRate(sampleRate)
   *     .build();
   *   String uri = "gs://bucket_name/file_name.flac";
   *   RecognitionAudio audio = RecognitionAudio.newBuilder()
   *     .setUri(uri)
   *     .build();
   *   SyncRecognizeRequest request = SyncRecognizeRequest.newBuilder()
   *     .setConfig(config)
   *     .setAudio(audio)
   *     .build();
   *   SyncRecognizeResponse response = speechClient.syncRecognize(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final SyncRecognizeResponse syncRecognize(SyncRecognizeRequest request) {
    return syncRecognizeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Perform synchronous speech-recognition: receive results after all audio has been sent and
   * processed.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   RecognitionConfig.AudioEncoding encoding = RecognitionConfig.AudioEncoding.FLAC;
   *   int sampleRate = 44100;
   *   RecognitionConfig config = RecognitionConfig.newBuilder()
   *     .setEncoding(encoding)
   *     .setSampleRate(sampleRate)
   *     .build();
   *   String uri = "gs://bucket_name/file_name.flac";
   *   RecognitionAudio audio = RecognitionAudio.newBuilder()
   *     .setUri(uri)
   *     .build();
   *   SyncRecognizeRequest request = SyncRecognizeRequest.newBuilder()
   *     .setConfig(config)
   *     .setAudio(audio)
   *     .build();
   *   RpcFuture&lt;SyncRecognizeResponse&gt; future = speechClient.syncRecognizeCallable().futureCall(request);
   *   // Do something
   *   SyncRecognizeResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SyncRecognizeRequest, SyncRecognizeResponse> syncRecognizeCallable() {
    return syncRecognizeCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Perform asynchronous speech-recognition: receive results via the google.longrunning.Operations
   * interface. Returns either an `Operation.error` or an `Operation.response` which contains an
   * `AsyncRecognizeResponse` message.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   RecognitionConfig.AudioEncoding encoding = RecognitionConfig.AudioEncoding.FLAC;
   *   int sampleRate = 44100;
   *   RecognitionConfig config = RecognitionConfig.newBuilder()
   *     .setEncoding(encoding)
   *     .setSampleRate(sampleRate)
   *     .build();
   *   String uri = "gs://bucket_name/file_name.flac";
   *   RecognitionAudio audio = RecognitionAudio.newBuilder()
   *     .setUri(uri)
   *     .build();
   *   AsyncRecognizeResponse response = speechClient.asyncRecognizeAsync(config, audio).get();
   * }
   * </code></pre>
   *
   * @param config [Required] The `config` message provides information to the recognizer that
   *     specifies how to process the request.
   * @param audio [Required] The audio data to be recognized.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final OperationFuture<AsyncRecognizeResponse> asyncRecognizeAsync(
      RecognitionConfig config, RecognitionAudio audio) {

    AsyncRecognizeRequest request =
        AsyncRecognizeRequest.newBuilder().setConfig(config).setAudio(audio).build();
    return asyncRecognizeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Perform asynchronous speech-recognition: receive results via the google.longrunning.Operations
   * interface. Returns either an `Operation.error` or an `Operation.response` which contains an
   * `AsyncRecognizeResponse` message.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   RecognitionConfig.AudioEncoding encoding = RecognitionConfig.AudioEncoding.FLAC;
   *   int sampleRate = 44100;
   *   RecognitionConfig config = RecognitionConfig.newBuilder()
   *     .setEncoding(encoding)
   *     .setSampleRate(sampleRate)
   *     .build();
   *   String uri = "gs://bucket_name/file_name.flac";
   *   RecognitionAudio audio = RecognitionAudio.newBuilder()
   *     .setUri(uri)
   *     .build();
   *   AsyncRecognizeRequest request = AsyncRecognizeRequest.newBuilder()
   *     .setConfig(config)
   *     .setAudio(audio)
   *     .build();
   *   AsyncRecognizeResponse response = speechClient.asyncRecognizeAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final OperationFuture<AsyncRecognizeResponse> asyncRecognizeAsync(
      AsyncRecognizeRequest request) {
    return asyncRecognizeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Perform asynchronous speech-recognition: receive results via the google.longrunning.Operations
   * interface. Returns either an `Operation.error` or an `Operation.response` which contains an
   * `AsyncRecognizeResponse` message.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   RecognitionConfig.AudioEncoding encoding = RecognitionConfig.AudioEncoding.FLAC;
   *   int sampleRate = 44100;
   *   RecognitionConfig config = RecognitionConfig.newBuilder()
   *     .setEncoding(encoding)
   *     .setSampleRate(sampleRate)
   *     .build();
   *   String uri = "gs://bucket_name/file_name.flac";
   *   RecognitionAudio audio = RecognitionAudio.newBuilder()
   *     .setUri(uri)
   *     .build();
   *   AsyncRecognizeRequest request = AsyncRecognizeRequest.newBuilder()
   *     .setConfig(config)
   *     .setAudio(audio)
   *     .build();
   *   OperationFuture&lt;Operation&gt; future = speechClient.asyncRecognizeOperationCallable().futureCall(request);
   *   // Do something
   *   AsyncRecognizeResponse response = future.get();
   * }
   * </code></pre>
   */
  public final OperationCallable<AsyncRecognizeRequest, AsyncRecognizeResponse>
      asyncRecognizeOperationCallable() {
    return asyncRecognizeOperationCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Perform asynchronous speech-recognition: receive results via the google.longrunning.Operations
   * interface. Returns either an `Operation.error` or an `Operation.response` which contains an
   * `AsyncRecognizeResponse` message.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   RecognitionConfig.AudioEncoding encoding = RecognitionConfig.AudioEncoding.FLAC;
   *   int sampleRate = 44100;
   *   RecognitionConfig config = RecognitionConfig.newBuilder()
   *     .setEncoding(encoding)
   *     .setSampleRate(sampleRate)
   *     .build();
   *   String uri = "gs://bucket_name/file_name.flac";
   *   RecognitionAudio audio = RecognitionAudio.newBuilder()
   *     .setUri(uri)
   *     .build();
   *   AsyncRecognizeRequest request = AsyncRecognizeRequest.newBuilder()
   *     .setConfig(config)
   *     .setAudio(audio)
   *     .build();
   *   RpcFuture&lt;Operation&gt; future = speechClient.asyncRecognizeCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<AsyncRecognizeRequest, Operation> asyncRecognizeCallable() {
    return asyncRecognizeCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Perform bidirectional streaming speech-recognition: receive results while sending audio. This
   * method is only available via the gRPC API (not REST).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   RpcStreamObserver&lt;StreamingRecognizeResponse&gt; responseObserver =
   *       new RpcStreamObserver&lt;StreamingRecognizeResponse&gt;() {
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
   *   RpcStreamObserver&lt;StreamingRecognizeRequest&gt; requestObserver =
   *       speechClient.streamingRecognizeCallable().bidiStreamingCall(responseObserver)});
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
