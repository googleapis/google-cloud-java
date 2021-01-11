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
import com.google.cloud.compute.v1.stub.AddressesStub;
import com.google.cloud.compute.v1.stub.AddressesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The Addresses API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (AddressesClient addressesClient = AddressesClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String address = "";
 *   Operation response = addressesClient.delete(project, region, address);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the addressesClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of AddressesSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * AddressesSettings addressesSettings =
 *     AddressesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AddressesClient addressesClient =
 *     AddressesClient.create(addressesSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * AddressesSettings addressesSettings =
 *     AddressesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AddressesClient addressesClient =
 *     AddressesClient.create(addressesSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class AddressesClient implements BackgroundResource {
  private final AddressesSettings settings;
  private final AddressesStub stub;

  /** Constructs an instance of AddressesClient with default settings. */
  public static final AddressesClient create() throws IOException {
    return create(AddressesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AddressesClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AddressesClient create(AddressesSettings settings) throws IOException {
    return new AddressesClient(settings);
  }

  /**
   * Constructs an instance of AddressesClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use AddressesSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final AddressesClient create(AddressesStub stub) {
    return new AddressesClient(stub);
  }

  /**
   * Constructs an instance of AddressesClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected AddressesClient(AddressesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AddressesStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected AddressesClient(AddressesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AddressesSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public AddressesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of addresses.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AddressesClient addressesClient = AddressesClient.create()) {
   *   String project = "";
   *   for (Entry&lt;String, AddressesScopedList&gt; element : addressesClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListAddressesRequest request =
        AggregatedListAddressesRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of addresses.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AddressesClient addressesClient = AddressesClient.create()) {
   *   String project = "";
   *   AggregatedListAddressesRequest request = AggregatedListAddressesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (Entry&lt;String, AddressesScopedList&gt; element : addressesClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(AggregatedListAddressesRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of addresses.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AddressesClient addressesClient = AddressesClient.create()) {
   *   String project = "";
   *   AggregatedListAddressesRequest request = AggregatedListAddressesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;AggregatedListPagedResponse&gt; future = addressesClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something
   *   for (Entry&lt;String, AddressesScopedList&gt; element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<AggregatedListAddressesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of addresses.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AddressesClient addressesClient = AddressesClient.create()) {
   *   String project = "";
   *   AggregatedListAddressesRequest request = AggregatedListAddressesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     AddressAggregatedList response = addressesClient.aggregatedListCallable().call(request);
   *     for (Entry&lt;String, AddressesScopedList&gt; element : response.getItemsMap()) {
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
  public final UnaryCallable<AggregatedListAddressesRequest, AddressAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified address resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AddressesClient addressesClient = AddressesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String address = "";
   *   Operation response = addressesClient.delete(project, region, address);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param address Name of the address resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String region, String address) {
    DeleteAddressRequest request =
        DeleteAddressRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setAddress(address)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified address resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AddressesClient addressesClient = AddressesClient.create()) {
   *   String address = "";
   *   String project = "";
   *   String region = "";
   *   DeleteAddressRequest request = DeleteAddressRequest.newBuilder()
   *     .setAddress(address)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   Operation response = addressesClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteAddressRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified address resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AddressesClient addressesClient = AddressesClient.create()) {
   *   String address = "";
   *   String project = "";
   *   String region = "";
   *   DeleteAddressRequest request = DeleteAddressRequest.newBuilder()
   *     .setAddress(address)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = addressesClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteAddressRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified address resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AddressesClient addressesClient = AddressesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String address = "";
   *   Address response = addressesClient.get(project, region, address);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param address Name of the address resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Address get(String project, String region, String address) {
    GetAddressRequest request =
        GetAddressRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setAddress(address)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified address resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AddressesClient addressesClient = AddressesClient.create()) {
   *   String address = "";
   *   String project = "";
   *   String region = "";
   *   GetAddressRequest request = GetAddressRequest.newBuilder()
   *     .setAddress(address)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   Address response = addressesClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Address get(GetAddressRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified address resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AddressesClient addressesClient = AddressesClient.create()) {
   *   String address = "";
   *   String project = "";
   *   String region = "";
   *   GetAddressRequest request = GetAddressRequest.newBuilder()
   *     .setAddress(address)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;Address&gt; future = addressesClient.getCallable().futureCall(request);
   *   // Do something
   *   Address response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetAddressRequest, Address> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an address resource in the specified project by using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AddressesClient addressesClient = AddressesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   Address addressResource = Address.newBuilder().build();
   *   Operation response = addressesClient.insert(project, region, addressResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param addressResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(String project, String region, Address addressResource) {
    InsertAddressRequest request =
        InsertAddressRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setAddressResource(addressResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an address resource in the specified project by using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AddressesClient addressesClient = AddressesClient.create()) {
   *   Address addressResource = Address.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   InsertAddressRequest request = InsertAddressRequest.newBuilder()
   *     .setAddressResource(addressResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   Operation response = addressesClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertAddressRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an address resource in the specified project by using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AddressesClient addressesClient = AddressesClient.create()) {
   *   Address addressResource = Address.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   InsertAddressRequest request = InsertAddressRequest.newBuilder()
   *     .setAddressResource(addressResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = addressesClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertAddressRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of addresses contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AddressesClient addressesClient = AddressesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   for (Address element : addressesClient.list(project, region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String region) {
    ListAddressesRequest request =
        ListAddressesRequest.newBuilder().setProject(project).setRegion(region).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of addresses contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AddressesClient addressesClient = AddressesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListAddressesRequest request = ListAddressesRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   for (Address element : addressesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListAddressesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of addresses contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AddressesClient addressesClient = AddressesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListAddressesRequest request = ListAddressesRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = addressesClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (Address element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListAddressesRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of addresses contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AddressesClient addressesClient = AddressesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListAddressesRequest request = ListAddressesRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   while (true) {
   *     AddressList response = addressesClient.listCallable().call(request);
   *     for (Address element : response.getItemsList()) {
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
  public final UnaryCallable<ListAddressesRequest, AddressList> listCallable() {
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
          AggregatedListAddressesRequest,
          AddressAggregatedList,
          Entry<String, AddressesScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListAddressesRequest,
                AddressAggregatedList,
                Entry<String, AddressesScopedList>>
            context,
        ApiFuture<AddressAggregatedList> futureResponse) {
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
          AggregatedListAddressesRequest,
          AddressAggregatedList,
          Entry<String, AddressesScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListAddressesRequest,
                AddressAggregatedList,
                Entry<String, AddressesScopedList>>
            context,
        AddressAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListAddressesRequest,
                AddressAggregatedList,
                Entry<String, AddressesScopedList>>
            context,
        AddressAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListAddressesRequest,
                AddressAggregatedList,
                Entry<String, AddressesScopedList>>
            context,
        ApiFuture<AddressAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListAddressesRequest,
          AddressAggregatedList,
          Entry<String, AddressesScopedList>,
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
          ListAddressesRequest, AddressList, Address, ListPage, ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListAddressesRequest, AddressList, Address> context,
        ApiFuture<AddressList> futureResponse) {
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
      extends AbstractPage<ListAddressesRequest, AddressList, Address, ListPage> {

    private ListPage(
        PageContext<ListAddressesRequest, AddressList, Address> context, AddressList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListAddressesRequest, AddressList, Address> context, AddressList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListAddressesRequest, AddressList, Address> context,
        ApiFuture<AddressList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAddressesRequest, AddressList, Address, ListPage, ListFixedSizeCollection> {

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
