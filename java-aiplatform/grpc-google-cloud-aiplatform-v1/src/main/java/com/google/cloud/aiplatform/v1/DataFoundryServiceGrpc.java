/*
 * Copyright 2025 Google LLC
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
 * Service for generating and preparing datasets for Gen AI evaluation.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1/data_foundry_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DataFoundryServiceGrpc {

  private DataFoundryServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.aiplatform.v1.DataFoundryService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GenerateSyntheticDataRequest,
          com.google.cloud.aiplatform.v1.GenerateSyntheticDataResponse>
      getGenerateSyntheticDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateSyntheticData",
      requestType = com.google.cloud.aiplatform.v1.GenerateSyntheticDataRequest.class,
      responseType = com.google.cloud.aiplatform.v1.GenerateSyntheticDataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GenerateSyntheticDataRequest,
          com.google.cloud.aiplatform.v1.GenerateSyntheticDataResponse>
      getGenerateSyntheticDataMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.GenerateSyntheticDataRequest,
            com.google.cloud.aiplatform.v1.GenerateSyntheticDataResponse>
        getGenerateSyntheticDataMethod;
    if ((getGenerateSyntheticDataMethod = DataFoundryServiceGrpc.getGenerateSyntheticDataMethod)
        == null) {
      synchronized (DataFoundryServiceGrpc.class) {
        if ((getGenerateSyntheticDataMethod = DataFoundryServiceGrpc.getGenerateSyntheticDataMethod)
            == null) {
          DataFoundryServiceGrpc.getGenerateSyntheticDataMethod =
              getGenerateSyntheticDataMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.GenerateSyntheticDataRequest,
                          com.google.cloud.aiplatform.v1.GenerateSyntheticDataResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GenerateSyntheticData"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.GenerateSyntheticDataRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.GenerateSyntheticDataResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataFoundryServiceMethodDescriptorSupplier("GenerateSyntheticData"))
                      .build();
        }
      }
    }
    return getGenerateSyntheticDataMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DataFoundryServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataFoundryServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataFoundryServiceStub>() {
          @java.lang.Override
          public DataFoundryServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataFoundryServiceStub(channel, callOptions);
          }
        };
    return DataFoundryServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static DataFoundryServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataFoundryServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataFoundryServiceBlockingV2Stub>() {
          @java.lang.Override
          public DataFoundryServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataFoundryServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return DataFoundryServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataFoundryServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataFoundryServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataFoundryServiceBlockingStub>() {
          @java.lang.Override
          public DataFoundryServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataFoundryServiceBlockingStub(channel, callOptions);
          }
        };
    return DataFoundryServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DataFoundryServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataFoundryServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataFoundryServiceFutureStub>() {
          @java.lang.Override
          public DataFoundryServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataFoundryServiceFutureStub(channel, callOptions);
          }
        };
    return DataFoundryServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for generating and preparing datasets for Gen AI evaluation.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Generates synthetic data based on the provided configuration.
     * </pre>
     */
    default void generateSyntheticData(
        com.google.cloud.aiplatform.v1.GenerateSyntheticDataRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.GenerateSyntheticDataResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateSyntheticDataMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DataFoundryService.
   *
   * <pre>
   * Service for generating and preparing datasets for Gen AI evaluation.
   * </pre>
   */
  public abstract static class DataFoundryServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DataFoundryServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DataFoundryService.
   *
   * <pre>
   * Service for generating and preparing datasets for Gen AI evaluation.
   * </pre>
   */
  public static final class DataFoundryServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DataFoundryServiceStub> {
    private DataFoundryServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataFoundryServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataFoundryServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Generates synthetic data based on the provided configuration.
     * </pre>
     */
    public void generateSyntheticData(
        com.google.cloud.aiplatform.v1.GenerateSyntheticDataRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.GenerateSyntheticDataResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateSyntheticDataMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DataFoundryService.
   *
   * <pre>
   * Service for generating and preparing datasets for Gen AI evaluation.
   * </pre>
   */
  public static final class DataFoundryServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<DataFoundryServiceBlockingV2Stub> {
    private DataFoundryServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataFoundryServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataFoundryServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Generates synthetic data based on the provided configuration.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.GenerateSyntheticDataResponse generateSyntheticData(
        com.google.cloud.aiplatform.v1.GenerateSyntheticDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateSyntheticDataMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service DataFoundryService.
   *
   * <pre>
   * Service for generating and preparing datasets for Gen AI evaluation.
   * </pre>
   */
  public static final class DataFoundryServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DataFoundryServiceBlockingStub> {
    private DataFoundryServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataFoundryServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataFoundryServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Generates synthetic data based on the provided configuration.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.GenerateSyntheticDataResponse generateSyntheticData(
        com.google.cloud.aiplatform.v1.GenerateSyntheticDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateSyntheticDataMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DataFoundryService.
   *
   * <pre>
   * Service for generating and preparing datasets for Gen AI evaluation.
   * </pre>
   */
  public static final class DataFoundryServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DataFoundryServiceFutureStub> {
    private DataFoundryServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataFoundryServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataFoundryServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Generates synthetic data based on the provided configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.GenerateSyntheticDataResponse>
        generateSyntheticData(com.google.cloud.aiplatform.v1.GenerateSyntheticDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateSyntheticDataMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GENERATE_SYNTHETIC_DATA = 0;

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
        case METHODID_GENERATE_SYNTHETIC_DATA:
          serviceImpl.generateSyntheticData(
              (com.google.cloud.aiplatform.v1.GenerateSyntheticDataRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1.GenerateSyntheticDataResponse>)
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
            getGenerateSyntheticDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.GenerateSyntheticDataRequest,
                    com.google.cloud.aiplatform.v1.GenerateSyntheticDataResponse>(
                    service, METHODID_GENERATE_SYNTHETIC_DATA)))
        .build();
  }

  private abstract static class DataFoundryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataFoundryServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1.DataFoundryServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataFoundryService");
    }
  }

  private static final class DataFoundryServiceFileDescriptorSupplier
      extends DataFoundryServiceBaseDescriptorSupplier {
    DataFoundryServiceFileDescriptorSupplier() {}
  }

  private static final class DataFoundryServiceMethodDescriptorSupplier
      extends DataFoundryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DataFoundryServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DataFoundryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DataFoundryServiceFileDescriptorSupplier())
                      .addMethod(getGenerateSyntheticDataMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
