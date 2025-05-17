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

package com.google.shopping.merchant.accounts.v1beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.shopping.merchant.accounts.v1beta.stub.LfpProvidersServiceStub;
import com.google.shopping.merchant.accounts.v1beta.stub.LfpProvidersServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The service facilitates the management of a merchant's LFP provider
 * settings. This API defines the following resource model: -
 * [LfpProvider][google.shopping.merchant.accounts.v1.LfpProvider]
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
 * try (LfpProvidersServiceClient lfpProvidersServiceClient = LfpProvidersServiceClient.create()) {
 *   LfpProviderName name =
 *       LfpProviderName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]", "[LFP_PROVIDER]");
 *   LinkLfpProviderResponse response = lfpProvidersServiceClient.linkLfpProvider(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the LfpProvidersServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> FindLfpProviders</td>
 *      <td><p> Find the LFP provider candidates in a given country.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> findLfpProviders(FindLfpProvidersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> findLfpProviders(OmnichannelSettingName parent)
 *           <li><p> findLfpProviders(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> findLfpProvidersPagedCallable()
 *           <li><p> findLfpProvidersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> LinkLfpProvider</td>
 *      <td><p> Link the specified merchant to a LFP provider for the specified country.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> linkLfpProvider(LinkLfpProviderRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> linkLfpProvider(LfpProviderName name)
 *           <li><p> linkLfpProvider(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> linkLfpProviderCallable()
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
 * <p>This class can be customized by passing in a custom instance of LfpProvidersServiceSettings to
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
 * LfpProvidersServiceSettings lfpProvidersServiceSettings =
 *     LfpProvidersServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * LfpProvidersServiceClient lfpProvidersServiceClient =
 *     LfpProvidersServiceClient.create(lfpProvidersServiceSettings);
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
 * LfpProvidersServiceSettings lfpProvidersServiceSettings =
 *     LfpProvidersServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * LfpProvidersServiceClient lfpProvidersServiceClient =
 *     LfpProvidersServiceClient.create(lfpProvidersServiceSettings);
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
 * LfpProvidersServiceSettings lfpProvidersServiceSettings =
 *     LfpProvidersServiceSettings.newHttpJsonBuilder().build();
 * LfpProvidersServiceClient lfpProvidersServiceClient =
 *     LfpProvidersServiceClient.create(lfpProvidersServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class LfpProvidersServiceClient implements BackgroundResource {
  private final LfpProvidersServiceSettings settings;
  private final LfpProvidersServiceStub stub;

  /** Constructs an instance of LfpProvidersServiceClient with default settings. */
  public static final LfpProvidersServiceClient create() throws IOException {
    return create(LfpProvidersServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of LfpProvidersServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final LfpProvidersServiceClient create(LfpProvidersServiceSettings settings)
      throws IOException {
    return new LfpProvidersServiceClient(settings);
  }

  /**
   * Constructs an instance of LfpProvidersServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(LfpProvidersServiceSettings).
   */
  public static final LfpProvidersServiceClient create(LfpProvidersServiceStub stub) {
    return new LfpProvidersServiceClient(stub);
  }

  /**
   * Constructs an instance of LfpProvidersServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected LfpProvidersServiceClient(LfpProvidersServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((LfpProvidersServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected LfpProvidersServiceClient(LfpProvidersServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final LfpProvidersServiceSettings getSettings() {
    return settings;
  }

  public LfpProvidersServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Find the LFP provider candidates in a given country.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LfpProvidersServiceClient lfpProvidersServiceClient = LfpProvidersServiceClient.create()) {
   *   OmnichannelSettingName parent =
   *       OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]");
   *   for (LfpProvider element : lfpProvidersServiceClient.findLfpProviders(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource under which the LFP providers are
   *     found. Format: `accounts/{account}/omnichannelSettings/{omnichannel_setting}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FindLfpProvidersPagedResponse findLfpProviders(OmnichannelSettingName parent) {
    FindLfpProvidersRequest request =
        FindLfpProvidersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return findLfpProviders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Find the LFP provider candidates in a given country.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LfpProvidersServiceClient lfpProvidersServiceClient = LfpProvidersServiceClient.create()) {
   *   String parent = OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]").toString();
   *   for (LfpProvider element : lfpProvidersServiceClient.findLfpProviders(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource under which the LFP providers are
   *     found. Format: `accounts/{account}/omnichannelSettings/{omnichannel_setting}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FindLfpProvidersPagedResponse findLfpProviders(String parent) {
    FindLfpProvidersRequest request =
        FindLfpProvidersRequest.newBuilder().setParent(parent).build();
    return findLfpProviders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Find the LFP provider candidates in a given country.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LfpProvidersServiceClient lfpProvidersServiceClient = LfpProvidersServiceClient.create()) {
   *   FindLfpProvidersRequest request =
   *       FindLfpProvidersRequest.newBuilder()
   *           .setParent(OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (LfpProvider element : lfpProvidersServiceClient.findLfpProviders(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FindLfpProvidersPagedResponse findLfpProviders(FindLfpProvidersRequest request) {
    return findLfpProvidersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Find the LFP provider candidates in a given country.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LfpProvidersServiceClient lfpProvidersServiceClient = LfpProvidersServiceClient.create()) {
   *   FindLfpProvidersRequest request =
   *       FindLfpProvidersRequest.newBuilder()
   *           .setParent(OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<LfpProvider> future =
   *       lfpProvidersServiceClient.findLfpProvidersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (LfpProvider element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<FindLfpProvidersRequest, FindLfpProvidersPagedResponse>
      findLfpProvidersPagedCallable() {
    return stub.findLfpProvidersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Find the LFP provider candidates in a given country.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LfpProvidersServiceClient lfpProvidersServiceClient = LfpProvidersServiceClient.create()) {
   *   FindLfpProvidersRequest request =
   *       FindLfpProvidersRequest.newBuilder()
   *           .setParent(OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     FindLfpProvidersResponse response =
   *         lfpProvidersServiceClient.findLfpProvidersCallable().call(request);
   *     for (LfpProvider element : response.getLfpProvidersList()) {
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
  public final UnaryCallable<FindLfpProvidersRequest, FindLfpProvidersResponse>
      findLfpProvidersCallable() {
    return stub.findLfpProvidersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Link the specified merchant to a LFP provider for the specified country.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LfpProvidersServiceClient lfpProvidersServiceClient = LfpProvidersServiceClient.create()) {
   *   LfpProviderName name =
   *       LfpProviderName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]", "[LFP_PROVIDER]");
   *   LinkLfpProviderResponse response = lfpProvidersServiceClient.linkLfpProvider(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the LFP provider resource to link. Format:
   *     `accounts/{account}/omnichannelSettings/{omnichannel_setting}/lfpProviders/{lfp_provider}`.
   *     The `lfp_provider` is the LFP provider ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LinkLfpProviderResponse linkLfpProvider(LfpProviderName name) {
    LinkLfpProviderRequest request =
        LinkLfpProviderRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return linkLfpProvider(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Link the specified merchant to a LFP provider for the specified country.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LfpProvidersServiceClient lfpProvidersServiceClient = LfpProvidersServiceClient.create()) {
   *   String name =
   *       LfpProviderName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]", "[LFP_PROVIDER]").toString();
   *   LinkLfpProviderResponse response = lfpProvidersServiceClient.linkLfpProvider(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the LFP provider resource to link. Format:
   *     `accounts/{account}/omnichannelSettings/{omnichannel_setting}/lfpProviders/{lfp_provider}`.
   *     The `lfp_provider` is the LFP provider ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LinkLfpProviderResponse linkLfpProvider(String name) {
    LinkLfpProviderRequest request = LinkLfpProviderRequest.newBuilder().setName(name).build();
    return linkLfpProvider(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Link the specified merchant to a LFP provider for the specified country.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LfpProvidersServiceClient lfpProvidersServiceClient = LfpProvidersServiceClient.create()) {
   *   LinkLfpProviderRequest request =
   *       LinkLfpProviderRequest.newBuilder()
   *           .setName(
   *               LfpProviderName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]", "[LFP_PROVIDER]")
   *                   .toString())
   *           .setExternalAccountId("externalAccountId1814989981")
   *           .build();
   *   LinkLfpProviderResponse response = lfpProvidersServiceClient.linkLfpProvider(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LinkLfpProviderResponse linkLfpProvider(LinkLfpProviderRequest request) {
    return linkLfpProviderCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Link the specified merchant to a LFP provider for the specified country.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LfpProvidersServiceClient lfpProvidersServiceClient = LfpProvidersServiceClient.create()) {
   *   LinkLfpProviderRequest request =
   *       LinkLfpProviderRequest.newBuilder()
   *           .setName(
   *               LfpProviderName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]", "[LFP_PROVIDER]")
   *                   .toString())
   *           .setExternalAccountId("externalAccountId1814989981")
   *           .build();
   *   ApiFuture<LinkLfpProviderResponse> future =
   *       lfpProvidersServiceClient.linkLfpProviderCallable().futureCall(request);
   *   // Do something.
   *   LinkLfpProviderResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<LinkLfpProviderRequest, LinkLfpProviderResponse>
      linkLfpProviderCallable() {
    return stub.linkLfpProviderCallable();
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

  public static class FindLfpProvidersPagedResponse
      extends AbstractPagedListResponse<
          FindLfpProvidersRequest,
          FindLfpProvidersResponse,
          LfpProvider,
          FindLfpProvidersPage,
          FindLfpProvidersFixedSizeCollection> {

    public static ApiFuture<FindLfpProvidersPagedResponse> createAsync(
        PageContext<FindLfpProvidersRequest, FindLfpProvidersResponse, LfpProvider> context,
        ApiFuture<FindLfpProvidersResponse> futureResponse) {
      ApiFuture<FindLfpProvidersPage> futurePage =
          FindLfpProvidersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new FindLfpProvidersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private FindLfpProvidersPagedResponse(FindLfpProvidersPage page) {
      super(page, FindLfpProvidersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class FindLfpProvidersPage
      extends AbstractPage<
          FindLfpProvidersRequest, FindLfpProvidersResponse, LfpProvider, FindLfpProvidersPage> {

    private FindLfpProvidersPage(
        PageContext<FindLfpProvidersRequest, FindLfpProvidersResponse, LfpProvider> context,
        FindLfpProvidersResponse response) {
      super(context, response);
    }

    private static FindLfpProvidersPage createEmptyPage() {
      return new FindLfpProvidersPage(null, null);
    }

    @Override
    protected FindLfpProvidersPage createPage(
        PageContext<FindLfpProvidersRequest, FindLfpProvidersResponse, LfpProvider> context,
        FindLfpProvidersResponse response) {
      return new FindLfpProvidersPage(context, response);
    }

    @Override
    public ApiFuture<FindLfpProvidersPage> createPageAsync(
        PageContext<FindLfpProvidersRequest, FindLfpProvidersResponse, LfpProvider> context,
        ApiFuture<FindLfpProvidersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class FindLfpProvidersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          FindLfpProvidersRequest,
          FindLfpProvidersResponse,
          LfpProvider,
          FindLfpProvidersPage,
          FindLfpProvidersFixedSizeCollection> {

    private FindLfpProvidersFixedSizeCollection(
        List<FindLfpProvidersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static FindLfpProvidersFixedSizeCollection createEmptyCollection() {
      return new FindLfpProvidersFixedSizeCollection(null, 0);
    }

    @Override
    protected FindLfpProvidersFixedSizeCollection createCollection(
        List<FindLfpProvidersPage> pages, int collectionSize) {
      return new FindLfpProvidersFixedSizeCollection(pages, collectionSize);
    }
  }
}
