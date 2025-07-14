/*
 * Copyright 2025 Google LLC
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
package com.google.cloud.discoveryengine.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing User Licenses.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/discoveryengine/v1/user_license_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class UserLicenseServiceGrpc {

  private UserLicenseServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.discoveryengine.v1.UserLicenseService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.ListUserLicensesRequest,
          com.google.cloud.discoveryengine.v1.ListUserLicensesResponse>
      getListUserLicensesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListUserLicenses",
      requestType = com.google.cloud.discoveryengine.v1.ListUserLicensesRequest.class,
      responseType = com.google.cloud.discoveryengine.v1.ListUserLicensesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.ListUserLicensesRequest,
          com.google.cloud.discoveryengine.v1.ListUserLicensesResponse>
      getListUserLicensesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1.ListUserLicensesRequest,
            com.google.cloud.discoveryengine.v1.ListUserLicensesResponse>
        getListUserLicensesMethod;
    if ((getListUserLicensesMethod = UserLicenseServiceGrpc.getListUserLicensesMethod) == null) {
      synchronized (UserLicenseServiceGrpc.class) {
        if ((getListUserLicensesMethod = UserLicenseServiceGrpc.getListUserLicensesMethod)
            == null) {
          UserLicenseServiceGrpc.getListUserLicensesMethod =
              getListUserLicensesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1.ListUserLicensesRequest,
                          com.google.cloud.discoveryengine.v1.ListUserLicensesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListUserLicenses"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.ListUserLicensesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.ListUserLicensesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new UserLicenseServiceMethodDescriptorSupplier("ListUserLicenses"))
                      .build();
        }
      }
    }
    return getListUserLicensesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.BatchUpdateUserLicensesRequest,
          com.google.longrunning.Operation>
      getBatchUpdateUserLicensesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchUpdateUserLicenses",
      requestType = com.google.cloud.discoveryengine.v1.BatchUpdateUserLicensesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.BatchUpdateUserLicensesRequest,
          com.google.longrunning.Operation>
      getBatchUpdateUserLicensesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1.BatchUpdateUserLicensesRequest,
            com.google.longrunning.Operation>
        getBatchUpdateUserLicensesMethod;
    if ((getBatchUpdateUserLicensesMethod = UserLicenseServiceGrpc.getBatchUpdateUserLicensesMethod)
        == null) {
      synchronized (UserLicenseServiceGrpc.class) {
        if ((getBatchUpdateUserLicensesMethod =
                UserLicenseServiceGrpc.getBatchUpdateUserLicensesMethod)
            == null) {
          UserLicenseServiceGrpc.getBatchUpdateUserLicensesMethod =
              getBatchUpdateUserLicensesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1.BatchUpdateUserLicensesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchUpdateUserLicenses"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.BatchUpdateUserLicensesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new UserLicenseServiceMethodDescriptorSupplier("BatchUpdateUserLicenses"))
                      .build();
        }
      }
    }
    return getBatchUpdateUserLicensesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static UserLicenseServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserLicenseServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<UserLicenseServiceStub>() {
          @java.lang.Override
          public UserLicenseServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new UserLicenseServiceStub(channel, callOptions);
          }
        };
    return UserLicenseServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static UserLicenseServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserLicenseServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<UserLicenseServiceBlockingV2Stub>() {
          @java.lang.Override
          public UserLicenseServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new UserLicenseServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return UserLicenseServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserLicenseServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserLicenseServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<UserLicenseServiceBlockingStub>() {
          @java.lang.Override
          public UserLicenseServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new UserLicenseServiceBlockingStub(channel, callOptions);
          }
        };
    return UserLicenseServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static UserLicenseServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserLicenseServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<UserLicenseServiceFutureStub>() {
          @java.lang.Override
          public UserLicenseServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new UserLicenseServiceFutureStub(channel, callOptions);
          }
        };
    return UserLicenseServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing User Licenses.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists the User Licenses.
     * </pre>
     */
    default void listUserLicenses(
        com.google.cloud.discoveryengine.v1.ListUserLicensesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.ListUserLicensesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListUserLicensesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the User License.
     * This method is used for batch assign/unassign licenses to users.
     * </pre>
     */
    default void batchUpdateUserLicenses(
        com.google.cloud.discoveryengine.v1.BatchUpdateUserLicensesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchUpdateUserLicensesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service UserLicenseService.
   *
   * <pre>
   * Service for managing User Licenses.
   * </pre>
   */
  public abstract static class UserLicenseServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return UserLicenseServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service UserLicenseService.
   *
   * <pre>
   * Service for managing User Licenses.
   * </pre>
   */
  public static final class UserLicenseServiceStub
      extends io.grpc.stub.AbstractAsyncStub<UserLicenseServiceStub> {
    private UserLicenseServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserLicenseServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserLicenseServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the User Licenses.
     * </pre>
     */
    public void listUserLicenses(
        com.google.cloud.discoveryengine.v1.ListUserLicensesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.ListUserLicensesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListUserLicensesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the User License.
     * This method is used for batch assign/unassign licenses to users.
     * </pre>
     */
    public void batchUpdateUserLicenses(
        com.google.cloud.discoveryengine.v1.BatchUpdateUserLicensesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchUpdateUserLicensesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service UserLicenseService.
   *
   * <pre>
   * Service for managing User Licenses.
   * </pre>
   */
  public static final class UserLicenseServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<UserLicenseServiceBlockingV2Stub> {
    private UserLicenseServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserLicenseServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserLicenseServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the User Licenses.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1.ListUserLicensesResponse listUserLicenses(
        com.google.cloud.discoveryengine.v1.ListUserLicensesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUserLicensesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the User License.
     * This method is used for batch assign/unassign licenses to users.
     * </pre>
     */
    public com.google.longrunning.Operation batchUpdateUserLicenses(
        com.google.cloud.discoveryengine.v1.BatchUpdateUserLicensesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchUpdateUserLicensesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service UserLicenseService.
   *
   * <pre>
   * Service for managing User Licenses.
   * </pre>
   */
  public static final class UserLicenseServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<UserLicenseServiceBlockingStub> {
    private UserLicenseServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserLicenseServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserLicenseServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the User Licenses.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1.ListUserLicensesResponse listUserLicenses(
        com.google.cloud.discoveryengine.v1.ListUserLicensesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUserLicensesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the User License.
     * This method is used for batch assign/unassign licenses to users.
     * </pre>
     */
    public com.google.longrunning.Operation batchUpdateUserLicenses(
        com.google.cloud.discoveryengine.v1.BatchUpdateUserLicensesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchUpdateUserLicensesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service UserLicenseService.
   *
   * <pre>
   * Service for managing User Licenses.
   * </pre>
   */
  public static final class UserLicenseServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<UserLicenseServiceFutureStub> {
    private UserLicenseServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserLicenseServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserLicenseServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the User Licenses.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1.ListUserLicensesResponse>
        listUserLicenses(com.google.cloud.discoveryengine.v1.ListUserLicensesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListUserLicensesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the User License.
     * This method is used for batch assign/unassign licenses to users.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchUpdateUserLicenses(
            com.google.cloud.discoveryengine.v1.BatchUpdateUserLicensesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchUpdateUserLicensesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_USER_LICENSES = 0;
  private static final int METHODID_BATCH_UPDATE_USER_LICENSES = 1;

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
        case METHODID_LIST_USER_LICENSES:
          serviceImpl.listUserLicenses(
              (com.google.cloud.discoveryengine.v1.ListUserLicensesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.discoveryengine.v1.ListUserLicensesResponse>)
                  responseObserver);
          break;
        case METHODID_BATCH_UPDATE_USER_LICENSES:
          serviceImpl.batchUpdateUserLicenses(
              (com.google.cloud.discoveryengine.v1.BatchUpdateUserLicensesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
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
            getListUserLicensesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1.ListUserLicensesRequest,
                    com.google.cloud.discoveryengine.v1.ListUserLicensesResponse>(
                    service, METHODID_LIST_USER_LICENSES)))
        .addMethod(
            getBatchUpdateUserLicensesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1.BatchUpdateUserLicensesRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_BATCH_UPDATE_USER_LICENSES)))
        .build();
  }

  private abstract static class UserLicenseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserLicenseServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1.UserLicenseServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserLicenseService");
    }
  }

  private static final class UserLicenseServiceFileDescriptorSupplier
      extends UserLicenseServiceBaseDescriptorSupplier {
    UserLicenseServiceFileDescriptorSupplier() {}
  }

  private static final class UserLicenseServiceMethodDescriptorSupplier
      extends UserLicenseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    UserLicenseServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (UserLicenseServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new UserLicenseServiceFileDescriptorSupplier())
                      .addMethod(getListUserLicensesMethod())
                      .addMethod(getBatchUpdateUserLicensesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
