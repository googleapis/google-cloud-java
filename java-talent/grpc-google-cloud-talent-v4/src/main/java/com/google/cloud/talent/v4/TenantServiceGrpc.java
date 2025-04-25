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
package com.google.cloud.talent.v4;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * A service that handles tenant management, including CRUD and enumeration.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/talent/v4/tenant_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TenantServiceGrpc {

  private TenantServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.talent.v4.TenantService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4.CreateTenantRequest, com.google.cloud.talent.v4.Tenant>
      getCreateTenantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTenant",
      requestType = com.google.cloud.talent.v4.CreateTenantRequest.class,
      responseType = com.google.cloud.talent.v4.Tenant.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4.CreateTenantRequest, com.google.cloud.talent.v4.Tenant>
      getCreateTenantMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4.CreateTenantRequest, com.google.cloud.talent.v4.Tenant>
        getCreateTenantMethod;
    if ((getCreateTenantMethod = TenantServiceGrpc.getCreateTenantMethod) == null) {
      synchronized (TenantServiceGrpc.class) {
        if ((getCreateTenantMethod = TenantServiceGrpc.getCreateTenantMethod) == null) {
          TenantServiceGrpc.getCreateTenantMethod =
              getCreateTenantMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4.CreateTenantRequest,
                          com.google.cloud.talent.v4.Tenant>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTenant"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4.CreateTenantRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4.Tenant.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TenantServiceMethodDescriptorSupplier("CreateTenant"))
                      .build();
        }
      }
    }
    return getCreateTenantMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4.GetTenantRequest, com.google.cloud.talent.v4.Tenant>
      getGetTenantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTenant",
      requestType = com.google.cloud.talent.v4.GetTenantRequest.class,
      responseType = com.google.cloud.talent.v4.Tenant.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4.GetTenantRequest, com.google.cloud.talent.v4.Tenant>
      getGetTenantMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4.GetTenantRequest, com.google.cloud.talent.v4.Tenant>
        getGetTenantMethod;
    if ((getGetTenantMethod = TenantServiceGrpc.getGetTenantMethod) == null) {
      synchronized (TenantServiceGrpc.class) {
        if ((getGetTenantMethod = TenantServiceGrpc.getGetTenantMethod) == null) {
          TenantServiceGrpc.getGetTenantMethod =
              getGetTenantMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4.GetTenantRequest,
                          com.google.cloud.talent.v4.Tenant>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTenant"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4.GetTenantRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4.Tenant.getDefaultInstance()))
                      .setSchemaDescriptor(new TenantServiceMethodDescriptorSupplier("GetTenant"))
                      .build();
        }
      }
    }
    return getGetTenantMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4.UpdateTenantRequest, com.google.cloud.talent.v4.Tenant>
      getUpdateTenantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTenant",
      requestType = com.google.cloud.talent.v4.UpdateTenantRequest.class,
      responseType = com.google.cloud.talent.v4.Tenant.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4.UpdateTenantRequest, com.google.cloud.talent.v4.Tenant>
      getUpdateTenantMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4.UpdateTenantRequest, com.google.cloud.talent.v4.Tenant>
        getUpdateTenantMethod;
    if ((getUpdateTenantMethod = TenantServiceGrpc.getUpdateTenantMethod) == null) {
      synchronized (TenantServiceGrpc.class) {
        if ((getUpdateTenantMethod = TenantServiceGrpc.getUpdateTenantMethod) == null) {
          TenantServiceGrpc.getUpdateTenantMethod =
              getUpdateTenantMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4.UpdateTenantRequest,
                          com.google.cloud.talent.v4.Tenant>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTenant"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4.UpdateTenantRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4.Tenant.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TenantServiceMethodDescriptorSupplier("UpdateTenant"))
                      .build();
        }
      }
    }
    return getUpdateTenantMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4.DeleteTenantRequest, com.google.protobuf.Empty>
      getDeleteTenantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTenant",
      requestType = com.google.cloud.talent.v4.DeleteTenantRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4.DeleteTenantRequest, com.google.protobuf.Empty>
      getDeleteTenantMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4.DeleteTenantRequest, com.google.protobuf.Empty>
        getDeleteTenantMethod;
    if ((getDeleteTenantMethod = TenantServiceGrpc.getDeleteTenantMethod) == null) {
      synchronized (TenantServiceGrpc.class) {
        if ((getDeleteTenantMethod = TenantServiceGrpc.getDeleteTenantMethod) == null) {
          TenantServiceGrpc.getDeleteTenantMethod =
              getDeleteTenantMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4.DeleteTenantRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTenant"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4.DeleteTenantRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TenantServiceMethodDescriptorSupplier("DeleteTenant"))
                      .build();
        }
      }
    }
    return getDeleteTenantMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4.ListTenantsRequest,
          com.google.cloud.talent.v4.ListTenantsResponse>
      getListTenantsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTenants",
      requestType = com.google.cloud.talent.v4.ListTenantsRequest.class,
      responseType = com.google.cloud.talent.v4.ListTenantsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4.ListTenantsRequest,
          com.google.cloud.talent.v4.ListTenantsResponse>
      getListTenantsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4.ListTenantsRequest,
            com.google.cloud.talent.v4.ListTenantsResponse>
        getListTenantsMethod;
    if ((getListTenantsMethod = TenantServiceGrpc.getListTenantsMethod) == null) {
      synchronized (TenantServiceGrpc.class) {
        if ((getListTenantsMethod = TenantServiceGrpc.getListTenantsMethod) == null) {
          TenantServiceGrpc.getListTenantsMethod =
              getListTenantsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4.ListTenantsRequest,
                          com.google.cloud.talent.v4.ListTenantsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTenants"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4.ListTenantsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4.ListTenantsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new TenantServiceMethodDescriptorSupplier("ListTenants"))
                      .build();
        }
      }
    }
    return getListTenantsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static TenantServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TenantServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TenantServiceStub>() {
          @java.lang.Override
          public TenantServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TenantServiceStub(channel, callOptions);
          }
        };
    return TenantServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TenantServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TenantServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TenantServiceBlockingStub>() {
          @java.lang.Override
          public TenantServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TenantServiceBlockingStub(channel, callOptions);
          }
        };
    return TenantServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static TenantServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TenantServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TenantServiceFutureStub>() {
          @java.lang.Override
          public TenantServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TenantServiceFutureStub(channel, callOptions);
          }
        };
    return TenantServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * A service that handles tenant management, including CRUD and enumeration.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a new tenant entity.
     * </pre>
     */
    default void createTenant(
        com.google.cloud.talent.v4.CreateTenantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4.Tenant> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateTenantMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves specified tenant.
     * </pre>
     */
    default void getTenant(
        com.google.cloud.talent.v4.GetTenantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4.Tenant> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTenantMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates specified tenant.
     * </pre>
     */
    default void updateTenant(
        com.google.cloud.talent.v4.UpdateTenantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4.Tenant> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateTenantMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes specified tenant.
     * </pre>
     */
    default void deleteTenant(
        com.google.cloud.talent.v4.DeleteTenantRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteTenantMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all tenants associated with the project.
     * </pre>
     */
    default void listTenants(
        com.google.cloud.talent.v4.ListTenantsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4.ListTenantsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListTenantsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service TenantService.
   *
   * <pre>
   * A service that handles tenant management, including CRUD and enumeration.
   * </pre>
   */
  public abstract static class TenantServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return TenantServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service TenantService.
   *
   * <pre>
   * A service that handles tenant management, including CRUD and enumeration.
   * </pre>
   */
  public static final class TenantServiceStub
      extends io.grpc.stub.AbstractAsyncStub<TenantServiceStub> {
    private TenantServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TenantServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TenantServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new tenant entity.
     * </pre>
     */
    public void createTenant(
        com.google.cloud.talent.v4.CreateTenantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4.Tenant> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTenantMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves specified tenant.
     * </pre>
     */
    public void getTenant(
        com.google.cloud.talent.v4.GetTenantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4.Tenant> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTenantMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates specified tenant.
     * </pre>
     */
    public void updateTenant(
        com.google.cloud.talent.v4.UpdateTenantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4.Tenant> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTenantMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes specified tenant.
     * </pre>
     */
    public void deleteTenant(
        com.google.cloud.talent.v4.DeleteTenantRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTenantMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all tenants associated with the project.
     * </pre>
     */
    public void listTenants(
        com.google.cloud.talent.v4.ListTenantsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4.ListTenantsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTenantsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service TenantService.
   *
   * <pre>
   * A service that handles tenant management, including CRUD and enumeration.
   * </pre>
   */
  public static final class TenantServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TenantServiceBlockingStub> {
    private TenantServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TenantServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TenantServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new tenant entity.
     * </pre>
     */
    public com.google.cloud.talent.v4.Tenant createTenant(
        com.google.cloud.talent.v4.CreateTenantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTenantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves specified tenant.
     * </pre>
     */
    public com.google.cloud.talent.v4.Tenant getTenant(
        com.google.cloud.talent.v4.GetTenantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTenantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates specified tenant.
     * </pre>
     */
    public com.google.cloud.talent.v4.Tenant updateTenant(
        com.google.cloud.talent.v4.UpdateTenantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTenantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes specified tenant.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTenant(
        com.google.cloud.talent.v4.DeleteTenantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTenantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all tenants associated with the project.
     * </pre>
     */
    public com.google.cloud.talent.v4.ListTenantsResponse listTenants(
        com.google.cloud.talent.v4.ListTenantsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTenantsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service TenantService.
   *
   * <pre>
   * A service that handles tenant management, including CRUD and enumeration.
   * </pre>
   */
  public static final class TenantServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<TenantServiceFutureStub> {
    private TenantServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TenantServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TenantServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new tenant entity.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.talent.v4.Tenant>
        createTenant(com.google.cloud.talent.v4.CreateTenantRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTenantMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves specified tenant.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.talent.v4.Tenant>
        getTenant(com.google.cloud.talent.v4.GetTenantRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTenantMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates specified tenant.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.talent.v4.Tenant>
        updateTenant(com.google.cloud.talent.v4.UpdateTenantRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTenantMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes specified tenant.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteTenant(com.google.cloud.talent.v4.DeleteTenantRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTenantMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all tenants associated with the project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.talent.v4.ListTenantsResponse>
        listTenants(com.google.cloud.talent.v4.ListTenantsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTenantsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_TENANT = 0;
  private static final int METHODID_GET_TENANT = 1;
  private static final int METHODID_UPDATE_TENANT = 2;
  private static final int METHODID_DELETE_TENANT = 3;
  private static final int METHODID_LIST_TENANTS = 4;

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
        case METHODID_CREATE_TENANT:
          serviceImpl.createTenant(
              (com.google.cloud.talent.v4.CreateTenantRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.talent.v4.Tenant>) responseObserver);
          break;
        case METHODID_GET_TENANT:
          serviceImpl.getTenant(
              (com.google.cloud.talent.v4.GetTenantRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.talent.v4.Tenant>) responseObserver);
          break;
        case METHODID_UPDATE_TENANT:
          serviceImpl.updateTenant(
              (com.google.cloud.talent.v4.UpdateTenantRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.talent.v4.Tenant>) responseObserver);
          break;
        case METHODID_DELETE_TENANT:
          serviceImpl.deleteTenant(
              (com.google.cloud.talent.v4.DeleteTenantRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_TENANTS:
          serviceImpl.listTenants(
              (com.google.cloud.talent.v4.ListTenantsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.talent.v4.ListTenantsResponse>)
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
            getCreateTenantMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.talent.v4.CreateTenantRequest,
                    com.google.cloud.talent.v4.Tenant>(service, METHODID_CREATE_TENANT)))
        .addMethod(
            getGetTenantMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.talent.v4.GetTenantRequest, com.google.cloud.talent.v4.Tenant>(
                    service, METHODID_GET_TENANT)))
        .addMethod(
            getUpdateTenantMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.talent.v4.UpdateTenantRequest,
                    com.google.cloud.talent.v4.Tenant>(service, METHODID_UPDATE_TENANT)))
        .addMethod(
            getDeleteTenantMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.talent.v4.DeleteTenantRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_TENANT)))
        .addMethod(
            getListTenantsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.talent.v4.ListTenantsRequest,
                    com.google.cloud.talent.v4.ListTenantsResponse>(
                    service, METHODID_LIST_TENANTS)))
        .build();
  }

  private abstract static class TenantServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TenantServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.talent.v4.TenantServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TenantService");
    }
  }

  private static final class TenantServiceFileDescriptorSupplier
      extends TenantServiceBaseDescriptorSupplier {
    TenantServiceFileDescriptorSupplier() {}
  }

  private static final class TenantServiceMethodDescriptorSupplier
      extends TenantServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    TenantServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (TenantServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new TenantServiceFileDescriptorSupplier())
                      .addMethod(getCreateTenantMethod())
                      .addMethod(getGetTenantMethod())
                      .addMethod(getUpdateTenantMethod())
                      .addMethod(getDeleteTenantMethod())
                      .addMethod(getListTenantsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
