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

package com.google.cloud.aiplatform.v1beta1;

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
import com.google.cloud.aiplatform.v1beta1.stub.IndexEndpointServiceStub;
import com.google.cloud.aiplatform.v1beta1.stub.IndexEndpointServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
 * Service Description: A service for managing Vertex AI's IndexEndpoints.
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
 * try (IndexEndpointServiceClient indexEndpointServiceClient =
 *     IndexEndpointServiceClient.create()) {
 *   IndexEndpointName name = IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]");
 *   IndexEndpoint response = indexEndpointServiceClient.getIndexEndpoint(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the IndexEndpointServiceClient object to clean up
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
 * <p>This class can be customized by passing in a custom instance of IndexEndpointServiceSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * IndexEndpointServiceSettings indexEndpointServiceSettings =
 *     IndexEndpointServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * IndexEndpointServiceClient indexEndpointServiceClient =
 *     IndexEndpointServiceClient.create(indexEndpointServiceSettings);
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
 * IndexEndpointServiceSettings indexEndpointServiceSettings =
 *     IndexEndpointServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * IndexEndpointServiceClient indexEndpointServiceClient =
 *     IndexEndpointServiceClient.create(indexEndpointServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class IndexEndpointServiceClient implements BackgroundResource {
  private final IndexEndpointServiceSettings settings;
  private final IndexEndpointServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of IndexEndpointServiceClient with default settings. */
  public static final IndexEndpointServiceClient create() throws IOException {
    return create(IndexEndpointServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of IndexEndpointServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final IndexEndpointServiceClient create(IndexEndpointServiceSettings settings)
      throws IOException {
    return new IndexEndpointServiceClient(settings);
  }

  /**
   * Constructs an instance of IndexEndpointServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(IndexEndpointServiceSettings).
   */
  public static final IndexEndpointServiceClient create(IndexEndpointServiceStub stub) {
    return new IndexEndpointServiceClient(stub);
  }

  /**
   * Constructs an instance of IndexEndpointServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected IndexEndpointServiceClient(IndexEndpointServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((IndexEndpointServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected IndexEndpointServiceClient(IndexEndpointServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final IndexEndpointServiceSettings getSettings() {
    return settings;
  }

  public IndexEndpointServiceStub getStub() {
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
   * Creates an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   IndexEndpoint indexEndpoint = IndexEndpoint.newBuilder().build();
   *   IndexEndpoint response =
   *       indexEndpointServiceClient.createIndexEndpointAsync(parent, indexEndpoint).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the IndexEndpoint in.
   *     Format: `projects/{project}/locations/{location}`
   * @param indexEndpoint Required. The IndexEndpoint to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IndexEndpoint, CreateIndexEndpointOperationMetadata>
      createIndexEndpointAsync(LocationName parent, IndexEndpoint indexEndpoint) {
    CreateIndexEndpointRequest request =
        CreateIndexEndpointRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setIndexEndpoint(indexEndpoint)
            .build();
    return createIndexEndpointAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   IndexEndpoint indexEndpoint = IndexEndpoint.newBuilder().build();
   *   IndexEndpoint response =
   *       indexEndpointServiceClient.createIndexEndpointAsync(parent, indexEndpoint).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the IndexEndpoint in.
   *     Format: `projects/{project}/locations/{location}`
   * @param indexEndpoint Required. The IndexEndpoint to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IndexEndpoint, CreateIndexEndpointOperationMetadata>
      createIndexEndpointAsync(String parent, IndexEndpoint indexEndpoint) {
    CreateIndexEndpointRequest request =
        CreateIndexEndpointRequest.newBuilder()
            .setParent(parent)
            .setIndexEndpoint(indexEndpoint)
            .build();
    return createIndexEndpointAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   CreateIndexEndpointRequest request =
   *       CreateIndexEndpointRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setIndexEndpoint(IndexEndpoint.newBuilder().build())
   *           .build();
   *   IndexEndpoint response = indexEndpointServiceClient.createIndexEndpointAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IndexEndpoint, CreateIndexEndpointOperationMetadata>
      createIndexEndpointAsync(CreateIndexEndpointRequest request) {
    return createIndexEndpointOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   CreateIndexEndpointRequest request =
   *       CreateIndexEndpointRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setIndexEndpoint(IndexEndpoint.newBuilder().build())
   *           .build();
   *   OperationFuture<IndexEndpoint, CreateIndexEndpointOperationMetadata> future =
   *       indexEndpointServiceClient.createIndexEndpointOperationCallable().futureCall(request);
   *   // Do something.
   *   IndexEndpoint response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateIndexEndpointRequest, IndexEndpoint, CreateIndexEndpointOperationMetadata>
      createIndexEndpointOperationCallable() {
    return stub.createIndexEndpointOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   CreateIndexEndpointRequest request =
   *       CreateIndexEndpointRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setIndexEndpoint(IndexEndpoint.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       indexEndpointServiceClient.createIndexEndpointCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateIndexEndpointRequest, Operation> createIndexEndpointCallable() {
    return stub.createIndexEndpointCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   IndexEndpointName name = IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]");
   *   IndexEndpoint response = indexEndpointServiceClient.getIndexEndpoint(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the IndexEndpoint resource. Format:
   *     `projects/{project}/locations/{location}/indexEndpoints/{index_endpoint}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IndexEndpoint getIndexEndpoint(IndexEndpointName name) {
    GetIndexEndpointRequest request =
        GetIndexEndpointRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getIndexEndpoint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   String name = IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString();
   *   IndexEndpoint response = indexEndpointServiceClient.getIndexEndpoint(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the IndexEndpoint resource. Format:
   *     `projects/{project}/locations/{location}/indexEndpoints/{index_endpoint}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IndexEndpoint getIndexEndpoint(String name) {
    GetIndexEndpointRequest request = GetIndexEndpointRequest.newBuilder().setName(name).build();
    return getIndexEndpoint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   GetIndexEndpointRequest request =
   *       GetIndexEndpointRequest.newBuilder()
   *           .setName(
   *               IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
   *           .build();
   *   IndexEndpoint response = indexEndpointServiceClient.getIndexEndpoint(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IndexEndpoint getIndexEndpoint(GetIndexEndpointRequest request) {
    return getIndexEndpointCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   GetIndexEndpointRequest request =
   *       GetIndexEndpointRequest.newBuilder()
   *           .setName(
   *               IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
   *           .build();
   *   ApiFuture<IndexEndpoint> future =
   *       indexEndpointServiceClient.getIndexEndpointCallable().futureCall(request);
   *   // Do something.
   *   IndexEndpoint response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIndexEndpointRequest, IndexEndpoint> getIndexEndpointCallable() {
    return stub.getIndexEndpointCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists IndexEndpoints in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (IndexEndpoint element :
   *       indexEndpointServiceClient.listIndexEndpoints(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location from which to list the
   *     IndexEndpoints. Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIndexEndpointsPagedResponse listIndexEndpoints(LocationName parent) {
    ListIndexEndpointsRequest request =
        ListIndexEndpointsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listIndexEndpoints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists IndexEndpoints in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (IndexEndpoint element :
   *       indexEndpointServiceClient.listIndexEndpoints(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location from which to list the
   *     IndexEndpoints. Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIndexEndpointsPagedResponse listIndexEndpoints(String parent) {
    ListIndexEndpointsRequest request =
        ListIndexEndpointsRequest.newBuilder().setParent(parent).build();
    return listIndexEndpoints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists IndexEndpoints in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   ListIndexEndpointsRequest request =
   *       ListIndexEndpointsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   for (IndexEndpoint element :
   *       indexEndpointServiceClient.listIndexEndpoints(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIndexEndpointsPagedResponse listIndexEndpoints(
      ListIndexEndpointsRequest request) {
    return listIndexEndpointsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists IndexEndpoints in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   ListIndexEndpointsRequest request =
   *       ListIndexEndpointsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<IndexEndpoint> future =
   *       indexEndpointServiceClient.listIndexEndpointsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (IndexEndpoint element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListIndexEndpointsRequest, ListIndexEndpointsPagedResponse>
      listIndexEndpointsPagedCallable() {
    return stub.listIndexEndpointsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists IndexEndpoints in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   ListIndexEndpointsRequest request =
   *       ListIndexEndpointsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   while (true) {
   *     ListIndexEndpointsResponse response =
   *         indexEndpointServiceClient.listIndexEndpointsCallable().call(request);
   *     for (IndexEndpoint element : response.getIndexEndpointsList()) {
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
  public final UnaryCallable<ListIndexEndpointsRequest, ListIndexEndpointsResponse>
      listIndexEndpointsCallable() {
    return stub.listIndexEndpointsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   IndexEndpoint indexEndpoint = IndexEndpoint.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   IndexEndpoint response =
   *       indexEndpointServiceClient.updateIndexEndpoint(indexEndpoint, updateMask);
   * }
   * }</pre>
   *
   * @param indexEndpoint Required. The IndexEndpoint which replaces the resource on the server.
   * @param updateMask Required. The update mask applies to the resource. See
   *     [google.protobuf.FieldMask][google.protobuf.FieldMask].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IndexEndpoint updateIndexEndpoint(
      IndexEndpoint indexEndpoint, FieldMask updateMask) {
    UpdateIndexEndpointRequest request =
        UpdateIndexEndpointRequest.newBuilder()
            .setIndexEndpoint(indexEndpoint)
            .setUpdateMask(updateMask)
            .build();
    return updateIndexEndpoint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   UpdateIndexEndpointRequest request =
   *       UpdateIndexEndpointRequest.newBuilder()
   *           .setIndexEndpoint(IndexEndpoint.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   IndexEndpoint response = indexEndpointServiceClient.updateIndexEndpoint(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IndexEndpoint updateIndexEndpoint(UpdateIndexEndpointRequest request) {
    return updateIndexEndpointCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   UpdateIndexEndpointRequest request =
   *       UpdateIndexEndpointRequest.newBuilder()
   *           .setIndexEndpoint(IndexEndpoint.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<IndexEndpoint> future =
   *       indexEndpointServiceClient.updateIndexEndpointCallable().futureCall(request);
   *   // Do something.
   *   IndexEndpoint response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateIndexEndpointRequest, IndexEndpoint>
      updateIndexEndpointCallable() {
    return stub.updateIndexEndpointCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   IndexEndpointName name = IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]");
   *   indexEndpointServiceClient.deleteIndexEndpointAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the IndexEndpoint resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/indexEndpoints/{index_endpoint}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteIndexEndpointAsync(
      IndexEndpointName name) {
    DeleteIndexEndpointRequest request =
        DeleteIndexEndpointRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteIndexEndpointAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   String name = IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString();
   *   indexEndpointServiceClient.deleteIndexEndpointAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the IndexEndpoint resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/indexEndpoints/{index_endpoint}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteIndexEndpointAsync(
      String name) {
    DeleteIndexEndpointRequest request =
        DeleteIndexEndpointRequest.newBuilder().setName(name).build();
    return deleteIndexEndpointAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   DeleteIndexEndpointRequest request =
   *       DeleteIndexEndpointRequest.newBuilder()
   *           .setName(
   *               IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
   *           .build();
   *   indexEndpointServiceClient.deleteIndexEndpointAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteIndexEndpointAsync(
      DeleteIndexEndpointRequest request) {
    return deleteIndexEndpointOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   DeleteIndexEndpointRequest request =
   *       DeleteIndexEndpointRequest.newBuilder()
   *           .setName(
   *               IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       indexEndpointServiceClient.deleteIndexEndpointOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteIndexEndpointRequest, Empty, DeleteOperationMetadata>
      deleteIndexEndpointOperationCallable() {
    return stub.deleteIndexEndpointOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   DeleteIndexEndpointRequest request =
   *       DeleteIndexEndpointRequest.newBuilder()
   *           .setName(
   *               IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       indexEndpointServiceClient.deleteIndexEndpointCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteIndexEndpointRequest, Operation> deleteIndexEndpointCallable() {
    return stub.deleteIndexEndpointCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys an Index into this IndexEndpoint, creating a DeployedIndex within it. Only non-empty
   * Indexes can be deployed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   IndexEndpointName indexEndpoint =
   *       IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]");
   *   DeployedIndex deployedIndex = DeployedIndex.newBuilder().build();
   *   DeployIndexResponse response =
   *       indexEndpointServiceClient.deployIndexAsync(indexEndpoint, deployedIndex).get();
   * }
   * }</pre>
   *
   * @param indexEndpoint Required. The name of the IndexEndpoint resource into which to deploy an
   *     Index. Format: `projects/{project}/locations/{location}/indexEndpoints/{index_endpoint}`
   * @param deployedIndex Required. The DeployedIndex to be created within the IndexEndpoint.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeployIndexResponse, DeployIndexOperationMetadata> deployIndexAsync(
      IndexEndpointName indexEndpoint, DeployedIndex deployedIndex) {
    DeployIndexRequest request =
        DeployIndexRequest.newBuilder()
            .setIndexEndpoint(indexEndpoint == null ? null : indexEndpoint.toString())
            .setDeployedIndex(deployedIndex)
            .build();
    return deployIndexAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys an Index into this IndexEndpoint, creating a DeployedIndex within it. Only non-empty
   * Indexes can be deployed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   String indexEndpoint =
   *       IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString();
   *   DeployedIndex deployedIndex = DeployedIndex.newBuilder().build();
   *   DeployIndexResponse response =
   *       indexEndpointServiceClient.deployIndexAsync(indexEndpoint, deployedIndex).get();
   * }
   * }</pre>
   *
   * @param indexEndpoint Required. The name of the IndexEndpoint resource into which to deploy an
   *     Index. Format: `projects/{project}/locations/{location}/indexEndpoints/{index_endpoint}`
   * @param deployedIndex Required. The DeployedIndex to be created within the IndexEndpoint.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeployIndexResponse, DeployIndexOperationMetadata> deployIndexAsync(
      String indexEndpoint, DeployedIndex deployedIndex) {
    DeployIndexRequest request =
        DeployIndexRequest.newBuilder()
            .setIndexEndpoint(indexEndpoint)
            .setDeployedIndex(deployedIndex)
            .build();
    return deployIndexAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys an Index into this IndexEndpoint, creating a DeployedIndex within it. Only non-empty
   * Indexes can be deployed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   DeployIndexRequest request =
   *       DeployIndexRequest.newBuilder()
   *           .setIndexEndpoint(
   *               IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
   *           .setDeployedIndex(DeployedIndex.newBuilder().build())
   *           .build();
   *   DeployIndexResponse response = indexEndpointServiceClient.deployIndexAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeployIndexResponse, DeployIndexOperationMetadata> deployIndexAsync(
      DeployIndexRequest request) {
    return deployIndexOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys an Index into this IndexEndpoint, creating a DeployedIndex within it. Only non-empty
   * Indexes can be deployed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   DeployIndexRequest request =
   *       DeployIndexRequest.newBuilder()
   *           .setIndexEndpoint(
   *               IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
   *           .setDeployedIndex(DeployedIndex.newBuilder().build())
   *           .build();
   *   OperationFuture<DeployIndexResponse, DeployIndexOperationMetadata> future =
   *       indexEndpointServiceClient.deployIndexOperationCallable().futureCall(request);
   *   // Do something.
   *   DeployIndexResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeployIndexRequest, DeployIndexResponse, DeployIndexOperationMetadata>
      deployIndexOperationCallable() {
    return stub.deployIndexOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys an Index into this IndexEndpoint, creating a DeployedIndex within it. Only non-empty
   * Indexes can be deployed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   DeployIndexRequest request =
   *       DeployIndexRequest.newBuilder()
   *           .setIndexEndpoint(
   *               IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
   *           .setDeployedIndex(DeployedIndex.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       indexEndpointServiceClient.deployIndexCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeployIndexRequest, Operation> deployIndexCallable() {
    return stub.deployIndexCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys an Index from an IndexEndpoint, removing a DeployedIndex from it, and freeing all
   * resources it's using.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   IndexEndpointName indexEndpoint =
   *       IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]");
   *   String deployedIndexId = "deployedIndexId-1101212953";
   *   UndeployIndexResponse response =
   *       indexEndpointServiceClient.undeployIndexAsync(indexEndpoint, deployedIndexId).get();
   * }
   * }</pre>
   *
   * @param indexEndpoint Required. The name of the IndexEndpoint resource from which to undeploy an
   *     Index. Format: `projects/{project}/locations/{location}/indexEndpoints/{index_endpoint}`
   * @param deployedIndexId Required. The ID of the DeployedIndex to be undeployed from the
   *     IndexEndpoint.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UndeployIndexResponse, UndeployIndexOperationMetadata>
      undeployIndexAsync(IndexEndpointName indexEndpoint, String deployedIndexId) {
    UndeployIndexRequest request =
        UndeployIndexRequest.newBuilder()
            .setIndexEndpoint(indexEndpoint == null ? null : indexEndpoint.toString())
            .setDeployedIndexId(deployedIndexId)
            .build();
    return undeployIndexAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys an Index from an IndexEndpoint, removing a DeployedIndex from it, and freeing all
   * resources it's using.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   String indexEndpoint =
   *       IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString();
   *   String deployedIndexId = "deployedIndexId-1101212953";
   *   UndeployIndexResponse response =
   *       indexEndpointServiceClient.undeployIndexAsync(indexEndpoint, deployedIndexId).get();
   * }
   * }</pre>
   *
   * @param indexEndpoint Required. The name of the IndexEndpoint resource from which to undeploy an
   *     Index. Format: `projects/{project}/locations/{location}/indexEndpoints/{index_endpoint}`
   * @param deployedIndexId Required. The ID of the DeployedIndex to be undeployed from the
   *     IndexEndpoint.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UndeployIndexResponse, UndeployIndexOperationMetadata>
      undeployIndexAsync(String indexEndpoint, String deployedIndexId) {
    UndeployIndexRequest request =
        UndeployIndexRequest.newBuilder()
            .setIndexEndpoint(indexEndpoint)
            .setDeployedIndexId(deployedIndexId)
            .build();
    return undeployIndexAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys an Index from an IndexEndpoint, removing a DeployedIndex from it, and freeing all
   * resources it's using.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   UndeployIndexRequest request =
   *       UndeployIndexRequest.newBuilder()
   *           .setIndexEndpoint(
   *               IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
   *           .setDeployedIndexId("deployedIndexId-1101212953")
   *           .build();
   *   UndeployIndexResponse response = indexEndpointServiceClient.undeployIndexAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UndeployIndexResponse, UndeployIndexOperationMetadata>
      undeployIndexAsync(UndeployIndexRequest request) {
    return undeployIndexOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys an Index from an IndexEndpoint, removing a DeployedIndex from it, and freeing all
   * resources it's using.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   UndeployIndexRequest request =
   *       UndeployIndexRequest.newBuilder()
   *           .setIndexEndpoint(
   *               IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
   *           .setDeployedIndexId("deployedIndexId-1101212953")
   *           .build();
   *   OperationFuture<UndeployIndexResponse, UndeployIndexOperationMetadata> future =
   *       indexEndpointServiceClient.undeployIndexOperationCallable().futureCall(request);
   *   // Do something.
   *   UndeployIndexResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UndeployIndexRequest, UndeployIndexResponse, UndeployIndexOperationMetadata>
      undeployIndexOperationCallable() {
    return stub.undeployIndexOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys an Index from an IndexEndpoint, removing a DeployedIndex from it, and freeing all
   * resources it's using.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   UndeployIndexRequest request =
   *       UndeployIndexRequest.newBuilder()
   *           .setIndexEndpoint(
   *               IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
   *           .setDeployedIndexId("deployedIndexId-1101212953")
   *           .build();
   *   ApiFuture<Operation> future =
   *       indexEndpointServiceClient.undeployIndexCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UndeployIndexRequest, Operation> undeployIndexCallable() {
    return stub.undeployIndexCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update an existing DeployedIndex under an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   IndexEndpointName indexEndpoint =
   *       IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]");
   *   DeployedIndex deployedIndex = DeployedIndex.newBuilder().build();
   *   MutateDeployedIndexResponse response =
   *       indexEndpointServiceClient.mutateDeployedIndexAsync(indexEndpoint, deployedIndex).get();
   * }
   * }</pre>
   *
   * @param indexEndpoint Required. The name of the IndexEndpoint resource into which to deploy an
   *     Index. Format: `projects/{project}/locations/{location}/indexEndpoints/{index_endpoint}`
   * @param deployedIndex Required. The DeployedIndex to be updated within the IndexEndpoint.
   *     Currently, the updatable fields are [DeployedIndex][automatic_resources] and
   *     [DeployedIndex][dedicated_resources]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MutateDeployedIndexResponse, MutateDeployedIndexOperationMetadata>
      mutateDeployedIndexAsync(IndexEndpointName indexEndpoint, DeployedIndex deployedIndex) {
    MutateDeployedIndexRequest request =
        MutateDeployedIndexRequest.newBuilder()
            .setIndexEndpoint(indexEndpoint == null ? null : indexEndpoint.toString())
            .setDeployedIndex(deployedIndex)
            .build();
    return mutateDeployedIndexAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update an existing DeployedIndex under an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   String indexEndpoint =
   *       IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString();
   *   DeployedIndex deployedIndex = DeployedIndex.newBuilder().build();
   *   MutateDeployedIndexResponse response =
   *       indexEndpointServiceClient.mutateDeployedIndexAsync(indexEndpoint, deployedIndex).get();
   * }
   * }</pre>
   *
   * @param indexEndpoint Required. The name of the IndexEndpoint resource into which to deploy an
   *     Index. Format: `projects/{project}/locations/{location}/indexEndpoints/{index_endpoint}`
   * @param deployedIndex Required. The DeployedIndex to be updated within the IndexEndpoint.
   *     Currently, the updatable fields are [DeployedIndex][automatic_resources] and
   *     [DeployedIndex][dedicated_resources]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MutateDeployedIndexResponse, MutateDeployedIndexOperationMetadata>
      mutateDeployedIndexAsync(String indexEndpoint, DeployedIndex deployedIndex) {
    MutateDeployedIndexRequest request =
        MutateDeployedIndexRequest.newBuilder()
            .setIndexEndpoint(indexEndpoint)
            .setDeployedIndex(deployedIndex)
            .build();
    return mutateDeployedIndexAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update an existing DeployedIndex under an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   MutateDeployedIndexRequest request =
   *       MutateDeployedIndexRequest.newBuilder()
   *           .setIndexEndpoint(
   *               IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
   *           .setDeployedIndex(DeployedIndex.newBuilder().build())
   *           .build();
   *   MutateDeployedIndexResponse response =
   *       indexEndpointServiceClient.mutateDeployedIndexAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MutateDeployedIndexResponse, MutateDeployedIndexOperationMetadata>
      mutateDeployedIndexAsync(MutateDeployedIndexRequest request) {
    return mutateDeployedIndexOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update an existing DeployedIndex under an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   MutateDeployedIndexRequest request =
   *       MutateDeployedIndexRequest.newBuilder()
   *           .setIndexEndpoint(
   *               IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
   *           .setDeployedIndex(DeployedIndex.newBuilder().build())
   *           .build();
   *   OperationFuture<MutateDeployedIndexResponse, MutateDeployedIndexOperationMetadata> future =
   *       indexEndpointServiceClient.mutateDeployedIndexOperationCallable().futureCall(request);
   *   // Do something.
   *   MutateDeployedIndexResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          MutateDeployedIndexRequest,
          MutateDeployedIndexResponse,
          MutateDeployedIndexOperationMetadata>
      mutateDeployedIndexOperationCallable() {
    return stub.mutateDeployedIndexOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update an existing DeployedIndex under an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   MutateDeployedIndexRequest request =
   *       MutateDeployedIndexRequest.newBuilder()
   *           .setIndexEndpoint(
   *               IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
   *           .setDeployedIndex(DeployedIndex.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       indexEndpointServiceClient.mutateDeployedIndexCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<MutateDeployedIndexRequest, Operation> mutateDeployedIndexCallable() {
    return stub.mutateDeployedIndexCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : indexEndpointServiceClient.listLocations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLocationsPagedResponse listLocations(ListLocationsRequest request) {
    return listLocationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       indexEndpointServiceClient.listLocationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Location element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return stub.listLocationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         indexEndpointServiceClient.listLocationsCallable().call(request);
   *     for (Location element : response.getLocationsList()) {
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
  public final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return stub.listLocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = indexEndpointServiceClient.getLocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Location getLocation(GetLocationRequest request) {
    return getLocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       indexEndpointServiceClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = indexEndpointServiceClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       indexEndpointServiceClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = indexEndpointServiceClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       indexEndpointServiceClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = indexEndpointServiceClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IndexEndpointServiceClient indexEndpointServiceClient =
   *     IndexEndpointServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       indexEndpointServiceClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
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

  public static class ListIndexEndpointsPagedResponse
      extends AbstractPagedListResponse<
          ListIndexEndpointsRequest,
          ListIndexEndpointsResponse,
          IndexEndpoint,
          ListIndexEndpointsPage,
          ListIndexEndpointsFixedSizeCollection> {

    public static ApiFuture<ListIndexEndpointsPagedResponse> createAsync(
        PageContext<ListIndexEndpointsRequest, ListIndexEndpointsResponse, IndexEndpoint> context,
        ApiFuture<ListIndexEndpointsResponse> futureResponse) {
      ApiFuture<ListIndexEndpointsPage> futurePage =
          ListIndexEndpointsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListIndexEndpointsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListIndexEndpointsPagedResponse(ListIndexEndpointsPage page) {
      super(page, ListIndexEndpointsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListIndexEndpointsPage
      extends AbstractPage<
          ListIndexEndpointsRequest,
          ListIndexEndpointsResponse,
          IndexEndpoint,
          ListIndexEndpointsPage> {

    private ListIndexEndpointsPage(
        PageContext<ListIndexEndpointsRequest, ListIndexEndpointsResponse, IndexEndpoint> context,
        ListIndexEndpointsResponse response) {
      super(context, response);
    }

    private static ListIndexEndpointsPage createEmptyPage() {
      return new ListIndexEndpointsPage(null, null);
    }

    @Override
    protected ListIndexEndpointsPage createPage(
        PageContext<ListIndexEndpointsRequest, ListIndexEndpointsResponse, IndexEndpoint> context,
        ListIndexEndpointsResponse response) {
      return new ListIndexEndpointsPage(context, response);
    }

    @Override
    public ApiFuture<ListIndexEndpointsPage> createPageAsync(
        PageContext<ListIndexEndpointsRequest, ListIndexEndpointsResponse, IndexEndpoint> context,
        ApiFuture<ListIndexEndpointsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListIndexEndpointsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListIndexEndpointsRequest,
          ListIndexEndpointsResponse,
          IndexEndpoint,
          ListIndexEndpointsPage,
          ListIndexEndpointsFixedSizeCollection> {

    private ListIndexEndpointsFixedSizeCollection(
        List<ListIndexEndpointsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListIndexEndpointsFixedSizeCollection createEmptyCollection() {
      return new ListIndexEndpointsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListIndexEndpointsFixedSizeCollection createCollection(
        List<ListIndexEndpointsPage> pages, int collectionSize) {
      return new ListIndexEndpointsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLocationsPagedResponse
      extends AbstractPagedListResponse<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    public static ApiFuture<ListLocationsPagedResponse> createAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      ApiFuture<ListLocationsPage> futurePage =
          ListLocationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLocationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLocationsPagedResponse(ListLocationsPage page) {
      super(page, ListLocationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLocationsPage
      extends AbstractPage<
          ListLocationsRequest, ListLocationsResponse, Location, ListLocationsPage> {

    private ListLocationsPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLocationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    private ListLocationsFixedSizeCollection(List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
