/*
 * Copyright 2017, Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.errorreporting.v1beta1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.errorreporting.v1beta1.stub.ErrorGroupServiceStub;
import com.google.devtools.clouderrorreporting.v1beta1.ErrorGroup;
import com.google.devtools.clouderrorreporting.v1beta1.GetGroupRequest;
import com.google.devtools.clouderrorreporting.v1beta1.GroupName;
import com.google.devtools.clouderrorreporting.v1beta1.UpdateGroupRequest;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Service for retrieving and updating individual error groups.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (ErrorGroupServiceClient errorGroupServiceClient = ErrorGroupServiceClient.create()) {
 *   GroupName groupName = GroupName.create("[PROJECT]", "[GROUP]");
 *   ErrorGroup response = errorGroupServiceClient.getGroup(groupName);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the errorGroupServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li> A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li> A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li> A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of ErrorGroupServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * ErrorGroupServiceSettings errorGroupServiceSettings =
 *     ErrorGroupServiceSettings.defaultBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ErrorGroupServiceClient errorGroupServiceClient =
 *     ErrorGroupServiceClient.create(errorGroupServiceSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * ErrorGroupServiceSettings errorGroupServiceSettings =
 *     ErrorGroupServiceSettings.defaultBuilder()
 *         .setTransportProvider(ErrorGroupServiceSettings.defaultGrpcTransportProviderBuilder()
 *             .setChannelProvider(ErrorGroupServiceSettings.defaultGrpcChannelProviderBuilder()
 *                 .setEndpoint(myEndpoint)
 *                 .build())
 *             .build())
 *         .build();
 * ErrorGroupServiceClient errorGroupServiceClient =
 *     ErrorGroupServiceClient.create(errorGroupServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class ErrorGroupServiceClient implements BackgroundResource {
  private final ErrorGroupServiceSettings settings;
  private final ErrorGroupServiceStub stub;

  /** Constructs an instance of ErrorGroupServiceClient with default settings. */
  public static final ErrorGroupServiceClient create() throws IOException {
    return create(ErrorGroupServiceSettings.defaultBuilder().build());
  }

  /**
   * Constructs an instance of ErrorGroupServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ErrorGroupServiceClient create(ErrorGroupServiceSettings settings)
      throws IOException {
    return new ErrorGroupServiceClient(settings);
  }

  /**
   * Constructs an instance of ErrorGroupServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer to use ErrorGroupServiceSettings}.
   */
  public static final ErrorGroupServiceClient create(ErrorGroupServiceStub stub) {
    return new ErrorGroupServiceClient(stub);
  }

  /**
   * Constructs an instance of ErrorGroupServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ErrorGroupServiceClient(ErrorGroupServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = settings.createStub();
  }

  protected ErrorGroupServiceClient(ErrorGroupServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ErrorGroupServiceSettings getSettings() {
    return settings;
  }

  public ErrorGroupServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get the specified group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ErrorGroupServiceClient errorGroupServiceClient = ErrorGroupServiceClient.create()) {
   *   GroupName groupName = GroupName.create("[PROJECT]", "[GROUP]");
   *   ErrorGroup response = errorGroupServiceClient.getGroup(groupName);
   * }
   * </code></pre>
   *
   * @param groupName [Required] The group resource name. Written as
   *     &lt;code&gt;projects/&lt;var&gt;projectID&lt;/var&gt;/groups/&lt;var&gt;group_name&lt;/var&gt;&lt;/code&gt;.
   *     Call &lt;a href="/error-reporting/reference/rest/v1beta1/projects.groupStats/list"&gt;
   *     &lt;code&gt;groupStats.list&lt;/code&gt;&lt;/a&gt; to return a list of groups belonging to
   *     this project.
   *     <p>Example: &lt;code&gt;projects/my-project-123/groups/my-group&lt;/code&gt;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ErrorGroup getGroup(GroupName groupName) {

    GetGroupRequest request =
        GetGroupRequest.newBuilder().setGroupNameWithGroupName(groupName).build();
    return getGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get the specified group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ErrorGroupServiceClient errorGroupServiceClient = ErrorGroupServiceClient.create()) {
   *   GroupName groupName = GroupName.create("[PROJECT]", "[GROUP]");
   *   GetGroupRequest request = GetGroupRequest.newBuilder()
   *     .setGroupNameWithGroupName(groupName)
   *     .build();
   *   ErrorGroup response = errorGroupServiceClient.getGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final ErrorGroup getGroup(GetGroupRequest request) {
    return getGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get the specified group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ErrorGroupServiceClient errorGroupServiceClient = ErrorGroupServiceClient.create()) {
   *   GroupName groupName = GroupName.create("[PROJECT]", "[GROUP]");
   *   GetGroupRequest request = GetGroupRequest.newBuilder()
   *     .setGroupNameWithGroupName(groupName)
   *     .build();
   *   ApiFuture&lt;ErrorGroup&gt; future = errorGroupServiceClient.getGroupCallable().futureCall(request);
   *   // Do something
   *   ErrorGroup response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetGroupRequest, ErrorGroup> getGroupCallable() {
    return stub.getGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Replace the data for the specified group. Fails if the group does not exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ErrorGroupServiceClient errorGroupServiceClient = ErrorGroupServiceClient.create()) {
   *   ErrorGroup group = ErrorGroup.newBuilder().build();
   *   ErrorGroup response = errorGroupServiceClient.updateGroup(group);
   * }
   * </code></pre>
   *
   * @param group [Required] The group which replaces the resource on the server.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ErrorGroup updateGroup(ErrorGroup group) {

    UpdateGroupRequest request = UpdateGroupRequest.newBuilder().setGroup(group).build();
    return updateGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Replace the data for the specified group. Fails if the group does not exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ErrorGroupServiceClient errorGroupServiceClient = ErrorGroupServiceClient.create()) {
   *   ErrorGroup group = ErrorGroup.newBuilder().build();
   *   UpdateGroupRequest request = UpdateGroupRequest.newBuilder()
   *     .setGroup(group)
   *     .build();
   *   ErrorGroup response = errorGroupServiceClient.updateGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final ErrorGroup updateGroup(UpdateGroupRequest request) {
    return updateGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Replace the data for the specified group. Fails if the group does not exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ErrorGroupServiceClient errorGroupServiceClient = ErrorGroupServiceClient.create()) {
   *   ErrorGroup group = ErrorGroup.newBuilder().build();
   *   UpdateGroupRequest request = UpdateGroupRequest.newBuilder()
   *     .setGroup(group)
   *     .build();
   *   ApiFuture&lt;ErrorGroup&gt; future = errorGroupServiceClient.updateGroupCallable().futureCall(request);
   *   // Do something
   *   ErrorGroup response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateGroupRequest, ErrorGroup> updateGroupCallable() {
    return stub.updateGroupCallable();
  }

  @Override
  public final void close() throws Exception {
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
