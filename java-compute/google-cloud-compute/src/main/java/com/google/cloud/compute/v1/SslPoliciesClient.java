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
import com.google.cloud.compute.v1.stub.SslPoliciesStub;
import com.google.cloud.compute.v1.stub.SslPoliciesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The SslPolicies API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (SslPoliciesClient sslPoliciesClient = SslPoliciesClient.create()) {
 *   String project = "";
 *   String sslPolicy = "";
 *   Operation response = sslPoliciesClient.delete(project, sslPolicy);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the sslPoliciesClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of SslPoliciesSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * SslPoliciesSettings sslPoliciesSettings =
 *     SslPoliciesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SslPoliciesClient sslPoliciesClient =
 *     SslPoliciesClient.create(sslPoliciesSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * SslPoliciesSettings sslPoliciesSettings =
 *     SslPoliciesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SslPoliciesClient sslPoliciesClient =
 *     SslPoliciesClient.create(sslPoliciesSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class SslPoliciesClient implements BackgroundResource {
  private final SslPoliciesSettings settings;
  private final SslPoliciesStub stub;

  /** Constructs an instance of SslPoliciesClient with default settings. */
  public static final SslPoliciesClient create() throws IOException {
    return create(SslPoliciesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SslPoliciesClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SslPoliciesClient create(SslPoliciesSettings settings) throws IOException {
    return new SslPoliciesClient(settings);
  }

  /**
   * Constructs an instance of SslPoliciesClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use SslPoliciesSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final SslPoliciesClient create(SslPoliciesStub stub) {
    return new SslPoliciesClient(stub);
  }

  /**
   * Constructs an instance of SslPoliciesClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected SslPoliciesClient(SslPoliciesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SslPoliciesStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected SslPoliciesClient(SslPoliciesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SslPoliciesSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public SslPoliciesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified SSL policy. The SSL policy resource can be deleted only if it is not in
   * use by any TargetHttpsProxy or TargetSslProxy resources.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPoliciesClient sslPoliciesClient = SslPoliciesClient.create()) {
   *   String project = "";
   *   String sslPolicy = "";
   *   Operation response = sslPoliciesClient.delete(project, sslPolicy);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param sslPolicy Name of the SSL policy to delete. The name must be 1-63 characters long, and
   *     comply with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String sslPolicy) {
    DeleteSslPolicyRequest request =
        DeleteSslPolicyRequest.newBuilder().setProject(project).setSslPolicy(sslPolicy).build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified SSL policy. The SSL policy resource can be deleted only if it is not in
   * use by any TargetHttpsProxy or TargetSslProxy resources.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPoliciesClient sslPoliciesClient = SslPoliciesClient.create()) {
   *   String project = "";
   *   String sslPolicy = "";
   *   DeleteSslPolicyRequest request = DeleteSslPolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setSslPolicy(sslPolicy)
   *     .build();
   *   Operation response = sslPoliciesClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteSslPolicyRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified SSL policy. The SSL policy resource can be deleted only if it is not in
   * use by any TargetHttpsProxy or TargetSslProxy resources.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPoliciesClient sslPoliciesClient = SslPoliciesClient.create()) {
   *   String project = "";
   *   String sslPolicy = "";
   *   DeleteSslPolicyRequest request = DeleteSslPolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setSslPolicy(sslPolicy)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = sslPoliciesClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteSslPolicyRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all of the ordered rules present in a single specified policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPoliciesClient sslPoliciesClient = SslPoliciesClient.create()) {
   *   String project = "";
   *   String sslPolicy = "";
   *   SslPolicy response = sslPoliciesClient.get(project, sslPolicy);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param sslPolicy Name of the SSL policy to update. The name must be 1-63 characters long, and
   *     comply with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SslPolicy get(String project, String sslPolicy) {
    GetSslPolicyRequest request =
        GetSslPolicyRequest.newBuilder().setProject(project).setSslPolicy(sslPolicy).build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all of the ordered rules present in a single specified policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPoliciesClient sslPoliciesClient = SslPoliciesClient.create()) {
   *   String project = "";
   *   String sslPolicy = "";
   *   GetSslPolicyRequest request = GetSslPolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setSslPolicy(sslPolicy)
   *     .build();
   *   SslPolicy response = sslPoliciesClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SslPolicy get(GetSslPolicyRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all of the ordered rules present in a single specified policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPoliciesClient sslPoliciesClient = SslPoliciesClient.create()) {
   *   String project = "";
   *   String sslPolicy = "";
   *   GetSslPolicyRequest request = GetSslPolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setSslPolicy(sslPolicy)
   *     .build();
   *   ApiFuture&lt;SslPolicy&gt; future = sslPoliciesClient.getCallable().futureCall(request);
   *   // Do something
   *   SslPolicy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetSslPolicyRequest, SslPolicy> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified SSL policy resource. Gets a list of available SSL policies by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPoliciesClient sslPoliciesClient = SslPoliciesClient.create()) {
   *   String project = "";
   *   SslPolicy sslPolicyResource = SslPolicy.newBuilder().build();
   *   Operation response = sslPoliciesClient.insert(project, sslPolicyResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param sslPolicyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(String project, SslPolicy sslPolicyResource) {
    InsertSslPolicyRequest request =
        InsertSslPolicyRequest.newBuilder()
            .setProject(project)
            .setSslPolicyResource(sslPolicyResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified SSL policy resource. Gets a list of available SSL policies by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPoliciesClient sslPoliciesClient = SslPoliciesClient.create()) {
   *   String project = "";
   *   SslPolicy sslPolicyResource = SslPolicy.newBuilder().build();
   *   InsertSslPolicyRequest request = InsertSslPolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setSslPolicyResource(sslPolicyResource)
   *     .build();
   *   Operation response = sslPoliciesClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertSslPolicyRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified SSL policy resource. Gets a list of available SSL policies by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPoliciesClient sslPoliciesClient = SslPoliciesClient.create()) {
   *   String project = "";
   *   SslPolicy sslPolicyResource = SslPolicy.newBuilder().build();
   *   InsertSslPolicyRequest request = InsertSslPolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setSslPolicyResource(sslPolicyResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = sslPoliciesClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertSslPolicyRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all the SSL policies that have been configured for the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPoliciesClient sslPoliciesClient = SslPoliciesClient.create()) {
   *   String project = "";
   *   for (SslPolicy element : sslPoliciesClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListSslPoliciesRequest request =
        ListSslPoliciesRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all the SSL policies that have been configured for the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPoliciesClient sslPoliciesClient = SslPoliciesClient.create()) {
   *   String project = "";
   *   ListSslPoliciesRequest request = ListSslPoliciesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (SslPolicy element : sslPoliciesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListSslPoliciesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all the SSL policies that have been configured for the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPoliciesClient sslPoliciesClient = SslPoliciesClient.create()) {
   *   String project = "";
   *   ListSslPoliciesRequest request = ListSslPoliciesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = sslPoliciesClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (SslPolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListSslPoliciesRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all the SSL policies that have been configured for the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPoliciesClient sslPoliciesClient = SslPoliciesClient.create()) {
   *   String project = "";
   *   ListSslPoliciesRequest request = ListSslPoliciesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     SslPoliciesList response = sslPoliciesClient.listCallable().call(request);
   *     for (SslPolicy element : response.getItemsList()) {
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
  public final UnaryCallable<ListSslPoliciesRequest, SslPoliciesList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all features that can be specified in the SSL policy when using custom profile.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPoliciesClient sslPoliciesClient = SslPoliciesClient.create()) {
   *   String project = "";
   *   SslPoliciesListAvailableFeaturesResponse response = sslPoliciesClient.listAvailableFeatures(project);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SslPoliciesListAvailableFeaturesResponse listAvailableFeatures(String project) {
    ListAvailableFeaturesSslPoliciesRequest request =
        ListAvailableFeaturesSslPoliciesRequest.newBuilder().setProject(project).build();
    return listAvailableFeatures(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all features that can be specified in the SSL policy when using custom profile.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPoliciesClient sslPoliciesClient = SslPoliciesClient.create()) {
   *   String project = "";
   *   ListAvailableFeaturesSslPoliciesRequest request = ListAvailableFeaturesSslPoliciesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   SslPoliciesListAvailableFeaturesResponse response = sslPoliciesClient.listAvailableFeatures(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SslPoliciesListAvailableFeaturesResponse listAvailableFeatures(
      ListAvailableFeaturesSslPoliciesRequest request) {
    return listAvailableFeaturesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all features that can be specified in the SSL policy when using custom profile.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPoliciesClient sslPoliciesClient = SslPoliciesClient.create()) {
   *   String project = "";
   *   ListAvailableFeaturesSslPoliciesRequest request = ListAvailableFeaturesSslPoliciesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;SslPoliciesListAvailableFeaturesResponse&gt; future = sslPoliciesClient.listAvailableFeaturesCallable().futureCall(request);
   *   // Do something
   *   SslPoliciesListAvailableFeaturesResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<
          ListAvailableFeaturesSslPoliciesRequest, SslPoliciesListAvailableFeaturesResponse>
      listAvailableFeaturesCallable() {
    return stub.listAvailableFeaturesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified SSL policy with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPoliciesClient sslPoliciesClient = SslPoliciesClient.create()) {
   *   String project = "";
   *   String sslPolicy = "";
   *   SslPolicy sslPolicyResource = SslPolicy.newBuilder().build();
   *   Operation response = sslPoliciesClient.patch(project, sslPolicy, sslPolicyResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param sslPolicy Name of the SSL policy to update. The name must be 1-63 characters long, and
   *     comply with RFC1035.
   * @param sslPolicyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(String project, String sslPolicy, SslPolicy sslPolicyResource) {
    PatchSslPolicyRequest request =
        PatchSslPolicyRequest.newBuilder()
            .setProject(project)
            .setSslPolicy(sslPolicy)
            .setSslPolicyResource(sslPolicyResource)
            .build();
    return patch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified SSL policy with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPoliciesClient sslPoliciesClient = SslPoliciesClient.create()) {
   *   String project = "";
   *   String sslPolicy = "";
   *   SslPolicy sslPolicyResource = SslPolicy.newBuilder().build();
   *   PatchSslPolicyRequest request = PatchSslPolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setSslPolicy(sslPolicy)
   *     .setSslPolicyResource(sslPolicyResource)
   *     .build();
   *   Operation response = sslPoliciesClient.patch(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(PatchSslPolicyRequest request) {
    return patchCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified SSL policy with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPoliciesClient sslPoliciesClient = SslPoliciesClient.create()) {
   *   String project = "";
   *   String sslPolicy = "";
   *   SslPolicy sslPolicyResource = SslPolicy.newBuilder().build();
   *   PatchSslPolicyRequest request = PatchSslPolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setSslPolicy(sslPolicy)
   *     .setSslPolicyResource(sslPolicyResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = sslPoliciesClient.patchCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<PatchSslPolicyRequest, Operation> patchCallable() {
    return stub.patchCallable();
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
          ListSslPoliciesRequest, SslPoliciesList, SslPolicy, ListPage, ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListSslPoliciesRequest, SslPoliciesList, SslPolicy> context,
        ApiFuture<SslPoliciesList> futureResponse) {
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
      extends AbstractPage<ListSslPoliciesRequest, SslPoliciesList, SslPolicy, ListPage> {

    private ListPage(
        PageContext<ListSslPoliciesRequest, SslPoliciesList, SslPolicy> context,
        SslPoliciesList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListSslPoliciesRequest, SslPoliciesList, SslPolicy> context,
        SslPoliciesList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListSslPoliciesRequest, SslPoliciesList, SslPolicy> context,
        ApiFuture<SslPoliciesList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSslPoliciesRequest, SslPoliciesList, SslPolicy, ListPage, ListFixedSizeCollection> {

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
