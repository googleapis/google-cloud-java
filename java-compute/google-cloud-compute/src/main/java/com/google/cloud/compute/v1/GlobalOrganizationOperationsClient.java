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
import com.google.cloud.compute.v1.stub.GlobalOrganizationOperationsStub;
import com.google.cloud.compute.v1.stub.GlobalOrganizationOperationsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The GlobalOrganizationOperations API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (GlobalOrganizationOperationsClient globalOrganizationOperationsClient = GlobalOrganizationOperationsClient.create()) {
 *   String operation = "";
 *   DeleteGlobalOrganizationOperationResponse response = globalOrganizationOperationsClient.delete(operation);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the globalOrganizationOperationsClient object to clean up
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
 * <p>This class can be customized by passing in a custom instance of
 * GlobalOrganizationOperationsSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * GlobalOrganizationOperationsSettings globalOrganizationOperationsSettings =
 *     GlobalOrganizationOperationsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GlobalOrganizationOperationsClient globalOrganizationOperationsClient =
 *     GlobalOrganizationOperationsClient.create(globalOrganizationOperationsSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * GlobalOrganizationOperationsSettings globalOrganizationOperationsSettings =
 *     GlobalOrganizationOperationsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GlobalOrganizationOperationsClient globalOrganizationOperationsClient =
 *     GlobalOrganizationOperationsClient.create(globalOrganizationOperationsSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class GlobalOrganizationOperationsClient implements BackgroundResource {
  private final GlobalOrganizationOperationsSettings settings;
  private final GlobalOrganizationOperationsStub stub;

  /** Constructs an instance of GlobalOrganizationOperationsClient with default settings. */
  public static final GlobalOrganizationOperationsClient create() throws IOException {
    return create(GlobalOrganizationOperationsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of GlobalOrganizationOperationsClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final GlobalOrganizationOperationsClient create(
      GlobalOrganizationOperationsSettings settings) throws IOException {
    return new GlobalOrganizationOperationsClient(settings);
  }

  /**
   * Constructs an instance of GlobalOrganizationOperationsClient, using the given stub for making
   * calls. This is for advanced usage - prefer to use GlobalOrganizationOperationsSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final GlobalOrganizationOperationsClient create(
      GlobalOrganizationOperationsStub stub) {
    return new GlobalOrganizationOperationsClient(stub);
  }

  /**
   * Constructs an instance of GlobalOrganizationOperationsClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GlobalOrganizationOperationsClient(GlobalOrganizationOperationsSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((GlobalOrganizationOperationsStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected GlobalOrganizationOperationsClient(GlobalOrganizationOperationsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final GlobalOrganizationOperationsSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public GlobalOrganizationOperationsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified Operations resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalOrganizationOperationsClient globalOrganizationOperationsClient = GlobalOrganizationOperationsClient.create()) {
   *   String operation = "";
   *   DeleteGlobalOrganizationOperationResponse response = globalOrganizationOperationsClient.delete(operation);
   * }
   * </code></pre>
   *
   * @param operation Name of the Operations resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeleteGlobalOrganizationOperationResponse delete(String operation) {
    DeleteGlobalOrganizationOperationRequest request =
        DeleteGlobalOrganizationOperationRequest.newBuilder().setOperation(operation).build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified Operations resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalOrganizationOperationsClient globalOrganizationOperationsClient = GlobalOrganizationOperationsClient.create()) {
   *   String operation = "";
   *   DeleteGlobalOrganizationOperationRequest request = DeleteGlobalOrganizationOperationRequest.newBuilder()
   *     .setOperation(operation)
   *     .build();
   *   DeleteGlobalOrganizationOperationResponse response = globalOrganizationOperationsClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeleteGlobalOrganizationOperationResponse delete(
      DeleteGlobalOrganizationOperationRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified Operations resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalOrganizationOperationsClient globalOrganizationOperationsClient = GlobalOrganizationOperationsClient.create()) {
   *   String operation = "";
   *   DeleteGlobalOrganizationOperationRequest request = DeleteGlobalOrganizationOperationRequest.newBuilder()
   *     .setOperation(operation)
   *     .build();
   *   ApiFuture&lt;DeleteGlobalOrganizationOperationResponse&gt; future = globalOrganizationOperationsClient.deleteCallable().futureCall(request);
   *   // Do something
   *   DeleteGlobalOrganizationOperationResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<
          DeleteGlobalOrganizationOperationRequest, DeleteGlobalOrganizationOperationResponse>
      deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the specified Operations resource. Gets a list of operations by making a `list()`
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalOrganizationOperationsClient globalOrganizationOperationsClient = GlobalOrganizationOperationsClient.create()) {
   *   String operation = "";
   *   Operation response = globalOrganizationOperationsClient.get(operation);
   * }
   * </code></pre>
   *
   * @param operation Name of the Operations resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation get(String operation) {
    GetGlobalOrganizationOperationRequest request =
        GetGlobalOrganizationOperationRequest.newBuilder().setOperation(operation).build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the specified Operations resource. Gets a list of operations by making a `list()`
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalOrganizationOperationsClient globalOrganizationOperationsClient = GlobalOrganizationOperationsClient.create()) {
   *   String operation = "";
   *   GetGlobalOrganizationOperationRequest request = GetGlobalOrganizationOperationRequest.newBuilder()
   *     .setOperation(operation)
   *     .build();
   *   Operation response = globalOrganizationOperationsClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation get(GetGlobalOrganizationOperationRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the specified Operations resource. Gets a list of operations by making a `list()`
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalOrganizationOperationsClient globalOrganizationOperationsClient = GlobalOrganizationOperationsClient.create()) {
   *   String operation = "";
   *   GetGlobalOrganizationOperationRequest request = GetGlobalOrganizationOperationRequest.newBuilder()
   *     .setOperation(operation)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = globalOrganizationOperationsClient.getCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetGlobalOrganizationOperationRequest, Operation> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of Operation resources contained within the specified organization.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalOrganizationOperationsClient globalOrganizationOperationsClient = GlobalOrganizationOperationsClient.create()) {
   *
   *   for (Operation element : globalOrganizationOperationsClient.list().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list() {
    ListGlobalOrganizationOperationsRequest request =
        ListGlobalOrganizationOperationsRequest.newBuilder().build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of Operation resources contained within the specified organization.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalOrganizationOperationsClient globalOrganizationOperationsClient = GlobalOrganizationOperationsClient.create()) {
   *   ListGlobalOrganizationOperationsRequest request = ListGlobalOrganizationOperationsRequest.newBuilder().build();
   *   for (Operation element : globalOrganizationOperationsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListGlobalOrganizationOperationsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of Operation resources contained within the specified organization.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalOrganizationOperationsClient globalOrganizationOperationsClient = GlobalOrganizationOperationsClient.create()) {
   *   ListGlobalOrganizationOperationsRequest request = ListGlobalOrganizationOperationsRequest.newBuilder().build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = globalOrganizationOperationsClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (Operation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListGlobalOrganizationOperationsRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of Operation resources contained within the specified organization.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalOrganizationOperationsClient globalOrganizationOperationsClient = GlobalOrganizationOperationsClient.create()) {
   *   ListGlobalOrganizationOperationsRequest request = ListGlobalOrganizationOperationsRequest.newBuilder().build();
   *   while (true) {
   *     OperationList response = globalOrganizationOperationsClient.listCallable().call(request);
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
  public final UnaryCallable<ListGlobalOrganizationOperationsRequest, OperationList>
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
          ListGlobalOrganizationOperationsRequest,
          OperationList,
          Operation,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListGlobalOrganizationOperationsRequest, OperationList, Operation> context,
        ApiFuture<OperationList> futureResponse) {
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
          ListGlobalOrganizationOperationsRequest, OperationList, Operation, ListPage> {

    private ListPage(
        PageContext<ListGlobalOrganizationOperationsRequest, OperationList, Operation> context,
        OperationList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListGlobalOrganizationOperationsRequest, OperationList, Operation> context,
        OperationList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListGlobalOrganizationOperationsRequest, OperationList, Operation> context,
        ApiFuture<OperationList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGlobalOrganizationOperationsRequest,
          OperationList,
          Operation,
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
