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
package com.google.cloud.asset.v1p1beta1;

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
import com.google.cloud.asset.v1p1beta1.stub.AssetServiceStub;
import com.google.cloud.asset.v1p1beta1.stub.AssetServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Asset service definition.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
 *   String scope = "";
 *   String query = "";
 *   List&lt;String&gt; assetTypes = new ArrayList&lt;&gt;();
 *   for (StandardResourceMetadata element : assetServiceClient.searchResources(scope, query, assetTypes).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the assetServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of AssetServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * AssetServiceSettings assetServiceSettings =
 *     AssetServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AssetServiceClient assetServiceClient =
 *     AssetServiceClient.create(assetServiceSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * AssetServiceSettings assetServiceSettings =
 *     AssetServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AssetServiceClient assetServiceClient =
 *     AssetServiceClient.create(assetServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class AssetServiceClient implements BackgroundResource {
  private final AssetServiceSettings settings;
  private final AssetServiceStub stub;

  /** Constructs an instance of AssetServiceClient with default settings. */
  public static final AssetServiceClient create() throws IOException {
    return create(AssetServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AssetServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AssetServiceClient create(AssetServiceSettings settings) throws IOException {
    return new AssetServiceClient(settings);
  }

  /**
   * Constructs an instance of AssetServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use AssetServiceSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final AssetServiceClient create(AssetServiceStub stub) {
    return new AssetServiceClient(stub);
  }

  /**
   * Constructs an instance of AssetServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected AssetServiceClient(AssetServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AssetServiceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected AssetServiceClient(AssetServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AssetServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public AssetServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches resources which are accessible with .get permission.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String scope = "";
   *   String query = "";
   *   List&lt;String&gt; assetTypes = new ArrayList&lt;&gt;();
   *   for (StandardResourceMetadata element : assetServiceClient.searchResources(scope, query, assetTypes).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param scope Required. The relative name of an asset. The search is limited to the resources
   *     within the `scope`. The allowed value must be: &#42; Organization number (such as
   *     "organizations/123") &#42; Folder number(such as "folders/1234") &#42; Project number (such
   *     as "projects/12345")
   * @param query Optional. The query statement.
   * @param assetTypes Optional. A list of asset types that this request searches for. If empty, it
   *     will search all the supported asset types.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchResourcesPagedResponse searchResources(
      String scope, String query, List<String> assetTypes) {
    SearchResourcesRequest request =
        SearchResourcesRequest.newBuilder()
            .setScope(scope)
            .setQuery(query)
            .addAllAssetTypes(assetTypes)
            .build();
    return searchResources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches resources which are accessible with .get permission.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String scope = "";
   *   SearchResourcesRequest request = SearchResourcesRequest.newBuilder()
   *     .setScope(scope)
   *     .build();
   *   for (StandardResourceMetadata element : assetServiceClient.searchResources(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchResourcesPagedResponse searchResources(SearchResourcesRequest request) {
    return searchResourcesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches resources which are accessible with .get permission.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String scope = "";
   *   SearchResourcesRequest request = SearchResourcesRequest.newBuilder()
   *     .setScope(scope)
   *     .build();
   *   ApiFuture&lt;SearchResourcesPagedResponse&gt; future = assetServiceClient.searchResourcesPagedCallable().futureCall(request);
   *   // Do something
   *   for (StandardResourceMetadata element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<SearchResourcesRequest, SearchResourcesPagedResponse>
      searchResourcesPagedCallable() {
    return stub.searchResourcesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches resources which are accessible with .get permission.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String scope = "";
   *   SearchResourcesRequest request = SearchResourcesRequest.newBuilder()
   *     .setScope(scope)
   *     .build();
   *   while (true) {
   *     SearchResourcesResponse response = assetServiceClient.searchResourcesCallable().call(request);
   *     for (StandardResourceMetadata element : response.getResultsList()) {
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
  public final UnaryCallable<SearchResourcesRequest, SearchResourcesResponse>
      searchResourcesCallable() {
    return stub.searchResourcesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches IAM policies which are accessible with .getIamPolicy permission.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String scope = "";
   *   String query = "";
   *   for (IamPolicySearchResult element : assetServiceClient.searchIamPolicies(scope, query).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param scope Required. The relative name of an asset. The search is limited to the resources
   *     within the `scope`. The allowed value must be: &#42; Organization number (such as
   *     "organizations/123") &#42; Folder number(such as "folders/1234") &#42; Project number (such
   *     as "projects/12345")
   * @param query Optional. The query statement. Examples: &#42;
   *     "policy:myuser{@literal @}mydomain.com" &#42; "policy:(myuser{@literal @}mydomain.com
   *     viewer)"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchIamPoliciesPagedResponse searchIamPolicies(String scope, String query) {
    SearchIamPoliciesRequest request =
        SearchIamPoliciesRequest.newBuilder().setScope(scope).setQuery(query).build();
    return searchIamPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches IAM policies which are accessible with .getIamPolicy permission.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String scope = "";
   *   SearchIamPoliciesRequest request = SearchIamPoliciesRequest.newBuilder()
   *     .setScope(scope)
   *     .build();
   *   for (IamPolicySearchResult element : assetServiceClient.searchIamPolicies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchIamPoliciesPagedResponse searchIamPolicies(SearchIamPoliciesRequest request) {
    return searchIamPoliciesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches IAM policies which are accessible with .getIamPolicy permission.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String scope = "";
   *   SearchIamPoliciesRequest request = SearchIamPoliciesRequest.newBuilder()
   *     .setScope(scope)
   *     .build();
   *   ApiFuture&lt;SearchIamPoliciesPagedResponse&gt; future = assetServiceClient.searchIamPoliciesPagedCallable().futureCall(request);
   *   // Do something
   *   for (IamPolicySearchResult element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<SearchIamPoliciesRequest, SearchIamPoliciesPagedResponse>
      searchIamPoliciesPagedCallable() {
    return stub.searchIamPoliciesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches IAM policies which are accessible with .getIamPolicy permission.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String scope = "";
   *   SearchIamPoliciesRequest request = SearchIamPoliciesRequest.newBuilder()
   *     .setScope(scope)
   *     .build();
   *   while (true) {
   *     SearchIamPoliciesResponse response = assetServiceClient.searchIamPoliciesCallable().call(request);
   *     for (IamPolicySearchResult element : response.getResultsList()) {
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
  public final UnaryCallable<SearchIamPoliciesRequest, SearchIamPoliciesResponse>
      searchIamPoliciesCallable() {
    return stub.searchIamPoliciesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches all the resources under a given accessible CRM scope (project/folder/organization).
   * This RPC gives callers especially admins the ability to search all the resources under a scope,
   * even if they don't have .get permission of all the resources. Callers should have
   * cloud.assets.SearchAllResources permission on the requested scope, otherwise it will be
   * rejected.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String scope = "";
   *   String query = "";
   *   List&lt;String&gt; assetTypes = new ArrayList&lt;&gt;();
   *   for (StandardResourceMetadata element : assetServiceClient.searchAllResources(scope, query, assetTypes).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param scope Required. The relative name of an asset. The search is limited to the resources
   *     within the `scope`. The allowed value must be: &#42; Organization number (such as
   *     "organizations/123") &#42; Folder number(such as "folders/1234") &#42; Project number (such
   *     as "projects/12345")
   * @param query Optional. The query statement.
   * @param assetTypes Optional. A list of asset types that this request searches for. If empty, it
   *     will search all the supported asset types.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAllResourcesPagedResponse searchAllResources(
      String scope, String query, List<String> assetTypes) {
    SearchAllResourcesRequest request =
        SearchAllResourcesRequest.newBuilder()
            .setScope(scope)
            .setQuery(query)
            .addAllAssetTypes(assetTypes)
            .build();
    return searchAllResources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches all the resources under a given accessible CRM scope (project/folder/organization).
   * This RPC gives callers especially admins the ability to search all the resources under a scope,
   * even if they don't have .get permission of all the resources. Callers should have
   * cloud.assets.SearchAllResources permission on the requested scope, otherwise it will be
   * rejected.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String scope = "";
   *   SearchAllResourcesRequest request = SearchAllResourcesRequest.newBuilder()
   *     .setScope(scope)
   *     .build();
   *   for (StandardResourceMetadata element : assetServiceClient.searchAllResources(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAllResourcesPagedResponse searchAllResources(
      SearchAllResourcesRequest request) {
    return searchAllResourcesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches all the resources under a given accessible CRM scope (project/folder/organization).
   * This RPC gives callers especially admins the ability to search all the resources under a scope,
   * even if they don't have .get permission of all the resources. Callers should have
   * cloud.assets.SearchAllResources permission on the requested scope, otherwise it will be
   * rejected.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String scope = "";
   *   SearchAllResourcesRequest request = SearchAllResourcesRequest.newBuilder()
   *     .setScope(scope)
   *     .build();
   *   ApiFuture&lt;SearchAllResourcesPagedResponse&gt; future = assetServiceClient.searchAllResourcesPagedCallable().futureCall(request);
   *   // Do something
   *   for (StandardResourceMetadata element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<SearchAllResourcesRequest, SearchAllResourcesPagedResponse>
      searchAllResourcesPagedCallable() {
    return stub.searchAllResourcesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches all the resources under a given accessible CRM scope (project/folder/organization).
   * This RPC gives callers especially admins the ability to search all the resources under a scope,
   * even if they don't have .get permission of all the resources. Callers should have
   * cloud.assets.SearchAllResources permission on the requested scope, otherwise it will be
   * rejected.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String scope = "";
   *   SearchAllResourcesRequest request = SearchAllResourcesRequest.newBuilder()
   *     .setScope(scope)
   *     .build();
   *   while (true) {
   *     SearchAllResourcesResponse response = assetServiceClient.searchAllResourcesCallable().call(request);
   *     for (StandardResourceMetadata element : response.getResultsList()) {
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
  public final UnaryCallable<SearchAllResourcesRequest, SearchAllResourcesResponse>
      searchAllResourcesCallable() {
    return stub.searchAllResourcesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches all the IAM policies under a given accessible CRM scope (project/folder/organization).
   * This RPC gives callers especially admins the ability to search all the IAM policies under a
   * scope, even if they don't have .getIamPolicy permission of all the IAM policies. Callers should
   * have cloud.assets.SearchAllIamPolicies permission on the requested scope, otherwise it will be
   * rejected.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String scope = "";
   *   String query = "";
   *   for (IamPolicySearchResult element : assetServiceClient.searchAllIamPolicies(scope, query).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param scope Required. The relative name of an asset. The search is limited to the resources
   *     within the `scope`. The allowed value must be: &#42; Organization number (such as
   *     "organizations/123") &#42; Folder number(such as "folders/1234") &#42; Project number (such
   *     as "projects/12345")
   * @param query Optional. The query statement. Examples: &#42;
   *     "policy:myuser{@literal @}mydomain.com" &#42; "policy:(myuser{@literal @}mydomain.com
   *     viewer)"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAllIamPoliciesPagedResponse searchAllIamPolicies(String scope, String query) {
    SearchAllIamPoliciesRequest request =
        SearchAllIamPoliciesRequest.newBuilder().setScope(scope).setQuery(query).build();
    return searchAllIamPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches all the IAM policies under a given accessible CRM scope (project/folder/organization).
   * This RPC gives callers especially admins the ability to search all the IAM policies under a
   * scope, even if they don't have .getIamPolicy permission of all the IAM policies. Callers should
   * have cloud.assets.SearchAllIamPolicies permission on the requested scope, otherwise it will be
   * rejected.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String scope = "";
   *   SearchAllIamPoliciesRequest request = SearchAllIamPoliciesRequest.newBuilder()
   *     .setScope(scope)
   *     .build();
   *   for (IamPolicySearchResult element : assetServiceClient.searchAllIamPolicies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAllIamPoliciesPagedResponse searchAllIamPolicies(
      SearchAllIamPoliciesRequest request) {
    return searchAllIamPoliciesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches all the IAM policies under a given accessible CRM scope (project/folder/organization).
   * This RPC gives callers especially admins the ability to search all the IAM policies under a
   * scope, even if they don't have .getIamPolicy permission of all the IAM policies. Callers should
   * have cloud.assets.SearchAllIamPolicies permission on the requested scope, otherwise it will be
   * rejected.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String scope = "";
   *   SearchAllIamPoliciesRequest request = SearchAllIamPoliciesRequest.newBuilder()
   *     .setScope(scope)
   *     .build();
   *   ApiFuture&lt;SearchAllIamPoliciesPagedResponse&gt; future = assetServiceClient.searchAllIamPoliciesPagedCallable().futureCall(request);
   *   // Do something
   *   for (IamPolicySearchResult element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<SearchAllIamPoliciesRequest, SearchAllIamPoliciesPagedResponse>
      searchAllIamPoliciesPagedCallable() {
    return stub.searchAllIamPoliciesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches all the IAM policies under a given accessible CRM scope (project/folder/organization).
   * This RPC gives callers especially admins the ability to search all the IAM policies under a
   * scope, even if they don't have .getIamPolicy permission of all the IAM policies. Callers should
   * have cloud.assets.SearchAllIamPolicies permission on the requested scope, otherwise it will be
   * rejected.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String scope = "";
   *   SearchAllIamPoliciesRequest request = SearchAllIamPoliciesRequest.newBuilder()
   *     .setScope(scope)
   *     .build();
   *   while (true) {
   *     SearchAllIamPoliciesResponse response = assetServiceClient.searchAllIamPoliciesCallable().call(request);
   *     for (IamPolicySearchResult element : response.getResultsList()) {
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
  public final UnaryCallable<SearchAllIamPoliciesRequest, SearchAllIamPoliciesResponse>
      searchAllIamPoliciesCallable() {
    return stub.searchAllIamPoliciesCallable();
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

  public static class SearchResourcesPagedResponse
      extends AbstractPagedListResponse<
          SearchResourcesRequest,
          SearchResourcesResponse,
          StandardResourceMetadata,
          SearchResourcesPage,
          SearchResourcesFixedSizeCollection> {

    public static ApiFuture<SearchResourcesPagedResponse> createAsync(
        PageContext<SearchResourcesRequest, SearchResourcesResponse, StandardResourceMetadata>
            context,
        ApiFuture<SearchResourcesResponse> futureResponse) {
      ApiFuture<SearchResourcesPage> futurePage =
          SearchResourcesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<SearchResourcesPage, SearchResourcesPagedResponse>() {
            @Override
            public SearchResourcesPagedResponse apply(SearchResourcesPage input) {
              return new SearchResourcesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private SearchResourcesPagedResponse(SearchResourcesPage page) {
      super(page, SearchResourcesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchResourcesPage
      extends AbstractPage<
          SearchResourcesRequest,
          SearchResourcesResponse,
          StandardResourceMetadata,
          SearchResourcesPage> {

    private SearchResourcesPage(
        PageContext<SearchResourcesRequest, SearchResourcesResponse, StandardResourceMetadata>
            context,
        SearchResourcesResponse response) {
      super(context, response);
    }

    private static SearchResourcesPage createEmptyPage() {
      return new SearchResourcesPage(null, null);
    }

    @Override
    protected SearchResourcesPage createPage(
        PageContext<SearchResourcesRequest, SearchResourcesResponse, StandardResourceMetadata>
            context,
        SearchResourcesResponse response) {
      return new SearchResourcesPage(context, response);
    }

    @Override
    public ApiFuture<SearchResourcesPage> createPageAsync(
        PageContext<SearchResourcesRequest, SearchResourcesResponse, StandardResourceMetadata>
            context,
        ApiFuture<SearchResourcesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchResourcesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchResourcesRequest,
          SearchResourcesResponse,
          StandardResourceMetadata,
          SearchResourcesPage,
          SearchResourcesFixedSizeCollection> {

    private SearchResourcesFixedSizeCollection(
        List<SearchResourcesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchResourcesFixedSizeCollection createEmptyCollection() {
      return new SearchResourcesFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchResourcesFixedSizeCollection createCollection(
        List<SearchResourcesPage> pages, int collectionSize) {
      return new SearchResourcesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchIamPoliciesPagedResponse
      extends AbstractPagedListResponse<
          SearchIamPoliciesRequest,
          SearchIamPoliciesResponse,
          IamPolicySearchResult,
          SearchIamPoliciesPage,
          SearchIamPoliciesFixedSizeCollection> {

    public static ApiFuture<SearchIamPoliciesPagedResponse> createAsync(
        PageContext<SearchIamPoliciesRequest, SearchIamPoliciesResponse, IamPolicySearchResult>
            context,
        ApiFuture<SearchIamPoliciesResponse> futureResponse) {
      ApiFuture<SearchIamPoliciesPage> futurePage =
          SearchIamPoliciesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<SearchIamPoliciesPage, SearchIamPoliciesPagedResponse>() {
            @Override
            public SearchIamPoliciesPagedResponse apply(SearchIamPoliciesPage input) {
              return new SearchIamPoliciesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private SearchIamPoliciesPagedResponse(SearchIamPoliciesPage page) {
      super(page, SearchIamPoliciesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchIamPoliciesPage
      extends AbstractPage<
          SearchIamPoliciesRequest,
          SearchIamPoliciesResponse,
          IamPolicySearchResult,
          SearchIamPoliciesPage> {

    private SearchIamPoliciesPage(
        PageContext<SearchIamPoliciesRequest, SearchIamPoliciesResponse, IamPolicySearchResult>
            context,
        SearchIamPoliciesResponse response) {
      super(context, response);
    }

    private static SearchIamPoliciesPage createEmptyPage() {
      return new SearchIamPoliciesPage(null, null);
    }

    @Override
    protected SearchIamPoliciesPage createPage(
        PageContext<SearchIamPoliciesRequest, SearchIamPoliciesResponse, IamPolicySearchResult>
            context,
        SearchIamPoliciesResponse response) {
      return new SearchIamPoliciesPage(context, response);
    }

    @Override
    public ApiFuture<SearchIamPoliciesPage> createPageAsync(
        PageContext<SearchIamPoliciesRequest, SearchIamPoliciesResponse, IamPolicySearchResult>
            context,
        ApiFuture<SearchIamPoliciesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchIamPoliciesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchIamPoliciesRequest,
          SearchIamPoliciesResponse,
          IamPolicySearchResult,
          SearchIamPoliciesPage,
          SearchIamPoliciesFixedSizeCollection> {

    private SearchIamPoliciesFixedSizeCollection(
        List<SearchIamPoliciesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchIamPoliciesFixedSizeCollection createEmptyCollection() {
      return new SearchIamPoliciesFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchIamPoliciesFixedSizeCollection createCollection(
        List<SearchIamPoliciesPage> pages, int collectionSize) {
      return new SearchIamPoliciesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchAllResourcesPagedResponse
      extends AbstractPagedListResponse<
          SearchAllResourcesRequest,
          SearchAllResourcesResponse,
          StandardResourceMetadata,
          SearchAllResourcesPage,
          SearchAllResourcesFixedSizeCollection> {

    public static ApiFuture<SearchAllResourcesPagedResponse> createAsync(
        PageContext<SearchAllResourcesRequest, SearchAllResourcesResponse, StandardResourceMetadata>
            context,
        ApiFuture<SearchAllResourcesResponse> futureResponse) {
      ApiFuture<SearchAllResourcesPage> futurePage =
          SearchAllResourcesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<SearchAllResourcesPage, SearchAllResourcesPagedResponse>() {
            @Override
            public SearchAllResourcesPagedResponse apply(SearchAllResourcesPage input) {
              return new SearchAllResourcesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private SearchAllResourcesPagedResponse(SearchAllResourcesPage page) {
      super(page, SearchAllResourcesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchAllResourcesPage
      extends AbstractPage<
          SearchAllResourcesRequest,
          SearchAllResourcesResponse,
          StandardResourceMetadata,
          SearchAllResourcesPage> {

    private SearchAllResourcesPage(
        PageContext<SearchAllResourcesRequest, SearchAllResourcesResponse, StandardResourceMetadata>
            context,
        SearchAllResourcesResponse response) {
      super(context, response);
    }

    private static SearchAllResourcesPage createEmptyPage() {
      return new SearchAllResourcesPage(null, null);
    }

    @Override
    protected SearchAllResourcesPage createPage(
        PageContext<SearchAllResourcesRequest, SearchAllResourcesResponse, StandardResourceMetadata>
            context,
        SearchAllResourcesResponse response) {
      return new SearchAllResourcesPage(context, response);
    }

    @Override
    public ApiFuture<SearchAllResourcesPage> createPageAsync(
        PageContext<SearchAllResourcesRequest, SearchAllResourcesResponse, StandardResourceMetadata>
            context,
        ApiFuture<SearchAllResourcesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchAllResourcesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchAllResourcesRequest,
          SearchAllResourcesResponse,
          StandardResourceMetadata,
          SearchAllResourcesPage,
          SearchAllResourcesFixedSizeCollection> {

    private SearchAllResourcesFixedSizeCollection(
        List<SearchAllResourcesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchAllResourcesFixedSizeCollection createEmptyCollection() {
      return new SearchAllResourcesFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchAllResourcesFixedSizeCollection createCollection(
        List<SearchAllResourcesPage> pages, int collectionSize) {
      return new SearchAllResourcesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchAllIamPoliciesPagedResponse
      extends AbstractPagedListResponse<
          SearchAllIamPoliciesRequest,
          SearchAllIamPoliciesResponse,
          IamPolicySearchResult,
          SearchAllIamPoliciesPage,
          SearchAllIamPoliciesFixedSizeCollection> {

    public static ApiFuture<SearchAllIamPoliciesPagedResponse> createAsync(
        PageContext<
                SearchAllIamPoliciesRequest, SearchAllIamPoliciesResponse, IamPolicySearchResult>
            context,
        ApiFuture<SearchAllIamPoliciesResponse> futureResponse) {
      ApiFuture<SearchAllIamPoliciesPage> futurePage =
          SearchAllIamPoliciesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<SearchAllIamPoliciesPage, SearchAllIamPoliciesPagedResponse>() {
            @Override
            public SearchAllIamPoliciesPagedResponse apply(SearchAllIamPoliciesPage input) {
              return new SearchAllIamPoliciesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private SearchAllIamPoliciesPagedResponse(SearchAllIamPoliciesPage page) {
      super(page, SearchAllIamPoliciesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchAllIamPoliciesPage
      extends AbstractPage<
          SearchAllIamPoliciesRequest,
          SearchAllIamPoliciesResponse,
          IamPolicySearchResult,
          SearchAllIamPoliciesPage> {

    private SearchAllIamPoliciesPage(
        PageContext<
                SearchAllIamPoliciesRequest, SearchAllIamPoliciesResponse, IamPolicySearchResult>
            context,
        SearchAllIamPoliciesResponse response) {
      super(context, response);
    }

    private static SearchAllIamPoliciesPage createEmptyPage() {
      return new SearchAllIamPoliciesPage(null, null);
    }

    @Override
    protected SearchAllIamPoliciesPage createPage(
        PageContext<
                SearchAllIamPoliciesRequest, SearchAllIamPoliciesResponse, IamPolicySearchResult>
            context,
        SearchAllIamPoliciesResponse response) {
      return new SearchAllIamPoliciesPage(context, response);
    }

    @Override
    public ApiFuture<SearchAllIamPoliciesPage> createPageAsync(
        PageContext<
                SearchAllIamPoliciesRequest, SearchAllIamPoliciesResponse, IamPolicySearchResult>
            context,
        ApiFuture<SearchAllIamPoliciesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchAllIamPoliciesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchAllIamPoliciesRequest,
          SearchAllIamPoliciesResponse,
          IamPolicySearchResult,
          SearchAllIamPoliciesPage,
          SearchAllIamPoliciesFixedSizeCollection> {

    private SearchAllIamPoliciesFixedSizeCollection(
        List<SearchAllIamPoliciesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchAllIamPoliciesFixedSizeCollection createEmptyCollection() {
      return new SearchAllIamPoliciesFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchAllIamPoliciesFixedSizeCollection createCollection(
        List<SearchAllIamPoliciesPage> pages, int collectionSize) {
      return new SearchAllIamPoliciesFixedSizeCollection(pages, collectionSize);
    }
  }
}
