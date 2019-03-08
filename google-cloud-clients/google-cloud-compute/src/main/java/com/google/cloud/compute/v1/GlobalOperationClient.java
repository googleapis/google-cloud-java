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
import com.google.cloud.compute.v1.stub.GlobalOperationStub;
import com.google.cloud.compute.v1.stub.GlobalOperationStubSettings;
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
 * try (GlobalOperationClient globalOperationClient = GlobalOperationClient.create()) {
 *   ProjectGlobalOperationName operation = ProjectGlobalOperationName.of("[PROJECT]", "[OPERATION]");
 *   globalOperationClient.deleteGlobalOperation(operation);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the globalOperationClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of GlobalOperationSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * GlobalOperationSettings globalOperationSettings =
 *     GlobalOperationSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GlobalOperationClient globalOperationClient =
 *     GlobalOperationClient.create(globalOperationSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * GlobalOperationSettings globalOperationSettings =
 *     GlobalOperationSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GlobalOperationClient globalOperationClient =
 *     GlobalOperationClient.create(globalOperationSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class GlobalOperationClient implements BackgroundResource {
  private final GlobalOperationSettings settings;
  private final GlobalOperationStub stub;

  /** Constructs an instance of GlobalOperationClient with default settings. */
  public static final GlobalOperationClient create() throws IOException {
    return create(GlobalOperationSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of GlobalOperationClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final GlobalOperationClient create(GlobalOperationSettings settings)
      throws IOException {
    return new GlobalOperationClient(settings);
  }

  /**
   * Constructs an instance of GlobalOperationClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use GlobalOperationSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final GlobalOperationClient create(GlobalOperationStub stub) {
    return new GlobalOperationClient(stub);
  }

  /**
   * Constructs an instance of GlobalOperationClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GlobalOperationClient(GlobalOperationSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((GlobalOperationStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected GlobalOperationClient(GlobalOperationStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final GlobalOperationSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public GlobalOperationStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of all operations.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalOperationClient globalOperationClient = GlobalOperationClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (OperationsScopedList element : globalOperationClient.aggregatedListGlobalOperations(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListGlobalOperationsPagedResponse aggregatedListGlobalOperations(
      ProjectName project) {
    AggregatedListGlobalOperationsHttpRequest request =
        AggregatedListGlobalOperationsHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return aggregatedListGlobalOperations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of all operations.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalOperationClient globalOperationClient = GlobalOperationClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (OperationsScopedList element : globalOperationClient.aggregatedListGlobalOperations(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListGlobalOperationsPagedResponse aggregatedListGlobalOperations(
      String project) {
    AggregatedListGlobalOperationsHttpRequest request =
        AggregatedListGlobalOperationsHttpRequest.newBuilder().setProject(project).build();
    return aggregatedListGlobalOperations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of all operations.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalOperationClient globalOperationClient = GlobalOperationClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListGlobalOperationsHttpRequest request = AggregatedListGlobalOperationsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   for (OperationsScopedList element : globalOperationClient.aggregatedListGlobalOperations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListGlobalOperationsPagedResponse aggregatedListGlobalOperations(
      AggregatedListGlobalOperationsHttpRequest request) {
    return aggregatedListGlobalOperationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of all operations.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalOperationClient globalOperationClient = GlobalOperationClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListGlobalOperationsHttpRequest request = AggregatedListGlobalOperationsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;AggregatedListGlobalOperationsPagedResponse&gt; future = globalOperationClient.aggregatedListGlobalOperationsPagedCallable().futureCall(request);
   *   // Do something
   *   for (OperationsScopedList element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          AggregatedListGlobalOperationsHttpRequest, AggregatedListGlobalOperationsPagedResponse>
      aggregatedListGlobalOperationsPagedCallable() {
    return stub.aggregatedListGlobalOperationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of all operations.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalOperationClient globalOperationClient = GlobalOperationClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListGlobalOperationsHttpRequest request = AggregatedListGlobalOperationsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   while (true) {
   *     OperationAggregatedList response = globalOperationClient.aggregatedListGlobalOperationsCallable().call(request);
   *     for (OperationsScopedList element : response.getItemsMap()) {
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
  public final UnaryCallable<AggregatedListGlobalOperationsHttpRequest, OperationAggregatedList>
      aggregatedListGlobalOperationsCallable() {
    return stub.aggregatedListGlobalOperationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified Operations resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalOperationClient globalOperationClient = GlobalOperationClient.create()) {
   *   ProjectGlobalOperationName operation = ProjectGlobalOperationName.of("[PROJECT]", "[OPERATION]");
   *   globalOperationClient.deleteGlobalOperation(operation);
   * }
   * </code></pre>
   *
   * @param operation Name of the Operations resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final void deleteGlobalOperation(ProjectGlobalOperationName operation) {

    DeleteGlobalOperationHttpRequest request =
        DeleteGlobalOperationHttpRequest.newBuilder()
            .setOperation(operation == null ? null : operation.toString())
            .build();
    deleteGlobalOperation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified Operations resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalOperationClient globalOperationClient = GlobalOperationClient.create()) {
   *   ProjectGlobalOperationName operation = ProjectGlobalOperationName.of("[PROJECT]", "[OPERATION]");
   *   globalOperationClient.deleteGlobalOperation(operation.toString());
   * }
   * </code></pre>
   *
   * @param operation Name of the Operations resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final void deleteGlobalOperation(String operation) {

    DeleteGlobalOperationHttpRequest request =
        DeleteGlobalOperationHttpRequest.newBuilder().setOperation(operation).build();
    deleteGlobalOperation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified Operations resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalOperationClient globalOperationClient = GlobalOperationClient.create()) {
   *   ProjectGlobalOperationName operation = ProjectGlobalOperationName.of("[PROJECT]", "[OPERATION]");
   *   DeleteGlobalOperationHttpRequest request = DeleteGlobalOperationHttpRequest.newBuilder()
   *     .setOperation(operation.toString())
   *     .build();
   *   globalOperationClient.deleteGlobalOperation(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final void deleteGlobalOperation(DeleteGlobalOperationHttpRequest request) {
    deleteGlobalOperationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified Operations resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalOperationClient globalOperationClient = GlobalOperationClient.create()) {
   *   ProjectGlobalOperationName operation = ProjectGlobalOperationName.of("[PROJECT]", "[OPERATION]");
   *   DeleteGlobalOperationHttpRequest request = DeleteGlobalOperationHttpRequest.newBuilder()
   *     .setOperation(operation.toString())
   *     .build();
   *   ApiFuture&lt;Void&gt; future = globalOperationClient.deleteGlobalOperationCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteGlobalOperationHttpRequest, Void>
      deleteGlobalOperationCallable() {
    return stub.deleteGlobalOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the specified Operations resource. Gets a list of operations by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalOperationClient globalOperationClient = GlobalOperationClient.create()) {
   *   ProjectGlobalOperationName operation = ProjectGlobalOperationName.of("[PROJECT]", "[OPERATION]");
   *   Operation response = globalOperationClient.getGlobalOperation(operation);
   * }
   * </code></pre>
   *
   * @param operation Name of the Operations resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation getGlobalOperation(ProjectGlobalOperationName operation) {

    GetGlobalOperationHttpRequest request =
        GetGlobalOperationHttpRequest.newBuilder()
            .setOperation(operation == null ? null : operation.toString())
            .build();
    return getGlobalOperation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the specified Operations resource. Gets a list of operations by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalOperationClient globalOperationClient = GlobalOperationClient.create()) {
   *   ProjectGlobalOperationName operation = ProjectGlobalOperationName.of("[PROJECT]", "[OPERATION]");
   *   Operation response = globalOperationClient.getGlobalOperation(operation.toString());
   * }
   * </code></pre>
   *
   * @param operation Name of the Operations resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation getGlobalOperation(String operation) {

    GetGlobalOperationHttpRequest request =
        GetGlobalOperationHttpRequest.newBuilder().setOperation(operation).build();
    return getGlobalOperation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the specified Operations resource. Gets a list of operations by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalOperationClient globalOperationClient = GlobalOperationClient.create()) {
   *   ProjectGlobalOperationName operation = ProjectGlobalOperationName.of("[PROJECT]", "[OPERATION]");
   *   GetGlobalOperationHttpRequest request = GetGlobalOperationHttpRequest.newBuilder()
   *     .setOperation(operation.toString())
   *     .build();
   *   Operation response = globalOperationClient.getGlobalOperation(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation getGlobalOperation(GetGlobalOperationHttpRequest request) {
    return getGlobalOperationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the specified Operations resource. Gets a list of operations by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalOperationClient globalOperationClient = GlobalOperationClient.create()) {
   *   ProjectGlobalOperationName operation = ProjectGlobalOperationName.of("[PROJECT]", "[OPERATION]");
   *   GetGlobalOperationHttpRequest request = GetGlobalOperationHttpRequest.newBuilder()
   *     .setOperation(operation.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = globalOperationClient.getGlobalOperationCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetGlobalOperationHttpRequest, Operation>
      getGlobalOperationCallable() {
    return stub.getGlobalOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of Operation resources contained within the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalOperationClient globalOperationClient = GlobalOperationClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (Operation element : globalOperationClient.listGlobalOperations(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListGlobalOperationsPagedResponse listGlobalOperations(ProjectName project) {
    ListGlobalOperationsHttpRequest request =
        ListGlobalOperationsHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return listGlobalOperations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of Operation resources contained within the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalOperationClient globalOperationClient = GlobalOperationClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (Operation element : globalOperationClient.listGlobalOperations(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListGlobalOperationsPagedResponse listGlobalOperations(String project) {
    ListGlobalOperationsHttpRequest request =
        ListGlobalOperationsHttpRequest.newBuilder().setProject(project).build();
    return listGlobalOperations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of Operation resources contained within the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalOperationClient globalOperationClient = GlobalOperationClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListGlobalOperationsHttpRequest request = ListGlobalOperationsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   for (Operation element : globalOperationClient.listGlobalOperations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListGlobalOperationsPagedResponse listGlobalOperations(
      ListGlobalOperationsHttpRequest request) {
    return listGlobalOperationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of Operation resources contained within the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalOperationClient globalOperationClient = GlobalOperationClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListGlobalOperationsHttpRequest request = ListGlobalOperationsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;ListGlobalOperationsPagedResponse&gt; future = globalOperationClient.listGlobalOperationsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Operation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListGlobalOperationsHttpRequest, ListGlobalOperationsPagedResponse>
      listGlobalOperationsPagedCallable() {
    return stub.listGlobalOperationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of Operation resources contained within the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalOperationClient globalOperationClient = GlobalOperationClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListGlobalOperationsHttpRequest request = ListGlobalOperationsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   while (true) {
   *     OperationList response = globalOperationClient.listGlobalOperationsCallable().call(request);
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
  public final UnaryCallable<ListGlobalOperationsHttpRequest, OperationList>
      listGlobalOperationsCallable() {
    return stub.listGlobalOperationsCallable();
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

  public static class AggregatedListGlobalOperationsPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListGlobalOperationsHttpRequest,
          OperationAggregatedList,
          OperationsScopedList,
          AggregatedListGlobalOperationsPage,
          AggregatedListGlobalOperationsFixedSizeCollection> {

    public static ApiFuture<AggregatedListGlobalOperationsPagedResponse> createAsync(
        PageContext<
                AggregatedListGlobalOperationsHttpRequest,
                OperationAggregatedList,
                OperationsScopedList>
            context,
        ApiFuture<OperationAggregatedList> futureResponse) {
      ApiFuture<AggregatedListGlobalOperationsPage> futurePage =
          AggregatedListGlobalOperationsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              AggregatedListGlobalOperationsPage, AggregatedListGlobalOperationsPagedResponse>() {
            @Override
            public AggregatedListGlobalOperationsPagedResponse apply(
                AggregatedListGlobalOperationsPage input) {
              return new AggregatedListGlobalOperationsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private AggregatedListGlobalOperationsPagedResponse(AggregatedListGlobalOperationsPage page) {
      super(page, AggregatedListGlobalOperationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListGlobalOperationsPage
      extends AbstractPage<
          AggregatedListGlobalOperationsHttpRequest,
          OperationAggregatedList,
          OperationsScopedList,
          AggregatedListGlobalOperationsPage> {

    private AggregatedListGlobalOperationsPage(
        PageContext<
                AggregatedListGlobalOperationsHttpRequest,
                OperationAggregatedList,
                OperationsScopedList>
            context,
        OperationAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListGlobalOperationsPage createEmptyPage() {
      return new AggregatedListGlobalOperationsPage(null, null);
    }

    @Override
    protected AggregatedListGlobalOperationsPage createPage(
        PageContext<
                AggregatedListGlobalOperationsHttpRequest,
                OperationAggregatedList,
                OperationsScopedList>
            context,
        OperationAggregatedList response) {
      return new AggregatedListGlobalOperationsPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListGlobalOperationsPage> createPageAsync(
        PageContext<
                AggregatedListGlobalOperationsHttpRequest,
                OperationAggregatedList,
                OperationsScopedList>
            context,
        ApiFuture<OperationAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListGlobalOperationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListGlobalOperationsHttpRequest,
          OperationAggregatedList,
          OperationsScopedList,
          AggregatedListGlobalOperationsPage,
          AggregatedListGlobalOperationsFixedSizeCollection> {

    private AggregatedListGlobalOperationsFixedSizeCollection(
        List<AggregatedListGlobalOperationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListGlobalOperationsFixedSizeCollection createEmptyCollection() {
      return new AggregatedListGlobalOperationsFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListGlobalOperationsFixedSizeCollection createCollection(
        List<AggregatedListGlobalOperationsPage> pages, int collectionSize) {
      return new AggregatedListGlobalOperationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListGlobalOperationsPagedResponse
      extends AbstractPagedListResponse<
          ListGlobalOperationsHttpRequest,
          OperationList,
          Operation,
          ListGlobalOperationsPage,
          ListGlobalOperationsFixedSizeCollection> {

    public static ApiFuture<ListGlobalOperationsPagedResponse> createAsync(
        PageContext<ListGlobalOperationsHttpRequest, OperationList, Operation> context,
        ApiFuture<OperationList> futureResponse) {
      ApiFuture<ListGlobalOperationsPage> futurePage =
          ListGlobalOperationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListGlobalOperationsPage, ListGlobalOperationsPagedResponse>() {
            @Override
            public ListGlobalOperationsPagedResponse apply(ListGlobalOperationsPage input) {
              return new ListGlobalOperationsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListGlobalOperationsPagedResponse(ListGlobalOperationsPage page) {
      super(page, ListGlobalOperationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGlobalOperationsPage
      extends AbstractPage<
          ListGlobalOperationsHttpRequest, OperationList, Operation, ListGlobalOperationsPage> {

    private ListGlobalOperationsPage(
        PageContext<ListGlobalOperationsHttpRequest, OperationList, Operation> context,
        OperationList response) {
      super(context, response);
    }

    private static ListGlobalOperationsPage createEmptyPage() {
      return new ListGlobalOperationsPage(null, null);
    }

    @Override
    protected ListGlobalOperationsPage createPage(
        PageContext<ListGlobalOperationsHttpRequest, OperationList, Operation> context,
        OperationList response) {
      return new ListGlobalOperationsPage(context, response);
    }

    @Override
    public ApiFuture<ListGlobalOperationsPage> createPageAsync(
        PageContext<ListGlobalOperationsHttpRequest, OperationList, Operation> context,
        ApiFuture<OperationList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGlobalOperationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGlobalOperationsHttpRequest,
          OperationList,
          Operation,
          ListGlobalOperationsPage,
          ListGlobalOperationsFixedSizeCollection> {

    private ListGlobalOperationsFixedSizeCollection(
        List<ListGlobalOperationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGlobalOperationsFixedSizeCollection createEmptyCollection() {
      return new ListGlobalOperationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGlobalOperationsFixedSizeCollection createCollection(
        List<ListGlobalOperationsPage> pages, int collectionSize) {
      return new ListGlobalOperationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
