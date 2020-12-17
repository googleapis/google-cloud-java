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

package com.google.cloud.bigquery.storage.v1beta1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.storage.v1beta1.stub.BigQueryStorageStub;
import com.google.cloud.bigquery.storage.v1beta1.stub.BigQueryStorageStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: BigQuery storage API.
 *
 * <p>The BigQuery storage API can be used to read data stored in BigQuery.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <p>Note: close() needs to be called on the BaseBigQueryStorageClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
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
 * <p>This class can be customized by passing in a custom instance of BaseBigQueryStorageSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * BaseBigQueryStorageSettings baseBigQueryStorageSettings =
 *     BaseBigQueryStorageSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * BaseBigQueryStorageClient baseBigQueryStorageClient =
 *     BaseBigQueryStorageClient.create(baseBigQueryStorageSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * BaseBigQueryStorageSettings baseBigQueryStorageSettings =
 *     BaseBigQueryStorageSettings.newBuilder().setEndpoint(myEndpoint).build();
 * BaseBigQueryStorageClient baseBigQueryStorageClient =
 *     BaseBigQueryStorageClient.create(baseBigQueryStorageSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator")
public class BaseBigQueryStorageClient implements BackgroundResource {
  private final BaseBigQueryStorageSettings settings;
  private final BigQueryStorageStub stub;

  /** Constructs an instance of BaseBigQueryStorageClient with default settings. */
  public static final BaseBigQueryStorageClient create() throws IOException {
    return create(BaseBigQueryStorageSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of BaseBigQueryStorageClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final BaseBigQueryStorageClient create(BaseBigQueryStorageSettings settings)
      throws IOException {
    return new BaseBigQueryStorageClient(settings);
  }

  /**
   * Constructs an instance of BaseBigQueryStorageClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(BaseBigQueryStorageSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final BaseBigQueryStorageClient create(BigQueryStorageStub stub) {
    return new BaseBigQueryStorageClient(stub);
  }

  /**
   * Constructs an instance of BaseBigQueryStorageClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected BaseBigQueryStorageClient(BaseBigQueryStorageSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((BigQueryStorageStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected BaseBigQueryStorageClient(BigQueryStorageStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final BaseBigQueryStorageSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public BigQueryStorageStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new read session. A read session divides the contents of a BigQuery table into one or
   * more streams, which can then be used to read data from the table. The read session also
   * specifies properties of the data to be read, such as a list of columns or a push-down filter
   * describing the rows to be returned.
   *
   * <p>A particular row can be read by at most one stream. When the caller has reached the end of
   * each stream in the session, then all the data in the table has been read.
   *
   * <p>Read sessions automatically expire 24 hours after they are created and do not require manual
   * clean-up by the caller.
   *
   * @param tableReference Required. Reference to the table to read.
   * @param parent Required. String of the form `projects/{project_id}` indicating the project this
   *     ReadSession is associated with. This is the project that will be billed for usage.
   * @param requestedStreams Initial number of streams. If unset or 0, we will provide a value of
   *     streams so as to produce reasonable throughput. Must be non-negative. The number of streams
   *     may be lower than the requested number, depending on the amount parallelism that is
   *     reasonable for the table and the maximum amount of parallelism allowed by the system.
   *     <p>Streams must be read starting from offset 0.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Storage.ReadSession createReadSession(
      TableReferenceProto.TableReference tableReference, ProjectName parent, int requestedStreams) {
    Storage.CreateReadSessionRequest request =
        Storage.CreateReadSessionRequest.newBuilder()
            .setTableReference(tableReference)
            .setParent(parent == null ? null : parent.toString())
            .setRequestedStreams(requestedStreams)
            .build();
    return createReadSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new read session. A read session divides the contents of a BigQuery table into one or
   * more streams, which can then be used to read data from the table. The read session also
   * specifies properties of the data to be read, such as a list of columns or a push-down filter
   * describing the rows to be returned.
   *
   * <p>A particular row can be read by at most one stream. When the caller has reached the end of
   * each stream in the session, then all the data in the table has been read.
   *
   * <p>Read sessions automatically expire 24 hours after they are created and do not require manual
   * clean-up by the caller.
   *
   * @param tableReference Required. Reference to the table to read.
   * @param parent Required. String of the form `projects/{project_id}` indicating the project this
   *     ReadSession is associated with. This is the project that will be billed for usage.
   * @param requestedStreams Initial number of streams. If unset or 0, we will provide a value of
   *     streams so as to produce reasonable throughput. Must be non-negative. The number of streams
   *     may be lower than the requested number, depending on the amount parallelism that is
   *     reasonable for the table and the maximum amount of parallelism allowed by the system.
   *     <p>Streams must be read starting from offset 0.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Storage.ReadSession createReadSession(
      TableReferenceProto.TableReference tableReference, String parent, int requestedStreams) {
    Storage.CreateReadSessionRequest request =
        Storage.CreateReadSessionRequest.newBuilder()
            .setTableReference(tableReference)
            .setParent(parent)
            .setRequestedStreams(requestedStreams)
            .build();
    return createReadSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new read session. A read session divides the contents of a BigQuery table into one or
   * more streams, which can then be used to read data from the table. The read session also
   * specifies properties of the data to be read, such as a list of columns or a push-down filter
   * describing the rows to be returned.
   *
   * <p>A particular row can be read by at most one stream. When the caller has reached the end of
   * each stream in the session, then all the data in the table has been read.
   *
   * <p>Read sessions automatically expire 24 hours after they are created and do not require manual
   * clean-up by the caller.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Storage.ReadSession createReadSession(Storage.CreateReadSessionRequest request) {
    return createReadSessionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new read session. A read session divides the contents of a BigQuery table into one or
   * more streams, which can then be used to read data from the table. The read session also
   * specifies properties of the data to be read, such as a list of columns or a push-down filter
   * describing the rows to be returned.
   *
   * <p>A particular row can be read by at most one stream. When the caller has reached the end of
   * each stream in the session, then all the data in the table has been read.
   *
   * <p>Read sessions automatically expire 24 hours after they are created and do not require manual
   * clean-up by the caller.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<Storage.CreateReadSessionRequest, Storage.ReadSession>
      createReadSessionCallable() {
    return stub.createReadSessionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reads rows from the table in the format prescribed by the read session. Each response contains
   * one or more table rows, up to a maximum of 10 MiB per response; read requests which attempt to
   * read individual rows larger than this will fail.
   *
   * <p>Each request also returns a set of stream statistics reflecting the estimated total number
   * of rows in the read stream. This number is computed based on the total table size and the
   * number of active streams in the read session, and may change as other streams continue to read
   * data.
   *
   * <p>Sample code:
   */
  public final ServerStreamingCallable<Storage.ReadRowsRequest, Storage.ReadRowsResponse>
      readRowsCallable() {
    return stub.readRowsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates additional streams for a ReadSession. This API can be used to dynamically adjust the
   * parallelism of a batch processing task upwards by adding additional workers.
   *
   * @param session Required. Must be a non-expired session obtained from a call to
   *     CreateReadSession. Only the name field needs to be set.
   * @param requestedStreams Required. Number of new streams requested. Must be positive. Number of
   *     added streams may be less than this, see CreateReadSessionRequest for more information.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Storage.BatchCreateReadSessionStreamsResponse batchCreateReadSessionStreams(
      Storage.ReadSession session, int requestedStreams) {
    Storage.BatchCreateReadSessionStreamsRequest request =
        Storage.BatchCreateReadSessionStreamsRequest.newBuilder()
            .setSession(session)
            .setRequestedStreams(requestedStreams)
            .build();
    return batchCreateReadSessionStreams(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates additional streams for a ReadSession. This API can be used to dynamically adjust the
   * parallelism of a batch processing task upwards by adding additional workers.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Storage.BatchCreateReadSessionStreamsResponse batchCreateReadSessionStreams(
      Storage.BatchCreateReadSessionStreamsRequest request) {
    return batchCreateReadSessionStreamsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates additional streams for a ReadSession. This API can be used to dynamically adjust the
   * parallelism of a batch processing task upwards by adding additional workers.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<
          Storage.BatchCreateReadSessionStreamsRequest,
          Storage.BatchCreateReadSessionStreamsResponse>
      batchCreateReadSessionStreamsCallable() {
    return stub.batchCreateReadSessionStreamsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Triggers the graceful termination of a single stream in a ReadSession. This API can be used to
   * dynamically adjust the parallelism of a batch processing task downwards without losing data.
   *
   * <p>This API does not delete the stream -- it remains visible in the ReadSession, and any data
   * processed by the stream is not released to other streams. However, no additional data will be
   * assigned to the stream once this call completes. Callers must continue reading data on the
   * stream until the end of the stream is reached so that data which has already been assigned to
   * the stream will be processed.
   *
   * <p>This method will return an error if there are no other live streams in the Session, or if
   * SplitReadStream() has been called on the given Stream.
   *
   * @param stream Required. Stream to finalize.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void finalizeStream(Storage.Stream stream) {
    Storage.FinalizeStreamRequest request =
        Storage.FinalizeStreamRequest.newBuilder().setStream(stream).build();
    finalizeStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Triggers the graceful termination of a single stream in a ReadSession. This API can be used to
   * dynamically adjust the parallelism of a batch processing task downwards without losing data.
   *
   * <p>This API does not delete the stream -- it remains visible in the ReadSession, and any data
   * processed by the stream is not released to other streams. However, no additional data will be
   * assigned to the stream once this call completes. Callers must continue reading data on the
   * stream until the end of the stream is reached so that data which has already been assigned to
   * the stream will be processed.
   *
   * <p>This method will return an error if there are no other live streams in the Session, or if
   * SplitReadStream() has been called on the given Stream.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void finalizeStream(Storage.FinalizeStreamRequest request) {
    finalizeStreamCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Triggers the graceful termination of a single stream in a ReadSession. This API can be used to
   * dynamically adjust the parallelism of a batch processing task downwards without losing data.
   *
   * <p>This API does not delete the stream -- it remains visible in the ReadSession, and any data
   * processed by the stream is not released to other streams. However, no additional data will be
   * assigned to the stream once this call completes. Callers must continue reading data on the
   * stream until the end of the stream is reached so that data which has already been assigned to
   * the stream will be processed.
   *
   * <p>This method will return an error if there are no other live streams in the Session, or if
   * SplitReadStream() has been called on the given Stream.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<Storage.FinalizeStreamRequest, Empty> finalizeStreamCallable() {
    return stub.finalizeStreamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Splits a given read stream into two Streams. These streams are referred to as the primary and
   * the residual of the split. The original stream can still be read from in the same manner as
   * before. Both of the returned streams can also be read from, and the total rows return by both
   * child streams will be the same as the rows read from the original stream.
   *
   * <p>Moreover, the two child streams will be allocated back to back in the original Stream.
   * Concretely, it is guaranteed that for streams Original, Primary, and Residual, that
   * Original[0-j] = Primary[0-j] and Original[j-n] = Residual[0-m] once the streams have been read
   * to completion.
   *
   * <p>This method is guaranteed to be idempotent.
   *
   * @param originalStream Required. Stream to split.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Storage.SplitReadStreamResponse splitReadStream(Storage.Stream originalStream) {
    Storage.SplitReadStreamRequest request =
        Storage.SplitReadStreamRequest.newBuilder().setOriginalStream(originalStream).build();
    return splitReadStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Splits a given read stream into two Streams. These streams are referred to as the primary and
   * the residual of the split. The original stream can still be read from in the same manner as
   * before. Both of the returned streams can also be read from, and the total rows return by both
   * child streams will be the same as the rows read from the original stream.
   *
   * <p>Moreover, the two child streams will be allocated back to back in the original Stream.
   * Concretely, it is guaranteed that for streams Original, Primary, and Residual, that
   * Original[0-j] = Primary[0-j] and Original[j-n] = Residual[0-m] once the streams have been read
   * to completion.
   *
   * <p>This method is guaranteed to be idempotent.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Storage.SplitReadStreamResponse splitReadStream(
      Storage.SplitReadStreamRequest request) {
    return splitReadStreamCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Splits a given read stream into two Streams. These streams are referred to as the primary and
   * the residual of the split. The original stream can still be read from in the same manner as
   * before. Both of the returned streams can also be read from, and the total rows return by both
   * child streams will be the same as the rows read from the original stream.
   *
   * <p>Moreover, the two child streams will be allocated back to back in the original Stream.
   * Concretely, it is guaranteed that for streams Original, Primary, and Residual, that
   * Original[0-j] = Primary[0-j] and Original[j-n] = Residual[0-m] once the streams have been read
   * to completion.
   *
   * <p>This method is guaranteed to be idempotent.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<Storage.SplitReadStreamRequest, Storage.SplitReadStreamResponse>
      splitReadStreamCallable() {
    return stub.splitReadStreamCallable();
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
