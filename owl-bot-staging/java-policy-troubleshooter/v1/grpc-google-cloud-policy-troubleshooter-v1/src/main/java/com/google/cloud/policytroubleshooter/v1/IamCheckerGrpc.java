package com.google.cloud.policytroubleshooter.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * IAM Policy Troubleshooter service.
 * This service helps you troubleshoot access issues for Google Cloud resources.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/policytroubleshooter/v1/checker.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class IamCheckerGrpc {

  private IamCheckerGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.policytroubleshooter.v1.IamChecker";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.policytroubleshooter.v1.TroubleshootIamPolicyRequest,
      com.google.cloud.policytroubleshooter.v1.TroubleshootIamPolicyResponse> getTroubleshootIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TroubleshootIamPolicy",
      requestType = com.google.cloud.policytroubleshooter.v1.TroubleshootIamPolicyRequest.class,
      responseType = com.google.cloud.policytroubleshooter.v1.TroubleshootIamPolicyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.policytroubleshooter.v1.TroubleshootIamPolicyRequest,
      com.google.cloud.policytroubleshooter.v1.TroubleshootIamPolicyResponse> getTroubleshootIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.policytroubleshooter.v1.TroubleshootIamPolicyRequest, com.google.cloud.policytroubleshooter.v1.TroubleshootIamPolicyResponse> getTroubleshootIamPolicyMethod;
    if ((getTroubleshootIamPolicyMethod = IamCheckerGrpc.getTroubleshootIamPolicyMethod) == null) {
      synchronized (IamCheckerGrpc.class) {
        if ((getTroubleshootIamPolicyMethod = IamCheckerGrpc.getTroubleshootIamPolicyMethod) == null) {
          IamCheckerGrpc.getTroubleshootIamPolicyMethod = getTroubleshootIamPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.policytroubleshooter.v1.TroubleshootIamPolicyRequest, com.google.cloud.policytroubleshooter.v1.TroubleshootIamPolicyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TroubleshootIamPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.policytroubleshooter.v1.TroubleshootIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.policytroubleshooter.v1.TroubleshootIamPolicyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new IamCheckerMethodDescriptorSupplier("TroubleshootIamPolicy"))
              .build();
        }
      }
    }
    return getTroubleshootIamPolicyMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static IamCheckerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IamCheckerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IamCheckerStub>() {
        @java.lang.Override
        public IamCheckerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IamCheckerStub(channel, callOptions);
        }
      };
    return IamCheckerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static IamCheckerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IamCheckerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IamCheckerBlockingStub>() {
        @java.lang.Override
        public IamCheckerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IamCheckerBlockingStub(channel, callOptions);
        }
      };
    return IamCheckerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static IamCheckerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IamCheckerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IamCheckerFutureStub>() {
        @java.lang.Override
        public IamCheckerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IamCheckerFutureStub(channel, callOptions);
        }
      };
    return IamCheckerFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * IAM Policy Troubleshooter service.
   * This service helps you troubleshoot access issues for Google Cloud resources.
   * </pre>
   */
  public static abstract class IamCheckerImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Checks whether a member has a specific permission for a specific resource,
     * and explains why the member does or does not have that permission.
     * </pre>
     */
    public void troubleshootIamPolicy(com.google.cloud.policytroubleshooter.v1.TroubleshootIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.policytroubleshooter.v1.TroubleshootIamPolicyResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTroubleshootIamPolicyMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTroubleshootIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.policytroubleshooter.v1.TroubleshootIamPolicyRequest,
                com.google.cloud.policytroubleshooter.v1.TroubleshootIamPolicyResponse>(
                  this, METHODID_TROUBLESHOOT_IAM_POLICY)))
          .build();
    }
  }

  /**
   * <pre>
   * IAM Policy Troubleshooter service.
   * This service helps you troubleshoot access issues for Google Cloud resources.
   * </pre>
   */
  public static final class IamCheckerStub extends io.grpc.stub.AbstractAsyncStub<IamCheckerStub> {
    private IamCheckerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IamCheckerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IamCheckerStub(channel, callOptions);
    }

    /**
     * <pre>
     * Checks whether a member has a specific permission for a specific resource,
     * and explains why the member does or does not have that permission.
     * </pre>
     */
    public void troubleshootIamPolicy(com.google.cloud.policytroubleshooter.v1.TroubleshootIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.policytroubleshooter.v1.TroubleshootIamPolicyResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTroubleshootIamPolicyMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * IAM Policy Troubleshooter service.
   * This service helps you troubleshoot access issues for Google Cloud resources.
   * </pre>
   */
  public static final class IamCheckerBlockingStub extends io.grpc.stub.AbstractBlockingStub<IamCheckerBlockingStub> {
    private IamCheckerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IamCheckerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IamCheckerBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Checks whether a member has a specific permission for a specific resource,
     * and explains why the member does or does not have that permission.
     * </pre>
     */
    public com.google.cloud.policytroubleshooter.v1.TroubleshootIamPolicyResponse troubleshootIamPolicy(com.google.cloud.policytroubleshooter.v1.TroubleshootIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTroubleshootIamPolicyMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * IAM Policy Troubleshooter service.
   * This service helps you troubleshoot access issues for Google Cloud resources.
   * </pre>
   */
  public static final class IamCheckerFutureStub extends io.grpc.stub.AbstractFutureStub<IamCheckerFutureStub> {
    private IamCheckerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IamCheckerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IamCheckerFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Checks whether a member has a specific permission for a specific resource,
     * and explains why the member does or does not have that permission.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.policytroubleshooter.v1.TroubleshootIamPolicyResponse> troubleshootIamPolicy(
        com.google.cloud.policytroubleshooter.v1.TroubleshootIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTroubleshootIamPolicyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TROUBLESHOOT_IAM_POLICY = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final IamCheckerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(IamCheckerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TROUBLESHOOT_IAM_POLICY:
          serviceImpl.troubleshootIamPolicy((com.google.cloud.policytroubleshooter.v1.TroubleshootIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.policytroubleshooter.v1.TroubleshootIamPolicyResponse>) responseObserver);
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

  private static abstract class IamCheckerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    IamCheckerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.policytroubleshooter.v1.IAMCheckerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("IamChecker");
    }
  }

  private static final class IamCheckerFileDescriptorSupplier
      extends IamCheckerBaseDescriptorSupplier {
    IamCheckerFileDescriptorSupplier() {}
  }

  private static final class IamCheckerMethodDescriptorSupplier
      extends IamCheckerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    IamCheckerMethodDescriptorSupplier(String methodName) {
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
      synchronized (IamCheckerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new IamCheckerFileDescriptorSupplier())
              .addMethod(getTroubleshootIamPolicyMethod())
              .build();
        }
      }
    }
    return result;
  }
}
