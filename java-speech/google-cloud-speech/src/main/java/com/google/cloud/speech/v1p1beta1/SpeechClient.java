/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.speech.v1p1beta1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.speech.v1p1beta1.stub.SpeechStub;
import com.google.cloud.speech.v1p1beta1.stub.SpeechStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service that implements Google Cloud Speech API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SpeechClient speechClient = SpeechClient.create()) {
 *   RecognitionConfig config = RecognitionConfig.newBuilder().build();
 *   RecognitionAudio audio = RecognitionAudio.newBuilder().build();
 *   RecognizeResponse response = speechClient.recognize(config, audio);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SpeechClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
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
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SpeechSettings speechSettings =
 *     SpeechSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SpeechClient speechClient = SpeechClient.create(speechSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SpeechSettings speechSettings = SpeechSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SpeechClient speechClient = SpeechClient.create(speechSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SpeechSettings speechSettings = SpeechSettings.newHttpJsonBuilder().build();
 * SpeechClient speechClient = SpeechClient.create(speechSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class SpeechClient implements BackgroundResource {
  private final SpeechSettings settings;
  private final SpeechStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

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
   * advanced usage - prefer using create(SpeechSettings).
   */
  public static final SpeechClient create(SpeechStub stub) {
    return new SpeechClient(stub);
  }

  /**
   * Constructs an instance of SpeechClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected SpeechClient(SpeechSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SpeechStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected SpeechClient(SpeechStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final SpeechSettings getSettings() {
    return settings;
  }

  public SpeechStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs synchronous speech recognition: receive results after all audio has been sent and
   * processed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   RecognitionConfig config = RecognitionConfig.newBuilder().build();
   *   RecognitionAudio audio = RecognitionAudio.newBuilder().build();
   *   RecognizeResponse response = speechClient.recognize(config, audio);
   * }
   * }</pre>
   *
   * @param config Required. Provides information to the recognizer that specifies how to process
   *     the request.
   * @param audio Required. The audio data to be recognized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RecognizeResponse recognize(RecognitionConfig config, RecognitionAudio audio) {
    RecognizeRequest request =
        RecognizeRequest.newBuilder().setConfig(config).setAudio(audio).build();
    return recognize(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs synchronous speech recognition: receive results after all audio has been sent and
   * processed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   RecognizeRequest request =
   *       RecognizeRequest.newBuilder()
   *           .setConfig(RecognitionConfig.newBuilder().build())
   *           .setAudio(RecognitionAudio.newBuilder().build())
   *           .build();
   *   RecognizeResponse response = speechClient.recognize(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RecognizeResponse recognize(RecognizeRequest request) {
    return recognizeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs synchronous speech recognition: receive results after all audio has been sent and
   * processed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   RecognizeRequest request =
   *       RecognizeRequest.newBuilder()
   *           .setConfig(RecognitionConfig.newBuilder().build())
   *           .setAudio(RecognitionAudio.newBuilder().build())
   *           .build();
   *   ApiFuture<RecognizeResponse> future = speechClient.recognizeCallable().futureCall(request);
   *   // Do something.
   *   RecognizeResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RecognizeRequest, RecognizeResponse> recognizeCallable() {
    return stub.recognizeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs asynchronous speech recognition: receive results via the google.longrunning.Operations
   * interface. Returns either an `Operation.error` or an `Operation.response` which contains a
   * `LongRunningRecognizeResponse` message. For more information on asynchronous speech
   * recognition, see the [how-to](https://cloud.google.com/speech-to-text/docs/async-recognize).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   RecognitionConfig config = RecognitionConfig.newBuilder().build();
   *   RecognitionAudio audio = RecognitionAudio.newBuilder().build();
   *   LongRunningRecognizeResponse response =
   *       speechClient.longRunningRecognizeAsync(config, audio).get();
   * }
   * }</pre>
   *
   * @param config Required. Provides information to the recognizer that specifies how to process
   *     the request.
   * @param audio Required. The audio data to be recognized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<LongRunningRecognizeResponse, LongRunningRecognizeMetadata>
      longRunningRecognizeAsync(RecognitionConfig config, RecognitionAudio audio) {
    LongRunningRecognizeRequest request =
        LongRunningRecognizeRequest.newBuilder().setConfig(config).setAudio(audio).build();
    return longRunningRecognizeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs asynchronous speech recognition: receive results via the google.longrunning.Operations
   * interface. Returns either an `Operation.error` or an `Operation.response` which contains a
   * `LongRunningRecognizeResponse` message. For more information on asynchronous speech
   * recognition, see the [how-to](https://cloud.google.com/speech-to-text/docs/async-recognize).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   LongRunningRecognizeRequest request =
   *       LongRunningRecognizeRequest.newBuilder()
   *           .setConfig(RecognitionConfig.newBuilder().build())
   *           .setAudio(RecognitionAudio.newBuilder().build())
   *           .setOutputConfig(TranscriptOutputConfig.newBuilder().build())
   *           .build();
   *   LongRunningRecognizeResponse response = speechClient.longRunningRecognizeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<LongRunningRecognizeResponse, LongRunningRecognizeMetadata>
      longRunningRecognizeAsync(LongRunningRecognizeRequest request) {
    return longRunningRecognizeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs asynchronous speech recognition: receive results via the google.longrunning.Operations
   * interface. Returns either an `Operation.error` or an `Operation.response` which contains a
   * `LongRunningRecognizeResponse` message. For more information on asynchronous speech
   * recognition, see the [how-to](https://cloud.google.com/speech-to-text/docs/async-recognize).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   LongRunningRecognizeRequest request =
   *       LongRunningRecognizeRequest.newBuilder()
   *           .setConfig(RecognitionConfig.newBuilder().build())
   *           .setAudio(RecognitionAudio.newBuilder().build())
   *           .setOutputConfig(TranscriptOutputConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<LongRunningRecognizeResponse, LongRunningRecognizeMetadata> future =
   *       speechClient.longRunningRecognizeOperationCallable().futureCall(request);
   *   // Do something.
   *   LongRunningRecognizeResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          LongRunningRecognizeRequest, LongRunningRecognizeResponse, LongRunningRecognizeMetadata>
      longRunningRecognizeOperationCallable() {
    return stub.longRunningRecognizeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs asynchronous speech recognition: receive results via the google.longrunning.Operations
   * interface. Returns either an `Operation.error` or an `Operation.response` which contains a
   * `LongRunningRecognizeResponse` message. For more information on asynchronous speech
   * recognition, see the [how-to](https://cloud.google.com/speech-to-text/docs/async-recognize).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   LongRunningRecognizeRequest request =
   *       LongRunningRecognizeRequest.newBuilder()
   *           .setConfig(RecognitionConfig.newBuilder().build())
   *           .setAudio(RecognitionAudio.newBuilder().build())
   *           .setOutputConfig(TranscriptOutputConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = speechClient.longRunningRecognizeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<LongRunningRecognizeRequest, Operation>
      longRunningRecognizeCallable() {
    return stub.longRunningRecognizeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs bidirectional streaming speech recognition: receive results while sending audio. This
   * method is only available via the gRPC API (not REST).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpeechClient speechClient = SpeechClient.create()) {
   *   BidiStream<StreamingRecognizeRequest, StreamingRecognizeResponse> bidiStream =
   *       speechClient.streamingRecognizeCallable().call();
   *   StreamingRecognizeRequest request = StreamingRecognizeRequest.newBuilder().build();
   *   bidiStream.send(request);
   *   for (StreamingRecognizeResponse response : bidiStream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final BidiStreamingCallable<StreamingRecognizeRequest, StreamingRecognizeResponse>
      streamingRecognizeCallable() {
    return stub.streamingRecognizeCallable();
  }

  @Override
  public final void close() {
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
