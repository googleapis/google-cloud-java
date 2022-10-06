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
package com.google.cloud.beyondcorp.appgateways.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * ## API Overview
 * The `beyondcorp.googleapis.com` service implements the Google Cloud
 * BeyondCorp API.
 * ## Data Model
 * The AppGatewaysService exposes the following resources:
 * * AppGateways, named as follows:
 *   `projects/{project_id}/locations/{location_id}/appGateways/{app_gateway_id}`.
 * The AppGatewaysService service provides methods to manage
 * (create/read/update/delete) BeyondCorp AppGateways.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/beyondcorp/appgateways/v1/app_gateways_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AppGatewaysServiceGrpc {

  private AppGatewaysServiceGrpc() {}

  public static final String SERVICE_NAME =
      "google.cloud.beyondcorp.appgateways.v1.AppGatewaysService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.beyondcorp.appgateways.v1.ListAppGatewaysRequest,
          com.google.cloud.beyondcorp.appgateways.v1.ListAppGatewaysResponse>
      getListAppGatewaysMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAppGateways",
      requestType = com.google.cloud.beyondcorp.appgateways.v1.ListAppGatewaysRequest.class,
      responseType = com.google.cloud.beyondcorp.appgateways.v1.ListAppGatewaysResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.beyondcorp.appgateways.v1.ListAppGatewaysRequest,
          com.google.cloud.beyondcorp.appgateways.v1.ListAppGatewaysResponse>
      getListAppGatewaysMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.beyondcorp.appgateways.v1.ListAppGatewaysRequest,
            com.google.cloud.beyondcorp.appgateways.v1.ListAppGatewaysResponse>
        getListAppGatewaysMethod;
    if ((getListAppGatewaysMethod = AppGatewaysServiceGrpc.getListAppGatewaysMethod) == null) {
      synchronized (AppGatewaysServiceGrpc.class) {
        if ((getListAppGatewaysMethod = AppGatewaysServiceGrpc.getListAppGatewaysMethod) == null) {
          AppGatewaysServiceGrpc.getListAppGatewaysMethod =
              getListAppGatewaysMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.beyondcorp.appgateways.v1.ListAppGatewaysRequest,
                          com.google.cloud.beyondcorp.appgateways.v1.ListAppGatewaysResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAppGateways"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.beyondcorp.appgateways.v1.ListAppGatewaysRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.beyondcorp.appgateways.v1.ListAppGatewaysResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AppGatewaysServiceMethodDescriptorSupplier("ListAppGateways"))
                      .build();
        }
      }
    }
    return getListAppGatewaysMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.beyondcorp.appgateways.v1.GetAppGatewayRequest,
          com.google.cloud.beyondcorp.appgateways.v1.AppGateway>
      getGetAppGatewayMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAppGateway",
      requestType = com.google.cloud.beyondcorp.appgateways.v1.GetAppGatewayRequest.class,
      responseType = com.google.cloud.beyondcorp.appgateways.v1.AppGateway.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.beyondcorp.appgateways.v1.GetAppGatewayRequest,
          com.google.cloud.beyondcorp.appgateways.v1.AppGateway>
      getGetAppGatewayMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.beyondcorp.appgateways.v1.GetAppGatewayRequest,
            com.google.cloud.beyondcorp.appgateways.v1.AppGateway>
        getGetAppGatewayMethod;
    if ((getGetAppGatewayMethod = AppGatewaysServiceGrpc.getGetAppGatewayMethod) == null) {
      synchronized (AppGatewaysServiceGrpc.class) {
        if ((getGetAppGatewayMethod = AppGatewaysServiceGrpc.getGetAppGatewayMethod) == null) {
          AppGatewaysServiceGrpc.getGetAppGatewayMethod =
              getGetAppGatewayMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.beyondcorp.appgateways.v1.GetAppGatewayRequest,
                          com.google.cloud.beyondcorp.appgateways.v1.AppGateway>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAppGateway"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.beyondcorp.appgateways.v1.GetAppGatewayRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.beyondcorp.appgateways.v1.AppGateway
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AppGatewaysServiceMethodDescriptorSupplier("GetAppGateway"))
                      .build();
        }
      }
    }
    return getGetAppGatewayMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.beyondcorp.appgateways.v1.CreateAppGatewayRequest,
          com.google.longrunning.Operation>
      getCreateAppGatewayMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAppGateway",
      requestType = com.google.cloud.beyondcorp.appgateways.v1.CreateAppGatewayRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.beyondcorp.appgateways.v1.CreateAppGatewayRequest,
          com.google.longrunning.Operation>
      getCreateAppGatewayMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.beyondcorp.appgateways.v1.CreateAppGatewayRequest,
            com.google.longrunning.Operation>
        getCreateAppGatewayMethod;
    if ((getCreateAppGatewayMethod = AppGatewaysServiceGrpc.getCreateAppGatewayMethod) == null) {
      synchronized (AppGatewaysServiceGrpc.class) {
        if ((getCreateAppGatewayMethod = AppGatewaysServiceGrpc.getCreateAppGatewayMethod)
            == null) {
          AppGatewaysServiceGrpc.getCreateAppGatewayMethod =
              getCreateAppGatewayMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.beyondcorp.appgateways.v1.CreateAppGatewayRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAppGateway"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.beyondcorp.appgateways.v1.CreateAppGatewayRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AppGatewaysServiceMethodDescriptorSupplier("CreateAppGateway"))
                      .build();
        }
      }
    }
    return getCreateAppGatewayMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.beyondcorp.appgateways.v1.DeleteAppGatewayRequest,
          com.google.longrunning.Operation>
      getDeleteAppGatewayMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAppGateway",
      requestType = com.google.cloud.beyondcorp.appgateways.v1.DeleteAppGatewayRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.beyondcorp.appgateways.v1.DeleteAppGatewayRequest,
          com.google.longrunning.Operation>
      getDeleteAppGatewayMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.beyondcorp.appgateways.v1.DeleteAppGatewayRequest,
            com.google.longrunning.Operation>
        getDeleteAppGatewayMethod;
    if ((getDeleteAppGatewayMethod = AppGatewaysServiceGrpc.getDeleteAppGatewayMethod) == null) {
      synchronized (AppGatewaysServiceGrpc.class) {
        if ((getDeleteAppGatewayMethod = AppGatewaysServiceGrpc.getDeleteAppGatewayMethod)
            == null) {
          AppGatewaysServiceGrpc.getDeleteAppGatewayMethod =
              getDeleteAppGatewayMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.beyondcorp.appgateways.v1.DeleteAppGatewayRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAppGateway"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.beyondcorp.appgateways.v1.DeleteAppGatewayRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AppGatewaysServiceMethodDescriptorSupplier("DeleteAppGateway"))
                      .build();
        }
      }
    }
    return getDeleteAppGatewayMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AppGatewaysServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AppGatewaysServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AppGatewaysServiceStub>() {
          @java.lang.Override
          public AppGatewaysServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AppGatewaysServiceStub(channel, callOptions);
          }
        };
    return AppGatewaysServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AppGatewaysServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AppGatewaysServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AppGatewaysServiceBlockingStub>() {
          @java.lang.Override
          public AppGatewaysServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AppGatewaysServiceBlockingStub(channel, callOptions);
          }
        };
    return AppGatewaysServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AppGatewaysServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AppGatewaysServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AppGatewaysServiceFutureStub>() {
          @java.lang.Override
          public AppGatewaysServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AppGatewaysServiceFutureStub(channel, callOptions);
          }
        };
    return AppGatewaysServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * ## API Overview
   * The `beyondcorp.googleapis.com` service implements the Google Cloud
   * BeyondCorp API.
   * ## Data Model
   * The AppGatewaysService exposes the following resources:
   * * AppGateways, named as follows:
   *   `projects/{project_id}/locations/{location_id}/appGateways/{app_gateway_id}`.
   * The AppGatewaysService service provides methods to manage
   * (create/read/update/delete) BeyondCorp AppGateways.
   * </pre>
   */
  public abstract static class AppGatewaysServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Lists AppGateways in a given project and location.
     * </pre>
     */
    public void listAppGateways(
        com.google.cloud.beyondcorp.appgateways.v1.ListAppGatewaysRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.beyondcorp.appgateways.v1.ListAppGatewaysResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAppGatewaysMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single AppGateway.
     * </pre>
     */
    public void getAppGateway(
        com.google.cloud.beyondcorp.appgateways.v1.GetAppGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.beyondcorp.appgateways.v1.AppGateway>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAppGatewayMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new AppGateway in a given project and location.
     * </pre>
     */
    public void createAppGateway(
        com.google.cloud.beyondcorp.appgateways.v1.CreateAppGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAppGatewayMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single AppGateway.
     * </pre>
     */
    public void deleteAppGateway(
        com.google.cloud.beyondcorp.appgateways.v1.DeleteAppGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAppGatewayMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListAppGatewaysMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.beyondcorp.appgateways.v1.ListAppGatewaysRequest,
                      com.google.cloud.beyondcorp.appgateways.v1.ListAppGatewaysResponse>(
                      this, METHODID_LIST_APP_GATEWAYS)))
          .addMethod(
              getGetAppGatewayMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.beyondcorp.appgateways.v1.GetAppGatewayRequest,
                      com.google.cloud.beyondcorp.appgateways.v1.AppGateway>(
                      this, METHODID_GET_APP_GATEWAY)))
          .addMethod(
              getCreateAppGatewayMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.beyondcorp.appgateways.v1.CreateAppGatewayRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_APP_GATEWAY)))
          .addMethod(
              getDeleteAppGatewayMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.beyondcorp.appgateways.v1.DeleteAppGatewayRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_APP_GATEWAY)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * ## API Overview
   * The `beyondcorp.googleapis.com` service implements the Google Cloud
   * BeyondCorp API.
   * ## Data Model
   * The AppGatewaysService exposes the following resources:
   * * AppGateways, named as follows:
   *   `projects/{project_id}/locations/{location_id}/appGateways/{app_gateway_id}`.
   * The AppGatewaysService service provides methods to manage
   * (create/read/update/delete) BeyondCorp AppGateways.
   * </pre>
   */
  public static final class AppGatewaysServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AppGatewaysServiceStub> {
    private AppGatewaysServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AppGatewaysServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AppGatewaysServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists AppGateways in a given project and location.
     * </pre>
     */
    public void listAppGateways(
        com.google.cloud.beyondcorp.appgateways.v1.ListAppGatewaysRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.beyondcorp.appgateways.v1.ListAppGatewaysResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAppGatewaysMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single AppGateway.
     * </pre>
     */
    public void getAppGateway(
        com.google.cloud.beyondcorp.appgateways.v1.GetAppGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.beyondcorp.appgateways.v1.AppGateway>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAppGatewayMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new AppGateway in a given project and location.
     * </pre>
     */
    public void createAppGateway(
        com.google.cloud.beyondcorp.appgateways.v1.CreateAppGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAppGatewayMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single AppGateway.
     * </pre>
     */
    public void deleteAppGateway(
        com.google.cloud.beyondcorp.appgateways.v1.DeleteAppGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAppGatewayMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * ## API Overview
   * The `beyondcorp.googleapis.com` service implements the Google Cloud
   * BeyondCorp API.
   * ## Data Model
   * The AppGatewaysService exposes the following resources:
   * * AppGateways, named as follows:
   *   `projects/{project_id}/locations/{location_id}/appGateways/{app_gateway_id}`.
   * The AppGatewaysService service provides methods to manage
   * (create/read/update/delete) BeyondCorp AppGateways.
   * </pre>
   */
  public static final class AppGatewaysServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AppGatewaysServiceBlockingStub> {
    private AppGatewaysServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AppGatewaysServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AppGatewaysServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists AppGateways in a given project and location.
     * </pre>
     */
    public com.google.cloud.beyondcorp.appgateways.v1.ListAppGatewaysResponse listAppGateways(
        com.google.cloud.beyondcorp.appgateways.v1.ListAppGatewaysRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAppGatewaysMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single AppGateway.
     * </pre>
     */
    public com.google.cloud.beyondcorp.appgateways.v1.AppGateway getAppGateway(
        com.google.cloud.beyondcorp.appgateways.v1.GetAppGatewayRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAppGatewayMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new AppGateway in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createAppGateway(
        com.google.cloud.beyondcorp.appgateways.v1.CreateAppGatewayRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAppGatewayMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single AppGateway.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAppGateway(
        com.google.cloud.beyondcorp.appgateways.v1.DeleteAppGatewayRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAppGatewayMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * ## API Overview
   * The `beyondcorp.googleapis.com` service implements the Google Cloud
   * BeyondCorp API.
   * ## Data Model
   * The AppGatewaysService exposes the following resources:
   * * AppGateways, named as follows:
   *   `projects/{project_id}/locations/{location_id}/appGateways/{app_gateway_id}`.
   * The AppGatewaysService service provides methods to manage
   * (create/read/update/delete) BeyondCorp AppGateways.
   * </pre>
   */
  public static final class AppGatewaysServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AppGatewaysServiceFutureStub> {
    private AppGatewaysServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AppGatewaysServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AppGatewaysServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists AppGateways in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.beyondcorp.appgateways.v1.ListAppGatewaysResponse>
        listAppGateways(com.google.cloud.beyondcorp.appgateways.v1.ListAppGatewaysRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAppGatewaysMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single AppGateway.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.beyondcorp.appgateways.v1.AppGateway>
        getAppGateway(com.google.cloud.beyondcorp.appgateways.v1.GetAppGatewayRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAppGatewayMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new AppGateway in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createAppGateway(
            com.google.cloud.beyondcorp.appgateways.v1.CreateAppGatewayRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAppGatewayMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single AppGateway.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteAppGateway(
            com.google.cloud.beyondcorp.appgateways.v1.DeleteAppGatewayRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAppGatewayMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_APP_GATEWAYS = 0;
  private static final int METHODID_GET_APP_GATEWAY = 1;
  private static final int METHODID_CREATE_APP_GATEWAY = 2;
  private static final int METHODID_DELETE_APP_GATEWAY = 3;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AppGatewaysServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AppGatewaysServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_APP_GATEWAYS:
          serviceImpl.listAppGateways(
              (com.google.cloud.beyondcorp.appgateways.v1.ListAppGatewaysRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.beyondcorp.appgateways.v1.ListAppGatewaysResponse>)
                  responseObserver);
          break;
        case METHODID_GET_APP_GATEWAY:
          serviceImpl.getAppGateway(
              (com.google.cloud.beyondcorp.appgateways.v1.GetAppGatewayRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.beyondcorp.appgateways.v1.AppGateway>)
                  responseObserver);
          break;
        case METHODID_CREATE_APP_GATEWAY:
          serviceImpl.createAppGateway(
              (com.google.cloud.beyondcorp.appgateways.v1.CreateAppGatewayRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_APP_GATEWAY:
          serviceImpl.deleteAppGateway(
              (com.google.cloud.beyondcorp.appgateways.v1.DeleteAppGatewayRequest) request,
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

  private abstract static class AppGatewaysServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AppGatewaysServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.beyondcorp.appgateways.v1.AppGatewaysServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AppGatewaysService");
    }
  }

  private static final class AppGatewaysServiceFileDescriptorSupplier
      extends AppGatewaysServiceBaseDescriptorSupplier {
    AppGatewaysServiceFileDescriptorSupplier() {}
  }

  private static final class AppGatewaysServiceMethodDescriptorSupplier
      extends AppGatewaysServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AppGatewaysServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AppGatewaysServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AppGatewaysServiceFileDescriptorSupplier())
                      .addMethod(getListAppGatewaysMethod())
                      .addMethod(getGetAppGatewayMethod())
                      .addMethod(getCreateAppGatewayMethod())
                      .addMethod(getDeleteAppGatewayMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
