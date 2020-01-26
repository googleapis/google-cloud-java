/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.bigquery.storage.v1alpha2;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.AppendRowsRequest;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.AppendRowsResponse;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.BatchCommitWriteStreamsRequest;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.BatchCommitWriteStreamsResponse;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.CreateWriteStreamRequest;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.FinalizeWriteStreamRequest;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.FinalizeWriteStreamResponse;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.GetWriteStreamRequest;
import com.google.cloud.bigquery.storage.v1alpha2.Stream.WriteStream;
import com.google.cloud.bigquery.storage.v1alpha2.stub.BigQueryWriteStub;
import com.google.cloud.bigquery.storage.v1alpha2.stub.BigQueryWriteStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: BigQuery Write API.
 *
 * <p>The Write API can be used to write data to BigQuery.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (BigQueryWriteClient bigQueryWriteClient = BigQueryWriteClient.create()) {
 *   CreateWriteStreamRequest request = CreateWriteStreamRequest.newBuilder().build();
 *   WriteStream response = bigQueryWriteClient.createWriteStream(request);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the bigQueryWriteClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of BigQueryWriteSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * BigQueryWriteSettings bigQueryWriteSettings =
 *     BigQueryWriteSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * BigQueryWriteClient bigQueryWriteClient =
 *     BigQueryWriteClient.create(bigQueryWriteSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * BigQueryWriteSettings bigQueryWriteSettings =
 *     BigQueryWriteSettings.newBuilder().setEndpoint(myEndpoint).build();
 * BigQueryWriteClient bigQueryWriteClient =
 *     BigQueryWriteClient.create(bigQueryWriteSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class BigQueryWriteClient implements BackgroundResource {
  private final BigQueryWriteSettings settings;
  private final BigQueryWriteStub stub;

  /** Constructs an instance of BigQueryWriteClient with default settings. */
  public static final BigQueryWriteClient create() throws IOException {
    return create(BigQueryWriteSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of BigQueryWriteClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final BigQueryWriteClient create(BigQueryWriteSettings settings)
      throws IOException {
    return new BigQueryWriteClient(settings);
  }

  /**
   * Constructs an instance of BigQueryWriteClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use BigQueryWriteSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final BigQueryWriteClient create(BigQueryWriteStub stub) {
    return new BigQueryWriteClient(stub);
  }

  /**
   * Constructs an instance of BigQueryWriteClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected BigQueryWriteClient(BigQueryWriteSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((BigQueryWriteStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected BigQueryWriteClient(BigQueryWriteStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final BigQueryWriteSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public BigQueryWriteStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a write stream to the given table.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigQueryWriteClient bigQueryWriteClient = BigQueryWriteClient.create()) {
   *   CreateWriteStreamRequest request = CreateWriteStreamRequest.newBuilder().build();
   *   WriteStream response = bigQueryWriteClient.createWriteStream(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WriteStream createWriteStream(CreateWriteStreamRequest request) {
    return createWriteStreamCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a write stream to the given table.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigQueryWriteClient bigQueryWriteClient = BigQueryWriteClient.create()) {
   *   CreateWriteStreamRequest request = CreateWriteStreamRequest.newBuilder().build();
   *   ApiFuture&lt;WriteStream&gt; future = bigQueryWriteClient.createWriteStreamCallable().futureCall(request);
   *   // Do something
   *   WriteStream response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateWriteStreamRequest, WriteStream> createWriteStreamCallable() {
    return stub.createWriteStreamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Appends data to the given stream.
   *
   * <p>If `offset` is specified, the `offset` is checked against the end of stream. The server
   * returns `OUT_OF_RANGE` in `AppendRowsResponse` if an attempt is made to append to an offset
   * beyond the current end of the stream or `ALREADY_EXISTS` if user provids an `offset` that has
   * already been written to. User can retry with adjusted offset within the same RPC stream. If
   * `offset` is not specified, append happens at the end of the stream.
   *
   * <p>The response contains the offset at which the append happened. Responses are received in the
   * same order in which requests are sent. There will be one response for each successful request.
   * If the `offset` is not set in response, it means append didn't happen due to some errors. If
   * one request fails, all the subsequent requests will also fail until a success request is made
   * again.
   *
   * <p>If the stream is of `PENDING` type, data will only be available for read operations after
   * the stream is committed.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigQueryWriteClient bigQueryWriteClient = BigQueryWriteClient.create()) {
   *   BidiStream&lt;AppendRowsRequest, AppendRowsResponse&gt; bidiStream =
   *       bigQueryWriteClient.appendRowsCallable().call();
   *
   *   AppendRowsRequest request = AppendRowsRequest.newBuilder().build();
   *   bidiStream.send(request);
   *   for (AppendRowsResponse response : bidiStream) {
   *     // Do something when receive a response
   *   }
   * }
   * </code></pre>
   */
  public final BidiStreamingCallable<AppendRowsRequest, AppendRowsResponse> appendRowsCallable() {
    return stub.appendRowsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a write stream.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigQueryWriteClient bigQueryWriteClient = BigQueryWriteClient.create()) {
   *   GetWriteStreamRequest request = GetWriteStreamRequest.newBuilder().build();
   *   WriteStream response = bigQueryWriteClient.getWriteStream(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WriteStream getWriteStream(GetWriteStreamRequest request) {
    return getWriteStreamCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a write stream.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigQueryWriteClient bigQueryWriteClient = BigQueryWriteClient.create()) {
   *   GetWriteStreamRequest request = GetWriteStreamRequest.newBuilder().build();
   *   ApiFuture&lt;WriteStream&gt; future = bigQueryWriteClient.getWriteStreamCallable().futureCall(request);
   *   // Do something
   *   WriteStream response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetWriteStreamRequest, WriteStream> getWriteStreamCallable() {
    return stub.getWriteStreamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Finalize a write stream so that no new data can be appended to the stream.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigQueryWriteClient bigQueryWriteClient = BigQueryWriteClient.create()) {
   *   FinalizeWriteStreamRequest request = FinalizeWriteStreamRequest.newBuilder().build();
   *   FinalizeWriteStreamResponse response = bigQueryWriteClient.finalizeWriteStream(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FinalizeWriteStreamResponse finalizeWriteStream(FinalizeWriteStreamRequest request) {
    return finalizeWriteStreamCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Finalize a write stream so that no new data can be appended to the stream.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigQueryWriteClient bigQueryWriteClient = BigQueryWriteClient.create()) {
   *   FinalizeWriteStreamRequest request = FinalizeWriteStreamRequest.newBuilder().build();
   *   ApiFuture&lt;FinalizeWriteStreamResponse&gt; future = bigQueryWriteClient.finalizeWriteStreamCallable().futureCall(request);
   *   // Do something
   *   FinalizeWriteStreamResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<FinalizeWriteStreamRequest, FinalizeWriteStreamResponse>
      finalizeWriteStreamCallable() {
    return stub.finalizeWriteStreamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Atomically commits a group of `PENDING` streams that belong to the same `parent` table. Streams
   * must be finalized before commit and cannot be committed multiple times. Once a stream is
   * committed, data in the stream becomes available for read operations.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigQueryWriteClient bigQueryWriteClient = BigQueryWriteClient.create()) {
   *   BatchCommitWriteStreamsRequest request = BatchCommitWriteStreamsRequest.newBuilder().build();
   *   BatchCommitWriteStreamsResponse response = bigQueryWriteClient.batchCommitWriteStreams(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCommitWriteStreamsResponse batchCommitWriteStreams(
      BatchCommitWriteStreamsRequest request) {
    return batchCommitWriteStreamsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Atomically commits a group of `PENDING` streams that belong to the same `parent` table. Streams
   * must be finalized before commit and cannot be committed multiple times. Once a stream is
   * committed, data in the stream becomes available for read operations.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigQueryWriteClient bigQueryWriteClient = BigQueryWriteClient.create()) {
   *   BatchCommitWriteStreamsRequest request = BatchCommitWriteStreamsRequest.newBuilder().build();
   *   ApiFuture&lt;BatchCommitWriteStreamsResponse&gt; future = bigQueryWriteClient.batchCommitWriteStreamsCallable().futureCall(request);
   *   // Do something
   *   BatchCommitWriteStreamsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<BatchCommitWriteStreamsRequest, BatchCommitWriteStreamsResponse>
      batchCommitWriteStreamsCallable() {
    return stub.batchCommitWriteStreamsCallable();
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
