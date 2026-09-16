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

import com.google.ads.admanager.v1.stub.DaiAuthenticationKeyServiceStub;
import com.google.ads.admanager.v1.stub.DaiAuthenticationKeyServiceStubSettings;
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
 * Service Description: Provides methods for handling `DaiAuthenticationKey` objects.
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
 * try (DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
 *     DaiAuthenticationKeyServiceClient.create()) {
 *   DaiAuthenticationKeyName name =
 *       DaiAuthenticationKeyName.of("[NETWORK_CODE]", "[DAI_AUTHENTICATION_KEY]");
 *   DaiAuthenticationKey response =
 *       daiAuthenticationKeyServiceClient.getDaiAuthenticationKey(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DaiAuthenticationKeyServiceClient object to clean up
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
 *      <td><p> GetDaiAuthenticationKey</td>
 *      <td><p> Retrieves a `DaiAuthenticationKey` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDaiAuthenticationKey(GetDaiAuthenticationKeyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDaiAuthenticationKey(DaiAuthenticationKeyName name)
 *           <li><p> getDaiAuthenticationKey(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDaiAuthenticationKeyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDaiAuthenticationKeys</td>
 *      <td><p> Lists `DaiAuthenticationKey` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDaiAuthenticationKeys(ListDaiAuthenticationKeysRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDaiAuthenticationKeys(NetworkName parent)
 *           <li><p> listDaiAuthenticationKeys(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDaiAuthenticationKeysPagedCallable()
 *           <li><p> listDaiAuthenticationKeysCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateDaiAuthenticationKey</td>
 *      <td><p> Creates a `DaiAuthenticationKey` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDaiAuthenticationKey(CreateDaiAuthenticationKeyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createDaiAuthenticationKey(NetworkName parent, DaiAuthenticationKey daiAuthenticationKey)
 *           <li><p> createDaiAuthenticationKey(String parent, DaiAuthenticationKey daiAuthenticationKey)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDaiAuthenticationKeyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreateDaiAuthenticationKeys</td>
 *      <td><p> Batch creates `DaiAuthenticationKey` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateDaiAuthenticationKeys(NetworkName parent, List&lt;CreateDaiAuthenticationKeyRequest&gt; requests)
 *           <li><p> batchCreateDaiAuthenticationKeys(String parent, List&lt;CreateDaiAuthenticationKeyRequest&gt; requests)
 *           <li><p> batchCreateDaiAuthenticationKeys(BatchCreateDaiAuthenticationKeysRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateDaiAuthenticationKeysCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDaiAuthenticationKey</td>
 *      <td><p> Updates a `DaiAuthenticationKey` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDaiAuthenticationKey(UpdateDaiAuthenticationKeyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateDaiAuthenticationKey(DaiAuthenticationKey daiAuthenticationKey, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDaiAuthenticationKeyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUpdateDaiAuthenticationKeys</td>
 *      <td><p> Batch updates `DaiAuthenticationKey` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUpdateDaiAuthenticationKeys(NetworkName parent, List&lt;UpdateDaiAuthenticationKeyRequest&gt; requests)
 *           <li><p> batchUpdateDaiAuthenticationKeys(String parent, List&lt;UpdateDaiAuthenticationKeyRequest&gt; requests)
 *           <li><p> batchUpdateDaiAuthenticationKeys(BatchUpdateDaiAuthenticationKeysRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUpdateDaiAuthenticationKeysCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchActivateDaiAuthenticationKeys</td>
 *      <td><p> Activates a list of `DaiAuthenticationKey` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchActivateDaiAuthenticationKeys(BatchActivateDaiAuthenticationKeysRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchActivateDaiAuthenticationKeys(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchActivateDaiAuthenticationKeys(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchActivateDaiAuthenticationKeysCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchDeactivateDaiAuthenticationKeys</td>
 *      <td><p> Deactivates a list of `DaiAuthenticationKey` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchDeactivateDaiAuthenticationKeys(BatchDeactivateDaiAuthenticationKeysRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchDeactivateDaiAuthenticationKeys(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchDeactivateDaiAuthenticationKeys(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchDeactivateDaiAuthenticationKeysCallable()
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
 * DaiAuthenticationKeyServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DaiAuthenticationKeyServiceSettings daiAuthenticationKeyServiceSettings =
 *     DaiAuthenticationKeyServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
 *     DaiAuthenticationKeyServiceClient.create(daiAuthenticationKeyServiceSettings);
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
 * DaiAuthenticationKeyServiceSettings daiAuthenticationKeyServiceSettings =
 *     DaiAuthenticationKeyServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
 *     DaiAuthenticationKeyServiceClient.create(daiAuthenticationKeyServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class DaiAuthenticationKeyServiceClient implements BackgroundResource {
  private final @Nullable DaiAuthenticationKeyServiceSettings settings;
  private final DaiAuthenticationKeyServiceStub stub;

  /** Constructs an instance of DaiAuthenticationKeyServiceClient with default settings. */
  public static final DaiAuthenticationKeyServiceClient create() throws IOException {
    return create(DaiAuthenticationKeyServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DaiAuthenticationKeyServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final DaiAuthenticationKeyServiceClient create(
      DaiAuthenticationKeyServiceSettings settings) throws IOException {
    return new DaiAuthenticationKeyServiceClient(settings);
  }

  /**
   * Constructs an instance of DaiAuthenticationKeyServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(DaiAuthenticationKeyServiceSettings).
   */
  public static final DaiAuthenticationKeyServiceClient create(
      DaiAuthenticationKeyServiceStub stub) {
    return new DaiAuthenticationKeyServiceClient(stub);
  }

  /**
   * Constructs an instance of DaiAuthenticationKeyServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected DaiAuthenticationKeyServiceClient(DaiAuthenticationKeyServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((DaiAuthenticationKeyServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected DaiAuthenticationKeyServiceClient(DaiAuthenticationKeyServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable DaiAuthenticationKeyServiceSettings getSettings() {
    return settings;
  }

  public DaiAuthenticationKeyServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `DaiAuthenticationKey` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
   *     DaiAuthenticationKeyServiceClient.create()) {
   *   DaiAuthenticationKeyName name =
   *       DaiAuthenticationKeyName.of("[NETWORK_CODE]", "[DAI_AUTHENTICATION_KEY]");
   *   DaiAuthenticationKey response =
   *       daiAuthenticationKeyServiceClient.getDaiAuthenticationKey(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the `DaiAuthenticationKey`. Format:
   *     `networks/{network_code}/daiAuthenticationKeys/{dai_authentication_key_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DaiAuthenticationKey getDaiAuthenticationKey(
      @Nullable DaiAuthenticationKeyName name) {
    GetDaiAuthenticationKeyRequest request =
        GetDaiAuthenticationKeyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDaiAuthenticationKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `DaiAuthenticationKey` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
   *     DaiAuthenticationKeyServiceClient.create()) {
   *   String name =
   *       DaiAuthenticationKeyName.of("[NETWORK_CODE]", "[DAI_AUTHENTICATION_KEY]").toString();
   *   DaiAuthenticationKey response =
   *       daiAuthenticationKeyServiceClient.getDaiAuthenticationKey(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the `DaiAuthenticationKey`. Format:
   *     `networks/{network_code}/daiAuthenticationKeys/{dai_authentication_key_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DaiAuthenticationKey getDaiAuthenticationKey(String name) {
    GetDaiAuthenticationKeyRequest request =
        GetDaiAuthenticationKeyRequest.newBuilder().setName(name).build();
    return getDaiAuthenticationKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `DaiAuthenticationKey` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
   *     DaiAuthenticationKeyServiceClient.create()) {
   *   GetDaiAuthenticationKeyRequest request =
   *       GetDaiAuthenticationKeyRequest.newBuilder()
   *           .setName(
   *               DaiAuthenticationKeyName.of("[NETWORK_CODE]", "[DAI_AUTHENTICATION_KEY]")
   *                   .toString())
   *           .build();
   *   DaiAuthenticationKey response =
   *       daiAuthenticationKeyServiceClient.getDaiAuthenticationKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DaiAuthenticationKey getDaiAuthenticationKey(
      GetDaiAuthenticationKeyRequest request) {
    return getDaiAuthenticationKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `DaiAuthenticationKey` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
   *     DaiAuthenticationKeyServiceClient.create()) {
   *   GetDaiAuthenticationKeyRequest request =
   *       GetDaiAuthenticationKeyRequest.newBuilder()
   *           .setName(
   *               DaiAuthenticationKeyName.of("[NETWORK_CODE]", "[DAI_AUTHENTICATION_KEY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DaiAuthenticationKey> future =
   *       daiAuthenticationKeyServiceClient.getDaiAuthenticationKeyCallable().futureCall(request);
   *   // Do something.
   *   DaiAuthenticationKey response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDaiAuthenticationKeyRequest, DaiAuthenticationKey>
      getDaiAuthenticationKeyCallable() {
    return stub.getDaiAuthenticationKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `DaiAuthenticationKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
   *     DaiAuthenticationKeyServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (DaiAuthenticationKey element :
   *       daiAuthenticationKeyServiceClient.listDaiAuthenticationKeys(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of DaiAuthenticationKeys.
   *     Format: `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDaiAuthenticationKeysPagedResponse listDaiAuthenticationKeys(
      @Nullable NetworkName parent) {
    ListDaiAuthenticationKeysRequest request =
        ListDaiAuthenticationKeysRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDaiAuthenticationKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `DaiAuthenticationKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
   *     DaiAuthenticationKeyServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (DaiAuthenticationKey element :
   *       daiAuthenticationKeyServiceClient.listDaiAuthenticationKeys(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of DaiAuthenticationKeys.
   *     Format: `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDaiAuthenticationKeysPagedResponse listDaiAuthenticationKeys(String parent) {
    ListDaiAuthenticationKeysRequest request =
        ListDaiAuthenticationKeysRequest.newBuilder().setParent(parent).build();
    return listDaiAuthenticationKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `DaiAuthenticationKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
   *     DaiAuthenticationKeyServiceClient.create()) {
   *   ListDaiAuthenticationKeysRequest request =
   *       ListDaiAuthenticationKeysRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (DaiAuthenticationKey element :
   *       daiAuthenticationKeyServiceClient.listDaiAuthenticationKeys(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDaiAuthenticationKeysPagedResponse listDaiAuthenticationKeys(
      ListDaiAuthenticationKeysRequest request) {
    return listDaiAuthenticationKeysPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `DaiAuthenticationKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
   *     DaiAuthenticationKeyServiceClient.create()) {
   *   ListDaiAuthenticationKeysRequest request =
   *       ListDaiAuthenticationKeysRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<DaiAuthenticationKey> future =
   *       daiAuthenticationKeyServiceClient
   *           .listDaiAuthenticationKeysPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (DaiAuthenticationKey element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListDaiAuthenticationKeysRequest, ListDaiAuthenticationKeysPagedResponse>
      listDaiAuthenticationKeysPagedCallable() {
    return stub.listDaiAuthenticationKeysPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `DaiAuthenticationKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
   *     DaiAuthenticationKeyServiceClient.create()) {
   *   ListDaiAuthenticationKeysRequest request =
   *       ListDaiAuthenticationKeysRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListDaiAuthenticationKeysResponse response =
   *         daiAuthenticationKeyServiceClient.listDaiAuthenticationKeysCallable().call(request);
   *     for (DaiAuthenticationKey element : response.getDaiAuthenticationKeysList()) {
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
  public final UnaryCallable<ListDaiAuthenticationKeysRequest, ListDaiAuthenticationKeysResponse>
      listDaiAuthenticationKeysCallable() {
    return stub.listDaiAuthenticationKeysCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `DaiAuthenticationKey` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
   *     DaiAuthenticationKeyServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   DaiAuthenticationKey daiAuthenticationKey = DaiAuthenticationKey.newBuilder().build();
   *   DaiAuthenticationKey response =
   *       daiAuthenticationKeyServiceClient.createDaiAuthenticationKey(
   *           parent, daiAuthenticationKey);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `DaiAuthenticationKey` will be created.
   *     Format: `networks/{network_code}`
   * @param daiAuthenticationKey Required. The `DaiAuthenticationKey` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DaiAuthenticationKey createDaiAuthenticationKey(
      @Nullable NetworkName parent, DaiAuthenticationKey daiAuthenticationKey) {
    CreateDaiAuthenticationKeyRequest request =
        CreateDaiAuthenticationKeyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDaiAuthenticationKey(daiAuthenticationKey)
            .build();
    return createDaiAuthenticationKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `DaiAuthenticationKey` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
   *     DaiAuthenticationKeyServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   DaiAuthenticationKey daiAuthenticationKey = DaiAuthenticationKey.newBuilder().build();
   *   DaiAuthenticationKey response =
   *       daiAuthenticationKeyServiceClient.createDaiAuthenticationKey(
   *           parent, daiAuthenticationKey);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `DaiAuthenticationKey` will be created.
   *     Format: `networks/{network_code}`
   * @param daiAuthenticationKey Required. The `DaiAuthenticationKey` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DaiAuthenticationKey createDaiAuthenticationKey(
      String parent, DaiAuthenticationKey daiAuthenticationKey) {
    CreateDaiAuthenticationKeyRequest request =
        CreateDaiAuthenticationKeyRequest.newBuilder()
            .setParent(parent)
            .setDaiAuthenticationKey(daiAuthenticationKey)
            .build();
    return createDaiAuthenticationKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `DaiAuthenticationKey` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
   *     DaiAuthenticationKeyServiceClient.create()) {
   *   CreateDaiAuthenticationKeyRequest request =
   *       CreateDaiAuthenticationKeyRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setDaiAuthenticationKey(DaiAuthenticationKey.newBuilder().build())
   *           .build();
   *   DaiAuthenticationKey response =
   *       daiAuthenticationKeyServiceClient.createDaiAuthenticationKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DaiAuthenticationKey createDaiAuthenticationKey(
      CreateDaiAuthenticationKeyRequest request) {
    return createDaiAuthenticationKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `DaiAuthenticationKey` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
   *     DaiAuthenticationKeyServiceClient.create()) {
   *   CreateDaiAuthenticationKeyRequest request =
   *       CreateDaiAuthenticationKeyRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setDaiAuthenticationKey(DaiAuthenticationKey.newBuilder().build())
   *           .build();
   *   ApiFuture<DaiAuthenticationKey> future =
   *       daiAuthenticationKeyServiceClient
   *           .createDaiAuthenticationKeyCallable()
   *           .futureCall(request);
   *   // Do something.
   *   DaiAuthenticationKey response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDaiAuthenticationKeyRequest, DaiAuthenticationKey>
      createDaiAuthenticationKeyCallable() {
    return stub.createDaiAuthenticationKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `DaiAuthenticationKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
   *     DaiAuthenticationKeyServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<CreateDaiAuthenticationKeyRequest> requests = new ArrayList<>();
   *   BatchCreateDaiAuthenticationKeysResponse response =
   *       daiAuthenticationKeyServiceClient.batchCreateDaiAuthenticationKeys(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `DaiAuthenticationKeys` will be created.
   *     Format: `networks/{network_code}` The parent field in the CreateDaiAuthenticationKeyRequest
   *     must match this field.
   * @param requests Required. The `DaiAuthenticationKey` objects to create. A maximum of 100
   *     objects can be created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateDaiAuthenticationKeysResponse batchCreateDaiAuthenticationKeys(
      @Nullable NetworkName parent, List<CreateDaiAuthenticationKeyRequest> requests) {
    BatchCreateDaiAuthenticationKeysRequest request =
        BatchCreateDaiAuthenticationKeysRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchCreateDaiAuthenticationKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `DaiAuthenticationKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
   *     DaiAuthenticationKeyServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<CreateDaiAuthenticationKeyRequest> requests = new ArrayList<>();
   *   BatchCreateDaiAuthenticationKeysResponse response =
   *       daiAuthenticationKeyServiceClient.batchCreateDaiAuthenticationKeys(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `DaiAuthenticationKeys` will be created.
   *     Format: `networks/{network_code}` The parent field in the CreateDaiAuthenticationKeyRequest
   *     must match this field.
   * @param requests Required. The `DaiAuthenticationKey` objects to create. A maximum of 100
   *     objects can be created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateDaiAuthenticationKeysResponse batchCreateDaiAuthenticationKeys(
      String parent, List<CreateDaiAuthenticationKeyRequest> requests) {
    BatchCreateDaiAuthenticationKeysRequest request =
        BatchCreateDaiAuthenticationKeysRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchCreateDaiAuthenticationKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `DaiAuthenticationKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
   *     DaiAuthenticationKeyServiceClient.create()) {
   *   BatchCreateDaiAuthenticationKeysRequest request =
   *       BatchCreateDaiAuthenticationKeysRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateDaiAuthenticationKeyRequest>())
   *           .build();
   *   BatchCreateDaiAuthenticationKeysResponse response =
   *       daiAuthenticationKeyServiceClient.batchCreateDaiAuthenticationKeys(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateDaiAuthenticationKeysResponse batchCreateDaiAuthenticationKeys(
      BatchCreateDaiAuthenticationKeysRequest request) {
    return batchCreateDaiAuthenticationKeysCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `DaiAuthenticationKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
   *     DaiAuthenticationKeyServiceClient.create()) {
   *   BatchCreateDaiAuthenticationKeysRequest request =
   *       BatchCreateDaiAuthenticationKeysRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateDaiAuthenticationKeyRequest>())
   *           .build();
   *   ApiFuture<BatchCreateDaiAuthenticationKeysResponse> future =
   *       daiAuthenticationKeyServiceClient
   *           .batchCreateDaiAuthenticationKeysCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchCreateDaiAuthenticationKeysResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchCreateDaiAuthenticationKeysRequest, BatchCreateDaiAuthenticationKeysResponse>
      batchCreateDaiAuthenticationKeysCallable() {
    return stub.batchCreateDaiAuthenticationKeysCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `DaiAuthenticationKey` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
   *     DaiAuthenticationKeyServiceClient.create()) {
   *   DaiAuthenticationKey daiAuthenticationKey = DaiAuthenticationKey.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DaiAuthenticationKey response =
   *       daiAuthenticationKeyServiceClient.updateDaiAuthenticationKey(
   *           daiAuthenticationKey, updateMask);
   * }
   * }</pre>
   *
   * @param daiAuthenticationKey Required. The `DaiAuthenticationKey` to update.
   *     <p>The `DaiAuthenticationKey`'s `name` is used to identify the `DaiAuthenticationKey` to
   *     update.
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DaiAuthenticationKey updateDaiAuthenticationKey(
      DaiAuthenticationKey daiAuthenticationKey, FieldMask updateMask) {
    UpdateDaiAuthenticationKeyRequest request =
        UpdateDaiAuthenticationKeyRequest.newBuilder()
            .setDaiAuthenticationKey(daiAuthenticationKey)
            .setUpdateMask(updateMask)
            .build();
    return updateDaiAuthenticationKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `DaiAuthenticationKey` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
   *     DaiAuthenticationKeyServiceClient.create()) {
   *   UpdateDaiAuthenticationKeyRequest request =
   *       UpdateDaiAuthenticationKeyRequest.newBuilder()
   *           .setDaiAuthenticationKey(DaiAuthenticationKey.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   DaiAuthenticationKey response =
   *       daiAuthenticationKeyServiceClient.updateDaiAuthenticationKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DaiAuthenticationKey updateDaiAuthenticationKey(
      UpdateDaiAuthenticationKeyRequest request) {
    return updateDaiAuthenticationKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `DaiAuthenticationKey` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
   *     DaiAuthenticationKeyServiceClient.create()) {
   *   UpdateDaiAuthenticationKeyRequest request =
   *       UpdateDaiAuthenticationKeyRequest.newBuilder()
   *           .setDaiAuthenticationKey(DaiAuthenticationKey.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<DaiAuthenticationKey> future =
   *       daiAuthenticationKeyServiceClient
   *           .updateDaiAuthenticationKeyCallable()
   *           .futureCall(request);
   *   // Do something.
   *   DaiAuthenticationKey response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDaiAuthenticationKeyRequest, DaiAuthenticationKey>
      updateDaiAuthenticationKeyCallable() {
    return stub.updateDaiAuthenticationKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `DaiAuthenticationKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
   *     DaiAuthenticationKeyServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<UpdateDaiAuthenticationKeyRequest> requests = new ArrayList<>();
   *   BatchUpdateDaiAuthenticationKeysResponse response =
   *       daiAuthenticationKeyServiceClient.batchUpdateDaiAuthenticationKeys(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `DaiAuthenticationKeys` will be updated.
   *     Format: `networks/{network_code}` The parent field in the UpdateDaiAuthenticationKeyRequest
   *     must match this field.
   * @param requests Required. The `DaiAuthenticationKey` objects to update. A maximum of 100
   *     objects can be updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateDaiAuthenticationKeysResponse batchUpdateDaiAuthenticationKeys(
      @Nullable NetworkName parent, List<UpdateDaiAuthenticationKeyRequest> requests) {
    BatchUpdateDaiAuthenticationKeysRequest request =
        BatchUpdateDaiAuthenticationKeysRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchUpdateDaiAuthenticationKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `DaiAuthenticationKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
   *     DaiAuthenticationKeyServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<UpdateDaiAuthenticationKeyRequest> requests = new ArrayList<>();
   *   BatchUpdateDaiAuthenticationKeysResponse response =
   *       daiAuthenticationKeyServiceClient.batchUpdateDaiAuthenticationKeys(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `DaiAuthenticationKeys` will be updated.
   *     Format: `networks/{network_code}` The parent field in the UpdateDaiAuthenticationKeyRequest
   *     must match this field.
   * @param requests Required. The `DaiAuthenticationKey` objects to update. A maximum of 100
   *     objects can be updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateDaiAuthenticationKeysResponse batchUpdateDaiAuthenticationKeys(
      String parent, List<UpdateDaiAuthenticationKeyRequest> requests) {
    BatchUpdateDaiAuthenticationKeysRequest request =
        BatchUpdateDaiAuthenticationKeysRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchUpdateDaiAuthenticationKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `DaiAuthenticationKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
   *     DaiAuthenticationKeyServiceClient.create()) {
   *   BatchUpdateDaiAuthenticationKeysRequest request =
   *       BatchUpdateDaiAuthenticationKeysRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateDaiAuthenticationKeyRequest>())
   *           .build();
   *   BatchUpdateDaiAuthenticationKeysResponse response =
   *       daiAuthenticationKeyServiceClient.batchUpdateDaiAuthenticationKeys(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateDaiAuthenticationKeysResponse batchUpdateDaiAuthenticationKeys(
      BatchUpdateDaiAuthenticationKeysRequest request) {
    return batchUpdateDaiAuthenticationKeysCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `DaiAuthenticationKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
   *     DaiAuthenticationKeyServiceClient.create()) {
   *   BatchUpdateDaiAuthenticationKeysRequest request =
   *       BatchUpdateDaiAuthenticationKeysRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateDaiAuthenticationKeyRequest>())
   *           .build();
   *   ApiFuture<BatchUpdateDaiAuthenticationKeysResponse> future =
   *       daiAuthenticationKeyServiceClient
   *           .batchUpdateDaiAuthenticationKeysCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchUpdateDaiAuthenticationKeysResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchUpdateDaiAuthenticationKeysRequest, BatchUpdateDaiAuthenticationKeysResponse>
      batchUpdateDaiAuthenticationKeysCallable() {
    return stub.batchUpdateDaiAuthenticationKeysCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activates a list of `DaiAuthenticationKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
   *     DaiAuthenticationKeyServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchActivateDaiAuthenticationKeysResponse response =
   *       daiAuthenticationKeyServiceClient.batchActivateDaiAuthenticationKeys(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. Resource names for the DaiAuthenticationKey. Format:
   *     `networks/{network_code}/daiAuthenticationKeys/{dai_authentication_key}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateDaiAuthenticationKeysResponse batchActivateDaiAuthenticationKeys(
      @Nullable NetworkName parent, List<String> names) {
    BatchActivateDaiAuthenticationKeysRequest request =
        BatchActivateDaiAuthenticationKeysRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchActivateDaiAuthenticationKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activates a list of `DaiAuthenticationKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
   *     DaiAuthenticationKeyServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchActivateDaiAuthenticationKeysResponse response =
   *       daiAuthenticationKeyServiceClient.batchActivateDaiAuthenticationKeys(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. Resource names for the DaiAuthenticationKey. Format:
   *     `networks/{network_code}/daiAuthenticationKeys/{dai_authentication_key}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateDaiAuthenticationKeysResponse batchActivateDaiAuthenticationKeys(
      String parent, List<String> names) {
    BatchActivateDaiAuthenticationKeysRequest request =
        BatchActivateDaiAuthenticationKeysRequest.newBuilder()
            .setParent(parent)
            .addAllNames(names)
            .build();
    return batchActivateDaiAuthenticationKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activates a list of `DaiAuthenticationKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
   *     DaiAuthenticationKeyServiceClient.create()) {
   *   BatchActivateDaiAuthenticationKeysRequest request =
   *       BatchActivateDaiAuthenticationKeysRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchActivateDaiAuthenticationKeysResponse response =
   *       daiAuthenticationKeyServiceClient.batchActivateDaiAuthenticationKeys(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateDaiAuthenticationKeysResponse batchActivateDaiAuthenticationKeys(
      BatchActivateDaiAuthenticationKeysRequest request) {
    return batchActivateDaiAuthenticationKeysCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activates a list of `DaiAuthenticationKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
   *     DaiAuthenticationKeyServiceClient.create()) {
   *   BatchActivateDaiAuthenticationKeysRequest request =
   *       BatchActivateDaiAuthenticationKeysRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchActivateDaiAuthenticationKeysResponse> future =
   *       daiAuthenticationKeyServiceClient
   *           .batchActivateDaiAuthenticationKeysCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchActivateDaiAuthenticationKeysResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchActivateDaiAuthenticationKeysRequest, BatchActivateDaiAuthenticationKeysResponse>
      batchActivateDaiAuthenticationKeysCallable() {
    return stub.batchActivateDaiAuthenticationKeysCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `DaiAuthenticationKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
   *     DaiAuthenticationKeyServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchDeactivateDaiAuthenticationKeysResponse response =
   *       daiAuthenticationKeyServiceClient.batchDeactivateDaiAuthenticationKeys(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. Resource names for the DaiAuthenticationKey. Format:
   *     `networks/{network_code}/daiAuthenticationKeys/{dai_authentication_key}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateDaiAuthenticationKeysResponse batchDeactivateDaiAuthenticationKeys(
      @Nullable NetworkName parent, List<String> names) {
    BatchDeactivateDaiAuthenticationKeysRequest request =
        BatchDeactivateDaiAuthenticationKeysRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchDeactivateDaiAuthenticationKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `DaiAuthenticationKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
   *     DaiAuthenticationKeyServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchDeactivateDaiAuthenticationKeysResponse response =
   *       daiAuthenticationKeyServiceClient.batchDeactivateDaiAuthenticationKeys(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. Resource names for the DaiAuthenticationKey. Format:
   *     `networks/{network_code}/daiAuthenticationKeys/{dai_authentication_key}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateDaiAuthenticationKeysResponse batchDeactivateDaiAuthenticationKeys(
      String parent, List<String> names) {
    BatchDeactivateDaiAuthenticationKeysRequest request =
        BatchDeactivateDaiAuthenticationKeysRequest.newBuilder()
            .setParent(parent)
            .addAllNames(names)
            .build();
    return batchDeactivateDaiAuthenticationKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `DaiAuthenticationKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
   *     DaiAuthenticationKeyServiceClient.create()) {
   *   BatchDeactivateDaiAuthenticationKeysRequest request =
   *       BatchDeactivateDaiAuthenticationKeysRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchDeactivateDaiAuthenticationKeysResponse response =
   *       daiAuthenticationKeyServiceClient.batchDeactivateDaiAuthenticationKeys(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateDaiAuthenticationKeysResponse batchDeactivateDaiAuthenticationKeys(
      BatchDeactivateDaiAuthenticationKeysRequest request) {
    return batchDeactivateDaiAuthenticationKeysCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `DaiAuthenticationKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiAuthenticationKeyServiceClient daiAuthenticationKeyServiceClient =
   *     DaiAuthenticationKeyServiceClient.create()) {
   *   BatchDeactivateDaiAuthenticationKeysRequest request =
   *       BatchDeactivateDaiAuthenticationKeysRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchDeactivateDaiAuthenticationKeysResponse> future =
   *       daiAuthenticationKeyServiceClient
   *           .batchDeactivateDaiAuthenticationKeysCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchDeactivateDaiAuthenticationKeysResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchDeactivateDaiAuthenticationKeysRequest, BatchDeactivateDaiAuthenticationKeysResponse>
      batchDeactivateDaiAuthenticationKeysCallable() {
    return stub.batchDeactivateDaiAuthenticationKeysCallable();
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

  public static class ListDaiAuthenticationKeysPagedResponse
      extends AbstractPagedListResponse<
          ListDaiAuthenticationKeysRequest,
          ListDaiAuthenticationKeysResponse,
          DaiAuthenticationKey,
          ListDaiAuthenticationKeysPage,
          ListDaiAuthenticationKeysFixedSizeCollection> {

    public static ApiFuture<ListDaiAuthenticationKeysPagedResponse> createAsync(
        PageContext<
                ListDaiAuthenticationKeysRequest,
                ListDaiAuthenticationKeysResponse,
                DaiAuthenticationKey>
            context,
        ApiFuture<ListDaiAuthenticationKeysResponse> futureResponse) {
      ApiFuture<ListDaiAuthenticationKeysPage> futurePage =
          ListDaiAuthenticationKeysPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDaiAuthenticationKeysPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDaiAuthenticationKeysPagedResponse(ListDaiAuthenticationKeysPage page) {
      super(page, ListDaiAuthenticationKeysFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDaiAuthenticationKeysPage
      extends AbstractPage<
          ListDaiAuthenticationKeysRequest,
          ListDaiAuthenticationKeysResponse,
          DaiAuthenticationKey,
          ListDaiAuthenticationKeysPage> {

    private ListDaiAuthenticationKeysPage(
        @Nullable
            PageContext<
                ListDaiAuthenticationKeysRequest,
                ListDaiAuthenticationKeysResponse,
                DaiAuthenticationKey>
            context,
        @Nullable ListDaiAuthenticationKeysResponse response) {
      super(context, response);
    }

    private static ListDaiAuthenticationKeysPage createEmptyPage() {
      return new ListDaiAuthenticationKeysPage(null, null);
    }

    @Override
    protected ListDaiAuthenticationKeysPage createPage(
        @Nullable
            PageContext<
                ListDaiAuthenticationKeysRequest,
                ListDaiAuthenticationKeysResponse,
                DaiAuthenticationKey>
            context,
        @Nullable ListDaiAuthenticationKeysResponse response) {
      return new ListDaiAuthenticationKeysPage(context, response);
    }

    @Override
    public ApiFuture<ListDaiAuthenticationKeysPage> createPageAsync(
        @Nullable
            PageContext<
                ListDaiAuthenticationKeysRequest,
                ListDaiAuthenticationKeysResponse,
                DaiAuthenticationKey>
            context,
        ApiFuture<ListDaiAuthenticationKeysResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDaiAuthenticationKeysFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDaiAuthenticationKeysRequest,
          ListDaiAuthenticationKeysResponse,
          DaiAuthenticationKey,
          ListDaiAuthenticationKeysPage,
          ListDaiAuthenticationKeysFixedSizeCollection> {

    private ListDaiAuthenticationKeysFixedSizeCollection(
        @Nullable List<ListDaiAuthenticationKeysPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDaiAuthenticationKeysFixedSizeCollection createEmptyCollection() {
      return new ListDaiAuthenticationKeysFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDaiAuthenticationKeysFixedSizeCollection createCollection(
        @Nullable List<ListDaiAuthenticationKeysPage> pages, int collectionSize) {
      return new ListDaiAuthenticationKeysFixedSizeCollection(pages, collectionSize);
    }
  }
}
