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
import com.google.cloud.compute.v1.stub.RegionAutoscalersStub;
import com.google.cloud.compute.v1.stub.RegionAutoscalersStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The RegionAutoscalers API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (RegionAutoscalersClient regionAutoscalersClient = RegionAutoscalersClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String autoscaler = "";
 *   Operation response = regionAutoscalersClient.delete(project, region, autoscaler);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the regionAutoscalersClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of RegionAutoscalersSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * RegionAutoscalersSettings regionAutoscalersSettings =
 *     RegionAutoscalersSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionAutoscalersClient regionAutoscalersClient =
 *     RegionAutoscalersClient.create(regionAutoscalersSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * RegionAutoscalersSettings regionAutoscalersSettings =
 *     RegionAutoscalersSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionAutoscalersClient regionAutoscalersClient =
 *     RegionAutoscalersClient.create(regionAutoscalersSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionAutoscalersClient implements BackgroundResource {
  private final RegionAutoscalersSettings settings;
  private final RegionAutoscalersStub stub;

  /** Constructs an instance of RegionAutoscalersClient with default settings. */
  public static final RegionAutoscalersClient create() throws IOException {
    return create(RegionAutoscalersSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionAutoscalersClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RegionAutoscalersClient create(RegionAutoscalersSettings settings)
      throws IOException {
    return new RegionAutoscalersClient(settings);
  }

  /**
   * Constructs an instance of RegionAutoscalersClient, using the given stub for making calls. This
   * is for advanced usage - prefer to use RegionAutoscalersSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final RegionAutoscalersClient create(RegionAutoscalersStub stub) {
    return new RegionAutoscalersClient(stub);
  }

  /**
   * Constructs an instance of RegionAutoscalersClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected RegionAutoscalersClient(RegionAutoscalersSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RegionAutoscalersStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected RegionAutoscalersClient(RegionAutoscalersStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionAutoscalersSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RegionAutoscalersStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified autoscaler.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalersClient regionAutoscalersClient = RegionAutoscalersClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String autoscaler = "";
   *   Operation response = regionAutoscalersClient.delete(project, region, autoscaler);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param autoscaler Name of the autoscaler to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String region, String autoscaler) {
    DeleteRegionAutoscalerRequest request =
        DeleteRegionAutoscalerRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setAutoscaler(autoscaler)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified autoscaler.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalersClient regionAutoscalersClient = RegionAutoscalersClient.create()) {
   *   String autoscaler = "";
   *   String project = "";
   *   String region = "";
   *   DeleteRegionAutoscalerRequest request = DeleteRegionAutoscalerRequest.newBuilder()
   *     .setAutoscaler(autoscaler)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   Operation response = regionAutoscalersClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteRegionAutoscalerRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified autoscaler.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalersClient regionAutoscalersClient = RegionAutoscalersClient.create()) {
   *   String autoscaler = "";
   *   String project = "";
   *   String region = "";
   *   DeleteRegionAutoscalerRequest request = DeleteRegionAutoscalerRequest.newBuilder()
   *     .setAutoscaler(autoscaler)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionAutoscalersClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteRegionAutoscalerRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified autoscaler.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalersClient regionAutoscalersClient = RegionAutoscalersClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String autoscaler = "";
   *   Autoscaler response = regionAutoscalersClient.get(project, region, autoscaler);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param autoscaler Name of the autoscaler to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Autoscaler get(String project, String region, String autoscaler) {
    GetRegionAutoscalerRequest request =
        GetRegionAutoscalerRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setAutoscaler(autoscaler)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified autoscaler.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalersClient regionAutoscalersClient = RegionAutoscalersClient.create()) {
   *   String autoscaler = "";
   *   String project = "";
   *   String region = "";
   *   GetRegionAutoscalerRequest request = GetRegionAutoscalerRequest.newBuilder()
   *     .setAutoscaler(autoscaler)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   Autoscaler response = regionAutoscalersClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Autoscaler get(GetRegionAutoscalerRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified autoscaler.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalersClient regionAutoscalersClient = RegionAutoscalersClient.create()) {
   *   String autoscaler = "";
   *   String project = "";
   *   String region = "";
   *   GetRegionAutoscalerRequest request = GetRegionAutoscalerRequest.newBuilder()
   *     .setAutoscaler(autoscaler)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;Autoscaler&gt; future = regionAutoscalersClient.getCallable().futureCall(request);
   *   // Do something
   *   Autoscaler response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetRegionAutoscalerRequest, Autoscaler> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an autoscaler in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalersClient regionAutoscalersClient = RegionAutoscalersClient.create()) {
   *   String project = "";
   *   String region = "";
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   Operation response = regionAutoscalersClient.insert(project, region, autoscalerResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param autoscalerResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(String project, String region, Autoscaler autoscalerResource) {
    InsertRegionAutoscalerRequest request =
        InsertRegionAutoscalerRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setAutoscalerResource(autoscalerResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an autoscaler in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalersClient regionAutoscalersClient = RegionAutoscalersClient.create()) {
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   InsertRegionAutoscalerRequest request = InsertRegionAutoscalerRequest.newBuilder()
   *     .setAutoscalerResource(autoscalerResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   Operation response = regionAutoscalersClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertRegionAutoscalerRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an autoscaler in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalersClient regionAutoscalersClient = RegionAutoscalersClient.create()) {
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   InsertRegionAutoscalerRequest request = InsertRegionAutoscalerRequest.newBuilder()
   *     .setAutoscalerResource(autoscalerResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionAutoscalersClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertRegionAutoscalerRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of autoscalers contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalersClient regionAutoscalersClient = RegionAutoscalersClient.create()) {
   *   String project = "";
   *   String region = "";
   *   for (Autoscaler element : regionAutoscalersClient.list(project, region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String region) {
    ListRegionAutoscalersRequest request =
        ListRegionAutoscalersRequest.newBuilder().setProject(project).setRegion(region).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of autoscalers contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalersClient regionAutoscalersClient = RegionAutoscalersClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListRegionAutoscalersRequest request = ListRegionAutoscalersRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   for (Autoscaler element : regionAutoscalersClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListRegionAutoscalersRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of autoscalers contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalersClient regionAutoscalersClient = RegionAutoscalersClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListRegionAutoscalersRequest request = ListRegionAutoscalersRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = regionAutoscalersClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (Autoscaler element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListRegionAutoscalersRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of autoscalers contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalersClient regionAutoscalersClient = RegionAutoscalersClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListRegionAutoscalersRequest request = ListRegionAutoscalersRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   while (true) {
   *     RegionAutoscalerList response = regionAutoscalersClient.listCallable().call(request);
   *     for (Autoscaler element : response.getItemsList()) {
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
  public final UnaryCallable<ListRegionAutoscalersRequest, RegionAutoscalerList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an autoscaler in the specified project using the data included in the request. This
   * method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalersClient regionAutoscalersClient = RegionAutoscalersClient.create()) {
   *   String project = "";
   *   String region = "";
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   Operation response = regionAutoscalersClient.patch(project, region, autoscalerResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param autoscalerResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(String project, String region, Autoscaler autoscalerResource) {
    PatchRegionAutoscalerRequest request =
        PatchRegionAutoscalerRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setAutoscalerResource(autoscalerResource)
            .build();
    return patch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an autoscaler in the specified project using the data included in the request. This
   * method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalersClient regionAutoscalersClient = RegionAutoscalersClient.create()) {
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   PatchRegionAutoscalerRequest request = PatchRegionAutoscalerRequest.newBuilder()
   *     .setAutoscalerResource(autoscalerResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   Operation response = regionAutoscalersClient.patch(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(PatchRegionAutoscalerRequest request) {
    return patchCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an autoscaler in the specified project using the data included in the request. This
   * method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalersClient regionAutoscalersClient = RegionAutoscalersClient.create()) {
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   PatchRegionAutoscalerRequest request = PatchRegionAutoscalerRequest.newBuilder()
   *     .setAutoscalerResource(autoscalerResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionAutoscalersClient.patchCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<PatchRegionAutoscalerRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an autoscaler in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalersClient regionAutoscalersClient = RegionAutoscalersClient.create()) {
   *   String project = "";
   *   String region = "";
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   Operation response = regionAutoscalersClient.update(project, region, autoscalerResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param autoscalerResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation update(String project, String region, Autoscaler autoscalerResource) {
    UpdateRegionAutoscalerRequest request =
        UpdateRegionAutoscalerRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setAutoscalerResource(autoscalerResource)
            .build();
    return update(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an autoscaler in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalersClient regionAutoscalersClient = RegionAutoscalersClient.create()) {
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   UpdateRegionAutoscalerRequest request = UpdateRegionAutoscalerRequest.newBuilder()
   *     .setAutoscalerResource(autoscalerResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   Operation response = regionAutoscalersClient.update(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation update(UpdateRegionAutoscalerRequest request) {
    return updateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an autoscaler in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalersClient regionAutoscalersClient = RegionAutoscalersClient.create()) {
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   UpdateRegionAutoscalerRequest request = UpdateRegionAutoscalerRequest.newBuilder()
   *     .setAutoscalerResource(autoscalerResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionAutoscalersClient.updateCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateRegionAutoscalerRequest, Operation> updateCallable() {
    return stub.updateCallable();
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
          ListRegionAutoscalersRequest,
          RegionAutoscalerList,
          Autoscaler,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListRegionAutoscalersRequest, RegionAutoscalerList, Autoscaler> context,
        ApiFuture<RegionAutoscalerList> futureResponse) {
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
          ListRegionAutoscalersRequest, RegionAutoscalerList, Autoscaler, ListPage> {

    private ListPage(
        PageContext<ListRegionAutoscalersRequest, RegionAutoscalerList, Autoscaler> context,
        RegionAutoscalerList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListRegionAutoscalersRequest, RegionAutoscalerList, Autoscaler> context,
        RegionAutoscalerList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListRegionAutoscalersRequest, RegionAutoscalerList, Autoscaler> context,
        ApiFuture<RegionAutoscalerList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionAutoscalersRequest,
          RegionAutoscalerList,
          Autoscaler,
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
