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
package com.google.cloud.maintenance.api.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Unified Maintenance service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/maintenance/api/v1beta/maintenance_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MaintenanceGrpc {

  private MaintenanceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.maintenance.api.v1beta.Maintenance";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.maintenance.api.v1beta.SummarizeMaintenancesRequest,
          com.google.cloud.maintenance.api.v1beta.SummarizeMaintenancesResponse>
      getSummarizeMaintenancesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SummarizeMaintenances",
      requestType = com.google.cloud.maintenance.api.v1beta.SummarizeMaintenancesRequest.class,
      responseType = com.google.cloud.maintenance.api.v1beta.SummarizeMaintenancesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.maintenance.api.v1beta.SummarizeMaintenancesRequest,
          com.google.cloud.maintenance.api.v1beta.SummarizeMaintenancesResponse>
      getSummarizeMaintenancesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.maintenance.api.v1beta.SummarizeMaintenancesRequest,
            com.google.cloud.maintenance.api.v1beta.SummarizeMaintenancesResponse>
        getSummarizeMaintenancesMethod;
    if ((getSummarizeMaintenancesMethod = MaintenanceGrpc.getSummarizeMaintenancesMethod) == null) {
      synchronized (MaintenanceGrpc.class) {
        if ((getSummarizeMaintenancesMethod = MaintenanceGrpc.getSummarizeMaintenancesMethod)
            == null) {
          MaintenanceGrpc.getSummarizeMaintenancesMethod =
              getSummarizeMaintenancesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.maintenance.api.v1beta.SummarizeMaintenancesRequest,
                          com.google.cloud.maintenance.api.v1beta.SummarizeMaintenancesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SummarizeMaintenances"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.maintenance.api.v1beta.SummarizeMaintenancesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.maintenance.api.v1beta.SummarizeMaintenancesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MaintenanceMethodDescriptorSupplier("SummarizeMaintenances"))
                      .build();
        }
      }
    }
    return getSummarizeMaintenancesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.maintenance.api.v1beta.ListResourceMaintenancesRequest,
          com.google.cloud.maintenance.api.v1beta.ListResourceMaintenancesResponse>
      getListResourceMaintenancesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListResourceMaintenances",
      requestType = com.google.cloud.maintenance.api.v1beta.ListResourceMaintenancesRequest.class,
      responseType = com.google.cloud.maintenance.api.v1beta.ListResourceMaintenancesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.maintenance.api.v1beta.ListResourceMaintenancesRequest,
          com.google.cloud.maintenance.api.v1beta.ListResourceMaintenancesResponse>
      getListResourceMaintenancesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.maintenance.api.v1beta.ListResourceMaintenancesRequest,
            com.google.cloud.maintenance.api.v1beta.ListResourceMaintenancesResponse>
        getListResourceMaintenancesMethod;
    if ((getListResourceMaintenancesMethod = MaintenanceGrpc.getListResourceMaintenancesMethod)
        == null) {
      synchronized (MaintenanceGrpc.class) {
        if ((getListResourceMaintenancesMethod = MaintenanceGrpc.getListResourceMaintenancesMethod)
            == null) {
          MaintenanceGrpc.getListResourceMaintenancesMethod =
              getListResourceMaintenancesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.maintenance.api.v1beta.ListResourceMaintenancesRequest,
                          com.google.cloud.maintenance.api.v1beta.ListResourceMaintenancesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListResourceMaintenances"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.maintenance.api.v1beta
                                  .ListResourceMaintenancesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.maintenance.api.v1beta
                                  .ListResourceMaintenancesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MaintenanceMethodDescriptorSupplier("ListResourceMaintenances"))
                      .build();
        }
      }
    }
    return getListResourceMaintenancesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.maintenance.api.v1beta.GetResourceMaintenanceRequest,
          com.google.cloud.maintenance.api.v1beta.ResourceMaintenance>
      getGetResourceMaintenanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetResourceMaintenance",
      requestType = com.google.cloud.maintenance.api.v1beta.GetResourceMaintenanceRequest.class,
      responseType = com.google.cloud.maintenance.api.v1beta.ResourceMaintenance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.maintenance.api.v1beta.GetResourceMaintenanceRequest,
          com.google.cloud.maintenance.api.v1beta.ResourceMaintenance>
      getGetResourceMaintenanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.maintenance.api.v1beta.GetResourceMaintenanceRequest,
            com.google.cloud.maintenance.api.v1beta.ResourceMaintenance>
        getGetResourceMaintenanceMethod;
    if ((getGetResourceMaintenanceMethod = MaintenanceGrpc.getGetResourceMaintenanceMethod)
        == null) {
      synchronized (MaintenanceGrpc.class) {
        if ((getGetResourceMaintenanceMethod = MaintenanceGrpc.getGetResourceMaintenanceMethod)
            == null) {
          MaintenanceGrpc.getGetResourceMaintenanceMethod =
              getGetResourceMaintenanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.maintenance.api.v1beta.GetResourceMaintenanceRequest,
                          com.google.cloud.maintenance.api.v1beta.ResourceMaintenance>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetResourceMaintenance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.maintenance.api.v1beta.GetResourceMaintenanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.maintenance.api.v1beta.ResourceMaintenance
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MaintenanceMethodDescriptorSupplier("GetResourceMaintenance"))
                      .build();
        }
      }
    }
    return getGetResourceMaintenanceMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static MaintenanceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MaintenanceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MaintenanceStub>() {
          @java.lang.Override
          public MaintenanceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MaintenanceStub(channel, callOptions);
          }
        };
    return MaintenanceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static MaintenanceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MaintenanceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MaintenanceBlockingV2Stub>() {
          @java.lang.Override
          public MaintenanceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MaintenanceBlockingV2Stub(channel, callOptions);
          }
        };
    return MaintenanceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MaintenanceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MaintenanceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MaintenanceBlockingStub>() {
          @java.lang.Override
          public MaintenanceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MaintenanceBlockingStub(channel, callOptions);
          }
        };
    return MaintenanceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static MaintenanceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MaintenanceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MaintenanceFutureStub>() {
          @java.lang.Override
          public MaintenanceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MaintenanceFutureStub(channel, callOptions);
          }
        };
    return MaintenanceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Unified Maintenance service
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Retrieves the statistics of a specific maintenance.
     * </pre>
     */
    default void summarizeMaintenances(
        com.google.cloud.maintenance.api.v1beta.SummarizeMaintenancesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.maintenance.api.v1beta.SummarizeMaintenancesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSummarizeMaintenancesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of resource maintenances.
     * </pre>
     */
    default void listResourceMaintenances(
        com.google.cloud.maintenance.api.v1beta.ListResourceMaintenancesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.maintenance.api.v1beta.ListResourceMaintenancesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListResourceMaintenancesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single resource maintenance.
     * </pre>
     */
    default void getResourceMaintenance(
        com.google.cloud.maintenance.api.v1beta.GetResourceMaintenanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.maintenance.api.v1beta.ResourceMaintenance>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetResourceMaintenanceMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Maintenance.
   *
   * <pre>
   * Unified Maintenance service
   * </pre>
   */
  public abstract static class MaintenanceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return MaintenanceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Maintenance.
   *
   * <pre>
   * Unified Maintenance service
   * </pre>
   */
  public static final class MaintenanceStub
      extends io.grpc.stub.AbstractAsyncStub<MaintenanceStub> {
    private MaintenanceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MaintenanceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MaintenanceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the statistics of a specific maintenance.
     * </pre>
     */
    public void summarizeMaintenances(
        com.google.cloud.maintenance.api.v1beta.SummarizeMaintenancesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.maintenance.api.v1beta.SummarizeMaintenancesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSummarizeMaintenancesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of resource maintenances.
     * </pre>
     */
    public void listResourceMaintenances(
        com.google.cloud.maintenance.api.v1beta.ListResourceMaintenancesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.maintenance.api.v1beta.ListResourceMaintenancesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListResourceMaintenancesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single resource maintenance.
     * </pre>
     */
    public void getResourceMaintenance(
        com.google.cloud.maintenance.api.v1beta.GetResourceMaintenanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.maintenance.api.v1beta.ResourceMaintenance>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetResourceMaintenanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Maintenance.
   *
   * <pre>
   * Unified Maintenance service
   * </pre>
   */
  public static final class MaintenanceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<MaintenanceBlockingV2Stub> {
    private MaintenanceBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MaintenanceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MaintenanceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the statistics of a specific maintenance.
     * </pre>
     */
    public com.google.cloud.maintenance.api.v1beta.SummarizeMaintenancesResponse
        summarizeMaintenances(
            com.google.cloud.maintenance.api.v1beta.SummarizeMaintenancesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSummarizeMaintenancesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of resource maintenances.
     * </pre>
     */
    public com.google.cloud.maintenance.api.v1beta.ListResourceMaintenancesResponse
        listResourceMaintenances(
            com.google.cloud.maintenance.api.v1beta.ListResourceMaintenancesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListResourceMaintenancesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single resource maintenance.
     * </pre>
     */
    public com.google.cloud.maintenance.api.v1beta.ResourceMaintenance getResourceMaintenance(
        com.google.cloud.maintenance.api.v1beta.GetResourceMaintenanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetResourceMaintenanceMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Maintenance.
   *
   * <pre>
   * Unified Maintenance service
   * </pre>
   */
  public static final class MaintenanceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MaintenanceBlockingStub> {
    private MaintenanceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MaintenanceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MaintenanceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the statistics of a specific maintenance.
     * </pre>
     */
    public com.google.cloud.maintenance.api.v1beta.SummarizeMaintenancesResponse
        summarizeMaintenances(
            com.google.cloud.maintenance.api.v1beta.SummarizeMaintenancesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSummarizeMaintenancesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of resource maintenances.
     * </pre>
     */
    public com.google.cloud.maintenance.api.v1beta.ListResourceMaintenancesResponse
        listResourceMaintenances(
            com.google.cloud.maintenance.api.v1beta.ListResourceMaintenancesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListResourceMaintenancesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single resource maintenance.
     * </pre>
     */
    public com.google.cloud.maintenance.api.v1beta.ResourceMaintenance getResourceMaintenance(
        com.google.cloud.maintenance.api.v1beta.GetResourceMaintenanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetResourceMaintenanceMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Maintenance.
   *
   * <pre>
   * Unified Maintenance service
   * </pre>
   */
  public static final class MaintenanceFutureStub
      extends io.grpc.stub.AbstractFutureStub<MaintenanceFutureStub> {
    private MaintenanceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MaintenanceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MaintenanceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the statistics of a specific maintenance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.maintenance.api.v1beta.SummarizeMaintenancesResponse>
        summarizeMaintenances(
            com.google.cloud.maintenance.api.v1beta.SummarizeMaintenancesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSummarizeMaintenancesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of resource maintenances.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.maintenance.api.v1beta.ListResourceMaintenancesResponse>
        listResourceMaintenances(
            com.google.cloud.maintenance.api.v1beta.ListResourceMaintenancesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListResourceMaintenancesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single resource maintenance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.maintenance.api.v1beta.ResourceMaintenance>
        getResourceMaintenance(
            com.google.cloud.maintenance.api.v1beta.GetResourceMaintenanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetResourceMaintenanceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SUMMARIZE_MAINTENANCES = 0;
  private static final int METHODID_LIST_RESOURCE_MAINTENANCES = 1;
  private static final int METHODID_GET_RESOURCE_MAINTENANCE = 2;

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
        case METHODID_SUMMARIZE_MAINTENANCES:
          serviceImpl.summarizeMaintenances(
              (com.google.cloud.maintenance.api.v1beta.SummarizeMaintenancesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.maintenance.api.v1beta.SummarizeMaintenancesResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_RESOURCE_MAINTENANCES:
          serviceImpl.listResourceMaintenances(
              (com.google.cloud.maintenance.api.v1beta.ListResourceMaintenancesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.maintenance.api.v1beta.ListResourceMaintenancesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_RESOURCE_MAINTENANCE:
          serviceImpl.getResourceMaintenance(
              (com.google.cloud.maintenance.api.v1beta.GetResourceMaintenanceRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.maintenance.api.v1beta.ResourceMaintenance>)
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
            getSummarizeMaintenancesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.maintenance.api.v1beta.SummarizeMaintenancesRequest,
                    com.google.cloud.maintenance.api.v1beta.SummarizeMaintenancesResponse>(
                    service, METHODID_SUMMARIZE_MAINTENANCES)))
        .addMethod(
            getListResourceMaintenancesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.maintenance.api.v1beta.ListResourceMaintenancesRequest,
                    com.google.cloud.maintenance.api.v1beta.ListResourceMaintenancesResponse>(
                    service, METHODID_LIST_RESOURCE_MAINTENANCES)))
        .addMethod(
            getGetResourceMaintenanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.maintenance.api.v1beta.GetResourceMaintenanceRequest,
                    com.google.cloud.maintenance.api.v1beta.ResourceMaintenance>(
                    service, METHODID_GET_RESOURCE_MAINTENANCE)))
        .build();
  }

  private abstract static class MaintenanceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MaintenanceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.maintenance.api.v1beta.UMMServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Maintenance");
    }
  }

  private static final class MaintenanceFileDescriptorSupplier
      extends MaintenanceBaseDescriptorSupplier {
    MaintenanceFileDescriptorSupplier() {}
  }

  private static final class MaintenanceMethodDescriptorSupplier
      extends MaintenanceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MaintenanceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (MaintenanceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new MaintenanceFileDescriptorSupplier())
                      .addMethod(getSummarizeMaintenancesMethod())
                      .addMethod(getListResourceMaintenancesMethod())
                      .addMethod(getGetResourceMaintenanceMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
