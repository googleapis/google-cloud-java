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
package com.google.cloud.discoveryengine.v1alpha;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for search tuning.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/discoveryengine/v1alpha/search_tuning_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SearchTuningServiceGrpc {

  private SearchTuningServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.discoveryengine.v1alpha.SearchTuningService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.TrainCustomModelRequest,
          com.google.longrunning.Operation>
      getTrainCustomModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TrainCustomModel",
      requestType = com.google.cloud.discoveryengine.v1alpha.TrainCustomModelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.TrainCustomModelRequest,
          com.google.longrunning.Operation>
      getTrainCustomModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1alpha.TrainCustomModelRequest,
            com.google.longrunning.Operation>
        getTrainCustomModelMethod;
    if ((getTrainCustomModelMethod = SearchTuningServiceGrpc.getTrainCustomModelMethod) == null) {
      synchronized (SearchTuningServiceGrpc.class) {
        if ((getTrainCustomModelMethod = SearchTuningServiceGrpc.getTrainCustomModelMethod)
            == null) {
          SearchTuningServiceGrpc.getTrainCustomModelMethod =
              getTrainCustomModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1alpha.TrainCustomModelRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TrainCustomModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.TrainCustomModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SearchTuningServiceMethodDescriptorSupplier("TrainCustomModel"))
                      .build();
        }
      }
    }
    return getTrainCustomModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.ListCustomModelsRequest,
          com.google.cloud.discoveryengine.v1alpha.ListCustomModelsResponse>
      getListCustomModelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCustomModels",
      requestType = com.google.cloud.discoveryengine.v1alpha.ListCustomModelsRequest.class,
      responseType = com.google.cloud.discoveryengine.v1alpha.ListCustomModelsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.ListCustomModelsRequest,
          com.google.cloud.discoveryengine.v1alpha.ListCustomModelsResponse>
      getListCustomModelsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1alpha.ListCustomModelsRequest,
            com.google.cloud.discoveryengine.v1alpha.ListCustomModelsResponse>
        getListCustomModelsMethod;
    if ((getListCustomModelsMethod = SearchTuningServiceGrpc.getListCustomModelsMethod) == null) {
      synchronized (SearchTuningServiceGrpc.class) {
        if ((getListCustomModelsMethod = SearchTuningServiceGrpc.getListCustomModelsMethod)
            == null) {
          SearchTuningServiceGrpc.getListCustomModelsMethod =
              getListCustomModelsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1alpha.ListCustomModelsRequest,
                          com.google.cloud.discoveryengine.v1alpha.ListCustomModelsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCustomModels"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.ListCustomModelsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.ListCustomModelsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SearchTuningServiceMethodDescriptorSupplier("ListCustomModels"))
                      .build();
        }
      }
    }
    return getListCustomModelsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SearchTuningServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SearchTuningServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SearchTuningServiceStub>() {
          @java.lang.Override
          public SearchTuningServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SearchTuningServiceStub(channel, callOptions);
          }
        };
    return SearchTuningServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SearchTuningServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SearchTuningServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SearchTuningServiceBlockingStub>() {
          @java.lang.Override
          public SearchTuningServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SearchTuningServiceBlockingStub(channel, callOptions);
          }
        };
    return SearchTuningServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SearchTuningServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SearchTuningServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SearchTuningServiceFutureStub>() {
          @java.lang.Override
          public SearchTuningServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SearchTuningServiceFutureStub(channel, callOptions);
          }
        };
    return SearchTuningServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for search tuning.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Trains a custom model.
     * </pre>
     */
    default void trainCustomModel(
        com.google.cloud.discoveryengine.v1alpha.TrainCustomModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getTrainCustomModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of all the custom models.
     * </pre>
     */
    default void listCustomModels(
        com.google.cloud.discoveryengine.v1alpha.ListCustomModelsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.discoveryengine.v1alpha.ListCustomModelsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCustomModelsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SearchTuningService.
   *
   * <pre>
   * Service for search tuning.
   * </pre>
   */
  public abstract static class SearchTuningServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SearchTuningServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SearchTuningService.
   *
   * <pre>
   * Service for search tuning.
   * </pre>
   */
  public static final class SearchTuningServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SearchTuningServiceStub> {
    private SearchTuningServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SearchTuningServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SearchTuningServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Trains a custom model.
     * </pre>
     */
    public void trainCustomModel(
        com.google.cloud.discoveryengine.v1alpha.TrainCustomModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTrainCustomModelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of all the custom models.
     * </pre>
     */
    public void listCustomModels(
        com.google.cloud.discoveryengine.v1alpha.ListCustomModelsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.discoveryengine.v1alpha.ListCustomModelsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCustomModelsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SearchTuningService.
   *
   * <pre>
   * Service for search tuning.
   * </pre>
   */
  public static final class SearchTuningServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SearchTuningServiceBlockingStub> {
    private SearchTuningServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SearchTuningServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SearchTuningServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Trains a custom model.
     * </pre>
     */
    public com.google.longrunning.Operation trainCustomModel(
        com.google.cloud.discoveryengine.v1alpha.TrainCustomModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTrainCustomModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of all the custom models.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1alpha.ListCustomModelsResponse listCustomModels(
        com.google.cloud.discoveryengine.v1alpha.ListCustomModelsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCustomModelsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SearchTuningService.
   *
   * <pre>
   * Service for search tuning.
   * </pre>
   */
  public static final class SearchTuningServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SearchTuningServiceFutureStub> {
    private SearchTuningServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SearchTuningServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SearchTuningServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Trains a custom model.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        trainCustomModel(com.google.cloud.discoveryengine.v1alpha.TrainCustomModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTrainCustomModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of all the custom models.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1alpha.ListCustomModelsResponse>
        listCustomModels(com.google.cloud.discoveryengine.v1alpha.ListCustomModelsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCustomModelsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TRAIN_CUSTOM_MODEL = 0;
  private static final int METHODID_LIST_CUSTOM_MODELS = 1;

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
        case METHODID_TRAIN_CUSTOM_MODEL:
          serviceImpl.trainCustomModel(
              (com.google.cloud.discoveryengine.v1alpha.TrainCustomModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_CUSTOM_MODELS:
          serviceImpl.listCustomModels(
              (com.google.cloud.discoveryengine.v1alpha.ListCustomModelsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.discoveryengine.v1alpha.ListCustomModelsResponse>)
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
            getTrainCustomModelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1alpha.TrainCustomModelRequest,
                    com.google.longrunning.Operation>(service, METHODID_TRAIN_CUSTOM_MODEL)))
        .addMethod(
            getListCustomModelsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1alpha.ListCustomModelsRequest,
                    com.google.cloud.discoveryengine.v1alpha.ListCustomModelsResponse>(
                    service, METHODID_LIST_CUSTOM_MODELS)))
        .build();
  }

  private abstract static class SearchTuningServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SearchTuningServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1alpha.SearchTuningServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SearchTuningService");
    }
  }

  private static final class SearchTuningServiceFileDescriptorSupplier
      extends SearchTuningServiceBaseDescriptorSupplier {
    SearchTuningServiceFileDescriptorSupplier() {}
  }

  private static final class SearchTuningServiceMethodDescriptorSupplier
      extends SearchTuningServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SearchTuningServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SearchTuningServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SearchTuningServiceFileDescriptorSupplier())
                      .addMethod(getTrainCustomModelMethod())
                      .addMethod(getListCustomModelsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
