/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.compute.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.RegionOperationsStub;
import com.google.cloud.compute.v1.stub.RegionOperationsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The RegionOperations API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (RegionOperationsClient regionOperationsClient = RegionOperationsClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String operation = "operation1662702951";
 *   DeleteRegionOperationResponse response =
 *       regionOperationsClient.delete(project, region, operation);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RegionOperationsClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of RegionOperationsSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RegionOperationsSettings regionOperationsSettings =
 *     RegionOperationsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionOperationsClient regionOperationsClient =
 *     RegionOperationsClient.create(regionOperationsSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RegionOperationsSettings regionOperationsSettings =
 *     RegionOperationsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionOperationsClient regionOperationsClient =
 *     RegionOperationsClient.create(regionOperationsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class RegionOperationsClient implements BackgroundResource {
  private final RegionOperationsSettings settings;
  private final RegionOperationsStub stub;

  /** Constructs an instance of RegionOperationsClient with default settings. */
  public static final RegionOperationsClient create() throws IOException {
    return create(RegionOperationsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionOperationsClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RegionOperationsClient create(RegionOperationsSettings settings)
      throws IOException {
    return new RegionOperationsClient(settings);
  }

  /**
   * Constructs an instance of RegionOperationsClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(RegionOperationsSettings).
   */
  public static final RegionOperationsClient create(RegionOperationsStub stub) {
    return new RegionOperationsClient(stub);
  }

  /**
   * Constructs an instance of RegionOperationsClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected RegionOperationsClient(RegionOperationsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RegionOperationsStubSettings) settings.getStubSettings()).createStub();
  }

  protected RegionOperationsClient(RegionOperationsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionOperationsSettings getSettings() {
    return settings;
  }

  public RegionOperationsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified region-specific Operations resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionOperationsClient regionOperationsClient = RegionOperationsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String operation = "operation1662702951";
   *   DeleteRegionOperationResponse response =
   *       regionOperationsClient.delete(project, region, operation);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param operation Name of the Operations resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeleteRegionOperationResponse delete(
      String project, String region, String operation) {
    DeleteRegionOperationRequest request =
        DeleteRegionOperationRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setOperation(operation)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified region-specific Operations resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionOperationsClient regionOperationsClient = RegionOperationsClient.create()) {
   *   DeleteRegionOperationRequest request =
   *       DeleteRegionOperationRequest.newBuilder()
   *           .setOperation("operation1662702951")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   DeleteRegionOperationResponse response = regionOperationsClient.delete(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeleteRegionOperationResponse delete(DeleteRegionOperationRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified region-specific Operations resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionOperationsClient regionOperationsClient = RegionOperationsClient.create()) {
   *   DeleteRegionOperationRequest request =
   *       DeleteRegionOperationRequest.newBuilder()
   *           .setOperation("operation1662702951")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   ApiFuture<DeleteRegionOperationResponse> future =
   *       regionOperationsClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   DeleteRegionOperationResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRegionOperationRequest, DeleteRegionOperationResponse>
      deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified region-specific Operations resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionOperationsClient regionOperationsClient = RegionOperationsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String operation = "operation1662702951";
   *   Operation response = regionOperationsClient.get(project, region, operation);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param operation Name of the Operations resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation get(String project, String region, String operation) {
    GetRegionOperationRequest request =
        GetRegionOperationRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setOperation(operation)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified region-specific Operations resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionOperationsClient regionOperationsClient = RegionOperationsClient.create()) {
   *   GetRegionOperationRequest request =
   *       GetRegionOperationRequest.newBuilder()
   *           .setOperation("operation1662702951")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   Operation response = regionOperationsClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation get(GetRegionOperationRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified region-specific Operations resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionOperationsClient regionOperationsClient = RegionOperationsClient.create()) {
   *   GetRegionOperationRequest request =
   *       GetRegionOperationRequest.newBuilder()
   *           .setOperation("operation1662702951")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   ApiFuture<Operation> future = regionOperationsClient.getCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRegionOperationRequest, Operation> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of Operation resources contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionOperationsClient regionOperationsClient = RegionOperationsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   for (Operation element : regionOperationsClient.list(project, region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String region) {
    ListRegionOperationsRequest request =
        ListRegionOperationsRequest.newBuilder().setProject(project).setRegion(region).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of Operation resources contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionOperationsClient regionOperationsClient = RegionOperationsClient.create()) {
   *   ListRegionOperationsRequest request =
   *       ListRegionOperationsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (Operation element : regionOperationsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListRegionOperationsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of Operation resources contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionOperationsClient regionOperationsClient = RegionOperationsClient.create()) {
   *   ListRegionOperationsRequest request =
   *       ListRegionOperationsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<Operation> future = regionOperationsClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Operation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRegionOperationsRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of Operation resources contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionOperationsClient regionOperationsClient = RegionOperationsClient.create()) {
   *   ListRegionOperationsRequest request =
   *       ListRegionOperationsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     OperationList response = regionOperationsClient.listCallable().call(request);
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
   * }</pre>
   */
  public final UnaryCallable<ListRegionOperationsRequest, OperationList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Waits for the specified Operation resource to return as `DONE` or for the request to approach
   * the 2 minute deadline, and retrieves the specified Operation resource. This method differs from
   * the `GET` method in that it waits for no more than the default deadline (2 minutes) and then
   * returns the current state of the operation, which might be `DONE` or still in progress. This
   * method is called on a best-effort basis. Specifically: - In uncommon cases, when the server is
   * overloaded, the request might return before the default deadline is reached, or might return
   * after zero seconds. - If the default deadline is reached, there is no guarantee that the
   * operation is actually done when the method returns. Be prepared to retry if the operation is
   * not `DONE`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionOperationsClient regionOperationsClient = RegionOperationsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String operation = "operation1662702951";
   *   Operation response = regionOperationsClient.wait(project, region, operation);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param operation Name of the Operations resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation wait(String project, String region, String operation) {
    WaitRegionOperationRequest request =
        WaitRegionOperationRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setOperation(operation)
            .build();
    return wait(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Waits for the specified Operation resource to return as `DONE` or for the request to approach
   * the 2 minute deadline, and retrieves the specified Operation resource. This method differs from
   * the `GET` method in that it waits for no more than the default deadline (2 minutes) and then
   * returns the current state of the operation, which might be `DONE` or still in progress. This
   * method is called on a best-effort basis. Specifically: - In uncommon cases, when the server is
   * overloaded, the request might return before the default deadline is reached, or might return
   * after zero seconds. - If the default deadline is reached, there is no guarantee that the
   * operation is actually done when the method returns. Be prepared to retry if the operation is
   * not `DONE`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionOperationsClient regionOperationsClient = RegionOperationsClient.create()) {
   *   WaitRegionOperationRequest request =
   *       WaitRegionOperationRequest.newBuilder()
   *           .setOperation("operation1662702951")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   Operation response = regionOperationsClient.wait(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation wait(WaitRegionOperationRequest request) {
    return waitCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Waits for the specified Operation resource to return as `DONE` or for the request to approach
   * the 2 minute deadline, and retrieves the specified Operation resource. This method differs from
   * the `GET` method in that it waits for no more than the default deadline (2 minutes) and then
   * returns the current state of the operation, which might be `DONE` or still in progress. This
   * method is called on a best-effort basis. Specifically: - In uncommon cases, when the server is
   * overloaded, the request might return before the default deadline is reached, or might return
   * after zero seconds. - If the default deadline is reached, there is no guarantee that the
   * operation is actually done when the method returns. Be prepared to retry if the operation is
   * not `DONE`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionOperationsClient regionOperationsClient = RegionOperationsClient.create()) {
   *   WaitRegionOperationRequest request =
   *       WaitRegionOperationRequest.newBuilder()
   *           .setOperation("operation1662702951")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   ApiFuture<Operation> future = regionOperationsClient.waitCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<WaitRegionOperationRequest, Operation> waitCallable() {
    return stub.waitCallable();
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
          ListRegionOperationsRequest,
          OperationList,
          Operation,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListRegionOperationsRequest, OperationList, Operation> context,
        ApiFuture<OperationList> futureResponse) {
      ApiFuture<ListPage> futurePage =
          ListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListPagedResponse(ListPage page) {
      super(page, ListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPage
      extends AbstractPage<ListRegionOperationsRequest, OperationList, Operation, ListPage> {

    private ListPage(
        PageContext<ListRegionOperationsRequest, OperationList, Operation> context,
        OperationList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListRegionOperationsRequest, OperationList, Operation> context,
        OperationList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListRegionOperationsRequest, OperationList, Operation> context,
        ApiFuture<OperationList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionOperationsRequest,
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
