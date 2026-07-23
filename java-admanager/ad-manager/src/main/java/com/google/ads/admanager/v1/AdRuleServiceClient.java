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

import com.google.ads.admanager.v1.stub.AdRuleServiceStub;
import com.google.ads.admanager.v1.stub.AdRuleServiceStubSettings;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for handling `AdRule` objects.
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
 * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
 *   AdRuleName name = AdRuleName.of("[NETWORK_CODE]", "[AD_RULE]");
 *   AdRule response = adRuleServiceClient.getAdRule(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AdRuleServiceClient object to clean up resources such
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
 *      <td><p> GetAdRule</td>
 *      <td><p> Retrieves an `AdRule` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAdRule(GetAdRuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAdRule(AdRuleName name)
 *           <li><p> getAdRule(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAdRuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAdRules</td>
 *      <td><p> Lists `AdRule` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAdRules(ListAdRulesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAdRules(NetworkName parent)
 *           <li><p> listAdRules(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAdRulesPagedCallable()
 *           <li><p> listAdRulesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateAdRule</td>
 *      <td><p> Creates a `AdRule` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAdRule(CreateAdRuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createAdRule(NetworkName parent, AdRule adRule)
 *           <li><p> createAdRule(String parent, AdRule adRule)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAdRuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreateAdRules</td>
 *      <td><p> Batch creates `AdRule` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateAdRules(NetworkName parent, List&lt;CreateAdRuleRequest&gt; requests)
 *           <li><p> batchCreateAdRules(String parent, List&lt;CreateAdRuleRequest&gt; requests)
 *           <li><p> batchCreateAdRules(BatchCreateAdRulesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateAdRulesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateAdRule</td>
 *      <td><p> Updates a `AdRule` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAdRule(UpdateAdRuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateAdRule(AdRule adRule, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAdRuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUpdateAdRules</td>
 *      <td><p> Batch updates `AdRule` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUpdateAdRules(NetworkName parent, List&lt;UpdateAdRuleRequest&gt; requests)
 *           <li><p> batchUpdateAdRules(String parent, List&lt;UpdateAdRuleRequest&gt; requests)
 *           <li><p> batchUpdateAdRules(BatchUpdateAdRulesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUpdateAdRulesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchActivateAdRules</td>
 *      <td><p> Activates a list of `AdRule` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchActivateAdRules(BatchActivateAdRulesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchActivateAdRules(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchActivateAdRules(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchActivateAdRulesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchDeactivateAdRules</td>
 *      <td><p> Deactivates a list of `AdRule` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchDeactivateAdRules(BatchDeactivateAdRulesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchDeactivateAdRules(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchDeactivateAdRules(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchDeactivateAdRulesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchDeleteAdRules</td>
 *      <td><p> Deletes a list of `AdRule` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchDeleteAdRules(BatchDeleteAdRulesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchDeleteAdRules(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchDeleteAdRules(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchDeleteAdRulesCallable()
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
 * <p>This class can be customized by passing in a custom instance of AdRuleServiceSettings to
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
 * AdRuleServiceSettings adRuleServiceSettings =
 *     AdRuleServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create(adRuleServiceSettings);
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
 * AdRuleServiceSettings adRuleServiceSettings =
 *     AdRuleServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create(adRuleServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class AdRuleServiceClient implements BackgroundResource {
  private final @Nullable AdRuleServiceSettings settings;
  private final AdRuleServiceStub stub;

  /** Constructs an instance of AdRuleServiceClient with default settings. */
  public static final AdRuleServiceClient create() throws IOException {
    return create(AdRuleServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AdRuleServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AdRuleServiceClient create(AdRuleServiceSettings settings)
      throws IOException {
    return new AdRuleServiceClient(settings);
  }

  /**
   * Constructs an instance of AdRuleServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(AdRuleServiceSettings).
   */
  public static final AdRuleServiceClient create(AdRuleServiceStub stub) {
    return new AdRuleServiceClient(stub);
  }

  /**
   * Constructs an instance of AdRuleServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected AdRuleServiceClient(AdRuleServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AdRuleServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected AdRuleServiceClient(AdRuleServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable AdRuleServiceSettings getSettings() {
    return settings;
  }

  public AdRuleServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an `AdRule` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   AdRuleName name = AdRuleName.of("[NETWORK_CODE]", "[AD_RULE]");
   *   AdRule response = adRuleServiceClient.getAdRule(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the AdRule. Format:
   *     `networks/{network_code}/adRules/{ad_rule_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdRule getAdRule(@Nullable AdRuleName name) {
    GetAdRuleRequest request =
        GetAdRuleRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAdRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an `AdRule` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   String name = AdRuleName.of("[NETWORK_CODE]", "[AD_RULE]").toString();
   *   AdRule response = adRuleServiceClient.getAdRule(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the AdRule. Format:
   *     `networks/{network_code}/adRules/{ad_rule_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdRule getAdRule(String name) {
    GetAdRuleRequest request = GetAdRuleRequest.newBuilder().setName(name).build();
    return getAdRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an `AdRule` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   GetAdRuleRequest request =
   *       GetAdRuleRequest.newBuilder()
   *           .setName(AdRuleName.of("[NETWORK_CODE]", "[AD_RULE]").toString())
   *           .build();
   *   AdRule response = adRuleServiceClient.getAdRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdRule getAdRule(GetAdRuleRequest request) {
    return getAdRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an `AdRule` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   GetAdRuleRequest request =
   *       GetAdRuleRequest.newBuilder()
   *           .setName(AdRuleName.of("[NETWORK_CODE]", "[AD_RULE]").toString())
   *           .build();
   *   ApiFuture<AdRule> future = adRuleServiceClient.getAdRuleCallable().futureCall(request);
   *   // Do something.
   *   AdRule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAdRuleRequest, AdRule> getAdRuleCallable() {
    return stub.getAdRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `AdRule` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (AdRule element : adRuleServiceClient.listAdRules(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of AdRules. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdRulesPagedResponse listAdRules(@Nullable NetworkName parent) {
    ListAdRulesRequest request =
        ListAdRulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAdRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `AdRule` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (AdRule element : adRuleServiceClient.listAdRules(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of AdRules. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdRulesPagedResponse listAdRules(String parent) {
    ListAdRulesRequest request = ListAdRulesRequest.newBuilder().setParent(parent).build();
    return listAdRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `AdRule` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   ListAdRulesRequest request =
   *       ListAdRulesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (AdRule element : adRuleServiceClient.listAdRules(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdRulesPagedResponse listAdRules(ListAdRulesRequest request) {
    return listAdRulesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `AdRule` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   ListAdRulesRequest request =
   *       ListAdRulesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<AdRule> future = adRuleServiceClient.listAdRulesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AdRule element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAdRulesRequest, ListAdRulesPagedResponse>
      listAdRulesPagedCallable() {
    return stub.listAdRulesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `AdRule` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   ListAdRulesRequest request =
   *       ListAdRulesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListAdRulesResponse response = adRuleServiceClient.listAdRulesCallable().call(request);
   *     for (AdRule element : response.getAdRulesList()) {
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
  public final UnaryCallable<ListAdRulesRequest, ListAdRulesResponse> listAdRulesCallable() {
    return stub.listAdRulesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `AdRule` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   AdRule adRule = AdRule.newBuilder().build();
   *   AdRule response = adRuleServiceClient.createAdRule(parent, adRule);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `AdRule` will be created. Format:
   *     `networks/{network_code}`
   * @param adRule Required. The `AdRule` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdRule createAdRule(@Nullable NetworkName parent, AdRule adRule) {
    CreateAdRuleRequest request =
        CreateAdRuleRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAdRule(adRule)
            .build();
    return createAdRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `AdRule` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   AdRule adRule = AdRule.newBuilder().build();
   *   AdRule response = adRuleServiceClient.createAdRule(parent, adRule);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `AdRule` will be created. Format:
   *     `networks/{network_code}`
   * @param adRule Required. The `AdRule` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdRule createAdRule(String parent, AdRule adRule) {
    CreateAdRuleRequest request =
        CreateAdRuleRequest.newBuilder().setParent(parent).setAdRule(adRule).build();
    return createAdRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `AdRule` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   CreateAdRuleRequest request =
   *       CreateAdRuleRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setAdRule(AdRule.newBuilder().build())
   *           .build();
   *   AdRule response = adRuleServiceClient.createAdRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdRule createAdRule(CreateAdRuleRequest request) {
    return createAdRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `AdRule` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   CreateAdRuleRequest request =
   *       CreateAdRuleRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setAdRule(AdRule.newBuilder().build())
   *           .build();
   *   ApiFuture<AdRule> future = adRuleServiceClient.createAdRuleCallable().futureCall(request);
   *   // Do something.
   *   AdRule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAdRuleRequest, AdRule> createAdRuleCallable() {
    return stub.createAdRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `AdRule` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<CreateAdRuleRequest> requests = new ArrayList<>();
   *   BatchCreateAdRulesResponse response =
   *       adRuleServiceClient.batchCreateAdRules(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `AdRules` will be created. Format:
   *     `networks/{network_code}` The parent field in the CreateAdRuleRequest must match this
   *     field.
   * @param requests Required. The `AdRule` objects to create. A maximum of 100 objects can be
   *     created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateAdRulesResponse batchCreateAdRules(
      @Nullable NetworkName parent, List<CreateAdRuleRequest> requests) {
    BatchCreateAdRulesRequest request =
        BatchCreateAdRulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchCreateAdRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `AdRule` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<CreateAdRuleRequest> requests = new ArrayList<>();
   *   BatchCreateAdRulesResponse response =
   *       adRuleServiceClient.batchCreateAdRules(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `AdRules` will be created. Format:
   *     `networks/{network_code}` The parent field in the CreateAdRuleRequest must match this
   *     field.
   * @param requests Required. The `AdRule` objects to create. A maximum of 100 objects can be
   *     created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateAdRulesResponse batchCreateAdRules(
      String parent, List<CreateAdRuleRequest> requests) {
    BatchCreateAdRulesRequest request =
        BatchCreateAdRulesRequest.newBuilder().setParent(parent).addAllRequests(requests).build();
    return batchCreateAdRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `AdRule` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   BatchCreateAdRulesRequest request =
   *       BatchCreateAdRulesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateAdRuleRequest>())
   *           .build();
   *   BatchCreateAdRulesResponse response = adRuleServiceClient.batchCreateAdRules(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateAdRulesResponse batchCreateAdRules(BatchCreateAdRulesRequest request) {
    return batchCreateAdRulesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `AdRule` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   BatchCreateAdRulesRequest request =
   *       BatchCreateAdRulesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateAdRuleRequest>())
   *           .build();
   *   ApiFuture<BatchCreateAdRulesResponse> future =
   *       adRuleServiceClient.batchCreateAdRulesCallable().futureCall(request);
   *   // Do something.
   *   BatchCreateAdRulesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchCreateAdRulesRequest, BatchCreateAdRulesResponse>
      batchCreateAdRulesCallable() {
    return stub.batchCreateAdRulesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `AdRule` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   AdRule adRule = AdRule.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AdRule response = adRuleServiceClient.updateAdRule(adRule, updateMask);
   * }
   * }</pre>
   *
   * @param adRule Required. The `AdRule` to update.
   *     <p>The `AdRule`'s `name` is used to identify the `AdRule` to update.
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdRule updateAdRule(AdRule adRule, FieldMask updateMask) {
    UpdateAdRuleRequest request =
        UpdateAdRuleRequest.newBuilder().setAdRule(adRule).setUpdateMask(updateMask).build();
    return updateAdRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `AdRule` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   UpdateAdRuleRequest request =
   *       UpdateAdRuleRequest.newBuilder()
   *           .setAdRule(AdRule.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   AdRule response = adRuleServiceClient.updateAdRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdRule updateAdRule(UpdateAdRuleRequest request) {
    return updateAdRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `AdRule` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   UpdateAdRuleRequest request =
   *       UpdateAdRuleRequest.newBuilder()
   *           .setAdRule(AdRule.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<AdRule> future = adRuleServiceClient.updateAdRuleCallable().futureCall(request);
   *   // Do something.
   *   AdRule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAdRuleRequest, AdRule> updateAdRuleCallable() {
    return stub.updateAdRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `AdRule` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<UpdateAdRuleRequest> requests = new ArrayList<>();
   *   BatchUpdateAdRulesResponse response =
   *       adRuleServiceClient.batchUpdateAdRules(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `AdRules` will be updated. Format:
   *     `networks/{network_code}` The parent field in the UpdateAdRuleRequest must match this
   *     field.
   * @param requests Required. The `AdRule` objects to update. A maximum of 100 objects can be
   *     updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateAdRulesResponse batchUpdateAdRules(
      @Nullable NetworkName parent, List<UpdateAdRuleRequest> requests) {
    BatchUpdateAdRulesRequest request =
        BatchUpdateAdRulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchUpdateAdRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `AdRule` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<UpdateAdRuleRequest> requests = new ArrayList<>();
   *   BatchUpdateAdRulesResponse response =
   *       adRuleServiceClient.batchUpdateAdRules(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `AdRules` will be updated. Format:
   *     `networks/{network_code}` The parent field in the UpdateAdRuleRequest must match this
   *     field.
   * @param requests Required. The `AdRule` objects to update. A maximum of 100 objects can be
   *     updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateAdRulesResponse batchUpdateAdRules(
      String parent, List<UpdateAdRuleRequest> requests) {
    BatchUpdateAdRulesRequest request =
        BatchUpdateAdRulesRequest.newBuilder().setParent(parent).addAllRequests(requests).build();
    return batchUpdateAdRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `AdRule` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   BatchUpdateAdRulesRequest request =
   *       BatchUpdateAdRulesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateAdRuleRequest>())
   *           .build();
   *   BatchUpdateAdRulesResponse response = adRuleServiceClient.batchUpdateAdRules(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateAdRulesResponse batchUpdateAdRules(BatchUpdateAdRulesRequest request) {
    return batchUpdateAdRulesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `AdRule` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   BatchUpdateAdRulesRequest request =
   *       BatchUpdateAdRulesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateAdRuleRequest>())
   *           .build();
   *   ApiFuture<BatchUpdateAdRulesResponse> future =
   *       adRuleServiceClient.batchUpdateAdRulesCallable().futureCall(request);
   *   // Do something.
   *   BatchUpdateAdRulesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchUpdateAdRulesRequest, BatchUpdateAdRulesResponse>
      batchUpdateAdRulesCallable() {
    return stub.batchUpdateAdRulesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activates a list of `AdRule` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchActivateAdRulesResponse response =
   *       adRuleServiceClient.batchActivateAdRules(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. Resource names for the AdRule. Format:
   *     `networks/{network_code}/adRules/{ad_rule}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateAdRulesResponse batchActivateAdRules(
      @Nullable NetworkName parent, List<String> names) {
    BatchActivateAdRulesRequest request =
        BatchActivateAdRulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchActivateAdRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activates a list of `AdRule` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchActivateAdRulesResponse response =
   *       adRuleServiceClient.batchActivateAdRules(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. Resource names for the AdRule. Format:
   *     `networks/{network_code}/adRules/{ad_rule}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateAdRulesResponse batchActivateAdRules(
      String parent, List<String> names) {
    BatchActivateAdRulesRequest request =
        BatchActivateAdRulesRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchActivateAdRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activates a list of `AdRule` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   BatchActivateAdRulesRequest request =
   *       BatchActivateAdRulesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchActivateAdRulesResponse response = adRuleServiceClient.batchActivateAdRules(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateAdRulesResponse batchActivateAdRules(
      BatchActivateAdRulesRequest request) {
    return batchActivateAdRulesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activates a list of `AdRule` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   BatchActivateAdRulesRequest request =
   *       BatchActivateAdRulesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchActivateAdRulesResponse> future =
   *       adRuleServiceClient.batchActivateAdRulesCallable().futureCall(request);
   *   // Do something.
   *   BatchActivateAdRulesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchActivateAdRulesRequest, BatchActivateAdRulesResponse>
      batchActivateAdRulesCallable() {
    return stub.batchActivateAdRulesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `AdRule` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchDeactivateAdRulesResponse response =
   *       adRuleServiceClient.batchDeactivateAdRules(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. Resource names for the AdRule. Format:
   *     `networks/{network_code}/adRules/{ad_rule}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateAdRulesResponse batchDeactivateAdRules(
      @Nullable NetworkName parent, List<String> names) {
    BatchDeactivateAdRulesRequest request =
        BatchDeactivateAdRulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchDeactivateAdRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `AdRule` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchDeactivateAdRulesResponse response =
   *       adRuleServiceClient.batchDeactivateAdRules(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. Resource names for the AdRule. Format:
   *     `networks/{network_code}/adRules/{ad_rule}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateAdRulesResponse batchDeactivateAdRules(
      String parent, List<String> names) {
    BatchDeactivateAdRulesRequest request =
        BatchDeactivateAdRulesRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchDeactivateAdRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `AdRule` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   BatchDeactivateAdRulesRequest request =
   *       BatchDeactivateAdRulesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchDeactivateAdRulesResponse response = adRuleServiceClient.batchDeactivateAdRules(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateAdRulesResponse batchDeactivateAdRules(
      BatchDeactivateAdRulesRequest request) {
    return batchDeactivateAdRulesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `AdRule` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   BatchDeactivateAdRulesRequest request =
   *       BatchDeactivateAdRulesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchDeactivateAdRulesResponse> future =
   *       adRuleServiceClient.batchDeactivateAdRulesCallable().futureCall(request);
   *   // Do something.
   *   BatchDeactivateAdRulesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchDeactivateAdRulesRequest, BatchDeactivateAdRulesResponse>
      batchDeactivateAdRulesCallable() {
    return stub.batchDeactivateAdRulesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a list of `AdRule` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   adRuleServiceClient.batchDeleteAdRules(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. Resource names for the AdRule. Format:
   *     `networks/{network_code}/adRules/{ad_rule}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void batchDeleteAdRules(@Nullable NetworkName parent, List<String> names) {
    BatchDeleteAdRulesRequest request =
        BatchDeleteAdRulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    batchDeleteAdRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a list of `AdRule` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   adRuleServiceClient.batchDeleteAdRules(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. Resource names for the AdRule. Format:
   *     `networks/{network_code}/adRules/{ad_rule}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void batchDeleteAdRules(String parent, List<String> names) {
    BatchDeleteAdRulesRequest request =
        BatchDeleteAdRulesRequest.newBuilder().setParent(parent).addAllNames(names).build();
    batchDeleteAdRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a list of `AdRule` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   BatchDeleteAdRulesRequest request =
   *       BatchDeleteAdRulesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   adRuleServiceClient.batchDeleteAdRules(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void batchDeleteAdRules(BatchDeleteAdRulesRequest request) {
    batchDeleteAdRulesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a list of `AdRule` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
   *   BatchDeleteAdRulesRequest request =
   *       BatchDeleteAdRulesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<Empty> future =
   *       adRuleServiceClient.batchDeleteAdRulesCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchDeleteAdRulesRequest, Empty> batchDeleteAdRulesCallable() {
    return stub.batchDeleteAdRulesCallable();
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

  public static class ListAdRulesPagedResponse
      extends AbstractPagedListResponse<
          ListAdRulesRequest,
          ListAdRulesResponse,
          AdRule,
          ListAdRulesPage,
          ListAdRulesFixedSizeCollection> {

    public static ApiFuture<ListAdRulesPagedResponse> createAsync(
        PageContext<ListAdRulesRequest, ListAdRulesResponse, AdRule> context,
        ApiFuture<ListAdRulesResponse> futureResponse) {
      ApiFuture<ListAdRulesPage> futurePage =
          ListAdRulesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListAdRulesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListAdRulesPagedResponse(ListAdRulesPage page) {
      super(page, ListAdRulesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAdRulesPage
      extends AbstractPage<ListAdRulesRequest, ListAdRulesResponse, AdRule, ListAdRulesPage> {

    private ListAdRulesPage(
        @Nullable PageContext<ListAdRulesRequest, ListAdRulesResponse, AdRule> context,
        @Nullable ListAdRulesResponse response) {
      super(context, response);
    }

    private static ListAdRulesPage createEmptyPage() {
      return new ListAdRulesPage(null, null);
    }

    @Override
    protected ListAdRulesPage createPage(
        @Nullable PageContext<ListAdRulesRequest, ListAdRulesResponse, AdRule> context,
        @Nullable ListAdRulesResponse response) {
      return new ListAdRulesPage(context, response);
    }

    @Override
    public ApiFuture<ListAdRulesPage> createPageAsync(
        @Nullable PageContext<ListAdRulesRequest, ListAdRulesResponse, AdRule> context,
        ApiFuture<ListAdRulesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAdRulesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAdRulesRequest,
          ListAdRulesResponse,
          AdRule,
          ListAdRulesPage,
          ListAdRulesFixedSizeCollection> {

    private ListAdRulesFixedSizeCollection(
        @Nullable List<ListAdRulesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAdRulesFixedSizeCollection createEmptyCollection() {
      return new ListAdRulesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAdRulesFixedSizeCollection createCollection(
        @Nullable List<ListAdRulesPage> pages, int collectionSize) {
      return new ListAdRulesFixedSizeCollection(pages, collectionSize);
    }
  }
}
