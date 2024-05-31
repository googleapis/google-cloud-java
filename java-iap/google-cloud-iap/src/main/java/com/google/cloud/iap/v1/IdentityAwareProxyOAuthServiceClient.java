/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.iap.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.iap.v1.stub.IdentityAwareProxyOAuthServiceStub;
import com.google.cloud.iap.v1.stub.IdentityAwareProxyOAuthServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: API to programmatically create, list and retrieve Identity Aware Proxy (IAP)
 * OAuth brands; and create, retrieve, delete and reset-secret of IAP OAuth clients.
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
 * try (IdentityAwareProxyOAuthServiceClient identityAwareProxyOAuthServiceClient =
 *     IdentityAwareProxyOAuthServiceClient.create()) {
 *   ListBrandsRequest request =
 *       ListBrandsRequest.newBuilder().setParent("parent-995424086").build();
 *   ListBrandsResponse response = identityAwareProxyOAuthServiceClient.listBrands(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the IdentityAwareProxyOAuthServiceClient object to clean
 * up resources such as threads. In the example above, try-with-resources is used, which
 * automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListBrands</td>
 *      <td><p> Lists the existing brands for the project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBrands(ListBrandsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listBrandsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateBrand</td>
 *      <td><p> Constructs a new OAuth brand for the project if one does not exist. The created brand is "internal only", meaning that OAuth clients created under it only accept requests from users who belong to the same Google Workspace organization as the project. The brand is created in an un-reviewed status. NOTE: The "internal only" status can be manually changed in the Google Cloud Console. Requires that a brand does not already exist for the project, and that the specified support email is owned by the caller.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createBrand(CreateBrandRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createBrandCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetBrand</td>
 *      <td><p> Retrieves the OAuth brand of the project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getBrand(GetBrandRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getBrandCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateIdentityAwareProxyClient</td>
 *      <td><p> Creates an Identity Aware Proxy (IAP) OAuth client. The client is owned by IAP. Requires that the brand for the project exists and that it is set for internal-only use.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createIdentityAwareProxyClient(CreateIdentityAwareProxyClientRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createIdentityAwareProxyClientCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListIdentityAwareProxyClients</td>
 *      <td><p> Lists the existing clients for the brand.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listIdentityAwareProxyClients(ListIdentityAwareProxyClientsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listIdentityAwareProxyClientsPagedCallable()
 *           <li><p> listIdentityAwareProxyClientsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIdentityAwareProxyClient</td>
 *      <td><p> Retrieves an Identity Aware Proxy (IAP) OAuth client. Requires that the client is owned by IAP.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIdentityAwareProxyClient(GetIdentityAwareProxyClientRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIdentityAwareProxyClientCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ResetIdentityAwareProxyClientSecret</td>
 *      <td><p> Resets an Identity Aware Proxy (IAP) OAuth client secret. Useful if the secret was compromised. Requires that the client is owned by IAP.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> resetIdentityAwareProxyClientSecret(ResetIdentityAwareProxyClientSecretRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> resetIdentityAwareProxyClientSecretCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteIdentityAwareProxyClient</td>
 *      <td><p> Deletes an Identity Aware Proxy (IAP) OAuth client. Useful for removing obsolete clients, managing the number of clients in a given project, and cleaning up after tests. Requires that the client is owned by IAP.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteIdentityAwareProxyClient(DeleteIdentityAwareProxyClientRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteIdentityAwareProxyClientCallable()
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
 * IdentityAwareProxyOAuthServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * IdentityAwareProxyOAuthServiceSettings identityAwareProxyOAuthServiceSettings =
 *     IdentityAwareProxyOAuthServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * IdentityAwareProxyOAuthServiceClient identityAwareProxyOAuthServiceClient =
 *     IdentityAwareProxyOAuthServiceClient.create(identityAwareProxyOAuthServiceSettings);
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
 * IdentityAwareProxyOAuthServiceSettings identityAwareProxyOAuthServiceSettings =
 *     IdentityAwareProxyOAuthServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * IdentityAwareProxyOAuthServiceClient identityAwareProxyOAuthServiceClient =
 *     IdentityAwareProxyOAuthServiceClient.create(identityAwareProxyOAuthServiceSettings);
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
 * IdentityAwareProxyOAuthServiceSettings identityAwareProxyOAuthServiceSettings =
 *     IdentityAwareProxyOAuthServiceSettings.newHttpJsonBuilder().build();
 * IdentityAwareProxyOAuthServiceClient identityAwareProxyOAuthServiceClient =
 *     IdentityAwareProxyOAuthServiceClient.create(identityAwareProxyOAuthServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class IdentityAwareProxyOAuthServiceClient implements BackgroundResource {
  private final IdentityAwareProxyOAuthServiceSettings settings;
  private final IdentityAwareProxyOAuthServiceStub stub;

  /** Constructs an instance of IdentityAwareProxyOAuthServiceClient with default settings. */
  public static final IdentityAwareProxyOAuthServiceClient create() throws IOException {
    return create(IdentityAwareProxyOAuthServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of IdentityAwareProxyOAuthServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final IdentityAwareProxyOAuthServiceClient create(
      IdentityAwareProxyOAuthServiceSettings settings) throws IOException {
    return new IdentityAwareProxyOAuthServiceClient(settings);
  }

  /**
   * Constructs an instance of IdentityAwareProxyOAuthServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using
   * create(IdentityAwareProxyOAuthServiceSettings).
   */
  public static final IdentityAwareProxyOAuthServiceClient create(
      IdentityAwareProxyOAuthServiceStub stub) {
    return new IdentityAwareProxyOAuthServiceClient(stub);
  }

  /**
   * Constructs an instance of IdentityAwareProxyOAuthServiceClient, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected IdentityAwareProxyOAuthServiceClient(IdentityAwareProxyOAuthServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((IdentityAwareProxyOAuthServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected IdentityAwareProxyOAuthServiceClient(IdentityAwareProxyOAuthServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final IdentityAwareProxyOAuthServiceSettings getSettings() {
    return settings;
  }

  public IdentityAwareProxyOAuthServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the existing brands for the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyOAuthServiceClient identityAwareProxyOAuthServiceClient =
   *     IdentityAwareProxyOAuthServiceClient.create()) {
   *   ListBrandsRequest request =
   *       ListBrandsRequest.newBuilder().setParent("parent-995424086").build();
   *   ListBrandsResponse response = identityAwareProxyOAuthServiceClient.listBrands(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBrandsResponse listBrands(ListBrandsRequest request) {
    return listBrandsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the existing brands for the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyOAuthServiceClient identityAwareProxyOAuthServiceClient =
   *     IdentityAwareProxyOAuthServiceClient.create()) {
   *   ListBrandsRequest request =
   *       ListBrandsRequest.newBuilder().setParent("parent-995424086").build();
   *   ApiFuture<ListBrandsResponse> future =
   *       identityAwareProxyOAuthServiceClient.listBrandsCallable().futureCall(request);
   *   // Do something.
   *   ListBrandsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBrandsRequest, ListBrandsResponse> listBrandsCallable() {
    return stub.listBrandsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Constructs a new OAuth brand for the project if one does not exist. The created brand is
   * "internal only", meaning that OAuth clients created under it only accept requests from users
   * who belong to the same Google Workspace organization as the project. The brand is created in an
   * un-reviewed status. NOTE: The "internal only" status can be manually changed in the Google
   * Cloud Console. Requires that a brand does not already exist for the project, and that the
   * specified support email is owned by the caller.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyOAuthServiceClient identityAwareProxyOAuthServiceClient =
   *     IdentityAwareProxyOAuthServiceClient.create()) {
   *   CreateBrandRequest request =
   *       CreateBrandRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setBrand(Brand.newBuilder().build())
   *           .build();
   *   Brand response = identityAwareProxyOAuthServiceClient.createBrand(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Brand createBrand(CreateBrandRequest request) {
    return createBrandCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Constructs a new OAuth brand for the project if one does not exist. The created brand is
   * "internal only", meaning that OAuth clients created under it only accept requests from users
   * who belong to the same Google Workspace organization as the project. The brand is created in an
   * un-reviewed status. NOTE: The "internal only" status can be manually changed in the Google
   * Cloud Console. Requires that a brand does not already exist for the project, and that the
   * specified support email is owned by the caller.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyOAuthServiceClient identityAwareProxyOAuthServiceClient =
   *     IdentityAwareProxyOAuthServiceClient.create()) {
   *   CreateBrandRequest request =
   *       CreateBrandRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setBrand(Brand.newBuilder().build())
   *           .build();
   *   ApiFuture<Brand> future =
   *       identityAwareProxyOAuthServiceClient.createBrandCallable().futureCall(request);
   *   // Do something.
   *   Brand response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateBrandRequest, Brand> createBrandCallable() {
    return stub.createBrandCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the OAuth brand of the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyOAuthServiceClient identityAwareProxyOAuthServiceClient =
   *     IdentityAwareProxyOAuthServiceClient.create()) {
   *   GetBrandRequest request = GetBrandRequest.newBuilder().setName("name3373707").build();
   *   Brand response = identityAwareProxyOAuthServiceClient.getBrand(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Brand getBrand(GetBrandRequest request) {
    return getBrandCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the OAuth brand of the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyOAuthServiceClient identityAwareProxyOAuthServiceClient =
   *     IdentityAwareProxyOAuthServiceClient.create()) {
   *   GetBrandRequest request = GetBrandRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Brand> future =
   *       identityAwareProxyOAuthServiceClient.getBrandCallable().futureCall(request);
   *   // Do something.
   *   Brand response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBrandRequest, Brand> getBrandCallable() {
    return stub.getBrandCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Identity Aware Proxy (IAP) OAuth client. The client is owned by IAP. Requires that
   * the brand for the project exists and that it is set for internal-only use.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyOAuthServiceClient identityAwareProxyOAuthServiceClient =
   *     IdentityAwareProxyOAuthServiceClient.create()) {
   *   CreateIdentityAwareProxyClientRequest request =
   *       CreateIdentityAwareProxyClientRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setIdentityAwareProxyClient(IdentityAwareProxyClient.newBuilder().build())
   *           .build();
   *   IdentityAwareProxyClient response =
   *       identityAwareProxyOAuthServiceClient.createIdentityAwareProxyClient(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IdentityAwareProxyClient createIdentityAwareProxyClient(
      CreateIdentityAwareProxyClientRequest request) {
    return createIdentityAwareProxyClientCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Identity Aware Proxy (IAP) OAuth client. The client is owned by IAP. Requires that
   * the brand for the project exists and that it is set for internal-only use.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyOAuthServiceClient identityAwareProxyOAuthServiceClient =
   *     IdentityAwareProxyOAuthServiceClient.create()) {
   *   CreateIdentityAwareProxyClientRequest request =
   *       CreateIdentityAwareProxyClientRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setIdentityAwareProxyClient(IdentityAwareProxyClient.newBuilder().build())
   *           .build();
   *   ApiFuture<IdentityAwareProxyClient> future =
   *       identityAwareProxyOAuthServiceClient
   *           .createIdentityAwareProxyClientCallable()
   *           .futureCall(request);
   *   // Do something.
   *   IdentityAwareProxyClient response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateIdentityAwareProxyClientRequest, IdentityAwareProxyClient>
      createIdentityAwareProxyClientCallable() {
    return stub.createIdentityAwareProxyClientCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the existing clients for the brand.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyOAuthServiceClient identityAwareProxyOAuthServiceClient =
   *     IdentityAwareProxyOAuthServiceClient.create()) {
   *   ListIdentityAwareProxyClientsRequest request =
   *       ListIdentityAwareProxyClientsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (IdentityAwareProxyClient element :
   *       identityAwareProxyOAuthServiceClient
   *           .listIdentityAwareProxyClients(request)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIdentityAwareProxyClientsPagedResponse listIdentityAwareProxyClients(
      ListIdentityAwareProxyClientsRequest request) {
    return listIdentityAwareProxyClientsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the existing clients for the brand.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyOAuthServiceClient identityAwareProxyOAuthServiceClient =
   *     IdentityAwareProxyOAuthServiceClient.create()) {
   *   ListIdentityAwareProxyClientsRequest request =
   *       ListIdentityAwareProxyClientsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<IdentityAwareProxyClient> future =
   *       identityAwareProxyOAuthServiceClient
   *           .listIdentityAwareProxyClientsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (IdentityAwareProxyClient element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListIdentityAwareProxyClientsRequest, ListIdentityAwareProxyClientsPagedResponse>
      listIdentityAwareProxyClientsPagedCallable() {
    return stub.listIdentityAwareProxyClientsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the existing clients for the brand.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyOAuthServiceClient identityAwareProxyOAuthServiceClient =
   *     IdentityAwareProxyOAuthServiceClient.create()) {
   *   ListIdentityAwareProxyClientsRequest request =
   *       ListIdentityAwareProxyClientsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListIdentityAwareProxyClientsResponse response =
   *         identityAwareProxyOAuthServiceClient
   *             .listIdentityAwareProxyClientsCallable()
   *             .call(request);
   *     for (IdentityAwareProxyClient element : response.getIdentityAwareProxyClientsList()) {
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
  public final UnaryCallable<
          ListIdentityAwareProxyClientsRequest, ListIdentityAwareProxyClientsResponse>
      listIdentityAwareProxyClientsCallable() {
    return stub.listIdentityAwareProxyClientsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an Identity Aware Proxy (IAP) OAuth client. Requires that the client is owned by IAP.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyOAuthServiceClient identityAwareProxyOAuthServiceClient =
   *     IdentityAwareProxyOAuthServiceClient.create()) {
   *   GetIdentityAwareProxyClientRequest request =
   *       GetIdentityAwareProxyClientRequest.newBuilder().setName("name3373707").build();
   *   IdentityAwareProxyClient response =
   *       identityAwareProxyOAuthServiceClient.getIdentityAwareProxyClient(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IdentityAwareProxyClient getIdentityAwareProxyClient(
      GetIdentityAwareProxyClientRequest request) {
    return getIdentityAwareProxyClientCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an Identity Aware Proxy (IAP) OAuth client. Requires that the client is owned by IAP.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyOAuthServiceClient identityAwareProxyOAuthServiceClient =
   *     IdentityAwareProxyOAuthServiceClient.create()) {
   *   GetIdentityAwareProxyClientRequest request =
   *       GetIdentityAwareProxyClientRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<IdentityAwareProxyClient> future =
   *       identityAwareProxyOAuthServiceClient
   *           .getIdentityAwareProxyClientCallable()
   *           .futureCall(request);
   *   // Do something.
   *   IdentityAwareProxyClient response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIdentityAwareProxyClientRequest, IdentityAwareProxyClient>
      getIdentityAwareProxyClientCallable() {
    return stub.getIdentityAwareProxyClientCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets an Identity Aware Proxy (IAP) OAuth client secret. Useful if the secret was compromised.
   * Requires that the client is owned by IAP.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyOAuthServiceClient identityAwareProxyOAuthServiceClient =
   *     IdentityAwareProxyOAuthServiceClient.create()) {
   *   ResetIdentityAwareProxyClientSecretRequest request =
   *       ResetIdentityAwareProxyClientSecretRequest.newBuilder().setName("name3373707").build();
   *   IdentityAwareProxyClient response =
   *       identityAwareProxyOAuthServiceClient.resetIdentityAwareProxyClientSecret(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IdentityAwareProxyClient resetIdentityAwareProxyClientSecret(
      ResetIdentityAwareProxyClientSecretRequest request) {
    return resetIdentityAwareProxyClientSecretCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets an Identity Aware Proxy (IAP) OAuth client secret. Useful if the secret was compromised.
   * Requires that the client is owned by IAP.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyOAuthServiceClient identityAwareProxyOAuthServiceClient =
   *     IdentityAwareProxyOAuthServiceClient.create()) {
   *   ResetIdentityAwareProxyClientSecretRequest request =
   *       ResetIdentityAwareProxyClientSecretRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<IdentityAwareProxyClient> future =
   *       identityAwareProxyOAuthServiceClient
   *           .resetIdentityAwareProxyClientSecretCallable()
   *           .futureCall(request);
   *   // Do something.
   *   IdentityAwareProxyClient response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ResetIdentityAwareProxyClientSecretRequest, IdentityAwareProxyClient>
      resetIdentityAwareProxyClientSecretCallable() {
    return stub.resetIdentityAwareProxyClientSecretCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Identity Aware Proxy (IAP) OAuth client. Useful for removing obsolete clients,
   * managing the number of clients in a given project, and cleaning up after tests. Requires that
   * the client is owned by IAP.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyOAuthServiceClient identityAwareProxyOAuthServiceClient =
   *     IdentityAwareProxyOAuthServiceClient.create()) {
   *   DeleteIdentityAwareProxyClientRequest request =
   *       DeleteIdentityAwareProxyClientRequest.newBuilder().setName("name3373707").build();
   *   identityAwareProxyOAuthServiceClient.deleteIdentityAwareProxyClient(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteIdentityAwareProxyClient(DeleteIdentityAwareProxyClientRequest request) {
    deleteIdentityAwareProxyClientCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Identity Aware Proxy (IAP) OAuth client. Useful for removing obsolete clients,
   * managing the number of clients in a given project, and cleaning up after tests. Requires that
   * the client is owned by IAP.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyOAuthServiceClient identityAwareProxyOAuthServiceClient =
   *     IdentityAwareProxyOAuthServiceClient.create()) {
   *   DeleteIdentityAwareProxyClientRequest request =
   *       DeleteIdentityAwareProxyClientRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Empty> future =
   *       identityAwareProxyOAuthServiceClient
   *           .deleteIdentityAwareProxyClientCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteIdentityAwareProxyClientRequest, Empty>
      deleteIdentityAwareProxyClientCallable() {
    return stub.deleteIdentityAwareProxyClientCallable();
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

  public static class ListIdentityAwareProxyClientsPagedResponse
      extends AbstractPagedListResponse<
          ListIdentityAwareProxyClientsRequest,
          ListIdentityAwareProxyClientsResponse,
          IdentityAwareProxyClient,
          ListIdentityAwareProxyClientsPage,
          ListIdentityAwareProxyClientsFixedSizeCollection> {

    public static ApiFuture<ListIdentityAwareProxyClientsPagedResponse> createAsync(
        PageContext<
                ListIdentityAwareProxyClientsRequest,
                ListIdentityAwareProxyClientsResponse,
                IdentityAwareProxyClient>
            context,
        ApiFuture<ListIdentityAwareProxyClientsResponse> futureResponse) {
      ApiFuture<ListIdentityAwareProxyClientsPage> futurePage =
          ListIdentityAwareProxyClientsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListIdentityAwareProxyClientsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListIdentityAwareProxyClientsPagedResponse(ListIdentityAwareProxyClientsPage page) {
      super(page, ListIdentityAwareProxyClientsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListIdentityAwareProxyClientsPage
      extends AbstractPage<
          ListIdentityAwareProxyClientsRequest,
          ListIdentityAwareProxyClientsResponse,
          IdentityAwareProxyClient,
          ListIdentityAwareProxyClientsPage> {

    private ListIdentityAwareProxyClientsPage(
        PageContext<
                ListIdentityAwareProxyClientsRequest,
                ListIdentityAwareProxyClientsResponse,
                IdentityAwareProxyClient>
            context,
        ListIdentityAwareProxyClientsResponse response) {
      super(context, response);
    }

    private static ListIdentityAwareProxyClientsPage createEmptyPage() {
      return new ListIdentityAwareProxyClientsPage(null, null);
    }

    @Override
    protected ListIdentityAwareProxyClientsPage createPage(
        PageContext<
                ListIdentityAwareProxyClientsRequest,
                ListIdentityAwareProxyClientsResponse,
                IdentityAwareProxyClient>
            context,
        ListIdentityAwareProxyClientsResponse response) {
      return new ListIdentityAwareProxyClientsPage(context, response);
    }

    @Override
    public ApiFuture<ListIdentityAwareProxyClientsPage> createPageAsync(
        PageContext<
                ListIdentityAwareProxyClientsRequest,
                ListIdentityAwareProxyClientsResponse,
                IdentityAwareProxyClient>
            context,
        ApiFuture<ListIdentityAwareProxyClientsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListIdentityAwareProxyClientsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListIdentityAwareProxyClientsRequest,
          ListIdentityAwareProxyClientsResponse,
          IdentityAwareProxyClient,
          ListIdentityAwareProxyClientsPage,
          ListIdentityAwareProxyClientsFixedSizeCollection> {

    private ListIdentityAwareProxyClientsFixedSizeCollection(
        List<ListIdentityAwareProxyClientsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListIdentityAwareProxyClientsFixedSizeCollection createEmptyCollection() {
      return new ListIdentityAwareProxyClientsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListIdentityAwareProxyClientsFixedSizeCollection createCollection(
        List<ListIdentityAwareProxyClientsPage> pages, int collectionSize) {
      return new ListIdentityAwareProxyClientsFixedSizeCollection(pages, collectionSize);
    }
  }
}
