package com.google.recaptchaenterprise.v1beta1;

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
 * Service to determine the likelihood an event is legitimate.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/recaptchaenterprise/v1beta1/recaptchaenterprise.proto")
public final class RecaptchaEnterpriseServiceV1Beta1Grpc {

  private RecaptchaEnterpriseServiceV1Beta1Grpc() {}

  public static final String SERVICE_NAME =
      "google.cloud.recaptchaenterprise.v1beta1.RecaptchaEnterpriseServiceV1Beta1";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateAssessmentMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.CreateAssessmentRequest,
          com.google.recaptchaenterprise.v1beta1.Assessment>
      METHOD_CREATE_ASSESSMENT = getCreateAssessmentMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.CreateAssessmentRequest,
          com.google.recaptchaenterprise.v1beta1.Assessment>
      getCreateAssessmentMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.CreateAssessmentRequest,
          com.google.recaptchaenterprise.v1beta1.Assessment>
      getCreateAssessmentMethod() {
    return getCreateAssessmentMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.CreateAssessmentRequest,
          com.google.recaptchaenterprise.v1beta1.Assessment>
      getCreateAssessmentMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1beta1.CreateAssessmentRequest,
            com.google.recaptchaenterprise.v1beta1.Assessment>
        getCreateAssessmentMethod;
    if ((getCreateAssessmentMethod =
            RecaptchaEnterpriseServiceV1Beta1Grpc.getCreateAssessmentMethod)
        == null) {
      synchronized (RecaptchaEnterpriseServiceV1Beta1Grpc.class) {
        if ((getCreateAssessmentMethod =
                RecaptchaEnterpriseServiceV1Beta1Grpc.getCreateAssessmentMethod)
            == null) {
          RecaptchaEnterpriseServiceV1Beta1Grpc.getCreateAssessmentMethod =
              getCreateAssessmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1beta1.CreateAssessmentRequest,
                          com.google.recaptchaenterprise.v1beta1.Assessment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.recaptchaenterprise.v1beta1.RecaptchaEnterpriseServiceV1Beta1",
                              "CreateAssessment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1beta1.CreateAssessmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1beta1.Assessment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceV1Beta1MethodDescriptorSupplier(
                              "CreateAssessment"))
                      .build();
        }
      }
    }
    return getCreateAssessmentMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAnnotateAssessmentMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentRequest,
          com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentResponse>
      METHOD_ANNOTATE_ASSESSMENT = getAnnotateAssessmentMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentRequest,
          com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentResponse>
      getAnnotateAssessmentMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentRequest,
          com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentResponse>
      getAnnotateAssessmentMethod() {
    return getAnnotateAssessmentMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentRequest,
          com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentResponse>
      getAnnotateAssessmentMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentRequest,
            com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentResponse>
        getAnnotateAssessmentMethod;
    if ((getAnnotateAssessmentMethod =
            RecaptchaEnterpriseServiceV1Beta1Grpc.getAnnotateAssessmentMethod)
        == null) {
      synchronized (RecaptchaEnterpriseServiceV1Beta1Grpc.class) {
        if ((getAnnotateAssessmentMethod =
                RecaptchaEnterpriseServiceV1Beta1Grpc.getAnnotateAssessmentMethod)
            == null) {
          RecaptchaEnterpriseServiceV1Beta1Grpc.getAnnotateAssessmentMethod =
              getAnnotateAssessmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentRequest,
                          com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.recaptchaenterprise.v1beta1.RecaptchaEnterpriseServiceV1Beta1",
                              "AnnotateAssessment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceV1Beta1MethodDescriptorSupplier(
                              "AnnotateAssessment"))
                      .build();
        }
      }
    }
    return getAnnotateAssessmentMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static RecaptchaEnterpriseServiceV1Beta1Stub newStub(io.grpc.Channel channel) {
    return new RecaptchaEnterpriseServiceV1Beta1Stub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RecaptchaEnterpriseServiceV1Beta1BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RecaptchaEnterpriseServiceV1Beta1BlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static RecaptchaEnterpriseServiceV1Beta1FutureStub newFutureStub(io.grpc.Channel channel) {
    return new RecaptchaEnterpriseServiceV1Beta1FutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * Service to determine the likelihood an event is legitimate.
   * </pre>
   */
  public abstract static class RecaptchaEnterpriseServiceV1Beta1ImplBase
      implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates an Assessment of the likelihood an event is legitimate.
     * </pre>
     */
    public void createAssessment(
        com.google.recaptchaenterprise.v1beta1.CreateAssessmentRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1beta1.Assessment>
            responseObserver) {
      asyncUnimplementedUnaryCall(getCreateAssessmentMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Annotates a previously created Assessment to provide additional information
     * on whether the event turned out to be authentic or fradulent.
     * </pre>
     */
    public void annotateAssessment(
        com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentRequest request,
        io.grpc.stub.StreamObserver<
                com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getAnnotateAssessmentMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateAssessmentMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.recaptchaenterprise.v1beta1.CreateAssessmentRequest,
                      com.google.recaptchaenterprise.v1beta1.Assessment>(
                      this, METHODID_CREATE_ASSESSMENT)))
          .addMethod(
              getAnnotateAssessmentMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentRequest,
                      com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentResponse>(
                      this, METHODID_ANNOTATE_ASSESSMENT)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service to determine the likelihood an event is legitimate.
   * </pre>
   */
  public static final class RecaptchaEnterpriseServiceV1Beta1Stub
      extends io.grpc.stub.AbstractStub<RecaptchaEnterpriseServiceV1Beta1Stub> {
    private RecaptchaEnterpriseServiceV1Beta1Stub(io.grpc.Channel channel) {
      super(channel);
    }

    private RecaptchaEnterpriseServiceV1Beta1Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecaptchaEnterpriseServiceV1Beta1Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecaptchaEnterpriseServiceV1Beta1Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an Assessment of the likelihood an event is legitimate.
     * </pre>
     */
    public void createAssessment(
        com.google.recaptchaenterprise.v1beta1.CreateAssessmentRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1beta1.Assessment>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateAssessmentMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Annotates a previously created Assessment to provide additional information
     * on whether the event turned out to be authentic or fradulent.
     * </pre>
     */
    public void annotateAssessment(
        com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentRequest request,
        io.grpc.stub.StreamObserver<
                com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAnnotateAssessmentMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service to determine the likelihood an event is legitimate.
   * </pre>
   */
  public static final class RecaptchaEnterpriseServiceV1Beta1BlockingStub
      extends io.grpc.stub.AbstractStub<RecaptchaEnterpriseServiceV1Beta1BlockingStub> {
    private RecaptchaEnterpriseServiceV1Beta1BlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RecaptchaEnterpriseServiceV1Beta1BlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecaptchaEnterpriseServiceV1Beta1BlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecaptchaEnterpriseServiceV1Beta1BlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an Assessment of the likelihood an event is legitimate.
     * </pre>
     */
    public com.google.recaptchaenterprise.v1beta1.Assessment createAssessment(
        com.google.recaptchaenterprise.v1beta1.CreateAssessmentRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateAssessmentMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Annotates a previously created Assessment to provide additional information
     * on whether the event turned out to be authentic or fradulent.
     * </pre>
     */
    public com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentResponse annotateAssessment(
        com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentRequest request) {
      return blockingUnaryCall(
          getChannel(), getAnnotateAssessmentMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service to determine the likelihood an event is legitimate.
   * </pre>
   */
  public static final class RecaptchaEnterpriseServiceV1Beta1FutureStub
      extends io.grpc.stub.AbstractStub<RecaptchaEnterpriseServiceV1Beta1FutureStub> {
    private RecaptchaEnterpriseServiceV1Beta1FutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RecaptchaEnterpriseServiceV1Beta1FutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecaptchaEnterpriseServiceV1Beta1FutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecaptchaEnterpriseServiceV1Beta1FutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an Assessment of the likelihood an event is legitimate.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.recaptchaenterprise.v1beta1.Assessment>
        createAssessment(com.google.recaptchaenterprise.v1beta1.CreateAssessmentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateAssessmentMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Annotates a previously created Assessment to provide additional information
     * on whether the event turned out to be authentic or fradulent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentResponse>
        annotateAssessment(
            com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAnnotateAssessmentMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ASSESSMENT = 0;
  private static final int METHODID_ANNOTATE_ASSESSMENT = 1;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RecaptchaEnterpriseServiceV1Beta1ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RecaptchaEnterpriseServiceV1Beta1ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_ASSESSMENT:
          serviceImpl.createAssessment(
              (com.google.recaptchaenterprise.v1beta1.CreateAssessmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1beta1.Assessment>)
                  responseObserver);
          break;
        case METHODID_ANNOTATE_ASSESSMENT:
          serviceImpl.annotateAssessment(
              (com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentResponse>)
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

  private abstract static class RecaptchaEnterpriseServiceV1Beta1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RecaptchaEnterpriseServiceV1Beta1BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.recaptchaenterprise.v1beta1.RecaptchaEnterpriseProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RecaptchaEnterpriseServiceV1Beta1");
    }
  }

  private static final class RecaptchaEnterpriseServiceV1Beta1FileDescriptorSupplier
      extends RecaptchaEnterpriseServiceV1Beta1BaseDescriptorSupplier {
    RecaptchaEnterpriseServiceV1Beta1FileDescriptorSupplier() {}
  }

  private static final class RecaptchaEnterpriseServiceV1Beta1MethodDescriptorSupplier
      extends RecaptchaEnterpriseServiceV1Beta1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RecaptchaEnterpriseServiceV1Beta1MethodDescriptorSupplier(String methodName) {
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
      synchronized (RecaptchaEnterpriseServiceV1Beta1Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceV1Beta1FileDescriptorSupplier())
                      .addMethod(getCreateAssessmentMethodHelper())
                      .addMethod(getAnnotateAssessmentMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
