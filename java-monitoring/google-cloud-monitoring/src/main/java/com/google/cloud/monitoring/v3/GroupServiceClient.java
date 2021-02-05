/*
 * Copyright 2020 Google LLC
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
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.monitoring.v3.stub.GroupServiceStub;
import com.google.cloud.monitoring.v3.stub.GroupServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.monitoring.v3.CreateGroupRequest;
import com.google.monitoring.v3.DeleteGroupRequest;
import com.google.monitoring.v3.GetGroupRequest;
import com.google.monitoring.v3.Group;
import com.google.monitoring.v3.GroupName;
import com.google.monitoring.v3.ListGroupMembersRequest;
import com.google.monitoring.v3.ListGroupMembersResponse;
import com.google.monitoring.v3.ListGroupsRequest;
import com.google.monitoring.v3.ListGroupsResponse;
import com.google.monitoring.v3.OrganizationName;
import com.google.monitoring.v3.ProjectName;
import com.google.monitoring.v3.UpdateGroupRequest;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The Group API lets you inspect and manage your
 * [groups](#google.monitoring.v3.Group).
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
 * <p>Note: close() needs to be called on the GroupServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of GroupServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * GroupServiceSettings groupServiceSettings =
 *     GroupServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GroupServiceClient groupServiceClient = GroupServiceClient.create(groupServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * GroupServiceSettings groupServiceSettings =
 *     GroupServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GroupServiceClient groupServiceClient = GroupServiceClient.create(groupServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
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
   * for advanced usage - prefer using create(GroupServiceSettings).
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the existing groups.
   *
   * @param name Required. The project whose groups are to be listed. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGroupsPagedResponse listGroups(ResourceName name) {
    ListGroupsRequest request =
        ListGroupsRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return listGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the existing groups.
   *
   * @param name Required. The project whose groups are to be listed. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGroupsPagedResponse listGroups(OrganizationName name) {
    ListGroupsRequest request =
        ListGroupsRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return listGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the existing groups.
   *
   * @param name Required. The project whose groups are to be listed. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGroupsPagedResponse listGroups(ProjectName name) {
    ListGroupsRequest request =
        ListGroupsRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return listGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the existing groups.
   *
   * @param name Required. The project whose groups are to be listed. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGroupsPagedResponse listGroups(String name) {
    ListGroupsRequest request = ListGroupsRequest.newBuilder().setName(name).build();
    return listGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the existing groups.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGroupsPagedResponse listGroups(ListGroupsRequest request) {
    return listGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the existing groups.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListGroupsRequest, ListGroupsPagedResponse> listGroupsPagedCallable() {
    return stub.listGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the existing groups.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListGroupsRequest, ListGroupsResponse> listGroupsCallable() {
    return stub.listGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single group.
   *
   * @param name Required. The group to retrieve. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]/groups/[GROUP_ID]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Group getGroup(GroupName name) {
    GetGroupRequest request =
        GetGroupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single group.
   *
   * @param name Required. The group to retrieve. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]/groups/[GROUP_ID]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Group getGroup(String name) {
    GetGroupRequest request = GetGroupRequest.newBuilder().setName(name).build();
    return getGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single group.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Group getGroup(GetGroupRequest request) {
    return getGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single group.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetGroupRequest, Group> getGroupCallable() {
    return stub.getGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new group.
   *
   * @param name Required. The project in which to create the group. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]
   * @param group Required. A group definition. It is an error to define the `name` field because
   *     the system assigns the name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Group createGroup(ResourceName name, Group group) {
    CreateGroupRequest request =
        CreateGroupRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setGroup(group)
            .build();
    return createGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new group.
   *
   * @param name Required. The project in which to create the group. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]
   * @param group Required. A group definition. It is an error to define the `name` field because
   *     the system assigns the name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Group createGroup(OrganizationName name, Group group) {
    CreateGroupRequest request =
        CreateGroupRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setGroup(group)
            .build();
    return createGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new group.
   *
   * @param name Required. The project in which to create the group. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]
   * @param group Required. A group definition. It is an error to define the `name` field because
   *     the system assigns the name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Group createGroup(ProjectName name, Group group) {
    CreateGroupRequest request =
        CreateGroupRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setGroup(group)
            .build();
    return createGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new group.
   *
   * @param name Required. The project in which to create the group. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]
   * @param group Required. A group definition. It is an error to define the `name` field because
   *     the system assigns the name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Group createGroup(String name, Group group) {
    CreateGroupRequest request =
        CreateGroupRequest.newBuilder().setName(name).setGroup(group).build();
    return createGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new group.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Group createGroup(CreateGroupRequest request) {
    return createGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new group.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateGroupRequest, Group> createGroupCallable() {
    return stub.createGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing group. You can change any group attributes except `name`.
   *
   * @param group Required. The new definition of the group. All fields of the existing group,
   *     excepting `name`, are replaced with the corresponding fields of this group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Group updateGroup(Group group) {
    UpdateGroupRequest request = UpdateGroupRequest.newBuilder().setGroup(group).build();
    return updateGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing group. You can change any group attributes except `name`.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Group updateGroup(UpdateGroupRequest request) {
    return updateGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing group. You can change any group attributes except `name`.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateGroupRequest, Group> updateGroupCallable() {
    return stub.updateGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing group.
   *
   * @param name Required. The group to delete. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]/groups/[GROUP_ID]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteGroup(GroupName name) {
    DeleteGroupRequest request =
        DeleteGroupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing group.
   *
   * @param name Required. The group to delete. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]/groups/[GROUP_ID]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteGroup(String name) {
    DeleteGroupRequest request = DeleteGroupRequest.newBuilder().setName(name).build();
    deleteGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing group.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteGroup(DeleteGroupRequest request) {
    deleteGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing group.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteGroupRequest, Empty> deleteGroupCallable() {
    return stub.deleteGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the monitored resources that are members of a group.
   *
   * @param name Required. The group whose members are listed. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]/groups/[GROUP_ID]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGroupMembersPagedResponse listGroupMembers(GroupName name) {
    ListGroupMembersRequest request =
        ListGroupMembersRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return listGroupMembers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the monitored resources that are members of a group.
   *
   * @param name Required. The group whose members are listed. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]/groups/[GROUP_ID]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGroupMembersPagedResponse listGroupMembers(String name) {
    ListGroupMembersRequest request = ListGroupMembersRequest.newBuilder().setName(name).build();
    return listGroupMembers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the monitored resources that are members of a group.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGroupMembersPagedResponse listGroupMembers(ListGroupMembersRequest request) {
    return listGroupMembersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the monitored resources that are members of a group.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListGroupMembersRequest, ListGroupMembersPagedResponse>
      listGroupMembersPagedCallable() {
    return stub.listGroupMembersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the monitored resources that are members of a group.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListGroupMembersRequest, ListGroupMembersResponse>
      listGroupMembersCallable() {
    return stub.listGroupMembersCallable();
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

  public static class ListGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListGroupsRequest,
          ListGroupsResponse,
          Group,
          ListGroupsPage,
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
          },
          MoreExecutors.directExecutor());
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
          ListGroupsRequest,
          ListGroupsResponse,
          Group,
          ListGroupsPage,
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
          ListGroupMembersRequest,
          ListGroupMembersResponse,
          MonitoredResource,
          ListGroupMembersPage,
          ListGroupMembersFixedSizeCollection> {

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
          },
          MoreExecutors.directExecutor());
    }

    private ListGroupMembersPagedResponse(ListGroupMembersPage page) {
      super(page, ListGroupMembersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGroupMembersPage
      extends AbstractPage<
          ListGroupMembersRequest,
          ListGroupMembersResponse,
          MonitoredResource,
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
          ListGroupMembersRequest,
          ListGroupMembersResponse,
          MonitoredResource,
          ListGroupMembersPage,
          ListGroupMembersFixedSizeCollection> {

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
