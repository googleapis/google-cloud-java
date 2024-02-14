package com.google.cloud.policytroubleshooter.iam.v3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * IAM Policy Troubleshooter service.
 * This service helps you troubleshoot access issues for Google Cloud resources.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/policytroubleshooter/iam/v3/troubleshooter.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PolicyTroubleshooterGrpc {

  private PolicyTroubleshooterGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.policytroubleshooter.iam.v3.PolicyTroubleshooter";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.policytroubleshooter.iam.v3.TroubleshootIamPolicyRequest,
      com.google.cloud.policytroubleshooter.iam.v3.TroubleshootIamPolicyResponse> getTroubleshootIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TroubleshootIamPolicy",
      requestType = com.google.cloud.policytroubleshooter.iam.v3.TroubleshootIamPolicyRequest.class,
      responseType = com.google.cloud.policytroubleshooter.iam.v3.TroubleshootIamPolicyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.policytroubleshooter.iam.v3.TroubleshootIamPolicyRequest,
      com.google.cloud.policytroubleshooter.iam.v3.TroubleshootIamPolicyResponse> getTroubleshootIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.policytroubleshooter.iam.v3.TroubleshootIamPolicyRequest, com.google.cloud.policytroubleshooter.iam.v3.TroubleshootIamPolicyResponse> getTroubleshootIamPolicyMethod;
    if ((getTroubleshootIamPolicyMethod = PolicyTroubleshooterGrpc.getTroubleshootIamPolicyMethod) == null) {
      synchronized (PolicyTroubleshooterGrpc.class) {
        if ((getTroubleshootIamPolicyMethod = PolicyTroubleshooterGrpc.getTroubleshootIamPolicyMethod) == null) {
          PolicyTroubleshooterGrpc.getTroubleshootIamPolicyMethod = getTroubleshootIamPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.policytroubleshooter.iam.v3.TroubleshootIamPolicyRequest, com.google.cloud.policytroubleshooter.iam.v3.TroubleshootIamPolicyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TroubleshootIamPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.policytroubleshooter.iam.v3.TroubleshootIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.policytroubleshooter.iam.v3.TroubleshootIamPolicyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PolicyTroubleshooterMethodDescriptorSupplier("TroubleshootIamPolicy"))
              .build();
        }
      }
    }
    return getTroubleshootIamPolicyMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PolicyTroubleshooterStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PolicyTroubleshooterStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PolicyTroubleshooterStub>() {
        @java.lang.Override
        public PolicyTroubleshooterStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PolicyTroubleshooterStub(channel, callOptions);
        }
      };
    return PolicyTroubleshooterStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PolicyTroubleshooterBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PolicyTroubleshooterBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PolicyTroubleshooterBlockingStub>() {
        @java.lang.Override
        public PolicyTroubleshooterBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PolicyTroubleshooterBlockingStub(channel, callOptions);
        }
      };
    return PolicyTroubleshooterBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PolicyTroubleshooterFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PolicyTroubleshooterFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PolicyTroubleshooterFutureStub>() {
        @java.lang.Override
        public PolicyTroubleshooterFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PolicyTroubleshooterFutureStub(channel, callOptions);
        }
      };
    return PolicyTroubleshooterFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * IAM Policy Troubleshooter service.
   * This service helps you troubleshoot access issues for Google Cloud resources.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Checks whether a principal has a specific permission for a specific
     * resource, and explains why the principal does or doesn't have that
     * permission.
     * </pre>
     */
    default void troubleshootIamPolicy(com.google.cloud.policytroubleshooter.iam.v3.TroubleshootIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.policytroubleshooter.iam.v3.TroubleshootIamPolicyResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTroubleshootIamPolicyMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service PolicyTroubleshooter.
   * <pre>
   * IAM Policy Troubleshooter service.
   * This service helps you troubleshoot access issues for Google Cloud resources.
   * </pre>
   */
  public static abstract class PolicyTroubleshooterImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return PolicyTroubleshooterGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service PolicyTroubleshooter.
   * <pre>
   * IAM Policy Troubleshooter service.
   * This service helps you troubleshoot access issues for Google Cloud resources.
   * </pre>
   */
  public static final class PolicyTroubleshooterStub
      extends io.grpc.stub.AbstractAsyncStub<PolicyTroubleshooterStub> {
    private PolicyTroubleshooterStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PolicyTroubleshooterStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PolicyTroubleshooterStub(channel, callOptions);
    }

    /**
     * <pre>
     * Checks whether a principal has a specific permission for a specific
     * resource, and explains why the principal does or doesn't have that
     * permission.
     * </pre>
     */
    public void troubleshootIamPolicy(com.google.cloud.policytroubleshooter.iam.v3.TroubleshootIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.policytroubleshooter.iam.v3.TroubleshootIamPolicyResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTroubleshootIamPolicyMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service PolicyTroubleshooter.
   * <pre>
   * IAM Policy Troubleshooter service.
   * This service helps you troubleshoot access issues for Google Cloud resources.
   * </pre>
   */
  public static final class PolicyTroubleshooterBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PolicyTroubleshooterBlockingStub> {
    private PolicyTroubleshooterBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PolicyTroubleshooterBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PolicyTroubleshooterBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Checks whether a principal has a specific permission for a specific
     * resource, and explains why the principal does or doesn't have that
     * permission.
     * </pre>
     */
    public com.google.cloud.policytroubleshooter.iam.v3.TroubleshootIamPolicyResponse troubleshootIamPolicy(com.google.cloud.policytroubleshooter.iam.v3.TroubleshootIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTroubleshootIamPolicyMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service PolicyTroubleshooter.
   * <pre>
   * IAM Policy Troubleshooter service.
   * This service helps you troubleshoot access issues for Google Cloud resources.
   * </pre>
   */
  public static final class PolicyTroubleshooterFutureStub
      extends io.grpc.stub.AbstractFutureStub<PolicyTroubleshooterFutureStub> {
    private PolicyTroubleshooterFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PolicyTroubleshooterFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PolicyTroubleshooterFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Checks whether a principal has a specific permission for a specific
     * resource, and explains why the principal does or doesn't have that
     * permission.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.policytroubleshooter.iam.v3.TroubleshootIamPolicyResponse> troubleshootIamPolicy(
        com.google.cloud.policytroubleshooter.iam.v3.TroubleshootIamPolicyRequest request) {
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
        case METHODID_TROUBLESHOOT_IAM_POLICY:
          serviceImpl.troubleshootIamPolicy((com.google.cloud.policytroubleshooter.iam.v3.TroubleshootIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.policytroubleshooter.iam.v3.TroubleshootIamPolicyResponse>) responseObserver);
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
          getTroubleshootIamPolicyMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.policytroubleshooter.iam.v3.TroubleshootIamPolicyRequest,
              com.google.cloud.policytroubleshooter.iam.v3.TroubleshootIamPolicyResponse>(
                service, METHODID_TROUBLESHOOT_IAM_POLICY)))
        .build();
  }

  private static abstract class PolicyTroubleshooterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PolicyTroubleshooterBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.policytroubleshooter.iam.v3.TroubleshooterProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PolicyTroubleshooter");
    }
  }

  private static final class PolicyTroubleshooterFileDescriptorSupplier
      extends PolicyTroubleshooterBaseDescriptorSupplier {
    PolicyTroubleshooterFileDescriptorSupplier() {}
  }

  private static final class PolicyTroubleshooterMethodDescriptorSupplier
      extends PolicyTroubleshooterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    PolicyTroubleshooterMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (PolicyTroubleshooterGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PolicyTroubleshooterFileDescriptorSupplier())
              .addMethod(getTroubleshootIamPolicyMethod())
              .build();
        }
      }
    }
    return result;
  }
}
