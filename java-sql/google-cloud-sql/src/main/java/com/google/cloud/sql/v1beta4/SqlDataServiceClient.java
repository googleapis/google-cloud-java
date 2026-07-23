/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.sql.v1beta4;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.cloud.sql.v1beta4.stub.SqlDataServiceStub;
import com.google.cloud.sql.v1beta4.stub.SqlDataServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for streaming data to and from Cloud SQL instances.
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
 * try (SqlDataServiceClient sqlDataServiceClient = SqlDataServiceClient.create()) {
 *   BidiStream<StreamSqlDataRequest, StreamSqlDataResponse> bidiStream =
 *       sqlDataServiceClient.streamSqlDataCallable().call();
 *   StreamSqlDataRequest request =
 *       StreamSqlDataRequest.newBuilder()
 *           .setAck(Ack.newBuilder().build())
 *           .setInstanceId(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
 *           .build();
 *   bidiStream.send(request);
 *   for (StreamSqlDataResponse response : bidiStream) {
 *     // Do something when a response is received.
 *   }
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SqlDataServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> StreamSqlData</td>
 *      <td><p> `StreamSqlData` establishes a bidirectional stream to a Cloud SQL instance, and then streams data to and from the instance.
 * <p>  The first message from the client MUST be a `StreamSqlDataRequest` request with configuration settings, including required values for the `connection_settings` field. Subsequent messages from the client may contain the `payload` field.
 * <p>  Messages from the server may contain the `payload` field.
 * <p>  The `payload` fields of the request and response streams contain the raw data of the database's native wire protocol (e.g., PostgreSQL wire protocol). The database client is responsible for generating and parsing this data.
 * <p>  Any errors on initial connection (e.g., connection failure, authorization issues, network problems) will result in the stream being terminated with an appropriate RPC status exception.
 * <p>  After a successful connection is made, if an error occurs, then the server terminates connection and returns the appropriate RPC status exception.
 * <p>  Add the request params headers to the request to ensure that the streaming request is routed to the correct service for your database.
 * <p>  Use this format for the request params header:
 * <p>     `x-goog-request-params`:        location_id={location_path}&amp;instance_id={instance_path}`
 * <p>   `location_path` is `locations/{location_name}`  `instance_path` is `projects/{project_name}/instances/{instance_name}`
 * <p>  for example:     `x-goog-request-params`:     `location_id=locations/us-central1&amp;instance_id=projects/myproject/instances/instancename`</td>
 *      <td>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> streamSqlDataCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of SqlDataServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SqlDataServiceSettings sqlDataServiceSettings =
 *     SqlDataServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SqlDataServiceClient sqlDataServiceClient = SqlDataServiceClient.create(sqlDataServiceSettings);
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
 * SqlDataServiceSettings sqlDataServiceSettings =
 *     SqlDataServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SqlDataServiceClient sqlDataServiceClient = SqlDataServiceClient.create(sqlDataServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class SqlDataServiceClient implements BackgroundResource {
  private final @Nullable SqlDataServiceSettings settings;
  private final SqlDataServiceStub stub;

  /** Constructs an instance of SqlDataServiceClient with default settings. */
  public static final SqlDataServiceClient create() throws IOException {
    return create(SqlDataServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SqlDataServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SqlDataServiceClient create(SqlDataServiceSettings settings)
      throws IOException {
    return new SqlDataServiceClient(settings);
  }

  /**
   * Constructs an instance of SqlDataServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(SqlDataServiceSettings).
   */
  public static final SqlDataServiceClient create(SqlDataServiceStub stub) {
    return new SqlDataServiceClient(stub);
  }

  /**
   * Constructs an instance of SqlDataServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected SqlDataServiceClient(SqlDataServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SqlDataServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected SqlDataServiceClient(SqlDataServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable SqlDataServiceSettings getSettings() {
    return settings;
  }

  public SqlDataServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * `StreamSqlData` establishes a bidirectional stream to a Cloud SQL instance, and then streams
   * data to and from the instance.
   *
   * <p>The first message from the client MUST be a `StreamSqlDataRequest` request with
   * configuration settings, including required values for the `connection_settings` field.
   * Subsequent messages from the client may contain the `payload` field.
   *
   * <p>Messages from the server may contain the `payload` field.
   *
   * <p>The `payload` fields of the request and response streams contain the raw data of the
   * database's native wire protocol (e.g., PostgreSQL wire protocol). The database client is
   * responsible for generating and parsing this data.
   *
   * <p>Any errors on initial connection (e.g., connection failure, authorization issues, network
   * problems) will result in the stream being terminated with an appropriate RPC status exception.
   *
   * <p>After a successful connection is made, if an error occurs, then the server terminates
   * connection and returns the appropriate RPC status exception.
   *
   * <p>Add the request params headers to the request to ensure that the streaming request is routed
   * to the correct service for your database.
   *
   * <p>Use this format for the request params header:
   *
   * <p>`x-goog-request-params`: location_id={location_path}&amp;instance_id={instance_path}`
   *
   * <p>`location_path` is `locations/{location_name}` `instance_path` is
   * `projects/{project_name}/instances/{instance_name}`
   *
   * <p>for example: `x-goog-request-params`:
   * `location_id=locations/us-central1&amp;instance_id=projects/myproject/instances/instancename`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlDataServiceClient sqlDataServiceClient = SqlDataServiceClient.create()) {
   *   BidiStream<StreamSqlDataRequest, StreamSqlDataResponse> bidiStream =
   *       sqlDataServiceClient.streamSqlDataCallable().call();
   *   StreamSqlDataRequest request =
   *       StreamSqlDataRequest.newBuilder()
   *           .setAck(Ack.newBuilder().build())
   *           .setInstanceId(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .build();
   *   bidiStream.send(request);
   *   for (StreamSqlDataResponse response : bidiStream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final BidiStreamingCallable<StreamSqlDataRequest, StreamSqlDataResponse>
      streamSqlDataCallable() {
    return stub.streamSqlDataCallable();
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
