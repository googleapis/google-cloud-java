/*
 * Copyright 2020 Google LLC
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
package com.google.protos.google.cloud.binaryauthorization.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * API for working with the system policy.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/binaryauthorization/v1/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SystemPolicyV1Grpc {

  private SystemPolicyV1Grpc() {}

  public static final String SERVICE_NAME = "google.cloud.binaryauthorization.v1.SystemPolicyV1";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.protos.google.cloud.binaryauthorization.v1.Service.GetSystemPolicyRequest,
          com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy>
      getGetSystemPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSystemPolicy",
      requestType =
          com.google.protos.google.cloud.binaryauthorization.v1.Service.GetSystemPolicyRequest
              .class,
      responseType = com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.protos.google.cloud.binaryauthorization.v1.Service.GetSystemPolicyRequest,
          com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy>
      getGetSystemPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.protos.google.cloud.binaryauthorization.v1.Service.GetSystemPolicyRequest,
            com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy>
        getGetSystemPolicyMethod;
    if ((getGetSystemPolicyMethod = SystemPolicyV1Grpc.getGetSystemPolicyMethod) == null) {
      synchronized (SystemPolicyV1Grpc.class) {
        if ((getGetSystemPolicyMethod = SystemPolicyV1Grpc.getGetSystemPolicyMethod) == null) {
          SystemPolicyV1Grpc.getGetSystemPolicyMethod =
              getGetSystemPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.protos.google.cloud.binaryauthorization.v1.Service
                              .GetSystemPolicyRequest,
                          com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSystemPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protos.google.cloud.binaryauthorization.v1.Service
                                  .GetSystemPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SystemPolicyV1MethodDescriptorSupplier("GetSystemPolicy"))
                      .build();
        }
      }
    }
    return getGetSystemPolicyMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SystemPolicyV1Stub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SystemPolicyV1Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SystemPolicyV1Stub>() {
          @java.lang.Override
          public SystemPolicyV1Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SystemPolicyV1Stub(channel, callOptions);
          }
        };
    return SystemPolicyV1Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SystemPolicyV1BlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SystemPolicyV1BlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SystemPolicyV1BlockingStub>() {
          @java.lang.Override
          public SystemPolicyV1BlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SystemPolicyV1BlockingStub(channel, callOptions);
          }
        };
    return SystemPolicyV1BlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SystemPolicyV1FutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SystemPolicyV1FutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SystemPolicyV1FutureStub>() {
          @java.lang.Override
          public SystemPolicyV1FutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SystemPolicyV1FutureStub(channel, callOptions);
          }
        };
    return SystemPolicyV1FutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * API for working with the system policy.
   * </pre>
   */
  public abstract static class SystemPolicyV1ImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Gets the current system policy in the specified location.
     * </pre>
     */
    public void getSystemPolicy(
        com.google.protos.google.cloud.binaryauthorization.v1.Service.GetSystemPolicyRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSystemPolicyMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getGetSystemPolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.protos.google.cloud.binaryauthorization.v1.Service
                          .GetSystemPolicyRequest,
                      com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy>(
                      this, METHODID_GET_SYSTEM_POLICY)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * API for working with the system policy.
   * </pre>
   */
  public static final class SystemPolicyV1Stub
      extends io.grpc.stub.AbstractAsyncStub<SystemPolicyV1Stub> {
    private SystemPolicyV1Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SystemPolicyV1Stub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SystemPolicyV1Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the current system policy in the specified location.
     * </pre>
     */
    public void getSystemPolicy(
        com.google.protos.google.cloud.binaryauthorization.v1.Service.GetSystemPolicyRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSystemPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * API for working with the system policy.
   * </pre>
   */
  public static final class SystemPolicyV1BlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SystemPolicyV1BlockingStub> {
    private SystemPolicyV1BlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SystemPolicyV1BlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SystemPolicyV1BlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the current system policy in the specified location.
     * </pre>
     */
    public com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy getSystemPolicy(
        com.google.protos.google.cloud.binaryauthorization.v1.Service.GetSystemPolicyRequest
            request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSystemPolicyMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * API for working with the system policy.
   * </pre>
   */
  public static final class SystemPolicyV1FutureStub
      extends io.grpc.stub.AbstractFutureStub<SystemPolicyV1FutureStub> {
    private SystemPolicyV1FutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SystemPolicyV1FutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SystemPolicyV1FutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the current system policy in the specified location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy>
        getSystemPolicy(
            com.google.protos.google.cloud.binaryauthorization.v1.Service.GetSystemPolicyRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSystemPolicyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_SYSTEM_POLICY = 0;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SystemPolicyV1ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SystemPolicyV1ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_SYSTEM_POLICY:
          serviceImpl.getSystemPolicy(
              (com.google.protos.google.cloud.binaryauthorization.v1.Service.GetSystemPolicyRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy>)
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

  private abstract static class SystemPolicyV1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SystemPolicyV1BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.protos.google.cloud.binaryauthorization.v1.Service.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SystemPolicyV1");
    }
  }

  private static final class SystemPolicyV1FileDescriptorSupplier
      extends SystemPolicyV1BaseDescriptorSupplier {
    SystemPolicyV1FileDescriptorSupplier() {}
  }

  private static final class SystemPolicyV1MethodDescriptorSupplier
      extends SystemPolicyV1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SystemPolicyV1MethodDescriptorSupplier(String methodName) {
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
      synchronized (SystemPolicyV1Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SystemPolicyV1FileDescriptorSupplier())
                      .addMethod(getGetSystemPolicyMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
