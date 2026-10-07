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

import com.google.ads.admanager.v1.stub.NativeStyleServiceStub;
import com.google.ads.admanager.v1.stub.NativeStyleServiceStubSettings;
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
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for handling `NativeStyle` objects.
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
 * try (NativeStyleServiceClient nativeStyleServiceClient = NativeStyleServiceClient.create()) {
 *   NativeStyleName name = NativeStyleName.of("[NETWORK_CODE]", "[NATIVE_STYLE]");
 *   NativeStyle response = nativeStyleServiceClient.getNativeStyle(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the NativeStyleServiceClient object to clean up resources
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
 *      <td><p> GetNativeStyle</td>
 *      <td><p> Retrieves a `NativeStyle` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getNativeStyle(GetNativeStyleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getNativeStyle(NativeStyleName name)
 *           <li><p> getNativeStyle(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getNativeStyleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListNativeStyles</td>
 *      <td><p> Lists `NativeStyle` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listNativeStyles(ListNativeStylesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listNativeStyles(NetworkName parent)
 *           <li><p> listNativeStyles(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listNativeStylesPagedCallable()
 *           <li><p> listNativeStylesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreateNativeStyles</td>
 *      <td><p> Creates `NativeStyle` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateNativeStyles(NetworkName parent, List&lt;CreateNativeStyleRequest&gt; requests)
 *           <li><p> batchCreateNativeStyles(String parent, List&lt;CreateNativeStyleRequest&gt; requests)
 *           <li><p> batchCreateNativeStyles(BatchCreateNativeStylesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateNativeStylesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUpdateNativeStyles</td>
 *      <td><p> Batch updates `NativeStyle` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUpdateNativeStyles(NetworkName parent, List&lt;UpdateNativeStyleRequest&gt; requests)
 *           <li><p> batchUpdateNativeStyles(String parent, List&lt;UpdateNativeStyleRequest&gt; requests)
 *           <li><p> batchUpdateNativeStyles(BatchUpdateNativeStylesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUpdateNativeStylesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchActivateNativeStyles</td>
 *      <td><p> Beginning of non-CRUD Activates a list of `NativeStyle` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchActivateNativeStyles(BatchActivateNativeStylesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchActivateNativeStyles(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchActivateNativeStyles(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchActivateNativeStylesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchDeactivateNativeStyles</td>
 *      <td><p> Deactivates a list of `NativeStyle` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchDeactivateNativeStyles(BatchDeactivateNativeStylesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchDeactivateNativeStyles(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchDeactivateNativeStyles(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchDeactivateNativeStylesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchArchiveNativeStyles</td>
 *      <td><p> Archives a list of `NativeStyle` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchArchiveNativeStyles(BatchArchiveNativeStylesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchArchiveNativeStyles(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchArchiveNativeStyles(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchArchiveNativeStylesCallable()
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
 * <p>This class can be customized by passing in a custom instance of NativeStyleServiceSettings to
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
 * NativeStyleServiceSettings nativeStyleServiceSettings =
 *     NativeStyleServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * NativeStyleServiceClient nativeStyleServiceClient =
 *     NativeStyleServiceClient.create(nativeStyleServiceSettings);
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
 * NativeStyleServiceSettings nativeStyleServiceSettings =
 *     NativeStyleServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * NativeStyleServiceClient nativeStyleServiceClient =
 *     NativeStyleServiceClient.create(nativeStyleServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class NativeStyleServiceClient implements BackgroundResource {
  private final @Nullable NativeStyleServiceSettings settings;
  private final NativeStyleServiceStub stub;

  /** Constructs an instance of NativeStyleServiceClient with default settings. */
  public static final NativeStyleServiceClient create() throws IOException {
    return create(NativeStyleServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of NativeStyleServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final NativeStyleServiceClient create(NativeStyleServiceSettings settings)
      throws IOException {
    return new NativeStyleServiceClient(settings);
  }

  /**
   * Constructs an instance of NativeStyleServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(NativeStyleServiceSettings).
   */
  public static final NativeStyleServiceClient create(NativeStyleServiceStub stub) {
    return new NativeStyleServiceClient(stub);
  }

  /**
   * Constructs an instance of NativeStyleServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected NativeStyleServiceClient(NativeStyleServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((NativeStyleServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected NativeStyleServiceClient(NativeStyleServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable NativeStyleServiceSettings getSettings() {
    return settings;
  }

  public NativeStyleServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `NativeStyle` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeStyleServiceClient nativeStyleServiceClient = NativeStyleServiceClient.create()) {
   *   NativeStyleName name = NativeStyleName.of("[NETWORK_CODE]", "[NATIVE_STYLE]");
   *   NativeStyle response = nativeStyleServiceClient.getNativeStyle(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the NativeStyle. Format:
   *     `networks/{network_code}/nativeStyles/{native_style_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NativeStyle getNativeStyle(@Nullable NativeStyleName name) {
    GetNativeStyleRequest request =
        GetNativeStyleRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getNativeStyle(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `NativeStyle` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeStyleServiceClient nativeStyleServiceClient = NativeStyleServiceClient.create()) {
   *   String name = NativeStyleName.of("[NETWORK_CODE]", "[NATIVE_STYLE]").toString();
   *   NativeStyle response = nativeStyleServiceClient.getNativeStyle(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the NativeStyle. Format:
   *     `networks/{network_code}/nativeStyles/{native_style_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NativeStyle getNativeStyle(String name) {
    GetNativeStyleRequest request = GetNativeStyleRequest.newBuilder().setName(name).build();
    return getNativeStyle(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `NativeStyle` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeStyleServiceClient nativeStyleServiceClient = NativeStyleServiceClient.create()) {
   *   GetNativeStyleRequest request =
   *       GetNativeStyleRequest.newBuilder()
   *           .setName(NativeStyleName.of("[NETWORK_CODE]", "[NATIVE_STYLE]").toString())
   *           .build();
   *   NativeStyle response = nativeStyleServiceClient.getNativeStyle(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NativeStyle getNativeStyle(GetNativeStyleRequest request) {
    return getNativeStyleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `NativeStyle` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeStyleServiceClient nativeStyleServiceClient = NativeStyleServiceClient.create()) {
   *   GetNativeStyleRequest request =
   *       GetNativeStyleRequest.newBuilder()
   *           .setName(NativeStyleName.of("[NETWORK_CODE]", "[NATIVE_STYLE]").toString())
   *           .build();
   *   ApiFuture<NativeStyle> future =
   *       nativeStyleServiceClient.getNativeStyleCallable().futureCall(request);
   *   // Do something.
   *   NativeStyle response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetNativeStyleRequest, NativeStyle> getNativeStyleCallable() {
    return stub.getNativeStyleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `NativeStyle` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeStyleServiceClient nativeStyleServiceClient = NativeStyleServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (NativeStyle element : nativeStyleServiceClient.listNativeStyles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of NativeStyles. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNativeStylesPagedResponse listNativeStyles(@Nullable NetworkName parent) {
    ListNativeStylesRequest request =
        ListNativeStylesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listNativeStyles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `NativeStyle` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeStyleServiceClient nativeStyleServiceClient = NativeStyleServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (NativeStyle element : nativeStyleServiceClient.listNativeStyles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of NativeStyles. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNativeStylesPagedResponse listNativeStyles(String parent) {
    ListNativeStylesRequest request =
        ListNativeStylesRequest.newBuilder().setParent(parent).build();
    return listNativeStyles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `NativeStyle` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeStyleServiceClient nativeStyleServiceClient = NativeStyleServiceClient.create()) {
   *   ListNativeStylesRequest request =
   *       ListNativeStylesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (NativeStyle element : nativeStyleServiceClient.listNativeStyles(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNativeStylesPagedResponse listNativeStyles(ListNativeStylesRequest request) {
    return listNativeStylesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `NativeStyle` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeStyleServiceClient nativeStyleServiceClient = NativeStyleServiceClient.create()) {
   *   ListNativeStylesRequest request =
   *       ListNativeStylesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<NativeStyle> future =
   *       nativeStyleServiceClient.listNativeStylesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (NativeStyle element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListNativeStylesRequest, ListNativeStylesPagedResponse>
      listNativeStylesPagedCallable() {
    return stub.listNativeStylesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `NativeStyle` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeStyleServiceClient nativeStyleServiceClient = NativeStyleServiceClient.create()) {
   *   ListNativeStylesRequest request =
   *       ListNativeStylesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListNativeStylesResponse response =
   *         nativeStyleServiceClient.listNativeStylesCallable().call(request);
   *     for (NativeStyle element : response.getNativeStylesList()) {
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
  public final UnaryCallable<ListNativeStylesRequest, ListNativeStylesResponse>
      listNativeStylesCallable() {
    return stub.listNativeStylesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `NativeStyle` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeStyleServiceClient nativeStyleServiceClient = NativeStyleServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<CreateNativeStyleRequest> requests = new ArrayList<>();
   *   BatchCreateNativeStylesResponse response =
   *       nativeStyleServiceClient.batchCreateNativeStyles(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `NativeStyles` will be created. Format:
   *     `networks/{network_code}` The parent field in the CreateNativeStyleRequest must match this
   *     field.
   * @param requests Required. The `NativeStyle` objects to create. A maximum of 100 objects can be
   *     created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateNativeStylesResponse batchCreateNativeStyles(
      @Nullable NetworkName parent, List<CreateNativeStyleRequest> requests) {
    BatchCreateNativeStylesRequest request =
        BatchCreateNativeStylesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchCreateNativeStyles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `NativeStyle` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeStyleServiceClient nativeStyleServiceClient = NativeStyleServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<CreateNativeStyleRequest> requests = new ArrayList<>();
   *   BatchCreateNativeStylesResponse response =
   *       nativeStyleServiceClient.batchCreateNativeStyles(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `NativeStyles` will be created. Format:
   *     `networks/{network_code}` The parent field in the CreateNativeStyleRequest must match this
   *     field.
   * @param requests Required. The `NativeStyle` objects to create. A maximum of 100 objects can be
   *     created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateNativeStylesResponse batchCreateNativeStyles(
      String parent, List<CreateNativeStyleRequest> requests) {
    BatchCreateNativeStylesRequest request =
        BatchCreateNativeStylesRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchCreateNativeStyles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `NativeStyle` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeStyleServiceClient nativeStyleServiceClient = NativeStyleServiceClient.create()) {
   *   BatchCreateNativeStylesRequest request =
   *       BatchCreateNativeStylesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateNativeStyleRequest>())
   *           .build();
   *   BatchCreateNativeStylesResponse response =
   *       nativeStyleServiceClient.batchCreateNativeStyles(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateNativeStylesResponse batchCreateNativeStyles(
      BatchCreateNativeStylesRequest request) {
    return batchCreateNativeStylesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `NativeStyle` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeStyleServiceClient nativeStyleServiceClient = NativeStyleServiceClient.create()) {
   *   BatchCreateNativeStylesRequest request =
   *       BatchCreateNativeStylesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateNativeStyleRequest>())
   *           .build();
   *   ApiFuture<BatchCreateNativeStylesResponse> future =
   *       nativeStyleServiceClient.batchCreateNativeStylesCallable().futureCall(request);
   *   // Do something.
   *   BatchCreateNativeStylesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchCreateNativeStylesRequest, BatchCreateNativeStylesResponse>
      batchCreateNativeStylesCallable() {
    return stub.batchCreateNativeStylesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `NativeStyle` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeStyleServiceClient nativeStyleServiceClient = NativeStyleServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<UpdateNativeStyleRequest> requests = new ArrayList<>();
   *   BatchUpdateNativeStylesResponse response =
   *       nativeStyleServiceClient.batchUpdateNativeStyles(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `NativeStyles` will be updated. Format:
   *     `networks/{network_code}` The parent field in the UpdateNativeStyleRequest must match this
   *     field.
   * @param requests Required. The `NativeStyle` objects to update. A maximum of 100 objects can be
   *     updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateNativeStylesResponse batchUpdateNativeStyles(
      @Nullable NetworkName parent, List<UpdateNativeStyleRequest> requests) {
    BatchUpdateNativeStylesRequest request =
        BatchUpdateNativeStylesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchUpdateNativeStyles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `NativeStyle` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeStyleServiceClient nativeStyleServiceClient = NativeStyleServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<UpdateNativeStyleRequest> requests = new ArrayList<>();
   *   BatchUpdateNativeStylesResponse response =
   *       nativeStyleServiceClient.batchUpdateNativeStyles(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `NativeStyles` will be updated. Format:
   *     `networks/{network_code}` The parent field in the UpdateNativeStyleRequest must match this
   *     field.
   * @param requests Required. The `NativeStyle` objects to update. A maximum of 100 objects can be
   *     updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateNativeStylesResponse batchUpdateNativeStyles(
      String parent, List<UpdateNativeStyleRequest> requests) {
    BatchUpdateNativeStylesRequest request =
        BatchUpdateNativeStylesRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchUpdateNativeStyles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `NativeStyle` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeStyleServiceClient nativeStyleServiceClient = NativeStyleServiceClient.create()) {
   *   BatchUpdateNativeStylesRequest request =
   *       BatchUpdateNativeStylesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateNativeStyleRequest>())
   *           .build();
   *   BatchUpdateNativeStylesResponse response =
   *       nativeStyleServiceClient.batchUpdateNativeStyles(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateNativeStylesResponse batchUpdateNativeStyles(
      BatchUpdateNativeStylesRequest request) {
    return batchUpdateNativeStylesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `NativeStyle` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeStyleServiceClient nativeStyleServiceClient = NativeStyleServiceClient.create()) {
   *   BatchUpdateNativeStylesRequest request =
   *       BatchUpdateNativeStylesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateNativeStyleRequest>())
   *           .build();
   *   ApiFuture<BatchUpdateNativeStylesResponse> future =
   *       nativeStyleServiceClient.batchUpdateNativeStylesCallable().futureCall(request);
   *   // Do something.
   *   BatchUpdateNativeStylesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchUpdateNativeStylesRequest, BatchUpdateNativeStylesResponse>
      batchUpdateNativeStylesCallable() {
    return stub.batchUpdateNativeStylesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Beginning of non-CRUD Activates a list of `NativeStyle` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeStyleServiceClient nativeStyleServiceClient = NativeStyleServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchActivateNativeStylesResponse response =
   *       nativeStyleServiceClient.batchActivateNativeStyles(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. Resource names for the `NativeStyle`s. Format:
   *     `networks/{network_code}/nativeStyles/{native_style_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateNativeStylesResponse batchActivateNativeStyles(
      @Nullable NetworkName parent, List<String> names) {
    BatchActivateNativeStylesRequest request =
        BatchActivateNativeStylesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchActivateNativeStyles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Beginning of non-CRUD Activates a list of `NativeStyle` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeStyleServiceClient nativeStyleServiceClient = NativeStyleServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchActivateNativeStylesResponse response =
   *       nativeStyleServiceClient.batchActivateNativeStyles(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. Resource names for the `NativeStyle`s. Format:
   *     `networks/{network_code}/nativeStyles/{native_style_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateNativeStylesResponse batchActivateNativeStyles(
      String parent, List<String> names) {
    BatchActivateNativeStylesRequest request =
        BatchActivateNativeStylesRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchActivateNativeStyles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Beginning of non-CRUD Activates a list of `NativeStyle` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeStyleServiceClient nativeStyleServiceClient = NativeStyleServiceClient.create()) {
   *   BatchActivateNativeStylesRequest request =
   *       BatchActivateNativeStylesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchActivateNativeStylesResponse response =
   *       nativeStyleServiceClient.batchActivateNativeStyles(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateNativeStylesResponse batchActivateNativeStyles(
      BatchActivateNativeStylesRequest request) {
    return batchActivateNativeStylesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Beginning of non-CRUD Activates a list of `NativeStyle` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeStyleServiceClient nativeStyleServiceClient = NativeStyleServiceClient.create()) {
   *   BatchActivateNativeStylesRequest request =
   *       BatchActivateNativeStylesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchActivateNativeStylesResponse> future =
   *       nativeStyleServiceClient.batchActivateNativeStylesCallable().futureCall(request);
   *   // Do something.
   *   BatchActivateNativeStylesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchActivateNativeStylesRequest, BatchActivateNativeStylesResponse>
      batchActivateNativeStylesCallable() {
    return stub.batchActivateNativeStylesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `NativeStyle` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeStyleServiceClient nativeStyleServiceClient = NativeStyleServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchDeactivateNativeStylesResponse response =
   *       nativeStyleServiceClient.batchDeactivateNativeStyles(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. Resource names for the `NativeStyle`s. Format:
   *     `networks/{network_code}/nativeStyles/{native_style_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateNativeStylesResponse batchDeactivateNativeStyles(
      @Nullable NetworkName parent, List<String> names) {
    BatchDeactivateNativeStylesRequest request =
        BatchDeactivateNativeStylesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchDeactivateNativeStyles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `NativeStyle` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeStyleServiceClient nativeStyleServiceClient = NativeStyleServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchDeactivateNativeStylesResponse response =
   *       nativeStyleServiceClient.batchDeactivateNativeStyles(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. Resource names for the `NativeStyle`s. Format:
   *     `networks/{network_code}/nativeStyles/{native_style_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateNativeStylesResponse batchDeactivateNativeStyles(
      String parent, List<String> names) {
    BatchDeactivateNativeStylesRequest request =
        BatchDeactivateNativeStylesRequest.newBuilder()
            .setParent(parent)
            .addAllNames(names)
            .build();
    return batchDeactivateNativeStyles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `NativeStyle` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeStyleServiceClient nativeStyleServiceClient = NativeStyleServiceClient.create()) {
   *   BatchDeactivateNativeStylesRequest request =
   *       BatchDeactivateNativeStylesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchDeactivateNativeStylesResponse response =
   *       nativeStyleServiceClient.batchDeactivateNativeStyles(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateNativeStylesResponse batchDeactivateNativeStyles(
      BatchDeactivateNativeStylesRequest request) {
    return batchDeactivateNativeStylesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `NativeStyle` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeStyleServiceClient nativeStyleServiceClient = NativeStyleServiceClient.create()) {
   *   BatchDeactivateNativeStylesRequest request =
   *       BatchDeactivateNativeStylesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchDeactivateNativeStylesResponse> future =
   *       nativeStyleServiceClient.batchDeactivateNativeStylesCallable().futureCall(request);
   *   // Do something.
   *   BatchDeactivateNativeStylesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchDeactivateNativeStylesRequest, BatchDeactivateNativeStylesResponse>
      batchDeactivateNativeStylesCallable() {
    return stub.batchDeactivateNativeStylesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives a list of `NativeStyle` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeStyleServiceClient nativeStyleServiceClient = NativeStyleServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchArchiveNativeStylesResponse response =
   *       nativeStyleServiceClient.batchArchiveNativeStyles(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. Resource names for the `NativeStyle`s. Format:
   *     `networks/{network_code}/nativeStyles/{native_style_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchArchiveNativeStylesResponse batchArchiveNativeStyles(
      @Nullable NetworkName parent, List<String> names) {
    BatchArchiveNativeStylesRequest request =
        BatchArchiveNativeStylesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchArchiveNativeStyles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives a list of `NativeStyle` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeStyleServiceClient nativeStyleServiceClient = NativeStyleServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchArchiveNativeStylesResponse response =
   *       nativeStyleServiceClient.batchArchiveNativeStyles(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. Resource names for the `NativeStyle`s. Format:
   *     `networks/{network_code}/nativeStyles/{native_style_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchArchiveNativeStylesResponse batchArchiveNativeStyles(
      String parent, List<String> names) {
    BatchArchiveNativeStylesRequest request =
        BatchArchiveNativeStylesRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchArchiveNativeStyles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives a list of `NativeStyle` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeStyleServiceClient nativeStyleServiceClient = NativeStyleServiceClient.create()) {
   *   BatchArchiveNativeStylesRequest request =
   *       BatchArchiveNativeStylesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchArchiveNativeStylesResponse response =
   *       nativeStyleServiceClient.batchArchiveNativeStyles(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchArchiveNativeStylesResponse batchArchiveNativeStyles(
      BatchArchiveNativeStylesRequest request) {
    return batchArchiveNativeStylesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives a list of `NativeStyle` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeStyleServiceClient nativeStyleServiceClient = NativeStyleServiceClient.create()) {
   *   BatchArchiveNativeStylesRequest request =
   *       BatchArchiveNativeStylesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchArchiveNativeStylesResponse> future =
   *       nativeStyleServiceClient.batchArchiveNativeStylesCallable().futureCall(request);
   *   // Do something.
   *   BatchArchiveNativeStylesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchArchiveNativeStylesRequest, BatchArchiveNativeStylesResponse>
      batchArchiveNativeStylesCallable() {
    return stub.batchArchiveNativeStylesCallable();
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

  public static class ListNativeStylesPagedResponse
      extends AbstractPagedListResponse<
          ListNativeStylesRequest,
          ListNativeStylesResponse,
          NativeStyle,
          ListNativeStylesPage,
          ListNativeStylesFixedSizeCollection> {

    public static ApiFuture<ListNativeStylesPagedResponse> createAsync(
        PageContext<ListNativeStylesRequest, ListNativeStylesResponse, NativeStyle> context,
        ApiFuture<ListNativeStylesResponse> futureResponse) {
      ApiFuture<ListNativeStylesPage> futurePage =
          ListNativeStylesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListNativeStylesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListNativeStylesPagedResponse(ListNativeStylesPage page) {
      super(page, ListNativeStylesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNativeStylesPage
      extends AbstractPage<
          ListNativeStylesRequest, ListNativeStylesResponse, NativeStyle, ListNativeStylesPage> {

    private ListNativeStylesPage(
        @Nullable PageContext<ListNativeStylesRequest, ListNativeStylesResponse, NativeStyle>
            context,
        @Nullable ListNativeStylesResponse response) {
      super(context, response);
    }

    private static ListNativeStylesPage createEmptyPage() {
      return new ListNativeStylesPage(null, null);
    }

    @Override
    protected ListNativeStylesPage createPage(
        @Nullable PageContext<ListNativeStylesRequest, ListNativeStylesResponse, NativeStyle>
            context,
        @Nullable ListNativeStylesResponse response) {
      return new ListNativeStylesPage(context, response);
    }

    @Override
    public ApiFuture<ListNativeStylesPage> createPageAsync(
        @Nullable PageContext<ListNativeStylesRequest, ListNativeStylesResponse, NativeStyle>
            context,
        ApiFuture<ListNativeStylesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNativeStylesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNativeStylesRequest,
          ListNativeStylesResponse,
          NativeStyle,
          ListNativeStylesPage,
          ListNativeStylesFixedSizeCollection> {

    private ListNativeStylesFixedSizeCollection(
        @Nullable List<ListNativeStylesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNativeStylesFixedSizeCollection createEmptyCollection() {
      return new ListNativeStylesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNativeStylesFixedSizeCollection createCollection(
        @Nullable List<ListNativeStylesPage> pages, int collectionSize) {
      return new ListNativeStylesFixedSizeCollection(pages, collectionSize);
    }
  }
}
