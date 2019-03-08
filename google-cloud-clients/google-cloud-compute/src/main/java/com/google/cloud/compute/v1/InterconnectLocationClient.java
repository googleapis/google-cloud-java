/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.InterconnectLocationStub;
import com.google.cloud.compute.v1.stub.InterconnectLocationStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (InterconnectLocationClient interconnectLocationClient = InterconnectLocationClient.create()) {
 *   ProjectGlobalInterconnectLocationName interconnectLocation = ProjectGlobalInterconnectLocationName.of("[PROJECT]", "[INTERCONNECT_LOCATION]");
 *   InterconnectLocation response = interconnectLocationClient.getInterconnectLocation(interconnectLocation);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the interconnectLocationClient object to clean up
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
 * <p>This class can be customized by passing in a custom instance of InterconnectLocationSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * InterconnectLocationSettings interconnectLocationSettings =
 *     InterconnectLocationSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * InterconnectLocationClient interconnectLocationClient =
 *     InterconnectLocationClient.create(interconnectLocationSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * InterconnectLocationSettings interconnectLocationSettings =
 *     InterconnectLocationSettings.newBuilder().setEndpoint(myEndpoint).build();
 * InterconnectLocationClient interconnectLocationClient =
 *     InterconnectLocationClient.create(interconnectLocationSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class InterconnectLocationClient implements BackgroundResource {
  private final InterconnectLocationSettings settings;
  private final InterconnectLocationStub stub;

  /** Constructs an instance of InterconnectLocationClient with default settings. */
  public static final InterconnectLocationClient create() throws IOException {
    return create(InterconnectLocationSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of InterconnectLocationClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final InterconnectLocationClient create(InterconnectLocationSettings settings)
      throws IOException {
    return new InterconnectLocationClient(settings);
  }

  /**
   * Constructs an instance of InterconnectLocationClient, using the given stub for making calls.
   * This is for advanced usage - prefer to use InterconnectLocationSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final InterconnectLocationClient create(InterconnectLocationStub stub) {
    return new InterconnectLocationClient(stub);
  }

  /**
   * Constructs an instance of InterconnectLocationClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected InterconnectLocationClient(InterconnectLocationSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((InterconnectLocationStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected InterconnectLocationClient(InterconnectLocationStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final InterconnectLocationSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public InterconnectLocationStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the details for the specified interconnect location. Gets a list of available
   * interconnect locations by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectLocationClient interconnectLocationClient = InterconnectLocationClient.create()) {
   *   ProjectGlobalInterconnectLocationName interconnectLocation = ProjectGlobalInterconnectLocationName.of("[PROJECT]", "[INTERCONNECT_LOCATION]");
   *   InterconnectLocation response = interconnectLocationClient.getInterconnectLocation(interconnectLocation);
   * }
   * </code></pre>
   *
   * @param interconnectLocation Name of the interconnect location to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final InterconnectLocation getInterconnectLocation(
      ProjectGlobalInterconnectLocationName interconnectLocation) {

    GetInterconnectLocationHttpRequest request =
        GetInterconnectLocationHttpRequest.newBuilder()
            .setInterconnectLocation(
                interconnectLocation == null ? null : interconnectLocation.toString())
            .build();
    return getInterconnectLocation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the details for the specified interconnect location. Gets a list of available
   * interconnect locations by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectLocationClient interconnectLocationClient = InterconnectLocationClient.create()) {
   *   ProjectGlobalInterconnectLocationName interconnectLocation = ProjectGlobalInterconnectLocationName.of("[PROJECT]", "[INTERCONNECT_LOCATION]");
   *   InterconnectLocation response = interconnectLocationClient.getInterconnectLocation(interconnectLocation.toString());
   * }
   * </code></pre>
   *
   * @param interconnectLocation Name of the interconnect location to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final InterconnectLocation getInterconnectLocation(String interconnectLocation) {

    GetInterconnectLocationHttpRequest request =
        GetInterconnectLocationHttpRequest.newBuilder()
            .setInterconnectLocation(interconnectLocation)
            .build();
    return getInterconnectLocation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the details for the specified interconnect location. Gets a list of available
   * interconnect locations by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectLocationClient interconnectLocationClient = InterconnectLocationClient.create()) {
   *   ProjectGlobalInterconnectLocationName interconnectLocation = ProjectGlobalInterconnectLocationName.of("[PROJECT]", "[INTERCONNECT_LOCATION]");
   *   GetInterconnectLocationHttpRequest request = GetInterconnectLocationHttpRequest.newBuilder()
   *     .setInterconnectLocation(interconnectLocation.toString())
   *     .build();
   *   InterconnectLocation response = interconnectLocationClient.getInterconnectLocation(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final InterconnectLocation getInterconnectLocation(
      GetInterconnectLocationHttpRequest request) {
    return getInterconnectLocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the details for the specified interconnect location. Gets a list of available
   * interconnect locations by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectLocationClient interconnectLocationClient = InterconnectLocationClient.create()) {
   *   ProjectGlobalInterconnectLocationName interconnectLocation = ProjectGlobalInterconnectLocationName.of("[PROJECT]", "[INTERCONNECT_LOCATION]");
   *   GetInterconnectLocationHttpRequest request = GetInterconnectLocationHttpRequest.newBuilder()
   *     .setInterconnectLocation(interconnectLocation.toString())
   *     .build();
   *   ApiFuture&lt;InterconnectLocation&gt; future = interconnectLocationClient.getInterconnectLocationCallable().futureCall(request);
   *   // Do something
   *   InterconnectLocation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetInterconnectLocationHttpRequest, InterconnectLocation>
      getInterconnectLocationCallable() {
    return stub.getInterconnectLocationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of interconnect locations available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectLocationClient interconnectLocationClient = InterconnectLocationClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (InterconnectLocation element : interconnectLocationClient.listInterconnectLocations(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListInterconnectLocationsPagedResponse listInterconnectLocations(
      ProjectName project) {
    ListInterconnectLocationsHttpRequest request =
        ListInterconnectLocationsHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return listInterconnectLocations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of interconnect locations available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectLocationClient interconnectLocationClient = InterconnectLocationClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (InterconnectLocation element : interconnectLocationClient.listInterconnectLocations(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListInterconnectLocationsPagedResponse listInterconnectLocations(String project) {
    ListInterconnectLocationsHttpRequest request =
        ListInterconnectLocationsHttpRequest.newBuilder().setProject(project).build();
    return listInterconnectLocations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of interconnect locations available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectLocationClient interconnectLocationClient = InterconnectLocationClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListInterconnectLocationsHttpRequest request = ListInterconnectLocationsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   for (InterconnectLocation element : interconnectLocationClient.listInterconnectLocations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListInterconnectLocationsPagedResponse listInterconnectLocations(
      ListInterconnectLocationsHttpRequest request) {
    return listInterconnectLocationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of interconnect locations available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectLocationClient interconnectLocationClient = InterconnectLocationClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListInterconnectLocationsHttpRequest request = ListInterconnectLocationsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;ListInterconnectLocationsPagedResponse&gt; future = interconnectLocationClient.listInterconnectLocationsPagedCallable().futureCall(request);
   *   // Do something
   *   for (InterconnectLocation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          ListInterconnectLocationsHttpRequest, ListInterconnectLocationsPagedResponse>
      listInterconnectLocationsPagedCallable() {
    return stub.listInterconnectLocationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of interconnect locations available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectLocationClient interconnectLocationClient = InterconnectLocationClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListInterconnectLocationsHttpRequest request = ListInterconnectLocationsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   while (true) {
   *     InterconnectLocationList response = interconnectLocationClient.listInterconnectLocationsCallable().call(request);
   *     for (InterconnectLocation element : response.getItemsList()) {
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
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListInterconnectLocationsHttpRequest, InterconnectLocationList>
      listInterconnectLocationsCallable() {
    return stub.listInterconnectLocationsCallable();
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

  public static class ListInterconnectLocationsPagedResponse
      extends AbstractPagedListResponse<
          ListInterconnectLocationsHttpRequest,
          InterconnectLocationList,
          InterconnectLocation,
          ListInterconnectLocationsPage,
          ListInterconnectLocationsFixedSizeCollection> {

    public static ApiFuture<ListInterconnectLocationsPagedResponse> createAsync(
        PageContext<
                ListInterconnectLocationsHttpRequest,
                InterconnectLocationList,
                InterconnectLocation>
            context,
        ApiFuture<InterconnectLocationList> futureResponse) {
      ApiFuture<ListInterconnectLocationsPage> futurePage =
          ListInterconnectLocationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListInterconnectLocationsPage, ListInterconnectLocationsPagedResponse>() {
            @Override
            public ListInterconnectLocationsPagedResponse apply(
                ListInterconnectLocationsPage input) {
              return new ListInterconnectLocationsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListInterconnectLocationsPagedResponse(ListInterconnectLocationsPage page) {
      super(page, ListInterconnectLocationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInterconnectLocationsPage
      extends AbstractPage<
          ListInterconnectLocationsHttpRequest,
          InterconnectLocationList,
          InterconnectLocation,
          ListInterconnectLocationsPage> {

    private ListInterconnectLocationsPage(
        PageContext<
                ListInterconnectLocationsHttpRequest,
                InterconnectLocationList,
                InterconnectLocation>
            context,
        InterconnectLocationList response) {
      super(context, response);
    }

    private static ListInterconnectLocationsPage createEmptyPage() {
      return new ListInterconnectLocationsPage(null, null);
    }

    @Override
    protected ListInterconnectLocationsPage createPage(
        PageContext<
                ListInterconnectLocationsHttpRequest,
                InterconnectLocationList,
                InterconnectLocation>
            context,
        InterconnectLocationList response) {
      return new ListInterconnectLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListInterconnectLocationsPage> createPageAsync(
        PageContext<
                ListInterconnectLocationsHttpRequest,
                InterconnectLocationList,
                InterconnectLocation>
            context,
        ApiFuture<InterconnectLocationList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInterconnectLocationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInterconnectLocationsHttpRequest,
          InterconnectLocationList,
          InterconnectLocation,
          ListInterconnectLocationsPage,
          ListInterconnectLocationsFixedSizeCollection> {

    private ListInterconnectLocationsFixedSizeCollection(
        List<ListInterconnectLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInterconnectLocationsFixedSizeCollection createEmptyCollection() {
      return new ListInterconnectLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInterconnectLocationsFixedSizeCollection createCollection(
        List<ListInterconnectLocationsPage> pages, int collectionSize) {
      return new ListInterconnectLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
