/*
 * Copyright 2024 Google LLC
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
package com.google.shopping.merchant.accounts.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service to support user API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/accounts/v1beta/user.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class UserServiceGrpc {

  private UserServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.accounts.v1beta.UserService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.GetUserRequest,
          com.google.shopping.merchant.accounts.v1beta.User>
      getGetUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUser",
      requestType = com.google.shopping.merchant.accounts.v1beta.GetUserRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.User.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.GetUserRequest,
          com.google.shopping.merchant.accounts.v1beta.User>
      getGetUserMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.GetUserRequest,
            com.google.shopping.merchant.accounts.v1beta.User>
        getGetUserMethod;
    if ((getGetUserMethod = UserServiceGrpc.getGetUserMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getGetUserMethod = UserServiceGrpc.getGetUserMethod) == null) {
          UserServiceGrpc.getGetUserMethod =
              getGetUserMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.GetUserRequest,
                          com.google.shopping.merchant.accounts.v1beta.User>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUser"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.GetUserRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.User
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("GetUser"))
                      .build();
        }
      }
    }
    return getGetUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.CreateUserRequest,
          com.google.shopping.merchant.accounts.v1beta.User>
      getCreateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUser",
      requestType = com.google.shopping.merchant.accounts.v1beta.CreateUserRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.User.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.CreateUserRequest,
          com.google.shopping.merchant.accounts.v1beta.User>
      getCreateUserMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.CreateUserRequest,
            com.google.shopping.merchant.accounts.v1beta.User>
        getCreateUserMethod;
    if ((getCreateUserMethod = UserServiceGrpc.getCreateUserMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getCreateUserMethod = UserServiceGrpc.getCreateUserMethod) == null) {
          UserServiceGrpc.getCreateUserMethod =
              getCreateUserMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.CreateUserRequest,
                          com.google.shopping.merchant.accounts.v1beta.User>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateUser"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.CreateUserRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.User
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("CreateUser"))
                      .build();
        }
      }
    }
    return getCreateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.DeleteUserRequest, com.google.protobuf.Empty>
      getDeleteUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteUser",
      requestType = com.google.shopping.merchant.accounts.v1beta.DeleteUserRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.DeleteUserRequest, com.google.protobuf.Empty>
      getDeleteUserMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.DeleteUserRequest,
            com.google.protobuf.Empty>
        getDeleteUserMethod;
    if ((getDeleteUserMethod = UserServiceGrpc.getDeleteUserMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getDeleteUserMethod = UserServiceGrpc.getDeleteUserMethod) == null) {
          UserServiceGrpc.getDeleteUserMethod =
              getDeleteUserMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.DeleteUserRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteUser"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.DeleteUserRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("DeleteUser"))
                      .build();
        }
      }
    }
    return getDeleteUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.UpdateUserRequest,
          com.google.shopping.merchant.accounts.v1beta.User>
      getUpdateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateUser",
      requestType = com.google.shopping.merchant.accounts.v1beta.UpdateUserRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.User.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.UpdateUserRequest,
          com.google.shopping.merchant.accounts.v1beta.User>
      getUpdateUserMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.UpdateUserRequest,
            com.google.shopping.merchant.accounts.v1beta.User>
        getUpdateUserMethod;
    if ((getUpdateUserMethod = UserServiceGrpc.getUpdateUserMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getUpdateUserMethod = UserServiceGrpc.getUpdateUserMethod) == null) {
          UserServiceGrpc.getUpdateUserMethod =
              getUpdateUserMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.UpdateUserRequest,
                          com.google.shopping.merchant.accounts.v1beta.User>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateUser"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.UpdateUserRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.User
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("UpdateUser"))
                      .build();
        }
      }
    }
    return getUpdateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.ListUsersRequest,
          com.google.shopping.merchant.accounts.v1beta.ListUsersResponse>
      getListUsersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListUsers",
      requestType = com.google.shopping.merchant.accounts.v1beta.ListUsersRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.ListUsersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.ListUsersRequest,
          com.google.shopping.merchant.accounts.v1beta.ListUsersResponse>
      getListUsersMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.ListUsersRequest,
            com.google.shopping.merchant.accounts.v1beta.ListUsersResponse>
        getListUsersMethod;
    if ((getListUsersMethod = UserServiceGrpc.getListUsersMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getListUsersMethod = UserServiceGrpc.getListUsersMethod) == null) {
          UserServiceGrpc.getListUsersMethod =
              getListUsersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.ListUsersRequest,
                          com.google.shopping.merchant.accounts.v1beta.ListUsersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListUsers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.ListUsersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.ListUsersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("ListUsers"))
                      .build();
        }
      }
    }
    return getListUsersMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static UserServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<UserServiceStub>() {
          @java.lang.Override
          public UserServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new UserServiceStub(channel, callOptions);
          }
        };
    return UserServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<UserServiceBlockingStub>() {
          @java.lang.Override
          public UserServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new UserServiceBlockingStub(channel, callOptions);
          }
        };
    return UserServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static UserServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<UserServiceFutureStub>() {
          @java.lang.Override
          public UserServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new UserServiceFutureStub(channel, callOptions);
          }
        };
    return UserServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to support user API.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Retrieves a Merchant Center account user.
     * </pre>
     */
    default void getUser(
        com.google.shopping.merchant.accounts.v1beta.GetUserRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.User>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUserMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a Merchant Center account user. Executing this method requires
     * admin access.
     * </pre>
     */
    default void createUser(
        com.google.shopping.merchant.accounts.v1beta.CreateUserRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.User>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateUserMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Merchant Center account user. Executing this method requires
     * admin access.
     * </pre>
     */
    default void deleteUser(
        com.google.shopping.merchant.accounts.v1beta.DeleteUserRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteUserMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a Merchant Center account user. Executing this method requires
     * admin access.
     * </pre>
     */
    default void updateUser(
        com.google.shopping.merchant.accounts.v1beta.UpdateUserRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.User>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateUserMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all users of a Merchant Center account.
     * </pre>
     */
    default void listUsers(
        com.google.shopping.merchant.accounts.v1beta.ListUsersRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.ListUsersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListUsersMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service UserService.
   *
   * <pre>
   * Service to support user API.
   * </pre>
   */
  public abstract static class UserServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return UserServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service UserService.
   *
   * <pre>
   * Service to support user API.
   * </pre>
   */
  public static final class UserServiceStub
      extends io.grpc.stub.AbstractAsyncStub<UserServiceStub> {
    private UserServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a Merchant Center account user.
     * </pre>
     */
    public void getUser(
        com.google.shopping.merchant.accounts.v1beta.GetUserRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.User>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a Merchant Center account user. Executing this method requires
     * admin access.
     * </pre>
     */
    public void createUser(
        com.google.shopping.merchant.accounts.v1beta.CreateUserRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.User>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Merchant Center account user. Executing this method requires
     * admin access.
     * </pre>
     */
    public void deleteUser(
        com.google.shopping.merchant.accounts.v1beta.DeleteUserRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a Merchant Center account user. Executing this method requires
     * admin access.
     * </pre>
     */
    public void updateUser(
        com.google.shopping.merchant.accounts.v1beta.UpdateUserRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.User>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all users of a Merchant Center account.
     * </pre>
     */
    public void listUsers(
        com.google.shopping.merchant.accounts.v1beta.ListUsersRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.ListUsersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListUsersMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service UserService.
   *
   * <pre>
   * Service to support user API.
   * </pre>
   */
  public static final class UserServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<UserServiceBlockingStub> {
    private UserServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a Merchant Center account user.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.User getUser(
        com.google.shopping.merchant.accounts.v1beta.GetUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Merchant Center account user. Executing this method requires
     * admin access.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.User createUser(
        com.google.shopping.merchant.accounts.v1beta.CreateUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUserMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Merchant Center account user. Executing this method requires
     * admin access.
     * </pre>
     */
    public com.google.protobuf.Empty deleteUser(
        com.google.shopping.merchant.accounts.v1beta.DeleteUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteUserMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Merchant Center account user. Executing this method requires
     * admin access.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.User updateUser(
        com.google.shopping.merchant.accounts.v1beta.UpdateUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUserMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all users of a Merchant Center account.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.ListUsersResponse listUsers(
        com.google.shopping.merchant.accounts.v1beta.ListUsersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUsersMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service UserService.
   *
   * <pre>
   * Service to support user API.
   * </pre>
   */
  public static final class UserServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<UserServiceFutureStub> {
    private UserServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a Merchant Center account user.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.User>
        getUser(com.google.shopping.merchant.accounts.v1beta.GetUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Merchant Center account user. Executing this method requires
     * admin access.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.User>
        createUser(com.google.shopping.merchant.accounts.v1beta.CreateUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateUserMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Merchant Center account user. Executing this method requires
     * admin access.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteUser(
        com.google.shopping.merchant.accounts.v1beta.DeleteUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteUserMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Merchant Center account user. Executing this method requires
     * admin access.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.User>
        updateUser(com.google.shopping.merchant.accounts.v1beta.UpdateUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateUserMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all users of a Merchant Center account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.ListUsersResponse>
        listUsers(com.google.shopping.merchant.accounts.v1beta.ListUsersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListUsersMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_USER = 0;
  private static final int METHODID_CREATE_USER = 1;
  private static final int METHODID_DELETE_USER = 2;
  private static final int METHODID_UPDATE_USER = 3;
  private static final int METHODID_LIST_USERS = 4;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_USER:
          serviceImpl.getUser(
              (com.google.shopping.merchant.accounts.v1beta.GetUserRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.User>)
                  responseObserver);
          break;
        case METHODID_CREATE_USER:
          serviceImpl.createUser(
              (com.google.shopping.merchant.accounts.v1beta.CreateUserRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.User>)
                  responseObserver);
          break;
        case METHODID_DELETE_USER:
          serviceImpl.deleteUser(
              (com.google.shopping.merchant.accounts.v1beta.DeleteUserRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_USER:
          serviceImpl.updateUser(
              (com.google.shopping.merchant.accounts.v1beta.UpdateUserRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.User>)
                  responseObserver);
          break;
        case METHODID_LIST_USERS:
          serviceImpl.listUsers(
              (com.google.shopping.merchant.accounts.v1beta.ListUsersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1beta.ListUsersResponse>)
                  responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getGetUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.GetUserRequest,
                    com.google.shopping.merchant.accounts.v1beta.User>(service, METHODID_GET_USER)))
        .addMethod(
            getCreateUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.CreateUserRequest,
                    com.google.shopping.merchant.accounts.v1beta.User>(
                    service, METHODID_CREATE_USER)))
        .addMethod(
            getDeleteUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.DeleteUserRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_USER)))
        .addMethod(
            getUpdateUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.UpdateUserRequest,
                    com.google.shopping.merchant.accounts.v1beta.User>(
                    service, METHODID_UPDATE_USER)))
        .addMethod(
            getListUsersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.ListUsersRequest,
                    com.google.shopping.merchant.accounts.v1beta.ListUsersResponse>(
                    service, METHODID_LIST_USERS)))
        .build();
  }

  private abstract static class UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.accounts.v1beta.UserProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserService");
    }
  }

  private static final class UserServiceFileDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier {
    UserServiceFileDescriptorSupplier() {}
  }

  private static final class UserServiceMethodDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    UserServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UserServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new UserServiceFileDescriptorSupplier())
                      .addMethod(getGetUserMethod())
                      .addMethod(getCreateUserMethod())
                      .addMethod(getDeleteUserMethod())
                      .addMethod(getUpdateUserMethod())
                      .addMethod(getListUsersMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
