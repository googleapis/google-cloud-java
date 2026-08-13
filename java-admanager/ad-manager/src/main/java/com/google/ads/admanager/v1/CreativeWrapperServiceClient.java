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

import com.google.ads.admanager.v1.stub.CreativeWrapperServiceStub;
import com.google.ads.admanager.v1.stub.CreativeWrapperServiceStubSettings;
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
 * Service Description: Provides methods for handling `CreativeWrapper` objects.
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
 * try (CreativeWrapperServiceClient creativeWrapperServiceClient =
 *     CreativeWrapperServiceClient.create()) {
 *   CreativeWrapperName name = CreativeWrapperName.of("[NETWORK_CODE]", "[CREATIVE_WRAPPER]");
 *   CreativeWrapper response = creativeWrapperServiceClient.getCreativeWrapper(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CreativeWrapperServiceClient object to clean up
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
 *      <td><p> GetCreativeWrapper</td>
 *      <td><p> Retrieves a `CreativeWrapper` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCreativeWrapper(GetCreativeWrapperRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCreativeWrapper(CreativeWrapperName name)
 *           <li><p> getCreativeWrapper(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCreativeWrapperCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCreativeWrappers</td>
 *      <td><p> Lists `CreativeWrapper` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCreativeWrappers(ListCreativeWrappersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCreativeWrappers(NetworkName parent)
 *           <li><p> listCreativeWrappers(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCreativeWrappersPagedCallable()
 *           <li><p> listCreativeWrappersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateCreativeWrapper</td>
 *      <td><p> Creates a `CreativeWrapper` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createCreativeWrapper(CreateCreativeWrapperRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createCreativeWrapper(NetworkName parent, CreativeWrapper creativeWrapper)
 *           <li><p> createCreativeWrapper(String parent, CreativeWrapper creativeWrapper)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createCreativeWrapperCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreateCreativeWrappers</td>
 *      <td><p> Creates `CreativeWrapper` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateCreativeWrappers(NetworkName parent, List&lt;CreateCreativeWrapperRequest&gt; requests)
 *           <li><p> batchCreateCreativeWrappers(String parent, List&lt;CreateCreativeWrapperRequest&gt; requests)
 *           <li><p> batchCreateCreativeWrappers(BatchCreateCreativeWrappersRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateCreativeWrappersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateCreativeWrapper</td>
 *      <td><p> Updates a `CreativeWrapper` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateCreativeWrapper(UpdateCreativeWrapperRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateCreativeWrapper(CreativeWrapper creativeWrapper, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateCreativeWrapperCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUpdateCreativeWrappers</td>
 *      <td><p> Batch updates `CreativeWrapper` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUpdateCreativeWrappers(NetworkName parent, List&lt;UpdateCreativeWrapperRequest&gt; requests)
 *           <li><p> batchUpdateCreativeWrappers(String parent, List&lt;UpdateCreativeWrapperRequest&gt; requests)
 *           <li><p> batchUpdateCreativeWrappers(BatchUpdateCreativeWrappersRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUpdateCreativeWrappersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchActivateCreativeWrappers</td>
 *      <td><p> Batch activates `CreativeWrapper` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchActivateCreativeWrappers(BatchActivateCreativeWrappersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchActivateCreativeWrappers(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchActivateCreativeWrappers(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchActivateCreativeWrappersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchDeactivateCreativeWrappers</td>
 *      <td><p> Deactivates a list of `CreativeWrapper` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchDeactivateCreativeWrappers(BatchDeactivateCreativeWrappersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchDeactivateCreativeWrappers(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchDeactivateCreativeWrappers(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchDeactivateCreativeWrappersCallable()
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
 * <p>This class can be customized by passing in a custom instance of CreativeWrapperServiceSettings
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
 * CreativeWrapperServiceSettings creativeWrapperServiceSettings =
 *     CreativeWrapperServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CreativeWrapperServiceClient creativeWrapperServiceClient =
 *     CreativeWrapperServiceClient.create(creativeWrapperServiceSettings);
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
 * CreativeWrapperServiceSettings creativeWrapperServiceSettings =
 *     CreativeWrapperServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CreativeWrapperServiceClient creativeWrapperServiceClient =
 *     CreativeWrapperServiceClient.create(creativeWrapperServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class CreativeWrapperServiceClient implements BackgroundResource {
  private final @Nullable CreativeWrapperServiceSettings settings;
  private final CreativeWrapperServiceStub stub;

  /** Constructs an instance of CreativeWrapperServiceClient with default settings. */
  public static final CreativeWrapperServiceClient create() throws IOException {
    return create(CreativeWrapperServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CreativeWrapperServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CreativeWrapperServiceClient create(CreativeWrapperServiceSettings settings)
      throws IOException {
    return new CreativeWrapperServiceClient(settings);
  }

  /**
   * Constructs an instance of CreativeWrapperServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(CreativeWrapperServiceSettings).
   */
  public static final CreativeWrapperServiceClient create(CreativeWrapperServiceStub stub) {
    return new CreativeWrapperServiceClient(stub);
  }

  /**
   * Constructs an instance of CreativeWrapperServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected CreativeWrapperServiceClient(CreativeWrapperServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((CreativeWrapperServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected CreativeWrapperServiceClient(CreativeWrapperServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable CreativeWrapperServiceSettings getSettings() {
    return settings;
  }

  public CreativeWrapperServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `CreativeWrapper` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeWrapperServiceClient creativeWrapperServiceClient =
   *     CreativeWrapperServiceClient.create()) {
   *   CreativeWrapperName name = CreativeWrapperName.of("[NETWORK_CODE]", "[CREATIVE_WRAPPER]");
   *   CreativeWrapper response = creativeWrapperServiceClient.getCreativeWrapper(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the CreativeWrapper. Format:
   *     `networks/{network_code}/creativeWrappers/{creative_wrapper_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CreativeWrapper getCreativeWrapper(@Nullable CreativeWrapperName name) {
    GetCreativeWrapperRequest request =
        GetCreativeWrapperRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getCreativeWrapper(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `CreativeWrapper` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeWrapperServiceClient creativeWrapperServiceClient =
   *     CreativeWrapperServiceClient.create()) {
   *   String name = CreativeWrapperName.of("[NETWORK_CODE]", "[CREATIVE_WRAPPER]").toString();
   *   CreativeWrapper response = creativeWrapperServiceClient.getCreativeWrapper(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the CreativeWrapper. Format:
   *     `networks/{network_code}/creativeWrappers/{creative_wrapper_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CreativeWrapper getCreativeWrapper(String name) {
    GetCreativeWrapperRequest request =
        GetCreativeWrapperRequest.newBuilder().setName(name).build();
    return getCreativeWrapper(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `CreativeWrapper` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeWrapperServiceClient creativeWrapperServiceClient =
   *     CreativeWrapperServiceClient.create()) {
   *   GetCreativeWrapperRequest request =
   *       GetCreativeWrapperRequest.newBuilder()
   *           .setName(CreativeWrapperName.of("[NETWORK_CODE]", "[CREATIVE_WRAPPER]").toString())
   *           .build();
   *   CreativeWrapper response = creativeWrapperServiceClient.getCreativeWrapper(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CreativeWrapper getCreativeWrapper(GetCreativeWrapperRequest request) {
    return getCreativeWrapperCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `CreativeWrapper` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeWrapperServiceClient creativeWrapperServiceClient =
   *     CreativeWrapperServiceClient.create()) {
   *   GetCreativeWrapperRequest request =
   *       GetCreativeWrapperRequest.newBuilder()
   *           .setName(CreativeWrapperName.of("[NETWORK_CODE]", "[CREATIVE_WRAPPER]").toString())
   *           .build();
   *   ApiFuture<CreativeWrapper> future =
   *       creativeWrapperServiceClient.getCreativeWrapperCallable().futureCall(request);
   *   // Do something.
   *   CreativeWrapper response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCreativeWrapperRequest, CreativeWrapper>
      getCreativeWrapperCallable() {
    return stub.getCreativeWrapperCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `CreativeWrapper` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeWrapperServiceClient creativeWrapperServiceClient =
   *     CreativeWrapperServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (CreativeWrapper element :
   *       creativeWrapperServiceClient.listCreativeWrappers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of CreativeWrappers. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCreativeWrappersPagedResponse listCreativeWrappers(
      @Nullable NetworkName parent) {
    ListCreativeWrappersRequest request =
        ListCreativeWrappersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCreativeWrappers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `CreativeWrapper` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeWrapperServiceClient creativeWrapperServiceClient =
   *     CreativeWrapperServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (CreativeWrapper element :
   *       creativeWrapperServiceClient.listCreativeWrappers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of CreativeWrappers. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCreativeWrappersPagedResponse listCreativeWrappers(String parent) {
    ListCreativeWrappersRequest request =
        ListCreativeWrappersRequest.newBuilder().setParent(parent).build();
    return listCreativeWrappers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `CreativeWrapper` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeWrapperServiceClient creativeWrapperServiceClient =
   *     CreativeWrapperServiceClient.create()) {
   *   ListCreativeWrappersRequest request =
   *       ListCreativeWrappersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (CreativeWrapper element :
   *       creativeWrapperServiceClient.listCreativeWrappers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCreativeWrappersPagedResponse listCreativeWrappers(
      ListCreativeWrappersRequest request) {
    return listCreativeWrappersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `CreativeWrapper` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeWrapperServiceClient creativeWrapperServiceClient =
   *     CreativeWrapperServiceClient.create()) {
   *   ListCreativeWrappersRequest request =
   *       ListCreativeWrappersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<CreativeWrapper> future =
   *       creativeWrapperServiceClient.listCreativeWrappersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CreativeWrapper element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCreativeWrappersRequest, ListCreativeWrappersPagedResponse>
      listCreativeWrappersPagedCallable() {
    return stub.listCreativeWrappersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `CreativeWrapper` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeWrapperServiceClient creativeWrapperServiceClient =
   *     CreativeWrapperServiceClient.create()) {
   *   ListCreativeWrappersRequest request =
   *       ListCreativeWrappersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListCreativeWrappersResponse response =
   *         creativeWrapperServiceClient.listCreativeWrappersCallable().call(request);
   *     for (CreativeWrapper element : response.getCreativeWrappersList()) {
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
  public final UnaryCallable<ListCreativeWrappersRequest, ListCreativeWrappersResponse>
      listCreativeWrappersCallable() {
    return stub.listCreativeWrappersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `CreativeWrapper` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeWrapperServiceClient creativeWrapperServiceClient =
   *     CreativeWrapperServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   CreativeWrapper creativeWrapper = CreativeWrapper.newBuilder().build();
   *   CreativeWrapper response =
   *       creativeWrapperServiceClient.createCreativeWrapper(parent, creativeWrapper);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `CreativeWrapper` will be created.
   *     Format: `networks/{network_code}`
   * @param creativeWrapper Required. The `CreativeWrapper` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CreativeWrapper createCreativeWrapper(
      @Nullable NetworkName parent, CreativeWrapper creativeWrapper) {
    CreateCreativeWrapperRequest request =
        CreateCreativeWrapperRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCreativeWrapper(creativeWrapper)
            .build();
    return createCreativeWrapper(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `CreativeWrapper` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeWrapperServiceClient creativeWrapperServiceClient =
   *     CreativeWrapperServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   CreativeWrapper creativeWrapper = CreativeWrapper.newBuilder().build();
   *   CreativeWrapper response =
   *       creativeWrapperServiceClient.createCreativeWrapper(parent, creativeWrapper);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `CreativeWrapper` will be created.
   *     Format: `networks/{network_code}`
   * @param creativeWrapper Required. The `CreativeWrapper` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CreativeWrapper createCreativeWrapper(
      String parent, CreativeWrapper creativeWrapper) {
    CreateCreativeWrapperRequest request =
        CreateCreativeWrapperRequest.newBuilder()
            .setParent(parent)
            .setCreativeWrapper(creativeWrapper)
            .build();
    return createCreativeWrapper(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `CreativeWrapper` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeWrapperServiceClient creativeWrapperServiceClient =
   *     CreativeWrapperServiceClient.create()) {
   *   CreateCreativeWrapperRequest request =
   *       CreateCreativeWrapperRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setCreativeWrapper(CreativeWrapper.newBuilder().build())
   *           .build();
   *   CreativeWrapper response = creativeWrapperServiceClient.createCreativeWrapper(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CreativeWrapper createCreativeWrapper(CreateCreativeWrapperRequest request) {
    return createCreativeWrapperCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `CreativeWrapper` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeWrapperServiceClient creativeWrapperServiceClient =
   *     CreativeWrapperServiceClient.create()) {
   *   CreateCreativeWrapperRequest request =
   *       CreateCreativeWrapperRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setCreativeWrapper(CreativeWrapper.newBuilder().build())
   *           .build();
   *   ApiFuture<CreativeWrapper> future =
   *       creativeWrapperServiceClient.createCreativeWrapperCallable().futureCall(request);
   *   // Do something.
   *   CreativeWrapper response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCreativeWrapperRequest, CreativeWrapper>
      createCreativeWrapperCallable() {
    return stub.createCreativeWrapperCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `CreativeWrapper` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeWrapperServiceClient creativeWrapperServiceClient =
   *     CreativeWrapperServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<CreateCreativeWrapperRequest> requests = new ArrayList<>();
   *   BatchCreateCreativeWrappersResponse response =
   *       creativeWrapperServiceClient.batchCreateCreativeWrappers(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `CreativeWrappers` will be created. Format:
   *     `networks/{network_code}` The parent field in the CreateCreativeWrapperRequest must match
   *     this field.
   * @param requests Required. The `CreativeWrapper` objects to create. A maximum of 100 objects can
   *     be created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateCreativeWrappersResponse batchCreateCreativeWrappers(
      @Nullable NetworkName parent, List<CreateCreativeWrapperRequest> requests) {
    BatchCreateCreativeWrappersRequest request =
        BatchCreateCreativeWrappersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchCreateCreativeWrappers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `CreativeWrapper` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeWrapperServiceClient creativeWrapperServiceClient =
   *     CreativeWrapperServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<CreateCreativeWrapperRequest> requests = new ArrayList<>();
   *   BatchCreateCreativeWrappersResponse response =
   *       creativeWrapperServiceClient.batchCreateCreativeWrappers(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `CreativeWrappers` will be created. Format:
   *     `networks/{network_code}` The parent field in the CreateCreativeWrapperRequest must match
   *     this field.
   * @param requests Required. The `CreativeWrapper` objects to create. A maximum of 100 objects can
   *     be created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateCreativeWrappersResponse batchCreateCreativeWrappers(
      String parent, List<CreateCreativeWrapperRequest> requests) {
    BatchCreateCreativeWrappersRequest request =
        BatchCreateCreativeWrappersRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchCreateCreativeWrappers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `CreativeWrapper` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeWrapperServiceClient creativeWrapperServiceClient =
   *     CreativeWrapperServiceClient.create()) {
   *   BatchCreateCreativeWrappersRequest request =
   *       BatchCreateCreativeWrappersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateCreativeWrapperRequest>())
   *           .build();
   *   BatchCreateCreativeWrappersResponse response =
   *       creativeWrapperServiceClient.batchCreateCreativeWrappers(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateCreativeWrappersResponse batchCreateCreativeWrappers(
      BatchCreateCreativeWrappersRequest request) {
    return batchCreateCreativeWrappersCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `CreativeWrapper` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeWrapperServiceClient creativeWrapperServiceClient =
   *     CreativeWrapperServiceClient.create()) {
   *   BatchCreateCreativeWrappersRequest request =
   *       BatchCreateCreativeWrappersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateCreativeWrapperRequest>())
   *           .build();
   *   ApiFuture<BatchCreateCreativeWrappersResponse> future =
   *       creativeWrapperServiceClient.batchCreateCreativeWrappersCallable().futureCall(request);
   *   // Do something.
   *   BatchCreateCreativeWrappersResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchCreateCreativeWrappersRequest, BatchCreateCreativeWrappersResponse>
      batchCreateCreativeWrappersCallable() {
    return stub.batchCreateCreativeWrappersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `CreativeWrapper` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeWrapperServiceClient creativeWrapperServiceClient =
   *     CreativeWrapperServiceClient.create()) {
   *   CreativeWrapper creativeWrapper = CreativeWrapper.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   CreativeWrapper response =
   *       creativeWrapperServiceClient.updateCreativeWrapper(creativeWrapper, updateMask);
   * }
   * }</pre>
   *
   * @param creativeWrapper Required. The `CreativeWrapper` to update.
   *     <p>The `CreativeWrapper`'s `name` is used to identify the `CreativeWrapper` to update.
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CreativeWrapper updateCreativeWrapper(
      CreativeWrapper creativeWrapper, FieldMask updateMask) {
    UpdateCreativeWrapperRequest request =
        UpdateCreativeWrapperRequest.newBuilder()
            .setCreativeWrapper(creativeWrapper)
            .setUpdateMask(updateMask)
            .build();
    return updateCreativeWrapper(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `CreativeWrapper` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeWrapperServiceClient creativeWrapperServiceClient =
   *     CreativeWrapperServiceClient.create()) {
   *   UpdateCreativeWrapperRequest request =
   *       UpdateCreativeWrapperRequest.newBuilder()
   *           .setCreativeWrapper(CreativeWrapper.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   CreativeWrapper response = creativeWrapperServiceClient.updateCreativeWrapper(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CreativeWrapper updateCreativeWrapper(UpdateCreativeWrapperRequest request) {
    return updateCreativeWrapperCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `CreativeWrapper` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeWrapperServiceClient creativeWrapperServiceClient =
   *     CreativeWrapperServiceClient.create()) {
   *   UpdateCreativeWrapperRequest request =
   *       UpdateCreativeWrapperRequest.newBuilder()
   *           .setCreativeWrapper(CreativeWrapper.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<CreativeWrapper> future =
   *       creativeWrapperServiceClient.updateCreativeWrapperCallable().futureCall(request);
   *   // Do something.
   *   CreativeWrapper response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCreativeWrapperRequest, CreativeWrapper>
      updateCreativeWrapperCallable() {
    return stub.updateCreativeWrapperCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `CreativeWrapper` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeWrapperServiceClient creativeWrapperServiceClient =
   *     CreativeWrapperServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<UpdateCreativeWrapperRequest> requests = new ArrayList<>();
   *   BatchUpdateCreativeWrappersResponse response =
   *       creativeWrapperServiceClient.batchUpdateCreativeWrappers(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `CreativeWrappers` will be updated. Format:
   *     `networks/{network_code}` The parent field in the UpdateCreativeWrapperRequest must match
   *     this field.
   * @param requests Required. The `CreativeWrapper` objects to update. A maximum of 100 objects can
   *     be updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateCreativeWrappersResponse batchUpdateCreativeWrappers(
      @Nullable NetworkName parent, List<UpdateCreativeWrapperRequest> requests) {
    BatchUpdateCreativeWrappersRequest request =
        BatchUpdateCreativeWrappersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchUpdateCreativeWrappers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `CreativeWrapper` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeWrapperServiceClient creativeWrapperServiceClient =
   *     CreativeWrapperServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<UpdateCreativeWrapperRequest> requests = new ArrayList<>();
   *   BatchUpdateCreativeWrappersResponse response =
   *       creativeWrapperServiceClient.batchUpdateCreativeWrappers(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `CreativeWrappers` will be updated. Format:
   *     `networks/{network_code}` The parent field in the UpdateCreativeWrapperRequest must match
   *     this field.
   * @param requests Required. The `CreativeWrapper` objects to update. A maximum of 100 objects can
   *     be updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateCreativeWrappersResponse batchUpdateCreativeWrappers(
      String parent, List<UpdateCreativeWrapperRequest> requests) {
    BatchUpdateCreativeWrappersRequest request =
        BatchUpdateCreativeWrappersRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchUpdateCreativeWrappers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `CreativeWrapper` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeWrapperServiceClient creativeWrapperServiceClient =
   *     CreativeWrapperServiceClient.create()) {
   *   BatchUpdateCreativeWrappersRequest request =
   *       BatchUpdateCreativeWrappersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateCreativeWrapperRequest>())
   *           .build();
   *   BatchUpdateCreativeWrappersResponse response =
   *       creativeWrapperServiceClient.batchUpdateCreativeWrappers(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateCreativeWrappersResponse batchUpdateCreativeWrappers(
      BatchUpdateCreativeWrappersRequest request) {
    return batchUpdateCreativeWrappersCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `CreativeWrapper` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeWrapperServiceClient creativeWrapperServiceClient =
   *     CreativeWrapperServiceClient.create()) {
   *   BatchUpdateCreativeWrappersRequest request =
   *       BatchUpdateCreativeWrappersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateCreativeWrapperRequest>())
   *           .build();
   *   ApiFuture<BatchUpdateCreativeWrappersResponse> future =
   *       creativeWrapperServiceClient.batchUpdateCreativeWrappersCallable().futureCall(request);
   *   // Do something.
   *   BatchUpdateCreativeWrappersResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchUpdateCreativeWrappersRequest, BatchUpdateCreativeWrappersResponse>
      batchUpdateCreativeWrappersCallable() {
    return stub.batchUpdateCreativeWrappersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch activates `CreativeWrapper` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeWrapperServiceClient creativeWrapperServiceClient =
   *     CreativeWrapperServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchActivateCreativeWrappersResponse response =
   *       creativeWrapperServiceClient.batchActivateCreativeWrappers(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `CreativeWrapper` objects to activate. Format:
   *     `networks/{network_code}/creativeWrappers/{creative_wrapper_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateCreativeWrappersResponse batchActivateCreativeWrappers(
      @Nullable NetworkName parent, List<String> names) {
    BatchActivateCreativeWrappersRequest request =
        BatchActivateCreativeWrappersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchActivateCreativeWrappers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch activates `CreativeWrapper` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeWrapperServiceClient creativeWrapperServiceClient =
   *     CreativeWrapperServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchActivateCreativeWrappersResponse response =
   *       creativeWrapperServiceClient.batchActivateCreativeWrappers(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `CreativeWrapper` objects to activate. Format:
   *     `networks/{network_code}/creativeWrappers/{creative_wrapper_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateCreativeWrappersResponse batchActivateCreativeWrappers(
      String parent, List<String> names) {
    BatchActivateCreativeWrappersRequest request =
        BatchActivateCreativeWrappersRequest.newBuilder()
            .setParent(parent)
            .addAllNames(names)
            .build();
    return batchActivateCreativeWrappers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch activates `CreativeWrapper` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeWrapperServiceClient creativeWrapperServiceClient =
   *     CreativeWrapperServiceClient.create()) {
   *   BatchActivateCreativeWrappersRequest request =
   *       BatchActivateCreativeWrappersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchActivateCreativeWrappersResponse response =
   *       creativeWrapperServiceClient.batchActivateCreativeWrappers(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateCreativeWrappersResponse batchActivateCreativeWrappers(
      BatchActivateCreativeWrappersRequest request) {
    return batchActivateCreativeWrappersCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch activates `CreativeWrapper` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeWrapperServiceClient creativeWrapperServiceClient =
   *     CreativeWrapperServiceClient.create()) {
   *   BatchActivateCreativeWrappersRequest request =
   *       BatchActivateCreativeWrappersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchActivateCreativeWrappersResponse> future =
   *       creativeWrapperServiceClient.batchActivateCreativeWrappersCallable().futureCall(request);
   *   // Do something.
   *   BatchActivateCreativeWrappersResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchActivateCreativeWrappersRequest, BatchActivateCreativeWrappersResponse>
      batchActivateCreativeWrappersCallable() {
    return stub.batchActivateCreativeWrappersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `CreativeWrapper` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeWrapperServiceClient creativeWrapperServiceClient =
   *     CreativeWrapperServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchDeactivateCreativeWrappersResponse response =
   *       creativeWrapperServiceClient.batchDeactivateCreativeWrappers(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `CreativeWrapper` objects to deactivate.
   *     Format: `networks/{network_code}/creativeWrappers/{creative_wrapper_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateCreativeWrappersResponse batchDeactivateCreativeWrappers(
      @Nullable NetworkName parent, List<String> names) {
    BatchDeactivateCreativeWrappersRequest request =
        BatchDeactivateCreativeWrappersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchDeactivateCreativeWrappers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `CreativeWrapper` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeWrapperServiceClient creativeWrapperServiceClient =
   *     CreativeWrapperServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchDeactivateCreativeWrappersResponse response =
   *       creativeWrapperServiceClient.batchDeactivateCreativeWrappers(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `CreativeWrapper` objects to deactivate.
   *     Format: `networks/{network_code}/creativeWrappers/{creative_wrapper_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateCreativeWrappersResponse batchDeactivateCreativeWrappers(
      String parent, List<String> names) {
    BatchDeactivateCreativeWrappersRequest request =
        BatchDeactivateCreativeWrappersRequest.newBuilder()
            .setParent(parent)
            .addAllNames(names)
            .build();
    return batchDeactivateCreativeWrappers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `CreativeWrapper` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeWrapperServiceClient creativeWrapperServiceClient =
   *     CreativeWrapperServiceClient.create()) {
   *   BatchDeactivateCreativeWrappersRequest request =
   *       BatchDeactivateCreativeWrappersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchDeactivateCreativeWrappersResponse response =
   *       creativeWrapperServiceClient.batchDeactivateCreativeWrappers(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateCreativeWrappersResponse batchDeactivateCreativeWrappers(
      BatchDeactivateCreativeWrappersRequest request) {
    return batchDeactivateCreativeWrappersCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `CreativeWrapper` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeWrapperServiceClient creativeWrapperServiceClient =
   *     CreativeWrapperServiceClient.create()) {
   *   BatchDeactivateCreativeWrappersRequest request =
   *       BatchDeactivateCreativeWrappersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchDeactivateCreativeWrappersResponse> future =
   *       creativeWrapperServiceClient
   *           .batchDeactivateCreativeWrappersCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchDeactivateCreativeWrappersResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchDeactivateCreativeWrappersRequest, BatchDeactivateCreativeWrappersResponse>
      batchDeactivateCreativeWrappersCallable() {
    return stub.batchDeactivateCreativeWrappersCallable();
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

  public static class ListCreativeWrappersPagedResponse
      extends AbstractPagedListResponse<
          ListCreativeWrappersRequest,
          ListCreativeWrappersResponse,
          CreativeWrapper,
          ListCreativeWrappersPage,
          ListCreativeWrappersFixedSizeCollection> {

    public static ApiFuture<ListCreativeWrappersPagedResponse> createAsync(
        PageContext<ListCreativeWrappersRequest, ListCreativeWrappersResponse, CreativeWrapper>
            context,
        ApiFuture<ListCreativeWrappersResponse> futureResponse) {
      ApiFuture<ListCreativeWrappersPage> futurePage =
          ListCreativeWrappersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCreativeWrappersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCreativeWrappersPagedResponse(ListCreativeWrappersPage page) {
      super(page, ListCreativeWrappersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCreativeWrappersPage
      extends AbstractPage<
          ListCreativeWrappersRequest,
          ListCreativeWrappersResponse,
          CreativeWrapper,
          ListCreativeWrappersPage> {

    private ListCreativeWrappersPage(
        @Nullable
            PageContext<ListCreativeWrappersRequest, ListCreativeWrappersResponse, CreativeWrapper>
            context,
        @Nullable ListCreativeWrappersResponse response) {
      super(context, response);
    }

    private static ListCreativeWrappersPage createEmptyPage() {
      return new ListCreativeWrappersPage(null, null);
    }

    @Override
    protected ListCreativeWrappersPage createPage(
        @Nullable
            PageContext<ListCreativeWrappersRequest, ListCreativeWrappersResponse, CreativeWrapper>
            context,
        @Nullable ListCreativeWrappersResponse response) {
      return new ListCreativeWrappersPage(context, response);
    }

    @Override
    public ApiFuture<ListCreativeWrappersPage> createPageAsync(
        @Nullable
            PageContext<ListCreativeWrappersRequest, ListCreativeWrappersResponse, CreativeWrapper>
            context,
        ApiFuture<ListCreativeWrappersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCreativeWrappersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCreativeWrappersRequest,
          ListCreativeWrappersResponse,
          CreativeWrapper,
          ListCreativeWrappersPage,
          ListCreativeWrappersFixedSizeCollection> {

    private ListCreativeWrappersFixedSizeCollection(
        @Nullable List<ListCreativeWrappersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCreativeWrappersFixedSizeCollection createEmptyCollection() {
      return new ListCreativeWrappersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCreativeWrappersFixedSizeCollection createCollection(
        @Nullable List<ListCreativeWrappersPage> pages, int collectionSize) {
      return new ListCreativeWrappersFixedSizeCollection(pages, collectionSize);
    }
  }
}
