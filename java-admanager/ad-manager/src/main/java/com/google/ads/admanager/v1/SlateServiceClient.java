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

import com.google.ads.admanager.v1.stub.SlateServiceStub;
import com.google.ads.admanager.v1.stub.SlateServiceStubSettings;
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
 * Service Description: Provides methods for handling `Slate` objects.
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
 * try (SlateServiceClient slateServiceClient = SlateServiceClient.create()) {
 *   SlateName name = SlateName.of("[NETWORK_CODE]", "[SLATE]");
 *   Slate response = slateServiceClient.getSlate(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SlateServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetSlate</td>
 *      <td><p> Retrieves a `Slate` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSlate(GetSlateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSlate(SlateName name)
 *           <li><p> getSlate(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSlateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSlates</td>
 *      <td><p> Lists `Slate` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSlates(ListSlatesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSlates(NetworkName parent)
 *           <li><p> listSlates(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSlatesPagedCallable()
 *           <li><p> listSlatesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSlate</td>
 *      <td><p> Creates a `Slate` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSlate(CreateSlateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createSlate(NetworkName parent, Slate slate)
 *           <li><p> createSlate(String parent, Slate slate)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSlateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreateSlates</td>
 *      <td><p> Batch creates `Slate` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateSlates(NetworkName parent, List&lt;CreateSlateRequest&gt; requests)
 *           <li><p> batchCreateSlates(String parent, List&lt;CreateSlateRequest&gt; requests)
 *           <li><p> batchCreateSlates(BatchCreateSlatesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateSlatesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSlate</td>
 *      <td><p> Updates a `Slate` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSlate(UpdateSlateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateSlate(Slate slate, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSlateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUpdateSlates</td>
 *      <td><p> Batch updates `Slate` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUpdateSlates(NetworkName parent, List&lt;UpdateSlateRequest&gt; requests)
 *           <li><p> batchUpdateSlates(String parent, List&lt;UpdateSlateRequest&gt; requests)
 *           <li><p> batchUpdateSlates(BatchUpdateSlatesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUpdateSlatesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchArchiveSlates</td>
 *      <td><p> Batch archives `Slate` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchArchiveSlates(BatchArchiveSlatesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchArchiveSlates(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchArchiveSlates(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchArchiveSlatesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUnarchiveSlates</td>
 *      <td><p> Batch unarchives `Slate` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUnarchiveSlates(BatchUnarchiveSlatesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchUnarchiveSlates(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchUnarchiveSlates(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUnarchiveSlatesCallable()
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
 * <p>This class can be customized by passing in a custom instance of SlateServiceSettings to
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
 * SlateServiceSettings slateServiceSettings =
 *     SlateServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SlateServiceClient slateServiceClient = SlateServiceClient.create(slateServiceSettings);
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
 * SlateServiceSettings slateServiceSettings =
 *     SlateServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SlateServiceClient slateServiceClient = SlateServiceClient.create(slateServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class SlateServiceClient implements BackgroundResource {
  private final @Nullable SlateServiceSettings settings;
  private final SlateServiceStub stub;

  /** Constructs an instance of SlateServiceClient with default settings. */
  public static final SlateServiceClient create() throws IOException {
    return create(SlateServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SlateServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SlateServiceClient create(SlateServiceSettings settings) throws IOException {
    return new SlateServiceClient(settings);
  }

  /**
   * Constructs an instance of SlateServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(SlateServiceSettings).
   */
  public static final SlateServiceClient create(SlateServiceStub stub) {
    return new SlateServiceClient(stub);
  }

  /**
   * Constructs an instance of SlateServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected SlateServiceClient(SlateServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SlateServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected SlateServiceClient(SlateServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable SlateServiceSettings getSettings() {
    return settings;
  }

  public SlateServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `Slate` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SlateServiceClient slateServiceClient = SlateServiceClient.create()) {
   *   SlateName name = SlateName.of("[NETWORK_CODE]", "[SLATE]");
   *   Slate response = slateServiceClient.getSlate(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Slate to retrieve. Format:
   *     `networks/{network_code}/slates/{slate_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Slate getSlate(@Nullable SlateName name) {
    GetSlateRequest request =
        GetSlateRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSlate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `Slate` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SlateServiceClient slateServiceClient = SlateServiceClient.create()) {
   *   String name = SlateName.of("[NETWORK_CODE]", "[SLATE]").toString();
   *   Slate response = slateServiceClient.getSlate(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Slate to retrieve. Format:
   *     `networks/{network_code}/slates/{slate_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Slate getSlate(String name) {
    GetSlateRequest request = GetSlateRequest.newBuilder().setName(name).build();
    return getSlate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `Slate` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SlateServiceClient slateServiceClient = SlateServiceClient.create()) {
   *   GetSlateRequest request =
   *       GetSlateRequest.newBuilder()
   *           .setName(SlateName.of("[NETWORK_CODE]", "[SLATE]").toString())
   *           .build();
   *   Slate response = slateServiceClient.getSlate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Slate getSlate(GetSlateRequest request) {
    return getSlateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `Slate` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SlateServiceClient slateServiceClient = SlateServiceClient.create()) {
   *   GetSlateRequest request =
   *       GetSlateRequest.newBuilder()
   *           .setName(SlateName.of("[NETWORK_CODE]", "[SLATE]").toString())
   *           .build();
   *   ApiFuture<Slate> future = slateServiceClient.getSlateCallable().futureCall(request);
   *   // Do something.
   *   Slate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSlateRequest, Slate> getSlateCallable() {
    return stub.getSlateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `Slate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SlateServiceClient slateServiceClient = SlateServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (Slate element : slateServiceClient.listSlates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource containing the Slates. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSlatesPagedResponse listSlates(@Nullable NetworkName parent) {
    ListSlatesRequest request =
        ListSlatesRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listSlates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `Slate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SlateServiceClient slateServiceClient = SlateServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (Slate element : slateServiceClient.listSlates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource containing the Slates. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSlatesPagedResponse listSlates(String parent) {
    ListSlatesRequest request = ListSlatesRequest.newBuilder().setParent(parent).build();
    return listSlates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `Slate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SlateServiceClient slateServiceClient = SlateServiceClient.create()) {
   *   ListSlatesRequest request =
   *       ListSlatesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (Slate element : slateServiceClient.listSlates(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSlatesPagedResponse listSlates(ListSlatesRequest request) {
    return listSlatesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `Slate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SlateServiceClient slateServiceClient = SlateServiceClient.create()) {
   *   ListSlatesRequest request =
   *       ListSlatesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<Slate> future = slateServiceClient.listSlatesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Slate element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSlatesRequest, ListSlatesPagedResponse> listSlatesPagedCallable() {
    return stub.listSlatesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `Slate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SlateServiceClient slateServiceClient = SlateServiceClient.create()) {
   *   ListSlatesRequest request =
   *       ListSlatesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListSlatesResponse response = slateServiceClient.listSlatesCallable().call(request);
   *     for (Slate element : response.getSlatesList()) {
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
  public final UnaryCallable<ListSlatesRequest, ListSlatesResponse> listSlatesCallable() {
    return stub.listSlatesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `Slate` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SlateServiceClient slateServiceClient = SlateServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   Slate slate = Slate.newBuilder().build();
   *   Slate response = slateServiceClient.createSlate(parent, slate);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `Slate` will be created. Format:
   *     `networks/{network_code}`
   * @param slate Required. The `Slate` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Slate createSlate(@Nullable NetworkName parent, Slate slate) {
    CreateSlateRequest request =
        CreateSlateRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSlate(slate)
            .build();
    return createSlate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `Slate` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SlateServiceClient slateServiceClient = SlateServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   Slate slate = Slate.newBuilder().build();
   *   Slate response = slateServiceClient.createSlate(parent, slate);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `Slate` will be created. Format:
   *     `networks/{network_code}`
   * @param slate Required. The `Slate` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Slate createSlate(String parent, Slate slate) {
    CreateSlateRequest request =
        CreateSlateRequest.newBuilder().setParent(parent).setSlate(slate).build();
    return createSlate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `Slate` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SlateServiceClient slateServiceClient = SlateServiceClient.create()) {
   *   CreateSlateRequest request =
   *       CreateSlateRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setSlate(Slate.newBuilder().build())
   *           .build();
   *   Slate response = slateServiceClient.createSlate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Slate createSlate(CreateSlateRequest request) {
    return createSlateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `Slate` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SlateServiceClient slateServiceClient = SlateServiceClient.create()) {
   *   CreateSlateRequest request =
   *       CreateSlateRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setSlate(Slate.newBuilder().build())
   *           .build();
   *   ApiFuture<Slate> future = slateServiceClient.createSlateCallable().futureCall(request);
   *   // Do something.
   *   Slate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSlateRequest, Slate> createSlateCallable() {
    return stub.createSlateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `Slate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SlateServiceClient slateServiceClient = SlateServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<CreateSlateRequest> requests = new ArrayList<>();
   *   BatchCreateSlatesResponse response = slateServiceClient.batchCreateSlates(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `Slates` will be created. Format:
   *     `networks/{network_code}` The parent field in the CreateSlateRequest must match this field.
   * @param requests Required. The `Slate` objects to create. A maximum of 100 objects can be
   *     created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateSlatesResponse batchCreateSlates(
      @Nullable NetworkName parent, List<CreateSlateRequest> requests) {
    BatchCreateSlatesRequest request =
        BatchCreateSlatesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchCreateSlates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `Slate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SlateServiceClient slateServiceClient = SlateServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<CreateSlateRequest> requests = new ArrayList<>();
   *   BatchCreateSlatesResponse response = slateServiceClient.batchCreateSlates(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `Slates` will be created. Format:
   *     `networks/{network_code}` The parent field in the CreateSlateRequest must match this field.
   * @param requests Required. The `Slate` objects to create. A maximum of 100 objects can be
   *     created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateSlatesResponse batchCreateSlates(
      String parent, List<CreateSlateRequest> requests) {
    BatchCreateSlatesRequest request =
        BatchCreateSlatesRequest.newBuilder().setParent(parent).addAllRequests(requests).build();
    return batchCreateSlates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `Slate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SlateServiceClient slateServiceClient = SlateServiceClient.create()) {
   *   BatchCreateSlatesRequest request =
   *       BatchCreateSlatesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateSlateRequest>())
   *           .build();
   *   BatchCreateSlatesResponse response = slateServiceClient.batchCreateSlates(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateSlatesResponse batchCreateSlates(BatchCreateSlatesRequest request) {
    return batchCreateSlatesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `Slate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SlateServiceClient slateServiceClient = SlateServiceClient.create()) {
   *   BatchCreateSlatesRequest request =
   *       BatchCreateSlatesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateSlateRequest>())
   *           .build();
   *   ApiFuture<BatchCreateSlatesResponse> future =
   *       slateServiceClient.batchCreateSlatesCallable().futureCall(request);
   *   // Do something.
   *   BatchCreateSlatesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchCreateSlatesRequest, BatchCreateSlatesResponse>
      batchCreateSlatesCallable() {
    return stub.batchCreateSlatesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `Slate` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SlateServiceClient slateServiceClient = SlateServiceClient.create()) {
   *   Slate slate = Slate.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Slate response = slateServiceClient.updateSlate(slate, updateMask);
   * }
   * }</pre>
   *
   * @param slate Required. The `Slate` to update.
   *     <p>The `Slate`'s `name` is used to identify the `Slate` to update.
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Slate updateSlate(Slate slate, FieldMask updateMask) {
    UpdateSlateRequest request =
        UpdateSlateRequest.newBuilder().setSlate(slate).setUpdateMask(updateMask).build();
    return updateSlate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `Slate` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SlateServiceClient slateServiceClient = SlateServiceClient.create()) {
   *   UpdateSlateRequest request =
   *       UpdateSlateRequest.newBuilder()
   *           .setSlate(Slate.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Slate response = slateServiceClient.updateSlate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Slate updateSlate(UpdateSlateRequest request) {
    return updateSlateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `Slate` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SlateServiceClient slateServiceClient = SlateServiceClient.create()) {
   *   UpdateSlateRequest request =
   *       UpdateSlateRequest.newBuilder()
   *           .setSlate(Slate.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Slate> future = slateServiceClient.updateSlateCallable().futureCall(request);
   *   // Do something.
   *   Slate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSlateRequest, Slate> updateSlateCallable() {
    return stub.updateSlateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `Slate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SlateServiceClient slateServiceClient = SlateServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<UpdateSlateRequest> requests = new ArrayList<>();
   *   BatchUpdateSlatesResponse response = slateServiceClient.batchUpdateSlates(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `Slates` will be updated. Format:
   *     `networks/{network_code}` The parent field in the UpdateSlateRequest must match this field.
   * @param requests Required. The `Slate` objects to update. A maximum of 100 objects can be
   *     updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateSlatesResponse batchUpdateSlates(
      @Nullable NetworkName parent, List<UpdateSlateRequest> requests) {
    BatchUpdateSlatesRequest request =
        BatchUpdateSlatesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchUpdateSlates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `Slate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SlateServiceClient slateServiceClient = SlateServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<UpdateSlateRequest> requests = new ArrayList<>();
   *   BatchUpdateSlatesResponse response = slateServiceClient.batchUpdateSlates(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `Slates` will be updated. Format:
   *     `networks/{network_code}` The parent field in the UpdateSlateRequest must match this field.
   * @param requests Required. The `Slate` objects to update. A maximum of 100 objects can be
   *     updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateSlatesResponse batchUpdateSlates(
      String parent, List<UpdateSlateRequest> requests) {
    BatchUpdateSlatesRequest request =
        BatchUpdateSlatesRequest.newBuilder().setParent(parent).addAllRequests(requests).build();
    return batchUpdateSlates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `Slate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SlateServiceClient slateServiceClient = SlateServiceClient.create()) {
   *   BatchUpdateSlatesRequest request =
   *       BatchUpdateSlatesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateSlateRequest>())
   *           .build();
   *   BatchUpdateSlatesResponse response = slateServiceClient.batchUpdateSlates(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateSlatesResponse batchUpdateSlates(BatchUpdateSlatesRequest request) {
    return batchUpdateSlatesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `Slate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SlateServiceClient slateServiceClient = SlateServiceClient.create()) {
   *   BatchUpdateSlatesRequest request =
   *       BatchUpdateSlatesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateSlateRequest>())
   *           .build();
   *   ApiFuture<BatchUpdateSlatesResponse> future =
   *       slateServiceClient.batchUpdateSlatesCallable().futureCall(request);
   *   // Do something.
   *   BatchUpdateSlatesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchUpdateSlatesRequest, BatchUpdateSlatesResponse>
      batchUpdateSlatesCallable() {
    return stub.batchUpdateSlatesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch archives `Slate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SlateServiceClient slateServiceClient = SlateServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchArchiveSlatesResponse response = slateServiceClient.batchArchiveSlates(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource containing the slates. Format:
   *     "networks/{network_code}"
   * @param names Required. The resource names of the slates to archive. Format:
   *     "networks/{network_code}/slates/{slate_id}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchArchiveSlatesResponse batchArchiveSlates(
      @Nullable NetworkName parent, List<String> names) {
    BatchArchiveSlatesRequest request =
        BatchArchiveSlatesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchArchiveSlates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch archives `Slate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SlateServiceClient slateServiceClient = SlateServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchArchiveSlatesResponse response = slateServiceClient.batchArchiveSlates(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource containing the slates. Format:
   *     "networks/{network_code}"
   * @param names Required. The resource names of the slates to archive. Format:
   *     "networks/{network_code}/slates/{slate_id}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchArchiveSlatesResponse batchArchiveSlates(String parent, List<String> names) {
    BatchArchiveSlatesRequest request =
        BatchArchiveSlatesRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchArchiveSlates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch archives `Slate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SlateServiceClient slateServiceClient = SlateServiceClient.create()) {
   *   BatchArchiveSlatesRequest request =
   *       BatchArchiveSlatesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchArchiveSlatesResponse response = slateServiceClient.batchArchiveSlates(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchArchiveSlatesResponse batchArchiveSlates(BatchArchiveSlatesRequest request) {
    return batchArchiveSlatesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch archives `Slate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SlateServiceClient slateServiceClient = SlateServiceClient.create()) {
   *   BatchArchiveSlatesRequest request =
   *       BatchArchiveSlatesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchArchiveSlatesResponse> future =
   *       slateServiceClient.batchArchiveSlatesCallable().futureCall(request);
   *   // Do something.
   *   BatchArchiveSlatesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchArchiveSlatesRequest, BatchArchiveSlatesResponse>
      batchArchiveSlatesCallable() {
    return stub.batchArchiveSlatesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch unarchives `Slate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SlateServiceClient slateServiceClient = SlateServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchUnarchiveSlatesResponse response =
   *       slateServiceClient.batchUnarchiveSlates(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource containing the slates. Format:
   *     "networks/{network_code}"
   * @param names Required. The resource names of the slates to unarchive. Format:
   *     "networks/{network_code}/slates/{slate_id}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUnarchiveSlatesResponse batchUnarchiveSlates(
      @Nullable NetworkName parent, List<String> names) {
    BatchUnarchiveSlatesRequest request =
        BatchUnarchiveSlatesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchUnarchiveSlates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch unarchives `Slate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SlateServiceClient slateServiceClient = SlateServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchUnarchiveSlatesResponse response =
   *       slateServiceClient.batchUnarchiveSlates(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource containing the slates. Format:
   *     "networks/{network_code}"
   * @param names Required. The resource names of the slates to unarchive. Format:
   *     "networks/{network_code}/slates/{slate_id}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUnarchiveSlatesResponse batchUnarchiveSlates(
      String parent, List<String> names) {
    BatchUnarchiveSlatesRequest request =
        BatchUnarchiveSlatesRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchUnarchiveSlates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch unarchives `Slate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SlateServiceClient slateServiceClient = SlateServiceClient.create()) {
   *   BatchUnarchiveSlatesRequest request =
   *       BatchUnarchiveSlatesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchUnarchiveSlatesResponse response = slateServiceClient.batchUnarchiveSlates(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUnarchiveSlatesResponse batchUnarchiveSlates(
      BatchUnarchiveSlatesRequest request) {
    return batchUnarchiveSlatesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch unarchives `Slate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SlateServiceClient slateServiceClient = SlateServiceClient.create()) {
   *   BatchUnarchiveSlatesRequest request =
   *       BatchUnarchiveSlatesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchUnarchiveSlatesResponse> future =
   *       slateServiceClient.batchUnarchiveSlatesCallable().futureCall(request);
   *   // Do something.
   *   BatchUnarchiveSlatesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchUnarchiveSlatesRequest, BatchUnarchiveSlatesResponse>
      batchUnarchiveSlatesCallable() {
    return stub.batchUnarchiveSlatesCallable();
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

  public static class ListSlatesPagedResponse
      extends AbstractPagedListResponse<
          ListSlatesRequest,
          ListSlatesResponse,
          Slate,
          ListSlatesPage,
          ListSlatesFixedSizeCollection> {

    public static ApiFuture<ListSlatesPagedResponse> createAsync(
        PageContext<ListSlatesRequest, ListSlatesResponse, Slate> context,
        ApiFuture<ListSlatesResponse> futureResponse) {
      ApiFuture<ListSlatesPage> futurePage =
          ListSlatesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListSlatesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListSlatesPagedResponse(ListSlatesPage page) {
      super(page, ListSlatesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSlatesPage
      extends AbstractPage<ListSlatesRequest, ListSlatesResponse, Slate, ListSlatesPage> {

    private ListSlatesPage(
        @Nullable PageContext<ListSlatesRequest, ListSlatesResponse, Slate> context,
        @Nullable ListSlatesResponse response) {
      super(context, response);
    }

    private static ListSlatesPage createEmptyPage() {
      return new ListSlatesPage(null, null);
    }

    @Override
    protected ListSlatesPage createPage(
        @Nullable PageContext<ListSlatesRequest, ListSlatesResponse, Slate> context,
        @Nullable ListSlatesResponse response) {
      return new ListSlatesPage(context, response);
    }

    @Override
    public ApiFuture<ListSlatesPage> createPageAsync(
        @Nullable PageContext<ListSlatesRequest, ListSlatesResponse, Slate> context,
        ApiFuture<ListSlatesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSlatesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSlatesRequest,
          ListSlatesResponse,
          Slate,
          ListSlatesPage,
          ListSlatesFixedSizeCollection> {

    private ListSlatesFixedSizeCollection(
        @Nullable List<ListSlatesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSlatesFixedSizeCollection createEmptyCollection() {
      return new ListSlatesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSlatesFixedSizeCollection createCollection(
        @Nullable List<ListSlatesPage> pages, int collectionSize) {
      return new ListSlatesFixedSizeCollection(pages, collectionSize);
    }
  }
}
