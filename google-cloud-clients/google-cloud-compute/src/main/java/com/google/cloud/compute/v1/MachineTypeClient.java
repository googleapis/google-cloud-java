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
import com.google.cloud.compute.v1.stub.MachineTypeStub;
import com.google.cloud.compute.v1.stub.MachineTypeStubSettings;
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
 * try (MachineTypeClient machineTypeClient = MachineTypeClient.create()) {
 *   ProjectZoneMachineTypeName machineType = ProjectZoneMachineTypeName.of("[PROJECT]", "[ZONE]", "[MACHINE_TYPE]");
 *   MachineType response = machineTypeClient.getMachineType(machineType);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the machineTypeClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of MachineTypeSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * MachineTypeSettings machineTypeSettings =
 *     MachineTypeSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * MachineTypeClient machineTypeClient =
 *     MachineTypeClient.create(machineTypeSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * MachineTypeSettings machineTypeSettings =
 *     MachineTypeSettings.newBuilder().setEndpoint(myEndpoint).build();
 * MachineTypeClient machineTypeClient =
 *     MachineTypeClient.create(machineTypeSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class MachineTypeClient implements BackgroundResource {
  private final MachineTypeSettings settings;
  private final MachineTypeStub stub;

  /** Constructs an instance of MachineTypeClient with default settings. */
  public static final MachineTypeClient create() throws IOException {
    return create(MachineTypeSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of MachineTypeClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final MachineTypeClient create(MachineTypeSettings settings) throws IOException {
    return new MachineTypeClient(settings);
  }

  /**
   * Constructs an instance of MachineTypeClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use MachineTypeSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final MachineTypeClient create(MachineTypeStub stub) {
    return new MachineTypeClient(stub);
  }

  /**
   * Constructs an instance of MachineTypeClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected MachineTypeClient(MachineTypeSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((MachineTypeStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected MachineTypeClient(MachineTypeStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final MachineTypeSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public MachineTypeStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of machine types.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MachineTypeClient machineTypeClient = MachineTypeClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (MachineTypesScopedList element : machineTypeClient.aggregatedListMachineTypes(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListMachineTypesPagedResponse aggregatedListMachineTypes(
      ProjectName project) {
    AggregatedListMachineTypesHttpRequest request =
        AggregatedListMachineTypesHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return aggregatedListMachineTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of machine types.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MachineTypeClient machineTypeClient = MachineTypeClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (MachineTypesScopedList element : machineTypeClient.aggregatedListMachineTypes(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListMachineTypesPagedResponse aggregatedListMachineTypes(String project) {
    AggregatedListMachineTypesHttpRequest request =
        AggregatedListMachineTypesHttpRequest.newBuilder().setProject(project).build();
    return aggregatedListMachineTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of machine types.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MachineTypeClient machineTypeClient = MachineTypeClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListMachineTypesHttpRequest request = AggregatedListMachineTypesHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   for (MachineTypesScopedList element : machineTypeClient.aggregatedListMachineTypes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListMachineTypesPagedResponse aggregatedListMachineTypes(
      AggregatedListMachineTypesHttpRequest request) {
    return aggregatedListMachineTypesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of machine types.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MachineTypeClient machineTypeClient = MachineTypeClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListMachineTypesHttpRequest request = AggregatedListMachineTypesHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;AggregatedListMachineTypesPagedResponse&gt; future = machineTypeClient.aggregatedListMachineTypesPagedCallable().futureCall(request);
   *   // Do something
   *   for (MachineTypesScopedList element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          AggregatedListMachineTypesHttpRequest, AggregatedListMachineTypesPagedResponse>
      aggregatedListMachineTypesPagedCallable() {
    return stub.aggregatedListMachineTypesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of machine types.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MachineTypeClient machineTypeClient = MachineTypeClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListMachineTypesHttpRequest request = AggregatedListMachineTypesHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   while (true) {
   *     MachineTypeAggregatedList response = machineTypeClient.aggregatedListMachineTypesCallable().call(request);
   *     for (MachineTypesScopedList element : response.getItemsMap()) {
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
  public final UnaryCallable<AggregatedListMachineTypesHttpRequest, MachineTypeAggregatedList>
      aggregatedListMachineTypesCallable() {
    return stub.aggregatedListMachineTypesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified machine type. Gets a list of available machine types by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MachineTypeClient machineTypeClient = MachineTypeClient.create()) {
   *   ProjectZoneMachineTypeName machineType = ProjectZoneMachineTypeName.of("[PROJECT]", "[ZONE]", "[MACHINE_TYPE]");
   *   MachineType response = machineTypeClient.getMachineType(machineType);
   * }
   * </code></pre>
   *
   * @param machineType Name of the machine type to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final MachineType getMachineType(ProjectZoneMachineTypeName machineType) {

    GetMachineTypeHttpRequest request =
        GetMachineTypeHttpRequest.newBuilder()
            .setMachineType(machineType == null ? null : machineType.toString())
            .build();
    return getMachineType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified machine type. Gets a list of available machine types by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MachineTypeClient machineTypeClient = MachineTypeClient.create()) {
   *   ProjectZoneMachineTypeName machineType = ProjectZoneMachineTypeName.of("[PROJECT]", "[ZONE]", "[MACHINE_TYPE]");
   *   MachineType response = machineTypeClient.getMachineType(machineType.toString());
   * }
   * </code></pre>
   *
   * @param machineType Name of the machine type to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final MachineType getMachineType(String machineType) {

    GetMachineTypeHttpRequest request =
        GetMachineTypeHttpRequest.newBuilder().setMachineType(machineType).build();
    return getMachineType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified machine type. Gets a list of available machine types by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MachineTypeClient machineTypeClient = MachineTypeClient.create()) {
   *   ProjectZoneMachineTypeName machineType = ProjectZoneMachineTypeName.of("[PROJECT]", "[ZONE]", "[MACHINE_TYPE]");
   *   GetMachineTypeHttpRequest request = GetMachineTypeHttpRequest.newBuilder()
   *     .setMachineType(machineType.toString())
   *     .build();
   *   MachineType response = machineTypeClient.getMachineType(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final MachineType getMachineType(GetMachineTypeHttpRequest request) {
    return getMachineTypeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified machine type. Gets a list of available machine types by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MachineTypeClient machineTypeClient = MachineTypeClient.create()) {
   *   ProjectZoneMachineTypeName machineType = ProjectZoneMachineTypeName.of("[PROJECT]", "[ZONE]", "[MACHINE_TYPE]");
   *   GetMachineTypeHttpRequest request = GetMachineTypeHttpRequest.newBuilder()
   *     .setMachineType(machineType.toString())
   *     .build();
   *   ApiFuture&lt;MachineType&gt; future = machineTypeClient.getMachineTypeCallable().futureCall(request);
   *   // Do something
   *   MachineType response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetMachineTypeHttpRequest, MachineType> getMachineTypeCallable() {
    return stub.getMachineTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of machine types available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MachineTypeClient machineTypeClient = MachineTypeClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   for (MachineType element : machineTypeClient.listMachineTypes(zone).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param zone The name of the zone for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListMachineTypesPagedResponse listMachineTypes(ProjectZoneName zone) {
    ListMachineTypesHttpRequest request =
        ListMachineTypesHttpRequest.newBuilder()
            .setZone(zone == null ? null : zone.toString())
            .build();
    return listMachineTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of machine types available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MachineTypeClient machineTypeClient = MachineTypeClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   for (MachineType element : machineTypeClient.listMachineTypes(zone.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param zone The name of the zone for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListMachineTypesPagedResponse listMachineTypes(String zone) {
    ListMachineTypesHttpRequest request =
        ListMachineTypesHttpRequest.newBuilder().setZone(zone).build();
    return listMachineTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of machine types available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MachineTypeClient machineTypeClient = MachineTypeClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   ListMachineTypesHttpRequest request = ListMachineTypesHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .build();
   *   for (MachineType element : machineTypeClient.listMachineTypes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListMachineTypesPagedResponse listMachineTypes(ListMachineTypesHttpRequest request) {
    return listMachineTypesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of machine types available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MachineTypeClient machineTypeClient = MachineTypeClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   ListMachineTypesHttpRequest request = ListMachineTypesHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .build();
   *   ApiFuture&lt;ListMachineTypesPagedResponse&gt; future = machineTypeClient.listMachineTypesPagedCallable().futureCall(request);
   *   // Do something
   *   for (MachineType element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListMachineTypesHttpRequest, ListMachineTypesPagedResponse>
      listMachineTypesPagedCallable() {
    return stub.listMachineTypesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of machine types available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MachineTypeClient machineTypeClient = MachineTypeClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   ListMachineTypesHttpRequest request = ListMachineTypesHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .build();
   *   while (true) {
   *     MachineTypeList response = machineTypeClient.listMachineTypesCallable().call(request);
   *     for (MachineType element : response.getItemsList()) {
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
  public final UnaryCallable<ListMachineTypesHttpRequest, MachineTypeList>
      listMachineTypesCallable() {
    return stub.listMachineTypesCallable();
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

  public static class AggregatedListMachineTypesPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListMachineTypesHttpRequest,
          MachineTypeAggregatedList,
          MachineTypesScopedList,
          AggregatedListMachineTypesPage,
          AggregatedListMachineTypesFixedSizeCollection> {

    public static ApiFuture<AggregatedListMachineTypesPagedResponse> createAsync(
        PageContext<
                AggregatedListMachineTypesHttpRequest,
                MachineTypeAggregatedList,
                MachineTypesScopedList>
            context,
        ApiFuture<MachineTypeAggregatedList> futureResponse) {
      ApiFuture<AggregatedListMachineTypesPage> futurePage =
          AggregatedListMachineTypesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              AggregatedListMachineTypesPage, AggregatedListMachineTypesPagedResponse>() {
            @Override
            public AggregatedListMachineTypesPagedResponse apply(
                AggregatedListMachineTypesPage input) {
              return new AggregatedListMachineTypesPagedResponse(input);
            }
          });
    }

    private AggregatedListMachineTypesPagedResponse(AggregatedListMachineTypesPage page) {
      super(page, AggregatedListMachineTypesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListMachineTypesPage
      extends AbstractPage<
          AggregatedListMachineTypesHttpRequest,
          MachineTypeAggregatedList,
          MachineTypesScopedList,
          AggregatedListMachineTypesPage> {

    private AggregatedListMachineTypesPage(
        PageContext<
                AggregatedListMachineTypesHttpRequest,
                MachineTypeAggregatedList,
                MachineTypesScopedList>
            context,
        MachineTypeAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListMachineTypesPage createEmptyPage() {
      return new AggregatedListMachineTypesPage(null, null);
    }

    @Override
    protected AggregatedListMachineTypesPage createPage(
        PageContext<
                AggregatedListMachineTypesHttpRequest,
                MachineTypeAggregatedList,
                MachineTypesScopedList>
            context,
        MachineTypeAggregatedList response) {
      return new AggregatedListMachineTypesPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListMachineTypesPage> createPageAsync(
        PageContext<
                AggregatedListMachineTypesHttpRequest,
                MachineTypeAggregatedList,
                MachineTypesScopedList>
            context,
        ApiFuture<MachineTypeAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListMachineTypesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListMachineTypesHttpRequest,
          MachineTypeAggregatedList,
          MachineTypesScopedList,
          AggregatedListMachineTypesPage,
          AggregatedListMachineTypesFixedSizeCollection> {

    private AggregatedListMachineTypesFixedSizeCollection(
        List<AggregatedListMachineTypesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListMachineTypesFixedSizeCollection createEmptyCollection() {
      return new AggregatedListMachineTypesFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListMachineTypesFixedSizeCollection createCollection(
        List<AggregatedListMachineTypesPage> pages, int collectionSize) {
      return new AggregatedListMachineTypesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListMachineTypesPagedResponse
      extends AbstractPagedListResponse<
          ListMachineTypesHttpRequest,
          MachineTypeList,
          MachineType,
          ListMachineTypesPage,
          ListMachineTypesFixedSizeCollection> {

    public static ApiFuture<ListMachineTypesPagedResponse> createAsync(
        PageContext<ListMachineTypesHttpRequest, MachineTypeList, MachineType> context,
        ApiFuture<MachineTypeList> futureResponse) {
      ApiFuture<ListMachineTypesPage> futurePage =
          ListMachineTypesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListMachineTypesPage, ListMachineTypesPagedResponse>() {
            @Override
            public ListMachineTypesPagedResponse apply(ListMachineTypesPage input) {
              return new ListMachineTypesPagedResponse(input);
            }
          });
    }

    private ListMachineTypesPagedResponse(ListMachineTypesPage page) {
      super(page, ListMachineTypesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMachineTypesPage
      extends AbstractPage<
          ListMachineTypesHttpRequest, MachineTypeList, MachineType, ListMachineTypesPage> {

    private ListMachineTypesPage(
        PageContext<ListMachineTypesHttpRequest, MachineTypeList, MachineType> context,
        MachineTypeList response) {
      super(context, response);
    }

    private static ListMachineTypesPage createEmptyPage() {
      return new ListMachineTypesPage(null, null);
    }

    @Override
    protected ListMachineTypesPage createPage(
        PageContext<ListMachineTypesHttpRequest, MachineTypeList, MachineType> context,
        MachineTypeList response) {
      return new ListMachineTypesPage(context, response);
    }

    @Override
    public ApiFuture<ListMachineTypesPage> createPageAsync(
        PageContext<ListMachineTypesHttpRequest, MachineTypeList, MachineType> context,
        ApiFuture<MachineTypeList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMachineTypesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMachineTypesHttpRequest,
          MachineTypeList,
          MachineType,
          ListMachineTypesPage,
          ListMachineTypesFixedSizeCollection> {

    private ListMachineTypesFixedSizeCollection(
        List<ListMachineTypesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMachineTypesFixedSizeCollection createEmptyCollection() {
      return new ListMachineTypesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMachineTypesFixedSizeCollection createCollection(
        List<ListMachineTypesPage> pages, int collectionSize) {
      return new ListMachineTypesFixedSizeCollection(pages, collectionSize);
    }
  }
}
