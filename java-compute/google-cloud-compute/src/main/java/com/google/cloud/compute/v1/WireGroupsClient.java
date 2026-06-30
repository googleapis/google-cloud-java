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
import com.google.cloud.compute.v1.stub.WireGroupsStub;
import com.google.cloud.compute.v1.stub.WireGroupsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The WireGroups API.
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
 * try (WireGroupsClient wireGroupsClient = WireGroupsClient.create()) {
 *   String project = "project-309310695";
 *   String crossSiteNetwork = "crossSiteNetwork1009388679";
 *   String wireGroup = "wireGroup-970399494";
 *   WireGroup response = wireGroupsClient.get(project, crossSiteNetwork, wireGroup);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the WireGroupsClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
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
 *      <td><p> Deletes the specified wire group in the given scope.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAsync(DeleteWireGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteAsync(String project, String crossSiteNetwork, String wireGroup)
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
 *      <td><p> Gets the specified wire group resource in the given scope.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> get(GetWireGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> get(String project, String crossSiteNetwork, String wireGroup)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Insert</td>
 *      <td><p> Creates a wire group in the specified project in the given scope using the parameters that are included in the request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> insertAsync(InsertWireGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> insertAsync(String project, String crossSiteNetwork, WireGroup wireGroupResource)
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
 *      <td><p> Lists the wire groups for a project in the given scope.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> list(ListWireGroupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> list(String project, String crossSiteNetwork)
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
 *      <td><p> Updates the specified wire group resource with the data included in the request. This method supportsPATCH semantics and usesJSON merge patch format and processing rules.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> patchAsync(PatchWireGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> patchAsync(String project, String crossSiteNetwork, String wireGroup, WireGroup wireGroupResource)
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
 * <p>This class can be customized by passing in a custom instance of WireGroupsSettings to
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
 * WireGroupsSettings wireGroupsSettings =
 *     WireGroupsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * WireGroupsClient wireGroupsClient = WireGroupsClient.create(wireGroupsSettings);
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
 * WireGroupsSettings wireGroupsSettings =
 *     WireGroupsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * WireGroupsClient wireGroupsClient = WireGroupsClient.create(wireGroupsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class WireGroupsClient implements BackgroundResource {
  private final WireGroupsSettings settings;
  private final WireGroupsStub stub;

  /** Constructs an instance of WireGroupsClient with default settings. */
  public static final WireGroupsClient create() throws IOException {
    return create(WireGroupsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of WireGroupsClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final WireGroupsClient create(WireGroupsSettings settings) throws IOException {
    return new WireGroupsClient(settings);
  }

  /**
   * Constructs an instance of WireGroupsClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(WireGroupsSettings).
   */
  public static final WireGroupsClient create(WireGroupsStub stub) {
    return new WireGroupsClient(stub);
  }

  /**
   * Constructs an instance of WireGroupsClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected WireGroupsClient(WireGroupsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((WireGroupsStubSettings) settings.getStubSettings()).createStub();
  }

  protected WireGroupsClient(WireGroupsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final WireGroupsSettings getSettings() {
    return settings;
  }

  public WireGroupsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified wire group in the given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WireGroupsClient wireGroupsClient = WireGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String crossSiteNetwork = "crossSiteNetwork1009388679";
   *   String wireGroup = "wireGroup-970399494";
   *   Operation response = wireGroupsClient.deleteAsync(project, crossSiteNetwork, wireGroup).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param crossSiteNetwork
   * @param wireGroup Name of the wire group resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String crossSiteNetwork, String wireGroup) {
    DeleteWireGroupRequest request =
        DeleteWireGroupRequest.newBuilder()
            .setProject(project)
            .setCrossSiteNetwork(crossSiteNetwork)
            .setWireGroup(wireGroup)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified wire group in the given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WireGroupsClient wireGroupsClient = WireGroupsClient.create()) {
   *   DeleteWireGroupRequest request =
   *       DeleteWireGroupRequest.newBuilder()
   *           .setCrossSiteNetwork("crossSiteNetwork1009388679")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setWireGroup("wireGroup-970399494")
   *           .build();
   *   Operation response = wireGroupsClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(DeleteWireGroupRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified wire group in the given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WireGroupsClient wireGroupsClient = WireGroupsClient.create()) {
   *   DeleteWireGroupRequest request =
   *       DeleteWireGroupRequest.newBuilder()
   *           .setCrossSiteNetwork("crossSiteNetwork1009388679")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setWireGroup("wireGroup-970399494")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       wireGroupsClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteWireGroupRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified wire group in the given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WireGroupsClient wireGroupsClient = WireGroupsClient.create()) {
   *   DeleteWireGroupRequest request =
   *       DeleteWireGroupRequest.newBuilder()
   *           .setCrossSiteNetwork("crossSiteNetwork1009388679")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setWireGroup("wireGroup-970399494")
   *           .build();
   *   ApiFuture<Operation> future = wireGroupsClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteWireGroupRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the specified wire group resource in the given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WireGroupsClient wireGroupsClient = WireGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String crossSiteNetwork = "crossSiteNetwork1009388679";
   *   String wireGroup = "wireGroup-970399494";
   *   WireGroup response = wireGroupsClient.get(project, crossSiteNetwork, wireGroup);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param crossSiteNetwork
   * @param wireGroup Name of the wire group resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WireGroup get(String project, String crossSiteNetwork, String wireGroup) {
    GetWireGroupRequest request =
        GetWireGroupRequest.newBuilder()
            .setProject(project)
            .setCrossSiteNetwork(crossSiteNetwork)
            .setWireGroup(wireGroup)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the specified wire group resource in the given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WireGroupsClient wireGroupsClient = WireGroupsClient.create()) {
   *   GetWireGroupRequest request =
   *       GetWireGroupRequest.newBuilder()
   *           .setCrossSiteNetwork("crossSiteNetwork1009388679")
   *           .setProject("project-309310695")
   *           .setWireGroup("wireGroup-970399494")
   *           .build();
   *   WireGroup response = wireGroupsClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WireGroup get(GetWireGroupRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the specified wire group resource in the given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WireGroupsClient wireGroupsClient = WireGroupsClient.create()) {
   *   GetWireGroupRequest request =
   *       GetWireGroupRequest.newBuilder()
   *           .setCrossSiteNetwork("crossSiteNetwork1009388679")
   *           .setProject("project-309310695")
   *           .setWireGroup("wireGroup-970399494")
   *           .build();
   *   ApiFuture<WireGroup> future = wireGroupsClient.getCallable().futureCall(request);
   *   // Do something.
   *   WireGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetWireGroupRequest, WireGroup> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a wire group in the specified project in the given scope using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WireGroupsClient wireGroupsClient = WireGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String crossSiteNetwork = "crossSiteNetwork1009388679";
   *   WireGroup wireGroupResource = WireGroup.newBuilder().build();
   *   Operation response =
   *       wireGroupsClient.insertAsync(project, crossSiteNetwork, wireGroupResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param crossSiteNetwork
   * @param wireGroupResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, String crossSiteNetwork, WireGroup wireGroupResource) {
    InsertWireGroupRequest request =
        InsertWireGroupRequest.newBuilder()
            .setProject(project)
            .setCrossSiteNetwork(crossSiteNetwork)
            .setWireGroupResource(wireGroupResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a wire group in the specified project in the given scope using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WireGroupsClient wireGroupsClient = WireGroupsClient.create()) {
   *   InsertWireGroupRequest request =
   *       InsertWireGroupRequest.newBuilder()
   *           .setCrossSiteNetwork("crossSiteNetwork1009388679")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setWireGroupResource(WireGroup.newBuilder().build())
   *           .build();
   *   Operation response = wireGroupsClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(InsertWireGroupRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a wire group in the specified project in the given scope using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WireGroupsClient wireGroupsClient = WireGroupsClient.create()) {
   *   InsertWireGroupRequest request =
   *       InsertWireGroupRequest.newBuilder()
   *           .setCrossSiteNetwork("crossSiteNetwork1009388679")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setWireGroupResource(WireGroup.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       wireGroupsClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertWireGroupRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a wire group in the specified project in the given scope using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WireGroupsClient wireGroupsClient = WireGroupsClient.create()) {
   *   InsertWireGroupRequest request =
   *       InsertWireGroupRequest.newBuilder()
   *           .setCrossSiteNetwork("crossSiteNetwork1009388679")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setWireGroupResource(WireGroup.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = wireGroupsClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertWireGroupRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the wire groups for a project in the given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WireGroupsClient wireGroupsClient = WireGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String crossSiteNetwork = "crossSiteNetwork1009388679";
   *   for (WireGroup element : wireGroupsClient.list(project, crossSiteNetwork).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param crossSiteNetwork
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String crossSiteNetwork) {
    ListWireGroupsRequest request =
        ListWireGroupsRequest.newBuilder()
            .setProject(project)
            .setCrossSiteNetwork(crossSiteNetwork)
            .build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the wire groups for a project in the given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WireGroupsClient wireGroupsClient = WireGroupsClient.create()) {
   *   ListWireGroupsRequest request =
   *       ListWireGroupsRequest.newBuilder()
   *           .setCrossSiteNetwork("crossSiteNetwork1009388679")
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (WireGroup element : wireGroupsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListWireGroupsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the wire groups for a project in the given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WireGroupsClient wireGroupsClient = WireGroupsClient.create()) {
   *   ListWireGroupsRequest request =
   *       ListWireGroupsRequest.newBuilder()
   *           .setCrossSiteNetwork("crossSiteNetwork1009388679")
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<WireGroup> future = wireGroupsClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (WireGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListWireGroupsRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the wire groups for a project in the given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WireGroupsClient wireGroupsClient = WireGroupsClient.create()) {
   *   ListWireGroupsRequest request =
   *       ListWireGroupsRequest.newBuilder()
   *           .setCrossSiteNetwork("crossSiteNetwork1009388679")
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     WireGroupList response = wireGroupsClient.listCallable().call(request);
   *     for (WireGroup element : response.getItemsList()) {
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
  public final UnaryCallable<ListWireGroupsRequest, WireGroupList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified wire group resource with the data included in the request. This method
   * supportsPATCH semantics and usesJSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WireGroupsClient wireGroupsClient = WireGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String crossSiteNetwork = "crossSiteNetwork1009388679";
   *   String wireGroup = "wireGroup-970399494";
   *   WireGroup wireGroupResource = WireGroup.newBuilder().build();
   *   Operation response =
   *       wireGroupsClient
   *           .patchAsync(project, crossSiteNetwork, wireGroup, wireGroupResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param crossSiteNetwork
   * @param wireGroup Name of the WireGroups resource to patch.
   * @param wireGroupResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      String project, String crossSiteNetwork, String wireGroup, WireGroup wireGroupResource) {
    PatchWireGroupRequest request =
        PatchWireGroupRequest.newBuilder()
            .setProject(project)
            .setCrossSiteNetwork(crossSiteNetwork)
            .setWireGroup(wireGroup)
            .setWireGroupResource(wireGroupResource)
            .build();
    return patchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified wire group resource with the data included in the request. This method
   * supportsPATCH semantics and usesJSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WireGroupsClient wireGroupsClient = WireGroupsClient.create()) {
   *   PatchWireGroupRequest request =
   *       PatchWireGroupRequest.newBuilder()
   *           .setCrossSiteNetwork("crossSiteNetwork1009388679")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setUpdateMask("updateMask-296147115")
   *           .setValidateOnly(true)
   *           .setWireGroup("wireGroup-970399494")
   *           .setWireGroupResource(WireGroup.newBuilder().build())
   *           .build();
   *   Operation response = wireGroupsClient.patchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(PatchWireGroupRequest request) {
    return patchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified wire group resource with the data included in the request. This method
   * supportsPATCH semantics and usesJSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WireGroupsClient wireGroupsClient = WireGroupsClient.create()) {
   *   PatchWireGroupRequest request =
   *       PatchWireGroupRequest.newBuilder()
   *           .setCrossSiteNetwork("crossSiteNetwork1009388679")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setUpdateMask("updateMask-296147115")
   *           .setValidateOnly(true)
   *           .setWireGroup("wireGroup-970399494")
   *           .setWireGroupResource(WireGroup.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       wireGroupsClient.patchOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchWireGroupRequest, Operation, Operation>
      patchOperationCallable() {
    return stub.patchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified wire group resource with the data included in the request. This method
   * supportsPATCH semantics and usesJSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WireGroupsClient wireGroupsClient = WireGroupsClient.create()) {
   *   PatchWireGroupRequest request =
   *       PatchWireGroupRequest.newBuilder()
   *           .setCrossSiteNetwork("crossSiteNetwork1009388679")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setUpdateMask("updateMask-296147115")
   *           .setValidateOnly(true)
   *           .setWireGroup("wireGroup-970399494")
   *           .setWireGroupResource(WireGroup.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = wireGroupsClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchWireGroupRequest, Operation> patchCallable() {
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
          ListWireGroupsRequest, WireGroupList, WireGroup, ListPage, ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListWireGroupsRequest, WireGroupList, WireGroup> context,
        ApiFuture<WireGroupList> futureResponse) {
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
      extends AbstractPage<ListWireGroupsRequest, WireGroupList, WireGroup, ListPage> {

    private ListPage(
        PageContext<ListWireGroupsRequest, WireGroupList, WireGroup> context,
        WireGroupList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListWireGroupsRequest, WireGroupList, WireGroup> context,
        WireGroupList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListWireGroupsRequest, WireGroupList, WireGroup> context,
        ApiFuture<WireGroupList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListWireGroupsRequest, WireGroupList, WireGroup, ListPage, ListFixedSizeCollection> {

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
