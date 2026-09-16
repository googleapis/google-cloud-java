/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.compute.v1;

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
import com.google.cloud.compute.v1.stub.HostsStub;
import com.google.cloud.compute.v1.stub.HostsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The Hosts API.
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
 * try (HostsClient hostsClient = HostsClient.create()) {
 *   String project = "project-309310695";
 *   String zone = "zone3744684";
 *   String association = "association-87499647";
 *   String host = "host3208616";
 *   Host response = hostsClient.get(project, zone, association, host);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the HostsClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> Get</td>
 *      <td><p> Retrieves information about the specified host.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> get(GetHostRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> get(String project, String zone, String association, String host)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetVersion</td>
 *      <td><p> Allows customers to get SBOM versions of a host.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getVersionAsync(GetVersionHostRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> getVersionAsync(String project, String zone, String association, String host, HostsGetVersionRequest hostsGetVersionRequestResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getVersionOperationCallable()
 *           <li><p> getVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> List</td>
 *      <td><p> Retrieves a list of hosts.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> list(ListHostsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> list(String project, String zone, String association)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPagedCallable()
 *           <li><p> listCallable()
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
 * <p>This class can be customized by passing in a custom instance of HostsSettings to create(). For
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
 * HostsSettings hostsSettings =
 *     HostsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * HostsClient hostsClient = HostsClient.create(hostsSettings);
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
 * HostsSettings hostsSettings = HostsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * HostsClient hostsClient = HostsClient.create(hostsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HostsClient implements BackgroundResource {
  private final @Nullable HostsSettings settings;
  private final HostsStub stub;

  /** Constructs an instance of HostsClient with default settings. */
  public static final HostsClient create() throws IOException {
    return create(HostsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of HostsClient, using the given settings. The channels are created based
   * on the settings passed in, or defaults for any settings that are not set.
   */
  public static final HostsClient create(HostsSettings settings) throws IOException {
    return new HostsClient(settings);
  }

  /**
   * Constructs an instance of HostsClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(HostsSettings).
   */
  public static final HostsClient create(HostsStub stub) {
    return new HostsClient(stub);
  }

  /**
   * Constructs an instance of HostsClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected HostsClient(HostsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((HostsStubSettings) settings.getStubSettings()).createStub();
  }

  protected HostsClient(HostsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable HostsSettings getSettings() {
    return settings;
  }

  public HostsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves information about the specified host.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HostsClient hostsClient = HostsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String association = "association-87499647";
   *   String host = "host3208616";
   *   Host response = hostsClient.get(project, zone, association, host);
   * }
   * }</pre>
   *
   * @param project The project ID for this request.
   * @param zone The name of the zone for this request, formatted as RFC1035.
   * @param association The parent resource association for the Host. This field specifies the
   *     hierarchical context (e.g., reservation, block, sub-block) when accessing the host. For
   *     example, reservations/reservation_name,
   *     reservations/reservation_name/reservationBlocks/reservation_block_name or
   *     reservations/reservation_name/reservationBlocks/reservation_block_name/reservationSubBlocks/reservation_sub_block_name.
   * @param host The name of the host, formatted as RFC1035 or a resource ID number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Host get(String project, String zone, String association, String host) {
    GetHostRequest request =
        GetHostRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setAssociation(association)
            .setHost(host)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves information about the specified host.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HostsClient hostsClient = HostsClient.create()) {
   *   GetHostRequest request =
   *       GetHostRequest.newBuilder()
   *           .setAssociation("association-87499647")
   *           .setHost("host3208616")
   *           .setProject("project-309310695")
   *           .setZone("zone3744684")
   *           .build();
   *   Host response = hostsClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Host get(GetHostRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves information about the specified host.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HostsClient hostsClient = HostsClient.create()) {
   *   GetHostRequest request =
   *       GetHostRequest.newBuilder()
   *           .setAssociation("association-87499647")
   *           .setHost("host3208616")
   *           .setProject("project-309310695")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Host> future = hostsClient.getCallable().futureCall(request);
   *   // Do something.
   *   Host response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetHostRequest, Host> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows customers to get SBOM versions of a host.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HostsClient hostsClient = HostsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String association = "association-87499647";
   *   String host = "host3208616";
   *   HostsGetVersionRequest hostsGetVersionRequestResource =
   *       HostsGetVersionRequest.newBuilder().build();
   *   Operation response =
   *       hostsClient
   *           .getVersionAsync(project, zone, association, host, hostsGetVersionRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone for this request. Zone name should conform to RFC1035.
   * @param association The parent resource association for the Host. This field specifies the
   *     hierarchical context (e.g., reservation, block, sub-block) when accessing the host.
   * @param host The name of the host, formatted as RFC1035 or a resource ID number.
   * @param hostsGetVersionRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> getVersionAsync(
      String project,
      String zone,
      String association,
      String host,
      HostsGetVersionRequest hostsGetVersionRequestResource) {
    GetVersionHostRequest request =
        GetVersionHostRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setAssociation(association)
            .setHost(host)
            .setHostsGetVersionRequestResource(hostsGetVersionRequestResource)
            .build();
    return getVersionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows customers to get SBOM versions of a host.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HostsClient hostsClient = HostsClient.create()) {
   *   GetVersionHostRequest request =
   *       GetVersionHostRequest.newBuilder()
   *           .setAssociation("association-87499647")
   *           .setHost("host3208616")
   *           .setHostsGetVersionRequestResource(HostsGetVersionRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = hostsClient.getVersionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> getVersionAsync(
      GetVersionHostRequest request) {
    return getVersionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows customers to get SBOM versions of a host.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HostsClient hostsClient = HostsClient.create()) {
   *   GetVersionHostRequest request =
   *       GetVersionHostRequest.newBuilder()
   *           .setAssociation("association-87499647")
   *           .setHost("host3208616")
   *           .setHostsGetVersionRequestResource(HostsGetVersionRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       hostsClient.getVersionOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<GetVersionHostRequest, Operation, Operation>
      getVersionOperationCallable() {
    return stub.getVersionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows customers to get SBOM versions of a host.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HostsClient hostsClient = HostsClient.create()) {
   *   GetVersionHostRequest request =
   *       GetVersionHostRequest.newBuilder()
   *           .setAssociation("association-87499647")
   *           .setHost("host3208616")
   *           .setHostsGetVersionRequestResource(HostsGetVersionRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future = hostsClient.getVersionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetVersionHostRequest, Operation> getVersionCallable() {
    return stub.getVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of hosts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HostsClient hostsClient = HostsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String association = "association-87499647";
   *   for (Host element : hostsClient.list(project, zone, association).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project The project ID for this request.
   * @param zone The name of the zone for this request, formatted as RFC1035.
   * @param association The parent resource association for the Host. This field specifies the
   *     hierarchical context (e.g., reservation, block, sub-block) when accessing the host. For
   *     example, reservations/reservation_name,
   *     reservations/reservation_name/reservationBlocks/reservation_block_name or
   *     reservations/reservation_name/reservationBlocks/reservation_block_name/reservationSubBlocks/reservation_sub_block_name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String zone, String association) {
    ListHostsRequest request =
        ListHostsRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setAssociation(association)
            .build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of hosts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HostsClient hostsClient = HostsClient.create()) {
   *   ListHostsRequest request =
   *       ListHostsRequest.newBuilder()
   *           .setAssociation("association-87499647")
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   for (Host element : hostsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListHostsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of hosts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HostsClient hostsClient = HostsClient.create()) {
   *   ListHostsRequest request =
   *       ListHostsRequest.newBuilder()
   *           .setAssociation("association-87499647")
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Host> future = hostsClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Host element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListHostsRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of hosts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HostsClient hostsClient = HostsClient.create()) {
   *   ListHostsRequest request =
   *       ListHostsRequest.newBuilder()
   *           .setAssociation("association-87499647")
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   while (true) {
   *     HostsListResponse response = hostsClient.listCallable().call(request);
   *     for (Host element : response.getItemsList()) {
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
  public final UnaryCallable<ListHostsRequest, HostsListResponse> listCallable() {
    return stub.listCallable();
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

  public static class ListPagedResponse
      extends AbstractPagedListResponse<
          ListHostsRequest, HostsListResponse, Host, ListPage, ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListHostsRequest, HostsListResponse, Host> context,
        ApiFuture<HostsListResponse> futureResponse) {
      ApiFuture<ListPage> futurePage =
          ListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListPagedResponse(ListPage page) {
      super(page, ListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPage
      extends AbstractPage<ListHostsRequest, HostsListResponse, Host, ListPage> {

    private ListPage(
        @Nullable PageContext<ListHostsRequest, HostsListResponse, Host> context,
        @Nullable HostsListResponse response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        @Nullable PageContext<ListHostsRequest, HostsListResponse, Host> context,
        @Nullable HostsListResponse response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        @Nullable PageContext<ListHostsRequest, HostsListResponse, Host> context,
        ApiFuture<HostsListResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListHostsRequest, HostsListResponse, Host, ListPage, ListFixedSizeCollection> {

    private ListFixedSizeCollection(@Nullable List<ListPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFixedSizeCollection createEmptyCollection() {
      return new ListFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFixedSizeCollection createCollection(
        @Nullable List<ListPage> pages, int collectionSize) {
      return new ListFixedSizeCollection(pages, collectionSize);
    }
  }
}
