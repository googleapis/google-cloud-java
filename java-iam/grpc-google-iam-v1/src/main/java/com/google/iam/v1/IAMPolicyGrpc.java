package com.google.iam.v1;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 * <pre>
 * ## API Overview
 * Manages Identity and Access Management (IAM) policies.
 * Any implementation of an API that offers access control features
 * implements the google.iam.v1.IAMPolicy interface.
 * ## Data model
 * Access control is applied when a principal (user or service account), takes
 * some action on a resource exposed by a service. Resources, identified by
 * URI-like names, are the unit of access control specification. Service
 * implementations can choose the granularity of access control and the
 * supported permissions for their resources.
 * For example one database service may allow access control to be
 * specified only at the Table level, whereas another might allow access control
 * to also be specified at the Column level.
 * ## Policy Structure
 * See google.iam.v1.Policy
 * This is intentionally not a CRUD style API because access control policies
 * are created and deleted implicitly with the resources to which they are
 * attached.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.2.0)",
    comments = "Source: google/iam/v1/iam_policy.proto")
public final class IAMPolicyGrpc {

  private IAMPolicyGrpc() {}

  public static final String SERVICE_NAME = "google.iam.v1.IAMPolicy";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> METHOD_SET_IAM_POLICY =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.iam.v1.IAMPolicy", "SetIamPolicy"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.iam.v1.Policy.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> METHOD_GET_IAM_POLICY =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.iam.v1.IAMPolicy", "GetIamPolicy"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.iam.v1.Policy.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> METHOD_TEST_IAM_PERMISSIONS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.iam.v1.IAMPolicy", "TestIamPermissions"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.iam.v1.TestIamPermissionsRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.iam.v1.TestIamPermissionsResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static IAMPolicyStub newStub(io.grpc.Channel channel) {
    return new IAMPolicyStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static IAMPolicyBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new IAMPolicyBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static IAMPolicyFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new IAMPolicyFutureStub(channel);
  }

  /**
   * <pre>
   * ## API Overview
   * Manages Identity and Access Management (IAM) policies.
   * Any implementation of an API that offers access control features
   * implements the google.iam.v1.IAMPolicy interface.
   * ## Data model
   * Access control is applied when a principal (user or service account), takes
   * some action on a resource exposed by a service. Resources, identified by
   * URI-like names, are the unit of access control specification. Service
   * implementations can choose the granularity of access control and the
   * supported permissions for their resources.
   * For example one database service may allow access control to be
   * specified only at the Table level, whereas another might allow access control
   * to also be specified at the Column level.
   * ## Policy Structure
   * See google.iam.v1.Policy
   * This is intentionally not a CRUD style API because access control policies
   * are created and deleted implicitly with the resources to which they are
   * attached.
   * </pre>
   */
  public static abstract class IAMPolicyImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sets the access control policy on the specified resource. Replaces any
     * existing policy.
     * </pre>
     */
    public void setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_IAM_POLICY, responseObserver);
    }

    /**
     * <pre>
     * Gets the access control policy for a resource.
     * Returns an empty policy if the resource exists and does not have a policy
     * set.
     * </pre>
     */
    public void getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_IAM_POLICY, responseObserver);
    }

    /**
     * <pre>
     * Returns permissions that a caller has on the specified resource.
     * If the resource does not exist, this will return an empty set of
     * permissions, not a NOT_FOUND error.
     * </pre>
     */
    public void testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_TEST_IAM_PERMISSIONS, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_SET_IAM_POLICY,
            asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.SetIamPolicyRequest,
                com.google.iam.v1.Policy>(
                  this, METHODID_SET_IAM_POLICY)))
          .addMethod(
            METHOD_GET_IAM_POLICY,
            asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.GetIamPolicyRequest,
                com.google.iam.v1.Policy>(
                  this, METHODID_GET_IAM_POLICY)))
          .addMethod(
            METHOD_TEST_IAM_PERMISSIONS,
            asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.TestIamPermissionsRequest,
                com.google.iam.v1.TestIamPermissionsResponse>(
                  this, METHODID_TEST_IAM_PERMISSIONS)))
          .build();
    }
  }

  /**
   * <pre>
   * ## API Overview
   * Manages Identity and Access Management (IAM) policies.
   * Any implementation of an API that offers access control features
   * implements the google.iam.v1.IAMPolicy interface.
   * ## Data model
   * Access control is applied when a principal (user or service account), takes
   * some action on a resource exposed by a service. Resources, identified by
   * URI-like names, are the unit of access control specification. Service
   * implementations can choose the granularity of access control and the
   * supported permissions for their resources.
   * For example one database service may allow access control to be
   * specified only at the Table level, whereas another might allow access control
   * to also be specified at the Column level.
   * ## Policy Structure
   * See google.iam.v1.Policy
   * This is intentionally not a CRUD style API because access control policies
   * are created and deleted implicitly with the resources to which they are
   * attached.
   * </pre>
   */
  public static final class IAMPolicyStub extends io.grpc.stub.AbstractStub<IAMPolicyStub> {
    private IAMPolicyStub(io.grpc.Channel channel) {
      super(channel);
    }

    private IAMPolicyStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IAMPolicyStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new IAMPolicyStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sets the access control policy on the specified resource. Replaces any
     * existing policy.
     * </pre>
     */
    public void setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_IAM_POLICY, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the access control policy for a resource.
     * Returns an empty policy if the resource exists and does not have a policy
     * set.
     * </pre>
     */
    public void getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_IAM_POLICY, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns permissions that a caller has on the specified resource.
     * If the resource does not exist, this will return an empty set of
     * permissions, not a NOT_FOUND error.
     * </pre>
     */
    public void testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_TEST_IAM_PERMISSIONS, getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * ## API Overview
   * Manages Identity and Access Management (IAM) policies.
   * Any implementation of an API that offers access control features
   * implements the google.iam.v1.IAMPolicy interface.
   * ## Data model
   * Access control is applied when a principal (user or service account), takes
   * some action on a resource exposed by a service. Resources, identified by
   * URI-like names, are the unit of access control specification. Service
   * implementations can choose the granularity of access control and the
   * supported permissions for their resources.
   * For example one database service may allow access control to be
   * specified only at the Table level, whereas another might allow access control
   * to also be specified at the Column level.
   * ## Policy Structure
   * See google.iam.v1.Policy
   * This is intentionally not a CRUD style API because access control policies
   * are created and deleted implicitly with the resources to which they are
   * attached.
   * </pre>
   */
  public static final class IAMPolicyBlockingStub extends io.grpc.stub.AbstractStub<IAMPolicyBlockingStub> {
    private IAMPolicyBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private IAMPolicyBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IAMPolicyBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new IAMPolicyBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sets the access control policy on the specified resource. Replaces any
     * existing policy.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_IAM_POLICY, getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the access control policy for a resource.
     * Returns an empty policy if the resource exists and does not have a policy
     * set.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_IAM_POLICY, getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns permissions that a caller has on the specified resource.
     * If the resource does not exist, this will return an empty set of
     * permissions, not a NOT_FOUND error.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_TEST_IAM_PERMISSIONS, getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * ## API Overview
   * Manages Identity and Access Management (IAM) policies.
   * Any implementation of an API that offers access control features
   * implements the google.iam.v1.IAMPolicy interface.
   * ## Data model
   * Access control is applied when a principal (user or service account), takes
   * some action on a resource exposed by a service. Resources, identified by
   * URI-like names, are the unit of access control specification. Service
   * implementations can choose the granularity of access control and the
   * supported permissions for their resources.
   * For example one database service may allow access control to be
   * specified only at the Table level, whereas another might allow access control
   * to also be specified at the Column level.
   * ## Policy Structure
   * See google.iam.v1.Policy
   * This is intentionally not a CRUD style API because access control policies
   * are created and deleted implicitly with the resources to which they are
   * attached.
   * </pre>
   */
  public static final class IAMPolicyFutureStub extends io.grpc.stub.AbstractStub<IAMPolicyFutureStub> {
    private IAMPolicyFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private IAMPolicyFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IAMPolicyFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new IAMPolicyFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sets the access control policy on the specified resource. Replaces any
     * existing policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy> setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_IAM_POLICY, getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the access control policy for a resource.
     * Returns an empty policy if the resource exists and does not have a policy
     * set.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy> getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_IAM_POLICY, getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns permissions that a caller has on the specified resource.
     * If the resource does not exist, this will return an empty set of
     * permissions, not a NOT_FOUND error.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.TestIamPermissionsResponse> testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_TEST_IAM_PERMISSIONS, getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_IAM_POLICY = 0;
  private static final int METHODID_GET_IAM_POLICY = 1;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final IAMPolicyImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(IAMPolicyImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SET_IAM_POLICY:
          serviceImpl.setIamPolicy((com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy((com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_TEST_IAM_PERMISSIONS:
          serviceImpl.testIamPermissions((com.google.iam.v1.TestIamPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>) responseObserver);
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

  private static final class IAMPolicyDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.iam.v1.IamPolicyProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (IAMPolicyGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new IAMPolicyDescriptorSupplier())
              .addMethod(METHOD_SET_IAM_POLICY)
              .addMethod(METHOD_GET_IAM_POLICY)
              .addMethod(METHOD_TEST_IAM_PERMISSIONS)
              .build();
        }
      }
    }
    return result;
  }
}
