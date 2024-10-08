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
package com.google.cloud.commerce.consumer.procurement.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing licenses.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments =
        "Source: google/cloud/commerce/consumer/procurement/v1/license_management_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LicenseManagementServiceGrpc {

  private LicenseManagementServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.commerce.consumer.procurement.v1.LicenseManagementService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.commerce.consumer.procurement.v1.GetLicensePoolRequest,
          com.google.cloud.commerce.consumer.procurement.v1.LicensePool>
      getGetLicensePoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLicensePool",
      requestType = com.google.cloud.commerce.consumer.procurement.v1.GetLicensePoolRequest.class,
      responseType = com.google.cloud.commerce.consumer.procurement.v1.LicensePool.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.commerce.consumer.procurement.v1.GetLicensePoolRequest,
          com.google.cloud.commerce.consumer.procurement.v1.LicensePool>
      getGetLicensePoolMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.commerce.consumer.procurement.v1.GetLicensePoolRequest,
            com.google.cloud.commerce.consumer.procurement.v1.LicensePool>
        getGetLicensePoolMethod;
    if ((getGetLicensePoolMethod = LicenseManagementServiceGrpc.getGetLicensePoolMethod) == null) {
      synchronized (LicenseManagementServiceGrpc.class) {
        if ((getGetLicensePoolMethod = LicenseManagementServiceGrpc.getGetLicensePoolMethod)
            == null) {
          LicenseManagementServiceGrpc.getGetLicensePoolMethod =
              getGetLicensePoolMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.commerce.consumer.procurement.v1.GetLicensePoolRequest,
                          com.google.cloud.commerce.consumer.procurement.v1.LicensePool>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLicensePool"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerce.consumer.procurement.v1
                                  .GetLicensePoolRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerce.consumer.procurement.v1.LicensePool
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LicenseManagementServiceMethodDescriptorSupplier("GetLicensePool"))
                      .build();
        }
      }
    }
    return getGetLicensePoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.commerce.consumer.procurement.v1.UpdateLicensePoolRequest,
          com.google.cloud.commerce.consumer.procurement.v1.LicensePool>
      getUpdateLicensePoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateLicensePool",
      requestType =
          com.google.cloud.commerce.consumer.procurement.v1.UpdateLicensePoolRequest.class,
      responseType = com.google.cloud.commerce.consumer.procurement.v1.LicensePool.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.commerce.consumer.procurement.v1.UpdateLicensePoolRequest,
          com.google.cloud.commerce.consumer.procurement.v1.LicensePool>
      getUpdateLicensePoolMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.commerce.consumer.procurement.v1.UpdateLicensePoolRequest,
            com.google.cloud.commerce.consumer.procurement.v1.LicensePool>
        getUpdateLicensePoolMethod;
    if ((getUpdateLicensePoolMethod = LicenseManagementServiceGrpc.getUpdateLicensePoolMethod)
        == null) {
      synchronized (LicenseManagementServiceGrpc.class) {
        if ((getUpdateLicensePoolMethod = LicenseManagementServiceGrpc.getUpdateLicensePoolMethod)
            == null) {
          LicenseManagementServiceGrpc.getUpdateLicensePoolMethod =
              getUpdateLicensePoolMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.commerce.consumer.procurement.v1.UpdateLicensePoolRequest,
                          com.google.cloud.commerce.consumer.procurement.v1.LicensePool>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateLicensePool"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerce.consumer.procurement.v1
                                  .UpdateLicensePoolRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerce.consumer.procurement.v1.LicensePool
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LicenseManagementServiceMethodDescriptorSupplier("UpdateLicensePool"))
                      .build();
        }
      }
    }
    return getUpdateLicensePoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.commerce.consumer.procurement.v1.AssignRequest,
          com.google.cloud.commerce.consumer.procurement.v1.AssignResponse>
      getAssignMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Assign",
      requestType = com.google.cloud.commerce.consumer.procurement.v1.AssignRequest.class,
      responseType = com.google.cloud.commerce.consumer.procurement.v1.AssignResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.commerce.consumer.procurement.v1.AssignRequest,
          com.google.cloud.commerce.consumer.procurement.v1.AssignResponse>
      getAssignMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.commerce.consumer.procurement.v1.AssignRequest,
            com.google.cloud.commerce.consumer.procurement.v1.AssignResponse>
        getAssignMethod;
    if ((getAssignMethod = LicenseManagementServiceGrpc.getAssignMethod) == null) {
      synchronized (LicenseManagementServiceGrpc.class) {
        if ((getAssignMethod = LicenseManagementServiceGrpc.getAssignMethod) == null) {
          LicenseManagementServiceGrpc.getAssignMethod =
              getAssignMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.commerce.consumer.procurement.v1.AssignRequest,
                          com.google.cloud.commerce.consumer.procurement.v1.AssignResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Assign"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerce.consumer.procurement.v1.AssignRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerce.consumer.procurement.v1.AssignResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LicenseManagementServiceMethodDescriptorSupplier("Assign"))
                      .build();
        }
      }
    }
    return getAssignMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.commerce.consumer.procurement.v1.UnassignRequest,
          com.google.cloud.commerce.consumer.procurement.v1.UnassignResponse>
      getUnassignMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Unassign",
      requestType = com.google.cloud.commerce.consumer.procurement.v1.UnassignRequest.class,
      responseType = com.google.cloud.commerce.consumer.procurement.v1.UnassignResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.commerce.consumer.procurement.v1.UnassignRequest,
          com.google.cloud.commerce.consumer.procurement.v1.UnassignResponse>
      getUnassignMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.commerce.consumer.procurement.v1.UnassignRequest,
            com.google.cloud.commerce.consumer.procurement.v1.UnassignResponse>
        getUnassignMethod;
    if ((getUnassignMethod = LicenseManagementServiceGrpc.getUnassignMethod) == null) {
      synchronized (LicenseManagementServiceGrpc.class) {
        if ((getUnassignMethod = LicenseManagementServiceGrpc.getUnassignMethod) == null) {
          LicenseManagementServiceGrpc.getUnassignMethod =
              getUnassignMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.commerce.consumer.procurement.v1.UnassignRequest,
                          com.google.cloud.commerce.consumer.procurement.v1.UnassignResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Unassign"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerce.consumer.procurement.v1.UnassignRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerce.consumer.procurement.v1.UnassignResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LicenseManagementServiceMethodDescriptorSupplier("Unassign"))
                      .build();
        }
      }
    }
    return getUnassignMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.commerce.consumer.procurement.v1.EnumerateLicensedUsersRequest,
          com.google.cloud.commerce.consumer.procurement.v1.EnumerateLicensedUsersResponse>
      getEnumerateLicensedUsersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EnumerateLicensedUsers",
      requestType =
          com.google.cloud.commerce.consumer.procurement.v1.EnumerateLicensedUsersRequest.class,
      responseType =
          com.google.cloud.commerce.consumer.procurement.v1.EnumerateLicensedUsersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.commerce.consumer.procurement.v1.EnumerateLicensedUsersRequest,
          com.google.cloud.commerce.consumer.procurement.v1.EnumerateLicensedUsersResponse>
      getEnumerateLicensedUsersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.commerce.consumer.procurement.v1.EnumerateLicensedUsersRequest,
            com.google.cloud.commerce.consumer.procurement.v1.EnumerateLicensedUsersResponse>
        getEnumerateLicensedUsersMethod;
    if ((getEnumerateLicensedUsersMethod =
            LicenseManagementServiceGrpc.getEnumerateLicensedUsersMethod)
        == null) {
      synchronized (LicenseManagementServiceGrpc.class) {
        if ((getEnumerateLicensedUsersMethod =
                LicenseManagementServiceGrpc.getEnumerateLicensedUsersMethod)
            == null) {
          LicenseManagementServiceGrpc.getEnumerateLicensedUsersMethod =
              getEnumerateLicensedUsersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.commerce.consumer.procurement.v1
                              .EnumerateLicensedUsersRequest,
                          com.google.cloud.commerce.consumer.procurement.v1
                              .EnumerateLicensedUsersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "EnumerateLicensedUsers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerce.consumer.procurement.v1
                                  .EnumerateLicensedUsersRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerce.consumer.procurement.v1
                                  .EnumerateLicensedUsersResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LicenseManagementServiceMethodDescriptorSupplier(
                              "EnumerateLicensedUsers"))
                      .build();
        }
      }
    }
    return getEnumerateLicensedUsersMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static LicenseManagementServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LicenseManagementServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LicenseManagementServiceStub>() {
          @java.lang.Override
          public LicenseManagementServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LicenseManagementServiceStub(channel, callOptions);
          }
        };
    return LicenseManagementServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LicenseManagementServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LicenseManagementServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LicenseManagementServiceBlockingStub>() {
          @java.lang.Override
          public LicenseManagementServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LicenseManagementServiceBlockingStub(channel, callOptions);
          }
        };
    return LicenseManagementServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static LicenseManagementServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LicenseManagementServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LicenseManagementServiceFutureStub>() {
          @java.lang.Override
          public LicenseManagementServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LicenseManagementServiceFutureStub(channel, callOptions);
          }
        };
    return LicenseManagementServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing licenses.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Gets the license pool.
     * </pre>
     */
    default void getLicensePool(
        com.google.cloud.commerce.consumer.procurement.v1.GetLicensePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerce.consumer.procurement.v1.LicensePool>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetLicensePoolMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the license pool if one exists for this Order.
     * </pre>
     */
    default void updateLicensePool(
        com.google.cloud.commerce.consumer.procurement.v1.UpdateLicensePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerce.consumer.procurement.v1.LicensePool>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateLicensePoolMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Assigns a license to a user.
     * </pre>
     */
    default void assign(
        com.google.cloud.commerce.consumer.procurement.v1.AssignRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.commerce.consumer.procurement.v1.AssignResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAssignMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Unassigns a license from a user.
     * </pre>
     */
    default void unassign(
        com.google.cloud.commerce.consumer.procurement.v1.UnassignRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.commerce.consumer.procurement.v1.UnassignResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUnassignMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Enumerates all users assigned a license.
     * </pre>
     */
    default void enumerateLicensedUsers(
        com.google.cloud.commerce.consumer.procurement.v1.EnumerateLicensedUsersRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.commerce.consumer.procurement.v1.EnumerateLicensedUsersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getEnumerateLicensedUsersMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service LicenseManagementService.
   *
   * <pre>
   * Service for managing licenses.
   * </pre>
   */
  public abstract static class LicenseManagementServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return LicenseManagementServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service LicenseManagementService.
   *
   * <pre>
   * Service for managing licenses.
   * </pre>
   */
  public static final class LicenseManagementServiceStub
      extends io.grpc.stub.AbstractAsyncStub<LicenseManagementServiceStub> {
    private LicenseManagementServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LicenseManagementServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LicenseManagementServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the license pool.
     * </pre>
     */
    public void getLicensePool(
        com.google.cloud.commerce.consumer.procurement.v1.GetLicensePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerce.consumer.procurement.v1.LicensePool>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLicensePoolMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the license pool if one exists for this Order.
     * </pre>
     */
    public void updateLicensePool(
        com.google.cloud.commerce.consumer.procurement.v1.UpdateLicensePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerce.consumer.procurement.v1.LicensePool>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateLicensePoolMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Assigns a license to a user.
     * </pre>
     */
    public void assign(
        com.google.cloud.commerce.consumer.procurement.v1.AssignRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.commerce.consumer.procurement.v1.AssignResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAssignMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Unassigns a license from a user.
     * </pre>
     */
    public void unassign(
        com.google.cloud.commerce.consumer.procurement.v1.UnassignRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.commerce.consumer.procurement.v1.UnassignResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUnassignMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Enumerates all users assigned a license.
     * </pre>
     */
    public void enumerateLicensedUsers(
        com.google.cloud.commerce.consumer.procurement.v1.EnumerateLicensedUsersRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.commerce.consumer.procurement.v1.EnumerateLicensedUsersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEnumerateLicensedUsersMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service LicenseManagementService.
   *
   * <pre>
   * Service for managing licenses.
   * </pre>
   */
  public static final class LicenseManagementServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LicenseManagementServiceBlockingStub> {
    private LicenseManagementServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LicenseManagementServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LicenseManagementServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the license pool.
     * </pre>
     */
    public com.google.cloud.commerce.consumer.procurement.v1.LicensePool getLicensePool(
        com.google.cloud.commerce.consumer.procurement.v1.GetLicensePoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLicensePoolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the license pool if one exists for this Order.
     * </pre>
     */
    public com.google.cloud.commerce.consumer.procurement.v1.LicensePool updateLicensePool(
        com.google.cloud.commerce.consumer.procurement.v1.UpdateLicensePoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateLicensePoolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Assigns a license to a user.
     * </pre>
     */
    public com.google.cloud.commerce.consumer.procurement.v1.AssignResponse assign(
        com.google.cloud.commerce.consumer.procurement.v1.AssignRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAssignMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Unassigns a license from a user.
     * </pre>
     */
    public com.google.cloud.commerce.consumer.procurement.v1.UnassignResponse unassign(
        com.google.cloud.commerce.consumer.procurement.v1.UnassignRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnassignMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Enumerates all users assigned a license.
     * </pre>
     */
    public com.google.cloud.commerce.consumer.procurement.v1.EnumerateLicensedUsersResponse
        enumerateLicensedUsers(
            com.google.cloud.commerce.consumer.procurement.v1.EnumerateLicensedUsersRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEnumerateLicensedUsersMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * LicenseManagementService.
   *
   * <pre>
   * Service for managing licenses.
   * </pre>
   */
  public static final class LicenseManagementServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<LicenseManagementServiceFutureStub> {
    private LicenseManagementServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LicenseManagementServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LicenseManagementServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the license pool.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.commerce.consumer.procurement.v1.LicensePool>
        getLicensePool(
            com.google.cloud.commerce.consumer.procurement.v1.GetLicensePoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLicensePoolMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the license pool if one exists for this Order.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.commerce.consumer.procurement.v1.LicensePool>
        updateLicensePool(
            com.google.cloud.commerce.consumer.procurement.v1.UpdateLicensePoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateLicensePoolMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Assigns a license to a user.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.commerce.consumer.procurement.v1.AssignResponse>
        assign(com.google.cloud.commerce.consumer.procurement.v1.AssignRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAssignMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Unassigns a license from a user.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.commerce.consumer.procurement.v1.UnassignResponse>
        unassign(com.google.cloud.commerce.consumer.procurement.v1.UnassignRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUnassignMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Enumerates all users assigned a license.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.commerce.consumer.procurement.v1.EnumerateLicensedUsersResponse>
        enumerateLicensedUsers(
            com.google.cloud.commerce.consumer.procurement.v1.EnumerateLicensedUsersRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEnumerateLicensedUsersMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_LICENSE_POOL = 0;
  private static final int METHODID_UPDATE_LICENSE_POOL = 1;
  private static final int METHODID_ASSIGN = 2;
  private static final int METHODID_UNASSIGN = 3;
  private static final int METHODID_ENUMERATE_LICENSED_USERS = 4;

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
        case METHODID_GET_LICENSE_POOL:
          serviceImpl.getLicensePool(
              (com.google.cloud.commerce.consumer.procurement.v1.GetLicensePoolRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.commerce.consumer.procurement.v1.LicensePool>)
                  responseObserver);
          break;
        case METHODID_UPDATE_LICENSE_POOL:
          serviceImpl.updateLicensePool(
              (com.google.cloud.commerce.consumer.procurement.v1.UpdateLicensePoolRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.commerce.consumer.procurement.v1.LicensePool>)
                  responseObserver);
          break;
        case METHODID_ASSIGN:
          serviceImpl.assign(
              (com.google.cloud.commerce.consumer.procurement.v1.AssignRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.commerce.consumer.procurement.v1.AssignResponse>)
                  responseObserver);
          break;
        case METHODID_UNASSIGN:
          serviceImpl.unassign(
              (com.google.cloud.commerce.consumer.procurement.v1.UnassignRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.commerce.consumer.procurement.v1.UnassignResponse>)
                  responseObserver);
          break;
        case METHODID_ENUMERATE_LICENSED_USERS:
          serviceImpl.enumerateLicensedUsers(
              (com.google.cloud.commerce.consumer.procurement.v1.EnumerateLicensedUsersRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.commerce.consumer.procurement.v1
                          .EnumerateLicensedUsersResponse>)
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
            getGetLicensePoolMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.commerce.consumer.procurement.v1.GetLicensePoolRequest,
                    com.google.cloud.commerce.consumer.procurement.v1.LicensePool>(
                    service, METHODID_GET_LICENSE_POOL)))
        .addMethod(
            getUpdateLicensePoolMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.commerce.consumer.procurement.v1.UpdateLicensePoolRequest,
                    com.google.cloud.commerce.consumer.procurement.v1.LicensePool>(
                    service, METHODID_UPDATE_LICENSE_POOL)))
        .addMethod(
            getAssignMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.commerce.consumer.procurement.v1.AssignRequest,
                    com.google.cloud.commerce.consumer.procurement.v1.AssignResponse>(
                    service, METHODID_ASSIGN)))
        .addMethod(
            getUnassignMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.commerce.consumer.procurement.v1.UnassignRequest,
                    com.google.cloud.commerce.consumer.procurement.v1.UnassignResponse>(
                    service, METHODID_UNASSIGN)))
        .addMethod(
            getEnumerateLicensedUsersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.commerce.consumer.procurement.v1.EnumerateLicensedUsersRequest,
                    com.google.cloud.commerce.consumer.procurement.v1
                        .EnumerateLicensedUsersResponse>(
                    service, METHODID_ENUMERATE_LICENSED_USERS)))
        .build();
  }

  private abstract static class LicenseManagementServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LicenseManagementServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.commerce.consumer.procurement.v1.LicenseManagementServiceProto
          .getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LicenseManagementService");
    }
  }

  private static final class LicenseManagementServiceFileDescriptorSupplier
      extends LicenseManagementServiceBaseDescriptorSupplier {
    LicenseManagementServiceFileDescriptorSupplier() {}
  }

  private static final class LicenseManagementServiceMethodDescriptorSupplier
      extends LicenseManagementServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    LicenseManagementServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (LicenseManagementServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new LicenseManagementServiceFileDescriptorSupplier())
                      .addMethod(getGetLicensePoolMethod())
                      .addMethod(getUpdateLicensePoolMethod())
                      .addMethod(getAssignMethod())
                      .addMethod(getUnassignMethod())
                      .addMethod(getEnumerateLicensedUsersMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
