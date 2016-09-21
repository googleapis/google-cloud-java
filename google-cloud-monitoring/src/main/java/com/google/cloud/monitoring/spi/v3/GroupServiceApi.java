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
package com.google.cloud.monitoring.spi.v3;

import com.google.api.MonitoredResource;
import com.google.api.gax.core.PagedListResponse;
import com.google.api.gax.grpc.ApiCallable;
import com.google.api.gax.protobuf.PathTemplate;
import com.google.monitoring.v3.CreateGroupRequest;
import com.google.monitoring.v3.DeleteGroupRequest;
import com.google.monitoring.v3.GetGroupRequest;
import com.google.monitoring.v3.Group;
import com.google.monitoring.v3.ListGroupMembersRequest;
import com.google.monitoring.v3.ListGroupMembersResponse;
import com.google.monitoring.v3.ListGroupsRequest;
import com.google.monitoring.v3.ListGroupsResponse;
import com.google.monitoring.v3.TimeInterval;
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
 * A group is a named filter that is used to identify
 * a collection of monitored resources. Groups are typically used to
 * mirror the physical and/or logical topology of the environment.
 * Because group membership is computed dynamically, monitored
 * resources that are started in the future are automatically placed
 * in matching groups. By using a group to name monitored resources in,
 * for example, an alert policy, the target of that alert policy is
 * updated automatically as monitored resources are added and removed
 * from the infrastructure.
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
 * <p>Note: close() needs to be called on the groupServiceApi object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's methods:
 *
 * <ol>
 * <li> A "flattened" method. With this type of method, the fields of the request type have been
 * converted into function parameters. It may be the case that not all fields are available
 * as parameters, and not every API method will have a flattened method entry point.
 * <li> A "request object" method. This type of method only takes one parameter, a request
 * object, which must be constructed before the call. Not every API method will have a request
 * object method.
 * <li> A "callable" method. This type of method takes no parameters and returns an immutable
 * ApiCallable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist
 * with these names, this class includes a format method for each type of name, and additionally
 * a parse method to extract the individual identifiers contained within names that are
 * returned.
 *
 * <p>This class can be customized by passing in a custom instance of GroupServiceSettings to
 * create(). For example:
 *
 * <pre>
 * <code>
 * GroupServiceSettings groupServiceSettings = GroupServiceSettings.defaultBuilder()
 *     .provideChannelWith(myCredentials)
 *     .build();
 * GroupServiceApi groupServiceApi = GroupServiceApi.create(groupServiceSettings);
 * </code>
 * </pre>
 */
@javax.annotation.Generated("by GAPIC")
public class GroupServiceApi implements AutoCloseable {
  private final GroupServiceSettings settings;
  private final ManagedChannel channel;
  private final ScheduledExecutorService executor;
  private final List<AutoCloseable> closeables = new ArrayList<>();

  private final ApiCallable<ListGroupsRequest, ListGroupsResponse> listGroupsCallable;
  private final ApiCallable<
          ListGroupsRequest, PagedListResponse<ListGroupsRequest, ListGroupsResponse, Group>>
      listGroupsPagedCallable;
  private final ApiCallable<GetGroupRequest, Group> getGroupCallable;
  private final ApiCallable<CreateGroupRequest, Group> createGroupCallable;
  private final ApiCallable<UpdateGroupRequest, Group> updateGroupCallable;
  private final ApiCallable<DeleteGroupRequest, Empty> deleteGroupCallable;
  private final ApiCallable<ListGroupMembersRequest, ListGroupMembersResponse>
      listGroupMembersCallable;
  private final ApiCallable<
          ListGroupMembersRequest,
          PagedListResponse<ListGroupMembersRequest, ListGroupMembersResponse, MonitoredResource>>
      listGroupMembersPagedCallable;

  public final GroupServiceSettings getSettings() {
    return settings;
  }

