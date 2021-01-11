/*
 * Copyright 2020 Google LLC
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
import com.google.cloud.compute.v1.stub.TargetInstancesStub;
import com.google.cloud.compute.v1.stub.TargetInstancesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The TargetInstances API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
 *   String project = "";
 *   String zone = "";
 *   String targetInstance = "";
 *   Operation response = targetInstancesClient.delete(project, zone, targetInstance);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the targetInstancesClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of TargetInstancesSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * TargetInstancesSettings targetInstancesSettings =
 *     TargetInstancesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TargetInstancesClient targetInstancesClient =
 *     TargetInstancesClient.create(targetInstancesSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * TargetInstancesSettings targetInstancesSettings =
 *     TargetInstancesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TargetInstancesClient targetInstancesClient =
 *     TargetInstancesClient.create(targetInstancesSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class TargetInstancesClient implements BackgroundResource {
  private final TargetInstancesSettings settings;
  private final TargetInstancesStub stub;

  /** Constructs an instance of TargetInstancesClient with default settings. */
  public static final TargetInstancesClient create() throws IOException {
    return create(TargetInstancesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TargetInstancesClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TargetInstancesClient create(TargetInstancesSettings settings)
      throws IOException {
    return new TargetInstancesClient(settings);
  }

  /**
   * Constructs an instance of TargetInstancesClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use TargetInstancesSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final TargetInstancesClient create(TargetInstancesStub stub) {
    return new TargetInstancesClient(stub);
  }

  /**
   * Constructs an instance of TargetInstancesClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected TargetInstancesClient(TargetInstancesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TargetInstancesStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected TargetInstancesClient(TargetInstancesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TargetInstancesSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public TargetInstancesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of target instances.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   String project = "";
   *   for (Entry&lt;String, TargetInstancesScopedList&gt; element : targetInstancesClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListTargetInstancesRequest request =
        AggregatedListTargetInstancesRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of target instances.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   String project = "";
   *   AggregatedListTargetInstancesRequest request = AggregatedListTargetInstancesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (Entry&lt;String, TargetInstancesScopedList&gt; element : targetInstancesClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListTargetInstancesRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of target instances.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   String project = "";
   *   AggregatedListTargetInstancesRequest request = AggregatedListTargetInstancesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;AggregatedListPagedResponse&gt; future = targetInstancesClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something
   *   for (Entry&lt;String, TargetInstancesScopedList&gt; element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<AggregatedListTargetInstancesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of target instances.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   String project = "";
   *   AggregatedListTargetInstancesRequest request = AggregatedListTargetInstancesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     TargetInstanceAggregatedList response = targetInstancesClient.aggregatedListCallable().call(request);
   *     for (Entry&lt;String, TargetInstancesScopedList&gt; element : response.getItemsMap()) {
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
  public final UnaryCallable<AggregatedListTargetInstancesRequest, TargetInstanceAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified TargetInstance resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String targetInstance = "";
   *   Operation response = targetInstancesClient.delete(project, zone, targetInstance);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone scoping this request.
   * @param targetInstance Name of the TargetInstance resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String zone, String targetInstance) {
    DeleteTargetInstanceRequest request =
        DeleteTargetInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setTargetInstance(targetInstance)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified TargetInstance resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   String project = "";
   *   String targetInstance = "";
   *   String zone = "";
   *   DeleteTargetInstanceRequest request = DeleteTargetInstanceRequest.newBuilder()
   *     .setProject(project)
   *     .setTargetInstance(targetInstance)
   *     .setZone(zone)
   *     .build();
   *   Operation response = targetInstancesClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteTargetInstanceRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified TargetInstance resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   String project = "";
   *   String targetInstance = "";
   *   String zone = "";
   *   DeleteTargetInstanceRequest request = DeleteTargetInstanceRequest.newBuilder()
   *     .setProject(project)
   *     .setTargetInstance(targetInstance)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = targetInstancesClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteTargetInstanceRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified TargetInstance resource. Gets a list of available target instances by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String targetInstance = "";
   *   TargetInstance response = targetInstancesClient.get(project, zone, targetInstance);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone scoping this request.
   * @param targetInstance Name of the TargetInstance resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetInstance get(String project, String zone, String targetInstance) {
    GetTargetInstanceRequest request =
        GetTargetInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setTargetInstance(targetInstance)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified TargetInstance resource. Gets a list of available target instances by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   String project = "";
   *   String targetInstance = "";
   *   String zone = "";
   *   GetTargetInstanceRequest request = GetTargetInstanceRequest.newBuilder()
   *     .setProject(project)
   *     .setTargetInstance(targetInstance)
   *     .setZone(zone)
   *     .build();
   *   TargetInstance response = targetInstancesClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetInstance get(GetTargetInstanceRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified TargetInstance resource. Gets a list of available target instances by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   String project = "";
   *   String targetInstance = "";
   *   String zone = "";
   *   GetTargetInstanceRequest request = GetTargetInstanceRequest.newBuilder()
   *     .setProject(project)
   *     .setTargetInstance(targetInstance)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;TargetInstance&gt; future = targetInstancesClient.getCallable().futureCall(request);
   *   // Do something
   *   TargetInstance response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetTargetInstanceRequest, TargetInstance> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a TargetInstance resource in the specified project and zone using the data included in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   TargetInstance targetInstanceResource = TargetInstance.newBuilder().build();
   *   Operation response = targetInstancesClient.insert(project, zone, targetInstanceResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone scoping this request.
   * @param targetInstanceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(
      String project, String zone, TargetInstance targetInstanceResource) {
    InsertTargetInstanceRequest request =
        InsertTargetInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setTargetInstanceResource(targetInstanceResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a TargetInstance resource in the specified project and zone using the data included in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   String project = "";
   *   TargetInstance targetInstanceResource = TargetInstance.newBuilder().build();
   *   String zone = "";
   *   InsertTargetInstanceRequest request = InsertTargetInstanceRequest.newBuilder()
   *     .setProject(project)
   *     .setTargetInstanceResource(targetInstanceResource)
   *     .setZone(zone)
   *     .build();
   *   Operation response = targetInstancesClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertTargetInstanceRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a TargetInstance resource in the specified project and zone using the data included in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   String project = "";
   *   TargetInstance targetInstanceResource = TargetInstance.newBuilder().build();
   *   String zone = "";
   *   InsertTargetInstanceRequest request = InsertTargetInstanceRequest.newBuilder()
   *     .setProject(project)
   *     .setTargetInstanceResource(targetInstanceResource)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = targetInstancesClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertTargetInstanceRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of TargetInstance resources available to the specified project and zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   for (TargetInstance element : targetInstancesClient.list(project, zone).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String zone) {
    ListTargetInstancesRequest request =
        ListTargetInstancesRequest.newBuilder().setProject(project).setZone(zone).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of TargetInstance resources available to the specified project and zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   ListTargetInstancesRequest request = ListTargetInstancesRequest.newBuilder()
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   for (TargetInstance element : targetInstancesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListTargetInstancesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of TargetInstance resources available to the specified project and zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   ListTargetInstancesRequest request = ListTargetInstancesRequest.newBuilder()
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = targetInstancesClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (TargetInstance element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListTargetInstancesRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of TargetInstance resources available to the specified project and zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   ListTargetInstancesRequest request = ListTargetInstancesRequest.newBuilder()
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   while (true) {
   *     TargetInstanceList response = targetInstancesClient.listCallable().call(request);
   *     for (TargetInstance element : response.getItemsList()) {
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
  public final UnaryCallable<ListTargetInstancesRequest, TargetInstanceList> listCallable() {
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

  public static class AggregatedListPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListTargetInstancesRequest,
          TargetInstanceAggregatedList,
          Entry<String, TargetInstancesScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListTargetInstancesRequest,
                TargetInstanceAggregatedList,
                Entry<String, TargetInstancesScopedList>>
            context,
        ApiFuture<TargetInstanceAggregatedList> futureResponse) {
      ApiFuture<AggregatedListPage> futurePage =
          AggregatedListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<AggregatedListPage, AggregatedListPagedResponse>() {
            @Override
            public AggregatedListPagedResponse apply(AggregatedListPage input) {
              return new AggregatedListPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private AggregatedListPagedResponse(AggregatedListPage page) {
      super(page, AggregatedListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListPage
      extends AbstractPage<
          AggregatedListTargetInstancesRequest,
          TargetInstanceAggregatedList,
          Entry<String, TargetInstancesScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListTargetInstancesRequest,
                TargetInstanceAggregatedList,
                Entry<String, TargetInstancesScopedList>>
            context,
        TargetInstanceAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListTargetInstancesRequest,
                TargetInstanceAggregatedList,
                Entry<String, TargetInstancesScopedList>>
            context,
        TargetInstanceAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListTargetInstancesRequest,
                TargetInstanceAggregatedList,
                Entry<String, TargetInstancesScopedList>>
            context,
        ApiFuture<TargetInstanceAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListTargetInstancesRequest,
          TargetInstanceAggregatedList,
          Entry<String, TargetInstancesScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    private AggregatedListFixedSizeCollection(List<AggregatedListPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListFixedSizeCollection createEmptyCollection() {
      return new AggregatedListFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListFixedSizeCollection createCollection(
        List<AggregatedListPage> pages, int collectionSize) {
      return new AggregatedListFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPagedResponse
      extends AbstractPagedListResponse<
          ListTargetInstancesRequest,
          TargetInstanceList,
          TargetInstance,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListTargetInstancesRequest, TargetInstanceList, TargetInstance> context,
        ApiFuture<TargetInstanceList> futureResponse) {
      ApiFuture<ListPage> futurePage =
          ListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListPage, ListPagedResponse>() {
            @Override
            public ListPagedResponse apply(ListPage input) {
              return new ListPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListPagedResponse(ListPage page) {
      super(page, ListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPage
      extends AbstractPage<
          ListTargetInstancesRequest, TargetInstanceList, TargetInstance, ListPage> {

    private ListPage(
        PageContext<ListTargetInstancesRequest, TargetInstanceList, TargetInstance> context,
        TargetInstanceList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListTargetInstancesRequest, TargetInstanceList, TargetInstance> context,
        TargetInstanceList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListTargetInstancesRequest, TargetInstanceList, TargetInstance> context,
        ApiFuture<TargetInstanceList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTargetInstancesRequest,
          TargetInstanceList,
          TargetInstance,
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
