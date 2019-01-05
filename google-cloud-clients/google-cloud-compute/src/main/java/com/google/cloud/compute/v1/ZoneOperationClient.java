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
import com.google.cloud.compute.v1.stub.ZoneOperationStub;
import com.google.cloud.compute.v1.stub.ZoneOperationStubSettings;
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
 * try (ZoneOperationClient zoneOperationClient = ZoneOperationClient.create()) {
 *   ProjectZoneOperationName operation = ProjectZoneOperationName.of("[PROJECT]", "[ZONE]", "[OPERATION]");
 *   zoneOperationClient.deleteZoneOperation(operation);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the zoneOperationClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of ZoneOperationSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * ZoneOperationSettings zoneOperationSettings =
 *     ZoneOperationSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ZoneOperationClient zoneOperationClient =
 *     ZoneOperationClient.create(zoneOperationSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * ZoneOperationSettings zoneOperationSettings =
 *     ZoneOperationSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ZoneOperationClient zoneOperationClient =
 *     ZoneOperationClient.create(zoneOperationSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ZoneOperationClient implements BackgroundResource {
  private final ZoneOperationSettings settings;
  private final ZoneOperationStub stub;

  /** Constructs an instance of ZoneOperationClient with default settings. */
  public static final ZoneOperationClient create() throws IOException {
    return create(ZoneOperationSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ZoneOperationClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ZoneOperationClient create(ZoneOperationSettings settings)
      throws IOException {
    return new ZoneOperationClient(settings);
  }

  /**
   * Constructs an instance of ZoneOperationClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use ZoneOperationSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final ZoneOperationClient create(ZoneOperationStub stub) {
    return new ZoneOperationClient(stub);
  }

  /**
   * Constructs an instance of ZoneOperationClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ZoneOperationClient(ZoneOperationSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ZoneOperationStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected ZoneOperationClient(ZoneOperationStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ZoneOperationSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ZoneOperationStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified zone-specific Operations resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ZoneOperationClient zoneOperationClient = ZoneOperationClient.create()) {
   *   ProjectZoneOperationName operation = ProjectZoneOperationName.of("[PROJECT]", "[ZONE]", "[OPERATION]");
   *   zoneOperationClient.deleteZoneOperation(operation);
   * }
   * </code></pre>
   *
   * @param operation Name of the Operations resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final void deleteZoneOperation(ProjectZoneOperationName operation) {

    DeleteZoneOperationHttpRequest request =
        DeleteZoneOperationHttpRequest.newBuilder()
            .setOperation(operation == null ? null : operation.toString())
            .build();
    deleteZoneOperation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified zone-specific Operations resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ZoneOperationClient zoneOperationClient = ZoneOperationClient.create()) {
   *   ProjectZoneOperationName operation = ProjectZoneOperationName.of("[PROJECT]", "[ZONE]", "[OPERATION]");
   *   zoneOperationClient.deleteZoneOperation(operation.toString());
   * }
   * </code></pre>
   *
   * @param operation Name of the Operations resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final void deleteZoneOperation(String operation) {

    DeleteZoneOperationHttpRequest request =
        DeleteZoneOperationHttpRequest.newBuilder().setOperation(operation).build();
    deleteZoneOperation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified zone-specific Operations resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ZoneOperationClient zoneOperationClient = ZoneOperationClient.create()) {
   *   ProjectZoneOperationName operation = ProjectZoneOperationName.of("[PROJECT]", "[ZONE]", "[OPERATION]");
   *   DeleteZoneOperationHttpRequest request = DeleteZoneOperationHttpRequest.newBuilder()
   *     .setOperation(operation.toString())
   *     .build();
   *   zoneOperationClient.deleteZoneOperation(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final void deleteZoneOperation(DeleteZoneOperationHttpRequest request) {
    deleteZoneOperationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified zone-specific Operations resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ZoneOperationClient zoneOperationClient = ZoneOperationClient.create()) {
   *   ProjectZoneOperationName operation = ProjectZoneOperationName.of("[PROJECT]", "[ZONE]", "[OPERATION]");
   *   DeleteZoneOperationHttpRequest request = DeleteZoneOperationHttpRequest.newBuilder()
   *     .setOperation(operation.toString())
   *     .build();
   *   ApiFuture&lt;Void&gt; future = zoneOperationClient.deleteZoneOperationCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteZoneOperationHttpRequest, Void> deleteZoneOperationCallable() {
    return stub.deleteZoneOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the specified zone-specific Operations resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ZoneOperationClient zoneOperationClient = ZoneOperationClient.create()) {
   *   ProjectZoneOperationName operation = ProjectZoneOperationName.of("[PROJECT]", "[ZONE]", "[OPERATION]");
   *   Operation response = zoneOperationClient.getZoneOperation(operation);
   * }
   * </code></pre>
   *
   * @param operation Name of the Operations resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation getZoneOperation(ProjectZoneOperationName operation) {

    GetZoneOperationHttpRequest request =
        GetZoneOperationHttpRequest.newBuilder()
            .setOperation(operation == null ? null : operation.toString())
            .build();
    return getZoneOperation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the specified zone-specific Operations resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ZoneOperationClient zoneOperationClient = ZoneOperationClient.create()) {
   *   ProjectZoneOperationName operation = ProjectZoneOperationName.of("[PROJECT]", "[ZONE]", "[OPERATION]");
   *   Operation response = zoneOperationClient.getZoneOperation(operation.toString());
   * }
   * </code></pre>
   *
   * @param operation Name of the Operations resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation getZoneOperation(String operation) {

    GetZoneOperationHttpRequest request =
        GetZoneOperationHttpRequest.newBuilder().setOperation(operation).build();
    return getZoneOperation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the specified zone-specific Operations resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ZoneOperationClient zoneOperationClient = ZoneOperationClient.create()) {
   *   ProjectZoneOperationName operation = ProjectZoneOperationName.of("[PROJECT]", "[ZONE]", "[OPERATION]");
   *   GetZoneOperationHttpRequest request = GetZoneOperationHttpRequest.newBuilder()
   *     .setOperation(operation.toString())
   *     .build();
   *   Operation response = zoneOperationClient.getZoneOperation(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation getZoneOperation(GetZoneOperationHttpRequest request) {
    return getZoneOperationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the specified zone-specific Operations resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ZoneOperationClient zoneOperationClient = ZoneOperationClient.create()) {
   *   ProjectZoneOperationName operation = ProjectZoneOperationName.of("[PROJECT]", "[ZONE]", "[OPERATION]");
   *   GetZoneOperationHttpRequest request = GetZoneOperationHttpRequest.newBuilder()
   *     .setOperation(operation.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = zoneOperationClient.getZoneOperationCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetZoneOperationHttpRequest, Operation> getZoneOperationCallable() {
    return stub.getZoneOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of Operation resources contained within the specified zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ZoneOperationClient zoneOperationClient = ZoneOperationClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   for (Operation element : zoneOperationClient.listZoneOperations(zone).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param zone Name of the zone for request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListZoneOperationsPagedResponse listZoneOperations(ProjectZoneName zone) {
    ListZoneOperationsHttpRequest request =
        ListZoneOperationsHttpRequest.newBuilder()
            .setZone(zone == null ? null : zone.toString())
            .build();
    return listZoneOperations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of Operation resources contained within the specified zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ZoneOperationClient zoneOperationClient = ZoneOperationClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   for (Operation element : zoneOperationClient.listZoneOperations(zone.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param zone Name of the zone for request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListZoneOperationsPagedResponse listZoneOperations(String zone) {
    ListZoneOperationsHttpRequest request =
        ListZoneOperationsHttpRequest.newBuilder().setZone(zone).build();
    return listZoneOperations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of Operation resources contained within the specified zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ZoneOperationClient zoneOperationClient = ZoneOperationClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   ListZoneOperationsHttpRequest request = ListZoneOperationsHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .build();
   *   for (Operation element : zoneOperationClient.listZoneOperations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListZoneOperationsPagedResponse listZoneOperations(
      ListZoneOperationsHttpRequest request) {
    return listZoneOperationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of Operation resources contained within the specified zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ZoneOperationClient zoneOperationClient = ZoneOperationClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   ListZoneOperationsHttpRequest request = ListZoneOperationsHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .build();
   *   ApiFuture&lt;ListZoneOperationsPagedResponse&gt; future = zoneOperationClient.listZoneOperationsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Operation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListZoneOperationsHttpRequest, ListZoneOperationsPagedResponse>
      listZoneOperationsPagedCallable() {
    return stub.listZoneOperationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of Operation resources contained within the specified zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ZoneOperationClient zoneOperationClient = ZoneOperationClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   ListZoneOperationsHttpRequest request = ListZoneOperationsHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .build();
   *   while (true) {
   *     OperationList response = zoneOperationClient.listZoneOperationsCallable().call(request);
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
  public final UnaryCallable<ListZoneOperationsHttpRequest, OperationList>
      listZoneOperationsCallable() {
    return stub.listZoneOperationsCallable();
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

  public static class ListZoneOperationsPagedResponse
      extends AbstractPagedListResponse<
          ListZoneOperationsHttpRequest,
          OperationList,
          Operation,
          ListZoneOperationsPage,
          ListZoneOperationsFixedSizeCollection> {

    public static ApiFuture<ListZoneOperationsPagedResponse> createAsync(
        PageContext<ListZoneOperationsHttpRequest, OperationList, Operation> context,
        ApiFuture<OperationList> futureResponse) {
      ApiFuture<ListZoneOperationsPage> futurePage =
          ListZoneOperationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListZoneOperationsPage, ListZoneOperationsPagedResponse>() {
            @Override
            public ListZoneOperationsPagedResponse apply(ListZoneOperationsPage input) {
              return new ListZoneOperationsPagedResponse(input);
            }
          });
    }

    private ListZoneOperationsPagedResponse(ListZoneOperationsPage page) {
      super(page, ListZoneOperationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListZoneOperationsPage
      extends AbstractPage<
          ListZoneOperationsHttpRequest, OperationList, Operation, ListZoneOperationsPage> {

    private ListZoneOperationsPage(
        PageContext<ListZoneOperationsHttpRequest, OperationList, Operation> context,
        OperationList response) {
      super(context, response);
    }

    private static ListZoneOperationsPage createEmptyPage() {
      return new ListZoneOperationsPage(null, null);
    }

    @Override
    protected ListZoneOperationsPage createPage(
        PageContext<ListZoneOperationsHttpRequest, OperationList, Operation> context,
        OperationList response) {
      return new ListZoneOperationsPage(context, response);
    }

    @Override
    public ApiFuture<ListZoneOperationsPage> createPageAsync(
        PageContext<ListZoneOperationsHttpRequest, OperationList, Operation> context,
        ApiFuture<OperationList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListZoneOperationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListZoneOperationsHttpRequest,
          OperationList,
          Operation,
          ListZoneOperationsPage,
          ListZoneOperationsFixedSizeCollection> {

    private ListZoneOperationsFixedSizeCollection(
        List<ListZoneOperationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListZoneOperationsFixedSizeCollection createEmptyCollection() {
      return new ListZoneOperationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListZoneOperationsFixedSizeCollection createCollection(
        List<ListZoneOperationsPage> pages, int collectionSize) {
      return new ListZoneOperationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
