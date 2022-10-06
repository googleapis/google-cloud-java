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

package com.google.cloud.dataproc.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataproc.v1.stub.BatchControllerStub;
import com.google.cloud.dataproc.v1.stub.BatchControllerStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The BatchController provides methods to manage batch workloads.
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
 * try (BatchControllerClient batchControllerClient = BatchControllerClient.create()) {
 *   BatchName name = BatchName.of("[PROJECT]", "[LOCATION]", "[BATCH]");
 *   Batch response = batchControllerClient.getBatch(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the BatchControllerClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of BatchControllerSettings to
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
 * BatchControllerSettings batchControllerSettings =
 *     BatchControllerSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * BatchControllerClient batchControllerClient =
 *     BatchControllerClient.create(batchControllerSettings);
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
 * BatchControllerSettings batchControllerSettings =
 *     BatchControllerSettings.newBuilder().setEndpoint(myEndpoint).build();
 * BatchControllerClient batchControllerClient =
 *     BatchControllerClient.create(batchControllerSettings);
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
 * BatchControllerSettings batchControllerSettings =
 *     BatchControllerSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             BatchControllerSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * BatchControllerClient batchControllerClient =
 *     BatchControllerClient.create(batchControllerSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class BatchControllerClient implements BackgroundResource {
  private final BatchControllerSettings settings;
  private final BatchControllerStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of BatchControllerClient with default settings. */
  public static final BatchControllerClient create() throws IOException {
    return create(BatchControllerSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of BatchControllerClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final BatchControllerClient create(BatchControllerSettings settings)
      throws IOException {
    return new BatchControllerClient(settings);
  }

  /**
   * Constructs an instance of BatchControllerClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(BatchControllerSettings).
   */
  public static final BatchControllerClient create(BatchControllerStub stub) {
    return new BatchControllerClient(stub);
  }

  /**
   * Constructs an instance of BatchControllerClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected BatchControllerClient(BatchControllerSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((BatchControllerStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected BatchControllerClient(BatchControllerStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final BatchControllerSettings getSettings() {
    return settings;
  }

  public BatchControllerStub getStub() {
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
   * Creates a batch workload that executes asynchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BatchControllerClient batchControllerClient = BatchControllerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Batch batch = Batch.newBuilder().build();
   *   String batchId = "batchId-331744779";
   *   Batch response = batchControllerClient.createBatchAsync(parent, batch, batchId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this batch will be created.
   * @param batch Required. The batch to create.
   * @param batchId Optional. The ID to use for the batch, which will become the final component of
   *     the batch's resource name.
   *     <p>This value must be 4-63 characters. Valid characters are `/[a-z][0-9]-/`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Batch, BatchOperationMetadata> createBatchAsync(
      LocationName parent, Batch batch, String batchId) {
    CreateBatchRequest request =
        CreateBatchRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setBatch(batch)
            .setBatchId(batchId)
            .build();
    return createBatchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a batch workload that executes asynchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BatchControllerClient batchControllerClient = BatchControllerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Batch batch = Batch.newBuilder().build();
   *   String batchId = "batchId-331744779";
   *   Batch response = batchControllerClient.createBatchAsync(parent, batch, batchId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this batch will be created.
   * @param batch Required. The batch to create.
   * @param batchId Optional. The ID to use for the batch, which will become the final component of
   *     the batch's resource name.
   *     <p>This value must be 4-63 characters. Valid characters are `/[a-z][0-9]-/`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Batch, BatchOperationMetadata> createBatchAsync(
      String parent, Batch batch, String batchId) {
    CreateBatchRequest request =
        CreateBatchRequest.newBuilder()
            .setParent(parent)
            .setBatch(batch)
            .setBatchId(batchId)
            .build();
    return createBatchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a batch workload that executes asynchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BatchControllerClient batchControllerClient = BatchControllerClient.create()) {
   *   CreateBatchRequest request =
   *       CreateBatchRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBatch(Batch.newBuilder().build())
   *           .setBatchId("batchId-331744779")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Batch response = batchControllerClient.createBatchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Batch, BatchOperationMetadata> createBatchAsync(
      CreateBatchRequest request) {
    return createBatchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a batch workload that executes asynchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BatchControllerClient batchControllerClient = BatchControllerClient.create()) {
   *   CreateBatchRequest request =
   *       CreateBatchRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBatch(Batch.newBuilder().build())
   *           .setBatchId("batchId-331744779")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Batch, BatchOperationMetadata> future =
   *       batchControllerClient.createBatchOperationCallable().futureCall(request);
   *   // Do something.
   *   Batch response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateBatchRequest, Batch, BatchOperationMetadata>
      createBatchOperationCallable() {
    return stub.createBatchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a batch workload that executes asynchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BatchControllerClient batchControllerClient = BatchControllerClient.create()) {
   *   CreateBatchRequest request =
   *       CreateBatchRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBatch(Batch.newBuilder().build())
   *           .setBatchId("batchId-331744779")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = batchControllerClient.createBatchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateBatchRequest, Operation> createBatchCallable() {
    return stub.createBatchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the batch workload resource representation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BatchControllerClient batchControllerClient = BatchControllerClient.create()) {
   *   BatchName name = BatchName.of("[PROJECT]", "[LOCATION]", "[BATCH]");
   *   Batch response = batchControllerClient.getBatch(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the batch to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Batch getBatch(BatchName name) {
    GetBatchRequest request =
        GetBatchRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getBatch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the batch workload resource representation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BatchControllerClient batchControllerClient = BatchControllerClient.create()) {
   *   String name = BatchName.of("[PROJECT]", "[LOCATION]", "[BATCH]").toString();
   *   Batch response = batchControllerClient.getBatch(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the batch to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Batch getBatch(String name) {
    GetBatchRequest request = GetBatchRequest.newBuilder().setName(name).build();
    return getBatch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the batch workload resource representation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BatchControllerClient batchControllerClient = BatchControllerClient.create()) {
   *   GetBatchRequest request =
   *       GetBatchRequest.newBuilder()
   *           .setName(BatchName.of("[PROJECT]", "[LOCATION]", "[BATCH]").toString())
   *           .build();
   *   Batch response = batchControllerClient.getBatch(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Batch getBatch(GetBatchRequest request) {
    return getBatchCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the batch workload resource representation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BatchControllerClient batchControllerClient = BatchControllerClient.create()) {
   *   GetBatchRequest request =
   *       GetBatchRequest.newBuilder()
   *           .setName(BatchName.of("[PROJECT]", "[LOCATION]", "[BATCH]").toString())
   *           .build();
   *   ApiFuture<Batch> future = batchControllerClient.getBatchCallable().futureCall(request);
   *   // Do something.
   *   Batch response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBatchRequest, Batch> getBatchCallable() {
    return stub.getBatchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists batch workloads.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BatchControllerClient batchControllerClient = BatchControllerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Batch element : batchControllerClient.listBatches(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of batches.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBatchesPagedResponse listBatches(LocationName parent) {
    ListBatchesRequest request =
        ListBatchesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBatches(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists batch workloads.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BatchControllerClient batchControllerClient = BatchControllerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Batch element : batchControllerClient.listBatches(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of batches.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBatchesPagedResponse listBatches(String parent) {
    ListBatchesRequest request = ListBatchesRequest.newBuilder().setParent(parent).build();
    return listBatches(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists batch workloads.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BatchControllerClient batchControllerClient = BatchControllerClient.create()) {
   *   ListBatchesRequest request =
   *       ListBatchesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Batch element : batchControllerClient.listBatches(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBatchesPagedResponse listBatches(ListBatchesRequest request) {
    return listBatchesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists batch workloads.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BatchControllerClient batchControllerClient = BatchControllerClient.create()) {
   *   ListBatchesRequest request =
   *       ListBatchesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Batch> future =
   *       batchControllerClient.listBatchesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Batch element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBatchesRequest, ListBatchesPagedResponse>
      listBatchesPagedCallable() {
    return stub.listBatchesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists batch workloads.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BatchControllerClient batchControllerClient = BatchControllerClient.create()) {
   *   ListBatchesRequest request =
   *       ListBatchesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListBatchesResponse response = batchControllerClient.listBatchesCallable().call(request);
   *     for (Batch element : response.getBatchesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBatchesRequest, ListBatchesResponse> listBatchesCallable() {
    return stub.listBatchesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the batch workload resource. If the batch is not in terminal state, the delete fails
   * and the response returns `FAILED_PRECONDITION`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BatchControllerClient batchControllerClient = BatchControllerClient.create()) {
   *   BatchName name = BatchName.of("[PROJECT]", "[LOCATION]", "[BATCH]");
   *   batchControllerClient.deleteBatch(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the batch resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBatch(BatchName name) {
    DeleteBatchRequest request =
        DeleteBatchRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteBatch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the batch workload resource. If the batch is not in terminal state, the delete fails
   * and the response returns `FAILED_PRECONDITION`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BatchControllerClient batchControllerClient = BatchControllerClient.create()) {
   *   String name = BatchName.of("[PROJECT]", "[LOCATION]", "[BATCH]").toString();
   *   batchControllerClient.deleteBatch(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the batch resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBatch(String name) {
    DeleteBatchRequest request = DeleteBatchRequest.newBuilder().setName(name).build();
    deleteBatch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the batch workload resource. If the batch is not in terminal state, the delete fails
   * and the response returns `FAILED_PRECONDITION`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BatchControllerClient batchControllerClient = BatchControllerClient.create()) {
   *   DeleteBatchRequest request =
   *       DeleteBatchRequest.newBuilder()
   *           .setName(BatchName.of("[PROJECT]", "[LOCATION]", "[BATCH]").toString())
   *           .build();
   *   batchControllerClient.deleteBatch(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBatch(DeleteBatchRequest request) {
    deleteBatchCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the batch workload resource. If the batch is not in terminal state, the delete fails
   * and the response returns `FAILED_PRECONDITION`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BatchControllerClient batchControllerClient = BatchControllerClient.create()) {
   *   DeleteBatchRequest request =
   *       DeleteBatchRequest.newBuilder()
   *           .setName(BatchName.of("[PROJECT]", "[LOCATION]", "[BATCH]").toString())
   *           .build();
   *   ApiFuture<Empty> future = batchControllerClient.deleteBatchCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteBatchRequest, Empty> deleteBatchCallable() {
    return stub.deleteBatchCallable();
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

  public static class ListBatchesPagedResponse
      extends AbstractPagedListResponse<
          ListBatchesRequest,
          ListBatchesResponse,
          Batch,
          ListBatchesPage,
          ListBatchesFixedSizeCollection> {

    public static ApiFuture<ListBatchesPagedResponse> createAsync(
        PageContext<ListBatchesRequest, ListBatchesResponse, Batch> context,
        ApiFuture<ListBatchesResponse> futureResponse) {
      ApiFuture<ListBatchesPage> futurePage =
          ListBatchesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListBatchesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListBatchesPagedResponse(ListBatchesPage page) {
      super(page, ListBatchesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBatchesPage
      extends AbstractPage<ListBatchesRequest, ListBatchesResponse, Batch, ListBatchesPage> {

    private ListBatchesPage(
        PageContext<ListBatchesRequest, ListBatchesResponse, Batch> context,
        ListBatchesResponse response) {
      super(context, response);
    }

    private static ListBatchesPage createEmptyPage() {
      return new ListBatchesPage(null, null);
    }

    @Override
    protected ListBatchesPage createPage(
        PageContext<ListBatchesRequest, ListBatchesResponse, Batch> context,
        ListBatchesResponse response) {
      return new ListBatchesPage(context, response);
    }

    @Override
    public ApiFuture<ListBatchesPage> createPageAsync(
        PageContext<ListBatchesRequest, ListBatchesResponse, Batch> context,
        ApiFuture<ListBatchesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBatchesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBatchesRequest,
          ListBatchesResponse,
          Batch,
          ListBatchesPage,
          ListBatchesFixedSizeCollection> {

    private ListBatchesFixedSizeCollection(List<ListBatchesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBatchesFixedSizeCollection createEmptyCollection() {
      return new ListBatchesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBatchesFixedSizeCollection createCollection(
        List<ListBatchesPage> pages, int collectionSize) {
      return new ListBatchesFixedSizeCollection(pages, collectionSize);
    }
  }
}
