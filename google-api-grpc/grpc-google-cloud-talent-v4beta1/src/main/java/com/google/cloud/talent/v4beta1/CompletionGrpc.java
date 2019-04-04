package com.google.cloud.talent.v4beta1;

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
 * A service handles auto completion.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/talent/v4beta1/completion_service.proto")
public final class CompletionGrpc {

  private CompletionGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.talent.v4beta1.Completion";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCompleteQueryMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.CompleteQueryRequest,
          com.google.cloud.talent.v4beta1.CompleteQueryResponse>
      METHOD_COMPLETE_QUERY = getCompleteQueryMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.CompleteQueryRequest,
          com.google.cloud.talent.v4beta1.CompleteQueryResponse>
      getCompleteQueryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.CompleteQueryRequest,
          com.google.cloud.talent.v4beta1.CompleteQueryResponse>
      getCompleteQueryMethod() {
    return getCompleteQueryMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.CompleteQueryRequest,
          com.google.cloud.talent.v4beta1.CompleteQueryResponse>
      getCompleteQueryMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4beta1.CompleteQueryRequest,
            com.google.cloud.talent.v4beta1.CompleteQueryResponse>
        getCompleteQueryMethod;
    if ((getCompleteQueryMethod = CompletionGrpc.getCompleteQueryMethod) == null) {
      synchronized (CompletionGrpc.class) {
        if ((getCompleteQueryMethod = CompletionGrpc.getCompleteQueryMethod) == null) {
          CompletionGrpc.getCompleteQueryMethod =
              getCompleteQueryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4beta1.CompleteQueryRequest,
                          com.google.cloud.talent.v4beta1.CompleteQueryResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.talent.v4beta1.Completion", "CompleteQuery"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.CompleteQueryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.CompleteQueryResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new CompletionMethodDescriptorSupplier("CompleteQuery"))
                      .build();
        }
      }
    }
    return getCompleteQueryMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static CompletionStub newStub(io.grpc.Channel channel) {
    return new CompletionStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CompletionBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new CompletionBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static CompletionFutureStub newFutureStub(io.grpc.Channel channel) {
    return new CompletionFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * A service handles auto completion.
   * </pre>
   */
  public abstract static class CompletionImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Completes the specified prefix with keyword suggestions.
     * Intended for use by a job search auto-complete search box.
     * </pre>
     */
    public void completeQuery(
        com.google.cloud.talent.v4beta1.CompleteQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.CompleteQueryResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getCompleteQueryMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCompleteQueryMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.CompleteQueryRequest,
                      com.google.cloud.talent.v4beta1.CompleteQueryResponse>(
                      this, METHODID_COMPLETE_QUERY)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * A service handles auto completion.
   * </pre>
   */
  public static final class CompletionStub extends io.grpc.stub.AbstractStub<CompletionStub> {
    private CompletionStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CompletionStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompletionStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CompletionStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Completes the specified prefix with keyword suggestions.
     * Intended for use by a job search auto-complete search box.
     * </pre>
     */
    public void completeQuery(
        com.google.cloud.talent.v4beta1.CompleteQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.CompleteQueryResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCompleteQueryMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * A service handles auto completion.
   * </pre>
   */
  public static final class CompletionBlockingStub
      extends io.grpc.stub.AbstractStub<CompletionBlockingStub> {
    private CompletionBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CompletionBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompletionBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CompletionBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Completes the specified prefix with keyword suggestions.
     * Intended for use by a job search auto-complete search box.
     * </pre>
     */
    public com.google.cloud.talent.v4beta1.CompleteQueryResponse completeQuery(
        com.google.cloud.talent.v4beta1.CompleteQueryRequest request) {
      return blockingUnaryCall(
          getChannel(), getCompleteQueryMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * A service handles auto completion.
   * </pre>
   */
  public static final class CompletionFutureStub
      extends io.grpc.stub.AbstractStub<CompletionFutureStub> {
    private CompletionFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CompletionFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompletionFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CompletionFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Completes the specified prefix with keyword suggestions.
     * Intended for use by a job search auto-complete search box.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.talent.v4beta1.CompleteQueryResponse>
        completeQuery(com.google.cloud.talent.v4beta1.CompleteQueryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCompleteQueryMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_COMPLETE_QUERY = 0;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CompletionImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CompletionImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_COMPLETE_QUERY:
          serviceImpl.completeQuery(
              (com.google.cloud.talent.v4beta1.CompleteQueryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.CompleteQueryResponse>)
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

  private abstract static class CompletionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CompletionBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.talent.v4beta1.CompletionServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Completion");
    }
  }

  private static final class CompletionFileDescriptorSupplier
      extends CompletionBaseDescriptorSupplier {
    CompletionFileDescriptorSupplier() {}
  }

  private static final class CompletionMethodDescriptorSupplier
      extends CompletionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CompletionMethodDescriptorSupplier(String methodName) {
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
      synchronized (CompletionGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new CompletionFileDescriptorSupplier())
                      .addMethod(getCompleteQueryMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
