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

package com.google.cloud.mediatranslation.v1beta1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.cloud.mediatranslation.v1beta1.stub.SpeechTranslationServiceStub;
import com.google.cloud.mediatranslation.v1beta1.stub.SpeechTranslationServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides translation from/to media types.
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
 * try (SpeechTranslationServiceClient speechTranslationServiceClient =
 *     SpeechTranslationServiceClient.create()) {
 *   BidiStream<StreamingTranslateSpeechRequest, StreamingTranslateSpeechResponse> bidiStream =
 *       speechTranslationServiceClient.streamingTranslateSpeechCallable().call();
 *   StreamingTranslateSpeechRequest request =
 *       StreamingTranslateSpeechRequest.newBuilder().build();
 *   bidiStream.send(request);
 *   for (StreamingTranslateSpeechResponse response : bidiStream) {
 *     // Do something when a response is received.
 *   }
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SpeechTranslationServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
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
 * <p>This class can be customized by passing in a custom instance of
 * SpeechTranslationServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SpeechTranslationServiceSettings speechTranslationServiceSettings =
 *     SpeechTranslationServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SpeechTranslationServiceClient speechTranslationServiceClient =
 *     SpeechTranslationServiceClient.create(speechTranslationServiceSettings);
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
 * SpeechTranslationServiceSettings speechTranslationServiceSettings =
 *     SpeechTranslationServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SpeechTranslationServiceClient speechTranslationServiceClient =
 *     SpeechTranslationServiceClient.create(speechTranslationServiceSettings);
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
 * SpeechTranslationServiceSettings speechTranslationServiceSettings =
 *     SpeechTranslationServiceSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             SpeechTranslationServiceSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * SpeechTranslationServiceClient speechTranslationServiceClient =
 *     SpeechTranslationServiceClient.create(speechTranslationServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class SpeechTranslationServiceClient implements BackgroundResource {
  private final SpeechTranslationServiceSettings settings;
  private final SpeechTranslationServiceStub stub;

  /** Constructs an instance of SpeechTranslationServiceClient with default settings. */
  public static final SpeechTranslationServiceClient create() throws IOException {
    return create(SpeechTranslationServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SpeechTranslationServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final SpeechTranslationServiceClient create(
      SpeechTranslationServiceSettings settings) throws IOException {
    return new SpeechTranslationServiceClient(settings);
  }

  /**
   * Constructs an instance of SpeechTranslationServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(SpeechTranslationServiceSettings).
   */
  public static final SpeechTranslationServiceClient create(SpeechTranslationServiceStub stub) {
    return new SpeechTranslationServiceClient(stub);
  }

  /**
   * Constructs an instance of SpeechTranslationServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected SpeechTranslationServiceClient(SpeechTranslationServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((SpeechTranslationServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected SpeechTranslationServiceClient(SpeechTranslationServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SpeechTranslationServiceSettings getSettings() {
    return settings;
  }

  public SpeechTranslationServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs bidirectional streaming speech translation: receive results while sending audio. This
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
   * try (SpeechTranslationServiceClient speechTranslationServiceClient =
   *     SpeechTranslationServiceClient.create()) {
   *   BidiStream<StreamingTranslateSpeechRequest, StreamingTranslateSpeechResponse> bidiStream =
   *       speechTranslationServiceClient.streamingTranslateSpeechCallable().call();
   *   StreamingTranslateSpeechRequest request =
   *       StreamingTranslateSpeechRequest.newBuilder().build();
   *   bidiStream.send(request);
   *   for (StreamingTranslateSpeechResponse response : bidiStream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final BidiStreamingCallable<
          StreamingTranslateSpeechRequest, StreamingTranslateSpeechResponse>
      streamingTranslateSpeechCallable() {
    return stub.streamingTranslateSpeechCallable();
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
