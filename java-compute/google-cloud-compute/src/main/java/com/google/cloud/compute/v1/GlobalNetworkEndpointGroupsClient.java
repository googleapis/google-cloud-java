/*
 * Copyright 2022 Google LLC
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
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.GlobalNetworkEndpointGroupsStub;
import com.google.cloud.compute.v1.stub.GlobalNetworkEndpointGroupsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The GlobalNetworkEndpointGroups API.
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
 * try (GlobalNetworkEndpointGroupsClient globalNetworkEndpointGroupsClient =
 *     GlobalNetworkEndpointGroupsClient.create()) {
 *   String project = "project-309310695";
 *   String networkEndpointGroup = "networkEndpointGroup-2120389028";
 *   NetworkEndpointGroup response =
 *       globalNetworkEndpointGroupsClient.get(project, networkEndpointGroup);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the GlobalNetworkEndpointGroupsClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of
 * GlobalNetworkEndpointGroupsSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GlobalNetworkEndpointGroupsSettings globalNetworkEndpointGroupsSettings =
 *     GlobalNetworkEndpointGroupsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GlobalNetworkEndpointGroupsClient globalNetworkEndpointGroupsClient =
 *     GlobalNetworkEndpointGroupsClient.create(globalNetworkEndpointGroupsSettings);
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
 * GlobalNetworkEndpointGroupsSettings globalNetworkEndpointGroupsSettings =
 *     GlobalNetworkEndpointGroupsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GlobalNetworkEndpointGroupsClient globalNetworkEndpointGroupsClient =
 *     GlobalNetworkEndpointGroupsClient.create(globalNetworkEndpointGroupsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class GlobalNetworkEndpointGroupsClient implements BackgroundResource {
  private final GlobalNetworkEndpointGroupsSettings settings;
  private final GlobalNetworkEndpointGroupsStub stub;

  /** Constructs an instance of GlobalNetworkEndpointGroupsClient with default settings. */
  public static final GlobalNetworkEndpointGroupsClient create() throws IOException {
    return create(GlobalNetworkEndpointGroupsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of GlobalNetworkEndpointGroupsClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final GlobalNetworkEndpointGroupsClient create(
      GlobalNetworkEndpointGroupsSettings settings) throws IOException {
    return new GlobalNetworkEndpointGroupsClient(settings);
  }

  /**
   * Constructs an instance of GlobalNetworkEndpointGroupsClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(GlobalNetworkEndpointGroupsSettings).
   */
  public static final GlobalNetworkEndpointGroupsClient create(
      GlobalNetworkEndpointGroupsStub stub) {
    return new GlobalNetworkEndpointGroupsClient(stub);
  }

  /**
   * Constructs an instance of GlobalNetworkEndpointGroupsClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GlobalNetworkEndpointGroupsClient(GlobalNetworkEndpointGroupsSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((GlobalNetworkEndpointGroupsStubSettings) settings.getStubSettings()).createStub();
  }

  protected GlobalNetworkEndpointGroupsClient(GlobalNetworkEndpointGroupsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final GlobalNetworkEndpointGroupsSettings getSettings() {
    return settings;
  }

  public GlobalNetworkEndpointGroupsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Attach a network endpoint to the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalNetworkEndpointGroupsClient globalNetworkEndpointGroupsClient =
   *     GlobalNetworkEndpointGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String networkEndpointGroup = "networkEndpointGroup-2120389028";
   *   GlobalNetworkEndpointGroupsAttachEndpointsRequest
   *       globalNetworkEndpointGroupsAttachEndpointsRequestResource =
   *           GlobalNetworkEndpointGroupsAttachEndpointsRequest.newBuilder().build();
   *   Operation response =
   *       globalNetworkEndpointGroupsClient
   *           .attachNetworkEndpointsAsync(
   *               project,
   *               networkEndpointGroup,
   *               globalNetworkEndpointGroupsAttachEndpointsRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param networkEndpointGroup The name of the network endpoint group where you are attaching
   *     network endpoints to. It should comply with RFC1035.
   * @param globalNetworkEndpointGroupsAttachEndpointsRequestResource The body resource for this
   *     request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> attachNetworkEndpointsAsync(
      String project,
      String networkEndpointGroup,
      GlobalNetworkEndpointGroupsAttachEndpointsRequest
          globalNetworkEndpointGroupsAttachEndpointsRequestResource) {
    AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest request =
        AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest.newBuilder()
            .setProject(project)
            .setNetworkEndpointGroup(networkEndpointGroup)
            .setGlobalNetworkEndpointGroupsAttachEndpointsRequestResource(
                globalNetworkEndpointGroupsAttachEndpointsRequestResource)
            .build();
    return attachNetworkEndpointsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Attach a network endpoint to the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalNetworkEndpointGroupsClient globalNetworkEndpointGroupsClient =
   *     GlobalNetworkEndpointGroupsClient.create()) {
   *   AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest request =
   *       AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest.newBuilder()
   *           .setGlobalNetworkEndpointGroupsAttachEndpointsRequestResource(
   *               GlobalNetworkEndpointGroupsAttachEndpointsRequest.newBuilder().build())
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response =
   *       globalNetworkEndpointGroupsClient.attachNetworkEndpointsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> attachNetworkEndpointsAsync(
      AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest request) {
    return attachNetworkEndpointsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Attach a network endpoint to the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalNetworkEndpointGroupsClient globalNetworkEndpointGroupsClient =
   *     GlobalNetworkEndpointGroupsClient.create()) {
   *   AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest request =
   *       AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest.newBuilder()
   *           .setGlobalNetworkEndpointGroupsAttachEndpointsRequestResource(
   *               GlobalNetworkEndpointGroupsAttachEndpointsRequest.newBuilder().build())
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       globalNetworkEndpointGroupsClient
   *           .attachNetworkEndpointsOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation, Operation>
      attachNetworkEndpointsOperationCallable() {
    return stub.attachNetworkEndpointsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Attach a network endpoint to the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalNetworkEndpointGroupsClient globalNetworkEndpointGroupsClient =
   *     GlobalNetworkEndpointGroupsClient.create()) {
   *   AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest request =
   *       AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest.newBuilder()
   *           .setGlobalNetworkEndpointGroupsAttachEndpointsRequestResource(
   *               GlobalNetworkEndpointGroupsAttachEndpointsRequest.newBuilder().build())
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       globalNetworkEndpointGroupsClient.attachNetworkEndpointsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>
      attachNetworkEndpointsCallable() {
    return stub.attachNetworkEndpointsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified network endpoint group.Note that the NEG cannot be deleted if there are
   * backend services referencing it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalNetworkEndpointGroupsClient globalNetworkEndpointGroupsClient =
   *     GlobalNetworkEndpointGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String networkEndpointGroup = "networkEndpointGroup-2120389028";
   *   Operation response =
   *       globalNetworkEndpointGroupsClient.deleteAsync(project, networkEndpointGroup).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param networkEndpointGroup The name of the network endpoint group to delete. It should comply
   *     with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String networkEndpointGroup) {
    DeleteGlobalNetworkEndpointGroupRequest request =
        DeleteGlobalNetworkEndpointGroupRequest.newBuilder()
            .setProject(project)
            .setNetworkEndpointGroup(networkEndpointGroup)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified network endpoint group.Note that the NEG cannot be deleted if there are
   * backend services referencing it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalNetworkEndpointGroupsClient globalNetworkEndpointGroupsClient =
   *     GlobalNetworkEndpointGroupsClient.create()) {
   *   DeleteGlobalNetworkEndpointGroupRequest request =
   *       DeleteGlobalNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = globalNetworkEndpointGroupsClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteGlobalNetworkEndpointGroupRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified network endpoint group.Note that the NEG cannot be deleted if there are
   * backend services referencing it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalNetworkEndpointGroupsClient globalNetworkEndpointGroupsClient =
   *     GlobalNetworkEndpointGroupsClient.create()) {
   *   DeleteGlobalNetworkEndpointGroupRequest request =
   *       DeleteGlobalNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       globalNetworkEndpointGroupsClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteGlobalNetworkEndpointGroupRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified network endpoint group.Note that the NEG cannot be deleted if there are
   * backend services referencing it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalNetworkEndpointGroupsClient globalNetworkEndpointGroupsClient =
   *     GlobalNetworkEndpointGroupsClient.create()) {
   *   DeleteGlobalNetworkEndpointGroupRequest request =
   *       DeleteGlobalNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       globalNetworkEndpointGroupsClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteGlobalNetworkEndpointGroupRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detach the network endpoint from the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalNetworkEndpointGroupsClient globalNetworkEndpointGroupsClient =
   *     GlobalNetworkEndpointGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String networkEndpointGroup = "networkEndpointGroup-2120389028";
   *   GlobalNetworkEndpointGroupsDetachEndpointsRequest
   *       globalNetworkEndpointGroupsDetachEndpointsRequestResource =
   *           GlobalNetworkEndpointGroupsDetachEndpointsRequest.newBuilder().build();
   *   Operation response =
   *       globalNetworkEndpointGroupsClient
   *           .detachNetworkEndpointsAsync(
   *               project,
   *               networkEndpointGroup,
   *               globalNetworkEndpointGroupsDetachEndpointsRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param networkEndpointGroup The name of the network endpoint group where you are removing
   *     network endpoints. It should comply with RFC1035.
   * @param globalNetworkEndpointGroupsDetachEndpointsRequestResource The body resource for this
   *     request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> detachNetworkEndpointsAsync(
      String project,
      String networkEndpointGroup,
      GlobalNetworkEndpointGroupsDetachEndpointsRequest
          globalNetworkEndpointGroupsDetachEndpointsRequestResource) {
    DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest request =
        DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest.newBuilder()
            .setProject(project)
            .setNetworkEndpointGroup(networkEndpointGroup)
            .setGlobalNetworkEndpointGroupsDetachEndpointsRequestResource(
                globalNetworkEndpointGroupsDetachEndpointsRequestResource)
            .build();
    return detachNetworkEndpointsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detach the network endpoint from the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalNetworkEndpointGroupsClient globalNetworkEndpointGroupsClient =
   *     GlobalNetworkEndpointGroupsClient.create()) {
   *   DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest request =
   *       DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest.newBuilder()
   *           .setGlobalNetworkEndpointGroupsDetachEndpointsRequestResource(
   *               GlobalNetworkEndpointGroupsDetachEndpointsRequest.newBuilder().build())
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response =
   *       globalNetworkEndpointGroupsClient.detachNetworkEndpointsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> detachNetworkEndpointsAsync(
      DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest request) {
    return detachNetworkEndpointsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detach the network endpoint from the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalNetworkEndpointGroupsClient globalNetworkEndpointGroupsClient =
   *     GlobalNetworkEndpointGroupsClient.create()) {
   *   DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest request =
   *       DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest.newBuilder()
   *           .setGlobalNetworkEndpointGroupsDetachEndpointsRequestResource(
   *               GlobalNetworkEndpointGroupsDetachEndpointsRequest.newBuilder().build())
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       globalNetworkEndpointGroupsClient
   *           .detachNetworkEndpointsOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation, Operation>
      detachNetworkEndpointsOperationCallable() {
    return stub.detachNetworkEndpointsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detach the network endpoint from the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalNetworkEndpointGroupsClient globalNetworkEndpointGroupsClient =
   *     GlobalNetworkEndpointGroupsClient.create()) {
   *   DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest request =
   *       DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest.newBuilder()
   *           .setGlobalNetworkEndpointGroupsDetachEndpointsRequestResource(
   *               GlobalNetworkEndpointGroupsDetachEndpointsRequest.newBuilder().build())
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       globalNetworkEndpointGroupsClient.detachNetworkEndpointsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>
      detachNetworkEndpointsCallable() {
    return stub.detachNetworkEndpointsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified network endpoint group. Gets a list of available network endpoint groups
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalNetworkEndpointGroupsClient globalNetworkEndpointGroupsClient =
   *     GlobalNetworkEndpointGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String networkEndpointGroup = "networkEndpointGroup-2120389028";
   *   NetworkEndpointGroup response =
   *       globalNetworkEndpointGroupsClient.get(project, networkEndpointGroup);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param networkEndpointGroup The name of the network endpoint group. It should comply with
   *     RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NetworkEndpointGroup get(String project, String networkEndpointGroup) {
    GetGlobalNetworkEndpointGroupRequest request =
        GetGlobalNetworkEndpointGroupRequest.newBuilder()
            .setProject(project)
            .setNetworkEndpointGroup(networkEndpointGroup)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified network endpoint group. Gets a list of available network endpoint groups
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalNetworkEndpointGroupsClient globalNetworkEndpointGroupsClient =
   *     GlobalNetworkEndpointGroupsClient.create()) {
   *   GetGlobalNetworkEndpointGroupRequest request =
   *       GetGlobalNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setProject("project-309310695")
   *           .build();
   *   NetworkEndpointGroup response = globalNetworkEndpointGroupsClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NetworkEndpointGroup get(GetGlobalNetworkEndpointGroupRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified network endpoint group. Gets a list of available network endpoint groups
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalNetworkEndpointGroupsClient globalNetworkEndpointGroupsClient =
   *     GlobalNetworkEndpointGroupsClient.create()) {
   *   GetGlobalNetworkEndpointGroupRequest request =
   *       GetGlobalNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<NetworkEndpointGroup> future =
   *       globalNetworkEndpointGroupsClient.getCallable().futureCall(request);
   *   // Do something.
   *   NetworkEndpointGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGlobalNetworkEndpointGroupRequest, NetworkEndpointGroup>
      getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a network endpoint group in the specified project using the parameters that are
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
   * try (GlobalNetworkEndpointGroupsClient globalNetworkEndpointGroupsClient =
   *     GlobalNetworkEndpointGroupsClient.create()) {
   *   String project = "project-309310695";
   *   NetworkEndpointGroup networkEndpointGroupResource = NetworkEndpointGroup.newBuilder().build();
   *   Operation response =
   *       globalNetworkEndpointGroupsClient
   *           .insertAsync(project, networkEndpointGroupResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param networkEndpointGroupResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, NetworkEndpointGroup networkEndpointGroupResource) {
    InsertGlobalNetworkEndpointGroupRequest request =
        InsertGlobalNetworkEndpointGroupRequest.newBuilder()
            .setProject(project)
            .setNetworkEndpointGroupResource(networkEndpointGroupResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a network endpoint group in the specified project using the parameters that are
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
   * try (GlobalNetworkEndpointGroupsClient globalNetworkEndpointGroupsClient =
   *     GlobalNetworkEndpointGroupsClient.create()) {
   *   InsertGlobalNetworkEndpointGroupRequest request =
   *       InsertGlobalNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroupResource(NetworkEndpointGroup.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = globalNetworkEndpointGroupsClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertGlobalNetworkEndpointGroupRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a network endpoint group in the specified project using the parameters that are
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
   * try (GlobalNetworkEndpointGroupsClient globalNetworkEndpointGroupsClient =
   *     GlobalNetworkEndpointGroupsClient.create()) {
   *   InsertGlobalNetworkEndpointGroupRequest request =
   *       InsertGlobalNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroupResource(NetworkEndpointGroup.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       globalNetworkEndpointGroupsClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertGlobalNetworkEndpointGroupRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a network endpoint group in the specified project using the parameters that are
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
   * try (GlobalNetworkEndpointGroupsClient globalNetworkEndpointGroupsClient =
   *     GlobalNetworkEndpointGroupsClient.create()) {
   *   InsertGlobalNetworkEndpointGroupRequest request =
   *       InsertGlobalNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroupResource(NetworkEndpointGroup.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       globalNetworkEndpointGroupsClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertGlobalNetworkEndpointGroupRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of network endpoint groups that are located in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalNetworkEndpointGroupsClient globalNetworkEndpointGroupsClient =
   *     GlobalNetworkEndpointGroupsClient.create()) {
   *   String project = "project-309310695";
   *   for (NetworkEndpointGroup element :
   *       globalNetworkEndpointGroupsClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListGlobalNetworkEndpointGroupsRequest request =
        ListGlobalNetworkEndpointGroupsRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of network endpoint groups that are located in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalNetworkEndpointGroupsClient globalNetworkEndpointGroupsClient =
   *     GlobalNetworkEndpointGroupsClient.create()) {
   *   ListGlobalNetworkEndpointGroupsRequest request =
   *       ListGlobalNetworkEndpointGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (NetworkEndpointGroup element :
   *       globalNetworkEndpointGroupsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListGlobalNetworkEndpointGroupsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of network endpoint groups that are located in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalNetworkEndpointGroupsClient globalNetworkEndpointGroupsClient =
   *     GlobalNetworkEndpointGroupsClient.create()) {
   *   ListGlobalNetworkEndpointGroupsRequest request =
   *       ListGlobalNetworkEndpointGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<NetworkEndpointGroup> future =
   *       globalNetworkEndpointGroupsClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (NetworkEndpointGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListGlobalNetworkEndpointGroupsRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of network endpoint groups that are located in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalNetworkEndpointGroupsClient globalNetworkEndpointGroupsClient =
   *     GlobalNetworkEndpointGroupsClient.create()) {
   *   ListGlobalNetworkEndpointGroupsRequest request =
   *       ListGlobalNetworkEndpointGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     NetworkEndpointGroupList response =
   *         globalNetworkEndpointGroupsClient.listCallable().call(request);
   *     for (NetworkEndpointGroup element : response.getItemsList()) {
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
  public final UnaryCallable<ListGlobalNetworkEndpointGroupsRequest, NetworkEndpointGroupList>
      listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the network endpoints in the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalNetworkEndpointGroupsClient globalNetworkEndpointGroupsClient =
   *     GlobalNetworkEndpointGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String networkEndpointGroup = "networkEndpointGroup-2120389028";
   *   for (NetworkEndpointWithHealthStatus element :
   *       globalNetworkEndpointGroupsClient
   *           .listNetworkEndpoints(project, networkEndpointGroup)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param networkEndpointGroup The name of the network endpoint group from which you want to
   *     generate a list of included network endpoints. It should comply with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNetworkEndpointsPagedResponse listNetworkEndpoints(
      String project, String networkEndpointGroup) {
    ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest request =
        ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest.newBuilder()
            .setProject(project)
            .setNetworkEndpointGroup(networkEndpointGroup)
            .build();
    return listNetworkEndpoints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the network endpoints in the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalNetworkEndpointGroupsClient globalNetworkEndpointGroupsClient =
   *     GlobalNetworkEndpointGroupsClient.create()) {
   *   ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest request =
   *       ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (NetworkEndpointWithHealthStatus element :
   *       globalNetworkEndpointGroupsClient.listNetworkEndpoints(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNetworkEndpointsPagedResponse listNetworkEndpoints(
      ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest request) {
    return listNetworkEndpointsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the network endpoints in the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalNetworkEndpointGroupsClient globalNetworkEndpointGroupsClient =
   *     GlobalNetworkEndpointGroupsClient.create()) {
   *   ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest request =
   *       ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<NetworkEndpointWithHealthStatus> future =
   *       globalNetworkEndpointGroupsClient.listNetworkEndpointsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (NetworkEndpointWithHealthStatus element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest, ListNetworkEndpointsPagedResponse>
      listNetworkEndpointsPagedCallable() {
    return stub.listNetworkEndpointsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the network endpoints in the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalNetworkEndpointGroupsClient globalNetworkEndpointGroupsClient =
   *     GlobalNetworkEndpointGroupsClient.create()) {
   *   ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest request =
   *       ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     NetworkEndpointGroupsListNetworkEndpoints response =
   *         globalNetworkEndpointGroupsClient.listNetworkEndpointsCallable().call(request);
   *     for (NetworkEndpointWithHealthStatus element : response.getItemsList()) {
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
          ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest,
          NetworkEndpointGroupsListNetworkEndpoints>
      listNetworkEndpointsCallable() {
    return stub.listNetworkEndpointsCallable();
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
          ListGlobalNetworkEndpointGroupsRequest,
          NetworkEndpointGroupList,
          NetworkEndpointGroup,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<
                ListGlobalNetworkEndpointGroupsRequest,
                NetworkEndpointGroupList,
                NetworkEndpointGroup>
            context,
        ApiFuture<NetworkEndpointGroupList> futureResponse) {
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
          ListGlobalNetworkEndpointGroupsRequest,
          NetworkEndpointGroupList,
          NetworkEndpointGroup,
          ListPage> {

    private ListPage(
        PageContext<
                ListGlobalNetworkEndpointGroupsRequest,
                NetworkEndpointGroupList,
                NetworkEndpointGroup>
            context,
        NetworkEndpointGroupList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<
                ListGlobalNetworkEndpointGroupsRequest,
                NetworkEndpointGroupList,
                NetworkEndpointGroup>
            context,
        NetworkEndpointGroupList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<
                ListGlobalNetworkEndpointGroupsRequest,
                NetworkEndpointGroupList,
                NetworkEndpointGroup>
            context,
        ApiFuture<NetworkEndpointGroupList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGlobalNetworkEndpointGroupsRequest,
          NetworkEndpointGroupList,
          NetworkEndpointGroup,
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

  public static class ListNetworkEndpointsPagedResponse
      extends AbstractPagedListResponse<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest,
          NetworkEndpointGroupsListNetworkEndpoints,
          NetworkEndpointWithHealthStatus,
          ListNetworkEndpointsPage,
          ListNetworkEndpointsFixedSizeCollection> {

    public static ApiFuture<ListNetworkEndpointsPagedResponse> createAsync(
        PageContext<
                ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest,
                NetworkEndpointGroupsListNetworkEndpoints,
                NetworkEndpointWithHealthStatus>
            context,
        ApiFuture<NetworkEndpointGroupsListNetworkEndpoints> futureResponse) {
      ApiFuture<ListNetworkEndpointsPage> futurePage =
          ListNetworkEndpointsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListNetworkEndpointsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListNetworkEndpointsPagedResponse(ListNetworkEndpointsPage page) {
      super(page, ListNetworkEndpointsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNetworkEndpointsPage
      extends AbstractPage<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest,
          NetworkEndpointGroupsListNetworkEndpoints,
          NetworkEndpointWithHealthStatus,
          ListNetworkEndpointsPage> {

    private ListNetworkEndpointsPage(
        PageContext<
                ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest,
                NetworkEndpointGroupsListNetworkEndpoints,
                NetworkEndpointWithHealthStatus>
            context,
        NetworkEndpointGroupsListNetworkEndpoints response) {
      super(context, response);
    }

    private static ListNetworkEndpointsPage createEmptyPage() {
      return new ListNetworkEndpointsPage(null, null);
    }

    @Override
    protected ListNetworkEndpointsPage createPage(
        PageContext<
                ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest,
                NetworkEndpointGroupsListNetworkEndpoints,
                NetworkEndpointWithHealthStatus>
            context,
        NetworkEndpointGroupsListNetworkEndpoints response) {
      return new ListNetworkEndpointsPage(context, response);
    }

    @Override
    public ApiFuture<ListNetworkEndpointsPage> createPageAsync(
        PageContext<
                ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest,
                NetworkEndpointGroupsListNetworkEndpoints,
                NetworkEndpointWithHealthStatus>
            context,
        ApiFuture<NetworkEndpointGroupsListNetworkEndpoints> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNetworkEndpointsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest,
          NetworkEndpointGroupsListNetworkEndpoints,
          NetworkEndpointWithHealthStatus,
          ListNetworkEndpointsPage,
          ListNetworkEndpointsFixedSizeCollection> {

    private ListNetworkEndpointsFixedSizeCollection(
        List<ListNetworkEndpointsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNetworkEndpointsFixedSizeCollection createEmptyCollection() {
      return new ListNetworkEndpointsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNetworkEndpointsFixedSizeCollection createCollection(
        List<ListNetworkEndpointsPage> pages, int collectionSize) {
      return new ListNetworkEndpointsFixedSizeCollection(pages, collectionSize);
    }
  }
}
