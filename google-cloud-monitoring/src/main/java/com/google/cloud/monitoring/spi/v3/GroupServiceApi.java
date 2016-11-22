/*
 * Copyright 2016, Google Inc. All rights reserved.
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
package com.google.cloud.monitoring.spi.v3;

import static com.google.cloud.monitoring.spi.v3.PagedResponseWrappers.ListGroupMembersPagedResponse;
import static com.google.cloud.monitoring.spi.v3.PagedResponseWrappers.ListGroupsPagedResponse;

import com.google.api.gax.grpc.ChannelAndExecutor;
import com.google.api.gax.grpc.UnaryCallable;
import com.google.api.gax.protobuf.PathTemplate;
import com.google.monitoring.v3.CreateGroupRequest;
import com.google.monitoring.v3.DeleteGroupRequest;
import com.google.monitoring.v3.GetGroupRequest;
import com.google.monitoring.v3.Group;
import com.google.monitoring.v3.ListGroupMembersRequest;
import com.google.monitoring.v3.ListGroupMembersResponse;
import com.google.monitoring.v3.ListGroupsRequest;
import com.google.monitoring.v3.ListGroupsResponse;
import com.google.monitoring.v3.UpdateGroupRequest;
import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The Group API lets you inspect and manage your
 * [groups](google.monitoring.v3.Group).
 *
 * <p>A group is a named filter that is used to identify a collection of monitored resources. Groups
 * are typically used to mirror the physical and/or logical topology of the environment. Because
 * group membership is computed dynamically, monitored resources that are started in the future are
 * automatically placed in matching groups. By using a group to name monitored resources in, for
 * example, an alert policy, the target of that alert policy is updated automatically as monitored
 * resources are added and removed from the infrastructure.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (GroupServiceApi groupServiceApi = GroupServiceApi.create()) {
 *   String formattedName = GroupServiceApi.formatGroupName("[PROJECT]", "[GROUP]");
 *   Group response = groupServiceApi.getGroup(formattedName);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the groupServiceApi object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of GroupServiceSettings to
 * create(). For example:
 *
 * <pre>
 * <code>
 * InstantiatingChannelProvider channelProvider =
 *     GroupServiceSettings.defaultChannelProviderBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GroupServiceSettings groupServiceSettings =
 *     GroupServiceSettings.defaultBuilder().setChannelProvider(channelProvider).build();
 * GroupServiceApi groupServiceApi =
 *     GroupServiceApi.create(groupServiceSettings);
 * </code>
 * </pre>
 */
@javax.annotation.Generated("by GAPIC")
public class GroupServiceApi implements AutoCloseable {
  private final GroupServiceSettings settings;
  private final ScheduledExecutorService executor;
  private final ManagedChannel channel;
  private final List<AutoCloseable> closeables = new ArrayList<>();

  private final UnaryCallable<ListGroupsRequest, ListGroupsResponse> listGroupsCallable;
  private final UnaryCallable<ListGroupsRequest, ListGroupsPagedResponse> listGroupsPagedCallable;
  private final UnaryCallable<GetGroupRequest, Group> getGroupCallable;
  private final UnaryCallable<CreateGroupRequest, Group> createGroupCallable;
  private final UnaryCallable<UpdateGroupRequest, Group> updateGroupCallable;
  private final UnaryCallable<DeleteGroupRequest, Empty> deleteGroupCallable;
  private final UnaryCallable<ListGroupMembersRequest, ListGroupMembersResponse>
      listGroupMembersCallable;
  private final UnaryCallable<ListGroupMembersRequest, ListGroupMembersPagedResponse>
      listGroupMembersPagedCallable;

