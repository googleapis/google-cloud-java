package com.google.cloud.lifesciences.v2beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * A service for running workflows, such as pipelines consisting of Docker
 * containers.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/lifesciences/v2beta/workflows.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class WorkflowsServiceV2BetaGrpc {

  private WorkflowsServiceV2BetaGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.lifesciences.v2beta.WorkflowsServiceV2Beta";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.lifesciences.v2beta.RunPipelineRequest,
      com.google.longrunning.Operation> getRunPipelineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RunPipeline",
      requestType = com.google.cloud.lifesciences.v2beta.RunPipelineRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.lifesciences.v2beta.RunPipelineRequest,
      com.google.longrunning.Operation> getRunPipelineMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.lifesciences.v2beta.RunPipelineRequest, com.google.longrunning.Operation> getRunPipelineMethod;
    if ((getRunPipelineMethod = WorkflowsServiceV2BetaGrpc.getRunPipelineMethod) == null) {
      synchronized (WorkflowsServiceV2BetaGrpc.class) {
        if ((getRunPipelineMethod = WorkflowsServiceV2BetaGrpc.getRunPipelineMethod) == null) {
          WorkflowsServiceV2BetaGrpc.getRunPipelineMethod = getRunPipelineMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.lifesciences.v2beta.RunPipelineRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RunPipeline"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.lifesciences.v2beta.RunPipelineRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new WorkflowsServiceV2BetaMethodDescriptorSupplier("RunPipeline"))
              .build();
        }
      }
    }
    return getRunPipelineMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WorkflowsServiceV2BetaStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkflowsServiceV2BetaStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WorkflowsServiceV2BetaStub>() {
        @java.lang.Override
        public WorkflowsServiceV2BetaStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WorkflowsServiceV2BetaStub(channel, callOptions);
        }
      };
    return WorkflowsServiceV2BetaStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WorkflowsServiceV2BetaBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkflowsServiceV2BetaBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WorkflowsServiceV2BetaBlockingStub>() {
        @java.lang.Override
        public WorkflowsServiceV2BetaBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WorkflowsServiceV2BetaBlockingStub(channel, callOptions);
        }
      };
    return WorkflowsServiceV2BetaBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WorkflowsServiceV2BetaFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkflowsServiceV2BetaFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WorkflowsServiceV2BetaFutureStub>() {
        @java.lang.Override
        public WorkflowsServiceV2BetaFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WorkflowsServiceV2BetaFutureStub(channel, callOptions);
        }
      };
    return WorkflowsServiceV2BetaFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * A service for running workflows, such as pipelines consisting of Docker
   * containers.
   * </pre>
   */
  public static abstract class WorkflowsServiceV2BetaImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Runs a pipeline.  The returned Operation's [metadata]
     * [google.longrunning.Operation.metadata] field will contain a
     * [google.cloud.lifesciences.v2beta.Metadata][google.cloud.lifesciences.v2beta.Metadata] object describing the status
     * of the pipeline execution. The
     * [response][google.longrunning.Operation.response] field will contain a
     * [google.cloud.lifesciences.v2beta.RunPipelineResponse][google.cloud.lifesciences.v2beta.RunPipelineResponse] object if the
     * pipeline completes successfully.
     * **Note:** Before you can use this method, the *Life Sciences Service Agent*
     * must have access to your project. This is done automatically when the
     * Cloud Life Sciences API is first enabled, but if you delete this permission
     * you must disable and re-enable the API to grant the Life Sciences
     * Service Agent the required permissions.
     * Authorization requires the following [Google
     * IAM](https://cloud.google.com/iam/) permission:
     * * `lifesciences.workflows.run`
     * </pre>
     */
    public void runPipeline(com.google.cloud.lifesciences.v2beta.RunPipelineRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRunPipelineMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRunPipelineMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.lifesciences.v2beta.RunPipelineRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_RUN_PIPELINE)))
          .build();
    }
  }

  /**
   * <pre>
   * A service for running workflows, such as pipelines consisting of Docker
   * containers.
   * </pre>
   */
  public static final class WorkflowsServiceV2BetaStub extends io.grpc.stub.AbstractAsyncStub<WorkflowsServiceV2BetaStub> {
    private WorkflowsServiceV2BetaStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkflowsServiceV2BetaStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkflowsServiceV2BetaStub(channel, callOptions);
    }

    /**
     * <pre>
     * Runs a pipeline.  The returned Operation's [metadata]
     * [google.longrunning.Operation.metadata] field will contain a
     * [google.cloud.lifesciences.v2beta.Metadata][google.cloud.lifesciences.v2beta.Metadata] object describing the status
     * of the pipeline execution. The
     * [response][google.longrunning.Operation.response] field will contain a
     * [google.cloud.lifesciences.v2beta.RunPipelineResponse][google.cloud.lifesciences.v2beta.RunPipelineResponse] object if the
     * pipeline completes successfully.
     * **Note:** Before you can use this method, the *Life Sciences Service Agent*
     * must have access to your project. This is done automatically when the
     * Cloud Life Sciences API is first enabled, but if you delete this permission
     * you must disable and re-enable the API to grant the Life Sciences
     * Service Agent the required permissions.
     * Authorization requires the following [Google
     * IAM](https://cloud.google.com/iam/) permission:
     * * `lifesciences.workflows.run`
     * </pre>
     */
    public void runPipeline(com.google.cloud.lifesciences.v2beta.RunPipelineRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRunPipelineMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * A service for running workflows, such as pipelines consisting of Docker
   * containers.
   * </pre>
   */
  public static final class WorkflowsServiceV2BetaBlockingStub extends io.grpc.stub.AbstractBlockingStub<WorkflowsServiceV2BetaBlockingStub> {
    private WorkflowsServiceV2BetaBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkflowsServiceV2BetaBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkflowsServiceV2BetaBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Runs a pipeline.  The returned Operation's [metadata]
     * [google.longrunning.Operation.metadata] field will contain a
     * [google.cloud.lifesciences.v2beta.Metadata][google.cloud.lifesciences.v2beta.Metadata] object describing the status
     * of the pipeline execution. The
     * [response][google.longrunning.Operation.response] field will contain a
     * [google.cloud.lifesciences.v2beta.RunPipelineResponse][google.cloud.lifesciences.v2beta.RunPipelineResponse] object if the
     * pipeline completes successfully.
     * **Note:** Before you can use this method, the *Life Sciences Service Agent*
     * must have access to your project. This is done automatically when the
     * Cloud Life Sciences API is first enabled, but if you delete this permission
     * you must disable and re-enable the API to grant the Life Sciences
     * Service Agent the required permissions.
     * Authorization requires the following [Google
     * IAM](https://cloud.google.com/iam/) permission:
     * * `lifesciences.workflows.run`
     * </pre>
     */
    public com.google.longrunning.Operation runPipeline(com.google.cloud.lifesciences.v2beta.RunPipelineRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRunPipelineMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * A service for running workflows, such as pipelines consisting of Docker
   * containers.
   * </pre>
   */
  public static final class WorkflowsServiceV2BetaFutureStub extends io.grpc.stub.AbstractFutureStub<WorkflowsServiceV2BetaFutureStub> {
    private WorkflowsServiceV2BetaFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkflowsServiceV2BetaFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkflowsServiceV2BetaFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Runs a pipeline.  The returned Operation's [metadata]
     * [google.longrunning.Operation.metadata] field will contain a
     * [google.cloud.lifesciences.v2beta.Metadata][google.cloud.lifesciences.v2beta.Metadata] object describing the status
     * of the pipeline execution. The
     * [response][google.longrunning.Operation.response] field will contain a
     * [google.cloud.lifesciences.v2beta.RunPipelineResponse][google.cloud.lifesciences.v2beta.RunPipelineResponse] object if the
     * pipeline completes successfully.
     * **Note:** Before you can use this method, the *Life Sciences Service Agent*
     * must have access to your project. This is done automatically when the
     * Cloud Life Sciences API is first enabled, but if you delete this permission
     * you must disable and re-enable the API to grant the Life Sciences
     * Service Agent the required permissions.
     * Authorization requires the following [Google
     * IAM](https://cloud.google.com/iam/) permission:
     * * `lifesciences.workflows.run`
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> runPipeline(
        com.google.cloud.lifesciences.v2beta.RunPipelineRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRunPipelineMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RUN_PIPELINE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WorkflowsServiceV2BetaImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WorkflowsServiceV2BetaImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RUN_PIPELINE:
          serviceImpl.runPipeline((com.google.cloud.lifesciences.v2beta.RunPipelineRequest) request,
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

  private static abstract class WorkflowsServiceV2BetaBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WorkflowsServiceV2BetaBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.lifesciences.v2beta.WorkflowsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WorkflowsServiceV2Beta");
    }
  }

  private static final class WorkflowsServiceV2BetaFileDescriptorSupplier
      extends WorkflowsServiceV2BetaBaseDescriptorSupplier {
    WorkflowsServiceV2BetaFileDescriptorSupplier() {}
  }

  private static final class WorkflowsServiceV2BetaMethodDescriptorSupplier
      extends WorkflowsServiceV2BetaBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WorkflowsServiceV2BetaMethodDescriptorSupplier(String methodName) {
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
      synchronized (WorkflowsServiceV2BetaGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WorkflowsServiceV2BetaFileDescriptorSupplier())
              .addMethod(getRunPipelineMethod())
              .build();
        }
      }
    }
    return result;
  }
}
