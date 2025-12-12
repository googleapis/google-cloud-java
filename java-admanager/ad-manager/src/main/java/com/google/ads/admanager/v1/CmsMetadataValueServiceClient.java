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

import com.google.ads.admanager.v1.stub.CmsMetadataValueServiceStub;
import com.google.ads.admanager.v1.stub.CmsMetadataValueServiceStubSettings;
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
 * Service Description: Provides methods for handling `CmsMetadataValue` objects.
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
 * try (CmsMetadataValueServiceClient cmsMetadataValueServiceClient =
 *     CmsMetadataValueServiceClient.create()) {
 *   CmsMetadataValueName name = CmsMetadataValueName.of("[NETWORK_CODE]", "[CMS_METADATA_VALUE]");
 *   CmsMetadataValue response = cmsMetadataValueServiceClient.getCmsMetadataValue(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CmsMetadataValueServiceClient object to clean up
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
 *      <td><p> GetCmsMetadataValue</td>
 *      <td><p> API to retrieve a `CmsMetadataValue` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCmsMetadataValue(GetCmsMetadataValueRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCmsMetadataValue(CmsMetadataValueName name)
 *           <li><p> getCmsMetadataValue(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCmsMetadataValueCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCmsMetadataValues</td>
 *      <td><p> API to retrieve a list of `CmsMetadataValue` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCmsMetadataValues(ListCmsMetadataValuesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCmsMetadataValues(NetworkName parent)
 *           <li><p> listCmsMetadataValues(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCmsMetadataValuesPagedCallable()
 *           <li><p> listCmsMetadataValuesCallable()
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
 * CmsMetadataValueServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CmsMetadataValueServiceSettings cmsMetadataValueServiceSettings =
 *     CmsMetadataValueServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CmsMetadataValueServiceClient cmsMetadataValueServiceClient =
 *     CmsMetadataValueServiceClient.create(cmsMetadataValueServiceSettings);
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
 * CmsMetadataValueServiceSettings cmsMetadataValueServiceSettings =
 *     CmsMetadataValueServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CmsMetadataValueServiceClient cmsMetadataValueServiceClient =
 *     CmsMetadataValueServiceClient.create(cmsMetadataValueServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class CmsMetadataValueServiceClient implements BackgroundResource {
  private final CmsMetadataValueServiceSettings settings;
  private final CmsMetadataValueServiceStub stub;

  /** Constructs an instance of CmsMetadataValueServiceClient with default settings. */
  public static final CmsMetadataValueServiceClient create() throws IOException {
    return create(CmsMetadataValueServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CmsMetadataValueServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CmsMetadataValueServiceClient create(CmsMetadataValueServiceSettings settings)
      throws IOException {
    return new CmsMetadataValueServiceClient(settings);
  }

  /**
   * Constructs an instance of CmsMetadataValueServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(CmsMetadataValueServiceSettings).
   */
  public static final CmsMetadataValueServiceClient create(CmsMetadataValueServiceStub stub) {
    return new CmsMetadataValueServiceClient(stub);
  }

  /**
   * Constructs an instance of CmsMetadataValueServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected CmsMetadataValueServiceClient(CmsMetadataValueServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((CmsMetadataValueServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected CmsMetadataValueServiceClient(CmsMetadataValueServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final CmsMetadataValueServiceSettings getSettings() {
    return settings;
  }

  public CmsMetadataValueServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `CmsMetadataValue` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmsMetadataValueServiceClient cmsMetadataValueServiceClient =
   *     CmsMetadataValueServiceClient.create()) {
   *   CmsMetadataValueName name = CmsMetadataValueName.of("[NETWORK_CODE]", "[CMS_METADATA_VALUE]");
   *   CmsMetadataValue response = cmsMetadataValueServiceClient.getCmsMetadataValue(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the CmsMetadataValue. Format:
   *     `networks/{network_code}/cmsMetadataValues/{cms_metadata_value_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CmsMetadataValue getCmsMetadataValue(CmsMetadataValueName name) {
    GetCmsMetadataValueRequest request =
        GetCmsMetadataValueRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getCmsMetadataValue(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `CmsMetadataValue` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmsMetadataValueServiceClient cmsMetadataValueServiceClient =
   *     CmsMetadataValueServiceClient.create()) {
   *   String name = CmsMetadataValueName.of("[NETWORK_CODE]", "[CMS_METADATA_VALUE]").toString();
   *   CmsMetadataValue response = cmsMetadataValueServiceClient.getCmsMetadataValue(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the CmsMetadataValue. Format:
   *     `networks/{network_code}/cmsMetadataValues/{cms_metadata_value_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CmsMetadataValue getCmsMetadataValue(String name) {
    GetCmsMetadataValueRequest request =
        GetCmsMetadataValueRequest.newBuilder().setName(name).build();
    return getCmsMetadataValue(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `CmsMetadataValue` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmsMetadataValueServiceClient cmsMetadataValueServiceClient =
   *     CmsMetadataValueServiceClient.create()) {
   *   GetCmsMetadataValueRequest request =
   *       GetCmsMetadataValueRequest.newBuilder()
   *           .setName(CmsMetadataValueName.of("[NETWORK_CODE]", "[CMS_METADATA_VALUE]").toString())
   *           .build();
   *   CmsMetadataValue response = cmsMetadataValueServiceClient.getCmsMetadataValue(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CmsMetadataValue getCmsMetadataValue(GetCmsMetadataValueRequest request) {
    return getCmsMetadataValueCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `CmsMetadataValue` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmsMetadataValueServiceClient cmsMetadataValueServiceClient =
   *     CmsMetadataValueServiceClient.create()) {
   *   GetCmsMetadataValueRequest request =
   *       GetCmsMetadataValueRequest.newBuilder()
   *           .setName(CmsMetadataValueName.of("[NETWORK_CODE]", "[CMS_METADATA_VALUE]").toString())
   *           .build();
   *   ApiFuture<CmsMetadataValue> future =
   *       cmsMetadataValueServiceClient.getCmsMetadataValueCallable().futureCall(request);
   *   // Do something.
   *   CmsMetadataValue response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCmsMetadataValueRequest, CmsMetadataValue>
      getCmsMetadataValueCallable() {
    return stub.getCmsMetadataValueCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CmsMetadataValue` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmsMetadataValueServiceClient cmsMetadataValueServiceClient =
   *     CmsMetadataValueServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (CmsMetadataValue element :
   *       cmsMetadataValueServiceClient.listCmsMetadataValues(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of CmsMetadataValues. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCmsMetadataValuesPagedResponse listCmsMetadataValues(NetworkName parent) {
    ListCmsMetadataValuesRequest request =
        ListCmsMetadataValuesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCmsMetadataValues(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CmsMetadataValue` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmsMetadataValueServiceClient cmsMetadataValueServiceClient =
   *     CmsMetadataValueServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (CmsMetadataValue element :
   *       cmsMetadataValueServiceClient.listCmsMetadataValues(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of CmsMetadataValues. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCmsMetadataValuesPagedResponse listCmsMetadataValues(String parent) {
    ListCmsMetadataValuesRequest request =
        ListCmsMetadataValuesRequest.newBuilder().setParent(parent).build();
    return listCmsMetadataValues(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CmsMetadataValue` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmsMetadataValueServiceClient cmsMetadataValueServiceClient =
   *     CmsMetadataValueServiceClient.create()) {
   *   ListCmsMetadataValuesRequest request =
   *       ListCmsMetadataValuesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (CmsMetadataValue element :
   *       cmsMetadataValueServiceClient.listCmsMetadataValues(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCmsMetadataValuesPagedResponse listCmsMetadataValues(
      ListCmsMetadataValuesRequest request) {
    return listCmsMetadataValuesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CmsMetadataValue` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmsMetadataValueServiceClient cmsMetadataValueServiceClient =
   *     CmsMetadataValueServiceClient.create()) {
   *   ListCmsMetadataValuesRequest request =
   *       ListCmsMetadataValuesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<CmsMetadataValue> future =
   *       cmsMetadataValueServiceClient.listCmsMetadataValuesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CmsMetadataValue element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCmsMetadataValuesRequest, ListCmsMetadataValuesPagedResponse>
      listCmsMetadataValuesPagedCallable() {
    return stub.listCmsMetadataValuesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CmsMetadataValue` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmsMetadataValueServiceClient cmsMetadataValueServiceClient =
   *     CmsMetadataValueServiceClient.create()) {
   *   ListCmsMetadataValuesRequest request =
   *       ListCmsMetadataValuesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListCmsMetadataValuesResponse response =
   *         cmsMetadataValueServiceClient.listCmsMetadataValuesCallable().call(request);
   *     for (CmsMetadataValue element : response.getCmsMetadataValuesList()) {
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
  public final UnaryCallable<ListCmsMetadataValuesRequest, ListCmsMetadataValuesResponse>
      listCmsMetadataValuesCallable() {
    return stub.listCmsMetadataValuesCallable();
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

  public static class ListCmsMetadataValuesPagedResponse
      extends AbstractPagedListResponse<
          ListCmsMetadataValuesRequest,
          ListCmsMetadataValuesResponse,
          CmsMetadataValue,
          ListCmsMetadataValuesPage,
          ListCmsMetadataValuesFixedSizeCollection> {

    public static ApiFuture<ListCmsMetadataValuesPagedResponse> createAsync(
        PageContext<ListCmsMetadataValuesRequest, ListCmsMetadataValuesResponse, CmsMetadataValue>
            context,
        ApiFuture<ListCmsMetadataValuesResponse> futureResponse) {
      ApiFuture<ListCmsMetadataValuesPage> futurePage =
          ListCmsMetadataValuesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCmsMetadataValuesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCmsMetadataValuesPagedResponse(ListCmsMetadataValuesPage page) {
      super(page, ListCmsMetadataValuesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCmsMetadataValuesPage
      extends AbstractPage<
          ListCmsMetadataValuesRequest,
          ListCmsMetadataValuesResponse,
          CmsMetadataValue,
          ListCmsMetadataValuesPage> {

    private ListCmsMetadataValuesPage(
        PageContext<ListCmsMetadataValuesRequest, ListCmsMetadataValuesResponse, CmsMetadataValue>
            context,
        ListCmsMetadataValuesResponse response) {
      super(context, response);
    }

    private static ListCmsMetadataValuesPage createEmptyPage() {
      return new ListCmsMetadataValuesPage(null, null);
    }

    @Override
    protected ListCmsMetadataValuesPage createPage(
        PageContext<ListCmsMetadataValuesRequest, ListCmsMetadataValuesResponse, CmsMetadataValue>
            context,
        ListCmsMetadataValuesResponse response) {
      return new ListCmsMetadataValuesPage(context, response);
    }

    @Override
    public ApiFuture<ListCmsMetadataValuesPage> createPageAsync(
        PageContext<ListCmsMetadataValuesRequest, ListCmsMetadataValuesResponse, CmsMetadataValue>
            context,
        ApiFuture<ListCmsMetadataValuesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCmsMetadataValuesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCmsMetadataValuesRequest,
          ListCmsMetadataValuesResponse,
          CmsMetadataValue,
          ListCmsMetadataValuesPage,
          ListCmsMetadataValuesFixedSizeCollection> {

    private ListCmsMetadataValuesFixedSizeCollection(
        List<ListCmsMetadataValuesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCmsMetadataValuesFixedSizeCollection createEmptyCollection() {
      return new ListCmsMetadataValuesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCmsMetadataValuesFixedSizeCollection createCollection(
        List<ListCmsMetadataValuesPage> pages, int collectionSize) {
      return new ListCmsMetadataValuesFixedSizeCollection(pages, collectionSize);
    }
  }
}
