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

import com.google.ads.admanager.v1.stub.CdnConfigServiceStub;
import com.google.ads.admanager.v1.stub.CdnConfigServiceStubSettings;
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
 * Service Description: Provides methods for handling `CdnConfig` objects.
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
 * try (CdnConfigServiceClient cdnConfigServiceClient = CdnConfigServiceClient.create()) {
 *   CdnConfigName name = CdnConfigName.of("[NETWORK_CODE]", "[CDN_CONFIG]");
 *   CdnConfig response = cdnConfigServiceClient.getCdnConfig(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CdnConfigServiceClient object to clean up resources
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
 *      <td><p> GetCdnConfig</td>
 *      <td><p> Retrieves a `CdnConfig` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCdnConfig(GetCdnConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCdnConfig(CdnConfigName name)
 *           <li><p> getCdnConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCdnConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCdnConfigs</td>
 *      <td><p> Lists `CdnConfig` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCdnConfigs(ListCdnConfigsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCdnConfigs(NetworkName parent)
 *           <li><p> listCdnConfigs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCdnConfigsPagedCallable()
 *           <li><p> listCdnConfigsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateCdnConfig</td>
 *      <td><p> Creates a `CdnConfig` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createCdnConfig(CreateCdnConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createCdnConfig(NetworkName parent, CdnConfig cdnConfig)
 *           <li><p> createCdnConfig(String parent, CdnConfig cdnConfig)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createCdnConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreateCdnConfigs</td>
 *      <td><p> Batch creates `CdnConfig` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateCdnConfigs(NetworkName parent, List&lt;CreateCdnConfigRequest&gt; requests)
 *           <li><p> batchCreateCdnConfigs(String parent, List&lt;CreateCdnConfigRequest&gt; requests)
 *           <li><p> batchCreateCdnConfigs(BatchCreateCdnConfigsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateCdnConfigsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateCdnConfig</td>
 *      <td><p> Updates a `CdnConfig` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateCdnConfig(UpdateCdnConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateCdnConfig(CdnConfig cdnConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateCdnConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUpdateCdnConfigs</td>
 *      <td><p> Batch updates `CdnConfig` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUpdateCdnConfigs(NetworkName parent, List&lt;UpdateCdnConfigRequest&gt; requests)
 *           <li><p> batchUpdateCdnConfigs(String parent, List&lt;UpdateCdnConfigRequest&gt; requests)
 *           <li><p> batchUpdateCdnConfigs(BatchUpdateCdnConfigsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUpdateCdnConfigsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchActivateCdnConfigs</td>
 *      <td><p> Batch activates `CdnConfig` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchActivateCdnConfigs(BatchActivateCdnConfigsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchActivateCdnConfigs(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchActivateCdnConfigs(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchActivateCdnConfigsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchArchiveCdnConfigs</td>
 *      <td><p> Batch archives `CdnConfig` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchArchiveCdnConfigs(BatchArchiveCdnConfigsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchArchiveCdnConfigs(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchArchiveCdnConfigs(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchArchiveCdnConfigsCallable()
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
 * <p>This class can be customized by passing in a custom instance of CdnConfigServiceSettings to
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
 * CdnConfigServiceSettings cdnConfigServiceSettings =
 *     CdnConfigServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CdnConfigServiceClient cdnConfigServiceClient =
 *     CdnConfigServiceClient.create(cdnConfigServiceSettings);
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
 * CdnConfigServiceSettings cdnConfigServiceSettings =
 *     CdnConfigServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CdnConfigServiceClient cdnConfigServiceClient =
 *     CdnConfigServiceClient.create(cdnConfigServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class CdnConfigServiceClient implements BackgroundResource {
  private final @Nullable CdnConfigServiceSettings settings;
  private final CdnConfigServiceStub stub;

  /** Constructs an instance of CdnConfigServiceClient with default settings. */
  public static final CdnConfigServiceClient create() throws IOException {
    return create(CdnConfigServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CdnConfigServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CdnConfigServiceClient create(CdnConfigServiceSettings settings)
      throws IOException {
    return new CdnConfigServiceClient(settings);
  }

  /**
   * Constructs an instance of CdnConfigServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(CdnConfigServiceSettings).
   */
  public static final CdnConfigServiceClient create(CdnConfigServiceStub stub) {
    return new CdnConfigServiceClient(stub);
  }

  /**
   * Constructs an instance of CdnConfigServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected CdnConfigServiceClient(CdnConfigServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CdnConfigServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected CdnConfigServiceClient(CdnConfigServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable CdnConfigServiceSettings getSettings() {
    return settings;
  }

  public CdnConfigServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `CdnConfig` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CdnConfigServiceClient cdnConfigServiceClient = CdnConfigServiceClient.create()) {
   *   CdnConfigName name = CdnConfigName.of("[NETWORK_CODE]", "[CDN_CONFIG]");
   *   CdnConfig response = cdnConfigServiceClient.getCdnConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the CdnConfig. Format:
   *     `networks/{network_code}/cdnConfigs/{cdn_config_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CdnConfig getCdnConfig(@Nullable CdnConfigName name) {
    GetCdnConfigRequest request =
        GetCdnConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCdnConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `CdnConfig` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CdnConfigServiceClient cdnConfigServiceClient = CdnConfigServiceClient.create()) {
   *   String name = CdnConfigName.of("[NETWORK_CODE]", "[CDN_CONFIG]").toString();
   *   CdnConfig response = cdnConfigServiceClient.getCdnConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the CdnConfig. Format:
   *     `networks/{network_code}/cdnConfigs/{cdn_config_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CdnConfig getCdnConfig(String name) {
    GetCdnConfigRequest request = GetCdnConfigRequest.newBuilder().setName(name).build();
    return getCdnConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `CdnConfig` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CdnConfigServiceClient cdnConfigServiceClient = CdnConfigServiceClient.create()) {
   *   GetCdnConfigRequest request =
   *       GetCdnConfigRequest.newBuilder()
   *           .setName(CdnConfigName.of("[NETWORK_CODE]", "[CDN_CONFIG]").toString())
   *           .build();
   *   CdnConfig response = cdnConfigServiceClient.getCdnConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CdnConfig getCdnConfig(GetCdnConfigRequest request) {
    return getCdnConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `CdnConfig` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CdnConfigServiceClient cdnConfigServiceClient = CdnConfigServiceClient.create()) {
   *   GetCdnConfigRequest request =
   *       GetCdnConfigRequest.newBuilder()
   *           .setName(CdnConfigName.of("[NETWORK_CODE]", "[CDN_CONFIG]").toString())
   *           .build();
   *   ApiFuture<CdnConfig> future =
   *       cdnConfigServiceClient.getCdnConfigCallable().futureCall(request);
   *   // Do something.
   *   CdnConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCdnConfigRequest, CdnConfig> getCdnConfigCallable() {
    return stub.getCdnConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `CdnConfig` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CdnConfigServiceClient cdnConfigServiceClient = CdnConfigServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (CdnConfig element : cdnConfigServiceClient.listCdnConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of CdnConfigs. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCdnConfigsPagedResponse listCdnConfigs(@Nullable NetworkName parent) {
    ListCdnConfigsRequest request =
        ListCdnConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCdnConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `CdnConfig` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CdnConfigServiceClient cdnConfigServiceClient = CdnConfigServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (CdnConfig element : cdnConfigServiceClient.listCdnConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of CdnConfigs. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCdnConfigsPagedResponse listCdnConfigs(String parent) {
    ListCdnConfigsRequest request = ListCdnConfigsRequest.newBuilder().setParent(parent).build();
    return listCdnConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `CdnConfig` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CdnConfigServiceClient cdnConfigServiceClient = CdnConfigServiceClient.create()) {
   *   ListCdnConfigsRequest request =
   *       ListCdnConfigsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (CdnConfig element : cdnConfigServiceClient.listCdnConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCdnConfigsPagedResponse listCdnConfigs(ListCdnConfigsRequest request) {
    return listCdnConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `CdnConfig` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CdnConfigServiceClient cdnConfigServiceClient = CdnConfigServiceClient.create()) {
   *   ListCdnConfigsRequest request =
   *       ListCdnConfigsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<CdnConfig> future =
   *       cdnConfigServiceClient.listCdnConfigsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CdnConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCdnConfigsRequest, ListCdnConfigsPagedResponse>
      listCdnConfigsPagedCallable() {
    return stub.listCdnConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `CdnConfig` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CdnConfigServiceClient cdnConfigServiceClient = CdnConfigServiceClient.create()) {
   *   ListCdnConfigsRequest request =
   *       ListCdnConfigsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListCdnConfigsResponse response =
   *         cdnConfigServiceClient.listCdnConfigsCallable().call(request);
   *     for (CdnConfig element : response.getCdnConfigsList()) {
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
  public final UnaryCallable<ListCdnConfigsRequest, ListCdnConfigsResponse>
      listCdnConfigsCallable() {
    return stub.listCdnConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `CdnConfig` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CdnConfigServiceClient cdnConfigServiceClient = CdnConfigServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   CdnConfig cdnConfig = CdnConfig.newBuilder().build();
   *   CdnConfig response = cdnConfigServiceClient.createCdnConfig(parent, cdnConfig);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `CdnConfig` will be created. Format:
   *     `networks/{network_code}`
   * @param cdnConfig Required. The `CdnConfig` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CdnConfig createCdnConfig(@Nullable NetworkName parent, CdnConfig cdnConfig) {
    CreateCdnConfigRequest request =
        CreateCdnConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCdnConfig(cdnConfig)
            .build();
    return createCdnConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `CdnConfig` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CdnConfigServiceClient cdnConfigServiceClient = CdnConfigServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   CdnConfig cdnConfig = CdnConfig.newBuilder().build();
   *   CdnConfig response = cdnConfigServiceClient.createCdnConfig(parent, cdnConfig);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `CdnConfig` will be created. Format:
   *     `networks/{network_code}`
   * @param cdnConfig Required. The `CdnConfig` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CdnConfig createCdnConfig(String parent, CdnConfig cdnConfig) {
    CreateCdnConfigRequest request =
        CreateCdnConfigRequest.newBuilder().setParent(parent).setCdnConfig(cdnConfig).build();
    return createCdnConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `CdnConfig` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CdnConfigServiceClient cdnConfigServiceClient = CdnConfigServiceClient.create()) {
   *   CreateCdnConfigRequest request =
   *       CreateCdnConfigRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setCdnConfig(CdnConfig.newBuilder().build())
   *           .build();
   *   CdnConfig response = cdnConfigServiceClient.createCdnConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CdnConfig createCdnConfig(CreateCdnConfigRequest request) {
    return createCdnConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `CdnConfig` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CdnConfigServiceClient cdnConfigServiceClient = CdnConfigServiceClient.create()) {
   *   CreateCdnConfigRequest request =
   *       CreateCdnConfigRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setCdnConfig(CdnConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<CdnConfig> future =
   *       cdnConfigServiceClient.createCdnConfigCallable().futureCall(request);
   *   // Do something.
   *   CdnConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCdnConfigRequest, CdnConfig> createCdnConfigCallable() {
    return stub.createCdnConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `CdnConfig` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CdnConfigServiceClient cdnConfigServiceClient = CdnConfigServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<CreateCdnConfigRequest> requests = new ArrayList<>();
   *   BatchCreateCdnConfigsResponse response =
   *       cdnConfigServiceClient.batchCreateCdnConfigs(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `CdnConfigs` will be created. Format:
   *     `networks/{network_code}` The parent field in the CreateCdnConfigRequest must match this
   *     field.
   * @param requests Required. The `CdnConfig` objects to create. A maximum of 100 objects can be
   *     created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateCdnConfigsResponse batchCreateCdnConfigs(
      @Nullable NetworkName parent, List<CreateCdnConfigRequest> requests) {
    BatchCreateCdnConfigsRequest request =
        BatchCreateCdnConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchCreateCdnConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `CdnConfig` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CdnConfigServiceClient cdnConfigServiceClient = CdnConfigServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<CreateCdnConfigRequest> requests = new ArrayList<>();
   *   BatchCreateCdnConfigsResponse response =
   *       cdnConfigServiceClient.batchCreateCdnConfigs(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `CdnConfigs` will be created. Format:
   *     `networks/{network_code}` The parent field in the CreateCdnConfigRequest must match this
   *     field.
   * @param requests Required. The `CdnConfig` objects to create. A maximum of 100 objects can be
   *     created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateCdnConfigsResponse batchCreateCdnConfigs(
      String parent, List<CreateCdnConfigRequest> requests) {
    BatchCreateCdnConfigsRequest request =
        BatchCreateCdnConfigsRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchCreateCdnConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `CdnConfig` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CdnConfigServiceClient cdnConfigServiceClient = CdnConfigServiceClient.create()) {
   *   BatchCreateCdnConfigsRequest request =
   *       BatchCreateCdnConfigsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateCdnConfigRequest>())
   *           .build();
   *   BatchCreateCdnConfigsResponse response =
   *       cdnConfigServiceClient.batchCreateCdnConfigs(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateCdnConfigsResponse batchCreateCdnConfigs(
      BatchCreateCdnConfigsRequest request) {
    return batchCreateCdnConfigsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `CdnConfig` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CdnConfigServiceClient cdnConfigServiceClient = CdnConfigServiceClient.create()) {
   *   BatchCreateCdnConfigsRequest request =
   *       BatchCreateCdnConfigsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateCdnConfigRequest>())
   *           .build();
   *   ApiFuture<BatchCreateCdnConfigsResponse> future =
   *       cdnConfigServiceClient.batchCreateCdnConfigsCallable().futureCall(request);
   *   // Do something.
   *   BatchCreateCdnConfigsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchCreateCdnConfigsRequest, BatchCreateCdnConfigsResponse>
      batchCreateCdnConfigsCallable() {
    return stub.batchCreateCdnConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `CdnConfig` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CdnConfigServiceClient cdnConfigServiceClient = CdnConfigServiceClient.create()) {
   *   CdnConfig cdnConfig = CdnConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   CdnConfig response = cdnConfigServiceClient.updateCdnConfig(cdnConfig, updateMask);
   * }
   * }</pre>
   *
   * @param cdnConfig Required. The `CdnConfig` to update.
   *     <p>The `CdnConfig`'s `name` is used to identify the `CdnConfig` to update.
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CdnConfig updateCdnConfig(CdnConfig cdnConfig, FieldMask updateMask) {
    UpdateCdnConfigRequest request =
        UpdateCdnConfigRequest.newBuilder()
            .setCdnConfig(cdnConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateCdnConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `CdnConfig` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CdnConfigServiceClient cdnConfigServiceClient = CdnConfigServiceClient.create()) {
   *   UpdateCdnConfigRequest request =
   *       UpdateCdnConfigRequest.newBuilder()
   *           .setCdnConfig(CdnConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   CdnConfig response = cdnConfigServiceClient.updateCdnConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CdnConfig updateCdnConfig(UpdateCdnConfigRequest request) {
    return updateCdnConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `CdnConfig` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CdnConfigServiceClient cdnConfigServiceClient = CdnConfigServiceClient.create()) {
   *   UpdateCdnConfigRequest request =
   *       UpdateCdnConfigRequest.newBuilder()
   *           .setCdnConfig(CdnConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<CdnConfig> future =
   *       cdnConfigServiceClient.updateCdnConfigCallable().futureCall(request);
   *   // Do something.
   *   CdnConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCdnConfigRequest, CdnConfig> updateCdnConfigCallable() {
    return stub.updateCdnConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `CdnConfig` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CdnConfigServiceClient cdnConfigServiceClient = CdnConfigServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<UpdateCdnConfigRequest> requests = new ArrayList<>();
   *   BatchUpdateCdnConfigsResponse response =
   *       cdnConfigServiceClient.batchUpdateCdnConfigs(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `CdnConfigs` will be updated. Format:
   *     `networks/{network_code}` The parent field in the UpdateCdnConfigRequest must match this
   *     field.
   * @param requests Required. The `CdnConfig` objects to update. A maximum of 100 objects can be
   *     updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateCdnConfigsResponse batchUpdateCdnConfigs(
      @Nullable NetworkName parent, List<UpdateCdnConfigRequest> requests) {
    BatchUpdateCdnConfigsRequest request =
        BatchUpdateCdnConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchUpdateCdnConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `CdnConfig` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CdnConfigServiceClient cdnConfigServiceClient = CdnConfigServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<UpdateCdnConfigRequest> requests = new ArrayList<>();
   *   BatchUpdateCdnConfigsResponse response =
   *       cdnConfigServiceClient.batchUpdateCdnConfigs(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `CdnConfigs` will be updated. Format:
   *     `networks/{network_code}` The parent field in the UpdateCdnConfigRequest must match this
   *     field.
   * @param requests Required. The `CdnConfig` objects to update. A maximum of 100 objects can be
   *     updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateCdnConfigsResponse batchUpdateCdnConfigs(
      String parent, List<UpdateCdnConfigRequest> requests) {
    BatchUpdateCdnConfigsRequest request =
        BatchUpdateCdnConfigsRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchUpdateCdnConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `CdnConfig` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CdnConfigServiceClient cdnConfigServiceClient = CdnConfigServiceClient.create()) {
   *   BatchUpdateCdnConfigsRequest request =
   *       BatchUpdateCdnConfigsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateCdnConfigRequest>())
   *           .build();
   *   BatchUpdateCdnConfigsResponse response =
   *       cdnConfigServiceClient.batchUpdateCdnConfigs(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateCdnConfigsResponse batchUpdateCdnConfigs(
      BatchUpdateCdnConfigsRequest request) {
    return batchUpdateCdnConfigsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `CdnConfig` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CdnConfigServiceClient cdnConfigServiceClient = CdnConfigServiceClient.create()) {
   *   BatchUpdateCdnConfigsRequest request =
   *       BatchUpdateCdnConfigsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateCdnConfigRequest>())
   *           .build();
   *   ApiFuture<BatchUpdateCdnConfigsResponse> future =
   *       cdnConfigServiceClient.batchUpdateCdnConfigsCallable().futureCall(request);
   *   // Do something.
   *   BatchUpdateCdnConfigsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchUpdateCdnConfigsRequest, BatchUpdateCdnConfigsResponse>
      batchUpdateCdnConfigsCallable() {
    return stub.batchUpdateCdnConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch activates `CdnConfig` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CdnConfigServiceClient cdnConfigServiceClient = CdnConfigServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchActivateCdnConfigsResponse response =
   *       cdnConfigServiceClient.batchActivateCdnConfigs(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `CdnConfig` objects to activate. Format:
   *     `networks/{network_code}/cdnConfigs/{cdn_config_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateCdnConfigsResponse batchActivateCdnConfigs(
      @Nullable NetworkName parent, List<String> names) {
    BatchActivateCdnConfigsRequest request =
        BatchActivateCdnConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchActivateCdnConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch activates `CdnConfig` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CdnConfigServiceClient cdnConfigServiceClient = CdnConfigServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchActivateCdnConfigsResponse response =
   *       cdnConfigServiceClient.batchActivateCdnConfigs(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `CdnConfig` objects to activate. Format:
   *     `networks/{network_code}/cdnConfigs/{cdn_config_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateCdnConfigsResponse batchActivateCdnConfigs(
      String parent, List<String> names) {
    BatchActivateCdnConfigsRequest request =
        BatchActivateCdnConfigsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchActivateCdnConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch activates `CdnConfig` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CdnConfigServiceClient cdnConfigServiceClient = CdnConfigServiceClient.create()) {
   *   BatchActivateCdnConfigsRequest request =
   *       BatchActivateCdnConfigsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchActivateCdnConfigsResponse response =
   *       cdnConfigServiceClient.batchActivateCdnConfigs(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateCdnConfigsResponse batchActivateCdnConfigs(
      BatchActivateCdnConfigsRequest request) {
    return batchActivateCdnConfigsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch activates `CdnConfig` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CdnConfigServiceClient cdnConfigServiceClient = CdnConfigServiceClient.create()) {
   *   BatchActivateCdnConfigsRequest request =
   *       BatchActivateCdnConfigsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchActivateCdnConfigsResponse> future =
   *       cdnConfigServiceClient.batchActivateCdnConfigsCallable().futureCall(request);
   *   // Do something.
   *   BatchActivateCdnConfigsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchActivateCdnConfigsRequest, BatchActivateCdnConfigsResponse>
      batchActivateCdnConfigsCallable() {
    return stub.batchActivateCdnConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch archives `CdnConfig` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CdnConfigServiceClient cdnConfigServiceClient = CdnConfigServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchArchiveCdnConfigsResponse response =
   *       cdnConfigServiceClient.batchArchiveCdnConfigs(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `CdnConfig` objects to archive. Format:
   *     `networks/{network_code}/cdnConfigs/{cdn_config_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchArchiveCdnConfigsResponse batchArchiveCdnConfigs(
      @Nullable NetworkName parent, List<String> names) {
    BatchArchiveCdnConfigsRequest request =
        BatchArchiveCdnConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchArchiveCdnConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch archives `CdnConfig` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CdnConfigServiceClient cdnConfigServiceClient = CdnConfigServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchArchiveCdnConfigsResponse response =
   *       cdnConfigServiceClient.batchArchiveCdnConfigs(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `CdnConfig` objects to archive. Format:
   *     `networks/{network_code}/cdnConfigs/{cdn_config_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchArchiveCdnConfigsResponse batchArchiveCdnConfigs(
      String parent, List<String> names) {
    BatchArchiveCdnConfigsRequest request =
        BatchArchiveCdnConfigsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchArchiveCdnConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch archives `CdnConfig` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CdnConfigServiceClient cdnConfigServiceClient = CdnConfigServiceClient.create()) {
   *   BatchArchiveCdnConfigsRequest request =
   *       BatchArchiveCdnConfigsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchArchiveCdnConfigsResponse response =
   *       cdnConfigServiceClient.batchArchiveCdnConfigs(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchArchiveCdnConfigsResponse batchArchiveCdnConfigs(
      BatchArchiveCdnConfigsRequest request) {
    return batchArchiveCdnConfigsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch archives `CdnConfig` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CdnConfigServiceClient cdnConfigServiceClient = CdnConfigServiceClient.create()) {
   *   BatchArchiveCdnConfigsRequest request =
   *       BatchArchiveCdnConfigsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchArchiveCdnConfigsResponse> future =
   *       cdnConfigServiceClient.batchArchiveCdnConfigsCallable().futureCall(request);
   *   // Do something.
   *   BatchArchiveCdnConfigsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchArchiveCdnConfigsRequest, BatchArchiveCdnConfigsResponse>
      batchArchiveCdnConfigsCallable() {
    return stub.batchArchiveCdnConfigsCallable();
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

  public static class ListCdnConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListCdnConfigsRequest,
          ListCdnConfigsResponse,
          CdnConfig,
          ListCdnConfigsPage,
          ListCdnConfigsFixedSizeCollection> {

    public static ApiFuture<ListCdnConfigsPagedResponse> createAsync(
        PageContext<ListCdnConfigsRequest, ListCdnConfigsResponse, CdnConfig> context,
        ApiFuture<ListCdnConfigsResponse> futureResponse) {
      ApiFuture<ListCdnConfigsPage> futurePage =
          ListCdnConfigsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCdnConfigsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCdnConfigsPagedResponse(ListCdnConfigsPage page) {
      super(page, ListCdnConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCdnConfigsPage
      extends AbstractPage<
          ListCdnConfigsRequest, ListCdnConfigsResponse, CdnConfig, ListCdnConfigsPage> {

    private ListCdnConfigsPage(
        @Nullable PageContext<ListCdnConfigsRequest, ListCdnConfigsResponse, CdnConfig> context,
        @Nullable ListCdnConfigsResponse response) {
      super(context, response);
    }

    private static ListCdnConfigsPage createEmptyPage() {
      return new ListCdnConfigsPage(null, null);
    }

    @Override
    protected ListCdnConfigsPage createPage(
        @Nullable PageContext<ListCdnConfigsRequest, ListCdnConfigsResponse, CdnConfig> context,
        @Nullable ListCdnConfigsResponse response) {
      return new ListCdnConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListCdnConfigsPage> createPageAsync(
        @Nullable PageContext<ListCdnConfigsRequest, ListCdnConfigsResponse, CdnConfig> context,
        ApiFuture<ListCdnConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCdnConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCdnConfigsRequest,
          ListCdnConfigsResponse,
          CdnConfig,
          ListCdnConfigsPage,
          ListCdnConfigsFixedSizeCollection> {

    private ListCdnConfigsFixedSizeCollection(
        @Nullable List<ListCdnConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCdnConfigsFixedSizeCollection createEmptyCollection() {
      return new ListCdnConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCdnConfigsFixedSizeCollection createCollection(
        @Nullable List<ListCdnConfigsPage> pages, int collectionSize) {
      return new ListCdnConfigsFixedSizeCollection(pages, collectionSize);
    }
  }
}
