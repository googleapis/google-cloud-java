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
import com.google.cloud.compute.v1.stub.SslCertificatesStub;
import com.google.cloud.compute.v1.stub.SslCertificatesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The SslCertificates API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (SslCertificatesClient sslCertificatesClient = SslCertificatesClient.create()) {
 *   String project = "";
 *   String sslCertificate = "";
 *   Operation response = sslCertificatesClient.delete(project, sslCertificate);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the sslCertificatesClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of SslCertificatesSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * SslCertificatesSettings sslCertificatesSettings =
 *     SslCertificatesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SslCertificatesClient sslCertificatesClient =
 *     SslCertificatesClient.create(sslCertificatesSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * SslCertificatesSettings sslCertificatesSettings =
 *     SslCertificatesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SslCertificatesClient sslCertificatesClient =
 *     SslCertificatesClient.create(sslCertificatesSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class SslCertificatesClient implements BackgroundResource {
  private final SslCertificatesSettings settings;
  private final SslCertificatesStub stub;

  /** Constructs an instance of SslCertificatesClient with default settings. */
  public static final SslCertificatesClient create() throws IOException {
    return create(SslCertificatesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SslCertificatesClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SslCertificatesClient create(SslCertificatesSettings settings)
      throws IOException {
    return new SslCertificatesClient(settings);
  }

  /**
   * Constructs an instance of SslCertificatesClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use SslCertificatesSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final SslCertificatesClient create(SslCertificatesStub stub) {
    return new SslCertificatesClient(stub);
  }

  /**
   * Constructs an instance of SslCertificatesClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected SslCertificatesClient(SslCertificatesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SslCertificatesStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected SslCertificatesClient(SslCertificatesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SslCertificatesSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public SslCertificatesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of all SslCertificate resources, regional and global, available to the
   * specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslCertificatesClient sslCertificatesClient = SslCertificatesClient.create()) {
   *   String project = "";
   *   for (Entry&lt;String, SslCertificatesScopedList&gt; element : sslCertificatesClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Name of the project scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListSslCertificatesRequest request =
        AggregatedListSslCertificatesRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of all SslCertificate resources, regional and global, available to the
   * specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslCertificatesClient sslCertificatesClient = SslCertificatesClient.create()) {
   *   String project = "";
   *   AggregatedListSslCertificatesRequest request = AggregatedListSslCertificatesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (Entry&lt;String, SslCertificatesScopedList&gt; element : sslCertificatesClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListSslCertificatesRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of all SslCertificate resources, regional and global, available to the
   * specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslCertificatesClient sslCertificatesClient = SslCertificatesClient.create()) {
   *   String project = "";
   *   AggregatedListSslCertificatesRequest request = AggregatedListSslCertificatesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;AggregatedListPagedResponse&gt; future = sslCertificatesClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something
   *   for (Entry&lt;String, SslCertificatesScopedList&gt; element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<AggregatedListSslCertificatesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of all SslCertificate resources, regional and global, available to the
   * specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslCertificatesClient sslCertificatesClient = SslCertificatesClient.create()) {
   *   String project = "";
   *   AggregatedListSslCertificatesRequest request = AggregatedListSslCertificatesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     SslCertificateAggregatedList response = sslCertificatesClient.aggregatedListCallable().call(request);
   *     for (Entry&lt;String, SslCertificatesScopedList&gt; element : response.getItemsMap()) {
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
  public final UnaryCallable<AggregatedListSslCertificatesRequest, SslCertificateAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified SslCertificate resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslCertificatesClient sslCertificatesClient = SslCertificatesClient.create()) {
   *   String project = "";
   *   String sslCertificate = "";
   *   Operation response = sslCertificatesClient.delete(project, sslCertificate);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param sslCertificate Name of the SslCertificate resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String sslCertificate) {
    DeleteSslCertificateRequest request =
        DeleteSslCertificateRequest.newBuilder()
            .setProject(project)
            .setSslCertificate(sslCertificate)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified SslCertificate resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslCertificatesClient sslCertificatesClient = SslCertificatesClient.create()) {
   *   String project = "";
   *   String sslCertificate = "";
   *   DeleteSslCertificateRequest request = DeleteSslCertificateRequest.newBuilder()
   *     .setProject(project)
   *     .setSslCertificate(sslCertificate)
   *     .build();
   *   Operation response = sslCertificatesClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteSslCertificateRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified SslCertificate resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslCertificatesClient sslCertificatesClient = SslCertificatesClient.create()) {
   *   String project = "";
   *   String sslCertificate = "";
   *   DeleteSslCertificateRequest request = DeleteSslCertificateRequest.newBuilder()
   *     .setProject(project)
   *     .setSslCertificate(sslCertificate)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = sslCertificatesClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteSslCertificateRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified SslCertificate resource. Gets a list of available SSL certificates by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslCertificatesClient sslCertificatesClient = SslCertificatesClient.create()) {
   *   String project = "";
   *   String sslCertificate = "";
   *   SslCertificate response = sslCertificatesClient.get(project, sslCertificate);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param sslCertificate Name of the SslCertificate resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SslCertificate get(String project, String sslCertificate) {
    GetSslCertificateRequest request =
        GetSslCertificateRequest.newBuilder()
            .setProject(project)
            .setSslCertificate(sslCertificate)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified SslCertificate resource. Gets a list of available SSL certificates by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslCertificatesClient sslCertificatesClient = SslCertificatesClient.create()) {
   *   String project = "";
   *   String sslCertificate = "";
   *   GetSslCertificateRequest request = GetSslCertificateRequest.newBuilder()
   *     .setProject(project)
   *     .setSslCertificate(sslCertificate)
   *     .build();
   *   SslCertificate response = sslCertificatesClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SslCertificate get(GetSslCertificateRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified SslCertificate resource. Gets a list of available SSL certificates by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslCertificatesClient sslCertificatesClient = SslCertificatesClient.create()) {
   *   String project = "";
   *   String sslCertificate = "";
   *   GetSslCertificateRequest request = GetSslCertificateRequest.newBuilder()
   *     .setProject(project)
   *     .setSslCertificate(sslCertificate)
   *     .build();
   *   ApiFuture&lt;SslCertificate&gt; future = sslCertificatesClient.getCallable().futureCall(request);
   *   // Do something
   *   SslCertificate response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetSslCertificateRequest, SslCertificate> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a SslCertificate resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslCertificatesClient sslCertificatesClient = SslCertificatesClient.create()) {
   *   String project = "";
   *   SslCertificate sslCertificateResource = SslCertificate.newBuilder().build();
   *   Operation response = sslCertificatesClient.insert(project, sslCertificateResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param sslCertificateResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(String project, SslCertificate sslCertificateResource) {
    InsertSslCertificateRequest request =
        InsertSslCertificateRequest.newBuilder()
            .setProject(project)
            .setSslCertificateResource(sslCertificateResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a SslCertificate resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslCertificatesClient sslCertificatesClient = SslCertificatesClient.create()) {
   *   String project = "";
   *   SslCertificate sslCertificateResource = SslCertificate.newBuilder().build();
   *   InsertSslCertificateRequest request = InsertSslCertificateRequest.newBuilder()
   *     .setProject(project)
   *     .setSslCertificateResource(sslCertificateResource)
   *     .build();
   *   Operation response = sslCertificatesClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertSslCertificateRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a SslCertificate resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslCertificatesClient sslCertificatesClient = SslCertificatesClient.create()) {
   *   String project = "";
   *   SslCertificate sslCertificateResource = SslCertificate.newBuilder().build();
   *   InsertSslCertificateRequest request = InsertSslCertificateRequest.newBuilder()
   *     .setProject(project)
   *     .setSslCertificateResource(sslCertificateResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = sslCertificatesClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertSslCertificateRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of SslCertificate resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslCertificatesClient sslCertificatesClient = SslCertificatesClient.create()) {
   *   String project = "";
   *   for (SslCertificate element : sslCertificatesClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListSslCertificatesRequest request =
        ListSslCertificatesRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of SslCertificate resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslCertificatesClient sslCertificatesClient = SslCertificatesClient.create()) {
   *   String project = "";
   *   ListSslCertificatesRequest request = ListSslCertificatesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (SslCertificate element : sslCertificatesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListSslCertificatesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of SslCertificate resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslCertificatesClient sslCertificatesClient = SslCertificatesClient.create()) {
   *   String project = "";
   *   ListSslCertificatesRequest request = ListSslCertificatesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = sslCertificatesClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (SslCertificate element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListSslCertificatesRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of SslCertificate resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslCertificatesClient sslCertificatesClient = SslCertificatesClient.create()) {
   *   String project = "";
   *   ListSslCertificatesRequest request = ListSslCertificatesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     SslCertificateList response = sslCertificatesClient.listCallable().call(request);
   *     for (SslCertificate element : response.getItemsList()) {
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
  public final UnaryCallable<ListSslCertificatesRequest, SslCertificateList> listCallable() {
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
          AggregatedListSslCertificatesRequest,
          SslCertificateAggregatedList,
          Entry<String, SslCertificatesScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListSslCertificatesRequest,
                SslCertificateAggregatedList,
                Entry<String, SslCertificatesScopedList>>
            context,
        ApiFuture<SslCertificateAggregatedList> futureResponse) {
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
          AggregatedListSslCertificatesRequest,
          SslCertificateAggregatedList,
          Entry<String, SslCertificatesScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListSslCertificatesRequest,
                SslCertificateAggregatedList,
                Entry<String, SslCertificatesScopedList>>
            context,
        SslCertificateAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListSslCertificatesRequest,
                SslCertificateAggregatedList,
                Entry<String, SslCertificatesScopedList>>
            context,
        SslCertificateAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListSslCertificatesRequest,
                SslCertificateAggregatedList,
                Entry<String, SslCertificatesScopedList>>
            context,
        ApiFuture<SslCertificateAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListSslCertificatesRequest,
          SslCertificateAggregatedList,
          Entry<String, SslCertificatesScopedList>,
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
          ListSslCertificatesRequest,
          SslCertificateList,
          SslCertificate,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListSslCertificatesRequest, SslCertificateList, SslCertificate> context,
        ApiFuture<SslCertificateList> futureResponse) {
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
          ListSslCertificatesRequest, SslCertificateList, SslCertificate, ListPage> {

    private ListPage(
        PageContext<ListSslCertificatesRequest, SslCertificateList, SslCertificate> context,
        SslCertificateList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListSslCertificatesRequest, SslCertificateList, SslCertificate> context,
        SslCertificateList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListSslCertificatesRequest, SslCertificateList, SslCertificate> context,
        ApiFuture<SslCertificateList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSslCertificatesRequest,
          SslCertificateList,
          SslCertificate,
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
