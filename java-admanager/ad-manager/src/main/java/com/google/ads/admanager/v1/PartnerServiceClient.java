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

import com.google.ads.admanager.v1.stub.PartnerServiceStub;
import com.google.ads.admanager.v1.stub.PartnerServiceStubSettings;
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
 * Service Description: Provides methods for handling [Partner][google.ads.admanager.v1.Partner]
 * objects.
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
 * try (PartnerServiceClient partnerServiceClient = PartnerServiceClient.create()) {
 *   PartnerName name = PartnerName.of("[NETWORK_CODE]", "[PARTNER]");
 *   Partner response = partnerServiceClient.getPartner(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the PartnerServiceClient object to clean up resources such
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
 *      <td><p> GetPartner</td>
 *      <td><p> Retrieves a [Partner][google.ads.admanager.v1.Partner] object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPartner(GetPartnerRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPartner(PartnerName name)
 *           <li><p> getPartner(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPartnerCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPartners</td>
 *      <td><p> Lists [Partner][google.ads.admanager.v1.Partner] objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPartners(ListPartnersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPartners(NetworkName parent)
 *           <li><p> listPartners(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPartnersPagedCallable()
 *           <li><p> listPartnersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdatePartner</td>
 *      <td><p> Updates a [Partner][google.ads.admanager.v1.Partner] object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updatePartner(UpdatePartnerRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updatePartner(Partner partner, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updatePartnerCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUpdatePartners</td>
 *      <td><p> Batch updates [Partner][google.ads.admanager.v1.Partner] objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUpdatePartners(NetworkName parent, List&lt;UpdatePartnerRequest&gt; requests)
 *           <li><p> batchUpdatePartners(String parent, List&lt;UpdatePartnerRequest&gt; requests)
 *           <li><p> batchUpdatePartners(BatchUpdatePartnersRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUpdatePartnersCallable()
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
 * <p>This class can be customized by passing in a custom instance of PartnerServiceSettings to
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
 * PartnerServiceSettings partnerServiceSettings =
 *     PartnerServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PartnerServiceClient partnerServiceClient = PartnerServiceClient.create(partnerServiceSettings);
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
 * PartnerServiceSettings partnerServiceSettings =
 *     PartnerServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PartnerServiceClient partnerServiceClient = PartnerServiceClient.create(partnerServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class PartnerServiceClient implements BackgroundResource {
  private final @Nullable PartnerServiceSettings settings;
  private final PartnerServiceStub stub;

  /** Constructs an instance of PartnerServiceClient with default settings. */
  public static final PartnerServiceClient create() throws IOException {
    return create(PartnerServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of PartnerServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final PartnerServiceClient create(PartnerServiceSettings settings)
      throws IOException {
    return new PartnerServiceClient(settings);
  }

  /**
   * Constructs an instance of PartnerServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(PartnerServiceSettings).
   */
  public static final PartnerServiceClient create(PartnerServiceStub stub) {
    return new PartnerServiceClient(stub);
  }

  /**
   * Constructs an instance of PartnerServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected PartnerServiceClient(PartnerServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((PartnerServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected PartnerServiceClient(PartnerServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable PartnerServiceSettings getSettings() {
    return settings;
  }

  public PartnerServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a [Partner][google.ads.admanager.v1.Partner] object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PartnerServiceClient partnerServiceClient = PartnerServiceClient.create()) {
   *   PartnerName name = PartnerName.of("[NETWORK_CODE]", "[PARTNER]");
   *   Partner response = partnerServiceClient.getPartner(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the [Partner][google.ads.admanager.v1.Partner].
   *     Format: `networks/{network_code}/partners/{partner_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Partner getPartner(@Nullable PartnerName name) {
    GetPartnerRequest request =
        GetPartnerRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPartner(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a [Partner][google.ads.admanager.v1.Partner] object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PartnerServiceClient partnerServiceClient = PartnerServiceClient.create()) {
   *   String name = PartnerName.of("[NETWORK_CODE]", "[PARTNER]").toString();
   *   Partner response = partnerServiceClient.getPartner(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the [Partner][google.ads.admanager.v1.Partner].
   *     Format: `networks/{network_code}/partners/{partner_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Partner getPartner(String name) {
    GetPartnerRequest request = GetPartnerRequest.newBuilder().setName(name).build();
    return getPartner(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a [Partner][google.ads.admanager.v1.Partner] object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PartnerServiceClient partnerServiceClient = PartnerServiceClient.create()) {
   *   GetPartnerRequest request =
   *       GetPartnerRequest.newBuilder()
   *           .setName(PartnerName.of("[NETWORK_CODE]", "[PARTNER]").toString())
   *           .build();
   *   Partner response = partnerServiceClient.getPartner(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Partner getPartner(GetPartnerRequest request) {
    return getPartnerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a [Partner][google.ads.admanager.v1.Partner] object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PartnerServiceClient partnerServiceClient = PartnerServiceClient.create()) {
   *   GetPartnerRequest request =
   *       GetPartnerRequest.newBuilder()
   *           .setName(PartnerName.of("[NETWORK_CODE]", "[PARTNER]").toString())
   *           .build();
   *   ApiFuture<Partner> future = partnerServiceClient.getPartnerCallable().futureCall(request);
   *   // Do something.
   *   Partner response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPartnerRequest, Partner> getPartnerCallable() {
    return stub.getPartnerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Partner][google.ads.admanager.v1.Partner] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PartnerServiceClient partnerServiceClient = PartnerServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (Partner element : partnerServiceClient.listPartners(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of
   *     [Partner][google.ads.admanager.v1.Partner]s. Format: `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPartnersPagedResponse listPartners(@Nullable NetworkName parent) {
    ListPartnersRequest request =
        ListPartnersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPartners(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Partner][google.ads.admanager.v1.Partner] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PartnerServiceClient partnerServiceClient = PartnerServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (Partner element : partnerServiceClient.listPartners(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of
   *     [Partner][google.ads.admanager.v1.Partner]s. Format: `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPartnersPagedResponse listPartners(String parent) {
    ListPartnersRequest request = ListPartnersRequest.newBuilder().setParent(parent).build();
    return listPartners(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Partner][google.ads.admanager.v1.Partner] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PartnerServiceClient partnerServiceClient = PartnerServiceClient.create()) {
   *   ListPartnersRequest request =
   *       ListPartnersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (Partner element : partnerServiceClient.listPartners(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPartnersPagedResponse listPartners(ListPartnersRequest request) {
    return listPartnersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Partner][google.ads.admanager.v1.Partner] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PartnerServiceClient partnerServiceClient = PartnerServiceClient.create()) {
   *   ListPartnersRequest request =
   *       ListPartnersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<Partner> future =
   *       partnerServiceClient.listPartnersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Partner element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPartnersRequest, ListPartnersPagedResponse>
      listPartnersPagedCallable() {
    return stub.listPartnersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Partner][google.ads.admanager.v1.Partner] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PartnerServiceClient partnerServiceClient = PartnerServiceClient.create()) {
   *   ListPartnersRequest request =
   *       ListPartnersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListPartnersResponse response = partnerServiceClient.listPartnersCallable().call(request);
   *     for (Partner element : response.getPartnersList()) {
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
  public final UnaryCallable<ListPartnersRequest, ListPartnersResponse> listPartnersCallable() {
    return stub.listPartnersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [Partner][google.ads.admanager.v1.Partner] object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PartnerServiceClient partnerServiceClient = PartnerServiceClient.create()) {
   *   Partner partner = Partner.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Partner response = partnerServiceClient.updatePartner(partner, updateMask);
   * }
   * }</pre>
   *
   * @param partner Required. The [Partner][google.ads.admanager.v1.Partner] to update.
   *     <p>The [Partner][google.ads.admanager.v1.Partner]'s `name` is used to identify the
   *     [Partner][google.ads.admanager.v1.Partner] to update.
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Partner updatePartner(Partner partner, FieldMask updateMask) {
    UpdatePartnerRequest request =
        UpdatePartnerRequest.newBuilder().setPartner(partner).setUpdateMask(updateMask).build();
    return updatePartner(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [Partner][google.ads.admanager.v1.Partner] object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PartnerServiceClient partnerServiceClient = PartnerServiceClient.create()) {
   *   UpdatePartnerRequest request =
   *       UpdatePartnerRequest.newBuilder()
   *           .setPartner(Partner.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Partner response = partnerServiceClient.updatePartner(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Partner updatePartner(UpdatePartnerRequest request) {
    return updatePartnerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [Partner][google.ads.admanager.v1.Partner] object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PartnerServiceClient partnerServiceClient = PartnerServiceClient.create()) {
   *   UpdatePartnerRequest request =
   *       UpdatePartnerRequest.newBuilder()
   *           .setPartner(Partner.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Partner> future = partnerServiceClient.updatePartnerCallable().futureCall(request);
   *   // Do something.
   *   Partner response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePartnerRequest, Partner> updatePartnerCallable() {
    return stub.updatePartnerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates [Partner][google.ads.admanager.v1.Partner] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PartnerServiceClient partnerServiceClient = PartnerServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<UpdatePartnerRequest> requests = new ArrayList<>();
   *   BatchUpdatePartnersResponse response =
   *       partnerServiceClient.batchUpdatePartners(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where [Partner][google.ads.admanager.v1.Partner]s
   *     will be updated. Format: `networks/{network_code}` The parent field in the
   *     [UpdatePartnerRequest][google.ads.admanager.v1.UpdatePartnerRequest] must match this field.
   * @param requests Required. The [Partner][google.ads.admanager.v1.Partner] objects to update. A
   *     maximum of 100 objects can be updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdatePartnersResponse batchUpdatePartners(
      @Nullable NetworkName parent, List<UpdatePartnerRequest> requests) {
    BatchUpdatePartnersRequest request =
        BatchUpdatePartnersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchUpdatePartners(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates [Partner][google.ads.admanager.v1.Partner] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PartnerServiceClient partnerServiceClient = PartnerServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<UpdatePartnerRequest> requests = new ArrayList<>();
   *   BatchUpdatePartnersResponse response =
   *       partnerServiceClient.batchUpdatePartners(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where [Partner][google.ads.admanager.v1.Partner]s
   *     will be updated. Format: `networks/{network_code}` The parent field in the
   *     [UpdatePartnerRequest][google.ads.admanager.v1.UpdatePartnerRequest] must match this field.
   * @param requests Required. The [Partner][google.ads.admanager.v1.Partner] objects to update. A
   *     maximum of 100 objects can be updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdatePartnersResponse batchUpdatePartners(
      String parent, List<UpdatePartnerRequest> requests) {
    BatchUpdatePartnersRequest request =
        BatchUpdatePartnersRequest.newBuilder().setParent(parent).addAllRequests(requests).build();
    return batchUpdatePartners(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates [Partner][google.ads.admanager.v1.Partner] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PartnerServiceClient partnerServiceClient = PartnerServiceClient.create()) {
   *   BatchUpdatePartnersRequest request =
   *       BatchUpdatePartnersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdatePartnerRequest>())
   *           .build();
   *   BatchUpdatePartnersResponse response = partnerServiceClient.batchUpdatePartners(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdatePartnersResponse batchUpdatePartners(BatchUpdatePartnersRequest request) {
    return batchUpdatePartnersCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates [Partner][google.ads.admanager.v1.Partner] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PartnerServiceClient partnerServiceClient = PartnerServiceClient.create()) {
   *   BatchUpdatePartnersRequest request =
   *       BatchUpdatePartnersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdatePartnerRequest>())
   *           .build();
   *   ApiFuture<BatchUpdatePartnersResponse> future =
   *       partnerServiceClient.batchUpdatePartnersCallable().futureCall(request);
   *   // Do something.
   *   BatchUpdatePartnersResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchUpdatePartnersRequest, BatchUpdatePartnersResponse>
      batchUpdatePartnersCallable() {
    return stub.batchUpdatePartnersCallable();
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

  public static class ListPartnersPagedResponse
      extends AbstractPagedListResponse<
          ListPartnersRequest,
          ListPartnersResponse,
          Partner,
          ListPartnersPage,
          ListPartnersFixedSizeCollection> {

    public static ApiFuture<ListPartnersPagedResponse> createAsync(
        PageContext<ListPartnersRequest, ListPartnersResponse, Partner> context,
        ApiFuture<ListPartnersResponse> futureResponse) {
      ApiFuture<ListPartnersPage> futurePage =
          ListPartnersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPartnersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPartnersPagedResponse(ListPartnersPage page) {
      super(page, ListPartnersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPartnersPage
      extends AbstractPage<ListPartnersRequest, ListPartnersResponse, Partner, ListPartnersPage> {

    private ListPartnersPage(
        @Nullable PageContext<ListPartnersRequest, ListPartnersResponse, Partner> context,
        @Nullable ListPartnersResponse response) {
      super(context, response);
    }

    private static ListPartnersPage createEmptyPage() {
      return new ListPartnersPage(null, null);
    }

    @Override
    protected ListPartnersPage createPage(
        @Nullable PageContext<ListPartnersRequest, ListPartnersResponse, Partner> context,
        @Nullable ListPartnersResponse response) {
      return new ListPartnersPage(context, response);
    }

    @Override
    public ApiFuture<ListPartnersPage> createPageAsync(
        @Nullable PageContext<ListPartnersRequest, ListPartnersResponse, Partner> context,
        ApiFuture<ListPartnersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPartnersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPartnersRequest,
          ListPartnersResponse,
          Partner,
          ListPartnersPage,
          ListPartnersFixedSizeCollection> {

    private ListPartnersFixedSizeCollection(
        @Nullable List<ListPartnersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPartnersFixedSizeCollection createEmptyCollection() {
      return new ListPartnersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPartnersFixedSizeCollection createCollection(
        @Nullable List<ListPartnersPage> pages, int collectionSize) {
      return new ListPartnersFixedSizeCollection(pages, collectionSize);
    }
  }
}
