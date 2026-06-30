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
 * Service for managing user list direct licenses. Delete is not a supported
 * operation for UserListDirectLicenses.  Callers should update the
 * license status to DISABLED to instead to deactivate a license.
 * This feature is only available to data partners.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class UserListDirectLicenseServiceGrpc {

  private UserListDirectLicenseServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.ads.datamanager.v1.UserListDirectLicenseService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.CreateUserListDirectLicenseRequest,
          com.google.ads.datamanager.v1.UserListDirectLicense>
      getCreateUserListDirectLicenseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUserListDirectLicense",
      requestType = com.google.ads.datamanager.v1.CreateUserListDirectLicenseRequest.class,
      responseType = com.google.ads.datamanager.v1.UserListDirectLicense.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.CreateUserListDirectLicenseRequest,
          com.google.ads.datamanager.v1.UserListDirectLicense>
      getCreateUserListDirectLicenseMethod() {
    io.grpc.MethodDescriptor<
            com.google.ads.datamanager.v1.CreateUserListDirectLicenseRequest,
            com.google.ads.datamanager.v1.UserListDirectLicense>
        getCreateUserListDirectLicenseMethod;
    if ((getCreateUserListDirectLicenseMethod =
            UserListDirectLicenseServiceGrpc.getCreateUserListDirectLicenseMethod)
        == null) {
      synchronized (UserListDirectLicenseServiceGrpc.class) {
        if ((getCreateUserListDirectLicenseMethod =
                UserListDirectLicenseServiceGrpc.getCreateUserListDirectLicenseMethod)
            == null) {
          UserListDirectLicenseServiceGrpc.getCreateUserListDirectLicenseMethod =
              getCreateUserListDirectLicenseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.ads.datamanager.v1.CreateUserListDirectLicenseRequest,
                          com.google.ads.datamanager.v1.UserListDirectLicense>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateUserListDirectLicense"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.CreateUserListDirectLicenseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.UserListDirectLicense
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new UserListDirectLicenseServiceMethodDescriptorSupplier(
                              "CreateUserListDirectLicense"))
                      .build();
        }
      }
    }
    return getCreateUserListDirectLicenseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.GetUserListDirectLicenseRequest,
          com.google.ads.datamanager.v1.UserListDirectLicense>
      getGetUserListDirectLicenseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserListDirectLicense",
      requestType = com.google.ads.datamanager.v1.GetUserListDirectLicenseRequest.class,
      responseType = com.google.ads.datamanager.v1.UserListDirectLicense.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.GetUserListDirectLicenseRequest,
          com.google.ads.datamanager.v1.UserListDirectLicense>
      getGetUserListDirectLicenseMethod() {
    io.grpc.MethodDescriptor<
            com.google.ads.datamanager.v1.GetUserListDirectLicenseRequest,
            com.google.ads.datamanager.v1.UserListDirectLicense>
        getGetUserListDirectLicenseMethod;
    if ((getGetUserListDirectLicenseMethod =
            UserListDirectLicenseServiceGrpc.getGetUserListDirectLicenseMethod)
        == null) {
      synchronized (UserListDirectLicenseServiceGrpc.class) {
        if ((getGetUserListDirectLicenseMethod =
                UserListDirectLicenseServiceGrpc.getGetUserListDirectLicenseMethod)
            == null) {
          UserListDirectLicenseServiceGrpc.getGetUserListDirectLicenseMethod =
              getGetUserListDirectLicenseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.ads.datamanager.v1.GetUserListDirectLicenseRequest,
                          com.google.ads.datamanager.v1.UserListDirectLicense>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetUserListDirectLicense"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.GetUserListDirectLicenseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.UserListDirectLicense
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new UserListDirectLicenseServiceMethodDescriptorSupplier(
                              "GetUserListDirectLicense"))
                      .build();
        }
      }
    }
    return getGetUserListDirectLicenseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.UpdateUserListDirectLicenseRequest,
          com.google.ads.datamanager.v1.UserListDirectLicense>
      getUpdateUserListDirectLicenseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateUserListDirectLicense",
      requestType = com.google.ads.datamanager.v1.UpdateUserListDirectLicenseRequest.class,
      responseType = com.google.ads.datamanager.v1.UserListDirectLicense.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.UpdateUserListDirectLicenseRequest,
          com.google.ads.datamanager.v1.UserListDirectLicense>
      getUpdateUserListDirectLicenseMethod() {
    io.grpc.MethodDescriptor<
            com.google.ads.datamanager.v1.UpdateUserListDirectLicenseRequest,
            com.google.ads.datamanager.v1.UserListDirectLicense>
        getUpdateUserListDirectLicenseMethod;
    if ((getUpdateUserListDirectLicenseMethod =
            UserListDirectLicenseServiceGrpc.getUpdateUserListDirectLicenseMethod)
        == null) {
      synchronized (UserListDirectLicenseServiceGrpc.class) {
        if ((getUpdateUserListDirectLicenseMethod =
                UserListDirectLicenseServiceGrpc.getUpdateUserListDirectLicenseMethod)
            == null) {
          UserListDirectLicenseServiceGrpc.getUpdateUserListDirectLicenseMethod =
              getUpdateUserListDirectLicenseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.ads.datamanager.v1.UpdateUserListDirectLicenseRequest,
                          com.google.ads.datamanager.v1.UserListDirectLicense>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateUserListDirectLicense"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.UpdateUserListDirectLicenseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.UserListDirectLicense
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new UserListDirectLicenseServiceMethodDescriptorSupplier(
                              "UpdateUserListDirectLicense"))
                      .build();
        }
      }
    }
    return getUpdateUserListDirectLicenseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.ListUserListDirectLicensesRequest,
          com.google.ads.datamanager.v1.ListUserListDirectLicensesResponse>
      getListUserListDirectLicensesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListUserListDirectLicenses",
      requestType = com.google.ads.datamanager.v1.ListUserListDirectLicensesRequest.class,
      responseType = com.google.ads.datamanager.v1.ListUserListDirectLicensesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.ListUserListDirectLicensesRequest,
          com.google.ads.datamanager.v1.ListUserListDirectLicensesResponse>
      getListUserListDirectLicensesMethod() {
    io.grpc.MethodDescriptor<
            com.google.ads.datamanager.v1.ListUserListDirectLicensesRequest,
            com.google.ads.datamanager.v1.ListUserListDirectLicensesResponse>
        getListUserListDirectLicensesMethod;
    if ((getListUserListDirectLicensesMethod =
            UserListDirectLicenseServiceGrpc.getListUserListDirectLicensesMethod)
        == null) {
      synchronized (UserListDirectLicenseServiceGrpc.class) {
        if ((getListUserListDirectLicensesMethod =
                UserListDirectLicenseServiceGrpc.getListUserListDirectLicensesMethod)
            == null) {
          UserListDirectLicenseServiceGrpc.getListUserListDirectLicensesMethod =
              getListUserListDirectLicensesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.ads.datamanager.v1.ListUserListDirectLicensesRequest,
                          com.google.ads.datamanager.v1.ListUserListDirectLicensesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListUserListDirectLicenses"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.ListUserListDirectLicensesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.ListUserListDirectLicensesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new UserListDirectLicenseServiceMethodDescriptorSupplier(
                              "ListUserListDirectLicenses"))
                      .build();
        }
      }
    }
    return getListUserListDirectLicensesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static UserListDirectLicenseServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserListDirectLicenseServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<UserListDirectLicenseServiceStub>() {
          @java.lang.Override
          public UserListDirectLicenseServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new UserListDirectLicenseServiceStub(channel, callOptions);
          }
        };
    return UserListDirectLicenseServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static UserListDirectLicenseServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserListDirectLicenseServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<UserListDirectLicenseServiceBlockingV2Stub>() {
          @java.lang.Override
          public UserListDirectLicenseServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new UserListDirectLicenseServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return UserListDirectLicenseServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserListDirectLicenseServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserListDirectLicenseServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<UserListDirectLicenseServiceBlockingStub>() {
          @java.lang.Override
          public UserListDirectLicenseServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new UserListDirectLicenseServiceBlockingStub(channel, callOptions);
          }
        };
    return UserListDirectLicenseServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static UserListDirectLicenseServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserListDirectLicenseServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<UserListDirectLicenseServiceFutureStub>() {
          @java.lang.Override
          public UserListDirectLicenseServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new UserListDirectLicenseServiceFutureStub(channel, callOptions);
          }
        };
    return UserListDirectLicenseServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing user list direct licenses. Delete is not a supported
   * operation for UserListDirectLicenses.  Callers should update the
   * license status to DISABLED to instead to deactivate a license.
   * This feature is only available to data partners.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a user list direct license.
     * This feature is only available to data partners.
     * </pre>
     */
    default void createUserListDirectLicense(
        com.google.ads.datamanager.v1.CreateUserListDirectLicenseRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.UserListDirectLicense>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateUserListDirectLicenseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a user list direct license.
     * This feature is only available to data partners.
     * </pre>
     */
    default void getUserListDirectLicense(
        com.google.ads.datamanager.v1.GetUserListDirectLicenseRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.UserListDirectLicense>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetUserListDirectLicenseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a user list direct license.
     * This feature is only available to data partners.
     * </pre>
     */
    default void updateUserListDirectLicense(
        com.google.ads.datamanager.v1.UpdateUserListDirectLicenseRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.UserListDirectLicense>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateUserListDirectLicenseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all user list direct licenses owned by the parent account.
     * This feature is only available to data partners.
     * </pre>
     */
    default void listUserListDirectLicenses(
        com.google.ads.datamanager.v1.ListUserListDirectLicensesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.ads.datamanager.v1.ListUserListDirectLicensesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListUserListDirectLicensesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service UserListDirectLicenseService.
   *
   * <pre>
   * Service for managing user list direct licenses. Delete is not a supported
   * operation for UserListDirectLicenses.  Callers should update the
   * license status to DISABLED to instead to deactivate a license.
   * This feature is only available to data partners.
   * </pre>
   */
  public abstract static class UserListDirectLicenseServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return UserListDirectLicenseServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service UserListDirectLicenseService.
   *
   * <pre>
   * Service for managing user list direct licenses. Delete is not a supported
   * operation for UserListDirectLicenses.  Callers should update the
   * license status to DISABLED to instead to deactivate a license.
   * This feature is only available to data partners.
   * </pre>
   */
  public static final class UserListDirectLicenseServiceStub
      extends io.grpc.stub.AbstractAsyncStub<UserListDirectLicenseServiceStub> {
    private UserListDirectLicenseServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserListDirectLicenseServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserListDirectLicenseServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a user list direct license.
     * This feature is only available to data partners.
     * </pre>
     */
    public void createUserListDirectLicense(
        com.google.ads.datamanager.v1.CreateUserListDirectLicenseRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.UserListDirectLicense>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateUserListDirectLicenseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a user list direct license.
     * This feature is only available to data partners.
     * </pre>
     */
    public void getUserListDirectLicense(
        com.google.ads.datamanager.v1.GetUserListDirectLicenseRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.UserListDirectLicense>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserListDirectLicenseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a user list direct license.
     * This feature is only available to data partners.
     * </pre>
     */
    public void updateUserListDirectLicense(
        com.google.ads.datamanager.v1.UpdateUserListDirectLicenseRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.UserListDirectLicense>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateUserListDirectLicenseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all user list direct licenses owned by the parent account.
     * This feature is only available to data partners.
     * </pre>
     */
    public void listUserListDirectLicenses(
        com.google.ads.datamanager.v1.ListUserListDirectLicensesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.ads.datamanager.v1.ListUserListDirectLicensesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListUserListDirectLicensesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service UserListDirectLicenseService.
   *
   * <pre>
   * Service for managing user list direct licenses. Delete is not a supported
   * operation for UserListDirectLicenses.  Callers should update the
   * license status to DISABLED to instead to deactivate a license.
   * This feature is only available to data partners.
   * </pre>
   */
  public static final class UserListDirectLicenseServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<UserListDirectLicenseServiceBlockingV2Stub> {
    private UserListDirectLicenseServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserListDirectLicenseServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserListDirectLicenseServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a user list direct license.
     * This feature is only available to data partners.
     * </pre>
     */
    public com.google.ads.datamanager.v1.UserListDirectLicense createUserListDirectLicense(
        com.google.ads.datamanager.v1.CreateUserListDirectLicenseRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateUserListDirectLicenseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a user list direct license.
     * This feature is only available to data partners.
     * </pre>
     */
    public com.google.ads.datamanager.v1.UserListDirectLicense getUserListDirectLicense(
        com.google.ads.datamanager.v1.GetUserListDirectLicenseRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetUserListDirectLicenseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a user list direct license.
     * This feature is only available to data partners.
     * </pre>
     */
    public com.google.ads.datamanager.v1.UserListDirectLicense updateUserListDirectLicense(
        com.google.ads.datamanager.v1.UpdateUserListDirectLicenseRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateUserListDirectLicenseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all user list direct licenses owned by the parent account.
     * This feature is only available to data partners.
     * </pre>
     */
    public com.google.ads.datamanager.v1.ListUserListDirectLicensesResponse
        listUserListDirectLicenses(
            com.google.ads.datamanager.v1.ListUserListDirectLicensesRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListUserListDirectLicensesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service
   * UserListDirectLicenseService.
   *
   * <pre>
   * Service for managing user list direct licenses. Delete is not a supported
   * operation for UserListDirectLicenses.  Callers should update the
   * license status to DISABLED to instead to deactivate a license.
   * This feature is only available to data partners.
   * </pre>
   */
  public static final class UserListDirectLicenseServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<UserListDirectLicenseServiceBlockingStub> {
    private UserListDirectLicenseServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserListDirectLicenseServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserListDirectLicenseServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a user list direct license.
     * This feature is only available to data partners.
     * </pre>
     */
    public com.google.ads.datamanager.v1.UserListDirectLicense createUserListDirectLicense(
        com.google.ads.datamanager.v1.CreateUserListDirectLicenseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUserListDirectLicenseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a user list direct license.
     * This feature is only available to data partners.
     * </pre>
     */
    public com.google.ads.datamanager.v1.UserListDirectLicense getUserListDirectLicense(
        com.google.ads.datamanager.v1.GetUserListDirectLicenseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserListDirectLicenseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a user list direct license.
     * This feature is only available to data partners.
     * </pre>
     */
    public com.google.ads.datamanager.v1.UserListDirectLicense updateUserListDirectLicense(
        com.google.ads.datamanager.v1.UpdateUserListDirectLicenseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUserListDirectLicenseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all user list direct licenses owned by the parent account.
     * This feature is only available to data partners.
     * </pre>
     */
    public com.google.ads.datamanager.v1.ListUserListDirectLicensesResponse
        listUserListDirectLicenses(
            com.google.ads.datamanager.v1.ListUserListDirectLicensesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUserListDirectLicensesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * UserListDirectLicenseService.
   *
   * <pre>
   * Service for managing user list direct licenses. Delete is not a supported
   * operation for UserListDirectLicenses.  Callers should update the
   * license status to DISABLED to instead to deactivate a license.
   * This feature is only available to data partners.
   * </pre>
   */
  public static final class UserListDirectLicenseServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<UserListDirectLicenseServiceFutureStub> {
    private UserListDirectLicenseServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserListDirectLicenseServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserListDirectLicenseServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a user list direct license.
     * This feature is only available to data partners.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.ads.datamanager.v1.UserListDirectLicense>
        createUserListDirectLicense(
            com.google.ads.datamanager.v1.CreateUserListDirectLicenseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateUserListDirectLicenseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a user list direct license.
     * This feature is only available to data partners.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.ads.datamanager.v1.UserListDirectLicense>
        getUserListDirectLicense(
            com.google.ads.datamanager.v1.GetUserListDirectLicenseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserListDirectLicenseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a user list direct license.
     * This feature is only available to data partners.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.ads.datamanager.v1.UserListDirectLicense>
        updateUserListDirectLicense(
            com.google.ads.datamanager.v1.UpdateUserListDirectLicenseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateUserListDirectLicenseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all user list direct licenses owned by the parent account.
     * This feature is only available to data partners.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.ads.datamanager.v1.ListUserListDirectLicensesResponse>
        listUserListDirectLicenses(
            com.google.ads.datamanager.v1.ListUserListDirectLicensesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListUserListDirectLicensesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_USER_LIST_DIRECT_LICENSE = 0;
  private static final int METHODID_GET_USER_LIST_DIRECT_LICENSE = 1;
  private static final int METHODID_UPDATE_USER_LIST_DIRECT_LICENSE = 2;
  private static final int METHODID_LIST_USER_LIST_DIRECT_LICENSES = 3;

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
        case METHODID_CREATE_USER_LIST_DIRECT_LICENSE:
          serviceImpl.createUserListDirectLicense(
              (com.google.ads.datamanager.v1.CreateUserListDirectLicenseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.UserListDirectLicense>)
                  responseObserver);
          break;
        case METHODID_GET_USER_LIST_DIRECT_LICENSE:
          serviceImpl.getUserListDirectLicense(
              (com.google.ads.datamanager.v1.GetUserListDirectLicenseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.UserListDirectLicense>)
                  responseObserver);
          break;
        case METHODID_UPDATE_USER_LIST_DIRECT_LICENSE:
          serviceImpl.updateUserListDirectLicense(
              (com.google.ads.datamanager.v1.UpdateUserListDirectLicenseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.UserListDirectLicense>)
                  responseObserver);
          break;
        case METHODID_LIST_USER_LIST_DIRECT_LICENSES:
          serviceImpl.listUserListDirectLicenses(
              (com.google.ads.datamanager.v1.ListUserListDirectLicensesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.ads.datamanager.v1.ListUserListDirectLicensesResponse>)
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
            getCreateUserListDirectLicenseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.ads.datamanager.v1.CreateUserListDirectLicenseRequest,
                    com.google.ads.datamanager.v1.UserListDirectLicense>(
                    service, METHODID_CREATE_USER_LIST_DIRECT_LICENSE)))
        .addMethod(
            getGetUserListDirectLicenseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.ads.datamanager.v1.GetUserListDirectLicenseRequest,
                    com.google.ads.datamanager.v1.UserListDirectLicense>(
                    service, METHODID_GET_USER_LIST_DIRECT_LICENSE)))
        .addMethod(
            getUpdateUserListDirectLicenseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.ads.datamanager.v1.UpdateUserListDirectLicenseRequest,
                    com.google.ads.datamanager.v1.UserListDirectLicense>(
                    service, METHODID_UPDATE_USER_LIST_DIRECT_LICENSE)))
        .addMethod(
            getListUserListDirectLicensesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.ads.datamanager.v1.ListUserListDirectLicensesRequest,
                    com.google.ads.datamanager.v1.ListUserListDirectLicensesResponse>(
                    service, METHODID_LIST_USER_LIST_DIRECT_LICENSES)))
        .build();
  }

  private abstract static class UserListDirectLicenseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserListDirectLicenseServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.ads.datamanager.v1.UserListDirectLicenseServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserListDirectLicenseService");
    }
  }

  private static final class UserListDirectLicenseServiceFileDescriptorSupplier
      extends UserListDirectLicenseServiceBaseDescriptorSupplier {
    UserListDirectLicenseServiceFileDescriptorSupplier() {}
  }

  private static final class UserListDirectLicenseServiceMethodDescriptorSupplier
      extends UserListDirectLicenseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    UserListDirectLicenseServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (UserListDirectLicenseServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new UserListDirectLicenseServiceFileDescriptorSupplier())
                      .addMethod(getCreateUserListDirectLicenseMethod())
                      .addMethod(getGetUserListDirectLicenseMethod())
                      .addMethod(getUpdateUserListDirectLicenseMethod())
                      .addMethod(getListUserListDirectLicensesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
