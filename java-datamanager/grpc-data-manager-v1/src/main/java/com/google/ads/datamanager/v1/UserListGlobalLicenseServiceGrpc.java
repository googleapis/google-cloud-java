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
 * Service for managing user list global licenses. Delete is not a supported
 * operation for UserListGlobalLicenses.  Callers should update the
 * license status to DISABLED to instead to deactivate a license.
 * This feature is only available to data partners.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class UserListGlobalLicenseServiceGrpc {

  private UserListGlobalLicenseServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.ads.datamanager.v1.UserListGlobalLicenseService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.CreateUserListGlobalLicenseRequest,
          com.google.ads.datamanager.v1.UserListGlobalLicense>
      getCreateUserListGlobalLicenseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUserListGlobalLicense",
      requestType = com.google.ads.datamanager.v1.CreateUserListGlobalLicenseRequest.class,
      responseType = com.google.ads.datamanager.v1.UserListGlobalLicense.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.CreateUserListGlobalLicenseRequest,
          com.google.ads.datamanager.v1.UserListGlobalLicense>
      getCreateUserListGlobalLicenseMethod() {
    io.grpc.MethodDescriptor<
            com.google.ads.datamanager.v1.CreateUserListGlobalLicenseRequest,
            com.google.ads.datamanager.v1.UserListGlobalLicense>
        getCreateUserListGlobalLicenseMethod;
    if ((getCreateUserListGlobalLicenseMethod =
            UserListGlobalLicenseServiceGrpc.getCreateUserListGlobalLicenseMethod)
        == null) {
      synchronized (UserListGlobalLicenseServiceGrpc.class) {
        if ((getCreateUserListGlobalLicenseMethod =
                UserListGlobalLicenseServiceGrpc.getCreateUserListGlobalLicenseMethod)
            == null) {
          UserListGlobalLicenseServiceGrpc.getCreateUserListGlobalLicenseMethod =
              getCreateUserListGlobalLicenseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.ads.datamanager.v1.CreateUserListGlobalLicenseRequest,
                          com.google.ads.datamanager.v1.UserListGlobalLicense>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateUserListGlobalLicense"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.CreateUserListGlobalLicenseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.UserListGlobalLicense
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new UserListGlobalLicenseServiceMethodDescriptorSupplier(
                              "CreateUserListGlobalLicense"))
                      .build();
        }
      }
    }
    return getCreateUserListGlobalLicenseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.UpdateUserListGlobalLicenseRequest,
          com.google.ads.datamanager.v1.UserListGlobalLicense>
      getUpdateUserListGlobalLicenseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateUserListGlobalLicense",
      requestType = com.google.ads.datamanager.v1.UpdateUserListGlobalLicenseRequest.class,
      responseType = com.google.ads.datamanager.v1.UserListGlobalLicense.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.UpdateUserListGlobalLicenseRequest,
          com.google.ads.datamanager.v1.UserListGlobalLicense>
      getUpdateUserListGlobalLicenseMethod() {
    io.grpc.MethodDescriptor<
            com.google.ads.datamanager.v1.UpdateUserListGlobalLicenseRequest,
            com.google.ads.datamanager.v1.UserListGlobalLicense>
        getUpdateUserListGlobalLicenseMethod;
    if ((getUpdateUserListGlobalLicenseMethod =
            UserListGlobalLicenseServiceGrpc.getUpdateUserListGlobalLicenseMethod)
        == null) {
      synchronized (UserListGlobalLicenseServiceGrpc.class) {
        if ((getUpdateUserListGlobalLicenseMethod =
                UserListGlobalLicenseServiceGrpc.getUpdateUserListGlobalLicenseMethod)
            == null) {
          UserListGlobalLicenseServiceGrpc.getUpdateUserListGlobalLicenseMethod =
              getUpdateUserListGlobalLicenseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.ads.datamanager.v1.UpdateUserListGlobalLicenseRequest,
                          com.google.ads.datamanager.v1.UserListGlobalLicense>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateUserListGlobalLicense"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.UpdateUserListGlobalLicenseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.UserListGlobalLicense
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new UserListGlobalLicenseServiceMethodDescriptorSupplier(
                              "UpdateUserListGlobalLicense"))
                      .build();
        }
      }
    }
    return getUpdateUserListGlobalLicenseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.GetUserListGlobalLicenseRequest,
          com.google.ads.datamanager.v1.UserListGlobalLicense>
      getGetUserListGlobalLicenseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserListGlobalLicense",
      requestType = com.google.ads.datamanager.v1.GetUserListGlobalLicenseRequest.class,
      responseType = com.google.ads.datamanager.v1.UserListGlobalLicense.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.GetUserListGlobalLicenseRequest,
          com.google.ads.datamanager.v1.UserListGlobalLicense>
      getGetUserListGlobalLicenseMethod() {
    io.grpc.MethodDescriptor<
            com.google.ads.datamanager.v1.GetUserListGlobalLicenseRequest,
            com.google.ads.datamanager.v1.UserListGlobalLicense>
        getGetUserListGlobalLicenseMethod;
    if ((getGetUserListGlobalLicenseMethod =
            UserListGlobalLicenseServiceGrpc.getGetUserListGlobalLicenseMethod)
        == null) {
      synchronized (UserListGlobalLicenseServiceGrpc.class) {
        if ((getGetUserListGlobalLicenseMethod =
                UserListGlobalLicenseServiceGrpc.getGetUserListGlobalLicenseMethod)
            == null) {
          UserListGlobalLicenseServiceGrpc.getGetUserListGlobalLicenseMethod =
              getGetUserListGlobalLicenseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.ads.datamanager.v1.GetUserListGlobalLicenseRequest,
                          com.google.ads.datamanager.v1.UserListGlobalLicense>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetUserListGlobalLicense"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.GetUserListGlobalLicenseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.UserListGlobalLicense
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new UserListGlobalLicenseServiceMethodDescriptorSupplier(
                              "GetUserListGlobalLicense"))
                      .build();
        }
      }
    }
    return getGetUserListGlobalLicenseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.ListUserListGlobalLicensesRequest,
          com.google.ads.datamanager.v1.ListUserListGlobalLicensesResponse>
      getListUserListGlobalLicensesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListUserListGlobalLicenses",
      requestType = com.google.ads.datamanager.v1.ListUserListGlobalLicensesRequest.class,
      responseType = com.google.ads.datamanager.v1.ListUserListGlobalLicensesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.ListUserListGlobalLicensesRequest,
          com.google.ads.datamanager.v1.ListUserListGlobalLicensesResponse>
      getListUserListGlobalLicensesMethod() {
    io.grpc.MethodDescriptor<
            com.google.ads.datamanager.v1.ListUserListGlobalLicensesRequest,
            com.google.ads.datamanager.v1.ListUserListGlobalLicensesResponse>
        getListUserListGlobalLicensesMethod;
    if ((getListUserListGlobalLicensesMethod =
            UserListGlobalLicenseServiceGrpc.getListUserListGlobalLicensesMethod)
        == null) {
      synchronized (UserListGlobalLicenseServiceGrpc.class) {
        if ((getListUserListGlobalLicensesMethod =
                UserListGlobalLicenseServiceGrpc.getListUserListGlobalLicensesMethod)
            == null) {
          UserListGlobalLicenseServiceGrpc.getListUserListGlobalLicensesMethod =
              getListUserListGlobalLicensesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.ads.datamanager.v1.ListUserListGlobalLicensesRequest,
                          com.google.ads.datamanager.v1.ListUserListGlobalLicensesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListUserListGlobalLicenses"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.ListUserListGlobalLicensesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.ListUserListGlobalLicensesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new UserListGlobalLicenseServiceMethodDescriptorSupplier(
                              "ListUserListGlobalLicenses"))
                      .build();
        }
      }
    }
    return getListUserListGlobalLicensesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.ListUserListGlobalLicenseCustomerInfosRequest,
          com.google.ads.datamanager.v1.ListUserListGlobalLicenseCustomerInfosResponse>
      getListUserListGlobalLicenseCustomerInfosMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListUserListGlobalLicenseCustomerInfos",
      requestType =
          com.google.ads.datamanager.v1.ListUserListGlobalLicenseCustomerInfosRequest.class,
      responseType =
          com.google.ads.datamanager.v1.ListUserListGlobalLicenseCustomerInfosResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.ListUserListGlobalLicenseCustomerInfosRequest,
          com.google.ads.datamanager.v1.ListUserListGlobalLicenseCustomerInfosResponse>
      getListUserListGlobalLicenseCustomerInfosMethod() {
    io.grpc.MethodDescriptor<
            com.google.ads.datamanager.v1.ListUserListGlobalLicenseCustomerInfosRequest,
            com.google.ads.datamanager.v1.ListUserListGlobalLicenseCustomerInfosResponse>
        getListUserListGlobalLicenseCustomerInfosMethod;
    if ((getListUserListGlobalLicenseCustomerInfosMethod =
            UserListGlobalLicenseServiceGrpc.getListUserListGlobalLicenseCustomerInfosMethod)
        == null) {
      synchronized (UserListGlobalLicenseServiceGrpc.class) {
        if ((getListUserListGlobalLicenseCustomerInfosMethod =
                UserListGlobalLicenseServiceGrpc.getListUserListGlobalLicenseCustomerInfosMethod)
            == null) {
          UserListGlobalLicenseServiceGrpc.getListUserListGlobalLicenseCustomerInfosMethod =
              getListUserListGlobalLicenseCustomerInfosMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.ads.datamanager.v1.ListUserListGlobalLicenseCustomerInfosRequest,
                          com.google.ads.datamanager.v1
                              .ListUserListGlobalLicenseCustomerInfosResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "ListUserListGlobalLicenseCustomerInfos"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1
                                  .ListUserListGlobalLicenseCustomerInfosRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1
                                  .ListUserListGlobalLicenseCustomerInfosResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new UserListGlobalLicenseServiceMethodDescriptorSupplier(
                              "ListUserListGlobalLicenseCustomerInfos"))
                      .build();
        }
      }
    }
    return getListUserListGlobalLicenseCustomerInfosMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static UserListGlobalLicenseServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserListGlobalLicenseServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<UserListGlobalLicenseServiceStub>() {
          @java.lang.Override
          public UserListGlobalLicenseServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new UserListGlobalLicenseServiceStub(channel, callOptions);
          }
        };
    return UserListGlobalLicenseServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static UserListGlobalLicenseServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserListGlobalLicenseServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<UserListGlobalLicenseServiceBlockingV2Stub>() {
          @java.lang.Override
          public UserListGlobalLicenseServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new UserListGlobalLicenseServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return UserListGlobalLicenseServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserListGlobalLicenseServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserListGlobalLicenseServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<UserListGlobalLicenseServiceBlockingStub>() {
          @java.lang.Override
          public UserListGlobalLicenseServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new UserListGlobalLicenseServiceBlockingStub(channel, callOptions);
          }
        };
    return UserListGlobalLicenseServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static UserListGlobalLicenseServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserListGlobalLicenseServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<UserListGlobalLicenseServiceFutureStub>() {
          @java.lang.Override
          public UserListGlobalLicenseServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new UserListGlobalLicenseServiceFutureStub(channel, callOptions);
          }
        };
    return UserListGlobalLicenseServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing user list global licenses. Delete is not a supported
   * operation for UserListGlobalLicenses.  Callers should update the
   * license status to DISABLED to instead to deactivate a license.
   * This feature is only available to data partners.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a user list global license.
     * This feature is only available to data partners.
     * </pre>
     */
    default void createUserListGlobalLicense(
        com.google.ads.datamanager.v1.CreateUserListGlobalLicenseRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.UserListGlobalLicense>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateUserListGlobalLicenseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a user list global license.
     * This feature is only available to data partners.
     * </pre>
     */
    default void updateUserListGlobalLicense(
        com.google.ads.datamanager.v1.UpdateUserListGlobalLicenseRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.UserListGlobalLicense>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateUserListGlobalLicenseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a user list global license.
     * This feature is only available to data partners.
     * </pre>
     */
    default void getUserListGlobalLicense(
        com.google.ads.datamanager.v1.GetUserListGlobalLicenseRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.UserListGlobalLicense>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetUserListGlobalLicenseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all user list global licenses owned by the parent account.
     * This feature is only available to data partners.
     * </pre>
     */
    default void listUserListGlobalLicenses(
        com.google.ads.datamanager.v1.ListUserListGlobalLicensesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.ads.datamanager.v1.ListUserListGlobalLicensesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListUserListGlobalLicensesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all customer info for a user list global license.
     * This feature is only available to data partners.
     * </pre>
     */
    default void listUserListGlobalLicenseCustomerInfos(
        com.google.ads.datamanager.v1.ListUserListGlobalLicenseCustomerInfosRequest request,
        io.grpc.stub.StreamObserver<
                com.google.ads.datamanager.v1.ListUserListGlobalLicenseCustomerInfosResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListUserListGlobalLicenseCustomerInfosMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service UserListGlobalLicenseService.
   *
   * <pre>
   * Service for managing user list global licenses. Delete is not a supported
   * operation for UserListGlobalLicenses.  Callers should update the
   * license status to DISABLED to instead to deactivate a license.
   * This feature is only available to data partners.
   * </pre>
   */
  public abstract static class UserListGlobalLicenseServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return UserListGlobalLicenseServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service UserListGlobalLicenseService.
   *
   * <pre>
   * Service for managing user list global licenses. Delete is not a supported
   * operation for UserListGlobalLicenses.  Callers should update the
   * license status to DISABLED to instead to deactivate a license.
   * This feature is only available to data partners.
   * </pre>
   */
  public static final class UserListGlobalLicenseServiceStub
      extends io.grpc.stub.AbstractAsyncStub<UserListGlobalLicenseServiceStub> {
    private UserListGlobalLicenseServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserListGlobalLicenseServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserListGlobalLicenseServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a user list global license.
     * This feature is only available to data partners.
     * </pre>
     */
    public void createUserListGlobalLicense(
        com.google.ads.datamanager.v1.CreateUserListGlobalLicenseRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.UserListGlobalLicense>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateUserListGlobalLicenseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a user list global license.
     * This feature is only available to data partners.
     * </pre>
     */
    public void updateUserListGlobalLicense(
        com.google.ads.datamanager.v1.UpdateUserListGlobalLicenseRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.UserListGlobalLicense>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateUserListGlobalLicenseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a user list global license.
     * This feature is only available to data partners.
     * </pre>
     */
    public void getUserListGlobalLicense(
        com.google.ads.datamanager.v1.GetUserListGlobalLicenseRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.UserListGlobalLicense>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserListGlobalLicenseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all user list global licenses owned by the parent account.
     * This feature is only available to data partners.
     * </pre>
     */
    public void listUserListGlobalLicenses(
        com.google.ads.datamanager.v1.ListUserListGlobalLicensesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.ads.datamanager.v1.ListUserListGlobalLicensesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListUserListGlobalLicensesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all customer info for a user list global license.
     * This feature is only available to data partners.
     * </pre>
     */
    public void listUserListGlobalLicenseCustomerInfos(
        com.google.ads.datamanager.v1.ListUserListGlobalLicenseCustomerInfosRequest request,
        io.grpc.stub.StreamObserver<
                com.google.ads.datamanager.v1.ListUserListGlobalLicenseCustomerInfosResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListUserListGlobalLicenseCustomerInfosMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service UserListGlobalLicenseService.
   *
   * <pre>
   * Service for managing user list global licenses. Delete is not a supported
   * operation for UserListGlobalLicenses.  Callers should update the
   * license status to DISABLED to instead to deactivate a license.
   * This feature is only available to data partners.
   * </pre>
   */
  public static final class UserListGlobalLicenseServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<UserListGlobalLicenseServiceBlockingV2Stub> {
    private UserListGlobalLicenseServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserListGlobalLicenseServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserListGlobalLicenseServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a user list global license.
     * This feature is only available to data partners.
     * </pre>
     */
    public com.google.ads.datamanager.v1.UserListGlobalLicense createUserListGlobalLicense(
        com.google.ads.datamanager.v1.CreateUserListGlobalLicenseRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateUserListGlobalLicenseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a user list global license.
     * This feature is only available to data partners.
     * </pre>
     */
    public com.google.ads.datamanager.v1.UserListGlobalLicense updateUserListGlobalLicense(
        com.google.ads.datamanager.v1.UpdateUserListGlobalLicenseRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateUserListGlobalLicenseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a user list global license.
     * This feature is only available to data partners.
     * </pre>
     */
    public com.google.ads.datamanager.v1.UserListGlobalLicense getUserListGlobalLicense(
        com.google.ads.datamanager.v1.GetUserListGlobalLicenseRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetUserListGlobalLicenseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all user list global licenses owned by the parent account.
     * This feature is only available to data partners.
     * </pre>
     */
    public com.google.ads.datamanager.v1.ListUserListGlobalLicensesResponse
        listUserListGlobalLicenses(
            com.google.ads.datamanager.v1.ListUserListGlobalLicensesRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListUserListGlobalLicensesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all customer info for a user list global license.
     * This feature is only available to data partners.
     * </pre>
     */
    public com.google.ads.datamanager.v1.ListUserListGlobalLicenseCustomerInfosResponse
        listUserListGlobalLicenseCustomerInfos(
            com.google.ads.datamanager.v1.ListUserListGlobalLicenseCustomerInfosRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(),
          getListUserListGlobalLicenseCustomerInfosMethod(),
          getCallOptions(),
          request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service
   * UserListGlobalLicenseService.
   *
   * <pre>
   * Service for managing user list global licenses. Delete is not a supported
   * operation for UserListGlobalLicenses.  Callers should update the
   * license status to DISABLED to instead to deactivate a license.
   * This feature is only available to data partners.
   * </pre>
   */
  public static final class UserListGlobalLicenseServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<UserListGlobalLicenseServiceBlockingStub> {
    private UserListGlobalLicenseServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserListGlobalLicenseServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserListGlobalLicenseServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a user list global license.
     * This feature is only available to data partners.
     * </pre>
     */
    public com.google.ads.datamanager.v1.UserListGlobalLicense createUserListGlobalLicense(
        com.google.ads.datamanager.v1.CreateUserListGlobalLicenseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUserListGlobalLicenseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a user list global license.
     * This feature is only available to data partners.
     * </pre>
     */
    public com.google.ads.datamanager.v1.UserListGlobalLicense updateUserListGlobalLicense(
        com.google.ads.datamanager.v1.UpdateUserListGlobalLicenseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUserListGlobalLicenseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a user list global license.
     * This feature is only available to data partners.
     * </pre>
     */
    public com.google.ads.datamanager.v1.UserListGlobalLicense getUserListGlobalLicense(
        com.google.ads.datamanager.v1.GetUserListGlobalLicenseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserListGlobalLicenseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all user list global licenses owned by the parent account.
     * This feature is only available to data partners.
     * </pre>
     */
    public com.google.ads.datamanager.v1.ListUserListGlobalLicensesResponse
        listUserListGlobalLicenses(
            com.google.ads.datamanager.v1.ListUserListGlobalLicensesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUserListGlobalLicensesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all customer info for a user list global license.
     * This feature is only available to data partners.
     * </pre>
     */
    public com.google.ads.datamanager.v1.ListUserListGlobalLicenseCustomerInfosResponse
        listUserListGlobalLicenseCustomerInfos(
            com.google.ads.datamanager.v1.ListUserListGlobalLicenseCustomerInfosRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getListUserListGlobalLicenseCustomerInfosMethod(),
          getCallOptions(),
          request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * UserListGlobalLicenseService.
   *
   * <pre>
   * Service for managing user list global licenses. Delete is not a supported
   * operation for UserListGlobalLicenses.  Callers should update the
   * license status to DISABLED to instead to deactivate a license.
   * This feature is only available to data partners.
   * </pre>
   */
  public static final class UserListGlobalLicenseServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<UserListGlobalLicenseServiceFutureStub> {
    private UserListGlobalLicenseServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserListGlobalLicenseServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserListGlobalLicenseServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a user list global license.
     * This feature is only available to data partners.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.ads.datamanager.v1.UserListGlobalLicense>
        createUserListGlobalLicense(
            com.google.ads.datamanager.v1.CreateUserListGlobalLicenseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateUserListGlobalLicenseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a user list global license.
     * This feature is only available to data partners.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.ads.datamanager.v1.UserListGlobalLicense>
        updateUserListGlobalLicense(
            com.google.ads.datamanager.v1.UpdateUserListGlobalLicenseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateUserListGlobalLicenseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a user list global license.
     * This feature is only available to data partners.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.ads.datamanager.v1.UserListGlobalLicense>
        getUserListGlobalLicense(
            com.google.ads.datamanager.v1.GetUserListGlobalLicenseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserListGlobalLicenseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all user list global licenses owned by the parent account.
     * This feature is only available to data partners.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.ads.datamanager.v1.ListUserListGlobalLicensesResponse>
        listUserListGlobalLicenses(
            com.google.ads.datamanager.v1.ListUserListGlobalLicensesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListUserListGlobalLicensesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all customer info for a user list global license.
     * This feature is only available to data partners.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.ads.datamanager.v1.ListUserListGlobalLicenseCustomerInfosResponse>
        listUserListGlobalLicenseCustomerInfos(
            com.google.ads.datamanager.v1.ListUserListGlobalLicenseCustomerInfosRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListUserListGlobalLicenseCustomerInfosMethod(), getCallOptions()),
          request);
    }
  }

  private static final int METHODID_CREATE_USER_LIST_GLOBAL_LICENSE = 0;
  private static final int METHODID_UPDATE_USER_LIST_GLOBAL_LICENSE = 1;
  private static final int METHODID_GET_USER_LIST_GLOBAL_LICENSE = 2;
  private static final int METHODID_LIST_USER_LIST_GLOBAL_LICENSES = 3;
  private static final int METHODID_LIST_USER_LIST_GLOBAL_LICENSE_CUSTOMER_INFOS = 4;

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
        case METHODID_CREATE_USER_LIST_GLOBAL_LICENSE:
          serviceImpl.createUserListGlobalLicense(
              (com.google.ads.datamanager.v1.CreateUserListGlobalLicenseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.UserListGlobalLicense>)
                  responseObserver);
          break;
        case METHODID_UPDATE_USER_LIST_GLOBAL_LICENSE:
          serviceImpl.updateUserListGlobalLicense(
              (com.google.ads.datamanager.v1.UpdateUserListGlobalLicenseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.UserListGlobalLicense>)
                  responseObserver);
          break;
        case METHODID_GET_USER_LIST_GLOBAL_LICENSE:
          serviceImpl.getUserListGlobalLicense(
              (com.google.ads.datamanager.v1.GetUserListGlobalLicenseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.UserListGlobalLicense>)
                  responseObserver);
          break;
        case METHODID_LIST_USER_LIST_GLOBAL_LICENSES:
          serviceImpl.listUserListGlobalLicenses(
              (com.google.ads.datamanager.v1.ListUserListGlobalLicensesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.ads.datamanager.v1.ListUserListGlobalLicensesResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_USER_LIST_GLOBAL_LICENSE_CUSTOMER_INFOS:
          serviceImpl.listUserListGlobalLicenseCustomerInfos(
              (com.google.ads.datamanager.v1.ListUserListGlobalLicenseCustomerInfosRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.ads.datamanager.v1.ListUserListGlobalLicenseCustomerInfosResponse>)
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
            getCreateUserListGlobalLicenseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.ads.datamanager.v1.CreateUserListGlobalLicenseRequest,
                    com.google.ads.datamanager.v1.UserListGlobalLicense>(
                    service, METHODID_CREATE_USER_LIST_GLOBAL_LICENSE)))
        .addMethod(
            getUpdateUserListGlobalLicenseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.ads.datamanager.v1.UpdateUserListGlobalLicenseRequest,
                    com.google.ads.datamanager.v1.UserListGlobalLicense>(
                    service, METHODID_UPDATE_USER_LIST_GLOBAL_LICENSE)))
        .addMethod(
            getGetUserListGlobalLicenseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.ads.datamanager.v1.GetUserListGlobalLicenseRequest,
                    com.google.ads.datamanager.v1.UserListGlobalLicense>(
                    service, METHODID_GET_USER_LIST_GLOBAL_LICENSE)))
        .addMethod(
            getListUserListGlobalLicensesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.ads.datamanager.v1.ListUserListGlobalLicensesRequest,
                    com.google.ads.datamanager.v1.ListUserListGlobalLicensesResponse>(
                    service, METHODID_LIST_USER_LIST_GLOBAL_LICENSES)))
        .addMethod(
            getListUserListGlobalLicenseCustomerInfosMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.ads.datamanager.v1.ListUserListGlobalLicenseCustomerInfosRequest,
                    com.google.ads.datamanager.v1.ListUserListGlobalLicenseCustomerInfosResponse>(
                    service, METHODID_LIST_USER_LIST_GLOBAL_LICENSE_CUSTOMER_INFOS)))
        .build();
  }

  private abstract static class UserListGlobalLicenseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserListGlobalLicenseServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.ads.datamanager.v1.UserListGlobalLicenseServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserListGlobalLicenseService");
    }
  }

  private static final class UserListGlobalLicenseServiceFileDescriptorSupplier
      extends UserListGlobalLicenseServiceBaseDescriptorSupplier {
    UserListGlobalLicenseServiceFileDescriptorSupplier() {}
  }

  private static final class UserListGlobalLicenseServiceMethodDescriptorSupplier
      extends UserListGlobalLicenseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    UserListGlobalLicenseServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (UserListGlobalLicenseServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new UserListGlobalLicenseServiceFileDescriptorSupplier())
                      .addMethod(getCreateUserListGlobalLicenseMethod())
                      .addMethod(getUpdateUserListGlobalLicenseMethod())
                      .addMethod(getGetUserListGlobalLicenseMethod())
                      .addMethod(getListUserListGlobalLicensesMethod())
                      .addMethod(getListUserListGlobalLicenseCustomerInfosMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
