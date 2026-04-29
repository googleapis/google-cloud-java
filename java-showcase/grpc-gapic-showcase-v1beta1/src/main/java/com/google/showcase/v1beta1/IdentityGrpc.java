/*
 * Copyright 2026 Google LLC
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
package com.google.showcase.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * A simple identity service.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class IdentityGrpc {

  private IdentityGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.showcase.v1beta1.Identity";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.CreateUserRequest, com.google.showcase.v1beta1.User>
      getCreateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUser",
      requestType = com.google.showcase.v1beta1.CreateUserRequest.class,
      responseType = com.google.showcase.v1beta1.User.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.CreateUserRequest, com.google.showcase.v1beta1.User>
      getCreateUserMethod() {
    io.grpc.MethodDescriptor<
            com.google.showcase.v1beta1.CreateUserRequest, com.google.showcase.v1beta1.User>
        getCreateUserMethod;
    if ((getCreateUserMethod = IdentityGrpc.getCreateUserMethod) == null) {
      synchronized (IdentityGrpc.class) {
        if ((getCreateUserMethod = IdentityGrpc.getCreateUserMethod) == null) {
          IdentityGrpc.getCreateUserMethod =
              getCreateUserMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.showcase.v1beta1.CreateUserRequest,
                          com.google.showcase.v1beta1.User>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateUser"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.CreateUserRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.User.getDefaultInstance()))
                      .setSchemaDescriptor(new IdentityMethodDescriptorSupplier("CreateUser"))
                      .build();
        }
      }
    }
    return getCreateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.GetUserRequest, com.google.showcase.v1beta1.User>
      getGetUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUser",
      requestType = com.google.showcase.v1beta1.GetUserRequest.class,
      responseType = com.google.showcase.v1beta1.User.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.GetUserRequest, com.google.showcase.v1beta1.User>
      getGetUserMethod() {
    io.grpc.MethodDescriptor<
            com.google.showcase.v1beta1.GetUserRequest, com.google.showcase.v1beta1.User>
        getGetUserMethod;
    if ((getGetUserMethod = IdentityGrpc.getGetUserMethod) == null) {
      synchronized (IdentityGrpc.class) {
        if ((getGetUserMethod = IdentityGrpc.getGetUserMethod) == null) {
          IdentityGrpc.getGetUserMethod =
              getGetUserMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.showcase.v1beta1.GetUserRequest,
                          com.google.showcase.v1beta1.User>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUser"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.GetUserRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.User.getDefaultInstance()))
                      .setSchemaDescriptor(new IdentityMethodDescriptorSupplier("GetUser"))
                      .build();
        }
      }
    }
    return getGetUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.UpdateUserRequest, com.google.showcase.v1beta1.User>
      getUpdateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateUser",
      requestType = com.google.showcase.v1beta1.UpdateUserRequest.class,
      responseType = com.google.showcase.v1beta1.User.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.UpdateUserRequest, com.google.showcase.v1beta1.User>
      getUpdateUserMethod() {
    io.grpc.MethodDescriptor<
            com.google.showcase.v1beta1.UpdateUserRequest, com.google.showcase.v1beta1.User>
        getUpdateUserMethod;
    if ((getUpdateUserMethod = IdentityGrpc.getUpdateUserMethod) == null) {
      synchronized (IdentityGrpc.class) {
        if ((getUpdateUserMethod = IdentityGrpc.getUpdateUserMethod) == null) {
          IdentityGrpc.getUpdateUserMethod =
              getUpdateUserMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.showcase.v1beta1.UpdateUserRequest,
                          com.google.showcase.v1beta1.User>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateUser"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.UpdateUserRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.User.getDefaultInstance()))
                      .setSchemaDescriptor(new IdentityMethodDescriptorSupplier("UpdateUser"))
                      .build();
        }
      }
    }
    return getUpdateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.DeleteUserRequest, com.google.protobuf.Empty>
      getDeleteUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteUser",
      requestType = com.google.showcase.v1beta1.DeleteUserRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.DeleteUserRequest, com.google.protobuf.Empty>
      getDeleteUserMethod() {
    io.grpc.MethodDescriptor<
            com.google.showcase.v1beta1.DeleteUserRequest, com.google.protobuf.Empty>
        getDeleteUserMethod;
    if ((getDeleteUserMethod = IdentityGrpc.getDeleteUserMethod) == null) {
      synchronized (IdentityGrpc.class) {
        if ((getDeleteUserMethod = IdentityGrpc.getDeleteUserMethod) == null) {
          IdentityGrpc.getDeleteUserMethod =
              getDeleteUserMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.showcase.v1beta1.DeleteUserRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteUser"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.DeleteUserRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new IdentityMethodDescriptorSupplier("DeleteUser"))
                      .build();
        }
      }
    }
    return getDeleteUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.ListUsersRequest,
          com.google.showcase.v1beta1.ListUsersResponse>
      getListUsersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListUsers",
      requestType = com.google.showcase.v1beta1.ListUsersRequest.class,
      responseType = com.google.showcase.v1beta1.ListUsersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.ListUsersRequest,
          com.google.showcase.v1beta1.ListUsersResponse>
      getListUsersMethod() {
    io.grpc.MethodDescriptor<
            com.google.showcase.v1beta1.ListUsersRequest,
            com.google.showcase.v1beta1.ListUsersResponse>
        getListUsersMethod;
    if ((getListUsersMethod = IdentityGrpc.getListUsersMethod) == null) {
      synchronized (IdentityGrpc.class) {
        if ((getListUsersMethod = IdentityGrpc.getListUsersMethod) == null) {
          IdentityGrpc.getListUsersMethod =
              getListUsersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.showcase.v1beta1.ListUsersRequest,
                          com.google.showcase.v1beta1.ListUsersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListUsers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.ListUsersRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.ListUsersResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new IdentityMethodDescriptorSupplier("ListUsers"))
                      .build();
        }
      }
    }
    return getListUsersMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static IdentityStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IdentityStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IdentityStub>() {
          @java.lang.Override
          public IdentityStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IdentityStub(channel, callOptions);
          }
        };
    return IdentityStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static IdentityBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IdentityBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IdentityBlockingV2Stub>() {
          @java.lang.Override
          public IdentityBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IdentityBlockingV2Stub(channel, callOptions);
          }
        };
    return IdentityBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static IdentityBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IdentityBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IdentityBlockingStub>() {
          @java.lang.Override
          public IdentityBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IdentityBlockingStub(channel, callOptions);
          }
        };
    return IdentityBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static IdentityFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IdentityFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IdentityFutureStub>() {
          @java.lang.Override
          public IdentityFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IdentityFutureStub(channel, callOptions);
          }
        };
    return IdentityFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * A simple identity service.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a user.
     * </pre>
     */
    default void createUser(
        com.google.showcase.v1beta1.CreateUserRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.User> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateUserMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the User with the given uri.
     * </pre>
     */
    default void getUser(
        com.google.showcase.v1beta1.GetUserRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.User> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUserMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a user.
     * </pre>
     */
    default void updateUser(
        com.google.showcase.v1beta1.UpdateUserRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.User> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateUserMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a user, their profile, and all of their authored messages.
     * </pre>
     */
    default void deleteUser(
        com.google.showcase.v1beta1.DeleteUserRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteUserMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all users.
     * </pre>
     */
    default void listUsers(
        com.google.showcase.v1beta1.ListUsersRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.ListUsersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListUsersMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Identity.
   *
   * <pre>
   * A simple identity service.
   * </pre>
   */
  public abstract static class IdentityImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return IdentityGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Identity.
   *
   * <pre>
   * A simple identity service.
   * </pre>
   */
  public static final class IdentityStub extends io.grpc.stub.AbstractAsyncStub<IdentityStub> {
    private IdentityStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IdentityStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IdentityStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a user.
     * </pre>
     */
    public void createUser(
        com.google.showcase.v1beta1.CreateUserRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.User> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the User with the given uri.
     * </pre>
     */
    public void getUser(
        com.google.showcase.v1beta1.GetUserRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.User> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a user.
     * </pre>
     */
    public void updateUser(
        com.google.showcase.v1beta1.UpdateUserRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.User> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a user, their profile, and all of their authored messages.
     * </pre>
     */
    public void deleteUser(
        com.google.showcase.v1beta1.DeleteUserRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all users.
     * </pre>
     */
    public void listUsers(
        com.google.showcase.v1beta1.ListUsersRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.ListUsersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListUsersMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Identity.
   *
   * <pre>
   * A simple identity service.
   * </pre>
   */
  public static final class IdentityBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<IdentityBlockingV2Stub> {
    private IdentityBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IdentityBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IdentityBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a user.
     * </pre>
     */
    public com.google.showcase.v1beta1.User createUser(
        com.google.showcase.v1beta1.CreateUserRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateUserMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the User with the given uri.
     * </pre>
     */
    public com.google.showcase.v1beta1.User getUser(
        com.google.showcase.v1beta1.GetUserRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetUserMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a user.
     * </pre>
     */
    public com.google.showcase.v1beta1.User updateUser(
        com.google.showcase.v1beta1.UpdateUserRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateUserMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a user, their profile, and all of their authored messages.
     * </pre>
     */
    public com.google.protobuf.Empty deleteUser(
        com.google.showcase.v1beta1.DeleteUserRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteUserMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all users.
     * </pre>
     */
    public com.google.showcase.v1beta1.ListUsersResponse listUsers(
        com.google.showcase.v1beta1.ListUsersRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListUsersMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Identity.
   *
   * <pre>
   * A simple identity service.
   * </pre>
   */
  public static final class IdentityBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<IdentityBlockingStub> {
    private IdentityBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IdentityBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IdentityBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a user.
     * </pre>
     */
    public com.google.showcase.v1beta1.User createUser(
        com.google.showcase.v1beta1.CreateUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUserMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the User with the given uri.
     * </pre>
     */
    public com.google.showcase.v1beta1.User getUser(
        com.google.showcase.v1beta1.GetUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a user.
     * </pre>
     */
    public com.google.showcase.v1beta1.User updateUser(
        com.google.showcase.v1beta1.UpdateUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUserMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a user, their profile, and all of their authored messages.
     * </pre>
     */
    public com.google.protobuf.Empty deleteUser(
        com.google.showcase.v1beta1.DeleteUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteUserMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all users.
     * </pre>
     */
    public com.google.showcase.v1beta1.ListUsersResponse listUsers(
        com.google.showcase.v1beta1.ListUsersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUsersMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Identity.
   *
   * <pre>
   * A simple identity service.
   * </pre>
   */
  public static final class IdentityFutureStub
      extends io.grpc.stub.AbstractFutureStub<IdentityFutureStub> {
    private IdentityFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IdentityFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IdentityFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a user.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.showcase.v1beta1.User>
        createUser(com.google.showcase.v1beta1.CreateUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateUserMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the User with the given uri.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.showcase.v1beta1.User>
        getUser(com.google.showcase.v1beta1.GetUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a user.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.showcase.v1beta1.User>
        updateUser(com.google.showcase.v1beta1.UpdateUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateUserMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a user, their profile, and all of their authored messages.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteUser(
        com.google.showcase.v1beta1.DeleteUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteUserMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all users.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.showcase.v1beta1.ListUsersResponse>
        listUsers(com.google.showcase.v1beta1.ListUsersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListUsersMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_USER = 0;
  private static final int METHODID_GET_USER = 1;
  private static final int METHODID_UPDATE_USER = 2;
  private static final int METHODID_DELETE_USER = 3;
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
        case METHODID_CREATE_USER:
          serviceImpl.createUser(
              (com.google.showcase.v1beta1.CreateUserRequest) request,
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.User>) responseObserver);
          break;
        case METHODID_GET_USER:
          serviceImpl.getUser(
              (com.google.showcase.v1beta1.GetUserRequest) request,
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.User>) responseObserver);
          break;
        case METHODID_UPDATE_USER:
          serviceImpl.updateUser(
              (com.google.showcase.v1beta1.UpdateUserRequest) request,
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.User>) responseObserver);
          break;
        case METHODID_DELETE_USER:
          serviceImpl.deleteUser(
              (com.google.showcase.v1beta1.DeleteUserRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_USERS:
          serviceImpl.listUsers(
              (com.google.showcase.v1beta1.ListUsersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.ListUsersResponse>)
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
            getCreateUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.showcase.v1beta1.CreateUserRequest,
                    com.google.showcase.v1beta1.User>(service, METHODID_CREATE_USER)))
        .addMethod(
            getGetUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.showcase.v1beta1.GetUserRequest, com.google.showcase.v1beta1.User>(
                    service, METHODID_GET_USER)))
        .addMethod(
            getUpdateUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.showcase.v1beta1.UpdateUserRequest,
                    com.google.showcase.v1beta1.User>(service, METHODID_UPDATE_USER)))
        .addMethod(
            getDeleteUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.showcase.v1beta1.DeleteUserRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_USER)))
        .addMethod(
            getListUsersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.showcase.v1beta1.ListUsersRequest,
                    com.google.showcase.v1beta1.ListUsersResponse>(service, METHODID_LIST_USERS)))
        .build();
  }

  private abstract static class IdentityBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    IdentityBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.showcase.v1beta1.IdentityOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Identity");
    }
  }

  private static final class IdentityFileDescriptorSupplier extends IdentityBaseDescriptorSupplier {
    IdentityFileDescriptorSupplier() {}
  }

  private static final class IdentityMethodDescriptorSupplier extends IdentityBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    IdentityMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (IdentityGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new IdentityFileDescriptorSupplier())
                      .addMethod(getCreateUserMethod())
                      .addMethod(getGetUserMethod())
                      .addMethod(getUpdateUserMethod())
                      .addMethod(getDeleteUserMethod())
                      .addMethod(getListUsersMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
