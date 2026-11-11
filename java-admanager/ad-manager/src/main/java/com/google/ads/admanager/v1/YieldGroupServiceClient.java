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

import com.google.ads.admanager.v1.stub.YieldGroupServiceStub;
import com.google.ads.admanager.v1.stub.YieldGroupServiceStubSettings;
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
 * Service Description: Provides methods for handling `YieldGroup` objects.
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
 * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
 *   YieldGroupName name = YieldGroupName.of("[NETWORK_CODE]", "[YIELD_GROUP]");
 *   YieldGroup response = yieldGroupServiceClient.getYieldGroup(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the YieldGroupServiceClient object to clean up resources
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
 *      <td><p> GetYieldGroup</td>
 *      <td><p> Retrieves a `YieldGroup` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getYieldGroup(GetYieldGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getYieldGroup(YieldGroupName name)
 *           <li><p> getYieldGroup(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getYieldGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListYieldGroups</td>
 *      <td><p> Lists `YieldGroup` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listYieldGroups(ListYieldGroupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listYieldGroups(NetworkName parent)
 *           <li><p> listYieldGroups(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listYieldGroupsPagedCallable()
 *           <li><p> listYieldGroupsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateYieldGroup</td>
 *      <td><p> Creates a `YieldGroup` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createYieldGroup(CreateYieldGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createYieldGroup(NetworkName parent, YieldGroup yieldGroup)
 *           <li><p> createYieldGroup(String parent, YieldGroup yieldGroup)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createYieldGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreateYieldGroups</td>
 *      <td><p> Batch creates `YieldGroup` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateYieldGroups(NetworkName parent, List&lt;CreateYieldGroupRequest&gt; requests)
 *           <li><p> batchCreateYieldGroups(String parent, List&lt;CreateYieldGroupRequest&gt; requests)
 *           <li><p> batchCreateYieldGroups(BatchCreateYieldGroupsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateYieldGroupsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateYieldGroup</td>
 *      <td><p> Updates a `YieldGroup` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateYieldGroup(UpdateYieldGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateYieldGroup(YieldGroup yieldGroup, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateYieldGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUpdateYieldGroups</td>
 *      <td><p> Batch updates `YieldGroup` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUpdateYieldGroups(NetworkName parent, List&lt;UpdateYieldGroupRequest&gt; requests)
 *           <li><p> batchUpdateYieldGroups(String parent, List&lt;UpdateYieldGroupRequest&gt; requests)
 *           <li><p> batchUpdateYieldGroups(BatchUpdateYieldGroupsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUpdateYieldGroupsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchActivateYieldGroups</td>
 *      <td><p> Activates a list of `YieldGroup` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchActivateYieldGroups(BatchActivateYieldGroupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchActivateYieldGroups(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchActivateYieldGroups(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchActivateYieldGroupsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchDeactivateYieldGroups</td>
 *      <td><p> Deactivates a list of `YieldGroup` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchDeactivateYieldGroups(BatchDeactivateYieldGroupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchDeactivateYieldGroups(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchDeactivateYieldGroups(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchDeactivateYieldGroupsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchArchiveYieldGroups</td>
 *      <td><p> Archives a list of `YieldGroup` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchArchiveYieldGroups(BatchArchiveYieldGroupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchArchiveYieldGroups(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchArchiveYieldGroups(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchArchiveYieldGroupsCallable()
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
 * <p>This class can be customized by passing in a custom instance of YieldGroupServiceSettings to
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
 * YieldGroupServiceSettings yieldGroupServiceSettings =
 *     YieldGroupServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * YieldGroupServiceClient yieldGroupServiceClient =
 *     YieldGroupServiceClient.create(yieldGroupServiceSettings);
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
 * YieldGroupServiceSettings yieldGroupServiceSettings =
 *     YieldGroupServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * YieldGroupServiceClient yieldGroupServiceClient =
 *     YieldGroupServiceClient.create(yieldGroupServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class YieldGroupServiceClient implements BackgroundResource {
  private final @Nullable YieldGroupServiceSettings settings;
  private final YieldGroupServiceStub stub;

  /** Constructs an instance of YieldGroupServiceClient with default settings. */
  public static final YieldGroupServiceClient create() throws IOException {
    return create(YieldGroupServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of YieldGroupServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final YieldGroupServiceClient create(YieldGroupServiceSettings settings)
      throws IOException {
    return new YieldGroupServiceClient(settings);
  }

  /**
   * Constructs an instance of YieldGroupServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(YieldGroupServiceSettings).
   */
  public static final YieldGroupServiceClient create(YieldGroupServiceStub stub) {
    return new YieldGroupServiceClient(stub);
  }

  /**
   * Constructs an instance of YieldGroupServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected YieldGroupServiceClient(YieldGroupServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((YieldGroupServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected YieldGroupServiceClient(YieldGroupServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable YieldGroupServiceSettings getSettings() {
    return settings;
  }

  public YieldGroupServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `YieldGroup` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   YieldGroupName name = YieldGroupName.of("[NETWORK_CODE]", "[YIELD_GROUP]");
   *   YieldGroup response = yieldGroupServiceClient.getYieldGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the `YieldGroup`. Format:
   *     `networks/{network_code}/yieldGroups/{yield_group_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final YieldGroup getYieldGroup(@Nullable YieldGroupName name) {
    GetYieldGroupRequest request =
        GetYieldGroupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getYieldGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `YieldGroup` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   String name = YieldGroupName.of("[NETWORK_CODE]", "[YIELD_GROUP]").toString();
   *   YieldGroup response = yieldGroupServiceClient.getYieldGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the `YieldGroup`. Format:
   *     `networks/{network_code}/yieldGroups/{yield_group_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final YieldGroup getYieldGroup(String name) {
    GetYieldGroupRequest request = GetYieldGroupRequest.newBuilder().setName(name).build();
    return getYieldGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `YieldGroup` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   GetYieldGroupRequest request =
   *       GetYieldGroupRequest.newBuilder()
   *           .setName(YieldGroupName.of("[NETWORK_CODE]", "[YIELD_GROUP]").toString())
   *           .build();
   *   YieldGroup response = yieldGroupServiceClient.getYieldGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final YieldGroup getYieldGroup(GetYieldGroupRequest request) {
    return getYieldGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `YieldGroup` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   GetYieldGroupRequest request =
   *       GetYieldGroupRequest.newBuilder()
   *           .setName(YieldGroupName.of("[NETWORK_CODE]", "[YIELD_GROUP]").toString())
   *           .build();
   *   ApiFuture<YieldGroup> future =
   *       yieldGroupServiceClient.getYieldGroupCallable().futureCall(request);
   *   // Do something.
   *   YieldGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetYieldGroupRequest, YieldGroup> getYieldGroupCallable() {
    return stub.getYieldGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `YieldGroup` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (YieldGroup element : yieldGroupServiceClient.listYieldGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of `YieldGroups`. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListYieldGroupsPagedResponse listYieldGroups(@Nullable NetworkName parent) {
    ListYieldGroupsRequest request =
        ListYieldGroupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listYieldGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `YieldGroup` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (YieldGroup element : yieldGroupServiceClient.listYieldGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of `YieldGroups`. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListYieldGroupsPagedResponse listYieldGroups(String parent) {
    ListYieldGroupsRequest request = ListYieldGroupsRequest.newBuilder().setParent(parent).build();
    return listYieldGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `YieldGroup` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   ListYieldGroupsRequest request =
   *       ListYieldGroupsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (YieldGroup element : yieldGroupServiceClient.listYieldGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListYieldGroupsPagedResponse listYieldGroups(ListYieldGroupsRequest request) {
    return listYieldGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `YieldGroup` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   ListYieldGroupsRequest request =
   *       ListYieldGroupsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<YieldGroup> future =
   *       yieldGroupServiceClient.listYieldGroupsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (YieldGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListYieldGroupsRequest, ListYieldGroupsPagedResponse>
      listYieldGroupsPagedCallable() {
    return stub.listYieldGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `YieldGroup` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   ListYieldGroupsRequest request =
   *       ListYieldGroupsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListYieldGroupsResponse response =
   *         yieldGroupServiceClient.listYieldGroupsCallable().call(request);
   *     for (YieldGroup element : response.getYieldGroupsList()) {
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
  public final UnaryCallable<ListYieldGroupsRequest, ListYieldGroupsResponse>
      listYieldGroupsCallable() {
    return stub.listYieldGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `YieldGroup` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   YieldGroup yieldGroup = YieldGroup.newBuilder().build();
   *   YieldGroup response = yieldGroupServiceClient.createYieldGroup(parent, yieldGroup);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `YieldGroup` will be created. Format:
   *     `networks/{network_code}`
   * @param yieldGroup Required. The `YieldGroup` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final YieldGroup createYieldGroup(@Nullable NetworkName parent, YieldGroup yieldGroup) {
    CreateYieldGroupRequest request =
        CreateYieldGroupRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setYieldGroup(yieldGroup)
            .build();
    return createYieldGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `YieldGroup` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   YieldGroup yieldGroup = YieldGroup.newBuilder().build();
   *   YieldGroup response = yieldGroupServiceClient.createYieldGroup(parent, yieldGroup);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `YieldGroup` will be created. Format:
   *     `networks/{network_code}`
   * @param yieldGroup Required. The `YieldGroup` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final YieldGroup createYieldGroup(String parent, YieldGroup yieldGroup) {
    CreateYieldGroupRequest request =
        CreateYieldGroupRequest.newBuilder().setParent(parent).setYieldGroup(yieldGroup).build();
    return createYieldGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `YieldGroup` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   CreateYieldGroupRequest request =
   *       CreateYieldGroupRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setYieldGroup(YieldGroup.newBuilder().build())
   *           .build();
   *   YieldGroup response = yieldGroupServiceClient.createYieldGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final YieldGroup createYieldGroup(CreateYieldGroupRequest request) {
    return createYieldGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `YieldGroup` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   CreateYieldGroupRequest request =
   *       CreateYieldGroupRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setYieldGroup(YieldGroup.newBuilder().build())
   *           .build();
   *   ApiFuture<YieldGroup> future =
   *       yieldGroupServiceClient.createYieldGroupCallable().futureCall(request);
   *   // Do something.
   *   YieldGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateYieldGroupRequest, YieldGroup> createYieldGroupCallable() {
    return stub.createYieldGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `YieldGroup` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<CreateYieldGroupRequest> requests = new ArrayList<>();
   *   BatchCreateYieldGroupsResponse response =
   *       yieldGroupServiceClient.batchCreateYieldGroups(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `YieldGroups` will be created. Format:
   *     `networks/{network_code}` The parent field in the `CreateYieldGroupRequest` must match this
   *     field.
   * @param requests Required. The `YieldGroup` objects to create. A maximum of 100 objects can be
   *     created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateYieldGroupsResponse batchCreateYieldGroups(
      @Nullable NetworkName parent, List<CreateYieldGroupRequest> requests) {
    BatchCreateYieldGroupsRequest request =
        BatchCreateYieldGroupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchCreateYieldGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `YieldGroup` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<CreateYieldGroupRequest> requests = new ArrayList<>();
   *   BatchCreateYieldGroupsResponse response =
   *       yieldGroupServiceClient.batchCreateYieldGroups(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `YieldGroups` will be created. Format:
   *     `networks/{network_code}` The parent field in the `CreateYieldGroupRequest` must match this
   *     field.
   * @param requests Required. The `YieldGroup` objects to create. A maximum of 100 objects can be
   *     created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateYieldGroupsResponse batchCreateYieldGroups(
      String parent, List<CreateYieldGroupRequest> requests) {
    BatchCreateYieldGroupsRequest request =
        BatchCreateYieldGroupsRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchCreateYieldGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `YieldGroup` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   BatchCreateYieldGroupsRequest request =
   *       BatchCreateYieldGroupsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateYieldGroupRequest>())
   *           .build();
   *   BatchCreateYieldGroupsResponse response =
   *       yieldGroupServiceClient.batchCreateYieldGroups(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateYieldGroupsResponse batchCreateYieldGroups(
      BatchCreateYieldGroupsRequest request) {
    return batchCreateYieldGroupsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `YieldGroup` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   BatchCreateYieldGroupsRequest request =
   *       BatchCreateYieldGroupsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateYieldGroupRequest>())
   *           .build();
   *   ApiFuture<BatchCreateYieldGroupsResponse> future =
   *       yieldGroupServiceClient.batchCreateYieldGroupsCallable().futureCall(request);
   *   // Do something.
   *   BatchCreateYieldGroupsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchCreateYieldGroupsRequest, BatchCreateYieldGroupsResponse>
      batchCreateYieldGroupsCallable() {
    return stub.batchCreateYieldGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `YieldGroup` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   YieldGroup yieldGroup = YieldGroup.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   YieldGroup response = yieldGroupServiceClient.updateYieldGroup(yieldGroup, updateMask);
   * }
   * }</pre>
   *
   * @param yieldGroup Required. The `YieldGroup` to update.
   *     <p>The `YieldGroup`'s `name` is used to identify the `YieldGroup` to update.
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final YieldGroup updateYieldGroup(YieldGroup yieldGroup, FieldMask updateMask) {
    UpdateYieldGroupRequest request =
        UpdateYieldGroupRequest.newBuilder()
            .setYieldGroup(yieldGroup)
            .setUpdateMask(updateMask)
            .build();
    return updateYieldGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `YieldGroup` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   UpdateYieldGroupRequest request =
   *       UpdateYieldGroupRequest.newBuilder()
   *           .setYieldGroup(YieldGroup.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   YieldGroup response = yieldGroupServiceClient.updateYieldGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final YieldGroup updateYieldGroup(UpdateYieldGroupRequest request) {
    return updateYieldGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `YieldGroup` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   UpdateYieldGroupRequest request =
   *       UpdateYieldGroupRequest.newBuilder()
   *           .setYieldGroup(YieldGroup.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<YieldGroup> future =
   *       yieldGroupServiceClient.updateYieldGroupCallable().futureCall(request);
   *   // Do something.
   *   YieldGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateYieldGroupRequest, YieldGroup> updateYieldGroupCallable() {
    return stub.updateYieldGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `YieldGroup` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<UpdateYieldGroupRequest> requests = new ArrayList<>();
   *   BatchUpdateYieldGroupsResponse response =
   *       yieldGroupServiceClient.batchUpdateYieldGroups(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `YieldGroups` will be updated. Format:
   *     `networks/{network_code}` The parent field in the `UpdateYieldGroupRequest` must match this
   *     field.
   * @param requests Required. The `YieldGroup` objects to update. A maximum of 10 objects can be
   *     updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateYieldGroupsResponse batchUpdateYieldGroups(
      @Nullable NetworkName parent, List<UpdateYieldGroupRequest> requests) {
    BatchUpdateYieldGroupsRequest request =
        BatchUpdateYieldGroupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchUpdateYieldGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `YieldGroup` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<UpdateYieldGroupRequest> requests = new ArrayList<>();
   *   BatchUpdateYieldGroupsResponse response =
   *       yieldGroupServiceClient.batchUpdateYieldGroups(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `YieldGroups` will be updated. Format:
   *     `networks/{network_code}` The parent field in the `UpdateYieldGroupRequest` must match this
   *     field.
   * @param requests Required. The `YieldGroup` objects to update. A maximum of 10 objects can be
   *     updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateYieldGroupsResponse batchUpdateYieldGroups(
      String parent, List<UpdateYieldGroupRequest> requests) {
    BatchUpdateYieldGroupsRequest request =
        BatchUpdateYieldGroupsRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchUpdateYieldGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `YieldGroup` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   BatchUpdateYieldGroupsRequest request =
   *       BatchUpdateYieldGroupsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateYieldGroupRequest>())
   *           .build();
   *   BatchUpdateYieldGroupsResponse response =
   *       yieldGroupServiceClient.batchUpdateYieldGroups(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateYieldGroupsResponse batchUpdateYieldGroups(
      BatchUpdateYieldGroupsRequest request) {
    return batchUpdateYieldGroupsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `YieldGroup` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   BatchUpdateYieldGroupsRequest request =
   *       BatchUpdateYieldGroupsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateYieldGroupRequest>())
   *           .build();
   *   ApiFuture<BatchUpdateYieldGroupsResponse> future =
   *       yieldGroupServiceClient.batchUpdateYieldGroupsCallable().futureCall(request);
   *   // Do something.
   *   BatchUpdateYieldGroupsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchUpdateYieldGroupsRequest, BatchUpdateYieldGroupsResponse>
      batchUpdateYieldGroupsCallable() {
    return stub.batchUpdateYieldGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activates a list of `YieldGroup` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchActivateYieldGroupsResponse response =
   *       yieldGroupServiceClient.batchActivateYieldGroups(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of `YieldGroups`. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the `YieldGroups` to activate. Format:
   *     `networks/{network_code}/yieldGroups/{yield_group_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateYieldGroupsResponse batchActivateYieldGroups(
      @Nullable NetworkName parent, List<String> names) {
    BatchActivateYieldGroupsRequest request =
        BatchActivateYieldGroupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchActivateYieldGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activates a list of `YieldGroup` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchActivateYieldGroupsResponse response =
   *       yieldGroupServiceClient.batchActivateYieldGroups(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of `YieldGroups`. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the `YieldGroups` to activate. Format:
   *     `networks/{network_code}/yieldGroups/{yield_group_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateYieldGroupsResponse batchActivateYieldGroups(
      String parent, List<String> names) {
    BatchActivateYieldGroupsRequest request =
        BatchActivateYieldGroupsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchActivateYieldGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activates a list of `YieldGroup` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   BatchActivateYieldGroupsRequest request =
   *       BatchActivateYieldGroupsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchActivateYieldGroupsResponse response =
   *       yieldGroupServiceClient.batchActivateYieldGroups(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateYieldGroupsResponse batchActivateYieldGroups(
      BatchActivateYieldGroupsRequest request) {
    return batchActivateYieldGroupsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activates a list of `YieldGroup` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   BatchActivateYieldGroupsRequest request =
   *       BatchActivateYieldGroupsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchActivateYieldGroupsResponse> future =
   *       yieldGroupServiceClient.batchActivateYieldGroupsCallable().futureCall(request);
   *   // Do something.
   *   BatchActivateYieldGroupsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchActivateYieldGroupsRequest, BatchActivateYieldGroupsResponse>
      batchActivateYieldGroupsCallable() {
    return stub.batchActivateYieldGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `YieldGroup` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchDeactivateYieldGroupsResponse response =
   *       yieldGroupServiceClient.batchDeactivateYieldGroups(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of `YieldGroups`. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the `YieldGroups` to deactivate. Format:
   *     `networks/{network_code}/yieldGroups/{yield_group_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateYieldGroupsResponse batchDeactivateYieldGroups(
      @Nullable NetworkName parent, List<String> names) {
    BatchDeactivateYieldGroupsRequest request =
        BatchDeactivateYieldGroupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchDeactivateYieldGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `YieldGroup` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchDeactivateYieldGroupsResponse response =
   *       yieldGroupServiceClient.batchDeactivateYieldGroups(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of `YieldGroups`. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the `YieldGroups` to deactivate. Format:
   *     `networks/{network_code}/yieldGroups/{yield_group_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateYieldGroupsResponse batchDeactivateYieldGroups(
      String parent, List<String> names) {
    BatchDeactivateYieldGroupsRequest request =
        BatchDeactivateYieldGroupsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchDeactivateYieldGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `YieldGroup` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   BatchDeactivateYieldGroupsRequest request =
   *       BatchDeactivateYieldGroupsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchDeactivateYieldGroupsResponse response =
   *       yieldGroupServiceClient.batchDeactivateYieldGroups(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateYieldGroupsResponse batchDeactivateYieldGroups(
      BatchDeactivateYieldGroupsRequest request) {
    return batchDeactivateYieldGroupsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `YieldGroup` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   BatchDeactivateYieldGroupsRequest request =
   *       BatchDeactivateYieldGroupsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchDeactivateYieldGroupsResponse> future =
   *       yieldGroupServiceClient.batchDeactivateYieldGroupsCallable().futureCall(request);
   *   // Do something.
   *   BatchDeactivateYieldGroupsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchDeactivateYieldGroupsRequest, BatchDeactivateYieldGroupsResponse>
      batchDeactivateYieldGroupsCallable() {
    return stub.batchDeactivateYieldGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives a list of `YieldGroup` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchArchiveYieldGroupsResponse response =
   *       yieldGroupServiceClient.batchArchiveYieldGroups(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of `YieldGroups`. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the `YieldGroups` to archive. Format:
   *     `networks/{network_code}/yieldGroups/{yield_group_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchArchiveYieldGroupsResponse batchArchiveYieldGroups(
      @Nullable NetworkName parent, List<String> names) {
    BatchArchiveYieldGroupsRequest request =
        BatchArchiveYieldGroupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchArchiveYieldGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives a list of `YieldGroup` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchArchiveYieldGroupsResponse response =
   *       yieldGroupServiceClient.batchArchiveYieldGroups(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of `YieldGroups`. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the `YieldGroups` to archive. Format:
   *     `networks/{network_code}/yieldGroups/{yield_group_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchArchiveYieldGroupsResponse batchArchiveYieldGroups(
      String parent, List<String> names) {
    BatchArchiveYieldGroupsRequest request =
        BatchArchiveYieldGroupsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchArchiveYieldGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives a list of `YieldGroup` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   BatchArchiveYieldGroupsRequest request =
   *       BatchArchiveYieldGroupsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchArchiveYieldGroupsResponse response =
   *       yieldGroupServiceClient.batchArchiveYieldGroups(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchArchiveYieldGroupsResponse batchArchiveYieldGroups(
      BatchArchiveYieldGroupsRequest request) {
    return batchArchiveYieldGroupsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives a list of `YieldGroup` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldGroupServiceClient yieldGroupServiceClient = YieldGroupServiceClient.create()) {
   *   BatchArchiveYieldGroupsRequest request =
   *       BatchArchiveYieldGroupsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchArchiveYieldGroupsResponse> future =
   *       yieldGroupServiceClient.batchArchiveYieldGroupsCallable().futureCall(request);
   *   // Do something.
   *   BatchArchiveYieldGroupsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchArchiveYieldGroupsRequest, BatchArchiveYieldGroupsResponse>
      batchArchiveYieldGroupsCallable() {
    return stub.batchArchiveYieldGroupsCallable();
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

  public static class ListYieldGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListYieldGroupsRequest,
          ListYieldGroupsResponse,
          YieldGroup,
          ListYieldGroupsPage,
          ListYieldGroupsFixedSizeCollection> {

    public static ApiFuture<ListYieldGroupsPagedResponse> createAsync(
        PageContext<ListYieldGroupsRequest, ListYieldGroupsResponse, YieldGroup> context,
        ApiFuture<ListYieldGroupsResponse> futureResponse) {
      ApiFuture<ListYieldGroupsPage> futurePage =
          ListYieldGroupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListYieldGroupsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListYieldGroupsPagedResponse(ListYieldGroupsPage page) {
      super(page, ListYieldGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListYieldGroupsPage
      extends AbstractPage<
          ListYieldGroupsRequest, ListYieldGroupsResponse, YieldGroup, ListYieldGroupsPage> {

    private ListYieldGroupsPage(
        @Nullable PageContext<ListYieldGroupsRequest, ListYieldGroupsResponse, YieldGroup> context,
        @Nullable ListYieldGroupsResponse response) {
      super(context, response);
    }

    private static ListYieldGroupsPage createEmptyPage() {
      return new ListYieldGroupsPage(null, null);
    }

    @Override
    protected ListYieldGroupsPage createPage(
        @Nullable PageContext<ListYieldGroupsRequest, ListYieldGroupsResponse, YieldGroup> context,
        @Nullable ListYieldGroupsResponse response) {
      return new ListYieldGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListYieldGroupsPage> createPageAsync(
        @Nullable PageContext<ListYieldGroupsRequest, ListYieldGroupsResponse, YieldGroup> context,
        ApiFuture<ListYieldGroupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListYieldGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListYieldGroupsRequest,
          ListYieldGroupsResponse,
          YieldGroup,
          ListYieldGroupsPage,
          ListYieldGroupsFixedSizeCollection> {

    private ListYieldGroupsFixedSizeCollection(
        @Nullable List<ListYieldGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListYieldGroupsFixedSizeCollection createEmptyCollection() {
      return new ListYieldGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListYieldGroupsFixedSizeCollection createCollection(
        @Nullable List<ListYieldGroupsPage> pages, int collectionSize) {
      return new ListYieldGroupsFixedSizeCollection(pages, collectionSize);
    }
  }
}
