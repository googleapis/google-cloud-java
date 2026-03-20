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

package com.google.cloud.compute.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.CrossSiteNetworksStub;
import com.google.cloud.compute.v1.stub.CrossSiteNetworksStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The CrossSiteNetworks API.
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
 * try (CrossSiteNetworksClient crossSiteNetworksClient = CrossSiteNetworksClient.create()) {
 *   String project = "project-309310695";
 *   String crossSiteNetwork = "crossSiteNetwork1009388679";
 *   CrossSiteNetwork response = crossSiteNetworksClient.get(project, crossSiteNetwork);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CrossSiteNetworksClient object to clean up resources
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
 *      <td><p> Delete</td>
 *      <td><p> Deletes the specified cross-site network in the given scope.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAsync(DeleteCrossSiteNetworkRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteAsync(String project, String crossSiteNetwork)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteOperationCallable()
 *           <li><p> deleteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Get</td>
 *      <td><p> Returns the specified cross-site network in the given scope.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> get(GetCrossSiteNetworkRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> get(String project, String crossSiteNetwork)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Insert</td>
 *      <td><p> Creates a cross-site network in the specified project in the given scope using the parameters that are included in the request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> insertAsync(InsertCrossSiteNetworkRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> insertAsync(String project, CrossSiteNetwork crossSiteNetworkResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> insertOperationCallable()
 *           <li><p> insertCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> List</td>
 *      <td><p> Lists the cross-site networks for a project in the given scope.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> list(ListCrossSiteNetworksRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> list(String project)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPagedCallable()
 *           <li><p> listCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Patch</td>
 *      <td><p> Updates the specified cross-site network with the data included in the request. This method supportsPATCH semantics and uses theJSON merge patch format and processing rules.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> patchAsync(PatchCrossSiteNetworkRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> patchAsync(String project, String crossSiteNetwork, CrossSiteNetwork crossSiteNetworkResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> patchOperationCallable()
 *           <li><p> patchCallable()
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
 * <p>This class can be customized by passing in a custom instance of CrossSiteNetworksSettings to
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
 * CrossSiteNetworksSettings crossSiteNetworksSettings =
 *     CrossSiteNetworksSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CrossSiteNetworksClient crossSiteNetworksClient =
 *     CrossSiteNetworksClient.create(crossSiteNetworksSettings);
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
 * CrossSiteNetworksSettings crossSiteNetworksSettings =
 *     CrossSiteNetworksSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CrossSiteNetworksClient crossSiteNetworksClient =
 *     CrossSiteNetworksClient.create(crossSiteNetworksSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class CrossSiteNetworksClient implements BackgroundResource {
  private final CrossSiteNetworksSettings settings;
  private final CrossSiteNetworksStub stub;

  /** Constructs an instance of CrossSiteNetworksClient with default settings. */
  public static final CrossSiteNetworksClient create() throws IOException {
    return create(CrossSiteNetworksSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CrossSiteNetworksClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CrossSiteNetworksClient create(CrossSiteNetworksSettings settings)
      throws IOException {
    return new CrossSiteNetworksClient(settings);
  }

  /**
   * Constructs an instance of CrossSiteNetworksClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(CrossSiteNetworksSettings).
   */
  public static final CrossSiteNetworksClient create(CrossSiteNetworksStub stub) {
    return new CrossSiteNetworksClient(stub);
  }

  /**
   * Constructs an instance of CrossSiteNetworksClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected CrossSiteNetworksClient(CrossSiteNetworksSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CrossSiteNetworksStubSettings) settings.getStubSettings()).createStub();
  }

  protected CrossSiteNetworksClient(CrossSiteNetworksStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final CrossSiteNetworksSettings getSettings() {
    return settings;
  }

  public CrossSiteNetworksStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified cross-site network in the given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossSiteNetworksClient crossSiteNetworksClient = CrossSiteNetworksClient.create()) {
   *   String project = "project-309310695";
   *   String crossSiteNetwork = "crossSiteNetwork1009388679";
   *   Operation response = crossSiteNetworksClient.deleteAsync(project, crossSiteNetwork).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param crossSiteNetwork Name of the cross-site network to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String crossSiteNetwork) {
    DeleteCrossSiteNetworkRequest request =
        DeleteCrossSiteNetworkRequest.newBuilder()
            .setProject(project)
            .setCrossSiteNetwork(crossSiteNetwork)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified cross-site network in the given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossSiteNetworksClient crossSiteNetworksClient = CrossSiteNetworksClient.create()) {
   *   DeleteCrossSiteNetworkRequest request =
   *       DeleteCrossSiteNetworkRequest.newBuilder()
   *           .setCrossSiteNetwork("crossSiteNetwork1009388679")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = crossSiteNetworksClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteCrossSiteNetworkRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified cross-site network in the given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossSiteNetworksClient crossSiteNetworksClient = CrossSiteNetworksClient.create()) {
   *   DeleteCrossSiteNetworkRequest request =
   *       DeleteCrossSiteNetworkRequest.newBuilder()
   *           .setCrossSiteNetwork("crossSiteNetwork1009388679")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       crossSiteNetworksClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteCrossSiteNetworkRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified cross-site network in the given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossSiteNetworksClient crossSiteNetworksClient = CrossSiteNetworksClient.create()) {
   *   DeleteCrossSiteNetworkRequest request =
   *       DeleteCrossSiteNetworkRequest.newBuilder()
   *           .setCrossSiteNetwork("crossSiteNetwork1009388679")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = crossSiteNetworksClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCrossSiteNetworkRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified cross-site network in the given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossSiteNetworksClient crossSiteNetworksClient = CrossSiteNetworksClient.create()) {
   *   String project = "project-309310695";
   *   String crossSiteNetwork = "crossSiteNetwork1009388679";
   *   CrossSiteNetwork response = crossSiteNetworksClient.get(project, crossSiteNetwork);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param crossSiteNetwork Name of the cross-site network to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CrossSiteNetwork get(String project, String crossSiteNetwork) {
    GetCrossSiteNetworkRequest request =
        GetCrossSiteNetworkRequest.newBuilder()
            .setProject(project)
            .setCrossSiteNetwork(crossSiteNetwork)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified cross-site network in the given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossSiteNetworksClient crossSiteNetworksClient = CrossSiteNetworksClient.create()) {
   *   GetCrossSiteNetworkRequest request =
   *       GetCrossSiteNetworkRequest.newBuilder()
   *           .setCrossSiteNetwork("crossSiteNetwork1009388679")
   *           .setProject("project-309310695")
   *           .build();
   *   CrossSiteNetwork response = crossSiteNetworksClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CrossSiteNetwork get(GetCrossSiteNetworkRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified cross-site network in the given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossSiteNetworksClient crossSiteNetworksClient = CrossSiteNetworksClient.create()) {
   *   GetCrossSiteNetworkRequest request =
   *       GetCrossSiteNetworkRequest.newBuilder()
   *           .setCrossSiteNetwork("crossSiteNetwork1009388679")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<CrossSiteNetwork> future =
   *       crossSiteNetworksClient.getCallable().futureCall(request);
   *   // Do something.
   *   CrossSiteNetwork response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCrossSiteNetworkRequest, CrossSiteNetwork> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a cross-site network in the specified project in the given scope using the parameters
   * that are included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossSiteNetworksClient crossSiteNetworksClient = CrossSiteNetworksClient.create()) {
   *   String project = "project-309310695";
   *   CrossSiteNetwork crossSiteNetworkResource = CrossSiteNetwork.newBuilder().build();
   *   Operation response =
   *       crossSiteNetworksClient.insertAsync(project, crossSiteNetworkResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param crossSiteNetworkResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, CrossSiteNetwork crossSiteNetworkResource) {
    InsertCrossSiteNetworkRequest request =
        InsertCrossSiteNetworkRequest.newBuilder()
            .setProject(project)
            .setCrossSiteNetworkResource(crossSiteNetworkResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a cross-site network in the specified project in the given scope using the parameters
   * that are included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossSiteNetworksClient crossSiteNetworksClient = CrossSiteNetworksClient.create()) {
   *   InsertCrossSiteNetworkRequest request =
   *       InsertCrossSiteNetworkRequest.newBuilder()
   *           .setCrossSiteNetworkResource(CrossSiteNetwork.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   Operation response = crossSiteNetworksClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertCrossSiteNetworkRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a cross-site network in the specified project in the given scope using the parameters
   * that are included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossSiteNetworksClient crossSiteNetworksClient = CrossSiteNetworksClient.create()) {
   *   InsertCrossSiteNetworkRequest request =
   *       InsertCrossSiteNetworkRequest.newBuilder()
   *           .setCrossSiteNetworkResource(CrossSiteNetwork.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       crossSiteNetworksClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertCrossSiteNetworkRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a cross-site network in the specified project in the given scope using the parameters
   * that are included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossSiteNetworksClient crossSiteNetworksClient = CrossSiteNetworksClient.create()) {
   *   InsertCrossSiteNetworkRequest request =
   *       InsertCrossSiteNetworkRequest.newBuilder()
   *           .setCrossSiteNetworkResource(CrossSiteNetwork.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = crossSiteNetworksClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertCrossSiteNetworkRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the cross-site networks for a project in the given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossSiteNetworksClient crossSiteNetworksClient = CrossSiteNetworksClient.create()) {
   *   String project = "project-309310695";
   *   for (CrossSiteNetwork element : crossSiteNetworksClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListCrossSiteNetworksRequest request =
        ListCrossSiteNetworksRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the cross-site networks for a project in the given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossSiteNetworksClient crossSiteNetworksClient = CrossSiteNetworksClient.create()) {
   *   ListCrossSiteNetworksRequest request =
   *       ListCrossSiteNetworksRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (CrossSiteNetwork element : crossSiteNetworksClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListCrossSiteNetworksRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the cross-site networks for a project in the given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossSiteNetworksClient crossSiteNetworksClient = CrossSiteNetworksClient.create()) {
   *   ListCrossSiteNetworksRequest request =
   *       ListCrossSiteNetworksRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<CrossSiteNetwork> future =
   *       crossSiteNetworksClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CrossSiteNetwork element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCrossSiteNetworksRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the cross-site networks for a project in the given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossSiteNetworksClient crossSiteNetworksClient = CrossSiteNetworksClient.create()) {
   *   ListCrossSiteNetworksRequest request =
   *       ListCrossSiteNetworksRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     CrossSiteNetworkList response = crossSiteNetworksClient.listCallable().call(request);
   *     for (CrossSiteNetwork element : response.getItemsList()) {
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
  public final UnaryCallable<ListCrossSiteNetworksRequest, CrossSiteNetworkList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified cross-site network with the data included in the request. This method
   * supportsPATCH semantics and uses theJSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossSiteNetworksClient crossSiteNetworksClient = CrossSiteNetworksClient.create()) {
   *   String project = "project-309310695";
   *   String crossSiteNetwork = "crossSiteNetwork1009388679";
   *   CrossSiteNetwork crossSiteNetworkResource = CrossSiteNetwork.newBuilder().build();
   *   Operation response =
   *       crossSiteNetworksClient
   *           .patchAsync(project, crossSiteNetwork, crossSiteNetworkResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param crossSiteNetwork Name of the cross-site network to update.
   * @param crossSiteNetworkResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      String project, String crossSiteNetwork, CrossSiteNetwork crossSiteNetworkResource) {
    PatchCrossSiteNetworkRequest request =
        PatchCrossSiteNetworkRequest.newBuilder()
            .setProject(project)
            .setCrossSiteNetwork(crossSiteNetwork)
            .setCrossSiteNetworkResource(crossSiteNetworkResource)
            .build();
    return patchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified cross-site network with the data included in the request. This method
   * supportsPATCH semantics and uses theJSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossSiteNetworksClient crossSiteNetworksClient = CrossSiteNetworksClient.create()) {
   *   PatchCrossSiteNetworkRequest request =
   *       PatchCrossSiteNetworkRequest.newBuilder()
   *           .setCrossSiteNetwork("crossSiteNetwork1009388679")
   *           .setCrossSiteNetworkResource(CrossSiteNetwork.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setUpdateMask("updateMask-296147115")
   *           .setValidateOnly(true)
   *           .build();
   *   Operation response = crossSiteNetworksClient.patchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      PatchCrossSiteNetworkRequest request) {
    return patchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified cross-site network with the data included in the request. This method
   * supportsPATCH semantics and uses theJSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossSiteNetworksClient crossSiteNetworksClient = CrossSiteNetworksClient.create()) {
   *   PatchCrossSiteNetworkRequest request =
   *       PatchCrossSiteNetworkRequest.newBuilder()
   *           .setCrossSiteNetwork("crossSiteNetwork1009388679")
   *           .setCrossSiteNetworkResource(CrossSiteNetwork.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setUpdateMask("updateMask-296147115")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       crossSiteNetworksClient.patchOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchCrossSiteNetworkRequest, Operation, Operation>
      patchOperationCallable() {
    return stub.patchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified cross-site network with the data included in the request. This method
   * supportsPATCH semantics and uses theJSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossSiteNetworksClient crossSiteNetworksClient = CrossSiteNetworksClient.create()) {
   *   PatchCrossSiteNetworkRequest request =
   *       PatchCrossSiteNetworkRequest.newBuilder()
   *           .setCrossSiteNetwork("crossSiteNetwork1009388679")
   *           .setCrossSiteNetworkResource(CrossSiteNetwork.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setUpdateMask("updateMask-296147115")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = crossSiteNetworksClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchCrossSiteNetworkRequest, Operation> patchCallable() {
    return stub.patchCallable();
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

  public static class ListPagedResponse
      extends AbstractPagedListResponse<
          ListCrossSiteNetworksRequest,
          CrossSiteNetworkList,
          CrossSiteNetwork,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListCrossSiteNetworksRequest, CrossSiteNetworkList, CrossSiteNetwork> context,
        ApiFuture<CrossSiteNetworkList> futureResponse) {
      ApiFuture<ListPage> futurePage =
          ListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListPagedResponse(ListPage page) {
      super(page, ListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPage
      extends AbstractPage<
          ListCrossSiteNetworksRequest, CrossSiteNetworkList, CrossSiteNetwork, ListPage> {

    private ListPage(
        PageContext<ListCrossSiteNetworksRequest, CrossSiteNetworkList, CrossSiteNetwork> context,
        CrossSiteNetworkList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListCrossSiteNetworksRequest, CrossSiteNetworkList, CrossSiteNetwork> context,
        CrossSiteNetworkList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListCrossSiteNetworksRequest, CrossSiteNetworkList, CrossSiteNetwork> context,
        ApiFuture<CrossSiteNetworkList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCrossSiteNetworksRequest,
          CrossSiteNetworkList,
          CrossSiteNetwork,
          ListPage,
          ListFixedSizeCollection> {

    private ListFixedSizeCollection(List<ListPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFixedSizeCollection createEmptyCollection() {
      return new ListFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFixedSizeCollection createCollection(List<ListPage> pages, int collectionSize) {
      return new ListFixedSizeCollection(pages, collectionSize);
    }
  }
}
