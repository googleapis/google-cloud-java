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

package com.google.cloud.ids.v1;

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
import com.google.cloud.ids.v1.stub.IDSStub;
import com.google.cloud.ids.v1.stub.IDSStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The IDS Service
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
 * try (IDSClient iDSClient = IDSClient.create()) {
 *   EndpointName name = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
 *   Endpoint response = iDSClient.getEndpoint(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the IDSClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of IDSSettings to create(). For
 * example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * IDSSettings iDSSettings =
 *     IDSSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * IDSClient iDSClient = IDSClient.create(iDSSettings);
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
 * IDSSettings iDSSettings = IDSSettings.newBuilder().setEndpoint(myEndpoint).build();
 * IDSClient iDSClient = IDSClient.create(iDSSettings);
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
 * IDSSettings iDSSettings =
 *     IDSSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             IDSSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * IDSClient iDSClient = IDSClient.create(iDSSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class IDSClient implements BackgroundResource {
  private final IDSSettings settings;
  private final IDSStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of IDSClient with default settings. */
  public static final IDSClient create() throws IOException {
    return create(IDSSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of IDSClient, using the given settings. The channels are created based
   * on the settings passed in, or defaults for any settings that are not set.
   */
  public static final IDSClient create(IDSSettings settings) throws IOException {
    return new IDSClient(settings);
  }

  /**
   * Constructs an instance of IDSClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(IDSSettings).
   */
  public static final IDSClient create(IDSStub stub) {
    return new IDSClient(stub);
  }

  /**
   * Constructs an instance of IDSClient, using the given settings. This is protected so that it is
   * easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected IDSClient(IDSSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((IDSStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected IDSClient(IDSStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final IDSSettings getSettings() {
    return settings;
  }

  public IDSStub getStub() {
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
   * Lists Endpoints in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IDSClient iDSClient = IDSClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Endpoint element : iDSClient.listEndpoints(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of endpoints.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEndpointsPagedResponse listEndpoints(LocationName parent) {
    ListEndpointsRequest request =
        ListEndpointsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEndpoints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Endpoints in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IDSClient iDSClient = IDSClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Endpoint element : iDSClient.listEndpoints(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of endpoints.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEndpointsPagedResponse listEndpoints(String parent) {
    ListEndpointsRequest request = ListEndpointsRequest.newBuilder().setParent(parent).build();
    return listEndpoints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Endpoints in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IDSClient iDSClient = IDSClient.create()) {
   *   ListEndpointsRequest request =
   *       ListEndpointsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Endpoint element : iDSClient.listEndpoints(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEndpointsPagedResponse listEndpoints(ListEndpointsRequest request) {
    return listEndpointsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Endpoints in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IDSClient iDSClient = IDSClient.create()) {
   *   ListEndpointsRequest request =
   *       ListEndpointsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Endpoint> future = iDSClient.listEndpointsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Endpoint element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEndpointsRequest, ListEndpointsPagedResponse>
      listEndpointsPagedCallable() {
    return stub.listEndpointsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Endpoints in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IDSClient iDSClient = IDSClient.create()) {
   *   ListEndpointsRequest request =
   *       ListEndpointsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListEndpointsResponse response = iDSClient.listEndpointsCallable().call(request);
   *     for (Endpoint element : response.getEndpointsList()) {
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
  public final UnaryCallable<ListEndpointsRequest, ListEndpointsResponse> listEndpointsCallable() {
    return stub.listEndpointsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IDSClient iDSClient = IDSClient.create()) {
   *   EndpointName name = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
   *   Endpoint response = iDSClient.getEndpoint(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the endpoint to retrieve. Format:
   *     `projects/{project}/locations/{location}/endpoints/{endpoint}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Endpoint getEndpoint(EndpointName name) {
    GetEndpointRequest request =
        GetEndpointRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEndpoint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IDSClient iDSClient = IDSClient.create()) {
   *   String name = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString();
   *   Endpoint response = iDSClient.getEndpoint(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the endpoint to retrieve. Format:
   *     `projects/{project}/locations/{location}/endpoints/{endpoint}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Endpoint getEndpoint(String name) {
    GetEndpointRequest request = GetEndpointRequest.newBuilder().setName(name).build();
    return getEndpoint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IDSClient iDSClient = IDSClient.create()) {
   *   GetEndpointRequest request =
   *       GetEndpointRequest.newBuilder()
   *           .setName(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
   *           .build();
   *   Endpoint response = iDSClient.getEndpoint(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Endpoint getEndpoint(GetEndpointRequest request) {
    return getEndpointCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IDSClient iDSClient = IDSClient.create()) {
   *   GetEndpointRequest request =
   *       GetEndpointRequest.newBuilder()
   *           .setName(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
   *           .build();
   *   ApiFuture<Endpoint> future = iDSClient.getEndpointCallable().futureCall(request);
   *   // Do something.
   *   Endpoint response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEndpointRequest, Endpoint> getEndpointCallable() {
    return stub.getEndpointCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Endpoint in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IDSClient iDSClient = IDSClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Endpoint endpoint = Endpoint.newBuilder().build();
   *   String endpointId = "endpointId-1837754992";
   *   Endpoint response = iDSClient.createEndpointAsync(parent, endpoint, endpointId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The endpoint's parent.
   * @param endpoint Required. The endpoint to create.
   * @param endpointId Required. The endpoint identifier. This will be part of the endpoint's
   *     resource name. This value must start with a lowercase letter followed by up to 62 lowercase
   *     letters, numbers, or hyphens, and cannot end with a hyphen. Values that do not match this
   *     pattern will trigger an INVALID_ARGUMENT error.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Endpoint, OperationMetadata> createEndpointAsync(
      LocationName parent, Endpoint endpoint, String endpointId) {
    CreateEndpointRequest request =
        CreateEndpointRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEndpoint(endpoint)
            .setEndpointId(endpointId)
            .build();
    return createEndpointAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Endpoint in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IDSClient iDSClient = IDSClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Endpoint endpoint = Endpoint.newBuilder().build();
   *   String endpointId = "endpointId-1837754992";
   *   Endpoint response = iDSClient.createEndpointAsync(parent, endpoint, endpointId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The endpoint's parent.
   * @param endpoint Required. The endpoint to create.
   * @param endpointId Required. The endpoint identifier. This will be part of the endpoint's
   *     resource name. This value must start with a lowercase letter followed by up to 62 lowercase
   *     letters, numbers, or hyphens, and cannot end with a hyphen. Values that do not match this
   *     pattern will trigger an INVALID_ARGUMENT error.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Endpoint, OperationMetadata> createEndpointAsync(
      String parent, Endpoint endpoint, String endpointId) {
    CreateEndpointRequest request =
        CreateEndpointRequest.newBuilder()
            .setParent(parent)
            .setEndpoint(endpoint)
            .setEndpointId(endpointId)
            .build();
    return createEndpointAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Endpoint in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IDSClient iDSClient = IDSClient.create()) {
   *   CreateEndpointRequest request =
   *       CreateEndpointRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEndpointId("endpointId-1837754992")
   *           .setEndpoint(Endpoint.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Endpoint response = iDSClient.createEndpointAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Endpoint, OperationMetadata> createEndpointAsync(
      CreateEndpointRequest request) {
    return createEndpointOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Endpoint in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IDSClient iDSClient = IDSClient.create()) {
   *   CreateEndpointRequest request =
   *       CreateEndpointRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEndpointId("endpointId-1837754992")
   *           .setEndpoint(Endpoint.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Endpoint, OperationMetadata> future =
   *       iDSClient.createEndpointOperationCallable().futureCall(request);
   *   // Do something.
   *   Endpoint response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateEndpointRequest, Endpoint, OperationMetadata>
      createEndpointOperationCallable() {
    return stub.createEndpointOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Endpoint in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IDSClient iDSClient = IDSClient.create()) {
   *   CreateEndpointRequest request =
   *       CreateEndpointRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEndpointId("endpointId-1837754992")
   *           .setEndpoint(Endpoint.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = iDSClient.createEndpointCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateEndpointRequest, Operation> createEndpointCallable() {
    return stub.createEndpointCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IDSClient iDSClient = IDSClient.create()) {
   *   EndpointName name = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
   *   iDSClient.deleteEndpointAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the endpoint to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEndpointAsync(EndpointName name) {
    DeleteEndpointRequest request =
        DeleteEndpointRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteEndpointAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IDSClient iDSClient = IDSClient.create()) {
   *   String name = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString();
   *   iDSClient.deleteEndpointAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the endpoint to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEndpointAsync(String name) {
    DeleteEndpointRequest request = DeleteEndpointRequest.newBuilder().setName(name).build();
    return deleteEndpointAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IDSClient iDSClient = IDSClient.create()) {
   *   DeleteEndpointRequest request =
   *       DeleteEndpointRequest.newBuilder()
   *           .setName(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   iDSClient.deleteEndpointAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEndpointAsync(
      DeleteEndpointRequest request) {
    return deleteEndpointOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IDSClient iDSClient = IDSClient.create()) {
   *   DeleteEndpointRequest request =
   *       DeleteEndpointRequest.newBuilder()
   *           .setName(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       iDSClient.deleteEndpointOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteEndpointRequest, Empty, OperationMetadata>
      deleteEndpointOperationCallable() {
    return stub.deleteEndpointOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IDSClient iDSClient = IDSClient.create()) {
   *   DeleteEndpointRequest request =
   *       DeleteEndpointRequest.newBuilder()
   *           .setName(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = iDSClient.deleteEndpointCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteEndpointRequest, Operation> deleteEndpointCallable() {
    return stub.deleteEndpointCallable();
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

  public static class ListEndpointsPagedResponse
      extends AbstractPagedListResponse<
          ListEndpointsRequest,
          ListEndpointsResponse,
          Endpoint,
          ListEndpointsPage,
          ListEndpointsFixedSizeCollection> {

    public static ApiFuture<ListEndpointsPagedResponse> createAsync(
        PageContext<ListEndpointsRequest, ListEndpointsResponse, Endpoint> context,
        ApiFuture<ListEndpointsResponse> futureResponse) {
      ApiFuture<ListEndpointsPage> futurePage =
          ListEndpointsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEndpointsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEndpointsPagedResponse(ListEndpointsPage page) {
      super(page, ListEndpointsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEndpointsPage
      extends AbstractPage<
          ListEndpointsRequest, ListEndpointsResponse, Endpoint, ListEndpointsPage> {

    private ListEndpointsPage(
        PageContext<ListEndpointsRequest, ListEndpointsResponse, Endpoint> context,
        ListEndpointsResponse response) {
      super(context, response);
    }

    private static ListEndpointsPage createEmptyPage() {
      return new ListEndpointsPage(null, null);
    }

    @Override
    protected ListEndpointsPage createPage(
        PageContext<ListEndpointsRequest, ListEndpointsResponse, Endpoint> context,
        ListEndpointsResponse response) {
      return new ListEndpointsPage(context, response);
    }

    @Override
    public ApiFuture<ListEndpointsPage> createPageAsync(
        PageContext<ListEndpointsRequest, ListEndpointsResponse, Endpoint> context,
        ApiFuture<ListEndpointsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEndpointsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEndpointsRequest,
          ListEndpointsResponse,
          Endpoint,
          ListEndpointsPage,
          ListEndpointsFixedSizeCollection> {

    private ListEndpointsFixedSizeCollection(List<ListEndpointsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEndpointsFixedSizeCollection createEmptyCollection() {
      return new ListEndpointsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEndpointsFixedSizeCollection createCollection(
        List<ListEndpointsPage> pages, int collectionSize) {
      return new ListEndpointsFixedSizeCollection(pages, collectionSize);
    }
  }
}
