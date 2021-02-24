/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.aiplatform.v1beta1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.stub.MigrationServiceStub;
import com.google.cloud.aiplatform.v1beta1.stub.MigrationServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service that migrates resources from automl.googleapis.com,
 * datalabeling.googleapis.com and ml.googleapis.com to AI Platform.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   for (MigratableResource element :
 *       migrationServiceClient.searchMigratableResources(parent).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the MigrationServiceClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of MigrationServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * MigrationServiceSettings migrationServiceSettings =
 *     MigrationServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * MigrationServiceClient migrationServiceClient =
 *     MigrationServiceClient.create(migrationServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * MigrationServiceSettings migrationServiceSettings =
 *     MigrationServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * MigrationServiceClient migrationServiceClient =
 *     MigrationServiceClient.create(migrationServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator")
public class MigrationServiceClient implements BackgroundResource {
  private final MigrationServiceSettings settings;
  private final MigrationServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of MigrationServiceClient with default settings. */
  public static final MigrationServiceClient create() throws IOException {
    return create(MigrationServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of MigrationServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final MigrationServiceClient create(MigrationServiceSettings settings)
      throws IOException {
    return new MigrationServiceClient(settings);
  }

  /**
   * Constructs an instance of MigrationServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(MigrationServiceSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final MigrationServiceClient create(MigrationServiceStub stub) {
    return new MigrationServiceClient(stub);
  }

  /**
   * Constructs an instance of MigrationServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected MigrationServiceClient(MigrationServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((MigrationServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected MigrationServiceClient(MigrationServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final MigrationServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public MigrationServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches all of the resources in automl.googleapis.com, datalabeling.googleapis.com and
   * ml.googleapis.com that can be migrated to AI Platform's given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (MigratableResource element :
   *       migrationServiceClient.searchMigratableResources(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The location that the migratable resources should be searched from.
   *     It's the AI Platform location that the resources can be migrated to, not the resources'
   *     original location. Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchMigratableResourcesPagedResponse searchMigratableResources(
      LocationName parent) {
    SearchMigratableResourcesRequest request =
        SearchMigratableResourcesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return searchMigratableResources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches all of the resources in automl.googleapis.com, datalabeling.googleapis.com and
   * ml.googleapis.com that can be migrated to AI Platform's given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (MigratableResource element :
   *       migrationServiceClient.searchMigratableResources(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The location that the migratable resources should be searched from.
   *     It's the AI Platform location that the resources can be migrated to, not the resources'
   *     original location. Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchMigratableResourcesPagedResponse searchMigratableResources(String parent) {
    SearchMigratableResourcesRequest request =
        SearchMigratableResourcesRequest.newBuilder().setParent(parent).build();
    return searchMigratableResources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches all of the resources in automl.googleapis.com, datalabeling.googleapis.com and
   * ml.googleapis.com that can be migrated to AI Platform's given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   SearchMigratableResourcesRequest request =
   *       SearchMigratableResourcesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (MigratableResource element :
   *       migrationServiceClient.searchMigratableResources(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchMigratableResourcesPagedResponse searchMigratableResources(
      SearchMigratableResourcesRequest request) {
    return searchMigratableResourcesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches all of the resources in automl.googleapis.com, datalabeling.googleapis.com and
   * ml.googleapis.com that can be migrated to AI Platform's given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   SearchMigratableResourcesRequest request =
   *       SearchMigratableResourcesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<MigratableResource> future =
   *       migrationServiceClient.searchMigratableResourcesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (MigratableResource element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          SearchMigratableResourcesRequest, SearchMigratableResourcesPagedResponse>
      searchMigratableResourcesPagedCallable() {
    return stub.searchMigratableResourcesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches all of the resources in automl.googleapis.com, datalabeling.googleapis.com and
   * ml.googleapis.com that can be migrated to AI Platform's given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   while (true) {
   *     SearchMigratableResourcesResponse response =
   *         migrationServiceClient.searchMigratableResourcesCallable().call(request);
   *     for (MigratableResource element : response.getResponsesList()) {
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
  public final UnaryCallable<SearchMigratableResourcesRequest, SearchMigratableResourcesResponse>
      searchMigratableResourcesCallable() {
    return stub.searchMigratableResourcesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch migrates resources from ml.googleapis.com, automl.googleapis.com, and
   * datalabeling.googleapis.com to AI Platform (Unified).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   List<MigrateResourceRequest> migrateResourceRequests = new ArrayList<>();
   *   BatchMigrateResourcesResponse response =
   *       migrationServiceClient.batchMigrateResourcesAsync(parent, migrateResourceRequests).get();
   * }
   * }</pre>
   *
   * @param parent Required. The location of the migrated resource will live in. Format:
   *     `projects/{project}/locations/{location}`
   * @param migrateResourceRequests Required. The request messages specifying the resources to
   *     migrate. They must be in the same location as the destination. Up to 50 resources can be
   *     migrated in one batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          BatchMigrateResourcesResponse, BatchMigrateResourcesOperationMetadata>
      batchMigrateResourcesAsync(
          LocationName parent, List<MigrateResourceRequest> migrateResourceRequests) {
    BatchMigrateResourcesRequest request =
        BatchMigrateResourcesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllMigrateResourceRequests(migrateResourceRequests)
            .build();
    return batchMigrateResourcesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch migrates resources from ml.googleapis.com, automl.googleapis.com, and
   * datalabeling.googleapis.com to AI Platform (Unified).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   List<MigrateResourceRequest> migrateResourceRequests = new ArrayList<>();
   *   BatchMigrateResourcesResponse response =
   *       migrationServiceClient.batchMigrateResourcesAsync(parent, migrateResourceRequests).get();
   * }
   * }</pre>
   *
   * @param parent Required. The location of the migrated resource will live in. Format:
   *     `projects/{project}/locations/{location}`
   * @param migrateResourceRequests Required. The request messages specifying the resources to
   *     migrate. They must be in the same location as the destination. Up to 50 resources can be
   *     migrated in one batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          BatchMigrateResourcesResponse, BatchMigrateResourcesOperationMetadata>
      batchMigrateResourcesAsync(
          String parent, List<MigrateResourceRequest> migrateResourceRequests) {
    BatchMigrateResourcesRequest request =
        BatchMigrateResourcesRequest.newBuilder()
            .setParent(parent)
            .addAllMigrateResourceRequests(migrateResourceRequests)
            .build();
    return batchMigrateResourcesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch migrates resources from ml.googleapis.com, automl.googleapis.com, and
   * datalabeling.googleapis.com to AI Platform (Unified).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   BatchMigrateResourcesRequest request =
   *       BatchMigrateResourcesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .addAllMigrateResourceRequests(new ArrayList<MigrateResourceRequest>())
   *           .build();
   *   BatchMigrateResourcesResponse response =
   *       migrationServiceClient.batchMigrateResourcesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          BatchMigrateResourcesResponse, BatchMigrateResourcesOperationMetadata>
      batchMigrateResourcesAsync(BatchMigrateResourcesRequest request) {
    return batchMigrateResourcesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch migrates resources from ml.googleapis.com, automl.googleapis.com, and
   * datalabeling.googleapis.com to AI Platform (Unified).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   BatchMigrateResourcesRequest request =
   *       BatchMigrateResourcesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .addAllMigrateResourceRequests(new ArrayList<MigrateResourceRequest>())
   *           .build();
   *   OperationFuture<BatchMigrateResourcesResponse, BatchMigrateResourcesOperationMetadata>
   *       future =
   *           migrationServiceClient.batchMigrateResourcesOperationCallable().futureCall(request);
   *   // Do something.
   *   BatchMigrateResourcesResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          BatchMigrateResourcesRequest,
          BatchMigrateResourcesResponse,
          BatchMigrateResourcesOperationMetadata>
      batchMigrateResourcesOperationCallable() {
    return stub.batchMigrateResourcesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch migrates resources from ml.googleapis.com, automl.googleapis.com, and
   * datalabeling.googleapis.com to AI Platform (Unified).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
   *   BatchMigrateResourcesRequest request =
   *       BatchMigrateResourcesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .addAllMigrateResourceRequests(new ArrayList<MigrateResourceRequest>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       migrationServiceClient.batchMigrateResourcesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchMigrateResourcesRequest, Operation>
      batchMigrateResourcesCallable() {
    return stub.batchMigrateResourcesCallable();
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

  public static class SearchMigratableResourcesPagedResponse
      extends AbstractPagedListResponse<
          SearchMigratableResourcesRequest,
          SearchMigratableResourcesResponse,
          MigratableResource,
          SearchMigratableResourcesPage,
          SearchMigratableResourcesFixedSizeCollection> {

    public static ApiFuture<SearchMigratableResourcesPagedResponse> createAsync(
        PageContext<
                SearchMigratableResourcesRequest,
                SearchMigratableResourcesResponse,
                MigratableResource>
            context,
        ApiFuture<SearchMigratableResourcesResponse> futureResponse) {
      ApiFuture<SearchMigratableResourcesPage> futurePage =
          SearchMigratableResourcesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<SearchMigratableResourcesPage, SearchMigratableResourcesPagedResponse>() {
            @Override
            public SearchMigratableResourcesPagedResponse apply(
                SearchMigratableResourcesPage input) {
              return new SearchMigratableResourcesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private SearchMigratableResourcesPagedResponse(SearchMigratableResourcesPage page) {
      super(page, SearchMigratableResourcesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchMigratableResourcesPage
      extends AbstractPage<
          SearchMigratableResourcesRequest,
          SearchMigratableResourcesResponse,
          MigratableResource,
          SearchMigratableResourcesPage> {

    private SearchMigratableResourcesPage(
        PageContext<
                SearchMigratableResourcesRequest,
                SearchMigratableResourcesResponse,
                MigratableResource>
            context,
        SearchMigratableResourcesResponse response) {
      super(context, response);
    }

    private static SearchMigratableResourcesPage createEmptyPage() {
      return new SearchMigratableResourcesPage(null, null);
    }

    @Override
    protected SearchMigratableResourcesPage createPage(
        PageContext<
                SearchMigratableResourcesRequest,
                SearchMigratableResourcesResponse,
                MigratableResource>
            context,
        SearchMigratableResourcesResponse response) {
      return new SearchMigratableResourcesPage(context, response);
    }

    @Override
    public ApiFuture<SearchMigratableResourcesPage> createPageAsync(
        PageContext<
                SearchMigratableResourcesRequest,
                SearchMigratableResourcesResponse,
                MigratableResource>
            context,
        ApiFuture<SearchMigratableResourcesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchMigratableResourcesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchMigratableResourcesRequest,
          SearchMigratableResourcesResponse,
          MigratableResource,
          SearchMigratableResourcesPage,
          SearchMigratableResourcesFixedSizeCollection> {

    private SearchMigratableResourcesFixedSizeCollection(
        List<SearchMigratableResourcesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchMigratableResourcesFixedSizeCollection createEmptyCollection() {
      return new SearchMigratableResourcesFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchMigratableResourcesFixedSizeCollection createCollection(
        List<SearchMigratableResourcesPage> pages, int collectionSize) {
      return new SearchMigratableResourcesFixedSizeCollection(pages, collectionSize);
    }
  }
}
