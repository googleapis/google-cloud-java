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
package com.google.cloud.developerconnect.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Creates and manages InsightsConfigs.
 * The InsightsConfig resource is the core configuration object to capture
 * events from your Software Development Lifecycle. It acts as the central hub
 * for managing how Developer connect understands your application, its runtime
 * environments, and the artifacts deployed within them.
 * A user can create an InsightsConfig, list previously-requested
 * InsightsConfigs or get InsightsConfigs by their ID to determine the status of
 * the InsightsConfig.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/developerconnect/v1/insights_config.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class InsightsConfigServiceGrpc {

  private InsightsConfigServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.developerconnect.v1.InsightsConfigService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.ListInsightsConfigsRequest,
          com.google.cloud.developerconnect.v1.ListInsightsConfigsResponse>
      getListInsightsConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInsightsConfigs",
      requestType = com.google.cloud.developerconnect.v1.ListInsightsConfigsRequest.class,
      responseType = com.google.cloud.developerconnect.v1.ListInsightsConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.ListInsightsConfigsRequest,
          com.google.cloud.developerconnect.v1.ListInsightsConfigsResponse>
      getListInsightsConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.developerconnect.v1.ListInsightsConfigsRequest,
            com.google.cloud.developerconnect.v1.ListInsightsConfigsResponse>
        getListInsightsConfigsMethod;
    if ((getListInsightsConfigsMethod = InsightsConfigServiceGrpc.getListInsightsConfigsMethod)
        == null) {
      synchronized (InsightsConfigServiceGrpc.class) {
        if ((getListInsightsConfigsMethod = InsightsConfigServiceGrpc.getListInsightsConfigsMethod)
            == null) {
          InsightsConfigServiceGrpc.getListInsightsConfigsMethod =
              getListInsightsConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.developerconnect.v1.ListInsightsConfigsRequest,
                          com.google.cloud.developerconnect.v1.ListInsightsConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListInsightsConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.developerconnect.v1.ListInsightsConfigsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.developerconnect.v1.ListInsightsConfigsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new InsightsConfigServiceMethodDescriptorSupplier("ListInsightsConfigs"))
                      .build();
        }
      }
    }
    return getListInsightsConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.CreateInsightsConfigRequest,
          com.google.longrunning.Operation>
      getCreateInsightsConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateInsightsConfig",
      requestType = com.google.cloud.developerconnect.v1.CreateInsightsConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.CreateInsightsConfigRequest,
          com.google.longrunning.Operation>
      getCreateInsightsConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.developerconnect.v1.CreateInsightsConfigRequest,
            com.google.longrunning.Operation>
        getCreateInsightsConfigMethod;
    if ((getCreateInsightsConfigMethod = InsightsConfigServiceGrpc.getCreateInsightsConfigMethod)
        == null) {
      synchronized (InsightsConfigServiceGrpc.class) {
        if ((getCreateInsightsConfigMethod =
                InsightsConfigServiceGrpc.getCreateInsightsConfigMethod)
            == null) {
          InsightsConfigServiceGrpc.getCreateInsightsConfigMethod =
              getCreateInsightsConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.developerconnect.v1.CreateInsightsConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateInsightsConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.developerconnect.v1.CreateInsightsConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new InsightsConfigServiceMethodDescriptorSupplier("CreateInsightsConfig"))
                      .build();
        }
      }
    }
    return getCreateInsightsConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.GetInsightsConfigRequest,
          com.google.cloud.developerconnect.v1.InsightsConfig>
      getGetInsightsConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInsightsConfig",
      requestType = com.google.cloud.developerconnect.v1.GetInsightsConfigRequest.class,
      responseType = com.google.cloud.developerconnect.v1.InsightsConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.GetInsightsConfigRequest,
          com.google.cloud.developerconnect.v1.InsightsConfig>
      getGetInsightsConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.developerconnect.v1.GetInsightsConfigRequest,
            com.google.cloud.developerconnect.v1.InsightsConfig>
        getGetInsightsConfigMethod;
    if ((getGetInsightsConfigMethod = InsightsConfigServiceGrpc.getGetInsightsConfigMethod)
        == null) {
      synchronized (InsightsConfigServiceGrpc.class) {
        if ((getGetInsightsConfigMethod = InsightsConfigServiceGrpc.getGetInsightsConfigMethod)
            == null) {
          InsightsConfigServiceGrpc.getGetInsightsConfigMethod =
              getGetInsightsConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.developerconnect.v1.GetInsightsConfigRequest,
                          com.google.cloud.developerconnect.v1.InsightsConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInsightsConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.developerconnect.v1.GetInsightsConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.developerconnect.v1.InsightsConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new InsightsConfigServiceMethodDescriptorSupplier("GetInsightsConfig"))
                      .build();
        }
      }
    }
    return getGetInsightsConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.UpdateInsightsConfigRequest,
          com.google.longrunning.Operation>
      getUpdateInsightsConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateInsightsConfig",
      requestType = com.google.cloud.developerconnect.v1.UpdateInsightsConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.UpdateInsightsConfigRequest,
          com.google.longrunning.Operation>
      getUpdateInsightsConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.developerconnect.v1.UpdateInsightsConfigRequest,
            com.google.longrunning.Operation>
        getUpdateInsightsConfigMethod;
    if ((getUpdateInsightsConfigMethod = InsightsConfigServiceGrpc.getUpdateInsightsConfigMethod)
        == null) {
      synchronized (InsightsConfigServiceGrpc.class) {
        if ((getUpdateInsightsConfigMethod =
                InsightsConfigServiceGrpc.getUpdateInsightsConfigMethod)
            == null) {
          InsightsConfigServiceGrpc.getUpdateInsightsConfigMethod =
              getUpdateInsightsConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.developerconnect.v1.UpdateInsightsConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateInsightsConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.developerconnect.v1.UpdateInsightsConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new InsightsConfigServiceMethodDescriptorSupplier("UpdateInsightsConfig"))
                      .build();
        }
      }
    }
    return getUpdateInsightsConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.DeleteInsightsConfigRequest,
          com.google.longrunning.Operation>
      getDeleteInsightsConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteInsightsConfig",
      requestType = com.google.cloud.developerconnect.v1.DeleteInsightsConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.DeleteInsightsConfigRequest,
          com.google.longrunning.Operation>
      getDeleteInsightsConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.developerconnect.v1.DeleteInsightsConfigRequest,
            com.google.longrunning.Operation>
        getDeleteInsightsConfigMethod;
    if ((getDeleteInsightsConfigMethod = InsightsConfigServiceGrpc.getDeleteInsightsConfigMethod)
        == null) {
      synchronized (InsightsConfigServiceGrpc.class) {
        if ((getDeleteInsightsConfigMethod =
                InsightsConfigServiceGrpc.getDeleteInsightsConfigMethod)
            == null) {
          InsightsConfigServiceGrpc.getDeleteInsightsConfigMethod =
              getDeleteInsightsConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.developerconnect.v1.DeleteInsightsConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteInsightsConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.developerconnect.v1.DeleteInsightsConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new InsightsConfigServiceMethodDescriptorSupplier("DeleteInsightsConfig"))
                      .build();
        }
      }
    }
    return getDeleteInsightsConfigMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static InsightsConfigServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InsightsConfigServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<InsightsConfigServiceStub>() {
          @java.lang.Override
          public InsightsConfigServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new InsightsConfigServiceStub(channel, callOptions);
          }
        };
    return InsightsConfigServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static InsightsConfigServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InsightsConfigServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<InsightsConfigServiceBlockingV2Stub>() {
          @java.lang.Override
          public InsightsConfigServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new InsightsConfigServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return InsightsConfigServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static InsightsConfigServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InsightsConfigServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<InsightsConfigServiceBlockingStub>() {
          @java.lang.Override
          public InsightsConfigServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new InsightsConfigServiceBlockingStub(channel, callOptions);
          }
        };
    return InsightsConfigServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static InsightsConfigServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InsightsConfigServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<InsightsConfigServiceFutureStub>() {
          @java.lang.Override
          public InsightsConfigServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new InsightsConfigServiceFutureStub(channel, callOptions);
          }
        };
    return InsightsConfigServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Creates and manages InsightsConfigs.
   * The InsightsConfig resource is the core configuration object to capture
   * events from your Software Development Lifecycle. It acts as the central hub
   * for managing how Developer connect understands your application, its runtime
   * environments, and the artifacts deployed within them.
   * A user can create an InsightsConfig, list previously-requested
   * InsightsConfigs or get InsightsConfigs by their ID to determine the status of
   * the InsightsConfig.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists InsightsConfigs in a given project and location.
     * </pre>
     */
    default void listInsightsConfigs(
        com.google.cloud.developerconnect.v1.ListInsightsConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.developerconnect.v1.ListInsightsConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListInsightsConfigsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new InsightsConfig in a given project and location.
     * </pre>
     */
    default void createInsightsConfig(
        com.google.cloud.developerconnect.v1.CreateInsightsConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateInsightsConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Insight.
     * </pre>
     */
    default void getInsightsConfig(
        com.google.cloud.developerconnect.v1.GetInsightsConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.developerconnect.v1.InsightsConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetInsightsConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single InsightsConfig.
     * </pre>
     */
    default void updateInsightsConfig(
        com.google.cloud.developerconnect.v1.UpdateInsightsConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateInsightsConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single Insight.
     * </pre>
     */
    default void deleteInsightsConfig(
        com.google.cloud.developerconnect.v1.DeleteInsightsConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteInsightsConfigMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service InsightsConfigService.
   *
   * <pre>
   * Creates and manages InsightsConfigs.
   * The InsightsConfig resource is the core configuration object to capture
   * events from your Software Development Lifecycle. It acts as the central hub
   * for managing how Developer connect understands your application, its runtime
   * environments, and the artifacts deployed within them.
   * A user can create an InsightsConfig, list previously-requested
   * InsightsConfigs or get InsightsConfigs by their ID to determine the status of
   * the InsightsConfig.
   * </pre>
   */
  public abstract static class InsightsConfigServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return InsightsConfigServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service InsightsConfigService.
   *
   * <pre>
   * Creates and manages InsightsConfigs.
   * The InsightsConfig resource is the core configuration object to capture
   * events from your Software Development Lifecycle. It acts as the central hub
   * for managing how Developer connect understands your application, its runtime
   * environments, and the artifacts deployed within them.
   * A user can create an InsightsConfig, list previously-requested
   * InsightsConfigs or get InsightsConfigs by their ID to determine the status of
   * the InsightsConfig.
   * </pre>
   */
  public static final class InsightsConfigServiceStub
      extends io.grpc.stub.AbstractAsyncStub<InsightsConfigServiceStub> {
    private InsightsConfigServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InsightsConfigServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InsightsConfigServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists InsightsConfigs in a given project and location.
     * </pre>
     */
    public void listInsightsConfigs(
        com.google.cloud.developerconnect.v1.ListInsightsConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.developerconnect.v1.ListInsightsConfigsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListInsightsConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new InsightsConfig in a given project and location.
     * </pre>
     */
    public void createInsightsConfig(
        com.google.cloud.developerconnect.v1.CreateInsightsConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateInsightsConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Insight.
     * </pre>
     */
    public void getInsightsConfig(
        com.google.cloud.developerconnect.v1.GetInsightsConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.developerconnect.v1.InsightsConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInsightsConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single InsightsConfig.
     * </pre>
     */
    public void updateInsightsConfig(
        com.google.cloud.developerconnect.v1.UpdateInsightsConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateInsightsConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single Insight.
     * </pre>
     */
    public void deleteInsightsConfig(
        com.google.cloud.developerconnect.v1.DeleteInsightsConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteInsightsConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service InsightsConfigService.
   *
   * <pre>
   * Creates and manages InsightsConfigs.
   * The InsightsConfig resource is the core configuration object to capture
   * events from your Software Development Lifecycle. It acts as the central hub
   * for managing how Developer connect understands your application, its runtime
   * environments, and the artifacts deployed within them.
   * A user can create an InsightsConfig, list previously-requested
   * InsightsConfigs or get InsightsConfigs by their ID to determine the status of
   * the InsightsConfig.
   * </pre>
   */
  public static final class InsightsConfigServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<InsightsConfigServiceBlockingV2Stub> {
    private InsightsConfigServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InsightsConfigServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InsightsConfigServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists InsightsConfigs in a given project and location.
     * </pre>
     */
    public com.google.cloud.developerconnect.v1.ListInsightsConfigsResponse listInsightsConfigs(
        com.google.cloud.developerconnect.v1.ListInsightsConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInsightsConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new InsightsConfig in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createInsightsConfig(
        com.google.cloud.developerconnect.v1.CreateInsightsConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateInsightsConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Insight.
     * </pre>
     */
    public com.google.cloud.developerconnect.v1.InsightsConfig getInsightsConfig(
        com.google.cloud.developerconnect.v1.GetInsightsConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInsightsConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single InsightsConfig.
     * </pre>
     */
    public com.google.longrunning.Operation updateInsightsConfig(
        com.google.cloud.developerconnect.v1.UpdateInsightsConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateInsightsConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single Insight.
     * </pre>
     */
    public com.google.longrunning.Operation deleteInsightsConfig(
        com.google.cloud.developerconnect.v1.DeleteInsightsConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteInsightsConfigMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service InsightsConfigService.
   *
   * <pre>
   * Creates and manages InsightsConfigs.
   * The InsightsConfig resource is the core configuration object to capture
   * events from your Software Development Lifecycle. It acts as the central hub
   * for managing how Developer connect understands your application, its runtime
   * environments, and the artifacts deployed within them.
   * A user can create an InsightsConfig, list previously-requested
   * InsightsConfigs or get InsightsConfigs by their ID to determine the status of
   * the InsightsConfig.
   * </pre>
   */
  public static final class InsightsConfigServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<InsightsConfigServiceBlockingStub> {
    private InsightsConfigServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InsightsConfigServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InsightsConfigServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists InsightsConfigs in a given project and location.
     * </pre>
     */
    public com.google.cloud.developerconnect.v1.ListInsightsConfigsResponse listInsightsConfigs(
        com.google.cloud.developerconnect.v1.ListInsightsConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInsightsConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new InsightsConfig in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createInsightsConfig(
        com.google.cloud.developerconnect.v1.CreateInsightsConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateInsightsConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Insight.
     * </pre>
     */
    public com.google.cloud.developerconnect.v1.InsightsConfig getInsightsConfig(
        com.google.cloud.developerconnect.v1.GetInsightsConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInsightsConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single InsightsConfig.
     * </pre>
     */
    public com.google.longrunning.Operation updateInsightsConfig(
        com.google.cloud.developerconnect.v1.UpdateInsightsConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateInsightsConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single Insight.
     * </pre>
     */
    public com.google.longrunning.Operation deleteInsightsConfig(
        com.google.cloud.developerconnect.v1.DeleteInsightsConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteInsightsConfigMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * InsightsConfigService.
   *
   * <pre>
   * Creates and manages InsightsConfigs.
   * The InsightsConfig resource is the core configuration object to capture
   * events from your Software Development Lifecycle. It acts as the central hub
   * for managing how Developer connect understands your application, its runtime
   * environments, and the artifacts deployed within them.
   * A user can create an InsightsConfig, list previously-requested
   * InsightsConfigs or get InsightsConfigs by their ID to determine the status of
   * the InsightsConfig.
   * </pre>
   */
  public static final class InsightsConfigServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<InsightsConfigServiceFutureStub> {
    private InsightsConfigServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InsightsConfigServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InsightsConfigServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists InsightsConfigs in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.developerconnect.v1.ListInsightsConfigsResponse>
        listInsightsConfigs(
            com.google.cloud.developerconnect.v1.ListInsightsConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListInsightsConfigsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new InsightsConfig in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createInsightsConfig(
            com.google.cloud.developerconnect.v1.CreateInsightsConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateInsightsConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Insight.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.developerconnect.v1.InsightsConfig>
        getInsightsConfig(com.google.cloud.developerconnect.v1.GetInsightsConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInsightsConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single InsightsConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateInsightsConfig(
            com.google.cloud.developerconnect.v1.UpdateInsightsConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateInsightsConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single Insight.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteInsightsConfig(
            com.google.cloud.developerconnect.v1.DeleteInsightsConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteInsightsConfigMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_INSIGHTS_CONFIGS = 0;
  private static final int METHODID_CREATE_INSIGHTS_CONFIG = 1;
  private static final int METHODID_GET_INSIGHTS_CONFIG = 2;
  private static final int METHODID_UPDATE_INSIGHTS_CONFIG = 3;
  private static final int METHODID_DELETE_INSIGHTS_CONFIG = 4;

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
        case METHODID_LIST_INSIGHTS_CONFIGS:
          serviceImpl.listInsightsConfigs(
              (com.google.cloud.developerconnect.v1.ListInsightsConfigsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.developerconnect.v1.ListInsightsConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_INSIGHTS_CONFIG:
          serviceImpl.createInsightsConfig(
              (com.google.cloud.developerconnect.v1.CreateInsightsConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_INSIGHTS_CONFIG:
          serviceImpl.getInsightsConfig(
              (com.google.cloud.developerconnect.v1.GetInsightsConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.developerconnect.v1.InsightsConfig>)
                  responseObserver);
          break;
        case METHODID_UPDATE_INSIGHTS_CONFIG:
          serviceImpl.updateInsightsConfig(
              (com.google.cloud.developerconnect.v1.UpdateInsightsConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_INSIGHTS_CONFIG:
          serviceImpl.deleteInsightsConfig(
              (com.google.cloud.developerconnect.v1.DeleteInsightsConfigRequest) request,
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
            getListInsightsConfigsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.developerconnect.v1.ListInsightsConfigsRequest,
                    com.google.cloud.developerconnect.v1.ListInsightsConfigsResponse>(
                    service, METHODID_LIST_INSIGHTS_CONFIGS)))
        .addMethod(
            getCreateInsightsConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.developerconnect.v1.CreateInsightsConfigRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_INSIGHTS_CONFIG)))
        .addMethod(
            getGetInsightsConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.developerconnect.v1.GetInsightsConfigRequest,
                    com.google.cloud.developerconnect.v1.InsightsConfig>(
                    service, METHODID_GET_INSIGHTS_CONFIG)))
        .addMethod(
            getUpdateInsightsConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.developerconnect.v1.UpdateInsightsConfigRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_INSIGHTS_CONFIG)))
        .addMethod(
            getDeleteInsightsConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.developerconnect.v1.DeleteInsightsConfigRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_INSIGHTS_CONFIG)))
        .build();
  }

  private abstract static class InsightsConfigServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    InsightsConfigServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.developerconnect.v1.InsightsConfigProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("InsightsConfigService");
    }
  }

  private static final class InsightsConfigServiceFileDescriptorSupplier
      extends InsightsConfigServiceBaseDescriptorSupplier {
    InsightsConfigServiceFileDescriptorSupplier() {}
  }

  private static final class InsightsConfigServiceMethodDescriptorSupplier
      extends InsightsConfigServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    InsightsConfigServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (InsightsConfigServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new InsightsConfigServiceFileDescriptorSupplier())
                      .addMethod(getListInsightsConfigsMethod())
                      .addMethod(getCreateInsightsConfigMethod())
                      .addMethod(getGetInsightsConfigMethod())
                      .addMethod(getUpdateInsightsConfigMethod())
                      .addMethod(getDeleteInsightsConfigMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
