package com.google.cloud.asset.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Asset service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/asset/v1beta1/asset_service.proto")
public final class AssetServiceGrpc {

  private AssetServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.asset.v1beta1.AssetService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getExportAssetsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.asset.v1beta1.ExportAssetsRequest,
      com.google.longrunning.Operation> METHOD_EXPORT_ASSETS = getExportAssetsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.asset.v1beta1.ExportAssetsRequest,
      com.google.longrunning.Operation> getExportAssetsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.asset.v1beta1.ExportAssetsRequest,
      com.google.longrunning.Operation> getExportAssetsMethod() {
    return getExportAssetsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.asset.v1beta1.ExportAssetsRequest,
      com.google.longrunning.Operation> getExportAssetsMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.asset.v1beta1.ExportAssetsRequest, com.google.longrunning.Operation> getExportAssetsMethod;
    if ((getExportAssetsMethod = AssetServiceGrpc.getExportAssetsMethod) == null) {
      synchronized (AssetServiceGrpc.class) {
        if ((getExportAssetsMethod = AssetServiceGrpc.getExportAssetsMethod) == null) {
          AssetServiceGrpc.getExportAssetsMethod = getExportAssetsMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.asset.v1beta1.ExportAssetsRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.asset.v1beta1.AssetService", "ExportAssets"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.asset.v1beta1.ExportAssetsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new AssetServiceMethodDescriptorSupplier("ExportAssets"))
                  .build();
          }
        }
     }
     return getExportAssetsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBatchGetAssetsHistoryMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.asset.v1beta1.BatchGetAssetsHistoryRequest,
      com.google.cloud.asset.v1beta1.BatchGetAssetsHistoryResponse> METHOD_BATCH_GET_ASSETS_HISTORY = getBatchGetAssetsHistoryMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.asset.v1beta1.BatchGetAssetsHistoryRequest,
      com.google.cloud.asset.v1beta1.BatchGetAssetsHistoryResponse> getBatchGetAssetsHistoryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.asset.v1beta1.BatchGetAssetsHistoryRequest,
      com.google.cloud.asset.v1beta1.BatchGetAssetsHistoryResponse> getBatchGetAssetsHistoryMethod() {
    return getBatchGetAssetsHistoryMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.asset.v1beta1.BatchGetAssetsHistoryRequest,
      com.google.cloud.asset.v1beta1.BatchGetAssetsHistoryResponse> getBatchGetAssetsHistoryMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.asset.v1beta1.BatchGetAssetsHistoryRequest, com.google.cloud.asset.v1beta1.BatchGetAssetsHistoryResponse> getBatchGetAssetsHistoryMethod;
    if ((getBatchGetAssetsHistoryMethod = AssetServiceGrpc.getBatchGetAssetsHistoryMethod) == null) {
      synchronized (AssetServiceGrpc.class) {
        if ((getBatchGetAssetsHistoryMethod = AssetServiceGrpc.getBatchGetAssetsHistoryMethod) == null) {
          AssetServiceGrpc.getBatchGetAssetsHistoryMethod = getBatchGetAssetsHistoryMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.asset.v1beta1.BatchGetAssetsHistoryRequest, com.google.cloud.asset.v1beta1.BatchGetAssetsHistoryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.asset.v1beta1.AssetService", "BatchGetAssetsHistory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.asset.v1beta1.BatchGetAssetsHistoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.asset.v1beta1.BatchGetAssetsHistoryResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AssetServiceMethodDescriptorSupplier("BatchGetAssetsHistory"))
                  .build();
          }
        }
     }
     return getBatchGetAssetsHistoryMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AssetServiceStub newStub(io.grpc.Channel channel) {
    return new AssetServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AssetServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AssetServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AssetServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AssetServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Asset service definition.
   * </pre>
   */
  public static abstract class AssetServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Exports assets with time and resource types to a given Google Cloud Storage
     * location. The output format is newline delimited JSON.
     * This API implements the [google.longrunning.Operation][google.longrunning.Operation] API allowing users
     * to keep track of the export.
     * </pre>
     */
    public void exportAssets(com.google.cloud.asset.v1beta1.ExportAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getExportAssetsMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Batch gets assets update history that overlaps a time window.
     * For RESOURCE content, this API outputs history with asset in both
     * non-delete or deleted status.
     * For IAM_POLICY content, this API only outputs history when asset and its
     * attached IAM POLICY both exist. So there may be gaps in the output history.
     * </pre>
     */
    public void batchGetAssetsHistory(com.google.cloud.asset.v1beta1.BatchGetAssetsHistoryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1beta1.BatchGetAssetsHistoryResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getBatchGetAssetsHistoryMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getExportAssetsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.asset.v1beta1.ExportAssetsRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_EXPORT_ASSETS)))
          .addMethod(
            getBatchGetAssetsHistoryMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.asset.v1beta1.BatchGetAssetsHistoryRequest,
                com.google.cloud.asset.v1beta1.BatchGetAssetsHistoryResponse>(
                  this, METHODID_BATCH_GET_ASSETS_HISTORY)))
          .build();
    }
  }

  /**
   * <pre>
   * Asset service definition.
   * </pre>
   */
  public static final class AssetServiceStub extends io.grpc.stub.AbstractStub<AssetServiceStub> {
    private AssetServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AssetServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AssetServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AssetServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Exports assets with time and resource types to a given Google Cloud Storage
     * location. The output format is newline delimited JSON.
     * This API implements the [google.longrunning.Operation][google.longrunning.Operation] API allowing users
     * to keep track of the export.
     * </pre>
     */
    public void exportAssets(com.google.cloud.asset.v1beta1.ExportAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getExportAssetsMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Batch gets assets update history that overlaps a time window.
     * For RESOURCE content, this API outputs history with asset in both
     * non-delete or deleted status.
     * For IAM_POLICY content, this API only outputs history when asset and its
     * attached IAM POLICY both exist. So there may be gaps in the output history.
     * </pre>
     */
    public void batchGetAssetsHistory(com.google.cloud.asset.v1beta1.BatchGetAssetsHistoryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1beta1.BatchGetAssetsHistoryResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBatchGetAssetsHistoryMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Asset service definition.
   * </pre>
   */
  public static final class AssetServiceBlockingStub extends io.grpc.stub.AbstractStub<AssetServiceBlockingStub> {
    private AssetServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AssetServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AssetServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AssetServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Exports assets with time and resource types to a given Google Cloud Storage
     * location. The output format is newline delimited JSON.
     * This API implements the [google.longrunning.Operation][google.longrunning.Operation] API allowing users
     * to keep track of the export.
     * </pre>
     */
    public com.google.longrunning.Operation exportAssets(com.google.cloud.asset.v1beta1.ExportAssetsRequest request) {
      return blockingUnaryCall(
          getChannel(), getExportAssetsMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Batch gets assets update history that overlaps a time window.
     * For RESOURCE content, this API outputs history with asset in both
     * non-delete or deleted status.
     * For IAM_POLICY content, this API only outputs history when asset and its
     * attached IAM POLICY both exist. So there may be gaps in the output history.
     * </pre>
     */
    public com.google.cloud.asset.v1beta1.BatchGetAssetsHistoryResponse batchGetAssetsHistory(com.google.cloud.asset.v1beta1.BatchGetAssetsHistoryRequest request) {
      return blockingUnaryCall(
          getChannel(), getBatchGetAssetsHistoryMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Asset service definition.
   * </pre>
   */
  public static final class AssetServiceFutureStub extends io.grpc.stub.AbstractStub<AssetServiceFutureStub> {
    private AssetServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AssetServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AssetServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AssetServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Exports assets with time and resource types to a given Google Cloud Storage
     * location. The output format is newline delimited JSON.
     * This API implements the [google.longrunning.Operation][google.longrunning.Operation] API allowing users
     * to keep track of the export.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> exportAssets(
        com.google.cloud.asset.v1beta1.ExportAssetsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getExportAssetsMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Batch gets assets update history that overlaps a time window.
     * For RESOURCE content, this API outputs history with asset in both
     * non-delete or deleted status.
     * For IAM_POLICY content, this API only outputs history when asset and its
     * attached IAM POLICY both exist. So there may be gaps in the output history.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.asset.v1beta1.BatchGetAssetsHistoryResponse> batchGetAssetsHistory(
        com.google.cloud.asset.v1beta1.BatchGetAssetsHistoryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBatchGetAssetsHistoryMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_EXPORT_ASSETS = 0;
  private static final int METHODID_BATCH_GET_ASSETS_HISTORY = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AssetServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AssetServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_EXPORT_ASSETS:
          serviceImpl.exportAssets((com.google.cloud.asset.v1beta1.ExportAssetsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_BATCH_GET_ASSETS_HISTORY:
          serviceImpl.batchGetAssetsHistory((com.google.cloud.asset.v1beta1.BatchGetAssetsHistoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.asset.v1beta1.BatchGetAssetsHistoryResponse>) responseObserver);
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

  private static abstract class AssetServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AssetServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.asset.v1beta1.AssetServiceProto.getDescriptor();
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
    private final String methodName;

    AssetServiceMethodDescriptorSupplier(String methodName) {
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
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AssetServiceFileDescriptorSupplier())
              .addMethod(getExportAssetsMethodHelper())
              .addMethod(getBatchGetAssetsHistoryMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
