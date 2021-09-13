/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.osconfig.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Zonal OS Config API
 * The OS Config service is the server-side component that allows users to
 * manage package installations and patch jobs for Compute Engine VM instances.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/osconfig/v1/osconfig_zonal_service.proto")
public final class OsConfigZonalServiceGrpc {

  private OsConfigZonalServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.osconfig.v1.OsConfigZonalService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1.GetInventoryRequest, com.google.cloud.osconfig.v1.Inventory>
      getGetInventoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInventory",
      requestType = com.google.cloud.osconfig.v1.GetInventoryRequest.class,
      responseType = com.google.cloud.osconfig.v1.Inventory.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1.GetInventoryRequest, com.google.cloud.osconfig.v1.Inventory>
      getGetInventoryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.osconfig.v1.GetInventoryRequest,
            com.google.cloud.osconfig.v1.Inventory>
        getGetInventoryMethod;
    if ((getGetInventoryMethod = OsConfigZonalServiceGrpc.getGetInventoryMethod) == null) {
      synchronized (OsConfigZonalServiceGrpc.class) {
        if ((getGetInventoryMethod = OsConfigZonalServiceGrpc.getGetInventoryMethod) == null) {
          OsConfigZonalServiceGrpc.getGetInventoryMethod =
              getGetInventoryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.osconfig.v1.GetInventoryRequest,
                          com.google.cloud.osconfig.v1.Inventory>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInventory"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.osconfig.v1.GetInventoryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.osconfig.v1.Inventory.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OsConfigZonalServiceMethodDescriptorSupplier("GetInventory"))
                      .build();
        }
      }
    }
    return getGetInventoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1.ListInventoriesRequest,
          com.google.cloud.osconfig.v1.ListInventoriesResponse>
      getListInventoriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInventories",
      requestType = com.google.cloud.osconfig.v1.ListInventoriesRequest.class,
      responseType = com.google.cloud.osconfig.v1.ListInventoriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1.ListInventoriesRequest,
          com.google.cloud.osconfig.v1.ListInventoriesResponse>
      getListInventoriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.osconfig.v1.ListInventoriesRequest,
            com.google.cloud.osconfig.v1.ListInventoriesResponse>
        getListInventoriesMethod;
    if ((getListInventoriesMethod = OsConfigZonalServiceGrpc.getListInventoriesMethod) == null) {
      synchronized (OsConfigZonalServiceGrpc.class) {
        if ((getListInventoriesMethod = OsConfigZonalServiceGrpc.getListInventoriesMethod)
            == null) {
          OsConfigZonalServiceGrpc.getListInventoriesMethod =
              getListInventoriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.osconfig.v1.ListInventoriesRequest,
                          com.google.cloud.osconfig.v1.ListInventoriesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListInventories"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.osconfig.v1.ListInventoriesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.osconfig.v1.ListInventoriesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OsConfigZonalServiceMethodDescriptorSupplier("ListInventories"))
                      .build();
        }
      }
    }
    return getListInventoriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1.GetVulnerabilityReportRequest,
          com.google.cloud.osconfig.v1.VulnerabilityReport>
      getGetVulnerabilityReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetVulnerabilityReport",
      requestType = com.google.cloud.osconfig.v1.GetVulnerabilityReportRequest.class,
      responseType = com.google.cloud.osconfig.v1.VulnerabilityReport.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1.GetVulnerabilityReportRequest,
          com.google.cloud.osconfig.v1.VulnerabilityReport>
      getGetVulnerabilityReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.osconfig.v1.GetVulnerabilityReportRequest,
            com.google.cloud.osconfig.v1.VulnerabilityReport>
        getGetVulnerabilityReportMethod;
    if ((getGetVulnerabilityReportMethod = OsConfigZonalServiceGrpc.getGetVulnerabilityReportMethod)
        == null) {
      synchronized (OsConfigZonalServiceGrpc.class) {
        if ((getGetVulnerabilityReportMethod =
                OsConfigZonalServiceGrpc.getGetVulnerabilityReportMethod)
            == null) {
          OsConfigZonalServiceGrpc.getGetVulnerabilityReportMethod =
              getGetVulnerabilityReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.osconfig.v1.GetVulnerabilityReportRequest,
                          com.google.cloud.osconfig.v1.VulnerabilityReport>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetVulnerabilityReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.osconfig.v1.GetVulnerabilityReportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.osconfig.v1.VulnerabilityReport
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OsConfigZonalServiceMethodDescriptorSupplier(
                              "GetVulnerabilityReport"))
                      .build();
        }
      }
    }
    return getGetVulnerabilityReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1.ListVulnerabilityReportsRequest,
          com.google.cloud.osconfig.v1.ListVulnerabilityReportsResponse>
      getListVulnerabilityReportsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListVulnerabilityReports",
      requestType = com.google.cloud.osconfig.v1.ListVulnerabilityReportsRequest.class,
      responseType = com.google.cloud.osconfig.v1.ListVulnerabilityReportsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1.ListVulnerabilityReportsRequest,
          com.google.cloud.osconfig.v1.ListVulnerabilityReportsResponse>
      getListVulnerabilityReportsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.osconfig.v1.ListVulnerabilityReportsRequest,
            com.google.cloud.osconfig.v1.ListVulnerabilityReportsResponse>
        getListVulnerabilityReportsMethod;
    if ((getListVulnerabilityReportsMethod =
            OsConfigZonalServiceGrpc.getListVulnerabilityReportsMethod)
        == null) {
      synchronized (OsConfigZonalServiceGrpc.class) {
        if ((getListVulnerabilityReportsMethod =
                OsConfigZonalServiceGrpc.getListVulnerabilityReportsMethod)
            == null) {
          OsConfigZonalServiceGrpc.getListVulnerabilityReportsMethod =
              getListVulnerabilityReportsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.osconfig.v1.ListVulnerabilityReportsRequest,
                          com.google.cloud.osconfig.v1.ListVulnerabilityReportsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListVulnerabilityReports"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.osconfig.v1.ListVulnerabilityReportsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.osconfig.v1.ListVulnerabilityReportsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OsConfigZonalServiceMethodDescriptorSupplier(
                              "ListVulnerabilityReports"))
                      .build();
        }
      }
    }
    return getListVulnerabilityReportsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static OsConfigZonalServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OsConfigZonalServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OsConfigZonalServiceStub>() {
          @java.lang.Override
          public OsConfigZonalServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OsConfigZonalServiceStub(channel, callOptions);
          }
        };
    return OsConfigZonalServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OsConfigZonalServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OsConfigZonalServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OsConfigZonalServiceBlockingStub>() {
          @java.lang.Override
          public OsConfigZonalServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OsConfigZonalServiceBlockingStub(channel, callOptions);
          }
        };
    return OsConfigZonalServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static OsConfigZonalServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OsConfigZonalServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OsConfigZonalServiceFutureStub>() {
          @java.lang.Override
          public OsConfigZonalServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OsConfigZonalServiceFutureStub(channel, callOptions);
          }
        };
    return OsConfigZonalServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Zonal OS Config API
   * The OS Config service is the server-side component that allows users to
   * manage package installations and patch jobs for Compute Engine VM instances.
   * </pre>
   */
  public abstract static class OsConfigZonalServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Get inventory data for the specified VM instance. If the VM has no
     * associated inventory, the message `NOT_FOUND` is returned.
     * </pre>
     */
    public void getInventory(
        com.google.cloud.osconfig.v1.GetInventoryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1.Inventory> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetInventoryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List inventory data for all VM instances in the specified zone.
     * </pre>
     */
    public void listInventories(
        com.google.cloud.osconfig.v1.ListInventoriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1.ListInventoriesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListInventoriesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the vulnerability report for the specified VM instance. Only VMs with
     * inventory data have vulnerability reports associated with them.
     * </pre>
     */
    public void getVulnerabilityReport(
        com.google.cloud.osconfig.v1.GetVulnerabilityReportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1.VulnerabilityReport>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetVulnerabilityReportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List vulnerability reports for all VM instances in the specified zone.
     * </pre>
     */
    public void listVulnerabilityReports(
        com.google.cloud.osconfig.v1.ListVulnerabilityReportsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1.ListVulnerabilityReportsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListVulnerabilityReportsMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getGetInventoryMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.osconfig.v1.GetInventoryRequest,
                      com.google.cloud.osconfig.v1.Inventory>(this, METHODID_GET_INVENTORY)))
          .addMethod(
              getListInventoriesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.osconfig.v1.ListInventoriesRequest,
                      com.google.cloud.osconfig.v1.ListInventoriesResponse>(
                      this, METHODID_LIST_INVENTORIES)))
          .addMethod(
              getGetVulnerabilityReportMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.osconfig.v1.GetVulnerabilityReportRequest,
                      com.google.cloud.osconfig.v1.VulnerabilityReport>(
                      this, METHODID_GET_VULNERABILITY_REPORT)))
          .addMethod(
              getListVulnerabilityReportsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.osconfig.v1.ListVulnerabilityReportsRequest,
                      com.google.cloud.osconfig.v1.ListVulnerabilityReportsResponse>(
                      this, METHODID_LIST_VULNERABILITY_REPORTS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Zonal OS Config API
   * The OS Config service is the server-side component that allows users to
   * manage package installations and patch jobs for Compute Engine VM instances.
   * </pre>
   */
  public static final class OsConfigZonalServiceStub
      extends io.grpc.stub.AbstractAsyncStub<OsConfigZonalServiceStub> {
    private OsConfigZonalServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OsConfigZonalServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OsConfigZonalServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get inventory data for the specified VM instance. If the VM has no
     * associated inventory, the message `NOT_FOUND` is returned.
     * </pre>
     */
    public void getInventory(
        com.google.cloud.osconfig.v1.GetInventoryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1.Inventory> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInventoryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List inventory data for all VM instances in the specified zone.
     * </pre>
     */
    public void listInventories(
        com.google.cloud.osconfig.v1.ListInventoriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1.ListInventoriesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListInventoriesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the vulnerability report for the specified VM instance. Only VMs with
     * inventory data have vulnerability reports associated with them.
     * </pre>
     */
    public void getVulnerabilityReport(
        com.google.cloud.osconfig.v1.GetVulnerabilityReportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1.VulnerabilityReport>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetVulnerabilityReportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List vulnerability reports for all VM instances in the specified zone.
     * </pre>
     */
    public void listVulnerabilityReports(
        com.google.cloud.osconfig.v1.ListVulnerabilityReportsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1.ListVulnerabilityReportsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListVulnerabilityReportsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Zonal OS Config API
   * The OS Config service is the server-side component that allows users to
   * manage package installations and patch jobs for Compute Engine VM instances.
   * </pre>
   */
  public static final class OsConfigZonalServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<OsConfigZonalServiceBlockingStub> {
    private OsConfigZonalServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OsConfigZonalServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OsConfigZonalServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get inventory data for the specified VM instance. If the VM has no
     * associated inventory, the message `NOT_FOUND` is returned.
     * </pre>
     */
    public com.google.cloud.osconfig.v1.Inventory getInventory(
        com.google.cloud.osconfig.v1.GetInventoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInventoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List inventory data for all VM instances in the specified zone.
     * </pre>
     */
    public com.google.cloud.osconfig.v1.ListInventoriesResponse listInventories(
        com.google.cloud.osconfig.v1.ListInventoriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInventoriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the vulnerability report for the specified VM instance. Only VMs with
     * inventory data have vulnerability reports associated with them.
     * </pre>
     */
    public com.google.cloud.osconfig.v1.VulnerabilityReport getVulnerabilityReport(
        com.google.cloud.osconfig.v1.GetVulnerabilityReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetVulnerabilityReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List vulnerability reports for all VM instances in the specified zone.
     * </pre>
     */
    public com.google.cloud.osconfig.v1.ListVulnerabilityReportsResponse listVulnerabilityReports(
        com.google.cloud.osconfig.v1.ListVulnerabilityReportsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListVulnerabilityReportsMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Zonal OS Config API
   * The OS Config service is the server-side component that allows users to
   * manage package installations and patch jobs for Compute Engine VM instances.
   * </pre>
   */
  public static final class OsConfigZonalServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<OsConfigZonalServiceFutureStub> {
    private OsConfigZonalServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OsConfigZonalServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OsConfigZonalServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get inventory data for the specified VM instance. If the VM has no
     * associated inventory, the message `NOT_FOUND` is returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.osconfig.v1.Inventory>
        getInventory(com.google.cloud.osconfig.v1.GetInventoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInventoryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List inventory data for all VM instances in the specified zone.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.osconfig.v1.ListInventoriesResponse>
        listInventories(com.google.cloud.osconfig.v1.ListInventoriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListInventoriesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the vulnerability report for the specified VM instance. Only VMs with
     * inventory data have vulnerability reports associated with them.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.osconfig.v1.VulnerabilityReport>
        getVulnerabilityReport(com.google.cloud.osconfig.v1.GetVulnerabilityReportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetVulnerabilityReportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List vulnerability reports for all VM instances in the specified zone.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.osconfig.v1.ListVulnerabilityReportsResponse>
        listVulnerabilityReports(
            com.google.cloud.osconfig.v1.ListVulnerabilityReportsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListVulnerabilityReportsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_INVENTORY = 0;
  private static final int METHODID_LIST_INVENTORIES = 1;
  private static final int METHODID_GET_VULNERABILITY_REPORT = 2;
  private static final int METHODID_LIST_VULNERABILITY_REPORTS = 3;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final OsConfigZonalServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(OsConfigZonalServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_INVENTORY:
          serviceImpl.getInventory(
              (com.google.cloud.osconfig.v1.GetInventoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1.Inventory>)
                  responseObserver);
          break;
        case METHODID_LIST_INVENTORIES:
          serviceImpl.listInventories(
              (com.google.cloud.osconfig.v1.ListInventoriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1.ListInventoriesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_VULNERABILITY_REPORT:
          serviceImpl.getVulnerabilityReport(
              (com.google.cloud.osconfig.v1.GetVulnerabilityReportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1.VulnerabilityReport>)
                  responseObserver);
          break;
        case METHODID_LIST_VULNERABILITY_REPORTS:
          serviceImpl.listVulnerabilityReports(
              (com.google.cloud.osconfig.v1.ListVulnerabilityReportsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.osconfig.v1.ListVulnerabilityReportsResponse>)
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

  private abstract static class OsConfigZonalServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OsConfigZonalServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.osconfig.v1.OsConfigZonalServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OsConfigZonalService");
    }
  }

  private static final class OsConfigZonalServiceFileDescriptorSupplier
      extends OsConfigZonalServiceBaseDescriptorSupplier {
    OsConfigZonalServiceFileDescriptorSupplier() {}
  }

  private static final class OsConfigZonalServiceMethodDescriptorSupplier
      extends OsConfigZonalServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    OsConfigZonalServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (OsConfigZonalServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new OsConfigZonalServiceFileDescriptorSupplier())
                      .addMethod(getGetInventoryMethod())
                      .addMethod(getListInventoriesMethod())
                      .addMethod(getGetVulnerabilityReportMethod())
                      .addMethod(getListVulnerabilityReportsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
