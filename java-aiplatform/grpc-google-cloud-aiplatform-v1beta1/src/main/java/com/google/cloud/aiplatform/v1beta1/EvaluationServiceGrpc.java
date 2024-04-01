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
 * Vertex AI Online Evaluation Service.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1beta1/evaluation_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EvaluationServiceGrpc {

  private EvaluationServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.aiplatform.v1beta1.EvaluationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.EvaluateInstancesRequest,
          com.google.cloud.aiplatform.v1beta1.EvaluateInstancesResponse>
      getEvaluateInstancesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EvaluateInstances",
      requestType = com.google.cloud.aiplatform.v1beta1.EvaluateInstancesRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.EvaluateInstancesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.EvaluateInstancesRequest,
          com.google.cloud.aiplatform.v1beta1.EvaluateInstancesResponse>
      getEvaluateInstancesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.EvaluateInstancesRequest,
            com.google.cloud.aiplatform.v1beta1.EvaluateInstancesResponse>
        getEvaluateInstancesMethod;
    if ((getEvaluateInstancesMethod = EvaluationServiceGrpc.getEvaluateInstancesMethod) == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getEvaluateInstancesMethod = EvaluationServiceGrpc.getEvaluateInstancesMethod)
            == null) {
          EvaluationServiceGrpc.getEvaluateInstancesMethod =
              getEvaluateInstancesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.EvaluateInstancesRequest,
                          com.google.cloud.aiplatform.v1beta1.EvaluateInstancesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EvaluateInstances"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.EvaluateInstancesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.EvaluateInstancesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier("EvaluateInstances"))
                      .build();
        }
      }
    }
    return getEvaluateInstancesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static EvaluationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EvaluationServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EvaluationServiceStub>() {
          @java.lang.Override
          public EvaluationServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EvaluationServiceStub(channel, callOptions);
          }
        };
    return EvaluationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EvaluationServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EvaluationServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EvaluationServiceBlockingStub>() {
          @java.lang.Override
          public EvaluationServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EvaluationServiceBlockingStub(channel, callOptions);
          }
        };
    return EvaluationServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static EvaluationServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EvaluationServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EvaluationServiceFutureStub>() {
          @java.lang.Override
          public EvaluationServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EvaluationServiceFutureStub(channel, callOptions);
          }
        };
    return EvaluationServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Vertex AI Online Evaluation Service.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Evaluates instances based on a given metric.
     * </pre>
     */
    default void evaluateInstances(
        com.google.cloud.aiplatform.v1beta1.EvaluateInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.EvaluateInstancesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getEvaluateInstancesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service EvaluationService.
   *
   * <pre>
   * Vertex AI Online Evaluation Service.
   * </pre>
   */
  public abstract static class EvaluationServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return EvaluationServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service EvaluationService.
   *
   * <pre>
   * Vertex AI Online Evaluation Service.
   * </pre>
   */
  public static final class EvaluationServiceStub
      extends io.grpc.stub.AbstractAsyncStub<EvaluationServiceStub> {
    private EvaluationServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EvaluationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EvaluationServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Evaluates instances based on a given metric.
     * </pre>
     */
    public void evaluateInstances(
        com.google.cloud.aiplatform.v1beta1.EvaluateInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.EvaluateInstancesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEvaluateInstancesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service EvaluationService.
   *
   * <pre>
   * Vertex AI Online Evaluation Service.
   * </pre>
   */
  public static final class EvaluationServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<EvaluationServiceBlockingStub> {
    private EvaluationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EvaluationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EvaluationServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Evaluates instances based on a given metric.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.EvaluateInstancesResponse evaluateInstances(
        com.google.cloud.aiplatform.v1beta1.EvaluateInstancesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEvaluateInstancesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service EvaluationService.
   *
   * <pre>
   * Vertex AI Online Evaluation Service.
   * </pre>
   */
  public static final class EvaluationServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<EvaluationServiceFutureStub> {
    private EvaluationServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EvaluationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EvaluationServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Evaluates instances based on a given metric.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.EvaluateInstancesResponse>
        evaluateInstances(com.google.cloud.aiplatform.v1beta1.EvaluateInstancesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEvaluateInstancesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_EVALUATE_INSTANCES = 0;

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
        case METHODID_EVALUATE_INSTANCES:
          serviceImpl.evaluateInstances(
              (com.google.cloud.aiplatform.v1beta1.EvaluateInstancesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.EvaluateInstancesResponse>)
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
            getEvaluateInstancesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.EvaluateInstancesRequest,
                    com.google.cloud.aiplatform.v1beta1.EvaluateInstancesResponse>(
                    service, METHODID_EVALUATE_INSTANCES)))
        .build();
  }

  private abstract static class EvaluationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EvaluationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1beta1.EvaluationServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EvaluationService");
    }
  }

  private static final class EvaluationServiceFileDescriptorSupplier
      extends EvaluationServiceBaseDescriptorSupplier {
    EvaluationServiceFileDescriptorSupplier() {}
  }

  private static final class EvaluationServiceMethodDescriptorSupplier
      extends EvaluationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    EvaluationServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (EvaluationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new EvaluationServiceFileDescriptorSupplier())
                      .addMethod(getEvaluateInstancesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