  private static final PathTemplate PROJECT_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}");

  private static final PathTemplate GROUP_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/groups/{group}");

  /**
   * Formats a string containing the fully-qualified path to represent
   * a project resource.
   */
  public static final String formatProjectName(String project) {
    return PROJECT_PATH_TEMPLATE.instantiate("project", project);
  }

  /**
   * Formats a string containing the fully-qualified path to represent
   * a group resource.
   */
  public static final String formatGroupName(String project, String group) {
    return GROUP_PATH_TEMPLATE.instantiate(
        "project", project,
        "group", group);
  }

  /**
   * Parses the project from the given fully-qualified path which
   * represents a project resource.
   */
  public static final String parseProjectFromProjectName(String projectName) {
    return PROJECT_PATH_TEMPLATE.parse(projectName).get("project");
  }

  /**
   * Parses the project from the given fully-qualified path which
   * represents a group resource.
   */
  public static final String parseProjectFromGroupName(String groupName) {
    return GROUP_PATH_TEMPLATE.parse(groupName).get("project");
  }

  /**
   * Parses the group from the given fully-qualified path which
   * represents a group resource.
   */
  public static final String parseGroupFromGroupName(String groupName) {
    return GROUP_PATH_TEMPLATE.parse(groupName).get("group");
  }

  /**
   * Constructs an instance of GroupServiceApi with default settings.
   */
  public static final GroupServiceApi create() throws IOException {
    return create(GroupServiceSettings.defaultBuilder().build());
  }

  /**
   * Constructs an instance of GroupServiceApi, using the given settings.
   * The channels are created based on the settings passed in, or defaults for any
   * settings that are not set.
   */
  public static final GroupServiceApi create(GroupServiceSettings settings) throws IOException {
    return new GroupServiceApi(settings);
  }

  /**
   * Constructs an instance of GroupServiceApi, using the given settings.
   * This is protected so that it easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected GroupServiceApi(GroupServiceSettings settings) throws IOException {
    this.settings = settings;
    this.executor = settings.getExecutorProvider().getOrBuildExecutor();
    this.channel = settings.getChannelProvider().getOrBuildChannel(this.executor);

    this.listGroupsCallable =
        ApiCallable.create(settings.listGroupsSettings(), this.channel, this.executor);
    this.listGroupsPagedCallable =
        ApiCallable.createPagedVariant(settings.listGroupsSettings(), this.channel, this.executor);
    this.getGroupCallable =
        ApiCallable.create(settings.getGroupSettings(), this.channel, this.executor);
    this.createGroupCallable =
        ApiCallable.create(settings.createGroupSettings(), this.channel, this.executor);
    this.updateGroupCallable =
        ApiCallable.create(settings.updateGroupSettings(), this.channel, this.executor);
    this.deleteGroupCallable =
        ApiCallable.create(settings.deleteGroupSettings(), this.channel, this.executor);
    this.listGroupMembersCallable =
        ApiCallable.create(settings.listGroupMembersSettings(), this.channel, this.executor);
    this.listGroupMembersPagedCallable =
        ApiCallable.createPagedVariant(
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the existing groups. The project ID in the URL path must refer
   * to a Stackdriver account.
   *
   * Sample code:
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
  public final PagedListResponse<ListGroupsRequest, ListGroupsResponse, Group> listGroups(
      ListGroupsRequest request) {
    return listGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the existing groups. The project ID in the URL path must refer
   * to a Stackdriver account.
   *
   * Sample code:
   * <pre><code>
   * try (GroupServiceApi groupServiceApi = GroupServiceApi.create()) {
   *   String formattedName = GroupServiceApi.formatProjectName("[PROJECT]");
   *   ListGroupsRequest request = ListGroupsRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ListenableFuture&lt;PagedListResponse&lt;ListGroupsRequest,ListGroupsResponse,Group&gt;&gt; future = groupServiceApi.listGroupsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Group element : future.get().iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final ApiCallable<
          ListGroupsRequest, PagedListResponse<ListGroupsRequest, ListGroupsResponse, Group>>
      listGroupsPagedCallable() {
    return listGroupsPagedCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the existing groups. The project ID in the URL path must refer
   * to a Stackdriver account.
   *
   * Sample code:
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
  public final ApiCallable<ListGroupsRequest, ListGroupsResponse> listGroupsCallable() {
    return listGroupsCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a single group. The project ID in the URL path must refer to a
   * Stackdriver account.
   *
   * Sample code:
   * <pre><code>
   * try (GroupServiceApi groupServiceApi = GroupServiceApi.create()) {
   *   String formattedName = GroupServiceApi.formatGroupName("[PROJECT]", "[GROUP]");
   *   Group response = groupServiceApi.getGroup(formattedName);
   * }
   * </code></pre>
   *
   * @param name The group to retrieve. The format is
   * `"projects/{project_id_or_number}/groups/{group_id}"`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final Group getGroup(String name) {
    GROUP_PATH_TEMPLATE.validate(name, "getGroup");
    GetGroupRequest request = GetGroupRequest.newBuilder().setName(name).build();
    return getGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a single group. The project ID in the URL path must refer to a
   * Stackdriver account.
   *
   * Sample code:
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
   * Gets a single group. The project ID in the URL path must refer to a
   * Stackdriver account.
   *
   * Sample code:
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
  public final ApiCallable<GetGroupRequest, Group> getGroupCallable() {
    return getGroupCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new group. The project ID in the URL path must refer to a
   * Stackdriver account.
   *
   * Sample code:
   * <pre><code>
   * try (GroupServiceApi groupServiceApi = GroupServiceApi.create()) {
   *   String formattedName = GroupServiceApi.formatProjectName("[PROJECT]");
   *   Group group = Group.newBuilder().build();
   *   boolean validateOnly = false;
   *   Group response = groupServiceApi.createGroup(formattedName, group, validateOnly);
   * }
   * </code></pre>
   *
   * @param name The project in which to create the group. The format is
   * `"projects/{project_id_or_number}"`.
   * @param group A group definition. It is an error to define the `name` field because
   * the system assigns the name.
   * @param validateOnly If true, validate this request but do not create the group.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final Group createGroup(String name, Group group, boolean validateOnly) {
    PROJECT_PATH_TEMPLATE.validate(name, "createGroup");
    CreateGroupRequest request =
        CreateGroupRequest.newBuilder()
            .setName(name)
            .setGroup(group)
            .setValidateOnly(validateOnly)
            .build();
    return createGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new group. The project ID in the URL path must refer to a
   * Stackdriver account.
   *
   * Sample code:
   * <pre><code>
   * try (GroupServiceApi groupServiceApi = GroupServiceApi.create()) {
   *   String formattedName = GroupServiceApi.formatProjectName("[PROJECT]");
   *   Group group = Group.newBuilder().build();
   *   boolean validateOnly = false;
   *   CreateGroupRequest request = CreateGroupRequest.newBuilder()
   *     .setName(formattedName)
   *     .setGroup(group)
   *     .setValidateOnly(validateOnly)
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
   * Creates a new group. The project ID in the URL path must refer to a
   * Stackdriver account.
   *
   * Sample code:
   * <pre><code>
   * try (GroupServiceApi groupServiceApi = GroupServiceApi.create()) {
   *   String formattedName = GroupServiceApi.formatProjectName("[PROJECT]");
   *   Group group = Group.newBuilder().build();
   *   boolean validateOnly = false;
   *   CreateGroupRequest request = CreateGroupRequest.newBuilder()
   *     .setName(formattedName)
   *     .setGroup(group)
   *     .setValidateOnly(validateOnly)
   *     .build();
   *   ListenableFuture&lt;Group&gt; future = groupServiceApi.createGroupCallable().futureCall(request);
   *   // Do something
   *   Group response = future.get();
   * }
   * </code></pre>
   */
  public final ApiCallable<CreateGroupRequest, Group> createGroupCallable() {
    return createGroupCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an existing group.
   * You can change any group attributes except `name`.
   * The project ID in the URL path must refer to a Stackdriver account.
   *
   * Sample code:
   * <pre><code>
   * try (GroupServiceApi groupServiceApi = GroupServiceApi.create()) {
   *   Group group = Group.newBuilder().build();
   *   boolean validateOnly = false;
   *   Group response = groupServiceApi.updateGroup(group, validateOnly);
   * }
   * </code></pre>
   *
   * @param group The new definition of the group.  All fields of the existing group,
   * excepting `name`, are replaced with the corresponding fields of this group.
   * @param validateOnly If true, validate this request but do not update the existing group.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final Group updateGroup(Group group, boolean validateOnly) {
    UpdateGroupRequest request =
        UpdateGroupRequest.newBuilder().setGroup(group).setValidateOnly(validateOnly).build();
    return updateGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an existing group.
   * You can change any group attributes except `name`.
   * The project ID in the URL path must refer to a Stackdriver account.
   *
   * Sample code:
   * <pre><code>
   * try (GroupServiceApi groupServiceApi = GroupServiceApi.create()) {
   *   Group group = Group.newBuilder().build();
   *   boolean validateOnly = false;
   *   UpdateGroupRequest request = UpdateGroupRequest.newBuilder()
   *     .setGroup(group)
   *     .setValidateOnly(validateOnly)
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
   * Updates an existing group.
   * You can change any group attributes except `name`.
   * The project ID in the URL path must refer to a Stackdriver account.
   *
   * Sample code:
   * <pre><code>
   * try (GroupServiceApi groupServiceApi = GroupServiceApi.create()) {
   *   Group group = Group.newBuilder().build();
   *   boolean validateOnly = false;
   *   UpdateGroupRequest request = UpdateGroupRequest.newBuilder()
   *     .setGroup(group)
   *     .setValidateOnly(validateOnly)
   *     .build();
   *   ListenableFuture&lt;Group&gt; future = groupServiceApi.updateGroupCallable().futureCall(request);
   *   // Do something
   *   Group response = future.get();
   * }
   * </code></pre>
   */
  public final ApiCallable<UpdateGroupRequest, Group> updateGroupCallable() {
    return updateGroupCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes an existing group. The project ID in the URL path must refer to a
   * Stackdriver account.
   *
   * Sample code:
   * <pre><code>
   * try (GroupServiceApi groupServiceApi = GroupServiceApi.create()) {
   *   String formattedName = GroupServiceApi.formatGroupName("[PROJECT]", "[GROUP]");
   *   groupServiceApi.deleteGroup(formattedName);
   * }
   * </code></pre>
   *
   * @param name The group to delete. The format is
   * `"projects/{project_id_or_number}/groups/{group_id}"`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final void deleteGroup(String name) {
    GROUP_PATH_TEMPLATE.validate(name, "deleteGroup");
    DeleteGroupRequest request = DeleteGroupRequest.newBuilder().setName(name).build();
    deleteGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes an existing group. The project ID in the URL path must refer to a
   * Stackdriver account.
   *
   * Sample code:
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
   * Deletes an existing group. The project ID in the URL path must refer to a
   * Stackdriver account.
   *
   * Sample code:
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
  public final ApiCallable<DeleteGroupRequest, Empty> deleteGroupCallable() {
    return deleteGroupCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the monitored resources that are members of a group. The project ID
   * in the URL path must refer to a Stackdriver account.
   *
   * Sample code:
   * <pre><code>
   * try (GroupServiceApi groupServiceApi = GroupServiceApi.create()) {
   *   String formattedName = GroupServiceApi.formatGroupName("[PROJECT]", "[GROUP]");
   *   String filter = "";
   *   TimeInterval interval = TimeInterval.newBuilder().build();
   *   for (MonitoredResource element : groupServiceApi.listGroupMembers(formattedName, filter, interval).iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param name The group whose members are listed. The format is
   * `"projects/{project_id_or_number}/groups/{group_id}"`.
   * @param filter An optional [list filter](/monitoring/api/learn_more#filtering) describing
   * the members to be returned.  The filter may reference the type, labels, and
   * metadata of monitored resources that comprise the group.
   * For example, to return only resources representing Compute Engine VM
   * instances, use this filter:
   *
   *     resource.type = "gce_instance"
   * @param interval An optional time interval for which results should be returned. Only
   * members that were part of the group during the specified interval are
   * included in the response.  If no interval is provided then the group
   * membership over the last minute is returned.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final PagedListResponse<
          ListGroupMembersRequest, ListGroupMembersResponse, MonitoredResource>
      listGroupMembers(String name, String filter, TimeInterval interval) {
    GROUP_PATH_TEMPLATE.validate(name, "listGroupMembers");
    ListGroupMembersRequest request =
        ListGroupMembersRequest.newBuilder()
            .setName(name)
            .setFilter(filter)
            .setInterval(interval)
            .build();
    return listGroupMembers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the monitored resources that are members of a group. The project ID
   * in the URL path must refer to a Stackdriver account.
   *
   * Sample code:
   * <pre><code>
   * try (GroupServiceApi groupServiceApi = GroupServiceApi.create()) {
   *   String formattedName = GroupServiceApi.formatGroupName("[PROJECT]", "[GROUP]");
   *   String filter = "";
   *   TimeInterval interval = TimeInterval.newBuilder().build();
   *   ListGroupMembersRequest request = ListGroupMembersRequest.newBuilder()
   *     .setName(formattedName)
   *     .setFilter(filter)
   *     .setInterval(interval)
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
  public final PagedListResponse<
          ListGroupMembersRequest, ListGroupMembersResponse, MonitoredResource>
      listGroupMembers(ListGroupMembersRequest request) {
    return listGroupMembersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the monitored resources that are members of a group. The project ID
   * in the URL path must refer to a Stackdriver account.
   *
   * Sample code:
   * <pre><code>
   * try (GroupServiceApi groupServiceApi = GroupServiceApi.create()) {
   *   String formattedName = GroupServiceApi.formatGroupName("[PROJECT]", "[GROUP]");
   *   String filter = "";
   *   TimeInterval interval = TimeInterval.newBuilder().build();
   *   ListGroupMembersRequest request = ListGroupMembersRequest.newBuilder()
   *     .setName(formattedName)
   *     .setFilter(filter)
   *     .setInterval(interval)
   *     .build();
   *   ListenableFuture&lt;PagedListResponse&lt;ListGroupMembersRequest,ListGroupMembersResponse,MonitoredResource&gt;&gt; future = groupServiceApi.listGroupMembersPagedCallable().futureCall(request);
   *   // Do something
   *   for (MonitoredResource element : future.get().iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final ApiCallable<
          ListGroupMembersRequest,
          PagedListResponse<ListGroupMembersRequest, ListGroupMembersResponse, MonitoredResource>>
      listGroupMembersPagedCallable() {
    return listGroupMembersPagedCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the monitored resources that are members of a group. The project ID
   * in the URL path must refer to a Stackdriver account.
   *
   * Sample code:
   * <pre><code>
   * try (GroupServiceApi groupServiceApi = GroupServiceApi.create()) {
   *   String formattedName = GroupServiceApi.formatGroupName("[PROJECT]", "[GROUP]");
   *   String filter = "";
   *   TimeInterval interval = TimeInterval.newBuilder().build();
   *   ListGroupMembersRequest request = ListGroupMembersRequest.newBuilder()
   *     .setName(formattedName)
   *     .setFilter(filter)
   *     .setInterval(interval)
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
  public final ApiCallable<ListGroupMembersRequest, ListGroupMembersResponse>
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
