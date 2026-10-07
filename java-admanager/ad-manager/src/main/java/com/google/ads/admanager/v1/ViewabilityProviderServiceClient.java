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

import com.google.ads.admanager.v1.stub.ViewabilityProviderServiceStub;
import com.google.ads.admanager.v1.stub.ViewabilityProviderServiceStubSettings;
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
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for handling
 * [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] objects.
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
 * try (ViewabilityProviderServiceClient viewabilityProviderServiceClient =
 *     ViewabilityProviderServiceClient.create()) {
 *   ViewabilityProviderName name =
 *       ViewabilityProviderName.of("[NETWORK_CODE]", "[VIEWABILITY_PROVIDER]");
 *   ViewabilityProvider response = viewabilityProviderServiceClient.getViewabilityProvider(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ViewabilityProviderServiceClient object to clean up
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
 *      <td><p> GetViewabilityProvider</td>
 *      <td><p> Retrieves a [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getViewabilityProvider(GetViewabilityProviderRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getViewabilityProvider(ViewabilityProviderName name)
 *           <li><p> getViewabilityProvider(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getViewabilityProviderCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListViewabilityProviders</td>
 *      <td><p> Lists [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listViewabilityProviders(ListViewabilityProvidersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listViewabilityProviders(NetworkName parent)
 *           <li><p> listViewabilityProviders(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listViewabilityProvidersPagedCallable()
 *           <li><p> listViewabilityProvidersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateViewabilityProvider</td>
 *      <td><p> Creates a [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createViewabilityProvider(CreateViewabilityProviderRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createViewabilityProvider(NetworkName parent, ViewabilityProvider viewabilityProvider)
 *           <li><p> createViewabilityProvider(String parent, ViewabilityProvider viewabilityProvider)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createViewabilityProviderCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreateViewabilityProviders</td>
 *      <td><p> Creates [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateViewabilityProviders(NetworkName parent, List&lt;CreateViewabilityProviderRequest&gt; requests)
 *           <li><p> batchCreateViewabilityProviders(String parent, List&lt;CreateViewabilityProviderRequest&gt; requests)
 *           <li><p> batchCreateViewabilityProviders(BatchCreateViewabilityProvidersRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateViewabilityProvidersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateViewabilityProvider</td>
 *      <td><p> Updates a [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateViewabilityProvider(UpdateViewabilityProviderRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateViewabilityProvider(ViewabilityProvider viewabilityProvider, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateViewabilityProviderCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUpdateViewabilityProviders</td>
 *      <td><p> Batch updates [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUpdateViewabilityProviders(NetworkName parent, List&lt;UpdateViewabilityProviderRequest&gt; requests)
 *           <li><p> batchUpdateViewabilityProviders(String parent, List&lt;UpdateViewabilityProviderRequest&gt; requests)
 *           <li><p> batchUpdateViewabilityProviders(BatchUpdateViewabilityProvidersRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUpdateViewabilityProvidersCallable()
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
 * ViewabilityProviderServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ViewabilityProviderServiceSettings viewabilityProviderServiceSettings =
 *     ViewabilityProviderServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ViewabilityProviderServiceClient viewabilityProviderServiceClient =
 *     ViewabilityProviderServiceClient.create(viewabilityProviderServiceSettings);
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
 * ViewabilityProviderServiceSettings viewabilityProviderServiceSettings =
 *     ViewabilityProviderServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ViewabilityProviderServiceClient viewabilityProviderServiceClient =
 *     ViewabilityProviderServiceClient.create(viewabilityProviderServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class ViewabilityProviderServiceClient implements BackgroundResource {
  private final @Nullable ViewabilityProviderServiceSettings settings;
  private final ViewabilityProviderServiceStub stub;

  /** Constructs an instance of ViewabilityProviderServiceClient with default settings. */
  public static final ViewabilityProviderServiceClient create() throws IOException {
    return create(ViewabilityProviderServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ViewabilityProviderServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final ViewabilityProviderServiceClient create(
      ViewabilityProviderServiceSettings settings) throws IOException {
    return new ViewabilityProviderServiceClient(settings);
  }

  /**
   * Constructs an instance of ViewabilityProviderServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(ViewabilityProviderServiceSettings).
   */
  public static final ViewabilityProviderServiceClient create(ViewabilityProviderServiceStub stub) {
    return new ViewabilityProviderServiceClient(stub);
  }

  /**
   * Constructs an instance of ViewabilityProviderServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ViewabilityProviderServiceClient(ViewabilityProviderServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((ViewabilityProviderServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ViewabilityProviderServiceClient(ViewabilityProviderServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable ViewabilityProviderServiceSettings getSettings() {
    return settings;
  }

  public ViewabilityProviderServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ViewabilityProviderServiceClient viewabilityProviderServiceClient =
   *     ViewabilityProviderServiceClient.create()) {
   *   ViewabilityProviderName name =
   *       ViewabilityProviderName.of("[NETWORK_CODE]", "[VIEWABILITY_PROVIDER]");
   *   ViewabilityProvider response = viewabilityProviderServiceClient.getViewabilityProvider(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the
   *     [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider]. Format:
   *     `networks/{network_code}/viewabilityProviders/{viewability_provider}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ViewabilityProvider getViewabilityProvider(@Nullable ViewabilityProviderName name) {
    GetViewabilityProviderRequest request =
        GetViewabilityProviderRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getViewabilityProvider(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ViewabilityProviderServiceClient viewabilityProviderServiceClient =
   *     ViewabilityProviderServiceClient.create()) {
   *   String name =
   *       ViewabilityProviderName.of("[NETWORK_CODE]", "[VIEWABILITY_PROVIDER]").toString();
   *   ViewabilityProvider response = viewabilityProviderServiceClient.getViewabilityProvider(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the
   *     [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider]. Format:
   *     `networks/{network_code}/viewabilityProviders/{viewability_provider}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ViewabilityProvider getViewabilityProvider(String name) {
    GetViewabilityProviderRequest request =
        GetViewabilityProviderRequest.newBuilder().setName(name).build();
    return getViewabilityProvider(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ViewabilityProviderServiceClient viewabilityProviderServiceClient =
   *     ViewabilityProviderServiceClient.create()) {
   *   GetViewabilityProviderRequest request =
   *       GetViewabilityProviderRequest.newBuilder()
   *           .setName(
   *               ViewabilityProviderName.of("[NETWORK_CODE]", "[VIEWABILITY_PROVIDER]").toString())
   *           .build();
   *   ViewabilityProvider response =
   *       viewabilityProviderServiceClient.getViewabilityProvider(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ViewabilityProvider getViewabilityProvider(GetViewabilityProviderRequest request) {
    return getViewabilityProviderCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ViewabilityProviderServiceClient viewabilityProviderServiceClient =
   *     ViewabilityProviderServiceClient.create()) {
   *   GetViewabilityProviderRequest request =
   *       GetViewabilityProviderRequest.newBuilder()
   *           .setName(
   *               ViewabilityProviderName.of("[NETWORK_CODE]", "[VIEWABILITY_PROVIDER]").toString())
   *           .build();
   *   ApiFuture<ViewabilityProvider> future =
   *       viewabilityProviderServiceClient.getViewabilityProviderCallable().futureCall(request);
   *   // Do something.
   *   ViewabilityProvider response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetViewabilityProviderRequest, ViewabilityProvider>
      getViewabilityProviderCallable() {
    return stub.getViewabilityProviderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ViewabilityProviderServiceClient viewabilityProviderServiceClient =
   *     ViewabilityProviderServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (ViewabilityProvider element :
   *       viewabilityProviderServiceClient.listViewabilityProviders(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of
   *     [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider]s. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListViewabilityProvidersPagedResponse listViewabilityProviders(
      @Nullable NetworkName parent) {
    ListViewabilityProvidersRequest request =
        ListViewabilityProvidersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listViewabilityProviders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ViewabilityProviderServiceClient viewabilityProviderServiceClient =
   *     ViewabilityProviderServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (ViewabilityProvider element :
   *       viewabilityProviderServiceClient.listViewabilityProviders(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of
   *     [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider]s. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListViewabilityProvidersPagedResponse listViewabilityProviders(String parent) {
    ListViewabilityProvidersRequest request =
        ListViewabilityProvidersRequest.newBuilder().setParent(parent).build();
    return listViewabilityProviders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ViewabilityProviderServiceClient viewabilityProviderServiceClient =
   *     ViewabilityProviderServiceClient.create()) {
   *   ListViewabilityProvidersRequest request =
   *       ListViewabilityProvidersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (ViewabilityProvider element :
   *       viewabilityProviderServiceClient.listViewabilityProviders(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListViewabilityProvidersPagedResponse listViewabilityProviders(
      ListViewabilityProvidersRequest request) {
    return listViewabilityProvidersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ViewabilityProviderServiceClient viewabilityProviderServiceClient =
   *     ViewabilityProviderServiceClient.create()) {
   *   ListViewabilityProvidersRequest request =
   *       ListViewabilityProvidersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<ViewabilityProvider> future =
   *       viewabilityProviderServiceClient
   *           .listViewabilityProvidersPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (ViewabilityProvider element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListViewabilityProvidersRequest, ListViewabilityProvidersPagedResponse>
      listViewabilityProvidersPagedCallable() {
    return stub.listViewabilityProvidersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ViewabilityProviderServiceClient viewabilityProviderServiceClient =
   *     ViewabilityProviderServiceClient.create()) {
   *   ListViewabilityProvidersRequest request =
   *       ListViewabilityProvidersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListViewabilityProvidersResponse response =
   *         viewabilityProviderServiceClient.listViewabilityProvidersCallable().call(request);
   *     for (ViewabilityProvider element : response.getViewabilityProvidersList()) {
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
  public final UnaryCallable<ListViewabilityProvidersRequest, ListViewabilityProvidersResponse>
      listViewabilityProvidersCallable() {
    return stub.listViewabilityProvidersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ViewabilityProviderServiceClient viewabilityProviderServiceClient =
   *     ViewabilityProviderServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   ViewabilityProvider viewabilityProvider = ViewabilityProvider.newBuilder().build();
   *   ViewabilityProvider response =
   *       viewabilityProviderServiceClient.createViewabilityProvider(parent, viewabilityProvider);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this
   *     [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] will be created. Format:
   *     `networks/{network_code}`
   * @param viewabilityProvider Required. The
   *     [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ViewabilityProvider createViewabilityProvider(
      @Nullable NetworkName parent, ViewabilityProvider viewabilityProvider) {
    CreateViewabilityProviderRequest request =
        CreateViewabilityProviderRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setViewabilityProvider(viewabilityProvider)
            .build();
    return createViewabilityProvider(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ViewabilityProviderServiceClient viewabilityProviderServiceClient =
   *     ViewabilityProviderServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   ViewabilityProvider viewabilityProvider = ViewabilityProvider.newBuilder().build();
   *   ViewabilityProvider response =
   *       viewabilityProviderServiceClient.createViewabilityProvider(parent, viewabilityProvider);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this
   *     [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] will be created. Format:
   *     `networks/{network_code}`
   * @param viewabilityProvider Required. The
   *     [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ViewabilityProvider createViewabilityProvider(
      String parent, ViewabilityProvider viewabilityProvider) {
    CreateViewabilityProviderRequest request =
        CreateViewabilityProviderRequest.newBuilder()
            .setParent(parent)
            .setViewabilityProvider(viewabilityProvider)
            .build();
    return createViewabilityProvider(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ViewabilityProviderServiceClient viewabilityProviderServiceClient =
   *     ViewabilityProviderServiceClient.create()) {
   *   CreateViewabilityProviderRequest request =
   *       CreateViewabilityProviderRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setViewabilityProvider(ViewabilityProvider.newBuilder().build())
   *           .build();
   *   ViewabilityProvider response =
   *       viewabilityProviderServiceClient.createViewabilityProvider(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ViewabilityProvider createViewabilityProvider(
      CreateViewabilityProviderRequest request) {
    return createViewabilityProviderCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ViewabilityProviderServiceClient viewabilityProviderServiceClient =
   *     ViewabilityProviderServiceClient.create()) {
   *   CreateViewabilityProviderRequest request =
   *       CreateViewabilityProviderRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setViewabilityProvider(ViewabilityProvider.newBuilder().build())
   *           .build();
   *   ApiFuture<ViewabilityProvider> future =
   *       viewabilityProviderServiceClient.createViewabilityProviderCallable().futureCall(request);
   *   // Do something.
   *   ViewabilityProvider response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateViewabilityProviderRequest, ViewabilityProvider>
      createViewabilityProviderCallable() {
    return stub.createViewabilityProviderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ViewabilityProviderServiceClient viewabilityProviderServiceClient =
   *     ViewabilityProviderServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<CreateViewabilityProviderRequest> requests = new ArrayList<>();
   *   BatchCreateViewabilityProvidersResponse response =
   *       viewabilityProviderServiceClient.batchCreateViewabilityProviders(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where
   *     [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider]s will be created.
   *     Format: `networks/{network_code}` The parent field in the CreateViewabilityProviderRequest
   *     must match this field.
   * @param requests Required. The
   *     [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] objects to create. A
   *     maximum of 100 objects can be created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateViewabilityProvidersResponse batchCreateViewabilityProviders(
      @Nullable NetworkName parent, List<CreateViewabilityProviderRequest> requests) {
    BatchCreateViewabilityProvidersRequest request =
        BatchCreateViewabilityProvidersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchCreateViewabilityProviders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ViewabilityProviderServiceClient viewabilityProviderServiceClient =
   *     ViewabilityProviderServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<CreateViewabilityProviderRequest> requests = new ArrayList<>();
   *   BatchCreateViewabilityProvidersResponse response =
   *       viewabilityProviderServiceClient.batchCreateViewabilityProviders(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where
   *     [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider]s will be created.
   *     Format: `networks/{network_code}` The parent field in the CreateViewabilityProviderRequest
   *     must match this field.
   * @param requests Required. The
   *     [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] objects to create. A
   *     maximum of 100 objects can be created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateViewabilityProvidersResponse batchCreateViewabilityProviders(
      String parent, List<CreateViewabilityProviderRequest> requests) {
    BatchCreateViewabilityProvidersRequest request =
        BatchCreateViewabilityProvidersRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchCreateViewabilityProviders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ViewabilityProviderServiceClient viewabilityProviderServiceClient =
   *     ViewabilityProviderServiceClient.create()) {
   *   BatchCreateViewabilityProvidersRequest request =
   *       BatchCreateViewabilityProvidersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateViewabilityProviderRequest>())
   *           .build();
   *   BatchCreateViewabilityProvidersResponse response =
   *       viewabilityProviderServiceClient.batchCreateViewabilityProviders(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateViewabilityProvidersResponse batchCreateViewabilityProviders(
      BatchCreateViewabilityProvidersRequest request) {
    return batchCreateViewabilityProvidersCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ViewabilityProviderServiceClient viewabilityProviderServiceClient =
   *     ViewabilityProviderServiceClient.create()) {
   *   BatchCreateViewabilityProvidersRequest request =
   *       BatchCreateViewabilityProvidersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateViewabilityProviderRequest>())
   *           .build();
   *   ApiFuture<BatchCreateViewabilityProvidersResponse> future =
   *       viewabilityProviderServiceClient
   *           .batchCreateViewabilityProvidersCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchCreateViewabilityProvidersResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchCreateViewabilityProvidersRequest, BatchCreateViewabilityProvidersResponse>
      batchCreateViewabilityProvidersCallable() {
    return stub.batchCreateViewabilityProvidersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ViewabilityProviderServiceClient viewabilityProviderServiceClient =
   *     ViewabilityProviderServiceClient.create()) {
   *   ViewabilityProvider viewabilityProvider = ViewabilityProvider.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ViewabilityProvider response =
   *       viewabilityProviderServiceClient.updateViewabilityProvider(
   *           viewabilityProvider, updateMask);
   * }
   * }</pre>
   *
   * @param viewabilityProvider Required. The
   *     [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] to update.
   *     <p>The [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider]'s `name` is used
   *     to identify the [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] to
   *     update.
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ViewabilityProvider updateViewabilityProvider(
      ViewabilityProvider viewabilityProvider, FieldMask updateMask) {
    UpdateViewabilityProviderRequest request =
        UpdateViewabilityProviderRequest.newBuilder()
            .setViewabilityProvider(viewabilityProvider)
            .setUpdateMask(updateMask)
            .build();
    return updateViewabilityProvider(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ViewabilityProviderServiceClient viewabilityProviderServiceClient =
   *     ViewabilityProviderServiceClient.create()) {
   *   UpdateViewabilityProviderRequest request =
   *       UpdateViewabilityProviderRequest.newBuilder()
   *           .setViewabilityProvider(ViewabilityProvider.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ViewabilityProvider response =
   *       viewabilityProviderServiceClient.updateViewabilityProvider(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ViewabilityProvider updateViewabilityProvider(
      UpdateViewabilityProviderRequest request) {
    return updateViewabilityProviderCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ViewabilityProviderServiceClient viewabilityProviderServiceClient =
   *     ViewabilityProviderServiceClient.create()) {
   *   UpdateViewabilityProviderRequest request =
   *       UpdateViewabilityProviderRequest.newBuilder()
   *           .setViewabilityProvider(ViewabilityProvider.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<ViewabilityProvider> future =
   *       viewabilityProviderServiceClient.updateViewabilityProviderCallable().futureCall(request);
   *   // Do something.
   *   ViewabilityProvider response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateViewabilityProviderRequest, ViewabilityProvider>
      updateViewabilityProviderCallable() {
    return stub.updateViewabilityProviderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ViewabilityProviderServiceClient viewabilityProviderServiceClient =
   *     ViewabilityProviderServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<UpdateViewabilityProviderRequest> requests = new ArrayList<>();
   *   BatchUpdateViewabilityProvidersResponse response =
   *       viewabilityProviderServiceClient.batchUpdateViewabilityProviders(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where
   *     [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider]s will be updated.
   *     Format: `networks/{network_code}` The parent field in the UpdateViewabilityProviderRequest
   *     must match this field.
   * @param requests Required. The
   *     [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] objects to update. A
   *     maximum of 100 objects can be updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateViewabilityProvidersResponse batchUpdateViewabilityProviders(
      @Nullable NetworkName parent, List<UpdateViewabilityProviderRequest> requests) {
    BatchUpdateViewabilityProvidersRequest request =
        BatchUpdateViewabilityProvidersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchUpdateViewabilityProviders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ViewabilityProviderServiceClient viewabilityProviderServiceClient =
   *     ViewabilityProviderServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<UpdateViewabilityProviderRequest> requests = new ArrayList<>();
   *   BatchUpdateViewabilityProvidersResponse response =
   *       viewabilityProviderServiceClient.batchUpdateViewabilityProviders(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where
   *     [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider]s will be updated.
   *     Format: `networks/{network_code}` The parent field in the UpdateViewabilityProviderRequest
   *     must match this field.
   * @param requests Required. The
   *     [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] objects to update. A
   *     maximum of 100 objects can be updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateViewabilityProvidersResponse batchUpdateViewabilityProviders(
      String parent, List<UpdateViewabilityProviderRequest> requests) {
    BatchUpdateViewabilityProvidersRequest request =
        BatchUpdateViewabilityProvidersRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchUpdateViewabilityProviders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ViewabilityProviderServiceClient viewabilityProviderServiceClient =
   *     ViewabilityProviderServiceClient.create()) {
   *   BatchUpdateViewabilityProvidersRequest request =
   *       BatchUpdateViewabilityProvidersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateViewabilityProviderRequest>())
   *           .build();
   *   BatchUpdateViewabilityProvidersResponse response =
   *       viewabilityProviderServiceClient.batchUpdateViewabilityProviders(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateViewabilityProvidersResponse batchUpdateViewabilityProviders(
      BatchUpdateViewabilityProvidersRequest request) {
    return batchUpdateViewabilityProvidersCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates [ViewabilityProvider][google.ads.admanager.v1.ViewabilityProvider] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ViewabilityProviderServiceClient viewabilityProviderServiceClient =
   *     ViewabilityProviderServiceClient.create()) {
   *   BatchUpdateViewabilityProvidersRequest request =
   *       BatchUpdateViewabilityProvidersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateViewabilityProviderRequest>())
   *           .build();
   *   ApiFuture<BatchUpdateViewabilityProvidersResponse> future =
   *       viewabilityProviderServiceClient
   *           .batchUpdateViewabilityProvidersCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchUpdateViewabilityProvidersResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchUpdateViewabilityProvidersRequest, BatchUpdateViewabilityProvidersResponse>
      batchUpdateViewabilityProvidersCallable() {
    return stub.batchUpdateViewabilityProvidersCallable();
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

  public static class ListViewabilityProvidersPagedResponse
      extends AbstractPagedListResponse<
          ListViewabilityProvidersRequest,
          ListViewabilityProvidersResponse,
          ViewabilityProvider,
          ListViewabilityProvidersPage,
          ListViewabilityProvidersFixedSizeCollection> {

    public static ApiFuture<ListViewabilityProvidersPagedResponse> createAsync(
        PageContext<
                ListViewabilityProvidersRequest,
                ListViewabilityProvidersResponse,
                ViewabilityProvider>
            context,
        ApiFuture<ListViewabilityProvidersResponse> futureResponse) {
      ApiFuture<ListViewabilityProvidersPage> futurePage =
          ListViewabilityProvidersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListViewabilityProvidersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListViewabilityProvidersPagedResponse(ListViewabilityProvidersPage page) {
      super(page, ListViewabilityProvidersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListViewabilityProvidersPage
      extends AbstractPage<
          ListViewabilityProvidersRequest,
          ListViewabilityProvidersResponse,
          ViewabilityProvider,
          ListViewabilityProvidersPage> {

    private ListViewabilityProvidersPage(
        @Nullable
            PageContext<
                ListViewabilityProvidersRequest,
                ListViewabilityProvidersResponse,
                ViewabilityProvider>
            context,
        @Nullable ListViewabilityProvidersResponse response) {
      super(context, response);
    }

    private static ListViewabilityProvidersPage createEmptyPage() {
      return new ListViewabilityProvidersPage(null, null);
    }

    @Override
    protected ListViewabilityProvidersPage createPage(
        @Nullable
            PageContext<
                ListViewabilityProvidersRequest,
                ListViewabilityProvidersResponse,
                ViewabilityProvider>
            context,
        @Nullable ListViewabilityProvidersResponse response) {
      return new ListViewabilityProvidersPage(context, response);
    }

    @Override
    public ApiFuture<ListViewabilityProvidersPage> createPageAsync(
        @Nullable
            PageContext<
                ListViewabilityProvidersRequest,
                ListViewabilityProvidersResponse,
                ViewabilityProvider>
            context,
        ApiFuture<ListViewabilityProvidersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListViewabilityProvidersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListViewabilityProvidersRequest,
          ListViewabilityProvidersResponse,
          ViewabilityProvider,
          ListViewabilityProvidersPage,
          ListViewabilityProvidersFixedSizeCollection> {

    private ListViewabilityProvidersFixedSizeCollection(
        @Nullable List<ListViewabilityProvidersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListViewabilityProvidersFixedSizeCollection createEmptyCollection() {
      return new ListViewabilityProvidersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListViewabilityProvidersFixedSizeCollection createCollection(
        @Nullable List<ListViewabilityProvidersPage> pages, int collectionSize) {
      return new ListViewabilityProvidersFixedSizeCollection(pages, collectionSize);
    }
  }
}
