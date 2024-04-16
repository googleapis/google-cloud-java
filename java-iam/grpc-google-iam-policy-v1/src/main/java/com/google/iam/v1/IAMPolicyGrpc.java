/*
 * Copyright 2024 Google LLC
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
package com.google.iam.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * API Overview
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
    value = "by gRPC proto compiler",
    comments = "Source: google/iam/v1/iam_policy.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class IAMPolicyGrpc {

  private IAMPolicyGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.iam.v1.IAMPolicy";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> getSetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetIamPolicy",
      requestType = com.google.iam.v1.SetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> getSetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy> getSetIamPolicyMethod;
    if ((getSetIamPolicyMethod = IAMPolicyGrpc.getSetIamPolicyMethod) == null) {
      synchronized (IAMPolicyGrpc.class) {
        if ((getSetIamPolicyMethod = IAMPolicyGrpc.getSetIamPolicyMethod) == null) {
          IAMPolicyGrpc.getSetIamPolicyMethod = getSetIamPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetIamPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.Policy.getDefaultInstance()))
              .setSchemaDescriptor(new IAMPolicyMethodDescriptorSupplier("SetIamPolicy"))
              .build();
        }
      }
    }
    return getSetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> getGetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIamPolicy",
      requestType = com.google.iam.v1.GetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> getGetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy> getGetIamPolicyMethod;
    if ((getGetIamPolicyMethod = IAMPolicyGrpc.getGetIamPolicyMethod) == null) {
      synchronized (IAMPolicyGrpc.class) {
        if ((getGetIamPolicyMethod = IAMPolicyGrpc.getGetIamPolicyMethod) == null) {
          IAMPolicyGrpc.getGetIamPolicyMethod = getGetIamPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIamPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.Policy.getDefaultInstance()))
              .setSchemaDescriptor(new IAMPolicyMethodDescriptorSupplier("GetIamPolicy"))
              .build();
        }
      }
    }
    return getGetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestIamPermissions",
      requestType = com.google.iam.v1.TestIamPermissionsRequest.class,
      responseType = com.google.iam.v1.TestIamPermissionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod;
    if ((getTestIamPermissionsMethod = IAMPolicyGrpc.getTestIamPermissionsMethod) == null) {
      synchronized (IAMPolicyGrpc.class) {
        if ((getTestIamPermissionsMethod = IAMPolicyGrpc.getTestIamPermissionsMethod) == null) {
          IAMPolicyGrpc.getTestIamPermissionsMethod = getTestIamPermissionsMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestIamPermissions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.TestIamPermissionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new IAMPolicyMethodDescriptorSupplier("TestIamPermissions"))
              .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static IAMPolicyStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IAMPolicyStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IAMPolicyStub>() {
        @java.lang.Override
        public IAMPolicyStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IAMPolicyStub(channel, callOptions);
        }
      };
    return IAMPolicyStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static IAMPolicyBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IAMPolicyBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IAMPolicyBlockingStub>() {
        @java.lang.Override
        public IAMPolicyBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IAMPolicyBlockingStub(channel, callOptions);
        }
      };
    return IAMPolicyBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static IAMPolicyFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IAMPolicyFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IAMPolicyFutureStub>() {
        @java.lang.Override
        public IAMPolicyFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IAMPolicyFutureStub(channel, callOptions);
        }
      };
    return IAMPolicyFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * API Overview
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
  public interface AsyncService {

    /**
     * <pre>
     * Sets the access control policy on the specified resource. Replaces any
     * existing policy.
     * Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
     * </pre>
     */
    default void setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetIamPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the access control policy for a resource.
     * Returns an empty policy if the resource exists and does not have a policy
     * set.
     * </pre>
     */
    default void getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetIamPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns permissions that a caller has on the specified resource.
     * If the resource does not exist, this will return an empty set of
     * permissions, not a `NOT_FOUND` error.
     * Note: This operation is designed to be used for building permission-aware
     * UIs and command-line tools, not for authorization checking. This operation
     * may "fail open" without warning.
     * </pre>
     */
    default void testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTestIamPermissionsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service IAMPolicy.
   * <pre>
   * API Overview
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
  public static abstract class IAMPolicyImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return IAMPolicyGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service IAMPolicy.
   * <pre>
   * API Overview
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
  public static final class IAMPolicyStub
      extends io.grpc.stub.AbstractAsyncStub<IAMPolicyStub> {
    private IAMPolicyStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IAMPolicyStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IAMPolicyStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sets the access control policy on the specified resource. Replaces any
     * existing policy.
     * Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
     * </pre>
     */
    public void setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request, responseObserver);
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
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns permissions that a caller has on the specified resource.
     * If the resource does not exist, this will return an empty set of
     * permissions, not a `NOT_FOUND` error.
     * Note: This operation is designed to be used for building permission-aware
     * UIs and command-line tools, not for authorization checking. This operation
     * may "fail open" without warning.
     * </pre>
     */
    public void testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service IAMPolicy.
   * <pre>
   * API Overview
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
  public static final class IAMPolicyBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<IAMPolicyBlockingStub> {
    private IAMPolicyBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IAMPolicyBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IAMPolicyBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sets the access control policy on the specified resource. Replaces any
     * existing policy.
     * Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the access control policy for a resource.
     * Returns an empty policy if the resource exists and does not have a policy
     * set.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns permissions that a caller has on the specified resource.
     * If the resource does not exist, this will return an empty set of
     * permissions, not a `NOT_FOUND` error.
     * Note: This operation is designed to be used for building permission-aware
     * UIs and command-line tools, not for authorization checking. This operation
     * may "fail open" without warning.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service IAMPolicy.
   * <pre>
   * API Overview
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
  public static final class IAMPolicyFutureStub
      extends io.grpc.stub.AbstractFutureStub<IAMPolicyFutureStub> {
    private IAMPolicyFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IAMPolicyFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IAMPolicyFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sets the access control policy on the specified resource. Replaces any
     * existing policy.
     * Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy> setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request);
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
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns permissions that a caller has on the specified resource.
     * If the resource does not exist, this will return an empty set of
     * permissions, not a `NOT_FOUND` error.
     * Note: This operation is designed to be used for building permission-aware
     * UIs and command-line tools, not for authorization checking. This operation
     * may "fail open" without warning.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.TestIamPermissionsResponse> testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSetIamPolicyMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.iam.v1.SetIamPolicyRequest,
              com.google.iam.v1.Policy>(
                service, METHODID_SET_IAM_POLICY)))
        .addMethod(
          getGetIamPolicyMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.iam.v1.GetIamPolicyRequest,
              com.google.iam.v1.Policy>(
                service, METHODID_GET_IAM_POLICY)))
        .addMethod(
          getTestIamPermissionsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.iam.v1.TestIamPermissionsRequest,
              com.google.iam.v1.TestIamPermissionsResponse>(
                service, METHODID_TEST_IAM_PERMISSIONS)))
        .build();
  }

  private static abstract class IAMPolicyBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    IAMPolicyBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.iam.v1.IamPolicyProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("IAMPolicy");
    }
  }

  private static final class IAMPolicyFileDescriptorSupplier
      extends IAMPolicyBaseDescriptorSupplier {
    IAMPolicyFileDescriptorSupplier() {}
  }

  private static final class IAMPolicyMethodDescriptorSupplier
      extends IAMPolicyBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    IAMPolicyMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (IAMPolicyGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new IAMPolicyFileDescriptorSupplier())
              .addMethod(getSetIamPolicyMethod())
              .addMethod(getGetIamPolicyMethod())
              .addMethod(getTestIamPermissionsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
