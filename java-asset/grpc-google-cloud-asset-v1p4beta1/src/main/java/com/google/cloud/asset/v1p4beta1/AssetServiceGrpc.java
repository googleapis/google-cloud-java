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
package com.google.cloud.asset.v1p4beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 *
 * <pre>
 * Asset service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/asset/v1p4beta1/asset_service.proto")
public final class AssetServiceGrpc {

  private AssetServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.asset.v1p4beta1.AssetService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p4beta1.AnalyzeIamPolicyRequest,
          com.google.cloud.asset.v1p4beta1.AnalyzeIamPolicyResponse>
      getAnalyzeIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AnalyzeIamPolicy",
      requestType = com.google.cloud.asset.v1p4beta1.AnalyzeIamPolicyRequest.class,
      responseType = com.google.cloud.asset.v1p4beta1.AnalyzeIamPolicyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p4beta1.AnalyzeIamPolicyRequest,
          com.google.cloud.asset.v1p4beta1.AnalyzeIamPolicyResponse>
      getAnalyzeIamPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.asset.v1p4beta1.AnalyzeIamPolicyRequest,
            com.google.cloud.asset.v1p4beta1.AnalyzeIamPolicyResponse>
        getAnalyzeIamPolicyMethod;
    if ((getAnalyzeIamPolicyMethod = AssetServiceGrpc.getAnalyzeIamPolicyMethod) == null) {
      synchronized (AssetServiceGrpc.class) {
        if ((getAnalyzeIamPolicyMethod = AssetServiceGrpc.getAnalyzeIamPolicyMethod) == null) {
          AssetServiceGrpc.getAnalyzeIamPolicyMethod =
              getAnalyzeIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.asset.v1p4beta1.AnalyzeIamPolicyRequest,
                          com.google.cloud.asset.v1p4beta1.AnalyzeIamPolicyResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AnalyzeIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1p4beta1.AnalyzeIamPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1p4beta1.AnalyzeIamPolicyResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssetServiceMethodDescriptorSupplier("AnalyzeIamPolicy"))
                      .build();
        }
      }
    }
    return getAnalyzeIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p4beta1.ExportIamPolicyAnalysisRequest,
          com.google.longrunning.Operation>
      getExportIamPolicyAnalysisMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportIamPolicyAnalysis",
      requestType = com.google.cloud.asset.v1p4beta1.ExportIamPolicyAnalysisRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p4beta1.ExportIamPolicyAnalysisRequest,
          com.google.longrunning.Operation>
      getExportIamPolicyAnalysisMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.asset.v1p4beta1.ExportIamPolicyAnalysisRequest,
            com.google.longrunning.Operation>
        getExportIamPolicyAnalysisMethod;
    if ((getExportIamPolicyAnalysisMethod = AssetServiceGrpc.getExportIamPolicyAnalysisMethod)
        == null) {
      synchronized (AssetServiceGrpc.class) {
        if ((getExportIamPolicyAnalysisMethod = AssetServiceGrpc.getExportIamPolicyAnalysisMethod)
            == null) {
          AssetServiceGrpc.getExportIamPolicyAnalysisMethod =
              getExportIamPolicyAnalysisMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.asset.v1p4beta1.ExportIamPolicyAnalysisRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ExportIamPolicyAnalysis"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1p4beta1.ExportIamPolicyAnalysisRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssetServiceMethodDescriptorSupplier("ExportIamPolicyAnalysis"))
                      .build();
        }
      }
    }
    return getExportIamPolicyAnalysisMethod;
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
  public abstract static class AssetServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Analyzes IAM policies based on the specified request. Returns
     * a list of [IamPolicyAnalysisResult][google.cloud.asset.v1p4beta1.IamPolicyAnalysisResult] matching the request.
     * </pre>
     */
    public void analyzeIamPolicy(
        com.google.cloud.asset.v1p4beta1.AnalyzeIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1p4beta1.AnalyzeIamPolicyResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getAnalyzeIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports IAM policy analysis based on the specified request. This API
     * implements the [google.longrunning.Operation][google.longrunning.Operation] API allowing you to keep
     * track of the export. The metadata contains the request to help callers to
     * map responses to requests.
     * </pre>
     */
    public void exportIamPolicyAnalysis(
        com.google.cloud.asset.v1p4beta1.ExportIamPolicyAnalysisRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getExportIamPolicyAnalysisMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getAnalyzeIamPolicyMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.asset.v1p4beta1.AnalyzeIamPolicyRequest,
                      com.google.cloud.asset.v1p4beta1.AnalyzeIamPolicyResponse>(
                      this, METHODID_ANALYZE_IAM_POLICY)))
          .addMethod(
              getExportIamPolicyAnalysisMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.asset.v1p4beta1.ExportIamPolicyAnalysisRequest,
                      com.google.longrunning.Operation>(this, METHODID_EXPORT_IAM_POLICY_ANALYSIS)))
          .build();
    }
  }

  /**
   *
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
     * Analyzes IAM policies based on the specified request. Returns
     * a list of [IamPolicyAnalysisResult][google.cloud.asset.v1p4beta1.IamPolicyAnalysisResult] matching the request.
     * </pre>
     */
    public void analyzeIamPolicy(
        com.google.cloud.asset.v1p4beta1.AnalyzeIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1p4beta1.AnalyzeIamPolicyResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAnalyzeIamPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports IAM policy analysis based on the specified request. This API
     * implements the [google.longrunning.Operation][google.longrunning.Operation] API allowing you to keep
     * track of the export. The metadata contains the request to help callers to
     * map responses to requests.
     * </pre>
     */
    public void exportIamPolicyAnalysis(
        com.google.cloud.asset.v1p4beta1.ExportIamPolicyAnalysisRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getExportIamPolicyAnalysisMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
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
     * Analyzes IAM policies based on the specified request. Returns
     * a list of [IamPolicyAnalysisResult][google.cloud.asset.v1p4beta1.IamPolicyAnalysisResult] matching the request.
     * </pre>
     */
    public com.google.cloud.asset.v1p4beta1.AnalyzeIamPolicyResponse analyzeIamPolicy(
        com.google.cloud.asset.v1p4beta1.AnalyzeIamPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getAnalyzeIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports IAM policy analysis based on the specified request. This API
     * implements the [google.longrunning.Operation][google.longrunning.Operation] API allowing you to keep
     * track of the export. The metadata contains the request to help callers to
     * map responses to requests.
     * </pre>
     */
    public com.google.longrunning.Operation exportIamPolicyAnalysis(
        com.google.cloud.asset.v1p4beta1.ExportIamPolicyAnalysisRequest request) {
      return blockingUnaryCall(
          getChannel(), getExportIamPolicyAnalysisMethod(), getCallOptions(), request);
    }
  }

  /**
   *
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
     * Analyzes IAM policies based on the specified request. Returns
     * a list of [IamPolicyAnalysisResult][google.cloud.asset.v1p4beta1.IamPolicyAnalysisResult] matching the request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.asset.v1p4beta1.AnalyzeIamPolicyResponse>
        analyzeIamPolicy(com.google.cloud.asset.v1p4beta1.AnalyzeIamPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAnalyzeIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Exports IAM policy analysis based on the specified request. This API
     * implements the [google.longrunning.Operation][google.longrunning.Operation] API allowing you to keep
     * track of the export. The metadata contains the request to help callers to
     * map responses to requests.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportIamPolicyAnalysis(
            com.google.cloud.asset.v1p4beta1.ExportIamPolicyAnalysisRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getExportIamPolicyAnalysisMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ANALYZE_IAM_POLICY = 0;
  private static final int METHODID_EXPORT_IAM_POLICY_ANALYSIS = 1;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
        case METHODID_ANALYZE_IAM_POLICY:
          serviceImpl.analyzeIamPolicy(
              (com.google.cloud.asset.v1p4beta1.AnalyzeIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.asset.v1p4beta1.AnalyzeIamPolicyResponse>)
                  responseObserver);
          break;
        case METHODID_EXPORT_IAM_POLICY_ANALYSIS:
          serviceImpl.exportIamPolicyAnalysis(
              (com.google.cloud.asset.v1p4beta1.ExportIamPolicyAnalysisRequest) request,
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

  private abstract static class AssetServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AssetServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.asset.v1p4beta1.AssetServiceProto.getDescriptor();
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
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AssetServiceFileDescriptorSupplier())
                      .addMethod(getAnalyzeIamPolicyMethod())
                      .addMethod(getExportIamPolicyAnalysisMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
