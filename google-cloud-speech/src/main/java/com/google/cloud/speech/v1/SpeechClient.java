/*
 * Copyright 2017, Google LLC All rights reserved.
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
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.speech.v1.stub.SpeechStub;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
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
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * SpeechSettings speechSettings =
 *     SpeechSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SpeechClient speechClient =
 *     SpeechClient.create(speechSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * SpeechSettings speechSettings =
 *     SpeechSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SpeechClient speechClient =
 *     SpeechClient.create(speechSettings);
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class SpeechClient implements BackgroundResource {
  private final SpeechSettings settings;
  private final SpeechStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of SpeechClient with default settings. */
  public static final SpeechClient create() throws IOException {
    return create(SpeechSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SpeechClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SpeechClient create(SpeechSettings settings) throws IOException {
    return new SpeechClient(settings);
  }

  /**
   * Constructs an instance of SpeechClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use SpeechSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final SpeechClient create(SpeechStub stub) {
    return new SpeechClient(stub);
  }

  /**
   * Constructs an instance of SpeechClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected SpeechClient(SpeechSettings settings) throws IOException {
    this.settings = settings;
    this.stub = settings.createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected SpeechClient(SpeechStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final SpeechSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public SpeechStub getStub() {
    return stub;
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
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
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
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
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
    return stub.recognizeCallable();
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
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
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
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
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
    return stub.longRunningRecognizeOperationCallable();
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
    return stub.longRunningRecognizeCallable();
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
  public final BidiStreamingCallable<StreamingRecognizeRequest, StreamingRecognizeResponse>
      streamingRecognizeCallable() {
    return stub.streamingRecognizeCallable();
  }

  @Override
  public final void close() throws Exception {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }
}
