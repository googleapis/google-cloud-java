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
package com.google.cloud.aiplatform.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for LLM related utility functions.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1beta1/llm_utility_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LlmUtilityServiceGrpc {

  private LlmUtilityServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.aiplatform.v1beta1.LlmUtilityService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ComputeTokensRequest,
          com.google.cloud.aiplatform.v1beta1.ComputeTokensResponse>
      getComputeTokensMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ComputeTokens",
      requestType = com.google.cloud.aiplatform.v1beta1.ComputeTokensRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ComputeTokensResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ComputeTokensRequest,
          com.google.cloud.aiplatform.v1beta1.ComputeTokensResponse>
      getComputeTokensMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ComputeTokensRequest,
            com.google.cloud.aiplatform.v1beta1.ComputeTokensResponse>
        getComputeTokensMethod;
    if ((getComputeTokensMethod = LlmUtilityServiceGrpc.getComputeTokensMethod) == null) {
      synchronized (LlmUtilityServiceGrpc.class) {
        if ((getComputeTokensMethod = LlmUtilityServiceGrpc.getComputeTokensMethod) == null) {
          LlmUtilityServiceGrpc.getComputeTokensMethod =
              getComputeTokensMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ComputeTokensRequest,
                          com.google.cloud.aiplatform.v1beta1.ComputeTokensResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ComputeTokens"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ComputeTokensRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ComputeTokensResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LlmUtilityServiceMethodDescriptorSupplier("ComputeTokens"))
                      .build();
        }
      }
    }
    return getComputeTokensMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static LlmUtilityServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LlmUtilityServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LlmUtilityServiceStub>() {
          @java.lang.Override
          public LlmUtilityServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LlmUtilityServiceStub(channel, callOptions);
          }
        };
    return LlmUtilityServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LlmUtilityServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LlmUtilityServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LlmUtilityServiceBlockingStub>() {
          @java.lang.Override
          public LlmUtilityServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LlmUtilityServiceBlockingStub(channel, callOptions);
          }
        };
    return LlmUtilityServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static LlmUtilityServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LlmUtilityServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LlmUtilityServiceFutureStub>() {
          @java.lang.Override
          public LlmUtilityServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LlmUtilityServiceFutureStub(channel, callOptions);
          }
        };
    return LlmUtilityServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for LLM related utility functions.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Return a list of tokens based on the input text.
     * </pre>
     */
    default void computeTokens(
        com.google.cloud.aiplatform.v1beta1.ComputeTokensRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ComputeTokensResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getComputeTokensMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service LlmUtilityService.
   *
   * <pre>
   * Service for LLM related utility functions.
   * </pre>
   */
  public abstract static class LlmUtilityServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return LlmUtilityServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service LlmUtilityService.
   *
   * <pre>
   * Service for LLM related utility functions.
   * </pre>
   */
  public static final class LlmUtilityServiceStub
      extends io.grpc.stub.AbstractAsyncStub<LlmUtilityServiceStub> {
    private LlmUtilityServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LlmUtilityServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LlmUtilityServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Return a list of tokens based on the input text.
     * </pre>
     */
    public void computeTokens(
        com.google.cloud.aiplatform.v1beta1.ComputeTokensRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ComputeTokensResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getComputeTokensMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service LlmUtilityService.
   *
   * <pre>
   * Service for LLM related utility functions.
   * </pre>
   */
  public static final class LlmUtilityServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LlmUtilityServiceBlockingStub> {
    private LlmUtilityServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LlmUtilityServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LlmUtilityServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Return a list of tokens based on the input text.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ComputeTokensResponse computeTokens(
        com.google.cloud.aiplatform.v1beta1.ComputeTokensRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getComputeTokensMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service LlmUtilityService.
   *
   * <pre>
   * Service for LLM related utility functions.
   * </pre>
   */
  public static final class LlmUtilityServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<LlmUtilityServiceFutureStub> {
    private LlmUtilityServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LlmUtilityServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LlmUtilityServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Return a list of tokens based on the input text.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ComputeTokensResponse>
        computeTokens(com.google.cloud.aiplatform.v1beta1.ComputeTokensRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getComputeTokensMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_COMPUTE_TOKENS = 0;

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
        case METHODID_COMPUTE_TOKENS:
          serviceImpl.computeTokens(
              (com.google.cloud.aiplatform.v1beta1.ComputeTokensRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ComputeTokensResponse>)
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
            getComputeTokensMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.ComputeTokensRequest,
                    com.google.cloud.aiplatform.v1beta1.ComputeTokensResponse>(
                    service, METHODID_COMPUTE_TOKENS)))
        .build();
  }

  private abstract static class LlmUtilityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LlmUtilityServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1beta1.LlmUtilityServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LlmUtilityService");
    }
  }

  private static final class LlmUtilityServiceFileDescriptorSupplier
      extends LlmUtilityServiceBaseDescriptorSupplier {
    LlmUtilityServiceFileDescriptorSupplier() {}
  }

  private static final class LlmUtilityServiceMethodDescriptorSupplier
      extends LlmUtilityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    LlmUtilityServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (LlmUtilityServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new LlmUtilityServiceFileDescriptorSupplier())
                      .addMethod(getComputeTokensMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
