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
import com.google.cloud.aiplatform.v1beta1.stub.EndpointServiceStub;
import com.google.cloud.aiplatform.v1beta1.stub.EndpointServiceStubSettings;
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
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service for managing Vertex AI's Endpoints.
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
 * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
 *   EndpointName name = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
 *   Endpoint response = endpointServiceClient.getEndpoint(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the EndpointServiceClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of EndpointServiceSettings to
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
 * EndpointServiceSettings endpointServiceSettings =
 *     EndpointServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * EndpointServiceClient endpointServiceClient =
 *     EndpointServiceClient.create(endpointServiceSettings);
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
 * EndpointServiceSettings endpointServiceSettings =
 *     EndpointServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * EndpointServiceClient endpointServiceClient =
 *     EndpointServiceClient.create(endpointServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class EndpointServiceClient implements BackgroundResource {
  private final EndpointServiceSettings settings;
  private final EndpointServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of EndpointServiceClient with default settings. */
  public static final EndpointServiceClient create() throws IOException {
    return create(EndpointServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of EndpointServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final EndpointServiceClient create(EndpointServiceSettings settings)
      throws IOException {
    return new EndpointServiceClient(settings);
  }

  /**
   * Constructs an instance of EndpointServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(EndpointServiceSettings).
   */
  public static final EndpointServiceClient create(EndpointServiceStub stub) {
    return new EndpointServiceClient(stub);
  }

  /**
   * Constructs an instance of EndpointServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected EndpointServiceClient(EndpointServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((EndpointServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected EndpointServiceClient(EndpointServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final EndpointServiceSettings getSettings() {
    return settings;
  }

  public EndpointServiceStub getStub() {
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
   * Creates an Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Endpoint endpoint = Endpoint.newBuilder().build();
   *   Endpoint response = endpointServiceClient.createEndpointAsync(parent, endpoint).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the Endpoint in. Format:
   *     `projects/{project}/locations/{location}`
   * @param endpoint Required. The Endpoint to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Endpoint, CreateEndpointOperationMetadata> createEndpointAsync(
      LocationName parent, Endpoint endpoint) {
    CreateEndpointRequest request =
        CreateEndpointRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEndpoint(endpoint)
            .build();
    return createEndpointAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Endpoint endpoint = Endpoint.newBuilder().build();
   *   Endpoint response = endpointServiceClient.createEndpointAsync(parent, endpoint).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the Endpoint in. Format:
   *     `projects/{project}/locations/{location}`
   * @param endpoint Required. The Endpoint to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Endpoint, CreateEndpointOperationMetadata> createEndpointAsync(
      String parent, Endpoint endpoint) {
    CreateEndpointRequest request =
        CreateEndpointRequest.newBuilder().setParent(parent).setEndpoint(endpoint).build();
    return createEndpointAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Endpoint endpoint = Endpoint.newBuilder().build();
   *   String endpointId = "endpointId-1837754992";
   *   Endpoint response =
   *       endpointServiceClient.createEndpointAsync(parent, endpoint, endpointId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the Endpoint in. Format:
   *     `projects/{project}/locations/{location}`
   * @param endpoint Required. The Endpoint to create.
   * @param endpointId Immutable. The ID to use for endpoint, which will become the final component
   *     of the endpoint resource name. If not provided, Vertex AI will generate a value for this
   *     ID.
   *     <p>This value should be 1-10 characters, and valid characters are /[0-9]/. When using
   *     HTTP/JSON, this field is populated based on a query string argument, such as
   *     `?endpoint_id=12345`. This is the fallback for fields that are not included in either the
   *     URI or the body.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Endpoint, CreateEndpointOperationMetadata> createEndpointAsync(
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
   * Creates an Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Endpoint endpoint = Endpoint.newBuilder().build();
   *   String endpointId = "endpointId-1837754992";
   *   Endpoint response =
   *       endpointServiceClient.createEndpointAsync(parent, endpoint, endpointId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the Endpoint in. Format:
   *     `projects/{project}/locations/{location}`
   * @param endpoint Required. The Endpoint to create.
   * @param endpointId Immutable. The ID to use for endpoint, which will become the final component
   *     of the endpoint resource name. If not provided, Vertex AI will generate a value for this
   *     ID.
   *     <p>This value should be 1-10 characters, and valid characters are /[0-9]/. When using
   *     HTTP/JSON, this field is populated based on a query string argument, such as
   *     `?endpoint_id=12345`. This is the fallback for fields that are not included in either the
   *     URI or the body.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Endpoint, CreateEndpointOperationMetadata> createEndpointAsync(
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
   * Creates an Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   CreateEndpointRequest request =
   *       CreateEndpointRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEndpoint(Endpoint.newBuilder().build())
   *           .setEndpointId("endpointId-1837754992")
   *           .build();
   *   Endpoint response = endpointServiceClient.createEndpointAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Endpoint, CreateEndpointOperationMetadata> createEndpointAsync(
      CreateEndpointRequest request) {
    return createEndpointOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   CreateEndpointRequest request =
   *       CreateEndpointRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEndpoint(Endpoint.newBuilder().build())
   *           .setEndpointId("endpointId-1837754992")
   *           .build();
   *   OperationFuture<Endpoint, CreateEndpointOperationMetadata> future =
   *       endpointServiceClient.createEndpointOperationCallable().futureCall(request);
   *   // Do something.
   *   Endpoint response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateEndpointRequest, Endpoint, CreateEndpointOperationMetadata>
      createEndpointOperationCallable() {
    return stub.createEndpointOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   CreateEndpointRequest request =
   *       CreateEndpointRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEndpoint(Endpoint.newBuilder().build())
   *           .setEndpointId("endpointId-1837754992")
   *           .build();
   *   ApiFuture<Operation> future =
   *       endpointServiceClient.createEndpointCallable().futureCall(request);
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
   * Gets an Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   EndpointName name = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
   *   Endpoint response = endpointServiceClient.getEndpoint(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Endpoint resource. Format:
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
   * Gets an Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   String name = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString();
   *   Endpoint response = endpointServiceClient.getEndpoint(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Endpoint resource. Format:
   *     `projects/{project}/locations/{location}/endpoints/{endpoint}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Endpoint getEndpoint(String name) {
    GetEndpointRequest request = GetEndpointRequest.newBuilder().setName(name).build();
    return getEndpoint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   GetEndpointRequest request =
   *       GetEndpointRequest.newBuilder()
   *           .setName(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
   *           .build();
   *   Endpoint response = endpointServiceClient.getEndpoint(request);
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
   * Gets an Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   GetEndpointRequest request =
   *       GetEndpointRequest.newBuilder()
   *           .setName(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
   *           .build();
   *   ApiFuture<Endpoint> future = endpointServiceClient.getEndpointCallable().futureCall(request);
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
   * Lists Endpoints in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Endpoint element : endpointServiceClient.listEndpoints(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location from which to list the Endpoints.
   *     Format: `projects/{project}/locations/{location}`
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
   * Lists Endpoints in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Endpoint element : endpointServiceClient.listEndpoints(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location from which to list the Endpoints.
   *     Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEndpointsPagedResponse listEndpoints(String parent) {
    ListEndpointsRequest request = ListEndpointsRequest.newBuilder().setParent(parent).build();
    return listEndpoints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Endpoints in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   ListEndpointsRequest request =
   *       ListEndpointsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   for (Endpoint element : endpointServiceClient.listEndpoints(request).iterateAll()) {
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
   * Lists Endpoints in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   ListEndpointsRequest request =
   *       ListEndpointsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Endpoint> future =
   *       endpointServiceClient.listEndpointsPagedCallable().futureCall(request);
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
   * Lists Endpoints in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   ListEndpointsRequest request =
   *       ListEndpointsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   while (true) {
   *     ListEndpointsResponse response =
   *         endpointServiceClient.listEndpointsCallable().call(request);
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
   * Updates an Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   Endpoint endpoint = Endpoint.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Endpoint response = endpointServiceClient.updateEndpoint(endpoint, updateMask);
   * }
   * }</pre>
   *
   * @param endpoint Required. The Endpoint which replaces the resource on the server.
   * @param updateMask Required. The update mask applies to the resource. See
   *     [google.protobuf.FieldMask][google.protobuf.FieldMask].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Endpoint updateEndpoint(Endpoint endpoint, FieldMask updateMask) {
    UpdateEndpointRequest request =
        UpdateEndpointRequest.newBuilder().setEndpoint(endpoint).setUpdateMask(updateMask).build();
    return updateEndpoint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   UpdateEndpointRequest request =
   *       UpdateEndpointRequest.newBuilder()
   *           .setEndpoint(Endpoint.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Endpoint response = endpointServiceClient.updateEndpoint(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Endpoint updateEndpoint(UpdateEndpointRequest request) {
    return updateEndpointCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   UpdateEndpointRequest request =
   *       UpdateEndpointRequest.newBuilder()
   *           .setEndpoint(Endpoint.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Endpoint> future =
   *       endpointServiceClient.updateEndpointCallable().futureCall(request);
   *   // Do something.
   *   Endpoint response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateEndpointRequest, Endpoint> updateEndpointCallable() {
    return stub.updateEndpointCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   EndpointName name = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
   *   endpointServiceClient.deleteEndpointAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Endpoint resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/endpoints/{endpoint}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteEndpointAsync(
      EndpointName name) {
    DeleteEndpointRequest request =
        DeleteEndpointRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteEndpointAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   String name = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString();
   *   endpointServiceClient.deleteEndpointAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Endpoint resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/endpoints/{endpoint}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteEndpointAsync(String name) {
    DeleteEndpointRequest request = DeleteEndpointRequest.newBuilder().setName(name).build();
    return deleteEndpointAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   DeleteEndpointRequest request =
   *       DeleteEndpointRequest.newBuilder()
   *           .setName(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
   *           .build();
   *   endpointServiceClient.deleteEndpointAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteEndpointAsync(
      DeleteEndpointRequest request) {
    return deleteEndpointOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   DeleteEndpointRequest request =
   *       DeleteEndpointRequest.newBuilder()
   *           .setName(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       endpointServiceClient.deleteEndpointOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteEndpointRequest, Empty, DeleteOperationMetadata>
      deleteEndpointOperationCallable() {
    return stub.deleteEndpointOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   DeleteEndpointRequest request =
   *       DeleteEndpointRequest.newBuilder()
   *           .setName(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       endpointServiceClient.deleteEndpointCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteEndpointRequest, Operation> deleteEndpointCallable() {
    return stub.deleteEndpointCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys a Model into this Endpoint, creating a DeployedModel within it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   EndpointName endpoint = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
   *   DeployedModel deployedModel = DeployedModel.newBuilder().build();
   *   Map<String, Integer> trafficSplit = new HashMap<>();
   *   DeployModelResponse response =
   *       endpointServiceClient.deployModelAsync(endpoint, deployedModel, trafficSplit).get();
   * }
   * }</pre>
   *
   * @param endpoint Required. The name of the Endpoint resource into which to deploy a Model.
   *     Format: `projects/{project}/locations/{location}/endpoints/{endpoint}`
   * @param deployedModel Required. The DeployedModel to be created within the Endpoint. Note that
   *     [Endpoint.traffic_split][google.cloud.aiplatform.v1beta1.Endpoint.traffic_split] must be
   *     updated for the DeployedModel to start receiving traffic, either as part of this call, or
   *     via
   *     [EndpointService.UpdateEndpoint][google.cloud.aiplatform.v1beta1.EndpointService.UpdateEndpoint].
   * @param trafficSplit A map from a DeployedModel's ID to the percentage of this Endpoint's
   *     traffic that should be forwarded to that DeployedModel.
   *     <p>If this field is non-empty, then the Endpoint's
   *     [traffic_split][google.cloud.aiplatform.v1beta1.Endpoint.traffic_split] will be overwritten
   *     with it. To refer to the ID of the just being deployed Model, a "0" should be used, and the
   *     actual ID of the new DeployedModel will be filled in its place by this method. The traffic
   *     percentage values must add up to 100.
   *     <p>If this field is empty, then the Endpoint's
   *     [traffic_split][google.cloud.aiplatform.v1beta1.Endpoint.traffic_split] is not updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeployModelResponse, DeployModelOperationMetadata> deployModelAsync(
      EndpointName endpoint, DeployedModel deployedModel, Map<String, Integer> trafficSplit) {
    DeployModelRequest request =
        DeployModelRequest.newBuilder()
            .setEndpoint(endpoint == null ? null : endpoint.toString())
            .setDeployedModel(deployedModel)
            .putAllTrafficSplit(trafficSplit)
            .build();
    return deployModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys a Model into this Endpoint, creating a DeployedModel within it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   String endpoint = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString();
   *   DeployedModel deployedModel = DeployedModel.newBuilder().build();
   *   Map<String, Integer> trafficSplit = new HashMap<>();
   *   DeployModelResponse response =
   *       endpointServiceClient.deployModelAsync(endpoint, deployedModel, trafficSplit).get();
   * }
   * }</pre>
   *
   * @param endpoint Required. The name of the Endpoint resource into which to deploy a Model.
   *     Format: `projects/{project}/locations/{location}/endpoints/{endpoint}`
   * @param deployedModel Required. The DeployedModel to be created within the Endpoint. Note that
   *     [Endpoint.traffic_split][google.cloud.aiplatform.v1beta1.Endpoint.traffic_split] must be
   *     updated for the DeployedModel to start receiving traffic, either as part of this call, or
   *     via
   *     [EndpointService.UpdateEndpoint][google.cloud.aiplatform.v1beta1.EndpointService.UpdateEndpoint].
   * @param trafficSplit A map from a DeployedModel's ID to the percentage of this Endpoint's
   *     traffic that should be forwarded to that DeployedModel.
   *     <p>If this field is non-empty, then the Endpoint's
   *     [traffic_split][google.cloud.aiplatform.v1beta1.Endpoint.traffic_split] will be overwritten
   *     with it. To refer to the ID of the just being deployed Model, a "0" should be used, and the
   *     actual ID of the new DeployedModel will be filled in its place by this method. The traffic
   *     percentage values must add up to 100.
   *     <p>If this field is empty, then the Endpoint's
   *     [traffic_split][google.cloud.aiplatform.v1beta1.Endpoint.traffic_split] is not updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeployModelResponse, DeployModelOperationMetadata> deployModelAsync(
      String endpoint, DeployedModel deployedModel, Map<String, Integer> trafficSplit) {
    DeployModelRequest request =
        DeployModelRequest.newBuilder()
            .setEndpoint(endpoint)
            .setDeployedModel(deployedModel)
            .putAllTrafficSplit(trafficSplit)
            .build();
    return deployModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys a Model into this Endpoint, creating a DeployedModel within it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   DeployModelRequest request =
   *       DeployModelRequest.newBuilder()
   *           .setEndpoint(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
   *           .setDeployedModel(DeployedModel.newBuilder().build())
   *           .putAllTrafficSplit(new HashMap<String, Integer>())
   *           .build();
   *   DeployModelResponse response = endpointServiceClient.deployModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeployModelResponse, DeployModelOperationMetadata> deployModelAsync(
      DeployModelRequest request) {
    return deployModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys a Model into this Endpoint, creating a DeployedModel within it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   DeployModelRequest request =
   *       DeployModelRequest.newBuilder()
   *           .setEndpoint(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
   *           .setDeployedModel(DeployedModel.newBuilder().build())
   *           .putAllTrafficSplit(new HashMap<String, Integer>())
   *           .build();
   *   OperationFuture<DeployModelResponse, DeployModelOperationMetadata> future =
   *       endpointServiceClient.deployModelOperationCallable().futureCall(request);
   *   // Do something.
   *   DeployModelResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeployModelRequest, DeployModelResponse, DeployModelOperationMetadata>
      deployModelOperationCallable() {
    return stub.deployModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys a Model into this Endpoint, creating a DeployedModel within it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   DeployModelRequest request =
   *       DeployModelRequest.newBuilder()
   *           .setEndpoint(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
   *           .setDeployedModel(DeployedModel.newBuilder().build())
   *           .putAllTrafficSplit(new HashMap<String, Integer>())
   *           .build();
   *   ApiFuture<Operation> future = endpointServiceClient.deployModelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeployModelRequest, Operation> deployModelCallable() {
    return stub.deployModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys a Model from an Endpoint, removing a DeployedModel from it, and freeing all resources
   * it's using.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   EndpointName endpoint = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
   *   String deployedModelId = "deployedModelId-1817547906";
   *   Map<String, Integer> trafficSplit = new HashMap<>();
   *   UndeployModelResponse response =
   *       endpointServiceClient.undeployModelAsync(endpoint, deployedModelId, trafficSplit).get();
   * }
   * }</pre>
   *
   * @param endpoint Required. The name of the Endpoint resource from which to undeploy a Model.
   *     Format: `projects/{project}/locations/{location}/endpoints/{endpoint}`
   * @param deployedModelId Required. The ID of the DeployedModel to be undeployed from the
   *     Endpoint.
   * @param trafficSplit If this field is provided, then the Endpoint's
   *     [traffic_split][google.cloud.aiplatform.v1beta1.Endpoint.traffic_split] will be overwritten
   *     with it. If last DeployedModel is being undeployed from the Endpoint, the
   *     [Endpoint.traffic_split] will always end up empty when this call returns. A DeployedModel
   *     will be successfully undeployed only if it doesn't have any traffic assigned to it when
   *     this method executes, or if this field unassigns any traffic to it.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UndeployModelResponse, UndeployModelOperationMetadata>
      undeployModelAsync(
          EndpointName endpoint, String deployedModelId, Map<String, Integer> trafficSplit) {
    UndeployModelRequest request =
        UndeployModelRequest.newBuilder()
            .setEndpoint(endpoint == null ? null : endpoint.toString())
            .setDeployedModelId(deployedModelId)
            .putAllTrafficSplit(trafficSplit)
            .build();
    return undeployModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys a Model from an Endpoint, removing a DeployedModel from it, and freeing all resources
   * it's using.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   String endpoint = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString();
   *   String deployedModelId = "deployedModelId-1817547906";
   *   Map<String, Integer> trafficSplit = new HashMap<>();
   *   UndeployModelResponse response =
   *       endpointServiceClient.undeployModelAsync(endpoint, deployedModelId, trafficSplit).get();
   * }
   * }</pre>
   *
   * @param endpoint Required. The name of the Endpoint resource from which to undeploy a Model.
   *     Format: `projects/{project}/locations/{location}/endpoints/{endpoint}`
   * @param deployedModelId Required. The ID of the DeployedModel to be undeployed from the
   *     Endpoint.
   * @param trafficSplit If this field is provided, then the Endpoint's
   *     [traffic_split][google.cloud.aiplatform.v1beta1.Endpoint.traffic_split] will be overwritten
   *     with it. If last DeployedModel is being undeployed from the Endpoint, the
   *     [Endpoint.traffic_split] will always end up empty when this call returns. A DeployedModel
   *     will be successfully undeployed only if it doesn't have any traffic assigned to it when
   *     this method executes, or if this field unassigns any traffic to it.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UndeployModelResponse, UndeployModelOperationMetadata>
      undeployModelAsync(
          String endpoint, String deployedModelId, Map<String, Integer> trafficSplit) {
    UndeployModelRequest request =
        UndeployModelRequest.newBuilder()
            .setEndpoint(endpoint)
            .setDeployedModelId(deployedModelId)
            .putAllTrafficSplit(trafficSplit)
            .build();
    return undeployModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys a Model from an Endpoint, removing a DeployedModel from it, and freeing all resources
   * it's using.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   UndeployModelRequest request =
   *       UndeployModelRequest.newBuilder()
   *           .setEndpoint(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
   *           .setDeployedModelId("deployedModelId-1817547906")
   *           .putAllTrafficSplit(new HashMap<String, Integer>())
   *           .build();
   *   UndeployModelResponse response = endpointServiceClient.undeployModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UndeployModelResponse, UndeployModelOperationMetadata>
      undeployModelAsync(UndeployModelRequest request) {
    return undeployModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys a Model from an Endpoint, removing a DeployedModel from it, and freeing all resources
   * it's using.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   UndeployModelRequest request =
   *       UndeployModelRequest.newBuilder()
   *           .setEndpoint(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
   *           .setDeployedModelId("deployedModelId-1817547906")
   *           .putAllTrafficSplit(new HashMap<String, Integer>())
   *           .build();
   *   OperationFuture<UndeployModelResponse, UndeployModelOperationMetadata> future =
   *       endpointServiceClient.undeployModelOperationCallable().futureCall(request);
   *   // Do something.
   *   UndeployModelResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UndeployModelRequest, UndeployModelResponse, UndeployModelOperationMetadata>
      undeployModelOperationCallable() {
    return stub.undeployModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys a Model from an Endpoint, removing a DeployedModel from it, and freeing all resources
   * it's using.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   UndeployModelRequest request =
   *       UndeployModelRequest.newBuilder()
   *           .setEndpoint(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
   *           .setDeployedModelId("deployedModelId-1817547906")
   *           .putAllTrafficSplit(new HashMap<String, Integer>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       endpointServiceClient.undeployModelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UndeployModelRequest, Operation> undeployModelCallable() {
    return stub.undeployModelCallable();
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
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : endpointServiceClient.listLocations(request).iterateAll()) {
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
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       endpointServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         endpointServiceClient.listLocationsCallable().call(request);
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
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = endpointServiceClient.getLocation(request);
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
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = endpointServiceClient.getLocationCallable().futureCall(request);
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
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = endpointServiceClient.setIamPolicy(request);
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
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = endpointServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = endpointServiceClient.getIamPolicy(request);
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
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = endpointServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = endpointServiceClient.testIamPermissions(request);
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
   * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       endpointServiceClient.testIamPermissionsCallable().futureCall(request);
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
