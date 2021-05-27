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

package com.google.cloud.vpcaccess.v1;

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
import com.google.cloud.vpcaccess.v1.stub.VpcAccessServiceStub;
import com.google.cloud.vpcaccess.v1.stub.VpcAccessServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Serverless VPC Access API allows users to create and manage connectors for
 * App Engine, Cloud Functions and Cloud Run to have internal connections to Virtual Private Cloud
 * networks.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (VpcAccessServiceClient vpcAccessServiceClient = VpcAccessServiceClient.create()) {
 *   ConnectorName name = ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECTOR]");
 *   Connector response = vpcAccessServiceClient.getConnector(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the VpcAccessServiceClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of VpcAccessServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * VpcAccessServiceSettings vpcAccessServiceSettings =
 *     VpcAccessServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * VpcAccessServiceClient vpcAccessServiceClient =
 *     VpcAccessServiceClient.create(vpcAccessServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * VpcAccessServiceSettings vpcAccessServiceSettings =
 *     VpcAccessServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * VpcAccessServiceClient vpcAccessServiceClient =
 *     VpcAccessServiceClient.create(vpcAccessServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class VpcAccessServiceClient implements BackgroundResource {
  private final VpcAccessServiceSettings settings;
  private final VpcAccessServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of VpcAccessServiceClient with default settings. */
  public static final VpcAccessServiceClient create() throws IOException {
    return create(VpcAccessServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of VpcAccessServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final VpcAccessServiceClient create(VpcAccessServiceSettings settings)
      throws IOException {
    return new VpcAccessServiceClient(settings);
  }

  /**
   * Constructs an instance of VpcAccessServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(VpcAccessServiceSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final VpcAccessServiceClient create(VpcAccessServiceStub stub) {
    return new VpcAccessServiceClient(stub);
  }

  /**
   * Constructs an instance of VpcAccessServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected VpcAccessServiceClient(VpcAccessServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((VpcAccessServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected VpcAccessServiceClient(VpcAccessServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final VpcAccessServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public VpcAccessServiceStub getStub() {
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
   * Creates a Serverless VPC Access connector, returns an operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (VpcAccessServiceClient vpcAccessServiceClient = VpcAccessServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String connectorId = "connectorId1724784200";
   *   Connector connector = Connector.newBuilder().build();
   *   Connector response =
   *       vpcAccessServiceClient.createConnectorAsync(parent, connectorId, connector).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project and location in which the configuration should be created,
   *     specified in the format `projects/&#42;/locations/&#42;`.
   * @param connectorId Required. The ID to use for this connector.
   * @param connector Required. Resource to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Connector, OperationMetadata> createConnectorAsync(
      LocationName parent, String connectorId, Connector connector) {
    CreateConnectorRequest request =
        CreateConnectorRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setConnectorId(connectorId)
            .setConnector(connector)
            .build();
    return createConnectorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Serverless VPC Access connector, returns an operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (VpcAccessServiceClient vpcAccessServiceClient = VpcAccessServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String connectorId = "connectorId1724784200";
   *   Connector connector = Connector.newBuilder().build();
   *   Connector response =
   *       vpcAccessServiceClient.createConnectorAsync(parent, connectorId, connector).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project and location in which the configuration should be created,
   *     specified in the format `projects/&#42;/locations/&#42;`.
   * @param connectorId Required. The ID to use for this connector.
   * @param connector Required. Resource to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Connector, OperationMetadata> createConnectorAsync(
      String parent, String connectorId, Connector connector) {
    CreateConnectorRequest request =
        CreateConnectorRequest.newBuilder()
            .setParent(parent)
            .setConnectorId(connectorId)
            .setConnector(connector)
            .build();
    return createConnectorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Serverless VPC Access connector, returns an operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (VpcAccessServiceClient vpcAccessServiceClient = VpcAccessServiceClient.create()) {
   *   CreateConnectorRequest request =
   *       CreateConnectorRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setConnectorId("connectorId1724784200")
   *           .setConnector(Connector.newBuilder().build())
   *           .build();
   *   Connector response = vpcAccessServiceClient.createConnectorAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Connector, OperationMetadata> createConnectorAsync(
      CreateConnectorRequest request) {
    return createConnectorOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Serverless VPC Access connector, returns an operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (VpcAccessServiceClient vpcAccessServiceClient = VpcAccessServiceClient.create()) {
   *   CreateConnectorRequest request =
   *       CreateConnectorRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setConnectorId("connectorId1724784200")
   *           .setConnector(Connector.newBuilder().build())
   *           .build();
   *   OperationFuture<Connector, OperationMetadata> future =
   *       vpcAccessServiceClient.createConnectorOperationCallable().futureCall(request);
   *   // Do something.
   *   Connector response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateConnectorRequest, Connector, OperationMetadata>
      createConnectorOperationCallable() {
    return stub.createConnectorOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Serverless VPC Access connector, returns an operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (VpcAccessServiceClient vpcAccessServiceClient = VpcAccessServiceClient.create()) {
   *   CreateConnectorRequest request =
   *       CreateConnectorRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setConnectorId("connectorId1724784200")
   *           .setConnector(Connector.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       vpcAccessServiceClient.createConnectorCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateConnectorRequest, Operation> createConnectorCallable() {
    return stub.createConnectorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Serverless VPC Access connector. Returns NOT_FOUND if the resource does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (VpcAccessServiceClient vpcAccessServiceClient = VpcAccessServiceClient.create()) {
   *   ConnectorName name = ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECTOR]");
   *   Connector response = vpcAccessServiceClient.getConnector(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of a Serverless VPC Access connector to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Connector getConnector(ConnectorName name) {
    GetConnectorRequest request =
        GetConnectorRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getConnector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Serverless VPC Access connector. Returns NOT_FOUND if the resource does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (VpcAccessServiceClient vpcAccessServiceClient = VpcAccessServiceClient.create()) {
   *   String name = ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECTOR]").toString();
   *   Connector response = vpcAccessServiceClient.getConnector(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of a Serverless VPC Access connector to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Connector getConnector(String name) {
    GetConnectorRequest request = GetConnectorRequest.newBuilder().setName(name).build();
    return getConnector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Serverless VPC Access connector. Returns NOT_FOUND if the resource does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (VpcAccessServiceClient vpcAccessServiceClient = VpcAccessServiceClient.create()) {
   *   GetConnectorRequest request =
   *       GetConnectorRequest.newBuilder()
   *           .setName(ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECTOR]").toString())
   *           .build();
   *   Connector response = vpcAccessServiceClient.getConnector(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Connector getConnector(GetConnectorRequest request) {
    return getConnectorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Serverless VPC Access connector. Returns NOT_FOUND if the resource does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (VpcAccessServiceClient vpcAccessServiceClient = VpcAccessServiceClient.create()) {
   *   GetConnectorRequest request =
   *       GetConnectorRequest.newBuilder()
   *           .setName(ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECTOR]").toString())
   *           .build();
   *   ApiFuture<Connector> future =
   *       vpcAccessServiceClient.getConnectorCallable().futureCall(request);
   *   // Do something.
   *   Connector response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetConnectorRequest, Connector> getConnectorCallable() {
    return stub.getConnectorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Serverless VPC Access connectors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (VpcAccessServiceClient vpcAccessServiceClient = VpcAccessServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Connector element : vpcAccessServiceClient.listConnectors(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the routes should be listed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConnectorsPagedResponse listConnectors(LocationName parent) {
    ListConnectorsRequest request =
        ListConnectorsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listConnectors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Serverless VPC Access connectors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (VpcAccessServiceClient vpcAccessServiceClient = VpcAccessServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Connector element : vpcAccessServiceClient.listConnectors(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the routes should be listed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConnectorsPagedResponse listConnectors(String parent) {
    ListConnectorsRequest request = ListConnectorsRequest.newBuilder().setParent(parent).build();
    return listConnectors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Serverless VPC Access connectors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (VpcAccessServiceClient vpcAccessServiceClient = VpcAccessServiceClient.create()) {
   *   ListConnectorsRequest request =
   *       ListConnectorsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Connector element : vpcAccessServiceClient.listConnectors(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConnectorsPagedResponse listConnectors(ListConnectorsRequest request) {
    return listConnectorsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Serverless VPC Access connectors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (VpcAccessServiceClient vpcAccessServiceClient = VpcAccessServiceClient.create()) {
   *   ListConnectorsRequest request =
   *       ListConnectorsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Connector> future =
   *       vpcAccessServiceClient.listConnectorsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Connector element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListConnectorsRequest, ListConnectorsPagedResponse>
      listConnectorsPagedCallable() {
    return stub.listConnectorsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Serverless VPC Access connectors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (VpcAccessServiceClient vpcAccessServiceClient = VpcAccessServiceClient.create()) {
   *   ListConnectorsRequest request =
   *       ListConnectorsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListConnectorsResponse response =
   *         vpcAccessServiceClient.listConnectorsCallable().call(request);
   *     for (Connector element : response.getResponsesList()) {
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
  public final UnaryCallable<ListConnectorsRequest, ListConnectorsResponse>
      listConnectorsCallable() {
    return stub.listConnectorsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Serverless VPC Access connector. Returns NOT_FOUND if the resource does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (VpcAccessServiceClient vpcAccessServiceClient = VpcAccessServiceClient.create()) {
   *   ConnectorName name = ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECTOR]");
   *   vpcAccessServiceClient.deleteConnectorAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of a Serverless VPC Access connector to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteConnectorAsync(ConnectorName name) {
    DeleteConnectorRequest request =
        DeleteConnectorRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteConnectorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Serverless VPC Access connector. Returns NOT_FOUND if the resource does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (VpcAccessServiceClient vpcAccessServiceClient = VpcAccessServiceClient.create()) {
   *   String name = ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECTOR]").toString();
   *   vpcAccessServiceClient.deleteConnectorAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of a Serverless VPC Access connector to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteConnectorAsync(String name) {
    DeleteConnectorRequest request = DeleteConnectorRequest.newBuilder().setName(name).build();
    return deleteConnectorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Serverless VPC Access connector. Returns NOT_FOUND if the resource does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (VpcAccessServiceClient vpcAccessServiceClient = VpcAccessServiceClient.create()) {
   *   DeleteConnectorRequest request =
   *       DeleteConnectorRequest.newBuilder()
   *           .setName(ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECTOR]").toString())
   *           .build();
   *   vpcAccessServiceClient.deleteConnectorAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteConnectorAsync(
      DeleteConnectorRequest request) {
    return deleteConnectorOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Serverless VPC Access connector. Returns NOT_FOUND if the resource does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (VpcAccessServiceClient vpcAccessServiceClient = VpcAccessServiceClient.create()) {
   *   DeleteConnectorRequest request =
   *       DeleteConnectorRequest.newBuilder()
   *           .setName(ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECTOR]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       vpcAccessServiceClient.deleteConnectorOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteConnectorRequest, Empty, OperationMetadata>
      deleteConnectorOperationCallable() {
    return stub.deleteConnectorOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Serverless VPC Access connector. Returns NOT_FOUND if the resource does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (VpcAccessServiceClient vpcAccessServiceClient = VpcAccessServiceClient.create()) {
   *   DeleteConnectorRequest request =
   *       DeleteConnectorRequest.newBuilder()
   *           .setName(ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECTOR]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       vpcAccessServiceClient.deleteConnectorCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteConnectorRequest, Operation> deleteConnectorCallable() {
    return stub.deleteConnectorCallable();
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

  public static class ListConnectorsPagedResponse
      extends AbstractPagedListResponse<
          ListConnectorsRequest,
          ListConnectorsResponse,
          Connector,
          ListConnectorsPage,
          ListConnectorsFixedSizeCollection> {

    public static ApiFuture<ListConnectorsPagedResponse> createAsync(
        PageContext<ListConnectorsRequest, ListConnectorsResponse, Connector> context,
        ApiFuture<ListConnectorsResponse> futureResponse) {
      ApiFuture<ListConnectorsPage> futurePage =
          ListConnectorsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListConnectorsPage, ListConnectorsPagedResponse>() {
            @Override
            public ListConnectorsPagedResponse apply(ListConnectorsPage input) {
              return new ListConnectorsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListConnectorsPagedResponse(ListConnectorsPage page) {
      super(page, ListConnectorsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListConnectorsPage
      extends AbstractPage<
          ListConnectorsRequest, ListConnectorsResponse, Connector, ListConnectorsPage> {

    private ListConnectorsPage(
        PageContext<ListConnectorsRequest, ListConnectorsResponse, Connector> context,
        ListConnectorsResponse response) {
      super(context, response);
    }

    private static ListConnectorsPage createEmptyPage() {
      return new ListConnectorsPage(null, null);
    }

    @Override
    protected ListConnectorsPage createPage(
        PageContext<ListConnectorsRequest, ListConnectorsResponse, Connector> context,
        ListConnectorsResponse response) {
      return new ListConnectorsPage(context, response);
    }

    @Override
    public ApiFuture<ListConnectorsPage> createPageAsync(
        PageContext<ListConnectorsRequest, ListConnectorsResponse, Connector> context,
        ApiFuture<ListConnectorsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListConnectorsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListConnectorsRequest,
          ListConnectorsResponse,
          Connector,
          ListConnectorsPage,
          ListConnectorsFixedSizeCollection> {

    private ListConnectorsFixedSizeCollection(List<ListConnectorsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListConnectorsFixedSizeCollection createEmptyCollection() {
      return new ListConnectorsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListConnectorsFixedSizeCollection createCollection(
        List<ListConnectorsPage> pages, int collectionSize) {
      return new ListConnectorsFixedSizeCollection(pages, collectionSize);
    }
  }
}
