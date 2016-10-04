/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.cloud.errorreporting.spi.v1beta1;

import com.google.api.gax.grpc.ApiCallable;
import com.google.api.gax.protobuf.PathTemplate;
import com.google.devtools.clouderrorreporting.v1beta1.ErrorGroup;
import com.google.devtools.clouderrorreporting.v1beta1.GetGroupRequest;
import com.google.devtools.clouderrorreporting.v1beta1.UpdateGroupRequest;
import io.grpc.ManagedChannel;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Service for retrieving and updating individual error groups.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (ErrorGroupServiceApi errorGroupServiceApi = ErrorGroupServiceApi.create()) {
 *   String formattedGroupName = ErrorGroupServiceApi.formatGroupName("[PROJECT]", "[GROUP]");
 *   ErrorGroup response = errorGroupServiceApi.getGroup(formattedGroupName);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the errorGroupServiceApi object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
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
 *   <li> A "callable" method. This type of method takes no parameters and returns an immutable
 *       ApiCallable object, which can be used to initiate calls to the service.
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
 * <pre>
 * <code>
 * ErrorGroupServiceSettings errorGroupServiceSettings = ErrorGroupServiceSettings.defaultBuilder()
 *     .provideChannelWith(myCredentials)
 *     .build();
 * ErrorGroupServiceApi errorGroupServiceApi = ErrorGroupServiceApi.create(errorGroupServiceSettings);
 * </code>
 * </pre>
 */
@javax.annotation.Generated("by GAPIC")
public class ErrorGroupServiceApi implements AutoCloseable {
  private final ErrorGroupServiceSettings settings;
  private final ManagedChannel channel;
  private final ScheduledExecutorService executor;
  private final List<AutoCloseable> closeables = new ArrayList<>();

  private final ApiCallable<GetGroupRequest, ErrorGroup> getGroupCallable;
  private final ApiCallable<UpdateGroupRequest, ErrorGroup> updateGroupCallable;

  private static final PathTemplate GROUP_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/groups/{group}");

  /** Formats a string containing the fully-qualified path to represent a group resource. */
  public static final String formatGroupName(String project, String group) {
    return GROUP_PATH_TEMPLATE.instantiate(
        "project", project,
        "group", group);
  }

  /** Parses the project from the given fully-qualified path which represents a group resource. */
  public static final String parseProjectFromGroupName(String groupName) {
    return GROUP_PATH_TEMPLATE.parse(groupName).get("project");
  }

  /** Parses the group from the given fully-qualified path which represents a group resource. */
  public static final String parseGroupFromGroupName(String groupName) {
    return GROUP_PATH_TEMPLATE.parse(groupName).get("group");
  }

  /** Constructs an instance of ErrorGroupServiceApi with default settings. */
  public static final ErrorGroupServiceApi create() throws IOException {
    return create(ErrorGroupServiceSettings.defaultBuilder().build());
  }

  /**
   * Constructs an instance of ErrorGroupServiceApi, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ErrorGroupServiceApi create(ErrorGroupServiceSettings settings)
      throws IOException {
    return new ErrorGroupServiceApi(settings);
  }

  /**
   * Constructs an instance of ErrorGroupServiceApi, using the given settings. This is protected so
   * that it easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected ErrorGroupServiceApi(ErrorGroupServiceSettings settings) throws IOException {
    this.settings = settings;
    this.executor = settings.getExecutorProvider().getOrBuildExecutor();
    this.channel = settings.getChannelProvider().getOrBuildChannel(this.executor);

    this.getGroupCallable =
        ApiCallable.create(settings.getGroupSettings(), this.channel, this.executor);
    this.updateGroupCallable =
        ApiCallable.create(settings.updateGroupSettings(), this.channel, this.executor);

    if (settings.getChannelProvider().shouldAutoClose()) {
      closeables.add(
          new Closeable() {
            @Override
            public void close() throws IOException {
              channel.shutdown();
            }
          });
    }
    if (settings.getExecutorProvider().shouldAutoClose()) {
      closeables.add(
          new Closeable() {
            @Override
            public void close() throws IOException {
              executor.shutdown();
            }
          });
    }
  }

  public final ErrorGroupServiceSettings getSettings() {
    return settings;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get the specified group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ErrorGroupServiceApi errorGroupServiceApi = ErrorGroupServiceApi.create()) {
   *   String formattedGroupName = ErrorGroupServiceApi.formatGroupName("[PROJECT]", "[GROUP]");
   *   ErrorGroup response = errorGroupServiceApi.getGroup(formattedGroupName);
   * }
   * </code></pre>
   *
   * @param groupName [Required] The group resource name. Written as
   *     &lt;code&gt;projects/&lt;var&gt;projectID&lt;/var&gt;/groups/&lt;var&gt;group_name&lt;/var&gt;&lt;/code&gt;.
   *     Call &lt;a href="/error-reporting/reference/rest/v1beta1/projects.groupStats/list"&gt;
   *     &lt;code&gt;groupStats.list&lt;/code&gt;&lt;/a&gt; to return a list of groups belonging to
   *     this project.
   *     <p>Example: &lt;code&gt;projects/my-project-123/groups/my-group&lt;/code&gt;
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final ErrorGroup getGroup(String groupName) {
    GROUP_PATH_TEMPLATE.validate(groupName, "getGroup");
    GetGroupRequest request = GetGroupRequest.newBuilder().setGroupName(groupName).build();
    return getGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get the specified group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ErrorGroupServiceApi errorGroupServiceApi = ErrorGroupServiceApi.create()) {
   *   String formattedGroupName = ErrorGroupServiceApi.formatGroupName("[PROJECT]", "[GROUP]");
   *   GetGroupRequest request = GetGroupRequest.newBuilder()
   *     .setGroupName(formattedGroupName)
   *     .build();
   *   ErrorGroup response = errorGroupServiceApi.getGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
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
   * try (ErrorGroupServiceApi errorGroupServiceApi = ErrorGroupServiceApi.create()) {
   *   String formattedGroupName = ErrorGroupServiceApi.formatGroupName("[PROJECT]", "[GROUP]");
   *   GetGroupRequest request = GetGroupRequest.newBuilder()
   *     .setGroupName(formattedGroupName)
   *     .build();
   *   ListenableFuture&lt;ErrorGroup&gt; future = errorGroupServiceApi.getGroupCallable().futureCall(request);
   *   // Do something
   *   ErrorGroup response = future.get();
   * }
   * </code></pre>
   */
  public final ApiCallable<GetGroupRequest, ErrorGroup> getGroupCallable() {
    return getGroupCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Replace the data for the specified group. Fails if the group does not exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ErrorGroupServiceApi errorGroupServiceApi = ErrorGroupServiceApi.create()) {
   *   ErrorGroup group = ErrorGroup.newBuilder().build();
   *   ErrorGroup response = errorGroupServiceApi.updateGroup(group);
   * }
   * </code></pre>
   *
   * @param group [Required] The group which replaces the resource on the server.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
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
   * try (ErrorGroupServiceApi errorGroupServiceApi = ErrorGroupServiceApi.create()) {
   *   ErrorGroup group = ErrorGroup.newBuilder().build();
   *   UpdateGroupRequest request = UpdateGroupRequest.newBuilder()
   *     .setGroup(group)
   *     .build();
   *   ErrorGroup response = errorGroupServiceApi.updateGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
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
   * try (ErrorGroupServiceApi errorGroupServiceApi = ErrorGroupServiceApi.create()) {
   *   ErrorGroup group = ErrorGroup.newBuilder().build();
   *   UpdateGroupRequest request = UpdateGroupRequest.newBuilder()
   *     .setGroup(group)
   *     .build();
   *   ListenableFuture&lt;ErrorGroup&gt; future = errorGroupServiceApi.updateGroupCallable().futureCall(request);
   *   // Do something
   *   ErrorGroup response = future.get();
   * }
   * </code></pre>
   */
  public final ApiCallable<UpdateGroupRequest, ErrorGroup> updateGroupCallable() {
    return updateGroupCallable;
  }

  /**
   * Initiates an orderly shutdown in which preexisting calls continue but new calls are immediately
   * cancelled.
   */
  @Override
  public final void close() throws Exception {
    for (AutoCloseable closeable : closeables) {
      closeable.close();
    }
  }
}
