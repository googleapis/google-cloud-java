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
 * A service that handles resume parsing.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/talent/v4beta1/resume_service.proto")
public final class ResumeServiceGrpc {

  private ResumeServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.talent.v4beta1.ResumeService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getParseResumeMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.ParseResumeRequest,
          com.google.cloud.talent.v4beta1.ParseResumeResponse>
      METHOD_PARSE_RESUME = getParseResumeMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.ParseResumeRequest,
          com.google.cloud.talent.v4beta1.ParseResumeResponse>
      getParseResumeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.ParseResumeRequest,
          com.google.cloud.talent.v4beta1.ParseResumeResponse>
      getParseResumeMethod() {
    return getParseResumeMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.ParseResumeRequest,
          com.google.cloud.talent.v4beta1.ParseResumeResponse>
      getParseResumeMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4beta1.ParseResumeRequest,
            com.google.cloud.talent.v4beta1.ParseResumeResponse>
        getParseResumeMethod;
    if ((getParseResumeMethod = ResumeServiceGrpc.getParseResumeMethod) == null) {
      synchronized (ResumeServiceGrpc.class) {
        if ((getParseResumeMethod = ResumeServiceGrpc.getParseResumeMethod) == null) {
          ResumeServiceGrpc.getParseResumeMethod =
              getParseResumeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4beta1.ParseResumeRequest,
                          com.google.cloud.talent.v4beta1.ParseResumeResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.talent.v4beta1.ResumeService", "ParseResume"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.ParseResumeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.ParseResumeResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ResumeServiceMethodDescriptorSupplier("ParseResume"))
                      .build();
        }
      }
    }
    return getParseResumeMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ResumeServiceStub newStub(io.grpc.Channel channel) {
    return new ResumeServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ResumeServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new ResumeServiceBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ResumeServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    return new ResumeServiceFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * A service that handles resume parsing.
   * </pre>
   */
  public abstract static class ResumeServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Parses a resume into a [Profile][google.cloud.talent.v4beta1.Profile]. The
     * API attempts to fill out the following profile fields if present within the
     * resume:
     * * personNames
     * * addresses
     * * emailAddress
     * * phoneNumbers
     * * personalUris
     * * employmentRecords
     * * educationRecords
     * * skills
     * Note that some attributes in these fields may not be populated if they're
     * not present within the resume or unrecognizable by the resume parser.
     * This API does not save the resume or profile. To create a profile from this
     * resume, clients need to call the CreateProfile method again with the
     * profile returned.
     * The following list of formats are supported:
     * * PDF
     * * TXT
     * * DOC
     * * RTF
     * * DOCX
     * * PNG (only when [ParseResumeRequest.enable_ocr][] is set to `true`,
     * otherwise an error is thrown)
     * </pre>
     */
    public void parseResume(
        com.google.cloud.talent.v4beta1.ParseResumeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.ParseResumeResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getParseResumeMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getParseResumeMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.ParseResumeRequest,
                      com.google.cloud.talent.v4beta1.ParseResumeResponse>(
                      this, METHODID_PARSE_RESUME)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * A service that handles resume parsing.
   * </pre>
   */
  public static final class ResumeServiceStub extends io.grpc.stub.AbstractStub<ResumeServiceStub> {
    private ResumeServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ResumeServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ResumeServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ResumeServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Parses a resume into a [Profile][google.cloud.talent.v4beta1.Profile]. The
     * API attempts to fill out the following profile fields if present within the
     * resume:
     * * personNames
     * * addresses
     * * emailAddress
     * * phoneNumbers
     * * personalUris
     * * employmentRecords
     * * educationRecords
     * * skills
     * Note that some attributes in these fields may not be populated if they're
     * not present within the resume or unrecognizable by the resume parser.
     * This API does not save the resume or profile. To create a profile from this
     * resume, clients need to call the CreateProfile method again with the
     * profile returned.
     * The following list of formats are supported:
     * * PDF
     * * TXT
     * * DOC
     * * RTF
     * * DOCX
     * * PNG (only when [ParseResumeRequest.enable_ocr][] is set to `true`,
     * otherwise an error is thrown)
     * </pre>
     */
    public void parseResume(
        com.google.cloud.talent.v4beta1.ParseResumeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.ParseResumeResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getParseResumeMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * A service that handles resume parsing.
   * </pre>
   */
  public static final class ResumeServiceBlockingStub
      extends io.grpc.stub.AbstractStub<ResumeServiceBlockingStub> {
    private ResumeServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ResumeServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ResumeServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ResumeServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Parses a resume into a [Profile][google.cloud.talent.v4beta1.Profile]. The
     * API attempts to fill out the following profile fields if present within the
     * resume:
     * * personNames
     * * addresses
     * * emailAddress
     * * phoneNumbers
     * * personalUris
     * * employmentRecords
     * * educationRecords
     * * skills
     * Note that some attributes in these fields may not be populated if they're
     * not present within the resume or unrecognizable by the resume parser.
     * This API does not save the resume or profile. To create a profile from this
     * resume, clients need to call the CreateProfile method again with the
     * profile returned.
     * The following list of formats are supported:
     * * PDF
     * * TXT
     * * DOC
     * * RTF
     * * DOCX
     * * PNG (only when [ParseResumeRequest.enable_ocr][] is set to `true`,
     * otherwise an error is thrown)
     * </pre>
     */
    public com.google.cloud.talent.v4beta1.ParseResumeResponse parseResume(
        com.google.cloud.talent.v4beta1.ParseResumeRequest request) {
      return blockingUnaryCall(
          getChannel(), getParseResumeMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * A service that handles resume parsing.
   * </pre>
   */
  public static final class ResumeServiceFutureStub
      extends io.grpc.stub.AbstractStub<ResumeServiceFutureStub> {
    private ResumeServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ResumeServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ResumeServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ResumeServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Parses a resume into a [Profile][google.cloud.talent.v4beta1.Profile]. The
     * API attempts to fill out the following profile fields if present within the
     * resume:
     * * personNames
     * * addresses
     * * emailAddress
     * * phoneNumbers
     * * personalUris
     * * employmentRecords
     * * educationRecords
     * * skills
     * Note that some attributes in these fields may not be populated if they're
     * not present within the resume or unrecognizable by the resume parser.
     * This API does not save the resume or profile. To create a profile from this
     * resume, clients need to call the CreateProfile method again with the
     * profile returned.
     * The following list of formats are supported:
     * * PDF
     * * TXT
     * * DOC
     * * RTF
     * * DOCX
     * * PNG (only when [ParseResumeRequest.enable_ocr][] is set to `true`,
     * otherwise an error is thrown)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.talent.v4beta1.ParseResumeResponse>
        parseResume(com.google.cloud.talent.v4beta1.ParseResumeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getParseResumeMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PARSE_RESUME = 0;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ResumeServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ResumeServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PARSE_RESUME:
          serviceImpl.parseResume(
              (com.google.cloud.talent.v4beta1.ParseResumeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.ParseResumeResponse>)
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

  private abstract static class ResumeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ResumeServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.talent.v4beta1.ResumeServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ResumeService");
    }
  }

  private static final class ResumeServiceFileDescriptorSupplier
      extends ResumeServiceBaseDescriptorSupplier {
    ResumeServiceFileDescriptorSupplier() {}
  }

  private static final class ResumeServiceMethodDescriptorSupplier
      extends ResumeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ResumeServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ResumeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ResumeServiceFileDescriptorSupplier())
                      .addMethod(getParseResumeMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
