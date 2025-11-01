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

import com.google.ads.admanager.v1.stub.CmsMetadataKeyServiceStub;
import com.google.ads.admanager.v1.stub.CmsMetadataKeyServiceStubSettings;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for handling `CmsMetadataKey` objects.
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
 * try (CmsMetadataKeyServiceClient cmsMetadataKeyServiceClient =
 *     CmsMetadataKeyServiceClient.create()) {
 *   CmsMetadataKeyName name = CmsMetadataKeyName.of("[NETWORK_CODE]", "[CMS_METADATA_KEY]");
 *   CmsMetadataKey response = cmsMetadataKeyServiceClient.getCmsMetadataKey(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CmsMetadataKeyServiceClient object to clean up
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
 *      <td><p> GetCmsMetadataKey</td>
 *      <td><p> API to retrieve a `CmsMetadataKey` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCmsMetadataKey(GetCmsMetadataKeyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCmsMetadataKey(CmsMetadataKeyName name)
 *           <li><p> getCmsMetadataKey(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCmsMetadataKeyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCmsMetadataKeys</td>
 *      <td><p> API to retrieve a list of `CmsMetadataKey` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCmsMetadataKeys(ListCmsMetadataKeysRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCmsMetadataKeys(NetworkName parent)
 *           <li><p> listCmsMetadataKeys(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCmsMetadataKeysPagedCallable()
 *           <li><p> listCmsMetadataKeysCallable()
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
 * <p>This class can be customized by passing in a custom instance of CmsMetadataKeyServiceSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CmsMetadataKeyServiceSettings cmsMetadataKeyServiceSettings =
 *     CmsMetadataKeyServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CmsMetadataKeyServiceClient cmsMetadataKeyServiceClient =
 *     CmsMetadataKeyServiceClient.create(cmsMetadataKeyServiceSettings);
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
 * CmsMetadataKeyServiceSettings cmsMetadataKeyServiceSettings =
 *     CmsMetadataKeyServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CmsMetadataKeyServiceClient cmsMetadataKeyServiceClient =
 *     CmsMetadataKeyServiceClient.create(cmsMetadataKeyServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class CmsMetadataKeyServiceClient implements BackgroundResource {
  private final CmsMetadataKeyServiceSettings settings;
  private final CmsMetadataKeyServiceStub stub;

  /** Constructs an instance of CmsMetadataKeyServiceClient with default settings. */
  public static final CmsMetadataKeyServiceClient create() throws IOException {
    return create(CmsMetadataKeyServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CmsMetadataKeyServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CmsMetadataKeyServiceClient create(CmsMetadataKeyServiceSettings settings)
      throws IOException {
    return new CmsMetadataKeyServiceClient(settings);
  }

  /**
   * Constructs an instance of CmsMetadataKeyServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(CmsMetadataKeyServiceSettings).
   */
  public static final CmsMetadataKeyServiceClient create(CmsMetadataKeyServiceStub stub) {
    return new CmsMetadataKeyServiceClient(stub);
  }

  /**
   * Constructs an instance of CmsMetadataKeyServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected CmsMetadataKeyServiceClient(CmsMetadataKeyServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CmsMetadataKeyServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected CmsMetadataKeyServiceClient(CmsMetadataKeyServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final CmsMetadataKeyServiceSettings getSettings() {
    return settings;
  }

  public CmsMetadataKeyServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `CmsMetadataKey` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmsMetadataKeyServiceClient cmsMetadataKeyServiceClient =
   *     CmsMetadataKeyServiceClient.create()) {
   *   CmsMetadataKeyName name = CmsMetadataKeyName.of("[NETWORK_CODE]", "[CMS_METADATA_KEY]");
   *   CmsMetadataKey response = cmsMetadataKeyServiceClient.getCmsMetadataKey(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the CmsMetadataKey. Format:
   *     `networks/{network_code}/cmsMetadataKeys/{cms_metadata_key_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CmsMetadataKey getCmsMetadataKey(CmsMetadataKeyName name) {
    GetCmsMetadataKeyRequest request =
        GetCmsMetadataKeyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getCmsMetadataKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `CmsMetadataKey` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmsMetadataKeyServiceClient cmsMetadataKeyServiceClient =
   *     CmsMetadataKeyServiceClient.create()) {
   *   String name = CmsMetadataKeyName.of("[NETWORK_CODE]", "[CMS_METADATA_KEY]").toString();
   *   CmsMetadataKey response = cmsMetadataKeyServiceClient.getCmsMetadataKey(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the CmsMetadataKey. Format:
   *     `networks/{network_code}/cmsMetadataKeys/{cms_metadata_key_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CmsMetadataKey getCmsMetadataKey(String name) {
    GetCmsMetadataKeyRequest request = GetCmsMetadataKeyRequest.newBuilder().setName(name).build();
    return getCmsMetadataKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `CmsMetadataKey` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmsMetadataKeyServiceClient cmsMetadataKeyServiceClient =
   *     CmsMetadataKeyServiceClient.create()) {
   *   GetCmsMetadataKeyRequest request =
   *       GetCmsMetadataKeyRequest.newBuilder()
   *           .setName(CmsMetadataKeyName.of("[NETWORK_CODE]", "[CMS_METADATA_KEY]").toString())
   *           .build();
   *   CmsMetadataKey response = cmsMetadataKeyServiceClient.getCmsMetadataKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CmsMetadataKey getCmsMetadataKey(GetCmsMetadataKeyRequest request) {
    return getCmsMetadataKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `CmsMetadataKey` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmsMetadataKeyServiceClient cmsMetadataKeyServiceClient =
   *     CmsMetadataKeyServiceClient.create()) {
   *   GetCmsMetadataKeyRequest request =
   *       GetCmsMetadataKeyRequest.newBuilder()
   *           .setName(CmsMetadataKeyName.of("[NETWORK_CODE]", "[CMS_METADATA_KEY]").toString())
   *           .build();
   *   ApiFuture<CmsMetadataKey> future =
   *       cmsMetadataKeyServiceClient.getCmsMetadataKeyCallable().futureCall(request);
   *   // Do something.
   *   CmsMetadataKey response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCmsMetadataKeyRequest, CmsMetadataKey> getCmsMetadataKeyCallable() {
    return stub.getCmsMetadataKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CmsMetadataKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmsMetadataKeyServiceClient cmsMetadataKeyServiceClient =
   *     CmsMetadataKeyServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (CmsMetadataKey element :
   *       cmsMetadataKeyServiceClient.listCmsMetadataKeys(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of CmsMetadataKeys. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCmsMetadataKeysPagedResponse listCmsMetadataKeys(NetworkName parent) {
    ListCmsMetadataKeysRequest request =
        ListCmsMetadataKeysRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCmsMetadataKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CmsMetadataKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmsMetadataKeyServiceClient cmsMetadataKeyServiceClient =
   *     CmsMetadataKeyServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (CmsMetadataKey element :
   *       cmsMetadataKeyServiceClient.listCmsMetadataKeys(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of CmsMetadataKeys. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCmsMetadataKeysPagedResponse listCmsMetadataKeys(String parent) {
    ListCmsMetadataKeysRequest request =
        ListCmsMetadataKeysRequest.newBuilder().setParent(parent).build();
    return listCmsMetadataKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CmsMetadataKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmsMetadataKeyServiceClient cmsMetadataKeyServiceClient =
   *     CmsMetadataKeyServiceClient.create()) {
   *   ListCmsMetadataKeysRequest request =
   *       ListCmsMetadataKeysRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (CmsMetadataKey element :
   *       cmsMetadataKeyServiceClient.listCmsMetadataKeys(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCmsMetadataKeysPagedResponse listCmsMetadataKeys(
      ListCmsMetadataKeysRequest request) {
    return listCmsMetadataKeysPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CmsMetadataKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmsMetadataKeyServiceClient cmsMetadataKeyServiceClient =
   *     CmsMetadataKeyServiceClient.create()) {
   *   ListCmsMetadataKeysRequest request =
   *       ListCmsMetadataKeysRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<CmsMetadataKey> future =
   *       cmsMetadataKeyServiceClient.listCmsMetadataKeysPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CmsMetadataKey element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCmsMetadataKeysRequest, ListCmsMetadataKeysPagedResponse>
      listCmsMetadataKeysPagedCallable() {
    return stub.listCmsMetadataKeysPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CmsMetadataKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmsMetadataKeyServiceClient cmsMetadataKeyServiceClient =
   *     CmsMetadataKeyServiceClient.create()) {
   *   ListCmsMetadataKeysRequest request =
   *       ListCmsMetadataKeysRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListCmsMetadataKeysResponse response =
   *         cmsMetadataKeyServiceClient.listCmsMetadataKeysCallable().call(request);
   *     for (CmsMetadataKey element : response.getCmsMetadataKeysList()) {
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
  public final UnaryCallable<ListCmsMetadataKeysRequest, ListCmsMetadataKeysResponse>
      listCmsMetadataKeysCallable() {
    return stub.listCmsMetadataKeysCallable();
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

  public static class ListCmsMetadataKeysPagedResponse
      extends AbstractPagedListResponse<
          ListCmsMetadataKeysRequest,
          ListCmsMetadataKeysResponse,
          CmsMetadataKey,
          ListCmsMetadataKeysPage,
          ListCmsMetadataKeysFixedSizeCollection> {

    public static ApiFuture<ListCmsMetadataKeysPagedResponse> createAsync(
        PageContext<ListCmsMetadataKeysRequest, ListCmsMetadataKeysResponse, CmsMetadataKey>
            context,
        ApiFuture<ListCmsMetadataKeysResponse> futureResponse) {
      ApiFuture<ListCmsMetadataKeysPage> futurePage =
          ListCmsMetadataKeysPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCmsMetadataKeysPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCmsMetadataKeysPagedResponse(ListCmsMetadataKeysPage page) {
      super(page, ListCmsMetadataKeysFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCmsMetadataKeysPage
      extends AbstractPage<
          ListCmsMetadataKeysRequest,
          ListCmsMetadataKeysResponse,
          CmsMetadataKey,
          ListCmsMetadataKeysPage> {

    private ListCmsMetadataKeysPage(
        PageContext<ListCmsMetadataKeysRequest, ListCmsMetadataKeysResponse, CmsMetadataKey>
            context,
        ListCmsMetadataKeysResponse response) {
      super(context, response);
    }

    private static ListCmsMetadataKeysPage createEmptyPage() {
      return new ListCmsMetadataKeysPage(null, null);
    }

    @Override
    protected ListCmsMetadataKeysPage createPage(
        PageContext<ListCmsMetadataKeysRequest, ListCmsMetadataKeysResponse, CmsMetadataKey>
            context,
        ListCmsMetadataKeysResponse response) {
      return new ListCmsMetadataKeysPage(context, response);
    }

    @Override
    public ApiFuture<ListCmsMetadataKeysPage> createPageAsync(
        PageContext<ListCmsMetadataKeysRequest, ListCmsMetadataKeysResponse, CmsMetadataKey>
            context,
        ApiFuture<ListCmsMetadataKeysResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCmsMetadataKeysFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCmsMetadataKeysRequest,
          ListCmsMetadataKeysResponse,
          CmsMetadataKey,
          ListCmsMetadataKeysPage,
          ListCmsMetadataKeysFixedSizeCollection> {

    private ListCmsMetadataKeysFixedSizeCollection(
        List<ListCmsMetadataKeysPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCmsMetadataKeysFixedSizeCollection createEmptyCollection() {
      return new ListCmsMetadataKeysFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCmsMetadataKeysFixedSizeCollection createCollection(
        List<ListCmsMetadataKeysPage> pages, int collectionSize) {
      return new ListCmsMetadataKeysFixedSizeCollection(pages, collectionSize);
    }
  }
}
