/*
 * Copyright 2024 Google LLC
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

package com.google.shopping.merchant.accounts.v1beta.stub;

import static com.google.shopping.merchant.accounts.v1beta.UserServiceClient.ListUsersPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.accounts.v1beta.CreateUserRequest;
import com.google.shopping.merchant.accounts.v1beta.DeleteUserRequest;
import com.google.shopping.merchant.accounts.v1beta.GetUserRequest;
import com.google.shopping.merchant.accounts.v1beta.ListUsersRequest;
import com.google.shopping.merchant.accounts.v1beta.ListUsersResponse;
import com.google.shopping.merchant.accounts.v1beta.UpdateUserRequest;
import com.google.shopping.merchant.accounts.v1beta.User;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the UserService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcUserServiceStub extends UserServiceStub {
  private static final MethodDescriptor<GetUserRequest, User> getUserMethodDescriptor =
      MethodDescriptor.<GetUserRequest, User>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.shopping.merchant.accounts.v1beta.UserService/GetUser")
          .setRequestMarshaller(ProtoUtils.marshaller(GetUserRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(User.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateUserRequest, User> createUserMethodDescriptor =
      MethodDescriptor.<CreateUserRequest, User>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.shopping.merchant.accounts.v1beta.UserService/CreateUser")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateUserRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(User.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteUserRequest, Empty> deleteUserMethodDescriptor =
      MethodDescriptor.<DeleteUserRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.shopping.merchant.accounts.v1beta.UserService/DeleteUser")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteUserRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateUserRequest, User> updateUserMethodDescriptor =
      MethodDescriptor.<UpdateUserRequest, User>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.shopping.merchant.accounts.v1beta.UserService/UpdateUser")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateUserRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(User.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListUsersRequest, ListUsersResponse>
      listUsersMethodDescriptor =
          MethodDescriptor.<ListUsersRequest, ListUsersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.shopping.merchant.accounts.v1beta.UserService/ListUsers")
              .setRequestMarshaller(ProtoUtils.marshaller(ListUsersRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListUsersResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetUserRequest, User> getUserCallable;
  private final UnaryCallable<CreateUserRequest, User> createUserCallable;
  private final UnaryCallable<DeleteUserRequest, Empty> deleteUserCallable;
  private final UnaryCallable<UpdateUserRequest, User> updateUserCallable;
  private final UnaryCallable<ListUsersRequest, ListUsersResponse> listUsersCallable;
  private final UnaryCallable<ListUsersRequest, ListUsersPagedResponse> listUsersPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcUserServiceStub create(UserServiceStubSettings settings)
      throws IOException {
    return new GrpcUserServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcUserServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcUserServiceStub(UserServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcUserServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcUserServiceStub(
        UserServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcUserServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcUserServiceStub(UserServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcUserServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcUserServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcUserServiceStub(
      UserServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetUserRequest, User> getUserTransportSettings =
        GrpcCallSettings.<GetUserRequest, User>newBuilder()
            .setMethodDescriptor(getUserMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateUserRequest, User> createUserTransportSettings =
        GrpcCallSettings.<CreateUserRequest, User>newBuilder()
            .setMethodDescriptor(createUserMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteUserRequest, Empty> deleteUserTransportSettings =
        GrpcCallSettings.<DeleteUserRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteUserMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateUserRequest, User> updateUserTransportSettings =
        GrpcCallSettings.<UpdateUserRequest, User>newBuilder()
            .setMethodDescriptor(updateUserMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("user.name", String.valueOf(request.getUser().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListUsersRequest, ListUsersResponse> listUsersTransportSettings =
        GrpcCallSettings.<ListUsersRequest, ListUsersResponse>newBuilder()
            .setMethodDescriptor(listUsersMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();

    this.getUserCallable =
        callableFactory.createUnaryCallable(
            getUserTransportSettings, settings.getUserSettings(), clientContext);
    this.createUserCallable =
        callableFactory.createUnaryCallable(
            createUserTransportSettings, settings.createUserSettings(), clientContext);
    this.deleteUserCallable =
        callableFactory.createUnaryCallable(
            deleteUserTransportSettings, settings.deleteUserSettings(), clientContext);
    this.updateUserCallable =
        callableFactory.createUnaryCallable(
            updateUserTransportSettings, settings.updateUserSettings(), clientContext);
    this.listUsersCallable =
        callableFactory.createUnaryCallable(
            listUsersTransportSettings, settings.listUsersSettings(), clientContext);
    this.listUsersPagedCallable =
        callableFactory.createPagedCallable(
            listUsersTransportSettings, settings.listUsersSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetUserRequest, User> getUserCallable() {
    return getUserCallable;
  }

  @Override
  public UnaryCallable<CreateUserRequest, User> createUserCallable() {
    return createUserCallable;
  }

  @Override
  public UnaryCallable<DeleteUserRequest, Empty> deleteUserCallable() {
    return deleteUserCallable;
  }

  @Override
  public UnaryCallable<UpdateUserRequest, User> updateUserCallable() {
    return updateUserCallable;
  }

  @Override
  public UnaryCallable<ListUsersRequest, ListUsersResponse> listUsersCallable() {
    return listUsersCallable;
  }

  @Override
  public UnaryCallable<ListUsersRequest, ListUsersPagedResponse> listUsersPagedCallable() {
    return listUsersPagedCallable;
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
