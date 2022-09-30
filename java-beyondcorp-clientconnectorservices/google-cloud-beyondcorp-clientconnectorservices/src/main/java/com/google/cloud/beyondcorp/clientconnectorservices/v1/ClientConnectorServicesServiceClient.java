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

package com.google.cloud.beyondcorp.clientconnectorservices.v1;

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
import com.google.cloud.beyondcorp.clientconnectorservices.v1.stub.ClientConnectorServicesServiceStub;
import com.google.cloud.beyondcorp.clientconnectorservices.v1.stub.ClientConnectorServicesServiceStubSettings;
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
 * Service Description: ## API Overview
 *
 * <p>The `beyondcorp.googleapis.com` service implements the Google Cloud BeyondCorp API.
 *
 * <p>## Data Model
 *
 * <p>The ClientConnectorServicesService exposes the following resources:
 *
 * <ul>
 *   <li>Client Connector Services, named as follows:
 *       `projects/{project_id}/locations/{location_id}/client_connector_services/{client_connector_service_id}`.
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
 * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
 *     ClientConnectorServicesServiceClient.create()) {
 *   ClientConnectorServiceName name =
 *       ClientConnectorServiceName.of("[PROJECT]", "[LOCATION]", "[CLIENT_CONNECTOR_SERVICE]");
 *   ClientConnectorService response =
 *       clientConnectorServicesServiceClient.getClientConnectorService(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ClientConnectorServicesServiceClient object to clean
 * up resources such as threads. In the example above, try-with-resources is used, which
 * automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of
 * ClientConnectorServicesServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ClientConnectorServicesServiceSettings clientConnectorServicesServiceSettings =
 *     ClientConnectorServicesServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
 *     ClientConnectorServicesServiceClient.create(clientConnectorServicesServiceSettings);
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
 * ClientConnectorServicesServiceSettings clientConnectorServicesServiceSettings =
 *     ClientConnectorServicesServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
 *     ClientConnectorServicesServiceClient.create(clientConnectorServicesServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ClientConnectorServicesServiceClient implements BackgroundResource {
  private final ClientConnectorServicesServiceSettings settings;
  private final ClientConnectorServicesServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of ClientConnectorServicesServiceClient with default settings. */
  public static final ClientConnectorServicesServiceClient create() throws IOException {
    return create(ClientConnectorServicesServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ClientConnectorServicesServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final ClientConnectorServicesServiceClient create(
      ClientConnectorServicesServiceSettings settings) throws IOException {
    return new ClientConnectorServicesServiceClient(settings);
  }

  /**
   * Constructs an instance of ClientConnectorServicesServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using
   * create(ClientConnectorServicesServiceSettings).
   */
  public static final ClientConnectorServicesServiceClient create(
      ClientConnectorServicesServiceStub stub) {
    return new ClientConnectorServicesServiceClient(stub);
  }

  /**
   * Constructs an instance of ClientConnectorServicesServiceClient, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ClientConnectorServicesServiceClient(ClientConnectorServicesServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((ClientConnectorServicesServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected ClientConnectorServicesServiceClient(ClientConnectorServicesServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final ClientConnectorServicesServiceSettings getSettings() {
    return settings;
  }

  public ClientConnectorServicesServiceStub getStub() {
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
   * Lists ClientConnectorServices in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
   *     ClientConnectorServicesServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ClientConnectorService element :
   *       clientConnectorServicesServiceClient.listClientConnectorServices(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListClientConnectorServicesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClientConnectorServicesPagedResponse listClientConnectorServices(
      LocationName parent) {
    ListClientConnectorServicesRequest request =
        ListClientConnectorServicesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listClientConnectorServices(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ClientConnectorServices in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
   *     ClientConnectorServicesServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ClientConnectorService element :
   *       clientConnectorServicesServiceClient.listClientConnectorServices(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListClientConnectorServicesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClientConnectorServicesPagedResponse listClientConnectorServices(String parent) {
    ListClientConnectorServicesRequest request =
        ListClientConnectorServicesRequest.newBuilder().setParent(parent).build();
    return listClientConnectorServices(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ClientConnectorServices in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
   *     ClientConnectorServicesServiceClient.create()) {
   *   ListClientConnectorServicesRequest request =
   *       ListClientConnectorServicesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ClientConnectorService element :
   *       clientConnectorServicesServiceClient.listClientConnectorServices(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClientConnectorServicesPagedResponse listClientConnectorServices(
      ListClientConnectorServicesRequest request) {
    return listClientConnectorServicesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ClientConnectorServices in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
   *     ClientConnectorServicesServiceClient.create()) {
   *   ListClientConnectorServicesRequest request =
   *       ListClientConnectorServicesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ClientConnectorService> future =
   *       clientConnectorServicesServiceClient
   *           .listClientConnectorServicesPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (ClientConnectorService element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListClientConnectorServicesRequest, ListClientConnectorServicesPagedResponse>
      listClientConnectorServicesPagedCallable() {
    return stub.listClientConnectorServicesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ClientConnectorServices in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
   *     ClientConnectorServicesServiceClient.create()) {
   *   ListClientConnectorServicesRequest request =
   *       ListClientConnectorServicesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListClientConnectorServicesResponse response =
   *         clientConnectorServicesServiceClient
   *             .listClientConnectorServicesCallable()
   *             .call(request);
   *     for (ClientConnectorService element : response.getClientConnectorServicesList()) {
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
  public final UnaryCallable<
          ListClientConnectorServicesRequest, ListClientConnectorServicesResponse>
      listClientConnectorServicesCallable() {
    return stub.listClientConnectorServicesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ClientConnectorService.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
   *     ClientConnectorServicesServiceClient.create()) {
   *   ClientConnectorServiceName name =
   *       ClientConnectorServiceName.of("[PROJECT]", "[LOCATION]", "[CLIENT_CONNECTOR_SERVICE]");
   *   ClientConnectorService response =
   *       clientConnectorServicesServiceClient.getClientConnectorService(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ClientConnectorService getClientConnectorService(ClientConnectorServiceName name) {
    GetClientConnectorServiceRequest request =
        GetClientConnectorServiceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getClientConnectorService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ClientConnectorService.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
   *     ClientConnectorServicesServiceClient.create()) {
   *   String name =
   *       ClientConnectorServiceName.of("[PROJECT]", "[LOCATION]", "[CLIENT_CONNECTOR_SERVICE]")
   *           .toString();
   *   ClientConnectorService response =
   *       clientConnectorServicesServiceClient.getClientConnectorService(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ClientConnectorService getClientConnectorService(String name) {
    GetClientConnectorServiceRequest request =
        GetClientConnectorServiceRequest.newBuilder().setName(name).build();
    return getClientConnectorService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ClientConnectorService.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
   *     ClientConnectorServicesServiceClient.create()) {
   *   GetClientConnectorServiceRequest request =
   *       GetClientConnectorServiceRequest.newBuilder()
   *           .setName(
   *               ClientConnectorServiceName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CLIENT_CONNECTOR_SERVICE]")
   *                   .toString())
   *           .build();
   *   ClientConnectorService response =
   *       clientConnectorServicesServiceClient.getClientConnectorService(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ClientConnectorService getClientConnectorService(
      GetClientConnectorServiceRequest request) {
    return getClientConnectorServiceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ClientConnectorService.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
   *     ClientConnectorServicesServiceClient.create()) {
   *   GetClientConnectorServiceRequest request =
   *       GetClientConnectorServiceRequest.newBuilder()
   *           .setName(
   *               ClientConnectorServiceName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CLIENT_CONNECTOR_SERVICE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ClientConnectorService> future =
   *       clientConnectorServicesServiceClient
   *           .getClientConnectorServiceCallable()
   *           .futureCall(request);
   *   // Do something.
   *   ClientConnectorService response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetClientConnectorServiceRequest, ClientConnectorService>
      getClientConnectorServiceCallable() {
    return stub.getClientConnectorServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ClientConnectorService in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
   *     ClientConnectorServicesServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ClientConnectorService clientConnectorService = ClientConnectorService.newBuilder().build();
   *   String clientConnectorServiceId = "clientConnectorServiceId766123022";
   *   ClientConnectorService response =
   *       clientConnectorServicesServiceClient
   *           .createClientConnectorServiceAsync(
   *               parent, clientConnectorService, clientConnectorServiceId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param clientConnectorService Required. The resource being created.
   * @param clientConnectorServiceId Optional. User-settable client connector service resource ID.
   *     &#42; Must start with a letter. &#42; Must contain between 4-63 characters from
   *     `/[a-z][0-9]-/`. &#42; Must end with a number or a letter.
   *     <p>A random system generated name will be assigned if not specified by the user.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ClientConnectorService, ClientConnectorServiceOperationMetadata>
      createClientConnectorServiceAsync(
          LocationName parent,
          ClientConnectorService clientConnectorService,
          String clientConnectorServiceId) {
    CreateClientConnectorServiceRequest request =
        CreateClientConnectorServiceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setClientConnectorService(clientConnectorService)
            .setClientConnectorServiceId(clientConnectorServiceId)
            .build();
    return createClientConnectorServiceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ClientConnectorService in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
   *     ClientConnectorServicesServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ClientConnectorService clientConnectorService = ClientConnectorService.newBuilder().build();
   *   String clientConnectorServiceId = "clientConnectorServiceId766123022";
   *   ClientConnectorService response =
   *       clientConnectorServicesServiceClient
   *           .createClientConnectorServiceAsync(
   *               parent, clientConnectorService, clientConnectorServiceId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param clientConnectorService Required. The resource being created.
   * @param clientConnectorServiceId Optional. User-settable client connector service resource ID.
   *     &#42; Must start with a letter. &#42; Must contain between 4-63 characters from
   *     `/[a-z][0-9]-/`. &#42; Must end with a number or a letter.
   *     <p>A random system generated name will be assigned if not specified by the user.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ClientConnectorService, ClientConnectorServiceOperationMetadata>
      createClientConnectorServiceAsync(
          String parent,
          ClientConnectorService clientConnectorService,
          String clientConnectorServiceId) {
    CreateClientConnectorServiceRequest request =
        CreateClientConnectorServiceRequest.newBuilder()
            .setParent(parent)
            .setClientConnectorService(clientConnectorService)
            .setClientConnectorServiceId(clientConnectorServiceId)
            .build();
    return createClientConnectorServiceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ClientConnectorService in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
   *     ClientConnectorServicesServiceClient.create()) {
   *   CreateClientConnectorServiceRequest request =
   *       CreateClientConnectorServiceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setClientConnectorServiceId("clientConnectorServiceId766123022")
   *           .setClientConnectorService(ClientConnectorService.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ClientConnectorService response =
   *       clientConnectorServicesServiceClient.createClientConnectorServiceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ClientConnectorService, ClientConnectorServiceOperationMetadata>
      createClientConnectorServiceAsync(CreateClientConnectorServiceRequest request) {
    return createClientConnectorServiceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ClientConnectorService in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
   *     ClientConnectorServicesServiceClient.create()) {
   *   CreateClientConnectorServiceRequest request =
   *       CreateClientConnectorServiceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setClientConnectorServiceId("clientConnectorServiceId766123022")
   *           .setClientConnectorService(ClientConnectorService.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<ClientConnectorService, ClientConnectorServiceOperationMetadata> future =
   *       clientConnectorServicesServiceClient
   *           .createClientConnectorServiceOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   ClientConnectorService response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateClientConnectorServiceRequest,
          ClientConnectorService,
          ClientConnectorServiceOperationMetadata>
      createClientConnectorServiceOperationCallable() {
    return stub.createClientConnectorServiceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ClientConnectorService in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
   *     ClientConnectorServicesServiceClient.create()) {
   *   CreateClientConnectorServiceRequest request =
   *       CreateClientConnectorServiceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setClientConnectorServiceId("clientConnectorServiceId766123022")
   *           .setClientConnectorService(ClientConnectorService.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       clientConnectorServicesServiceClient
   *           .createClientConnectorServiceCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateClientConnectorServiceRequest, Operation>
      createClientConnectorServiceCallable() {
    return stub.createClientConnectorServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ClientConnectorService.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
   *     ClientConnectorServicesServiceClient.create()) {
   *   ClientConnectorService clientConnectorService = ClientConnectorService.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ClientConnectorService response =
   *       clientConnectorServicesServiceClient
   *           .updateClientConnectorServiceAsync(clientConnectorService, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param clientConnectorService Required. The resource being updated.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     ClientConnectorService resource by the update. The fields specified in the update_mask are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. If the user does not provide a mask then all fields will be overwritten.
   *     <p>Mutable fields: display_name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ClientConnectorService, ClientConnectorServiceOperationMetadata>
      updateClientConnectorServiceAsync(
          ClientConnectorService clientConnectorService, FieldMask updateMask) {
    UpdateClientConnectorServiceRequest request =
        UpdateClientConnectorServiceRequest.newBuilder()
            .setClientConnectorService(clientConnectorService)
            .setUpdateMask(updateMask)
            .build();
    return updateClientConnectorServiceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ClientConnectorService.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
   *     ClientConnectorServicesServiceClient.create()) {
   *   UpdateClientConnectorServiceRequest request =
   *       UpdateClientConnectorServiceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setClientConnectorService(ClientConnectorService.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .build();
   *   ClientConnectorService response =
   *       clientConnectorServicesServiceClient.updateClientConnectorServiceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ClientConnectorService, ClientConnectorServiceOperationMetadata>
      updateClientConnectorServiceAsync(UpdateClientConnectorServiceRequest request) {
    return updateClientConnectorServiceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ClientConnectorService.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
   *     ClientConnectorServicesServiceClient.create()) {
   *   UpdateClientConnectorServiceRequest request =
   *       UpdateClientConnectorServiceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setClientConnectorService(ClientConnectorService.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .build();
   *   OperationFuture<ClientConnectorService, ClientConnectorServiceOperationMetadata> future =
   *       clientConnectorServicesServiceClient
   *           .updateClientConnectorServiceOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   ClientConnectorService response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateClientConnectorServiceRequest,
          ClientConnectorService,
          ClientConnectorServiceOperationMetadata>
      updateClientConnectorServiceOperationCallable() {
    return stub.updateClientConnectorServiceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ClientConnectorService.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
   *     ClientConnectorServicesServiceClient.create()) {
   *   UpdateClientConnectorServiceRequest request =
   *       UpdateClientConnectorServiceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setClientConnectorService(ClientConnectorService.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       clientConnectorServicesServiceClient
   *           .updateClientConnectorServiceCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateClientConnectorServiceRequest, Operation>
      updateClientConnectorServiceCallable() {
    return stub.updateClientConnectorServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ClientConnectorService.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
   *     ClientConnectorServicesServiceClient.create()) {
   *   ClientConnectorServiceName name =
   *       ClientConnectorServiceName.of("[PROJECT]", "[LOCATION]", "[CLIENT_CONNECTOR_SERVICE]");
   *   clientConnectorServicesServiceClient.deleteClientConnectorServiceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, ClientConnectorServiceOperationMetadata>
      deleteClientConnectorServiceAsync(ClientConnectorServiceName name) {
    DeleteClientConnectorServiceRequest request =
        DeleteClientConnectorServiceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteClientConnectorServiceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ClientConnectorService.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
   *     ClientConnectorServicesServiceClient.create()) {
   *   String name =
   *       ClientConnectorServiceName.of("[PROJECT]", "[LOCATION]", "[CLIENT_CONNECTOR_SERVICE]")
   *           .toString();
   *   clientConnectorServicesServiceClient.deleteClientConnectorServiceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, ClientConnectorServiceOperationMetadata>
      deleteClientConnectorServiceAsync(String name) {
    DeleteClientConnectorServiceRequest request =
        DeleteClientConnectorServiceRequest.newBuilder().setName(name).build();
    return deleteClientConnectorServiceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ClientConnectorService.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
   *     ClientConnectorServicesServiceClient.create()) {
   *   DeleteClientConnectorServiceRequest request =
   *       DeleteClientConnectorServiceRequest.newBuilder()
   *           .setName(
   *               ClientConnectorServiceName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CLIENT_CONNECTOR_SERVICE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   clientConnectorServicesServiceClient.deleteClientConnectorServiceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, ClientConnectorServiceOperationMetadata>
      deleteClientConnectorServiceAsync(DeleteClientConnectorServiceRequest request) {
    return deleteClientConnectorServiceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ClientConnectorService.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
   *     ClientConnectorServicesServiceClient.create()) {
   *   DeleteClientConnectorServiceRequest request =
   *       DeleteClientConnectorServiceRequest.newBuilder()
   *           .setName(
   *               ClientConnectorServiceName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CLIENT_CONNECTOR_SERVICE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Empty, ClientConnectorServiceOperationMetadata> future =
   *       clientConnectorServicesServiceClient
   *           .deleteClientConnectorServiceOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeleteClientConnectorServiceRequest, Empty, ClientConnectorServiceOperationMetadata>
      deleteClientConnectorServiceOperationCallable() {
    return stub.deleteClientConnectorServiceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ClientConnectorService.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
   *     ClientConnectorServicesServiceClient.create()) {
   *   DeleteClientConnectorServiceRequest request =
   *       DeleteClientConnectorServiceRequest.newBuilder()
   *           .setName(
   *               ClientConnectorServiceName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CLIENT_CONNECTOR_SERVICE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       clientConnectorServicesServiceClient
   *           .deleteClientConnectorServiceCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteClientConnectorServiceRequest, Operation>
      deleteClientConnectorServiceCallable() {
    return stub.deleteClientConnectorServiceCallable();
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
   * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
   *     ClientConnectorServicesServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element :
   *       clientConnectorServicesServiceClient.listLocations(request).iterateAll()) {
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
   * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
   *     ClientConnectorServicesServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       clientConnectorServicesServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
   *     ClientConnectorServicesServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         clientConnectorServicesServiceClient.listLocationsCallable().call(request);
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
   * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
   *     ClientConnectorServicesServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = clientConnectorServicesServiceClient.getLocation(request);
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
   * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
   *     ClientConnectorServicesServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       clientConnectorServicesServiceClient.getLocationCallable().futureCall(request);
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
   * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
   *     ClientConnectorServicesServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               ClientConnectorServiceName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CLIENT_CONNECTOR_SERVICE]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = clientConnectorServicesServiceClient.setIamPolicy(request);
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
   * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
   *     ClientConnectorServicesServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               ClientConnectorServiceName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CLIENT_CONNECTOR_SERVICE]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       clientConnectorServicesServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
   *     ClientConnectorServicesServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               ClientConnectorServiceName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CLIENT_CONNECTOR_SERVICE]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = clientConnectorServicesServiceClient.getIamPolicy(request);
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
   * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
   *     ClientConnectorServicesServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               ClientConnectorServiceName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CLIENT_CONNECTOR_SERVICE]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       clientConnectorServicesServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
   *     ClientConnectorServicesServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               ClientConnectorServiceName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CLIENT_CONNECTOR_SERVICE]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response =
   *       clientConnectorServicesServiceClient.testIamPermissions(request);
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
   * try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
   *     ClientConnectorServicesServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               ClientConnectorServiceName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CLIENT_CONNECTOR_SERVICE]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       clientConnectorServicesServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListClientConnectorServicesPagedResponse
      extends AbstractPagedListResponse<
          ListClientConnectorServicesRequest,
          ListClientConnectorServicesResponse,
          ClientConnectorService,
          ListClientConnectorServicesPage,
          ListClientConnectorServicesFixedSizeCollection> {

    public static ApiFuture<ListClientConnectorServicesPagedResponse> createAsync(
        PageContext<
                ListClientConnectorServicesRequest,
                ListClientConnectorServicesResponse,
                ClientConnectorService>
            context,
        ApiFuture<ListClientConnectorServicesResponse> futureResponse) {
      ApiFuture<ListClientConnectorServicesPage> futurePage =
          ListClientConnectorServicesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListClientConnectorServicesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListClientConnectorServicesPagedResponse(ListClientConnectorServicesPage page) {
      super(page, ListClientConnectorServicesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListClientConnectorServicesPage
      extends AbstractPage<
          ListClientConnectorServicesRequest,
          ListClientConnectorServicesResponse,
          ClientConnectorService,
          ListClientConnectorServicesPage> {

    private ListClientConnectorServicesPage(
        PageContext<
                ListClientConnectorServicesRequest,
                ListClientConnectorServicesResponse,
                ClientConnectorService>
            context,
        ListClientConnectorServicesResponse response) {
      super(context, response);
    }

    private static ListClientConnectorServicesPage createEmptyPage() {
      return new ListClientConnectorServicesPage(null, null);
    }

    @Override
    protected ListClientConnectorServicesPage createPage(
        PageContext<
                ListClientConnectorServicesRequest,
                ListClientConnectorServicesResponse,
                ClientConnectorService>
            context,
        ListClientConnectorServicesResponse response) {
      return new ListClientConnectorServicesPage(context, response);
    }

    @Override
    public ApiFuture<ListClientConnectorServicesPage> createPageAsync(
        PageContext<
                ListClientConnectorServicesRequest,
                ListClientConnectorServicesResponse,
                ClientConnectorService>
            context,
        ApiFuture<ListClientConnectorServicesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListClientConnectorServicesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListClientConnectorServicesRequest,
          ListClientConnectorServicesResponse,
          ClientConnectorService,
          ListClientConnectorServicesPage,
          ListClientConnectorServicesFixedSizeCollection> {

    private ListClientConnectorServicesFixedSizeCollection(
        List<ListClientConnectorServicesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListClientConnectorServicesFixedSizeCollection createEmptyCollection() {
      return new ListClientConnectorServicesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListClientConnectorServicesFixedSizeCollection createCollection(
        List<ListClientConnectorServicesPage> pages, int collectionSize) {
      return new ListClientConnectorServicesFixedSizeCollection(pages, collectionSize);
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
