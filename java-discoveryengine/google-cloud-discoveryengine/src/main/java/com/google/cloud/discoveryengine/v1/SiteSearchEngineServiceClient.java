/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.discoveryengine.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1.stub.SiteSearchEngineServiceStub;
import com.google.cloud.discoveryengine.v1.stub.SiteSearchEngineServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing site search related resources.
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
 * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
 *     SiteSearchEngineServiceClient.create()) {
 *   SiteSearchEngineName name =
 *       SiteSearchEngineName.ofProjectLocationDataStoreName(
 *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]");
 *   SiteSearchEngine response = siteSearchEngineServiceClient.getSiteSearchEngine(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SiteSearchEngineServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetSiteSearchEngine</td>
 *      <td><p> Gets the [SiteSearchEngine][google.cloud.discoveryengine.v1.SiteSearchEngine].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSiteSearchEngine(GetSiteSearchEngineRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSiteSearchEngine(SiteSearchEngineName name)
 *           <li><p> getSiteSearchEngine(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSiteSearchEngineCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateTargetSite</td>
 *      <td><p> Creates a [TargetSite][google.cloud.discoveryengine.v1.TargetSite].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createTargetSiteAsync(CreateTargetSiteRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createTargetSiteAsync(SiteSearchEngineName parent, TargetSite targetSite)
 *           <li><p> createTargetSiteAsync(String parent, TargetSite targetSite)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createTargetSiteOperationCallable()
 *           <li><p> createTargetSiteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreateTargetSites</td>
 *      <td><p> Creates [TargetSite][google.cloud.discoveryengine.v1.TargetSite] in a batch.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateTargetSitesAsync(BatchCreateTargetSitesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateTargetSitesOperationCallable()
 *           <li><p> batchCreateTargetSitesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetTargetSite</td>
 *      <td><p> Gets a [TargetSite][google.cloud.discoveryengine.v1.TargetSite].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getTargetSite(GetTargetSiteRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getTargetSite(TargetSiteName name)
 *           <li><p> getTargetSite(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getTargetSiteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateTargetSite</td>
 *      <td><p> Updates a [TargetSite][google.cloud.discoveryengine.v1.TargetSite].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateTargetSiteAsync(UpdateTargetSiteRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateTargetSiteAsync(TargetSite targetSite)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateTargetSiteOperationCallable()
 *           <li><p> updateTargetSiteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteTargetSite</td>
 *      <td><p> Deletes a [TargetSite][google.cloud.discoveryengine.v1.TargetSite].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteTargetSiteAsync(DeleteTargetSiteRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteTargetSiteAsync(TargetSiteName name)
 *           <li><p> deleteTargetSiteAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteTargetSiteOperationCallable()
 *           <li><p> deleteTargetSiteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListTargetSites</td>
 *      <td><p> Gets a list of [TargetSite][google.cloud.discoveryengine.v1.TargetSite]s.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listTargetSites(ListTargetSitesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listTargetSites(SiteSearchEngineName parent)
 *           <li><p> listTargetSites(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listTargetSitesPagedCallable()
 *           <li><p> listTargetSitesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> EnableAdvancedSiteSearch</td>
 *      <td><p> Upgrade from basic site search to advanced site search.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> enableAdvancedSiteSearchAsync(EnableAdvancedSiteSearchRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> enableAdvancedSiteSearchOperationCallable()
 *           <li><p> enableAdvancedSiteSearchCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DisableAdvancedSiteSearch</td>
 *      <td><p> Downgrade from advanced site search to basic site search.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> disableAdvancedSiteSearchAsync(DisableAdvancedSiteSearchRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> disableAdvancedSiteSearchOperationCallable()
 *           <li><p> disableAdvancedSiteSearchCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RecrawlUris</td>
 *      <td><p> Request on-demand recrawl for a list of URIs.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> recrawlUrisAsync(RecrawlUrisRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> recrawlUrisOperationCallable()
 *           <li><p> recrawlUrisCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchVerifyTargetSites</td>
 *      <td><p> Verify target sites' ownership and validity. This API sends all the target sites under site search engine for verification.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchVerifyTargetSitesAsync(BatchVerifyTargetSitesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchVerifyTargetSitesOperationCallable()
 *           <li><p> batchVerifyTargetSitesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FetchDomainVerificationStatus</td>
 *      <td><p> Returns list of target sites with its domain verification status. This method can only be called under data store with BASIC_SITE_SEARCH state at the moment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchDomainVerificationStatus(FetchDomainVerificationStatusRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchDomainVerificationStatusPagedCallable()
 *           <li><p> fetchDomainVerificationStatusCallable()
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
 * <p>This class can be customized by passing in a custom instance of
 * SiteSearchEngineServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SiteSearchEngineServiceSettings siteSearchEngineServiceSettings =
 *     SiteSearchEngineServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SiteSearchEngineServiceClient siteSearchEngineServiceClient =
 *     SiteSearchEngineServiceClient.create(siteSearchEngineServiceSettings);
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
 * SiteSearchEngineServiceSettings siteSearchEngineServiceSettings =
 *     SiteSearchEngineServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SiteSearchEngineServiceClient siteSearchEngineServiceClient =
 *     SiteSearchEngineServiceClient.create(siteSearchEngineServiceSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SiteSearchEngineServiceSettings siteSearchEngineServiceSettings =
 *     SiteSearchEngineServiceSettings.newHttpJsonBuilder().build();
 * SiteSearchEngineServiceClient siteSearchEngineServiceClient =
 *     SiteSearchEngineServiceClient.create(siteSearchEngineServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class SiteSearchEngineServiceClient implements BackgroundResource {
  private final SiteSearchEngineServiceSettings settings;
  private final SiteSearchEngineServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of SiteSearchEngineServiceClient with default settings. */
  public static final SiteSearchEngineServiceClient create() throws IOException {
    return create(SiteSearchEngineServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SiteSearchEngineServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SiteSearchEngineServiceClient create(SiteSearchEngineServiceSettings settings)
      throws IOException {
    return new SiteSearchEngineServiceClient(settings);
  }

  /**
   * Constructs an instance of SiteSearchEngineServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(SiteSearchEngineServiceSettings).
   */
  public static final SiteSearchEngineServiceClient create(SiteSearchEngineServiceStub stub) {
    return new SiteSearchEngineServiceClient(stub);
  }

  /**
   * Constructs an instance of SiteSearchEngineServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected SiteSearchEngineServiceClient(SiteSearchEngineServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((SiteSearchEngineServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected SiteSearchEngineServiceClient(SiteSearchEngineServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final SiteSearchEngineServiceSettings getSettings() {
    return settings;
  }

  public SiteSearchEngineServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the [SiteSearchEngine][google.cloud.discoveryengine.v1.SiteSearchEngine].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   SiteSearchEngineName name =
   *       SiteSearchEngineName.ofProjectLocationDataStoreName(
   *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]");
   *   SiteSearchEngine response = siteSearchEngineServiceClient.getSiteSearchEngine(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of
   *     [SiteSearchEngine][google.cloud.discoveryengine.v1.SiteSearchEngine], such as
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/siteSearchEngine`.
   *     <p>If the caller does not have permission to access the [SiteSearchEngine], regardless of
   *     whether or not it exists, a PERMISSION_DENIED error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SiteSearchEngine getSiteSearchEngine(SiteSearchEngineName name) {
    GetSiteSearchEngineRequest request =
        GetSiteSearchEngineRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getSiteSearchEngine(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the [SiteSearchEngine][google.cloud.discoveryengine.v1.SiteSearchEngine].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   String name =
   *       SiteSearchEngineName.ofProjectLocationDataStoreName(
   *               "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *           .toString();
   *   SiteSearchEngine response = siteSearchEngineServiceClient.getSiteSearchEngine(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of
   *     [SiteSearchEngine][google.cloud.discoveryengine.v1.SiteSearchEngine], such as
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/siteSearchEngine`.
   *     <p>If the caller does not have permission to access the [SiteSearchEngine], regardless of
   *     whether or not it exists, a PERMISSION_DENIED error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SiteSearchEngine getSiteSearchEngine(String name) {
    GetSiteSearchEngineRequest request =
        GetSiteSearchEngineRequest.newBuilder().setName(name).build();
    return getSiteSearchEngine(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the [SiteSearchEngine][google.cloud.discoveryengine.v1.SiteSearchEngine].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   GetSiteSearchEngineRequest request =
   *       GetSiteSearchEngineRequest.newBuilder()
   *           .setName(
   *               SiteSearchEngineName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .build();
   *   SiteSearchEngine response = siteSearchEngineServiceClient.getSiteSearchEngine(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SiteSearchEngine getSiteSearchEngine(GetSiteSearchEngineRequest request) {
    return getSiteSearchEngineCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the [SiteSearchEngine][google.cloud.discoveryengine.v1.SiteSearchEngine].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   GetSiteSearchEngineRequest request =
   *       GetSiteSearchEngineRequest.newBuilder()
   *           .setName(
   *               SiteSearchEngineName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<SiteSearchEngine> future =
   *       siteSearchEngineServiceClient.getSiteSearchEngineCallable().futureCall(request);
   *   // Do something.
   *   SiteSearchEngine response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSiteSearchEngineRequest, SiteSearchEngine>
      getSiteSearchEngineCallable() {
    return stub.getSiteSearchEngineCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [TargetSite][google.cloud.discoveryengine.v1.TargetSite].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   SiteSearchEngineName parent =
   *       SiteSearchEngineName.ofProjectLocationDataStoreName(
   *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]");
   *   TargetSite targetSite = TargetSite.newBuilder().build();
   *   TargetSite response =
   *       siteSearchEngineServiceClient.createTargetSiteAsync(parent, targetSite).get();
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name of
   *     [TargetSite][google.cloud.discoveryengine.v1.TargetSite], such as
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/siteSearchEngine`.
   * @param targetSite Required. The [TargetSite][google.cloud.discoveryengine.v1.TargetSite] to
   *     create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TargetSite, CreateTargetSiteMetadata> createTargetSiteAsync(
      SiteSearchEngineName parent, TargetSite targetSite) {
    CreateTargetSiteRequest request =
        CreateTargetSiteRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTargetSite(targetSite)
            .build();
    return createTargetSiteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [TargetSite][google.cloud.discoveryengine.v1.TargetSite].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   String parent =
   *       SiteSearchEngineName.ofProjectLocationDataStoreName(
   *               "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *           .toString();
   *   TargetSite targetSite = TargetSite.newBuilder().build();
   *   TargetSite response =
   *       siteSearchEngineServiceClient.createTargetSiteAsync(parent, targetSite).get();
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name of
   *     [TargetSite][google.cloud.discoveryengine.v1.TargetSite], such as
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/siteSearchEngine`.
   * @param targetSite Required. The [TargetSite][google.cloud.discoveryengine.v1.TargetSite] to
   *     create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TargetSite, CreateTargetSiteMetadata> createTargetSiteAsync(
      String parent, TargetSite targetSite) {
    CreateTargetSiteRequest request =
        CreateTargetSiteRequest.newBuilder().setParent(parent).setTargetSite(targetSite).build();
    return createTargetSiteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [TargetSite][google.cloud.discoveryengine.v1.TargetSite].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   CreateTargetSiteRequest request =
   *       CreateTargetSiteRequest.newBuilder()
   *           .setParent(
   *               SiteSearchEngineName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .setTargetSite(TargetSite.newBuilder().build())
   *           .build();
   *   TargetSite response = siteSearchEngineServiceClient.createTargetSiteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TargetSite, CreateTargetSiteMetadata> createTargetSiteAsync(
      CreateTargetSiteRequest request) {
    return createTargetSiteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [TargetSite][google.cloud.discoveryengine.v1.TargetSite].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   CreateTargetSiteRequest request =
   *       CreateTargetSiteRequest.newBuilder()
   *           .setParent(
   *               SiteSearchEngineName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .setTargetSite(TargetSite.newBuilder().build())
   *           .build();
   *   OperationFuture<TargetSite, CreateTargetSiteMetadata> future =
   *       siteSearchEngineServiceClient.createTargetSiteOperationCallable().futureCall(request);
   *   // Do something.
   *   TargetSite response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateTargetSiteRequest, TargetSite, CreateTargetSiteMetadata>
      createTargetSiteOperationCallable() {
    return stub.createTargetSiteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [TargetSite][google.cloud.discoveryengine.v1.TargetSite].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   CreateTargetSiteRequest request =
   *       CreateTargetSiteRequest.newBuilder()
   *           .setParent(
   *               SiteSearchEngineName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .setTargetSite(TargetSite.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       siteSearchEngineServiceClient.createTargetSiteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTargetSiteRequest, Operation> createTargetSiteCallable() {
    return stub.createTargetSiteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates [TargetSite][google.cloud.discoveryengine.v1.TargetSite] in a batch.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   BatchCreateTargetSitesRequest request =
   *       BatchCreateTargetSitesRequest.newBuilder()
   *           .setParent(
   *               SiteSearchEngineName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .addAllRequests(new ArrayList<CreateTargetSiteRequest>())
   *           .build();
   *   BatchCreateTargetSitesResponse response =
   *       siteSearchEngineServiceClient.batchCreateTargetSitesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchCreateTargetSitesResponse, BatchCreateTargetSiteMetadata>
      batchCreateTargetSitesAsync(BatchCreateTargetSitesRequest request) {
    return batchCreateTargetSitesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates [TargetSite][google.cloud.discoveryengine.v1.TargetSite] in a batch.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   BatchCreateTargetSitesRequest request =
   *       BatchCreateTargetSitesRequest.newBuilder()
   *           .setParent(
   *               SiteSearchEngineName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .addAllRequests(new ArrayList<CreateTargetSiteRequest>())
   *           .build();
   *   OperationFuture<BatchCreateTargetSitesResponse, BatchCreateTargetSiteMetadata> future =
   *       siteSearchEngineServiceClient
   *           .batchCreateTargetSitesOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchCreateTargetSitesResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          BatchCreateTargetSitesRequest,
          BatchCreateTargetSitesResponse,
          BatchCreateTargetSiteMetadata>
      batchCreateTargetSitesOperationCallable() {
    return stub.batchCreateTargetSitesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates [TargetSite][google.cloud.discoveryengine.v1.TargetSite] in a batch.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   BatchCreateTargetSitesRequest request =
   *       BatchCreateTargetSitesRequest.newBuilder()
   *           .setParent(
   *               SiteSearchEngineName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .addAllRequests(new ArrayList<CreateTargetSiteRequest>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       siteSearchEngineServiceClient.batchCreateTargetSitesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchCreateTargetSitesRequest, Operation>
      batchCreateTargetSitesCallable() {
    return stub.batchCreateTargetSitesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [TargetSite][google.cloud.discoveryengine.v1.TargetSite].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   TargetSiteName name =
   *       TargetSiteName.ofProjectLocationDataStoreTargetSiteName(
   *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[TARGET_SITE]");
   *   TargetSite response = siteSearchEngineServiceClient.getTargetSite(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [TargetSite][google.cloud.discoveryengine.v1.TargetSite], such as
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/siteSearchEngine/targetSites/{target_site}`.
   *     <p>If the caller does not have permission to access the
   *     [TargetSite][google.cloud.discoveryengine.v1.TargetSite], regardless of whether or not it
   *     exists, a PERMISSION_DENIED error is returned.
   *     <p>If the requested [TargetSite][google.cloud.discoveryengine.v1.TargetSite] does not
   *     exist, a NOT_FOUND error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetSite getTargetSite(TargetSiteName name) {
    GetTargetSiteRequest request =
        GetTargetSiteRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTargetSite(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [TargetSite][google.cloud.discoveryengine.v1.TargetSite].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   String name =
   *       TargetSiteName.ofProjectLocationDataStoreTargetSiteName(
   *               "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[TARGET_SITE]")
   *           .toString();
   *   TargetSite response = siteSearchEngineServiceClient.getTargetSite(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [TargetSite][google.cloud.discoveryengine.v1.TargetSite], such as
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/siteSearchEngine/targetSites/{target_site}`.
   *     <p>If the caller does not have permission to access the
   *     [TargetSite][google.cloud.discoveryengine.v1.TargetSite], regardless of whether or not it
   *     exists, a PERMISSION_DENIED error is returned.
   *     <p>If the requested [TargetSite][google.cloud.discoveryengine.v1.TargetSite] does not
   *     exist, a NOT_FOUND error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetSite getTargetSite(String name) {
    GetTargetSiteRequest request = GetTargetSiteRequest.newBuilder().setName(name).build();
    return getTargetSite(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [TargetSite][google.cloud.discoveryengine.v1.TargetSite].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   GetTargetSiteRequest request =
   *       GetTargetSiteRequest.newBuilder()
   *           .setName(
   *               TargetSiteName.ofProjectLocationDataStoreTargetSiteName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[TARGET_SITE]")
   *                   .toString())
   *           .build();
   *   TargetSite response = siteSearchEngineServiceClient.getTargetSite(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetSite getTargetSite(GetTargetSiteRequest request) {
    return getTargetSiteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [TargetSite][google.cloud.discoveryengine.v1.TargetSite].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   GetTargetSiteRequest request =
   *       GetTargetSiteRequest.newBuilder()
   *           .setName(
   *               TargetSiteName.ofProjectLocationDataStoreTargetSiteName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[TARGET_SITE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<TargetSite> future =
   *       siteSearchEngineServiceClient.getTargetSiteCallable().futureCall(request);
   *   // Do something.
   *   TargetSite response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTargetSiteRequest, TargetSite> getTargetSiteCallable() {
    return stub.getTargetSiteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [TargetSite][google.cloud.discoveryengine.v1.TargetSite].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   TargetSite targetSite = TargetSite.newBuilder().build();
   *   TargetSite response = siteSearchEngineServiceClient.updateTargetSiteAsync(targetSite).get();
   * }
   * }</pre>
   *
   * @param targetSite Required. The target site to update. If the caller does not have permission
   *     to update the [TargetSite][google.cloud.discoveryengine.v1.TargetSite], regardless of
   *     whether or not it exists, a PERMISSION_DENIED error is returned.
   *     <p>If the [TargetSite][google.cloud.discoveryengine.v1.TargetSite] to update does not
   *     exist, a NOT_FOUND error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TargetSite, UpdateTargetSiteMetadata> updateTargetSiteAsync(
      TargetSite targetSite) {
    UpdateTargetSiteRequest request =
        UpdateTargetSiteRequest.newBuilder().setTargetSite(targetSite).build();
    return updateTargetSiteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [TargetSite][google.cloud.discoveryengine.v1.TargetSite].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   UpdateTargetSiteRequest request =
   *       UpdateTargetSiteRequest.newBuilder()
   *           .setTargetSite(TargetSite.newBuilder().build())
   *           .build();
   *   TargetSite response = siteSearchEngineServiceClient.updateTargetSiteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TargetSite, UpdateTargetSiteMetadata> updateTargetSiteAsync(
      UpdateTargetSiteRequest request) {
    return updateTargetSiteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [TargetSite][google.cloud.discoveryengine.v1.TargetSite].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   UpdateTargetSiteRequest request =
   *       UpdateTargetSiteRequest.newBuilder()
   *           .setTargetSite(TargetSite.newBuilder().build())
   *           .build();
   *   OperationFuture<TargetSite, UpdateTargetSiteMetadata> future =
   *       siteSearchEngineServiceClient.updateTargetSiteOperationCallable().futureCall(request);
   *   // Do something.
   *   TargetSite response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateTargetSiteRequest, TargetSite, UpdateTargetSiteMetadata>
      updateTargetSiteOperationCallable() {
    return stub.updateTargetSiteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [TargetSite][google.cloud.discoveryengine.v1.TargetSite].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   UpdateTargetSiteRequest request =
   *       UpdateTargetSiteRequest.newBuilder()
   *           .setTargetSite(TargetSite.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       siteSearchEngineServiceClient.updateTargetSiteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTargetSiteRequest, Operation> updateTargetSiteCallable() {
    return stub.updateTargetSiteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [TargetSite][google.cloud.discoveryengine.v1.TargetSite].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   TargetSiteName name =
   *       TargetSiteName.ofProjectLocationDataStoreTargetSiteName(
   *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[TARGET_SITE]");
   *   siteSearchEngineServiceClient.deleteTargetSiteAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [TargetSite][google.cloud.discoveryengine.v1.TargetSite], such as
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/siteSearchEngine/targetSites/{target_site}`.
   *     <p>If the caller does not have permission to access the
   *     [TargetSite][google.cloud.discoveryengine.v1.TargetSite], regardless of whether or not it
   *     exists, a PERMISSION_DENIED error is returned.
   *     <p>If the requested [TargetSite][google.cloud.discoveryengine.v1.TargetSite] does not
   *     exist, a NOT_FOUND error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteTargetSiteMetadata> deleteTargetSiteAsync(
      TargetSiteName name) {
    DeleteTargetSiteRequest request =
        DeleteTargetSiteRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteTargetSiteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [TargetSite][google.cloud.discoveryengine.v1.TargetSite].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   String name =
   *       TargetSiteName.ofProjectLocationDataStoreTargetSiteName(
   *               "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[TARGET_SITE]")
   *           .toString();
   *   siteSearchEngineServiceClient.deleteTargetSiteAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [TargetSite][google.cloud.discoveryengine.v1.TargetSite], such as
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/siteSearchEngine/targetSites/{target_site}`.
   *     <p>If the caller does not have permission to access the
   *     [TargetSite][google.cloud.discoveryengine.v1.TargetSite], regardless of whether or not it
   *     exists, a PERMISSION_DENIED error is returned.
   *     <p>If the requested [TargetSite][google.cloud.discoveryengine.v1.TargetSite] does not
   *     exist, a NOT_FOUND error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteTargetSiteMetadata> deleteTargetSiteAsync(String name) {
    DeleteTargetSiteRequest request = DeleteTargetSiteRequest.newBuilder().setName(name).build();
    return deleteTargetSiteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [TargetSite][google.cloud.discoveryengine.v1.TargetSite].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   DeleteTargetSiteRequest request =
   *       DeleteTargetSiteRequest.newBuilder()
   *           .setName(
   *               TargetSiteName.ofProjectLocationDataStoreTargetSiteName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[TARGET_SITE]")
   *                   .toString())
   *           .build();
   *   siteSearchEngineServiceClient.deleteTargetSiteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteTargetSiteMetadata> deleteTargetSiteAsync(
      DeleteTargetSiteRequest request) {
    return deleteTargetSiteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [TargetSite][google.cloud.discoveryengine.v1.TargetSite].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   DeleteTargetSiteRequest request =
   *       DeleteTargetSiteRequest.newBuilder()
   *           .setName(
   *               TargetSiteName.ofProjectLocationDataStoreTargetSiteName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[TARGET_SITE]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, DeleteTargetSiteMetadata> future =
   *       siteSearchEngineServiceClient.deleteTargetSiteOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteTargetSiteRequest, Empty, DeleteTargetSiteMetadata>
      deleteTargetSiteOperationCallable() {
    return stub.deleteTargetSiteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [TargetSite][google.cloud.discoveryengine.v1.TargetSite].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   DeleteTargetSiteRequest request =
   *       DeleteTargetSiteRequest.newBuilder()
   *           .setName(
   *               TargetSiteName.ofProjectLocationDataStoreTargetSiteName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[TARGET_SITE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       siteSearchEngineServiceClient.deleteTargetSiteCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTargetSiteRequest, Operation> deleteTargetSiteCallable() {
    return stub.deleteTargetSiteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [TargetSite][google.cloud.discoveryengine.v1.TargetSite]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   SiteSearchEngineName parent =
   *       SiteSearchEngineName.ofProjectLocationDataStoreName(
   *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]");
   *   for (TargetSite element :
   *       siteSearchEngineServiceClient.listTargetSites(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent site search engine resource name, such as
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/siteSearchEngine`.
   *     <p>If the caller does not have permission to list
   *     [TargetSite][google.cloud.discoveryengine.v1.TargetSite]s under this site search engine,
   *     regardless of whether or not this branch exists, a PERMISSION_DENIED error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTargetSitesPagedResponse listTargetSites(SiteSearchEngineName parent) {
    ListTargetSitesRequest request =
        ListTargetSitesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTargetSites(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [TargetSite][google.cloud.discoveryengine.v1.TargetSite]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   String parent =
   *       SiteSearchEngineName.ofProjectLocationDataStoreName(
   *               "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *           .toString();
   *   for (TargetSite element :
   *       siteSearchEngineServiceClient.listTargetSites(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent site search engine resource name, such as
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/siteSearchEngine`.
   *     <p>If the caller does not have permission to list
   *     [TargetSite][google.cloud.discoveryengine.v1.TargetSite]s under this site search engine,
   *     regardless of whether or not this branch exists, a PERMISSION_DENIED error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTargetSitesPagedResponse listTargetSites(String parent) {
    ListTargetSitesRequest request = ListTargetSitesRequest.newBuilder().setParent(parent).build();
    return listTargetSites(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [TargetSite][google.cloud.discoveryengine.v1.TargetSite]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   ListTargetSitesRequest request =
   *       ListTargetSitesRequest.newBuilder()
   *           .setParent(
   *               SiteSearchEngineName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (TargetSite element :
   *       siteSearchEngineServiceClient.listTargetSites(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTargetSitesPagedResponse listTargetSites(ListTargetSitesRequest request) {
    return listTargetSitesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [TargetSite][google.cloud.discoveryengine.v1.TargetSite]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   ListTargetSitesRequest request =
   *       ListTargetSitesRequest.newBuilder()
   *           .setParent(
   *               SiteSearchEngineName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<TargetSite> future =
   *       siteSearchEngineServiceClient.listTargetSitesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TargetSite element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTargetSitesRequest, ListTargetSitesPagedResponse>
      listTargetSitesPagedCallable() {
    return stub.listTargetSitesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [TargetSite][google.cloud.discoveryengine.v1.TargetSite]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   ListTargetSitesRequest request =
   *       ListTargetSitesRequest.newBuilder()
   *           .setParent(
   *               SiteSearchEngineName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListTargetSitesResponse response =
   *         siteSearchEngineServiceClient.listTargetSitesCallable().call(request);
   *     for (TargetSite element : response.getTargetSitesList()) {
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
  public final UnaryCallable<ListTargetSitesRequest, ListTargetSitesResponse>
      listTargetSitesCallable() {
    return stub.listTargetSitesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrade from basic site search to advanced site search.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   EnableAdvancedSiteSearchRequest request =
   *       EnableAdvancedSiteSearchRequest.newBuilder()
   *           .setSiteSearchEngine(
   *               SiteSearchEngineName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .build();
   *   EnableAdvancedSiteSearchResponse response =
   *       siteSearchEngineServiceClient.enableAdvancedSiteSearchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EnableAdvancedSiteSearchResponse, EnableAdvancedSiteSearchMetadata>
      enableAdvancedSiteSearchAsync(EnableAdvancedSiteSearchRequest request) {
    return enableAdvancedSiteSearchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrade from basic site search to advanced site search.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   EnableAdvancedSiteSearchRequest request =
   *       EnableAdvancedSiteSearchRequest.newBuilder()
   *           .setSiteSearchEngine(
   *               SiteSearchEngineName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .build();
   *   OperationFuture<EnableAdvancedSiteSearchResponse, EnableAdvancedSiteSearchMetadata> future =
   *       siteSearchEngineServiceClient
   *           .enableAdvancedSiteSearchOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   EnableAdvancedSiteSearchResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          EnableAdvancedSiteSearchRequest,
          EnableAdvancedSiteSearchResponse,
          EnableAdvancedSiteSearchMetadata>
      enableAdvancedSiteSearchOperationCallable() {
    return stub.enableAdvancedSiteSearchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrade from basic site search to advanced site search.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   EnableAdvancedSiteSearchRequest request =
   *       EnableAdvancedSiteSearchRequest.newBuilder()
   *           .setSiteSearchEngine(
   *               SiteSearchEngineName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       siteSearchEngineServiceClient.enableAdvancedSiteSearchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<EnableAdvancedSiteSearchRequest, Operation>
      enableAdvancedSiteSearchCallable() {
    return stub.enableAdvancedSiteSearchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Downgrade from advanced site search to basic site search.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   DisableAdvancedSiteSearchRequest request =
   *       DisableAdvancedSiteSearchRequest.newBuilder()
   *           .setSiteSearchEngine(
   *               SiteSearchEngineName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .build();
   *   DisableAdvancedSiteSearchResponse response =
   *       siteSearchEngineServiceClient.disableAdvancedSiteSearchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DisableAdvancedSiteSearchResponse, DisableAdvancedSiteSearchMetadata>
      disableAdvancedSiteSearchAsync(DisableAdvancedSiteSearchRequest request) {
    return disableAdvancedSiteSearchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Downgrade from advanced site search to basic site search.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   DisableAdvancedSiteSearchRequest request =
   *       DisableAdvancedSiteSearchRequest.newBuilder()
   *           .setSiteSearchEngine(
   *               SiteSearchEngineName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .build();
   *   OperationFuture<DisableAdvancedSiteSearchResponse, DisableAdvancedSiteSearchMetadata> future =
   *       siteSearchEngineServiceClient
   *           .disableAdvancedSiteSearchOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   DisableAdvancedSiteSearchResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DisableAdvancedSiteSearchRequest,
          DisableAdvancedSiteSearchResponse,
          DisableAdvancedSiteSearchMetadata>
      disableAdvancedSiteSearchOperationCallable() {
    return stub.disableAdvancedSiteSearchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Downgrade from advanced site search to basic site search.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   DisableAdvancedSiteSearchRequest request =
   *       DisableAdvancedSiteSearchRequest.newBuilder()
   *           .setSiteSearchEngine(
   *               SiteSearchEngineName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       siteSearchEngineServiceClient.disableAdvancedSiteSearchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DisableAdvancedSiteSearchRequest, Operation>
      disableAdvancedSiteSearchCallable() {
    return stub.disableAdvancedSiteSearchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Request on-demand recrawl for a list of URIs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   RecrawlUrisRequest request =
   *       RecrawlUrisRequest.newBuilder()
   *           .setSiteSearchEngine(
   *               SiteSearchEngineName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .addAllUris(new ArrayList<String>())
   *           .build();
   *   RecrawlUrisResponse response = siteSearchEngineServiceClient.recrawlUrisAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RecrawlUrisResponse, RecrawlUrisMetadata> recrawlUrisAsync(
      RecrawlUrisRequest request) {
    return recrawlUrisOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Request on-demand recrawl for a list of URIs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   RecrawlUrisRequest request =
   *       RecrawlUrisRequest.newBuilder()
   *           .setSiteSearchEngine(
   *               SiteSearchEngineName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .addAllUris(new ArrayList<String>())
   *           .build();
   *   OperationFuture<RecrawlUrisResponse, RecrawlUrisMetadata> future =
   *       siteSearchEngineServiceClient.recrawlUrisOperationCallable().futureCall(request);
   *   // Do something.
   *   RecrawlUrisResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RecrawlUrisRequest, RecrawlUrisResponse, RecrawlUrisMetadata>
      recrawlUrisOperationCallable() {
    return stub.recrawlUrisOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Request on-demand recrawl for a list of URIs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   RecrawlUrisRequest request =
   *       RecrawlUrisRequest.newBuilder()
   *           .setSiteSearchEngine(
   *               SiteSearchEngineName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .addAllUris(new ArrayList<String>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       siteSearchEngineServiceClient.recrawlUrisCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RecrawlUrisRequest, Operation> recrawlUrisCallable() {
    return stub.recrawlUrisCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Verify target sites' ownership and validity. This API sends all the target sites under site
   * search engine for verification.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   BatchVerifyTargetSitesRequest request =
   *       BatchVerifyTargetSitesRequest.newBuilder()
   *           .setParent(
   *               SiteSearchEngineName.ofProjectLocationCollectionDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATA_STORE]")
   *                   .toString())
   *           .build();
   *   BatchVerifyTargetSitesResponse response =
   *       siteSearchEngineServiceClient.batchVerifyTargetSitesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchVerifyTargetSitesResponse, BatchVerifyTargetSitesMetadata>
      batchVerifyTargetSitesAsync(BatchVerifyTargetSitesRequest request) {
    return batchVerifyTargetSitesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Verify target sites' ownership and validity. This API sends all the target sites under site
   * search engine for verification.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   BatchVerifyTargetSitesRequest request =
   *       BatchVerifyTargetSitesRequest.newBuilder()
   *           .setParent(
   *               SiteSearchEngineName.ofProjectLocationCollectionDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATA_STORE]")
   *                   .toString())
   *           .build();
   *   OperationFuture<BatchVerifyTargetSitesResponse, BatchVerifyTargetSitesMetadata> future =
   *       siteSearchEngineServiceClient
   *           .batchVerifyTargetSitesOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchVerifyTargetSitesResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          BatchVerifyTargetSitesRequest,
          BatchVerifyTargetSitesResponse,
          BatchVerifyTargetSitesMetadata>
      batchVerifyTargetSitesOperationCallable() {
    return stub.batchVerifyTargetSitesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Verify target sites' ownership and validity. This API sends all the target sites under site
   * search engine for verification.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   BatchVerifyTargetSitesRequest request =
   *       BatchVerifyTargetSitesRequest.newBuilder()
   *           .setParent(
   *               SiteSearchEngineName.ofProjectLocationCollectionDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATA_STORE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       siteSearchEngineServiceClient.batchVerifyTargetSitesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchVerifyTargetSitesRequest, Operation>
      batchVerifyTargetSitesCallable() {
    return stub.batchVerifyTargetSitesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns list of target sites with its domain verification status. This method can only be
   * called under data store with BASIC_SITE_SEARCH state at the moment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   FetchDomainVerificationStatusRequest request =
   *       FetchDomainVerificationStatusRequest.newBuilder()
   *           .setSiteSearchEngine(
   *               SiteSearchEngineName.ofProjectLocationCollectionDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATA_STORE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (TargetSite element :
   *       siteSearchEngineServiceClient.fetchDomainVerificationStatus(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchDomainVerificationStatusPagedResponse fetchDomainVerificationStatus(
      FetchDomainVerificationStatusRequest request) {
    return fetchDomainVerificationStatusPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns list of target sites with its domain verification status. This method can only be
   * called under data store with BASIC_SITE_SEARCH state at the moment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   FetchDomainVerificationStatusRequest request =
   *       FetchDomainVerificationStatusRequest.newBuilder()
   *           .setSiteSearchEngine(
   *               SiteSearchEngineName.ofProjectLocationCollectionDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATA_STORE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<TargetSite> future =
   *       siteSearchEngineServiceClient
   *           .fetchDomainVerificationStatusPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (TargetSite element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          FetchDomainVerificationStatusRequest, FetchDomainVerificationStatusPagedResponse>
      fetchDomainVerificationStatusPagedCallable() {
    return stub.fetchDomainVerificationStatusPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns list of target sites with its domain verification status. This method can only be
   * called under data store with BASIC_SITE_SEARCH state at the moment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   FetchDomainVerificationStatusRequest request =
   *       FetchDomainVerificationStatusRequest.newBuilder()
   *           .setSiteSearchEngine(
   *               SiteSearchEngineName.ofProjectLocationCollectionDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATA_STORE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     FetchDomainVerificationStatusResponse response =
   *         siteSearchEngineServiceClient.fetchDomainVerificationStatusCallable().call(request);
   *     for (TargetSite element : response.getTargetSitesList()) {
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
  public final UnaryCallable<
          FetchDomainVerificationStatusRequest, FetchDomainVerificationStatusResponse>
      fetchDomainVerificationStatusCallable() {
    return stub.fetchDomainVerificationStatusCallable();
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

  public static class ListTargetSitesPagedResponse
      extends AbstractPagedListResponse<
          ListTargetSitesRequest,
          ListTargetSitesResponse,
          TargetSite,
          ListTargetSitesPage,
          ListTargetSitesFixedSizeCollection> {

    public static ApiFuture<ListTargetSitesPagedResponse> createAsync(
        PageContext<ListTargetSitesRequest, ListTargetSitesResponse, TargetSite> context,
        ApiFuture<ListTargetSitesResponse> futureResponse) {
      ApiFuture<ListTargetSitesPage> futurePage =
          ListTargetSitesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTargetSitesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTargetSitesPagedResponse(ListTargetSitesPage page) {
      super(page, ListTargetSitesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTargetSitesPage
      extends AbstractPage<
          ListTargetSitesRequest, ListTargetSitesResponse, TargetSite, ListTargetSitesPage> {

    private ListTargetSitesPage(
        PageContext<ListTargetSitesRequest, ListTargetSitesResponse, TargetSite> context,
        ListTargetSitesResponse response) {
      super(context, response);
    }

    private static ListTargetSitesPage createEmptyPage() {
      return new ListTargetSitesPage(null, null);
    }

    @Override
    protected ListTargetSitesPage createPage(
        PageContext<ListTargetSitesRequest, ListTargetSitesResponse, TargetSite> context,
        ListTargetSitesResponse response) {
      return new ListTargetSitesPage(context, response);
    }

    @Override
    public ApiFuture<ListTargetSitesPage> createPageAsync(
        PageContext<ListTargetSitesRequest, ListTargetSitesResponse, TargetSite> context,
        ApiFuture<ListTargetSitesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTargetSitesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTargetSitesRequest,
          ListTargetSitesResponse,
          TargetSite,
          ListTargetSitesPage,
          ListTargetSitesFixedSizeCollection> {

    private ListTargetSitesFixedSizeCollection(
        List<ListTargetSitesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTargetSitesFixedSizeCollection createEmptyCollection() {
      return new ListTargetSitesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTargetSitesFixedSizeCollection createCollection(
        List<ListTargetSitesPage> pages, int collectionSize) {
      return new ListTargetSitesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class FetchDomainVerificationStatusPagedResponse
      extends AbstractPagedListResponse<
          FetchDomainVerificationStatusRequest,
          FetchDomainVerificationStatusResponse,
          TargetSite,
          FetchDomainVerificationStatusPage,
          FetchDomainVerificationStatusFixedSizeCollection> {

    public static ApiFuture<FetchDomainVerificationStatusPagedResponse> createAsync(
        PageContext<
                FetchDomainVerificationStatusRequest,
                FetchDomainVerificationStatusResponse,
                TargetSite>
            context,
        ApiFuture<FetchDomainVerificationStatusResponse> futureResponse) {
      ApiFuture<FetchDomainVerificationStatusPage> futurePage =
          FetchDomainVerificationStatusPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new FetchDomainVerificationStatusPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private FetchDomainVerificationStatusPagedResponse(FetchDomainVerificationStatusPage page) {
      super(page, FetchDomainVerificationStatusFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class FetchDomainVerificationStatusPage
      extends AbstractPage<
          FetchDomainVerificationStatusRequest,
          FetchDomainVerificationStatusResponse,
          TargetSite,
          FetchDomainVerificationStatusPage> {

    private FetchDomainVerificationStatusPage(
        PageContext<
                FetchDomainVerificationStatusRequest,
                FetchDomainVerificationStatusResponse,
                TargetSite>
            context,
        FetchDomainVerificationStatusResponse response) {
      super(context, response);
    }

    private static FetchDomainVerificationStatusPage createEmptyPage() {
      return new FetchDomainVerificationStatusPage(null, null);
    }

    @Override
    protected FetchDomainVerificationStatusPage createPage(
        PageContext<
                FetchDomainVerificationStatusRequest,
                FetchDomainVerificationStatusResponse,
                TargetSite>
            context,
        FetchDomainVerificationStatusResponse response) {
      return new FetchDomainVerificationStatusPage(context, response);
    }

    @Override
    public ApiFuture<FetchDomainVerificationStatusPage> createPageAsync(
        PageContext<
                FetchDomainVerificationStatusRequest,
                FetchDomainVerificationStatusResponse,
                TargetSite>
            context,
        ApiFuture<FetchDomainVerificationStatusResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class FetchDomainVerificationStatusFixedSizeCollection
      extends AbstractFixedSizeCollection<
          FetchDomainVerificationStatusRequest,
          FetchDomainVerificationStatusResponse,
          TargetSite,
          FetchDomainVerificationStatusPage,
          FetchDomainVerificationStatusFixedSizeCollection> {

    private FetchDomainVerificationStatusFixedSizeCollection(
        List<FetchDomainVerificationStatusPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static FetchDomainVerificationStatusFixedSizeCollection createEmptyCollection() {
      return new FetchDomainVerificationStatusFixedSizeCollection(null, 0);
    }

    @Override
    protected FetchDomainVerificationStatusFixedSizeCollection createCollection(
        List<FetchDomainVerificationStatusPage> pages, int collectionSize) {
      return new FetchDomainVerificationStatusFixedSizeCollection(pages, collectionSize);
    }
  }
}