  private static final PathTemplate PROJECT_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}");

  private static final PathTemplate GROUP_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/groups/{group}");

  /** Formats a string containing the fully-qualified path to represent a project resource. */
  public static final String formatProjectName(String project) {
    return PROJECT_PATH_TEMPLATE.instantiate("project", project);
  }

  /** Formats a string containing the fully-qualified path to represent a group resource. */
  public static final String formatGroupName(String project, String group) {
    return GROUP_PATH_TEMPLATE.instantiate(
        "project", project,
        "group", group);
  }

  /** Parses the project from the given fully-qualified path which represents a project resource. */
  public static final String parseProjectFromProjectName(String projectName) {
    return PROJECT_PATH_TEMPLATE.parse(projectName).get("project");
  }

  /** Parses the project from the given fully-qualified path which represents a group resource. */
  public static final String parseProjectFromGroupName(String groupName) {
    return GROUP_PATH_TEMPLATE.parse(groupName).get("project");
  }

  /** Parses the group from the given fully-qualified path which represents a group resource. */
  public static final String parseGroupFromGroupName(String groupName) {
    return GROUP_PATH_TEMPLATE.parse(groupName).get("group");
  }

  /** Constructs an instance of GroupServiceApi with default settings. */
  public static final GroupServiceApi create() throws IOException {
    return create(GroupServiceSettings.defaultBuilder().build());
  }

  /**
   * Constructs an instance of GroupServiceApi, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final GroupServiceApi create(GroupServiceSettings settings) throws IOException {
    return new GroupServiceApi(settings);
  }

  /**
   * Constructs an instance of GroupServiceApi, using the given settings. This is protected so that
   * it easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GroupServiceApi(GroupServiceSettings settings) throws IOException {
    this.settings = settings;
    ChannelAndExecutor channelAndExecutor = settings.getChannelAndExecutor();
    this.executor = channelAndExecutor.getExecutor();
    this.channel = channelAndExecutor.getChannel();

    this.listGroupsCallable =
        UnaryCallable.create(settings.listGroupsSettings(), this.channel, this.executor);
    this.listGroupsPagedCallable =
        UnaryCallable.createPagedVariant(
            settings.listGroupsSettings(), this.channel, this.executor);
    this.getGroupCallable =
        UnaryCallable.create(settings.getGroupSettings(), this.channel, this.executor);
    this.createGroupCallable =
        UnaryCallable.create(settings.createGroupSettings(), this.channel, this.executor);
    this.updateGroupCallable =
        UnaryCallable.create(settings.updateGroupSettings(), this.channel, this.executor);
    this.deleteGroupCallable =
        UnaryCallable.create(settings.deleteGroupSettings(), this.channel, this.executor);
    this.listGroupMembersCallable =
        UnaryCallable.create(settings.listGroupMembersSettings(), this.channel, this.executor);
    this.listGroupMembersPagedCallable =
        UnaryCallable.createPagedVariant(
            settings.listGroupMembersSettings(), this.channel, this.executor);

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

  public final GroupServiceSettings getSettings() {
    return settings;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the existing groups.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GroupServiceApi groupServiceApi = GroupServiceApi.create()) {
   *   String formattedName = GroupServiceApi.formatProjectName("[PROJECT]");
   *   ListGroupsRequest request = ListGroupsRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   for (Group element : groupServiceApi.listGroups(request).iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final ListGroupsPagedResponse listGroups(ListGroupsRequest request) {
    return listGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the existing groups.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GroupServiceApi groupServiceApi = GroupServiceApi.create()) {
   *   String formattedName = GroupServiceApi.formatProjectName("[PROJECT]");
   *   ListGroupsRequest request = ListGroupsRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ListenableFuture&lt;ListGroupsPagedResponse&gt; future = groupServiceApi.listGroupsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Group element : future.get().iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListGroupsRequest, ListGroupsPagedResponse> listGroupsPagedCallable() {
    return listGroupsPagedCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the existing groups.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GroupServiceApi groupServiceApi = GroupServiceApi.create()) {
   *   String formattedName = GroupServiceApi.formatProjectName("[PROJECT]");
   *   ListGroupsRequest request = ListGroupsRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   while (true) {
   *     ListGroupsResponse response = groupServiceApi.listGroupsCallable().call(request);
   *     for (Group element : response.getGroupList()) {
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
  public final UnaryCallable<ListGroupsRequest, ListGroupsResponse> listGroupsCallable() {
    return listGroupsCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a single group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GroupServiceApi groupServiceApi = GroupServiceApi.create()) {
   *   String formattedName = GroupServiceApi.formatGroupName("[PROJECT]", "[GROUP]");
   *   Group response = groupServiceApi.getGroup(formattedName);
   * }
   * </code></pre>
   *
   * @param name The group to retrieve. The format is
   *     `"projects/{project_id_or_number}/groups/{group_id}"`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final Group getGroup(String name) {
    GROUP_PATH_TEMPLATE.validate(name, "getGroup");
    GetGroupRequest request = GetGroupRequest.newBuilder().setName(name).build();
    return getGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a single group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GroupServiceApi groupServiceApi = GroupServiceApi.create()) {
   *   String formattedName = GroupServiceApi.formatGroupName("[PROJECT]", "[GROUP]");
   *   GetGroupRequest request = GetGroupRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   Group response = groupServiceApi.getGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  private final Group getGroup(GetGroupRequest request) {
    return getGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a single group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GroupServiceApi groupServiceApi = GroupServiceApi.create()) {
   *   String formattedName = GroupServiceApi.formatGroupName("[PROJECT]", "[GROUP]");
   *   GetGroupRequest request = GetGroupRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ListenableFuture&lt;Group&gt; future = groupServiceApi.getGroupCallable().futureCall(request);
   *   // Do something
   *   Group response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetGroupRequest, Group> getGroupCallable() {
    return getGroupCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GroupServiceApi groupServiceApi = GroupServiceApi.create()) {
   *   String formattedName = GroupServiceApi.formatProjectName("[PROJECT]");
   *   Group group = Group.newBuilder().build();
   *   Group response = groupServiceApi.createGroup(formattedName, group);
   * }
   * </code></pre>
   *
   * @param name The project in which to create the group. The format is
   *     `"projects/{project_id_or_number}"`.
   * @param group A group definition. It is an error to define the `name` field because the system
   *     assigns the name.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final Group createGroup(String name, Group group) {
    PROJECT_PATH_TEMPLATE.validate(name, "createGroup");
    CreateGroupRequest request =
        CreateGroupRequest.newBuilder().setName(name).setGroup(group).build();
    return createGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GroupServiceApi groupServiceApi = GroupServiceApi.create()) {
   *   String formattedName = GroupServiceApi.formatProjectName("[PROJECT]");
   *   Group group = Group.newBuilder().build();
   *   CreateGroupRequest request = CreateGroupRequest.newBuilder()
   *     .setName(formattedName)
   *     .setGroup(group)
   *     .build();
   *   Group response = groupServiceApi.createGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final Group createGroup(CreateGroupRequest request) {
    return createGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GroupServiceApi groupServiceApi = GroupServiceApi.create()) {
   *   String formattedName = GroupServiceApi.formatProjectName("[PROJECT]");
   *   Group group = Group.newBuilder().build();
   *   CreateGroupRequest request = CreateGroupRequest.newBuilder()
   *     .setName(formattedName)
   *     .setGroup(group)
   *     .build();
   *   ListenableFuture&lt;Group&gt; future = groupServiceApi.createGroupCallable().futureCall(request);
   *   // Do something
   *   Group response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateGroupRequest, Group> createGroupCallable() {
    return createGroupCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an existing group. You can change any group attributes except `name`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GroupServiceApi groupServiceApi = GroupServiceApi.create()) {
   *   Group group = Group.newBuilder().build();
   *   Group response = groupServiceApi.updateGroup(group);
   * }
   * </code></pre>
   *
   * @param group The new definition of the group. All fields of the existing group, excepting
   *     `name`, are replaced with the corresponding fields of this group.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final Group updateGroup(Group group) {

    UpdateGroupRequest request = UpdateGroupRequest.newBuilder().setGroup(group).build();
    return updateGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an existing group. You can change any group attributes except `name`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GroupServiceApi groupServiceApi = GroupServiceApi.create()) {
   *   Group group = Group.newBuilder().build();
   *   UpdateGroupRequest request = UpdateGroupRequest.newBuilder()
   *     .setGroup(group)
   *     .build();
   *   Group response = groupServiceApi.updateGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final Group updateGroup(UpdateGroupRequest request) {
    return updateGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an existing group. You can change any group attributes except `name`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GroupServiceApi groupServiceApi = GroupServiceApi.create()) {
   *   Group group = Group.newBuilder().build();
   *   UpdateGroupRequest request = UpdateGroupRequest.newBuilder()
   *     .setGroup(group)
   *     .build();
   *   ListenableFuture&lt;Group&gt; future = groupServiceApi.updateGroupCallable().futureCall(request);
   *   // Do something
   *   Group response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateGroupRequest, Group> updateGroupCallable() {
    return updateGroupCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes an existing group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GroupServiceApi groupServiceApi = GroupServiceApi.create()) {
   *   String formattedName = GroupServiceApi.formatGroupName("[PROJECT]", "[GROUP]");
   *   groupServiceApi.deleteGroup(formattedName);
   * }
   * </code></pre>
   *
   * @param name The group to delete. The format is
   *     `"projects/{project_id_or_number}/groups/{group_id}"`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final void deleteGroup(String name) {
    GROUP_PATH_TEMPLATE.validate(name, "deleteGroup");
    DeleteGroupRequest request = DeleteGroupRequest.newBuilder().setName(name).build();
    deleteGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes an existing group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GroupServiceApi groupServiceApi = GroupServiceApi.create()) {
   *   String formattedName = GroupServiceApi.formatGroupName("[PROJECT]", "[GROUP]");
   *   DeleteGroupRequest request = DeleteGroupRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   groupServiceApi.deleteGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  private final void deleteGroup(DeleteGroupRequest request) {
    deleteGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes an existing group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GroupServiceApi groupServiceApi = GroupServiceApi.create()) {
   *   String formattedName = GroupServiceApi.formatGroupName("[PROJECT]", "[GROUP]");
   *   DeleteGroupRequest request = DeleteGroupRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ListenableFuture&lt;Void&gt; future = groupServiceApi.deleteGroupCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteGroupRequest, Empty> deleteGroupCallable() {
    return deleteGroupCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the monitored resources that are members of a group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GroupServiceApi groupServiceApi = GroupServiceApi.create()) {
   *   String formattedName = GroupServiceApi.formatGroupName("[PROJECT]", "[GROUP]");
   *   for (MonitoredResource element : groupServiceApi.listGroupMembers(formattedName).iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param name The group whose members are listed. The format is
   *     `"projects/{project_id_or_number}/groups/{group_id}"`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final ListGroupMembersPagedResponse listGroupMembers(String name) {
    GROUP_PATH_TEMPLATE.validate(name, "listGroupMembers");
    ListGroupMembersRequest request = ListGroupMembersRequest.newBuilder().setName(name).build();
    return listGroupMembers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the monitored resources that are members of a group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GroupServiceApi groupServiceApi = GroupServiceApi.create()) {
   *   String formattedName = GroupServiceApi.formatGroupName("[PROJECT]", "[GROUP]");
   *   ListGroupMembersRequest request = ListGroupMembersRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   for (MonitoredResource element : groupServiceApi.listGroupMembers(request).iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final ListGroupMembersPagedResponse listGroupMembers(ListGroupMembersRequest request) {
    return listGroupMembersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the monitored resources that are members of a group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GroupServiceApi groupServiceApi = GroupServiceApi.create()) {
   *   String formattedName = GroupServiceApi.formatGroupName("[PROJECT]", "[GROUP]");
   *   ListGroupMembersRequest request = ListGroupMembersRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ListenableFuture&lt;ListGroupMembersPagedResponse&gt; future = groupServiceApi.listGroupMembersPagedCallable().futureCall(request);
   *   // Do something
   *   for (MonitoredResource element : future.get().iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListGroupMembersRequest, ListGroupMembersPagedResponse>
      listGroupMembersPagedCallable() {
    return listGroupMembersPagedCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the monitored resources that are members of a group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GroupServiceApi groupServiceApi = GroupServiceApi.create()) {
   *   String formattedName = GroupServiceApi.formatGroupName("[PROJECT]", "[GROUP]");
   *   ListGroupMembersRequest request = ListGroupMembersRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   while (true) {
   *     ListGroupMembersResponse response = groupServiceApi.listGroupMembersCallable().call(request);
   *     for (MonitoredResource element : response.getMembersList()) {
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
  public final UnaryCallable<ListGroupMembersRequest, ListGroupMembersResponse>
      listGroupMembersCallable() {
    return listGroupMembersCallable;
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
