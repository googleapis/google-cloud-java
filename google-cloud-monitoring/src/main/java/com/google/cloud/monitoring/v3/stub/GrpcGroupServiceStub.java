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
package com.google.cloud.monitoring.v3.stub;

import static com.google.cloud.monitoring.v3.PagedResponseWrappers.ListGroupMembersPagedResponse;
import static com.google.cloud.monitoring.v3.PagedResponseWrappers.ListGroupsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.monitoring.v3.GroupServiceSettings;
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
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Stackdriver Monitoring API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class GrpcGroupServiceStub extends GroupServiceStub {
  private static final UnaryCallable<ListGroupsRequest, ListGroupsResponse>
      directListGroupsCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.monitoring.v3.GroupService/ListGroups",
                  io.grpc.protobuf.ProtoUtils.marshaller(ListGroupsRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(ListGroupsResponse.getDefaultInstance())));
  private static final UnaryCallable<GetGroupRequest, Group> directGetGroupCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.monitoring.v3.GroupService/GetGroup",
              io.grpc.protobuf.ProtoUtils.marshaller(GetGroupRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Group.getDefaultInstance())));
  private static final UnaryCallable<CreateGroupRequest, Group> directCreateGroupCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.monitoring.v3.GroupService/CreateGroup",
              io.grpc.protobuf.ProtoUtils.marshaller(CreateGroupRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Group.getDefaultInstance())));
  private static final UnaryCallable<UpdateGroupRequest, Group> directUpdateGroupCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.monitoring.v3.GroupService/UpdateGroup",
              io.grpc.protobuf.ProtoUtils.marshaller(UpdateGroupRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Group.getDefaultInstance())));
  private static final UnaryCallable<DeleteGroupRequest, Empty> directDeleteGroupCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.monitoring.v3.GroupService/DeleteGroup",
              io.grpc.protobuf.ProtoUtils.marshaller(DeleteGroupRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Empty.getDefaultInstance())));
  private static final UnaryCallable<ListGroupMembersRequest, ListGroupMembersResponse>
      directListGroupMembersCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.monitoring.v3.GroupService/ListGroupMembers",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ListGroupMembersRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ListGroupMembersResponse.getDefaultInstance())));

  private final BackgroundResource backgroundResources;

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

  public static final GrpcGroupServiceStub create(GroupServiceSettings settings)
      throws IOException {
    return new GrpcGroupServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcGroupServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcGroupServiceStub(GroupServiceSettings.defaultBuilder().build(), clientContext);
  }

  /**
   * Constructs an instance of GrpcGroupServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcGroupServiceStub(GroupServiceSettings settings, ClientContext clientContext)
      throws IOException {

    this.listGroupsCallable =
        GrpcCallableFactory.create(
            directListGroupsCallable, settings.listGroupsSettings(), clientContext);
    this.listGroupsPagedCallable =
        GrpcCallableFactory.createPagedVariant(
            directListGroupsCallable, settings.listGroupsSettings(), clientContext);
    this.getGroupCallable =
        GrpcCallableFactory.create(
            directGetGroupCallable, settings.getGroupSettings(), clientContext);
    this.createGroupCallable =
        GrpcCallableFactory.create(
            directCreateGroupCallable, settings.createGroupSettings(), clientContext);
    this.updateGroupCallable =
        GrpcCallableFactory.create(
            directUpdateGroupCallable, settings.updateGroupSettings(), clientContext);
    this.deleteGroupCallable =
        GrpcCallableFactory.create(
            directDeleteGroupCallable, settings.deleteGroupSettings(), clientContext);
    this.listGroupMembersCallable =
        GrpcCallableFactory.create(
            directListGroupMembersCallable, settings.listGroupMembersSettings(), clientContext);
    this.listGroupMembersPagedCallable =
        GrpcCallableFactory.createPagedVariant(
            directListGroupMembersCallable, settings.listGroupMembersSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<ListGroupsRequest, ListGroupsPagedResponse> listGroupsPagedCallable() {
    return listGroupsPagedCallable;
  }

  public UnaryCallable<ListGroupsRequest, ListGroupsResponse> listGroupsCallable() {
    return listGroupsCallable;
  }

  public UnaryCallable<GetGroupRequest, Group> getGroupCallable() {
    return getGroupCallable;
  }

  public UnaryCallable<CreateGroupRequest, Group> createGroupCallable() {
    return createGroupCallable;
  }

  public UnaryCallable<UpdateGroupRequest, Group> updateGroupCallable() {
    return updateGroupCallable;
  }

  public UnaryCallable<DeleteGroupRequest, Empty> deleteGroupCallable() {
    return deleteGroupCallable;
  }

  public UnaryCallable<ListGroupMembersRequest, ListGroupMembersPagedResponse>
      listGroupMembersPagedCallable() {
    return listGroupMembersPagedCallable;
  }

  public UnaryCallable<ListGroupMembersRequest, ListGroupMembersResponse>
      listGroupMembersCallable() {
    return listGroupMembersCallable;
  }

  @Override
  public final void close() throws Exception {
    shutdown();
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
