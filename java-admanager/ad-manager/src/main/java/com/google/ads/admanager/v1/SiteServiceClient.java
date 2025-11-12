/*
 * Copyright 2025 Google LLC
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

package com.google.ads.admanager.v1;

import com.google.ads.admanager.v1.stub.SiteServiceStub;
import com.google.ads.admanager.v1.stub.SiteServiceStubSettings;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for handling `Site` objects.
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
 * try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
 *   SiteName name = SiteName.of("[NETWORK_CODE]", "[SITE]");
 *   Site response = siteServiceClient.getSite(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SiteServiceClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetSite</td>
 *      <td><p> API to retrieve a `Site` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSite(GetSiteRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSite(SiteName name)
 *           <li><p> getSite(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSiteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSites</td>
 *      <td><p> API to retrieve a list of `Site` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSites(ListSitesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSites(NetworkName parent)
 *           <li><p> listSites(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSitesPagedCallable()
 *           <li><p> listSitesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSite</td>
 *      <td><p> API to create a `Site` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSite(CreateSiteRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createSite(NetworkName parent, Site site)
 *           <li><p> createSite(String parent, Site site)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSiteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreateSites</td>
 *      <td><p> API to batch create `Site` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateSites(NetworkName parent, List&lt;CreateSiteRequest&gt; requests)
 *           <li><p> batchCreateSites(String parent, List&lt;CreateSiteRequest&gt; requests)
 *           <li><p> batchCreateSites(BatchCreateSitesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateSitesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSite</td>
 *      <td><p> API to update a `Site` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSite(UpdateSiteRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateSite(Site site, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSiteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUpdateSites</td>
 *      <td><p> API to batch update `Site` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUpdateSites(NetworkName parent, List&lt;UpdateSiteRequest&gt; requests)
 *           <li><p> batchUpdateSites(String parent, List&lt;UpdateSiteRequest&gt; requests)
 *           <li><p> batchUpdateSites(BatchUpdateSitesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUpdateSitesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchDeactivateSites</td>
 *      <td><p> Deactivates a list of `Site` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchDeactivateSites(BatchDeactivateSitesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchDeactivateSites(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchDeactivateSites(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchDeactivateSitesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchSubmitSitesForApproval</td>
 *      <td><p> Submits a list of `Site` objects for approval.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchSubmitSitesForApproval(BatchSubmitSitesForApprovalRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchSubmitSitesForApproval(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchSubmitSitesForApproval(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchSubmitSitesForApprovalCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of SiteServiceSettings to
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
 * SiteServiceSettings siteServiceSettings =
 *     SiteServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SiteServiceClient siteServiceClient = SiteServiceClient.create(siteServiceSettings);
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
 * SiteServiceSettings siteServiceSettings =
 *     SiteServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SiteServiceClient siteServiceClient = SiteServiceClient.create(siteServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class SiteServiceClient implements BackgroundResource {
  private final SiteServiceSettings settings;
  private final SiteServiceStub stub;

  /** Constructs an instance of SiteServiceClient with default settings. */
  public static final SiteServiceClient create() throws IOException {
    return create(SiteServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SiteServiceClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SiteServiceClient create(SiteServiceSettings settings) throws IOException {
    return new SiteServiceClient(settings);
  }

  /**
   * Constructs an instance of SiteServiceClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(SiteServiceSettings).
   */
  public static final SiteServiceClient create(SiteServiceStub stub) {
    return new SiteServiceClient(stub);
  }

  /**
   * Constructs an instance of SiteServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected SiteServiceClient(SiteServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SiteServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected SiteServiceClient(SiteServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SiteServiceSettings getSettings() {
    return settings;
  }

  public SiteServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Site` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
   *   SiteName name = SiteName.of("[NETWORK_CODE]", "[SITE]");
   *   Site response = siteServiceClient.getSite(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Site. Format:
   *     `networks/{network_code}/sites/{site_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Site getSite(SiteName name) {
    GetSiteRequest request =
        GetSiteRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSite(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Site` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
   *   String name = SiteName.of("[NETWORK_CODE]", "[SITE]").toString();
   *   Site response = siteServiceClient.getSite(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Site. Format:
   *     `networks/{network_code}/sites/{site_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Site getSite(String name) {
    GetSiteRequest request = GetSiteRequest.newBuilder().setName(name).build();
    return getSite(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Site` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
   *   GetSiteRequest request =
   *       GetSiteRequest.newBuilder()
   *           .setName(SiteName.of("[NETWORK_CODE]", "[SITE]").toString())
   *           .build();
   *   Site response = siteServiceClient.getSite(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Site getSite(GetSiteRequest request) {
    return getSiteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Site` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
   *   GetSiteRequest request =
   *       GetSiteRequest.newBuilder()
   *           .setName(SiteName.of("[NETWORK_CODE]", "[SITE]").toString())
   *           .build();
   *   ApiFuture<Site> future = siteServiceClient.getSiteCallable().futureCall(request);
   *   // Do something.
   *   Site response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSiteRequest, Site> getSiteCallable() {
    return stub.getSiteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Site` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (Site element : siteServiceClient.listSites(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Sites. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSitesPagedResponse listSites(NetworkName parent) {
    ListSitesRequest request =
        ListSitesRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listSites(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Site` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (Site element : siteServiceClient.listSites(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Sites. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSitesPagedResponse listSites(String parent) {
    ListSitesRequest request = ListSitesRequest.newBuilder().setParent(parent).build();
    return listSites(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Site` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
   *   ListSitesRequest request =
   *       ListSitesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (Site element : siteServiceClient.listSites(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSitesPagedResponse listSites(ListSitesRequest request) {
    return listSitesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Site` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
   *   ListSitesRequest request =
   *       ListSitesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<Site> future = siteServiceClient.listSitesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Site element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSitesRequest, ListSitesPagedResponse> listSitesPagedCallable() {
    return stub.listSitesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Site` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
   *   ListSitesRequest request =
   *       ListSitesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListSitesResponse response = siteServiceClient.listSitesCallable().call(request);
   *     for (Site element : response.getSitesList()) {
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
  public final UnaryCallable<ListSitesRequest, ListSitesResponse> listSitesCallable() {
    return stub.listSitesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create a `Site` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   Site site = Site.newBuilder().build();
   *   Site response = siteServiceClient.createSite(parent, site);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `Site` will be created. Format:
   *     `networks/{network_code}`
   * @param site Required. The `Site` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Site createSite(NetworkName parent, Site site) {
    CreateSiteRequest request =
        CreateSiteRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSite(site)
            .build();
    return createSite(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create a `Site` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   Site site = Site.newBuilder().build();
   *   Site response = siteServiceClient.createSite(parent, site);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `Site` will be created. Format:
   *     `networks/{network_code}`
   * @param site Required. The `Site` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Site createSite(String parent, Site site) {
    CreateSiteRequest request =
        CreateSiteRequest.newBuilder().setParent(parent).setSite(site).build();
    return createSite(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create a `Site` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
   *   CreateSiteRequest request =
   *       CreateSiteRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setSite(Site.newBuilder().build())
   *           .build();
   *   Site response = siteServiceClient.createSite(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Site createSite(CreateSiteRequest request) {
    return createSiteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create a `Site` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
   *   CreateSiteRequest request =
   *       CreateSiteRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setSite(Site.newBuilder().build())
   *           .build();
   *   ApiFuture<Site> future = siteServiceClient.createSiteCallable().futureCall(request);
   *   // Do something.
   *   Site response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSiteRequest, Site> createSiteCallable() {
    return stub.createSiteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch create `Site` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<CreateSiteRequest> requests = new ArrayList<>();
   *   BatchCreateSitesResponse response = siteServiceClient.batchCreateSites(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `Sites` will be created. Format:
   *     `networks/{network_code}` The parent field in the CreateSiteRequest must match this field.
   * @param requests Required. The `Site` objects to create. A maximum of 100 objects can be created
   *     in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateSitesResponse batchCreateSites(
      NetworkName parent, List<CreateSiteRequest> requests) {
    BatchCreateSitesRequest request =
        BatchCreateSitesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchCreateSites(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch create `Site` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<CreateSiteRequest> requests = new ArrayList<>();
   *   BatchCreateSitesResponse response = siteServiceClient.batchCreateSites(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `Sites` will be created. Format:
   *     `networks/{network_code}` The parent field in the CreateSiteRequest must match this field.
   * @param requests Required. The `Site` objects to create. A maximum of 100 objects can be created
   *     in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateSitesResponse batchCreateSites(
      String parent, List<CreateSiteRequest> requests) {
    BatchCreateSitesRequest request =
        BatchCreateSitesRequest.newBuilder().setParent(parent).addAllRequests(requests).build();
    return batchCreateSites(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch create `Site` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
   *   BatchCreateSitesRequest request =
   *       BatchCreateSitesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateSiteRequest>())
   *           .build();
   *   BatchCreateSitesResponse response = siteServiceClient.batchCreateSites(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateSitesResponse batchCreateSites(BatchCreateSitesRequest request) {
    return batchCreateSitesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch create `Site` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
   *   BatchCreateSitesRequest request =
   *       BatchCreateSitesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateSiteRequest>())
   *           .build();
   *   ApiFuture<BatchCreateSitesResponse> future =
   *       siteServiceClient.batchCreateSitesCallable().futureCall(request);
   *   // Do something.
   *   BatchCreateSitesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchCreateSitesRequest, BatchCreateSitesResponse>
      batchCreateSitesCallable() {
    return stub.batchCreateSitesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to update a `Site` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
   *   Site site = Site.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Site response = siteServiceClient.updateSite(site, updateMask);
   * }
   * }</pre>
   *
   * @param site Required. The `Site` to update.
   *     <p>The `Site`'s `name` is used to identify the `Site` to update.
   * @param updateMask Required. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Site updateSite(Site site, FieldMask updateMask) {
    UpdateSiteRequest request =
        UpdateSiteRequest.newBuilder().setSite(site).setUpdateMask(updateMask).build();
    return updateSite(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to update a `Site` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
   *   UpdateSiteRequest request =
   *       UpdateSiteRequest.newBuilder()
   *           .setSite(Site.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Site response = siteServiceClient.updateSite(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Site updateSite(UpdateSiteRequest request) {
    return updateSiteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to update a `Site` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
   *   UpdateSiteRequest request =
   *       UpdateSiteRequest.newBuilder()
   *           .setSite(Site.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Site> future = siteServiceClient.updateSiteCallable().futureCall(request);
   *   // Do something.
   *   Site response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSiteRequest, Site> updateSiteCallable() {
    return stub.updateSiteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch update `Site` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<UpdateSiteRequest> requests = new ArrayList<>();
   *   BatchUpdateSitesResponse response = siteServiceClient.batchUpdateSites(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `Sites` will be updated. Format:
   *     `networks/{network_code}` The parent field in the UpdateSiteRequest must match this field.
   * @param requests Required. The `Site` objects to update. A maximum of 100 objects can be updated
   *     in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateSitesResponse batchUpdateSites(
      NetworkName parent, List<UpdateSiteRequest> requests) {
    BatchUpdateSitesRequest request =
        BatchUpdateSitesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchUpdateSites(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch update `Site` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<UpdateSiteRequest> requests = new ArrayList<>();
   *   BatchUpdateSitesResponse response = siteServiceClient.batchUpdateSites(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `Sites` will be updated. Format:
   *     `networks/{network_code}` The parent field in the UpdateSiteRequest must match this field.
   * @param requests Required. The `Site` objects to update. A maximum of 100 objects can be updated
   *     in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateSitesResponse batchUpdateSites(
      String parent, List<UpdateSiteRequest> requests) {
    BatchUpdateSitesRequest request =
        BatchUpdateSitesRequest.newBuilder().setParent(parent).addAllRequests(requests).build();
    return batchUpdateSites(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch update `Site` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
   *   BatchUpdateSitesRequest request =
   *       BatchUpdateSitesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateSiteRequest>())
   *           .build();
   *   BatchUpdateSitesResponse response = siteServiceClient.batchUpdateSites(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateSitesResponse batchUpdateSites(BatchUpdateSitesRequest request) {
    return batchUpdateSitesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch update `Site` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
   *   BatchUpdateSitesRequest request =
   *       BatchUpdateSitesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateSiteRequest>())
   *           .build();
   *   ApiFuture<BatchUpdateSitesResponse> future =
   *       siteServiceClient.batchUpdateSitesCallable().futureCall(request);
   *   // Do something.
   *   BatchUpdateSitesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchUpdateSitesRequest, BatchUpdateSitesResponse>
      batchUpdateSitesCallable() {
    return stub.batchUpdateSitesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `Site` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchDeactivateSitesResponse response = siteServiceClient.batchDeactivateSites(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `Site` objects to deactivate.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateSitesResponse batchDeactivateSites(
      NetworkName parent, List<String> names) {
    BatchDeactivateSitesRequest request =
        BatchDeactivateSitesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchDeactivateSites(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `Site` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchDeactivateSitesResponse response = siteServiceClient.batchDeactivateSites(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `Site` objects to deactivate.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateSitesResponse batchDeactivateSites(
      String parent, List<String> names) {
    BatchDeactivateSitesRequest request =
        BatchDeactivateSitesRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchDeactivateSites(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `Site` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
   *   BatchDeactivateSitesRequest request =
   *       BatchDeactivateSitesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchDeactivateSitesResponse response = siteServiceClient.batchDeactivateSites(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateSitesResponse batchDeactivateSites(
      BatchDeactivateSitesRequest request) {
    return batchDeactivateSitesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `Site` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
   *   BatchDeactivateSitesRequest request =
   *       BatchDeactivateSitesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchDeactivateSitesResponse> future =
   *       siteServiceClient.batchDeactivateSitesCallable().futureCall(request);
   *   // Do something.
   *   BatchDeactivateSitesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchDeactivateSitesRequest, BatchDeactivateSitesResponse>
      batchDeactivateSitesCallable() {
    return stub.batchDeactivateSitesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Submits a list of `Site` objects for approval.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchSubmitSitesForApprovalResponse response =
   *       siteServiceClient.batchSubmitSitesForApproval(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `Site` objects to submit for approval.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchSubmitSitesForApprovalResponse batchSubmitSitesForApproval(
      NetworkName parent, List<String> names) {
    BatchSubmitSitesForApprovalRequest request =
        BatchSubmitSitesForApprovalRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchSubmitSitesForApproval(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Submits a list of `Site` objects for approval.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchSubmitSitesForApprovalResponse response =
   *       siteServiceClient.batchSubmitSitesForApproval(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `Site` objects to submit for approval.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchSubmitSitesForApprovalResponse batchSubmitSitesForApproval(
      String parent, List<String> names) {
    BatchSubmitSitesForApprovalRequest request =
        BatchSubmitSitesForApprovalRequest.newBuilder()
            .setParent(parent)
            .addAllNames(names)
            .build();
    return batchSubmitSitesForApproval(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Submits a list of `Site` objects for approval.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
   *   BatchSubmitSitesForApprovalRequest request =
   *       BatchSubmitSitesForApprovalRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchSubmitSitesForApprovalResponse response =
   *       siteServiceClient.batchSubmitSitesForApproval(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchSubmitSitesForApprovalResponse batchSubmitSitesForApproval(
      BatchSubmitSitesForApprovalRequest request) {
    return batchSubmitSitesForApprovalCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Submits a list of `Site` objects for approval.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
   *   BatchSubmitSitesForApprovalRequest request =
   *       BatchSubmitSitesForApprovalRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchSubmitSitesForApprovalResponse> future =
   *       siteServiceClient.batchSubmitSitesForApprovalCallable().futureCall(request);
   *   // Do something.
   *   BatchSubmitSitesForApprovalResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchSubmitSitesForApprovalRequest, BatchSubmitSitesForApprovalResponse>
      batchSubmitSitesForApprovalCallable() {
    return stub.batchSubmitSitesForApprovalCallable();
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

  public static class ListSitesPagedResponse
      extends AbstractPagedListResponse<
          ListSitesRequest, ListSitesResponse, Site, ListSitesPage, ListSitesFixedSizeCollection> {

    public static ApiFuture<ListSitesPagedResponse> createAsync(
        PageContext<ListSitesRequest, ListSitesResponse, Site> context,
        ApiFuture<ListSitesResponse> futureResponse) {
      ApiFuture<ListSitesPage> futurePage =
          ListSitesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListSitesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListSitesPagedResponse(ListSitesPage page) {
      super(page, ListSitesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSitesPage
      extends AbstractPage<ListSitesRequest, ListSitesResponse, Site, ListSitesPage> {

    private ListSitesPage(
        PageContext<ListSitesRequest, ListSitesResponse, Site> context,
        ListSitesResponse response) {
      super(context, response);
    }

    private static ListSitesPage createEmptyPage() {
      return new ListSitesPage(null, null);
    }

    @Override
    protected ListSitesPage createPage(
        PageContext<ListSitesRequest, ListSitesResponse, Site> context,
        ListSitesResponse response) {
      return new ListSitesPage(context, response);
    }

    @Override
    public ApiFuture<ListSitesPage> createPageAsync(
        PageContext<ListSitesRequest, ListSitesResponse, Site> context,
        ApiFuture<ListSitesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSitesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSitesRequest, ListSitesResponse, Site, ListSitesPage, ListSitesFixedSizeCollection> {

    private ListSitesFixedSizeCollection(List<ListSitesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSitesFixedSizeCollection createEmptyCollection() {
      return new ListSitesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSitesFixedSizeCollection createCollection(
        List<ListSitesPage> pages, int collectionSize) {
      return new ListSitesFixedSizeCollection(pages, collectionSize);
    }
  }
}
