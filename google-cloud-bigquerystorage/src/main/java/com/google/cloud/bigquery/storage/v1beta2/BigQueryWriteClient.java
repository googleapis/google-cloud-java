/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.bigquery.storage.v1beta2;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.storage.v1beta2.stub.BigQueryWriteStub;
import com.google.cloud.bigquery.storage.v1beta2.stub.BigQueryWriteStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: BigQuery Write API.
 *
 * <p>The Write API can be used to write data to BigQuery.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (BigQueryWriteClient bigQueryWriteClient = BigQueryWriteClient.create()) {
 *   TableName parent = TableName.of("[PROJECT]", "[DATASET]", "[TABLE]");
 *   WriteStream writeStream = WriteStream.newBuilder().build();
 *   WriteStream response = bigQueryWriteClient.createWriteStream(parent, writeStream);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the BigQueryWriteClient object to clean up resources such
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
 * <pre>{@code
 * BigQueryWriteSettings bigQueryWriteSettings =
 *     BigQueryWriteSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * BigQueryWriteClient bigQueryWriteClient = BigQueryWriteClient.create(bigQueryWriteSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * BigQueryWriteSettings bigQueryWriteSettings =
 *     BigQueryWriteSettings.newBuilder().setEndpoint(myEndpoint).build();
 * BigQueryWriteClient bigQueryWriteClient = BigQueryWriteClient.create(bigQueryWriteSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
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
   * for advanced usage - prefer using create(BigQueryWriteSettings).
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a write stream to the given table. Additionally, every table has a special COMMITTED
   * stream named '_default' to which data can be written. This stream doesn't need to be created
   * using CreateWriteStream. It is a stream that can be used simultaneously by any number of
   * clients. Data written to this stream is considered committed as soon as an acknowledgement is
   * received.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (BigQueryWriteClient bigQueryWriteClient = BigQueryWriteClient.create()) {
   *   TableName parent = TableName.of("[PROJECT]", "[DATASET]", "[TABLE]");
   *   WriteStream writeStream = WriteStream.newBuilder().build();
   *   WriteStream response = bigQueryWriteClient.createWriteStream(parent, writeStream);
   * }
   * }</pre>
   *
   * @param parent Required. Reference to the table to which the stream belongs, in the format of
   *     `projects/{project}/datasets/{dataset}/tables/{table}`.
   * @param writeStream Required. Stream to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WriteStream createWriteStream(TableName parent, WriteStream writeStream) {
    CreateWriteStreamRequest request =
        CreateWriteStreamRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setWriteStream(writeStream)
            .build();
    return createWriteStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a write stream to the given table. Additionally, every table has a special COMMITTED
   * stream named '_default' to which data can be written. This stream doesn't need to be created
   * using CreateWriteStream. It is a stream that can be used simultaneously by any number of
   * clients. Data written to this stream is considered committed as soon as an acknowledgement is
   * received.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (BigQueryWriteClient bigQueryWriteClient = BigQueryWriteClient.create()) {
   *   String parent = TableName.of("[PROJECT]", "[DATASET]", "[TABLE]").toString();
   *   WriteStream writeStream = WriteStream.newBuilder().build();
   *   WriteStream response = bigQueryWriteClient.createWriteStream(parent, writeStream);
   * }
   * }</pre>
   *
   * @param parent Required. Reference to the table to which the stream belongs, in the format of
   *     `projects/{project}/datasets/{dataset}/tables/{table}`.
   * @param writeStream Required. Stream to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WriteStream createWriteStream(String parent, WriteStream writeStream) {
    CreateWriteStreamRequest request =
        CreateWriteStreamRequest.newBuilder().setParent(parent).setWriteStream(writeStream).build();
    return createWriteStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a write stream to the given table. Additionally, every table has a special COMMITTED
   * stream named '_default' to which data can be written. This stream doesn't need to be created
   * using CreateWriteStream. It is a stream that can be used simultaneously by any number of
   * clients. Data written to this stream is considered committed as soon as an acknowledgement is
   * received.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (BigQueryWriteClient bigQueryWriteClient = BigQueryWriteClient.create()) {
   *   CreateWriteStreamRequest request =
   *       CreateWriteStreamRequest.newBuilder()
   *           .setParent(TableName.of("[PROJECT]", "[DATASET]", "[TABLE]").toString())
   *           .setWriteStream(WriteStream.newBuilder().build())
   *           .build();
   *   WriteStream response = bigQueryWriteClient.createWriteStream(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WriteStream createWriteStream(CreateWriteStreamRequest request) {
    return createWriteStreamCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a write stream to the given table. Additionally, every table has a special COMMITTED
   * stream named '_default' to which data can be written. This stream doesn't need to be created
   * using CreateWriteStream. It is a stream that can be used simultaneously by any number of
   * clients. Data written to this stream is considered committed as soon as an acknowledgement is
   * received.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (BigQueryWriteClient bigQueryWriteClient = BigQueryWriteClient.create()) {
   *   CreateWriteStreamRequest request =
   *       CreateWriteStreamRequest.newBuilder()
   *           .setParent(TableName.of("[PROJECT]", "[DATASET]", "[TABLE]").toString())
   *           .setWriteStream(WriteStream.newBuilder().build())
   *           .build();
   *   ApiFuture<WriteStream> future =
   *       bigQueryWriteClient.createWriteStreamCallable().futureCall(request);
   *   // Do something.
   *   WriteStream response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateWriteStreamRequest, WriteStream> createWriteStreamCallable() {
    return stub.createWriteStreamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
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
   * <pre>{@code
   * try (BigQueryWriteClient bigQueryWriteClient = BigQueryWriteClient.create()) {
   *   BidiStream<AppendRowsRequest, AppendRowsResponse> bidiStream =
   *       bigQueryWriteClient.appendRowsCallable().call();
   *   AppendRowsRequest request =
   *       AppendRowsRequest.newBuilder()
   *           .setWriteStream(
   *               WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]").toString())
   *           .setOffset(Int64Value.newBuilder().build())
   *           .setTraceId("traceId-1067401920")
   *           .build();
   *   bidiStream.send(request);
   *   for (AppendRowsResponse response : bidiStream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final BidiStreamingCallable<AppendRowsRequest, AppendRowsResponse> appendRowsCallable() {
    return stub.appendRowsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a write stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (BigQueryWriteClient bigQueryWriteClient = BigQueryWriteClient.create()) {
   *   WriteStreamName name = WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]");
   *   WriteStream response = bigQueryWriteClient.getWriteStream(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the stream to get, in the form of
   *     `projects/{project}/datasets/{dataset}/tables/{table}/streams/{stream}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WriteStream getWriteStream(WriteStreamName name) {
    GetWriteStreamRequest request =
        GetWriteStreamRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getWriteStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a write stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (BigQueryWriteClient bigQueryWriteClient = BigQueryWriteClient.create()) {
   *   String name = WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]").toString();
   *   WriteStream response = bigQueryWriteClient.getWriteStream(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the stream to get, in the form of
   *     `projects/{project}/datasets/{dataset}/tables/{table}/streams/{stream}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WriteStream getWriteStream(String name) {
    GetWriteStreamRequest request = GetWriteStreamRequest.newBuilder().setName(name).build();
    return getWriteStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a write stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (BigQueryWriteClient bigQueryWriteClient = BigQueryWriteClient.create()) {
   *   GetWriteStreamRequest request =
   *       GetWriteStreamRequest.newBuilder()
   *           .setName(
   *               WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]").toString())
   *           .build();
   *   WriteStream response = bigQueryWriteClient.getWriteStream(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WriteStream getWriteStream(GetWriteStreamRequest request) {
    return getWriteStreamCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a write stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (BigQueryWriteClient bigQueryWriteClient = BigQueryWriteClient.create()) {
   *   GetWriteStreamRequest request =
   *       GetWriteStreamRequest.newBuilder()
   *           .setName(
   *               WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]").toString())
   *           .build();
   *   ApiFuture<WriteStream> future =
   *       bigQueryWriteClient.getWriteStreamCallable().futureCall(request);
   *   // Do something.
   *   WriteStream response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetWriteStreamRequest, WriteStream> getWriteStreamCallable() {
    return stub.getWriteStreamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Finalize a write stream so that no new data can be appended to the stream. Finalize is not
   * supported on the '_default' stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (BigQueryWriteClient bigQueryWriteClient = BigQueryWriteClient.create()) {
   *   WriteStreamName name = WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]");
   *   FinalizeWriteStreamResponse response = bigQueryWriteClient.finalizeWriteStream(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the stream to finalize, in the form of
   *     `projects/{project}/datasets/{dataset}/tables/{table}/streams/{stream}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FinalizeWriteStreamResponse finalizeWriteStream(WriteStreamName name) {
    FinalizeWriteStreamRequest request =
        FinalizeWriteStreamRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return finalizeWriteStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Finalize a write stream so that no new data can be appended to the stream. Finalize is not
   * supported on the '_default' stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (BigQueryWriteClient bigQueryWriteClient = BigQueryWriteClient.create()) {
   *   String name = WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]").toString();
   *   FinalizeWriteStreamResponse response = bigQueryWriteClient.finalizeWriteStream(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the stream to finalize, in the form of
   *     `projects/{project}/datasets/{dataset}/tables/{table}/streams/{stream}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FinalizeWriteStreamResponse finalizeWriteStream(String name) {
    FinalizeWriteStreamRequest request =
        FinalizeWriteStreamRequest.newBuilder().setName(name).build();
    return finalizeWriteStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Finalize a write stream so that no new data can be appended to the stream. Finalize is not
   * supported on the '_default' stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (BigQueryWriteClient bigQueryWriteClient = BigQueryWriteClient.create()) {
   *   FinalizeWriteStreamRequest request =
   *       FinalizeWriteStreamRequest.newBuilder()
   *           .setName(
   *               WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]").toString())
   *           .build();
   *   FinalizeWriteStreamResponse response = bigQueryWriteClient.finalizeWriteStream(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FinalizeWriteStreamResponse finalizeWriteStream(FinalizeWriteStreamRequest request) {
    return finalizeWriteStreamCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Finalize a write stream so that no new data can be appended to the stream. Finalize is not
   * supported on the '_default' stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (BigQueryWriteClient bigQueryWriteClient = BigQueryWriteClient.create()) {
   *   FinalizeWriteStreamRequest request =
   *       FinalizeWriteStreamRequest.newBuilder()
   *           .setName(
   *               WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]").toString())
   *           .build();
   *   ApiFuture<FinalizeWriteStreamResponse> future =
   *       bigQueryWriteClient.finalizeWriteStreamCallable().futureCall(request);
   *   // Do something.
   *   FinalizeWriteStreamResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<FinalizeWriteStreamRequest, FinalizeWriteStreamResponse>
      finalizeWriteStreamCallable() {
    return stub.finalizeWriteStreamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Atomically commits a group of `PENDING` streams that belong to the same `parent` table. Streams
   * must be finalized before commit and cannot be committed multiple times. Once a stream is
   * committed, data in the stream becomes available for read operations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (BigQueryWriteClient bigQueryWriteClient = BigQueryWriteClient.create()) {
   *   String parent = "parent-995424086";
   *   BatchCommitWriteStreamsResponse response =
   *       bigQueryWriteClient.batchCommitWriteStreams(parent);
   * }
   * }</pre>
   *
   * @param parent Required. Parent table that all the streams should belong to, in the form of
   *     `projects/{project}/datasets/{dataset}/tables/{table}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCommitWriteStreamsResponse batchCommitWriteStreams(String parent) {
    BatchCommitWriteStreamsRequest request =
        BatchCommitWriteStreamsRequest.newBuilder().setParent(parent).build();
    return batchCommitWriteStreams(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Atomically commits a group of `PENDING` streams that belong to the same `parent` table. Streams
   * must be finalized before commit and cannot be committed multiple times. Once a stream is
   * committed, data in the stream becomes available for read operations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (BigQueryWriteClient bigQueryWriteClient = BigQueryWriteClient.create()) {
   *   BatchCommitWriteStreamsRequest request =
   *       BatchCommitWriteStreamsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllWriteStreams(new ArrayList<String>())
   *           .build();
   *   BatchCommitWriteStreamsResponse response =
   *       bigQueryWriteClient.batchCommitWriteStreams(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCommitWriteStreamsResponse batchCommitWriteStreams(
      BatchCommitWriteStreamsRequest request) {
    return batchCommitWriteStreamsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Atomically commits a group of `PENDING` streams that belong to the same `parent` table. Streams
   * must be finalized before commit and cannot be committed multiple times. Once a stream is
   * committed, data in the stream becomes available for read operations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (BigQueryWriteClient bigQueryWriteClient = BigQueryWriteClient.create()) {
   *   BatchCommitWriteStreamsRequest request =
   *       BatchCommitWriteStreamsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllWriteStreams(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchCommitWriteStreamsResponse> future =
   *       bigQueryWriteClient.batchCommitWriteStreamsCallable().futureCall(request);
   *   // Do something.
   *   BatchCommitWriteStreamsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchCommitWriteStreamsRequest, BatchCommitWriteStreamsResponse>
      batchCommitWriteStreamsCallable() {
    return stub.batchCommitWriteStreamsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Flushes rows to a BUFFERED stream. If users are appending rows to BUFFERED stream, flush
   * operation is required in order for the rows to become available for reading. A Flush operation
   * flushes up to any previously flushed offset in a BUFFERED stream, to the offset specified in
   * the request. Flush is not supported on the _default stream, since it is not BUFFERED.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (BigQueryWriteClient bigQueryWriteClient = BigQueryWriteClient.create()) {
   *   WriteStreamName writeStream =
   *       WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]");
   *   FlushRowsResponse response = bigQueryWriteClient.flushRows(writeStream);
   * }
   * }</pre>
   *
   * @param writeStream Required. The stream that is the target of the flush operation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FlushRowsResponse flushRows(WriteStreamName writeStream) {
    FlushRowsRequest request =
        FlushRowsRequest.newBuilder()
            .setWriteStream(writeStream == null ? null : writeStream.toString())
            .build();
    return flushRows(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Flushes rows to a BUFFERED stream. If users are appending rows to BUFFERED stream, flush
   * operation is required in order for the rows to become available for reading. A Flush operation
   * flushes up to any previously flushed offset in a BUFFERED stream, to the offset specified in
   * the request. Flush is not supported on the _default stream, since it is not BUFFERED.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (BigQueryWriteClient bigQueryWriteClient = BigQueryWriteClient.create()) {
   *   String writeStream =
   *       WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]").toString();
   *   FlushRowsResponse response = bigQueryWriteClient.flushRows(writeStream);
   * }
   * }</pre>
   *
   * @param writeStream Required. The stream that is the target of the flush operation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FlushRowsResponse flushRows(String writeStream) {
    FlushRowsRequest request = FlushRowsRequest.newBuilder().setWriteStream(writeStream).build();
    return flushRows(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Flushes rows to a BUFFERED stream. If users are appending rows to BUFFERED stream, flush
   * operation is required in order for the rows to become available for reading. A Flush operation
   * flushes up to any previously flushed offset in a BUFFERED stream, to the offset specified in
   * the request. Flush is not supported on the _default stream, since it is not BUFFERED.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (BigQueryWriteClient bigQueryWriteClient = BigQueryWriteClient.create()) {
   *   FlushRowsRequest request =
   *       FlushRowsRequest.newBuilder()
   *           .setWriteStream(
   *               WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]").toString())
   *           .setOffset(Int64Value.newBuilder().build())
   *           .build();
   *   FlushRowsResponse response = bigQueryWriteClient.flushRows(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FlushRowsResponse flushRows(FlushRowsRequest request) {
    return flushRowsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Flushes rows to a BUFFERED stream. If users are appending rows to BUFFERED stream, flush
   * operation is required in order for the rows to become available for reading. A Flush operation
   * flushes up to any previously flushed offset in a BUFFERED stream, to the offset specified in
   * the request. Flush is not supported on the _default stream, since it is not BUFFERED.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (BigQueryWriteClient bigQueryWriteClient = BigQueryWriteClient.create()) {
   *   FlushRowsRequest request =
   *       FlushRowsRequest.newBuilder()
   *           .setWriteStream(
   *               WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]").toString())
   *           .setOffset(Int64Value.newBuilder().build())
   *           .build();
   *   ApiFuture<FlushRowsResponse> future =
   *       bigQueryWriteClient.flushRowsCallable().futureCall(request);
   *   // Do something.
   *   FlushRowsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<FlushRowsRequest, FlushRowsResponse> flushRowsCallable() {
    return stub.flushRowsCallable();
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
