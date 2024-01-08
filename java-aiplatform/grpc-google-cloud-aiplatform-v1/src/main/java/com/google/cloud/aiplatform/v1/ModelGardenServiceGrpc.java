/*
 * Copyright 2023 Google LLC
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
package com.google.cloud.aiplatform.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The interface of Model Garden Service.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1/model_garden_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ModelGardenServiceGrpc {

  private ModelGardenServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.aiplatform.v1.ModelGardenService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetPublisherModelRequest,
          com.google.cloud.aiplatform.v1.PublisherModel>
      getGetPublisherModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPublisherModel",
      requestType = com.google.cloud.aiplatform.v1.GetPublisherModelRequest.class,
      responseType = com.google.cloud.aiplatform.v1.PublisherModel.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetPublisherModelRequest,
          com.google.cloud.aiplatform.v1.PublisherModel>
      getGetPublisherModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.GetPublisherModelRequest,
            com.google.cloud.aiplatform.v1.PublisherModel>
        getGetPublisherModelMethod;
    if ((getGetPublisherModelMethod = ModelGardenServiceGrpc.getGetPublisherModelMethod) == null) {
      synchronized (ModelGardenServiceGrpc.class) {
        if ((getGetPublisherModelMethod = ModelGardenServiceGrpc.getGetPublisherModelMethod)
            == null) {
          ModelGardenServiceGrpc.getGetPublisherModelMethod =
              getGetPublisherModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.GetPublisherModelRequest,
                          com.google.cloud.aiplatform.v1.PublisherModel>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPublisherModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.GetPublisherModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.PublisherModel.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ModelGardenServiceMethodDescriptorSupplier("GetPublisherModel"))
                      .build();
        }
      }
    }
    return getGetPublisherModelMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ModelGardenServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ModelGardenServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ModelGardenServiceStub>() {
          @java.lang.Override
          public ModelGardenServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ModelGardenServiceStub(channel, callOptions);
          }
        };
    return ModelGardenServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ModelGardenServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ModelGardenServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ModelGardenServiceBlockingStub>() {
          @java.lang.Override
          public ModelGardenServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ModelGardenServiceBlockingStub(channel, callOptions);
          }
        };
    return ModelGardenServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ModelGardenServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ModelGardenServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ModelGardenServiceFutureStub>() {
          @java.lang.Override
          public ModelGardenServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ModelGardenServiceFutureStub(channel, callOptions);
          }
        };
    return ModelGardenServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The interface of Model Garden Service.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Gets a Model Garden publisher model.
     * </pre>
     */
    default void getPublisherModel(
        com.google.cloud.aiplatform.v1.GetPublisherModelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.PublisherModel>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetPublisherModelMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ModelGardenService.
   *
   * <pre>
   * The interface of Model Garden Service.
   * </pre>
   */
  public abstract static class ModelGardenServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ModelGardenServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ModelGardenService.
   *
   * <pre>
   * The interface of Model Garden Service.
   * </pre>
   */
  public static final class ModelGardenServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ModelGardenServiceStub> {
    private ModelGardenServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ModelGardenServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ModelGardenServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a Model Garden publisher model.
     * </pre>
     */
    public void getPublisherModel(
        com.google.cloud.aiplatform.v1.GetPublisherModelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.PublisherModel>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPublisherModelMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ModelGardenService.
   *
   * <pre>
   * The interface of Model Garden Service.
   * </pre>
   */
  public static final class ModelGardenServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ModelGardenServiceBlockingStub> {
    private ModelGardenServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ModelGardenServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ModelGardenServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a Model Garden publisher model.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.PublisherModel getPublisherModel(
        com.google.cloud.aiplatform.v1.GetPublisherModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPublisherModelMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ModelGardenService.
   *
   * <pre>
   * The interface of Model Garden Service.
   * </pre>
   */
  public static final class ModelGardenServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ModelGardenServiceFutureStub> {
    private ModelGardenServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ModelGardenServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ModelGardenServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a Model Garden publisher model.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.PublisherModel>
        getPublisherModel(com.google.cloud.aiplatform.v1.GetPublisherModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPublisherModelMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PUBLISHER_MODEL = 0;

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
        case METHODID_GET_PUBLISHER_MODEL:
          serviceImpl.getPublisherModel(
              (com.google.cloud.aiplatform.v1.GetPublisherModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.PublisherModel>)
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
            getGetPublisherModelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.GetPublisherModelRequest,
                    com.google.cloud.aiplatform.v1.PublisherModel>(
                    service, METHODID_GET_PUBLISHER_MODEL)))
        .build();
  }

  private abstract static class ModelGardenServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ModelGardenServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1.ModelGardenServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ModelGardenService");
    }
  }

  private static final class ModelGardenServiceFileDescriptorSupplier
      extends ModelGardenServiceBaseDescriptorSupplier {
    ModelGardenServiceFileDescriptorSupplier() {}
  }

  private static final class ModelGardenServiceMethodDescriptorSupplier
      extends ModelGardenServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ModelGardenServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ModelGardenServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ModelGardenServiceFileDescriptorSupplier())
                      .addMethod(getGetPublisherModelMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
