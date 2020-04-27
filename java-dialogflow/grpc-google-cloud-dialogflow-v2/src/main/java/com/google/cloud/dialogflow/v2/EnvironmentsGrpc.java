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
package com.google.cloud.dialogflow.v2;

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
 * Manages agent environments.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/v2/environment.proto")
public final class EnvironmentsGrpc {

  private EnvironmentsGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dialogflow.v2.Environments";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.ListEnvironmentsRequest,
          com.google.cloud.dialogflow.v2.ListEnvironmentsResponse>
      getListEnvironmentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEnvironments",
      requestType = com.google.cloud.dialogflow.v2.ListEnvironmentsRequest.class,
      responseType = com.google.cloud.dialogflow.v2.ListEnvironmentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.ListEnvironmentsRequest,
          com.google.cloud.dialogflow.v2.ListEnvironmentsResponse>
      getListEnvironmentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.ListEnvironmentsRequest,
            com.google.cloud.dialogflow.v2.ListEnvironmentsResponse>
        getListEnvironmentsMethod;
    if ((getListEnvironmentsMethod = EnvironmentsGrpc.getListEnvironmentsMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getListEnvironmentsMethod = EnvironmentsGrpc.getListEnvironmentsMethod) == null) {
          EnvironmentsGrpc.getListEnvironmentsMethod =
              getListEnvironmentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.ListEnvironmentsRequest,
                          com.google.cloud.dialogflow.v2.ListEnvironmentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEnvironments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.ListEnvironmentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.ListEnvironmentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EnvironmentsMethodDescriptorSupplier("ListEnvironments"))
                      .build();
        }
      }
    }
    return getListEnvironmentsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static EnvironmentsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EnvironmentsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EnvironmentsStub>() {
          @java.lang.Override
          public EnvironmentsStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EnvironmentsStub(channel, callOptions);
          }
        };
    return EnvironmentsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EnvironmentsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EnvironmentsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EnvironmentsBlockingStub>() {
          @java.lang.Override
          public EnvironmentsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EnvironmentsBlockingStub(channel, callOptions);
          }
        };
    return EnvironmentsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static EnvironmentsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EnvironmentsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EnvironmentsFutureStub>() {
          @java.lang.Override
          public EnvironmentsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EnvironmentsFutureStub(channel, callOptions);
          }
        };
    return EnvironmentsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Manages agent environments.
   * </pre>
   */
  public abstract static class EnvironmentsImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Returns the list of all non-draft environments of the specified agent.
     * </pre>
     */
    public void listEnvironments(
        com.google.cloud.dialogflow.v2.ListEnvironmentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListEnvironmentsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListEnvironmentsMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListEnvironmentsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.ListEnvironmentsRequest,
                      com.google.cloud.dialogflow.v2.ListEnvironmentsResponse>(
                      this, METHODID_LIST_ENVIRONMENTS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Manages agent environments.
   * </pre>
   */
  public static final class EnvironmentsStub
      extends io.grpc.stub.AbstractAsyncStub<EnvironmentsStub> {
    private EnvironmentsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnvironmentsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EnvironmentsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all non-draft environments of the specified agent.
     * </pre>
     */
    public void listEnvironments(
        com.google.cloud.dialogflow.v2.ListEnvironmentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListEnvironmentsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListEnvironmentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Manages agent environments.
   * </pre>
   */
  public static final class EnvironmentsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<EnvironmentsBlockingStub> {
    private EnvironmentsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnvironmentsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EnvironmentsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all non-draft environments of the specified agent.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.ListEnvironmentsResponse listEnvironments(
        com.google.cloud.dialogflow.v2.ListEnvironmentsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListEnvironmentsMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Manages agent environments.
   * </pre>
   */
  public static final class EnvironmentsFutureStub
      extends io.grpc.stub.AbstractFutureStub<EnvironmentsFutureStub> {
    private EnvironmentsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnvironmentsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EnvironmentsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all non-draft environments of the specified agent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.ListEnvironmentsResponse>
        listEnvironments(com.google.cloud.dialogflow.v2.ListEnvironmentsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListEnvironmentsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_ENVIRONMENTS = 0;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EnvironmentsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EnvironmentsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_ENVIRONMENTS:
          serviceImpl.listEnvironments(
              (com.google.cloud.dialogflow.v2.ListEnvironmentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListEnvironmentsResponse>)
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

  private abstract static class EnvironmentsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EnvironmentsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.v2.EnvironmentProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Environments");
    }
  }

  private static final class EnvironmentsFileDescriptorSupplier
      extends EnvironmentsBaseDescriptorSupplier {
    EnvironmentsFileDescriptorSupplier() {}
  }

  private static final class EnvironmentsMethodDescriptorSupplier
      extends EnvironmentsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EnvironmentsMethodDescriptorSupplier(String methodName) {
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
      synchronized (EnvironmentsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new EnvironmentsFileDescriptorSupplier())
                      .addMethod(getListEnvironmentsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
