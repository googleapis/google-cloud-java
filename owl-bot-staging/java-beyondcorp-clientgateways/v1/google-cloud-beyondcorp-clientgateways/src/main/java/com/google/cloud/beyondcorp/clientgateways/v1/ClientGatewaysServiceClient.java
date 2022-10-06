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

package com.google.cloud.beyondcorp.clientgateways.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.beyondcorp.clientgateways.v1.stub.ClientGatewaysServiceStub;
import com.google.cloud.beyondcorp.clientgateways.v1.stub.ClientGatewaysServiceStubSettings;
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
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: ## API Overview
 *
 * <p>The `beyondcorp.googleapis.com` service implements the Google Cloud BeyondCorp API.
 *
 * <p>## Data Model
 *
 * <p>The ClientGatewaysService exposes the following resources:
 *
 * <ul>
 *   <li>Client Gateways, named as follows:
 *       `projects/{project_id}/locations/{location_id}/clientGateways/{client_gateway_id}`.
 * </ul>
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
 * try (ClientGatewaysServiceClient clientGatewaysServiceClient =
 *     ClientGatewaysServiceClient.create()) {
 *   ClientGatewayName name = ClientGatewayName.of("[PROJECT]", "[LOCATION]", "[CLIENT_GATEWAY]");
 *   ClientGateway response = clientGatewaysServiceClient.getClientGateway(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ClientGatewaysServiceClient object to clean up
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
 * <p>This class can be customized by passing in a custom instance of ClientGatewaysServiceSettings
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
 * ClientGatewaysServiceSettings clientGatewaysServiceSettings =
 *     ClientGatewaysServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ClientGatewaysServiceClient clientGatewaysServiceClient =
 *     ClientGatewaysServiceClient.create(clientGatewaysServiceSettings);
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
 * ClientGatewaysServiceSettings clientGatewaysServiceSettings =
 *     ClientGatewaysServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ClientGatewaysServiceClient clientGatewaysServiceClient =
 *     ClientGatewaysServiceClient.create(clientGatewaysServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ClientGatewaysServiceClient implements BackgroundResource {
  private final ClientGatewaysServiceSettings settings;
  private final ClientGatewaysServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of ClientGatewaysServiceClient with default settings. */
  public static final ClientGatewaysServiceClient create() throws IOException {
    return create(ClientGatewaysServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ClientGatewaysServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ClientGatewaysServiceClient create(ClientGatewaysServiceSettings settings)
      throws IOException {
    return new ClientGatewaysServiceClient(settings);
  }

  /**
   * Constructs an instance of ClientGatewaysServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(ClientGatewaysServiceSettings).
   */
  public static final ClientGatewaysServiceClient create(ClientGatewaysServiceStub stub) {
    return new ClientGatewaysServiceClient(stub);
  }

  /**
   * Constructs an instance of ClientGatewaysServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ClientGatewaysServiceClient(ClientGatewaysServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ClientGatewaysServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected ClientGatewaysServiceClient(ClientGatewaysServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final ClientGatewaysServiceSettings getSettings() {
    return settings;
  }

  public ClientGatewaysServiceStub getStub() {
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
   * Lists ClientGateways in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientGatewaysServiceClient clientGatewaysServiceClient =
   *     ClientGatewaysServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ClientGateway element :
   *       clientGatewaysServiceClient.listClientGateways(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListClientGatewaysRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClientGatewaysPagedResponse listClientGateways(LocationName parent) {
    ListClientGatewaysRequest request =
        ListClientGatewaysRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listClientGateways(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ClientGateways in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientGatewaysServiceClient clientGatewaysServiceClient =
   *     ClientGatewaysServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ClientGateway element :
   *       clientGatewaysServiceClient.listClientGateways(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListClientGatewaysRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClientGatewaysPagedResponse listClientGateways(String parent) {
    ListClientGatewaysRequest request =
        ListClientGatewaysRequest.newBuilder().setParent(parent).build();
    return listClientGateways(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ClientGateways in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientGatewaysServiceClient clientGatewaysServiceClient =
   *     ClientGatewaysServiceClient.create()) {
   *   ListClientGatewaysRequest request =
   *       ListClientGatewaysRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ClientGateway element :
   *       clientGatewaysServiceClient.listClientGateways(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClientGatewaysPagedResponse listClientGateways(
      ListClientGatewaysRequest request) {
    return listClientGatewaysPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ClientGateways in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientGatewaysServiceClient clientGatewaysServiceClient =
   *     ClientGatewaysServiceClient.create()) {
   *   ListClientGatewaysRequest request =
   *       ListClientGatewaysRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ClientGateway> future =
   *       clientGatewaysServiceClient.listClientGatewaysPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ClientGateway element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListClientGatewaysRequest, ListClientGatewaysPagedResponse>
      listClientGatewaysPagedCallable() {
    return stub.listClientGatewaysPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ClientGateways in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientGatewaysServiceClient clientGatewaysServiceClient =
   *     ClientGatewaysServiceClient.create()) {
   *   ListClientGatewaysRequest request =
   *       ListClientGatewaysRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListClientGatewaysResponse response =
   *         clientGatewaysServiceClient.listClientGatewaysCallable().call(request);
   *     for (ClientGateway element : response.getClientGatewaysList()) {
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
  public final UnaryCallable<ListClientGatewaysRequest, ListClientGatewaysResponse>
      listClientGatewaysCallable() {
    return stub.listClientGatewaysCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ClientGateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientGatewaysServiceClient clientGatewaysServiceClient =
   *     ClientGatewaysServiceClient.create()) {
   *   ClientGatewayName name = ClientGatewayName.of("[PROJECT]", "[LOCATION]", "[CLIENT_GATEWAY]");
   *   ClientGateway response = clientGatewaysServiceClient.getClientGateway(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ClientGateway getClientGateway(ClientGatewayName name) {
    GetClientGatewayRequest request =
        GetClientGatewayRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getClientGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ClientGateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientGatewaysServiceClient clientGatewaysServiceClient =
   *     ClientGatewaysServiceClient.create()) {
   *   String name = ClientGatewayName.of("[PROJECT]", "[LOCATION]", "[CLIENT_GATEWAY]").toString();
   *   ClientGateway response = clientGatewaysServiceClient.getClientGateway(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ClientGateway getClientGateway(String name) {
    GetClientGatewayRequest request = GetClientGatewayRequest.newBuilder().setName(name).build();
    return getClientGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ClientGateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientGatewaysServiceClient clientGatewaysServiceClient =
   *     ClientGatewaysServiceClient.create()) {
   *   GetClientGatewayRequest request =
   *       GetClientGatewayRequest.newBuilder()
   *           .setName(
   *               ClientGatewayName.of("[PROJECT]", "[LOCATION]", "[CLIENT_GATEWAY]").toString())
   *           .build();
   *   ClientGateway response = clientGatewaysServiceClient.getClientGateway(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ClientGateway getClientGateway(GetClientGatewayRequest request) {
    return getClientGatewayCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ClientGateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientGatewaysServiceClient clientGatewaysServiceClient =
   *     ClientGatewaysServiceClient.create()) {
   *   GetClientGatewayRequest request =
   *       GetClientGatewayRequest.newBuilder()
   *           .setName(
   *               ClientGatewayName.of("[PROJECT]", "[LOCATION]", "[CLIENT_GATEWAY]").toString())
   *           .build();
   *   ApiFuture<ClientGateway> future =
   *       clientGatewaysServiceClient.getClientGatewayCallable().futureCall(request);
   *   // Do something.
   *   ClientGateway response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetClientGatewayRequest, ClientGateway> getClientGatewayCallable() {
    return stub.getClientGatewayCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ClientGateway in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientGatewaysServiceClient clientGatewaysServiceClient =
   *     ClientGatewaysServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ClientGateway clientGateway = ClientGateway.newBuilder().build();
   *   String clientGatewayId = "clientGatewayId-1199632652";
   *   ClientGateway response =
   *       clientGatewaysServiceClient
   *           .createClientGatewayAsync(parent, clientGateway, clientGatewayId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param clientGateway Required. The resource being created.
   * @param clientGatewayId Optional. User-settable client gateway resource ID. &#42; Must start
   *     with a letter. &#42; Must contain between 4-63 characters from `/[a-z][0-9]-/`. &#42; Must
   *     end with a number or a letter.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ClientGateway, ClientGatewayOperationMetadata>
      createClientGatewayAsync(
          LocationName parent, ClientGateway clientGateway, String clientGatewayId) {
    CreateClientGatewayRequest request =
        CreateClientGatewayRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setClientGateway(clientGateway)
            .setClientGatewayId(clientGatewayId)
            .build();
    return createClientGatewayAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ClientGateway in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientGatewaysServiceClient clientGatewaysServiceClient =
   *     ClientGatewaysServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ClientGateway clientGateway = ClientGateway.newBuilder().build();
   *   String clientGatewayId = "clientGatewayId-1199632652";
   *   ClientGateway response =
   *       clientGatewaysServiceClient
   *           .createClientGatewayAsync(parent, clientGateway, clientGatewayId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param clientGateway Required. The resource being created.
   * @param clientGatewayId Optional. User-settable client gateway resource ID. &#42; Must start
   *     with a letter. &#42; Must contain between 4-63 characters from `/[a-z][0-9]-/`. &#42; Must
   *     end with a number or a letter.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ClientGateway, ClientGatewayOperationMetadata>
      createClientGatewayAsync(String parent, ClientGateway clientGateway, String clientGatewayId) {
    CreateClientGatewayRequest request =
        CreateClientGatewayRequest.newBuilder()
            .setParent(parent)
            .setClientGateway(clientGateway)
            .setClientGatewayId(clientGatewayId)
            .build();
    return createClientGatewayAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ClientGateway in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientGatewaysServiceClient clientGatewaysServiceClient =
   *     ClientGatewaysServiceClient.create()) {
   *   CreateClientGatewayRequest request =
   *       CreateClientGatewayRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setClientGatewayId("clientGatewayId-1199632652")
   *           .setClientGateway(ClientGateway.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ClientGateway response = clientGatewaysServiceClient.createClientGatewayAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ClientGateway, ClientGatewayOperationMetadata>
      createClientGatewayAsync(CreateClientGatewayRequest request) {
    return createClientGatewayOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ClientGateway in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientGatewaysServiceClient clientGatewaysServiceClient =
   *     ClientGatewaysServiceClient.create()) {
   *   CreateClientGatewayRequest request =
   *       CreateClientGatewayRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setClientGatewayId("clientGatewayId-1199632652")
   *           .setClientGateway(ClientGateway.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<ClientGateway, ClientGatewayOperationMetadata> future =
   *       clientGatewaysServiceClient.createClientGatewayOperationCallable().futureCall(request);
   *   // Do something.
   *   ClientGateway response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateClientGatewayRequest, ClientGateway, ClientGatewayOperationMetadata>
      createClientGatewayOperationCallable() {
    return stub.createClientGatewayOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ClientGateway in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientGatewaysServiceClient clientGatewaysServiceClient =
   *     ClientGatewaysServiceClient.create()) {
   *   CreateClientGatewayRequest request =
   *       CreateClientGatewayRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setClientGatewayId("clientGatewayId-1199632652")
   *           .setClientGateway(ClientGateway.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       clientGatewaysServiceClient.createClientGatewayCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateClientGatewayRequest, Operation> createClientGatewayCallable() {
    return stub.createClientGatewayCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ClientGateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientGatewaysServiceClient clientGatewaysServiceClient =
   *     ClientGatewaysServiceClient.create()) {
   *   ClientGatewayName name = ClientGatewayName.of("[PROJECT]", "[LOCATION]", "[CLIENT_GATEWAY]");
   *   clientGatewaysServiceClient.deleteClientGatewayAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, ClientGatewayOperationMetadata> deleteClientGatewayAsync(
      ClientGatewayName name) {
    DeleteClientGatewayRequest request =
        DeleteClientGatewayRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteClientGatewayAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ClientGateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientGatewaysServiceClient clientGatewaysServiceClient =
   *     ClientGatewaysServiceClient.create()) {
   *   String name = ClientGatewayName.of("[PROJECT]", "[LOCATION]", "[CLIENT_GATEWAY]").toString();
   *   clientGatewaysServiceClient.deleteClientGatewayAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, ClientGatewayOperationMetadata> deleteClientGatewayAsync(
      String name) {
    DeleteClientGatewayRequest request =
        DeleteClientGatewayRequest.newBuilder().setName(name).build();
    return deleteClientGatewayAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ClientGateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientGatewaysServiceClient clientGatewaysServiceClient =
   *     ClientGatewaysServiceClient.create()) {
   *   DeleteClientGatewayRequest request =
   *       DeleteClientGatewayRequest.newBuilder()
   *           .setName(
   *               ClientGatewayName.of("[PROJECT]", "[LOCATION]", "[CLIENT_GATEWAY]").toString())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   clientGatewaysServiceClient.deleteClientGatewayAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, ClientGatewayOperationMetadata> deleteClientGatewayAsync(
      DeleteClientGatewayRequest request) {
    return deleteClientGatewayOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ClientGateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientGatewaysServiceClient clientGatewaysServiceClient =
   *     ClientGatewaysServiceClient.create()) {
   *   DeleteClientGatewayRequest request =
   *       DeleteClientGatewayRequest.newBuilder()
   *           .setName(
   *               ClientGatewayName.of("[PROJECT]", "[LOCATION]", "[CLIENT_GATEWAY]").toString())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Empty, ClientGatewayOperationMetadata> future =
   *       clientGatewaysServiceClient.deleteClientGatewayOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteClientGatewayRequest, Empty, ClientGatewayOperationMetadata>
      deleteClientGatewayOperationCallable() {
    return stub.deleteClientGatewayOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ClientGateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientGatewaysServiceClient clientGatewaysServiceClient =
   *     ClientGatewaysServiceClient.create()) {
   *   DeleteClientGatewayRequest request =
   *       DeleteClientGatewayRequest.newBuilder()
   *           .setName(
   *               ClientGatewayName.of("[PROJECT]", "[LOCATION]", "[CLIENT_GATEWAY]").toString())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       clientGatewaysServiceClient.deleteClientGatewayCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteClientGatewayRequest, Operation> deleteClientGatewayCallable() {
    return stub.deleteClientGatewayCallable();
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
   * try (ClientGatewaysServiceClient clientGatewaysServiceClient =
   *     ClientGatewaysServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : clientGatewaysServiceClient.listLocations(request).iterateAll()) {
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
   * try (ClientGatewaysServiceClient clientGatewaysServiceClient =
   *     ClientGatewaysServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       clientGatewaysServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (ClientGatewaysServiceClient clientGatewaysServiceClient =
   *     ClientGatewaysServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         clientGatewaysServiceClient.listLocationsCallable().call(request);
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
   * try (ClientGatewaysServiceClient clientGatewaysServiceClient =
   *     ClientGatewaysServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = clientGatewaysServiceClient.getLocation(request);
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
   * try (ClientGatewaysServiceClient clientGatewaysServiceClient =
   *     ClientGatewaysServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       clientGatewaysServiceClient.getLocationCallable().futureCall(request);
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
   * try (ClientGatewaysServiceClient clientGatewaysServiceClient =
   *     ClientGatewaysServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               ClientGatewayName.of("[PROJECT]", "[LOCATION]", "[CLIENT_GATEWAY]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = clientGatewaysServiceClient.setIamPolicy(request);
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
   * try (ClientGatewaysServiceClient clientGatewaysServiceClient =
   *     ClientGatewaysServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               ClientGatewayName.of("[PROJECT]", "[LOCATION]", "[CLIENT_GATEWAY]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       clientGatewaysServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (ClientGatewaysServiceClient clientGatewaysServiceClient =
   *     ClientGatewaysServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               ClientGatewayName.of("[PROJECT]", "[LOCATION]", "[CLIENT_GATEWAY]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = clientGatewaysServiceClient.getIamPolicy(request);
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
   * try (ClientGatewaysServiceClient clientGatewaysServiceClient =
   *     ClientGatewaysServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               ClientGatewayName.of("[PROJECT]", "[LOCATION]", "[CLIENT_GATEWAY]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       clientGatewaysServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (ClientGatewaysServiceClient clientGatewaysServiceClient =
   *     ClientGatewaysServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               ClientGatewayName.of("[PROJECT]", "[LOCATION]", "[CLIENT_GATEWAY]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = clientGatewaysServiceClient.testIamPermissions(request);
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
   * try (ClientGatewaysServiceClient clientGatewaysServiceClient =
   *     ClientGatewaysServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               ClientGatewayName.of("[PROJECT]", "[LOCATION]", "[CLIENT_GATEWAY]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       clientGatewaysServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListClientGatewaysPagedResponse
      extends AbstractPagedListResponse<
          ListClientGatewaysRequest,
          ListClientGatewaysResponse,
          ClientGateway,
          ListClientGatewaysPage,
          ListClientGatewaysFixedSizeCollection> {

    public static ApiFuture<ListClientGatewaysPagedResponse> createAsync(
        PageContext<ListClientGatewaysRequest, ListClientGatewaysResponse, ClientGateway> context,
        ApiFuture<ListClientGatewaysResponse> futureResponse) {
      ApiFuture<ListClientGatewaysPage> futurePage =
          ListClientGatewaysPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListClientGatewaysPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListClientGatewaysPagedResponse(ListClientGatewaysPage page) {
      super(page, ListClientGatewaysFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListClientGatewaysPage
      extends AbstractPage<
          ListClientGatewaysRequest,
          ListClientGatewaysResponse,
          ClientGateway,
          ListClientGatewaysPage> {

    private ListClientGatewaysPage(
        PageContext<ListClientGatewaysRequest, ListClientGatewaysResponse, ClientGateway> context,
        ListClientGatewaysResponse response) {
      super(context, response);
    }

    private static ListClientGatewaysPage createEmptyPage() {
      return new ListClientGatewaysPage(null, null);
    }

    @Override
    protected ListClientGatewaysPage createPage(
        PageContext<ListClientGatewaysRequest, ListClientGatewaysResponse, ClientGateway> context,
        ListClientGatewaysResponse response) {
      return new ListClientGatewaysPage(context, response);
    }

    @Override
    public ApiFuture<ListClientGatewaysPage> createPageAsync(
        PageContext<ListClientGatewaysRequest, ListClientGatewaysResponse, ClientGateway> context,
        ApiFuture<ListClientGatewaysResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListClientGatewaysFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListClientGatewaysRequest,
          ListClientGatewaysResponse,
          ClientGateway,
          ListClientGatewaysPage,
          ListClientGatewaysFixedSizeCollection> {

    private ListClientGatewaysFixedSizeCollection(
        List<ListClientGatewaysPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListClientGatewaysFixedSizeCollection createEmptyCollection() {
      return new ListClientGatewaysFixedSizeCollection(null, 0);
    }

    @Override
    protected ListClientGatewaysFixedSizeCollection createCollection(
        List<ListClientGatewaysPage> pages, int collectionSize) {
      return new ListClientGatewaysFixedSizeCollection(pages, collectionSize);
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
