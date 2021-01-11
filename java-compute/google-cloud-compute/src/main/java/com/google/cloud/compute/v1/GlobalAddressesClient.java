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
import com.google.cloud.compute.v1.stub.GlobalAddressesStub;
import com.google.cloud.compute.v1.stub.GlobalAddressesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The GlobalAddresses API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (GlobalAddressesClient globalAddressesClient = GlobalAddressesClient.create()) {
 *   String project = "";
 *   String address = "";
 *   Operation response = globalAddressesClient.delete(project, address);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the globalAddressesClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of GlobalAddressesSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * GlobalAddressesSettings globalAddressesSettings =
 *     GlobalAddressesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GlobalAddressesClient globalAddressesClient =
 *     GlobalAddressesClient.create(globalAddressesSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * GlobalAddressesSettings globalAddressesSettings =
 *     GlobalAddressesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GlobalAddressesClient globalAddressesClient =
 *     GlobalAddressesClient.create(globalAddressesSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class GlobalAddressesClient implements BackgroundResource {
  private final GlobalAddressesSettings settings;
  private final GlobalAddressesStub stub;

  /** Constructs an instance of GlobalAddressesClient with default settings. */
  public static final GlobalAddressesClient create() throws IOException {
    return create(GlobalAddressesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of GlobalAddressesClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final GlobalAddressesClient create(GlobalAddressesSettings settings)
      throws IOException {
    return new GlobalAddressesClient(settings);
  }

  /**
   * Constructs an instance of GlobalAddressesClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use GlobalAddressesSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final GlobalAddressesClient create(GlobalAddressesStub stub) {
    return new GlobalAddressesClient(stub);
  }

  /**
   * Constructs an instance of GlobalAddressesClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GlobalAddressesClient(GlobalAddressesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((GlobalAddressesStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected GlobalAddressesClient(GlobalAddressesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final GlobalAddressesSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public GlobalAddressesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified address resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalAddressesClient globalAddressesClient = GlobalAddressesClient.create()) {
   *   String project = "";
   *   String address = "";
   *   Operation response = globalAddressesClient.delete(project, address);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param address Name of the address resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String address) {
    DeleteGlobalAddressRequest request =
        DeleteGlobalAddressRequest.newBuilder().setProject(project).setAddress(address).build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified address resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalAddressesClient globalAddressesClient = GlobalAddressesClient.create()) {
   *   String address = "";
   *   String project = "";
   *   DeleteGlobalAddressRequest request = DeleteGlobalAddressRequest.newBuilder()
   *     .setAddress(address)
   *     .setProject(project)
   *     .build();
   *   Operation response = globalAddressesClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteGlobalAddressRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified address resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalAddressesClient globalAddressesClient = GlobalAddressesClient.create()) {
   *   String address = "";
   *   String project = "";
   *   DeleteGlobalAddressRequest request = DeleteGlobalAddressRequest.newBuilder()
   *     .setAddress(address)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = globalAddressesClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteGlobalAddressRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified address resource. Gets a list of available addresses by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalAddressesClient globalAddressesClient = GlobalAddressesClient.create()) {
   *   String project = "";
   *   String address = "";
   *   Address response = globalAddressesClient.get(project, address);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param address Name of the address resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Address get(String project, String address) {
    GetGlobalAddressRequest request =
        GetGlobalAddressRequest.newBuilder().setProject(project).setAddress(address).build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified address resource. Gets a list of available addresses by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalAddressesClient globalAddressesClient = GlobalAddressesClient.create()) {
   *   String address = "";
   *   String project = "";
   *   GetGlobalAddressRequest request = GetGlobalAddressRequest.newBuilder()
   *     .setAddress(address)
   *     .setProject(project)
   *     .build();
   *   Address response = globalAddressesClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Address get(GetGlobalAddressRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified address resource. Gets a list of available addresses by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalAddressesClient globalAddressesClient = GlobalAddressesClient.create()) {
   *   String address = "";
   *   String project = "";
   *   GetGlobalAddressRequest request = GetGlobalAddressRequest.newBuilder()
   *     .setAddress(address)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Address&gt; future = globalAddressesClient.getCallable().futureCall(request);
   *   // Do something
   *   Address response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetGlobalAddressRequest, Address> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an address resource in the specified project by using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalAddressesClient globalAddressesClient = GlobalAddressesClient.create()) {
   *   String project = "";
   *   Address addressResource = Address.newBuilder().build();
   *   Operation response = globalAddressesClient.insert(project, addressResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param addressResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(String project, Address addressResource) {
    InsertGlobalAddressRequest request =
        InsertGlobalAddressRequest.newBuilder()
            .setProject(project)
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
   * try (GlobalAddressesClient globalAddressesClient = GlobalAddressesClient.create()) {
   *   Address addressResource = Address.newBuilder().build();
   *   String project = "";
   *   InsertGlobalAddressRequest request = InsertGlobalAddressRequest.newBuilder()
   *     .setAddressResource(addressResource)
   *     .setProject(project)
   *     .build();
   *   Operation response = globalAddressesClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertGlobalAddressRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an address resource in the specified project by using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalAddressesClient globalAddressesClient = GlobalAddressesClient.create()) {
   *   Address addressResource = Address.newBuilder().build();
   *   String project = "";
   *   InsertGlobalAddressRequest request = InsertGlobalAddressRequest.newBuilder()
   *     .setAddressResource(addressResource)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = globalAddressesClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertGlobalAddressRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of global addresses.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalAddressesClient globalAddressesClient = GlobalAddressesClient.create()) {
   *   String project = "";
   *   for (Address element : globalAddressesClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListGlobalAddressesRequest request =
        ListGlobalAddressesRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of global addresses.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalAddressesClient globalAddressesClient = GlobalAddressesClient.create()) {
   *   String project = "";
   *   ListGlobalAddressesRequest request = ListGlobalAddressesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (Address element : globalAddressesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListGlobalAddressesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of global addresses.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalAddressesClient globalAddressesClient = GlobalAddressesClient.create()) {
   *   String project = "";
   *   ListGlobalAddressesRequest request = ListGlobalAddressesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = globalAddressesClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (Address element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListGlobalAddressesRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of global addresses.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalAddressesClient globalAddressesClient = GlobalAddressesClient.create()) {
   *   String project = "";
   *   ListGlobalAddressesRequest request = ListGlobalAddressesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     AddressList response = globalAddressesClient.listCallable().call(request);
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
  public final UnaryCallable<ListGlobalAddressesRequest, AddressList> listCallable() {
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
          ListGlobalAddressesRequest, AddressList, Address, ListPage, ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListGlobalAddressesRequest, AddressList, Address> context,
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
      extends AbstractPage<ListGlobalAddressesRequest, AddressList, Address, ListPage> {

    private ListPage(
        PageContext<ListGlobalAddressesRequest, AddressList, Address> context,
        AddressList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListGlobalAddressesRequest, AddressList, Address> context,
        AddressList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListGlobalAddressesRequest, AddressList, Address> context,
        ApiFuture<AddressList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGlobalAddressesRequest, AddressList, Address, ListPage, ListFixedSizeCollection> {

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
