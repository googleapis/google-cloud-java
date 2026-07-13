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
package com.google.cloud.discoveryengine.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing license config related resources.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class LicenseConfigServiceGrpc {

  private LicenseConfigServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.discoveryengine.v1beta.LicenseConfigService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.CreateLicenseConfigRequest,
          com.google.cloud.discoveryengine.v1beta.LicenseConfig>
      getCreateLicenseConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateLicenseConfig",
      requestType = com.google.cloud.discoveryengine.v1beta.CreateLicenseConfigRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.LicenseConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.CreateLicenseConfigRequest,
          com.google.cloud.discoveryengine.v1beta.LicenseConfig>
      getCreateLicenseConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.CreateLicenseConfigRequest,
            com.google.cloud.discoveryengine.v1beta.LicenseConfig>
        getCreateLicenseConfigMethod;
    if ((getCreateLicenseConfigMethod = LicenseConfigServiceGrpc.getCreateLicenseConfigMethod)
        == null) {
      synchronized (LicenseConfigServiceGrpc.class) {
        if ((getCreateLicenseConfigMethod = LicenseConfigServiceGrpc.getCreateLicenseConfigMethod)
            == null) {
          LicenseConfigServiceGrpc.getCreateLicenseConfigMethod =
              getCreateLicenseConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.CreateLicenseConfigRequest,
                          com.google.cloud.discoveryengine.v1beta.LicenseConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateLicenseConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.CreateLicenseConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.LicenseConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LicenseConfigServiceMethodDescriptorSupplier("CreateLicenseConfig"))
                      .build();
        }
      }
    }
    return getCreateLicenseConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.UpdateLicenseConfigRequest,
          com.google.cloud.discoveryengine.v1beta.LicenseConfig>
      getUpdateLicenseConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateLicenseConfig",
      requestType = com.google.cloud.discoveryengine.v1beta.UpdateLicenseConfigRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.LicenseConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.UpdateLicenseConfigRequest,
          com.google.cloud.discoveryengine.v1beta.LicenseConfig>
      getUpdateLicenseConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.UpdateLicenseConfigRequest,
            com.google.cloud.discoveryengine.v1beta.LicenseConfig>
        getUpdateLicenseConfigMethod;
    if ((getUpdateLicenseConfigMethod = LicenseConfigServiceGrpc.getUpdateLicenseConfigMethod)
        == null) {
      synchronized (LicenseConfigServiceGrpc.class) {
        if ((getUpdateLicenseConfigMethod = LicenseConfigServiceGrpc.getUpdateLicenseConfigMethod)
            == null) {
          LicenseConfigServiceGrpc.getUpdateLicenseConfigMethod =
              getUpdateLicenseConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.UpdateLicenseConfigRequest,
                          com.google.cloud.discoveryengine.v1beta.LicenseConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateLicenseConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.UpdateLicenseConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.LicenseConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LicenseConfigServiceMethodDescriptorSupplier("UpdateLicenseConfig"))
                      .build();
        }
      }
    }
    return getUpdateLicenseConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.GetLicenseConfigRequest,
          com.google.cloud.discoveryengine.v1beta.LicenseConfig>
      getGetLicenseConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLicenseConfig",
      requestType = com.google.cloud.discoveryengine.v1beta.GetLicenseConfigRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.LicenseConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.GetLicenseConfigRequest,
          com.google.cloud.discoveryengine.v1beta.LicenseConfig>
      getGetLicenseConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.GetLicenseConfigRequest,
            com.google.cloud.discoveryengine.v1beta.LicenseConfig>
        getGetLicenseConfigMethod;
    if ((getGetLicenseConfigMethod = LicenseConfigServiceGrpc.getGetLicenseConfigMethod) == null) {
      synchronized (LicenseConfigServiceGrpc.class) {
        if ((getGetLicenseConfigMethod = LicenseConfigServiceGrpc.getGetLicenseConfigMethod)
            == null) {
          LicenseConfigServiceGrpc.getGetLicenseConfigMethod =
              getGetLicenseConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.GetLicenseConfigRequest,
                          com.google.cloud.discoveryengine.v1beta.LicenseConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLicenseConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.GetLicenseConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.LicenseConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LicenseConfigServiceMethodDescriptorSupplier("GetLicenseConfig"))
                      .build();
        }
      }
    }
    return getGetLicenseConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.ListLicenseConfigsRequest,
          com.google.cloud.discoveryengine.v1beta.ListLicenseConfigsResponse>
      getListLicenseConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListLicenseConfigs",
      requestType = com.google.cloud.discoveryengine.v1beta.ListLicenseConfigsRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.ListLicenseConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.ListLicenseConfigsRequest,
          com.google.cloud.discoveryengine.v1beta.ListLicenseConfigsResponse>
      getListLicenseConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.ListLicenseConfigsRequest,
            com.google.cloud.discoveryengine.v1beta.ListLicenseConfigsResponse>
        getListLicenseConfigsMethod;
    if ((getListLicenseConfigsMethod = LicenseConfigServiceGrpc.getListLicenseConfigsMethod)
        == null) {
      synchronized (LicenseConfigServiceGrpc.class) {
        if ((getListLicenseConfigsMethod = LicenseConfigServiceGrpc.getListLicenseConfigsMethod)
            == null) {
          LicenseConfigServiceGrpc.getListLicenseConfigsMethod =
              getListLicenseConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.ListLicenseConfigsRequest,
                          com.google.cloud.discoveryengine.v1beta.ListLicenseConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListLicenseConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.ListLicenseConfigsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.ListLicenseConfigsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LicenseConfigServiceMethodDescriptorSupplier("ListLicenseConfigs"))
                      .build();
        }
      }
    }
    return getListLicenseConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.DistributeLicenseConfigRequest,
          com.google.cloud.discoveryengine.v1beta.DistributeLicenseConfigResponse>
      getDistributeLicenseConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DistributeLicenseConfig",
      requestType = com.google.cloud.discoveryengine.v1beta.DistributeLicenseConfigRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.DistributeLicenseConfigResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.DistributeLicenseConfigRequest,
          com.google.cloud.discoveryengine.v1beta.DistributeLicenseConfigResponse>
      getDistributeLicenseConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.DistributeLicenseConfigRequest,
            com.google.cloud.discoveryengine.v1beta.DistributeLicenseConfigResponse>
        getDistributeLicenseConfigMethod;
    if ((getDistributeLicenseConfigMethod =
            LicenseConfigServiceGrpc.getDistributeLicenseConfigMethod)
        == null) {
      synchronized (LicenseConfigServiceGrpc.class) {
        if ((getDistributeLicenseConfigMethod =
                LicenseConfigServiceGrpc.getDistributeLicenseConfigMethod)
            == null) {
          LicenseConfigServiceGrpc.getDistributeLicenseConfigMethod =
              getDistributeLicenseConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.DistributeLicenseConfigRequest,
                          com.google.cloud.discoveryengine.v1beta.DistributeLicenseConfigResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DistributeLicenseConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.DistributeLicenseConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta
                                  .DistributeLicenseConfigResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LicenseConfigServiceMethodDescriptorSupplier(
                              "DistributeLicenseConfig"))
                      .build();
        }
      }
    }
    return getDistributeLicenseConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigRequest,
          com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigResponse>
      getRetractLicenseConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RetractLicenseConfig",
      requestType = com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigRequest,
          com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigResponse>
      getRetractLicenseConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigRequest,
            com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigResponse>
        getRetractLicenseConfigMethod;
    if ((getRetractLicenseConfigMethod = LicenseConfigServiceGrpc.getRetractLicenseConfigMethod)
        == null) {
      synchronized (LicenseConfigServiceGrpc.class) {
        if ((getRetractLicenseConfigMethod = LicenseConfigServiceGrpc.getRetractLicenseConfigMethod)
            == null) {
          LicenseConfigServiceGrpc.getRetractLicenseConfigMethod =
              getRetractLicenseConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigRequest,
                          com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RetractLicenseConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LicenseConfigServiceMethodDescriptorSupplier("RetractLicenseConfig"))
                      .build();
        }
      }
    }
    return getRetractLicenseConfigMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static LicenseConfigServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LicenseConfigServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LicenseConfigServiceStub>() {
          @java.lang.Override
          public LicenseConfigServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LicenseConfigServiceStub(channel, callOptions);
          }
        };
    return LicenseConfigServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static LicenseConfigServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LicenseConfigServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LicenseConfigServiceBlockingV2Stub>() {
          @java.lang.Override
          public LicenseConfigServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LicenseConfigServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return LicenseConfigServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LicenseConfigServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LicenseConfigServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LicenseConfigServiceBlockingStub>() {
          @java.lang.Override
          public LicenseConfigServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LicenseConfigServiceBlockingStub(channel, callOptions);
          }
        };
    return LicenseConfigServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static LicenseConfigServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LicenseConfigServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LicenseConfigServiceFutureStub>() {
          @java.lang.Override
          public LicenseConfigServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LicenseConfigServiceFutureStub(channel, callOptions);
          }
        };
    return LicenseConfigServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing license config related resources.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a
     * [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] This
     * method should only be used for creating NotebookLm licenses or Gemini
     * Enterprise free trial licenses.
     * </pre>
     */
    default void createLicenseConfig(
        com.google.cloud.discoveryengine.v1beta.CreateLicenseConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.LicenseConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateLicenseConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the
     * [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig]
     * </pre>
     */
    default void updateLicenseConfig(
        com.google.cloud.discoveryengine.v1beta.UpdateLicenseConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.LicenseConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateLicenseConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig].
     * </pre>
     */
    default void getLicenseConfig(
        com.google.cloud.discoveryengine.v1beta.GetLicenseConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.LicenseConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetLicenseConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the
     * [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig]s
     * associated with the project.
     * </pre>
     */
    default void listLicenseConfigs(
        com.google.cloud.discoveryengine.v1beta.ListLicenseConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.discoveryengine.v1beta.ListLicenseConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListLicenseConfigsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Distributes a
     * [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] from
     * billing account level to project level.
     * </pre>
     */
    default void distributeLicenseConfig(
        com.google.cloud.discoveryengine.v1beta.DistributeLicenseConfigRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.discoveryengine.v1beta.DistributeLicenseConfigResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDistributeLicenseConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * This method is called from the billing account side to retract the
     * [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] from the
     * given project back to the billing account.
     * </pre>
     */
    default void retractLicenseConfig(
        com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRetractLicenseConfigMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service LicenseConfigService.
   *
   * <pre>
   * Service for managing license config related resources.
   * </pre>
   */
  public abstract static class LicenseConfigServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return LicenseConfigServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service LicenseConfigService.
   *
   * <pre>
   * Service for managing license config related resources.
   * </pre>
   */
  public static final class LicenseConfigServiceStub
      extends io.grpc.stub.AbstractAsyncStub<LicenseConfigServiceStub> {
    private LicenseConfigServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LicenseConfigServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LicenseConfigServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a
     * [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] This
     * method should only be used for creating NotebookLm licenses or Gemini
     * Enterprise free trial licenses.
     * </pre>
     */
    public void createLicenseConfig(
        com.google.cloud.discoveryengine.v1beta.CreateLicenseConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.LicenseConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateLicenseConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the
     * [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig]
     * </pre>
     */
    public void updateLicenseConfig(
        com.google.cloud.discoveryengine.v1beta.UpdateLicenseConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.LicenseConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateLicenseConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig].
     * </pre>
     */
    public void getLicenseConfig(
        com.google.cloud.discoveryengine.v1beta.GetLicenseConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.LicenseConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLicenseConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the
     * [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig]s
     * associated with the project.
     * </pre>
     */
    public void listLicenseConfigs(
        com.google.cloud.discoveryengine.v1beta.ListLicenseConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.discoveryengine.v1beta.ListLicenseConfigsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListLicenseConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Distributes a
     * [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] from
     * billing account level to project level.
     * </pre>
     */
    public void distributeLicenseConfig(
        com.google.cloud.discoveryengine.v1beta.DistributeLicenseConfigRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.discoveryengine.v1beta.DistributeLicenseConfigResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDistributeLicenseConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * This method is called from the billing account side to retract the
     * [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] from the
     * given project back to the billing account.
     * </pre>
     */
    public void retractLicenseConfig(
        com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRetractLicenseConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service LicenseConfigService.
   *
   * <pre>
   * Service for managing license config related resources.
   * </pre>
   */
  public static final class LicenseConfigServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<LicenseConfigServiceBlockingV2Stub> {
    private LicenseConfigServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LicenseConfigServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LicenseConfigServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a
     * [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] This
     * method should only be used for creating NotebookLm licenses or Gemini
     * Enterprise free trial licenses.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.LicenseConfig createLicenseConfig(
        com.google.cloud.discoveryengine.v1beta.CreateLicenseConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateLicenseConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the
     * [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig]
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.LicenseConfig updateLicenseConfig(
        com.google.cloud.discoveryengine.v1beta.UpdateLicenseConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateLicenseConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.LicenseConfig getLicenseConfig(
        com.google.cloud.discoveryengine.v1beta.GetLicenseConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetLicenseConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the
     * [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig]s
     * associated with the project.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.ListLicenseConfigsResponse listLicenseConfigs(
        com.google.cloud.discoveryengine.v1beta.ListLicenseConfigsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListLicenseConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Distributes a
     * [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] from
     * billing account level to project level.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.DistributeLicenseConfigResponse
        distributeLicenseConfig(
            com.google.cloud.discoveryengine.v1beta.DistributeLicenseConfigRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDistributeLicenseConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * This method is called from the billing account side to retract the
     * [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] from the
     * given project back to the billing account.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigResponse
        retractLicenseConfig(
            com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRetractLicenseConfigMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service LicenseConfigService.
   *
   * <pre>
   * Service for managing license config related resources.
   * </pre>
   */
  public static final class LicenseConfigServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LicenseConfigServiceBlockingStub> {
    private LicenseConfigServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LicenseConfigServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LicenseConfigServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a
     * [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] This
     * method should only be used for creating NotebookLm licenses or Gemini
     * Enterprise free trial licenses.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.LicenseConfig createLicenseConfig(
        com.google.cloud.discoveryengine.v1beta.CreateLicenseConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateLicenseConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the
     * [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig]
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.LicenseConfig updateLicenseConfig(
        com.google.cloud.discoveryengine.v1beta.UpdateLicenseConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateLicenseConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.LicenseConfig getLicenseConfig(
        com.google.cloud.discoveryengine.v1beta.GetLicenseConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLicenseConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the
     * [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig]s
     * associated with the project.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.ListLicenseConfigsResponse listLicenseConfigs(
        com.google.cloud.discoveryengine.v1beta.ListLicenseConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListLicenseConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Distributes a
     * [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] from
     * billing account level to project level.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.DistributeLicenseConfigResponse
        distributeLicenseConfig(
            com.google.cloud.discoveryengine.v1beta.DistributeLicenseConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDistributeLicenseConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * This method is called from the billing account side to retract the
     * [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] from the
     * given project back to the billing account.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigResponse
        retractLicenseConfig(
            com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRetractLicenseConfigMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service LicenseConfigService.
   *
   * <pre>
   * Service for managing license config related resources.
   * </pre>
   */
  public static final class LicenseConfigServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<LicenseConfigServiceFutureStub> {
    private LicenseConfigServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LicenseConfigServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LicenseConfigServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a
     * [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] This
     * method should only be used for creating NotebookLm licenses or Gemini
     * Enterprise free trial licenses.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.LicenseConfig>
        createLicenseConfig(
            com.google.cloud.discoveryengine.v1beta.CreateLicenseConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateLicenseConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the
     * [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig]
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.LicenseConfig>
        updateLicenseConfig(
            com.google.cloud.discoveryengine.v1beta.UpdateLicenseConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateLicenseConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.LicenseConfig>
        getLicenseConfig(com.google.cloud.discoveryengine.v1beta.GetLicenseConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLicenseConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the
     * [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig]s
     * associated with the project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.ListLicenseConfigsResponse>
        listLicenseConfigs(
            com.google.cloud.discoveryengine.v1beta.ListLicenseConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListLicenseConfigsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Distributes a
     * [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] from
     * billing account level to project level.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.DistributeLicenseConfigResponse>
        distributeLicenseConfig(
            com.google.cloud.discoveryengine.v1beta.DistributeLicenseConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDistributeLicenseConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * This method is called from the billing account side to retract the
     * [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] from the
     * given project back to the billing account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigResponse>
        retractLicenseConfig(
            com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRetractLicenseConfigMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_LICENSE_CONFIG = 0;
  private static final int METHODID_UPDATE_LICENSE_CONFIG = 1;
  private static final int METHODID_GET_LICENSE_CONFIG = 2;
  private static final int METHODID_LIST_LICENSE_CONFIGS = 3;
  private static final int METHODID_DISTRIBUTE_LICENSE_CONFIG = 4;
  private static final int METHODID_RETRACT_LICENSE_CONFIG = 5;

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
        case METHODID_CREATE_LICENSE_CONFIG:
          serviceImpl.createLicenseConfig(
              (com.google.cloud.discoveryengine.v1beta.CreateLicenseConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.LicenseConfig>)
                  responseObserver);
          break;
        case METHODID_UPDATE_LICENSE_CONFIG:
          serviceImpl.updateLicenseConfig(
              (com.google.cloud.discoveryengine.v1beta.UpdateLicenseConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.LicenseConfig>)
                  responseObserver);
          break;
        case METHODID_GET_LICENSE_CONFIG:
          serviceImpl.getLicenseConfig(
              (com.google.cloud.discoveryengine.v1beta.GetLicenseConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.LicenseConfig>)
                  responseObserver);
          break;
        case METHODID_LIST_LICENSE_CONFIGS:
          serviceImpl.listLicenseConfigs(
              (com.google.cloud.discoveryengine.v1beta.ListLicenseConfigsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.discoveryengine.v1beta.ListLicenseConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_DISTRIBUTE_LICENSE_CONFIG:
          serviceImpl.distributeLicenseConfig(
              (com.google.cloud.discoveryengine.v1beta.DistributeLicenseConfigRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.discoveryengine.v1beta.DistributeLicenseConfigResponse>)
                  responseObserver);
          break;
        case METHODID_RETRACT_LICENSE_CONFIG:
          serviceImpl.retractLicenseConfig(
              (com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigResponse>)
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
            getCreateLicenseConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.CreateLicenseConfigRequest,
                    com.google.cloud.discoveryengine.v1beta.LicenseConfig>(
                    service, METHODID_CREATE_LICENSE_CONFIG)))
        .addMethod(
            getUpdateLicenseConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.UpdateLicenseConfigRequest,
                    com.google.cloud.discoveryengine.v1beta.LicenseConfig>(
                    service, METHODID_UPDATE_LICENSE_CONFIG)))
        .addMethod(
            getGetLicenseConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.GetLicenseConfigRequest,
                    com.google.cloud.discoveryengine.v1beta.LicenseConfig>(
                    service, METHODID_GET_LICENSE_CONFIG)))
        .addMethod(
            getListLicenseConfigsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.ListLicenseConfigsRequest,
                    com.google.cloud.discoveryengine.v1beta.ListLicenseConfigsResponse>(
                    service, METHODID_LIST_LICENSE_CONFIGS)))
        .addMethod(
            getDistributeLicenseConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.DistributeLicenseConfigRequest,
                    com.google.cloud.discoveryengine.v1beta.DistributeLicenseConfigResponse>(
                    service, METHODID_DISTRIBUTE_LICENSE_CONFIG)))
        .addMethod(
            getRetractLicenseConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigRequest,
                    com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigResponse>(
                    service, METHODID_RETRACT_LICENSE_CONFIG)))
        .build();
  }

  private abstract static class LicenseConfigServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LicenseConfigServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1beta.LicenseConfigServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LicenseConfigService");
    }
  }

  private static final class LicenseConfigServiceFileDescriptorSupplier
      extends LicenseConfigServiceBaseDescriptorSupplier {
    LicenseConfigServiceFileDescriptorSupplier() {}
  }

  private static final class LicenseConfigServiceMethodDescriptorSupplier
      extends LicenseConfigServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    LicenseConfigServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (LicenseConfigServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new LicenseConfigServiceFileDescriptorSupplier())
                      .addMethod(getCreateLicenseConfigMethod())
                      .addMethod(getUpdateLicenseConfigMethod())
                      .addMethod(getGetLicenseConfigMethod())
                      .addMethod(getListLicenseConfigsMethod())
                      .addMethod(getDistributeLicenseConfigMethod())
                      .addMethod(getRetractLicenseConfigMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
