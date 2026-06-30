/*
 * Copyright 2021 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.httpjson.longrunning;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.stub.OperationsStub;
import com.google.api.gax.httpjson.longrunning.stub.OperationsStubSettings;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.CancelOperationRequest;
import com.google.longrunning.DeleteOperationRequest;
import com.google.longrunning.GetOperationRequest;
import com.google.longrunning.ListOperationsRequest;
import com.google.longrunning.ListOperationsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Manages long-running operations with an API service.
 *
 * <p>When an API method normally takes long time to complete, it can be designed to return
 * [Operation][google.longrunning.Operation] to the client, and the client can use this interface to
 * receive the real response asynchronously by polling the operation resource, or pass the operation
 * resource to another API (such as Google Cloud Pub/Sub API) to receive the response. Any API
 * service that returns long-running operations should implement the `Operations` interface so
 * developers can have a consistent client experience.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (OperationsClient operationsClient = OperationsClient.create()) {
 *   String name = "name3373707";
 *   Operation response = operationsClient.getOperation(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the OperationsClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of OperationsSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * OperationsSettings operationsSettings =
 *     OperationsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * OperationsClient operationsClient = OperationsClient.create(operationsSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * OperationsSettings operationsSettings =
 *     OperationsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * OperationsClient operationsClient = OperationsClient.create(operationsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
public class OperationsClient implements BackgroundResource {
  private final OperationsSettings settings;
  private final OperationsStub stub;

  /** Constructs an instance of OperationsClient with default settings. */
  public static final OperationsClient create() throws IOException {
    return create(OperationsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of OperationsClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final OperationsClient create(OperationsSettings settings) throws IOException {
    return new OperationsClient(settings);
  }

  /**
   * Constructs an instance of OperationsClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(OperationsSettings).
   */
  public static final OperationsClient create(OperationsStub stub) {
    return new OperationsClient(stub);
  }

  /**
   * Constructs an instance of OperationsClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(OperationsSettings).
   */
  public static final OperationsClient create(BackgroundResource stub) {
    return new OperationsClient((OperationsStub) stub);
  }

  /**
   * Constructs an instance of OperationsClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected OperationsClient(OperationsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((OperationsStubSettings) settings.getStubSettings()).createStub();
  }

  protected OperationsClient(OperationsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final OperationsSettings getSettings() {
    return settings;
  }

  public OperationsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists operations that match the specified filter in the request. If the server doesn't support
   * this method, it returns `UNIMPLEMENTED`.
   *
   * <p>NOTE: the `name` binding allows API services to override the binding to use different
   * resource name schemes, such as `users/&#42;/operations`. To override the binding, API services
   * can add a binding such as `"/v1/{name=users/&#42;}/operations"` to their service configuration.
   * For backwards compatibility, the default name includes the operations collection id, however
   * overriding users must ensure the name binding is the parent resource, without the operations
   * collection id.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OperationsClient operationsClient = OperationsClient.create()) {
   *   String name = "name3373707";
   *   String filter = "filter-1274492040";
   *   for (Operation element : operationsClient.listOperations(name, filter).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name The name of the operation's parent resource.
   * @param filter The standard list filter.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOperationsPagedResponse listOperations(String name, String filter) {
    ListOperationsRequest request =
        ListOperationsRequest.newBuilder().setName(name).setFilter(filter).build();
    return listOperations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists operations that match the specified filter in the request. If the server doesn't support
   * this method, it returns `UNIMPLEMENTED`.
   *
   * <p>NOTE: the `name` binding allows API services to override the binding to use different
   * resource name schemes, such as `users/&#42;/operations`. To override the binding, API services
   * can add a binding such as `"/v1/{name=users/&#42;}/operations"` to their service configuration.
   * For backwards compatibility, the default name includes the operations collection id, however
   * overriding users must ensure the name binding is the parent resource, without the operations
   * collection id.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OperationsClient operationsClient = OperationsClient.create()) {
   *   ListOperationsRequest request =
   *       ListOperationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Operation element : operationsClient.listOperations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOperationsPagedResponse listOperations(ListOperationsRequest request) {
    return listOperationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists operations that match the specified filter in the request. If the server doesn't support
   * this method, it returns `UNIMPLEMENTED`.
   *
   * <p>NOTE: the `name` binding allows API services to override the binding to use different
   * resource name schemes, such as `users/&#42;/operations`. To override the binding, API services
   * can add a binding such as `"/v1/{name=users/&#42;}/operations"` to their service configuration.
   * For backwards compatibility, the default name includes the operations collection id, however
   * overriding users must ensure the name binding is the parent resource, without the operations
   * collection id.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OperationsClient operationsClient = OperationsClient.create()) {
   *   ListOperationsRequest request =
   *       ListOperationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Operation> future =
   *       operationsClient.listOperationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Operation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListOperationsRequest, ListOperationsPagedResponse>
      listOperationsPagedCallable() {
    return stub.listOperationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists operations that match the specified filter in the request. If the server doesn't support
   * this method, it returns `UNIMPLEMENTED`.
   *
   * <p>NOTE: the `name` binding allows API services to override the binding to use different
   * resource name schemes, such as `users/&#42;/operations`. To override the binding, API services
   * can add a binding such as `"/v1/{name=users/&#42;}/operations"` to their service configuration.
   * For backwards compatibility, the default name includes the operations collection id, however
   * overriding users must ensure the name binding is the parent resource, without the operations
   * collection id.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OperationsClient operationsClient = OperationsClient.create()) {
   *   ListOperationsRequest request =
   *       ListOperationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListOperationsResponse response = operationsClient.listOperationsCallable().call(request);
   *     for (Operation element : response.getResponsesList()) {
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
  public final UnaryCallable<ListOperationsRequest, ListOperationsResponse>
      listOperationsCallable() {
    return stub.listOperationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the latest state of a long-running operation. Clients can use this method to poll the
   * operation result at intervals as recommended by the API service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OperationsClient operationsClient = OperationsClient.create()) {
   *   String name = "name3373707";
   *   Operation response = operationsClient.getOperation(name);
   * }
   * }</pre>
   *
   * @param name The name of the operation resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation getOperation(String name) {
    GetOperationRequest request = GetOperationRequest.newBuilder().setName(name).build();
    return getOperation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the latest state of a long-running operation. Clients can use this method to poll the
   * operation result at intervals as recommended by the API service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OperationsClient operationsClient = OperationsClient.create()) {
   *   GetOperationRequest request = GetOperationRequest.newBuilder().setName("name3373707").build();
   *   Operation response = operationsClient.getOperation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation getOperation(GetOperationRequest request) {
    return getOperationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the latest state of a long-running operation. Clients can use this method to poll the
   * operation result at intervals as recommended by the API service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OperationsClient operationsClient = OperationsClient.create()) {
   *   GetOperationRequest request = GetOperationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Operation> future = operationsClient.getOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetOperationRequest, Operation> getOperationCallable() {
    return stub.getOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a long-running operation. This method indicates that the client is no longer interested
   * in the operation result. It does not cancel the operation. If the server doesn't support this
   * method, it returns `google.rpc.Code.UNIMPLEMENTED`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OperationsClient operationsClient = OperationsClient.create()) {
   *   String name = "name3373707";
   *   operationsClient.deleteOperation(name);
   * }
   * }</pre>
   *
   * @param name The name of the operation resource to be deleted.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteOperation(String name) {
    DeleteOperationRequest request = DeleteOperationRequest.newBuilder().setName(name).build();
    deleteOperation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a long-running operation. This method indicates that the client is no longer interested
   * in the operation result. It does not cancel the operation. If the server doesn't support this
   * method, it returns `google.rpc.Code.UNIMPLEMENTED`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OperationsClient operationsClient = OperationsClient.create()) {
   *   DeleteOperationRequest request =
   *       DeleteOperationRequest.newBuilder().setName("name3373707").build();
   *   operationsClient.deleteOperation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteOperation(DeleteOperationRequest request) {
    deleteOperationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a long-running operation. This method indicates that the client is no longer interested
   * in the operation result. It does not cancel the operation. If the server doesn't support this
   * method, it returns `google.rpc.Code.UNIMPLEMENTED`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OperationsClient operationsClient = OperationsClient.create()) {
   *   DeleteOperationRequest request =
   *       DeleteOperationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Empty> future = operationsClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteOperationRequest, Empty> deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts asynchronous cancellation on a long-running operation. The server makes a best effort to
   * cancel the operation, but success is not guaranteed. If the server doesn't support this method,
   * it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use
   * [Operations.GetOperation][google.longrunning.Operations.GetOperation] or other methods to check
   * whether the cancellation succeeded or whether the operation completed despite cancellation. On
   * successful cancellation, the operation is not deleted; instead, it becomes an operation with an
   * [Operation.error][google.longrunning.Operation.error] value with a
   * [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding to `Code.CANCELLED`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OperationsClient operationsClient = OperationsClient.create()) {
   *   String name = "name3373707";
   *   operationsClient.cancelOperation(name);
   * }
   * }</pre>
   *
   * @param name The name of the operation resource to be cancelled.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelOperation(String name) {
    CancelOperationRequest request = CancelOperationRequest.newBuilder().setName(name).build();
    cancelOperation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts asynchronous cancellation on a long-running operation. The server makes a best effort to
   * cancel the operation, but success is not guaranteed. If the server doesn't support this method,
   * it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use
   * [Operations.GetOperation][google.longrunning.Operations.GetOperation] or other methods to check
   * whether the cancellation succeeded or whether the operation completed despite cancellation. On
   * successful cancellation, the operation is not deleted; instead, it becomes an operation with an
   * [Operation.error][google.longrunning.Operation.error] value with a
   * [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding to `Code.CANCELLED`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OperationsClient operationsClient = OperationsClient.create()) {
   *   CancelOperationRequest request =
   *       CancelOperationRequest.newBuilder().setName("name3373707").build();
   *   operationsClient.cancelOperation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelOperation(CancelOperationRequest request) {
    cancelOperationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts asynchronous cancellation on a long-running operation. The server makes a best effort to
   * cancel the operation, but success is not guaranteed. If the server doesn't support this method,
   * it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use
   * [Operations.GetOperation][google.longrunning.Operations.GetOperation] or other methods to check
   * whether the cancellation succeeded or whether the operation completed despite cancellation. On
   * successful cancellation, the operation is not deleted; instead, it becomes an operation with an
   * [Operation.error][google.longrunning.Operation.error] value with a
   * [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding to `Code.CANCELLED`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OperationsClient operationsClient = OperationsClient.create()) {
   *   CancelOperationRequest request =
   *       CancelOperationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Empty> future = operationsClient.cancelOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CancelOperationRequest, Empty> cancelOperationCallable() {
    return stub.cancelOperationCallable();
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

  public static class ListOperationsPagedResponse
      extends AbstractPagedListResponse<
          ListOperationsRequest,
          ListOperationsResponse,
          Operation,
          ListOperationsPage,
          ListOperationsFixedSizeCollection> {

    public static ApiFuture<ListOperationsPagedResponse> createAsync(
        PageContext<ListOperationsRequest, ListOperationsResponse, Operation> context,
        ApiFuture<ListOperationsResponse> futureResponse) {
      ApiFuture<ListOperationsPage> futurePage =
          ListOperationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListOperationsPage, ListOperationsPagedResponse>() {
            @Override
            public ListOperationsPagedResponse apply(ListOperationsPage input) {
              return new ListOperationsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListOperationsPagedResponse(ListOperationsPage page) {
      super(page, ListOperationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListOperationsPage
      extends AbstractPage<
          ListOperationsRequest, ListOperationsResponse, Operation, ListOperationsPage> {

    private ListOperationsPage(
        PageContext<ListOperationsRequest, ListOperationsResponse, Operation> context,
        ListOperationsResponse response) {
      super(context, response);
    }

    private static ListOperationsPage createEmptyPage() {
      return new ListOperationsPage(null, null);
    }

    @Override
    protected ListOperationsPage createPage(
        PageContext<ListOperationsRequest, ListOperationsResponse, Operation> context,
        ListOperationsResponse response) {
      return new ListOperationsPage(context, response);
    }

    @Override
    public ApiFuture<ListOperationsPage> createPageAsync(
        PageContext<ListOperationsRequest, ListOperationsResponse, Operation> context,
        ApiFuture<ListOperationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListOperationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListOperationsRequest,
          ListOperationsResponse,
          Operation,
          ListOperationsPage,
          ListOperationsFixedSizeCollection> {

    private ListOperationsFixedSizeCollection(List<ListOperationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListOperationsFixedSizeCollection createEmptyCollection() {
      return new ListOperationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListOperationsFixedSizeCollection createCollection(
        List<ListOperationsPage> pages, int collectionSize) {
      return new ListOperationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
