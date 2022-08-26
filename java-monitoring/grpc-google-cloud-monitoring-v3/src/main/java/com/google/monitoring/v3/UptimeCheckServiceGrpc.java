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
package com.google.monitoring.v3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The UptimeCheckService API is used to manage (list, create, delete, edit)
 * Uptime check configurations in the Stackdriver Monitoring product. An Uptime
 * check is a piece of configuration that determines which resources and
 * services to monitor for availability. These configurations can also be
 * configured interactively by navigating to the [Cloud Console]
 * (http://console.cloud.google.com), selecting the appropriate project,
 * clicking on "Monitoring" on the left-hand side to navigate to Stackdriver,
 * and then clicking on "Uptime".
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/monitoring/v3/uptime_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class UptimeCheckServiceGrpc {

  private UptimeCheckServiceGrpc() {}

  public static final String SERVICE_NAME = "google.monitoring.v3.UptimeCheckService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.ListUptimeCheckConfigsRequest,
          com.google.monitoring.v3.ListUptimeCheckConfigsResponse>
      getListUptimeCheckConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListUptimeCheckConfigs",
      requestType = com.google.monitoring.v3.ListUptimeCheckConfigsRequest.class,
      responseType = com.google.monitoring.v3.ListUptimeCheckConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.ListUptimeCheckConfigsRequest,
          com.google.monitoring.v3.ListUptimeCheckConfigsResponse>
      getListUptimeCheckConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.monitoring.v3.ListUptimeCheckConfigsRequest,
            com.google.monitoring.v3.ListUptimeCheckConfigsResponse>
        getListUptimeCheckConfigsMethod;
    if ((getListUptimeCheckConfigsMethod = UptimeCheckServiceGrpc.getListUptimeCheckConfigsMethod)
        == null) {
      synchronized (UptimeCheckServiceGrpc.class) {
        if ((getListUptimeCheckConfigsMethod =
                UptimeCheckServiceGrpc.getListUptimeCheckConfigsMethod)
            == null) {
          UptimeCheckServiceGrpc.getListUptimeCheckConfigsMethod =
              getListUptimeCheckConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.monitoring.v3.ListUptimeCheckConfigsRequest,
                          com.google.monitoring.v3.ListUptimeCheckConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListUptimeCheckConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.ListUptimeCheckConfigsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.ListUptimeCheckConfigsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new UptimeCheckServiceMethodDescriptorSupplier("ListUptimeCheckConfigs"))
                      .build();
        }
      }
    }
    return getListUptimeCheckConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.GetUptimeCheckConfigRequest,
          com.google.monitoring.v3.UptimeCheckConfig>
      getGetUptimeCheckConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUptimeCheckConfig",
      requestType = com.google.monitoring.v3.GetUptimeCheckConfigRequest.class,
      responseType = com.google.monitoring.v3.UptimeCheckConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.GetUptimeCheckConfigRequest,
          com.google.monitoring.v3.UptimeCheckConfig>
      getGetUptimeCheckConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.monitoring.v3.GetUptimeCheckConfigRequest,
            com.google.monitoring.v3.UptimeCheckConfig>
        getGetUptimeCheckConfigMethod;
    if ((getGetUptimeCheckConfigMethod = UptimeCheckServiceGrpc.getGetUptimeCheckConfigMethod)
        == null) {
      synchronized (UptimeCheckServiceGrpc.class) {
        if ((getGetUptimeCheckConfigMethod = UptimeCheckServiceGrpc.getGetUptimeCheckConfigMethod)
            == null) {
          UptimeCheckServiceGrpc.getGetUptimeCheckConfigMethod =
              getGetUptimeCheckConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.monitoring.v3.GetUptimeCheckConfigRequest,
                          com.google.monitoring.v3.UptimeCheckConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetUptimeCheckConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.GetUptimeCheckConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.UptimeCheckConfig.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new UptimeCheckServiceMethodDescriptorSupplier("GetUptimeCheckConfig"))
                      .build();
        }
      }
    }
    return getGetUptimeCheckConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.CreateUptimeCheckConfigRequest,
          com.google.monitoring.v3.UptimeCheckConfig>
      getCreateUptimeCheckConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUptimeCheckConfig",
      requestType = com.google.monitoring.v3.CreateUptimeCheckConfigRequest.class,
      responseType = com.google.monitoring.v3.UptimeCheckConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.CreateUptimeCheckConfigRequest,
          com.google.monitoring.v3.UptimeCheckConfig>
      getCreateUptimeCheckConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.monitoring.v3.CreateUptimeCheckConfigRequest,
            com.google.monitoring.v3.UptimeCheckConfig>
        getCreateUptimeCheckConfigMethod;
    if ((getCreateUptimeCheckConfigMethod = UptimeCheckServiceGrpc.getCreateUptimeCheckConfigMethod)
        == null) {
      synchronized (UptimeCheckServiceGrpc.class) {
        if ((getCreateUptimeCheckConfigMethod =
                UptimeCheckServiceGrpc.getCreateUptimeCheckConfigMethod)
            == null) {
          UptimeCheckServiceGrpc.getCreateUptimeCheckConfigMethod =
              getCreateUptimeCheckConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.monitoring.v3.CreateUptimeCheckConfigRequest,
                          com.google.monitoring.v3.UptimeCheckConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateUptimeCheckConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.CreateUptimeCheckConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.UptimeCheckConfig.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new UptimeCheckServiceMethodDescriptorSupplier("CreateUptimeCheckConfig"))
                      .build();
        }
      }
    }
    return getCreateUptimeCheckConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.UpdateUptimeCheckConfigRequest,
          com.google.monitoring.v3.UptimeCheckConfig>
      getUpdateUptimeCheckConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateUptimeCheckConfig",
      requestType = com.google.monitoring.v3.UpdateUptimeCheckConfigRequest.class,
      responseType = com.google.monitoring.v3.UptimeCheckConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.UpdateUptimeCheckConfigRequest,
          com.google.monitoring.v3.UptimeCheckConfig>
      getUpdateUptimeCheckConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.monitoring.v3.UpdateUptimeCheckConfigRequest,
            com.google.monitoring.v3.UptimeCheckConfig>
        getUpdateUptimeCheckConfigMethod;
    if ((getUpdateUptimeCheckConfigMethod = UptimeCheckServiceGrpc.getUpdateUptimeCheckConfigMethod)
        == null) {
      synchronized (UptimeCheckServiceGrpc.class) {
        if ((getUpdateUptimeCheckConfigMethod =
                UptimeCheckServiceGrpc.getUpdateUptimeCheckConfigMethod)
            == null) {
          UptimeCheckServiceGrpc.getUpdateUptimeCheckConfigMethod =
              getUpdateUptimeCheckConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.monitoring.v3.UpdateUptimeCheckConfigRequest,
                          com.google.monitoring.v3.UptimeCheckConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateUptimeCheckConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.UpdateUptimeCheckConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.UptimeCheckConfig.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new UptimeCheckServiceMethodDescriptorSupplier("UpdateUptimeCheckConfig"))
                      .build();
        }
      }
    }
    return getUpdateUptimeCheckConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.DeleteUptimeCheckConfigRequest, com.google.protobuf.Empty>
      getDeleteUptimeCheckConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteUptimeCheckConfig",
      requestType = com.google.monitoring.v3.DeleteUptimeCheckConfigRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.DeleteUptimeCheckConfigRequest, com.google.protobuf.Empty>
      getDeleteUptimeCheckConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.monitoring.v3.DeleteUptimeCheckConfigRequest, com.google.protobuf.Empty>
        getDeleteUptimeCheckConfigMethod;
    if ((getDeleteUptimeCheckConfigMethod = UptimeCheckServiceGrpc.getDeleteUptimeCheckConfigMethod)
        == null) {
      synchronized (UptimeCheckServiceGrpc.class) {
        if ((getDeleteUptimeCheckConfigMethod =
                UptimeCheckServiceGrpc.getDeleteUptimeCheckConfigMethod)
            == null) {
          UptimeCheckServiceGrpc.getDeleteUptimeCheckConfigMethod =
              getDeleteUptimeCheckConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.monitoring.v3.DeleteUptimeCheckConfigRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteUptimeCheckConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.DeleteUptimeCheckConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new UptimeCheckServiceMethodDescriptorSupplier("DeleteUptimeCheckConfig"))
                      .build();
        }
      }
    }
    return getDeleteUptimeCheckConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.ListUptimeCheckIpsRequest,
          com.google.monitoring.v3.ListUptimeCheckIpsResponse>
      getListUptimeCheckIpsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListUptimeCheckIps",
      requestType = com.google.monitoring.v3.ListUptimeCheckIpsRequest.class,
      responseType = com.google.monitoring.v3.ListUptimeCheckIpsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.ListUptimeCheckIpsRequest,
          com.google.monitoring.v3.ListUptimeCheckIpsResponse>
      getListUptimeCheckIpsMethod() {
    io.grpc.MethodDescriptor<
            com.google.monitoring.v3.ListUptimeCheckIpsRequest,
            com.google.monitoring.v3.ListUptimeCheckIpsResponse>
        getListUptimeCheckIpsMethod;
    if ((getListUptimeCheckIpsMethod = UptimeCheckServiceGrpc.getListUptimeCheckIpsMethod)
        == null) {
      synchronized (UptimeCheckServiceGrpc.class) {
        if ((getListUptimeCheckIpsMethod = UptimeCheckServiceGrpc.getListUptimeCheckIpsMethod)
            == null) {
          UptimeCheckServiceGrpc.getListUptimeCheckIpsMethod =
              getListUptimeCheckIpsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.monitoring.v3.ListUptimeCheckIpsRequest,
                          com.google.monitoring.v3.ListUptimeCheckIpsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListUptimeCheckIps"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.ListUptimeCheckIpsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.ListUptimeCheckIpsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new UptimeCheckServiceMethodDescriptorSupplier("ListUptimeCheckIps"))
                      .build();
        }
      }
    }
    return getListUptimeCheckIpsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static UptimeCheckServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UptimeCheckServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<UptimeCheckServiceStub>() {
          @java.lang.Override
          public UptimeCheckServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new UptimeCheckServiceStub(channel, callOptions);
          }
        };
    return UptimeCheckServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UptimeCheckServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UptimeCheckServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<UptimeCheckServiceBlockingStub>() {
          @java.lang.Override
          public UptimeCheckServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new UptimeCheckServiceBlockingStub(channel, callOptions);
          }
        };
    return UptimeCheckServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static UptimeCheckServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UptimeCheckServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<UptimeCheckServiceFutureStub>() {
          @java.lang.Override
          public UptimeCheckServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new UptimeCheckServiceFutureStub(channel, callOptions);
          }
        };
    return UptimeCheckServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The UptimeCheckService API is used to manage (list, create, delete, edit)
   * Uptime check configurations in the Stackdriver Monitoring product. An Uptime
   * check is a piece of configuration that determines which resources and
   * services to monitor for availability. These configurations can also be
   * configured interactively by navigating to the [Cloud Console]
   * (http://console.cloud.google.com), selecting the appropriate project,
   * clicking on "Monitoring" on the left-hand side to navigate to Stackdriver,
   * and then clicking on "Uptime".
   * </pre>
   */
  public abstract static class UptimeCheckServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Lists the existing valid Uptime check configurations for the project
     * (leaving out any invalid configurations).
     * </pre>
     */
    public void listUptimeCheckConfigs(
        com.google.monitoring.v3.ListUptimeCheckConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.ListUptimeCheckConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListUptimeCheckConfigsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a single Uptime check configuration.
     * </pre>
     */
    public void getUptimeCheckConfig(
        com.google.monitoring.v3.GetUptimeCheckConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.UptimeCheckConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetUptimeCheckConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Uptime check configuration.
     * </pre>
     */
    public void createUptimeCheckConfig(
        com.google.monitoring.v3.CreateUptimeCheckConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.UptimeCheckConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateUptimeCheckConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an Uptime check configuration. You can either replace the entire
     * configuration with a new one or replace only certain fields in the current
     * configuration by specifying the fields to be updated via `updateMask`.
     * Returns the updated configuration.
     * </pre>
     */
    public void updateUptimeCheckConfig(
        com.google.monitoring.v3.UpdateUptimeCheckConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.UptimeCheckConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateUptimeCheckConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Uptime check configuration. Note that this method will fail
     * if the Uptime check configuration is referenced by an alert policy or
     * other dependent configs that would be rendered invalid by the deletion.
     * </pre>
     */
    public void deleteUptimeCheckConfig(
        com.google.monitoring.v3.DeleteUptimeCheckConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteUptimeCheckConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of IP addresses that checkers run from
     * </pre>
     */
    public void listUptimeCheckIps(
        com.google.monitoring.v3.ListUptimeCheckIpsRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.ListUptimeCheckIpsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListUptimeCheckIpsMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListUptimeCheckConfigsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.ListUptimeCheckConfigsRequest,
                      com.google.monitoring.v3.ListUptimeCheckConfigsResponse>(
                      this, METHODID_LIST_UPTIME_CHECK_CONFIGS)))
          .addMethod(
              getGetUptimeCheckConfigMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.GetUptimeCheckConfigRequest,
                      com.google.monitoring.v3.UptimeCheckConfig>(
                      this, METHODID_GET_UPTIME_CHECK_CONFIG)))
          .addMethod(
              getCreateUptimeCheckConfigMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.CreateUptimeCheckConfigRequest,
                      com.google.monitoring.v3.UptimeCheckConfig>(
                      this, METHODID_CREATE_UPTIME_CHECK_CONFIG)))
          .addMethod(
              getUpdateUptimeCheckConfigMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.UpdateUptimeCheckConfigRequest,
                      com.google.monitoring.v3.UptimeCheckConfig>(
                      this, METHODID_UPDATE_UPTIME_CHECK_CONFIG)))
          .addMethod(
              getDeleteUptimeCheckConfigMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.DeleteUptimeCheckConfigRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_UPTIME_CHECK_CONFIG)))
          .addMethod(
              getListUptimeCheckIpsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.ListUptimeCheckIpsRequest,
                      com.google.monitoring.v3.ListUptimeCheckIpsResponse>(
                      this, METHODID_LIST_UPTIME_CHECK_IPS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * The UptimeCheckService API is used to manage (list, create, delete, edit)
   * Uptime check configurations in the Stackdriver Monitoring product. An Uptime
   * check is a piece of configuration that determines which resources and
   * services to monitor for availability. These configurations can also be
   * configured interactively by navigating to the [Cloud Console]
   * (http://console.cloud.google.com), selecting the appropriate project,
   * clicking on "Monitoring" on the left-hand side to navigate to Stackdriver,
   * and then clicking on "Uptime".
   * </pre>
   */
  public static final class UptimeCheckServiceStub
      extends io.grpc.stub.AbstractAsyncStub<UptimeCheckServiceStub> {
    private UptimeCheckServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UptimeCheckServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UptimeCheckServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the existing valid Uptime check configurations for the project
     * (leaving out any invalid configurations).
     * </pre>
     */
    public void listUptimeCheckConfigs(
        com.google.monitoring.v3.ListUptimeCheckConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.ListUptimeCheckConfigsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListUptimeCheckConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a single Uptime check configuration.
     * </pre>
     */
    public void getUptimeCheckConfig(
        com.google.monitoring.v3.GetUptimeCheckConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.UptimeCheckConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUptimeCheckConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Uptime check configuration.
     * </pre>
     */
    public void createUptimeCheckConfig(
        com.google.monitoring.v3.CreateUptimeCheckConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.UptimeCheckConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateUptimeCheckConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an Uptime check configuration. You can either replace the entire
     * configuration with a new one or replace only certain fields in the current
     * configuration by specifying the fields to be updated via `updateMask`.
     * Returns the updated configuration.
     * </pre>
     */
    public void updateUptimeCheckConfig(
        com.google.monitoring.v3.UpdateUptimeCheckConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.UptimeCheckConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateUptimeCheckConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Uptime check configuration. Note that this method will fail
     * if the Uptime check configuration is referenced by an alert policy or
     * other dependent configs that would be rendered invalid by the deletion.
     * </pre>
     */
    public void deleteUptimeCheckConfig(
        com.google.monitoring.v3.DeleteUptimeCheckConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteUptimeCheckConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of IP addresses that checkers run from
     * </pre>
     */
    public void listUptimeCheckIps(
        com.google.monitoring.v3.ListUptimeCheckIpsRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.ListUptimeCheckIpsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListUptimeCheckIpsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * The UptimeCheckService API is used to manage (list, create, delete, edit)
   * Uptime check configurations in the Stackdriver Monitoring product. An Uptime
   * check is a piece of configuration that determines which resources and
   * services to monitor for availability. These configurations can also be
   * configured interactively by navigating to the [Cloud Console]
   * (http://console.cloud.google.com), selecting the appropriate project,
   * clicking on "Monitoring" on the left-hand side to navigate to Stackdriver,
   * and then clicking on "Uptime".
   * </pre>
   */
  public static final class UptimeCheckServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<UptimeCheckServiceBlockingStub> {
    private UptimeCheckServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UptimeCheckServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UptimeCheckServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the existing valid Uptime check configurations for the project
     * (leaving out any invalid configurations).
     * </pre>
     */
    public com.google.monitoring.v3.ListUptimeCheckConfigsResponse listUptimeCheckConfigs(
        com.google.monitoring.v3.ListUptimeCheckConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUptimeCheckConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a single Uptime check configuration.
     * </pre>
     */
    public com.google.monitoring.v3.UptimeCheckConfig getUptimeCheckConfig(
        com.google.monitoring.v3.GetUptimeCheckConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUptimeCheckConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Uptime check configuration.
     * </pre>
     */
    public com.google.monitoring.v3.UptimeCheckConfig createUptimeCheckConfig(
        com.google.monitoring.v3.CreateUptimeCheckConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUptimeCheckConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an Uptime check configuration. You can either replace the entire
     * configuration with a new one or replace only certain fields in the current
     * configuration by specifying the fields to be updated via `updateMask`.
     * Returns the updated configuration.
     * </pre>
     */
    public com.google.monitoring.v3.UptimeCheckConfig updateUptimeCheckConfig(
        com.google.monitoring.v3.UpdateUptimeCheckConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUptimeCheckConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Uptime check configuration. Note that this method will fail
     * if the Uptime check configuration is referenced by an alert policy or
     * other dependent configs that would be rendered invalid by the deletion.
     * </pre>
     */
    public com.google.protobuf.Empty deleteUptimeCheckConfig(
        com.google.monitoring.v3.DeleteUptimeCheckConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteUptimeCheckConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of IP addresses that checkers run from
     * </pre>
     */
    public com.google.monitoring.v3.ListUptimeCheckIpsResponse listUptimeCheckIps(
        com.google.monitoring.v3.ListUptimeCheckIpsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUptimeCheckIpsMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * The UptimeCheckService API is used to manage (list, create, delete, edit)
   * Uptime check configurations in the Stackdriver Monitoring product. An Uptime
   * check is a piece of configuration that determines which resources and
   * services to monitor for availability. These configurations can also be
   * configured interactively by navigating to the [Cloud Console]
   * (http://console.cloud.google.com), selecting the appropriate project,
   * clicking on "Monitoring" on the left-hand side to navigate to Stackdriver,
   * and then clicking on "Uptime".
   * </pre>
   */
  public static final class UptimeCheckServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<UptimeCheckServiceFutureStub> {
    private UptimeCheckServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UptimeCheckServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UptimeCheckServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the existing valid Uptime check configurations for the project
     * (leaving out any invalid configurations).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.monitoring.v3.ListUptimeCheckConfigsResponse>
        listUptimeCheckConfigs(com.google.monitoring.v3.ListUptimeCheckConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListUptimeCheckConfigsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a single Uptime check configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.monitoring.v3.UptimeCheckConfig>
        getUptimeCheckConfig(com.google.monitoring.v3.GetUptimeCheckConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUptimeCheckConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Uptime check configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.monitoring.v3.UptimeCheckConfig>
        createUptimeCheckConfig(com.google.monitoring.v3.CreateUptimeCheckConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateUptimeCheckConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an Uptime check configuration. You can either replace the entire
     * configuration with a new one or replace only certain fields in the current
     * configuration by specifying the fields to be updated via `updateMask`.
     * Returns the updated configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.monitoring.v3.UptimeCheckConfig>
        updateUptimeCheckConfig(com.google.monitoring.v3.UpdateUptimeCheckConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateUptimeCheckConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Uptime check configuration. Note that this method will fail
     * if the Uptime check configuration is referenced by an alert policy or
     * other dependent configs that would be rendered invalid by the deletion.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteUptimeCheckConfig(com.google.monitoring.v3.DeleteUptimeCheckConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteUptimeCheckConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of IP addresses that checkers run from
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.monitoring.v3.ListUptimeCheckIpsResponse>
        listUptimeCheckIps(com.google.monitoring.v3.ListUptimeCheckIpsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListUptimeCheckIpsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_UPTIME_CHECK_CONFIGS = 0;
  private static final int METHODID_GET_UPTIME_CHECK_CONFIG = 1;
  private static final int METHODID_CREATE_UPTIME_CHECK_CONFIG = 2;
  private static final int METHODID_UPDATE_UPTIME_CHECK_CONFIG = 3;
  private static final int METHODID_DELETE_UPTIME_CHECK_CONFIG = 4;
  private static final int METHODID_LIST_UPTIME_CHECK_IPS = 5;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UptimeCheckServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UptimeCheckServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_UPTIME_CHECK_CONFIGS:
          serviceImpl.listUptimeCheckConfigs(
              (com.google.monitoring.v3.ListUptimeCheckConfigsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.ListUptimeCheckConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_UPTIME_CHECK_CONFIG:
          serviceImpl.getUptimeCheckConfig(
              (com.google.monitoring.v3.GetUptimeCheckConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.UptimeCheckConfig>)
                  responseObserver);
          break;
        case METHODID_CREATE_UPTIME_CHECK_CONFIG:
          serviceImpl.createUptimeCheckConfig(
              (com.google.monitoring.v3.CreateUptimeCheckConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.UptimeCheckConfig>)
                  responseObserver);
          break;
        case METHODID_UPDATE_UPTIME_CHECK_CONFIG:
          serviceImpl.updateUptimeCheckConfig(
              (com.google.monitoring.v3.UpdateUptimeCheckConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.UptimeCheckConfig>)
                  responseObserver);
          break;
        case METHODID_DELETE_UPTIME_CHECK_CONFIG:
          serviceImpl.deleteUptimeCheckConfig(
              (com.google.monitoring.v3.DeleteUptimeCheckConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_UPTIME_CHECK_IPS:
          serviceImpl.listUptimeCheckIps(
              (com.google.monitoring.v3.ListUptimeCheckIpsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.ListUptimeCheckIpsResponse>)
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

  private abstract static class UptimeCheckServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UptimeCheckServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.monitoring.v3.UptimeServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UptimeCheckService");
    }
  }

  private static final class UptimeCheckServiceFileDescriptorSupplier
      extends UptimeCheckServiceBaseDescriptorSupplier {
    UptimeCheckServiceFileDescriptorSupplier() {}
  }

  private static final class UptimeCheckServiceMethodDescriptorSupplier
      extends UptimeCheckServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UptimeCheckServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (UptimeCheckServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new UptimeCheckServiceFileDescriptorSupplier())
                      .addMethod(getListUptimeCheckConfigsMethod())
                      .addMethod(getGetUptimeCheckConfigMethod())
                      .addMethod(getCreateUptimeCheckConfigMethod())
                      .addMethod(getUpdateUptimeCheckConfigMethod())
                      .addMethod(getDeleteUptimeCheckConfigMethod())
                      .addMethod(getListUptimeCheckIpsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
