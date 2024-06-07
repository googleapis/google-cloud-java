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
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2alpha.stub.BranchServiceStub;
import com.google.cloud.retail.v2alpha.stub.BranchServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for [Branch][google.cloud.retail.v2alpha.Branch] Management
 *
 * <p>[Branch][google.cloud.retail.v2alpha.Branch]es are automatically created when a
 * [Catalog][google.cloud.retail.v2alpha.Catalog] is created. There are fixed three branches in each
 * catalog, and may use [ListBranches][google.cloud.retail.v2alpha.BranchService.ListBranches]
 * method to get the details of all branches.
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
 * try (BranchServiceClient branchServiceClient = BranchServiceClient.create()) {
 *   CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
 *   ListBranchesResponse response = branchServiceClient.listBranches(parent);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the BranchServiceClient object to clean up resources such
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
 *      <td><p> ListBranches</td>
 *      <td><p> Lists all [Branch][google.cloud.retail.v2alpha.Branch]s under the specified parent [Catalog][google.cloud.retail.v2alpha.Catalog].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBranches(ListBranchesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBranches(CatalogName parent)
 *           <li><p> listBranches(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listBranchesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetBranch</td>
 *      <td><p> Retrieves a [Branch][google.cloud.retail.v2alpha.Branch].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getBranch(GetBranchRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getBranch(BranchName name)
 *           <li><p> getBranch(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getBranchCallable()
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
 * <p>This class can be customized by passing in a custom instance of BranchServiceSettings to
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
 * BranchServiceSettings branchServiceSettings =
 *     BranchServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * BranchServiceClient branchServiceClient = BranchServiceClient.create(branchServiceSettings);
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
 * BranchServiceSettings branchServiceSettings =
 *     BranchServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * BranchServiceClient branchServiceClient = BranchServiceClient.create(branchServiceSettings);
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
 * BranchServiceSettings branchServiceSettings =
 *     BranchServiceSettings.newHttpJsonBuilder().build();
 * BranchServiceClient branchServiceClient = BranchServiceClient.create(branchServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class BranchServiceClient implements BackgroundResource {
  private final BranchServiceSettings settings;
  private final BranchServiceStub stub;

  /** Constructs an instance of BranchServiceClient with default settings. */
  public static final BranchServiceClient create() throws IOException {
    return create(BranchServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of BranchServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final BranchServiceClient create(BranchServiceSettings settings)
      throws IOException {
    return new BranchServiceClient(settings);
  }

  /**
   * Constructs an instance of BranchServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(BranchServiceSettings).
   */
  public static final BranchServiceClient create(BranchServiceStub stub) {
    return new BranchServiceClient(stub);
  }

  /**
   * Constructs an instance of BranchServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected BranchServiceClient(BranchServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((BranchServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected BranchServiceClient(BranchServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final BranchServiceSettings getSettings() {
    return settings;
  }

  public BranchServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [Branch][google.cloud.retail.v2alpha.Branch]s under the specified parent
   * [Catalog][google.cloud.retail.v2alpha.Catalog].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BranchServiceClient branchServiceClient = BranchServiceClient.create()) {
   *   CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
   *   ListBranchesResponse response = branchServiceClient.listBranches(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The parent catalog resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBranchesResponse listBranches(CatalogName parent) {
    ListBranchesRequest request =
        ListBranchesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBranches(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [Branch][google.cloud.retail.v2alpha.Branch]s under the specified parent
   * [Catalog][google.cloud.retail.v2alpha.Catalog].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BranchServiceClient branchServiceClient = BranchServiceClient.create()) {
   *   String parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString();
   *   ListBranchesResponse response = branchServiceClient.listBranches(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The parent catalog resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBranchesResponse listBranches(String parent) {
    ListBranchesRequest request = ListBranchesRequest.newBuilder().setParent(parent).build();
    return listBranches(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [Branch][google.cloud.retail.v2alpha.Branch]s under the specified parent
   * [Catalog][google.cloud.retail.v2alpha.Catalog].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BranchServiceClient branchServiceClient = BranchServiceClient.create()) {
   *   ListBranchesRequest request =
   *       ListBranchesRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .setView(BranchView.forNumber(0))
   *           .build();
   *   ListBranchesResponse response = branchServiceClient.listBranches(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBranchesResponse listBranches(ListBranchesRequest request) {
    return listBranchesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [Branch][google.cloud.retail.v2alpha.Branch]s under the specified parent
   * [Catalog][google.cloud.retail.v2alpha.Catalog].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BranchServiceClient branchServiceClient = BranchServiceClient.create()) {
   *   ListBranchesRequest request =
   *       ListBranchesRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .setView(BranchView.forNumber(0))
   *           .build();
   *   ApiFuture<ListBranchesResponse> future =
   *       branchServiceClient.listBranchesCallable().futureCall(request);
   *   // Do something.
   *   ListBranchesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBranchesRequest, ListBranchesResponse> listBranchesCallable() {
    return stub.listBranchesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a [Branch][google.cloud.retail.v2alpha.Branch].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BranchServiceClient branchServiceClient = BranchServiceClient.create()) {
   *   BranchName name = BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]");
   *   Branch response = branchServiceClient.getBranch(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the branch to retrieve. Format:
   *     `projects/&#42;/locations/global/catalogs/default_catalog/branches/some_branch_id`.
   *     <p>"default_branch" can be used as a special branch_id, it returns the default branch that
   *     has been set for the catalog.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Branch getBranch(BranchName name) {
    GetBranchRequest request =
        GetBranchRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getBranch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a [Branch][google.cloud.retail.v2alpha.Branch].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BranchServiceClient branchServiceClient = BranchServiceClient.create()) {
   *   String name = BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString();
   *   Branch response = branchServiceClient.getBranch(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the branch to retrieve. Format:
   *     `projects/&#42;/locations/global/catalogs/default_catalog/branches/some_branch_id`.
   *     <p>"default_branch" can be used as a special branch_id, it returns the default branch that
   *     has been set for the catalog.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Branch getBranch(String name) {
    GetBranchRequest request = GetBranchRequest.newBuilder().setName(name).build();
    return getBranch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a [Branch][google.cloud.retail.v2alpha.Branch].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BranchServiceClient branchServiceClient = BranchServiceClient.create()) {
   *   GetBranchRequest request =
   *       GetBranchRequest.newBuilder()
   *           .setName(BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString())
   *           .setView(BranchView.forNumber(0))
   *           .build();
   *   Branch response = branchServiceClient.getBranch(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Branch getBranch(GetBranchRequest request) {
    return getBranchCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a [Branch][google.cloud.retail.v2alpha.Branch].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BranchServiceClient branchServiceClient = BranchServiceClient.create()) {
   *   GetBranchRequest request =
   *       GetBranchRequest.newBuilder()
   *           .setName(BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString())
   *           .setView(BranchView.forNumber(0))
   *           .build();
   *   ApiFuture<Branch> future = branchServiceClient.getBranchCallable().futureCall(request);
   *   // Do something.
   *   Branch response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBranchRequest, Branch> getBranchCallable() {
    return stub.getBranchCallable();
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
