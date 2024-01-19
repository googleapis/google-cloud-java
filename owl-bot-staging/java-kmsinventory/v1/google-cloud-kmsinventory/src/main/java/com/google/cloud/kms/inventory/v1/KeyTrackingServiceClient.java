/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.kms.inventory.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.kms.inventory.v1.stub.KeyTrackingServiceStub;
import com.google.cloud.kms.inventory.v1.stub.KeyTrackingServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Returns information about the resources in an org that are protected by a
 * given Cloud KMS key via CMEK.
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
 * try (KeyTrackingServiceClient keyTrackingServiceClient = KeyTrackingServiceClient.create()) {
 *   ProtectedResourcesSummaryName name =
 *       ProtectedResourcesSummaryName.ofProjectLocationKeyRingCryptoKeyName(
 *           "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
 *   ProtectedResourcesSummary response =
 *       keyTrackingServiceClient.getProtectedResourcesSummary(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the KeyTrackingServiceClient object to clean up resources
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
 *      <td><p> GetProtectedResourcesSummary</td>
 *      <td><p> Returns aggregate information about the resources protected by the given Cloud KMS [CryptoKey][google.cloud.kms.v1.CryptoKey]. Only resources within the same Cloud organization as the key will be returned. The project that holds the key must be part of an organization in order for this call to succeed.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getProtectedResourcesSummary(GetProtectedResourcesSummaryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getProtectedResourcesSummary(ProtectedResourcesSummaryName name)
 *           <li><p> getProtectedResourcesSummary(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getProtectedResourcesSummaryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SearchProtectedResources</td>
 *      <td><p> Returns metadata about the resources protected by the given Cloud KMS [CryptoKey][google.cloud.kms.v1.CryptoKey] in the given Cloud organization.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchProtectedResources(SearchProtectedResourcesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> searchProtectedResources(OrganizationName scope, ResourceName cryptoKey)
 *           <li><p> searchProtectedResources(OrganizationName scope, String cryptoKey)
 *           <li><p> searchProtectedResources(String scope, ResourceName cryptoKey)
 *           <li><p> searchProtectedResources(String scope, String cryptoKey)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchProtectedResourcesPagedCallable()
 *           <li><p> searchProtectedResourcesCallable()
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
 * <p>This class can be customized by passing in a custom instance of KeyTrackingServiceSettings to
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
 * KeyTrackingServiceSettings keyTrackingServiceSettings =
 *     KeyTrackingServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * KeyTrackingServiceClient keyTrackingServiceClient =
 *     KeyTrackingServiceClient.create(keyTrackingServiceSettings);
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
 * KeyTrackingServiceSettings keyTrackingServiceSettings =
 *     KeyTrackingServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * KeyTrackingServiceClient keyTrackingServiceClient =
 *     KeyTrackingServiceClient.create(keyTrackingServiceSettings);
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
 * KeyTrackingServiceSettings keyTrackingServiceSettings =
 *     KeyTrackingServiceSettings.newHttpJsonBuilder().build();
 * KeyTrackingServiceClient keyTrackingServiceClient =
 *     KeyTrackingServiceClient.create(keyTrackingServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class KeyTrackingServiceClient implements BackgroundResource {
  private final KeyTrackingServiceSettings settings;
  private final KeyTrackingServiceStub stub;

  /** Constructs an instance of KeyTrackingServiceClient with default settings. */
  public static final KeyTrackingServiceClient create() throws IOException {
    return create(KeyTrackingServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of KeyTrackingServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final KeyTrackingServiceClient create(KeyTrackingServiceSettings settings)
      throws IOException {
    return new KeyTrackingServiceClient(settings);
  }

  /**
   * Constructs an instance of KeyTrackingServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(KeyTrackingServiceSettings).
   */
  public static final KeyTrackingServiceClient create(KeyTrackingServiceStub stub) {
    return new KeyTrackingServiceClient(stub);
  }

  /**
   * Constructs an instance of KeyTrackingServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected KeyTrackingServiceClient(KeyTrackingServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((KeyTrackingServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected KeyTrackingServiceClient(KeyTrackingServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final KeyTrackingServiceSettings getSettings() {
    return settings;
  }

  public KeyTrackingServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns aggregate information about the resources protected by the given Cloud KMS
   * [CryptoKey][google.cloud.kms.v1.CryptoKey]. Only resources within the same Cloud organization
   * as the key will be returned. The project that holds the key must be part of an organization in
   * order for this call to succeed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyTrackingServiceClient keyTrackingServiceClient = KeyTrackingServiceClient.create()) {
   *   ProtectedResourcesSummaryName name =
   *       ProtectedResourcesSummaryName.ofProjectLocationKeyRingCryptoKeyName(
   *           "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
   *   ProtectedResourcesSummary response =
   *       keyTrackingServiceClient.getProtectedResourcesSummary(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the [CryptoKey][google.cloud.kms.v1.CryptoKey].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProtectedResourcesSummary getProtectedResourcesSummary(
      ProtectedResourcesSummaryName name) {
    GetProtectedResourcesSummaryRequest request =
        GetProtectedResourcesSummaryRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getProtectedResourcesSummary(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns aggregate information about the resources protected by the given Cloud KMS
   * [CryptoKey][google.cloud.kms.v1.CryptoKey]. Only resources within the same Cloud organization
   * as the key will be returned. The project that holds the key must be part of an organization in
   * order for this call to succeed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyTrackingServiceClient keyTrackingServiceClient = KeyTrackingServiceClient.create()) {
   *   String name =
   *       ProtectedResourcesSummaryName.ofProjectLocationKeyRingCryptoKeyName(
   *               "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *           .toString();
   *   ProtectedResourcesSummary response =
   *       keyTrackingServiceClient.getProtectedResourcesSummary(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the [CryptoKey][google.cloud.kms.v1.CryptoKey].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProtectedResourcesSummary getProtectedResourcesSummary(String name) {
    GetProtectedResourcesSummaryRequest request =
        GetProtectedResourcesSummaryRequest.newBuilder().setName(name).build();
    return getProtectedResourcesSummary(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns aggregate information about the resources protected by the given Cloud KMS
   * [CryptoKey][google.cloud.kms.v1.CryptoKey]. Only resources within the same Cloud organization
   * as the key will be returned. The project that holds the key must be part of an organization in
   * order for this call to succeed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyTrackingServiceClient keyTrackingServiceClient = KeyTrackingServiceClient.create()) {
   *   GetProtectedResourcesSummaryRequest request =
   *       GetProtectedResourcesSummaryRequest.newBuilder()
   *           .setName(
   *               ProtectedResourcesSummaryName.ofProjectLocationKeyRingCryptoKeyName(
   *                       "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .build();
   *   ProtectedResourcesSummary response =
   *       keyTrackingServiceClient.getProtectedResourcesSummary(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProtectedResourcesSummary getProtectedResourcesSummary(
      GetProtectedResourcesSummaryRequest request) {
    return getProtectedResourcesSummaryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns aggregate information about the resources protected by the given Cloud KMS
   * [CryptoKey][google.cloud.kms.v1.CryptoKey]. Only resources within the same Cloud organization
   * as the key will be returned. The project that holds the key must be part of an organization in
   * order for this call to succeed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyTrackingServiceClient keyTrackingServiceClient = KeyTrackingServiceClient.create()) {
   *   GetProtectedResourcesSummaryRequest request =
   *       GetProtectedResourcesSummaryRequest.newBuilder()
   *           .setName(
   *               ProtectedResourcesSummaryName.ofProjectLocationKeyRingCryptoKeyName(
   *                       "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ProtectedResourcesSummary> future =
   *       keyTrackingServiceClient.getProtectedResourcesSummaryCallable().futureCall(request);
   *   // Do something.
   *   ProtectedResourcesSummary response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetProtectedResourcesSummaryRequest, ProtectedResourcesSummary>
      getProtectedResourcesSummaryCallable() {
    return stub.getProtectedResourcesSummaryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata about the resources protected by the given Cloud KMS
   * [CryptoKey][google.cloud.kms.v1.CryptoKey] in the given Cloud organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyTrackingServiceClient keyTrackingServiceClient = KeyTrackingServiceClient.create()) {
   *   OrganizationName scope = OrganizationName.of("[ORGANIZATION]");
   *   ResourceName cryptoKey = OrganizationName.of("[ORGANIZATION]");
   *   for (ProtectedResource element :
   *       keyTrackingServiceClient.searchProtectedResources(scope, cryptoKey).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param scope Required. Resource name of the organization. Example: organizations/123
   * @param cryptoKey Required. The resource name of the [CryptoKey][google.cloud.kms.v1.CryptoKey].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchProtectedResourcesPagedResponse searchProtectedResources(
      OrganizationName scope, ResourceName cryptoKey) {
    SearchProtectedResourcesRequest request =
        SearchProtectedResourcesRequest.newBuilder()
            .setScope(scope == null ? null : scope.toString())
            .setCryptoKey(cryptoKey == null ? null : cryptoKey.toString())
            .build();
    return searchProtectedResources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata about the resources protected by the given Cloud KMS
   * [CryptoKey][google.cloud.kms.v1.CryptoKey] in the given Cloud organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyTrackingServiceClient keyTrackingServiceClient = KeyTrackingServiceClient.create()) {
   *   OrganizationName scope = OrganizationName.of("[ORGANIZATION]");
   *   String cryptoKey = OrganizationName.of("[ORGANIZATION]").toString();
   *   for (ProtectedResource element :
   *       keyTrackingServiceClient.searchProtectedResources(scope, cryptoKey).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param scope Required. Resource name of the organization. Example: organizations/123
   * @param cryptoKey Required. The resource name of the [CryptoKey][google.cloud.kms.v1.CryptoKey].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchProtectedResourcesPagedResponse searchProtectedResources(
      OrganizationName scope, String cryptoKey) {
    SearchProtectedResourcesRequest request =
        SearchProtectedResourcesRequest.newBuilder()
            .setScope(scope == null ? null : scope.toString())
            .setCryptoKey(cryptoKey)
            .build();
    return searchProtectedResources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata about the resources protected by the given Cloud KMS
   * [CryptoKey][google.cloud.kms.v1.CryptoKey] in the given Cloud organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyTrackingServiceClient keyTrackingServiceClient = KeyTrackingServiceClient.create()) {
   *   String scope = OrganizationName.of("[ORGANIZATION]").toString();
   *   ResourceName cryptoKey = OrganizationName.of("[ORGANIZATION]");
   *   for (ProtectedResource element :
   *       keyTrackingServiceClient.searchProtectedResources(scope, cryptoKey).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param scope Required. Resource name of the organization. Example: organizations/123
   * @param cryptoKey Required. The resource name of the [CryptoKey][google.cloud.kms.v1.CryptoKey].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchProtectedResourcesPagedResponse searchProtectedResources(
      String scope, ResourceName cryptoKey) {
    SearchProtectedResourcesRequest request =
        SearchProtectedResourcesRequest.newBuilder()
            .setScope(scope)
            .setCryptoKey(cryptoKey == null ? null : cryptoKey.toString())
            .build();
    return searchProtectedResources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata about the resources protected by the given Cloud KMS
   * [CryptoKey][google.cloud.kms.v1.CryptoKey] in the given Cloud organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyTrackingServiceClient keyTrackingServiceClient = KeyTrackingServiceClient.create()) {
   *   String scope = OrganizationName.of("[ORGANIZATION]").toString();
   *   String cryptoKey = OrganizationName.of("[ORGANIZATION]").toString();
   *   for (ProtectedResource element :
   *       keyTrackingServiceClient.searchProtectedResources(scope, cryptoKey).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param scope Required. Resource name of the organization. Example: organizations/123
   * @param cryptoKey Required. The resource name of the [CryptoKey][google.cloud.kms.v1.CryptoKey].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchProtectedResourcesPagedResponse searchProtectedResources(
      String scope, String cryptoKey) {
    SearchProtectedResourcesRequest request =
        SearchProtectedResourcesRequest.newBuilder()
            .setScope(scope)
            .setCryptoKey(cryptoKey)
            .build();
    return searchProtectedResources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata about the resources protected by the given Cloud KMS
   * [CryptoKey][google.cloud.kms.v1.CryptoKey] in the given Cloud organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyTrackingServiceClient keyTrackingServiceClient = KeyTrackingServiceClient.create()) {
   *   SearchProtectedResourcesRequest request =
   *       SearchProtectedResourcesRequest.newBuilder()
   *           .setScope(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setCryptoKey(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .addAllResourceTypes(new ArrayList<String>())
   *           .build();
   *   for (ProtectedResource element :
   *       keyTrackingServiceClient.searchProtectedResources(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchProtectedResourcesPagedResponse searchProtectedResources(
      SearchProtectedResourcesRequest request) {
    return searchProtectedResourcesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata about the resources protected by the given Cloud KMS
   * [CryptoKey][google.cloud.kms.v1.CryptoKey] in the given Cloud organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyTrackingServiceClient keyTrackingServiceClient = KeyTrackingServiceClient.create()) {
   *   SearchProtectedResourcesRequest request =
   *       SearchProtectedResourcesRequest.newBuilder()
   *           .setScope(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setCryptoKey(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .addAllResourceTypes(new ArrayList<String>())
   *           .build();
   *   ApiFuture<ProtectedResource> future =
   *       keyTrackingServiceClient.searchProtectedResourcesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ProtectedResource element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchProtectedResourcesRequest, SearchProtectedResourcesPagedResponse>
      searchProtectedResourcesPagedCallable() {
    return stub.searchProtectedResourcesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata about the resources protected by the given Cloud KMS
   * [CryptoKey][google.cloud.kms.v1.CryptoKey] in the given Cloud organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyTrackingServiceClient keyTrackingServiceClient = KeyTrackingServiceClient.create()) {
   *   SearchProtectedResourcesRequest request =
   *       SearchProtectedResourcesRequest.newBuilder()
   *           .setScope(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setCryptoKey(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .addAllResourceTypes(new ArrayList<String>())
   *           .build();
   *   while (true) {
   *     SearchProtectedResourcesResponse response =
   *         keyTrackingServiceClient.searchProtectedResourcesCallable().call(request);
   *     for (ProtectedResource element : response.getProtectedResourcesList()) {
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
  public final UnaryCallable<SearchProtectedResourcesRequest, SearchProtectedResourcesResponse>
      searchProtectedResourcesCallable() {
    return stub.searchProtectedResourcesCallable();
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

  public static class SearchProtectedResourcesPagedResponse
      extends AbstractPagedListResponse<
          SearchProtectedResourcesRequest,
          SearchProtectedResourcesResponse,
          ProtectedResource,
          SearchProtectedResourcesPage,
          SearchProtectedResourcesFixedSizeCollection> {

    public static ApiFuture<SearchProtectedResourcesPagedResponse> createAsync(
        PageContext<
                SearchProtectedResourcesRequest,
                SearchProtectedResourcesResponse,
                ProtectedResource>
            context,
        ApiFuture<SearchProtectedResourcesResponse> futureResponse) {
      ApiFuture<SearchProtectedResourcesPage> futurePage =
          SearchProtectedResourcesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchProtectedResourcesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchProtectedResourcesPagedResponse(SearchProtectedResourcesPage page) {
      super(page, SearchProtectedResourcesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchProtectedResourcesPage
      extends AbstractPage<
          SearchProtectedResourcesRequest,
          SearchProtectedResourcesResponse,
          ProtectedResource,
          SearchProtectedResourcesPage> {

    private SearchProtectedResourcesPage(
        PageContext<
                SearchProtectedResourcesRequest,
                SearchProtectedResourcesResponse,
                ProtectedResource>
            context,
        SearchProtectedResourcesResponse response) {
      super(context, response);
    }

    private static SearchProtectedResourcesPage createEmptyPage() {
      return new SearchProtectedResourcesPage(null, null);
    }

    @Override
    protected SearchProtectedResourcesPage createPage(
        PageContext<
                SearchProtectedResourcesRequest,
                SearchProtectedResourcesResponse,
                ProtectedResource>
            context,
        SearchProtectedResourcesResponse response) {
      return new SearchProtectedResourcesPage(context, response);
    }

    @Override
    public ApiFuture<SearchProtectedResourcesPage> createPageAsync(
        PageContext<
                SearchProtectedResourcesRequest,
                SearchProtectedResourcesResponse,
                ProtectedResource>
            context,
        ApiFuture<SearchProtectedResourcesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchProtectedResourcesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchProtectedResourcesRequest,
          SearchProtectedResourcesResponse,
          ProtectedResource,
          SearchProtectedResourcesPage,
          SearchProtectedResourcesFixedSizeCollection> {

    private SearchProtectedResourcesFixedSizeCollection(
        List<SearchProtectedResourcesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchProtectedResourcesFixedSizeCollection createEmptyCollection() {
      return new SearchProtectedResourcesFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchProtectedResourcesFixedSizeCollection createCollection(
        List<SearchProtectedResourcesPage> pages, int collectionSize) {
      return new SearchProtectedResourcesFixedSizeCollection(pages, collectionSize);
    }
  }
}
