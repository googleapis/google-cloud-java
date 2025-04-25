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
package com.google.cloud.asset.v1p7beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Asset service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/asset/v1p7beta1/asset_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AssetServiceGrpc {

  private AssetServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.asset.v1p7beta1.AssetService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p7beta1.ExportAssetsRequest, com.google.longrunning.Operation>
      getExportAssetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportAssets",
      requestType = com.google.cloud.asset.v1p7beta1.ExportAssetsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p7beta1.ExportAssetsRequest, com.google.longrunning.Operation>
      getExportAssetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.asset.v1p7beta1.ExportAssetsRequest, com.google.longrunning.Operation>
        getExportAssetsMethod;
    if ((getExportAssetsMethod = AssetServiceGrpc.getExportAssetsMethod) == null) {
      synchronized (AssetServiceGrpc.class) {
        if ((getExportAssetsMethod = AssetServiceGrpc.getExportAssetsMethod) == null) {
          AssetServiceGrpc.getExportAssetsMethod =
              getExportAssetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.asset.v1p7beta1.ExportAssetsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportAssets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1p7beta1.ExportAssetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AssetServiceMethodDescriptorSupplier("ExportAssets"))
                      .build();
        }
      }
    }
    return getExportAssetsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AssetServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AssetServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AssetServiceStub>() {
          @java.lang.Override
          public AssetServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AssetServiceStub(channel, callOptions);
          }
        };
    return AssetServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AssetServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AssetServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AssetServiceBlockingStub>() {
          @java.lang.Override
          public AssetServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AssetServiceBlockingStub(channel, callOptions);
          }
        };
    return AssetServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AssetServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AssetServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AssetServiceFutureStub>() {
          @java.lang.Override
          public AssetServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AssetServiceFutureStub(channel, callOptions);
          }
        };
    return AssetServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Asset service definition.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Exports assets with time and resource types to a given Cloud Storage
     * location/BigQuery table. For Cloud Storage location destinations, the
     * output format is newline-delimited JSON. Each line represents a
     * [google.cloud.asset.v1p7beta1.Asset][google.cloud.asset.v1p7beta1.Asset] in
     * the JSON format; for BigQuery table destinations, the output table stores
     * the fields in asset proto as columns. This API implements the
     * [google.longrunning.Operation][google.longrunning.Operation] API , which
     * allows you to keep track of the export. We recommend intervals of at least
     * 2 seconds with exponential retry to poll the export operation result. For
     * regular-size resource parent, the export operation usually finishes within
     * 5 minutes.
     * </pre>
     */
    default void exportAssets(
        com.google.cloud.asset.v1p7beta1.ExportAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExportAssetsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AssetService.
   *
   * <pre>
   * Asset service definition.
   * </pre>
   */
  public abstract static class AssetServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AssetServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AssetService.
   *
   * <pre>
   * Asset service definition.
   * </pre>
   */
  public static final class AssetServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AssetServiceStub> {
    private AssetServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AssetServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AssetServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Exports assets with time and resource types to a given Cloud Storage
     * location/BigQuery table. For Cloud Storage location destinations, the
     * output format is newline-delimited JSON. Each line represents a
     * [google.cloud.asset.v1p7beta1.Asset][google.cloud.asset.v1p7beta1.Asset] in
     * the JSON format; for BigQuery table destinations, the output table stores
     * the fields in asset proto as columns. This API implements the
     * [google.longrunning.Operation][google.longrunning.Operation] API , which
     * allows you to keep track of the export. We recommend intervals of at least
     * 2 seconds with exponential retry to poll the export operation result. For
     * regular-size resource parent, the export operation usually finishes within
     * 5 minutes.
     * </pre>
     */
    public void exportAssets(
        com.google.cloud.asset.v1p7beta1.ExportAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportAssetsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AssetService.
   *
   * <pre>
   * Asset service definition.
   * </pre>
   */
  public static final class AssetServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AssetServiceBlockingStub> {
    private AssetServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AssetServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AssetServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Exports assets with time and resource types to a given Cloud Storage
     * location/BigQuery table. For Cloud Storage location destinations, the
     * output format is newline-delimited JSON. Each line represents a
     * [google.cloud.asset.v1p7beta1.Asset][google.cloud.asset.v1p7beta1.Asset] in
     * the JSON format; for BigQuery table destinations, the output table stores
     * the fields in asset proto as columns. This API implements the
     * [google.longrunning.Operation][google.longrunning.Operation] API , which
     * allows you to keep track of the export. We recommend intervals of at least
     * 2 seconds with exponential retry to poll the export operation result. For
     * regular-size resource parent, the export operation usually finishes within
     * 5 minutes.
     * </pre>
     */
    public com.google.longrunning.Operation exportAssets(
        com.google.cloud.asset.v1p7beta1.ExportAssetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportAssetsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AssetService.
   *
   * <pre>
   * Asset service definition.
   * </pre>
   */
  public static final class AssetServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AssetServiceFutureStub> {
    private AssetServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AssetServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AssetServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Exports assets with time and resource types to a given Cloud Storage
     * location/BigQuery table. For Cloud Storage location destinations, the
     * output format is newline-delimited JSON. Each line represents a
     * [google.cloud.asset.v1p7beta1.Asset][google.cloud.asset.v1p7beta1.Asset] in
     * the JSON format; for BigQuery table destinations, the output table stores
     * the fields in asset proto as columns. This API implements the
     * [google.longrunning.Operation][google.longrunning.Operation] API , which
     * allows you to keep track of the export. We recommend intervals of at least
     * 2 seconds with exponential retry to poll the export operation result. For
     * regular-size resource parent, the export operation usually finishes within
     * 5 minutes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportAssets(com.google.cloud.asset.v1p7beta1.ExportAssetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportAssetsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_EXPORT_ASSETS = 0;

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
        case METHODID_EXPORT_ASSETS:
          serviceImpl.exportAssets(
              (com.google.cloud.asset.v1p7beta1.ExportAssetsRequest) request,
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
            getExportAssetsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.asset.v1p7beta1.ExportAssetsRequest,
                    com.google.longrunning.Operation>(service, METHODID_EXPORT_ASSETS)))
        .build();
  }

  private abstract static class AssetServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AssetServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.asset.v1p7beta1.AssetServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AssetService");
    }
  }

  private static final class AssetServiceFileDescriptorSupplier
      extends AssetServiceBaseDescriptorSupplier {
    AssetServiceFileDescriptorSupplier() {}
  }

  private static final class AssetServiceMethodDescriptorSupplier
      extends AssetServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AssetServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AssetServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AssetServiceFileDescriptorSupplier())
                      .addMethod(getExportAssetsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
