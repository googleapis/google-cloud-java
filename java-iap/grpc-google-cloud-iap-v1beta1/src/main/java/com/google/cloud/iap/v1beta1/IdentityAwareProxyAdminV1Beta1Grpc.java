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
package com.google.cloud.iap.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * APIs for Identity-Aware Proxy Admin configurations.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/iap/v1beta1/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class IdentityAwareProxyAdminV1Beta1Grpc {

  private IdentityAwareProxyAdminV1Beta1Grpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.iap.v1beta1.IdentityAwareProxyAdminV1Beta1";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetIamPolicy",
      requestType = com.google.iam.v1.SetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
        getSetIamPolicyMethod;
    if ((getSetIamPolicyMethod = IdentityAwareProxyAdminV1Beta1Grpc.getSetIamPolicyMethod)
        == null) {
      synchronized (IdentityAwareProxyAdminV1Beta1Grpc.class) {
        if ((getSetIamPolicyMethod = IdentityAwareProxyAdminV1Beta1Grpc.getSetIamPolicyMethod)
            == null) {
          IdentityAwareProxyAdminV1Beta1Grpc.getSetIamPolicyMethod =
              getSetIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IdentityAwareProxyAdminV1Beta1MethodDescriptorSupplier(
                              "SetIamPolicy"))
                      .build();
        }
      }
    }
    return getSetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIamPolicy",
      requestType = com.google.iam.v1.GetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
        getGetIamPolicyMethod;
    if ((getGetIamPolicyMethod = IdentityAwareProxyAdminV1Beta1Grpc.getGetIamPolicyMethod)
        == null) {
      synchronized (IdentityAwareProxyAdminV1Beta1Grpc.class) {
        if ((getGetIamPolicyMethod = IdentityAwareProxyAdminV1Beta1Grpc.getGetIamPolicyMethod)
            == null) {
          IdentityAwareProxyAdminV1Beta1Grpc.getGetIamPolicyMethod =
              getGetIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IdentityAwareProxyAdminV1Beta1MethodDescriptorSupplier(
                              "GetIamPolicy"))
                      .build();
        }
      }
    }
    return getGetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestIamPermissions",
      requestType = com.google.iam.v1.TestIamPermissionsRequest.class,
      responseType = com.google.iam.v1.TestIamPermissionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v1.TestIamPermissionsRequest,
            com.google.iam.v1.TestIamPermissionsResponse>
        getTestIamPermissionsMethod;
    if ((getTestIamPermissionsMethod =
            IdentityAwareProxyAdminV1Beta1Grpc.getTestIamPermissionsMethod)
        == null) {
      synchronized (IdentityAwareProxyAdminV1Beta1Grpc.class) {
        if ((getTestIamPermissionsMethod =
                IdentityAwareProxyAdminV1Beta1Grpc.getTestIamPermissionsMethod)
            == null) {
          IdentityAwareProxyAdminV1Beta1Grpc.getTestIamPermissionsMethod =
              getTestIamPermissionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.TestIamPermissionsRequest,
                          com.google.iam.v1.TestIamPermissionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestIamPermissions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.TestIamPermissionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.TestIamPermissionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IdentityAwareProxyAdminV1Beta1MethodDescriptorSupplier(
                              "TestIamPermissions"))
                      .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static IdentityAwareProxyAdminV1Beta1Stub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IdentityAwareProxyAdminV1Beta1Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IdentityAwareProxyAdminV1Beta1Stub>() {
          @java.lang.Override
          public IdentityAwareProxyAdminV1Beta1Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IdentityAwareProxyAdminV1Beta1Stub(channel, callOptions);
          }
        };
    return IdentityAwareProxyAdminV1Beta1Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static IdentityAwareProxyAdminV1Beta1BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IdentityAwareProxyAdminV1Beta1BlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IdentityAwareProxyAdminV1Beta1BlockingStub>() {
          @java.lang.Override
          public IdentityAwareProxyAdminV1Beta1BlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IdentityAwareProxyAdminV1Beta1BlockingStub(channel, callOptions);
          }
        };
    return IdentityAwareProxyAdminV1Beta1BlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static IdentityAwareProxyAdminV1Beta1FutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IdentityAwareProxyAdminV1Beta1FutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IdentityAwareProxyAdminV1Beta1FutureStub>() {
          @java.lang.Override
          public IdentityAwareProxyAdminV1Beta1FutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IdentityAwareProxyAdminV1Beta1FutureStub(channel, callOptions);
          }
        };
    return IdentityAwareProxyAdminV1Beta1FutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * APIs for Identity-Aware Proxy Admin configurations.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Sets the access control policy for an Identity-Aware Proxy protected
     * resource. Replaces any existing policy.
     * More information about managing access via IAP can be found at:
     * https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api
     * </pre>
     */
    default void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for an Identity-Aware Proxy protected
     * resource.
     * More information about managing access via IAP can be found at:
     * https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api
     * </pre>
     */
    default void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that a caller has on the Identity-Aware Proxy protected
     * resource. If the resource does not exist or the caller does not have
     * Identity-Aware Proxy permissions a [google.rpc.Code.PERMISSION_DENIED]
     * will be returned.
     * More information about managing access via IAP can be found at:
     * https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api
     * </pre>
     */
    default void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getTestIamPermissionsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service IdentityAwareProxyAdminV1Beta1.
   *
   * <pre>
   * APIs for Identity-Aware Proxy Admin configurations.
   * </pre>
   */
  public abstract static class IdentityAwareProxyAdminV1Beta1ImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return IdentityAwareProxyAdminV1Beta1Grpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service IdentityAwareProxyAdminV1Beta1.
   *
   * <pre>
   * APIs for Identity-Aware Proxy Admin configurations.
   * </pre>
   */
  public static final class IdentityAwareProxyAdminV1Beta1Stub
      extends io.grpc.stub.AbstractAsyncStub<IdentityAwareProxyAdminV1Beta1Stub> {
    private IdentityAwareProxyAdminV1Beta1Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IdentityAwareProxyAdminV1Beta1Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IdentityAwareProxyAdminV1Beta1Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy for an Identity-Aware Proxy protected
     * resource. Replaces any existing policy.
     * More information about managing access via IAP can be found at:
     * https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api
     * </pre>
     */
    public void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for an Identity-Aware Proxy protected
     * resource.
     * More information about managing access via IAP can be found at:
     * https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api
     * </pre>
     */
    public void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that a caller has on the Identity-Aware Proxy protected
     * resource. If the resource does not exist or the caller does not have
     * Identity-Aware Proxy permissions a [google.rpc.Code.PERMISSION_DENIED]
     * will be returned.
     * More information about managing access via IAP can be found at:
     * https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api
     * </pre>
     */
    public void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service IdentityAwareProxyAdminV1Beta1.
   *
   * <pre>
   * APIs for Identity-Aware Proxy Admin configurations.
   * </pre>
   */
  public static final class IdentityAwareProxyAdminV1Beta1BlockingStub
      extends io.grpc.stub.AbstractBlockingStub<IdentityAwareProxyAdminV1Beta1BlockingStub> {
    private IdentityAwareProxyAdminV1Beta1BlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IdentityAwareProxyAdminV1Beta1BlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IdentityAwareProxyAdminV1Beta1BlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy for an Identity-Aware Proxy protected
     * resource. Replaces any existing policy.
     * More information about managing access via IAP can be found at:
     * https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for an Identity-Aware Proxy protected
     * resource.
     * More information about managing access via IAP can be found at:
     * https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that a caller has on the Identity-Aware Proxy protected
     * resource. If the resource does not exist or the caller does not have
     * Identity-Aware Proxy permissions a [google.rpc.Code.PERMISSION_DENIED]
     * will be returned.
     * More information about managing access via IAP can be found at:
     * https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * IdentityAwareProxyAdminV1Beta1.
   *
   * <pre>
   * APIs for Identity-Aware Proxy Admin configurations.
   * </pre>
   */
  public static final class IdentityAwareProxyAdminV1Beta1FutureStub
      extends io.grpc.stub.AbstractFutureStub<IdentityAwareProxyAdminV1Beta1FutureStub> {
    private IdentityAwareProxyAdminV1Beta1FutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IdentityAwareProxyAdminV1Beta1FutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IdentityAwareProxyAdminV1Beta1FutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy for an Identity-Aware Proxy protected
     * resource. Replaces any existing policy.
     * More information about managing access via IAP can be found at:
     * https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for an Identity-Aware Proxy protected
     * resource.
     * More information about managing access via IAP can be found at:
     * https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that a caller has on the Identity-Aware Proxy protected
     * resource. If the resource does not exist or the caller does not have
     * Identity-Aware Proxy permissions a [google.rpc.Code.PERMISSION_DENIED]
     * will be returned.
     * More information about managing access via IAP can be found at:
     * https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.iam.v1.TestIamPermissionsResponse>
        testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_IAM_POLICY = 0;
  private static final int METHODID_GET_IAM_POLICY = 1;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 2;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
          serviceImpl.setIamPolicy(
              (com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy(
              (com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_TEST_IAM_PERMISSIONS:
          serviceImpl.testIamPermissions(
              (com.google.iam.v1.TestIamPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>)
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getSetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>(
                    service, METHODID_SET_IAM_POLICY)))
        .addMethod(
            getGetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>(
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

  private abstract static class IdentityAwareProxyAdminV1Beta1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    IdentityAwareProxyAdminV1Beta1BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.iap.v1beta1.Service.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("IdentityAwareProxyAdminV1Beta1");
    }
  }

  private static final class IdentityAwareProxyAdminV1Beta1FileDescriptorSupplier
      extends IdentityAwareProxyAdminV1Beta1BaseDescriptorSupplier {
    IdentityAwareProxyAdminV1Beta1FileDescriptorSupplier() {}
  }

  private static final class IdentityAwareProxyAdminV1Beta1MethodDescriptorSupplier
      extends IdentityAwareProxyAdminV1Beta1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    IdentityAwareProxyAdminV1Beta1MethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (IdentityAwareProxyAdminV1Beta1Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(
                          new IdentityAwareProxyAdminV1Beta1FileDescriptorSupplier())
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
