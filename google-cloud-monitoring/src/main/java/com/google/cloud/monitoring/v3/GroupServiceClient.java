/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.monitoring.v3;

import com.google.api.MonitoredResource;
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
import com.google.cloud.monitoring.v3.stub.GroupServiceStub;
import com.google.cloud.monitoring.v3.stub.GroupServiceStubSettings;
import com.google.monitoring.v3.CreateGroupRequest;
import com.google.monitoring.v3.DeleteGroupRequest;
import com.google.monitoring.v3.GetGroupRequest;
import com.google.monitoring.v3.Group;
import com.google.monitoring.v3.GroupName;
import com.google.monitoring.v3.ListGroupMembersRequest;
import com.google.monitoring.v3.ListGroupMembersResponse;
import com.google.monitoring.v3.ListGroupsRequest;
import com.google.monitoring.v3.ListGroupsResponse;
import com.google.monitoring.v3.ProjectName;
import com.google.monitoring.v3.UpdateGroupRequest;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

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
 * try (GroupServiceClient groupServiceClient = GroupServiceClient.create()) {
 *   GroupName name = GroupName.of("[PROJECT]", "[GROUP]");
 *   Group response = groupServiceClient.getGroup(name);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the groupServiceClient object to clean up resources such
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
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * GroupServiceSettings groupServiceSettings =
 *     GroupServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GroupServiceClient groupServiceClient =
 *     GroupServiceClient.create(groupServiceSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * GroupServiceSettings groupServiceSettings =
 *     GroupServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GroupServiceClient groupServiceClient =
 *     GroupServiceClient.create(groupServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class GroupServiceClient implements BackgroundResource {
  private final GroupServiceSettings settings;
  private final GroupServiceStub stub;

  /** Constructs an instance of GroupServiceClient with default settings. */
  public static final GroupServiceClient create() throws IOException {
    return create(GroupServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of GroupServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final GroupServiceClient create(GroupServiceSettings settings) throws IOException {
    return new GroupServiceClient(settings);
  }

  /**
   * Constructs an instance of GroupServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use GroupServiceSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final GroupServiceClient create(GroupServiceStub stub) {
    return new GroupServiceClient(stub);
  }

  /**
   * Constructs an instance of GroupServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GroupServiceClient(GroupServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((GroupServiceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected GroupServiceClient(GroupServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final GroupServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public GroupServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the existing groups.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GroupServiceClient groupServiceClient = GroupServiceClient.create()) {
   *   ProjectName name = ProjectName.of("[PROJECT]");
   *   ListGroupsRequest request = ListGroupsRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   for (Group element : groupServiceClient.listGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
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
   * try (GroupServiceClient groupServiceClient = GroupServiceClient.create()) {
   *   ProjectName name = ProjectName.of("[PROJECT]");
   *   ListGroupsRequest request = ListGroupsRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;ListGroupsPagedResponse&gt; future = groupServiceClient.listGroupsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Group element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListGroupsRequest, ListGroupsPagedResponse> listGroupsPagedCallable() {
    return stub.listGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the existing groups.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GroupServiceClient groupServiceClient = GroupServiceClient.create()) {
   *   ProjectName name = ProjectName.of("[PROJECT]");
   *   ListGroupsRequest request = ListGroupsRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   while (true) {
   *     ListGroupsResponse response = groupServiceClient.listGroupsCallable().call(request);
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
    return stub.listGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a single group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GroupServiceClient groupServiceClient = GroupServiceClient.create()) {
   *   GroupName name = GroupName.of("[PROJECT]", "[GROUP]");
   *   Group response = groupServiceClient.getGroup(name);
   * }
   * </code></pre>
   *
   * @param name The group to retrieve. The format is
   *     `"projects/{project_id_or_number}/groups/{group_id}"`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Group getGroup(GroupName name) {

    GetGroupRequest request = GetGroupRequest.newBuilder().setName(name.toString()).build();
    return getGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a single group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GroupServiceClient groupServiceClient = GroupServiceClient.create()) {
   *   GroupName name = GroupName.of("[PROJECT]", "[GROUP]");
   *   GetGroupRequest request = GetGroupRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   Group response = groupServiceClient.getGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
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
   * try (GroupServiceClient groupServiceClient = GroupServiceClient.create()) {
   *   GroupName name = GroupName.of("[PROJECT]", "[GROUP]");
   *   GetGroupRequest request = GetGroupRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Group&gt; future = groupServiceClient.getGroupCallable().futureCall(request);
   *   // Do something
   *   Group response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetGroupRequest, Group> getGroupCallable() {
    return stub.getGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GroupServiceClient groupServiceClient = GroupServiceClient.create()) {
   *   ProjectName name = ProjectName.of("[PROJECT]");
   *   Group group = Group.newBuilder().build();
   *   Group response = groupServiceClient.createGroup(name, group);
   * }
   * </code></pre>
   *
   * @param name The project in which to create the group. The format is
   *     `"projects/{project_id_or_number}"`.
   * @param group A group definition. It is an error to define the `name` field because the system
   *     assigns the name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Group createGroup(ProjectName name, Group group) {

    CreateGroupRequest request =
        CreateGroupRequest.newBuilder().setName(name.toString()).setGroup(group).build();
    return createGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GroupServiceClient groupServiceClient = GroupServiceClient.create()) {
   *   ProjectName name = ProjectName.of("[PROJECT]");
   *   Group group = Group.newBuilder().build();
   *   CreateGroupRequest request = CreateGroupRequest.newBuilder()
   *     .setName(name.toString())
   *     .setGroup(group)
   *     .build();
   *   Group response = groupServiceClient.createGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
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
   * try (GroupServiceClient groupServiceClient = GroupServiceClient.create()) {
   *   ProjectName name = ProjectName.of("[PROJECT]");
   *   Group group = Group.newBuilder().build();
   *   CreateGroupRequest request = CreateGroupRequest.newBuilder()
   *     .setName(name.toString())
   *     .setGroup(group)
   *     .build();
   *   ApiFuture&lt;Group&gt; future = groupServiceClient.createGroupCallable().futureCall(request);
   *   // Do something
   *   Group response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateGroupRequest, Group> createGroupCallable() {
    return stub.createGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an existing group. You can change any group attributes except `name`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GroupServiceClient groupServiceClient = GroupServiceClient.create()) {
   *   Group group = Group.newBuilder().build();
   *   Group response = groupServiceClient.updateGroup(group);
   * }
   * </code></pre>
   *
   * @param group The new definition of the group. All fields of the existing group, excepting
   *     `name`, are replaced with the corresponding fields of this group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
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
   * try (GroupServiceClient groupServiceClient = GroupServiceClient.create()) {
   *   Group group = Group.newBuilder().build();
   *   UpdateGroupRequest request = UpdateGroupRequest.newBuilder()
   *     .setGroup(group)
   *     .build();
   *   Group response = groupServiceClient.updateGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
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
   * try (GroupServiceClient groupServiceClient = GroupServiceClient.create()) {
   *   Group group = Group.newBuilder().build();
   *   UpdateGroupRequest request = UpdateGroupRequest.newBuilder()
   *     .setGroup(group)
   *     .build();
   *   ApiFuture&lt;Group&gt; future = groupServiceClient.updateGroupCallable().futureCall(request);
   *   // Do something
   *   Group response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateGroupRequest, Group> updateGroupCallable() {
    return stub.updateGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes an existing group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GroupServiceClient groupServiceClient = GroupServiceClient.create()) {
   *   GroupName name = GroupName.of("[PROJECT]", "[GROUP]");
   *   groupServiceClient.deleteGroup(name);
   * }
   * </code></pre>
   *
   * @param name The group to delete. The format is
   *     `"projects/{project_id_or_number}/groups/{group_id}"`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteGroup(GroupName name) {

    DeleteGroupRequest request = DeleteGroupRequest.newBuilder().setName(name.toString()).build();
    deleteGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes an existing group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GroupServiceClient groupServiceClient = GroupServiceClient.create()) {
   *   GroupName name = GroupName.of("[PROJECT]", "[GROUP]");
   *   DeleteGroupRequest request = DeleteGroupRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   groupServiceClient.deleteGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
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
   * try (GroupServiceClient groupServiceClient = GroupServiceClient.create()) {
   *   GroupName name = GroupName.of("[PROJECT]", "[GROUP]");
   *   DeleteGroupRequest request = DeleteGroupRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Void&gt; future = groupServiceClient.deleteGroupCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteGroupRequest, Empty> deleteGroupCallable() {
    return stub.deleteGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the monitored resources that are members of a group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GroupServiceClient groupServiceClient = GroupServiceClient.create()) {
   *   GroupName name = GroupName.of("[PROJECT]", "[GROUP]");
   *   for (MonitoredResource element : groupServiceClient.listGroupMembers(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param name The group whose members are listed. The format is
   *     `"projects/{project_id_or_number}/groups/{group_id}"`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGroupMembersPagedResponse listGroupMembers(GroupName name) {
    ListGroupMembersRequest request =
        ListGroupMembersRequest.newBuilder().setName(name.toString()).build();
    return listGroupMembers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the monitored resources that are members of a group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GroupServiceClient groupServiceClient = GroupServiceClient.create()) {
   *   GroupName name = GroupName.of("[PROJECT]", "[GROUP]");
   *   ListGroupMembersRequest request = ListGroupMembersRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   for (MonitoredResource element : groupServiceClient.listGroupMembers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
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
   * try (GroupServiceClient groupServiceClient = GroupServiceClient.create()) {
   *   GroupName name = GroupName.of("[PROJECT]", "[GROUP]");
   *   ListGroupMembersRequest request = ListGroupMembersRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;ListGroupMembersPagedResponse&gt; future = groupServiceClient.listGroupMembersPagedCallable().futureCall(request);
   *   // Do something
   *   for (MonitoredResource element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListGroupMembersRequest, ListGroupMembersPagedResponse>
      listGroupMembersPagedCallable() {
    return stub.listGroupMembersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the monitored resources that are members of a group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GroupServiceClient groupServiceClient = GroupServiceClient.create()) {
   *   GroupName name = GroupName.of("[PROJECT]", "[GROUP]");
   *   ListGroupMembersRequest request = ListGroupMembersRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   while (true) {
   *     ListGroupMembersResponse response = groupServiceClient.listGroupMembersCallable().call(request);
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
    return stub.listGroupMembersCallable();
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

  public static class ListGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListGroupsRequest, ListGroupsResponse, Group, ListGroupsPage,
          ListGroupsFixedSizeCollection> {

    public static ApiFuture<ListGroupsPagedResponse> createAsync(
        PageContext<ListGroupsRequest, ListGroupsResponse, Group> context,
        ApiFuture<ListGroupsResponse> futureResponse) {
      ApiFuture<ListGroupsPage> futurePage =
          ListGroupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListGroupsPage, ListGroupsPagedResponse>() {
            @Override
            public ListGroupsPagedResponse apply(ListGroupsPage input) {
              return new ListGroupsPagedResponse(input);
            }
          });
    }

    private ListGroupsPagedResponse(ListGroupsPage page) {
      super(page, ListGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGroupsPage
      extends AbstractPage<ListGroupsRequest, ListGroupsResponse, Group, ListGroupsPage> {

    private ListGroupsPage(
        PageContext<ListGroupsRequest, ListGroupsResponse, Group> context,
        ListGroupsResponse response) {
      super(context, response);
    }

    private static ListGroupsPage createEmptyPage() {
      return new ListGroupsPage(null, null);
    }

    @Override
    protected ListGroupsPage createPage(
        PageContext<ListGroupsRequest, ListGroupsResponse, Group> context,
        ListGroupsResponse response) {
      return new ListGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListGroupsPage> createPageAsync(
        PageContext<ListGroupsRequest, ListGroupsResponse, Group> context,
        ApiFuture<ListGroupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGroupsRequest, ListGroupsResponse, Group, ListGroupsPage,
          ListGroupsFixedSizeCollection> {

    private ListGroupsFixedSizeCollection(List<ListGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGroupsFixedSizeCollection createEmptyCollection() {
      return new ListGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGroupsFixedSizeCollection createCollection(
        List<ListGroupsPage> pages, int collectionSize) {
      return new ListGroupsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListGroupMembersPagedResponse
      extends AbstractPagedListResponse<
          ListGroupMembersRequest, ListGroupMembersResponse, MonitoredResource,
          ListGroupMembersPage, ListGroupMembersFixedSizeCollection> {

    public static ApiFuture<ListGroupMembersPagedResponse> createAsync(
        PageContext<ListGroupMembersRequest, ListGroupMembersResponse, MonitoredResource> context,
        ApiFuture<ListGroupMembersResponse> futureResponse) {
      ApiFuture<ListGroupMembersPage> futurePage =
          ListGroupMembersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListGroupMembersPage, ListGroupMembersPagedResponse>() {
            @Override
            public ListGroupMembersPagedResponse apply(ListGroupMembersPage input) {
              return new ListGroupMembersPagedResponse(input);
            }
          });
    }

    private ListGroupMembersPagedResponse(ListGroupMembersPage page) {
      super(page, ListGroupMembersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGroupMembersPage
      extends AbstractPage<
          ListGroupMembersRequest, ListGroupMembersResponse, MonitoredResource,
          ListGroupMembersPage> {

    private ListGroupMembersPage(
        PageContext<ListGroupMembersRequest, ListGroupMembersResponse, MonitoredResource> context,
        ListGroupMembersResponse response) {
      super(context, response);
    }

    private static ListGroupMembersPage createEmptyPage() {
      return new ListGroupMembersPage(null, null);
    }

    @Override
    protected ListGroupMembersPage createPage(
        PageContext<ListGroupMembersRequest, ListGroupMembersResponse, MonitoredResource> context,
        ListGroupMembersResponse response) {
      return new ListGroupMembersPage(context, response);
    }

    @Override
    public ApiFuture<ListGroupMembersPage> createPageAsync(
        PageContext<ListGroupMembersRequest, ListGroupMembersResponse, MonitoredResource> context,
        ApiFuture<ListGroupMembersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGroupMembersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGroupMembersRequest, ListGroupMembersResponse, MonitoredResource,
          ListGroupMembersPage, ListGroupMembersFixedSizeCollection> {

    private ListGroupMembersFixedSizeCollection(
        List<ListGroupMembersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGroupMembersFixedSizeCollection createEmptyCollection() {
      return new ListGroupMembersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGroupMembersFixedSizeCollection createCollection(
        List<ListGroupMembersPage> pages, int collectionSize) {
      return new ListGroupMembersFixedSizeCollection(pages, collectionSize);
    }
  }
}
