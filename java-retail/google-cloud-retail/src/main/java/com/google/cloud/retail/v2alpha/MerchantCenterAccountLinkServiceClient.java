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

package com.google.cloud.retail.v2alpha;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2alpha.stub.MerchantCenterAccountLinkServiceStub;
import com.google.cloud.retail.v2alpha.stub.MerchantCenterAccountLinkServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Merchant Center Link service to link a Branch to a Merchant Center Account.
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
 * try (MerchantCenterAccountLinkServiceClient merchantCenterAccountLinkServiceClient =
 *     MerchantCenterAccountLinkServiceClient.create()) {
 *   CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
 *   ListMerchantCenterAccountLinksResponse response =
 *       merchantCenterAccountLinkServiceClient.listMerchantCenterAccountLinks(parent);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the MerchantCenterAccountLinkServiceClient object to clean
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
 *      <td><p> ListMerchantCenterAccountLinks</td>
 *      <td><p> Lists all [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink]s under the specified parent [Catalog][google.cloud.retail.v2alpha.Catalog].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMerchantCenterAccountLinks(ListMerchantCenterAccountLinksRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listMerchantCenterAccountLinks(CatalogName parent)
 *           <li><p> listMerchantCenterAccountLinks(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listMerchantCenterAccountLinksCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateMerchantCenterAccountLink</td>
 *      <td><p> Creates a [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createMerchantCenterAccountLinkAsync(CreateMerchantCenterAccountLinkRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createMerchantCenterAccountLinkAsync(CatalogName parent, MerchantCenterAccountLink merchantCenterAccountLink)
 *           <li><p> createMerchantCenterAccountLinkAsync(String parent, MerchantCenterAccountLink merchantCenterAccountLink)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createMerchantCenterAccountLinkOperationCallable()
 *           <li><p> createMerchantCenterAccountLinkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteMerchantCenterAccountLink</td>
 *      <td><p> Deletes a [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink]. If the [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink] to delete does not exist, a NOT_FOUND error is returned.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteMerchantCenterAccountLink(DeleteMerchantCenterAccountLinkRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteMerchantCenterAccountLink(MerchantCenterAccountLinkName name)
 *           <li><p> deleteMerchantCenterAccountLink(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteMerchantCenterAccountLinkCallable()
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
 * MerchantCenterAccountLinkServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MerchantCenterAccountLinkServiceSettings merchantCenterAccountLinkServiceSettings =
 *     MerchantCenterAccountLinkServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * MerchantCenterAccountLinkServiceClient merchantCenterAccountLinkServiceClient =
 *     MerchantCenterAccountLinkServiceClient.create(merchantCenterAccountLinkServiceSettings);
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
 * MerchantCenterAccountLinkServiceSettings merchantCenterAccountLinkServiceSettings =
 *     MerchantCenterAccountLinkServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * MerchantCenterAccountLinkServiceClient merchantCenterAccountLinkServiceClient =
 *     MerchantCenterAccountLinkServiceClient.create(merchantCenterAccountLinkServiceSettings);
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
 * MerchantCenterAccountLinkServiceSettings merchantCenterAccountLinkServiceSettings =
 *     MerchantCenterAccountLinkServiceSettings.newHttpJsonBuilder().build();
 * MerchantCenterAccountLinkServiceClient merchantCenterAccountLinkServiceClient =
 *     MerchantCenterAccountLinkServiceClient.create(merchantCenterAccountLinkServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class MerchantCenterAccountLinkServiceClient implements BackgroundResource {
  private final MerchantCenterAccountLinkServiceSettings settings;
  private final MerchantCenterAccountLinkServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of MerchantCenterAccountLinkServiceClient with default settings. */
  public static final MerchantCenterAccountLinkServiceClient create() throws IOException {
    return create(MerchantCenterAccountLinkServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of MerchantCenterAccountLinkServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final MerchantCenterAccountLinkServiceClient create(
      MerchantCenterAccountLinkServiceSettings settings) throws IOException {
    return new MerchantCenterAccountLinkServiceClient(settings);
  }

  /**
   * Constructs an instance of MerchantCenterAccountLinkServiceClient, using the given stub for
   * making calls. This is for advanced usage - prefer using
   * create(MerchantCenterAccountLinkServiceSettings).
   */
  public static final MerchantCenterAccountLinkServiceClient create(
      MerchantCenterAccountLinkServiceStub stub) {
    return new MerchantCenterAccountLinkServiceClient(stub);
  }

  /**
   * Constructs an instance of MerchantCenterAccountLinkServiceClient, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected MerchantCenterAccountLinkServiceClient(
      MerchantCenterAccountLinkServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub =
        ((MerchantCenterAccountLinkServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected MerchantCenterAccountLinkServiceClient(MerchantCenterAccountLinkServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final MerchantCenterAccountLinkServiceSettings getSettings() {
    return settings;
  }

  public MerchantCenterAccountLinkServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink]s
   * under the specified parent [Catalog][google.cloud.retail.v2alpha.Catalog].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MerchantCenterAccountLinkServiceClient merchantCenterAccountLinkServiceClient =
   *     MerchantCenterAccountLinkServiceClient.create()) {
   *   CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
   *   ListMerchantCenterAccountLinksResponse response =
   *       merchantCenterAccountLinkServiceClient.listMerchantCenterAccountLinks(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The parent Catalog of the resource. It must match this format:
   *     projects/{PROJECT_NUMBER}/locations/global/catalogs/{CATALOG_ID}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMerchantCenterAccountLinksResponse listMerchantCenterAccountLinks(
      CatalogName parent) {
    ListMerchantCenterAccountLinksRequest request =
        ListMerchantCenterAccountLinksRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMerchantCenterAccountLinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink]s
   * under the specified parent [Catalog][google.cloud.retail.v2alpha.Catalog].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MerchantCenterAccountLinkServiceClient merchantCenterAccountLinkServiceClient =
   *     MerchantCenterAccountLinkServiceClient.create()) {
   *   String parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString();
   *   ListMerchantCenterAccountLinksResponse response =
   *       merchantCenterAccountLinkServiceClient.listMerchantCenterAccountLinks(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The parent Catalog of the resource. It must match this format:
   *     projects/{PROJECT_NUMBER}/locations/global/catalogs/{CATALOG_ID}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMerchantCenterAccountLinksResponse listMerchantCenterAccountLinks(
      String parent) {
    ListMerchantCenterAccountLinksRequest request =
        ListMerchantCenterAccountLinksRequest.newBuilder().setParent(parent).build();
    return listMerchantCenterAccountLinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink]s
   * under the specified parent [Catalog][google.cloud.retail.v2alpha.Catalog].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MerchantCenterAccountLinkServiceClient merchantCenterAccountLinkServiceClient =
   *     MerchantCenterAccountLinkServiceClient.create()) {
   *   ListMerchantCenterAccountLinksRequest request =
   *       ListMerchantCenterAccountLinksRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .build();
   *   ListMerchantCenterAccountLinksResponse response =
   *       merchantCenterAccountLinkServiceClient.listMerchantCenterAccountLinks(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMerchantCenterAccountLinksResponse listMerchantCenterAccountLinks(
      ListMerchantCenterAccountLinksRequest request) {
    return listMerchantCenterAccountLinksCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink]s
   * under the specified parent [Catalog][google.cloud.retail.v2alpha.Catalog].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MerchantCenterAccountLinkServiceClient merchantCenterAccountLinkServiceClient =
   *     MerchantCenterAccountLinkServiceClient.create()) {
   *   ListMerchantCenterAccountLinksRequest request =
   *       ListMerchantCenterAccountLinksRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .build();
   *   ApiFuture<ListMerchantCenterAccountLinksResponse> future =
   *       merchantCenterAccountLinkServiceClient
   *           .listMerchantCenterAccountLinksCallable()
   *           .futureCall(request);
   *   // Do something.
   *   ListMerchantCenterAccountLinksResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListMerchantCenterAccountLinksRequest, ListMerchantCenterAccountLinksResponse>
      listMerchantCenterAccountLinksCallable() {
    return stub.listMerchantCenterAccountLinksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MerchantCenterAccountLinkServiceClient merchantCenterAccountLinkServiceClient =
   *     MerchantCenterAccountLinkServiceClient.create()) {
   *   CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
   *   MerchantCenterAccountLink merchantCenterAccountLink =
   *       MerchantCenterAccountLink.newBuilder().build();
   *   MerchantCenterAccountLink response =
   *       merchantCenterAccountLinkServiceClient
   *           .createMerchantCenterAccountLinkAsync(parent, merchantCenterAccountLink)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The branch resource where this MerchantCenterAccountLink will be
   *     created. Format: projects/{PROJECT_NUMBER}/locations/global/catalogs/{CATALOG_ID}}
   * @param merchantCenterAccountLink Required. The
   *     [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink] to
   *     create.
   *     <p>If the caller does not have permission to create the
   *     [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink],
   *     regardless of whether or not it exists, a PERMISSION_DENIED error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MerchantCenterAccountLink, CreateMerchantCenterAccountLinkMetadata>
      createMerchantCenterAccountLinkAsync(
          CatalogName parent, MerchantCenterAccountLink merchantCenterAccountLink) {
    CreateMerchantCenterAccountLinkRequest request =
        CreateMerchantCenterAccountLinkRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMerchantCenterAccountLink(merchantCenterAccountLink)
            .build();
    return createMerchantCenterAccountLinkAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MerchantCenterAccountLinkServiceClient merchantCenterAccountLinkServiceClient =
   *     MerchantCenterAccountLinkServiceClient.create()) {
   *   String parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString();
   *   MerchantCenterAccountLink merchantCenterAccountLink =
   *       MerchantCenterAccountLink.newBuilder().build();
   *   MerchantCenterAccountLink response =
   *       merchantCenterAccountLinkServiceClient
   *           .createMerchantCenterAccountLinkAsync(parent, merchantCenterAccountLink)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The branch resource where this MerchantCenterAccountLink will be
   *     created. Format: projects/{PROJECT_NUMBER}/locations/global/catalogs/{CATALOG_ID}}
   * @param merchantCenterAccountLink Required. The
   *     [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink] to
   *     create.
   *     <p>If the caller does not have permission to create the
   *     [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink],
   *     regardless of whether or not it exists, a PERMISSION_DENIED error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MerchantCenterAccountLink, CreateMerchantCenterAccountLinkMetadata>
      createMerchantCenterAccountLinkAsync(
          String parent, MerchantCenterAccountLink merchantCenterAccountLink) {
    CreateMerchantCenterAccountLinkRequest request =
        CreateMerchantCenterAccountLinkRequest.newBuilder()
            .setParent(parent)
            .setMerchantCenterAccountLink(merchantCenterAccountLink)
            .build();
    return createMerchantCenterAccountLinkAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MerchantCenterAccountLinkServiceClient merchantCenterAccountLinkServiceClient =
   *     MerchantCenterAccountLinkServiceClient.create()) {
   *   CreateMerchantCenterAccountLinkRequest request =
   *       CreateMerchantCenterAccountLinkRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .setMerchantCenterAccountLink(MerchantCenterAccountLink.newBuilder().build())
   *           .build();
   *   MerchantCenterAccountLink response =
   *       merchantCenterAccountLinkServiceClient
   *           .createMerchantCenterAccountLinkAsync(request)
   *           .get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MerchantCenterAccountLink, CreateMerchantCenterAccountLinkMetadata>
      createMerchantCenterAccountLinkAsync(CreateMerchantCenterAccountLinkRequest request) {
    return createMerchantCenterAccountLinkOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MerchantCenterAccountLinkServiceClient merchantCenterAccountLinkServiceClient =
   *     MerchantCenterAccountLinkServiceClient.create()) {
   *   CreateMerchantCenterAccountLinkRequest request =
   *       CreateMerchantCenterAccountLinkRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .setMerchantCenterAccountLink(MerchantCenterAccountLink.newBuilder().build())
   *           .build();
   *   OperationFuture<MerchantCenterAccountLink, CreateMerchantCenterAccountLinkMetadata> future =
   *       merchantCenterAccountLinkServiceClient
   *           .createMerchantCenterAccountLinkOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   MerchantCenterAccountLink response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateMerchantCenterAccountLinkRequest,
          MerchantCenterAccountLink,
          CreateMerchantCenterAccountLinkMetadata>
      createMerchantCenterAccountLinkOperationCallable() {
    return stub.createMerchantCenterAccountLinkOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MerchantCenterAccountLinkServiceClient merchantCenterAccountLinkServiceClient =
   *     MerchantCenterAccountLinkServiceClient.create()) {
   *   CreateMerchantCenterAccountLinkRequest request =
   *       CreateMerchantCenterAccountLinkRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .setMerchantCenterAccountLink(MerchantCenterAccountLink.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       merchantCenterAccountLinkServiceClient
   *           .createMerchantCenterAccountLinkCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateMerchantCenterAccountLinkRequest, Operation>
      createMerchantCenterAccountLinkCallable() {
    return stub.createMerchantCenterAccountLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink].
   * If the [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink] to
   * delete does not exist, a NOT_FOUND error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MerchantCenterAccountLinkServiceClient merchantCenterAccountLinkServiceClient =
   *     MerchantCenterAccountLinkServiceClient.create()) {
   *   MerchantCenterAccountLinkName name =
   *       MerchantCenterAccountLinkName.of(
   *           "[PROJECT]", "[LOCATION]", "[CATALOG]", "[MERCHANT_CENTER_ACCOUNT_LINK]");
   *   merchantCenterAccountLinkServiceClient.deleteMerchantCenterAccountLink(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name. Format:
   *     projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}/merchantCenterAccountLinks/{merchant_center_account_link_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteMerchantCenterAccountLink(MerchantCenterAccountLinkName name) {
    DeleteMerchantCenterAccountLinkRequest request =
        DeleteMerchantCenterAccountLinkRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteMerchantCenterAccountLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink].
   * If the [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink] to
   * delete does not exist, a NOT_FOUND error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MerchantCenterAccountLinkServiceClient merchantCenterAccountLinkServiceClient =
   *     MerchantCenterAccountLinkServiceClient.create()) {
   *   String name =
   *       MerchantCenterAccountLinkName.of(
   *               "[PROJECT]", "[LOCATION]", "[CATALOG]", "[MERCHANT_CENTER_ACCOUNT_LINK]")
   *           .toString();
   *   merchantCenterAccountLinkServiceClient.deleteMerchantCenterAccountLink(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name. Format:
   *     projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}/merchantCenterAccountLinks/{merchant_center_account_link_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteMerchantCenterAccountLink(String name) {
    DeleteMerchantCenterAccountLinkRequest request =
        DeleteMerchantCenterAccountLinkRequest.newBuilder().setName(name).build();
    deleteMerchantCenterAccountLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink].
   * If the [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink] to
   * delete does not exist, a NOT_FOUND error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MerchantCenterAccountLinkServiceClient merchantCenterAccountLinkServiceClient =
   *     MerchantCenterAccountLinkServiceClient.create()) {
   *   DeleteMerchantCenterAccountLinkRequest request =
   *       DeleteMerchantCenterAccountLinkRequest.newBuilder()
   *           .setName(
   *               MerchantCenterAccountLinkName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CATALOG]", "[MERCHANT_CENTER_ACCOUNT_LINK]")
   *                   .toString())
   *           .build();
   *   merchantCenterAccountLinkServiceClient.deleteMerchantCenterAccountLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteMerchantCenterAccountLink(
      DeleteMerchantCenterAccountLinkRequest request) {
    deleteMerchantCenterAccountLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink].
   * If the [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink] to
   * delete does not exist, a NOT_FOUND error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MerchantCenterAccountLinkServiceClient merchantCenterAccountLinkServiceClient =
   *     MerchantCenterAccountLinkServiceClient.create()) {
   *   DeleteMerchantCenterAccountLinkRequest request =
   *       DeleteMerchantCenterAccountLinkRequest.newBuilder()
   *           .setName(
   *               MerchantCenterAccountLinkName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CATALOG]", "[MERCHANT_CENTER_ACCOUNT_LINK]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       merchantCenterAccountLinkServiceClient
   *           .deleteMerchantCenterAccountLinkCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteMerchantCenterAccountLinkRequest, Empty>
      deleteMerchantCenterAccountLinkCallable() {
    return stub.deleteMerchantCenterAccountLinkCallable();
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
}
