/*
 * Copyright 2018 Google LLC
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
import com.google.cloud.compute.v1.stub.RegionOperationStub;
import com.google.cloud.compute.v1.stub.RegionOperationStubSettings;
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
 * try (RegionOperationClient regionOperationClient = RegionOperationClient.create()) {
 *   ProjectRegionOperationName operation = ProjectRegionOperationName.of("[PROJECT]", "[REGION]", "[OPERATION]");
 *   regionOperationClient.deleteRegionOperation(operation);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the regionOperationClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li> A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li> A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li> A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of RegionOperationSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * RegionOperationSettings regionOperationSettings =
 *     RegionOperationSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionOperationClient regionOperationClient =
 *     RegionOperationClient.create(regionOperationSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * RegionOperationSettings regionOperationSettings =
 *     RegionOperationSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionOperationClient regionOperationClient =
 *     RegionOperationClient.create(regionOperationSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionOperationClient implements BackgroundResource {
  private final RegionOperationSettings settings;
  private final RegionOperationStub stub;

  /** Constructs an instance of RegionOperationClient with default settings. */
  public static final RegionOperationClient create() throws IOException {
    return create(RegionOperationSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionOperationClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RegionOperationClient create(RegionOperationSettings settings)
      throws IOException {
    return new RegionOperationClient(settings);
  }

  /**
   * Constructs an instance of RegionOperationClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use RegionOperationSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final RegionOperationClient create(RegionOperationStub stub) {
    return new RegionOperationClient(stub);
  }

  /**
   * Constructs an instance of RegionOperationClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected RegionOperationClient(RegionOperationSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RegionOperationStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected RegionOperationClient(RegionOperationStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionOperationSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RegionOperationStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified region-specific Operations resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionOperationClient regionOperationClient = RegionOperationClient.create()) {
   *   ProjectRegionOperationName operation = ProjectRegionOperationName.of("[PROJECT]", "[REGION]", "[OPERATION]");
   *   regionOperationClient.deleteRegionOperation(operation);
   * }
   * </code></pre>
   *
   * @param operation Name of the Operations resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final void deleteRegionOperation(ProjectRegionOperationName operation) {

    DeleteRegionOperationHttpRequest request =
        DeleteRegionOperationHttpRequest.newBuilder()
            .setOperation(operation == null ? null : operation.toString())
            .build();
    deleteRegionOperation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified region-specific Operations resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionOperationClient regionOperationClient = RegionOperationClient.create()) {
   *   ProjectRegionOperationName operation = ProjectRegionOperationName.of("[PROJECT]", "[REGION]", "[OPERATION]");
   *   regionOperationClient.deleteRegionOperation(operation.toString());
   * }
   * </code></pre>
   *
   * @param operation Name of the Operations resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final void deleteRegionOperation(String operation) {

    DeleteRegionOperationHttpRequest request =
        DeleteRegionOperationHttpRequest.newBuilder().setOperation(operation).build();
    deleteRegionOperation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified region-specific Operations resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionOperationClient regionOperationClient = RegionOperationClient.create()) {
   *   ProjectRegionOperationName operation = ProjectRegionOperationName.of("[PROJECT]", "[REGION]", "[OPERATION]");
   *   DeleteRegionOperationHttpRequest request = DeleteRegionOperationHttpRequest.newBuilder()
   *     .setOperation(operation.toString())
   *     .build();
   *   regionOperationClient.deleteRegionOperation(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final void deleteRegionOperation(DeleteRegionOperationHttpRequest request) {
    deleteRegionOperationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified region-specific Operations resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionOperationClient regionOperationClient = RegionOperationClient.create()) {
   *   ProjectRegionOperationName operation = ProjectRegionOperationName.of("[PROJECT]", "[REGION]", "[OPERATION]");
   *   DeleteRegionOperationHttpRequest request = DeleteRegionOperationHttpRequest.newBuilder()
   *     .setOperation(operation.toString())
   *     .build();
   *   ApiFuture&lt;Void&gt; future = regionOperationClient.deleteRegionOperationCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteRegionOperationHttpRequest, Void>
      deleteRegionOperationCallable() {
    return stub.deleteRegionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the specified region-specific Operations resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionOperationClient regionOperationClient = RegionOperationClient.create()) {
   *   ProjectRegionOperationName operation = ProjectRegionOperationName.of("[PROJECT]", "[REGION]", "[OPERATION]");
   *   Operation response = regionOperationClient.getRegionOperation(operation);
   * }
   * </code></pre>
   *
   * @param operation Name of the Operations resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation getRegionOperation(ProjectRegionOperationName operation) {

    GetRegionOperationHttpRequest request =
        GetRegionOperationHttpRequest.newBuilder()
            .setOperation(operation == null ? null : operation.toString())
            .build();
    return getRegionOperation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the specified region-specific Operations resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionOperationClient regionOperationClient = RegionOperationClient.create()) {
   *   ProjectRegionOperationName operation = ProjectRegionOperationName.of("[PROJECT]", "[REGION]", "[OPERATION]");
   *   Operation response = regionOperationClient.getRegionOperation(operation.toString());
   * }
   * </code></pre>
   *
   * @param operation Name of the Operations resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation getRegionOperation(String operation) {

    GetRegionOperationHttpRequest request =
        GetRegionOperationHttpRequest.newBuilder().setOperation(operation).build();
    return getRegionOperation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the specified region-specific Operations resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionOperationClient regionOperationClient = RegionOperationClient.create()) {
   *   ProjectRegionOperationName operation = ProjectRegionOperationName.of("[PROJECT]", "[REGION]", "[OPERATION]");
   *   GetRegionOperationHttpRequest request = GetRegionOperationHttpRequest.newBuilder()
   *     .setOperation(operation.toString())
   *     .build();
   *   Operation response = regionOperationClient.getRegionOperation(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation getRegionOperation(GetRegionOperationHttpRequest request) {
    return getRegionOperationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the specified region-specific Operations resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionOperationClient regionOperationClient = RegionOperationClient.create()) {
   *   ProjectRegionOperationName operation = ProjectRegionOperationName.of("[PROJECT]", "[REGION]", "[OPERATION]");
   *   GetRegionOperationHttpRequest request = GetRegionOperationHttpRequest.newBuilder()
   *     .setOperation(operation.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionOperationClient.getRegionOperationCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetRegionOperationHttpRequest, Operation>
      getRegionOperationCallable() {
    return stub.getRegionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of Operation resources contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionOperationClient regionOperationClient = RegionOperationClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (Operation element : regionOperationClient.listRegionOperations(region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionOperationsPagedResponse listRegionOperations(ProjectRegionName region) {
    ListRegionOperationsHttpRequest request =
        ListRegionOperationsHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .build();
    return listRegionOperations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of Operation resources contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionOperationClient regionOperationClient = RegionOperationClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (Operation element : regionOperationClient.listRegionOperations(region.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionOperationsPagedResponse listRegionOperations(String region) {
    ListRegionOperationsHttpRequest request =
        ListRegionOperationsHttpRequest.newBuilder().setRegion(region).build();
    return listRegionOperations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of Operation resources contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionOperationClient regionOperationClient = RegionOperationClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListRegionOperationsHttpRequest request = ListRegionOperationsHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   for (Operation element : regionOperationClient.listRegionOperations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionOperationsPagedResponse listRegionOperations(
      ListRegionOperationsHttpRequest request) {
    return listRegionOperationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of Operation resources contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionOperationClient regionOperationClient = RegionOperationClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListRegionOperationsHttpRequest request = ListRegionOperationsHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   ApiFuture&lt;ListRegionOperationsPagedResponse&gt; future = regionOperationClient.listRegionOperationsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Operation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListRegionOperationsHttpRequest, ListRegionOperationsPagedResponse>
      listRegionOperationsPagedCallable() {
    return stub.listRegionOperationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of Operation resources contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionOperationClient regionOperationClient = RegionOperationClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListRegionOperationsHttpRequest request = ListRegionOperationsHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   while (true) {
   *     OperationList response = regionOperationClient.listRegionOperationsCallable().call(request);
   *     for (Operation element : response.getItemsList()) {
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
  public final UnaryCallable<ListRegionOperationsHttpRequest, OperationList>
      listRegionOperationsCallable() {
    return stub.listRegionOperationsCallable();
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

  public static class ListRegionOperationsPagedResponse
      extends AbstractPagedListResponse<
          ListRegionOperationsHttpRequest, OperationList, Operation, ListRegionOperationsPage,
          ListRegionOperationsFixedSizeCollection> {

    public static ApiFuture<ListRegionOperationsPagedResponse> createAsync(
        PageContext<ListRegionOperationsHttpRequest, OperationList, Operation> context,
        ApiFuture<OperationList> futureResponse) {
      ApiFuture<ListRegionOperationsPage> futurePage =
          ListRegionOperationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListRegionOperationsPage, ListRegionOperationsPagedResponse>() {
            @Override
            public ListRegionOperationsPagedResponse apply(ListRegionOperationsPage input) {
              return new ListRegionOperationsPagedResponse(input);
            }
          });
    }

    private ListRegionOperationsPagedResponse(ListRegionOperationsPage page) {
      super(page, ListRegionOperationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRegionOperationsPage
      extends AbstractPage<
          ListRegionOperationsHttpRequest, OperationList, Operation, ListRegionOperationsPage> {

    private ListRegionOperationsPage(
        PageContext<ListRegionOperationsHttpRequest, OperationList, Operation> context,
        OperationList response) {
      super(context, response);
    }

    private static ListRegionOperationsPage createEmptyPage() {
      return new ListRegionOperationsPage(null, null);
    }

    @Override
    protected ListRegionOperationsPage createPage(
        PageContext<ListRegionOperationsHttpRequest, OperationList, Operation> context,
        OperationList response) {
      return new ListRegionOperationsPage(context, response);
    }

    @Override
    public ApiFuture<ListRegionOperationsPage> createPageAsync(
        PageContext<ListRegionOperationsHttpRequest, OperationList, Operation> context,
        ApiFuture<OperationList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRegionOperationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionOperationsHttpRequest, OperationList, Operation, ListRegionOperationsPage,
          ListRegionOperationsFixedSizeCollection> {

    private ListRegionOperationsFixedSizeCollection(
        List<ListRegionOperationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRegionOperationsFixedSizeCollection createEmptyCollection() {
      return new ListRegionOperationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRegionOperationsFixedSizeCollection createCollection(
        List<ListRegionOperationsPage> pages, int collectionSize) {
      return new ListRegionOperationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
