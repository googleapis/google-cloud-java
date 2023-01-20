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
package com.google.monitoring.dashboard.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Manages Stackdriver dashboards. A dashboard is an arrangement of data display
 * widgets in a specific layout.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/monitoring/dashboard/v1/dashboards_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DashboardsServiceGrpc {

  private DashboardsServiceGrpc() {}

  public static final String SERVICE_NAME = "google.monitoring.dashboard.v1.DashboardsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.dashboard.v1.CreateDashboardRequest,
          com.google.monitoring.dashboard.v1.Dashboard>
      getCreateDashboardMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDashboard",
      requestType = com.google.monitoring.dashboard.v1.CreateDashboardRequest.class,
      responseType = com.google.monitoring.dashboard.v1.Dashboard.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.dashboard.v1.CreateDashboardRequest,
          com.google.monitoring.dashboard.v1.Dashboard>
      getCreateDashboardMethod() {
    io.grpc.MethodDescriptor<
            com.google.monitoring.dashboard.v1.CreateDashboardRequest,
            com.google.monitoring.dashboard.v1.Dashboard>
        getCreateDashboardMethod;
    if ((getCreateDashboardMethod = DashboardsServiceGrpc.getCreateDashboardMethod) == null) {
      synchronized (DashboardsServiceGrpc.class) {
        if ((getCreateDashboardMethod = DashboardsServiceGrpc.getCreateDashboardMethod) == null) {
          DashboardsServiceGrpc.getCreateDashboardMethod =
              getCreateDashboardMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.monitoring.dashboard.v1.CreateDashboardRequest,
                          com.google.monitoring.dashboard.v1.Dashboard>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDashboard"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.dashboard.v1.CreateDashboardRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.dashboard.v1.Dashboard.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DashboardsServiceMethodDescriptorSupplier("CreateDashboard"))
                      .build();
        }
      }
    }
    return getCreateDashboardMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.dashboard.v1.ListDashboardsRequest,
          com.google.monitoring.dashboard.v1.ListDashboardsResponse>
      getListDashboardsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDashboards",
      requestType = com.google.monitoring.dashboard.v1.ListDashboardsRequest.class,
      responseType = com.google.monitoring.dashboard.v1.ListDashboardsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.dashboard.v1.ListDashboardsRequest,
          com.google.monitoring.dashboard.v1.ListDashboardsResponse>
      getListDashboardsMethod() {
    io.grpc.MethodDescriptor<
            com.google.monitoring.dashboard.v1.ListDashboardsRequest,
            com.google.monitoring.dashboard.v1.ListDashboardsResponse>
        getListDashboardsMethod;
    if ((getListDashboardsMethod = DashboardsServiceGrpc.getListDashboardsMethod) == null) {
      synchronized (DashboardsServiceGrpc.class) {
        if ((getListDashboardsMethod = DashboardsServiceGrpc.getListDashboardsMethod) == null) {
          DashboardsServiceGrpc.getListDashboardsMethod =
              getListDashboardsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.monitoring.dashboard.v1.ListDashboardsRequest,
                          com.google.monitoring.dashboard.v1.ListDashboardsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDashboards"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.dashboard.v1.ListDashboardsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.dashboard.v1.ListDashboardsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DashboardsServiceMethodDescriptorSupplier("ListDashboards"))
                      .build();
        }
      }
    }
    return getListDashboardsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.dashboard.v1.GetDashboardRequest,
          com.google.monitoring.dashboard.v1.Dashboard>
      getGetDashboardMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDashboard",
      requestType = com.google.monitoring.dashboard.v1.GetDashboardRequest.class,
      responseType = com.google.monitoring.dashboard.v1.Dashboard.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.dashboard.v1.GetDashboardRequest,
          com.google.monitoring.dashboard.v1.Dashboard>
      getGetDashboardMethod() {
    io.grpc.MethodDescriptor<
            com.google.monitoring.dashboard.v1.GetDashboardRequest,
            com.google.monitoring.dashboard.v1.Dashboard>
        getGetDashboardMethod;
    if ((getGetDashboardMethod = DashboardsServiceGrpc.getGetDashboardMethod) == null) {
      synchronized (DashboardsServiceGrpc.class) {
        if ((getGetDashboardMethod = DashboardsServiceGrpc.getGetDashboardMethod) == null) {
          DashboardsServiceGrpc.getGetDashboardMethod =
              getGetDashboardMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.monitoring.dashboard.v1.GetDashboardRequest,
                          com.google.monitoring.dashboard.v1.Dashboard>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDashboard"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.dashboard.v1.GetDashboardRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.dashboard.v1.Dashboard.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DashboardsServiceMethodDescriptorSupplier("GetDashboard"))
                      .build();
        }
      }
    }
    return getGetDashboardMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.dashboard.v1.DeleteDashboardRequest, com.google.protobuf.Empty>
      getDeleteDashboardMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDashboard",
      requestType = com.google.monitoring.dashboard.v1.DeleteDashboardRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.dashboard.v1.DeleteDashboardRequest, com.google.protobuf.Empty>
      getDeleteDashboardMethod() {
    io.grpc.MethodDescriptor<
            com.google.monitoring.dashboard.v1.DeleteDashboardRequest, com.google.protobuf.Empty>
        getDeleteDashboardMethod;
    if ((getDeleteDashboardMethod = DashboardsServiceGrpc.getDeleteDashboardMethod) == null) {
      synchronized (DashboardsServiceGrpc.class) {
        if ((getDeleteDashboardMethod = DashboardsServiceGrpc.getDeleteDashboardMethod) == null) {
          DashboardsServiceGrpc.getDeleteDashboardMethod =
              getDeleteDashboardMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.monitoring.dashboard.v1.DeleteDashboardRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDashboard"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.dashboard.v1.DeleteDashboardRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DashboardsServiceMethodDescriptorSupplier("DeleteDashboard"))
                      .build();
        }
      }
    }
    return getDeleteDashboardMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.dashboard.v1.UpdateDashboardRequest,
          com.google.monitoring.dashboard.v1.Dashboard>
      getUpdateDashboardMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDashboard",
      requestType = com.google.monitoring.dashboard.v1.UpdateDashboardRequest.class,
      responseType = com.google.monitoring.dashboard.v1.Dashboard.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.dashboard.v1.UpdateDashboardRequest,
          com.google.monitoring.dashboard.v1.Dashboard>
      getUpdateDashboardMethod() {
    io.grpc.MethodDescriptor<
            com.google.monitoring.dashboard.v1.UpdateDashboardRequest,
            com.google.monitoring.dashboard.v1.Dashboard>
        getUpdateDashboardMethod;
    if ((getUpdateDashboardMethod = DashboardsServiceGrpc.getUpdateDashboardMethod) == null) {
      synchronized (DashboardsServiceGrpc.class) {
        if ((getUpdateDashboardMethod = DashboardsServiceGrpc.getUpdateDashboardMethod) == null) {
          DashboardsServiceGrpc.getUpdateDashboardMethod =
              getUpdateDashboardMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.monitoring.dashboard.v1.UpdateDashboardRequest,
                          com.google.monitoring.dashboard.v1.Dashboard>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDashboard"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.dashboard.v1.UpdateDashboardRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.dashboard.v1.Dashboard.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DashboardsServiceMethodDescriptorSupplier("UpdateDashboard"))
                      .build();
        }
      }
    }
    return getUpdateDashboardMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DashboardsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DashboardsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DashboardsServiceStub>() {
          @java.lang.Override
          public DashboardsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DashboardsServiceStub(channel, callOptions);
          }
        };
    return DashboardsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DashboardsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DashboardsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DashboardsServiceBlockingStub>() {
          @java.lang.Override
          public DashboardsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DashboardsServiceBlockingStub(channel, callOptions);
          }
        };
    return DashboardsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DashboardsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DashboardsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DashboardsServiceFutureStub>() {
          @java.lang.Override
          public DashboardsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DashboardsServiceFutureStub(channel, callOptions);
          }
        };
    return DashboardsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Manages Stackdriver dashboards. A dashboard is an arrangement of data display
   * widgets in a specific layout.
   * </pre>
   */
  public abstract static class DashboardsServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a new custom dashboard. For examples on how you can use this API to
     * create dashboards, see [Managing dashboards by
     * API](https://cloud.google.com/monitoring/dashboards/api-dashboard). This
     * method requires the `monitoring.dashboards.create` permission on the
     * specified project. For more information about permissions, see [Cloud
     * Identity and Access Management](https://cloud.google.com/iam).
     * </pre>
     */
    public void createDashboard(
        com.google.monitoring.dashboard.v1.CreateDashboardRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.dashboard.v1.Dashboard>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDashboardMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the existing dashboards.
     * This method requires the `monitoring.dashboards.list` permission
     * on the specified project. For more information, see
     * [Cloud Identity and Access Management](https://cloud.google.com/iam).
     * </pre>
     */
    public void listDashboards(
        com.google.monitoring.dashboard.v1.ListDashboardsRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.dashboard.v1.ListDashboardsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDashboardsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches a specific dashboard.
     * This method requires the `monitoring.dashboards.get` permission
     * on the specified dashboard. For more information, see
     * [Cloud Identity and Access Management](https://cloud.google.com/iam).
     * </pre>
     */
    public void getDashboard(
        com.google.monitoring.dashboard.v1.GetDashboardRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.dashboard.v1.Dashboard>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDashboardMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing custom dashboard.
     * This method requires the `monitoring.dashboards.delete` permission
     * on the specified dashboard. For more information, see
     * [Cloud Identity and Access Management](https://cloud.google.com/iam).
     * </pre>
     */
    public void deleteDashboard(
        com.google.monitoring.dashboard.v1.DeleteDashboardRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDashboardMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Replaces an existing custom dashboard with a new definition.
     * This method requires the `monitoring.dashboards.update` permission
     * on the specified dashboard. For more information, see
     * [Cloud Identity and Access Management](https://cloud.google.com/iam).
     * </pre>
     */
    public void updateDashboard(
        com.google.monitoring.dashboard.v1.UpdateDashboardRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.dashboard.v1.Dashboard>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDashboardMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateDashboardMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.dashboard.v1.CreateDashboardRequest,
                      com.google.monitoring.dashboard.v1.Dashboard>(
                      this, METHODID_CREATE_DASHBOARD)))
          .addMethod(
              getListDashboardsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.dashboard.v1.ListDashboardsRequest,
                      com.google.monitoring.dashboard.v1.ListDashboardsResponse>(
                      this, METHODID_LIST_DASHBOARDS)))
          .addMethod(
              getGetDashboardMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.dashboard.v1.GetDashboardRequest,
                      com.google.monitoring.dashboard.v1.Dashboard>(this, METHODID_GET_DASHBOARD)))
          .addMethod(
              getDeleteDashboardMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.dashboard.v1.DeleteDashboardRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_DASHBOARD)))
          .addMethod(
              getUpdateDashboardMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.dashboard.v1.UpdateDashboardRequest,
                      com.google.monitoring.dashboard.v1.Dashboard>(
                      this, METHODID_UPDATE_DASHBOARD)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Manages Stackdriver dashboards. A dashboard is an arrangement of data display
   * widgets in a specific layout.
   * </pre>
   */
  public static final class DashboardsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DashboardsServiceStub> {
    private DashboardsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DashboardsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DashboardsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new custom dashboard. For examples on how you can use this API to
     * create dashboards, see [Managing dashboards by
     * API](https://cloud.google.com/monitoring/dashboards/api-dashboard). This
     * method requires the `monitoring.dashboards.create` permission on the
     * specified project. For more information about permissions, see [Cloud
     * Identity and Access Management](https://cloud.google.com/iam).
     * </pre>
     */
    public void createDashboard(
        com.google.monitoring.dashboard.v1.CreateDashboardRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.dashboard.v1.Dashboard>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDashboardMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the existing dashboards.
     * This method requires the `monitoring.dashboards.list` permission
     * on the specified project. For more information, see
     * [Cloud Identity and Access Management](https://cloud.google.com/iam).
     * </pre>
     */
    public void listDashboards(
        com.google.monitoring.dashboard.v1.ListDashboardsRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.dashboard.v1.ListDashboardsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDashboardsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches a specific dashboard.
     * This method requires the `monitoring.dashboards.get` permission
     * on the specified dashboard. For more information, see
     * [Cloud Identity and Access Management](https://cloud.google.com/iam).
     * </pre>
     */
    public void getDashboard(
        com.google.monitoring.dashboard.v1.GetDashboardRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.dashboard.v1.Dashboard>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDashboardMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing custom dashboard.
     * This method requires the `monitoring.dashboards.delete` permission
     * on the specified dashboard. For more information, see
     * [Cloud Identity and Access Management](https://cloud.google.com/iam).
     * </pre>
     */
    public void deleteDashboard(
        com.google.monitoring.dashboard.v1.DeleteDashboardRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDashboardMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Replaces an existing custom dashboard with a new definition.
     * This method requires the `monitoring.dashboards.update` permission
     * on the specified dashboard. For more information, see
     * [Cloud Identity and Access Management](https://cloud.google.com/iam).
     * </pre>
     */
    public void updateDashboard(
        com.google.monitoring.dashboard.v1.UpdateDashboardRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.dashboard.v1.Dashboard>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDashboardMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Manages Stackdriver dashboards. A dashboard is an arrangement of data display
   * widgets in a specific layout.
   * </pre>
   */
  public static final class DashboardsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DashboardsServiceBlockingStub> {
    private DashboardsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DashboardsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DashboardsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new custom dashboard. For examples on how you can use this API to
     * create dashboards, see [Managing dashboards by
     * API](https://cloud.google.com/monitoring/dashboards/api-dashboard). This
     * method requires the `monitoring.dashboards.create` permission on the
     * specified project. For more information about permissions, see [Cloud
     * Identity and Access Management](https://cloud.google.com/iam).
     * </pre>
     */
    public com.google.monitoring.dashboard.v1.Dashboard createDashboard(
        com.google.monitoring.dashboard.v1.CreateDashboardRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDashboardMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the existing dashboards.
     * This method requires the `monitoring.dashboards.list` permission
     * on the specified project. For more information, see
     * [Cloud Identity and Access Management](https://cloud.google.com/iam).
     * </pre>
     */
    public com.google.monitoring.dashboard.v1.ListDashboardsResponse listDashboards(
        com.google.monitoring.dashboard.v1.ListDashboardsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDashboardsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches a specific dashboard.
     * This method requires the `monitoring.dashboards.get` permission
     * on the specified dashboard. For more information, see
     * [Cloud Identity and Access Management](https://cloud.google.com/iam).
     * </pre>
     */
    public com.google.monitoring.dashboard.v1.Dashboard getDashboard(
        com.google.monitoring.dashboard.v1.GetDashboardRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDashboardMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing custom dashboard.
     * This method requires the `monitoring.dashboards.delete` permission
     * on the specified dashboard. For more information, see
     * [Cloud Identity and Access Management](https://cloud.google.com/iam).
     * </pre>
     */
    public com.google.protobuf.Empty deleteDashboard(
        com.google.monitoring.dashboard.v1.DeleteDashboardRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDashboardMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Replaces an existing custom dashboard with a new definition.
     * This method requires the `monitoring.dashboards.update` permission
     * on the specified dashboard. For more information, see
     * [Cloud Identity and Access Management](https://cloud.google.com/iam).
     * </pre>
     */
    public com.google.monitoring.dashboard.v1.Dashboard updateDashboard(
        com.google.monitoring.dashboard.v1.UpdateDashboardRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDashboardMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Manages Stackdriver dashboards. A dashboard is an arrangement of data display
   * widgets in a specific layout.
   * </pre>
   */
  public static final class DashboardsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DashboardsServiceFutureStub> {
    private DashboardsServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DashboardsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DashboardsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new custom dashboard. For examples on how you can use this API to
     * create dashboards, see [Managing dashboards by
     * API](https://cloud.google.com/monitoring/dashboards/api-dashboard). This
     * method requires the `monitoring.dashboards.create` permission on the
     * specified project. For more information about permissions, see [Cloud
     * Identity and Access Management](https://cloud.google.com/iam).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.monitoring.dashboard.v1.Dashboard>
        createDashboard(com.google.monitoring.dashboard.v1.CreateDashboardRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDashboardMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the existing dashboards.
     * This method requires the `monitoring.dashboards.list` permission
     * on the specified project. For more information, see
     * [Cloud Identity and Access Management](https://cloud.google.com/iam).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.monitoring.dashboard.v1.ListDashboardsResponse>
        listDashboards(com.google.monitoring.dashboard.v1.ListDashboardsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDashboardsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches a specific dashboard.
     * This method requires the `monitoring.dashboards.get` permission
     * on the specified dashboard. For more information, see
     * [Cloud Identity and Access Management](https://cloud.google.com/iam).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.monitoring.dashboard.v1.Dashboard>
        getDashboard(com.google.monitoring.dashboard.v1.GetDashboardRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDashboardMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing custom dashboard.
     * This method requires the `monitoring.dashboards.delete` permission
     * on the specified dashboard. For more information, see
     * [Cloud Identity and Access Management](https://cloud.google.com/iam).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteDashboard(com.google.monitoring.dashboard.v1.DeleteDashboardRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDashboardMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Replaces an existing custom dashboard with a new definition.
     * This method requires the `monitoring.dashboards.update` permission
     * on the specified dashboard. For more information, see
     * [Cloud Identity and Access Management](https://cloud.google.com/iam).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.monitoring.dashboard.v1.Dashboard>
        updateDashboard(com.google.monitoring.dashboard.v1.UpdateDashboardRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDashboardMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_DASHBOARD = 0;
  private static final int METHODID_LIST_DASHBOARDS = 1;
  private static final int METHODID_GET_DASHBOARD = 2;
  private static final int METHODID_DELETE_DASHBOARD = 3;
  private static final int METHODID_UPDATE_DASHBOARD = 4;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DashboardsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DashboardsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_DASHBOARD:
          serviceImpl.createDashboard(
              (com.google.monitoring.dashboard.v1.CreateDashboardRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.dashboard.v1.Dashboard>)
                  responseObserver);
          break;
        case METHODID_LIST_DASHBOARDS:
          serviceImpl.listDashboards(
              (com.google.monitoring.dashboard.v1.ListDashboardsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.monitoring.dashboard.v1.ListDashboardsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DASHBOARD:
          serviceImpl.getDashboard(
              (com.google.monitoring.dashboard.v1.GetDashboardRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.dashboard.v1.Dashboard>)
                  responseObserver);
          break;
        case METHODID_DELETE_DASHBOARD:
          serviceImpl.deleteDashboard(
              (com.google.monitoring.dashboard.v1.DeleteDashboardRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_DASHBOARD:
          serviceImpl.updateDashboard(
              (com.google.monitoring.dashboard.v1.UpdateDashboardRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.dashboard.v1.Dashboard>)
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

  private abstract static class DashboardsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DashboardsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.monitoring.dashboard.v1.DashboardsServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DashboardsService");
    }
  }

  private static final class DashboardsServiceFileDescriptorSupplier
      extends DashboardsServiceBaseDescriptorSupplier {
    DashboardsServiceFileDescriptorSupplier() {}
  }

  private static final class DashboardsServiceMethodDescriptorSupplier
      extends DashboardsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DashboardsServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DashboardsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DashboardsServiceFileDescriptorSupplier())
                      .addMethod(getCreateDashboardMethod())
                      .addMethod(getListDashboardsMethod())
                      .addMethod(getGetDashboardMethod())
                      .addMethod(getDeleteDashboardMethod())
                      .addMethod(getUpdateDashboardMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
