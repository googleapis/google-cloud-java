/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.aiplatform.v1beta1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.stub.IndexServiceStub;
import com.google.cloud.aiplatform.v1beta1.stub.IndexServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service for creating and managing AI Platform's Index resources.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (IndexServiceClient indexServiceClient = IndexServiceClient.create()) {
 *   IndexName name = IndexName.of("[PROJECT]", "[LOCATION]", "[INDEX]");
 *   Index response = indexServiceClient.getIndex(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the IndexServiceClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of IndexServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * IndexServiceSettings indexServiceSettings =
 *     IndexServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * IndexServiceClient indexServiceClient = IndexServiceClient.create(indexServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * IndexServiceSettings indexServiceSettings =
 *     IndexServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * IndexServiceClient indexServiceClient = IndexServiceClient.create(indexServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class IndexServiceClient implements BackgroundResource {
  private final IndexServiceSettings settings;
  private final IndexServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of IndexServiceClient with default settings. */
  public static final IndexServiceClient create() throws IOException {
    return create(IndexServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of IndexServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final IndexServiceClient create(IndexServiceSettings settings) throws IOException {
    return new IndexServiceClient(settings);
  }

  /**
   * Constructs an instance of IndexServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(IndexServiceSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final IndexServiceClient create(IndexServiceStub stub) {
    return new IndexServiceClient(stub);
  }

  /**
   * Constructs an instance of IndexServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected IndexServiceClient(IndexServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((IndexServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected IndexServiceClient(IndexServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final IndexServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public IndexServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Index.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IndexServiceClient indexServiceClient = IndexServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Index index = Index.newBuilder().build();
   *   Index response = indexServiceClient.createIndexAsync(parent, index).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the Index in. Format:
   *     `projects/{project}/locations/{location}`
   * @param index Required. The Index to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Index, CreateIndexOperationMetadata> createIndexAsync(
      LocationName parent, Index index) {
    CreateIndexRequest request =
        CreateIndexRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setIndex(index)
            .build();
    return createIndexAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Index.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IndexServiceClient indexServiceClient = IndexServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Index index = Index.newBuilder().build();
   *   Index response = indexServiceClient.createIndexAsync(parent, index).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the Index in. Format:
   *     `projects/{project}/locations/{location}`
   * @param index Required. The Index to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Index, CreateIndexOperationMetadata> createIndexAsync(
      String parent, Index index) {
    CreateIndexRequest request =
        CreateIndexRequest.newBuilder().setParent(parent).setIndex(index).build();
    return createIndexAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Index.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IndexServiceClient indexServiceClient = IndexServiceClient.create()) {
   *   CreateIndexRequest request =
   *       CreateIndexRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setIndex(Index.newBuilder().build())
   *           .build();
   *   Index response = indexServiceClient.createIndexAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Index, CreateIndexOperationMetadata> createIndexAsync(
      CreateIndexRequest request) {
    return createIndexOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Index.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IndexServiceClient indexServiceClient = IndexServiceClient.create()) {
   *   CreateIndexRequest request =
   *       CreateIndexRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setIndex(Index.newBuilder().build())
   *           .build();
   *   OperationFuture<Index, CreateIndexOperationMetadata> future =
   *       indexServiceClient.createIndexOperationCallable().futureCall(request);
   *   // Do something.
   *   Index response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateIndexRequest, Index, CreateIndexOperationMetadata>
      createIndexOperationCallable() {
    return stub.createIndexOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Index.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IndexServiceClient indexServiceClient = IndexServiceClient.create()) {
   *   CreateIndexRequest request =
   *       CreateIndexRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setIndex(Index.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = indexServiceClient.createIndexCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateIndexRequest, Operation> createIndexCallable() {
    return stub.createIndexCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an Index.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IndexServiceClient indexServiceClient = IndexServiceClient.create()) {
   *   IndexName name = IndexName.of("[PROJECT]", "[LOCATION]", "[INDEX]");
   *   Index response = indexServiceClient.getIndex(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Index resource. Format:
   *     `projects/{project}/locations/{location}/indexes/{index}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Index getIndex(IndexName name) {
    GetIndexRequest request =
        GetIndexRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getIndex(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an Index.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IndexServiceClient indexServiceClient = IndexServiceClient.create()) {
   *   String name = IndexName.of("[PROJECT]", "[LOCATION]", "[INDEX]").toString();
   *   Index response = indexServiceClient.getIndex(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Index resource. Format:
   *     `projects/{project}/locations/{location}/indexes/{index}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Index getIndex(String name) {
    GetIndexRequest request = GetIndexRequest.newBuilder().setName(name).build();
    return getIndex(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an Index.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IndexServiceClient indexServiceClient = IndexServiceClient.create()) {
   *   GetIndexRequest request =
   *       GetIndexRequest.newBuilder()
   *           .setName(IndexName.of("[PROJECT]", "[LOCATION]", "[INDEX]").toString())
   *           .build();
   *   Index response = indexServiceClient.getIndex(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Index getIndex(GetIndexRequest request) {
    return getIndexCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an Index.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IndexServiceClient indexServiceClient = IndexServiceClient.create()) {
   *   GetIndexRequest request =
   *       GetIndexRequest.newBuilder()
   *           .setName(IndexName.of("[PROJECT]", "[LOCATION]", "[INDEX]").toString())
   *           .build();
   *   ApiFuture<Index> future = indexServiceClient.getIndexCallable().futureCall(request);
   *   // Do something.
   *   Index response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIndexRequest, Index> getIndexCallable() {
    return stub.getIndexCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Indexes in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IndexServiceClient indexServiceClient = IndexServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Index element : indexServiceClient.listIndexes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location from which to list the Indexes.
   *     Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIndexesPagedResponse listIndexes(LocationName parent) {
    ListIndexesRequest request =
        ListIndexesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listIndexes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Indexes in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IndexServiceClient indexServiceClient = IndexServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Index element : indexServiceClient.listIndexes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location from which to list the Indexes.
   *     Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIndexesPagedResponse listIndexes(String parent) {
    ListIndexesRequest request = ListIndexesRequest.newBuilder().setParent(parent).build();
    return listIndexes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Indexes in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IndexServiceClient indexServiceClient = IndexServiceClient.create()) {
   *   ListIndexesRequest request =
   *       ListIndexesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   for (Index element : indexServiceClient.listIndexes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIndexesPagedResponse listIndexes(ListIndexesRequest request) {
    return listIndexesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Indexes in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IndexServiceClient indexServiceClient = IndexServiceClient.create()) {
   *   ListIndexesRequest request =
   *       ListIndexesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Index> future = indexServiceClient.listIndexesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Index element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListIndexesRequest, ListIndexesPagedResponse>
      listIndexesPagedCallable() {
    return stub.listIndexesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Indexes in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IndexServiceClient indexServiceClient = IndexServiceClient.create()) {
   *   ListIndexesRequest request =
   *       ListIndexesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   while (true) {
   *     ListIndexesResponse response = indexServiceClient.listIndexesCallable().call(request);
   *     for (Index element : response.getResponsesList()) {
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
  public final UnaryCallable<ListIndexesRequest, ListIndexesResponse> listIndexesCallable() {
    return stub.listIndexesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an Index.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IndexServiceClient indexServiceClient = IndexServiceClient.create()) {
   *   Index index = Index.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Index response = indexServiceClient.updateIndexAsync(index, updateMask).get();
   * }
   * }</pre>
   *
   * @param index Required. The Index which updates the resource on the server.
   * @param updateMask The update mask applies to the resource. For the `FieldMask` definition, see
   *     [FieldMask](https://tinyurl.com/protobufs#google.protobuf.FieldMask).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Index, UpdateIndexOperationMetadata> updateIndexAsync(
      Index index, FieldMask updateMask) {
    UpdateIndexRequest request =
        UpdateIndexRequest.newBuilder().setIndex(index).setUpdateMask(updateMask).build();
    return updateIndexAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an Index.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IndexServiceClient indexServiceClient = IndexServiceClient.create()) {
   *   UpdateIndexRequest request =
   *       UpdateIndexRequest.newBuilder()
   *           .setIndex(Index.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Index response = indexServiceClient.updateIndexAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Index, UpdateIndexOperationMetadata> updateIndexAsync(
      UpdateIndexRequest request) {
    return updateIndexOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an Index.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IndexServiceClient indexServiceClient = IndexServiceClient.create()) {
   *   UpdateIndexRequest request =
   *       UpdateIndexRequest.newBuilder()
   *           .setIndex(Index.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Index, UpdateIndexOperationMetadata> future =
   *       indexServiceClient.updateIndexOperationCallable().futureCall(request);
   *   // Do something.
   *   Index response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateIndexRequest, Index, UpdateIndexOperationMetadata>
      updateIndexOperationCallable() {
    return stub.updateIndexOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an Index.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IndexServiceClient indexServiceClient = IndexServiceClient.create()) {
   *   UpdateIndexRequest request =
   *       UpdateIndexRequest.newBuilder()
   *           .setIndex(Index.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = indexServiceClient.updateIndexCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateIndexRequest, Operation> updateIndexCallable() {
    return stub.updateIndexCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Index. An Index can only be deleted when all its
   * [DeployedIndexes][google.cloud.aiplatform.v1beta1.Index.deployed_indexes] had been undeployed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IndexServiceClient indexServiceClient = IndexServiceClient.create()) {
   *   IndexName name = IndexName.of("[PROJECT]", "[LOCATION]", "[INDEX]");
   *   indexServiceClient.deleteIndexAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Index resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/indexes/{index}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteIndexAsync(IndexName name) {
    DeleteIndexRequest request =
        DeleteIndexRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteIndexAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Index. An Index can only be deleted when all its
   * [DeployedIndexes][google.cloud.aiplatform.v1beta1.Index.deployed_indexes] had been undeployed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IndexServiceClient indexServiceClient = IndexServiceClient.create()) {
   *   String name = IndexName.of("[PROJECT]", "[LOCATION]", "[INDEX]").toString();
   *   indexServiceClient.deleteIndexAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Index resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/indexes/{index}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteIndexAsync(String name) {
    DeleteIndexRequest request = DeleteIndexRequest.newBuilder().setName(name).build();
    return deleteIndexAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Index. An Index can only be deleted when all its
   * [DeployedIndexes][google.cloud.aiplatform.v1beta1.Index.deployed_indexes] had been undeployed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IndexServiceClient indexServiceClient = IndexServiceClient.create()) {
   *   DeleteIndexRequest request =
   *       DeleteIndexRequest.newBuilder()
   *           .setName(IndexName.of("[PROJECT]", "[LOCATION]", "[INDEX]").toString())
   *           .build();
   *   indexServiceClient.deleteIndexAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteIndexAsync(
      DeleteIndexRequest request) {
    return deleteIndexOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Index. An Index can only be deleted when all its
   * [DeployedIndexes][google.cloud.aiplatform.v1beta1.Index.deployed_indexes] had been undeployed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IndexServiceClient indexServiceClient = IndexServiceClient.create()) {
   *   DeleteIndexRequest request =
   *       DeleteIndexRequest.newBuilder()
   *           .setName(IndexName.of("[PROJECT]", "[LOCATION]", "[INDEX]").toString())
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       indexServiceClient.deleteIndexOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteIndexRequest, Empty, DeleteOperationMetadata>
      deleteIndexOperationCallable() {
    return stub.deleteIndexOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Index. An Index can only be deleted when all its
   * [DeployedIndexes][google.cloud.aiplatform.v1beta1.Index.deployed_indexes] had been undeployed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (IndexServiceClient indexServiceClient = IndexServiceClient.create()) {
   *   DeleteIndexRequest request =
   *       DeleteIndexRequest.newBuilder()
   *           .setName(IndexName.of("[PROJECT]", "[LOCATION]", "[INDEX]").toString())
   *           .build();
   *   ApiFuture<Operation> future = indexServiceClient.deleteIndexCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteIndexRequest, Operation> deleteIndexCallable() {
    return stub.deleteIndexCallable();
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

  public static class ListIndexesPagedResponse
      extends AbstractPagedListResponse<
          ListIndexesRequest,
          ListIndexesResponse,
          Index,
          ListIndexesPage,
          ListIndexesFixedSizeCollection> {

    public static ApiFuture<ListIndexesPagedResponse> createAsync(
        PageContext<ListIndexesRequest, ListIndexesResponse, Index> context,
        ApiFuture<ListIndexesResponse> futureResponse) {
      ApiFuture<ListIndexesPage> futurePage =
          ListIndexesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListIndexesPage, ListIndexesPagedResponse>() {
            @Override
            public ListIndexesPagedResponse apply(ListIndexesPage input) {
              return new ListIndexesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListIndexesPagedResponse(ListIndexesPage page) {
      super(page, ListIndexesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListIndexesPage
      extends AbstractPage<ListIndexesRequest, ListIndexesResponse, Index, ListIndexesPage> {

    private ListIndexesPage(
        PageContext<ListIndexesRequest, ListIndexesResponse, Index> context,
        ListIndexesResponse response) {
      super(context, response);
    }

    private static ListIndexesPage createEmptyPage() {
      return new ListIndexesPage(null, null);
    }

    @Override
    protected ListIndexesPage createPage(
        PageContext<ListIndexesRequest, ListIndexesResponse, Index> context,
        ListIndexesResponse response) {
      return new ListIndexesPage(context, response);
    }

    @Override
    public ApiFuture<ListIndexesPage> createPageAsync(
        PageContext<ListIndexesRequest, ListIndexesResponse, Index> context,
        ApiFuture<ListIndexesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListIndexesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListIndexesRequest,
          ListIndexesResponse,
          Index,
          ListIndexesPage,
          ListIndexesFixedSizeCollection> {

    private ListIndexesFixedSizeCollection(List<ListIndexesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListIndexesFixedSizeCollection createEmptyCollection() {
      return new ListIndexesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListIndexesFixedSizeCollection createCollection(
        List<ListIndexesPage> pages, int collectionSize) {
      return new ListIndexesFixedSizeCollection(pages, collectionSize);
    }
  }
}
