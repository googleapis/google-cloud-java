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
package com.google.cloud.retail.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Auto-completion service for retail.
 * This feature is only available for users who have Retail Search enabled.
 * Please enable Retail Search on Cloud Console before using this feature.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/retail/v2/completion_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CompletionServiceGrpc {

  private CompletionServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.retail.v2.CompletionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2.CompleteQueryRequest,
          com.google.cloud.retail.v2.CompleteQueryResponse>
      getCompleteQueryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CompleteQuery",
      requestType = com.google.cloud.retail.v2.CompleteQueryRequest.class,
      responseType = com.google.cloud.retail.v2.CompleteQueryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2.CompleteQueryRequest,
          com.google.cloud.retail.v2.CompleteQueryResponse>
      getCompleteQueryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2.CompleteQueryRequest,
            com.google.cloud.retail.v2.CompleteQueryResponse>
        getCompleteQueryMethod;
    if ((getCompleteQueryMethod = CompletionServiceGrpc.getCompleteQueryMethod) == null) {
      synchronized (CompletionServiceGrpc.class) {
        if ((getCompleteQueryMethod = CompletionServiceGrpc.getCompleteQueryMethod) == null) {
          CompletionServiceGrpc.getCompleteQueryMethod =
              getCompleteQueryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2.CompleteQueryRequest,
                          com.google.cloud.retail.v2.CompleteQueryResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CompleteQuery"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2.CompleteQueryRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2.CompleteQueryResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CompletionServiceMethodDescriptorSupplier("CompleteQuery"))
                      .build();
        }
      }
    }
    return getCompleteQueryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2.ImportCompletionDataRequest, com.google.longrunning.Operation>
      getImportCompletionDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportCompletionData",
      requestType = com.google.cloud.retail.v2.ImportCompletionDataRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2.ImportCompletionDataRequest, com.google.longrunning.Operation>
      getImportCompletionDataMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2.ImportCompletionDataRequest,
            com.google.longrunning.Operation>
        getImportCompletionDataMethod;
    if ((getImportCompletionDataMethod = CompletionServiceGrpc.getImportCompletionDataMethod)
        == null) {
      synchronized (CompletionServiceGrpc.class) {
        if ((getImportCompletionDataMethod = CompletionServiceGrpc.getImportCompletionDataMethod)
            == null) {
          CompletionServiceGrpc.getImportCompletionDataMethod =
              getImportCompletionDataMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2.ImportCompletionDataRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ImportCompletionData"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2.ImportCompletionDataRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CompletionServiceMethodDescriptorSupplier("ImportCompletionData"))
                      .build();
        }
      }
    }
    return getImportCompletionDataMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static CompletionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CompletionServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CompletionServiceStub>() {
          @java.lang.Override
          public CompletionServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CompletionServiceStub(channel, callOptions);
          }
        };
    return CompletionServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CompletionServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CompletionServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CompletionServiceBlockingStub>() {
          @java.lang.Override
          public CompletionServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CompletionServiceBlockingStub(channel, callOptions);
          }
        };
    return CompletionServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static CompletionServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CompletionServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CompletionServiceFutureStub>() {
          @java.lang.Override
          public CompletionServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CompletionServiceFutureStub(channel, callOptions);
          }
        };
    return CompletionServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Auto-completion service for retail.
   * This feature is only available for users who have Retail Search enabled.
   * Please enable Retail Search on Cloud Console before using this feature.
   * </pre>
   */
  public abstract static class CompletionServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Completes the specified prefix with keyword suggestions.
     * This feature is only available for users who have Retail Search enabled.
     * Please enable Retail Search on Cloud Console before using this feature.
     * </pre>
     */
    public void completeQuery(
        com.google.cloud.retail.v2.CompleteQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.CompleteQueryResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCompleteQueryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Bulk import of processed completion dataset.
     * Request processing is asynchronous. Partial updating is not supported.
     * The operation is successfully finished only after the imported suggestions
     * are indexed successfully and ready for serving. The process takes hours.
     * This feature is only available for users who have Retail Search enabled.
     * Please enable Retail Search on Cloud Console before using this feature.
     * </pre>
     */
    public void importCompletionData(
        com.google.cloud.retail.v2.ImportCompletionDataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportCompletionDataMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCompleteQueryMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.retail.v2.CompleteQueryRequest,
                      com.google.cloud.retail.v2.CompleteQueryResponse>(
                      this, METHODID_COMPLETE_QUERY)))
          .addMethod(
              getImportCompletionDataMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.retail.v2.ImportCompletionDataRequest,
                      com.google.longrunning.Operation>(this, METHODID_IMPORT_COMPLETION_DATA)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Auto-completion service for retail.
   * This feature is only available for users who have Retail Search enabled.
   * Please enable Retail Search on Cloud Console before using this feature.
   * </pre>
   */
  public static final class CompletionServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CompletionServiceStub> {
    private CompletionServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompletionServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CompletionServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Completes the specified prefix with keyword suggestions.
     * This feature is only available for users who have Retail Search enabled.
     * Please enable Retail Search on Cloud Console before using this feature.
     * </pre>
     */
    public void completeQuery(
        com.google.cloud.retail.v2.CompleteQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.CompleteQueryResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCompleteQueryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Bulk import of processed completion dataset.
     * Request processing is asynchronous. Partial updating is not supported.
     * The operation is successfully finished only after the imported suggestions
     * are indexed successfully and ready for serving. The process takes hours.
     * This feature is only available for users who have Retail Search enabled.
     * Please enable Retail Search on Cloud Console before using this feature.
     * </pre>
     */
    public void importCompletionData(
        com.google.cloud.retail.v2.ImportCompletionDataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportCompletionDataMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Auto-completion service for retail.
   * This feature is only available for users who have Retail Search enabled.
   * Please enable Retail Search on Cloud Console before using this feature.
   * </pre>
   */
  public static final class CompletionServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CompletionServiceBlockingStub> {
    private CompletionServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompletionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CompletionServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Completes the specified prefix with keyword suggestions.
     * This feature is only available for users who have Retail Search enabled.
     * Please enable Retail Search on Cloud Console before using this feature.
     * </pre>
     */
    public com.google.cloud.retail.v2.CompleteQueryResponse completeQuery(
        com.google.cloud.retail.v2.CompleteQueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCompleteQueryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Bulk import of processed completion dataset.
     * Request processing is asynchronous. Partial updating is not supported.
     * The operation is successfully finished only after the imported suggestions
     * are indexed successfully and ready for serving. The process takes hours.
     * This feature is only available for users who have Retail Search enabled.
     * Please enable Retail Search on Cloud Console before using this feature.
     * </pre>
     */
    public com.google.longrunning.Operation importCompletionData(
        com.google.cloud.retail.v2.ImportCompletionDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportCompletionDataMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Auto-completion service for retail.
   * This feature is only available for users who have Retail Search enabled.
   * Please enable Retail Search on Cloud Console before using this feature.
   * </pre>
   */
  public static final class CompletionServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CompletionServiceFutureStub> {
    private CompletionServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompletionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CompletionServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Completes the specified prefix with keyword suggestions.
     * This feature is only available for users who have Retail Search enabled.
     * Please enable Retail Search on Cloud Console before using this feature.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.retail.v2.CompleteQueryResponse>
        completeQuery(com.google.cloud.retail.v2.CompleteQueryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCompleteQueryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Bulk import of processed completion dataset.
     * Request processing is asynchronous. Partial updating is not supported.
     * The operation is successfully finished only after the imported suggestions
     * are indexed successfully and ready for serving. The process takes hours.
     * This feature is only available for users who have Retail Search enabled.
     * Please enable Retail Search on Cloud Console before using this feature.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importCompletionData(com.google.cloud.retail.v2.ImportCompletionDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportCompletionDataMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_COMPLETE_QUERY = 0;
  private static final int METHODID_IMPORT_COMPLETION_DATA = 1;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CompletionServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CompletionServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_COMPLETE_QUERY:
          serviceImpl.completeQuery(
              (com.google.cloud.retail.v2.CompleteQueryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.CompleteQueryResponse>)
                  responseObserver);
          break;
        case METHODID_IMPORT_COMPLETION_DATA:
          serviceImpl.importCompletionData(
              (com.google.cloud.retail.v2.ImportCompletionDataRequest) request,
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

  private abstract static class CompletionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CompletionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.retail.v2.CompletionServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CompletionService");
    }
  }

  private static final class CompletionServiceFileDescriptorSupplier
      extends CompletionServiceBaseDescriptorSupplier {
    CompletionServiceFileDescriptorSupplier() {}
  }

  private static final class CompletionServiceMethodDescriptorSupplier
      extends CompletionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CompletionServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CompletionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new CompletionServiceFileDescriptorSupplier())
                      .addMethod(getCompleteQueryMethod())
                      .addMethod(getImportCompletionDataMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
