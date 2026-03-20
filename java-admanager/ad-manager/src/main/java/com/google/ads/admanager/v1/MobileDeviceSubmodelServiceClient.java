/*
 * Copyright 2026 Google LLC
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

import com.google.ads.admanager.v1.stub.MobileDeviceSubmodelServiceStub;
import com.google.ads.admanager.v1.stub.MobileDeviceSubmodelServiceStubSettings;
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
 * Service Description: Provides methods for handling `MobileDeviceSubmodel` objects.
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
 * try (MobileDeviceSubmodelServiceClient mobileDeviceSubmodelServiceClient =
 *     MobileDeviceSubmodelServiceClient.create()) {
 *   MobileDeviceSubmodelName name =
 *       MobileDeviceSubmodelName.of("[NETWORK_CODE]", "[MOBILE_DEVICE_SUBMODEL]");
 *   MobileDeviceSubmodel response =
 *       mobileDeviceSubmodelServiceClient.getMobileDeviceSubmodel(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the MobileDeviceSubmodelServiceClient object to clean up
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
 *      <td><p> GetMobileDeviceSubmodel</td>
 *      <td><p> API to retrieve a `MobileDeviceSubmodel` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getMobileDeviceSubmodel(GetMobileDeviceSubmodelRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getMobileDeviceSubmodel(MobileDeviceSubmodelName name)
 *           <li><p> getMobileDeviceSubmodel(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getMobileDeviceSubmodelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListMobileDeviceSubmodels</td>
 *      <td><p> API to retrieve a list of `MobileDeviceSubmodel` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMobileDeviceSubmodels(ListMobileDeviceSubmodelsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listMobileDeviceSubmodels(NetworkName parent)
 *           <li><p> listMobileDeviceSubmodels(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listMobileDeviceSubmodelsPagedCallable()
 *           <li><p> listMobileDeviceSubmodelsCallable()
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
 * MobileDeviceSubmodelServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MobileDeviceSubmodelServiceSettings mobileDeviceSubmodelServiceSettings =
 *     MobileDeviceSubmodelServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * MobileDeviceSubmodelServiceClient mobileDeviceSubmodelServiceClient =
 *     MobileDeviceSubmodelServiceClient.create(mobileDeviceSubmodelServiceSettings);
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
 * MobileDeviceSubmodelServiceSettings mobileDeviceSubmodelServiceSettings =
 *     MobileDeviceSubmodelServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * MobileDeviceSubmodelServiceClient mobileDeviceSubmodelServiceClient =
 *     MobileDeviceSubmodelServiceClient.create(mobileDeviceSubmodelServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class MobileDeviceSubmodelServiceClient implements BackgroundResource {
  private final MobileDeviceSubmodelServiceSettings settings;
  private final MobileDeviceSubmodelServiceStub stub;

  /** Constructs an instance of MobileDeviceSubmodelServiceClient with default settings. */
  public static final MobileDeviceSubmodelServiceClient create() throws IOException {
    return create(MobileDeviceSubmodelServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of MobileDeviceSubmodelServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final MobileDeviceSubmodelServiceClient create(
      MobileDeviceSubmodelServiceSettings settings) throws IOException {
    return new MobileDeviceSubmodelServiceClient(settings);
  }

  /**
   * Constructs an instance of MobileDeviceSubmodelServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(MobileDeviceSubmodelServiceSettings).
   */
  public static final MobileDeviceSubmodelServiceClient create(
      MobileDeviceSubmodelServiceStub stub) {
    return new MobileDeviceSubmodelServiceClient(stub);
  }

  /**
   * Constructs an instance of MobileDeviceSubmodelServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected MobileDeviceSubmodelServiceClient(MobileDeviceSubmodelServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((MobileDeviceSubmodelServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected MobileDeviceSubmodelServiceClient(MobileDeviceSubmodelServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final MobileDeviceSubmodelServiceSettings getSettings() {
    return settings;
  }

  public MobileDeviceSubmodelServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `MobileDeviceSubmodel` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MobileDeviceSubmodelServiceClient mobileDeviceSubmodelServiceClient =
   *     MobileDeviceSubmodelServiceClient.create()) {
   *   MobileDeviceSubmodelName name =
   *       MobileDeviceSubmodelName.of("[NETWORK_CODE]", "[MOBILE_DEVICE_SUBMODEL]");
   *   MobileDeviceSubmodel response =
   *       mobileDeviceSubmodelServiceClient.getMobileDeviceSubmodel(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the MobileDeviceSubmodel. Format:
   *     `networks/{network_code}/mobileDeviceSubmodels/{mobile_device_submodel_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MobileDeviceSubmodel getMobileDeviceSubmodel(MobileDeviceSubmodelName name) {
    GetMobileDeviceSubmodelRequest request =
        GetMobileDeviceSubmodelRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getMobileDeviceSubmodel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `MobileDeviceSubmodel` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MobileDeviceSubmodelServiceClient mobileDeviceSubmodelServiceClient =
   *     MobileDeviceSubmodelServiceClient.create()) {
   *   String name =
   *       MobileDeviceSubmodelName.of("[NETWORK_CODE]", "[MOBILE_DEVICE_SUBMODEL]").toString();
   *   MobileDeviceSubmodel response =
   *       mobileDeviceSubmodelServiceClient.getMobileDeviceSubmodel(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the MobileDeviceSubmodel. Format:
   *     `networks/{network_code}/mobileDeviceSubmodels/{mobile_device_submodel_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MobileDeviceSubmodel getMobileDeviceSubmodel(String name) {
    GetMobileDeviceSubmodelRequest request =
        GetMobileDeviceSubmodelRequest.newBuilder().setName(name).build();
    return getMobileDeviceSubmodel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `MobileDeviceSubmodel` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MobileDeviceSubmodelServiceClient mobileDeviceSubmodelServiceClient =
   *     MobileDeviceSubmodelServiceClient.create()) {
   *   GetMobileDeviceSubmodelRequest request =
   *       GetMobileDeviceSubmodelRequest.newBuilder()
   *           .setName(
   *               MobileDeviceSubmodelName.of("[NETWORK_CODE]", "[MOBILE_DEVICE_SUBMODEL]")
   *                   .toString())
   *           .build();
   *   MobileDeviceSubmodel response =
   *       mobileDeviceSubmodelServiceClient.getMobileDeviceSubmodel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MobileDeviceSubmodel getMobileDeviceSubmodel(
      GetMobileDeviceSubmodelRequest request) {
    return getMobileDeviceSubmodelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `MobileDeviceSubmodel` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MobileDeviceSubmodelServiceClient mobileDeviceSubmodelServiceClient =
   *     MobileDeviceSubmodelServiceClient.create()) {
   *   GetMobileDeviceSubmodelRequest request =
   *       GetMobileDeviceSubmodelRequest.newBuilder()
   *           .setName(
   *               MobileDeviceSubmodelName.of("[NETWORK_CODE]", "[MOBILE_DEVICE_SUBMODEL]")
   *                   .toString())
   *           .build();
   *   ApiFuture<MobileDeviceSubmodel> future =
   *       mobileDeviceSubmodelServiceClient.getMobileDeviceSubmodelCallable().futureCall(request);
   *   // Do something.
   *   MobileDeviceSubmodel response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMobileDeviceSubmodelRequest, MobileDeviceSubmodel>
      getMobileDeviceSubmodelCallable() {
    return stub.getMobileDeviceSubmodelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `MobileDeviceSubmodel` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MobileDeviceSubmodelServiceClient mobileDeviceSubmodelServiceClient =
   *     MobileDeviceSubmodelServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (MobileDeviceSubmodel element :
   *       mobileDeviceSubmodelServiceClient.listMobileDeviceSubmodels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of MobileDeviceSubmodels.
   *     Format: `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMobileDeviceSubmodelsPagedResponse listMobileDeviceSubmodels(
      NetworkName parent) {
    ListMobileDeviceSubmodelsRequest request =
        ListMobileDeviceSubmodelsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMobileDeviceSubmodels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `MobileDeviceSubmodel` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MobileDeviceSubmodelServiceClient mobileDeviceSubmodelServiceClient =
   *     MobileDeviceSubmodelServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (MobileDeviceSubmodel element :
   *       mobileDeviceSubmodelServiceClient.listMobileDeviceSubmodels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of MobileDeviceSubmodels.
   *     Format: `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMobileDeviceSubmodelsPagedResponse listMobileDeviceSubmodels(String parent) {
    ListMobileDeviceSubmodelsRequest request =
        ListMobileDeviceSubmodelsRequest.newBuilder().setParent(parent).build();
    return listMobileDeviceSubmodels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `MobileDeviceSubmodel` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MobileDeviceSubmodelServiceClient mobileDeviceSubmodelServiceClient =
   *     MobileDeviceSubmodelServiceClient.create()) {
   *   ListMobileDeviceSubmodelsRequest request =
   *       ListMobileDeviceSubmodelsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (MobileDeviceSubmodel element :
   *       mobileDeviceSubmodelServiceClient.listMobileDeviceSubmodels(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMobileDeviceSubmodelsPagedResponse listMobileDeviceSubmodels(
      ListMobileDeviceSubmodelsRequest request) {
    return listMobileDeviceSubmodelsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `MobileDeviceSubmodel` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MobileDeviceSubmodelServiceClient mobileDeviceSubmodelServiceClient =
   *     MobileDeviceSubmodelServiceClient.create()) {
   *   ListMobileDeviceSubmodelsRequest request =
   *       ListMobileDeviceSubmodelsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<MobileDeviceSubmodel> future =
   *       mobileDeviceSubmodelServiceClient
   *           .listMobileDeviceSubmodelsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (MobileDeviceSubmodel element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListMobileDeviceSubmodelsRequest, ListMobileDeviceSubmodelsPagedResponse>
      listMobileDeviceSubmodelsPagedCallable() {
    return stub.listMobileDeviceSubmodelsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `MobileDeviceSubmodel` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MobileDeviceSubmodelServiceClient mobileDeviceSubmodelServiceClient =
   *     MobileDeviceSubmodelServiceClient.create()) {
   *   ListMobileDeviceSubmodelsRequest request =
   *       ListMobileDeviceSubmodelsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListMobileDeviceSubmodelsResponse response =
   *         mobileDeviceSubmodelServiceClient.listMobileDeviceSubmodelsCallable().call(request);
   *     for (MobileDeviceSubmodel element : response.getMobileDeviceSubmodelsList()) {
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
  public final UnaryCallable<ListMobileDeviceSubmodelsRequest, ListMobileDeviceSubmodelsResponse>
      listMobileDeviceSubmodelsCallable() {
    return stub.listMobileDeviceSubmodelsCallable();
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

  public static class ListMobileDeviceSubmodelsPagedResponse
      extends AbstractPagedListResponse<
          ListMobileDeviceSubmodelsRequest,
          ListMobileDeviceSubmodelsResponse,
          MobileDeviceSubmodel,
          ListMobileDeviceSubmodelsPage,
          ListMobileDeviceSubmodelsFixedSizeCollection> {

    public static ApiFuture<ListMobileDeviceSubmodelsPagedResponse> createAsync(
        PageContext<
                ListMobileDeviceSubmodelsRequest,
                ListMobileDeviceSubmodelsResponse,
                MobileDeviceSubmodel>
            context,
        ApiFuture<ListMobileDeviceSubmodelsResponse> futureResponse) {
      ApiFuture<ListMobileDeviceSubmodelsPage> futurePage =
          ListMobileDeviceSubmodelsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMobileDeviceSubmodelsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMobileDeviceSubmodelsPagedResponse(ListMobileDeviceSubmodelsPage page) {
      super(page, ListMobileDeviceSubmodelsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMobileDeviceSubmodelsPage
      extends AbstractPage<
          ListMobileDeviceSubmodelsRequest,
          ListMobileDeviceSubmodelsResponse,
          MobileDeviceSubmodel,
          ListMobileDeviceSubmodelsPage> {

    private ListMobileDeviceSubmodelsPage(
        PageContext<
                ListMobileDeviceSubmodelsRequest,
                ListMobileDeviceSubmodelsResponse,
                MobileDeviceSubmodel>
            context,
        ListMobileDeviceSubmodelsResponse response) {
      super(context, response);
    }

    private static ListMobileDeviceSubmodelsPage createEmptyPage() {
      return new ListMobileDeviceSubmodelsPage(null, null);
    }

    @Override
    protected ListMobileDeviceSubmodelsPage createPage(
        PageContext<
                ListMobileDeviceSubmodelsRequest,
                ListMobileDeviceSubmodelsResponse,
                MobileDeviceSubmodel>
            context,
        ListMobileDeviceSubmodelsResponse response) {
      return new ListMobileDeviceSubmodelsPage(context, response);
    }

    @Override
    public ApiFuture<ListMobileDeviceSubmodelsPage> createPageAsync(
        PageContext<
                ListMobileDeviceSubmodelsRequest,
                ListMobileDeviceSubmodelsResponse,
                MobileDeviceSubmodel>
            context,
        ApiFuture<ListMobileDeviceSubmodelsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMobileDeviceSubmodelsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMobileDeviceSubmodelsRequest,
          ListMobileDeviceSubmodelsResponse,
          MobileDeviceSubmodel,
          ListMobileDeviceSubmodelsPage,
          ListMobileDeviceSubmodelsFixedSizeCollection> {

    private ListMobileDeviceSubmodelsFixedSizeCollection(
        List<ListMobileDeviceSubmodelsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMobileDeviceSubmodelsFixedSizeCollection createEmptyCollection() {
      return new ListMobileDeviceSubmodelsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMobileDeviceSubmodelsFixedSizeCollection createCollection(
        List<ListMobileDeviceSubmodelsPage> pages, int collectionSize) {
      return new ListMobileDeviceSubmodelsFixedSizeCollection(pages, collectionSize);
    }
  }
}
