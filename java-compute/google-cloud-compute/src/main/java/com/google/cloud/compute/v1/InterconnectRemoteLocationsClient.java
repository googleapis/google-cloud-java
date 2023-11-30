/*
 * Copyright 2023 Google LLC
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
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.InterconnectRemoteLocationsStub;
import com.google.cloud.compute.v1.stub.InterconnectRemoteLocationsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The InterconnectRemoteLocations API.
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
 * try (InterconnectRemoteLocationsClient interconnectRemoteLocationsClient =
 *     InterconnectRemoteLocationsClient.create()) {
 *   String project = "project-309310695";
 *   String interconnectRemoteLocation = "interconnectRemoteLocation-993839543";
 *   InterconnectRemoteLocation response =
 *       interconnectRemoteLocationsClient.get(project, interconnectRemoteLocation);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the InterconnectRemoteLocationsClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <table>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    <tr>
 *      <td>Get</td>
 *      <td><p>Returns the details for the specified interconnect remote location. Gets a list of available interconnect remote locations by making a list() request.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>get(GetInterconnectRemoteLocationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>get(String project, String interconnectRemoteLocation)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>List</td>
 *      <td><p>Retrieves the list of interconnect remote locations available to the specified project.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>list(ListInterconnectRemoteLocationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>list(String project)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listPagedCallable()
 *           <li>listCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of
 * InterconnectRemoteLocationsSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * InterconnectRemoteLocationsSettings interconnectRemoteLocationsSettings =
 *     InterconnectRemoteLocationsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * InterconnectRemoteLocationsClient interconnectRemoteLocationsClient =
 *     InterconnectRemoteLocationsClient.create(interconnectRemoteLocationsSettings);
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
 * InterconnectRemoteLocationsSettings interconnectRemoteLocationsSettings =
 *     InterconnectRemoteLocationsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * InterconnectRemoteLocationsClient interconnectRemoteLocationsClient =
 *     InterconnectRemoteLocationsClient.create(interconnectRemoteLocationsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class InterconnectRemoteLocationsClient implements BackgroundResource {
  private final InterconnectRemoteLocationsSettings settings;
  private final InterconnectRemoteLocationsStub stub;

  /** Constructs an instance of InterconnectRemoteLocationsClient with default settings. */
  public static final InterconnectRemoteLocationsClient create() throws IOException {
    return create(InterconnectRemoteLocationsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of InterconnectRemoteLocationsClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final InterconnectRemoteLocationsClient create(
      InterconnectRemoteLocationsSettings settings) throws IOException {
    return new InterconnectRemoteLocationsClient(settings);
  }

  /**
   * Constructs an instance of InterconnectRemoteLocationsClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(InterconnectRemoteLocationsSettings).
   */
  public static final InterconnectRemoteLocationsClient create(
      InterconnectRemoteLocationsStub stub) {
    return new InterconnectRemoteLocationsClient(stub);
  }

  /**
   * Constructs an instance of InterconnectRemoteLocationsClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected InterconnectRemoteLocationsClient(InterconnectRemoteLocationsSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((InterconnectRemoteLocationsStubSettings) settings.getStubSettings()).createStub();
  }

  protected InterconnectRemoteLocationsClient(InterconnectRemoteLocationsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final InterconnectRemoteLocationsSettings getSettings() {
    return settings;
  }

  public InterconnectRemoteLocationsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details for the specified interconnect remote location. Gets a list of available
   * interconnect remote locations by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterconnectRemoteLocationsClient interconnectRemoteLocationsClient =
   *     InterconnectRemoteLocationsClient.create()) {
   *   String project = "project-309310695";
   *   String interconnectRemoteLocation = "interconnectRemoteLocation-993839543";
   *   InterconnectRemoteLocation response =
   *       interconnectRemoteLocationsClient.get(project, interconnectRemoteLocation);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param interconnectRemoteLocation Name of the interconnect remote location to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InterconnectRemoteLocation get(String project, String interconnectRemoteLocation) {
    GetInterconnectRemoteLocationRequest request =
        GetInterconnectRemoteLocationRequest.newBuilder()
            .setProject(project)
            .setInterconnectRemoteLocation(interconnectRemoteLocation)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details for the specified interconnect remote location. Gets a list of available
   * interconnect remote locations by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterconnectRemoteLocationsClient interconnectRemoteLocationsClient =
   *     InterconnectRemoteLocationsClient.create()) {
   *   GetInterconnectRemoteLocationRequest request =
   *       GetInterconnectRemoteLocationRequest.newBuilder()
   *           .setInterconnectRemoteLocation("interconnectRemoteLocation-993839543")
   *           .setProject("project-309310695")
   *           .build();
   *   InterconnectRemoteLocation response = interconnectRemoteLocationsClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InterconnectRemoteLocation get(GetInterconnectRemoteLocationRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details for the specified interconnect remote location. Gets a list of available
   * interconnect remote locations by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterconnectRemoteLocationsClient interconnectRemoteLocationsClient =
   *     InterconnectRemoteLocationsClient.create()) {
   *   GetInterconnectRemoteLocationRequest request =
   *       GetInterconnectRemoteLocationRequest.newBuilder()
   *           .setInterconnectRemoteLocation("interconnectRemoteLocation-993839543")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<InterconnectRemoteLocation> future =
   *       interconnectRemoteLocationsClient.getCallable().futureCall(request);
   *   // Do something.
   *   InterconnectRemoteLocation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetInterconnectRemoteLocationRequest, InterconnectRemoteLocation>
      getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of interconnect remote locations available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterconnectRemoteLocationsClient interconnectRemoteLocationsClient =
   *     InterconnectRemoteLocationsClient.create()) {
   *   String project = "project-309310695";
   *   for (InterconnectRemoteLocation element :
   *       interconnectRemoteLocationsClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListInterconnectRemoteLocationsRequest request =
        ListInterconnectRemoteLocationsRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of interconnect remote locations available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterconnectRemoteLocationsClient interconnectRemoteLocationsClient =
   *     InterconnectRemoteLocationsClient.create()) {
   *   ListInterconnectRemoteLocationsRequest request =
   *       ListInterconnectRemoteLocationsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (InterconnectRemoteLocation element :
   *       interconnectRemoteLocationsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListInterconnectRemoteLocationsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of interconnect remote locations available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterconnectRemoteLocationsClient interconnectRemoteLocationsClient =
   *     InterconnectRemoteLocationsClient.create()) {
   *   ListInterconnectRemoteLocationsRequest request =
   *       ListInterconnectRemoteLocationsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<InterconnectRemoteLocation> future =
   *       interconnectRemoteLocationsClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (InterconnectRemoteLocation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListInterconnectRemoteLocationsRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of interconnect remote locations available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterconnectRemoteLocationsClient interconnectRemoteLocationsClient =
   *     InterconnectRemoteLocationsClient.create()) {
   *   ListInterconnectRemoteLocationsRequest request =
   *       ListInterconnectRemoteLocationsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     InterconnectRemoteLocationList response =
   *         interconnectRemoteLocationsClient.listCallable().call(request);
   *     for (InterconnectRemoteLocation element : response.getItemsList()) {
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
  public final UnaryCallable<ListInterconnectRemoteLocationsRequest, InterconnectRemoteLocationList>
      listCallable() {
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
          ListInterconnectRemoteLocationsRequest,
          InterconnectRemoteLocationList,
          InterconnectRemoteLocation,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<
                ListInterconnectRemoteLocationsRequest,
                InterconnectRemoteLocationList,
                InterconnectRemoteLocation>
            context,
        ApiFuture<InterconnectRemoteLocationList> futureResponse) {
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
      extends AbstractPage<
          ListInterconnectRemoteLocationsRequest,
          InterconnectRemoteLocationList,
          InterconnectRemoteLocation,
          ListPage> {

    private ListPage(
        PageContext<
                ListInterconnectRemoteLocationsRequest,
                InterconnectRemoteLocationList,
                InterconnectRemoteLocation>
            context,
        InterconnectRemoteLocationList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<
                ListInterconnectRemoteLocationsRequest,
                InterconnectRemoteLocationList,
                InterconnectRemoteLocation>
            context,
        InterconnectRemoteLocationList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<
                ListInterconnectRemoteLocationsRequest,
                InterconnectRemoteLocationList,
                InterconnectRemoteLocation>
            context,
        ApiFuture<InterconnectRemoteLocationList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInterconnectRemoteLocationsRequest,
          InterconnectRemoteLocationList,
          InterconnectRemoteLocation,
          ListPage,
          ListFixedSizeCollection> {

    private ListFixedSizeCollection(List<ListPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFixedSizeCollection createEmptyCollection() {
      return new ListFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFixedSizeCollection createCollection(List<ListPage> pages, int collectionSize) {
      return new ListFixedSizeCollection(pages, collectionSize);
    }
  }
}
