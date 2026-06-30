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
package com.google.ads.datamanager.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing UserList resources.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class UserListServiceGrpc {

  private UserListServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.ads.datamanager.v1.UserListService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.GetUserListRequest, com.google.ads.datamanager.v1.UserList>
      getGetUserListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserList",
      requestType = com.google.ads.datamanager.v1.GetUserListRequest.class,
      responseType = com.google.ads.datamanager.v1.UserList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.GetUserListRequest, com.google.ads.datamanager.v1.UserList>
      getGetUserListMethod() {
    io.grpc.MethodDescriptor<
            com.google.ads.datamanager.v1.GetUserListRequest,
            com.google.ads.datamanager.v1.UserList>
        getGetUserListMethod;
    if ((getGetUserListMethod = UserListServiceGrpc.getGetUserListMethod) == null) {
      synchronized (UserListServiceGrpc.class) {
        if ((getGetUserListMethod = UserListServiceGrpc.getGetUserListMethod) == null) {
          UserListServiceGrpc.getGetUserListMethod =
              getGetUserListMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.ads.datamanager.v1.GetUserListRequest,
                          com.google.ads.datamanager.v1.UserList>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUserList"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.GetUserListRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.UserList.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new UserListServiceMethodDescriptorSupplier("GetUserList"))
                      .build();
        }
      }
    }
    return getGetUserListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.ListUserListsRequest,
          com.google.ads.datamanager.v1.ListUserListsResponse>
      getListUserListsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListUserLists",
      requestType = com.google.ads.datamanager.v1.ListUserListsRequest.class,
      responseType = com.google.ads.datamanager.v1.ListUserListsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.ListUserListsRequest,
          com.google.ads.datamanager.v1.ListUserListsResponse>
      getListUserListsMethod() {
    io.grpc.MethodDescriptor<
            com.google.ads.datamanager.v1.ListUserListsRequest,
            com.google.ads.datamanager.v1.ListUserListsResponse>
        getListUserListsMethod;
    if ((getListUserListsMethod = UserListServiceGrpc.getListUserListsMethod) == null) {
      synchronized (UserListServiceGrpc.class) {
        if ((getListUserListsMethod = UserListServiceGrpc.getListUserListsMethod) == null) {
          UserListServiceGrpc.getListUserListsMethod =
              getListUserListsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.ads.datamanager.v1.ListUserListsRequest,
                          com.google.ads.datamanager.v1.ListUserListsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListUserLists"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.ListUserListsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.ListUserListsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new UserListServiceMethodDescriptorSupplier("ListUserLists"))
                      .build();
        }
      }
    }
    return getListUserListsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.CreateUserListRequest,
          com.google.ads.datamanager.v1.UserList>
      getCreateUserListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUserList",
      requestType = com.google.ads.datamanager.v1.CreateUserListRequest.class,
      responseType = com.google.ads.datamanager.v1.UserList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.CreateUserListRequest,
          com.google.ads.datamanager.v1.UserList>
      getCreateUserListMethod() {
    io.grpc.MethodDescriptor<
            com.google.ads.datamanager.v1.CreateUserListRequest,
            com.google.ads.datamanager.v1.UserList>
        getCreateUserListMethod;
    if ((getCreateUserListMethod = UserListServiceGrpc.getCreateUserListMethod) == null) {
      synchronized (UserListServiceGrpc.class) {
        if ((getCreateUserListMethod = UserListServiceGrpc.getCreateUserListMethod) == null) {
          UserListServiceGrpc.getCreateUserListMethod =
              getCreateUserListMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.ads.datamanager.v1.CreateUserListRequest,
                          com.google.ads.datamanager.v1.UserList>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateUserList"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.CreateUserListRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.UserList.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new UserListServiceMethodDescriptorSupplier("CreateUserList"))
                      .build();
        }
      }
    }
    return getCreateUserListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.UpdateUserListRequest,
          com.google.ads.datamanager.v1.UserList>
      getUpdateUserListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateUserList",
      requestType = com.google.ads.datamanager.v1.UpdateUserListRequest.class,
      responseType = com.google.ads.datamanager.v1.UserList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.UpdateUserListRequest,
          com.google.ads.datamanager.v1.UserList>
      getUpdateUserListMethod() {
    io.grpc.MethodDescriptor<
            com.google.ads.datamanager.v1.UpdateUserListRequest,
            com.google.ads.datamanager.v1.UserList>
        getUpdateUserListMethod;
    if ((getUpdateUserListMethod = UserListServiceGrpc.getUpdateUserListMethod) == null) {
      synchronized (UserListServiceGrpc.class) {
        if ((getUpdateUserListMethod = UserListServiceGrpc.getUpdateUserListMethod) == null) {
          UserListServiceGrpc.getUpdateUserListMethod =
              getUpdateUserListMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.ads.datamanager.v1.UpdateUserListRequest,
                          com.google.ads.datamanager.v1.UserList>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateUserList"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.UpdateUserListRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.UserList.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new UserListServiceMethodDescriptorSupplier("UpdateUserList"))
                      .build();
        }
      }
    }
    return getUpdateUserListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.DeleteUserListRequest, com.google.protobuf.Empty>
      getDeleteUserListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteUserList",
      requestType = com.google.ads.datamanager.v1.DeleteUserListRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.DeleteUserListRequest, com.google.protobuf.Empty>
      getDeleteUserListMethod() {
    io.grpc.MethodDescriptor<
            com.google.ads.datamanager.v1.DeleteUserListRequest, com.google.protobuf.Empty>
        getDeleteUserListMethod;
    if ((getDeleteUserListMethod = UserListServiceGrpc.getDeleteUserListMethod) == null) {
      synchronized (UserListServiceGrpc.class) {
        if ((getDeleteUserListMethod = UserListServiceGrpc.getDeleteUserListMethod) == null) {
          UserListServiceGrpc.getDeleteUserListMethod =
              getDeleteUserListMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.ads.datamanager.v1.DeleteUserListRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteUserList"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.DeleteUserListRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new UserListServiceMethodDescriptorSupplier("DeleteUserList"))
                      .build();
        }
      }
    }
    return getDeleteUserListMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static UserListServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserListServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<UserListServiceStub>() {
          @java.lang.Override
          public UserListServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new UserListServiceStub(channel, callOptions);
          }
        };
    return UserListServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static UserListServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserListServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<UserListServiceBlockingV2Stub>() {
          @java.lang.Override
          public UserListServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new UserListServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return UserListServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserListServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserListServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<UserListServiceBlockingStub>() {
          @java.lang.Override
          public UserListServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new UserListServiceBlockingStub(channel, callOptions);
          }
        };
    return UserListServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static UserListServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserListServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<UserListServiceFutureStub>() {
          @java.lang.Override
          public UserListServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new UserListServiceFutureStub(channel, callOptions);
          }
        };
    return UserListServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing UserList resources.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Gets a UserList.
     * Authorization Headers:
     * This method supports the following optional headers to define how the API
     * authorizes access for the request:
     * * `login-account`: (Optional) The resource name of the account where the
     *   Google Account of the credentials is a user. If not set, defaults to the
     *   account of the request. Format:
     *   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
     * * `linked-account`: (Optional) The resource name of the account with an
     *    established product link to the `login-account`. Format:
     *    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
     * </pre>
     */
    default void getUserList(
        com.google.ads.datamanager.v1.GetUserListRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.UserList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetUserListMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists UserLists.
     * Authorization Headers:
     * This method supports the following optional headers to define how the API
     * authorizes access for the request:
     * * `login-account`: (Optional) The resource name of the account where the
     *   Google Account of the credentials is a user. If not set, defaults to the
     *   account of the request. Format:
     *   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
     * * `linked-account`: (Optional) The resource name of the account with an
     *    established product link to the `login-account`. Format:
     *    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
     * </pre>
     */
    default void listUserLists(
        com.google.ads.datamanager.v1.ListUserListsRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.ListUserListsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListUserListsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a UserList.
     * Authorization Headers:
     * This method supports the following optional headers to define how the API
     * authorizes access for the request:
     * * `login-account`: (Optional) The resource name of the account where the
     *   Google Account of the credentials is a user. If not set, defaults to the
     *   account of the request. Format:
     *   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
     * * `linked-account`: (Optional) The resource name of the account with an
     *    established product link to the `login-account`. Format:
     *    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
     * </pre>
     */
    default void createUserList(
        com.google.ads.datamanager.v1.CreateUserListRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.UserList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateUserListMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a UserList.
     * Authorization Headers:
     * This method supports the following optional headers to define how the API
     * authorizes access for the request:
     * * `login-account`: (Optional) The resource name of the account where the
     *   Google Account of the credentials is a user. If not set, defaults to the
     *   account of the request. Format:
     *   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
     * * `linked-account`: (Optional) The resource name of the account with an
     *    established product link to the `login-account`. Format:
     *    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
     * </pre>
     */
    default void updateUserList(
        com.google.ads.datamanager.v1.UpdateUserListRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.UserList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateUserListMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a UserList.
     * Authorization Headers:
     * This method supports the following optional headers to define how the API
     * authorizes access for the request:
     * * `login-account`: (Optional) The resource name of the account where the
     *   Google Account of the credentials is a user. If not set, defaults to the
     *   account of the request. Format:
     *   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
     * * `linked-account`: (Optional) The resource name of the account with an
     *    established product link to the `login-account`. Format:
     *    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
     * </pre>
     */
    default void deleteUserList(
        com.google.ads.datamanager.v1.DeleteUserListRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteUserListMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service UserListService.
   *
   * <pre>
   * Service for managing UserList resources.
   * </pre>
   */
  public abstract static class UserListServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return UserListServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service UserListService.
   *
   * <pre>
   * Service for managing UserList resources.
   * </pre>
   */
  public static final class UserListServiceStub
      extends io.grpc.stub.AbstractAsyncStub<UserListServiceStub> {
    private UserListServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserListServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserListServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a UserList.
     * Authorization Headers:
     * This method supports the following optional headers to define how the API
     * authorizes access for the request:
     * * `login-account`: (Optional) The resource name of the account where the
     *   Google Account of the credentials is a user. If not set, defaults to the
     *   account of the request. Format:
     *   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
     * * `linked-account`: (Optional) The resource name of the account with an
     *    established product link to the `login-account`. Format:
     *    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
     * </pre>
     */
    public void getUserList(
        com.google.ads.datamanager.v1.GetUserListRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.UserList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserListMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists UserLists.
     * Authorization Headers:
     * This method supports the following optional headers to define how the API
     * authorizes access for the request:
     * * `login-account`: (Optional) The resource name of the account where the
     *   Google Account of the credentials is a user. If not set, defaults to the
     *   account of the request. Format:
     *   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
     * * `linked-account`: (Optional) The resource name of the account with an
     *    established product link to the `login-account`. Format:
     *    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
     * </pre>
     */
    public void listUserLists(
        com.google.ads.datamanager.v1.ListUserListsRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.ListUserListsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListUserListsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a UserList.
     * Authorization Headers:
     * This method supports the following optional headers to define how the API
     * authorizes access for the request:
     * * `login-account`: (Optional) The resource name of the account where the
     *   Google Account of the credentials is a user. If not set, defaults to the
     *   account of the request. Format:
     *   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
     * * `linked-account`: (Optional) The resource name of the account with an
     *    established product link to the `login-account`. Format:
     *    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
     * </pre>
     */
    public void createUserList(
        com.google.ads.datamanager.v1.CreateUserListRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.UserList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateUserListMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a UserList.
     * Authorization Headers:
     * This method supports the following optional headers to define how the API
     * authorizes access for the request:
     * * `login-account`: (Optional) The resource name of the account where the
     *   Google Account of the credentials is a user. If not set, defaults to the
     *   account of the request. Format:
     *   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
     * * `linked-account`: (Optional) The resource name of the account with an
     *    established product link to the `login-account`. Format:
     *    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
     * </pre>
     */
    public void updateUserList(
        com.google.ads.datamanager.v1.UpdateUserListRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.UserList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateUserListMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a UserList.
     * Authorization Headers:
     * This method supports the following optional headers to define how the API
     * authorizes access for the request:
     * * `login-account`: (Optional) The resource name of the account where the
     *   Google Account of the credentials is a user. If not set, defaults to the
     *   account of the request. Format:
     *   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
     * * `linked-account`: (Optional) The resource name of the account with an
     *    established product link to the `login-account`. Format:
     *    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
     * </pre>
     */
    public void deleteUserList(
        com.google.ads.datamanager.v1.DeleteUserListRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteUserListMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service UserListService.
   *
   * <pre>
   * Service for managing UserList resources.
   * </pre>
   */
  public static final class UserListServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<UserListServiceBlockingV2Stub> {
    private UserListServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserListServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserListServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a UserList.
     * Authorization Headers:
     * This method supports the following optional headers to define how the API
     * authorizes access for the request:
     * * `login-account`: (Optional) The resource name of the account where the
     *   Google Account of the credentials is a user. If not set, defaults to the
     *   account of the request. Format:
     *   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
     * * `linked-account`: (Optional) The resource name of the account with an
     *    established product link to the `login-account`. Format:
     *    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
     * </pre>
     */
    public com.google.ads.datamanager.v1.UserList getUserList(
        com.google.ads.datamanager.v1.GetUserListRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetUserListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists UserLists.
     * Authorization Headers:
     * This method supports the following optional headers to define how the API
     * authorizes access for the request:
     * * `login-account`: (Optional) The resource name of the account where the
     *   Google Account of the credentials is a user. If not set, defaults to the
     *   account of the request. Format:
     *   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
     * * `linked-account`: (Optional) The resource name of the account with an
     *    established product link to the `login-account`. Format:
     *    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
     * </pre>
     */
    public com.google.ads.datamanager.v1.ListUserListsResponse listUserLists(
        com.google.ads.datamanager.v1.ListUserListsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListUserListsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a UserList.
     * Authorization Headers:
     * This method supports the following optional headers to define how the API
     * authorizes access for the request:
     * * `login-account`: (Optional) The resource name of the account where the
     *   Google Account of the credentials is a user. If not set, defaults to the
     *   account of the request. Format:
     *   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
     * * `linked-account`: (Optional) The resource name of the account with an
     *    established product link to the `login-account`. Format:
     *    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
     * </pre>
     */
    public com.google.ads.datamanager.v1.UserList createUserList(
        com.google.ads.datamanager.v1.CreateUserListRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateUserListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a UserList.
     * Authorization Headers:
     * This method supports the following optional headers to define how the API
     * authorizes access for the request:
     * * `login-account`: (Optional) The resource name of the account where the
     *   Google Account of the credentials is a user. If not set, defaults to the
     *   account of the request. Format:
     *   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
     * * `linked-account`: (Optional) The resource name of the account with an
     *    established product link to the `login-account`. Format:
     *    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
     * </pre>
     */
    public com.google.ads.datamanager.v1.UserList updateUserList(
        com.google.ads.datamanager.v1.UpdateUserListRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateUserListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a UserList.
     * Authorization Headers:
     * This method supports the following optional headers to define how the API
     * authorizes access for the request:
     * * `login-account`: (Optional) The resource name of the account where the
     *   Google Account of the credentials is a user. If not set, defaults to the
     *   account of the request. Format:
     *   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
     * * `linked-account`: (Optional) The resource name of the account with an
     *    established product link to the `login-account`. Format:
     *    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
     * </pre>
     */
    public com.google.protobuf.Empty deleteUserList(
        com.google.ads.datamanager.v1.DeleteUserListRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteUserListMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service UserListService.
   *
   * <pre>
   * Service for managing UserList resources.
   * </pre>
   */
  public static final class UserListServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<UserListServiceBlockingStub> {
    private UserListServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserListServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserListServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a UserList.
     * Authorization Headers:
     * This method supports the following optional headers to define how the API
     * authorizes access for the request:
     * * `login-account`: (Optional) The resource name of the account where the
     *   Google Account of the credentials is a user. If not set, defaults to the
     *   account of the request. Format:
     *   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
     * * `linked-account`: (Optional) The resource name of the account with an
     *    established product link to the `login-account`. Format:
     *    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
     * </pre>
     */
    public com.google.ads.datamanager.v1.UserList getUserList(
        com.google.ads.datamanager.v1.GetUserListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists UserLists.
     * Authorization Headers:
     * This method supports the following optional headers to define how the API
     * authorizes access for the request:
     * * `login-account`: (Optional) The resource name of the account where the
     *   Google Account of the credentials is a user. If not set, defaults to the
     *   account of the request. Format:
     *   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
     * * `linked-account`: (Optional) The resource name of the account with an
     *    established product link to the `login-account`. Format:
     *    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
     * </pre>
     */
    public com.google.ads.datamanager.v1.ListUserListsResponse listUserLists(
        com.google.ads.datamanager.v1.ListUserListsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUserListsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a UserList.
     * Authorization Headers:
     * This method supports the following optional headers to define how the API
     * authorizes access for the request:
     * * `login-account`: (Optional) The resource name of the account where the
     *   Google Account of the credentials is a user. If not set, defaults to the
     *   account of the request. Format:
     *   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
     * * `linked-account`: (Optional) The resource name of the account with an
     *    established product link to the `login-account`. Format:
     *    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
     * </pre>
     */
    public com.google.ads.datamanager.v1.UserList createUserList(
        com.google.ads.datamanager.v1.CreateUserListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUserListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a UserList.
     * Authorization Headers:
     * This method supports the following optional headers to define how the API
     * authorizes access for the request:
     * * `login-account`: (Optional) The resource name of the account where the
     *   Google Account of the credentials is a user. If not set, defaults to the
     *   account of the request. Format:
     *   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
     * * `linked-account`: (Optional) The resource name of the account with an
     *    established product link to the `login-account`. Format:
     *    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
     * </pre>
     */
    public com.google.ads.datamanager.v1.UserList updateUserList(
        com.google.ads.datamanager.v1.UpdateUserListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUserListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a UserList.
     * Authorization Headers:
     * This method supports the following optional headers to define how the API
     * authorizes access for the request:
     * * `login-account`: (Optional) The resource name of the account where the
     *   Google Account of the credentials is a user. If not set, defaults to the
     *   account of the request. Format:
     *   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
     * * `linked-account`: (Optional) The resource name of the account with an
     *    established product link to the `login-account`. Format:
     *    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
     * </pre>
     */
    public com.google.protobuf.Empty deleteUserList(
        com.google.ads.datamanager.v1.DeleteUserListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteUserListMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service UserListService.
   *
   * <pre>
   * Service for managing UserList resources.
   * </pre>
   */
  public static final class UserListServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<UserListServiceFutureStub> {
    private UserListServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserListServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserListServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a UserList.
     * Authorization Headers:
     * This method supports the following optional headers to define how the API
     * authorizes access for the request:
     * * `login-account`: (Optional) The resource name of the account where the
     *   Google Account of the credentials is a user. If not set, defaults to the
     *   account of the request. Format:
     *   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
     * * `linked-account`: (Optional) The resource name of the account with an
     *    established product link to the `login-account`. Format:
     *    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.ads.datamanager.v1.UserList>
        getUserList(com.google.ads.datamanager.v1.GetUserListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserListMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists UserLists.
     * Authorization Headers:
     * This method supports the following optional headers to define how the API
     * authorizes access for the request:
     * * `login-account`: (Optional) The resource name of the account where the
     *   Google Account of the credentials is a user. If not set, defaults to the
     *   account of the request. Format:
     *   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
     * * `linked-account`: (Optional) The resource name of the account with an
     *    established product link to the `login-account`. Format:
     *    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.ads.datamanager.v1.ListUserListsResponse>
        listUserLists(com.google.ads.datamanager.v1.ListUserListsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListUserListsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a UserList.
     * Authorization Headers:
     * This method supports the following optional headers to define how the API
     * authorizes access for the request:
     * * `login-account`: (Optional) The resource name of the account where the
     *   Google Account of the credentials is a user. If not set, defaults to the
     *   account of the request. Format:
     *   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
     * * `linked-account`: (Optional) The resource name of the account with an
     *    established product link to the `login-account`. Format:
     *    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.ads.datamanager.v1.UserList>
        createUserList(com.google.ads.datamanager.v1.CreateUserListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateUserListMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a UserList.
     * Authorization Headers:
     * This method supports the following optional headers to define how the API
     * authorizes access for the request:
     * * `login-account`: (Optional) The resource name of the account where the
     *   Google Account of the credentials is a user. If not set, defaults to the
     *   account of the request. Format:
     *   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
     * * `linked-account`: (Optional) The resource name of the account with an
     *    established product link to the `login-account`. Format:
     *    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.ads.datamanager.v1.UserList>
        updateUserList(com.google.ads.datamanager.v1.UpdateUserListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateUserListMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a UserList.
     * Authorization Headers:
     * This method supports the following optional headers to define how the API
     * authorizes access for the request:
     * * `login-account`: (Optional) The resource name of the account where the
     *   Google Account of the credentials is a user. If not set, defaults to the
     *   account of the request. Format:
     *   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
     * * `linked-account`: (Optional) The resource name of the account with an
     *    established product link to the `login-account`. Format:
     *    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteUserList(com.google.ads.datamanager.v1.DeleteUserListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteUserListMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_USER_LIST = 0;
  private static final int METHODID_LIST_USER_LISTS = 1;
  private static final int METHODID_CREATE_USER_LIST = 2;
  private static final int METHODID_UPDATE_USER_LIST = 3;
  private static final int METHODID_DELETE_USER_LIST = 4;

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
        case METHODID_GET_USER_LIST:
          serviceImpl.getUserList(
              (com.google.ads.datamanager.v1.GetUserListRequest) request,
              (io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.UserList>)
                  responseObserver);
          break;
        case METHODID_LIST_USER_LISTS:
          serviceImpl.listUserLists(
              (com.google.ads.datamanager.v1.ListUserListsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.ListUserListsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_USER_LIST:
          serviceImpl.createUserList(
              (com.google.ads.datamanager.v1.CreateUserListRequest) request,
              (io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.UserList>)
                  responseObserver);
          break;
        case METHODID_UPDATE_USER_LIST:
          serviceImpl.updateUserList(
              (com.google.ads.datamanager.v1.UpdateUserListRequest) request,
              (io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.UserList>)
                  responseObserver);
          break;
        case METHODID_DELETE_USER_LIST:
          serviceImpl.deleteUserList(
              (com.google.ads.datamanager.v1.DeleteUserListRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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
            getGetUserListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.ads.datamanager.v1.GetUserListRequest,
                    com.google.ads.datamanager.v1.UserList>(service, METHODID_GET_USER_LIST)))
        .addMethod(
            getListUserListsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.ads.datamanager.v1.ListUserListsRequest,
                    com.google.ads.datamanager.v1.ListUserListsResponse>(
                    service, METHODID_LIST_USER_LISTS)))
        .addMethod(
            getCreateUserListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.ads.datamanager.v1.CreateUserListRequest,
                    com.google.ads.datamanager.v1.UserList>(service, METHODID_CREATE_USER_LIST)))
        .addMethod(
            getUpdateUserListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.ads.datamanager.v1.UpdateUserListRequest,
                    com.google.ads.datamanager.v1.UserList>(service, METHODID_UPDATE_USER_LIST)))
        .addMethod(
            getDeleteUserListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.ads.datamanager.v1.DeleteUserListRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_USER_LIST)))
        .build();
  }

  private abstract static class UserListServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserListServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.ads.datamanager.v1.UserListServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserListService");
    }
  }

  private static final class UserListServiceFileDescriptorSupplier
      extends UserListServiceBaseDescriptorSupplier {
    UserListServiceFileDescriptorSupplier() {}
  }

  private static final class UserListServiceMethodDescriptorSupplier
      extends UserListServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    UserListServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (UserListServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new UserListServiceFileDescriptorSupplier())
                      .addMethod(getGetUserListMethod())
                      .addMethod(getListUserListsMethod())
                      .addMethod(getCreateUserListMethod())
                      .addMethod(getUpdateUserListMethod())
                      .addMethod(getDeleteUserListMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
