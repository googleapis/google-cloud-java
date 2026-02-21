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

package com.google.ads.datamanager.v1.stub;

import static com.google.ads.datamanager.v1.UserListServiceClient.ListUserListsPagedResponse;

import com.google.ads.datamanager.v1.CreateUserListRequest;
import com.google.ads.datamanager.v1.DeleteUserListRequest;
import com.google.ads.datamanager.v1.GetUserListRequest;
import com.google.ads.datamanager.v1.ListUserListsRequest;
import com.google.ads.datamanager.v1.ListUserListsResponse;
import com.google.ads.datamanager.v1.UpdateUserListRequest;
import com.google.ads.datamanager.v1.UserList;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the UserListService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcUserListServiceStub extends UserListServiceStub {
  private static final MethodDescriptor<GetUserListRequest, UserList> getUserListMethodDescriptor =
      MethodDescriptor.<GetUserListRequest, UserList>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.ads.datamanager.v1.UserListService/GetUserList")
          .setRequestMarshaller(ProtoUtils.marshaller(GetUserListRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(UserList.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListUserListsRequest, ListUserListsResponse>
      listUserListsMethodDescriptor =
          MethodDescriptor.<ListUserListsRequest, ListUserListsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.ads.datamanager.v1.UserListService/ListUserLists")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListUserListsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListUserListsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateUserListRequest, UserList>
      createUserListMethodDescriptor =
          MethodDescriptor.<CreateUserListRequest, UserList>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.ads.datamanager.v1.UserListService/CreateUserList")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateUserListRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(UserList.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateUserListRequest, UserList>
      updateUserListMethodDescriptor =
          MethodDescriptor.<UpdateUserListRequest, UserList>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.ads.datamanager.v1.UserListService/UpdateUserList")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateUserListRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(UserList.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteUserListRequest, Empty>
      deleteUserListMethodDescriptor =
          MethodDescriptor.<DeleteUserListRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.ads.datamanager.v1.UserListService/DeleteUserList")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteUserListRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<GetUserListRequest, UserList> getUserListCallable;
  private final UnaryCallable<ListUserListsRequest, ListUserListsResponse> listUserListsCallable;
  private final UnaryCallable<ListUserListsRequest, ListUserListsPagedResponse>
      listUserListsPagedCallable;
  private final UnaryCallable<CreateUserListRequest, UserList> createUserListCallable;
  private final UnaryCallable<UpdateUserListRequest, UserList> updateUserListCallable;
  private final UnaryCallable<DeleteUserListRequest, Empty> deleteUserListCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcUserListServiceStub create(UserListServiceStubSettings settings)
      throws IOException {
    return new GrpcUserListServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcUserListServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcUserListServiceStub(
        UserListServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcUserListServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcUserListServiceStub(
        UserListServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcUserListServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcUserListServiceStub(
      UserListServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcUserListServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcUserListServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcUserListServiceStub(
      UserListServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetUserListRequest, UserList> getUserListTransportSettings =
        GrpcCallSettings.<GetUserListRequest, UserList>newBuilder()
            .setMethodDescriptor(getUserListMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListUserListsRequest, ListUserListsResponse> listUserListsTransportSettings =
        GrpcCallSettings.<ListUserListsRequest, ListUserListsResponse>newBuilder()
            .setMethodDescriptor(listUserListsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateUserListRequest, UserList> createUserListTransportSettings =
        GrpcCallSettings.<CreateUserListRequest, UserList>newBuilder()
            .setMethodDescriptor(createUserListMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateUserListRequest, UserList> updateUserListTransportSettings =
        GrpcCallSettings.<UpdateUserListRequest, UserList>newBuilder()
            .setMethodDescriptor(updateUserListMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("user_list.name", String.valueOf(request.getUserList().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteUserListRequest, Empty> deleteUserListTransportSettings =
        GrpcCallSettings.<DeleteUserListRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteUserListMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.getUserListCallable =
        callableFactory.createUnaryCallable(
            getUserListTransportSettings, settings.getUserListSettings(), clientContext);
    this.listUserListsCallable =
        callableFactory.createUnaryCallable(
            listUserListsTransportSettings, settings.listUserListsSettings(), clientContext);
    this.listUserListsPagedCallable =
        callableFactory.createPagedCallable(
            listUserListsTransportSettings, settings.listUserListsSettings(), clientContext);
    this.createUserListCallable =
        callableFactory.createUnaryCallable(
            createUserListTransportSettings, settings.createUserListSettings(), clientContext);
    this.updateUserListCallable =
        callableFactory.createUnaryCallable(
            updateUserListTransportSettings, settings.updateUserListSettings(), clientContext);
    this.deleteUserListCallable =
        callableFactory.createUnaryCallable(
            deleteUserListTransportSettings, settings.deleteUserListSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetUserListRequest, UserList> getUserListCallable() {
    return getUserListCallable;
  }

  @Override
  public UnaryCallable<ListUserListsRequest, ListUserListsResponse> listUserListsCallable() {
    return listUserListsCallable;
  }

  @Override
  public UnaryCallable<ListUserListsRequest, ListUserListsPagedResponse>
      listUserListsPagedCallable() {
    return listUserListsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateUserListRequest, UserList> createUserListCallable() {
    return createUserListCallable;
  }

  @Override
  public UnaryCallable<UpdateUserListRequest, UserList> updateUserListCallable() {
    return updateUserListCallable;
  }

  @Override
  public UnaryCallable<DeleteUserListRequest, Empty> deleteUserListCallable() {
    return deleteUserListCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
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
