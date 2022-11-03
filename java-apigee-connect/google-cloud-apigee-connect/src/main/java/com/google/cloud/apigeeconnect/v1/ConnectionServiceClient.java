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

package com.google.cloud.apigeeconnect.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apigeeconnect.v1.stub.ConnectionServiceStub;
import com.google.cloud.apigeeconnect.v1.stub.ConnectionServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service Interface for the Apigee Connect connection management APIs.
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
 * try (ConnectionServiceClient connectionServiceClient = ConnectionServiceClient.create()) {
 *   EndpointName parent = EndpointName.of("[PROJECT]", "[ENDPOINT]");
 *   for (Connection element : connectionServiceClient.listConnections(parent).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ConnectionServiceClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of ConnectionServiceSettings to
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
 * ConnectionServiceSettings connectionServiceSettings =
 *     ConnectionServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ConnectionServiceClient connectionServiceClient =
 *     ConnectionServiceClient.create(connectionServiceSettings);
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
 * ConnectionServiceSettings connectionServiceSettings =
 *     ConnectionServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ConnectionServiceClient connectionServiceClient =
 *     ConnectionServiceClient.create(connectionServiceSettings);
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
 * ConnectionServiceSettings connectionServiceSettings =
 *     ConnectionServiceSettings.newHttpJsonBuilder().build();
 * ConnectionServiceClient connectionServiceClient =
 *     ConnectionServiceClient.create(connectionServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ConnectionServiceClient implements BackgroundResource {
  private final ConnectionServiceSettings settings;
  private final ConnectionServiceStub stub;

  /** Constructs an instance of ConnectionServiceClient with default settings. */
  public static final ConnectionServiceClient create() throws IOException {
    return create(ConnectionServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ConnectionServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ConnectionServiceClient create(ConnectionServiceSettings settings)
      throws IOException {
    return new ConnectionServiceClient(settings);
  }

  /**
   * Constructs an instance of ConnectionServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(ConnectionServiceSettings).
   */
  public static final ConnectionServiceClient create(ConnectionServiceStub stub) {
    return new ConnectionServiceClient(stub);
  }

  /**
   * Constructs an instance of ConnectionServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ConnectionServiceClient(ConnectionServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ConnectionServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ConnectionServiceClient(ConnectionServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ConnectionServiceSettings getSettings() {
    return settings;
  }

  public ConnectionServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists connections that are currently active for the given Apigee Connect endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConnectionServiceClient connectionServiceClient = ConnectionServiceClient.create()) {
   *   EndpointName parent = EndpointName.of("[PROJECT]", "[ENDPOINT]");
   *   for (Connection element : connectionServiceClient.listConnections(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent name of the form: `projects/{project_number or
   *     project_id}/endpoints/{endpoint}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConnectionsPagedResponse listConnections(EndpointName parent) {
    ListConnectionsRequest request =
        ListConnectionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listConnections(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists connections that are currently active for the given Apigee Connect endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConnectionServiceClient connectionServiceClient = ConnectionServiceClient.create()) {
   *   String parent = EndpointName.of("[PROJECT]", "[ENDPOINT]").toString();
   *   for (Connection element : connectionServiceClient.listConnections(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent name of the form: `projects/{project_number or
   *     project_id}/endpoints/{endpoint}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConnectionsPagedResponse listConnections(String parent) {
    ListConnectionsRequest request = ListConnectionsRequest.newBuilder().setParent(parent).build();
    return listConnections(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists connections that are currently active for the given Apigee Connect endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConnectionServiceClient connectionServiceClient = ConnectionServiceClient.create()) {
   *   ListConnectionsRequest request =
   *       ListConnectionsRequest.newBuilder()
   *           .setParent(EndpointName.of("[PROJECT]", "[ENDPOINT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Connection element : connectionServiceClient.listConnections(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConnectionsPagedResponse listConnections(ListConnectionsRequest request) {
    return listConnectionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists connections that are currently active for the given Apigee Connect endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConnectionServiceClient connectionServiceClient = ConnectionServiceClient.create()) {
   *   ListConnectionsRequest request =
   *       ListConnectionsRequest.newBuilder()
   *           .setParent(EndpointName.of("[PROJECT]", "[ENDPOINT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Connection> future =
   *       connectionServiceClient.listConnectionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Connection element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListConnectionsRequest, ListConnectionsPagedResponse>
      listConnectionsPagedCallable() {
    return stub.listConnectionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists connections that are currently active for the given Apigee Connect endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConnectionServiceClient connectionServiceClient = ConnectionServiceClient.create()) {
   *   ListConnectionsRequest request =
   *       ListConnectionsRequest.newBuilder()
   *           .setParent(EndpointName.of("[PROJECT]", "[ENDPOINT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListConnectionsResponse response =
   *         connectionServiceClient.listConnectionsCallable().call(request);
   *     for (Connection element : response.getConnectionsList()) {
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
  public final UnaryCallable<ListConnectionsRequest, ListConnectionsResponse>
      listConnectionsCallable() {
    return stub.listConnectionsCallable();
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

  public static class ListConnectionsPagedResponse
      extends AbstractPagedListResponse<
          ListConnectionsRequest,
          ListConnectionsResponse,
          Connection,
          ListConnectionsPage,
          ListConnectionsFixedSizeCollection> {

    public static ApiFuture<ListConnectionsPagedResponse> createAsync(
        PageContext<ListConnectionsRequest, ListConnectionsResponse, Connection> context,
        ApiFuture<ListConnectionsResponse> futureResponse) {
      ApiFuture<ListConnectionsPage> futurePage =
          ListConnectionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListConnectionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListConnectionsPagedResponse(ListConnectionsPage page) {
      super(page, ListConnectionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListConnectionsPage
      extends AbstractPage<
          ListConnectionsRequest, ListConnectionsResponse, Connection, ListConnectionsPage> {

    private ListConnectionsPage(
        PageContext<ListConnectionsRequest, ListConnectionsResponse, Connection> context,
        ListConnectionsResponse response) {
      super(context, response);
    }

    private static ListConnectionsPage createEmptyPage() {
      return new ListConnectionsPage(null, null);
    }

    @Override
    protected ListConnectionsPage createPage(
        PageContext<ListConnectionsRequest, ListConnectionsResponse, Connection> context,
        ListConnectionsResponse response) {
      return new ListConnectionsPage(context, response);
    }

    @Override
    public ApiFuture<ListConnectionsPage> createPageAsync(
        PageContext<ListConnectionsRequest, ListConnectionsResponse, Connection> context,
        ApiFuture<ListConnectionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListConnectionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListConnectionsRequest,
          ListConnectionsResponse,
          Connection,
          ListConnectionsPage,
          ListConnectionsFixedSizeCollection> {

    private ListConnectionsFixedSizeCollection(
        List<ListConnectionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListConnectionsFixedSizeCollection createEmptyCollection() {
      return new ListConnectionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListConnectionsFixedSizeCollection createCollection(
        List<ListConnectionsPage> pages, int collectionSize) {
      return new ListConnectionsFixedSizeCollection(pages, collectionSize);
    }
  }
}
