package com.google.dataflow.v1beta3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Provides a method to create Cloud Dataflow jobs from templates.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/dataflow/v1beta3/templates.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TemplatesServiceGrpc {

  private TemplatesServiceGrpc() {}

  public static final String SERVICE_NAME = "google.dataflow.v1beta3.TemplatesService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.CreateJobFromTemplateRequest,
      com.google.dataflow.v1beta3.Job> getCreateJobFromTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateJobFromTemplate",
      requestType = com.google.dataflow.v1beta3.CreateJobFromTemplateRequest.class,
      responseType = com.google.dataflow.v1beta3.Job.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.CreateJobFromTemplateRequest,
      com.google.dataflow.v1beta3.Job> getCreateJobFromTemplateMethod() {
    io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.CreateJobFromTemplateRequest, com.google.dataflow.v1beta3.Job> getCreateJobFromTemplateMethod;
    if ((getCreateJobFromTemplateMethod = TemplatesServiceGrpc.getCreateJobFromTemplateMethod) == null) {
      synchronized (TemplatesServiceGrpc.class) {
        if ((getCreateJobFromTemplateMethod = TemplatesServiceGrpc.getCreateJobFromTemplateMethod) == null) {
          TemplatesServiceGrpc.getCreateJobFromTemplateMethod = getCreateJobFromTemplateMethod =
              io.grpc.MethodDescriptor.<com.google.dataflow.v1beta3.CreateJobFromTemplateRequest, com.google.dataflow.v1beta3.Job>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateJobFromTemplate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.dataflow.v1beta3.CreateJobFromTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.dataflow.v1beta3.Job.getDefaultInstance()))
              .setSchemaDescriptor(new TemplatesServiceMethodDescriptorSupplier("CreateJobFromTemplate"))
              .build();
        }
      }
    }
    return getCreateJobFromTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.LaunchTemplateRequest,
      com.google.dataflow.v1beta3.LaunchTemplateResponse> getLaunchTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LaunchTemplate",
      requestType = com.google.dataflow.v1beta3.LaunchTemplateRequest.class,
      responseType = com.google.dataflow.v1beta3.LaunchTemplateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.LaunchTemplateRequest,
      com.google.dataflow.v1beta3.LaunchTemplateResponse> getLaunchTemplateMethod() {
    io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.LaunchTemplateRequest, com.google.dataflow.v1beta3.LaunchTemplateResponse> getLaunchTemplateMethod;
    if ((getLaunchTemplateMethod = TemplatesServiceGrpc.getLaunchTemplateMethod) == null) {
      synchronized (TemplatesServiceGrpc.class) {
        if ((getLaunchTemplateMethod = TemplatesServiceGrpc.getLaunchTemplateMethod) == null) {
          TemplatesServiceGrpc.getLaunchTemplateMethod = getLaunchTemplateMethod =
              io.grpc.MethodDescriptor.<com.google.dataflow.v1beta3.LaunchTemplateRequest, com.google.dataflow.v1beta3.LaunchTemplateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LaunchTemplate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.dataflow.v1beta3.LaunchTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.dataflow.v1beta3.LaunchTemplateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TemplatesServiceMethodDescriptorSupplier("LaunchTemplate"))
              .build();
        }
      }
    }
    return getLaunchTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.GetTemplateRequest,
      com.google.dataflow.v1beta3.GetTemplateResponse> getGetTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTemplate",
      requestType = com.google.dataflow.v1beta3.GetTemplateRequest.class,
      responseType = com.google.dataflow.v1beta3.GetTemplateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.GetTemplateRequest,
      com.google.dataflow.v1beta3.GetTemplateResponse> getGetTemplateMethod() {
    io.grpc.MethodDescriptor<com.google.dataflow.v1beta3.GetTemplateRequest, com.google.dataflow.v1beta3.GetTemplateResponse> getGetTemplateMethod;
    if ((getGetTemplateMethod = TemplatesServiceGrpc.getGetTemplateMethod) == null) {
      synchronized (TemplatesServiceGrpc.class) {
        if ((getGetTemplateMethod = TemplatesServiceGrpc.getGetTemplateMethod) == null) {
          TemplatesServiceGrpc.getGetTemplateMethod = getGetTemplateMethod =
              io.grpc.MethodDescriptor.<com.google.dataflow.v1beta3.GetTemplateRequest, com.google.dataflow.v1beta3.GetTemplateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTemplate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.dataflow.v1beta3.GetTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.dataflow.v1beta3.GetTemplateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TemplatesServiceMethodDescriptorSupplier("GetTemplate"))
              .build();
        }
      }
    }
    return getGetTemplateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TemplatesServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TemplatesServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TemplatesServiceStub>() {
        @java.lang.Override
        public TemplatesServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TemplatesServiceStub(channel, callOptions);
        }
      };
    return TemplatesServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TemplatesServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TemplatesServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TemplatesServiceBlockingStub>() {
        @java.lang.Override
        public TemplatesServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TemplatesServiceBlockingStub(channel, callOptions);
        }
      };
    return TemplatesServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TemplatesServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TemplatesServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TemplatesServiceFutureStub>() {
        @java.lang.Override
        public TemplatesServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TemplatesServiceFutureStub(channel, callOptions);
        }
      };
    return TemplatesServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Provides a method to create Cloud Dataflow jobs from templates.
   * </pre>
   */
  public static abstract class TemplatesServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Creates a Cloud Dataflow job from a template.
     * </pre>
     */
    public void createJobFromTemplate(com.google.dataflow.v1beta3.CreateJobFromTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.Job> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateJobFromTemplateMethod(), responseObserver);
    }

    /**
     * <pre>
     * Launch a template.
     * </pre>
     */
    public void launchTemplate(com.google.dataflow.v1beta3.LaunchTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.LaunchTemplateResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLaunchTemplateMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get the template associated with a template.
     * </pre>
     */
    public void getTemplate(com.google.dataflow.v1beta3.GetTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.GetTemplateResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTemplateMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateJobFromTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.dataflow.v1beta3.CreateJobFromTemplateRequest,
                com.google.dataflow.v1beta3.Job>(
                  this, METHODID_CREATE_JOB_FROM_TEMPLATE)))
          .addMethod(
            getLaunchTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.dataflow.v1beta3.LaunchTemplateRequest,
                com.google.dataflow.v1beta3.LaunchTemplateResponse>(
                  this, METHODID_LAUNCH_TEMPLATE)))
          .addMethod(
            getGetTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.dataflow.v1beta3.GetTemplateRequest,
                com.google.dataflow.v1beta3.GetTemplateResponse>(
                  this, METHODID_GET_TEMPLATE)))
          .build();
    }
  }

  /**
   * <pre>
   * Provides a method to create Cloud Dataflow jobs from templates.
   * </pre>
   */
  public static final class TemplatesServiceStub extends io.grpc.stub.AbstractAsyncStub<TemplatesServiceStub> {
    private TemplatesServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TemplatesServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TemplatesServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a Cloud Dataflow job from a template.
     * </pre>
     */
    public void createJobFromTemplate(com.google.dataflow.v1beta3.CreateJobFromTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.Job> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateJobFromTemplateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Launch a template.
     * </pre>
     */
    public void launchTemplate(com.google.dataflow.v1beta3.LaunchTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.LaunchTemplateResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLaunchTemplateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get the template associated with a template.
     * </pre>
     */
    public void getTemplate(com.google.dataflow.v1beta3.GetTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.GetTemplateResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTemplateMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Provides a method to create Cloud Dataflow jobs from templates.
   * </pre>
   */
  public static final class TemplatesServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<TemplatesServiceBlockingStub> {
    private TemplatesServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TemplatesServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TemplatesServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a Cloud Dataflow job from a template.
     * </pre>
     */
    public com.google.dataflow.v1beta3.Job createJobFromTemplate(com.google.dataflow.v1beta3.CreateJobFromTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateJobFromTemplateMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Launch a template.
     * </pre>
     */
    public com.google.dataflow.v1beta3.LaunchTemplateResponse launchTemplate(com.google.dataflow.v1beta3.LaunchTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLaunchTemplateMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get the template associated with a template.
     * </pre>
     */
    public com.google.dataflow.v1beta3.GetTemplateResponse getTemplate(com.google.dataflow.v1beta3.GetTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTemplateMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Provides a method to create Cloud Dataflow jobs from templates.
   * </pre>
   */
  public static final class TemplatesServiceFutureStub extends io.grpc.stub.AbstractFutureStub<TemplatesServiceFutureStub> {
    private TemplatesServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TemplatesServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TemplatesServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a Cloud Dataflow job from a template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.dataflow.v1beta3.Job> createJobFromTemplate(
        com.google.dataflow.v1beta3.CreateJobFromTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateJobFromTemplateMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Launch a template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.dataflow.v1beta3.LaunchTemplateResponse> launchTemplate(
        com.google.dataflow.v1beta3.LaunchTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLaunchTemplateMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get the template associated with a template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.dataflow.v1beta3.GetTemplateResponse> getTemplate(
        com.google.dataflow.v1beta3.GetTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTemplateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_JOB_FROM_TEMPLATE = 0;
  private static final int METHODID_LAUNCH_TEMPLATE = 1;
  private static final int METHODID_GET_TEMPLATE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TemplatesServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TemplatesServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_JOB_FROM_TEMPLATE:
          serviceImpl.createJobFromTemplate((com.google.dataflow.v1beta3.CreateJobFromTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.Job>) responseObserver);
          break;
        case METHODID_LAUNCH_TEMPLATE:
          serviceImpl.launchTemplate((com.google.dataflow.v1beta3.LaunchTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.LaunchTemplateResponse>) responseObserver);
          break;
        case METHODID_GET_TEMPLATE:
          serviceImpl.getTemplate((com.google.dataflow.v1beta3.GetTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.GetTemplateResponse>) responseObserver);
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

  private static abstract class TemplatesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TemplatesServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.dataflow.v1beta3.TemplatesProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TemplatesService");
    }
  }

  private static final class TemplatesServiceFileDescriptorSupplier
      extends TemplatesServiceBaseDescriptorSupplier {
    TemplatesServiceFileDescriptorSupplier() {}
  }

  private static final class TemplatesServiceMethodDescriptorSupplier
      extends TemplatesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TemplatesServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TemplatesServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TemplatesServiceFileDescriptorSupplier())
              .addMethod(getCreateJobFromTemplateMethod())
              .addMethod(getLaunchTemplateMethod())
              .addMethod(getGetTemplateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
