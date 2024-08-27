/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.bigquery.storage.v1alpha;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.storage.v1alpha.stub.MetastorePartitionServiceStub;
import com.google.cloud.bigquery.storage.v1alpha.stub.MetastorePartitionServiceStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: BigQuery Metastore Partition Service API. This service is used for managing
 * metastore partitions in BigQuery metastore. The service supports only batch operations for write.
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
 * try (MetastorePartitionServiceClient metastorePartitionServiceClient =
 *     MetastorePartitionServiceClient.create()) {
 *   BatchCreateMetastorePartitionsRequest request =
 *       BatchCreateMetastorePartitionsRequest.newBuilder()
 *           .setParent(TableName.of("[PROJECT]", "[DATASET]", "[TABLE]").toString())
 *           .addAllRequests(new ArrayList<CreateMetastorePartitionRequest>())
 *           .setSkipExistingPartitions(true)
 *           .build();
 *   BatchCreateMetastorePartitionsResponse response =
 *       metastorePartitionServiceClient.batchCreateMetastorePartitions(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the MetastorePartitionServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreateMetastorePartitions</td>
 *      <td><p> Adds metastore partitions to a table.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateMetastorePartitions(BatchCreateMetastorePartitionsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateMetastorePartitionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchDeleteMetastorePartitions</td>
 *      <td><p> Deletes metastore partitions from a table.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchDeleteMetastorePartitions(BatchDeleteMetastorePartitionsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchDeleteMetastorePartitionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUpdateMetastorePartitions</td>
 *      <td><p> Updates metastore partitions in a table.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUpdateMetastorePartitions(BatchUpdateMetastorePartitionsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUpdateMetastorePartitionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListMetastorePartitions</td>
 *      <td><p> Gets metastore partitions from a table.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMetastorePartitions(ListMetastorePartitionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listMetastorePartitions(TableName parent)
 *           <li><p> listMetastorePartitions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listMetastorePartitionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> StreamMetastorePartitions</td>
 *      <td><p> This is a bi-di streaming rpc method that allows the client to send a stream of partitions and commit all of them atomically at the end. If the commit is successful, the server will return a response and close the stream. If the commit fails (due to duplicate partitions or other reason), the server will close the stream with an error. This method is only available via the gRPC API (not REST).</td>
 *      <td>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> streamMetastorePartitionsCallable()
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
 * <p>This class can be customized by passing in a custom instance of
 * MetastorePartitionServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MetastorePartitionServiceSettings metastorePartitionServiceSettings =
 *     MetastorePartitionServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * MetastorePartitionServiceClient metastorePartitionServiceClient =
 *     MetastorePartitionServiceClient.create(metastorePartitionServiceSettings);
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
 * MetastorePartitionServiceSettings metastorePartitionServiceSettings =
 *     MetastorePartitionServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * MetastorePartitionServiceClient metastorePartitionServiceClient =
 *     MetastorePartitionServiceClient.create(metastorePartitionServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class MetastorePartitionServiceClient implements BackgroundResource {
  private final MetastorePartitionServiceSettings settings;
  private final MetastorePartitionServiceStub stub;

  /** Constructs an instance of MetastorePartitionServiceClient with default settings. */
  public static final MetastorePartitionServiceClient create() throws IOException {
    return create(MetastorePartitionServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of MetastorePartitionServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final MetastorePartitionServiceClient create(
      MetastorePartitionServiceSettings settings) throws IOException {
    return new MetastorePartitionServiceClient(settings);
  }

  /**
   * Constructs an instance of MetastorePartitionServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(MetastorePartitionServiceSettings).
   */
  public static final MetastorePartitionServiceClient create(MetastorePartitionServiceStub stub) {
    return new MetastorePartitionServiceClient(stub);
  }

  /**
   * Constructs an instance of MetastorePartitionServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected MetastorePartitionServiceClient(MetastorePartitionServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((MetastorePartitionServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected MetastorePartitionServiceClient(MetastorePartitionServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final MetastorePartitionServiceSettings getSettings() {
    return settings;
  }

  public MetastorePartitionServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds metastore partitions to a table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastorePartitionServiceClient metastorePartitionServiceClient =
   *     MetastorePartitionServiceClient.create()) {
   *   BatchCreateMetastorePartitionsRequest request =
   *       BatchCreateMetastorePartitionsRequest.newBuilder()
   *           .setParent(TableName.of("[PROJECT]", "[DATASET]", "[TABLE]").toString())
   *           .addAllRequests(new ArrayList<CreateMetastorePartitionRequest>())
   *           .setSkipExistingPartitions(true)
   *           .build();
   *   BatchCreateMetastorePartitionsResponse response =
   *       metastorePartitionServiceClient.batchCreateMetastorePartitions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateMetastorePartitionsResponse batchCreateMetastorePartitions(
      BatchCreateMetastorePartitionsRequest request) {
    return batchCreateMetastorePartitionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds metastore partitions to a table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastorePartitionServiceClient metastorePartitionServiceClient =
   *     MetastorePartitionServiceClient.create()) {
   *   BatchCreateMetastorePartitionsRequest request =
   *       BatchCreateMetastorePartitionsRequest.newBuilder()
   *           .setParent(TableName.of("[PROJECT]", "[DATASET]", "[TABLE]").toString())
   *           .addAllRequests(new ArrayList<CreateMetastorePartitionRequest>())
   *           .setSkipExistingPartitions(true)
   *           .build();
   *   ApiFuture<BatchCreateMetastorePartitionsResponse> future =
   *       metastorePartitionServiceClient
   *           .batchCreateMetastorePartitionsCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchCreateMetastorePartitionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchCreateMetastorePartitionsRequest, BatchCreateMetastorePartitionsResponse>
      batchCreateMetastorePartitionsCallable() {
    return stub.batchCreateMetastorePartitionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes metastore partitions from a table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastorePartitionServiceClient metastorePartitionServiceClient =
   *     MetastorePartitionServiceClient.create()) {
   *   BatchDeleteMetastorePartitionsRequest request =
   *       BatchDeleteMetastorePartitionsRequest.newBuilder()
   *           .setParent(TableName.of("[PROJECT]", "[DATASET]", "[TABLE]").toString())
   *           .addAllPartitionValues(new ArrayList<MetastorePartitionValues>())
   *           .build();
   *   metastorePartitionServiceClient.batchDeleteMetastorePartitions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void batchDeleteMetastorePartitions(BatchDeleteMetastorePartitionsRequest request) {
    batchDeleteMetastorePartitionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes metastore partitions from a table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastorePartitionServiceClient metastorePartitionServiceClient =
   *     MetastorePartitionServiceClient.create()) {
   *   BatchDeleteMetastorePartitionsRequest request =
   *       BatchDeleteMetastorePartitionsRequest.newBuilder()
   *           .setParent(TableName.of("[PROJECT]", "[DATASET]", "[TABLE]").toString())
   *           .addAllPartitionValues(new ArrayList<MetastorePartitionValues>())
   *           .build();
   *   ApiFuture<Empty> future =
   *       metastorePartitionServiceClient
   *           .batchDeleteMetastorePartitionsCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchDeleteMetastorePartitionsRequest, Empty>
      batchDeleteMetastorePartitionsCallable() {
    return stub.batchDeleteMetastorePartitionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates metastore partitions in a table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastorePartitionServiceClient metastorePartitionServiceClient =
   *     MetastorePartitionServiceClient.create()) {
   *   BatchUpdateMetastorePartitionsRequest request =
   *       BatchUpdateMetastorePartitionsRequest.newBuilder()
   *           .setParent(TableName.of("[PROJECT]", "[DATASET]", "[TABLE]").toString())
   *           .addAllRequests(new ArrayList<UpdateMetastorePartitionRequest>())
   *           .build();
   *   BatchUpdateMetastorePartitionsResponse response =
   *       metastorePartitionServiceClient.batchUpdateMetastorePartitions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateMetastorePartitionsResponse batchUpdateMetastorePartitions(
      BatchUpdateMetastorePartitionsRequest request) {
    return batchUpdateMetastorePartitionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates metastore partitions in a table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastorePartitionServiceClient metastorePartitionServiceClient =
   *     MetastorePartitionServiceClient.create()) {
   *   BatchUpdateMetastorePartitionsRequest request =
   *       BatchUpdateMetastorePartitionsRequest.newBuilder()
   *           .setParent(TableName.of("[PROJECT]", "[DATASET]", "[TABLE]").toString())
   *           .addAllRequests(new ArrayList<UpdateMetastorePartitionRequest>())
   *           .build();
   *   ApiFuture<BatchUpdateMetastorePartitionsResponse> future =
   *       metastorePartitionServiceClient
   *           .batchUpdateMetastorePartitionsCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchUpdateMetastorePartitionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchUpdateMetastorePartitionsRequest, BatchUpdateMetastorePartitionsResponse>
      batchUpdateMetastorePartitionsCallable() {
    return stub.batchUpdateMetastorePartitionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets metastore partitions from a table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastorePartitionServiceClient metastorePartitionServiceClient =
   *     MetastorePartitionServiceClient.create()) {
   *   TableName parent = TableName.of("[PROJECT]", "[DATASET]", "[TABLE]");
   *   ListMetastorePartitionsResponse response =
   *       metastorePartitionServiceClient.listMetastorePartitions(parent);
   * }
   * }</pre>
   *
   * @param parent Required. Reference to the table to which these metastore partitions belong, in
   *     the format of projects/{project}/locations/{location}/datasets/{dataset}/tables/{table}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMetastorePartitionsResponse listMetastorePartitions(TableName parent) {
    ListMetastorePartitionsRequest request =
        ListMetastorePartitionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMetastorePartitions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets metastore partitions from a table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastorePartitionServiceClient metastorePartitionServiceClient =
   *     MetastorePartitionServiceClient.create()) {
   *   String parent = TableName.of("[PROJECT]", "[DATASET]", "[TABLE]").toString();
   *   ListMetastorePartitionsResponse response =
   *       metastorePartitionServiceClient.listMetastorePartitions(parent);
   * }
   * }</pre>
   *
   * @param parent Required. Reference to the table to which these metastore partitions belong, in
   *     the format of projects/{project}/locations/{location}/datasets/{dataset}/tables/{table}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMetastorePartitionsResponse listMetastorePartitions(String parent) {
    ListMetastorePartitionsRequest request =
        ListMetastorePartitionsRequest.newBuilder().setParent(parent).build();
    return listMetastorePartitions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets metastore partitions from a table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastorePartitionServiceClient metastorePartitionServiceClient =
   *     MetastorePartitionServiceClient.create()) {
   *   ListMetastorePartitionsRequest request =
   *       ListMetastorePartitionsRequest.newBuilder()
   *           .setParent(TableName.of("[PROJECT]", "[DATASET]", "[TABLE]").toString())
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ListMetastorePartitionsResponse response =
   *       metastorePartitionServiceClient.listMetastorePartitions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMetastorePartitionsResponse listMetastorePartitions(
      ListMetastorePartitionsRequest request) {
    return listMetastorePartitionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets metastore partitions from a table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastorePartitionServiceClient metastorePartitionServiceClient =
   *     MetastorePartitionServiceClient.create()) {
   *   ListMetastorePartitionsRequest request =
   *       ListMetastorePartitionsRequest.newBuilder()
   *           .setParent(TableName.of("[PROJECT]", "[DATASET]", "[TABLE]").toString())
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<ListMetastorePartitionsResponse> future =
   *       metastorePartitionServiceClient.listMetastorePartitionsCallable().futureCall(request);
   *   // Do something.
   *   ListMetastorePartitionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMetastorePartitionsRequest, ListMetastorePartitionsResponse>
      listMetastorePartitionsCallable() {
    return stub.listMetastorePartitionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * This is a bi-di streaming rpc method that allows the client to send a stream of partitions and
   * commit all of them atomically at the end. If the commit is successful, the server will return a
   * response and close the stream. If the commit fails (due to duplicate partitions or other
   * reason), the server will close the stream with an error. This method is only available via the
   * gRPC API (not REST).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastorePartitionServiceClient metastorePartitionServiceClient =
   *     MetastorePartitionServiceClient.create()) {
   *   BidiStream<StreamMetastorePartitionsRequest, StreamMetastorePartitionsResponse> bidiStream =
   *       metastorePartitionServiceClient.streamMetastorePartitionsCallable().call();
   *   StreamMetastorePartitionsRequest request =
   *       StreamMetastorePartitionsRequest.newBuilder()
   *           .setParent(TableName.of("[PROJECT]", "[DATASET]", "[TABLE]").toString())
   *           .addAllMetastorePartitions(new ArrayList<MetastorePartition>())
   *           .setSkipExistingPartitions(true)
   *           .build();
   *   bidiStream.send(request);
   *   for (StreamMetastorePartitionsResponse response : bidiStream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final BidiStreamingCallable<
          StreamMetastorePartitionsRequest, StreamMetastorePartitionsResponse>
      streamMetastorePartitionsCallable() {
    return stub.streamMetastorePartitionsCallable();
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
