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

package com.google.cloud.bigquery.storage.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.storage.v1.stub.BigQueryReadStub;
import com.google.cloud.bigquery.storage.v1.stub.BigQueryReadStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: BigQuery Read API.
 *
 * <p>The Read API can be used to read data from BigQuery.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <p>Note: close() needs to be called on the BaseBigQueryReadClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of BaseBigQueryReadSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * BaseBigQueryReadSettings baseBigQueryReadSettings =
 *     BaseBigQueryReadSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * BaseBigQueryReadClient baseBigQueryReadClient =
 *     BaseBigQueryReadClient.create(baseBigQueryReadSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * BaseBigQueryReadSettings baseBigQueryReadSettings =
 *     BaseBigQueryReadSettings.newBuilder().setEndpoint(myEndpoint).build();
 * BaseBigQueryReadClient baseBigQueryReadClient =
 *     BaseBigQueryReadClient.create(baseBigQueryReadSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class BaseBigQueryReadClient implements BackgroundResource {
  private final BaseBigQueryReadSettings settings;
  private final BigQueryReadStub stub;

  /** Constructs an instance of BaseBigQueryReadClient with default settings. */
  public static final BaseBigQueryReadClient create() throws IOException {
    return create(BaseBigQueryReadSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of BaseBigQueryReadClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final BaseBigQueryReadClient create(BaseBigQueryReadSettings settings)
      throws IOException {
    return new BaseBigQueryReadClient(settings);
  }

  /**
   * Constructs an instance of BaseBigQueryReadClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(BaseBigQueryReadSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final BaseBigQueryReadClient create(BigQueryReadStub stub) {
    return new BaseBigQueryReadClient(stub);
  }

  /**
   * Constructs an instance of BaseBigQueryReadClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected BaseBigQueryReadClient(BaseBigQueryReadSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((BigQueryReadStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected BaseBigQueryReadClient(BigQueryReadStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final BaseBigQueryReadSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public BigQueryReadStub getStub() {
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
   * <p>Data is assigned to each stream such that roughly the same number of rows can be read from
   * each stream. Because the server-side unit for assigning data is collections of rows, the API
   * does not guarantee that each stream will return the same number or rows. Additionally, the
   * limits are enforced based on the number of pre-filtered rows, so some filters can lead to
   * lopsided assignments.
   *
   * <p>Read sessions automatically expire 24 hours after they are created and do not require manual
   * clean-up by the caller.
   *
   * @param parent Required. The request project that owns the session, in the form of
   *     `projects/{project_id}`.
   * @param readSession Required. Session to be created.
   * @param maxStreamCount Max initial number of streams. If unset or zero, the server will provide
   *     a value of streams so as to produce reasonable throughput. Must be non-negative. The number
   *     of streams may be lower than the requested number, depending on the amount parallelism that
   *     is reasonable for the table. Error will be returned if the max count is greater than the
   *     current system max limit of 1,000.
   *     <p>Streams must be read starting from offset 0.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReadSession createReadSession(
      ProjectName parent, ReadSession readSession, int maxStreamCount) {
    CreateReadSessionRequest request =
        CreateReadSessionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setReadSession(readSession)
            .setMaxStreamCount(maxStreamCount)
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
   * <p>Data is assigned to each stream such that roughly the same number of rows can be read from
   * each stream. Because the server-side unit for assigning data is collections of rows, the API
   * does not guarantee that each stream will return the same number or rows. Additionally, the
   * limits are enforced based on the number of pre-filtered rows, so some filters can lead to
   * lopsided assignments.
   *
   * <p>Read sessions automatically expire 24 hours after they are created and do not require manual
   * clean-up by the caller.
   *
   * @param parent Required. The request project that owns the session, in the form of
   *     `projects/{project_id}`.
   * @param readSession Required. Session to be created.
   * @param maxStreamCount Max initial number of streams. If unset or zero, the server will provide
   *     a value of streams so as to produce reasonable throughput. Must be non-negative. The number
   *     of streams may be lower than the requested number, depending on the amount parallelism that
   *     is reasonable for the table. Error will be returned if the max count is greater than the
   *     current system max limit of 1,000.
   *     <p>Streams must be read starting from offset 0.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReadSession createReadSession(
      String parent, ReadSession readSession, int maxStreamCount) {
    CreateReadSessionRequest request =
        CreateReadSessionRequest.newBuilder()
            .setParent(parent)
            .setReadSession(readSession)
            .setMaxStreamCount(maxStreamCount)
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
   * <p>Data is assigned to each stream such that roughly the same number of rows can be read from
   * each stream. Because the server-side unit for assigning data is collections of rows, the API
   * does not guarantee that each stream will return the same number or rows. Additionally, the
   * limits are enforced based on the number of pre-filtered rows, so some filters can lead to
   * lopsided assignments.
   *
   * <p>Read sessions automatically expire 24 hours after they are created and do not require manual
   * clean-up by the caller.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReadSession createReadSession(CreateReadSessionRequest request) {
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
   * <p>Data is assigned to each stream such that roughly the same number of rows can be read from
   * each stream. Because the server-side unit for assigning data is collections of rows, the API
   * does not guarantee that each stream will return the same number or rows. Additionally, the
   * limits are enforced based on the number of pre-filtered rows, so some filters can lead to
   * lopsided assignments.
   *
   * <p>Read sessions automatically expire 24 hours after they are created and do not require manual
   * clean-up by the caller.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateReadSessionRequest, ReadSession> createReadSessionCallable() {
    return stub.createReadSessionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reads rows from the stream in the format prescribed by the ReadSession. Each response contains
   * one or more table rows, up to a maximum of 100 MiB per response; read requests which attempt to
   * read individual rows larger than 100 MiB will fail.
   *
   * <p>Each request also returns a set of stream statistics reflecting the current state of the
   * stream.
   *
   * <p>Sample code:
   */
  public final ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> readRowsCallable() {
    return stub.readRowsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Splits a given `ReadStream` into two `ReadStream` objects. These `ReadStream` objects are
   * referred to as the primary and the residual streams of the split. The original `ReadStream` can
   * still be read from in the same manner as before. Both of the returned `ReadStream` objects can
   * also be read from, and the rows returned by both child streams will be the same as the rows
   * read from the original stream.
   *
   * <p>Moreover, the two child streams will be allocated back-to-back in the original `ReadStream`.
   * Concretely, it is guaranteed that for streams original, primary, and residual, that
   * original[0-j] = primary[0-j] and original[j-n] = residual[0-m] once the streams have been read
   * to completion.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SplitReadStreamResponse splitReadStream(SplitReadStreamRequest request) {
    return splitReadStreamCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Splits a given `ReadStream` into two `ReadStream` objects. These `ReadStream` objects are
   * referred to as the primary and the residual streams of the split. The original `ReadStream` can
   * still be read from in the same manner as before. Both of the returned `ReadStream` objects can
   * also be read from, and the rows returned by both child streams will be the same as the rows
   * read from the original stream.
   *
   * <p>Moreover, the two child streams will be allocated back-to-back in the original `ReadStream`.
   * Concretely, it is guaranteed that for streams original, primary, and residual, that
   * original[0-j] = primary[0-j] and original[j-n] = residual[0-m] once the streams have been read
   * to completion.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<SplitReadStreamRequest, SplitReadStreamResponse>
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
