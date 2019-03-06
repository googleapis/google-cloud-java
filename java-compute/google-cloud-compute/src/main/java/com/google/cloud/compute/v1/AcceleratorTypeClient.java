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
import com.google.cloud.compute.v1.stub.AcceleratorTypeStub;
import com.google.cloud.compute.v1.stub.AcceleratorTypeStubSettings;
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
 * try (AcceleratorTypeClient acceleratorTypeClient = AcceleratorTypeClient.create()) {
 *   ProjectZoneAcceleratorTypeName acceleratorType = ProjectZoneAcceleratorTypeName.of("[PROJECT]", "[ZONE]", "[ACCELERATOR_TYPE]");
 *   AcceleratorType response = acceleratorTypeClient.getAcceleratorType(acceleratorType);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the acceleratorTypeClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of AcceleratorTypeSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * AcceleratorTypeSettings acceleratorTypeSettings =
 *     AcceleratorTypeSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AcceleratorTypeClient acceleratorTypeClient =
 *     AcceleratorTypeClient.create(acceleratorTypeSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * AcceleratorTypeSettings acceleratorTypeSettings =
 *     AcceleratorTypeSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AcceleratorTypeClient acceleratorTypeClient =
 *     AcceleratorTypeClient.create(acceleratorTypeSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class AcceleratorTypeClient implements BackgroundResource {
  private final AcceleratorTypeSettings settings;
  private final AcceleratorTypeStub stub;

  /** Constructs an instance of AcceleratorTypeClient with default settings. */
  public static final AcceleratorTypeClient create() throws IOException {
    return create(AcceleratorTypeSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AcceleratorTypeClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AcceleratorTypeClient create(AcceleratorTypeSettings settings)
      throws IOException {
    return new AcceleratorTypeClient(settings);
  }

  /**
   * Constructs an instance of AcceleratorTypeClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use AcceleratorTypeSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final AcceleratorTypeClient create(AcceleratorTypeStub stub) {
    return new AcceleratorTypeClient(stub);
  }

  /**
   * Constructs an instance of AcceleratorTypeClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected AcceleratorTypeClient(AcceleratorTypeSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AcceleratorTypeStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected AcceleratorTypeClient(AcceleratorTypeStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AcceleratorTypeSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public AcceleratorTypeStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of accelerator types.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AcceleratorTypeClient acceleratorTypeClient = AcceleratorTypeClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (AcceleratorTypesScopedList element : acceleratorTypeClient.aggregatedListAcceleratorTypes(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListAcceleratorTypesPagedResponse aggregatedListAcceleratorTypes(
      ProjectName project) {
    AggregatedListAcceleratorTypesHttpRequest request =
        AggregatedListAcceleratorTypesHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return aggregatedListAcceleratorTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of accelerator types.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AcceleratorTypeClient acceleratorTypeClient = AcceleratorTypeClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (AcceleratorTypesScopedList element : acceleratorTypeClient.aggregatedListAcceleratorTypes(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListAcceleratorTypesPagedResponse aggregatedListAcceleratorTypes(
      String project) {
    AggregatedListAcceleratorTypesHttpRequest request =
        AggregatedListAcceleratorTypesHttpRequest.newBuilder().setProject(project).build();
    return aggregatedListAcceleratorTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of accelerator types.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AcceleratorTypeClient acceleratorTypeClient = AcceleratorTypeClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListAcceleratorTypesHttpRequest request = AggregatedListAcceleratorTypesHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   for (AcceleratorTypesScopedList element : acceleratorTypeClient.aggregatedListAcceleratorTypes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListAcceleratorTypesPagedResponse aggregatedListAcceleratorTypes(
      AggregatedListAcceleratorTypesHttpRequest request) {
    return aggregatedListAcceleratorTypesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of accelerator types.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AcceleratorTypeClient acceleratorTypeClient = AcceleratorTypeClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListAcceleratorTypesHttpRequest request = AggregatedListAcceleratorTypesHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;AggregatedListAcceleratorTypesPagedResponse&gt; future = acceleratorTypeClient.aggregatedListAcceleratorTypesPagedCallable().futureCall(request);
   *   // Do something
   *   for (AcceleratorTypesScopedList element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          AggregatedListAcceleratorTypesHttpRequest, AggregatedListAcceleratorTypesPagedResponse>
      aggregatedListAcceleratorTypesPagedCallable() {
    return stub.aggregatedListAcceleratorTypesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of accelerator types.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AcceleratorTypeClient acceleratorTypeClient = AcceleratorTypeClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListAcceleratorTypesHttpRequest request = AggregatedListAcceleratorTypesHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   while (true) {
   *     AcceleratorTypeAggregatedList response = acceleratorTypeClient.aggregatedListAcceleratorTypesCallable().call(request);
   *     for (AcceleratorTypesScopedList element : response.getItemsMap()) {
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
  public final UnaryCallable<
          AggregatedListAcceleratorTypesHttpRequest, AcceleratorTypeAggregatedList>
      aggregatedListAcceleratorTypesCallable() {
    return stub.aggregatedListAcceleratorTypesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified accelerator type.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AcceleratorTypeClient acceleratorTypeClient = AcceleratorTypeClient.create()) {
   *   ProjectZoneAcceleratorTypeName acceleratorType = ProjectZoneAcceleratorTypeName.of("[PROJECT]", "[ZONE]", "[ACCELERATOR_TYPE]");
   *   AcceleratorType response = acceleratorTypeClient.getAcceleratorType(acceleratorType);
   * }
   * </code></pre>
   *
   * @param acceleratorType Name of the accelerator type to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AcceleratorType getAcceleratorType(ProjectZoneAcceleratorTypeName acceleratorType) {

    GetAcceleratorTypeHttpRequest request =
        GetAcceleratorTypeHttpRequest.newBuilder()
            .setAcceleratorType(acceleratorType == null ? null : acceleratorType.toString())
            .build();
    return getAcceleratorType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified accelerator type.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AcceleratorTypeClient acceleratorTypeClient = AcceleratorTypeClient.create()) {
   *   ProjectZoneAcceleratorTypeName acceleratorType = ProjectZoneAcceleratorTypeName.of("[PROJECT]", "[ZONE]", "[ACCELERATOR_TYPE]");
   *   AcceleratorType response = acceleratorTypeClient.getAcceleratorType(acceleratorType.toString());
   * }
   * </code></pre>
   *
   * @param acceleratorType Name of the accelerator type to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AcceleratorType getAcceleratorType(String acceleratorType) {

    GetAcceleratorTypeHttpRequest request =
        GetAcceleratorTypeHttpRequest.newBuilder().setAcceleratorType(acceleratorType).build();
    return getAcceleratorType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified accelerator type.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AcceleratorTypeClient acceleratorTypeClient = AcceleratorTypeClient.create()) {
   *   ProjectZoneAcceleratorTypeName acceleratorType = ProjectZoneAcceleratorTypeName.of("[PROJECT]", "[ZONE]", "[ACCELERATOR_TYPE]");
   *   GetAcceleratorTypeHttpRequest request = GetAcceleratorTypeHttpRequest.newBuilder()
   *     .setAcceleratorType(acceleratorType.toString())
   *     .build();
   *   AcceleratorType response = acceleratorTypeClient.getAcceleratorType(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AcceleratorType getAcceleratorType(GetAcceleratorTypeHttpRequest request) {
    return getAcceleratorTypeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified accelerator type.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AcceleratorTypeClient acceleratorTypeClient = AcceleratorTypeClient.create()) {
   *   ProjectZoneAcceleratorTypeName acceleratorType = ProjectZoneAcceleratorTypeName.of("[PROJECT]", "[ZONE]", "[ACCELERATOR_TYPE]");
   *   GetAcceleratorTypeHttpRequest request = GetAcceleratorTypeHttpRequest.newBuilder()
   *     .setAcceleratorType(acceleratorType.toString())
   *     .build();
   *   ApiFuture&lt;AcceleratorType&gt; future = acceleratorTypeClient.getAcceleratorTypeCallable().futureCall(request);
   *   // Do something
   *   AcceleratorType response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetAcceleratorTypeHttpRequest, AcceleratorType>
      getAcceleratorTypeCallable() {
    return stub.getAcceleratorTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of accelerator types available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AcceleratorTypeClient acceleratorTypeClient = AcceleratorTypeClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   for (AcceleratorType element : acceleratorTypeClient.listAcceleratorTypes(zone).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param zone The name of the zone for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListAcceleratorTypesPagedResponse listAcceleratorTypes(ProjectZoneName zone) {
    ListAcceleratorTypesHttpRequest request =
        ListAcceleratorTypesHttpRequest.newBuilder()
            .setZone(zone == null ? null : zone.toString())
            .build();
    return listAcceleratorTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of accelerator types available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AcceleratorTypeClient acceleratorTypeClient = AcceleratorTypeClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   for (AcceleratorType element : acceleratorTypeClient.listAcceleratorTypes(zone.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param zone The name of the zone for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListAcceleratorTypesPagedResponse listAcceleratorTypes(String zone) {
    ListAcceleratorTypesHttpRequest request =
        ListAcceleratorTypesHttpRequest.newBuilder().setZone(zone).build();
    return listAcceleratorTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of accelerator types available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AcceleratorTypeClient acceleratorTypeClient = AcceleratorTypeClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   ListAcceleratorTypesHttpRequest request = ListAcceleratorTypesHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .build();
   *   for (AcceleratorType element : acceleratorTypeClient.listAcceleratorTypes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListAcceleratorTypesPagedResponse listAcceleratorTypes(
      ListAcceleratorTypesHttpRequest request) {
    return listAcceleratorTypesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of accelerator types available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AcceleratorTypeClient acceleratorTypeClient = AcceleratorTypeClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   ListAcceleratorTypesHttpRequest request = ListAcceleratorTypesHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .build();
   *   ApiFuture&lt;ListAcceleratorTypesPagedResponse&gt; future = acceleratorTypeClient.listAcceleratorTypesPagedCallable().futureCall(request);
   *   // Do something
   *   for (AcceleratorType element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListAcceleratorTypesHttpRequest, ListAcceleratorTypesPagedResponse>
      listAcceleratorTypesPagedCallable() {
    return stub.listAcceleratorTypesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of accelerator types available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AcceleratorTypeClient acceleratorTypeClient = AcceleratorTypeClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   ListAcceleratorTypesHttpRequest request = ListAcceleratorTypesHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .build();
   *   while (true) {
   *     AcceleratorTypeList response = acceleratorTypeClient.listAcceleratorTypesCallable().call(request);
   *     for (AcceleratorType element : response.getItemsList()) {
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
  public final UnaryCallable<ListAcceleratorTypesHttpRequest, AcceleratorTypeList>
      listAcceleratorTypesCallable() {
    return stub.listAcceleratorTypesCallable();
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

  public static class AggregatedListAcceleratorTypesPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListAcceleratorTypesHttpRequest,
          AcceleratorTypeAggregatedList,
          AcceleratorTypesScopedList,
          AggregatedListAcceleratorTypesPage,
          AggregatedListAcceleratorTypesFixedSizeCollection> {

    public static ApiFuture<AggregatedListAcceleratorTypesPagedResponse> createAsync(
        PageContext<
                AggregatedListAcceleratorTypesHttpRequest,
                AcceleratorTypeAggregatedList,
                AcceleratorTypesScopedList>
            context,
        ApiFuture<AcceleratorTypeAggregatedList> futureResponse) {
      ApiFuture<AggregatedListAcceleratorTypesPage> futurePage =
          AggregatedListAcceleratorTypesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              AggregatedListAcceleratorTypesPage, AggregatedListAcceleratorTypesPagedResponse>() {
            @Override
            public AggregatedListAcceleratorTypesPagedResponse apply(
                AggregatedListAcceleratorTypesPage input) {
              return new AggregatedListAcceleratorTypesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private AggregatedListAcceleratorTypesPagedResponse(AggregatedListAcceleratorTypesPage page) {
      super(page, AggregatedListAcceleratorTypesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListAcceleratorTypesPage
      extends AbstractPage<
          AggregatedListAcceleratorTypesHttpRequest,
          AcceleratorTypeAggregatedList,
          AcceleratorTypesScopedList,
          AggregatedListAcceleratorTypesPage> {

    private AggregatedListAcceleratorTypesPage(
        PageContext<
                AggregatedListAcceleratorTypesHttpRequest,
                AcceleratorTypeAggregatedList,
                AcceleratorTypesScopedList>
            context,
        AcceleratorTypeAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListAcceleratorTypesPage createEmptyPage() {
      return new AggregatedListAcceleratorTypesPage(null, null);
    }

    @Override
    protected AggregatedListAcceleratorTypesPage createPage(
        PageContext<
                AggregatedListAcceleratorTypesHttpRequest,
                AcceleratorTypeAggregatedList,
                AcceleratorTypesScopedList>
            context,
        AcceleratorTypeAggregatedList response) {
      return new AggregatedListAcceleratorTypesPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListAcceleratorTypesPage> createPageAsync(
        PageContext<
                AggregatedListAcceleratorTypesHttpRequest,
                AcceleratorTypeAggregatedList,
                AcceleratorTypesScopedList>
            context,
        ApiFuture<AcceleratorTypeAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListAcceleratorTypesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListAcceleratorTypesHttpRequest,
          AcceleratorTypeAggregatedList,
          AcceleratorTypesScopedList,
          AggregatedListAcceleratorTypesPage,
          AggregatedListAcceleratorTypesFixedSizeCollection> {

    private AggregatedListAcceleratorTypesFixedSizeCollection(
        List<AggregatedListAcceleratorTypesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListAcceleratorTypesFixedSizeCollection createEmptyCollection() {
      return new AggregatedListAcceleratorTypesFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListAcceleratorTypesFixedSizeCollection createCollection(
        List<AggregatedListAcceleratorTypesPage> pages, int collectionSize) {
      return new AggregatedListAcceleratorTypesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAcceleratorTypesPagedResponse
      extends AbstractPagedListResponse<
          ListAcceleratorTypesHttpRequest,
          AcceleratorTypeList,
          AcceleratorType,
          ListAcceleratorTypesPage,
          ListAcceleratorTypesFixedSizeCollection> {

    public static ApiFuture<ListAcceleratorTypesPagedResponse> createAsync(
        PageContext<ListAcceleratorTypesHttpRequest, AcceleratorTypeList, AcceleratorType> context,
        ApiFuture<AcceleratorTypeList> futureResponse) {
      ApiFuture<ListAcceleratorTypesPage> futurePage =
          ListAcceleratorTypesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListAcceleratorTypesPage, ListAcceleratorTypesPagedResponse>() {
            @Override
            public ListAcceleratorTypesPagedResponse apply(ListAcceleratorTypesPage input) {
              return new ListAcceleratorTypesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListAcceleratorTypesPagedResponse(ListAcceleratorTypesPage page) {
      super(page, ListAcceleratorTypesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAcceleratorTypesPage
      extends AbstractPage<
          ListAcceleratorTypesHttpRequest,
          AcceleratorTypeList,
          AcceleratorType,
          ListAcceleratorTypesPage> {

    private ListAcceleratorTypesPage(
        PageContext<ListAcceleratorTypesHttpRequest, AcceleratorTypeList, AcceleratorType> context,
        AcceleratorTypeList response) {
      super(context, response);
    }

    private static ListAcceleratorTypesPage createEmptyPage() {
      return new ListAcceleratorTypesPage(null, null);
    }

    @Override
    protected ListAcceleratorTypesPage createPage(
        PageContext<ListAcceleratorTypesHttpRequest, AcceleratorTypeList, AcceleratorType> context,
        AcceleratorTypeList response) {
      return new ListAcceleratorTypesPage(context, response);
    }

    @Override
    public ApiFuture<ListAcceleratorTypesPage> createPageAsync(
        PageContext<ListAcceleratorTypesHttpRequest, AcceleratorTypeList, AcceleratorType> context,
        ApiFuture<AcceleratorTypeList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAcceleratorTypesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAcceleratorTypesHttpRequest,
          AcceleratorTypeList,
          AcceleratorType,
          ListAcceleratorTypesPage,
          ListAcceleratorTypesFixedSizeCollection> {

    private ListAcceleratorTypesFixedSizeCollection(
        List<ListAcceleratorTypesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAcceleratorTypesFixedSizeCollection createEmptyCollection() {
      return new ListAcceleratorTypesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAcceleratorTypesFixedSizeCollection createCollection(
        List<ListAcceleratorTypesPage> pages, int collectionSize) {
      return new ListAcceleratorTypesFixedSizeCollection(pages, collectionSize);
    }
  }
}
