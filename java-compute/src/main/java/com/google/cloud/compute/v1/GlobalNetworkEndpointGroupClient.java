/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.GlobalNetworkEndpointGroupStub;
import com.google.cloud.compute.v1.stub.GlobalNetworkEndpointGroupStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (GlobalNetworkEndpointGroupClient globalNetworkEndpointGroupClient = GlobalNetworkEndpointGroupClient.create()) {
 *   ProjectGlobalNetworkEndpointGroupName networkEndpointGroup = ProjectGlobalNetworkEndpointGroupName.of("[PROJECT]", "[NETWORK_ENDPOINT_GROUP]");
 *   GlobalNetworkEndpointGroupsAttachEndpointsRequest globalNetworkEndpointGroupsAttachEndpointsRequestResource = GlobalNetworkEndpointGroupsAttachEndpointsRequest.newBuilder().build();
 *   Operation response = globalNetworkEndpointGroupClient.attachNetworkEndpointsGlobalNetworkEndpointGroup(networkEndpointGroup, globalNetworkEndpointGroupsAttachEndpointsRequestResource);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the globalNetworkEndpointGroupClient object to clean up
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
 * GlobalNetworkEndpointGroupSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * GlobalNetworkEndpointGroupSettings globalNetworkEndpointGroupSettings =
 *     GlobalNetworkEndpointGroupSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GlobalNetworkEndpointGroupClient globalNetworkEndpointGroupClient =
 *     GlobalNetworkEndpointGroupClient.create(globalNetworkEndpointGroupSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * GlobalNetworkEndpointGroupSettings globalNetworkEndpointGroupSettings =
 *     GlobalNetworkEndpointGroupSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GlobalNetworkEndpointGroupClient globalNetworkEndpointGroupClient =
 *     GlobalNetworkEndpointGroupClient.create(globalNetworkEndpointGroupSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class GlobalNetworkEndpointGroupClient implements BackgroundResource {
  private final GlobalNetworkEndpointGroupSettings settings;
  private final GlobalNetworkEndpointGroupStub stub;

  /** Constructs an instance of GlobalNetworkEndpointGroupClient with default settings. */
  public static final GlobalNetworkEndpointGroupClient create() throws IOException {
    return create(GlobalNetworkEndpointGroupSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of GlobalNetworkEndpointGroupClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final GlobalNetworkEndpointGroupClient create(
      GlobalNetworkEndpointGroupSettings settings) throws IOException {
    return new GlobalNetworkEndpointGroupClient(settings);
  }

  /**
   * Constructs an instance of GlobalNetworkEndpointGroupClient, using the given stub for making
   * calls. This is for advanced usage - prefer to use GlobalNetworkEndpointGroupSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final GlobalNetworkEndpointGroupClient create(GlobalNetworkEndpointGroupStub stub) {
    return new GlobalNetworkEndpointGroupClient(stub);
  }

  /**
   * Constructs an instance of GlobalNetworkEndpointGroupClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GlobalNetworkEndpointGroupClient(GlobalNetworkEndpointGroupSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((GlobalNetworkEndpointGroupStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected GlobalNetworkEndpointGroupClient(GlobalNetworkEndpointGroupStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final GlobalNetworkEndpointGroupSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public GlobalNetworkEndpointGroupStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Attach a network endpoint to the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalNetworkEndpointGroupClient globalNetworkEndpointGroupClient = GlobalNetworkEndpointGroupClient.create()) {
   *   ProjectGlobalNetworkEndpointGroupName networkEndpointGroup = ProjectGlobalNetworkEndpointGroupName.of("[PROJECT]", "[NETWORK_ENDPOINT_GROUP]");
   *   GlobalNetworkEndpointGroupsAttachEndpointsRequest globalNetworkEndpointGroupsAttachEndpointsRequestResource = GlobalNetworkEndpointGroupsAttachEndpointsRequest.newBuilder().build();
   *   Operation response = globalNetworkEndpointGroupClient.attachNetworkEndpointsGlobalNetworkEndpointGroup(networkEndpointGroup, globalNetworkEndpointGroupsAttachEndpointsRequestResource);
   * }
   * </code></pre>
   *
   * @param networkEndpointGroup The name of the network endpoint group where you are attaching
   *     network endpoints to. It should comply with RFC1035.
   * @param globalNetworkEndpointGroupsAttachEndpointsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation attachNetworkEndpointsGlobalNetworkEndpointGroup(
      ProjectGlobalNetworkEndpointGroupName networkEndpointGroup,
      GlobalNetworkEndpointGroupsAttachEndpointsRequest
          globalNetworkEndpointGroupsAttachEndpointsRequestResource) {
    AttachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest request =
        AttachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest.newBuilder()
            .setNetworkEndpointGroup(
                networkEndpointGroup == null ? null : networkEndpointGroup.toString())
            .setGlobalNetworkEndpointGroupsAttachEndpointsRequestResource(
                globalNetworkEndpointGroupsAttachEndpointsRequestResource)
            .build();
    return attachNetworkEndpointsGlobalNetworkEndpointGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Attach a network endpoint to the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalNetworkEndpointGroupClient globalNetworkEndpointGroupClient = GlobalNetworkEndpointGroupClient.create()) {
   *   ProjectGlobalNetworkEndpointGroupName networkEndpointGroup = ProjectGlobalNetworkEndpointGroupName.of("[PROJECT]", "[NETWORK_ENDPOINT_GROUP]");
   *   GlobalNetworkEndpointGroupsAttachEndpointsRequest globalNetworkEndpointGroupsAttachEndpointsRequestResource = GlobalNetworkEndpointGroupsAttachEndpointsRequest.newBuilder().build();
   *   Operation response = globalNetworkEndpointGroupClient.attachNetworkEndpointsGlobalNetworkEndpointGroup(networkEndpointGroup.toString(), globalNetworkEndpointGroupsAttachEndpointsRequestResource);
   * }
   * </code></pre>
   *
   * @param networkEndpointGroup The name of the network endpoint group where you are attaching
   *     network endpoints to. It should comply with RFC1035.
   * @param globalNetworkEndpointGroupsAttachEndpointsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation attachNetworkEndpointsGlobalNetworkEndpointGroup(
      String networkEndpointGroup,
      GlobalNetworkEndpointGroupsAttachEndpointsRequest
          globalNetworkEndpointGroupsAttachEndpointsRequestResource) {
    AttachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest request =
        AttachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest.newBuilder()
            .setNetworkEndpointGroup(networkEndpointGroup)
            .setGlobalNetworkEndpointGroupsAttachEndpointsRequestResource(
                globalNetworkEndpointGroupsAttachEndpointsRequestResource)
            .build();
    return attachNetworkEndpointsGlobalNetworkEndpointGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Attach a network endpoint to the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalNetworkEndpointGroupClient globalNetworkEndpointGroupClient = GlobalNetworkEndpointGroupClient.create()) {
   *   String formattedNetworkEndpointGroup = ProjectGlobalNetworkEndpointGroupName.format("[PROJECT]", "[NETWORK_ENDPOINT_GROUP]");
   *   GlobalNetworkEndpointGroupsAttachEndpointsRequest globalNetworkEndpointGroupsAttachEndpointsRequestResource = GlobalNetworkEndpointGroupsAttachEndpointsRequest.newBuilder().build();
   *   AttachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest request = AttachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest.newBuilder()
   *     .setNetworkEndpointGroup(formattedNetworkEndpointGroup)
   *     .setGlobalNetworkEndpointGroupsAttachEndpointsRequestResource(globalNetworkEndpointGroupsAttachEndpointsRequestResource)
   *     .build();
   *   Operation response = globalNetworkEndpointGroupClient.attachNetworkEndpointsGlobalNetworkEndpointGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation attachNetworkEndpointsGlobalNetworkEndpointGroup(
      AttachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest request) {
    return attachNetworkEndpointsGlobalNetworkEndpointGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Attach a network endpoint to the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalNetworkEndpointGroupClient globalNetworkEndpointGroupClient = GlobalNetworkEndpointGroupClient.create()) {
   *   String formattedNetworkEndpointGroup = ProjectGlobalNetworkEndpointGroupName.format("[PROJECT]", "[NETWORK_ENDPOINT_GROUP]");
   *   GlobalNetworkEndpointGroupsAttachEndpointsRequest globalNetworkEndpointGroupsAttachEndpointsRequestResource = GlobalNetworkEndpointGroupsAttachEndpointsRequest.newBuilder().build();
   *   AttachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest request = AttachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest.newBuilder()
   *     .setNetworkEndpointGroup(formattedNetworkEndpointGroup)
   *     .setGlobalNetworkEndpointGroupsAttachEndpointsRequestResource(globalNetworkEndpointGroupsAttachEndpointsRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = globalNetworkEndpointGroupClient.attachNetworkEndpointsGlobalNetworkEndpointGroupCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<AttachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest, Operation>
      attachNetworkEndpointsGlobalNetworkEndpointGroupCallable() {
    return stub.attachNetworkEndpointsGlobalNetworkEndpointGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified network endpoint group.Note that the NEG cannot be deleted if there are
   * backend services referencing it.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalNetworkEndpointGroupClient globalNetworkEndpointGroupClient = GlobalNetworkEndpointGroupClient.create()) {
   *   ProjectGlobalNetworkEndpointGroupName networkEndpointGroup = ProjectGlobalNetworkEndpointGroupName.of("[PROJECT]", "[NETWORK_ENDPOINT_GROUP]");
   *   Operation response = globalNetworkEndpointGroupClient.deleteGlobalNetworkEndpointGroup(networkEndpointGroup);
   * }
   * </code></pre>
   *
   * @param networkEndpointGroup The name of the network endpoint group to delete. It should comply
   *     with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteGlobalNetworkEndpointGroup(
      ProjectGlobalNetworkEndpointGroupName networkEndpointGroup) {
    DeleteGlobalNetworkEndpointGroupHttpRequest request =
        DeleteGlobalNetworkEndpointGroupHttpRequest.newBuilder()
            .setNetworkEndpointGroup(
                networkEndpointGroup == null ? null : networkEndpointGroup.toString())
            .build();
    return deleteGlobalNetworkEndpointGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified network endpoint group.Note that the NEG cannot be deleted if there are
   * backend services referencing it.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalNetworkEndpointGroupClient globalNetworkEndpointGroupClient = GlobalNetworkEndpointGroupClient.create()) {
   *   ProjectGlobalNetworkEndpointGroupName networkEndpointGroup = ProjectGlobalNetworkEndpointGroupName.of("[PROJECT]", "[NETWORK_ENDPOINT_GROUP]");
   *   Operation response = globalNetworkEndpointGroupClient.deleteGlobalNetworkEndpointGroup(networkEndpointGroup.toString());
   * }
   * </code></pre>
   *
   * @param networkEndpointGroup The name of the network endpoint group to delete. It should comply
   *     with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteGlobalNetworkEndpointGroup(String networkEndpointGroup) {
    DeleteGlobalNetworkEndpointGroupHttpRequest request =
        DeleteGlobalNetworkEndpointGroupHttpRequest.newBuilder()
            .setNetworkEndpointGroup(networkEndpointGroup)
            .build();
    return deleteGlobalNetworkEndpointGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified network endpoint group.Note that the NEG cannot be deleted if there are
   * backend services referencing it.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalNetworkEndpointGroupClient globalNetworkEndpointGroupClient = GlobalNetworkEndpointGroupClient.create()) {
   *   String formattedNetworkEndpointGroup = ProjectGlobalNetworkEndpointGroupName.format("[PROJECT]", "[NETWORK_ENDPOINT_GROUP]");
   *   DeleteGlobalNetworkEndpointGroupHttpRequest request = DeleteGlobalNetworkEndpointGroupHttpRequest.newBuilder()
   *     .setNetworkEndpointGroup(formattedNetworkEndpointGroup)
   *     .build();
   *   Operation response = globalNetworkEndpointGroupClient.deleteGlobalNetworkEndpointGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteGlobalNetworkEndpointGroup(
      DeleteGlobalNetworkEndpointGroupHttpRequest request) {
    return deleteGlobalNetworkEndpointGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified network endpoint group.Note that the NEG cannot be deleted if there are
   * backend services referencing it.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalNetworkEndpointGroupClient globalNetworkEndpointGroupClient = GlobalNetworkEndpointGroupClient.create()) {
   *   String formattedNetworkEndpointGroup = ProjectGlobalNetworkEndpointGroupName.format("[PROJECT]", "[NETWORK_ENDPOINT_GROUP]");
   *   DeleteGlobalNetworkEndpointGroupHttpRequest request = DeleteGlobalNetworkEndpointGroupHttpRequest.newBuilder()
   *     .setNetworkEndpointGroup(formattedNetworkEndpointGroup)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = globalNetworkEndpointGroupClient.deleteGlobalNetworkEndpointGroupCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteGlobalNetworkEndpointGroupHttpRequest, Operation>
      deleteGlobalNetworkEndpointGroupCallable() {
    return stub.deleteGlobalNetworkEndpointGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Detach the network endpoint from the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalNetworkEndpointGroupClient globalNetworkEndpointGroupClient = GlobalNetworkEndpointGroupClient.create()) {
   *   ProjectGlobalNetworkEndpointGroupName networkEndpointGroup = ProjectGlobalNetworkEndpointGroupName.of("[PROJECT]", "[NETWORK_ENDPOINT_GROUP]");
   *   GlobalNetworkEndpointGroupsDetachEndpointsRequest globalNetworkEndpointGroupsDetachEndpointsRequestResource = GlobalNetworkEndpointGroupsDetachEndpointsRequest.newBuilder().build();
   *   Operation response = globalNetworkEndpointGroupClient.detachNetworkEndpointsGlobalNetworkEndpointGroup(networkEndpointGroup, globalNetworkEndpointGroupsDetachEndpointsRequestResource);
   * }
   * </code></pre>
   *
   * @param networkEndpointGroup The name of the network endpoint group where you are removing
   *     network endpoints. It should comply with RFC1035.
   * @param globalNetworkEndpointGroupsDetachEndpointsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation detachNetworkEndpointsGlobalNetworkEndpointGroup(
      ProjectGlobalNetworkEndpointGroupName networkEndpointGroup,
      GlobalNetworkEndpointGroupsDetachEndpointsRequest
          globalNetworkEndpointGroupsDetachEndpointsRequestResource) {
    DetachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest request =
        DetachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest.newBuilder()
            .setNetworkEndpointGroup(
                networkEndpointGroup == null ? null : networkEndpointGroup.toString())
            .setGlobalNetworkEndpointGroupsDetachEndpointsRequestResource(
                globalNetworkEndpointGroupsDetachEndpointsRequestResource)
            .build();
    return detachNetworkEndpointsGlobalNetworkEndpointGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Detach the network endpoint from the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalNetworkEndpointGroupClient globalNetworkEndpointGroupClient = GlobalNetworkEndpointGroupClient.create()) {
   *   ProjectGlobalNetworkEndpointGroupName networkEndpointGroup = ProjectGlobalNetworkEndpointGroupName.of("[PROJECT]", "[NETWORK_ENDPOINT_GROUP]");
   *   GlobalNetworkEndpointGroupsDetachEndpointsRequest globalNetworkEndpointGroupsDetachEndpointsRequestResource = GlobalNetworkEndpointGroupsDetachEndpointsRequest.newBuilder().build();
   *   Operation response = globalNetworkEndpointGroupClient.detachNetworkEndpointsGlobalNetworkEndpointGroup(networkEndpointGroup.toString(), globalNetworkEndpointGroupsDetachEndpointsRequestResource);
   * }
   * </code></pre>
   *
   * @param networkEndpointGroup The name of the network endpoint group where you are removing
   *     network endpoints. It should comply with RFC1035.
   * @param globalNetworkEndpointGroupsDetachEndpointsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation detachNetworkEndpointsGlobalNetworkEndpointGroup(
      String networkEndpointGroup,
      GlobalNetworkEndpointGroupsDetachEndpointsRequest
          globalNetworkEndpointGroupsDetachEndpointsRequestResource) {
    DetachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest request =
        DetachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest.newBuilder()
            .setNetworkEndpointGroup(networkEndpointGroup)
            .setGlobalNetworkEndpointGroupsDetachEndpointsRequestResource(
                globalNetworkEndpointGroupsDetachEndpointsRequestResource)
            .build();
    return detachNetworkEndpointsGlobalNetworkEndpointGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Detach the network endpoint from the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalNetworkEndpointGroupClient globalNetworkEndpointGroupClient = GlobalNetworkEndpointGroupClient.create()) {
   *   String formattedNetworkEndpointGroup = ProjectGlobalNetworkEndpointGroupName.format("[PROJECT]", "[NETWORK_ENDPOINT_GROUP]");
   *   GlobalNetworkEndpointGroupsDetachEndpointsRequest globalNetworkEndpointGroupsDetachEndpointsRequestResource = GlobalNetworkEndpointGroupsDetachEndpointsRequest.newBuilder().build();
   *   DetachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest request = DetachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest.newBuilder()
   *     .setNetworkEndpointGroup(formattedNetworkEndpointGroup)
   *     .setGlobalNetworkEndpointGroupsDetachEndpointsRequestResource(globalNetworkEndpointGroupsDetachEndpointsRequestResource)
   *     .build();
   *   Operation response = globalNetworkEndpointGroupClient.detachNetworkEndpointsGlobalNetworkEndpointGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation detachNetworkEndpointsGlobalNetworkEndpointGroup(
      DetachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest request) {
    return detachNetworkEndpointsGlobalNetworkEndpointGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Detach the network endpoint from the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalNetworkEndpointGroupClient globalNetworkEndpointGroupClient = GlobalNetworkEndpointGroupClient.create()) {
   *   String formattedNetworkEndpointGroup = ProjectGlobalNetworkEndpointGroupName.format("[PROJECT]", "[NETWORK_ENDPOINT_GROUP]");
   *   GlobalNetworkEndpointGroupsDetachEndpointsRequest globalNetworkEndpointGroupsDetachEndpointsRequestResource = GlobalNetworkEndpointGroupsDetachEndpointsRequest.newBuilder().build();
   *   DetachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest request = DetachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest.newBuilder()
   *     .setNetworkEndpointGroup(formattedNetworkEndpointGroup)
   *     .setGlobalNetworkEndpointGroupsDetachEndpointsRequestResource(globalNetworkEndpointGroupsDetachEndpointsRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = globalNetworkEndpointGroupClient.detachNetworkEndpointsGlobalNetworkEndpointGroupCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DetachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest, Operation>
      detachNetworkEndpointsGlobalNetworkEndpointGroupCallable() {
    return stub.detachNetworkEndpointsGlobalNetworkEndpointGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified network endpoint group. Gets a list of available network endpoint groups
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalNetworkEndpointGroupClient globalNetworkEndpointGroupClient = GlobalNetworkEndpointGroupClient.create()) {
   *   ProjectGlobalNetworkEndpointGroupName networkEndpointGroup = ProjectGlobalNetworkEndpointGroupName.of("[PROJECT]", "[NETWORK_ENDPOINT_GROUP]");
   *   NetworkEndpointGroup response = globalNetworkEndpointGroupClient.getGlobalNetworkEndpointGroup(networkEndpointGroup);
   * }
   * </code></pre>
   *
   * @param networkEndpointGroup The name of the network endpoint group. It should comply with
   *     RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final NetworkEndpointGroup getGlobalNetworkEndpointGroup(
      ProjectGlobalNetworkEndpointGroupName networkEndpointGroup) {
    GetGlobalNetworkEndpointGroupHttpRequest request =
        GetGlobalNetworkEndpointGroupHttpRequest.newBuilder()
            .setNetworkEndpointGroup(
                networkEndpointGroup == null ? null : networkEndpointGroup.toString())
            .build();
    return getGlobalNetworkEndpointGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified network endpoint group. Gets a list of available network endpoint groups
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalNetworkEndpointGroupClient globalNetworkEndpointGroupClient = GlobalNetworkEndpointGroupClient.create()) {
   *   ProjectGlobalNetworkEndpointGroupName networkEndpointGroup = ProjectGlobalNetworkEndpointGroupName.of("[PROJECT]", "[NETWORK_ENDPOINT_GROUP]");
   *   NetworkEndpointGroup response = globalNetworkEndpointGroupClient.getGlobalNetworkEndpointGroup(networkEndpointGroup.toString());
   * }
   * </code></pre>
   *
   * @param networkEndpointGroup The name of the network endpoint group. It should comply with
   *     RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final NetworkEndpointGroup getGlobalNetworkEndpointGroup(String networkEndpointGroup) {
    GetGlobalNetworkEndpointGroupHttpRequest request =
        GetGlobalNetworkEndpointGroupHttpRequest.newBuilder()
            .setNetworkEndpointGroup(networkEndpointGroup)
            .build();
    return getGlobalNetworkEndpointGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified network endpoint group. Gets a list of available network endpoint groups
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalNetworkEndpointGroupClient globalNetworkEndpointGroupClient = GlobalNetworkEndpointGroupClient.create()) {
   *   String formattedNetworkEndpointGroup = ProjectGlobalNetworkEndpointGroupName.format("[PROJECT]", "[NETWORK_ENDPOINT_GROUP]");
   *   GetGlobalNetworkEndpointGroupHttpRequest request = GetGlobalNetworkEndpointGroupHttpRequest.newBuilder()
   *     .setNetworkEndpointGroup(formattedNetworkEndpointGroup)
   *     .build();
   *   NetworkEndpointGroup response = globalNetworkEndpointGroupClient.getGlobalNetworkEndpointGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final NetworkEndpointGroup getGlobalNetworkEndpointGroup(
      GetGlobalNetworkEndpointGroupHttpRequest request) {
    return getGlobalNetworkEndpointGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified network endpoint group. Gets a list of available network endpoint groups
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalNetworkEndpointGroupClient globalNetworkEndpointGroupClient = GlobalNetworkEndpointGroupClient.create()) {
   *   String formattedNetworkEndpointGroup = ProjectGlobalNetworkEndpointGroupName.format("[PROJECT]", "[NETWORK_ENDPOINT_GROUP]");
   *   GetGlobalNetworkEndpointGroupHttpRequest request = GetGlobalNetworkEndpointGroupHttpRequest.newBuilder()
   *     .setNetworkEndpointGroup(formattedNetworkEndpointGroup)
   *     .build();
   *   ApiFuture&lt;NetworkEndpointGroup&gt; future = globalNetworkEndpointGroupClient.getGlobalNetworkEndpointGroupCallable().futureCall(request);
   *   // Do something
   *   NetworkEndpointGroup response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetGlobalNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>
      getGlobalNetworkEndpointGroupCallable() {
    return stub.getGlobalNetworkEndpointGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a network endpoint group in the specified project using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalNetworkEndpointGroupClient globalNetworkEndpointGroupClient = GlobalNetworkEndpointGroupClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   NetworkEndpointGroup networkEndpointGroupResource = NetworkEndpointGroup.newBuilder().build();
   *   Operation response = globalNetworkEndpointGroupClient.insertGlobalNetworkEndpointGroup(project, networkEndpointGroupResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param networkEndpointGroupResource Represents a collection of network endpoints.
   *     <p>For more information read Network endpoint groups overview. (== resource_for
   *     {$api_version}.networkEndpointGroups ==) Next ID: 21
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertGlobalNetworkEndpointGroup(
      ProjectName project, NetworkEndpointGroup networkEndpointGroupResource) {
    InsertGlobalNetworkEndpointGroupHttpRequest request =
        InsertGlobalNetworkEndpointGroupHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .setNetworkEndpointGroupResource(networkEndpointGroupResource)
            .build();
    return insertGlobalNetworkEndpointGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a network endpoint group in the specified project using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalNetworkEndpointGroupClient globalNetworkEndpointGroupClient = GlobalNetworkEndpointGroupClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   NetworkEndpointGroup networkEndpointGroupResource = NetworkEndpointGroup.newBuilder().build();
   *   Operation response = globalNetworkEndpointGroupClient.insertGlobalNetworkEndpointGroup(project.toString(), networkEndpointGroupResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param networkEndpointGroupResource Represents a collection of network endpoints.
   *     <p>For more information read Network endpoint groups overview. (== resource_for
   *     {$api_version}.networkEndpointGroups ==) Next ID: 21
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertGlobalNetworkEndpointGroup(
      String project, NetworkEndpointGroup networkEndpointGroupResource) {
    InsertGlobalNetworkEndpointGroupHttpRequest request =
        InsertGlobalNetworkEndpointGroupHttpRequest.newBuilder()
            .setProject(project)
            .setNetworkEndpointGroupResource(networkEndpointGroupResource)
            .build();
    return insertGlobalNetworkEndpointGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a network endpoint group in the specified project using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalNetworkEndpointGroupClient globalNetworkEndpointGroupClient = GlobalNetworkEndpointGroupClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   NetworkEndpointGroup networkEndpointGroupResource = NetworkEndpointGroup.newBuilder().build();
   *   InsertGlobalNetworkEndpointGroupHttpRequest request = InsertGlobalNetworkEndpointGroupHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .setNetworkEndpointGroupResource(networkEndpointGroupResource)
   *     .build();
   *   Operation response = globalNetworkEndpointGroupClient.insertGlobalNetworkEndpointGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertGlobalNetworkEndpointGroup(
      InsertGlobalNetworkEndpointGroupHttpRequest request) {
    return insertGlobalNetworkEndpointGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a network endpoint group in the specified project using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalNetworkEndpointGroupClient globalNetworkEndpointGroupClient = GlobalNetworkEndpointGroupClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   NetworkEndpointGroup networkEndpointGroupResource = NetworkEndpointGroup.newBuilder().build();
   *   InsertGlobalNetworkEndpointGroupHttpRequest request = InsertGlobalNetworkEndpointGroupHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .setNetworkEndpointGroupResource(networkEndpointGroupResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = globalNetworkEndpointGroupClient.insertGlobalNetworkEndpointGroupCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertGlobalNetworkEndpointGroupHttpRequest, Operation>
      insertGlobalNetworkEndpointGroupCallable() {
    return stub.insertGlobalNetworkEndpointGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of network endpoint groups that are located in the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalNetworkEndpointGroupClient globalNetworkEndpointGroupClient = GlobalNetworkEndpointGroupClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (NetworkEndpointGroup element : globalNetworkEndpointGroupClient.listGlobalNetworkEndpointGroups(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListGlobalNetworkEndpointGroupsPagedResponse listGlobalNetworkEndpointGroups(
      ProjectName project) {
    ListGlobalNetworkEndpointGroupsHttpRequest request =
        ListGlobalNetworkEndpointGroupsHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return listGlobalNetworkEndpointGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of network endpoint groups that are located in the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalNetworkEndpointGroupClient globalNetworkEndpointGroupClient = GlobalNetworkEndpointGroupClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (NetworkEndpointGroup element : globalNetworkEndpointGroupClient.listGlobalNetworkEndpointGroups(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListGlobalNetworkEndpointGroupsPagedResponse listGlobalNetworkEndpointGroups(
      String project) {
    ListGlobalNetworkEndpointGroupsHttpRequest request =
        ListGlobalNetworkEndpointGroupsHttpRequest.newBuilder().setProject(project).build();
    return listGlobalNetworkEndpointGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of network endpoint groups that are located in the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalNetworkEndpointGroupClient globalNetworkEndpointGroupClient = GlobalNetworkEndpointGroupClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   ListGlobalNetworkEndpointGroupsHttpRequest request = ListGlobalNetworkEndpointGroupsHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   for (NetworkEndpointGroup element : globalNetworkEndpointGroupClient.listGlobalNetworkEndpointGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListGlobalNetworkEndpointGroupsPagedResponse listGlobalNetworkEndpointGroups(
      ListGlobalNetworkEndpointGroupsHttpRequest request) {
    return listGlobalNetworkEndpointGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of network endpoint groups that are located in the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalNetworkEndpointGroupClient globalNetworkEndpointGroupClient = GlobalNetworkEndpointGroupClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   ListGlobalNetworkEndpointGroupsHttpRequest request = ListGlobalNetworkEndpointGroupsHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   ApiFuture&lt;ListGlobalNetworkEndpointGroupsPagedResponse&gt; future = globalNetworkEndpointGroupClient.listGlobalNetworkEndpointGroupsPagedCallable().futureCall(request);
   *   // Do something
   *   for (NetworkEndpointGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          ListGlobalNetworkEndpointGroupsHttpRequest, ListGlobalNetworkEndpointGroupsPagedResponse>
      listGlobalNetworkEndpointGroupsPagedCallable() {
    return stub.listGlobalNetworkEndpointGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of network endpoint groups that are located in the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalNetworkEndpointGroupClient globalNetworkEndpointGroupClient = GlobalNetworkEndpointGroupClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   ListGlobalNetworkEndpointGroupsHttpRequest request = ListGlobalNetworkEndpointGroupsHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   while (true) {
   *     NetworkEndpointGroupList response = globalNetworkEndpointGroupClient.listGlobalNetworkEndpointGroupsCallable().call(request);
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
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListGlobalNetworkEndpointGroupsHttpRequest, NetworkEndpointGroupList>
      listGlobalNetworkEndpointGroupsCallable() {
    return stub.listGlobalNetworkEndpointGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the network endpoints in the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalNetworkEndpointGroupClient globalNetworkEndpointGroupClient = GlobalNetworkEndpointGroupClient.create()) {
   *   ProjectGlobalNetworkEndpointGroupName networkEndpointGroup = ProjectGlobalNetworkEndpointGroupName.of("[PROJECT]", "[NETWORK_ENDPOINT_GROUP]");
   *   for (NetworkEndpointWithHealthStatus element : globalNetworkEndpointGroupClient.listNetworkEndpointsGlobalNetworkEndpointGroups(networkEndpointGroup).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param networkEndpointGroup The name of the network endpoint group from which you want to
   *     generate a list of included network endpoints. It should comply with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListNetworkEndpointsGlobalNetworkEndpointGroupsPagedResponse
      listNetworkEndpointsGlobalNetworkEndpointGroups(
          ProjectGlobalNetworkEndpointGroupName networkEndpointGroup) {
    ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest request =
        ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest.newBuilder()
            .setNetworkEndpointGroup(
                networkEndpointGroup == null ? null : networkEndpointGroup.toString())
            .build();
    return listNetworkEndpointsGlobalNetworkEndpointGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the network endpoints in the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalNetworkEndpointGroupClient globalNetworkEndpointGroupClient = GlobalNetworkEndpointGroupClient.create()) {
   *   ProjectGlobalNetworkEndpointGroupName networkEndpointGroup = ProjectGlobalNetworkEndpointGroupName.of("[PROJECT]", "[NETWORK_ENDPOINT_GROUP]");
   *   for (NetworkEndpointWithHealthStatus element : globalNetworkEndpointGroupClient.listNetworkEndpointsGlobalNetworkEndpointGroups(networkEndpointGroup.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param networkEndpointGroup The name of the network endpoint group from which you want to
   *     generate a list of included network endpoints. It should comply with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListNetworkEndpointsGlobalNetworkEndpointGroupsPagedResponse
      listNetworkEndpointsGlobalNetworkEndpointGroups(String networkEndpointGroup) {
    ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest request =
        ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest.newBuilder()
            .setNetworkEndpointGroup(networkEndpointGroup)
            .build();
    return listNetworkEndpointsGlobalNetworkEndpointGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the network endpoints in the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalNetworkEndpointGroupClient globalNetworkEndpointGroupClient = GlobalNetworkEndpointGroupClient.create()) {
   *   String formattedNetworkEndpointGroup = ProjectGlobalNetworkEndpointGroupName.format("[PROJECT]", "[NETWORK_ENDPOINT_GROUP]");
   *   ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest request = ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest.newBuilder()
   *     .setNetworkEndpointGroup(formattedNetworkEndpointGroup)
   *     .build();
   *   for (NetworkEndpointWithHealthStatus element : globalNetworkEndpointGroupClient.listNetworkEndpointsGlobalNetworkEndpointGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListNetworkEndpointsGlobalNetworkEndpointGroupsPagedResponse
      listNetworkEndpointsGlobalNetworkEndpointGroups(
          ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest request) {
    return listNetworkEndpointsGlobalNetworkEndpointGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the network endpoints in the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalNetworkEndpointGroupClient globalNetworkEndpointGroupClient = GlobalNetworkEndpointGroupClient.create()) {
   *   String formattedNetworkEndpointGroup = ProjectGlobalNetworkEndpointGroupName.format("[PROJECT]", "[NETWORK_ENDPOINT_GROUP]");
   *   ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest request = ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest.newBuilder()
   *     .setNetworkEndpointGroup(formattedNetworkEndpointGroup)
   *     .build();
   *   ApiFuture&lt;ListNetworkEndpointsGlobalNetworkEndpointGroupsPagedResponse&gt; future = globalNetworkEndpointGroupClient.listNetworkEndpointsGlobalNetworkEndpointGroupsPagedCallable().futureCall(request);
   *   // Do something
   *   for (NetworkEndpointWithHealthStatus element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest,
          ListNetworkEndpointsGlobalNetworkEndpointGroupsPagedResponse>
      listNetworkEndpointsGlobalNetworkEndpointGroupsPagedCallable() {
    return stub.listNetworkEndpointsGlobalNetworkEndpointGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the network endpoints in the specified network endpoint group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalNetworkEndpointGroupClient globalNetworkEndpointGroupClient = GlobalNetworkEndpointGroupClient.create()) {
   *   String formattedNetworkEndpointGroup = ProjectGlobalNetworkEndpointGroupName.format("[PROJECT]", "[NETWORK_ENDPOINT_GROUP]");
   *   ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest request = ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest.newBuilder()
   *     .setNetworkEndpointGroup(formattedNetworkEndpointGroup)
   *     .build();
   *   while (true) {
   *     NetworkEndpointGroupsListNetworkEndpoints response = globalNetworkEndpointGroupClient.listNetworkEndpointsGlobalNetworkEndpointGroupsCallable().call(request);
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
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupsListNetworkEndpoints>
      listNetworkEndpointsGlobalNetworkEndpointGroupsCallable() {
    return stub.listNetworkEndpointsGlobalNetworkEndpointGroupsCallable();
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

  public static class ListGlobalNetworkEndpointGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListGlobalNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupList,
          NetworkEndpointGroup,
          ListGlobalNetworkEndpointGroupsPage,
          ListGlobalNetworkEndpointGroupsFixedSizeCollection> {

    public static ApiFuture<ListGlobalNetworkEndpointGroupsPagedResponse> createAsync(
        PageContext<
                ListGlobalNetworkEndpointGroupsHttpRequest,
                NetworkEndpointGroupList,
                NetworkEndpointGroup>
            context,
        ApiFuture<NetworkEndpointGroupList> futureResponse) {
      ApiFuture<ListGlobalNetworkEndpointGroupsPage> futurePage =
          ListGlobalNetworkEndpointGroupsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              ListGlobalNetworkEndpointGroupsPage, ListGlobalNetworkEndpointGroupsPagedResponse>() {
            @Override
            public ListGlobalNetworkEndpointGroupsPagedResponse apply(
                ListGlobalNetworkEndpointGroupsPage input) {
              return new ListGlobalNetworkEndpointGroupsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListGlobalNetworkEndpointGroupsPagedResponse(ListGlobalNetworkEndpointGroupsPage page) {
      super(page, ListGlobalNetworkEndpointGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGlobalNetworkEndpointGroupsPage
      extends AbstractPage<
          ListGlobalNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupList,
          NetworkEndpointGroup,
          ListGlobalNetworkEndpointGroupsPage> {

    private ListGlobalNetworkEndpointGroupsPage(
        PageContext<
                ListGlobalNetworkEndpointGroupsHttpRequest,
                NetworkEndpointGroupList,
                NetworkEndpointGroup>
            context,
        NetworkEndpointGroupList response) {
      super(context, response);
    }

    private static ListGlobalNetworkEndpointGroupsPage createEmptyPage() {
      return new ListGlobalNetworkEndpointGroupsPage(null, null);
    }

    @Override
    protected ListGlobalNetworkEndpointGroupsPage createPage(
        PageContext<
                ListGlobalNetworkEndpointGroupsHttpRequest,
                NetworkEndpointGroupList,
                NetworkEndpointGroup>
            context,
        NetworkEndpointGroupList response) {
      return new ListGlobalNetworkEndpointGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListGlobalNetworkEndpointGroupsPage> createPageAsync(
        PageContext<
                ListGlobalNetworkEndpointGroupsHttpRequest,
                NetworkEndpointGroupList,
                NetworkEndpointGroup>
            context,
        ApiFuture<NetworkEndpointGroupList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGlobalNetworkEndpointGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGlobalNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupList,
          NetworkEndpointGroup,
          ListGlobalNetworkEndpointGroupsPage,
          ListGlobalNetworkEndpointGroupsFixedSizeCollection> {

    private ListGlobalNetworkEndpointGroupsFixedSizeCollection(
        List<ListGlobalNetworkEndpointGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGlobalNetworkEndpointGroupsFixedSizeCollection createEmptyCollection() {
      return new ListGlobalNetworkEndpointGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGlobalNetworkEndpointGroupsFixedSizeCollection createCollection(
        List<ListGlobalNetworkEndpointGroupsPage> pages, int collectionSize) {
      return new ListGlobalNetworkEndpointGroupsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListNetworkEndpointsGlobalNetworkEndpointGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupsListNetworkEndpoints,
          NetworkEndpointWithHealthStatus,
          ListNetworkEndpointsGlobalNetworkEndpointGroupsPage,
          ListNetworkEndpointsGlobalNetworkEndpointGroupsFixedSizeCollection> {

    public static ApiFuture<ListNetworkEndpointsGlobalNetworkEndpointGroupsPagedResponse>
        createAsync(
            PageContext<
                    ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest,
                    NetworkEndpointGroupsListNetworkEndpoints,
                    NetworkEndpointWithHealthStatus>
                context,
            ApiFuture<NetworkEndpointGroupsListNetworkEndpoints> futureResponse) {
      ApiFuture<ListNetworkEndpointsGlobalNetworkEndpointGroupsPage> futurePage =
          ListNetworkEndpointsGlobalNetworkEndpointGroupsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              ListNetworkEndpointsGlobalNetworkEndpointGroupsPage,
              ListNetworkEndpointsGlobalNetworkEndpointGroupsPagedResponse>() {
            @Override
            public ListNetworkEndpointsGlobalNetworkEndpointGroupsPagedResponse apply(
                ListNetworkEndpointsGlobalNetworkEndpointGroupsPage input) {
              return new ListNetworkEndpointsGlobalNetworkEndpointGroupsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListNetworkEndpointsGlobalNetworkEndpointGroupsPagedResponse(
        ListNetworkEndpointsGlobalNetworkEndpointGroupsPage page) {
      super(
          page,
          ListNetworkEndpointsGlobalNetworkEndpointGroupsFixedSizeCollection
              .createEmptyCollection());
    }
  }

  public static class ListNetworkEndpointsGlobalNetworkEndpointGroupsPage
      extends AbstractPage<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupsListNetworkEndpoints,
          NetworkEndpointWithHealthStatus,
          ListNetworkEndpointsGlobalNetworkEndpointGroupsPage> {

    private ListNetworkEndpointsGlobalNetworkEndpointGroupsPage(
        PageContext<
                ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest,
                NetworkEndpointGroupsListNetworkEndpoints,
                NetworkEndpointWithHealthStatus>
            context,
        NetworkEndpointGroupsListNetworkEndpoints response) {
      super(context, response);
    }

    private static ListNetworkEndpointsGlobalNetworkEndpointGroupsPage createEmptyPage() {
      return new ListNetworkEndpointsGlobalNetworkEndpointGroupsPage(null, null);
    }

    @Override
    protected ListNetworkEndpointsGlobalNetworkEndpointGroupsPage createPage(
        PageContext<
                ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest,
                NetworkEndpointGroupsListNetworkEndpoints,
                NetworkEndpointWithHealthStatus>
            context,
        NetworkEndpointGroupsListNetworkEndpoints response) {
      return new ListNetworkEndpointsGlobalNetworkEndpointGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListNetworkEndpointsGlobalNetworkEndpointGroupsPage> createPageAsync(
        PageContext<
                ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest,
                NetworkEndpointGroupsListNetworkEndpoints,
                NetworkEndpointWithHealthStatus>
            context,
        ApiFuture<NetworkEndpointGroupsListNetworkEndpoints> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNetworkEndpointsGlobalNetworkEndpointGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupsListNetworkEndpoints,
          NetworkEndpointWithHealthStatus,
          ListNetworkEndpointsGlobalNetworkEndpointGroupsPage,
          ListNetworkEndpointsGlobalNetworkEndpointGroupsFixedSizeCollection> {

    private ListNetworkEndpointsGlobalNetworkEndpointGroupsFixedSizeCollection(
        List<ListNetworkEndpointsGlobalNetworkEndpointGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNetworkEndpointsGlobalNetworkEndpointGroupsFixedSizeCollection
        createEmptyCollection() {
      return new ListNetworkEndpointsGlobalNetworkEndpointGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNetworkEndpointsGlobalNetworkEndpointGroupsFixedSizeCollection createCollection(
        List<ListNetworkEndpointsGlobalNetworkEndpointGroupsPage> pages, int collectionSize) {
      return new ListNetworkEndpointsGlobalNetworkEndpointGroupsFixedSizeCollection(
          pages, collectionSize);
    }
  }
}
